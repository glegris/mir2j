/* This file is a part of MIR2J project.
   Copyright (C) 2023-2025 Guillaume Legris
*/

#include "mir2j.h"
#include <float.h>
#include <inttypes.h>
#include <string.h>
#include <mir-hash.h>

static MIR_func_t curr_func;
static int unused_data_addr_count = 0;
// This flag prevents jump after a return statement (bug ?) 
static int is_in_dead_code = FALSE;
static char curr_func_has_stack_allocation = FALSE;
static int module_serial = 0;  /* 1, 2, 3, ... */

/* Symbol table */
typedef struct mir2j_symbol {
  const char *name;
  char* mangled_name;
  char visible;
  int module_id; // -1 for visible, otherwise module_serial at creation time
} symbol_t;

DEF_HTAB (symbol_t);

HTAB (symbol_t) * symbol_table;

static int symbol_eq (symbol_t a, symbol_t b, void *arg) {
  if (a.visible && b.visible)
    return strcmp(a.name, b.name) == 0;
  if (!a.visible && !b.visible)
    return (a.module_id == b.module_id) && strcmp(a.name, b.name) == 0;
  return 0; // visible vs non-visible => not equals
}

static htab_hash_t symbol_hash (symbol_t s, void *arg) {
  htab_hash_t h = mir_hash(s.name, strlen(s.name), 0);
  if (!s.visible)  // isolates keys by module
    h ^= (htab_hash_t) s.module_id * 0x9e3779b9u;
  return h;
}


static char* mormalize_name(char* name) {
  if (name[0] == '.') {
    return &name[1];
  } else {
  	return name;
  }
  
/*
  int var_name_length = strlen(item->u.data->name) + 1; 
  char *var_name = (char *) malloc(var_name_length);
  strncpy(var_name, item->u.data->name, var_name_length);
  if (var_name[0] == '.') {
    var_name[0] = '_';
  }
  fprintf(f, "static long %s = mir_allocate_", var_name);
  free(var_name);
*/
}

static symbol_t add_symbol(const char* name, char visible) {
  symbol_t symbol;
  symbol.name = name;
  symbol.visible = visible;
  symbol.module_id = visible ? -1 : module_serial;
  
  char* normalized_name = mormalize_name((char*) name);
  if (visible) {  
    int size = strlen(normalized_name) + 1;
    char* c_name = (char*) malloc(size);
    strcpy(c_name, normalized_name);
  	symbol.mangled_name = c_name;
  } else {
    char prefix[16];
    snprintf(prefix, sizeof(prefix), "m%d_", module_serial);
    char *m_name = malloc(strlen(prefix) + strlen(normalized_name) + 1);
    strcpy(m_name, prefix);
    strcat(m_name, normalized_name);
    symbol.mangled_name = m_name;
  }
  HTAB_DO (symbol_t, symbol_table, symbol, HTAB_INSERT, symbol);
  return symbol;
}

static char* get_mangled_symbol_name(const char* name) {
  symbol_t s;
  s.name = name;

  // 1) attempt visible
  s.visible = 1; s.module_id = -1;
  if (HTAB_DO (symbol_t, symbol_table, s, HTAB_FIND, s))
    return s.mangled_name;

  // 2) attempt not visible from current module
  s.visible = 0; s.module_id = module_serial;
  if (HTAB_DO (symbol_t, symbol_table, s, HTAB_FIND, s))
    return s.mangled_name;

  // 3) otherwise create non-visible from the current module
  return add_symbol(name, 0).mangled_name;
}

static void create_symbol_table() {
  HTAB_CREATE (symbol_t, symbol_table, 100, symbol_hash, symbol_eq, NULL);
}

static void destroy_symbol_table() {
  // TODO free symbol names
  HTAB_DESTROY (symbol_t, symbol_table);
}

static inline void fprintf_long_dec (FILE *f, int64_t v) {
  fprintf(f, "%" PRId64 "L", v);
}

static inline void fprintf_long_hex (FILE *f, uint64_t v) {
  if (v == 0) { 
    fputs("0L", f); 
    return; 
  }
  fprintf(f, "0x%" PRIx64 "L", v);
}

static inline void fprintf_float (FILE *f, float x) {
  fprintf(f, "%.9gf", x); // ex: 0f, 1.5f, 1e-8f
}

static inline void fprintf_double (FILE *f, double x) {
  fprintf(f, "%.17g", x); // ex: 0, 0.5, 1e-12
}

static inline void fprintf_long_double (FILE *f, long double x) {
  fprintf(f, "%.17g", (double) x);
}

static size_t get_MIR_type_size (MIR_type_t type) {
  switch (type) {
  case MIR_T_I8: return sizeof (int8_t);
  case MIR_T_U8: return sizeof (uint8_t);
  case MIR_T_I16: return sizeof (int16_t);
  case MIR_T_U16: return sizeof (uint16_t);
  case MIR_T_I32: return sizeof (int32_t);
  case MIR_T_U32: return sizeof (uint32_t);
  case MIR_T_I64: return sizeof (int64_t);
  case MIR_T_U64: return sizeof (uint64_t);
  case MIR_T_F: return sizeof (float);
  case MIR_T_D: return sizeof (double);
  case MIR_T_LD: return sizeof (long double); // FIXME sizeof (long double) can be 8 or 16
  case MIR_T_P: return sizeof (void *);
  default: mir_assert (FALSE); return 1;
  }
}

static void out_mangled_type (FILE *f, MIR_type_t t) {
  switch (t) {
  case MIR_T_I8: fprintf (f, "byte"); break; // int8_t
  case MIR_T_U8: fprintf (f, "ubyte"); break; // uint8_t
  case MIR_T_I16: fprintf (f, "short"); break; // int16_t
  case MIR_T_U16: fprintf (f, "ushort"); break; // uint16_t
  case MIR_T_I32: fprintf (f, "int"); break; // int32_t
  case MIR_T_U32: fprintf (f, "uint"); break; // uint32_t
  case MIR_T_I64: fprintf (f, "long"); break; // int64_t
  case MIR_T_U64: fprintf (f, "ulong"); break; // uint64_t
  case MIR_T_F: fprintf (f, "float"); break;
  case MIR_T_D: fprintf (f, "double"); break;
  case MIR_T_LD: fprintf (f, "long_double"); break; // long double
  case MIR_T_P: fprintf (f, "pointer"); break;
  case MIR_T_BLK:
  case MIR_T_BLK + 1:
  case MIR_T_BLK + 2:
  case MIR_T_BLK + 3:
  case MIR_T_BLK + 4:
  case MIR_T_RBLK: fprintf (f, "long"); break;
  default: mir_assert (FALSE);
  }
}


static void out_type (FILE *f, MIR_type_t t) {
  switch (t) {
  case MIR_T_I8: fprintf (f, "byte"); break; // int8_t
  case MIR_T_U8: fprintf (f, "short"); break; // uint8_t
  case MIR_T_I16: fprintf (f, "short"); break; // int16_t
  case MIR_T_U16: fprintf (f, "int"); break; // uint16_t
  case MIR_T_I32: fprintf (f, "int"); break; // int32_t
  case MIR_T_U32: fprintf (f, "long"); break; // uint32_t
  case MIR_T_I64: fprintf (f, "long"); break; // int64_t
  case MIR_T_U64: fprintf (f, "long"); break; // uint64_t
  case MIR_T_F: fprintf (f, "float"); break;
  case MIR_T_D: fprintf (f, "double"); break;
  case MIR_T_LD: fprintf (f, "double"); break; // long double
  case MIR_T_P: fprintf (f, "long"); break;
  case MIR_T_BLK:
  case MIR_T_BLK + 1:
  case MIR_T_BLK + 2:
  case MIR_T_BLK + 3:
  case MIR_T_BLK + 4:
  case MIR_T_RBLK: fprintf (f, "long"); break;
  default: mir_assert (FALSE);
  }
}

static void out_type_value (FILE *f, MIR_type_t t, uint8_t* v) {
  switch (t) {
  case MIR_T_I8: fprintf (f, "%" PRIi8, ((int8_t *)v)[0]); break; // int8_t
  case MIR_T_U8: fprintf (f, "%" PRIu8, ((uint8_t *)v)[0]); break; // uint8_t
  case MIR_T_I16: fprintf (f, "%" PRIi16, ((int16_t *)v)[0]); break; // int16_t
  case MIR_T_U16: fprintf (f, "%" PRIu16, ((uint16_t *)v)[0]); break; // uint16_t
  case MIR_T_I32: fprintf (f, "%" PRIi32, ((int32_t *)v)[0]); break; // int32_t
  case MIR_T_U32: fprintf (f, "%" PRIu32 "L", ((uint32_t *)v)[0]); break; // uint32_t
  case MIR_T_I64: fprintf (f, "%" PRIi64 "L", ((int64_t *)v)[0]); break; // int64_t
  case MIR_T_U64: fprintf_long_hex(f, ((uint64_t*)v)[0]); break; // uint64_t
  case MIR_T_F: fprintf_float (f, ((float *)v)[0]);; break;
  case MIR_T_D: fprintf_double(f, ((double*)v)[0]); break;
  case MIR_T_LD: fprintf_long_double(f, ((long double*)v)[0]); break; // long double
  case MIR_T_P: fprintf_long_hex(f, ((uint64_t*)v)[0]); break;
  default: mir_assert (FALSE);
  }
}

static void out_op_mem_address(MIR_context_t ctx, FILE *f, MIR_op_t op) {
	MIR_reg_t no_reg = 0;
	int disp_p = FALSE;
    if (op.u.mem.disp != 0 || (op.u.mem.base == no_reg && op.u.mem.index == no_reg)) {
       fprintf_long_dec(f, op.u.mem.disp);
       disp_p = TRUE;
    }
    if (op.u.mem.base != no_reg || op.u.mem.index != no_reg) {
      if (disp_p) fprintf (f, " + ");
      if (op.u.mem.base != no_reg) fprintf (f, "%s", MIR_reg_name (ctx, op.u.mem.base, curr_func));
      if (op.u.mem.index != no_reg) {
        if (op.u.mem.base != no_reg) fprintf (f, " + ");
        fprintf (f, "%s", MIR_reg_name (ctx, op.u.mem.index, curr_func));
        if (op.u.mem.scale != 1) fprintf (f, " * %u", op.u.mem.scale);
      }
    }	
}

static void out_op (MIR_context_t ctx, FILE *f, MIR_op_t op) {
  switch (op.mode) {
  case MIR_OP_REG: fprintf (f, "%s", MIR_reg_name (ctx, op.u.reg, curr_func)); break;
  case MIR_OP_INT: fprintf_long_dec(f, op.u.i); break;
  case MIR_OP_UINT: fprintf_long_hex(f, op.u.u); break;
  case MIR_OP_FLOAT: fprintf_float (f,  op.u.f);  break;
  case MIR_OP_DOUBLE: fprintf_double(f,  op.u.d); break;
  case MIR_OP_LDOUBLE: fprintf_long_double(f, op.u.ld); break;
  case MIR_OP_REF: {
    char* name = (char*) MIR_item_name (ctx, op.u.ref);
    char* mangled_name = get_mangled_symbol_name(name);
    fprintf (f, "%s", mangled_name); break;
  }
  case MIR_OP_STR: {
    fprintf (f, "mir_get_string_ptr(\"");
    for (int i = 0; i < op.u.str.len - 1; i++) {
      unsigned char c = (unsigned char) op.u.str.s[i];
      switch (c) {
      case '\n': fputs("\\n", f); break;
      case '\r': fputs("\\r", f); break;
      case '\t': fputs("\\t", f); break;
      case '\b': fputs("\\b", f); break;
      case '\f': fputs("\\f", f); break;
      case '\"': fputs("\\\"", f); break;
      case '\\': fputs("\\\\", f); break;
      case 0:    fputs("\\0",  f); break;
      default:
        if (c < 0x20 || c == 0x7F || c >= 0x80) {
          // Encode non-printable ASCII to \u00XX for Java
          fprintf(f, "\\u%04X", (unsigned)c);
        } else {
          fputc((char)c, f);
        }
      }
    }
    fputs("\")", f);
    break;
  }
  case MIR_OP_MEM: {
    //MIR_reg_t no_reg = 0;
    //int disp_p = FALSE;

    if (MIR_all_blk_type_p (op.u.mem.type)) {
    //if ((op.u.mem.type >= MIR_T_BLK) && (op.u.mem.type <= MIR_T_RBLK)) {
      //out_op_mem_address(ctx, f, op);	
      fprintf (f, "%s", MIR_reg_name (ctx, op.u.mem.base, curr_func));
    } else {
      fprintf (f, "mir_read_");
      out_mangled_type (f, op.u.mem.type);
      fprintf (f, "(");
      out_op_mem_address (ctx, f, op);
      fprintf (f, ")");
    }
    /*
    if (op.u.mem.disp != 0 || (op.u.mem.base == no_reg && op.u.mem.index == no_reg)) {
       fprintf (f, "%" PRId64, op.u.mem.disp);
       disp_p = TRUE;
    }
    if (op.u.mem.base != no_reg || op.u.mem.index != no_reg) {
      if (disp_p) fprintf (f, " + ");
      if (op.u.mem.base != no_reg) fprintf (f, "%s", MIR_reg_name (ctx, op.u.mem.base, curr_func));
      if (op.u.mem.index != no_reg) {
        if (op.u.mem.base != no_reg) fprintf (f, " + ");
        fprintf (f, "%s", MIR_reg_name (ctx, op.u.mem.index, curr_func));
        if (op.u.mem.scale != 1) fprintf (f, " * %u", op.u.mem.scale);
      }
    }*/
  
    break;

    
    /*
    fprintf (f, "*(");
    out_type (f, op.u.mem.type);
    fprintf (f, "*) (");
    if (op.u.mem.disp != 0 || (op.u.mem.base == no_reg && op.u.mem.index == no_reg)) {
      fprintf (f, "%" PRId64, op.u.mem.disp);
      disp_p = TRUE;
    }
    if (op.u.mem.base != no_reg || op.u.mem.index != no_reg) {
      if (disp_p) fprintf (f, " + ");
      if (op.u.mem.base != no_reg) fprintf (f, "%s", MIR_reg_name (ctx, op.u.mem.base, curr_func));
      if (op.u.mem.index != no_reg) {
        if (op.u.mem.base != no_reg) fprintf (f, " + ");
        fprintf (f, "%s", MIR_reg_name (ctx, op.u.mem.index, curr_func));
        if (op.u.mem.scale != 1) fprintf (f, " * %u", op.u.mem.scale);
      }
    }
    fprintf (f, ")");
    break;
    */
  }
  /*
  case MIR_OP_MEM: {
    MIR_reg_t no_reg = 0;
    int disp_p = FALSE;

    fprintf (f, "*(");
    out_type (f, op.u.mem.type);
    fprintf (f, "*) (");
    if (op.u.mem.disp != 0 || (op.u.mem.base == no_reg && op.u.mem.index == no_reg)) {
      fprintf (f, "%" PRId64, op.u.mem.disp);
      disp_p = TRUE;
    }
    if (op.u.mem.base != no_reg || op.u.mem.index != no_reg) {
      if (disp_p) fprintf (f, " + ");
      if (op.u.mem.base != no_reg) fprintf (f, "%s", MIR_reg_name (ctx, op.u.mem.base, curr_func));
      if (op.u.mem.index != no_reg) {
        if (op.u.mem.base != no_reg) fprintf (f, " + ");
        fprintf (f, "%s", MIR_reg_name (ctx, op.u.mem.index, curr_func));
        if (op.u.mem.scale != 1) fprintf (f, " * %u", op.u.mem.scale);
      }
    }
    fprintf (f, ")");
    break;
  }
  */
  case MIR_OP_LABEL:
    mir_assert (op.u.label->ops[0].mode == MIR_OP_INT);
    fprintf (f, "%" PRId64, op.u.label->ops[0].u.i);
    break;
  default: mir_assert (FALSE);
  }
}

static void out_op2 (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *str) {
  //printf("out_op2: mode=%d\n", ops[1].mode);
  if (ops[0].mode == MIR_OP_MEM) {
    fprintf (f, "mir_write_");
    out_mangled_type (f, ops[0].u.mem.type);
    fprintf (f, "(");
    out_op_mem_address(ctx, f, ops[0]);
    fprintf (f, ", ");
    out_op (ctx, f, ops[1]);
    fprintf (f, ");\n");
  } else { 
    out_op (ctx, f, ops[0]);
    fprintf (f, " = ");
    if (str != NULL) fprintf (f, "%s ", str);
    if (ops[1].mode == MIR_OP_REF && ops[1].u.ref->item_type == MIR_func_item) {
      fprintf (f, "mir_get_function_ptr(\"");
      out_op (ctx, f, ops[1]);
      fprintf (f, "\")");
    } else {
      out_op (ctx, f, ops[1]);
    }
    fprintf (f, ";\n");
  }
}

static void out_op3 (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *str) {
  out_op (ctx, f, ops[0]);
  fprintf (f, " = (long) "); // int64_t
  out_op (ctx, f, ops[1]);
  fprintf (f, " %s (long) ", str); // int64_t
  out_op (ctx, f, ops[2]);
  fprintf (f, ";\n");
}

static void out_op3_logic (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *str) {
  out_op (ctx, f, ops[0]);
  fprintf (f, " = ((long) "); // int64_t
  out_op (ctx, f, ops[1]);
  fprintf (f, " %s (long) ", str); // int64_t
  out_op (ctx, f, ops[2]);
  fprintf (f, ") ? 1 : 0;\n");  
}


static void out_uop3 (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *str) {
  out_op (ctx, f, ops[0]);
  fprintf (f, " = (long) ");  // uint64_t. FIXME: how to handle unsigned long ?
  out_op (ctx, f, ops[1]);
  fprintf (f, " %s (long) ", str);
  out_op (ctx, f, ops[2]);
  fprintf (f, ";\n");
}

static void out_sop3 (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *str) {
  out_op (ctx, f, ops[0]);
  fprintf (f, " = (int) "); // int32_t 
  out_op (ctx, f, ops[1]);
  fprintf (f, " %s (int) ", str); // int32_t
  out_op (ctx, f, ops[2]);
  fprintf (f, ";\n");
}

static void out_sop3_logic (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *str) {
  out_op (ctx, f, ops[0]);
  fprintf (f, " = ((int) "); // int32_t
  out_op (ctx, f, ops[1]);
  fprintf (f, " %s (int) ", str); // int32_t
  out_op (ctx, f, ops[2]);
  fprintf (f, ") ? 1 : 0;\n");
}

static void out_usop3 (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *str) {
  out_op (ctx, f, ops[0]);
  fprintf (f, " = (long) "); // uint32_t
  out_op (ctx, f, ops[1]);
  fprintf (f, " %s (long) ", str); // uint32_t
  out_op (ctx, f, ops[2]);
  fprintf (f, ";\n");
}

/* Compare two 32-bit unsigned values and write 0/1 to dst */
static void out_usop3_logic32 (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *sign_test) {
    // ops[0] = dst, ops[1] = a, ops[2] = b
  // sign_test is one of "<", "<=", ">", ">=" applied to the compareUnsigned result vs 0
  out_op(ctx, f, ops[0]);
  fprintf(f, " = (Integer.compareUnsigned((int) ");
  out_op(ctx, f, ops[1]);
  fprintf(f, ", (int) ");
  out_op(ctx, f, ops[2]);
  fprintf(f, ") %s 0) ? 1 : 0;\n", sign_test);
}

static void out_uop3_logic64 (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *cmp) {
  out_op(ctx,f,ops[0]);
  fprintf(f," = (Long.compareUnsigned((long) "); out_op(ctx,f,ops[1]);
  fprintf(f,", (long) "); out_op(ctx,f,ops[2]); fprintf(f,") %s 0) ? 1 : 0;\n", cmp);
}

/* Set dst to 0/1 from a floating-point comparison */
static void out_fcmp3_logic (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *op) {
  /* ops[0] = dst, ops[1] = lhs, ops[2] = rhs */
  out_op(ctx, f, ops[0]);
  fprintf(f, " = (");
  out_op(ctx, f, ops[1]);
  fprintf(f, " %s ", op);
  out_op(ctx, f, ops[2]);
  fprintf(f, ") ? 1 : 0;\n");
}

static void out_jmp (MIR_context_t ctx, FILE *f, MIR_op_t label_op) {
  mir_assert (label_op.mode == MIR_OP_LABEL);
  fprintf (f, "mir_label = "); // goto
  out_op (ctx, f, label_op);
  fprintf (f, "; break;");
}

static void out_bcmp (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *str) {
  fprintf (f, "if ((long) "); // int64_t 
  out_op (ctx, f, ops[1]);
  fprintf (f, " %s (long) ", str); // int64_t
  out_op (ctx, f, ops[2]);
  fprintf (f, ") { ");
  out_jmp (ctx, f, ops[0]);
  fprintf (f, " }\n");
}

static void out_bscmp (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *str) {
  fprintf (f, "if ((int) "); // int32_t
  out_op (ctx, f, ops[1]);
  fprintf (f, " %s (int) ", str); // int32_t
  out_op (ctx, f, ops[2]);
  fprintf (f, ") { ");
  out_jmp (ctx, f, ops[0]);
  fprintf (f, " }\n");
}

/* 64-bit unsigned branch: if (cmpUnsigned(a,b) op 0) goto L; */
static void out_bucmp64 (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *op) {
  fprintf(f,"if (Long.compareUnsigned((long) "); out_op(ctx,f,ops[1]);
  fprintf(f,", (long) "); out_op(ctx,f,ops[2]);
  fprintf(f,") %s 0) { ", op); out_jmp(ctx,f,ops[0]); fprintf(f," }\n");
}

/* 32-bit unsigned branch */
static void out_buscmp32 (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *op) {
  fprintf(f,"if (Integer.compareUnsigned((int) "); out_op(ctx,f,ops[1]);
  fprintf(f,", (int) "); out_op(ctx,f,ops[2]);
  fprintf(f,") %s 0) { ", op); out_jmp(ctx,f,ops[0]); fprintf(f," }\n");
}

static void out_fop3 (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *str) {
  out_op (ctx, f, ops[0]);
  fprintf (f, " = ");
  out_op (ctx, f, ops[1]);
  fprintf (f, " %s ", str);
  out_op (ctx, f, ops[2]);
  fprintf (f, ";\n");
}

static void out_bfcmp (MIR_context_t ctx, FILE *f, MIR_op_t *ops, const char *str) {
  fprintf (f, "if (");
  out_op (ctx, f, ops[1]);
  fprintf (f, " %s ", str);
  out_op (ctx, f, ops[2]);
  fprintf (f, ") { ");
  out_jmp (ctx, f, ops[0]);
  fprintf (f, " }\n");
}

/* Emit: dst = (long) Long.divideUnsigned((long)a, (long)b); */
static void out_udiv64 (MIR_context_t ctx, FILE *f, MIR_op_t *ops) {
  /* ops[0] = dst, ops[1] = lhs, ops[2] = rhs */
  out_op(ctx, f, ops[0]); fprintf(f, " = (long) Long.divideUnsigned((long) ");
  out_op(ctx, f, ops[1]); fprintf(f, ", (long) "); out_op(ctx, f, ops[2]);
  fprintf(f, ");\n");
}

/* Emit: dst = (long) Long.remainderUnsigned((long)a, (long)b); */
static void out_umod64 (MIR_context_t ctx, FILE *f, MIR_op_t *ops) {
  out_op(ctx, f, ops[0]); fprintf(f, " = (long) Long.remainderUnsigned((long) ");
  out_op(ctx, f, ops[1]); fprintf(f, ", (long) "); out_op(ctx, f, ops[2]);
  fprintf(f, ");\n");
}

/* Emit: dst = (long) Integer.divideUnsigned((int)a, (int)b); */
static void out_udiv32 (MIR_context_t ctx, FILE *f, MIR_op_t *ops) {
  out_op(ctx, f, ops[0]); fprintf(f, " = (long) Integer.divideUnsigned((int) ");
  out_op(ctx, f, ops[1]); fprintf(f, ", (int) "); out_op(ctx, f, ops[2]);
  fprintf(f, ");\n");
}

/* Emit: dst = (long) Integer.remainderUnsigned((int)a, (int)b); */
static void out_umod32 (MIR_context_t ctx, FILE *f, MIR_op_t *ops) {
  out_op(ctx, f, ops[0]); fprintf(f, " = (long) Integer.remainderUnsigned((int) ");
  out_op(ctx, f, ops[1]); fprintf(f, ", (int) "); out_op(ctx, f, ops[2]);
  fprintf(f, ");\n");
}

/* Zero-extend 8-bit to 64-bit */
static void out_uext8 (MIR_context_t ctx, FILE *f, MIR_op_t *ops) {
  out_op(ctx,f,ops[0]); fprintf(f," = (((long) (int) ");
  out_op(ctx,f,ops[1]); fprintf(f,") & 0xFFL);\n");
}

/* Zero-extend 16-bit to 64-bit */
static void out_uext16 (MIR_context_t ctx, FILE *f, MIR_op_t *ops) {
  out_op(ctx,f,ops[0]); fprintf(f," = (((long) (int) ");
  out_op(ctx,f,ops[1]); fprintf(f,") & 0xFFFFL);\n");
}

/* Zero-extend 32-bit to 64-bit */
static void out_uext32 (MIR_context_t ctx, FILE *f, MIR_op_t *ops) {
  out_op(ctx,f,ops[0]); 
  fprintf(f," = (((long) "); 
  out_op(ctx,f,ops[1]);
  fprintf(f, ") & 0xFFFFFFFFL);\n"); 
}

/* 32-bit logical right shift: dst = (long)(((int)lhs) >>> (int)rhs) */
static void out_urshs32 (MIR_context_t ctx, FILE *f, MIR_op_t *ops) {
  out_op(ctx,f,ops[0]); fprintf(f," = (long)(((int) ");
  out_op(ctx,f,ops[1]); fprintf(f,") >>> (int) ");
  out_op(ctx,f,ops[2]); fprintf(f," );\n");
}

/* Emit: if (((int) v) != 0) { goto L; } */
static void out_bts (MIR_context_t ctx, FILE *f, MIR_op_t *ops) {
  /* ops[0] = label, ops[1] = value */
  fprintf(f, "if (((int) "); out_op(ctx, f, ops[1]); fprintf(f, " != 0)) { ");
  out_jmp(ctx, f, ops[0]); fprintf(f, " }\n");
}

/* Emit: if (((int) v) == 0) { goto L; } */
static void out_bfs (MIR_context_t ctx, FILE *f, MIR_op_t *ops) {
  fprintf(f, "if (((int) "); out_op(ctx, f, ops[1]); fprintf(f, " == 0)) { ");
  out_jmp(ctx, f, ops[0]); fprintf(f, " }\n");
}

/* Emit: saved = mir_get_stack_position(); */
static void out_bstart (MIR_context_t ctx, FILE *f, MIR_op_t *ops) {
  out_op(ctx, f, ops[0]); fprintf(f, " = mir_get_stack_position();\n");
}

/* Emit: mir_set_stack_position(saved); */
static void out_bend (MIR_context_t ctx, FILE *f, MIR_op_t *ops) {
  fprintf(f, "mir_set_stack_position("); out_op(ctx, f, ops[0]); fprintf(f, ");\n");
}

static void out_insn (MIR_context_t ctx, FILE *f, MIR_insn_t insn) {
  MIR_op_t *ops = insn->ops;

  if (insn->code != MIR_LABEL) fprintf (f, "  ");
  switch (insn->code) {
  case MIR_MOV:
  case MIR_FMOV:
  case MIR_DMOV: 
  case MIR_LDMOV: out_op2 (ctx, f, ops, NULL); break;
  case MIR_EXT8: out_op2 (ctx, f, ops, "(long) (byte)"); break; // (int64_t) (int8_t) 
  case MIR_EXT16: out_op2 (ctx, f, ops, "(long) (short)"); break; // (int64_t) (int16_t) 
  case MIR_EXT32: out_op2 (ctx, f, ops, "(long) (int)"); break; // (int64_t) (int32_t)
  case MIR_UEXT8: out_uext8 (ctx,f,ops); break; // (int64_t) (uint8_t)
  case MIR_UEXT16: out_uext16(ctx,f,ops); break; // (int64_t) (uint16_t)
  case MIR_UEXT32: out_uext32 (ctx, f, ops); break; // (int64_t) (uint32_t)
  case MIR_F2I:
  case MIR_D2I:
  case MIR_LD2I: out_op2 (ctx, f, ops, "(long)"); break; // int64_t 
  case MIR_I2D:
  case MIR_F2D:
  case MIR_LD2D: out_op2 (ctx, f, ops, "(double)"); break;
  case MIR_I2F:
  case MIR_D2F:
  case MIR_LD2F: out_op2 (ctx, f, ops, "(float)"); break;
  case MIR_I2LD:
  case MIR_D2LD:
  case MIR_F2LD: out_op2 (ctx, f, ops, "(double)"); break; // long double
  case MIR_UI2D: out_op2 (ctx, f, ops, "(double) (long)"); break; // (double) (uint64_t)
  case MIR_UI2F: out_op2 (ctx, f, ops, "(float) (long)"); break; // (float) (uint64_t)
  case MIR_UI2LD: out_op2 (ctx, f, ops, "(double) (long)"); break; // (long double) (uint64_t)
  case MIR_NEG: out_op2 (ctx, f, ops, "- (long)"); break; // int64_t
  case MIR_NEGS: out_op2 (ctx, f, ops, "- (int)"); break; // int32_t
  case MIR_FNEG:
  case MIR_DNEG:
  case MIR_LDNEG: out_op2 (ctx, f, ops, "-"); break;
  case MIR_ADD: out_op3 (ctx, f, ops, "+"); break;
  case MIR_SUB: out_op3 (ctx, f, ops, "-"); break;
  case MIR_MUL: out_op3 (ctx, f, ops, "*"); break;
  case MIR_DIV: out_op3 (ctx, f, ops, "/"); break;
  case MIR_MOD: out_op3 (ctx, f, ops, "%"); break;
  case MIR_UDIV:  out_udiv64 (ctx, f, ops); break;
  case MIR_UMOD:  out_umod64 (ctx, f, ops); break;
  case MIR_ADDS: out_sop3 (ctx, f, ops, "+"); break;
  case MIR_SUBS: out_sop3 (ctx, f, ops, "-"); break;
  case MIR_MULS: out_sop3 (ctx, f, ops, "*"); break;
  case MIR_DIVS: out_sop3 (ctx, f, ops, "/"); break;
  case MIR_MODS: out_sop3 (ctx, f, ops, "%"); break;
  case MIR_UDIVS: out_udiv32 (ctx, f, ops); break;
  case MIR_UMODS: out_umod32 (ctx, f, ops); break;
  case MIR_FADD:
  case MIR_DADD:
  case MIR_LDADD: out_fop3 (ctx, f, ops, "+"); break;
  case MIR_FSUB:
  case MIR_DSUB:
  case MIR_LDSUB: out_fop3 (ctx, f, ops, "-"); break;
  case MIR_FMUL:
  case MIR_DMUL:
  case MIR_LDMUL: out_fop3 (ctx, f, ops, "*"); break;
  case MIR_FDIV:
  case MIR_DDIV:
  case MIR_LDDIV: out_fop3 (ctx, f, ops, "/"); break;
  case MIR_AND: out_op3 (ctx, f, ops, "&"); break;
  case MIR_OR: out_op3 (ctx, f, ops, "|"); break;
  case MIR_XOR: out_op3 (ctx, f, ops, "^"); break;
  case MIR_ANDS: out_sop3 (ctx, f, ops, "&"); break;
  case MIR_ORS: out_sop3 (ctx, f, ops, "|"); break;
  case MIR_XORS: out_sop3 (ctx, f, ops, "^"); break;
  case MIR_LSH: out_op3 (ctx, f, ops, "<<"); break;
  case MIR_RSH: out_op3 (ctx, f, ops, ">>"); break;
  case MIR_URSH: out_uop3 (ctx, f, ops, ">>>"); break;
  case MIR_LSHS: out_sop3 (ctx, f, ops, "<<"); break;
  case MIR_RSHS: out_sop3 (ctx, f, ops, ">>"); break;
  case MIR_URSHS: out_urshs32 (ctx, f, ops); break;
  case MIR_EQ: out_op3_logic (ctx, f, ops, "=="); break;
  case MIR_NE: out_op3_logic (ctx, f, ops, "!="); break;
  case MIR_LT: out_op3_logic (ctx, f, ops, "<"); break;
  case MIR_LE: out_op3_logic (ctx, f, ops, "<="); break;
  case MIR_GT: out_op3_logic (ctx, f, ops, ">"); break;
  case MIR_GE: out_op3_logic (ctx, f, ops, ">="); break;
  case MIR_EQS: out_sop3_logic (ctx, f, ops, "=="); break;
  case MIR_NES: out_sop3_logic (ctx, f, ops, "!="); break;
  case MIR_LTS: out_sop3_logic (ctx, f, ops, "<"); break;
  case MIR_LES: out_sop3_logic (ctx, f, ops, "<="); break;
  case MIR_GTS: out_sop3_logic (ctx, f, ops, ">"); break;
  case MIR_GES: out_sop3_logic (ctx, f, ops, ">="); break;
  case MIR_ULT: out_uop3_logic64(ctx,f,ops,"<");  break;
  case MIR_ULE: out_uop3_logic64(ctx,f,ops,"<="); break;
  case MIR_UGT: out_uop3_logic64(ctx,f,ops,">");  break;
  case MIR_UGE: out_uop3_logic64(ctx,f,ops,">="); break;
  case MIR_ULTS: out_usop3_logic32 (ctx, f, ops, "<"); break;
  case MIR_ULES: out_usop3_logic32 (ctx, f, ops, "<="); break;
  case MIR_UGTS: out_usop3_logic32 (ctx, f, ops, ">"); break;
  case MIR_UGES: out_usop3_logic32 (ctx, f, ops, ">="); break;
  case MIR_FEQ:
  case MIR_DEQ:
  case MIR_LDEQ: out_fcmp3_logic (ctx, f, ops, "=="); break;
  case MIR_FNE:
  case MIR_DNE:
  case MIR_LDNE: out_fcmp3_logic (ctx, f, ops, "!="); break;
  case MIR_FLT:
  case MIR_DLT:
  case MIR_LDLT: out_fcmp3_logic (ctx, f, ops, "<");  break;
  case MIR_FLE:
  case MIR_DLE:
  case MIR_LDLE: out_fcmp3_logic (ctx, f, ops, "<="); break;
  case MIR_FGT:
  case MIR_DGT:
  case MIR_LDGT: out_fcmp3_logic (ctx, f, ops, ">");  break;
  case MIR_FGE:
  case MIR_DGE:
  case MIR_LDGE: out_fcmp3_logic (ctx, f, ops, ">="); break;
  case MIR_JMP: 
    if (is_in_dead_code) {
      fprintf (f, "// Dead code: ");
    }
    out_jmp (ctx, f, ops[0]); 
    fprintf (f, "\n");
    is_in_dead_code = TRUE;
    break;
  case MIR_SWITCH:
    fprintf (f, "switch((int) ");
    out_op(ctx, f, ops[0]);
    fprintf (f, ") {\n");
    for (int i = 0; i < insn->nops - 1; i++) {
       fprintf (f, "  case %d: ", i);
       fprintf (f, "mir_label = ");
       out_op(ctx, f, ops[i + 1]);
       fprintf (f, "; break;\n");
    }
    fprintf (f, "  }\n");
    fprintf (f, "  break;");
    fprintf (f, " // End of switch(");
    out_op(ctx, f, ops[0]);
    fprintf (f, ")\n");
    break; 
  case MIR_BT:
    fprintf (f, "if (((long) "); // int64_t
    out_op (ctx, f, ops[1]);
    fprintf (f, " != 0)) { ");
    out_jmp (ctx, f, ops[0]);
    fprintf (f, " }\n");
    break;
  case MIR_BF:
    fprintf (f, "if (((long) "); // int64_t
    out_op (ctx, f, ops[1]);
    fprintf (f, " == 0)) { ");
    out_jmp (ctx, f, ops[0]);
    fprintf (f, " }\n");
    break;
  case MIR_BTS: out_bts (ctx, f, ops); break;
  case MIR_BFS: out_bfs (ctx, f, ops); break;
  case MIR_BEQ: out_bcmp (ctx, f, ops, "=="); break;
  case MIR_BNE: out_bcmp (ctx, f, ops, "!="); break;
  case MIR_BLT: out_bcmp (ctx, f, ops, "<"); break;
  case MIR_BLE: out_bcmp (ctx, f, ops, "<="); break;
  case MIR_BGT: out_bcmp (ctx, f, ops, ">"); break;
  case MIR_BGE: out_bcmp (ctx, f, ops, ">="); break;
  case MIR_BEQS: out_bscmp (ctx, f, ops, "=="); break;
  case MIR_BNES: out_bscmp (ctx, f, ops, "!="); break;
  case MIR_BLTS: out_bscmp (ctx, f, ops, "<"); break;
  case MIR_BLES: out_bscmp (ctx, f, ops, "<="); break;
  case MIR_BGTS: out_bscmp (ctx, f, ops, ">"); break;
  case MIR_BGES: out_bscmp (ctx, f, ops, ">="); break;
  case MIR_UBLT:  out_bucmp64 (ctx, f, ops, "<");  break;
  case MIR_UBLE:  out_bucmp64 (ctx, f, ops,"<="); break;
  case MIR_UBGT:  out_bucmp64 (ctx, f, ops, ">");  break;
  case MIR_UBGE:  out_bucmp64 (ctx, f, ops, ">="); break;
  case MIR_UBLTS: out_buscmp32(ctx, f, ops, "<");  break;
  case MIR_UBLES: out_buscmp32(ctx, f, ops, "<="); break;
  case MIR_UBGTS: out_buscmp32(ctx, f, ops, ">");  break;
  case MIR_UBGES: out_buscmp32(ctx, f, ops, ">="); break;
  case MIR_FBEQ:
  case MIR_DBEQ:
  case MIR_LDBEQ: out_bfcmp (ctx, f, ops, "=="); break;
  case MIR_FBNE:
  case MIR_DBNE:
  case MIR_LDBNE: out_bfcmp (ctx, f, ops, "!="); break;
  case MIR_FBLT:
  case MIR_DBLT:
  case MIR_LDBLT: out_bfcmp (ctx, f, ops, "<"); break;
  case MIR_FBLE:
  case MIR_DBLE:
  case MIR_LDBLE: out_bfcmp (ctx, f, ops, "<="); break;
  case MIR_FBGT:
  case MIR_DBGT:
  case MIR_LDBGT: out_bfcmp (ctx, f, ops, ">"); break;
  case MIR_FBGE:
  case MIR_DBGE:
  case MIR_LDBGE: out_bfcmp (ctx, f, ops, ">="); break;
  case MIR_ALLOCA:
    out_op (ctx, f, ops[0]);
    fprintf (f, " = mir_allocate(");
    out_op (ctx, f, ops[1]);
    fprintf (f, ");\n");
    break;
  case MIR_CALL:
  case MIR_INLINE: {
    MIR_proto_t proto;
    size_t start = 2;
    int has_result = 0;
    MIR_type_t rt = MIR_T_I64; // default

    mir_assert (insn->nops >= 2 && ops[0].mode == MIR_OP_REF
                && ops[0].u.ref->item_type == MIR_proto_item);
    proto = ops[0].u.ref->u.proto;
    if (proto->nres > 1) {
      (*MIR_get_error_func (ctx)) (MIR_call_op_error,
                                   " can not translate multiple results functions into C");
    } else if (proto->nres == 1) {
      out_op (ctx, f, ops[2]);
      fprintf (f, " = ");
      start = 3;
      rt = proto->res_types[0];
      has_result = 1;
    }
    //fprintf (f, "((%s) ", proto->name);
    //printf(" (CALL: mode=%d) ", ops[1].mode);
    //int number_of_args = insn->nops - start;
    if ((ops[1].mode == MIR_OP_REG)) { // && (number_of_args > 0)) {
        // Indirect call through function pointer
        if (!has_result) {
            fprintf (f, "mir_call_function_ret_void(");
        } else if (rt == MIR_T_F) {
            fprintf (f, "mir_call_function_ret_float(");
        } else if (rt == MIR_T_D) {
            fprintf (f, "mir_call_function_ret_double(");
        } else {
            fprintf (f, "mir_call_function_ret_long(");
        }
        out_op (ctx, f, ops[1]);
        fprintf (f, ", ");
    } else {
      // Direct call path
      out_op (ctx, f, ops[1]);
      fprintf (f, "(");	
    }

    // Emit arguments
    int arg_number = VARR_LENGTH (MIR_var_t, proto->args);
    for (size_t i = start; i < insn->nops; i++) {
      if (i != start) fprintf (f, ", ");
	  int arg_index = (int) (i - start);
	  if (arg_index < arg_number) {
	    MIR_var_t var = VARR_GET (MIR_var_t, proto->args, arg_index);
	    fprintf (f, "(");
        out_type (f, var.type);
	    fprintf (f, ") ");
	  }      
      if (ops[i].mode == MIR_OP_REF && ops[i].u.ref->item_type == MIR_func_item) {
        fprintf (f, "mir_get_function_ptr(\"");
        out_op (ctx, f, ops[i]);
        fprintf (f, "\")");
      } else {
        out_op (ctx, f, ops[i]);
      }
    }
    fprintf (f, ");\n");

    /*
    for (i = 0; i < VARR_LENGTH (MIR_var_t, proto->args); i++) {
      var = VARR_GET (MIR_var_t, proto->args, i);
      if (i != 0) fprintf (f, ", ");
      out_type (f, var.type);
      if (var.name != NULL) fprintf (f, " %s", var.name);
    }
    */
    
    break;
  }
  /*
  case MIR_INLINE: {
      MIR_proto_t proto;
      size_t start = 2;
  
      mir_assert (insn->nops >= 2 && ops[0].mode == MIR_OP_REF
                  && ops[0].u.ref->item_type == MIR_proto_item);
      proto = ops[0].u.ref->u.proto;
      if (proto->nres > 1) {
        (*MIR_get_error_func (ctx)) (MIR_call_op_error,
                                     " can not translate multiple results functions into C");
      } else if (proto->nres == 1) {
        out_op (ctx, f, ops[2]);
        fprintf (f, " = ");
        start = 3;
      }
      fprintf (f, "((%s) ", proto->name);
      out_op (ctx, f, ops[1]);
      fprintf (f, ") (");
      for (size_t i = start; i < insn->nops; i++) {
        if (i != start) fprintf (f, ", ");
        out_op (ctx, f, ops[i]);
      }
      fprintf (f, ");\n");
      break;
  } 
  */
  case MIR_RET:
    if (curr_func_has_stack_allocation) {
      fprintf (f, "mir_set_stack_position(mir_saved_stack_position);\n");
      fprintf (f, "  ");
    }
    fprintf (f, "return");
    if (insn->nops > 1) {
      fprintf (stderr, "return with multiple values is not implemented. See function %s\n", curr_func->name);
      exit (1);
    }
    // Cast returned type to the function return type
    if (insn->nops != 0) { 
      fprintf (f, " (");
      out_type (f, curr_func->res_types[0]);
      fprintf (f, ") ");
      out_op (ctx, f, insn->ops[0]);
    }
    fprintf (f, ";\n");
    is_in_dead_code = TRUE;
    break;
  case MIR_BSTART: out_bstart(ctx, f, ops); break;
  case MIR_BEND:   out_bend  (ctx, f, ops); break;
  case MIR_LABEL:
    mir_assert (ops[0].mode == MIR_OP_INT);
    fprintf (f, "case %" PRId64 ":\n", ops[0].u.i);
    is_in_dead_code = FALSE;
    break;
  case MIR_VA_START:
    fprintf (f, "mir_va_start(");
    out_op (ctx, f, insn->ops[0]);
    fprintf (f, ", mir_var_args);\n");
    break;
  case MIR_VA_ARG: 
    {
    int var_type = insn->ops[2].u.mem.type;
    fprintf (f, "{ // va_arg(");
    out_type(f, var_type);
    fprintf (f, ")\n");
    fprintf (f, "  VarArgs varArgs = mir_va_get_wrapper(");
    out_op (ctx, f, insn->ops[1]);
    fprintf (f, ");\n  ");
    out_op (ctx, f, insn->ops[0]);
    fprintf (f, " = varArgs.getArgDataAddr();\n");
    if (var_type == MIR_T_F || var_type == MIR_T_D || var_type == MIR_T_LD) {
      fprintf (f, "  double arg_value = varArgs.nextDouble");	
    } else {
      fprintf (f, "  long arg_value = varArgs.nextLong");	
    } 
    fprintf (f, "();\n");	  
    fprintf (f, "  mir_write_");
    out_mangled_type(f, var_type);
    fprintf (f, "(");
    out_op (ctx, f, insn->ops[0]);
    fprintf (f, ", (");
    out_type(f, var_type);
    fprintf (f, ") arg_value);\n");
    fprintf (f, "  } // end of va_arg\n");    
    }
    break;
  case MIR_VA_END:
    // FIXME c2mir doesn't emit va_end currently
    fprintf (f, "mir_va_end(");
    out_op (ctx, f, insn->ops[0]);
    fprintf (f, ");\n");
    break;
  case MIR_VA_BLOCK_ARG:
   fprintf (f, "// Instruction MIR_VA_BLOCK_ARG is not supported yet\n");
   exit(1);
   /* result addr := buffer; copy next block argument of given size there */
   // fprintf(f, "{ // va_block_arg\n  ");
   // out_op(ctx,f,ops[0]); fprintf(f," = "); /* result receives a writable buffer addr */
   // fprintf(f, "mir_va_get_wrapper("); out_op(ctx,f,ops[1]); fprintf(f, ").getArgDataAddr();\n  ");
   // fprintf(f, "long __src = mir_va_get_wrapper("); out_op(ctx,f,ops[1]); fprintf(f, ").nextLong();\n  ");
   // fprintf(f, "memcpy("); out_op(ctx,f,ops[0]); fprintf(f, ", __src, ");
   // out_op(ctx,f,ops[2]); fprintf(f, ");\n}\n"); 
   break;
  default: 
    fprintf (f, "// Unknown instruction code=%d\n", insn->code);
    mir_assert (FALSE);
    exit(1);
  }
}

void out_item (MIR_context_t ctx, FILE *f, MIR_item_t item) {
  MIR_var_t var;
  size_t i, nlocals;

  if (item->item_type == MIR_export_item) {
	/*
    MIR_item_t exported_item = item->ref_def;
    if (exported_item->item_type == MIR_data_item) {
      out_type(f, exported_item->u.data->el_type);
      fprintf(f, " %s = %d;\n", exported_item->u.data->name, exported_item->u.data->u.els[0]);
    }
    */
    MIR_item_t exported_item = item->ref_def;
    add_symbol(MIR_item_name(ctx, exported_item), TRUE);
    return;
  }
  if (item->item_type == MIR_import_item) {
    //fprintf (f, "extern char %s[];\n", item->u.import_id);
    MIR_item_t imported_item = item->ref_def;
    add_symbol(item->u.import_id, TRUE);
    return;
  }
  if (item->item_type == MIR_forward_item) {  // ???
    MIR_item_t forwarded_item = item->ref_def;
    add_symbol(MIR_item_name(ctx, forwarded_item), FALSE);
    return;
  }
  if (item->item_type == MIR_proto_item) {
    /*
    MIR_proto_t proto = item->u.proto;

    fprintf (f, "typedef ");
    if (proto->nres == 0)
      fprintf (f, "void");
    else if (proto->nres == 1)
      out_type (f, proto->res_types[0]);
    else
      (*MIR_get_error_func (ctx)) (MIR_func_error,
                                   "Multiple result functions can not be called in C");
    fprintf (f, " (*%s) (", proto->name);
    for (i = 0; i < VARR_LENGTH (MIR_var_t, proto->args); i++) {
      var = VARR_GET (MIR_var_t, proto->args, i);
      if (i != 0) fprintf (f, ", ");
      out_type (f, var.type);
      if (var.name != NULL) fprintf (f, " %s", var.name);
    }
    if (i == 0) fprintf (f, "void");
    fprintf (f, ");\n");
    */
    return;
  }
  if (item->item_type == MIR_data_item) {
    fprintf(f, "long ");
    if (item->u.data->name != NULL) {
    	//const char* var_name = mangle_name(item->u.data->name);
        char *var_name = get_mangled_symbol_name(item->u.data->name);
    	fprintf(f, "%s", var_name);
    } else {
        fprintf(f, "unused_data_addr_%d", unused_data_addr_count++);
    }
    fprintf(f, " = mir_set_data_");
    out_mangled_type(f, item->u.data->el_type);
    /*
    if (item->u.data->el_type == MIR_T_U8) {
      fprintf(f, "ubyte");
    } else if (item->u.data->el_type == MIR_T_U16) {
      fprintf(f, "ushort");
    } else if (item->u.data->el_type == MIR_T_U32) {
      fprintf(f, "uint");
    } else if (item->u.data->el_type == MIR_T_U64) {
      fprintf(f, "ulong");  
    } else {
      out_type(f, item->u.data->el_type);
    }
    */
    if (item->u.data->nel == 1) {
      //fprintf(f, "(alignement = %f)", item->u.data->u.d);
      fprintf(f, "(");
      out_type_value(f, item->u.data->el_type, item->u.data->u.els);
      fprintf(f, ");\n");
    } else {
      fprintf(f, "s(new ");
      if (item->u.data->el_type == MIR_T_U8) {
        fprintf(f, "short");
      } else if (item->u.data->el_type == MIR_T_U16) {
        fprintf(f, "int");
      } else if (item->u.data->el_type == MIR_T_U32) {
        fprintf(f, "long");
      } else {
        out_type(f, item->u.data->el_type);
      }
      fprintf(f, "[] { ");
      for (int i = 0; i < item->u.data->nel; i++) {
        if (i != 0) fprintf (f, ", ");
        fprintf(f, "%d", item->u.data->u.els[i]);	
      } 
      fprintf(f, " });\n");
    }
    return;
  }
  if (item->item_type == MIR_ref_data_item) {
    fprintf(f, "long ");
    if (item->u.ref_data->name != NULL) {
        char* out_var_name = get_mangled_symbol_name(item->u.ref_data->name);
    	fprintf(f, "%s", out_var_name);
    } else {
        fprintf(f, "unused_data_addr_%d", unused_data_addr_count++);
    }
    char* in_var_name = get_mangled_symbol_name(item->u.ref_data->ref_item->u.ref_data->name);
    fprintf(f, " = mir_set_data_ref(%s + %d);\n", in_var_name, item->u.ref_data->disp);
    return;
  }
  if (item->item_type == MIR_expr_data_item) {
      fprintf(stderr, "\nError in function %s\n", curr_func->name);
      (*MIR_get_error_func (ctx)) (MIR_func_error, "Expr data items are not supported yet");
      return;
  }
  if (item->item_type == MIR_bss_item) {
    fprintf(f, "long ");
    if (item->u.bss->name != NULL) {
      char* bss_name = get_mangled_symbol_name(item->u.bss->name);
      fprintf(f, "%s", bss_name);
    } else {
      fprintf(f, "unused_data_addr_%d", unused_data_addr_count++);
    }
    fprintf(f, " = mir_allocate(%d);\n", item->u.bss->len);
    return;
  }

  curr_func = item->u.func;
  char* func_name = (char*) curr_func->name;
  //printf("[MIR2J_DEBUG] function name:%s\n", func_name);

  /*------------------------------------
    First pass to analyze the function
  ------------------------------------- */
  int curr_func_number_of_labels = 0;
  curr_func_has_stack_allocation = FALSE;
  for (MIR_insn_t insn = DLIST_HEAD (MIR_insn_t, curr_func->insns); insn != NULL;
       insn = DLIST_NEXT (MIR_insn_t, insn)) {
    if (insn->code == MIR_LABEL) {
      curr_func_number_of_labels++; 
    } else if (insn->code == MIR_ALLOCA) {
      curr_func_has_stack_allocation = TRUE;	
    }
  }
  if (curr_func->vararg_p) {
    // The current implementation of varargs uses stack allocation
    curr_func_has_stack_allocation = TRUE;	
  }
  //printf("n of labels=%d\n", curr_func_number_of_labels);

  /*-----------------------------------------------
    Second pass where the code is actually emitted
  ------------------------------------------------ */
  symbol_t func_symbol;
  if (!item->export_p) {
    fprintf (f, "protected "); // static
    func_symbol = add_symbol(curr_func->name, FALSE);
  } else {
  	fprintf (f, "public ");
  	func_symbol = add_symbol(curr_func->name, TRUE);
  }
  if (curr_func->nres == 0)
    fprintf (f, "void");
  else if (curr_func->nres == 1)
    out_type (f, curr_func->res_types[0]);
  else {
    fprintf(stderr, "\nError in function %s\n", curr_func->name);
    (*MIR_get_error_func (ctx)) (MIR_func_error,
                                 "Multiple result functions can not be represented in C");
  }
  fprintf (f, " %s (", func_symbol.mangled_name);
  //if (curr_func->nargs == 0) fprintf (f, "void");
  for (i = 0; i < curr_func->nargs; i++) {
    if (i != 0) fprintf (f, ", ");
    var = VARR_GET (MIR_var_t, curr_func->vars, i);
    out_type (f, var.type);
    fprintf (f,
             var.type == MIR_T_I64 || var.type == MIR_T_F || var.type == MIR_T_D
                 || var.type == MIR_T_LD
               ? " %s"
               : " _%s",
             var.name);
  }
  if (curr_func->vararg_p) {
    fprintf (f, ", Object... mir_var_args");
  }
  fprintf (f, ") {\n");
  for (i = 0; i < curr_func->nargs; i++) {
    var = VARR_GET (MIR_var_t, curr_func->vars, i);
    if (var.type == MIR_T_I64 || var.type == MIR_T_F || var.type == MIR_T_D || var.type == MIR_T_LD)
      continue;
    fprintf (f, "  long %s = _%s;\n", var.name, var.name);  // int64_t
  }
  nlocals = VARR_LENGTH (MIR_var_t, curr_func->vars) - curr_func->nargs;
  for (i = 0; i < nlocals; i++) {
    var = VARR_GET (MIR_var_t, curr_func->vars, i + curr_func->nargs);
    fprintf (f, "  ");
    out_type (f, var.type);
    fprintf (f, " %s = 0;\n", var.name);
  }
  if (curr_func_has_stack_allocation) {
  	fprintf (f, "  int mir_saved_stack_position =  mir_get_stack_position();\n");
  }
  if (curr_func_number_of_labels > 0) {
    fprintf (f, "  int mir_label = -1;\n");
    fprintf (f, "while (true) {\n");
    fprintf (f, "switch (mir_label) {\n");
    fprintf (f, "case -1:\n");
  }
  for (MIR_insn_t insn = DLIST_HEAD (MIR_insn_t, curr_func->insns); insn != NULL;
       insn = DLIST_NEXT (MIR_insn_t, insn)) {
    out_insn (ctx, f, insn);
  }
  if (curr_func_number_of_labels > 0) {
    fprintf (f, "} // End of switch\n"); 
    fprintf (f, "} // End of while\n");
  }
  fprintf (f, "} // End of function %s\n\n", curr_func->name);
  is_in_dead_code = FALSE;
}

static void MIR_all_modules2j (MIR_context_t ctx, FILE *f) {
  create_symbol_table();

  fprintf(f, "import mir2j.Runtime;\n\n");
  fprintf(f, "public class Main extends Runtime {\n\n");

  for (MIR_module_t m = DLIST_HEAD (MIR_module_t, *MIR_get_module_list (ctx));
       m != NULL;
       m = DLIST_NEXT (MIR_module_t, m)) {
    ++module_serial;
    for (MIR_item_t it = DLIST_HEAD (MIR_item_t, m->items);
         it != NULL;
         it = DLIST_NEXT (MIR_item_t, it)) {
      out_item (ctx, f, it);
    }
  }

  fprintf(f, "} // End of class Main\n");
  destroy_symbol_table();
}

/*
void MIR_module2j (MIR_context_t ctx, FILE *f, MIR_module_t m) {
  create_symbol_table();

  fprintf(f, "import mir2j.Runtime;\n\n");
  fprintf(f, "public class Main extends Runtime {\n\n");
  //fprintf(f, "public Main() {\n");
  //fprintf(f, "  super(Main.class);\n");
  //fprintf(f, "}\n\n");
  for (MIR_item_t item = DLIST_HEAD (MIR_item_t, m->items); item != NULL;
       item = DLIST_NEXT (MIR_item_t, item))
    out_item (ctx, f, item);
  fprintf(f, "} // End of class Main\n");

  destroy_symbol_table();
}
*/

/* ------------------------- Small test example ------------------------- */
#if defined(TEST_MIR2J)

#include "mir-tests/scan-sieve.h"
#include "mir-tests/scan-hi.h"

int main (int argc, const char *argv[]) {
  MIR_module_t m;
  MIR_context_t ctx = MIR_init ();

  create_mir_func_sieve (ctx, NULL, &m);
  MIR_module2j (ctx, stdout, m);
  MIR_finish (ctx);
  return 0;
}
#elif defined(MIR2J)

DEF_VARR (char);

int main (int argc, const char *argv[]) {
  int c;
  FILE *f;
  VARR (char) * input;
  MIR_module_t m;
  MIR_context_t ctx = MIR_init ();

  if (argc == 1)
    f = stdin;
  else if (argc == 2) {
    if ((f = fopen (argv[1], "r")) == NULL) {
      fprintf (stderr, "%s: cannot open file %s\n", argv[0], argv[1]);
      exit (1);
    }
  } else {
    fprintf (stderr, "usage: %s < file or %s mir-file\n", argv[0], argv[0]);
    exit (1);
  }
  
  VARR_CREATE (char, input, 0);
  while ((c = getc (f)) != EOF) VARR_PUSH (char, input, c);
  VARR_PUSH (char, input, 0);
  if (ferror (f)) {
    fprintf (stderr, "%s: error in reading input file\n", argv[0]);
    exit (1);
  }
  fclose (f);
  MIR_scan_string (ctx, VARR_ADDR (char, input));
  
  //MIR_read (ctx, f);
  MIR_all_modules2j (ctx, stdout);
  MIR_finish (ctx);
  VARR_DESTROY (char, input);
  return 0;
}
#endif
