/* This file is a part of MIR project.
   Copyright (C) 2018-2021 Vladimir Makarov <vmakarov.gcc@gmail.com>.
*/

#include <limits.h>

#define HREG_EL(h) h##_HARD_REG
#define REP_SEP ,
enum {
  REP8 (HREG_EL, AX, CX, DX, BX, SP, BP, SI, DI),
  REP8 (HREG_EL, R8, R9, R10, R11, R12, R13, R14, R15),
  REP8 (HREG_EL, XMM0, XMM1, XMM2, XMM3, XMM4, XMM5, XMM6, XMM7),
  REP8 (HREG_EL, XMM8, XMM9, XMM10, XMM11, XMM12, XMM13, XMM14, XMM15),
  REP2 (HREG_EL, ST0, ST1),
};
#undef REP_SEP

static const MIR_reg_t MAX_HARD_REG = ST1_HARD_REG;
static const MIR_reg_t FP_HARD_REG = BP_HARD_REG;

static int target_locs_num (MIR_reg_t loc, MIR_type_t type) {
  return loc > MAX_HARD_REG && type == MIR_T_LD ? 2 : 1;
}

static inline MIR_reg_t target_nth_loc (MIR_reg_t loc, MIR_type_t type, int n) { return loc + n; }

/* Hard regs not used in machinized code, preferably call used ones. */
const MIR_reg_t TEMP_INT_HARD_REG1 = R10_HARD_REG, TEMP_INT_HARD_REG2 = R11_HARD_REG;
#ifndef _WIN32
const MIR_reg_t TEMP_FLOAT_HARD_REG1 = XMM8_HARD_REG, TEMP_FLOAT_HARD_REG2 = XMM9_HARD_REG;
const MIR_reg_t TEMP_DOUBLE_HARD_REG1 = XMM8_HARD_REG, TEMP_DOUBLE_HARD_REG2 = XMM9_HARD_REG;
#else
const MIR_reg_t TEMP_FLOAT_HARD_REG1 = XMM4_HARD_REG, TEMP_FLOAT_HARD_REG2 = XMM5_HARD_REG;
const MIR_reg_t TEMP_DOUBLE_HARD_REG1 = XMM4_HARD_REG, TEMP_DOUBLE_HARD_REG2 = XMM5_HARD_REG;
#endif
const MIR_reg_t TEMP_LDOUBLE_HARD_REG1 = MIR_NON_HARD_REG;
const MIR_reg_t TEMP_LDOUBLE_HARD_REG2 = MIR_NON_HARD_REG;

static inline int target_hard_reg_type_ok_p (MIR_reg_t hard_reg, MIR_type_t type) {
  assert (hard_reg <= MAX_HARD_REG);
  /* For LD we need x87 stack regs and it is too complicated so no
     hard register allocation for LD: */
  if (type == MIR_T_LD) return FALSE;
  return MIR_int_type_p (type) ? hard_reg < XMM0_HARD_REG : hard_reg >= XMM0_HARD_REG;
}

static inline int target_fixed_hard_reg_p (MIR_reg_t hard_reg) {
  assert (hard_reg <= MAX_HARD_REG);
  return (hard_reg == BP_HARD_REG || hard_reg == SP_HARD_REG || hard_reg == TEMP_INT_HARD_REG1
          || hard_reg == TEMP_INT_HARD_REG2 || hard_reg == TEMP_FLOAT_HARD_REG1
          || hard_reg == TEMP_FLOAT_HARD_REG2 || hard_reg == TEMP_DOUBLE_HARD_REG1
          || hard_reg == TEMP_DOUBLE_HARD_REG2 || hard_reg == ST0_HARD_REG
          || hard_reg == ST1_HARD_REG);
}

static inline int target_call_used_hard_reg_p (MIR_reg_t hard_reg, MIR_type_t type) {
  assert (hard_reg <= MAX_HARD_REG);
#ifndef _WIN32
  return !(hard_reg == BX_HARD_REG || (hard_reg >= R12_HARD_REG && hard_reg <= R15_HARD_REG));
#else
  return !(hard_reg == BX_HARD_REG || hard_reg == SI_HARD_REG || hard_reg == DI_HARD_REG
           || (hard_reg >= R12_HARD_REG && hard_reg <= R15_HARD_REG)
           || (hard_reg >= XMM6_HARD_REG && hard_reg <= XMM15_HARD_REG));
#endif
}

/* Stack layout (sp refers to the last reserved stack slot address)
   from higher address to lower address memory:

   | ...           |  prev func stack frame (start address should be aligned to 16 bytes)
   |---------------|
   | return pc     |  value of sp before prologue = start sp hard reg
   |---------------|
   | old bp        |  bp for previous func stack frame; new bp refers for here
   |---------------|
   |   reg save    |  176 bytes
   |     area      |  optional area for vararg func reg save area
   |---------------|
   | slots assigned|  can be absent for small functions (known only after RA)
   |   to pseudos  |
   |---------------|
   | saved regs    |  callee saved regs used in the func (known only after RA)
   |---------------|
   | alloca areas  |  optional
   |---------------|
   | slots for     |  dynamically allocated/deallocated by caller
   |  passing args |
   |---------------|
   |  spill space  |  WIN32 only, 32 bytes spill space for register args
   |---------------|

   size of slots and saved regs is multiple of 16 bytes

 */

#ifndef _WIN32
static const int reg_save_area_size = 176;
static const int spill_space_size = 0;
#else
static const int reg_save_area_size = 0;
static const int spill_space_size = 32;
#endif

static MIR_disp_t target_get_stack_slot_offset (gen_ctx_t gen_ctx, MIR_type_t type,
                                                MIR_reg_t slot) {
  /* slot is 0, 1, ... */
  return -((MIR_disp_t) (slot + (type == MIR_T_LD ? 2 : 1)) * 8
           + (curr_func_item->u.func->vararg_p ? reg_save_area_size : 0));
}

static const MIR_insn_code_t target_io_dup_op_insn_codes[] = {
  /* see possible patterns */
  MIR_FADD,  MIR_DADD,  MIR_LDADD, MIR_SUB,  MIR_SUBS,  MIR_FSUB,       MIR_DSUB,
  MIR_LDSUB, MIR_MUL,   MIR_MULS,  MIR_FMUL, MIR_DMUL,  MIR_LDMUL,      MIR_DIV,
  MIR_DIVS,  MIR_UDIV,  MIR_FDIV,  MIR_DDIV, MIR_LDDIV, MIR_MOD,        MIR_MODS,
  MIR_UMOD,  MIR_UMODS, MIR_AND,   MIR_ANDS, MIR_OR,    MIR_ORS,        MIR_XOR,
  MIR_XORS,  MIR_LSH,   MIR_LSHS,  MIR_RSH,  MIR_RSHS,  MIR_URSH,       MIR_URSHS,
  MIR_NEG,   MIR_NEGS,  MIR_FNEG,  MIR_DNEG, MIR_LDNEG, MIR_INSN_BOUND,
};

static MIR_insn_code_t get_ext_code (MIR_type_t type) {
  switch (type) {
  case MIR_T_I8: return MIR_EXT8;
  case MIR_T_U8: return MIR_UEXT8;
  case MIR_T_I16: return MIR_EXT16;
  case MIR_T_U16: return MIR_UEXT16;
  case MIR_T_I32: return MIR_EXT32;
  case MIR_T_U32: return MIR_UEXT32;
  default: return MIR_INVALID_INSN;
  }
}

static MIR_reg_t get_fp_arg_reg (size_t fp_arg_num) {
  switch (fp_arg_num) {
  case 0:
  case 1:
  case 2:
  case 3:
#ifndef _WIN32
  case 4:
  case 5:
  case 6:
  case 7:
#endif
    return XMM0_HARD_REG + fp_arg_num;
  default: return MIR_NON_HARD_REG;
  }
}

static MIR_reg_t get_int_arg_reg (size_t int_arg_num) {
  switch (int_arg_num
#ifdef _WIN32
          + 2
#endif
  ) {
  case 0: return DI_HARD_REG;
  case 1: return SI_HARD_REG;
#ifdef _WIN32
  case 2: return CX_HARD_REG;
  case 3: return DX_HARD_REG;
#else
  case 2: return DX_HARD_REG;
  case 3: return CX_HARD_REG;
#endif
  case 4: return R8_HARD_REG;
  case 5: return R9_HARD_REG;
  default: return MIR_NON_HARD_REG;
  }
}

#ifdef _WIN32
static int get_int_arg_reg_num (MIR_reg_t arg_reg) {
  switch (arg_reg) {
  case CX_HARD_REG: return 0;
  case DX_HARD_REG: return 1;
  case R8_HARD_REG: return 2;
  case R9_HARD_REG: return 3;
  default: assert (FALSE); return 0;
  }
}
#endif

static MIR_reg_t get_arg_reg (MIR_type_t arg_type, size_t *int_arg_num, size_t *fp_arg_num,
                              MIR_insn_code_t *mov_code) {
  MIR_reg_t arg_reg;

  if (arg_type == MIR_T_LD) {
    arg_reg = MIR_NON_HARD_REG;
    *mov_code = MIR_LDMOV;
  } else if (arg_type == MIR_T_F || arg_type == MIR_T_D) {
    arg_reg = get_fp_arg_reg (*fp_arg_num);
    (*fp_arg_num)++;
#ifdef _WIN32
    (*int_arg_num)++; /* arg slot used by fp, skip int register */
#endif
    *mov_code = arg_type == MIR_T_F ? MIR_FMOV : MIR_DMOV;
  } else { /* including RBLK */
    arg_reg = get_int_arg_reg (*int_arg_num);
#ifdef _WIN32
    (*fp_arg_num)++; /* arg slot used by int, skip fp register */
#endif
    (*int_arg_num)++;
    *mov_code = MIR_MOV;
  }
  return arg_reg;
}

static void gen_mov (gen_ctx_t gen_ctx, MIR_insn_t anchor, MIR_insn_code_t code, MIR_op_t dst_op,
                     MIR_op_t src_op) {
  gen_add_insn_before (gen_ctx, anchor, MIR_new_insn (gen_ctx->ctx, code, dst_op, src_op));
}

static void machinize_call (gen_ctx_t gen_ctx, MIR_insn_t call_insn) {
  MIR_context_t ctx = gen_ctx->ctx;
  MIR_func_t func = curr_func_item->u.func;
  MIR_proto_t proto = call_insn->ops[0].u.ref->u.proto;
  size_t size, nargs, nops = MIR_insn_nops (ctx, call_insn), start = proto->nres + 2;
  size_t int_arg_num = 0, fp_arg_num = 0, xmm_args = 0, arg_stack_size = spill_space_size;
#ifdef _WIN32
  size_t block_offset = spill_space_size;
#endif
  MIR_type_t type, mem_type;
  MIR_op_mode_t mode;
  MIR_var_t *arg_vars = NULL;
  MIR_reg_t arg_reg;
  MIR_op_t arg_op, new_arg_op, temp_op, ret_reg_op, mem_op;
  MIR_insn_code_t new_insn_code, ext_code;
  MIR_insn_t new_insn, prev_insn, next_insn, ext_insn;
  MIR_insn_t prev_call_insn = DLIST_PREV (MIR_insn_t, call_insn);
  uint32_t n_iregs, n_xregs, n_fregs;

  assert (prev_call_insn != NULL);
  if (call_insn->code == MIR_INLINE) call_insn->code = MIR_CALL;
  if (proto->args == NULL) {
    nargs = 0;
  } else {
    gen_assert (nops >= VARR_LENGTH (MIR_var_t, proto->args)
                && (proto->vararg_p || nops - start == VARR_LENGTH (MIR_var_t, proto->args)));
    nargs = VARR_LENGTH (MIR_var_t, proto->args);
    arg_vars = VARR_ADDR (MIR_var_t, proto->args);
  }
  if (call_insn->ops[1].mode != MIR_OP_REG && call_insn->ops[1].mode != MIR_OP_HARD_REG) {
    temp_op = MIR_new_reg_op (ctx, gen_new_temp_reg (gen_ctx, MIR_T_I64, func));
    new_insn = MIR_new_insn (ctx, MIR_MOV, temp_op, call_insn->ops[1]);
    call_insn->ops[1] = temp_op;
    gen_add_insn_before (gen_ctx, call_insn, new_insn);
  }
#ifdef _WIN32
  if ((nops - start) > 4) block_offset = (nops - start) * 8;
#endif
  for (size_t i = start; i < nops; i++) {
    arg_op = call_insn->ops[i];
    gen_assert (
      arg_op.mode == MIR_OP_REG || arg_op.mode == MIR_OP_HARD_REG
      || (arg_op.mode == MIR_OP_MEM && MIR_all_blk_type_p (arg_op.u.mem.type))
      || (arg_op.mode == MIR_OP_HARD_REG_MEM && MIR_all_blk_type_p (arg_op.u.hard_reg_mem.type)));
    if (i - start < nargs) {
      type = arg_vars[i - start].type;
    } else if (arg_op.mode == MIR_OP_MEM || arg_op.mode == MIR_OP_HARD_REG_MEM) {
      type = arg_op.mode == MIR_OP_MEM ? arg_op.u.mem.type : arg_op.u.hard_reg_mem.type;
      assert (MIR_all_blk_type_p (type));
    } else {
      mode = call_insn->ops[i].value_mode;  // ??? smaller ints
      gen_assert (mode == MIR_OP_INT || mode == MIR_OP_UINT || mode == MIR_OP_FLOAT
                  || mode == MIR_OP_DOUBLE || mode == MIR_OP_LDOUBLE);
      if (mode == MIR_OP_FLOAT)
        (*MIR_get_error_func (ctx)) (MIR_call_op_error,
                                     "passing float variadic arg (should be passed as double)");
      type = mode == MIR_OP_DOUBLE ? MIR_T_D : mode == MIR_OP_LDOUBLE ? MIR_T_LD : MIR_T_I64;
    }
    if (xmm_args < 8 && (type == MIR_T_F || type == MIR_T_D)) xmm_args++;
    ext_insn = NULL;
    if ((ext_code = get_ext_code (type)) != MIR_INVALID_INSN) { /* extend arg if necessary */
      temp_op = MIR_new_reg_op (ctx, gen_new_temp_reg (gen_ctx, MIR_T_I64, func));
      ext_insn = MIR_new_insn (ctx, ext_code, temp_op, arg_op);
      call_insn->ops[i] = arg_op = temp_op;
    }
    size = 0;
    if (MIR_blk_type_p (type)) {
      gen_assert (arg_op.mode == MIR_OP_MEM);
      size = (arg_op.u.mem.disp + 7) / 8 * 8;
      gen_assert (prev_call_insn != NULL); /* call_insn should not be 1st after simplification */
    }
#ifndef _WIN32
    if ((type == MIR_T_BLK + 1 && get_int_arg_reg (int_arg_num) != MIR_NON_HARD_REG
         && (size <= 8 || get_int_arg_reg (int_arg_num + 1) != MIR_NON_HARD_REG))
        || (type == MIR_T_BLK + 2 && get_fp_arg_reg (fp_arg_num) != MIR_NON_HARD_REG
            && (size <= 8 || get_fp_arg_reg (fp_arg_num + 1) != MIR_NON_HARD_REG))) {
      /* all is passed in gprs or fprs */
      MIR_type_t mov_type = type == MIR_T_BLK + 1 ? MIR_T_I64 : MIR_T_D;
      MIR_insn_code_t mov_code;
      MIR_reg_t reg2, reg1 = get_arg_reg (mov_type, &int_arg_num, &fp_arg_num, &mov_code);

      assert (size <= 16);
      new_insn = MIR_new_insn (ctx, mov_code, _MIR_new_hard_reg_op (ctx, reg1),
                               MIR_new_mem_op (ctx, mov_type, 0, arg_op.u.mem.base, 0, 1));
      gen_add_insn_before (gen_ctx, call_insn, new_insn);
      setup_call_hard_reg_args (gen_ctx, call_insn, reg1);
      call_insn->ops[i].u.mem.base = 0; /* not used anymore */
      if (size > 8) {
        reg2 = get_arg_reg (mov_type, &int_arg_num, &fp_arg_num, &mov_code);
        new_insn = MIR_new_insn (ctx, mov_code, _MIR_new_hard_reg_op (ctx, reg2),
                                 MIR_new_mem_op (ctx, mov_type, 8, arg_op.u.mem.base, 0, 1));
        gen_add_insn_before (gen_ctx, call_insn, new_insn);
        setup_call_hard_reg_args (gen_ctx, call_insn, reg2);
      }
      continue;
    } else if ((type == MIR_T_BLK + 3 || type == MIR_T_BLK + 4)
               && get_int_arg_reg (int_arg_num) != MIR_NON_HARD_REG
               && get_fp_arg_reg (fp_arg_num) != MIR_NON_HARD_REG) {
      /* gpr and then fpr or fpr and then gpr */
      MIR_type_t mov_type1 = type == MIR_T_BLK + 3 ? MIR_T_I64 : MIR_T_D;
      MIR_type_t mov_type2 = type == MIR_T_BLK + 3 ? MIR_T_D : MIR_T_I64;
      MIR_insn_code_t mov_code1, mov_code2;
      MIR_reg_t reg1 = get_arg_reg (mov_type1, &int_arg_num, &fp_arg_num, &mov_code1);
      MIR_reg_t reg2 = get_arg_reg (mov_type2, &int_arg_num, &fp_arg_num, &mov_code2);

      assert (size > 8 && size <= 16);
      new_insn = MIR_new_insn (ctx, mov_code1, _MIR_new_hard_reg_op (ctx, reg1),
                               MIR_new_mem_op (ctx, mov_type1, 0, arg_op.u.mem.base, 0, 1));
      setup_call_hard_reg_args (gen_ctx, call_insn, reg1);
      call_insn->ops[i].u.mem.base = 0; /* not used anymore */
      gen_add_insn_before (gen_ctx, call_insn, new_insn);
      new_insn = MIR_new_insn (ctx, mov_code2, _MIR_new_hard_reg_op (ctx, reg2),
                               MIR_new_mem_op (ctx, mov_type2, 8, arg_op.u.mem.base, 0, 1));
      gen_add_insn_before (gen_ctx, call_insn, new_insn);
      setup_call_hard_reg_args (gen_ctx, call_insn, reg2);
      continue;
    }
#endif
    if (MIR_blk_type_p (type)) { /* put block arg on the stack */
      MIR_insn_t load_insn;
      size_t disp, dest_disp, start_dest_disp;
      int first_p, by_val_p = FALSE;

#ifdef _WIN32
      by_val_p = size <= 8;
#endif
      if (by_val_p) {
        temp_op = MIR_new_reg_op (ctx, gen_new_temp_reg (gen_ctx, MIR_T_I64, func));
        mem_op = MIR_new_mem_op (ctx, MIR_T_I64, 0, arg_op.u.mem.base, 0, 1);
        load_insn = MIR_new_insn (ctx, MIR_MOV, temp_op, mem_op);
        gen_add_insn_after (gen_ctx, prev_call_insn, load_insn);
        arg_op = temp_op;
      } else if (size > 0 && size <= 2 * 8) { /* upto 2 moves */
        disp = 0;
        first_p = TRUE;
        temp_op = MIR_new_reg_op (ctx, gen_new_temp_reg (gen_ctx, MIR_T_I64, func));
        while (size != 0) {
          mem_op = MIR_new_mem_op (ctx, MIR_T_I64, disp, arg_op.u.mem.base, 0, 1);
          load_insn = MIR_new_insn (ctx, MIR_MOV, temp_op, mem_op);
          gen_add_insn_after (gen_ctx, prev_call_insn, load_insn);
          disp += 8;
#ifdef _WIN32
          dest_disp = block_offset;
          if (first_p) start_dest_disp = dest_disp;
          block_offset += 8;
#else
          dest_disp = arg_stack_size;
          arg_stack_size += 8;
#endif
          mem_op = _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, dest_disp, SP_HARD_REG,
                                             MIR_NON_HARD_REG, 1);
          new_insn = MIR_new_insn (ctx, MIR_MOV, mem_op, temp_op);
          size -= 8;
          gen_add_insn_after (gen_ctx, load_insn, new_insn);
          if (first_p) {
            call_insn->ops[i]
              = _MIR_new_hard_reg_mem_op (ctx, type, dest_disp, SP_HARD_REG, MIR_NON_HARD_REG, 1);
            first_p = FALSE;
          }
        }
#ifdef _WIN32
        arg_op
          = MIR_new_reg_op (ctx, gen_new_temp_reg (gen_ctx, MIR_T_I64, curr_func_item->u.func));
        new_insn = MIR_new_insn (ctx, MIR_ADD, arg_op, _MIR_new_hard_reg_op (ctx, SP_HARD_REG),
                                 MIR_new_int_op (ctx, start_dest_disp));
        gen_add_insn_before (gen_ctx, call_insn, new_insn);
#endif
      } else { /* generate memcpy call before call arg moves */
        MIR_reg_t dest_reg;
        MIR_op_t freg_op, dest_reg_op, ops[5];
        MIR_item_t memcpy_proto_item
          = _MIR_builtin_proto (ctx, curr_func_item->module, "mir.arg_memcpy.p", 0, NULL, 3,
                                MIR_T_I64, "dest", MIR_T_I64, "src", MIR_T_I64, "n");
        MIR_item_t memcpy_import_item
          = _MIR_builtin_func (ctx, curr_func_item->module, "mir.arg_memcpy", memcpy);
        freg_op
          = MIR_new_reg_op (ctx, gen_new_temp_reg (gen_ctx, MIR_T_I64, curr_func_item->u.func));
        dest_reg = gen_new_temp_reg (gen_ctx, MIR_T_I64, curr_func_item->u.func);
        dest_reg_op = MIR_new_reg_op (ctx, dest_reg);
        ops[0] = MIR_new_ref_op (ctx, memcpy_proto_item);
        ops[1] = freg_op;
        ops[2] = _MIR_new_hard_reg_op (ctx, get_int_arg_reg (0));
        ops[3] = _MIR_new_hard_reg_op (ctx, get_int_arg_reg (1));
        ops[4] = _MIR_new_hard_reg_op (ctx, get_int_arg_reg (2));
        new_insn = MIR_new_insn_arr (ctx, MIR_CALL, 5, ops);
        gen_add_insn_after (gen_ctx, prev_call_insn, new_insn);
        new_insn = MIR_new_insn (ctx, MIR_MOV, ops[4], MIR_new_int_op (ctx, size));
        gen_add_insn_after (gen_ctx, prev_call_insn, new_insn);
        new_insn = MIR_new_insn (ctx, MIR_MOV, ops[3], MIR_new_reg_op (ctx, arg_op.u.mem.base));
        gen_add_insn_after (gen_ctx, prev_call_insn, new_insn);
        new_insn = MIR_new_insn (ctx, MIR_MOV, ops[2], dest_reg_op);
        gen_add_insn_after (gen_ctx, prev_call_insn, new_insn);
#ifdef _WIN32
        start_dest_disp = block_offset;
        block_offset += size;
#else
        start_dest_disp = arg_stack_size;
        arg_stack_size += size;
#endif
        new_insn = MIR_new_insn (ctx, MIR_ADD, dest_reg_op, _MIR_new_hard_reg_op (ctx, SP_HARD_REG),
                                 MIR_new_int_op (ctx, start_dest_disp));
        gen_add_insn_after (gen_ctx, prev_call_insn, new_insn);
        new_insn = MIR_new_insn (ctx, MIR_MOV, ops[1], MIR_new_ref_op (ctx, memcpy_import_item));
        gen_add_insn_after (gen_ctx, prev_call_insn, new_insn);
        call_insn->ops[i] = MIR_new_mem_op (ctx, MIR_T_BLK, arg_op.u.mem.disp, dest_reg, 0, 1);
#ifdef _WIN32
        arg_op = dest_reg_op;
#endif
      }
#ifdef _WIN32
      if ((arg_reg = get_arg_reg (MIR_T_P, &int_arg_num, &fp_arg_num, &new_insn_code))
          != MIR_NON_HARD_REG) {
        new_arg_op = _MIR_new_hard_reg_op (ctx, arg_reg);
        new_insn = MIR_new_insn (ctx, MIR_MOV, new_arg_op, arg_op);
        call_insn->ops[i] = new_arg_op;
      } else {
        mem_op = _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, arg_stack_size, SP_HARD_REG,
                                           MIR_NON_HARD_REG, 1);
        new_insn = MIR_new_insn (ctx, MIR_MOV, mem_op, arg_op);
        call_insn->ops[i] = mem_op;
        arg_stack_size += 8;
      }
      gen_add_insn_before (gen_ctx, call_insn, new_insn);
#endif
    } else if ((arg_reg = get_arg_reg (type, &int_arg_num, &fp_arg_num, &new_insn_code))
               != MIR_NON_HARD_REG) {
      /* put arguments to argument hard regs */
      if (ext_insn != NULL) gen_add_insn_before (gen_ctx, call_insn, ext_insn);
      if (type != MIR_T_RBLK) {
        new_arg_op = _MIR_new_hard_reg_op (ctx, arg_reg);
        new_insn = MIR_new_insn (ctx, new_insn_code, new_arg_op, arg_op);
      } else if (arg_op.mode == MIR_OP_MEM) {
        new_insn = MIR_new_insn (ctx, new_insn_code, _MIR_new_hard_reg_op (ctx, arg_reg),
                                 MIR_new_reg_op (ctx, arg_op.u.mem.base));
        new_arg_op = _MIR_new_hard_reg_mem_op (ctx, MIR_T_RBLK, arg_op.u.mem.disp, arg_reg,
                                               MIR_NON_HARD_REG, 1);
      } else {
        assert (arg_op.mode == MIR_OP_HARD_REG_MEM);
        new_insn = MIR_new_insn (ctx, new_insn_code, _MIR_new_hard_reg_op (ctx, arg_reg),
                                 _MIR_new_hard_reg_op (ctx, arg_op.u.hard_reg_mem.base));
        new_arg_op = _MIR_new_hard_reg_mem_op (ctx, MIR_T_RBLK, arg_op.u.hard_reg_mem.disp, arg_reg,
                                               MIR_NON_HARD_REG, 1);
      }
      gen_add_insn_before (gen_ctx, call_insn, new_insn);
      call_insn->ops[i] = new_arg_op;
#ifdef _WIN32
      /* copy fp reg varargs into corresponding int regs */
      if (proto->vararg_p && type == MIR_T_D) {
        gen_assert (int_arg_num > 0 && int_arg_num <= 4);
        arg_reg = get_int_arg_reg (int_arg_num - 1);
        setup_call_hard_reg_args (gen_ctx, call_insn, arg_reg);
        /* mir does not support moving fp to int regs directly, spill and load them instead */
        mem_op = _MIR_new_hard_reg_mem_op (ctx, MIR_T_D, 8, SP_HARD_REG, MIR_NON_HARD_REG, 1);
        new_insn = MIR_new_insn (ctx, MIR_DMOV, mem_op, arg_op);
        gen_add_insn_before (gen_ctx, call_insn, new_insn);
        mem_op = _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, 8, SP_HARD_REG, MIR_NON_HARD_REG, 1);
        new_insn = MIR_new_insn (ctx, MIR_MOV, _MIR_new_hard_reg_op (ctx, arg_reg), mem_op);
        gen_add_insn_before (gen_ctx, call_insn, new_insn);
      }
#endif
    } else { /* put arguments on the stack */
      if (type == MIR_T_RBLK) {
        assert (arg_op.mode == MIR_OP_MEM || arg_op.mode == MIR_OP_HARD_REG_MEM);
        arg_op = arg_op.mode == MIR_OP_MEM ? MIR_new_reg_op (ctx, arg_op.u.mem.base)
                                           : _MIR_new_hard_reg_op (ctx, arg_op.u.hard_reg_mem.base);
      }
      mem_type = type == MIR_T_F || type == MIR_T_D || type == MIR_T_LD ? type : MIR_T_I64;
      new_insn_code = (type == MIR_T_F    ? MIR_FMOV
                       : type == MIR_T_D  ? MIR_DMOV
                       : type == MIR_T_LD ? MIR_LDMOV
                                          : MIR_MOV);
      mem_op = _MIR_new_hard_reg_mem_op (ctx, mem_type, arg_stack_size, SP_HARD_REG,
                                         MIR_NON_HARD_REG, 1);
      new_insn = MIR_new_insn (ctx, new_insn_code, mem_op, arg_op);
      gen_assert (prev_call_insn != NULL); /* call_insn should not be 1st after simplification */
      MIR_insert_insn_after (ctx, curr_func_item, prev_call_insn, new_insn);
      prev_insn = DLIST_PREV (MIR_insn_t, new_insn);
      next_insn = DLIST_NEXT (MIR_insn_t, new_insn);
      create_new_bb_insns (gen_ctx, prev_insn, next_insn, call_insn);
      call_insn->ops[i] = mem_op;
#ifdef _WIN32
      arg_stack_size += 8;
#else
      arg_stack_size += type == MIR_T_LD ? 16 : 8;
#endif
      if (ext_insn != NULL) gen_add_insn_after (gen_ctx, prev_call_insn, ext_insn);
    }
  }
#ifndef _WIN32
  if (proto->vararg_p) {
    setup_call_hard_reg_args (gen_ctx, call_insn, AX_HARD_REG);
    new_insn = MIR_new_insn (ctx, MIR_MOV, _MIR_new_hard_reg_op (ctx, AX_HARD_REG),
                             MIR_new_int_op (ctx, xmm_args));
    gen_add_insn_before (gen_ctx, call_insn, new_insn);
  }
#else
  if (proto->nres > 1)
    (*MIR_get_error_func (ctx)) (MIR_ret_error,
                                 "Windows x86-64 doesn't support multiple return values");
#endif
  n_iregs = n_xregs = n_fregs = 0;
  for (size_t i = 0; i < proto->nres; i++) {
    ret_reg_op = call_insn->ops[i + 2];
    gen_assert (ret_reg_op.mode == MIR_OP_REG || ret_reg_op.mode == MIR_OP_HARD_REG);
    if (proto->res_types[i] == MIR_T_F && n_xregs < 2) {
      new_insn
        = MIR_new_insn (ctx, MIR_FMOV, ret_reg_op,
                        _MIR_new_hard_reg_op (ctx, n_xregs == 0 ? XMM0_HARD_REG : XMM1_HARD_REG));
      n_xregs++;
    } else if (proto->res_types[i] == MIR_T_D && n_xregs < 2) {
      new_insn
        = MIR_new_insn (ctx, MIR_DMOV, ret_reg_op,
                        _MIR_new_hard_reg_op (ctx, n_xregs == 0 ? XMM0_HARD_REG : XMM1_HARD_REG));
      n_xregs++;
    } else if (proto->res_types[i] == MIR_T_LD && n_fregs < 2) {
      new_insn
        = MIR_new_insn (ctx, MIR_LDMOV, ret_reg_op,
                        _MIR_new_hard_reg_op (ctx, n_fregs == 0 ? ST0_HARD_REG : ST1_HARD_REG));
      n_fregs++;
    } else if (n_iregs < 2) {
      new_insn
        = MIR_new_insn (ctx, MIR_MOV, ret_reg_op,
                        _MIR_new_hard_reg_op (ctx, n_iregs == 0 ? AX_HARD_REG : DX_HARD_REG));
      n_iregs++;
    } else {
      (*MIR_get_error_func (ctx)) (MIR_ret_error,
                                   "x86-64 can not handle this combination of return values");
    }
    MIR_insert_insn_after (ctx, curr_func_item, call_insn, new_insn);
    call_insn->ops[i + 2] = new_insn->ops[1];
    if ((ext_code = get_ext_code (proto->res_types[i])) != MIR_INVALID_INSN) {
      MIR_insert_insn_after (ctx, curr_func_item, new_insn,
                             MIR_new_insn (ctx, ext_code, ret_reg_op, ret_reg_op));
      new_insn = DLIST_NEXT (MIR_insn_t, new_insn);
    }
    create_new_bb_insns (gen_ctx, call_insn, DLIST_NEXT (MIR_insn_t, new_insn), call_insn);
  }
#ifdef _WIN32
  if (block_offset > arg_stack_size) arg_stack_size = block_offset;
#endif
  if (arg_stack_size != 0) { /* allocate/deallocate stack for args passed on stack */
    arg_stack_size = (arg_stack_size + 15) / 16 * 16; /* make it of several 16 bytes */
    new_insn = MIR_new_insn (ctx, MIR_SUB, _MIR_new_hard_reg_op (ctx, SP_HARD_REG),
                             _MIR_new_hard_reg_op (ctx, SP_HARD_REG),
                             MIR_new_int_op (ctx, arg_stack_size));
    MIR_insert_insn_after (ctx, curr_func_item, prev_call_insn, new_insn);
    next_insn = DLIST_NEXT (MIR_insn_t, new_insn);
    create_new_bb_insns (gen_ctx, prev_call_insn, next_insn, call_insn);
    new_insn = MIR_new_insn (ctx, MIR_ADD, _MIR_new_hard_reg_op (ctx, SP_HARD_REG),
                             _MIR_new_hard_reg_op (ctx, SP_HARD_REG),
                             MIR_new_int_op (ctx, arg_stack_size));
    MIR_insert_insn_after (ctx, curr_func_item, call_insn, new_insn);
    next_insn = DLIST_NEXT (MIR_insn_t, new_insn);
    create_new_bb_insns (gen_ctx, call_insn, next_insn, call_insn);
  }
}

static float mir_ui2f (uint64_t i) { return i; }
static double mir_ui2d (uint64_t i) { return i; }
static long double mir_ui2ld (uint64_t i) { return i; }
static int64_t mir_ld2i (long double ld) { return ld; }
static const char *UI2F = "mir.ui2f";
static const char *UI2D = "mir.ui2d";
static const char *UI2LD = "mir.ui2ld";
static const char *LD2I = "mir.ld2i";
static const char *UI2F_P = "mir.ui2f.p";
static const char *UI2D_P = "mir.ui2d.p";
static const char *UI2LD_P = "mir.ui2ld.p";
static const char *LD2I_P = "mir.ld2i.p";

static const char *VA_ARG_P = "mir.va_arg.p";
static const char *VA_ARG = "mir.va_arg";
static const char *VA_BLOCK_ARG_P = "mir.va_block_arg.p";
static const char *VA_BLOCK_ARG = "mir.va_block_arg";

static void get_builtin (gen_ctx_t gen_ctx, MIR_insn_code_t code, MIR_item_t *proto_item,
                         MIR_item_t *func_import_item) {
  MIR_context_t ctx = gen_ctx->ctx;
  MIR_type_t res_type;

  *func_import_item = *proto_item = NULL; /* to remove uninitialized warning */
  switch (code) {
  case MIR_UI2F:
    res_type = MIR_T_F;
    *proto_item
      = _MIR_builtin_proto (ctx, curr_func_item->module, UI2F_P, 1, &res_type, 1, MIR_T_I64, "v");
    *func_import_item = _MIR_builtin_func (ctx, curr_func_item->module, UI2F, mir_ui2f);
    break;
  case MIR_UI2D:
    res_type = MIR_T_D;
    *proto_item
      = _MIR_builtin_proto (ctx, curr_func_item->module, UI2D_P, 1, &res_type, 1, MIR_T_I64, "v");
    *func_import_item = _MIR_builtin_func (ctx, curr_func_item->module, UI2D, mir_ui2d);
    break;
  case MIR_UI2LD:
    res_type = MIR_T_LD;
    *proto_item
      = _MIR_builtin_proto (ctx, curr_func_item->module, UI2LD_P, 1, &res_type, 1, MIR_T_I64, "v");
    *func_import_item = _MIR_builtin_func (ctx, curr_func_item->module, UI2LD, mir_ui2ld);
    break;
  case MIR_LD2I:
    res_type = MIR_T_I64;
    *proto_item
      = _MIR_builtin_proto (ctx, curr_func_item->module, LD2I_P, 1, &res_type, 1, MIR_T_LD, "v");
    *func_import_item = _MIR_builtin_func (ctx, curr_func_item->module, LD2I, mir_ld2i);
    break;
  case MIR_VA_ARG:
    res_type = MIR_T_I64;
    *proto_item = _MIR_builtin_proto (ctx, curr_func_item->module, VA_ARG_P, 1, &res_type, 2,
                                      MIR_T_I64, "va", MIR_T_I64, "type");
    *func_import_item = _MIR_builtin_func (ctx, curr_func_item->module, VA_ARG, va_arg_builtin);
    break;
  case MIR_VA_BLOCK_ARG:
    *proto_item
      = _MIR_builtin_proto (ctx, curr_func_item->module, VA_BLOCK_ARG_P, 0, NULL, 4, MIR_T_I64,
                            "res", MIR_T_I64, "va", MIR_T_I64, "size", MIR_T_I64, "ncase");
    *func_import_item
      = _MIR_builtin_func (ctx, curr_func_item->module, VA_BLOCK_ARG, va_block_arg_builtin);
    break;
  default: assert (FALSE);
  }
}

DEF_VARR (int);
DEF_VARR (uint8_t);
DEF_VARR (uint64_t);

struct insn_pattern_info {
  int start, num;
};

typedef struct insn_pattern_info insn_pattern_info_t;

DEF_VARR (insn_pattern_info_t);

struct const_ref {
  size_t pc;             /* where rel32 address should be in code */
  size_t next_insn_disp; /* displacement of the next insn */
  size_t const_num;
};

typedef struct const_ref const_ref_t;
DEF_VARR (const_ref_t);

struct label_ref {
  int abs_addr_p;
  size_t label_val_disp, next_insn_disp;
  MIR_label_t label;
};

typedef struct label_ref label_ref_t;
DEF_VARR (label_ref_t);

DEF_VARR (MIR_code_reloc_t);

#define MOVDQA_CODE 0

struct target_ctx {
  unsigned char alloca_p, block_arg_func_p, leaf_p;
  int start_sp_from_bp_offset;
  VARR (int) * pattern_indexes;
  VARR (insn_pattern_info_t) * insn_pattern_info;
  VARR (uint8_t) * result_code;
  VARR (uint64_t) * const_pool;
  VARR (const_ref_t) * const_refs;
  VARR (label_ref_t) * label_refs;
  VARR (uint64_t) * abs_address_locs;
  VARR (MIR_code_reloc_t) * relocs;
};

#define alloca_p gen_ctx->target_ctx->alloca_p
#define block_arg_func_p gen_ctx->target_ctx->block_arg_func_p
#define leaf_p gen_ctx->target_ctx->leaf_p
#define start_sp_from_bp_offset gen_ctx->target_ctx->start_sp_from_bp_offset
#define pattern_indexes gen_ctx->target_ctx->pattern_indexes
#define insn_pattern_info gen_ctx->target_ctx->insn_pattern_info
#define result_code gen_ctx->target_ctx->result_code
#define const_pool gen_ctx->target_ctx->const_pool
#define const_refs gen_ctx->target_ctx->const_refs
#define label_refs gen_ctx->target_ctx->label_refs
#define abs_address_locs gen_ctx->target_ctx->abs_address_locs
#define relocs gen_ctx->target_ctx->relocs

static void prepend_insn (gen_ctx_t gen_ctx, MIR_insn_t new_insn) {
  MIR_prepend_insn (gen_ctx->ctx, curr_func_item, new_insn);
  create_new_bb_insns (gen_ctx, NULL, DLIST_NEXT (MIR_insn_t, new_insn), NULL);
}

static int target_valid_mem_offset_p (gen_ctx_t gen_ctx, MIR_type_t type, MIR_disp_t offset) {
  return TRUE;
}

#define SWAP(v1, v2, t) \
  do {                  \
    t = v1;             \
    v1 = v2;            \
    v2 = t;             \
  } while (0)

static void target_machinize (gen_ctx_t gen_ctx) {
  MIR_context_t ctx = gen_ctx->ctx;
  MIR_func_t func;
  MIR_type_t type, mem_type, res_type;
  MIR_insn_code_t code, new_insn_code;
  MIR_insn_t insn, next_insn, new_insn;
  MIR_reg_t ret_reg, arg_reg;
  MIR_op_t ret_reg_op, arg_reg_op, mem_op, temp_op;
  size_t i, blk_size, int_arg_num = 0, fp_arg_num = 0, mem_size = spill_space_size;

  assert (curr_func_item->item_type == MIR_func_item);
  func = curr_func_item->u.func;
  block_arg_func_p = FALSE;
  start_sp_from_bp_offset = 8;
  for (i = 0; i < func->nargs; i++) {
    /* Argument extensions is already done in simplify */
    /* Prologue: generate arg_var = hard_reg|stack mem|stack addr ... */
    type = VARR_GET (MIR_var_t, func->vars, i).type;
    blk_size = MIR_blk_type_p (type) ? (VARR_GET (MIR_var_t, func->vars, i).size + 7) / 8 * 8 : 0;
#ifndef _WIN32
    if ((type == MIR_T_BLK + 1 && get_int_arg_reg (int_arg_num) != MIR_NON_HARD_REG
         && (blk_size <= 8 || get_int_arg_reg (int_arg_num + 1) != MIR_NON_HARD_REG))
        || (type == MIR_T_BLK + 2 && get_fp_arg_reg (fp_arg_num) != MIR_NON_HARD_REG
            && (blk_size <= 8 || get_fp_arg_reg (fp_arg_num + 1) != MIR_NON_HARD_REG))) {
      /* all is passed in gprs or fprs */
      MIR_type_t mov_type = type == MIR_T_BLK + 1 ? MIR_T_I64 : MIR_T_D;
      MIR_insn_code_t mov_code1, mov_code2;
      MIR_reg_t reg2, reg1 = get_arg_reg (mov_type, &int_arg_num, &fp_arg_num, &mov_code1);

      assert (blk_size <= 16);
      if (blk_size > 8) {
        reg2 = get_arg_reg (mov_type, &int_arg_num, &fp_arg_num, &mov_code2);
        new_insn = MIR_new_insn (ctx, mov_code1, MIR_new_mem_op (ctx, mov_type, 8, i + 1, 0, 1),
                                 _MIR_new_hard_reg_op (ctx, reg2));
        prepend_insn (gen_ctx, new_insn);
      }
      new_insn = MIR_new_insn (ctx, mov_code1, MIR_new_mem_op (ctx, mov_type, 0, i + 1, 0, 1),
                               _MIR_new_hard_reg_op (ctx, reg1));
      prepend_insn (gen_ctx, new_insn);
      new_insn = MIR_new_insn (ctx, MIR_ALLOCA, MIR_new_reg_op (ctx, i + 1),
                               MIR_new_int_op (ctx, blk_size));
      prepend_insn (gen_ctx, new_insn);
      continue;
    } else if ((type == MIR_T_BLK + 3 || type == MIR_T_BLK + 4)
               && get_int_arg_reg (int_arg_num) != MIR_NON_HARD_REG
               && get_fp_arg_reg (fp_arg_num) != MIR_NON_HARD_REG) {
      /* gpr and then fpr or fpr and then gpr */
      MIR_type_t mov_type1 = type == MIR_T_BLK + 3 ? MIR_T_I64 : MIR_T_D;
      MIR_type_t mov_type2 = type == MIR_T_BLK + 3 ? MIR_T_D : MIR_T_I64;
      MIR_insn_code_t mov_code1, mov_code2;
      MIR_reg_t reg1 = get_arg_reg (mov_type1, &int_arg_num, &fp_arg_num, &mov_code1);
      MIR_reg_t reg2 = get_arg_reg (mov_type2, &int_arg_num, &fp_arg_num, &mov_code2);

      assert (blk_size > 8 && blk_size <= 16);
      new_insn = MIR_new_insn (ctx, mov_code2, MIR_new_mem_op (ctx, mov_type2, 8, i + 1, 0, 1),
                               _MIR_new_hard_reg_op (ctx, reg2));
      prepend_insn (gen_ctx, new_insn);
      new_insn = MIR_new_insn (ctx, mov_code1, MIR_new_mem_op (ctx, mov_type1, 0, i + 1, 0, 1),
                               _MIR_new_hard_reg_op (ctx, reg1));
      prepend_insn (gen_ctx, new_insn);
      new_insn = MIR_new_insn (ctx, MIR_ALLOCA, MIR_new_reg_op (ctx, i + 1),
                               MIR_new_int_op (ctx, blk_size));
      prepend_insn (gen_ctx, new_insn);
      continue;
    }
#endif
    int blk_p = MIR_blk_type_p (type);
#ifdef _WIN32
    if (blk_p && blk_size > 8) { /* just address */
      blk_p = FALSE;
      type = MIR_T_I64;
    }
#endif
    if (blk_p) {
      block_arg_func_p = TRUE;
#ifdef _WIN32
      assert (blk_size <= 8);
      if ((arg_reg = get_arg_reg (MIR_T_I64, &int_arg_num, &fp_arg_num, &new_insn_code))
          == MIR_NON_HARD_REG) {
        new_insn = MIR_new_insn (ctx, MIR_ADD, MIR_new_reg_op (ctx, i + 1),
                                 _MIR_new_hard_reg_op (ctx, FP_HARD_REG),
                                 MIR_new_int_op (ctx, mem_size + 8 /* ret */
                                                        + start_sp_from_bp_offset));
        mem_size += 8;
      } else { /* put reg into spill space and use its address: prepend in reverse order:  */
        int disp = (mem_size + 8 /* ret */ + start_sp_from_bp_offset - spill_space_size
                    + 8 * get_int_arg_reg_num (arg_reg));
        new_insn
          = MIR_new_insn (ctx, MIR_ADD, MIR_new_reg_op (ctx, i + 1),
                          _MIR_new_hard_reg_op (ctx, FP_HARD_REG), MIR_new_int_op (ctx, disp));
        prepend_insn (gen_ctx, new_insn);
        arg_reg_op = _MIR_new_hard_reg_op (ctx, arg_reg);
        mem_op = _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, disp, FP_HARD_REG, MIR_NON_HARD_REG, 1);
        new_insn = MIR_new_insn (ctx, MIR_MOV, mem_op, arg_reg_op);
      }
#else
      new_insn = MIR_new_insn (ctx, MIR_ADD, MIR_new_reg_op (ctx, i + 1),
                               _MIR_new_hard_reg_op (ctx, FP_HARD_REG),
                               MIR_new_int_op (ctx, mem_size + 8 /* ret addr */
                                                      + start_sp_from_bp_offset));
      mem_size += blk_size;
#endif
      prepend_insn (gen_ctx, new_insn);
    } else if ((arg_reg = get_arg_reg (type, &int_arg_num, &fp_arg_num, &new_insn_code))
               != MIR_NON_HARD_REG) {
      arg_reg_op = _MIR_new_hard_reg_op (ctx, arg_reg);
      new_insn = MIR_new_insn (ctx, new_insn_code, MIR_new_reg_op (ctx, i + 1), arg_reg_op);
      prepend_insn (gen_ctx, new_insn);
    } else {
      /* arg is on the stack */
      block_arg_func_p = TRUE;
      mem_type = type == MIR_T_F || type == MIR_T_D || type == MIR_T_LD ? type : MIR_T_I64;
      new_insn_code = (type == MIR_T_F    ? MIR_FMOV
                       : type == MIR_T_D  ? MIR_DMOV
                       : type == MIR_T_LD ? MIR_LDMOV
                                          : MIR_MOV);
      mem_op = _MIR_new_hard_reg_mem_op (ctx, mem_type,
                                         mem_size + 8 /* ret */
                                           + start_sp_from_bp_offset,
                                         FP_HARD_REG, MIR_NON_HARD_REG, 1);
      new_insn = MIR_new_insn (ctx, new_insn_code, MIR_new_reg_op (ctx, i + 1), mem_op);
      prepend_insn (gen_ctx, new_insn);
      mem_size += type == MIR_T_LD ? 16 : 8;
    }
  }
  alloca_p = FALSE;
  leaf_p = TRUE;
  for (insn = DLIST_HEAD (MIR_insn_t, func->insns); insn != NULL; insn = next_insn) {
    next_insn = DLIST_NEXT (MIR_insn_t, insn);
    code = insn->code;
    switch (code) {
    case MIR_UI2F:
    case MIR_UI2D:
    case MIR_UI2LD:
    case MIR_LD2I: {
      /* Use a builtin func call: mov freg, func ref; call proto, freg, res_reg, op_reg */
      MIR_item_t proto_item, func_import_item;
      MIR_op_t freg_op, res_reg_op = insn->ops[0], op_reg_op = insn->ops[1], ops[4];

      get_builtin (gen_ctx, code, &proto_item, &func_import_item);
      assert (res_reg_op.mode == MIR_OP_REG && op_reg_op.mode == MIR_OP_REG);
      freg_op = MIR_new_reg_op (ctx, gen_new_temp_reg (gen_ctx, MIR_T_I64, curr_func_item->u.func));
      next_insn = new_insn
        = MIR_new_insn (ctx, MIR_MOV, freg_op, MIR_new_ref_op (ctx, func_import_item));
      gen_add_insn_before (gen_ctx, insn, new_insn);
      ops[0] = MIR_new_ref_op (ctx, proto_item);
      ops[1] = freg_op;
      ops[2] = res_reg_op;
      ops[3] = op_reg_op;
      new_insn = MIR_new_insn_arr (ctx, MIR_CALL, 4, ops);
      gen_add_insn_before (gen_ctx, insn, new_insn);
      gen_delete_insn (gen_ctx, insn);
      break;
    }
    case MIR_VA_START: {
      MIR_op_t treg_op
        = MIR_new_reg_op (ctx, gen_new_temp_reg (gen_ctx, MIR_T_I64, curr_func_item->u.func));
      MIR_op_t va_op = insn->ops[0];
      MIR_reg_t va_reg;
#ifndef _WIN32
      int gp_offset = 0, fp_offset = 48, mem_offset = 0;
      MIR_var_t var;

      assert (func->vararg_p && (va_op.mode == MIR_OP_REG || va_op.mode == MIR_OP_HARD_REG));
      for (uint32_t i = 0; i < func->nargs; i++) {
        var = VARR_GET (MIR_var_t, func->vars, i);
        if (var.type == MIR_T_F || var.type == MIR_T_D) {
          fp_offset += 16;
          if (gp_offset >= 176) mem_offset += 8;
        } else if (var.type == MIR_T_LD) {
          mem_offset += 16;
        } else if (MIR_blk_type_p (var.type)) {
          mem_offset += var.size;
        } else { /* including RBLK */
          gp_offset += 8;
          if (gp_offset >= 48) mem_offset += 8;
        }
      }
      va_reg = va_op.mode == MIR_OP_REG ? va_op.u.reg : va_op.u.hard_reg;
      /* Insns can be not simplified as soon as they match a machine insn.  */
      /* mem32[va_reg] = gp_offset; mem32[va_reg] = fp_offset */
      gen_mov (gen_ctx, insn, MIR_MOV, MIR_new_mem_op (ctx, MIR_T_U32, 0, va_reg, 0, 1),
               MIR_new_int_op (ctx, gp_offset));
      next_insn = DLIST_PREV (MIR_insn_t, insn);
      gen_mov (gen_ctx, insn, MIR_MOV, MIR_new_mem_op (ctx, MIR_T_U32, 4, va_reg, 0, 1),
               MIR_new_int_op (ctx, fp_offset));
      /* overflow_arg_area_reg: treg = start sp + 8 + mem_offset; mem64[va_reg + 8] = treg */
      new_insn
        = MIR_new_insn (ctx, MIR_ADD, treg_op, _MIR_new_hard_reg_op (ctx, FP_HARD_REG),
                        MIR_new_int_op (ctx, 8 /*ret*/ + mem_offset + start_sp_from_bp_offset));
      gen_add_insn_before (gen_ctx, insn, new_insn);
      gen_mov (gen_ctx, insn, MIR_MOV, MIR_new_mem_op (ctx, MIR_T_I64, 8, va_reg, 0, 1), treg_op);
      /* reg_save_area: treg = start sp - reg_save_area_size; mem64[va_reg + 16] = treg */
      new_insn = MIR_new_insn (ctx, MIR_ADD, treg_op, _MIR_new_hard_reg_op (ctx, FP_HARD_REG),
                               MIR_new_int_op (ctx, -reg_save_area_size));
      gen_add_insn_before (gen_ctx, insn, new_insn);
      gen_mov (gen_ctx, insn, MIR_MOV, MIR_new_mem_op (ctx, MIR_T_I64, 16, va_reg, 0, 1), treg_op);
#else
      /* init va_list */
      mem_size = 8 /*ret*/ + start_sp_from_bp_offset + func->nargs * 8;
      new_insn = MIR_new_insn (ctx, MIR_ADD, treg_op, _MIR_new_hard_reg_op (ctx, FP_HARD_REG),
                               MIR_new_int_op (ctx, mem_size));
      gen_add_insn_before (gen_ctx, insn, new_insn);
      va_reg = va_op.mode == MIR_OP_REG ? va_op.u.reg : va_op.u.hard_reg;
      gen_mov (gen_ctx, insn, MIR_MOV, MIR_new_mem_op (ctx, MIR_T_I64, 0, va_reg, 0, 1), treg_op);
#endif
      gen_delete_insn (gen_ctx, insn);
      break;
    }
    case MIR_VA_END: /* do nothing */ gen_delete_insn (gen_ctx, insn); break;
    case MIR_VA_ARG:
    case MIR_VA_BLOCK_ARG: {
      /* Use a builtin func call:
         mov func_reg, func ref; [mov reg3, type;] call proto, func_reg, res_reg, va_reg,
         reg3 */
      MIR_item_t proto_item, func_import_item;
      MIR_op_t ops[6], func_reg_op, reg_op3;
      MIR_op_t res_reg_op = insn->ops[0], va_reg_op = insn->ops[1], op3 = insn->ops[2];

      get_builtin (gen_ctx, code, &proto_item, &func_import_item);
      assert (res_reg_op.mode == MIR_OP_REG && va_reg_op.mode == MIR_OP_REG
              && op3.mode == (code == MIR_VA_ARG ? MIR_OP_MEM : MIR_OP_REG));
      func_reg_op = MIR_new_reg_op (ctx, gen_new_temp_reg (gen_ctx, MIR_T_I64, func));
      reg_op3 = MIR_new_reg_op (ctx, gen_new_temp_reg (gen_ctx, MIR_T_I64, func));
      next_insn = new_insn
        = MIR_new_insn (ctx, MIR_MOV, func_reg_op, MIR_new_ref_op (ctx, func_import_item));
      gen_add_insn_before (gen_ctx, insn, new_insn);
      if (code == MIR_VA_ARG) {
        new_insn
          = MIR_new_insn (ctx, MIR_MOV, reg_op3, MIR_new_int_op (ctx, (int64_t) op3.u.mem.type));
        op3 = reg_op3;
        gen_add_insn_before (gen_ctx, insn, new_insn);
      }
      ops[0] = MIR_new_ref_op (ctx, proto_item);
      ops[1] = func_reg_op;
      ops[2] = res_reg_op;
      ops[3] = va_reg_op;
      ops[4] = op3;
      if (code == MIR_VA_BLOCK_ARG) ops[5] = insn->ops[3];
      new_insn = MIR_new_insn_arr (ctx, MIR_CALL, code == MIR_VA_ARG ? 5 : 6, ops);
      gen_add_insn_before (gen_ctx, insn, new_insn);
      gen_delete_insn (gen_ctx, insn);
      break;
    }
    case MIR_ALLOCA: alloca_p = TRUE; break;
    case MIR_RET: {
      /* In simplify we already transformed code for one return insn
         and added extension in return (if any).  */
      uint32_t n_iregs = 0, n_xregs = 0, n_fregs = 0;

#ifdef _WIN32
      if (curr_func_item->u.func->nres > 1)
        (*MIR_get_error_func (ctx)) (MIR_ret_error,
                                     "Windows x86-64 doesn't support multiple return values");
#endif
      assert (curr_func_item->u.func->nres == MIR_insn_nops (ctx, insn));
      for (size_t i = 0; i < curr_func_item->u.func->nres; i++) {
        assert (insn->ops[i].mode == MIR_OP_REG);
        res_type = curr_func_item->u.func->res_types[i];
        if ((res_type == MIR_T_F || res_type == MIR_T_D) && n_xregs < 2) {
          new_insn_code = res_type == MIR_T_F ? MIR_FMOV : MIR_DMOV;
          ret_reg = n_xregs++ == 0 ? XMM0_HARD_REG : XMM1_HARD_REG;
        } else if (res_type == MIR_T_LD && n_fregs < 2) {  // ???
          new_insn_code = MIR_LDMOV;
          ret_reg = n_fregs == 0 ? ST0_HARD_REG : ST1_HARD_REG;
          n_fregs++;
        } else if (n_iregs < 2) {
          new_insn_code = MIR_MOV;
          ret_reg = n_iregs++ == 0 ? AX_HARD_REG : DX_HARD_REG;
        } else {
          (*MIR_get_error_func (ctx)) (MIR_ret_error,
                                       "x86-64 can not handle this combination of return values");
        }
        ret_reg_op = _MIR_new_hard_reg_op (ctx, ret_reg);
        new_insn = MIR_new_insn (ctx, new_insn_code, ret_reg_op, insn->ops[i]);
        gen_add_insn_before (gen_ctx, insn, new_insn);
        insn->ops[i] = ret_reg_op;
      }
      break;
    }
    case MIR_LSH:
    case MIR_RSH:
    case MIR_URSH:
    case MIR_LSHS:
    case MIR_RSHS:
    case MIR_URSHS: {
      /* We can access only cl as shift register: */
      MIR_op_t creg_op = _MIR_new_hard_reg_op (ctx, CX_HARD_REG);

      new_insn = MIR_new_insn (ctx, MIR_MOV, creg_op, insn->ops[2]);
      gen_add_insn_before (gen_ctx, insn, new_insn);
      insn->ops[2] = creg_op;
      break;
    }
    case MIR_DIV:
    case MIR_UDIV:
    case MIR_DIVS:
    case MIR_UDIVS: {
      /* Divide uses ax/dx as operands: */
      MIR_op_t areg_op = _MIR_new_hard_reg_op (ctx, AX_HARD_REG);

      new_insn = MIR_new_insn (ctx, MIR_MOV, areg_op, insn->ops[1]);
      gen_add_insn_before (gen_ctx, insn, new_insn);
      new_insn = MIR_new_insn (ctx, MIR_MOV, insn->ops[0], areg_op);
      gen_add_insn_after (gen_ctx, insn, new_insn);
      insn->ops[0] = insn->ops[1] = areg_op;
      break;
    }
    case MIR_MOD:
    case MIR_UMOD:
    case MIR_MODS:
    case MIR_UMODS: {
      /* Divide uses ax/dx as operands: */
      MIR_op_t areg_op = _MIR_new_hard_reg_op (ctx, AX_HARD_REG);
      MIR_op_t dreg_op = _MIR_new_hard_reg_op (ctx, DX_HARD_REG);

      new_insn = MIR_new_insn (ctx, MIR_MOV, areg_op, insn->ops[1]);
      gen_add_insn_before (gen_ctx, insn, new_insn);
      insn->ops[1] = areg_op;
      new_insn = MIR_new_insn (ctx, MIR_MOV, insn->ops[0], dreg_op);
      gen_add_insn_after (gen_ctx, insn, new_insn);
      insn->ops[0] = dreg_op;
      break;
    }
    case MIR_EQ:
    case MIR_NE:
    case MIR_LT:
    case MIR_ULT:
    case MIR_LE:
    case MIR_ULE:
    case MIR_GT:
    case MIR_UGT:
    case MIR_GE:
    case MIR_UGE:
    case MIR_EQS:
    case MIR_NES:
    case MIR_LTS:
    case MIR_ULTS:
    case MIR_LES:
    case MIR_ULES:
    case MIR_GTS:
    case MIR_UGTS:
    case MIR_GES:
    case MIR_UGES:
    case MIR_FEQ:
    case MIR_FNE:
    case MIR_FLT:
    case MIR_FLE:
    case MIR_FGT:
    case MIR_FGE:
    case MIR_DEQ:
    case MIR_DNE:
    case MIR_DLT:
    case MIR_DLE:
    case MIR_DGT:
    case MIR_DGE: {
      /* We can access only 4 regs in setxx -- use ax as the result: */
      MIR_op_t areg_op = _MIR_new_hard_reg_op (ctx, AX_HARD_REG);

      new_insn = MIR_new_insn (ctx, MIR_MOV, insn->ops[0], areg_op);
      gen_add_insn_after (gen_ctx, insn, new_insn);
      insn->ops[0] = areg_op;
      /* Following conditional branches are changed to correctly process unordered numbers: */
      switch (code) {
      case MIR_FLT:
        SWAP (insn->ops[1], insn->ops[2], temp_op);
        insn->code = MIR_FGT;
        break;
      case MIR_FLE:
        SWAP (insn->ops[1], insn->ops[2], temp_op);
        insn->code = MIR_FGE;
        break;
      case MIR_DLT:
        SWAP (insn->ops[1], insn->ops[2], temp_op);
        insn->code = MIR_DGT;
        break;
      case MIR_DLE:
        SWAP (insn->ops[1], insn->ops[2], temp_op);
        insn->code = MIR_DGE;
        break;
      default: break; /* do nothing */
      }
      break;
    }
    /* Following conditional branches are changed to correctly process unordered numbers: */
    case MIR_LDLT:
      SWAP (insn->ops[1], insn->ops[2], temp_op);
      insn->code = MIR_LDGT;
      break;
    case MIR_LDLE:
      SWAP (insn->ops[1], insn->ops[2], temp_op);
      insn->code = MIR_LDGE;
      break;
    case MIR_FBLT:
      SWAP (insn->ops[1], insn->ops[2], temp_op);
      insn->code = MIR_FBGT;
      break;
    case MIR_FBLE:
      SWAP (insn->ops[1], insn->ops[2], temp_op);
      insn->code = MIR_FBGE;
      break;
    case MIR_DBLT:
      SWAP (insn->ops[1], insn->ops[2], temp_op);
      insn->code = MIR_DBGT;
      break;
    case MIR_DBLE:
      SWAP (insn->ops[1], insn->ops[2], temp_op);
      insn->code = MIR_DBGE;
      break;
    case MIR_LDBLT:
      SWAP (insn->ops[1], insn->ops[2], temp_op);
      insn->code = MIR_LDBGT;
      break;
    case MIR_LDBLE:
      SWAP (insn->ops[1], insn->ops[2], temp_op);
      insn->code = MIR_LDBGE;
      break;
    default:
      if (MIR_call_code_p (code)) {
        machinize_call (gen_ctx, insn);
        leaf_p = FALSE;
      }
      break;
    }
  }
}

static void isave (gen_ctx_t gen_ctx, MIR_insn_t anchor, int disp, MIR_reg_t hard_reg) {
  MIR_context_t ctx = gen_ctx->ctx;

  gen_mov (gen_ctx, anchor, MIR_MOV,
           _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, disp, SP_HARD_REG, MIR_NON_HARD_REG, 1),
           _MIR_new_hard_reg_op (ctx, hard_reg));
}

static void dsave (gen_ctx_t gen_ctx, MIR_insn_t anchor, int disp, MIR_reg_t hard_reg) {
  MIR_context_t ctx = gen_ctx->ctx;

  gen_mov (gen_ctx, anchor, MIR_DMOV,
           _MIR_new_hard_reg_mem_op (ctx, MIR_T_D, disp, SP_HARD_REG, MIR_NON_HARD_REG, 1),
           _MIR_new_hard_reg_op (ctx, hard_reg));
}

static void target_make_prolog_epilog (gen_ctx_t gen_ctx, bitmap_t used_hard_regs,
                                       size_t stack_slots_num) {
  MIR_context_t ctx = gen_ctx->ctx;
  MIR_func_t func;
  MIR_insn_t anchor, new_insn;
  MIR_op_t sp_reg_op, fp_reg_op;
#ifdef MIR_NO_RED_ZONE_ABI
  MIR_op_t temp_reg_op;
#endif
  int64_t bp_saved_reg_offset, offset;
  size_t i, service_area_size, saved_hard_regs_size, stack_slots_size, block_size;

  assert (curr_func_item->item_type == MIR_func_item);
  func = curr_func_item->u.func;
  for (i = saved_hard_regs_size = 0; i <= R15_HARD_REG; i++)
    if (!target_call_used_hard_reg_p (i, MIR_T_UNDEF) && bitmap_bit_p (used_hard_regs, i))
      saved_hard_regs_size += 8;
#ifdef _WIN32
  for (; i <= XMM15_HARD_REG; i++)
    if (!target_call_used_hard_reg_p (i, MIR_T_UNDEF) && bitmap_bit_p (used_hard_regs, i))
      saved_hard_regs_size += 16;
#endif
  if (leaf_p && !alloca_p && !block_arg_func_p && saved_hard_regs_size == 0 && !func->vararg_p
      && stack_slots_num == 0)
    return;
  anchor = DLIST_HEAD (MIR_insn_t, func->insns);
  sp_reg_op = _MIR_new_hard_reg_op (ctx, SP_HARD_REG);
  fp_reg_op = _MIR_new_hard_reg_op (ctx, FP_HARD_REG);
#ifdef MIR_NO_RED_ZONE_ABI
  temp_reg_op = _MIR_new_hard_reg_op (ctx, TEMP_INT_HARD_REG1);
#endif
  /* Prologue: */
  /* Use add for matching LEA: */
#ifdef MIR_NO_RED_ZONE_ABI
  new_insn = MIR_new_insn (ctx, MIR_ADD, temp_reg_op, sp_reg_op, MIR_new_int_op (ctx, -8));
  gen_add_insn_before (gen_ctx, anchor, new_insn); /* temp = sp - 8 */
#else
  new_insn
    = MIR_new_insn (ctx, MIR_MOV,
                    _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, -8, SP_HARD_REG, MIR_NON_HARD_REG, 1),
                    fp_reg_op);
  gen_add_insn_before (gen_ctx, anchor, new_insn); /* -8(sp) = bp */
  /* Use add for matching LEA: */
  new_insn = MIR_new_insn (ctx, MIR_ADD, fp_reg_op, sp_reg_op, MIR_new_int_op (ctx, -8));
  gen_add_insn_before (gen_ctx, anchor, new_insn); /* bp = sp - 8 */
#endif
#ifdef _WIN32
  if (func->vararg_p) { /* filling spill space */
    for (i = 0, offset = 16 /* ret & bp */; i < 4; i++, offset += 8)
      gen_mov (gen_ctx, anchor, MIR_MOV,
               _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, offset, FP_HARD_REG, MIR_NON_HARD_REG, 1),
               _MIR_new_hard_reg_op (ctx, get_int_arg_reg (i)));
  }
#endif
  service_area_size = func->vararg_p ? reg_save_area_size + 8 : 8;
  stack_slots_size = stack_slots_num * 8;
  /* stack slots, and saved regs as multiple of 16 bytes: */
  block_size = (stack_slots_size + saved_hard_regs_size + 15) / 16 * 16;
  new_insn = MIR_new_insn (ctx, MIR_SUB, sp_reg_op, sp_reg_op,
                           MIR_new_int_op (ctx, block_size + service_area_size));
  gen_add_insn_before (gen_ctx, anchor, new_insn); /* sp -= block size + service_area_size */
  bp_saved_reg_offset = block_size;
#ifdef MIR_NO_RED_ZONE_ABI
  new_insn
    = MIR_new_insn (ctx, MIR_MOV,
                    _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, block_size + service_area_size - 8,
                                              SP_HARD_REG, MIR_NON_HARD_REG, 1),
                    fp_reg_op);
  gen_add_insn_before (gen_ctx, anchor, new_insn); /* -8(old sp) = bp */
  new_insn = MIR_new_insn (ctx, MIR_MOV, fp_reg_op, temp_reg_op);
  gen_add_insn_before (gen_ctx, anchor, new_insn); /* bp = temp */
#endif
#ifndef _WIN32
  if (func->vararg_p) {
    offset = block_size;
    isave (gen_ctx, anchor, offset, DI_HARD_REG);
    isave (gen_ctx, anchor, offset + 8, SI_HARD_REG);
    isave (gen_ctx, anchor, offset + 16, DX_HARD_REG);
    isave (gen_ctx, anchor, offset + 24, CX_HARD_REG);
    isave (gen_ctx, anchor, offset + 32, R8_HARD_REG);
    isave (gen_ctx, anchor, offset + 40, R9_HARD_REG);
    dsave (gen_ctx, anchor, offset + 48, XMM0_HARD_REG);
    dsave (gen_ctx, anchor, offset + 64, XMM1_HARD_REG);
    dsave (gen_ctx, anchor, offset + 80, XMM2_HARD_REG);
    dsave (gen_ctx, anchor, offset + 96, XMM3_HARD_REG);
    dsave (gen_ctx, anchor, offset + 112, XMM4_HARD_REG);
    dsave (gen_ctx, anchor, offset + 128, XMM5_HARD_REG);
    dsave (gen_ctx, anchor, offset + 144, XMM6_HARD_REG);
    dsave (gen_ctx, anchor, offset + 160, XMM7_HARD_REG);
    bp_saved_reg_offset += reg_save_area_size;
  }
#endif
  /* Saving callee saved hard registers: */
  offset = -bp_saved_reg_offset;
#ifdef _WIN32
  for (i = XMM0_HARD_REG; i <= XMM15_HARD_REG; i++)
    if (!target_call_used_hard_reg_p (i, MIR_T_UNDEF) && bitmap_bit_p (used_hard_regs, i)) {
      new_insn = _MIR_new_unspec_insn (ctx, 3, MIR_new_int_op (ctx, MOVDQA_CODE),
                                       _MIR_new_hard_reg_mem_op (ctx, MIR_T_D, offset, FP_HARD_REG,
                                                                 MIR_NON_HARD_REG, 1),
                                       _MIR_new_hard_reg_op (ctx, i));
      gen_add_insn_before (gen_ctx, anchor, new_insn); /* disp(sp) = saved hard reg */
      offset += 16;
    }
#endif
  for (i = 0; i <= R15_HARD_REG; i++)
    if (!target_call_used_hard_reg_p (i, MIR_T_UNDEF) && bitmap_bit_p (used_hard_regs, i)) {
      new_insn = MIR_new_insn (ctx, MIR_MOV,
                               _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, offset, FP_HARD_REG,
                                                         MIR_NON_HARD_REG, 1),
                               _MIR_new_hard_reg_op (ctx, i));
      gen_add_insn_before (gen_ctx, anchor, new_insn); /* disp(sp) = saved hard reg */
      offset += 8;
    }
  /* Epilogue: */
  anchor = DLIST_TAIL (MIR_insn_t, func->insns);
  /* It might be infinite loop after CCP with dead code elimination: */
  if (anchor->code == MIR_JMP) return;
  /* Restoring hard registers: */
  offset = -bp_saved_reg_offset;
#ifdef _WIN32
  for (i = XMM0_HARD_REG; i <= XMM15_HARD_REG; i++)
    if (!target_call_used_hard_reg_p (i, MIR_T_UNDEF) && bitmap_bit_p (used_hard_regs, i)) {
      new_insn = _MIR_new_unspec_insn (ctx, 3, MIR_new_int_op (ctx, MOVDQA_CODE),
                                       _MIR_new_hard_reg_op (ctx, i),
                                       _MIR_new_hard_reg_mem_op (ctx, MIR_T_D, offset, FP_HARD_REG,
                                                                 MIR_NON_HARD_REG, 1));
      gen_add_insn_before (gen_ctx, anchor, new_insn); /* hard reg = disp(sp) */
      offset += 16;
    }
#endif
  for (i = 0; i <= R15_HARD_REG; i++)
    if (!target_call_used_hard_reg_p (i, MIR_T_UNDEF) && bitmap_bit_p (used_hard_regs, i)) {
      new_insn = MIR_new_insn (ctx, MIR_MOV, _MIR_new_hard_reg_op (ctx, i),
                               _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, offset, FP_HARD_REG,
                                                         MIR_NON_HARD_REG, 1));
      gen_add_insn_before (gen_ctx, anchor, new_insn); /* hard reg = disp(sp) */
      offset += 8;
    }
#ifdef MIR_NO_RED_ZONE_ABI
  new_insn = MIR_new_insn (ctx, MIR_MOV, temp_reg_op, fp_reg_op);
  gen_add_insn_before (gen_ctx, anchor, new_insn); /* temp = bp */
  new_insn = MIR_new_insn (ctx, MIR_MOV, fp_reg_op,
                           _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, 0, TEMP_INT_HARD_REG1,
                                                     MIR_NON_HARD_REG, 1));
  gen_add_insn_before (gen_ctx, anchor, new_insn); /* bp = 0(bp) */
  new_insn = MIR_new_insn (ctx, MIR_ADD, sp_reg_op, temp_reg_op, MIR_new_int_op (ctx, 8));
  gen_add_insn_before (gen_ctx, anchor, new_insn); /* sp = temp + 8 */
#else
  new_insn = MIR_new_insn (ctx, MIR_ADD, sp_reg_op, fp_reg_op, MIR_new_int_op (ctx, 8));
  gen_add_insn_before (gen_ctx, anchor, new_insn); /* sp = bp + 8 */
  new_insn = MIR_new_insn (ctx, MIR_MOV, fp_reg_op,
                           _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, -8, SP_HARD_REG,
                                                     MIR_NON_HARD_REG, 1));
  gen_add_insn_before (gen_ctx, anchor, new_insn); /* bp = -8(sp) */
#endif
}

struct pattern {
  MIR_insn_code_t code;
  /* Pattern elements:
     blank - ignore
     X - match everything
     $ - finish successfully matching
     r - register (we don't care about bp and sp because they are fixed and used correctly)
     t - ax, cx, dx, or bx register
     h[0-31] - hard register with given number
     z - operand is zero
     i[0-3] - immediate of size 8,16,32,64-bits
     p[0-3] - reference
     s - immediate 1, 2, 4, or 8 (scale)
     c<number> - immediate integer <number>
     m[0-3] - int (signed or unsigned) type memory of size 8,16,32,64-bits
     ms[0-3] - signed int type memory of size 8,16,32,64-bits
     mu[0-3] - unsigned int type memory of size 8,16,32,64-bits
     mf - memory of float
     md - memory of double
     mld - memory of long double
     l - label which can be present by 32-bit
     [0-9] - an operand matching n-th operand (n should be less than given operand number)

     Remember we have no float or (long) double immediate at this stage. They are represented by
     a reference to data item.  */
  const char *pattern;
  /* Replacement elements:
     blank - ignore
     ; - insn separation
     X - REX byte with W=1
     Y - Optional REX byte with W=0
     Z - Obligatory REX byte with W=0
     [0-9A-F]+ pairs of hexidecimal digits opcode
     r[0-2] = n-th operand in ModRM:reg
     R[0-2] = n-th operand in ModRM:rm with mod == 3
     m[0-2] = n-th operand is mem
     mt = temp memory in red zone (-16(sp))
     mT = switch table memory (h11,r,8)
     ap = 2 and 3 operand forms address by plus (1st reg to base, 2nd reg to index, disp to disp)
     am = 2 and 3 operand forms address by mult (1st reg to index and mult const to scale)
     ad<value> - forms address: 1th operand is base reg and <value> is displacement
     i[0-2] - n-th operand in byte immediate (should be imm of type i8)
     I[0-2] - n-th operand in 4 byte immediate (should be imm of type i32)
     J[0-2] - n-th operand in 8 byte immediate
     P[0-2] - n-th operand in 8 byte address
     T     - absolute 8-byte switch table address
     l[0-2] - n-th operand-label in 32-bit
     /[0-7] - opmod with given value (reg of MOD-RM)
     +[0-2] - lower 3-bit part of opcode used for n-th reg operand
     c<value> - address of 32-bit or 64-bit constant in memory pool (we keep always 64-bit
                in memory pool. x86_64 is LE)
     h<one or two hex digits> - hardware register with given number in reg of ModRM:reg;
                                 one bit of 8-15 in REX.R
     H<one or two hex digits> - hardware register with given number in rm of MOD-RM with and mod=3
     (register); one bit of 8-15 in REX.B v<value> - 8-bit immediate with given hex value V<value> -
     32-bit immediate with given hex value
  */
  const char *replacement;
};

// make imm always second operand (simplify for cmp and commutative op)
// make result of cmp op always a register and memory only the 2nd operand if first is reg,
// but not for FP (NAN) (simplify)
// for FP cmp first operand should be always reg (machinize)

#define IOP0(ICODE, SUFF, RRM_CODE, MR_CODE, RMI8_CODE, RMI32_CODE)   \
  {ICODE##SUFF, "r 0 r", "X " RRM_CODE " r0 R2"},       /* op r0,r2*/ \
    {ICODE##SUFF, "r 0 m3", "X " RRM_CODE " r0 m2"},    /* op r0,m2*/ \
    {ICODE##SUFF, "m3 0 r", "X " MR_CODE " r2 m0"},     /* op m0,r2*/ \
    {ICODE##SUFF, "r 0 i0", "X " RMI8_CODE " R0 i2"},   /* op r0,i2*/ \
    {ICODE##SUFF, "m3 0 i0", "X " RMI8_CODE " m0 i2"},  /* op m0,i2*/ \
    {ICODE##SUFF, "r 0 i2", "X " RMI32_CODE " R0 I2"},  /* op r0,i2*/ \
    {ICODE##SUFF, "m3 0 i2", "X " RMI32_CODE " m0 I2"}, /* op m0,i2*/

#define IOP0S(ICODE, SUFF, RRM_CODE, MR_CODE, RMI8_CODE, RMI32_CODE)  \
  {ICODE##SUFF, "r 0 r", "Y " RRM_CODE " r0 R2"},       /* op r0,r2*/ \
    {ICODE##SUFF, "r 0 m2", "Y " RRM_CODE " r0 m2"},    /* op r0,m2*/ \
    {ICODE##SUFF, "m2 0 r", "Y " MR_CODE " r2 m0"},     /* op m0,r2*/ \
    {ICODE##SUFF, "r 0 i0", "Y " RMI8_CODE " R0 i2"},   /* op r0,i2*/ \
    {ICODE##SUFF, "m2 0 i0", "Y " RMI8_CODE " m0 i2"},  /* op m0,i2*/ \
    {ICODE##SUFF, "r 0 i2", "Y " RMI32_CODE " R0 I2"},  /* op r0,i2*/ \
    {ICODE##SUFF, "m2 0 i2", "Y " RMI32_CODE " m0 I2"}, /* op m0,i2*/

#define IOP(ICODE, RRM_CODE, MR_CODE, RMI8_CODE, RMI32_CODE) \
  IOP0 (ICODE, , RRM_CODE, MR_CODE, RMI8_CODE, RMI32_CODE)   \
  IOP0S (ICODE, S, RRM_CODE, MR_CODE, RMI8_CODE, RMI32_CODE)

#define FOP(ICODE, OP_CODE) {ICODE, "r 0 r", OP_CODE " r0 R2"}, {ICODE, "r 0 mf", OP_CODE " r0 m2"},

#define DOP(ICODE, OP_CODE) {ICODE, "r 0 r", OP_CODE " r0 R2"}, {ICODE, "r 0 md", OP_CODE " r0 m2"},

#define LDOP(ICODE, OP_CODE)      \
  /* fld m1;fld m2;op;fstp m0: */ \
  {ICODE, "mld mld mld", "DB /5 m1; DB /5 m2; " OP_CODE "; DB /7 m0"},

#define SHOP0(ICODE, SUFF, PREF, CL_OP_CODE, I8_OP_CODE)                    \
  {ICODE##SUFF, "r 0 h1", #PREF " " CL_OP_CODE " R0"},       /* sh r0,cl */ \
    {ICODE##SUFF, "m3 0 h1", #PREF " " CL_OP_CODE " m0"},    /* sh m0,cl */ \
    {ICODE##SUFF, "r 0 i0", #PREF " " I8_OP_CODE " R0 i2"},  /* sh r0,i2 */ \
    {ICODE##SUFF, "m3 0 i0", #PREF " " I8_OP_CODE " m0 i2"}, /* sh m0,i2 */

#define SHOP(ICODE, CL_OP_CODE, I8_OP_CODE)  \
  SHOP0 (ICODE, , X, CL_OP_CODE, I8_OP_CODE) \
  SHOP0 (ICODE, S, Y, CL_OP_CODE, I8_OP_CODE)

/* cmp ...; setx r0; movzbl r0,r0: */
#define CMP0(ICODE, SUFF, PREF, SETX)                                                            \
  {ICODE##SUFF, "t r r", #PREF " 3B r1 R2;" SETX " R0;X 0F B6 r0 R0"},        /* cmp r1,r2;...*/ \
    {ICODE##SUFF, "t r m3", #PREF " 3B r1 m2;" SETX " R0;X 0F B6 r0 R0"},     /* cmp r1,m2;...*/ \
    {ICODE##SUFF, "t r i0", #PREF " 83 /7 R1 i2;" SETX " R0;X 0F B6 r0 R0"},  /* cmp r1,i2;...*/ \
    {ICODE##SUFF, "t r i2", #PREF " 81 /7 R1 I2;" SETX " R0;X 0F B6 r0 R0"},  /* cmp r1,i2;...*/ \
    {ICODE##SUFF, "t m3 i0", #PREF " 83 /7 m1 i2;" SETX " R0;X 0F B6 r0 R0"}, /* cmp m1,i2;...*/ \
    {ICODE##SUFF, "t m3 i2", #PREF " 81 /7 m1 I2;" SETX " R0;X 0F B6 r0 R0"}, /* cmp m1,i2;...*/

#define CMP(ICODE, SET_OPCODE)  \
  CMP0 (ICODE, , X, SET_OPCODE) \
  CMP0 (ICODE, S, Y, SET_OPCODE)

#define FEQ(ICODE, V, SET_OPCODE)                                                            \
  /*xor %eax,%eax;ucomiss r1,{r,m2};mov V,%edx;set[n]p r0;cmovne %rdx,%rax; mov %rax,r0:  */ \
  {ICODE, "r r r",                                                                           \
   "33 h0 H0; 0F 2E r1 R2; BA " V "; " SET_OPCODE " H0; X 0F 45 h0 H2; X 8B r0 H0"},         \
    {ICODE, "r r md",                                                                        \
     "33 h0 H0; 0F 2E r1 m2; BA " V "; " SET_OPCODE " H0; X 0F 45 h0 H2; X 8B r0 H0"},

#define DEQ(ICODE, V, SET_OPCODE)                                                            \
  /*xor %eax,%eax;ucomisd r1,{r,m2};mov V,%edx;set[n]p r0;cmovne %rdx,%rax; mov %rax,r0:  */ \
  {ICODE, "r r r",                                                                           \
   "33 h0 H0; 66 Y 0F 2E r1 R2; BA " V "; " SET_OPCODE " H0; X 0F 45 h0 H2; X 8B r0 H0"},    \
    {ICODE, "r r md",                                                                        \
     "33 h0 H0; 66 Y 0F 2E r1 m2; BA " V "; " SET_OPCODE " H0; X 0F 45 h0 H2; X 8B r0 H0"},

#define LDEQ(ICODE, V, SET_OPCODE)                                     \
  /*fld m2;fld m1;xor %eax,%eax;fucomip st,st(1);fstp %st;mov V,%edx;  \
    set[n]p r0;cmovne %rdx,%rax;mov %rax,r0: */                        \
  {ICODE, "r mld mld",                                                 \
   "DB /5 m2; DB /5 m1; 33 h0 H0; DF E9; DD D8; BA " V "; " SET_OPCODE \
   " H0; X 0F 45 h0 H2; X 8B r0 H0"},

#define FCMP(ICODE, SET_OPCODE)                                              \
  /*xor %eax,%eax;ucomiss r1,r2;setx az; mov %rax,r0:  */                    \
  {ICODE, "r r r", "33 h0 H0; Y 0F 2E r1 R2; " SET_OPCODE " H0;X 8B r0 H0"}, \
    {ICODE, "r r mf", "33 h0 H0; Y 0F 2E r1 m2; " SET_OPCODE " H0;X 8B r0 H0"},

#define DCMP(ICODE, SET_OPCODE)                                                 \
  /*xor %eax,%eax;ucomisd r1,r2;setx az; mov %rax,r0:  */                       \
  {ICODE, "r r r", "33 h0 H0; 66 Y 0F 2E r1 R2; " SET_OPCODE " H0;X 8B r0 H0"}, \
    {ICODE, "r r md", "33 h0 H0; 66 Y 0F 2E r1 m2; " SET_OPCODE " H0;X 8B r0 H0"},

#define LDCMP(ICODE, SET_OPCODE)                                                   \
  /*fld m2;fld m1;xor %eax,%eax;fcomip st,st(1);fstp %st;setx az; mov %rax,r0:  */ \
  {ICODE, "r mld mld", "DB /5 m2; DB /5 m1; 33 h0 H0; DF F1; DD D8; " SET_OPCODE " H0;X 8B r0 H0"},

#define BR0(ICODE, SUFF, PREF, LONG_JMP_OPCODE)                                                 \
  {ICODE##SUFF, "l r", #PREF " 83 /7 R1 v0;" LONG_JMP_OPCODE " l0"},    /*cmp r0,$0;jxx rel32*/ \
    {ICODE##SUFF, "l m3", #PREF " 83 /7 m1 v0;" LONG_JMP_OPCODE " l0"}, /*cmp m0,$0;jxx rel8*/

#define BR(ICODE, LONG_JMP_OPCODE)  \
  BR0 (ICODE, , X, LONG_JMP_OPCODE) \
  BR0 (ICODE, S, Y, LONG_JMP_OPCODE)

#define BCMP0(ICODE, SUFF, PREF, LONG_JMP_OPCODE)                                                  \
  {ICODE##SUFF, "l r r", #PREF " 3B r1 R2;" LONG_JMP_OPCODE " l0"},        /*cmp r0,r1;jxx rel32*/ \
    {ICODE##SUFF, "l r m3", #PREF " 3B r1 m2;" LONG_JMP_OPCODE " l0"},     /*cmp r0,m1;jxx rel8*/  \
    {ICODE##SUFF, "l r i0", #PREF " 83 /7 R1 i2;" LONG_JMP_OPCODE " l0"},  /*cmp r0,i1;jxx rel32*/ \
    {ICODE##SUFF, "l r i2", #PREF " 81 /7 R1 I2;" LONG_JMP_OPCODE " l0"},  /*cmp r0,i1;jxx rel32*/ \
    {ICODE##SUFF, "l m3 i0", #PREF " 83 /7 m1 i2;" LONG_JMP_OPCODE " l0"}, /*cmp m0,i1;jxx rel32*/ \
    {ICODE##SUFF, "l m3 i2", #PREF " 81 /7 m1 I2;" LONG_JMP_OPCODE " l0"}, /*cmp m0,i1;jxx rel32*/

#define BCMP(ICODE, LONG_JMP_OPCODE)  \
  BCMP0 (ICODE, , X, LONG_JMP_OPCODE) \
  BCMP0 (ICODE, S, Y, LONG_JMP_OPCODE)

#define FBCMP(ICODE, LONG_JMP_OPCODE) \
  {ICODE, "l r r", "Y 0F 2E r1 R2;" LONG_JMP_OPCODE " l0"}, /* ucomiss r0,r1;jxx rel32*/

#define DBCMP(ICODE, LONG_JMP_OPCODE) \
  {ICODE, "l r r", "66 Y 0F 2E r1 R2;" LONG_JMP_OPCODE " l0"}, /* ucomisd r0,r1;jxx rel32*/

#define LDBCMP(ICODE, LONG_JMP_OPCODE)                    \
  /* fld m2;fld m1; fcomip st,st(1); fstp st; jxx rel32*/ \
  {ICODE, "l mld mld", "DB /5 m2; DB /5 m1; DF F1; DD D8; " LONG_JMP_OPCODE " l0"},

static const struct pattern patterns[] = {
  {MIR_MOV, "r z", "Y 33 r0 R0"},      /* xor r0,r0 -- 32 bit xor */
  {MIR_MOV, "r r", "X 8B r0 R1"},      /* mov r0,r1 */
  {MIR_MOV, "r m3", "X 8B r0 m1"},     /* mov r0,m1 */
  {MIR_MOV, "m3 r", "X 89 r1 m0"},     /* mov m0,r1 */
  {MIR_MOV, "r i2", "X C7 /0 R0 I1"},  /* mov r0,i32 */
  {MIR_MOV, "m3 i2", "X C7 /0 m0 I1"}, /* mov m0,i32 */
  {MIR_MOV, "r i3", "X B8 +0 J1"},     /* mov r0,i64 */
  {MIR_MOV, "r p", "X B8 +0 P1"},      /* mov r0,a64 */

  {MIR_MOV, "m0 r", "Z 88 r1 m0"},    /* mov m0, r1 */
  {MIR_MOV, "m1 r", "66 Y 89 r1 m0"}, /* mov m0, r1 */
  {MIR_MOV, "m2 r", "Y 89 r1 m0"},    /* mov m0, r1 */

  {MIR_MOV, "r ms0", "X 0F BE r0 m1"}, /* movsx r0, m1 */
  {MIR_MOV, "r ms1", "X 0F BF r0 m1"}, /* movsx r0, m1 */
  {MIR_MOV, "r ms2", "X 63 r0 m1"},    /* movsx r0, m1 */

  {MIR_MOV, "r mu0", "X 0F B6 r0 m1"}, /* movzx r0, m1 */
  {MIR_MOV, "r mu1", "X 0F B7 r0 m1"}, /* movzx r0, m1 */
  {MIR_MOV, "r mu2", "Y 8B r0 m1"},    /* mov r0, m1 */

  {MIR_MOV, "m0 i0", "Y C6 /0 m0 i1"}, /* mov m0,i8 */
  {MIR_MOV, "m2 i2", "Y C7 /0 m0 I1"}, /* mov m0,i32 */

  {MIR_FMOV, "r r", "Y 0F 28 r0 R1"},     /* movaps r0,r1 */
  {MIR_FMOV, "r mf", "F3 Y 0F 10 r0 m1"}, /* movss r0,m32 */
  {MIR_FMOV, "mf r", "F3 Y 0F 11 r1 m0"}, /* movss r0,m32 */

  {MIR_DMOV, "r r", "66 Y 0F 28 r0 R1"},  /* movapd r0,r1 */
  {MIR_DMOV, "r md", "F2 Y 0F 10 r0 m1"}, /* movsd r0,m64 */
  {MIR_DMOV, "md r", "F2 Y 0F 11 r1 m0"}, /* movsd m64,r0 */

  {MIR_LDMOV, "mld h32", "DB /7 m0"},           /*only for ret and calls in given order: fstp m0 */
  {MIR_LDMOV, "h32 mld", "DB /5 m1"},           /*only for ret and calls in given order: fld m1 */
  {MIR_LDMOV, "mld h33", "D9 C9; DB /7 m0"},    /*only for ret and calls: fxch;fstp m0 */
  {MIR_LDMOV, "h33 mld", "DB /5 m1; D9 C9"},    /*only for ret and calls: fld m1; fxch */
  {MIR_LDMOV, "mld mld", "DB /5 m1; DB /7 m0"}, /* fld m1; fstp m0 */

#define STR(c) #c
#define STR_VAL(c) STR (c)

  {MIR_UNSPEC, "c" STR_VAL (MOVDQA_CODE) " r r", "66 Y 0F 6F r1 R2"},  /* movdqa r0,r1 */
  {MIR_UNSPEC, "c" STR_VAL (MOVDQA_CODE) " r md", "66 Y 0F 6F r1 m2"}, /* movdqa r0,m128 */
  {MIR_UNSPEC, "c" STR_VAL (MOVDQA_CODE) " md r", "66 Y 0F 7F r2 m1"}, /* movdqa m128,r0 */

  {MIR_EXT8, "r r", "X 0F BE r0 R1"},    /* movsx r0,r1 */
  {MIR_EXT8, "r m0", "X 0F BE r0 m1"},   /* movsx r0,m1 */
  {MIR_EXT16, "r r", "X 0F BF r0 R1"},   /* movsx r0,r1 */
  {MIR_EXT16, "r m1", "X 0F BF r0 m1"},  /* movsx r0,m1 */
  {MIR_EXT32, "r r", "X 63 r0 R1"},      /* movsx r0,r1 */
  {MIR_EXT32, "r m2", "X 63 r0 m1"},     /* movsx r0,m1 */
  {MIR_UEXT8, "r r", "X 0F B6 r0 R1"},   /* movzx r0,r1 */
  {MIR_UEXT8, "r m0", "X 0F B6 r0 m1"},  /* movzx r0,m1 */
  {MIR_UEXT16, "r r", "X 0F B7 r0 R1"},  /* movzx r0,r1 */
  {MIR_UEXT16, "r m1", "X 0F B7 r0 m1"}, /* movzx r0,m1 */
  {MIR_UEXT32, "r r", "Y 8B r0 R1"},     /* mov r0,r1 */
  {MIR_UEXT32, "r m2", "Y 8B r0 m1"},    /* mov r0,m1 */

  {MIR_I2F, "r r", "F3 X 0F 2A r0 R1"},                  /* cvtsi2ss r0,r1 */
  {MIR_I2F, "r mf", "F3 X 0F 2A r0 m1"},                 /* cvtsi2ss r0,m1 */
  {MIR_I2D, "r r", "F2 X 0F 2A r0 R1"},                  /* cvtsi2sd r0,r1 */
  {MIR_I2D, "r md", "F2 X 0F 2A r0 m1"},                 /* cvtsi2sd r0,m1 */
  {MIR_I2LD, "mld r", "X 89 r1 mt; DF /5 mt; DB /7 m0"}, /*mov -16(sp),r1;fild -16(sp);fstp m0 */

  {MIR_F2I, "r r", "F3 X 0F 2C r0 R1"},  /* cvttss2si r0,r1 */
  {MIR_F2I, "r mf", "F3 X 0F 2C r0 m1"}, /* cvttss2si r0,m1 */
  {MIR_D2I, "r r", "F2 X 0F 2C r0 R1"},  /* cvttsd2si r0,r1 */
  {MIR_D2I, "r md", "F2 X 0F 2C r0 m1"}, /* cvttsd2si r0,m1 */

  {MIR_F2D, "r r", "F3 Y 0F 5A r0 R1"},  /* cvtss2sd r0,r1 */
  {MIR_F2D, "r mf", "F3 Y 0F 5A r0 m1"}, /* cvtss2sd r0,m1 */
                                         /* fld m1;fstpl -16(sp);movsd r0,-16(sp): */
  {MIR_LD2D, "r mld", "DB /5 m1; DD /3 mt; F2 Y 0F 10 r0 mt"},

  {MIR_D2F, "r r", "F2 Y 0F 5A r0 R1"},  /* cvtsd2ss r0,r1 */
  {MIR_D2F, "r md", "F2 Y 0F 5A r0 m1"}, /* cvtsd2ss r0,m1 */
  /* fld m1;fstps -16(sp);movss r0, -16(sp): */
  {MIR_LD2F, "r mld", "DB /5 m1; D9 /3 mt; F3 Y 0F 10 r0 mt"},

  /* movss -16(sp), r1; flds -16(sp); fstp m0: */
  {MIR_F2LD, "mld r", "F3 Y 0F 11 r1 mt; D9 /0 mt; DB /7 m0"},
  {MIR_F2LD, "mld mf", "D9 /0 m1; DB /7 m0"}, /* flds m1; fstp m0 */
  /* movsd -16(sp), r1; fldl -16(sp); fstp m0: */
  {MIR_D2LD, "mld r", "F2 Y 0F 11 r1 mt; DD /0 mt; DB /7 m0"},
  {MIR_D2LD, "mld md", "DD /0 m1; DB /7 m0"}, /* fldl m1; fstp m0 */

  /* lea r0, 15(r1); and r0, r0, -16; sub sp, r0; mov r0, sp: */
  {MIR_ALLOCA, "r r", "Y 8D r0 adF; X 81 /4 R0 VFFFFFFF0; X 2B h04 R0; X 8B r0 H04"},
  {MIR_ALLOCA, "r i2", "X 81 /5 H04 I1; X 8B r0 H04"}, /* sub sp, i2; mov r0, sp */

  {MIR_BSTART, "r", "X 8B r0 H4"}, /* r0 = sp */
  {MIR_BEND, "r", "X 8B h4 R0"},   /* sp = r0 */

  {MIR_NEG, "r 0", "X F7 /3 R1"},   /* neg r0 */
  {MIR_NEG, "m3 0", "X F7 /3 m1"},  /* neg m0 */
  {MIR_NEGS, "r 0", "Y F7 /3 R1"},  /* neg r0 */
  {MIR_NEGS, "m2 0", "Y F7 /3 m1"}, /* neg m0 */

  {MIR_FNEG, "r 0", "Y 0F 57 r0 c0000000080000000"},    /* xorps r0,80000000 */
  {MIR_DNEG, "r 0", "66 Y 0F 57 r0 c8000000000000000"}, /* xorpd r0,0x8000000000000000 */
  {MIR_LDNEG, "mld mld", "DB /5 m1; D9 E0; DB /7 m0"},  /* fld m1; fchs; fstp m0 */

  IOP (MIR_ADD, "03", "01", "83 /0", "81 /0") /* x86_64 int additions */

  {MIR_ADD, "r r r", "X 8D r0 ap"},   /* lea r0,(r1,r2)*/
  {MIR_ADD, "r r i2", "X 8D r0 ap"},  /* lea r0,i2(r1)*/
  {MIR_ADDS, "r r r", "Y 8D r0 ap"},  /* lea r0,(r1,r2)*/
  {MIR_ADDS, "r r i2", "Y 8D r0 ap"}, /* lea r0,i2(r1)*/

  IOP (MIR_SUB, "2B", "29", "83 /5", "81 /5") /* x86_64 int subtractions */

  {MIR_MUL, "r 0 r", "X 0F AF r0 R2"},    /* imul r0,r1*/
  {MIR_MUL, "r 0 m3", "X 0F AF r0 m2"},   /* imul r0,m1*/
  {MIR_MUL, "r r i2", "X 69 r0 R1 I2"},   /* imul r0,r1,i32*/
  {MIR_MUL, "r m3 i2", "X 69 r0 m1 I2"},  /* imul r0,m1,i32*/
  {MIR_MUL, "r r s", "X 8D r0 ap"},       /* lea r0,(,r1,s2)*/
  {MIR_MULS, "r 0 r", "Y 0F AF r0 R2"},   /* imul r0,r1*/
  {MIR_MULS, "r 0 m2", "Y 0F AF r0 m2"},  /* imul r0,m1*/
  {MIR_MULS, "r r i2", "Y 69 r0 R1 I2"},  /* imul r0,r1,i32*/
  {MIR_MULS, "r m2 i2", "Y 69 r0 m1 I2"}, /* imul r0,m1,i32*/
  {MIR_MULS, "r r s", "Y 8D r0 ap"},      /* lea r0,(,r1,s2)*/

  {MIR_DIV, "h0 h0 r", "X 99; X F7 /7 R2"},  /* cqo; idiv r2*/
  {MIR_DIV, "h0 h0 m3", "X 99; X F7 /7 m2"}, /* cqo; idiv m2*/
  {MIR_DIVS, "h0 h0 r", "99; Y F7 /7 R2"},   /* cdq; idiv r2*/
  {MIR_DIVS, "h0 h0 m2", "99; Y F7 /7 m2"},  /* cdq; idiv m2*/

  {MIR_UDIV, "h0 h0 r", "31 D2; X F7 /6 R2"},   /* xorl edx,edx; div r2*/
  {MIR_UDIV, "h0 h0 m3", "31 D2; X F7 /6 m2"},  /* xorl edx,edx; div m2*/
  {MIR_UDIVS, "h0 h0 r", "31 D2; Y F7 /6 R2"},  /* xorl edx,edx; div r2*/
  {MIR_UDIVS, "h0 h0 m2", "31 D2; Y F7 /6 m2"}, /* xorl edx,edx; div m2*/

  {MIR_MOD, "h2 h0 r", "X 99; X F7 /7 R2"},  /* cqo; idiv r2*/
  {MIR_MOD, "h2 h0 m3", "X 99; X F7 /7 m2"}, /* cqo; idiv m2*/
  {MIR_MODS, "h2 h0 r", "99; Y F7 /7 R2"},   /* cdq; idiv r2*/
  {MIR_MODS, "h2 h0 m2", "99; Y F7 /7 m2"},  /* cdq; idiv m2*/

  {MIR_UMOD, "h2 h0 r", "31 D2; X F7 /6 R2"},   /* xorl edx,edx; div r2*/
  {MIR_UMOD, "h2 h0 m3", "31 D2; X F7 /6 m2"},  /* xorl edx,edx; div m2*/
  {MIR_UMODS, "h2 h0 r", "31 D2; Y F7 /6 R2"},  /* xorl edx,edx; div r2*/
  {MIR_UMODS, "h2 h0 m2", "31 D2; Y F7 /6 m2"}, /* xorl edx,edx; div m2*/

  IOP (MIR_AND, "23", "21", "83 /4", "81 /4")                                            /*ands*/
  IOP (MIR_OR, "0B", "09", "83 /1", "81 /1") IOP (MIR_XOR, "33", "31", "83 /6", "81 /6") /*(x)ors*/

  FOP (MIR_FADD, "F3 Y 0F 58") DOP (MIR_DADD, "F2 Y 0F 58") FOP (MIR_FSUB, "F3 Y 0F 5C") /**/
  DOP (MIR_DSUB, "F2 Y 0F 5C") FOP (MIR_FMUL, "F3 Y 0F 59") DOP (MIR_DMUL, "F2 Y 0F 59") /**/
  FOP (MIR_FDIV, "F3 Y 0F 5E") DOP (MIR_DDIV, "F2 Y 0F 5E")                              /**/

  LDOP (MIR_LDADD, "DE C1") LDOP (MIR_LDSUB, "DE E9") /* long double adds/subs */
  LDOP (MIR_LDMUL, "DE C9") LDOP (MIR_LDDIV, "DE F9") /* long double muls/divs */

  SHOP (MIR_LSH, "D3 /4", "C1 /4") SHOP (MIR_RSH, "D3 /7", "C1 /7") /* arithm shifts */
  SHOP (MIR_URSH, "D3 /5", "C1 /5")                                 /* logical shifts */

  CMP (MIR_EQ, "0F 94") CMP (MIR_NE, "0F 95") CMP (MIR_LT, "0F 9C")   /* 1.int cmps */
  CMP (MIR_ULT, "0F 92") CMP (MIR_LE, "0F 9E") CMP (MIR_ULE, "0F 96") /* 2.int cmps */
  CMP (MIR_GT, "0F 9F") CMP (MIR_UGT, "0F 97") CMP (MIR_GE, "0F 9D")  /* 3.int cmps */
  CMP (MIR_UGE, "0F 93")                                              /* 4.int cmps */

  FEQ (MIR_FEQ, "V0", "0F 9B") DEQ (MIR_DEQ, "V0", "0F 9B")   /* 1. fp cmps */
  LDEQ (MIR_LDEQ, "V0", "0F 9B") FEQ (MIR_FNE, "V1", "0F 9A") /* 2. fp cmps */
  DEQ (MIR_DNE, "V1", "0F 9A") LDEQ (MIR_LDNE, "V1", "0F 9A") /* 3. fp cmps */

  FCMP (MIR_FLT, "0F 92") DCMP (MIR_DLT, "0F 92") LDCMP (MIR_LDLT, "0F 92") /*4*/
  FCMP (MIR_FLE, "0F 96") DCMP (MIR_DLE, "0F 96") LDCMP (MIR_LDLE, "0F 96") /*5*/
  FCMP (MIR_FGT, "0F 97") DCMP (MIR_DGT, "0F 97") LDCMP (MIR_LDGT, "0F 97") /*6*/
  FCMP (MIR_FGE, "0F 93") DCMP (MIR_DGE, "0F 93") LDCMP (MIR_LDGE, "0F 93") /*7*/

  {MIR_JMP, "l", "E9 l0"}, /* 32-bit offset jmp */

  /* movq TableAddress,r11; mov (r11,r,8),r11; jmp *r11; TableContent */
  {MIR_SWITCH, "r $", "49 BB T; X 8B hB mT; 41 FF E3"},

  BR (MIR_BT, "0F 85") BR (MIR_BF, "0F 84") /* branches */

  BCMP (MIR_BEQ, "0F 84") BCMP (MIR_BNE, "0F 85")  /* 1. int compare and branch */
  BCMP (MIR_BLT, "0F 8C") BCMP (MIR_UBLT, "0F 82") /* 2. int compare and branch */
  BCMP (MIR_BLE, "0F 8E") BCMP (MIR_UBLE, "0F 86") /* 3. int compare and branch */
  BCMP (MIR_BGT, "0F 8F") BCMP (MIR_UBGT, "0F 87") /* 4. int compare and branch */
  BCMP (MIR_BGE, "0F 8D") BCMP (MIR_UBGE, "0F 83") /* 5. int compare and branch */

#if 0 /* it is switched off because we change the following insn in machinize pass: */
  FBCMP (MIR_FBLT, "0F 82") DBCMP (MIR_DBLT, "0F 82")   /* 1. fp cmp and branch */
  LDBCMP (MIR_LDBLT, "0F 82") FBCMP (MIR_FBLE, "0F 86") /* 2. fp cmp and branch */
  DBCMP (MIR_DBLE, "0F 86") LDBCMP (MIR_LDBLE, "0F 86") /* 3. fp cmp and branch */
#endif

  FBCMP (MIR_FBGT, "0F 87") DBCMP (MIR_DBGT, "0F 87")   /* 4. fp cmp and branch */
  LDBCMP (MIR_LDBGT, "0F 87") FBCMP (MIR_FBGE, "0F 83") /* 5. fp cmp and branch */
  DBCMP (MIR_DBGE, "0F 83") LDBCMP (MIR_LDBGE, "0F 83") /* 6. fp cmp and branch */

  {MIR_FBEQ, "l r r", "Y 0F 2E r1 R2; 7A v6; 0F 84 l0"},    /* ucomiss r0,r1;jp L;je rel32 L: */
  {MIR_DBEQ, "l r r", "66 Y 0F 2E r1 R2; 7A v6; 0F 84 l0"}, /* ucomisd r0,r1;jp L;je rel32 L: */
  /* fld m2;fld m1;fucomip st,st1;fstp st;jp L;je rel32 L: */
  {MIR_LDBEQ, "l mld mld", "DB /5 m2; DB /5 m1; DF E9; DD D8; 7A v6; 0F 84 l0"},

  {MIR_FBNE, "l r r", "Y 0F 2E r1 R2; 0F 8A l0; 0F 85 l0"},    /* ucomiss r0,r1;jp rel32;jne rel32*/
  {MIR_DBNE, "l r r", "66 Y 0F 2E r1 R2; 0F 8A l0; 0F 85 l0"}, /* ucomisd r0,r1;jp rel32;jne rel32*/
  /* fld m2;fld m1;fucomip st,st1;fstp st;jp rel32;jne rel32 */
  {MIR_LDBNE, "l mld mld", "DB /5 m2; DB /5 m1; DF E9; DD D8; 0F 8A l0; 0F 85 l0"},

  {MIR_CALL, "X r $", "Y FF /2 R1"}, /* call *r1 */

  {MIR_RET, "$", "C3"}, /* ret ax, dx, xmm0, xmm1, st0, st1  */
};

static void target_get_early_clobbered_hard_regs (MIR_insn_t insn, MIR_reg_t *hr1, MIR_reg_t *hr2) {
  MIR_insn_code_t code = insn->code;

  *hr1 = *hr2 = MIR_NON_HARD_REG;
  if (code == MIR_DIV || code == MIR_UDIV || code == MIR_DIVS || code == MIR_UDIVS
      || code == MIR_MOD || code == MIR_UMOD || code == MIR_MODS || code == MIR_UMODS) {
    *hr1 = DX_HARD_REG;
  } else if (code == MIR_FEQ || code == MIR_FNE || code == MIR_DEQ || code == MIR_DNE
             || code == MIR_LDEQ || code == MIR_LDNE) {
    *hr1 = AX_HARD_REG;
    *hr2 = DX_HARD_REG;
  } else if (code == MIR_FLT || code == MIR_FLE || code == MIR_FGT || code == MIR_FGE
             || code == MIR_DLT || code == MIR_DLE || code == MIR_DGT || code == MIR_DGE
             || code == MIR_LDLT || code == MIR_LDLE || code == MIR_LDGT || code == MIR_LDGE) {
    *hr1 = AX_HARD_REG;
  }
}

// constraint: esp can not be index

static int int8_p (int64_t v) { return INT8_MIN <= v && v <= INT8_MAX; }
static int MIR_UNUSED uint8_p (int64_t v) { return 0 <= v && v <= UINT8_MAX; }
static int int16_p (int64_t v) { return INT16_MIN <= v && v <= INT16_MAX; }
static int MIR_UNUSED uint16_p (int64_t v) { return 0 <= v && v <= UINT16_MAX; }
static int int32_p (int64_t v) { return INT32_MIN <= v && v <= INT32_MAX; }
static int MIR_UNUSED uint32_p (int64_t v) { return 0 <= v && v <= UINT32_MAX; }

static int dec_value (int ch) { return '0' <= ch && ch <= '9' ? ch - '0' : -1; }

static uint64_t read_dec (const char **ptr) {
  int v;
  const char *p;
  uint64_t res = 0;

  for (p = *ptr; (v = dec_value (*p)) >= 0; p++) {
    gen_assert ((res >> 60) == 0);
    res = res * 10 + v;
  }
  gen_assert (p != *ptr);
  *ptr = p - 1;
  return res;
}

static int pattern_index_cmp (const void *a1, const void *a2) {
  int i1 = *(const int *) a1, i2 = *(const int *) a2;
  int c1 = (int) patterns[i1].code, c2 = (int) patterns[i2].code;

  return c1 != c2 ? c1 - c2 : (long) i1 - (long) i2;
}

static void patterns_init (gen_ctx_t gen_ctx) {
  int i, ind, n = sizeof (patterns) / sizeof (struct pattern);
  MIR_insn_code_t prev_code, code;
  insn_pattern_info_t *info_addr;
  insn_pattern_info_t pinfo = {0, 0};

  VARR_CREATE (int, pattern_indexes, 0);
  for (i = 0; i < n; i++) VARR_PUSH (int, pattern_indexes, i);
  qsort (VARR_ADDR (int, pattern_indexes), n, sizeof (int), pattern_index_cmp);
  VARR_CREATE (insn_pattern_info_t, insn_pattern_info, 0);
  for (i = 0; i < MIR_INSN_BOUND; i++) VARR_PUSH (insn_pattern_info_t, insn_pattern_info, pinfo);
  info_addr = VARR_ADDR (insn_pattern_info_t, insn_pattern_info);
  for (prev_code = MIR_INSN_BOUND, i = 0; i < n; i++) {
    ind = VARR_GET (int, pattern_indexes, i);
    if ((code = patterns[ind].code) != prev_code) {
      if (i != 0) info_addr[prev_code].num = i - info_addr[prev_code].start;
      info_addr[code].start = i;
      prev_code = code;
    }
  }
  assert (prev_code != MIR_INSN_BOUND);
  info_addr[prev_code].num = n - info_addr[prev_code].start;
}

static int pattern_match_p (gen_ctx_t gen_ctx, const struct pattern *pat, MIR_insn_t insn) {
  MIR_context_t ctx = gen_ctx->ctx;
  int nop, n;
  size_t nops = MIR_insn_nops (ctx, insn);
  const char *p;
  char ch, start_ch;
  MIR_op_mode_t mode;
  MIR_op_t op, original;
  MIR_reg_t hr;

  for (nop = 0, p = pat->pattern; *p != 0; p++, nop++) {
    while (*p == ' ' || *p == '\t') p++;
    if (*p == '$') return TRUE;
    if (MIR_call_code_p (insn->code) && nop >= nops) return FALSE;
    gen_assert (nop < nops);
    op = insn->ops[nop];
    switch (start_ch = *p) {
    case 'X': break;
    case 'r':
      if (op.mode != MIR_OP_HARD_REG) return FALSE;
      break;
    case 't':
      if (op.mode != MIR_OP_HARD_REG
          || !(AX_HARD_REG <= op.u.hard_reg && op.u.hard_reg <= BX_HARD_REG))
        return FALSE;
      break;
    case 'h':
      if (op.mode != MIR_OP_HARD_REG) return FALSE;
      ch = *++p;
      gen_assert ('0' <= ch && ch <= '9');
      hr = ch - '0';
      ch = *++p;
      if ('0' <= ch && ch <= '9')
        hr = hr * 10 + ch - '0';
      else
        --p;
      if (op.u.hard_reg != hr) return FALSE;
      break;
    case 'z':
      if ((op.mode != MIR_OP_INT && op.mode != MIR_OP_UINT) || op.u.i != 0) return FALSE;
      break;
    case 'i':
      if (op.mode != MIR_OP_INT && op.mode != MIR_OP_UINT) return FALSE;
      ch = *++p;
      gen_assert ('0' <= ch && ch <= '3');
      if ((ch == '0' && !int8_p (op.u.i)) || (ch == '1' && !int16_p (op.u.i))
          || (ch == '2' && !int32_p (op.u.i)))
        return FALSE;
      break;
    case 'p':
      if (op.mode != MIR_OP_REF) return FALSE;
      break;
    case 's':
      if ((op.mode != MIR_OP_INT && op.mode != MIR_OP_UINT)
          || (op.u.i != 1 && op.u.i != 2 && op.u.i != 4 && op.u.i != 8))
        return FALSE;
      break;
    case 'c': {
      uint64_t n;
      p++;
      n = read_dec (&p);
      if ((op.mode != MIR_OP_INT && op.mode != MIR_OP_UINT) || op.u.u != n) return FALSE;
      break;
    }
    case 'm': {
      MIR_type_t type, type2, type3 = MIR_T_BOUND;
      int u_p, s_p;

      if (op.mode != MIR_OP_HARD_REG_MEM) return FALSE;
      u_p = s_p = TRUE;
      ch = *++p;
      switch (ch) {
      case 'f':
        type = MIR_T_F;
        type2 = MIR_T_BOUND;
        break;
      case 'd':
        type = MIR_T_D;
        type2 = MIR_T_BOUND;
        break;
      case 'l':
        ch = *++p;
        gen_assert (ch == 'd');
        type = MIR_T_LD;
        type2 = MIR_T_BOUND;
        break;
      case 'u':
      case 's':
        u_p = ch == 'u';
        s_p = ch == 's';
        ch = *++p;
        /* Fall through: */
      default:
        gen_assert ('0' <= ch && ch <= '3');
        if (ch == '0') {
          type = u_p ? MIR_T_U8 : MIR_T_I8;
          type2 = u_p && s_p ? MIR_T_I8 : MIR_T_BOUND;
        } else if (ch == '1') {
          type = u_p ? MIR_T_U16 : MIR_T_I16;
          type2 = u_p && s_p ? MIR_T_I16 : MIR_T_BOUND;
        } else if (ch == '2') {
          type = u_p ? MIR_T_U32 : MIR_T_I32;
          type2 = u_p && s_p ? MIR_T_I32 : MIR_T_BOUND;
#if MIR_PTR32
          if (u_p) type3 = MIR_T_P;
#endif
        } else {
          type = u_p ? MIR_T_U64 : MIR_T_I64;
          type2 = u_p && s_p ? MIR_T_I64 : MIR_T_BOUND;
#if MIR_PTR64
          type3 = MIR_T_P;
#endif
        }
      }
      if (op.u.hard_reg_mem.type != type && op.u.hard_reg_mem.type != type2
          && op.u.hard_reg_mem.type != type3)
        return FALSE;
      if (op.u.hard_reg_mem.index != MIR_NON_HARD_REG && op.u.hard_reg_mem.scale != 1
          && op.u.hard_reg_mem.scale != 2 && op.u.hard_reg_mem.scale != 4
          && op.u.hard_reg_mem.scale != 8)
        return FALSE;
      if (!int32_p (op.u.hard_reg_mem.disp)) return FALSE;
      break;
    }
    case 'l':
      if (op.mode != MIR_OP_LABEL) return FALSE;
      break;
    case '0':
    case '1':
    case '2':
    case '3':
    case '4':
    case '5':
    case '6':
    case '7':
    case '8':
    case '9':
      n = start_ch - '0';
      gen_assert (n < nop);
      original = insn->ops[n];
      mode = op.mode;
      if (mode == MIR_OP_UINT) mode = MIR_OP_INT;
      if (original.mode != mode && (original.mode != MIR_OP_UINT || mode != MIR_OP_INT))
        return FALSE;
      gen_assert (mode == MIR_OP_HARD_REG || mode == MIR_OP_INT || mode == MIR_OP_FLOAT
                  || mode == MIR_OP_DOUBLE || mode == MIR_OP_LDOUBLE || mode == MIR_OP_HARD_REG_MEM
                  || mode == MIR_OP_LABEL);
      if (mode == MIR_OP_HARD_REG && op.u.hard_reg != original.u.hard_reg)
        return FALSE;
      else if (mode == MIR_OP_INT && op.u.i != original.u.i)
        return FALSE;
      else if (mode == MIR_OP_FLOAT && op.u.f != original.u.f)
        return FALSE;
      else if (mode == MIR_OP_DOUBLE && op.u.d != original.u.d)
        return FALSE;
      else if (mode == MIR_OP_LDOUBLE && op.u.ld != original.u.ld)
        return FALSE;
      else if (mode == MIR_OP_LABEL && op.u.label != original.u.label)
        return FALSE;
      else if (mode == MIR_OP_HARD_REG_MEM && op.u.hard_reg_mem.type != original.u.hard_reg_mem.type
               && op.u.hard_reg_mem.scale != original.u.hard_reg_mem.scale
               && op.u.hard_reg_mem.base != original.u.hard_reg_mem.base
               && op.u.hard_reg_mem.index != original.u.hard_reg_mem.index
               && op.u.hard_reg_mem.disp != original.u.hard_reg_mem.disp)
        return FALSE;
      break;
    default: gen_assert (FALSE);
    }
  }
  gen_assert (nop == nops);
  return TRUE;
}

static const char *find_insn_pattern_replacement (gen_ctx_t gen_ctx, MIR_insn_t insn) {
  int i;
  const struct pattern *pat;
  insn_pattern_info_t info = VARR_GET (insn_pattern_info_t, insn_pattern_info, insn->code);

  for (i = 0; i < info.num; i++) {
    pat = &patterns[VARR_GET (int, pattern_indexes, info.start + i)];
    if (pattern_match_p (gen_ctx, pat, insn)) return pat->replacement;
  }
  return NULL;
}

static void patterns_finish (gen_ctx_t gen_ctx) {
  VARR_DESTROY (int, pattern_indexes);
  VARR_DESTROY (insn_pattern_info_t, insn_pattern_info);
}

static int hex_value (int ch) {
  return '0' <= ch && ch <= '9' ? ch - '0' : 'A' <= ch && ch <= 'F' ? ch - 'A' + 10 : -1;
}

static uint64_t read_hex (const char **ptr) {
  int v;
  const char *p;
  uint64_t res = 0;

  for (p = *ptr; (v = hex_value (*p)) >= 0; p++) {
    gen_assert ((res >> 60) == 0);
    res = res * 16 + v;
  }
  gen_assert (p != *ptr);
  *ptr = p - 1;
  return res;
}

static void setup_r (int *rex, int *r, int v) {
  gen_assert ((rex == NULL || *rex < 0) && *r < 0 && v >= 0 && v <= MAX_HARD_REG);
  if (v >= 16) v -= 16;
  if (v >= 8) {
    if (rex != NULL) *rex = 1;
    v -= 8;
  }
  *r = v;
}

static void setup_reg (int *rex_reg, int *reg, int v) { setup_r (rex_reg, reg, v); }

static void setup_rm (int *rex_b, int *rm, int v) { setup_r (rex_b, rm, v); }

static void setup_mod (int *mod, int v) {
  gen_assert (*mod < 0 && v >= 0 && v <= 3);
  *mod = v;
}

static void setup_scale (int *scale, int v) {
  gen_assert (*scale < 0 && v >= 0 && v <= 3);
  *scale = v;
}

static void setup_base (int *rex_b, int *base, int v) { setup_r (rex_b, base, v); }

static void setup_index (int *rex_i, int *index, int v) { setup_r (rex_i, index, v); }

static void setup_rip_rel_addr (MIR_disp_t rip_disp, int *mod, int *rm, int64_t *disp32) {
  gen_assert (*mod < 0 && *rm < 0 && *disp32 < 0);
  setup_rm (NULL, rm, 5);
  gen_assert (int32_p (rip_disp));
  setup_mod (mod, 0);
  *disp32 = (uint32_t) rip_disp;
}

static void setup_mem (MIR_mem_t mem, int *mod, int *rm, int *scale, int *base, int *rex_b,
                       int *index, int *rex_x, int *disp8, int64_t *disp32) {
  MIR_disp_t disp = mem.disp;

  gen_assert (*disp8 < 0 && *disp32 < 0 && mem.index != SP_HARD_REG);
  if (mem.index == MIR_NON_HARD_REG && mem.base == MIR_NON_HARD_REG) { /* SIB: disp only */
    setup_rm (NULL, rm, 4);
    *disp32 = (uint32_t) disp;
    setup_base (NULL, base, BP_HARD_REG);
    setup_index (NULL, index, SP_HARD_REG);
  } else if (mem.index == MIR_NON_HARD_REG && mem.base != SP_HARD_REG && mem.base != R12_HARD_REG) {
    setup_rm (rex_b, rm, mem.base);
    if (disp == 0 && mem.base != BP_HARD_REG && mem.base != R13_HARD_REG) {
      setup_mod (mod, 0);
    } else if (int8_p (disp)) {
      setup_mod (mod, 1);
      *disp8 = (uint8_t) disp;
    } else {
      setup_mod (mod, 2);
      *disp32 = (uint32_t) disp;
    }
  } else if (mem.index == MIR_NON_HARD_REG) { /* SIB: only base = sp or r12 */
    setup_rm (NULL, rm, 4);
    setup_index (NULL, index, SP_HARD_REG);
    setup_base (rex_b, base, mem.base);
    if (disp == 0) {
      setup_mod (mod, 0);
    } else if (int8_p (disp)) {
      setup_mod (mod, 1);
      *disp8 = (uint8_t) disp;
    } else {
      setup_mod (mod, 2);
      *disp32 = (uint32_t) disp;
    }
  } else if (mem.base == MIR_NON_HARD_REG) { /* SIB: index with scale only */
    setup_rm (NULL, rm, 4);
    setup_index (rex_x, index, mem.index);
    setup_base (NULL, base, BP_HARD_REG);
    setup_mod (mod, 0);
    *disp32 = (uint32_t) disp;
    setup_scale (scale, mem.scale == 1 ? 0 : mem.scale == 2 ? 1 : mem.scale == 4 ? 2 : 3);
  } else { /* SIB: base and index */
    setup_rm (NULL, rm, 4);
    setup_base (rex_b, base, mem.base);
    setup_index (rex_x, index, mem.index);
    setup_scale (scale, mem.scale == 1 ? 0 : mem.scale == 2 ? 1 : mem.scale == 4 ? 2 : 3);
    if (disp == 0 && mem.base != BP_HARD_REG && mem.base != R13_HARD_REG) {
      setup_mod (mod, 0);
    } else if (int8_p (disp)) {
      setup_mod (mod, 1);
      *disp8 = (uint8_t) disp;
    } else {
      setup_mod (mod, 2);
      *disp32 = (uint32_t) disp;
    }
  }
}

static void put_byte (struct gen_ctx *gen_ctx, int byte) { VARR_PUSH (uint8_t, result_code, byte); }

static void put_uint64 (struct gen_ctx *gen_ctx, uint64_t v, int nb) {
  for (; nb > 0; nb--) {
    put_byte (gen_ctx, v & 0xff);
    v >>= 8;
  }
}

static void set_int64 (uint8_t *addr, int64_t v, int nb) {
  for (; nb > 0; nb--) {
    *addr++ = v & 0xff;
    v >>= 8;
  }
}

static int64_t get_int64 (uint8_t *addr, int nb) {
  int64_t v = 0;
  int i, sh = (8 - nb) * 8;

  for (i = nb - 1; i >= 0; i--) v = (v << 8) | addr[i];
  if (sh > 0) v = (v << sh) >> sh; /* make it signed */
  return v;
}

static size_t add_to_const_pool (struct gen_ctx *gen_ctx, uint64_t v) {
  uint64_t *addr = VARR_ADDR (uint64_t, const_pool);
  size_t n, len = VARR_LENGTH (uint64_t, const_pool);

  for (n = 0; n < len; n++)
    if (addr[n] == v) return n;
  VARR_PUSH (uint64_t, const_pool, v);
  return len;
}

static int setup_imm_addr (struct gen_ctx *gen_ctx, uint64_t v, int *mod, int *rm,
                           int64_t *disp32) {
  const_ref_t cr;
  size_t n;

  n = add_to_const_pool (gen_ctx, v);
  setup_rip_rel_addr (0, mod, rm, disp32);
  cr.pc = 0;
  cr.next_insn_disp = 0;
  cr.const_num = n;
  VARR_PUSH (const_ref_t, const_refs, cr);
  return VARR_LENGTH (const_ref_t, const_refs) - 1;
}

static void out_insn (gen_ctx_t gen_ctx, MIR_insn_t insn, const char *replacement) {
  MIR_context_t ctx = gen_ctx->ctx;
  const char *p, *insn_str;
  label_ref_t lr;
  int switch_table_addr_start = -1;

  if (insn->code == MIR_ALLOCA
      && (insn->ops[1].mode == MIR_OP_INT || insn->ops[1].mode == MIR_OP_UINT))
    insn->ops[1].u.u = (insn->ops[1].u.u + 15) & -16;
  for (insn_str = replacement;; insn_str = p + 1) {
    char ch, start_ch;
    int d1, d2;
    int opcode0 = -1, opcode1 = -1, opcode2 = -1;
    int rex_w = -1, rex_r = -1, rex_x = -1, rex_b = -1, rex_0 = -1;
    int mod = -1, reg = -1, rm = -1;
    int scale = -1, index = -1, base = -1;
    int prefix = -1, disp8 = -1, imm8 = -1, lb = -1;
    int64_t disp32 = -1, imm32 = -1;
    int imm64_p = FALSE;
    uint64_t imm64 = 0, v;
    MIR_op_t op;
    int const_ref_num = -1, label_ref_num = -1, switch_table_addr_p = FALSE;

    for (p = insn_str; (ch = *p) != '\0' && ch != ';'; p++) {
      if ((d1 = hex_value (ch = *p)) >= 0) {
        d2 = hex_value (ch = *++p);
        gen_assert (d2 >= 0);
        if (opcode0 == -1)
          opcode0 = d1 * 16 + d2;
        else if (opcode1 == -1)
          opcode1 = d1 * 16 + d2;
        else {
          gen_assert (opcode2 == -1);
          opcode2 = d1 * 16 + d2;
        }
        p++;
      }
      if ((ch = *p) == 0 || ch == ';') break;
      switch ((start_ch = ch = *p)) {
      case ' ':
      case '\t': break;
      case 'X':
        if (opcode0 >= 0) {
          gen_assert (opcode1 < 0);
          prefix = opcode0;
          opcode0 = -1;
        }
        rex_w = 1;
        break;
      case 'Y':
        if (opcode0 >= 0) {
          gen_assert (opcode1 < 0);
          prefix = opcode0;
          opcode0 = -1;
        }
        rex_w = 0;
        break;
      case 'Z':
        if (opcode0 >= 0) {
          gen_assert (opcode1 < 0);
          prefix = opcode0;
          opcode0 = -1;
        }
        rex_w = 0;
        rex_0 = 0;
        break;
      case 'r':
      case 'R':
        ch = *++p;
        gen_assert ('0' <= ch && ch <= '2');
        op = insn->ops[ch - '0'];
        gen_assert (op.mode == MIR_OP_HARD_REG);
        if (start_ch == 'r')
          setup_reg (&rex_r, &reg, op.u.hard_reg);
        else {
          setup_rm (&rex_b, &rm, op.u.hard_reg);
          setup_mod (&mod, 3);
        }
        break;
      case 'm':
        ch = *++p;
        if (ch == 't') { /* -16(%rsp) */
          setup_rm (NULL, &rm, 4);
          setup_index (NULL, &index, SP_HARD_REG);
          setup_base (&rex_b, &base, SP_HARD_REG);
          setup_mod (&mod, 1);
          disp8 = (uint8_t) -16;
        } else if (ch == 'T') {
          MIR_op_t mem;

          op = insn->ops[0];
          gen_assert (op.mode == MIR_OP_HARD_REG);
          mem = _MIR_new_hard_reg_mem_op (ctx, MIR_T_I64, 0, R11_HARD_REG, op.u.hard_reg, 8);
          setup_mem (mem.u.hard_reg_mem, &mod, &rm, &scale, &base, &rex_b, &index, &rex_x, &disp8,
                     &disp32);
        } else {
          gen_assert ('0' <= ch && ch <= '2');
          op = insn->ops[ch - '0'];
          gen_assert (op.mode == MIR_OP_HARD_REG_MEM);
          setup_mem (op.u.hard_reg_mem, &mod, &rm, &scale, &base, &rex_b, &index, &rex_x, &disp8,
                     &disp32);
        }
        break;
      case 'a': {
        MIR_mem_t mem;
        MIR_op_t op2;

        ch = *++p;
        op = insn->ops[1];
        gen_assert (op.mode == MIR_OP_HARD_REG);
        mem.type = MIR_T_I8;
        if (ch == 'p') {
          op2 = insn->ops[2];
          mem.base = op.u.hard_reg;
          mem.scale = 1;
          if (op2.mode == MIR_OP_HARD_REG) {
            mem.index = op2.u.hard_reg;
            mem.disp = 0;
          } else {
            gen_assert (op2.mode == MIR_OP_INT || op2.mode == MIR_OP_UINT);
            mem.index = MIR_NON_HARD_REG;
            mem.disp = op2.u.i;
          }
        } else if (ch == 'd') {
          mem.base = op.u.hard_reg;
          mem.index = MIR_NON_HARD_REG;
          mem.scale = 1;
          ++p;
          mem.disp = read_hex (&p);
        } else {
          gen_assert (ch == 'm');
          op2 = insn->ops[2];
          mem.index = op.u.hard_reg;
          mem.base = MIR_NON_HARD_REG;
          mem.disp = 0;
          gen_assert ((op2.mode == MIR_OP_INT || op2.mode == MIR_OP_UINT)
                      && (op2.u.i == 1 || op2.u.i == 2 || op2.u.i == 4 || op2.u.i == 8));
          mem.scale = op2.u.i;
        }
        setup_mem (mem, &mod, &rm, &scale, &base, &rex_b, &index, &rex_x, &disp8, &disp32);
        break;
      }
      case 'i':
      case 'I':
      case 'J':
        ch = *++p;
        gen_assert ('0' <= ch && ch <= '7');
        op = insn->ops[ch - '0'];
        gen_assert (op.mode == MIR_OP_INT || op.mode == MIR_OP_UINT);
        if (start_ch == 'i') {
          gen_assert (int8_p (op.u.i));
          imm8 = (uint8_t) op.u.i;
        } else if (start_ch == 'I') {
          gen_assert (int32_p (op.u.i));
          imm32 = (uint32_t) op.u.i;
        } else {
          imm64_p = TRUE;
          imm64 = (uint64_t) op.u.i;
        }
        break;
      case 'P':
        ch = *++p;
        gen_assert ('0' <= ch && ch <= '7');
        op = insn->ops[ch - '0'];
        gen_assert (op.mode == MIR_OP_REF);
        imm64_p = TRUE;
        if (op.u.ref->item_type == MIR_data_item && op.u.ref->u.data->name != NULL
            && _MIR_reserved_ref_name_p (ctx, op.u.ref->u.data->name))
          imm64 = (uint64_t) op.u.ref->u.data->u.els;
        else
          imm64 = (uint64_t) op.u.ref->addr;
        break;
      case 'T': {
        gen_assert (!switch_table_addr_p && switch_table_addr_start < 0);
        switch_table_addr_p = TRUE;
        break;
      }
      case 'l': {
        ch = *++p;
        gen_assert ('0' <= ch && ch <= '2');
        op = insn->ops[ch - '0'];
        gen_assert (op.mode == MIR_OP_LABEL);
        lr.abs_addr_p = FALSE;
        lr.label_val_disp = lr.next_insn_disp = 0;
        lr.label = op.u.label;
        gen_assert (label_ref_num < 0 && disp32 < 0);
        disp32 = 0; /* To reserve the space */
        label_ref_num = VARR_LENGTH (label_ref_t, label_refs);
        VARR_PUSH (label_ref_t, label_refs, lr);
        break;
      }
      case '/':
        ch = *++p;
        gen_assert ('0' <= ch && ch <= '7');
        setup_reg (NULL, &reg, ch - '0');
        break;
      case '+':
        ch = *++p;
        gen_assert ('0' <= ch && ch <= '2');
        op = insn->ops[ch - '0'];
        gen_assert (op.mode == MIR_OP_HARD_REG);
        setup_reg (&rex_b, &lb, op.u.hard_reg);
        break;
      case 'c':
        ++p;
        v = read_hex (&p);
        gen_assert (const_ref_num < 0 && disp32 < 0);
        const_ref_num = setup_imm_addr (gen_ctx, v, &mod, &rm, &disp32);
        break;
      case 'h':
        ++p;
        v = read_hex (&p);
        gen_assert (v <= 31);
        setup_reg (&rex_r, &reg, v);
        break;
      case 'H':
        ++p;
        v = read_hex (&p);
        gen_assert (v <= 31);
        setup_rm (&rex_b, &rm, v);
        setup_mod (&mod, 3);
        break;
      case 'v':
      case 'V':
        ++p;
        v = read_hex (&p);
        if (start_ch == 'v') {
          gen_assert (uint8_p (v));
          imm8 = v;
        } else {
          gen_assert (uint32_p (v));
          imm32 = v;
        }
        break;
      default: gen_assert (FALSE);
      }
    }
    if (prefix >= 0) put_byte (gen_ctx, prefix);

    if (rex_w > 0 || rex_r >= 0 || rex_x >= 0 || rex_b >= 0 || rex_0 >= 0) {
      if (rex_w < 0) rex_w = 0;
      if (rex_r < 0) rex_r = 0;
      if (rex_x < 0) rex_x = 0;
      if (rex_b < 0) rex_b = 0;
      gen_assert (rex_w <= 1 && rex_r <= 1 && rex_x <= 1 && rex_b <= 1);
      put_byte (gen_ctx, 0x40 | (rex_w << 3) | (rex_r << 2) | (rex_x << 1) | rex_b);
    }

    gen_assert (opcode0 >= 0 && lb <= 7);
    if (lb >= 0) opcode0 |= lb;
    put_byte (gen_ctx, opcode0);

    if (opcode1 >= 0) put_byte (gen_ctx, opcode1);
    if (opcode2 >= 0) put_byte (gen_ctx, opcode2);

    if (mod >= 0 || reg >= 0 || rm >= 0) {
      if (mod < 0) mod = 0;
      if (reg < 0) reg = 0;
      if (rm < 0) rm = 0;
      gen_assert (mod <= 3 && reg <= 7 && rm <= 7);
      put_byte (gen_ctx, (mod << 6) | (reg << 3) | rm);
    }
    if (scale >= 0 || base >= 0 || index >= 0) {
      if (scale < 0) scale = 0;
      if (base < 0) base = 0;
      if (index < 0) index = 0;
      gen_assert (scale <= 3 && base <= 7 && index <= 7);
      put_byte (gen_ctx, (scale << 6) | (index << 3) | base);
    }
    if (const_ref_num >= 0)
      VARR_ADDR (const_ref_t, const_refs)[const_ref_num].pc = VARR_LENGTH (uint8_t, result_code);
    if (label_ref_num >= 0) VARR_ADDR (label_ref_t, label_refs)
    [label_ref_num].label_val_disp = VARR_LENGTH (uint8_t, result_code);
    if (disp8 >= 0) put_byte (gen_ctx, disp8);
    if (disp32 >= 0) put_uint64 (gen_ctx, disp32, 4);
    if (imm8 >= 0) put_byte (gen_ctx, imm8);
    if (imm32 >= 0) put_uint64 (gen_ctx, imm32, 4);
    if (imm64_p) put_uint64 (gen_ctx, imm64, 8);

    if (switch_table_addr_p) {
      switch_table_addr_start = VARR_LENGTH (uint8_t, result_code);
      put_uint64 (gen_ctx, 0, 8);
    }

    if (label_ref_num >= 0) VARR_ADDR (label_ref_t, label_refs)
    [label_ref_num].next_insn_disp = VARR_LENGTH (uint8_t, result_code);

    if (const_ref_num >= 0) VARR_ADDR (const_ref_t, const_refs)
    [const_ref_num].next_insn_disp = VARR_LENGTH (uint8_t, result_code);
    if (ch == '\0') break;
  }
  if (switch_table_addr_start < 0) return;
  gen_assert (insn->code == MIR_SWITCH);
  VARR_PUSH (uint64_t, abs_address_locs, switch_table_addr_start);
  set_int64 (&VARR_ADDR (uint8_t, result_code)[switch_table_addr_start],
             (int64_t) VARR_LENGTH (uint8_t, result_code), 8);
  for (size_t i = 1; i < insn->nops; i++) {
    gen_assert (insn->ops[i].mode == MIR_OP_LABEL);
    lr.abs_addr_p = TRUE;
    lr.label_val_disp = VARR_LENGTH (uint8_t, result_code);
    lr.label = insn->ops[i].u.label;
    VARR_PUSH (label_ref_t, label_refs, lr);
    put_uint64 (gen_ctx, 0, 8);
  }
}

static uint8_t MIR_UNUSED get_short_jump_opcode (uint8_t *long_jump_opcode) {
  gen_assert (long_jump_opcode[0] == 0x0F && long_jump_opcode[1] > 0x10);
  return long_jump_opcode[1] - 0x10;
}

static int target_insn_ok_p (gen_ctx_t gen_ctx, MIR_insn_t insn) {
  return find_insn_pattern_replacement (gen_ctx, insn) != NULL;
}

static uint8_t *target_translate (gen_ctx_t gen_ctx, size_t *len) {
  MIR_context_t ctx = gen_ctx->ctx;
  size_t i;
  MIR_insn_t insn;
  const char *replacement;

  gen_assert (curr_func_item->item_type == MIR_func_item);
  VARR_TRUNC (uint8_t, result_code, 0);
  VARR_TRUNC (uint64_t, const_pool, 0);
  VARR_TRUNC (const_ref_t, const_refs, 0);
  VARR_TRUNC (label_ref_t, label_refs, 0);
  VARR_TRUNC (uint64_t, abs_address_locs, 0);
  for (insn = DLIST_HEAD (MIR_insn_t, curr_func_item->u.func->insns); insn != NULL;
       insn = DLIST_NEXT (MIR_insn_t, insn)) {
    if (insn->code == MIR_LABEL) {
      set_label_disp (gen_ctx, insn, VARR_LENGTH (uint8_t, result_code));
    } else {
      replacement = find_insn_pattern_replacement (gen_ctx, insn);
      if (replacement == NULL) {
        fprintf (stderr, "%d: fatal failure in matching insn:", gen_ctx->gen_num);
        MIR_output_insn (ctx, stderr, insn, curr_func_item->u.func, TRUE);
        exit (1);
      } else {
        gen_assert (replacement != NULL);
        out_insn (gen_ctx, insn, replacement);
      }
    }
  }
  /* Setting up labels */
  for (i = 0; i < VARR_LENGTH (label_ref_t, label_refs); i++) {
    label_ref_t lr = VARR_GET (label_ref_t, label_refs, i);

    if (!lr.abs_addr_p) {
      set_int64 (&VARR_ADDR (uint8_t, result_code)[lr.label_val_disp],
                 (int64_t) get_label_disp (gen_ctx, lr.label) - (int64_t) lr.next_insn_disp, 4);
    } else {
      set_int64 (&VARR_ADDR (uint8_t, result_code)[lr.label_val_disp],
                 (int64_t) get_label_disp (gen_ctx, lr.label), 8);
      VARR_PUSH (uint64_t, abs_address_locs, lr.label_val_disp);
    }
  }
  while (VARR_LENGTH (uint8_t, result_code) % 16 != 0) /* Align the pool */
    VARR_PUSH (uint8_t, result_code, 0);
  for (i = 0; i < VARR_LENGTH (const_ref_t, const_refs); i++) { /* Add pool constants */
    const_ref_t cr = VARR_GET (const_ref_t, const_refs, i);

    set_int64 (VARR_ADDR (uint8_t, result_code) + cr.pc,
               VARR_LENGTH (uint8_t, result_code) - cr.next_insn_disp, 4);
    put_uint64 (gen_ctx, VARR_GET (uint64_t, const_pool, cr.const_num), 8);
    put_uint64 (gen_ctx, 0, 8); /* keep 16 bytes align */
  }
  *len = VARR_LENGTH (uint8_t, result_code);
  return VARR_ADDR (uint8_t, result_code);
}

static void target_rebase (gen_ctx_t gen_ctx, uint8_t *base) {
  MIR_code_reloc_t reloc;

  VARR_TRUNC (MIR_code_reloc_t, relocs, 0);
  for (size_t i = 0; i < VARR_LENGTH (uint64_t, abs_address_locs); i++) {
    reloc.offset = VARR_GET (uint64_t, abs_address_locs, i);
    reloc.value = base + get_int64 (base + reloc.offset, 8);
    VARR_PUSH (MIR_code_reloc_t, relocs, reloc);
  }
  _MIR_update_code_arr (gen_ctx->ctx, base, VARR_LENGTH (MIR_code_reloc_t, relocs),
                        VARR_ADDR (MIR_code_reloc_t, relocs));
}

static void target_init (gen_ctx_t gen_ctx) {
  gen_ctx->target_ctx = gen_malloc (gen_ctx, sizeof (struct target_ctx));
  VARR_CREATE (uint8_t, result_code, 0);
  VARR_CREATE (uint64_t, const_pool, 0);
  VARR_CREATE (const_ref_t, const_refs, 0);
  VARR_CREATE (label_ref_t, label_refs, 0);
  VARR_CREATE (uint64_t, abs_address_locs, 0);
  VARR_CREATE (MIR_code_reloc_t, relocs, 0);
  MIR_type_t res = MIR_T_D;
  MIR_var_t args[] = {{MIR_T_D, "src"}};
  _MIR_register_unspec_insn (gen_ctx->ctx, MOVDQA_CODE, "movdqa", 1, &res, 1, FALSE, args);
  patterns_init (gen_ctx);
}

static void target_finish (gen_ctx_t gen_ctx) {
  patterns_finish (gen_ctx);
  VARR_DESTROY (uint8_t, result_code);
  VARR_DESTROY (uint64_t, const_pool);
  VARR_DESTROY (const_ref_t, const_refs);
  VARR_DESTROY (label_ref_t, label_refs);
  VARR_DESTROY (uint64_t, abs_address_locs);
  VARR_DESTROY (MIR_code_reloc_t, relocs);
  free (gen_ctx->target_ctx);
  gen_ctx->target_ctx = NULL;
}
