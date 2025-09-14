package raygui4j;
import mir2j.Runtime;

public class RayguiBase extends Runtime {

long m1___stdin = mir_set_data_int(0);
long unused_data_addr_0 = mir_set_data_int(0);
long unused_data_addr_1 = mir_set_data_ulong(0L);
long unused_data_addr_2 = mir_set_data_int(0);
long unused_data_addr_3 = mir_set_data_int(0);
long unused_data_addr_4 = mir_set_data_int(0);
long m1___stdout = mir_set_data_int(1);
long unused_data_addr_5 = mir_set_data_int(0);
long unused_data_addr_6 = mir_set_data_ulong(0L);
long unused_data_addr_7 = mir_set_data_int(0);
long unused_data_addr_8 = mir_set_data_int(0);
long unused_data_addr_9 = mir_set_data_int(0);
long m1___stderr = mir_set_data_int(2);
long unused_data_addr_10 = mir_set_data_int(0);
long unused_data_addr_11 = mir_set_data_ulong(0L);
long unused_data_addr_12 = mir_set_data_int(0);
long unused_data_addr_13 = mir_set_data_int(0);
long unused_data_addr_14 = mir_set_data_int(0);
long m1_stdin = mir_set_data_ref(m1___stdin + 0);
long stdout = mir_set_data_ref(m1___stdout + 0);
long m1_stderr = mir_set_data_ref(m1___stderr + 0);
public void __assert (long _U0_expression, long _U0_file, int _i0_line, long _U0_function) {
  long U0_expression = _U0_expression;
  long U0_file = _U0_file;
  long i0_line = _i0_line;
  long U0_function = _U0_function;
  abort();
  return;
} // End of function __assert

public int isalnum (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  long i_4 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  i_0 = isalpha((int) i0_c);
  I_1 = (long) (int) i_0;
  if (((long) I_1 != 0)) { mir_label = 1; break; }
case 2:
  i_2 = isdigit((int) i0_c);
  I_3 = (long) (int) i_2;
  if (((long) I_3 == 0)) { mir_label = 3; break; }
case 1:
  i_4 = 1L;
  mir_label = 4; break;
case 3:
  i_4 = 0L;
case 4:
  return (int) i_4;
} // End of switch
} // End of while
} // End of function isalnum

public int isalpha (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  long i_4 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  i_0 = isupper((int) i0_c);
  I_1 = (long) (int) i_0;
  if (((long) I_1 != 0)) { mir_label = 5; break; }
case 6:
  i_2 = islower((int) i0_c);
  I_3 = (long) (int) i_2;
  if (((long) I_3 == 0)) { mir_label = 7; break; }
case 5:
  i_4 = 1L;
  mir_label = 8; break;
case 7:
  i_4 = 0L;
case 8:
  return (int) i_4;
} // End of switch
} // End of while
} // End of function isalpha

public int isascii (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((int) i0_c < (int) 0L) { mir_label = 9; break; }
case 10:
  if ((int) i0_c > (int) 127L) { mir_label = 9; break; }
case 11:
  i_2 = 1L;
  mir_label = 12; break;
case 9:
  i_2 = 0L;
case 12:
  return (int) i_2;
} // End of switch
} // End of while
} // End of function isascii

public int isblank (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((int) i0_c == (int) 32L) { mir_label = 13; break; }
case 14:
  if ((int) i0_c != (int) 9L) { mir_label = 15; break; }
case 13:
  i_2 = 1L;
  mir_label = 16; break;
case 15:
  i_2 = 0L;
case 16:
  return (int) i_2;
} // End of switch
} // End of while
} // End of function isblank

public int iscntrl (int _i0_c) {
  long i0_c = _i0_c;
  long u_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  long i_3 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  u_0 = i0_c;
  if (Integer.compareUnsigned((int) u_0, (int) 32L) < 0) { mir_label = 17; break; }
case 18:
  if ((int) i0_c != (int) 127L) { mir_label = 19; break; }
case 17:
  i_3 = 1L;
  mir_label = 20; break;
case 19:
  i_3 = 0L;
case 20:
  return (int) i_3;
} // End of switch
} // End of while
} // End of function iscntrl

public int isdigit (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((int) i0_c < (int) 48L) { mir_label = 21; break; }
case 22:
  if ((int) i0_c > (int) 57L) { mir_label = 21; break; }
case 23:
  i_2 = 1L;
  mir_label = 24; break;
case 21:
  i_2 = 0L;
case 24:
  return (int) i_2;
} // End of switch
} // End of while
} // End of function isdigit

public int isgraph (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((int) i0_c < (int) 33L) { mir_label = 25; break; }
case 26:
  if ((int) i0_c > (int) 126L) { mir_label = 25; break; }
case 27:
  i_2 = 1L;
  mir_label = 28; break;
case 25:
  i_2 = 0L;
case 28:
  return (int) i_2;
} // End of switch
} // End of while
} // End of function isgraph

public int islower (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((int) i0_c < (int) 97L) { mir_label = 29; break; }
case 30:
  if ((int) i0_c > (int) 122L) { mir_label = 29; break; }
case 31:
  i_2 = 1L;
  mir_label = 32; break;
case 29:
  i_2 = 0L;
case 32:
  return (int) i_2;
} // End of switch
} // End of while
} // End of function islower

public int isprint (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((int) i0_c < (int) 32L) { mir_label = 33; break; }
case 34:
  if ((int) i0_c > (int) 126L) { mir_label = 33; break; }
case 35:
  i_2 = 1L;
  mir_label = 36; break;
case 33:
  i_2 = 0L;
case 36:
  return (int) i_2;
} // End of switch
} // End of while
} // End of function isprint

public int ispunct (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  long i_4 = 0;
  long I_5 = 0;
  long i_6 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  i_0 = isprint((int) i0_c);
  I_1 = (long) (int) i_0;
  if (((long) I_1 == 0)) { mir_label = 37; break; }
case 38:
  i_2 = isspace((int) i0_c);
  I_3 = (long) (int) i_2;
  if (((long) I_3 != 0)) { mir_label = 37; break; }
case 39:
  i_4 = isalnum((int) i0_c);
  I_5 = (long) (int) i_4;
  if (((long) I_5 != 0)) { mir_label = 37; break; }
case 40:
  i_6 = 1L;
  mir_label = 41; break;
case 37:
  i_6 = 0L;
case 41:
  return (int) i_6;
} // End of switch
} // End of while
} // End of function ispunct

public int isspace (int _i0_c) {
  long i0_c = _i0_c;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((int) i0_c == (int) 32L) { mir_label = 42; break; }
  if ((int) i0_c == (int) 12L) { mir_label = 42; break; }
  if ((int) i0_c == (int) 10L) { mir_label = 42; break; }
  if ((int) i0_c == (int) 13L) { mir_label = 42; break; }
  if ((int) i0_c == (int) 9L) { mir_label = 42; break; }
  if ((int) i0_c != (int) 11L) { mir_label = 43; break; }
case 42:
  return (int) 1L;
case 43:
  return (int) 0L;
case 44:
  return (int) 0L;
} // End of switch
} // End of while
} // End of function isspace

public int isupper (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((int) i0_c < (int) 65L) { mir_label = 45; break; }
case 46:
  if ((int) i0_c > (int) 90L) { mir_label = 45; break; }
case 47:
  i_2 = 1L;
  mir_label = 48; break;
case 45:
  i_2 = 0L;
case 48:
  return (int) i_2;
} // End of switch
} // End of while
} // End of function isupper

public int isxdigit (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  long i_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((int) i0_c < (int) 48L) { mir_label = 49; break; }
case 50:
  if ((int) i0_c <= (int) 57L) { mir_label = 51; break; }
case 49:
  if ((int) i0_c < (int) 97L) { mir_label = 52; break; }
case 53:
  if ((int) i0_c <= (int) 102L) { mir_label = 51; break; }
case 52:
  if ((int) i0_c < (int) 65L) { mir_label = 54; break; }
case 55:
  if ((int) i0_c > (int) 70L) { mir_label = 54; break; }
case 51:
  i_6 = 1L;
  mir_label = 56; break;
case 54:
  i_6 = 0L;
case 56:
  return (int) i_6;
} // End of switch
} // End of while
} // End of function isxdigit

public int tolower (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long i_3 = 0;
  long i_4 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  i_0 = isupper((int) i0_c);
  I_1 = (long) (int) i_0;
  if (((long) I_1 == 0)) { mir_label = 57; break; }
case 58:
  i_2 = (int) i0_c - (int) 65L;
  i_3 = (int) 97L + (int) i_2;
  i_4 = i_3;
  mir_label = 59; break;
case 57:
  i_4 = i0_c;
case 59:
  return (int) i_4;
} // End of switch
} // End of while
} // End of function tolower

public int toupper (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long i_3 = 0;
  long i_4 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  i_0 = islower((int) i0_c);
  I_1 = (long) (int) i_0;
  if (((long) I_1 == 0)) { mir_label = 60; break; }
case 61:
  i_2 = (int) i0_c - (int) 97L;
  i_3 = (int) 65L + (int) i_2;
  i_4 = i_3;
  mir_label = 62; break;
case 60:
  i_4 = i0_c;
case 62:
  return (int) i_4;
} // End of switch
} // End of while
} // End of function toupper

long __errno = mir_allocate(4);
long m1__LP_C_digits = mir_set_data_ubytes(new short[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 0 });
protected long m1_strtox_prelim (long _U0_p, long _U0_sign, long _U0_base) {
  long U0_p = _U0_p;
  long U0_sign = _U0_sign;
  long U0_base = _U0_base;
  long i_0 = 0;
  long I_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long i_4 = 0;
  long I_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long I_8 = 0;
  long U_9 = 0;
  long U_10 = 0;
  long I_11 = 0;
  long i_12 = 0;
  long U_13 = 0;
  long U_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long i_18 = 0;
  long U_19 = 0;
  long U_20 = 0;
  long U_21 = 0;
  long I_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long U_25 = 0;
  long U_26 = 0;
  long i_27 = 0;
  long U_28 = 0;
  long U_29 = 0;
  long i_30 = 0;
  long i_31 = 0;
  long U_32 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
case 63:
  i_0 = isspace((int) mir_read_byte(U0_p));
  I_1 = (long) (int) i_0;
  if (((long) I_1 == 0)) { mir_label = 64; break; }
case 65:
  U_2 = U0_p;
  U_2 = (long) U_2 + (long) 1L;
  U0_p = U_2;
  i_4 = isspace((int) mir_read_byte(U0_p));
  I_5 = (long) (int) i_4;
  if (((long) I_5 != 0)) { mir_label = 65; break; }
case 64:
  if ((int) mir_read_byte(U0_p) == (int) 43L) { mir_label = 66; break; }
case 67:
  if ((int) mir_read_byte(U0_p) == (int) 45L) { mir_label = 66; break; }
case 68:
  I_8 = (long) (byte) 43L;
  mir_write_byte(U0_sign, I_8);
  mir_label = 69; break;
case 66:
  U_9 = U0_p;
  U_10 = U0_p;
  U_10 = (long) U_10 + (long) 1L;
  U0_p = U_10;
  I_11 = (long) (byte) mir_read_byte(U_9);
  mir_write_byte(U0_sign, I_11);
case 69:
  if ((int) mir_read_byte(U0_p) != (int) 48L) { mir_label = 70; break; }
case 71:
  U_13 = U0_p;
  U_13 = (long) U_13 + (long) 1L;
  U0_p = U_13;
  if ((int) mir_read_int(U0_base) == (int) 0L) { mir_label = 72; break; }
case 73:
  if ((int) mir_read_int(U0_base) != (int) 16L) { mir_label = 74; break; }
case 72:
  if ((int) mir_read_byte(U0_p) == (int) 120L) { mir_label = 75; break; }
case 76:
  if ((int) mir_read_byte(U0_p) != (int) 88L) { mir_label = 74; break; }
case 75:
  mir_write_int(U0_base, 16L);
  U_19 = U0_p;
  U_19 = (long) U_19 + (long) 1L;
  U0_p = U_19;
  I_22 = m1__LP_C_digits;
  i_23 = tolower((int) mir_read_byte(U0_p));
  U_21 = memchr((long) I_22, (int) i_23, (long) mir_read_int(U0_base));
  if ((long) U_21 != (long) 0L) { mir_label = 77; break; }
case 78:
  U_25 = U0_p;
  U_25 = (long) U_25 - (long) 2L;
  U0_p = U_25;
  mir_label = 79; break;
case 77:
case 79:
  mir_label = 80; break;
case 74:
  if ((int) mir_read_int(U0_base) != (int) 0L) { mir_label = 81; break; }
case 82:
  mir_write_int(U0_base, 8L);
  mir_label = 83; break;
case 81:
  U_28 = U0_p;
  U_28 = (long) U_28 - (long) 1L;
  U0_p = U_28;
case 83:
case 80:
  mir_label = 84; break;
case 70:
  if (((long) mir_read_int(U0_base) != 0)) { mir_label = 85; break; }
case 86:
  mir_write_int(U0_base, 10L);
  mir_label = 87; break;
case 85:
case 87:
case 84:
  if ((int) mir_read_int(U0_base) < (int) 2L) { mir_label = 88; break; }
case 89:
  if ((int) mir_read_int(U0_base) > (int) 36L) { mir_label = 88; break; }
case 90:
  U_32 = U0_p;
  mir_label = 91; break;
case 88:
  U_32 = 0L;
case 91:
  return (long) U_32;
} // End of switch
} // End of while
} // End of function strtox_prelim

protected long m1_strtox_main (long _U0_p, long _u0_base, long _U0_error, long _U0_limval, int _i0_limdigit, long _U0_sign) {
  long U0_p = _U0_p;
  long u0_base = _u0_base;
  long U0_error = _U0_error;
  long U0_limval = _U0_limval;
  long i0_limdigit = _i0_limdigit;
  long U0_sign = _U0_sign;
  long U0_rc = 0;
  long i0_digit = 0;
  long U0_x = 0;
  long U_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long U_6 = 0;
  long i_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long i_10 = 0;
  long i_11 = 0;
  long i_12 = 0;
  long U_13 = 0;
  long U_14 = 0;
  long u_15 = 0;
  long U_16 = 0;
  long U_17 = 0;
  long U_18 = 0;
  long U_19 = 0;
  long I_20 = 0;
  long U_21 = 0;
  long I_22 = 0;
  long i_23 = 0;
  long I_24 = 0;
  long U_25 = 0;
  long i_26 = 0;
  long U_27 = 0;
  long U_28 = 0;
  long U_29 = 0;
  long I_30 = 0;
  long i_31 = 0;
  long I_32 = 0;
  long U_33 = 0;
  long i_34 = 0;
  long I_35 = 0;
  long U_36 = 0;
  long I_37 = 0;
  long i_38 = 0;
  long I_39 = 0;
  long U_40 = 0;
  long U_41 = 0;
  long U_42 = 0;
  long i_43 = 0;
  long i_44 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_rc = 0L;
  i0_digit = -1L;
case 92:
  I_1 = m1__LP_C_digits;
  I_3 = mir_read_ulong(U0_p);
  i_2 = tolower((int) mir_read_byte(I_3));
  U_4 = (((long) u0_base) & 0xFFFFFFFFL);
  U_0 = memchr((long) I_1, (int) i_2, (long) U_4);
  U_5 = U_0;
  U0_x = U_5;
  U_6 = U_5;
  if ((long) U_6 == (long) 0L) { mir_label = 93; break; }
case 94:
  I_8 = m1__LP_C_digits;
  I_9 = (long) U0_x - (long) I_8;
  I_9 = (long) I_9 / (long) 1L;
  i0_digit = I_9;
  if (Long.compareUnsigned((long) U0_rc, (long) U0_limval) < 0) { mir_label = 95; break; }
case 96:
  if ((long) U0_rc != (long) U0_limval) { mir_label = 97; break; }
case 98:
  if ((int) i0_digit > (int) i0_limdigit) { mir_label = 97; break; }
case 95:
  U_13 = (((long) u0_base) & 0xFFFFFFFFL);
  U_14 = (long) U0_rc * (long) U_13;
  u_15 = i0_digit;
  U_16 = (((long) u_15) & 0xFFFFFFFFL);
  U_17 = (long) U_14 + (long) U_16;
  U0_rc = U_17;
  U_18 = mir_read_ulong(U0_p);
  U_18 = (long) U_18 + (long) 1L;
  mir_write_ulong(U0_p, U_18);
  mir_label = 99; break;
case 97:
  I_20 = __errno;
  mir_write_int(I_20, 3L);
case 100:
  I_22 = m1__LP_C_digits;
  I_24 = mir_read_ulong(U0_p);
  i_23 = tolower((int) mir_read_byte(I_24));
  U_25 = (((long) u0_base) & 0xFFFFFFFFL);
  U_21 = memchr((long) I_22, (int) i_23, (long) U_25);
  if ((long) U_21 == (long) 0L) { mir_label = 101; break; }
case 102:
  U_27 = mir_read_ulong(U0_p);
  U_27 = (long) U_27 + (long) 1L;
  mir_write_ulong(U0_p, U_27);
  I_30 = m1__LP_C_digits;
  I_32 = mir_read_ulong(U0_p);
  i_31 = tolower((int) mir_read_byte(I_32));
  U_33 = (((long) u0_base) & 0xFFFFFFFFL);
  U_29 = memchr((long) I_30, (int) i_31, (long) U_33);
  if ((long) U_29 != (long) 0L) { mir_label = 102; break; }
case 101:
  I_35 = (long) (byte) 43L;
  mir_write_byte(U0_sign, I_35);
  return (long) U0_error;
case 99:
  I_37 = m1__LP_C_digits;
  I_39 = mir_read_ulong(U0_p);
  i_38 = tolower((int) mir_read_byte(I_39));
  U_40 = (((long) u0_base) & 0xFFFFFFFFL);
  U_36 = memchr((long) I_37, (int) i_38, (long) U_40);
  U_41 = U_36;
  U0_x = U_41;
  U_42 = U_41;
  if ((long) U_42 != (long) 0L) { mir_label = 94; break; }
case 93:
  if ((int) i0_digit != (int) -1L) { mir_label = 103; break; }
case 104:
  mir_write_ulong(U0_p, 0L);
  return (long) 0L;
  // Dead code: mir_label = 105; break;
case 103:
case 105:
  return (long) U0_rc;
} // End of switch
} // End of while
} // End of function strtox_main

public long strtoimax (long _U0_nptr, long _U0_endptr, int _i0_base) {
  long U0_nptr = _U0_nptr;
  long U0_endptr = _U0_endptr;
  long i0_base = _i0_base;
  long fp = 0;
  long I_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long U0_a = 0;
  long U0_b = 0;
  long I_7 = 0;
  long U_8 = 0;
  long i0_c = 0;
  long I_9 = 0;
  long i_10 = 0;
  long i_11 = 0;
  long I_12 = 0;
  long I_13 = 0;
  long U_14 = 0;
  long I_15 = 0;
  long I_16 = 0;
  long i_17 = 0;
  long I0_rc = 0;
  long U_18 = 0;
  long U_19 = 0;
  long u_20 = 0;
  long U_21 = 0;
  long I_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long U_25 = 0;
  long U_26 = 0;
  long U_27 = 0;
  long i_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  mir_write_int(4L + fp, i0_base);
  I_0 = (long) (byte) 43L;
  mir_write_byte(fp, I_0);
  U_2 = fp;
  U_3 = 4L;
  U_3 = (long) U_3 + (long) fp;
  U_1 = m1_strtox_prelim((long) U0_nptr, (long) U_2, (long) U_3);
  mir_write_ulong(8L + fp, U_1);
  if ((int) mir_read_int(4L + fp) < (int) 2L) { mir_label = 106; break; }
case 107:
  if ((int) mir_read_int(4L + fp) <= (int) 36L) { mir_label = 108; break; }
case 106:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) 0L;
  // Dead code: mir_label = 109; break;
case 108:
case 109:
  if ((int) mir_read_byte(fp) != (int) 43L) { mir_label = 110; break; }
case 111:
  U0_a = 9223372036854775807L;
  I_7 = (long) 9223372036854775807L / (long) mir_read_int(4L + fp);
  U_8 = I_7;
  U0_b = U_8;
  I_9 = (long) 9223372036854775807L % (long) mir_read_int(4L + fp);
  i_10 = I_9;
  i0_c = i_10;
  mir_label = 112; break;
case 110:
  U0_a = -9223372036854775808L;
  i_11 = - (int) mir_read_int(4L + fp);
  I_12 = (long) (int) i_11;
  I_13 = (long) -9223372036854775808L / (long) I_12;
  U_14 = I_13;
  U0_b = U_14;
  I_15 = (long) -9223372036854775808L % (long) mir_read_int(4L + fp);
  I_16 = - (long) I_15;
  i_17 = I_16;
  i0_c = i_17;
case 112:
  U_19 = 8L;
  U_19 = (long) U_19 + (long) fp;
  u_20 = mir_read_int(4L + fp);
  U_21 = fp;
  U_18 = m1_strtox_main((long) U_19, (long) u_20, (long) U0_a, (long) U0_b, (int) i0_c, (long) U_21);
  I_22 = U_18;
  I0_rc = I_22;
  if ((long) U0_endptr == (long) 0L) { mir_label = 113; break; }
case 114:
  if ((long) mir_read_ulong(8L + fp) == (long) 0L) { mir_label = 115; break; }
case 116:
  U_25 = mir_read_ulong(8L + fp);
  U_26 = U_25;
  mir_label = 117; break;
case 115:
  U_27 = U0_nptr;
  U_26 = U_27;
case 117:
  mir_write_ulong(U0_endptr, U_26);
  mir_label = 118; break;
case 113:
case 118:
  if ((int) mir_read_byte(fp) != (int) 43L) { mir_label = 119; break; }
case 120:
  I_29 = I0_rc;
  mir_label = 121; break;
case 119:
  I_30 = - (long) I0_rc;
  I_29 = I_30;
case 121:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) I_29;
} // End of switch
} // End of while
} // End of function strtoimax

public long strtoumax (long _U0_nptr, long _U0_endptr, int _i0_base) {
  long U0_nptr = _U0_nptr;
  long U0_endptr = _U0_endptr;
  long i0_base = _i0_base;
  long fp = 0;
  long I_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long U0_rc = 0;
  long U_6 = 0;
  long U_7 = 0;
  long u_8 = 0;
  long U_9 = 0;
  long U_10 = 0;
  long U_11 = 0;
  long i_12 = 0;
  long U_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long U_16 = 0;
  long U_17 = 0;
  long U_18 = 0;
  long i_19 = 0;
  long U_20 = 0;
  long U_21 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  mir_write_int(4L + fp, i0_base);
  I_0 = (long) (byte) 43L;
  mir_write_byte(fp, I_0);
  U_2 = fp;
  U_3 = 4L;
  U_3 = (long) U_3 + (long) fp;
  U_1 = m1_strtox_prelim((long) U0_nptr, (long) U_2, (long) U_3);
  mir_write_ulong(8L + fp, U_1);
  if ((int) mir_read_int(4L + fp) < (int) 2L) { mir_label = 122; break; }
case 123:
  if ((int) mir_read_int(4L + fp) <= (int) 36L) { mir_label = 124; break; }
case 122:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) 0L;
  // Dead code: mir_label = 125; break;
case 124:
case 125:
  U_7 = 8L;
  U_7 = (long) U_7 + (long) fp;
  u_8 = mir_read_int(4L + fp);
  U_9 = (long) Long.divideUnsigned((long) -1L, (long) mir_read_int(4L + fp));
  U_10 = U_9;
  U_11 = (long) Long.remainderUnsigned((long) -1L, (long) mir_read_int(4L + fp));
  i_12 = U_11;
  U_13 = fp;
  U_6 = m1_strtox_main((long) U_7, (long) u_8, (long) -1L, (long) U_10, (int) i_12, (long) U_13);
  U0_rc = U_6;
  if ((long) U0_endptr == (long) 0L) { mir_label = 126; break; }
case 127:
  if ((long) mir_read_ulong(8L + fp) == (long) 0L) { mir_label = 128; break; }
case 129:
  U_16 = mir_read_ulong(8L + fp);
  U_17 = U_16;
  mir_label = 130; break;
case 128:
  U_18 = U0_nptr;
  U_17 = U_18;
case 130:
  mir_write_ulong(U0_endptr, U_17);
  mir_label = 131; break;
case 126:
case 131:
  if ((int) mir_read_byte(fp) != (int) 43L) { mir_label = 132; break; }
case 133:
  U_20 = U0_rc;
  mir_label = 134; break;
case 132:
  U_21 = - (long) U0_rc;
  U_20 = U_21;
case 134:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) U_20;
} // End of switch
} // End of while
} // End of function strtoumax

public long imaxabs (long I0_j) {
  long i_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((long) I0_j < (long) 0L) { mir_label = 135; break; }
case 136:
  I_1 = I0_j;
  mir_label = 137; break;
case 135:
  I_2 = - (long) I0_j;
  I_1 = I_2;
case 137:
  return (long) I_1;
} // End of switch
} // End of while
} // End of function imaxabs

public long memchr (long _U0_s, int _i0_c, long _U0_n) {
  long U0_s = _U0_s;
  long i0_c = _i0_c;
  long U0_n = _U0_n;
  long U0_p = 0;
  long U_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long I_3 = 0;
  long i_4 = 0;
  long U_5 = 0;
  long U_6 = 0;
  long U_7 = 0;
  long U_8 = 0;
  long U_9 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U_0 = U0_s;
  U0_p = U_0;
case 138:
  U_1 = U0_n;
  U_2 = U0_n;
  U_2 = (long) U_2 - (long) 1L;
  U0_n = U_2;
  if (((long) U_1 == 0)) { mir_label = 139; break; }
case 140:
  I_3 = (((long) (int) i0_c) & 0xFFL);
  if ((int) mir_read_ubyte(U0_p) != (int) I_3) { mir_label = 141; break; }
case 142:
  U_5 = U0_p;
  return (long) U_5;
  // Dead code: mir_label = 143; break;
case 141:
case 143:
  U_6 = U0_p;
  U_6 = (long) U_6 + (long) 1L;
  U0_p = U_6;
  U_8 = U0_n;
  U_9 = U0_n;
  U_9 = (long) U_9 - (long) 1L;
  U0_n = U_9;
  if (((long) U_8 != 0)) { mir_label = 140; break; }
case 139:
  return (long) 0L;
} // End of switch
} // End of while
} // End of function memchr

public int memcmp (long _U0_s1, long _U0_s2, long _U0_n) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long U0_n = _U0_n;
  long U0_p1 = 0;
  long U_0 = 0;
  long U0_p2 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long U_6 = 0;
  long U_7 = 0;
  long U_8 = 0;
  long U_9 = 0;
  long U_10 = 0;
  long U_11 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U_0 = U0_s1;
  U0_p1 = U_0;
  U_1 = U0_s2;
  U0_p2 = U_1;
case 144:
  U_2 = U0_n;
  U_3 = U0_n;
  U_3 = (long) U_3 - (long) 1L;
  U0_n = U_3;
  if (((long) U_2 == 0)) { mir_label = 145; break; }
case 146:
  if ((int) mir_read_ubyte(U0_p1) == (int) mir_read_ubyte(U0_p2)) { mir_label = 147; break; }
case 148:
  i_5 = (int) mir_read_ubyte(U0_p1) - (int) mir_read_ubyte(U0_p2);
  return (int) i_5;
  // Dead code: mir_label = 149; break;
case 147:
case 149:
  U_6 = U0_p1;
  U_6 = (long) U_6 + (long) 1L;
  U0_p1 = U_6;
  U_8 = U0_p2;
  U_8 = (long) U_8 + (long) 1L;
  U0_p2 = U_8;
  U_10 = U0_n;
  U_11 = U0_n;
  U_11 = (long) U_11 - (long) 1L;
  U0_n = U_11;
  if (((long) U_10 != 0)) { mir_label = 146; break; }
case 145:
  return (int) 0L;
} // End of switch
} // End of while
} // End of function memcmp

public long memmove (long _U0_s1, long _U0_s2, long _U0_n) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long U0_n = _U0_n;
  long U0_dest = 0;
  long U_0 = 0;
  long U0_src = 0;
  long U_1 = 0;
  long i_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long U_6 = 0;
  long U_7 = 0;
  long U_8 = 0;
  long I_9 = 0;
  long U_10 = 0;
  long U_11 = 0;
  long U_12 = 0;
  long U_13 = 0;
  long U_14 = 0;
  long U_15 = 0;
  long U_16 = 0;
  long U_17 = 0;
  long U_18 = 0;
  long U_19 = 0;
  long U_20 = 0;
  long U_21 = 0;
  long U_22 = 0;
  long U_23 = 0;
  long I_24 = 0;
  long U_25 = 0;
  long U_26 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U_0 = U0_s1;
  U0_dest = U_0;
  U_1 = U0_s2;
  U0_src = U_1;
  if (Long.compareUnsigned((long) U0_dest, (long) U0_src) > 0) { mir_label = 150; break; }
case 151:
case 152:
  U_3 = U0_n;
  U_4 = U0_n;
  U_4 = (long) U_4 - (long) 1L;
  U0_n = U_4;
  if (((long) U_3 == 0)) { mir_label = 153; break; }
case 154:
  U_5 = U0_dest;
  U_6 = U0_dest;
  U_6 = (long) U_6 + (long) 1L;
  U0_dest = U_6;
  U_7 = U0_src;
  U_8 = U0_src;
  U_8 = (long) U_8 + (long) 1L;
  U0_src = U_8;
  I_9 = (long) (byte) mir_read_byte(U_7);
  mir_write_byte(U_5, I_9);
  U_10 = U0_n;
  U_11 = U0_n;
  U_11 = (long) U_11 - (long) 1L;
  U0_n = U_11;
  if (((long) U_10 != 0)) { mir_label = 154; break; }
case 153:
  mir_label = 155; break;
case 150:
  U_12 = U0_src;
  U_13 = (long) U0_n * (long) 1L;
  U_12 = (long) U_12 + (long) U_13;
  U0_src = U_12;
  U_15 = U0_dest;
  U_16 = (long) U0_n * (long) 1L;
  U_15 = (long) U_15 + (long) U_16;
  U0_dest = U_15;
case 156:
  U_18 = U0_n;
  U_19 = U0_n;
  U_19 = (long) U_19 - (long) 1L;
  U0_n = U_19;
  if (((long) U_18 == 0)) { mir_label = 157; break; }
case 158:
  U_20 = U0_dest;
  U_20 = (long) U_20 - (long) 1L;
  U0_dest = U_20;
  U_21 = U_20;
  U_22 = U0_src;
  U_22 = (long) U_22 - (long) 1L;
  U0_src = U_22;
  U_23 = U_22;
  I_24 = (long) (byte) mir_read_byte(U_23);
  mir_write_byte(U_21, I_24);
  U_25 = U0_n;
  U_26 = U0_n;
  U_26 = (long) U_26 - (long) 1L;
  U0_n = U_26;
  if (((long) U_25 != 0)) { mir_label = 158; break; }
case 157:
case 155:
  return (long) U0_s1;
} // End of switch
} // End of while
} // End of function memmove

public long strcat (long _U0_s1, long _U0_s2) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long U0_rc = 0;
  long U_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long U_6 = 0;
  long U_7 = 0;
  long i_8 = 0;
  long i_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  long U_12 = 0;
  long U_13 = 0;
  long U_14 = 0;
  long U_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_rc = U0_s1;
  if (((long) mir_read_byte(U0_s1) == 0)) { mir_label = 159; break; }
case 160:
case 161:
  U_0 = U0_s1;
  U_0 = (long) U_0 + (long) 1L;
  U0_s1 = U_0;
  U_1 = U_0;
  if (((long) mir_read_byte(U_1) == 0)) { mir_label = 162; break; }
case 163:
  U_2 = U0_s1;
  U_2 = (long) U_2 + (long) 1L;
  U0_s1 = U_2;
  U_3 = U_2;
  if (((long) mir_read_byte(U_3) != 0)) { mir_label = 163; break; }
case 162:
  mir_label = 164; break;
case 159:
case 164:
case 165:
  U_4 = U0_s1;
  U_5 = U0_s1;
  U_5 = (long) U_5 + (long) 1L;
  U0_s1 = U_5;
  U_6 = U0_s2;
  U_7 = U0_s2;
  U_7 = (long) U_7 + (long) 1L;
  U0_s2 = U_7;
  i_8 = mir_read_byte(U_6);
  I_10 = (long) (byte) i_8;
  mir_write_byte(U_4, I_10);
  i_9 = I_10;
  I_11 = (long) (int) i_9;
  if (((long) I_11 == 0)) { mir_label = 166; break; }
case 167:
  U_12 = U0_s1;
  U_13 = U0_s1;
  U_13 = (long) U_13 + (long) 1L;
  U0_s1 = U_13;
  U_14 = U0_s2;
  U_15 = U0_s2;
  U_15 = (long) U_15 + (long) 1L;
  U0_s2 = U_15;
  i_16 = mir_read_byte(U_14);
  I_18 = (long) (byte) i_16;
  mir_write_byte(U_12, I_18);
  i_17 = I_18;
  I_19 = (long) (int) i_17;
  if (((long) I_19 != 0)) { mir_label = 167; break; }
case 166:
  return (long) U0_rc;
} // End of switch
} // End of while
} // End of function strcat

public long strchr (long _U0_s, int _i0_c) {
  long U0_s = _U0_s;
  long i0_c = _i0_c;
  long i_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long U_3 = 0;
  long i_4 = 0;
  long I_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long i_8 = 0;
  long U_9 = 0;
  long U_10 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
case 168:
  if ((int) mir_read_byte(U0_s) == (int) 0L) { mir_label = 169; break; }
case 170:
  I_1 = (long) (byte) i0_c;
  if ((int) mir_read_byte(U0_s) == (int) I_1) { mir_label = 169; break; }
case 171:
  U_3 = U0_s;
  U_3 = (long) U_3 + (long) 1L;
  U0_s = U_3;
  if ((int) mir_read_byte(U0_s) == (int) 0L) { mir_label = 169; break; }
case 172:
  I_5 = (long) (byte) i0_c;
  if ((int) mir_read_byte(U0_s) != (int) I_5) { mir_label = 171; break; }
case 169:
  if ((int) mir_read_byte(U0_s) != (int) 0L) { mir_label = 173; break; }
case 174:
  if ((int) i0_c != (int) 0L) { mir_label = 175; break; }
case 173:
  U_9 = U0_s;
  U_10 = U_9;
  mir_label = 176; break;
case 175:
  U_10 = 0L;
case 176:
  return (long) U_10;
} // End of switch
} // End of while
} // End of function strchr

public int strcmp (long _U0_s1, long _U0_s2) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long U0_p1 = 0;
  long U_0 = 0;
  long U0_p2 = 0;
  long U_1 = 0;
  long i_2 = 0;
  long i_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long U_6 = 0;
  long i_7 = 0;
  long i_8 = 0;
  long i_9 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U_0 = U0_s1;
  U0_p1 = U_0;
  U_1 = U0_s2;
  U0_p2 = U_1;
case 177:
  if ((int) mir_read_ubyte(U0_p1) == (int) 0L) { mir_label = 178; break; }
case 179:
  if ((int) mir_read_ubyte(U0_p1) != (int) mir_read_ubyte(U0_p2)) { mir_label = 178; break; }
case 180:
  U_4 = U0_p1;
  U_4 = (long) U_4 + (long) 1L;
  U0_p1 = U_4;
  U_5 = U0_p2;
  U_6 = U0_p2;
  U_6 = (long) U_6 + (long) 1L;
  U0_p2 = U_6;
  if ((int) mir_read_ubyte(U0_p1) == (int) 0L) { mir_label = 178; break; }
case 181:
  if ((int) mir_read_ubyte(U0_p1) == (int) mir_read_ubyte(U0_p2)) { mir_label = 180; break; }
case 178:
  i_9 = (int) mir_read_ubyte(U0_p1) - (int) mir_read_ubyte(U0_p2);
  return (int) i_9;
} // End of switch
} // End of while
} // End of function strcmp

public int strcoll (long _U0_s1, long _U0_s2) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long i_0 = 0;
  i_0 = strcmp((long) U0_s1, (long) U0_s2);
  return (int) i_0;
} // End of function strcoll

public long strcspn (long _U0_s1, long _U0_s2) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long U0_result = 0;
  long i_0 = 0;
  long U_1 = 0;
  long i_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long i_6 = 0;
  long U_7 = 0;
  long i_8 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_result = 0L;
case 182:
  if ((int) mir_read_byte(U0_s1) == (int) 0L) { mir_label = 183; break; }
case 184:
  U_1 = strchr((long) U0_s2, (int) mir_read_byte(U0_s1));
  if ((long) U_1 != (long) 0L) { mir_label = 183; break; }
case 185:
  U_3 = U0_s1;
  U_3 = (long) U_3 + (long) 1L;
  U0_s1 = U_3;
  U_4 = U0_result;
  U_5 = U0_result;
  U_5 = (long) U_5 + (long) 1L;
  U0_result = U_5;
  if ((int) mir_read_byte(U0_s1) == (int) 0L) { mir_label = 183; break; }
case 186:
  U_7 = strchr((long) U0_s2, (int) mir_read_byte(U0_s1));
  if ((long) U_7 == (long) 0L) { mir_label = 185; break; }
case 183:
  return (long) U0_result;
} // End of switch
} // End of while
} // End of function strcspn

public long strdup (long _U0_s) {
  long U0_s = _U0_s;
  long U0_ns = 0;
  long U1_len = 0;
  long U_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_ns = 0L;
  if (((long) U0_s == 0)) { mir_label = 187; break; }
case 188:
  U_0 = strlen((long) U0_s);
  U_1 = (long) U_0 + (long) 1L;
  U1_len = U_1;
  U_2 = malloc((long) U1_len);
  U0_ns = U_2;
  if (((long) U0_ns == 0)) { mir_label = 189; break; }
case 190:
  U_3 = strncpy((long) U0_ns, (long) U0_s, (long) U1_len);
  mir_label = 191; break;
case 189:
case 191:
  mir_label = 192; break;
case 187:
case 192:
  return (long) U0_ns;
} // End of switch
} // End of while
} // End of function strdup

public long strerror (int _i0_errnum) {
  long i0_errnum = _i0_errnum;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((int) i0_errnum == (int) 1L) { mir_label = 193; break; }
  if ((int) i0_errnum == (int) 2L) { mir_label = 194; break; }
  if ((int) i0_errnum == (int) 3L) { mir_label = 195; break; }
  mir_label = 196; break;
case 193:
  return (long) mir_get_string_ptr("Numerical argument out of domain");
case 194:
  return (long) mir_get_string_ptr("Illegal byte sequence");
case 195:
  return (long) mir_get_string_ptr("Result too large");
case 196:
  return (long) mir_get_string_ptr("Unknown error");
case 197:
  return (long) 0L;
} // End of switch
} // End of while
} // End of function strerror

public long strncat (long _U0_s1, long _U0_s2, long _U0_n) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long U0_n = _U0_n;
  long U0_rc = 0;
  long U_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long U_10 = 0;
  long U_11 = 0;
  long U_12 = 0;
  long U_13 = 0;
  long U_14 = 0;
  long U_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  long i_20 = 0;
  long I_21 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_rc = U0_s1;
case 198:
  if (((long) mir_read_byte(U0_s1) == 0)) { mir_label = 199; break; }
case 200:
  U_0 = U0_s1;
  U_0 = (long) U_0 + (long) 1L;
  U0_s1 = U_0;
  if (((long) mir_read_byte(U0_s1) != 0)) { mir_label = 200; break; }
case 199:
case 201:
  if (((long) U0_n == 0)) { mir_label = 202; break; }
case 203:
  U_2 = U0_s1;
  U_3 = U0_s1;
  U_3 = (long) U_3 + (long) 1L;
  U0_s1 = U_3;
  U_4 = U0_s2;
  U_5 = U0_s2;
  U_5 = (long) U_5 + (long) 1L;
  U0_s2 = U_5;
  i_6 = mir_read_byte(U_4);
  I_8 = (long) (byte) i_6;
  mir_write_byte(U_2, I_8);
  i_7 = I_8;
  I_9 = (long) (int) i_7;
  if (((long) I_9 == 0)) { mir_label = 202; break; }
case 204:
  U_10 = U0_n;
  U_10 = (long) U_10 - (long) 1L;
  U0_n = U_10;
  if (((long) U0_n == 0)) { mir_label = 202; break; }
case 205:
  U_12 = U0_s1;
  U_13 = U0_s1;
  U_13 = (long) U_13 + (long) 1L;
  U0_s1 = U_13;
  U_14 = U0_s2;
  U_15 = U0_s2;
  U_15 = (long) U_15 + (long) 1L;
  U0_s2 = U_15;
  i_16 = mir_read_byte(U_14);
  I_18 = (long) (byte) i_16;
  mir_write_byte(U_12, I_18);
  i_17 = I_18;
  I_19 = (long) (int) i_17;
  if (((long) I_19 != 0)) { mir_label = 204; break; }
case 202:
  if ((long) U0_n != (long) 0L) { mir_label = 206; break; }
case 207:
  I_21 = (long) (byte) 0L;
  mir_write_byte(U0_s1, I_21);
  mir_label = 208; break;
case 206:
case 208:
  return (long) U0_rc;
} // End of switch
} // End of while
} // End of function strncat

public int strncmp (long _U0_s1, long _U0_s2, long _U0_n) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long U0_n = _U0_n;
  long i_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long U_6 = 0;
  long i_7 = 0;
  long i_8 = 0;
  long U_9 = 0;
  long U_10 = 0;
  long i_11 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
case 209:
  if (((long) mir_read_byte(U0_s1) == 0)) { mir_label = 210; break; }
case 211:
  if (((long) U0_n == 0)) { mir_label = 210; break; }
case 212:
  if ((int) mir_read_byte(U0_s1) != (int) mir_read_byte(U0_s2)) { mir_label = 210; break; }
case 213:
  U_1 = U0_s1;
  U_1 = (long) U_1 + (long) 1L;
  U0_s1 = U_1;
  U_3 = U0_s2;
  U_3 = (long) U_3 + (long) 1L;
  U0_s2 = U_3;
  U_5 = U0_n;
  U_5 = (long) U_5 - (long) 1L;
  U0_n = U_5;
  if (((long) mir_read_byte(U0_s1) == 0)) { mir_label = 210; break; }
case 214:
  if (((long) U0_n == 0)) { mir_label = 210; break; }
case 215:
  if ((int) mir_read_byte(U0_s1) == (int) mir_read_byte(U0_s2)) { mir_label = 213; break; }
case 210:
  if ((long) U0_n != (long) 0L) { mir_label = 216; break; }
case 217:
  return (int) 0L;
  // Dead code: mir_label = 218; break;
case 216:
  U_9 = U0_s1;
  U_10 = U0_s2;
  i_11 = (int) mir_read_ubyte(U_9) - (int) mir_read_ubyte(U_10);
  return (int) i_11;
case 218:
  return (int) 0L;
} // End of switch
} // End of while
} // End of function strncmp

public long strncpy (long _U0_s1, long _U0_s2, long _U0_n) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long U0_n = _U0_n;
  long U0_rc = 0;
  long i_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long I_7 = 0;
  long I_8 = 0;
  long U_9 = 0;
  long U_10 = 0;
  long i_11 = 0;
  long U_12 = 0;
  long U_13 = 0;
  long U_14 = 0;
  long U_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  long U_20 = 0;
  long U_21 = 0;
  long i_22 = 0;
  long U_23 = 0;
  long U_24 = 0;
  long I_25 = 0;
  long U_26 = 0;
  long U_27 = 0;
  long i_28 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_rc = U0_s1;
case 219:
  if (Long.compareUnsigned((long) U0_n, (long) 0L) <= 0) { mir_label = 220; break; }
case 221:
  U_1 = U0_s1;
  U_2 = U0_s1;
  U_2 = (long) U_2 + (long) 1L;
  U0_s1 = U_2;
  U_3 = U0_s2;
  U_4 = U0_s2;
  U_4 = (long) U_4 + (long) 1L;
  U0_s2 = U_4;
  i_5 = mir_read_byte(U_3);
  I_7 = (long) (byte) i_5;
  mir_write_byte(U_1, I_7);
  i_6 = I_7;
  I_8 = (long) (int) i_6;
  if (((long) I_8 == 0)) { mir_label = 220; break; }
case 222:
  U_9 = U0_n;
  U_9 = (long) U_9 - (long) 1L;
  U0_n = U_9;
  if (Long.compareUnsigned((long) U0_n, (long) 0L) <= 0) { mir_label = 220; break; }
case 223:
  U_12 = U0_s1;
  U_13 = U0_s1;
  U_13 = (long) U_13 + (long) 1L;
  U0_s1 = U_13;
  U_14 = U0_s2;
  U_15 = U0_s2;
  U_15 = (long) U_15 + (long) 1L;
  U0_s2 = U_15;
  i_16 = mir_read_byte(U_14);
  I_18 = (long) (byte) i_16;
  mir_write_byte(U_12, I_18);
  i_17 = I_18;
  I_19 = (long) (int) i_17;
  if (((long) I_19 != 0)) { mir_label = 222; break; }
case 220:
case 224:
  U_20 = U0_n;
  U_21 = U0_n;
  U_21 = (long) U_21 - (long) 1L;
  U0_n = U_21;
  if (Long.compareUnsigned((long) U_20, (long) 1L) <= 0) { mir_label = 225; break; }
case 226:
  U_23 = U0_s1;
  U_24 = U0_s1;
  U_24 = (long) U_24 + (long) 1L;
  U0_s1 = U_24;
  I_25 = (long) (byte) 0L;
  mir_write_byte(U_23, I_25);
  U_26 = U0_n;
  U_27 = U0_n;
  U_27 = (long) U_27 - (long) 1L;
  U0_n = U_27;
  if (Long.compareUnsigned((long) U_26, (long) 1L) > 0) { mir_label = 226; break; }
case 225:
  return (long) U0_rc;
} // End of switch
} // End of while
} // End of function strncpy

public long strndup (long _U0_s, long _U0_len) {
  long U0_s = _U0_s;
  long U0_len = _U0_len;
  long U0_ns = 0;
  long U_0 = 0;
  long U_1 = 0;
  long I_2 = 0;
  long U_3 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_ns = 0L;
  if (((long) U0_s == 0)) { mir_label = 227; break; }
case 228:
  U_1 = (long) U0_len + (long) 1L;
  U_0 = malloc((long) U_1);
  U0_ns = U_0;
  if (((long) U0_ns == 0)) { mir_label = 229; break; }
case 230:
  I_2 = (long) (byte) 0L;
  mir_write_byte(U0_ns + U0_len, I_2);
  U_3 = strncpy((long) U0_ns, (long) U0_s, (long) U0_len);
  return (long) U_3;
  // Dead code: mir_label = 231; break;
case 229:
case 231:
  mir_label = 232; break;
case 227:
case 232:
  return (long) U0_ns;
} // End of switch
} // End of while
} // End of function strndup

public long strnlen (long _U0_s, long _U0_maxlen) {
  long U0_s = _U0_s;
  long U0_maxlen = _U0_maxlen;
  long U1_len = 0;
  long i_0 = 0;
  long i_1 = 0;
  long U_2 = 0;
  long i_3 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U1_len = 0L;
  if ((long) U1_len == (long) U0_maxlen) { mir_label = 233; break; }
case 234:
  if ((int) mir_read_byte(U0_s + U1_len) != (int) 0L) { mir_label = 235; break; }
case 236:
  return (long) U1_len;
  // Dead code: mir_label = 237; break;
case 235:
case 237:
case 238:
  U_2 = U1_len;
  U_2 = (long) U_2 + (long) 1L;
  U1_len = U_2;
  if ((long) U1_len != (long) U0_maxlen) { mir_label = 234; break; }
case 233:
  return (long) U0_maxlen;
} // End of switch
} // End of while
} // End of function strnlen

public long strpbrk (long _U0_s1, long _U0_s2) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long i_0 = 0;
  long U_1 = 0;
  long i_2 = 0;
  long U_3 = 0;
  long i_4 = 0;
  long U_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long U_8 = 0;
  long U_9 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
case 239:
  if ((int) mir_read_byte(U0_s1) == (int) 0L) { mir_label = 240; break; }
case 241:
  U_1 = strchr((long) U0_s2, (int) mir_read_byte(U0_s1));
  if ((long) U_1 != (long) 0L) { mir_label = 240; break; }
case 242:
  U_3 = U0_s1;
  U_3 = (long) U_3 + (long) 1L;
  U0_s1 = U_3;
  if ((int) mir_read_byte(U0_s1) == (int) 0L) { mir_label = 240; break; }
case 243:
  U_5 = strchr((long) U0_s2, (int) mir_read_byte(U0_s1));
  if ((long) U_5 == (long) 0L) { mir_label = 242; break; }
case 240:
  if ((int) mir_read_byte(U0_s1) == (int) 0L) { mir_label = 244; break; }
case 245:
  U_8 = U0_s1;
  U_9 = U_8;
  mir_label = 246; break;
case 244:
  U_9 = 0L;
case 246:
  return (long) U_9;
} // End of switch
} // End of while
} // End of function strpbrk

public long strrchr (long _U0_s, int _i0_c) {
  long U0_s = _U0_s;
  long i0_c = _i0_c;
  long U0_i = 0;
  long U_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long I_6 = 0;
  long i_7 = 0;
  long U_8 = 0;
  long U_9 = 0;
  long U_10 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_i = 0L;
case 247:
  U_0 = U0_i;
  U_1 = U0_i;
  U_1 = (long) U_1 + (long) 1L;
  U0_i = U_1;
  if (((long) mir_read_byte(U0_s + U_0) == 0)) { mir_label = 248; break; }
case 249:
  U_2 = U0_i;
  U_3 = U0_i;
  U_3 = (long) U_3 + (long) 1L;
  U0_i = U_3;
  if (((long) mir_read_byte(U0_s + U_2) != 0)) { mir_label = 249; break; }
case 248:
case 250:
  U_4 = U0_i;
  U_4 = (long) U_4 - (long) 1L;
  U0_i = U_4;
  U_5 = U_4;
  I_6 = (long) (byte) i0_c;
  if ((int) mir_read_byte(U0_s + U_5) != (int) I_6) { mir_label = 251; break; }
case 252:
  U_8 = U0_s;
  U_10 = (long) U0_i * (long) 1L;
  U_9 = (long) U_8 + (long) U_10;
  return (long) U_9;
  // Dead code: mir_label = 253; break;
case 251:
case 253:
case 254:
  if (((long) U0_i != 0)) { mir_label = 250; break; }
case 255:
  return (long) 0L;
} // End of switch
} // End of while
} // End of function strrchr

public long strspn (long _U0_s1, long _U0_s2) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long U0_result = 0;
  long i_0 = 0;
  long U_1 = 0;
  long i_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long i_6 = 0;
  long U_7 = 0;
  long i_8 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_result = 0L;
case 256:
  if ((int) mir_read_byte(U0_s1) == (int) 0L) { mir_label = 257; break; }
case 258:
  U_1 = strchr((long) U0_s2, (int) mir_read_byte(U0_s1));
  if ((long) U_1 == (long) 0L) { mir_label = 257; break; }
case 259:
  U_3 = U0_s1;
  U_3 = (long) U_3 + (long) 1L;
  U0_s1 = U_3;
  U_4 = U0_result;
  U_5 = U0_result;
  U_5 = (long) U_5 + (long) 1L;
  U0_result = U_5;
  if ((int) mir_read_byte(U0_s1) == (int) 0L) { mir_label = 257; break; }
case 260:
  U_7 = strchr((long) U0_s2, (int) mir_read_byte(U0_s1));
  if ((long) U_7 != (long) 0L) { mir_label = 259; break; }
case 257:
  return (long) U0_result;
} // End of switch
} // End of while
} // End of function strspn

public long strstr (long _U0_s1, long _U0_s2) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long U0_p1 = 0;
  long U1_p2 = 0;
  long i_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long i_5 = 0;
  long U_6 = 0;
  long U_7 = 0;
  long U_8 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_p1 = U0_s1;
case 261:
  if (((long) mir_read_byte(U0_s1) == 0)) { mir_label = 262; break; }
case 263:
  U1_p2 = U0_s2;
case 264:
  if (((long) mir_read_byte(U1_p2) == 0)) { mir_label = 265; break; }
case 266:
  if ((int) mir_read_byte(U0_p1) != (int) mir_read_byte(U1_p2)) { mir_label = 265; break; }
case 267:
  U_1 = U0_p1;
  U_1 = (long) U_1 + (long) 1L;
  U0_p1 = U_1;
  U_3 = U1_p2;
  U_3 = (long) U_3 + (long) 1L;
  U1_p2 = U_3;
  if (((long) mir_read_byte(U1_p2) == 0)) { mir_label = 265; break; }
case 268:
  if ((int) mir_read_byte(U0_p1) == (int) mir_read_byte(U1_p2)) { mir_label = 267; break; }
case 265:
  if (((long) mir_read_byte(U1_p2) != 0)) { mir_label = 269; break; }
case 270:
  U_6 = U0_s1;
  return (long) U_6;
  // Dead code: mir_label = 271; break;
case 269:
case 271:
  U_7 = U0_s1;
  U_7 = (long) U_7 + (long) 1L;
  U0_s1 = U_7;
  U0_p1 = U0_s1;
  if (((long) mir_read_byte(U0_s1) != 0)) { mir_label = 263; break; }
case 262:
  return (long) 0L;
} // End of switch
} // End of while
} // End of function strstr

public long strtok (long _U0_s1, long _U0_s2) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long U0_p = 0;
  long i_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long i_3 = 0;
  long I_4 = 0;
  long i_5 = 0;
  long U_6 = 0;
  long U_7 = 0;
  long U_8 = 0;
  long U_9 = 0;
  long I_10 = 0;
  long U_11 = 0;
  long U_12 = 0;
  long I_13 = 0;
  long I_14 = 0;
  long I_15 = 0;
  long I_16 = 0;
  long I_17 = 0;
  long U_18 = 0;
  long U_19 = 0;
  long i_20 = 0;
  long I_21 = 0;
  long U_22 = 0;
  long U_23 = 0;
  long I_24 = 0;
  long I_25 = 0;
  long U_26 = 0;
  long U_27 = 0;
  long I_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_p = U0_s2;
  if ((long) U0_s1 == (long) 0L) { mir_label = 272; break; }
case 273:
  I_1 = m1_S0_strtok_tmp;
  mir_write_ulong(I_1, U0_s1);
  mir_label = 274; break;
case 272:
  I_2 = m1_S0_strtok_tmp;
  if ((long) mir_read_ulong(I_2) != (long) 0L) { mir_label = 275; break; }
case 276:
  return (long) 0L;
  // Dead code: mir_label = 277; break;
case 275:
case 277:
  I_4 = m1_S0_strtok_tmp;
  U0_s1 = mir_read_ulong(I_4);
case 274:
case 278:
  if (((long) mir_read_byte(U0_p) == 0)) { mir_label = 279; break; }
case 280:
  if (((long) mir_read_byte(U0_s1) == 0)) { mir_label = 279; break; }
case 281:
  if ((int) mir_read_byte(U0_s1) != (int) mir_read_byte(U0_p)) { mir_label = 282; break; }
case 283:
  U_6 = U0_s1;
  U_6 = (long) U_6 + (long) 1L;
  U0_s1 = U_6;
  U0_p = U0_s2;
  mir_label = 278; break;
  // Dead code: mir_label = 284; break;
case 282:
case 284:
  U_8 = U0_p;
  U_8 = (long) U_8 + (long) 1L;
  U0_p = U_8;
  if (((long) mir_read_byte(U0_p) == 0)) { mir_label = 279; break; }
case 285:
  if (((long) mir_read_byte(U0_s1) != 0)) { mir_label = 281; break; }
case 279:
  if (((long) mir_read_byte(U0_s1) != 0)) { mir_label = 286; break; }
case 287:
  I_10 = m1_S0_strtok_tmp;
  U_11 = 0L;
  mir_write_ulong(I_10, U_11);
  U_12 = U_11;
  return (long) U_12;
  // Dead code: mir_label = 288; break;
case 286:
case 288:
  I_13 = m1_S0_strtok_tmp;
  mir_write_ulong(I_13, U0_s1);
case 289:
  I_14 = m1_S0_strtok_tmp;
  I_15 = mir_read_ulong(I_14);
  if (((long) mir_read_byte(I_15) == 0)) { mir_label = 290; break; }
case 291:
  U0_p = U0_s2;
case 292:
  if (((long) mir_read_byte(U0_p) == 0)) { mir_label = 293; break; }
case 294:
  I_16 = m1_S0_strtok_tmp;
  I_17 = mir_read_ulong(I_16);
  U_18 = U0_p;
  U_19 = U0_p;
  U_19 = (long) U_19 + (long) 1L;
  U0_p = U_19;
  if ((int) mir_read_byte(I_17) != (int) mir_read_byte(U_18)) { mir_label = 295; break; }
case 296:
  I_21 = m1_S0_strtok_tmp;
  U_22 = mir_read_ulong(I_21);
  U_23 = mir_read_ulong(I_21);
  U_23 = (long) U_23 + (long) 1L;
  mir_write_ulong(I_21, U_23);
  I_24 = (long) (byte) 0L;
  mir_write_byte(U_22, I_24);
  return (long) U0_s1;
  // Dead code: mir_label = 297; break;
case 295:
case 297:
  if (((long) mir_read_byte(U0_p) != 0)) { mir_label = 294; break; }
case 293:
  I_25 = m1_S0_strtok_tmp;
  U_26 = mir_read_ulong(I_25);
  U_26 = (long) U_26 + (long) 1L;
  mir_write_ulong(I_25, U_26);
  I_28 = m1_S0_strtok_tmp;
  I_29 = mir_read_ulong(I_28);
  if (((long) mir_read_byte(I_29) != 0)) { mir_label = 291; break; }
case 290:
  I_30 = m1_S0_strtok_tmp;
  mir_write_ulong(I_30, 0L);
  return (long) U0_s1;
} // End of switch
} // End of while
} // End of function strtok

long m1_S0_strtok_tmp = mir_set_data_ulong(0L);
public long strxfrm (long _U0_s1, long _U0_s2, long _U0_n) {
  long U0_s1 = _U0_s1;
  long U0_s2 = _U0_s2;
  long U0_n = _U0_n;
  long U0_len = 0;
  long U_0 = 0;
  long i_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long U_6 = 0;
  long U_7 = 0;
  long I_8 = 0;
  long i_9 = 0;
  long i_10 = 0;
  long I_11 = 0;
  long I_12 = 0;
  long U_13 = 0;
  long U_14 = 0;
  long U_15 = 0;
  long U_16 = 0;
  long U_17 = 0;
  long U_18 = 0;
  long I_19 = 0;
  long i_20 = 0;
  long i_21 = 0;
  long I_22 = 0;
  long I_23 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U_0 = strlen((long) U0_s2);
  U0_len = U_0;
  if (Long.compareUnsigned((long) U0_len, (long) U0_n) >= 0) { mir_label = 298; break; }
case 299:
case 300:
  U_2 = U0_n;
  U_3 = U0_n;
  U_3 = (long) U_3 - (long) 1L;
  U0_n = U_3;
  if (((long) U_2 == 0)) { mir_label = 301; break; }
case 302:
  U_4 = U0_s1;
  U_5 = U0_s1;
  U_5 = (long) U_5 + (long) 1L;
  U0_s1 = U_5;
  U_6 = U0_s2;
  U_7 = U0_s2;
  U_7 = (long) U_7 + (long) 1L;
  U0_s2 = U_7;
  I_8 = (((long) (int) mir_read_byte(U_6)) & 0xFFL);
  i_9 = I_8;
  I_11 = (long) (byte) i_9;
  mir_write_byte(U_4, I_11);
  i_10 = I_11;
  I_12 = (long) (int) i_10;
  if (((long) I_12 == 0)) { mir_label = 301; break; }
case 303:
  U_13 = U0_n;
  U_14 = U0_n;
  U_14 = (long) U_14 - (long) 1L;
  U0_n = U_14;
  if (((long) U_13 == 0)) { mir_label = 301; break; }
case 304:
  U_15 = U0_s1;
  U_16 = U0_s1;
  U_16 = (long) U_16 + (long) 1L;
  U0_s1 = U_16;
  U_17 = U0_s2;
  U_18 = U0_s2;
  U_18 = (long) U_18 + (long) 1L;
  U0_s2 = U_18;
  I_19 = (((long) (int) mir_read_byte(U_17)) & 0xFFL);
  i_20 = I_19;
  I_22 = (long) (byte) i_20;
  mir_write_byte(U_15, I_22);
  i_21 = I_22;
  I_23 = (long) (int) i_21;
  if (((long) I_23 != 0)) { mir_label = 303; break; }
case 301:
  mir_label = 305; break;
case 298:
case 305:
  return (long) U0_len;
} // End of switch
} // End of while
} // End of function strxfrm

protected int m1_outputBuffer (long _U0_stream, long _U0_s, int _i0_length) {
  long U0_stream = _U0_stream;
  long U0_s = _U0_s;
  long i0_length = _i0_length;
  long i_0 = 0;
  long i_1 = 0;
  long i2_c = 0;
  long U_2 = 0;
  long U_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long i_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long i_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  long U_14 = 0;
  long I5_rc = 0;
  long I_15 = 0;
  long U_16 = 0;
  long i_17 = 0;
  long I_18 = 0;
  long i_19 = 0;
  long i_20 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((int) mir_read_int(U0_stream) >= (int) 0L) { mir_label = 306; break; }
case 307:
case 308:
  if ((int) i0_length == (int) 0L) { mir_label = 309; break; }
case 310:
  U_2 = U0_s;
  U_3 = U0_s;
  U_3 = (long) U_3 + (long) 1L;
  U0_s = U_3;
  i2_c = mir_read_byte(U_2);
  if ((int) i0_length >= (int) 0L) { mir_label = 311; break; }
case 312:
  if ((int) i2_c != (int) 0L) { mir_label = 313; break; }
case 314:
  mir_label = 309; break;
  // Dead code: mir_label = 315; break;
case 313:
case 315:
  mir_label = 316; break;
case 311:
  i_6 = i0_length;
  i_6 = (int) i_6 - (int) 1L;
  i0_length = i_6;
case 316:
  if ((int) mir_read_int(16L + U0_stream) >= (int) mir_read_int(20L + U0_stream)) { mir_label = 317; break; }
case 318:
  i_8 = mir_read_int(16L + U0_stream);
  I_9 = mir_read_ulong(8L + U0_stream);
  I_10 = (long) (byte) i2_c;
  mir_write_byte(I_9 + i_8, I_10);
  i_11 = mir_read_int(16L + U0_stream);
  i_11 = (int) i_11 + (int) 1L;
  mir_write_int(16L + U0_stream, i_11);
  mir_label = 319; break;
case 317:
case 319:
  if ((int) i0_length != (int) 0L) { mir_label = 310; break; }
case 309:
  mir_label = 320; break;
case 306:
  if ((int) i0_length >= (int) 0L) { mir_label = 321; break; }
case 322:
  U_14 = strlen((long) U0_s);
  i0_length = U_14;
  mir_label = 323; break;
case 321:
case 323:
  U_16 = (long) (int) i0_length;
  I_15 = mir_sysio_write((int) mir_read_int(U0_stream), (long) U0_s, (long) U_16);
  I5_rc = I_15;
  if ((long) I5_rc >= (long) 0L) { mir_label = 324; break; }
case 325:
  I_18 = __errno;
  i_19 = I5_rc;
  i_20 = - (int) i_19;
  mir_write_int(I_18, i_20);
  return (int) -1L;
  // Dead code: mir_label = 326; break;
case 324:
case 326:
case 320:
  return (int) 0L;
} // End of switch
} // End of while
} // End of function outputBuffer

protected int m1_outputChar (long _U0_stream, byte _i0_c) {
  long U0_stream = _U0_stream;
  long i0_c = _i0_c;
  long fp = 0;
  long i_0 = 0;
  long U_1 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(16L);
  mir_write_byte(fp, i0_c);
  U_1 = fp;
  i_0 = m1_outputBuffer((long) U0_stream, (long) U_1, (int) 1L);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i_0;
} // End of function outputChar

public long fopen (long _U0_filename, long _U0_mode) {
  long U0_filename = _U0_filename;
  long U0_mode = _U0_mode;
  long U0_stream = 0;
  long U_0 = 0;
  U_0 = calloc((long) 1L, (long) 32L);
  U0_stream = U_0;
  return (long) U0_stream;
} // End of function fopen

public int fclose (long _U0_stream) {
  long U0_stream = _U0_stream;
  free((long) U0_stream);
  return (int) 0L;
} // End of function fclose

public int feof (long _U0_stream) {
  long U0_stream = _U0_stream;
  return (int) 0L;
} // End of function feof

public int fflush (long _U0_stream) {
  long U0_stream = _U0_stream;
  return (int) 0L;
} // End of function fflush

public long fread (long _U0_ptr, long _U0_size, long _U0_count, long _U0_stream) {
  long U0_ptr = _U0_ptr;
  long U0_size = _U0_size;
  long U0_count = _U0_count;
  long U0_stream = _U0_stream;
  return (long) 0L;
} // End of function fread

public long fwrite (long _U0_ptr, long _U0_size, long _U0_count, long _U0_stream) {
  long U0_ptr = _U0_ptr;
  long U0_size = _U0_size;
  long U0_count = _U0_count;
  long U0_stream = _U0_stream;
  return (long) 0L;
} // End of function fwrite

public long freopen (long _U0_filename, long _U0_mode, long _U0_stream) {
  long U0_filename = _U0_filename;
  long U0_mode = _U0_mode;
  long U0_stream = _U0_stream;
  return (long) 0L;
} // End of function freopen

public long ftell (long _U0_stream) {
  long U0_stream = _U0_stream;
  return (long) -1L;
} // End of function ftell

public int fseek (long _U0_stream, long I0_offset, int _i0_whence) {
  long U0_stream = _U0_stream;
  long i0_whence = _i0_whence;
  return (int) -1L;
} // End of function fseek

public long fgets (long _U0_s, int _i0_n, long _U0_stream) {
  long U0_s = _U0_s;
  long i0_n = _i0_n;
  long U0_stream = _U0_stream;
  return (long) 0L;
} // End of function fgets

public int sscanf (long _U0_s, long _U0_format, Object... mir_var_args) {
  long U0_s = _U0_s;
  long U0_format = _U0_format;
  int mir_saved_stack_position =  mir_get_stack_position();
  mir_set_stack_position(mir_saved_stack_position);
  return (int) -1L;
} // End of function sscanf

public int vsscanf (long _U0_s, long _U0_format, long _U0_arg) {
  long U0_s = _U0_s;
  long U0_format = _U0_format;
  long U0_arg = _U0_arg;
  return (int) -1L;
} // End of function vsscanf

public int vfscanf (long _U0_stream, long _U0_format, long _U0_ap) {
  long U0_stream = _U0_stream;
  long U0_format = _U0_format;
  long U0_ap = _U0_ap;
  return (int) -1L;
} // End of function vfscanf

public int fscanf (long _U0_stream, long _U0_format, Object... mir_var_args) {
  long U0_stream = _U0_stream;
  long U0_format = _U0_format;
  long fp = 0;
  long i0_rc = 0;
  long i_0 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(32L);
  mir_va_start(fp, mir_var_args);
  i_0 = vfscanf((long) U0_stream, (long) U0_format, (long) fp);
  i0_rc = i_0;
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_rc;
} // End of function fscanf

public int fgetc (long _U0_stream) {
  long U0_stream = _U0_stream;
  return (int) -1L;
} // End of function fgetc

public int getc (long _U0_stream) {
  long U0_stream = _U0_stream;
  long i_0 = 0;
  i_0 = fgetc((long) U0_stream);
  return (int) i_0;
} // End of function getc

public int fputs (long _U0_str, long _U0_stream) {
  long U0_str = _U0_str;
  long U0_stream = _U0_stream;
  long I0_rc = 0;
  long I_0 = 0;
  long U_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U_1 = strlen((long) U0_str);
  I_0 = mir_sysio_write((int) mir_read_int(U0_stream), (long) U0_str, (long) U_1);
  I0_rc = I_0;
  if ((long) I0_rc >= (long) 0L) { mir_label = 327; break; }
case 328:
  I_3 = __errno;
  i_4 = I0_rc;
  i_5 = - (int) i_4;
  mir_write_int(I_3, i_5);
  return (int) -1L;
  // Dead code: mir_label = 329; break;
case 327:
case 329:
  return (int) 0L;
} // End of switch
} // End of while
} // End of function fputs

public int fputc (int _i0_c, long _U0_stream) {
  long i0_c = _i0_c;
  long U0_stream = _U0_stream;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long i_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  I_0 = (long) (byte) i0_c;
  I_1 = (long) (byte) I_0;
  mir_write_byte(fp, I_1);
  I_2 = (long) (byte) 0L;
  mir_write_byte(1L + fp, I_2);
  i_3 = fputs((long) fp, (long) U0_stream);
  if ((int) i_3 == (int) -1L) { mir_label = 330; break; }
case 331:
  i_5 = i0_c;
  mir_label = 332; break;
case 330:
  i_5 = -1L;
case 332:
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i_5;
} // End of switch
} // End of while
} // End of function fputc

public int putc (int _i0_c, long _U0_stream) {
  long i0_c = _i0_c;
  long U0_stream = _U0_stream;
  long i_0 = 0;
  i_0 = fputc((int) i0_c, (long) U0_stream);
  return (int) i_0;
} // End of function putc

public int putchar (int _i0_c) {
  long i0_c = _i0_c;
  long i_0 = 0;
  long I_1 = 0;
  I_1 = stdout;
  i_0 = putc((int) i0_c, (long) mir_read_ulong(I_1));
  return (int) i_0;
} // End of function putchar

public int puts (long _U0_s) {
  long U0_s = _U0_s;
  long i0_ret = 0;
  long i_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long i_3 = 0;
  long I_4 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  I_1 = stdout;
  i_0 = fputs((long) U0_s, (long) mir_read_ulong(I_1));
  i0_ret = i_0;
  if ((int) i0_ret != (int) -1L) { mir_label = 333; break; }
case 334:
  return (int) i0_ret;
  // Dead code: mir_label = 335; break;
case 333:
case 335:
  I_4 = stdout;
  i_3 = putc((int) 10L, (long) mir_read_ulong(I_4));
  return (int) i_3;
} // End of switch
} // End of while
} // End of function puts

protected void m1__out_buffer (long _U0_stream, byte _i0_character, long _U0_buffer, long _U0_idx, long _U0_maxlen) {
  long U0_stream = _U0_stream;
  long i0_character = _i0_character;
  long U0_buffer = _U0_buffer;
  long U0_idx = _U0_idx;
  long U0_maxlen = _U0_maxlen;
  long i_0 = 0;
  long U_1 = 0;
  long I_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if (Long.compareUnsigned((long) U0_idx, (long) U0_maxlen) >= 0) { mir_label = 336; break; }
case 337:
  U_1 = U0_buffer;
  I_2 = (long) (byte) i0_character;
  mir_write_byte(U_1 + U0_idx, I_2);
  mir_label = 338; break;
case 336:
case 338:
  return;
} // End of switch
} // End of while
} // End of function _out_buffer

protected void m1__out_null (long _U0_stream, byte _i0_character, long _U0_buffer, long _U0_idx, long _U0_maxlen) {
  long U0_stream = _U0_stream;
  long i0_character = _i0_character;
  long U0_buffer = _U0_buffer;
  long U0_idx = _U0_idx;
  long U0_maxlen = _U0_maxlen;
  return;
} // End of function _out_null

protected void m1__out_char (long _U0_stream, byte _i0_character, long _U0_buffer, long _U0_idx, long _U0_maxlen) {
  long U0_stream = _U0_stream;
  long i0_character = _i0_character;
  long U0_buffer = _U0_buffer;
  long U0_idx = _U0_idx;
  long U0_maxlen = _U0_maxlen;
  long I_0 = 0;
  long i_1 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  I_0 = (long) (int) i0_character;
  if (((long) I_0 == 0)) { mir_label = 339; break; }
case 340:
  i_1 = m1_outputChar((long) U0_stream, (byte) i0_character);
  mir_label = 341; break;
case 339:
case 341:
  return;
} // End of switch
} // End of while
} // End of function _out_char

protected long m1__atoi (long _U0_str) {
  long U0_str = _U0_str;
  long u0_i = 0;
  long i_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long u_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long i_6 = 0;
  long u_7 = 0;
  long u_8 = 0;
  long i_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  u0_i = 0L;
case 342:
  I_1 = mir_read_ulong(U0_str);
  i_0 = isdigit((int) mir_read_byte(I_1));
  I_2 = (long) (int) i_0;
  if (((long) I_2 == 0)) { mir_label = 343; break; }
case 344:
  u_3 = (int) u0_i * (int) 10L;
  U_4 = mir_read_ulong(U0_str);
  U_5 = mir_read_ulong(U0_str);
  U_5 = (long) U_5 + (long) 1L;
  mir_write_ulong(U0_str, U_5);
  i_6 = (int) mir_read_byte(U_4) - (int) 48L;
  u_7 = i_6;
  u_8 = (int) u_3 + (int) u_7;
  u0_i = u_8;
  I_10 = mir_read_ulong(U0_str);
  i_9 = isdigit((int) mir_read_byte(I_10));
  I_11 = (long) (int) i_9;
  if (((long) I_11 != 0)) { mir_label = 344; break; }
case 343:
  return (long) u0_i;
} // End of switch
} // End of while
} // End of function _atoi

protected long m1__ntoa_format (long _U0_stream, long _U0_out, long _U0_buffer, long _U0_idx, long _U0_maxlen, long _U0_buf, long _U0_len, short _u0_negative, long _u0_base, long _u0_prec, long _u0_width, long _u0_flags) {
  long U0_stream = _U0_stream;
  long U0_out = _U0_out;
  long U0_buffer = _U0_buffer;
  long U0_idx = _U0_idx;
  long U0_maxlen = _U0_maxlen;
  long U0_buf = _U0_buf;
  long U0_len = _U0_len;
  long u0_negative = _u0_negative;
  long u0_base = _u0_base;
  long u0_prec = _u0_prec;
  long u0_width = _u0_width;
  long u0_flags = _u0_flags;
  long U0_start_idx = 0;
  long u_0 = 0;
  long I_1 = 0;
  long U_2 = 0;
  long i_3 = 0;
  long i_4 = 0;
  long U_5 = 0;
  long U_6 = 0;
  long I_7 = 0;
  long U_8 = 0;
  long i_9 = 0;
  long i_10 = 0;
  long u_11 = 0;
  long I_12 = 0;
  long U_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long U_16 = 0;
  long U_17 = 0;
  long I_18 = 0;
  long u_19 = 0;
  long I_20 = 0;
  long U_21 = 0;
  long i_22 = 0;
  long i_23 = 0;
  long u_24 = 0;
  long I_25 = 0;
  long u_26 = 0;
  long I_27 = 0;
  long U_28 = 0;
  long i_29 = 0;
  long U_30 = 0;
  long i_31 = 0;
  long U_32 = 0;
  long i_33 = 0;
  long U_34 = 0;
  long i_35 = 0;
  long u_36 = 0;
  long I_37 = 0;
  long i_38 = 0;
  long U_39 = 0;
  long U_40 = 0;
  long I_41 = 0;
  long i_42 = 0;
  long u_43 = 0;
  long I_44 = 0;
  long i_45 = 0;
  long U_46 = 0;
  long U_47 = 0;
  long I_48 = 0;
  long i_49 = 0;
  long i_50 = 0;
  long U_51 = 0;
  long U_52 = 0;
  long I_53 = 0;
  long i_54 = 0;
  long U_55 = 0;
  long U_56 = 0;
  long I_57 = 0;
  long U_58 = 0;
  long i_59 = 0;
  long I_60 = 0;
  long u_61 = 0;
  long I_62 = 0;
  long u_63 = 0;
  long I_64 = 0;
  long U_65 = 0;
  long i_66 = 0;
  long I_67 = 0;
  long U_68 = 0;
  long U_69 = 0;
  long I_70 = 0;
  long u_71 = 0;
  long I_72 = 0;
  long U_73 = 0;
  long U_74 = 0;
  long I_75 = 0;
  long u_76 = 0;
  long I_77 = 0;
  long U_78 = 0;
  long U_79 = 0;
  long I_80 = 0;
  long u_81 = 0;
  long I_82 = 0;
  long u_83 = 0;
  long I_84 = 0;
  long U17_i = 0;
  long U_85 = 0;
  long i_86 = 0;
  long U_87 = 0;
  long U_88 = 0;
  long U_89 = 0;
  long U_90 = 0;
  long i_91 = 0;
  long U19_i = 0;
  long i_92 = 0;
  long U_93 = 0;
  long U_94 = 0;
  long U_95 = 0;
  long U_96 = 0;
  long U_97 = 0;
  long i_98 = 0;
  long u_99 = 0;
  long I_100 = 0;
  long U_101 = 0;
  long U_102 = 0;
  long i_103 = 0;
  long U_104 = 0;
  long U_105 = 0;
  long U_106 = 0;
  long U_107 = 0;
  long i_108 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_start_idx = U0_idx;
  u_0 = (int) u0_flags & (int) 2L;
  I_1 = (((long) u_0) & 0xFFFFFFFFL);
  if (((long) I_1 != 0)) { mir_label = 345; break; }
case 346:
case 347:
  U_2 = (((long) u0_prec) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U0_len, (long) U_2) >= 0) { mir_label = 348; break; }
case 349:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 348; break; }
case 350:
  U_5 = U0_len;
  U_6 = U0_len;
  U_6 = (long) U_6 + (long) 1L;
  U0_len = U_6;
  I_7 = (long) (byte) 48L;
  mir_write_byte(U0_buf + U_5, I_7);
  U_8 = (((long) u0_prec) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U0_len, (long) U_8) >= 0) { mir_label = 348; break; }
case 351:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) < 0) { mir_label = 350; break; }
case 348:
case 352:
  u_11 = (int) u0_flags & (int) 1L;
  I_12 = (((long) u_11) & 0xFFFFFFFFL);
  if (((long) I_12 == 0)) { mir_label = 353; break; }
case 354:
  U_13 = (((long) u0_width) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U0_len, (long) U_13) >= 0) { mir_label = 353; break; }
case 355:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 353; break; }
case 356:
  U_16 = U0_len;
  U_17 = U0_len;
  U_17 = (long) U_17 + (long) 1L;
  U0_len = U_17;
  I_18 = (long) (byte) 48L;
  mir_write_byte(U0_buf + U_16, I_18);
  u_19 = (int) u0_flags & (int) 1L;
  I_20 = (((long) u_19) & 0xFFFFFFFFL);
  if (((long) I_20 == 0)) { mir_label = 353; break; }
case 357:
  U_21 = (((long) u0_width) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U0_len, (long) U_21) >= 0) { mir_label = 353; break; }
case 358:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) < 0) { mir_label = 356; break; }
case 353:
  mir_label = 359; break;
case 345:
case 359:
  u_24 = (int) u0_flags & (int) 16L;
  I_25 = (((long) u_24) & 0xFFFFFFFFL);
  if (((long) I_25 == 0)) { mir_label = 360; break; }
case 361:
  u_26 = (int) u0_flags & (int) 1024L;
  I_27 = (((long) u_26) & 0xFFFFFFFFL);
  if (((long) I_27 != 0)) { mir_label = 362; break; }
case 363:
  if (((long) U0_len == 0)) { mir_label = 362; break; }
case 364:
  U_28 = (((long) u0_prec) & 0xFFFFFFFFL);
  if ((long) U0_len == (long) U_28) { mir_label = 365; break; }
case 366:
  U_30 = (((long) u0_width) & 0xFFFFFFFFL);
  if ((long) U0_len != (long) U_30) { mir_label = 362; break; }
case 365:
  U_32 = U0_len;
  U_32 = (long) U_32 - (long) 1L;
  U0_len = U_32;
  if (((long) U0_len == 0)) { mir_label = 367; break; }
case 368:
  if ((int) u0_base != (int) 16L) { mir_label = 367; break; }
case 369:
  U_34 = U0_len;
  U_34 = (long) U_34 - (long) 1L;
  U0_len = U_34;
  mir_label = 370; break;
case 367:
case 370:
  mir_label = 371; break;
case 362:
case 371:
  if ((int) u0_base != (int) 16L) { mir_label = 372; break; }
case 373:
  u_36 = (int) u0_flags & (int) 32L;
  I_37 = (((long) u_36) & 0xFFFFFFFFL);
  if (((long) I_37 != 0)) { mir_label = 372; break; }
case 374:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 372; break; }
case 375:
  U_39 = U0_len;
  U_40 = U0_len;
  U_40 = (long) U_40 + (long) 1L;
  U0_len = U_40;
  I_41 = (long) (byte) 120L;
  mir_write_byte(U0_buf + U_39, I_41);
  mir_label = 376; break;
case 372:
  if ((int) u0_base != (int) 16L) { mir_label = 377; break; }
case 378:
  u_43 = (int) u0_flags & (int) 32L;
  I_44 = (((long) u_43) & 0xFFFFFFFFL);
  if (((long) I_44 == 0)) { mir_label = 377; break; }
case 379:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 377; break; }
case 380:
  U_46 = U0_len;
  U_47 = U0_len;
  U_47 = (long) U_47 + (long) 1L;
  U0_len = U_47;
  I_48 = (long) (byte) 88L;
  mir_write_byte(U0_buf + U_46, I_48);
  mir_label = 381; break;
case 377:
  if ((int) u0_base != (int) 2L) { mir_label = 382; break; }
case 383:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 382; break; }
case 384:
  U_51 = U0_len;
  U_52 = U0_len;
  U_52 = (long) U_52 + (long) 1L;
  U0_len = U_52;
  I_53 = (long) (byte) 98L;
  mir_write_byte(U0_buf + U_51, I_53);
  mir_label = 385; break;
case 382:
case 385:
case 381:
case 376:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 386; break; }
case 387:
  U_55 = U0_len;
  U_56 = U0_len;
  U_56 = (long) U_56 + (long) 1L;
  U0_len = U_56;
  I_57 = (long) (byte) 48L;
  mir_write_byte(U0_buf + U_55, I_57);
  mir_label = 388; break;
case 386:
case 388:
  mir_label = 389; break;
case 360:
case 389:
  if (((long) U0_len == 0)) { mir_label = 390; break; }
case 391:
  U_58 = (((long) u0_width) & 0xFFFFFFFFL);
  if ((long) U0_len != (long) U_58) { mir_label = 390; break; }
case 392:
  I_60 = (((long) u0_negative) & 0xFFFFFFFFL);
  if (((long) I_60 != 0)) { mir_label = 393; break; }
case 394:
  u_61 = (int) u0_flags & (int) 4L;
  I_62 = (((long) u_61) & 0xFFFFFFFFL);
  if (((long) I_62 != 0)) { mir_label = 393; break; }
case 395:
  u_63 = (int) u0_flags & (int) 8L;
  I_64 = (((long) u_63) & 0xFFFFFFFFL);
  if (((long) I_64 == 0)) { mir_label = 390; break; }
case 393:
  U_65 = U0_len;
  U_65 = (long) U_65 - (long) 1L;
  U0_len = U_65;
  mir_label = 396; break;
case 390:
case 396:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 397; break; }
case 398:
  I_67 = (((long) u0_negative) & 0xFFFFFFFFL);
  if (((long) I_67 == 0)) { mir_label = 399; break; }
case 400:
  U_68 = U0_len;
  U_69 = U0_len;
  U_69 = (long) U_69 + (long) 1L;
  U0_len = U_69;
  I_70 = (long) (byte) 45L;
  mir_write_byte(U0_buf + U_68, I_70);
  mir_label = 401; break;
case 399:
  u_71 = (int) u0_flags & (int) 4L;
  I_72 = (((long) u_71) & 0xFFFFFFFFL);
  if (((long) I_72 == 0)) { mir_label = 402; break; }
case 403:
  U_73 = U0_len;
  U_74 = U0_len;
  U_74 = (long) U_74 + (long) 1L;
  U0_len = U_74;
  I_75 = (long) (byte) 43L;
  mir_write_byte(U0_buf + U_73, I_75);
  mir_label = 404; break;
case 402:
  u_76 = (int) u0_flags & (int) 8L;
  I_77 = (((long) u_76) & 0xFFFFFFFFL);
  if (((long) I_77 == 0)) { mir_label = 405; break; }
case 406:
  U_78 = U0_len;
  U_79 = U0_len;
  U_79 = (long) U_79 + (long) 1L;
  U0_len = U_79;
  I_80 = (long) (byte) 32L;
  mir_write_byte(U0_buf + U_78, I_80);
  mir_label = 407; break;
case 405:
case 407:
case 404:
case 401:
  mir_label = 408; break;
case 397:
case 408:
  u_81 = (int) u0_flags & (int) 2L;
  I_82 = (((long) u_81) & 0xFFFFFFFFL);
  if (((long) I_82 != 0)) { mir_label = 409; break; }
case 410:
  u_83 = (int) u0_flags & (int) 1L;
  I_84 = (((long) u_83) & 0xFFFFFFFFL);
  if (((long) I_84 != 0)) { mir_label = 409; break; }
case 411:
  U17_i = U0_len;
  U_85 = (((long) u0_width) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U17_i, (long) U_85) >= 0) { mir_label = 412; break; }
case 413:
  U_87 = U0_idx;
  U_88 = U0_idx;
  U_88 = (long) U_88 + (long) 1L;
  U0_idx = U_88;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) 32L, (long) U0_buffer, (long) U_87, (long) U0_maxlen);
case 414:
  U_89 = U17_i;
  U_89 = (long) U_89 + (long) 1L;
  U17_i = U_89;
  U_90 = (((long) u0_width) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U17_i, (long) U_90) < 0) { mir_label = 413; break; }
case 412:
  mir_label = 415; break;
case 409:
case 415:
  U19_i = 0L;
  if (Long.compareUnsigned((long) U19_i, (long) U0_len) >= 0) { mir_label = 416; break; }
case 417:
  U_93 = (long) U0_len - (long) U19_i;
  U_94 = (long) U_93 - (long) 1L;
  U_95 = U0_idx;
  U_96 = U0_idx;
  U_96 = (long) U_96 + (long) 1L;
  U0_idx = U_96;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) mir_read_byte(U0_buf + U_94), (long) U0_buffer, (long) U_95, (long) U0_maxlen);
case 418:
  U_97 = U19_i;
  U_97 = (long) U_97 + (long) 1L;
  U19_i = U_97;
  if (Long.compareUnsigned((long) U19_i, (long) U0_len) < 0) { mir_label = 417; break; }
case 416:
  u_99 = (int) u0_flags & (int) 2L;
  I_100 = (((long) u_99) & 0xFFFFFFFFL);
  if (((long) I_100 == 0)) { mir_label = 419; break; }
case 420:
case 421:
  U_101 = (long) U0_idx - (long) U0_start_idx;
  U_102 = (((long) u0_width) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U_101, (long) U_102) >= 0) { mir_label = 422; break; }
case 423:
  U_104 = U0_idx;
  U_105 = U0_idx;
  U_105 = (long) U_105 + (long) 1L;
  U0_idx = U_105;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) 32L, (long) U0_buffer, (long) U_104, (long) U0_maxlen);
  U_106 = (long) U0_idx - (long) U0_start_idx;
  U_107 = (((long) u0_width) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U_106, (long) U_107) < 0) { mir_label = 423; break; }
case 422:
  mir_label = 424; break;
case 419:
case 424:
  return (long) U0_idx;
} // End of switch
} // End of while
} // End of function _ntoa_format

protected long m1__ntoa_long (long _U0_stream, long _U0_out, long _U0_buffer, long _U0_idx, long _U0_maxlen, long _U0_value, short _u0_negative, long _U0_base, long _u0_prec, long _u0_width, long _u0_flags) {
  long U0_stream = _U0_stream;
  long U0_out = _U0_out;
  long U0_buffer = _U0_buffer;
  long U0_idx = _U0_idx;
  long U0_maxlen = _U0_maxlen;
  long U0_value = _U0_value;
  long u0_negative = _u0_negative;
  long U0_base = _U0_base;
  long u0_prec = _u0_prec;
  long u0_width = _u0_width;
  long u0_flags = _u0_flags;
  long fp = 0;
  long U0_len = 0;
  long u_0 = 0;
  long u_1 = 0;
  long u_2 = 0;
  long I_3 = 0;
  long i3_digit = 0;
  long U_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long U_7 = 0;
  long U_8 = 0;
  long i_9 = 0;
  long i_10 = 0;
  long i_11 = 0;
  long u_12 = 0;
  long I_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long I_17 = 0;
  long U_18 = 0;
  long U_19 = 0;
  long i_20 = 0;
  long U_21 = 0;
  long u_22 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(32L);
  U0_len = 0L;
  if (((long) U0_value != 0)) { mir_label = 425; break; }
case 426:
  u_0 = u0_flags;
  u_0 = (int) u_0 & (int) 4294967279L;
  u0_flags = u_0;
  mir_label = 427; break;
case 425:
case 427:
  u_2 = (int) u0_flags & (int) 1024L;
  I_3 = (((long) u_2) & 0xFFFFFFFFL);
  if (((long) I_3 == 0)) { mir_label = 428; break; }
case 429:
  if (((long) U0_value == 0)) { mir_label = 430; break; }
case 428:
case 431:
  U_4 = (long) Long.remainderUnsigned((long) U0_value, (long) U0_base);
  I_5 = (long) (byte) U_4;
  I_6 = (long) (byte) I_5;
  i3_digit = I_6;
  U_7 = U0_len;
  U_8 = U0_len;
  U_8 = (long) U_8 + (long) 1L;
  U0_len = U_8;
  if ((int) i3_digit >= (int) 10L) { mir_label = 432; break; }
case 433:
  i_10 = (int) 48L + (int) i3_digit;
  i_11 = i_10;
  mir_label = 434; break;
case 432:
  u_12 = (int) u0_flags & (int) 32L;
  I_13 = (((long) u_12) & 0xFFFFFFFFL);
  if (((long) I_13 == 0)) { mir_label = 435; break; }
case 436:
  i_14 = 65L;
  mir_label = 437; break;
case 435:
  i_14 = 97L;
case 437:
  i_15 = (int) i_14 + (int) i3_digit;
  i_16 = (int) i_15 - (int) 10L;
  i_11 = i_16;
case 434:
  I_17 = (long) (byte) i_11;
  mir_write_byte(fp + U_7, I_17);
  U_18 = U0_value;
  U_18 = (long) Long.divideUnsigned((long) U_18, (long) U0_base);
  U0_value = U_18;
case 438:
  if (((long) U0_value == 0)) { mir_label = 439; break; }
case 440:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) < 0) { mir_label = 431; break; }
case 439:
  mir_label = 441; break;
case 430:
case 441:
  u_22 = U0_base;
  U_21 = m1__ntoa_format((long) U0_stream, (long) U0_out, (long) U0_buffer, (long) U0_idx, (long) U0_maxlen, (long) fp, (long) U0_len, (short) u0_negative, (long) u_22, (long) u0_prec, (long) u0_width, (long) u0_flags);
  mir_set_stack_position(mir_saved_stack_position);
  return (long) U_21;
} // End of switch
} // End of while
} // End of function _ntoa_long

protected long m1__ntoa_long_long (long _U0_stream, long _U0_out, long _U0_buffer, long _U0_idx, long _U0_maxlen, long _U0_value, short _u0_negative, long _U0_base, long _u0_prec, long _u0_width, long _u0_flags) {
  long U0_stream = _U0_stream;
  long U0_out = _U0_out;
  long U0_buffer = _U0_buffer;
  long U0_idx = _U0_idx;
  long U0_maxlen = _U0_maxlen;
  long U0_value = _U0_value;
  long u0_negative = _u0_negative;
  long U0_base = _U0_base;
  long u0_prec = _u0_prec;
  long u0_width = _u0_width;
  long u0_flags = _u0_flags;
  long fp = 0;
  long U0_len = 0;
  long u_0 = 0;
  long u_1 = 0;
  long u_2 = 0;
  long I_3 = 0;
  long i3_digit = 0;
  long U_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long U_7 = 0;
  long U_8 = 0;
  long i_9 = 0;
  long i_10 = 0;
  long i_11 = 0;
  long u_12 = 0;
  long I_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long I_17 = 0;
  long U_18 = 0;
  long U_19 = 0;
  long i_20 = 0;
  long U_21 = 0;
  long u_22 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(32L);
  U0_len = 0L;
  if (((long) U0_value != 0)) { mir_label = 442; break; }
case 443:
  u_0 = u0_flags;
  u_0 = (int) u_0 & (int) 4294967279L;
  u0_flags = u_0;
  mir_label = 444; break;
case 442:
case 444:
  u_2 = (int) u0_flags & (int) 1024L;
  I_3 = (((long) u_2) & 0xFFFFFFFFL);
  if (((long) I_3 == 0)) { mir_label = 445; break; }
case 446:
  if (((long) U0_value == 0)) { mir_label = 447; break; }
case 445:
case 448:
  U_4 = (long) Long.remainderUnsigned((long) U0_value, (long) U0_base);
  I_5 = (long) (byte) U_4;
  I_6 = (long) (byte) I_5;
  i3_digit = I_6;
  U_7 = U0_len;
  U_8 = U0_len;
  U_8 = (long) U_8 + (long) 1L;
  U0_len = U_8;
  if ((int) i3_digit >= (int) 10L) { mir_label = 449; break; }
case 450:
  i_10 = (int) 48L + (int) i3_digit;
  i_11 = i_10;
  mir_label = 451; break;
case 449:
  u_12 = (int) u0_flags & (int) 32L;
  I_13 = (((long) u_12) & 0xFFFFFFFFL);
  if (((long) I_13 == 0)) { mir_label = 452; break; }
case 453:
  i_14 = 65L;
  mir_label = 454; break;
case 452:
  i_14 = 97L;
case 454:
  i_15 = (int) i_14 + (int) i3_digit;
  i_16 = (int) i_15 - (int) 10L;
  i_11 = i_16;
case 451:
  I_17 = (long) (byte) i_11;
  mir_write_byte(fp + U_7, I_17);
  U_18 = U0_value;
  U_18 = (long) Long.divideUnsigned((long) U_18, (long) U0_base);
  U0_value = U_18;
case 455:
  if (((long) U0_value == 0)) { mir_label = 456; break; }
case 457:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) < 0) { mir_label = 448; break; }
case 456:
  mir_label = 458; break;
case 447:
case 458:
  u_22 = U0_base;
  U_21 = m1__ntoa_format((long) U0_stream, (long) U0_out, (long) U0_buffer, (long) U0_idx, (long) U0_maxlen, (long) fp, (long) U0_len, (short) u0_negative, (long) u_22, (long) u0_prec, (long) u0_width, (long) u0_flags);
  mir_set_stack_position(mir_saved_stack_position);
  return (long) U_21;
} // End of switch
} // End of while
} // End of function _ntoa_long_long

protected long m1__ftoa (long _U0_stream, long _U0_out, long _U0_buffer, long _U0_idx, long _U0_maxlen, double d0_value, long _u0_prec, long _u0_width, long _u0_flags) {
  long U0_stream = _U0_stream;
  long U0_out = _U0_out;
  long U0_buffer = _U0_buffer;
  long U0_idx = _U0_idx;
  long U0_maxlen = _U0_maxlen;
  long u0_prec = _u0_prec;
  long u0_width = _u0_width;
  long u0_flags = _u0_flags;
  long fp = 0;
  long U0_start_idx = 0;
  long U0_len = 0;
  double d0_diff = 0;
  double d0_thres_max = 0;
  long u0_negative = 0;
  long I_0 = 0;
  double d_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  double d_4 = 0;
  double d_5 = 0;
  long u_6 = 0;
  long I_7 = 0;
  long i_8 = 0;
  long i_9 = 0;
  long U_10 = 0;
  long U_11 = 0;
  long I_12 = 0;
  long u_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long i0_whole = 0;
  long i_16 = 0;
  double d0_tmp = 0;
  double d_17 = 0;
  long I_18 = 0;
  double d_19 = 0;
  long I_20 = 0;
  long U_21 = 0;
  double d_22 = 0;
  long U0_frac = 0;
  long U_23 = 0;
  double d_24 = 0;
  double d_25 = 0;
  long i_26 = 0;
  long U_27 = 0;
  long U_28 = 0;
  long I_29 = 0;
  long U_30 = 0;
  double d_31 = 0;
  long i_32 = 0;
  long i_33 = 0;
  long i_34 = 0;
  long i_35 = 0;
  long i_36 = 0;
  long U_37 = 0;
  long U_38 = 0;
  long U_39 = 0;
  long i_40 = 0;
  long i_41 = 0;
  double d_42 = 0;
  long I_43 = 0;
  double d_44 = 0;
  long i_45 = 0;
  long i_46 = 0;
  long i_47 = 0;
  long i_48 = 0;
  long i_49 = 0;
  long I_50 = 0;
  long i_51 = 0;
  long i_52 = 0;
  long u11_count = 0;
  long i_53 = 0;
  long u_54 = 0;
  long u_55 = 0;
  long U_56 = 0;
  long U_57 = 0;
  long U_58 = 0;
  long U_59 = 0;
  long I_60 = 0;
  long I_61 = 0;
  long U_62 = 0;
  long U_63 = 0;
  long i_64 = 0;
  long i_65 = 0;
  long u_66 = 0;
  long u_67 = 0;
  long i_68 = 0;
  long U_69 = 0;
  long U_70 = 0;
  long I_71 = 0;
  long i_72 = 0;
  long u_73 = 0;
  long u_74 = 0;
  long i_75 = 0;
  long i_76 = 0;
  long U_77 = 0;
  long U_78 = 0;
  long I_79 = 0;
  long i_80 = 0;
  long U_81 = 0;
  long U_82 = 0;
  long i_83 = 0;
  long i_84 = 0;
  long I_85 = 0;
  long I_86 = 0;
  long i_87 = 0;
  long i_88 = 0;
  long I_89 = 0;
  long i_90 = 0;
  long u_91 = 0;
  long I_92 = 0;
  long u_93 = 0;
  long I_94 = 0;
  long U_95 = 0;
  long i_96 = 0;
  long i_97 = 0;
  long U_98 = 0;
  long U_99 = 0;
  long I_100 = 0;
  long U_101 = 0;
  long i_102 = 0;
  long i_103 = 0;
  long U_104 = 0;
  long i_105 = 0;
  long I_106 = 0;
  long u_107 = 0;
  long I_108 = 0;
  long u_109 = 0;
  long I_110 = 0;
  long U_111 = 0;
  long i_112 = 0;
  long I_113 = 0;
  long U_114 = 0;
  long U_115 = 0;
  long I_116 = 0;
  long u_117 = 0;
  long I_118 = 0;
  long U_119 = 0;
  long U_120 = 0;
  long I_121 = 0;
  long u_122 = 0;
  long I_123 = 0;
  long U_124 = 0;
  long U_125 = 0;
  long I_126 = 0;
  long u_127 = 0;
  long I_128 = 0;
  long u_129 = 0;
  long I_130 = 0;
  long U26_i = 0;
  long U_131 = 0;
  long i_132 = 0;
  long U_133 = 0;
  long U_134 = 0;
  long U_135 = 0;
  long U_136 = 0;
  long i_137 = 0;
  long U28_i = 0;
  long i_138 = 0;
  long U_139 = 0;
  long U_140 = 0;
  long U_141 = 0;
  long U_142 = 0;
  long U_143 = 0;
  long i_144 = 0;
  long u_145 = 0;
  long I_146 = 0;
  long U_147 = 0;
  long U_148 = 0;
  long i_149 = 0;
  long U_150 = 0;
  long U_151 = 0;
  long U_152 = 0;
  long U_153 = 0;
  long i_154 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(112L);
  U0_start_idx = U0_idx;
  U0_len = 0L;
  d0_diff = 0;
  d0_thres_max = 2147483647;
  I_0 = (((long) (int) 0L) & 0xFFL);
  u0_negative = I_0;
  d_1 = (double) 0L;
  if (d0_value < d_1) { mir_label = 459; break; }
  mir_label = 460; break;
case 459:
  I_3 = (((long) (int) 1L) & 0xFFL);
  u0_negative = I_3;
  d_4 = (double) 0L;
  d_5 = d_4 - d0_value;
  d0_value = d_5;
  mir_label = 461; break;
case 460:
case 461:
  u_6 = (int) u0_flags & (int) 1024L;
  I_7 = (((long) u_6) & 0xFFFFFFFFL);
  if (((long) I_7 != 0)) { mir_label = 462; break; }
case 463:
  u0_prec = 6L;
  mir_label = 464; break;
case 462:
case 464:
case 465:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 466; break; }
case 467:
  if (Integer.compareUnsigned((int) u0_prec, (int) 9L) <= 0) { mir_label = 466; break; }
case 468:
  U_10 = U0_len;
  U_11 = U0_len;
  U_11 = (long) U_11 + (long) 1L;
  U0_len = U_11;
  I_12 = (long) (byte) 48L;
  mir_write_byte(fp + U_10, I_12);
  u_13 = u0_prec;
  u_13 = (int) u_13 - (int) 1L;
  u0_prec = u_13;
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 466; break; }
case 469:
  if (Integer.compareUnsigned((int) u0_prec, (int) 9L) > 0) { mir_label = 468; break; }
case 466:
  i_16 = (long) d0_value;
  i0_whole = i_16;
  I_18 = (long) (int) i0_whole;
  d_17 = (double) I_18;
  d_19 = d0_value - d_17;
  I_20 = m1_S0__ftoa_pow10;
  U_21 = (((long) u0_prec) & 0xFFFFFFFFL);
  d_22 = d_19 * mir_read_double(I_20 + U_21 * 8);
  d0_tmp = d_22;
  U_23 = (long) d0_tmp;
  U0_frac = U_23;
  d_24 = (double) (long) U0_frac;
  d_25 = d0_tmp - d_24;
  d0_diff = d_25;
  if (d0_diff > 0.5) { mir_label = 470; break; }
  mir_label = 471; break;
case 470:
  U_27 = U0_frac;
  U_27 = (long) U_27 + (long) 1L;
  U0_frac = U_27;
  I_29 = m1_S0__ftoa_pow10;
  U_30 = (((long) u0_prec) & 0xFFFFFFFFL);
  d_31 = (double) (long) U0_frac;
  if (d_31 >= mir_read_double(I_29 + U_30 * 8)) { mir_label = 472; break; }
  mir_label = 473; break;
case 472:
  U0_frac = 0L;
  i_33 = i0_whole;
  i_33 = (int) i_33 + (int) 1L;
  i0_whole = i_33;
  mir_label = 474; break;
case 473:
case 474:
  mir_label = 475; break;
case 471:
  if (d0_diff == 0.5) { mir_label = 476; break; }
  mir_label = 477; break;
case 476:
  if ((long) U0_frac == (long) 0L) { mir_label = 478; break; }
case 479:
  U_37 = (long) U0_frac & (long) 1L;
  if (((long) U_37 == 0)) { mir_label = 477; break; }
case 478:
  U_38 = U0_frac;
  U_38 = (long) U_38 + (long) 1L;
  U0_frac = U_38;
  mir_label = 480; break;
case 477:
case 480:
case 475:
  if (d0_value > d0_thres_max) { mir_label = 481; break; }
  mir_label = 482; break;
case 481:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) 0L;
  // Dead code: mir_label = 483; break;
case 482:
case 483:
  if ((int) u0_prec != (int) 0L) { mir_label = 484; break; }
case 485:
  I_43 = (long) (int) i0_whole;
  d_42 = (double) I_43;
  d_44 = d0_value - d_42;
  d0_diff = d_44;
  if (d0_diff > 0.5) { mir_label = 486; break; }
  mir_label = 487; break;
case 486:
  i_46 = i0_whole;
  i_46 = (int) i_46 + (int) 1L;
  i0_whole = i_46;
  mir_label = 488; break;
case 487:
  if (d0_diff == 0.5) { mir_label = 489; break; }
  mir_label = 490; break;
case 489:
  i_49 = (int) i0_whole & (int) 1L;
  I_50 = (long) (int) i_49;
  if (((long) I_50 == 0)) { mir_label = 490; break; }
case 491:
  i_51 = i0_whole;
  i_51 = (int) i_51 + (int) 1L;
  i0_whole = i_51;
  mir_label = 492; break;
case 490:
case 492:
case 488:
  mir_label = 493; break;
case 484:
  u11_count = u0_prec;
case 494:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 495; break; }
case 496:
  u_54 = u11_count;
  u_54 = (int) u_54 - (int) 1L;
  u11_count = u_54;
  U_56 = U0_len;
  U_57 = U0_len;
  U_57 = (long) U_57 + (long) 1L;
  U0_len = U_57;
  U_58 = (long) Long.remainderUnsigned((long) U0_frac, (long) 10L);
  U_59 = (long) 48L + (long) U_58;
  I_60 = (long) (byte) U_59;
  I_61 = (long) (byte) I_60;
  mir_write_byte(fp + U_56, I_61);
  U_62 = U0_frac;
  U_62 = (long) Long.divideUnsigned((long) U_62, (long) 10L);
  U0_frac = U_62;
  U_63 = U_62;
  if (((long) U_63 != 0)) { mir_label = 497; break; }
case 498:
  mir_label = 495; break;
  // Dead code: mir_label = 499; break;
case 497:
case 499:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) < 0) { mir_label = 496; break; }
case 495:
case 500:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 501; break; }
case 502:
  u_66 = u11_count;
  u_67 = u11_count;
  u_67 = (int) u_67 - (int) 1L;
  u11_count = u_67;
  if (Integer.compareUnsigned((int) u_66, (int) 0L) <= 0) { mir_label = 501; break; }
case 503:
  U_69 = U0_len;
  U_70 = U0_len;
  U_70 = (long) U_70 + (long) 1L;
  U0_len = U_70;
  I_71 = (long) (byte) 48L;
  mir_write_byte(fp + U_69, I_71);
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 501; break; }
case 504:
  u_73 = u11_count;
  u_74 = u11_count;
  u_74 = (int) u_74 - (int) 1L;
  u11_count = u_74;
  if (Integer.compareUnsigned((int) u_73, (int) 0L) > 0) { mir_label = 503; break; }
case 501:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 505; break; }
case 506:
  U_77 = U0_len;
  U_78 = U0_len;
  U_78 = (long) U_78 + (long) 1L;
  U0_len = U_78;
  I_79 = (long) (byte) 46L;
  mir_write_byte(fp + U_77, I_79);
  mir_label = 507; break;
case 505:
case 507:
case 493:
case 508:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 509; break; }
case 510:
  U_81 = U0_len;
  U_82 = U0_len;
  U_82 = (long) U_82 + (long) 1L;
  U0_len = U_82;
  i_83 = (int) i0_whole % (int) 10L;
  i_84 = (int) 48L + (int) i_83;
  I_85 = (long) (byte) i_84;
  I_86 = (long) (byte) I_85;
  mir_write_byte(fp + U_81, I_86);
  i_87 = i0_whole;
  i_87 = (int) i_87 / (int) 10L;
  i0_whole = i_87;
  i_88 = i_87;
  I_89 = (long) (int) i_88;
  if (((long) I_89 != 0)) { mir_label = 511; break; }
case 512:
  mir_label = 509; break;
  // Dead code: mir_label = 513; break;
case 511:
case 513:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) < 0) { mir_label = 510; break; }
case 509:
  u_91 = (int) u0_flags & (int) 2L;
  I_92 = (((long) u_91) & 0xFFFFFFFFL);
  if (((long) I_92 != 0)) { mir_label = 514; break; }
case 515:
  u_93 = (int) u0_flags & (int) 1L;
  I_94 = (((long) u_93) & 0xFFFFFFFFL);
  if (((long) I_94 == 0)) { mir_label = 514; break; }
case 516:
case 517:
  U_95 = (((long) u0_width) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U0_len, (long) U_95) >= 0) { mir_label = 518; break; }
case 519:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 518; break; }
case 520:
  U_98 = U0_len;
  U_99 = U0_len;
  U_99 = (long) U_99 + (long) 1L;
  U0_len = U_99;
  I_100 = (long) (byte) 48L;
  mir_write_byte(fp + U_98, I_100);
  U_101 = (((long) u0_width) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U0_len, (long) U_101) >= 0) { mir_label = 518; break; }
case 521:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) < 0) { mir_label = 520; break; }
case 518:
  mir_label = 522; break;
case 514:
case 522:
  U_104 = (((long) u0_width) & 0xFFFFFFFFL);
  if ((long) U0_len != (long) U_104) { mir_label = 523; break; }
case 524:
  I_106 = (((long) u0_negative) & 0xFFFFFFFFL);
  if (((long) I_106 != 0)) { mir_label = 525; break; }
case 526:
  u_107 = (int) u0_flags & (int) 4L;
  I_108 = (((long) u_107) & 0xFFFFFFFFL);
  if (((long) I_108 != 0)) { mir_label = 525; break; }
case 527:
  u_109 = (int) u0_flags & (int) 8L;
  I_110 = (((long) u_109) & 0xFFFFFFFFL);
  if (((long) I_110 == 0)) { mir_label = 523; break; }
case 525:
  U_111 = U0_len;
  U_111 = (long) U_111 - (long) 1L;
  U0_len = U_111;
  mir_label = 528; break;
case 523:
case 528:
  if (Long.compareUnsigned((long) U0_len, (long) 32L) >= 0) { mir_label = 529; break; }
case 530:
  I_113 = (((long) u0_negative) & 0xFFFFFFFFL);
  if (((long) I_113 == 0)) { mir_label = 531; break; }
case 532:
  U_114 = U0_len;
  U_115 = U0_len;
  U_115 = (long) U_115 + (long) 1L;
  U0_len = U_115;
  I_116 = (long) (byte) 45L;
  mir_write_byte(fp + U_114, I_116);
  mir_label = 533; break;
case 531:
  u_117 = (int) u0_flags & (int) 4L;
  I_118 = (((long) u_117) & 0xFFFFFFFFL);
  if (((long) I_118 == 0)) { mir_label = 534; break; }
case 535:
  U_119 = U0_len;
  U_120 = U0_len;
  U_120 = (long) U_120 + (long) 1L;
  U0_len = U_120;
  I_121 = (long) (byte) 43L;
  mir_write_byte(fp + U_119, I_121);
  mir_label = 536; break;
case 534:
  u_122 = (int) u0_flags & (int) 8L;
  I_123 = (((long) u_122) & 0xFFFFFFFFL);
  if (((long) I_123 == 0)) { mir_label = 537; break; }
case 538:
  U_124 = U0_len;
  U_125 = U0_len;
  U_125 = (long) U_125 + (long) 1L;
  U0_len = U_125;
  I_126 = (long) (byte) 32L;
  mir_write_byte(fp + U_124, I_126);
  mir_label = 539; break;
case 537:
case 539:
case 536:
case 533:
  mir_label = 540; break;
case 529:
case 540:
  u_127 = (int) u0_flags & (int) 2L;
  I_128 = (((long) u_127) & 0xFFFFFFFFL);
  if (((long) I_128 != 0)) { mir_label = 541; break; }
case 542:
  u_129 = (int) u0_flags & (int) 1L;
  I_130 = (((long) u_129) & 0xFFFFFFFFL);
  if (((long) I_130 != 0)) { mir_label = 541; break; }
case 543:
  U26_i = U0_len;
  U_131 = (((long) u0_width) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U26_i, (long) U_131) >= 0) { mir_label = 544; break; }
case 545:
  U_133 = U0_idx;
  U_134 = U0_idx;
  U_134 = (long) U_134 + (long) 1L;
  U0_idx = U_134;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) 32L, (long) U0_buffer, (long) U_133, (long) U0_maxlen);
case 546:
  U_135 = U26_i;
  U_135 = (long) U_135 + (long) 1L;
  U26_i = U_135;
  U_136 = (((long) u0_width) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U26_i, (long) U_136) < 0) { mir_label = 545; break; }
case 544:
  mir_label = 547; break;
case 541:
case 547:
  U28_i = 0L;
  if (Long.compareUnsigned((long) U28_i, (long) U0_len) >= 0) { mir_label = 548; break; }
case 549:
  U_139 = (long) U0_len - (long) U28_i;
  U_140 = (long) U_139 - (long) 1L;
  U_141 = U0_idx;
  U_142 = U0_idx;
  U_142 = (long) U_142 + (long) 1L;
  U0_idx = U_142;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) mir_read_byte(fp + U_140), (long) U0_buffer, (long) U_141, (long) U0_maxlen);
case 550:
  U_143 = U28_i;
  U_143 = (long) U_143 + (long) 1L;
  U28_i = U_143;
  if (Long.compareUnsigned((long) U28_i, (long) U0_len) < 0) { mir_label = 549; break; }
case 548:
  u_145 = (int) u0_flags & (int) 2L;
  I_146 = (((long) u_145) & 0xFFFFFFFFL);
  if (((long) I_146 == 0)) { mir_label = 551; break; }
case 552:
case 553:
  U_147 = (long) U0_idx - (long) U0_start_idx;
  U_148 = (((long) u0_width) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U_147, (long) U_148) >= 0) { mir_label = 554; break; }
case 555:
  U_150 = U0_idx;
  U_151 = U0_idx;
  U_151 = (long) U_151 + (long) 1L;
  U0_idx = U_151;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) 32L, (long) U0_buffer, (long) U_150, (long) U0_maxlen);
  U_152 = (long) U0_idx - (long) U0_start_idx;
  U_153 = (((long) u0_width) & 0xFFFFFFFFL);
  if (Long.compareUnsigned((long) U_152, (long) U_153) < 0) { mir_label = 555; break; }
case 554:
  mir_label = 556; break;
case 551:
case 556:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) U0_idx;
} // End of switch
} // End of while
} // End of function _ftoa

long m1_S0__ftoa_pow10 = mir_set_data_double(1);
long unused_data_addr_15 = mir_set_data_double(10);
long unused_data_addr_16 = mir_set_data_double(100);
long unused_data_addr_17 = mir_set_data_double(1000);
long unused_data_addr_18 = mir_set_data_double(10000);
long unused_data_addr_19 = mir_set_data_double(100000);
long unused_data_addr_20 = mir_set_data_double(1000000);
long unused_data_addr_21 = mir_set_data_double(10000000);
long unused_data_addr_22 = mir_set_data_double(100000000);
long unused_data_addr_23 = mir_set_data_double(1000000000);
protected int m1__vsnprintf (long _U0_stream, long _U0_out, long _U0_buffer, long _U0_maxlen, long _U0_format, long _U0_va) {
  long U0_stream = _U0_stream;
  long U0_out = _U0_out;
  long U0_buffer = _U0_buffer;
  long U0_maxlen = _U0_maxlen;
  long U0_format = _U0_format;
  long U0_va = _U0_va;
  long fp = 0;
  long U0_idx = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long U_6 = 0;
  long U_7 = 0;
  long u0_flags = 0;
  long I_8 = 0;
  long i_9 = 0;
  long I_10 = 0;
  long u_11 = 0;
  long u_12 = 0;
  long U_13 = 0;
  long u0_n = 0;
  long u_14 = 0;
  long u_15 = 0;
  long U_16 = 0;
  long u_17 = 0;
  long u_18 = 0;
  long U_19 = 0;
  long u_20 = 0;
  long u_21 = 0;
  long U_22 = 0;
  long u_23 = 0;
  long u_24 = 0;
  long U_25 = 0;
  long I_26 = 0;
  long u0_width = 0;
  long i_27 = 0;
  long I_28 = 0;
  long I_29 = 0;
  long u_30 = 0;
  long U_31 = 0;
  long I_32 = 0;
  long i_33 = 0;
  long i8_w = 0;
  long i_34 = 0;
  long I_35 = 0;
  long i_36 = 0;
  long i_37 = 0;
  long u_38 = 0;
  long u_39 = 0;
  long i_40 = 0;
  long u_41 = 0;
  long u_42 = 0;
  long U_43 = 0;
  long u0_precision = 0;
  long I_44 = 0;
  long i_45 = 0;
  long u_46 = 0;
  long u_47 = 0;
  long U_48 = 0;
  long i_49 = 0;
  long I_50 = 0;
  long I_51 = 0;
  long u_52 = 0;
  long U_53 = 0;
  long I_54 = 0;
  long i_55 = 0;
  long i13_prec = 0;
  long i_56 = 0;
  long I_57 = 0;
  long i_58 = 0;
  long i_59 = 0;
  long i_60 = 0;
  long u_61 = 0;
  long u_62 = 0;
  long U_63 = 0;
  long I_64 = 0;
  long i_65 = 0;
  long u_66 = 0;
  long u_67 = 0;
  long U_68 = 0;
  long I_69 = 0;
  long i_70 = 0;
  long u_71 = 0;
  long u_72 = 0;
  long U_73 = 0;
  long u_74 = 0;
  long u_75 = 0;
  long U_76 = 0;
  long I_77 = 0;
  long i_78 = 0;
  long u_79 = 0;
  long u_80 = 0;
  long U_81 = 0;
  long u_82 = 0;
  long u_83 = 0;
  long U_84 = 0;
  long u_85 = 0;
  long u_86 = 0;
  long U_87 = 0;
  long u_88 = 0;
  long u_89 = 0;
  long U_90 = 0;
  long I_91 = 0;
  long i_92 = 0;
  long I_93 = 0;
  long i_94 = 0;
  long I_95 = 0;
  long i_96 = 0;
  long u18_base = 0;
  long I_97 = 0;
  long i_98 = 0;
  long I_99 = 0;
  long i_100 = 0;
  long u_101 = 0;
  long u_102 = 0;
  long I_103 = 0;
  long i_104 = 0;
  long u_105 = 0;
  long u_106 = 0;
  long I_107 = 0;
  long i_108 = 0;
  long I_109 = 0;
  long i_110 = 0;
  long u_111 = 0;
  long u_112 = 0;
  long u_113 = 0;
  long I_114 = 0;
  long u_115 = 0;
  long u_116 = 0;
  long I_117 = 0;
  long i_118 = 0;
  long I_119 = 0;
  long i_120 = 0;
  long u_121 = 0;
  long I_122 = 0;
  long I27_value = 0;
  long I_123 = 0;
  long I_124 = 0;
  long I_125 = 0;
  long U_126 = 0;
  long i_127 = 0;
  long I_128 = 0;
  long I_129 = 0;
  long U_130 = 0;
  long i_131 = 0;
  long U_132 = 0;
  long u_133 = 0;
  long I_134 = 0;
  long I28_value = 0;
  long I_135 = 0;
  long I_136 = 0;
  long I_137 = 0;
  long U_138 = 0;
  long i_139 = 0;
  long I_140 = 0;
  long I_141 = 0;
  long U_142 = 0;
  long i_143 = 0;
  long U_144 = 0;
  long i29_value = 0;
  long u_145 = 0;
  long I_146 = 0;
  long i_147 = 0;
  long I_148 = 0;
  long i_149 = 0;
  long I_150 = 0;
  long i_151 = 0;
  long u_152 = 0;
  long I_153 = 0;
  long i_154 = 0;
  long I_155 = 0;
  long i_156 = 0;
  long I_157 = 0;
  long i_158 = 0;
  long i_159 = 0;
  long I_160 = 0;
  long i_161 = 0;
  long U_162 = 0;
  long i_163 = 0;
  long i_164 = 0;
  long i_165 = 0;
  long u_166 = 0;
  long U_167 = 0;
  long i_168 = 0;
  long U_169 = 0;
  long u_170 = 0;
  long I_171 = 0;
  long U_172 = 0;
  long U_173 = 0;
  long I_174 = 0;
  long U_175 = 0;
  long U_176 = 0;
  long u_177 = 0;
  long I_178 = 0;
  long U_179 = 0;
  long U_180 = 0;
  long I_181 = 0;
  long U_182 = 0;
  long U_183 = 0;
  long u33_value = 0;
  long u_184 = 0;
  long I_185 = 0;
  long u_186 = 0;
  long I_187 = 0;
  long u_188 = 0;
  long I_189 = 0;
  long u_190 = 0;
  long u_191 = 0;
  long I_192 = 0;
  long u_193 = 0;
  long I_194 = 0;
  long u_195 = 0;
  long I_196 = 0;
  long u_197 = 0;
  long u_198 = 0;
  long I_199 = 0;
  long u_200 = 0;
  long U_201 = 0;
  long U_202 = 0;
  long U_203 = 0;
  long U_204 = 0;
  long U_205 = 0;
  double d_206 = 0;
  long I_207 = 0;
  double d_208 = 0;
  long U_209 = 0;
  long u34_l = 0;
  long u_210 = 0;
  long I_211 = 0;
  long u_212 = 0;
  long u_213 = 0;
  long i_214 = 0;
  long U_215 = 0;
  long U_216 = 0;
  long u_217 = 0;
  long u_218 = 0;
  long i_219 = 0;
  long i_220 = 0;
  long I_221 = 0;
  long i_222 = 0;
  long I_223 = 0;
  long U_224 = 0;
  long U_225 = 0;
  long u_226 = 0;
  long I_227 = 0;
  long u_228 = 0;
  long u_229 = 0;
  long i_230 = 0;
  long U_231 = 0;
  long U_232 = 0;
  long u_233 = 0;
  long u_234 = 0;
  long i_235 = 0;
  long U_236 = 0;
  long U39_p = 0;
  long U_237 = 0;
  long I_238 = 0;
  long U_239 = 0;
  long u39_l = 0;
  long U_240 = 0;
  long u_241 = 0;
  long I_242 = 0;
  long i_243 = 0;
  long u_244 = 0;
  long u_245 = 0;
  long I_246 = 0;
  long u_247 = 0;
  long u_248 = 0;
  long i_249 = 0;
  long U_250 = 0;
  long U_251 = 0;
  long u_252 = 0;
  long u_253 = 0;
  long i_254 = 0;
  long i_255 = 0;
  long u_256 = 0;
  long I_257 = 0;
  long u_258 = 0;
  long u_259 = 0;
  long I_260 = 0;
  long U_261 = 0;
  long U_262 = 0;
  long U_263 = 0;
  long U_264 = 0;
  long i_265 = 0;
  long u_266 = 0;
  long I_267 = 0;
  long u_268 = 0;
  long u_269 = 0;
  long I_270 = 0;
  long u_271 = 0;
  long I_272 = 0;
  long u_273 = 0;
  long u_274 = 0;
  long i_275 = 0;
  long U_276 = 0;
  long U_277 = 0;
  long u_278 = 0;
  long u_279 = 0;
  long i_280 = 0;
  long U_281 = 0;
  long u_282 = 0;
  long u_283 = 0;
  long u46_is_ll = 0;
  long I_284 = 0;
  long I_285 = 0;
  long U_286 = 0;
  long U_287 = 0;
  long I_288 = 0;
  long U_289 = 0;
  long u_290 = 0;
  long U_291 = 0;
  long U_292 = 0;
  long U_293 = 0;
  long I_294 = 0;
  long U_295 = 0;
  long u_296 = 0;
  long U_297 = 0;
  long U_298 = 0;
  long U_299 = 0;
  long U_300 = 0;
  long U_301 = 0;
  long I_302 = 0;
  long U_303 = 0;
  long U_304 = 0;
  long U_305 = 0;
  long I_306 = 0;
  long i_307 = 0;
  long U_308 = 0;
  long U_309 = 0;
  long i_310 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  mir_write_ulong(fp, U0_format);
  U0_idx = 0L;
  if (((long) U0_buffer != 0)) { mir_label = 557; break; }
case 558:
  U0_out = mir_get_function_ptr("m1__out_null");
  mir_label = 559; break;
case 557:
case 559:
case 560:
  I_0 = mir_read_ulong(fp);
  if (((long) mir_read_byte(I_0) == 0)) { mir_label = 561; break; }
case 562:
  I_1 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_1) == (int) 37L) { mir_label = 563; break; }
case 564:
  I_3 = mir_read_ulong(fp);
  U_4 = U0_idx;
  U_5 = U0_idx;
  U_5 = (long) U_5 + (long) 1L;
  U0_idx = U_5;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) mir_read_byte(I_3), (long) U0_buffer, (long) U_4, (long) U0_maxlen);
  U_6 = mir_read_ulong(fp);
  U_6 = (long) U_6 + (long) 1L;
  mir_write_ulong(fp, U_6);
  mir_label = 560; break;
  // Dead code: mir_label = 565; break;
case 563:
  U_7 = mir_read_ulong(fp);
  U_7 = (long) U_7 + (long) 1L;
  mir_write_ulong(fp, U_7);
case 565:
  u0_flags = 0L;
case 566:
  I_8 = mir_read_ulong(fp);
  i_9 = mir_read_byte(I_8);
  I_10 = (int) i_9 - (int) 32L;
  if (Integer.compareUnsigned((int) I_10, (int) 16L) > 0) { mir_label = 567; break; }
  I_10 = (((long) I_10) & 0xFFFFFFFFL);
  switch((int) I_10) {
  case 0: mir_label = 568; break;
  case 1: mir_label = 567; break;
  case 2: mir_label = 567; break;
  case 3: mir_label = 569; break;
  case 4: mir_label = 567; break;
  case 5: mir_label = 567; break;
  case 6: mir_label = 567; break;
  case 7: mir_label = 567; break;
  case 8: mir_label = 567; break;
  case 9: mir_label = 567; break;
  case 10: mir_label = 567; break;
  case 11: mir_label = 570; break;
  case 12: mir_label = 567; break;
  case 13: mir_label = 571; break;
  case 14: mir_label = 567; break;
  case 15: mir_label = 567; break;
  case 16: mir_label = 572; break;
  }
  break; // End of switch(I_10)
case 572:
  u_11 = u0_flags;
  u_11 = (int) u_11 | (int) 1L;
  u0_flags = u_11;
  U_13 = mir_read_ulong(fp);
  U_13 = (long) U_13 + (long) 1L;
  mir_write_ulong(fp, U_13);
  u0_n = 1L;
  mir_label = 573; break;
case 571:
  u_14 = u0_flags;
  u_14 = (int) u_14 | (int) 2L;
  u0_flags = u_14;
  U_16 = mir_read_ulong(fp);
  U_16 = (long) U_16 + (long) 1L;
  mir_write_ulong(fp, U_16);
  u0_n = 1L;
  mir_label = 573; break;
case 570:
  u_17 = u0_flags;
  u_17 = (int) u_17 | (int) 4L;
  u0_flags = u_17;
  U_19 = mir_read_ulong(fp);
  U_19 = (long) U_19 + (long) 1L;
  mir_write_ulong(fp, U_19);
  u0_n = 1L;
  mir_label = 573; break;
case 568:
  u_20 = u0_flags;
  u_20 = (int) u_20 | (int) 8L;
  u0_flags = u_20;
  U_22 = mir_read_ulong(fp);
  U_22 = (long) U_22 + (long) 1L;
  mir_write_ulong(fp, U_22);
  u0_n = 1L;
  mir_label = 573; break;
case 569:
  u_23 = u0_flags;
  u_23 = (int) u_23 | (int) 16L;
  u0_flags = u_23;
  U_25 = mir_read_ulong(fp);
  U_25 = (long) U_25 + (long) 1L;
  mir_write_ulong(fp, U_25);
  u0_n = 1L;
  mir_label = 573; break;
case 567:
  u0_n = 0L;
case 573:
case 574:
  I_26 = (((long) u0_n) & 0xFFFFFFFFL);
  if (((long) I_26 != 0)) { mir_label = 566; break; }
case 575:
  u0_width = 0L;
  I_28 = mir_read_ulong(fp);
  i_27 = isdigit((int) mir_read_byte(I_28));
  I_29 = (long) (int) i_27;
  if (((long) I_29 == 0)) { mir_label = 576; break; }
case 577:
  U_31 = fp;
  u_30 = m1__atoi((long) U_31);
  u0_width = u_30;
  mir_label = 578; break;
case 576:
  I_32 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_32) != (int) 42L) { mir_label = 579; break; }
case 580:
  { // va_arg(int)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_35 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_int(I_35, (int) arg_value);
  } // end of va_arg
  i_36 = mir_read_int(I_35);
  i8_w = i_36;
  if ((int) i8_w >= (int) 0L) { mir_label = 581; break; }
case 582:
  u_38 = u0_flags;
  u_38 = (int) u_38 | (int) 2L;
  u0_flags = u_38;
  i_40 = - (int) i8_w;
  u_41 = i_40;
  u0_width = u_41;
  mir_label = 583; break;
case 581:
  u_42 = i8_w;
  u0_width = u_42;
case 583:
  U_43 = mir_read_ulong(fp);
  U_43 = (long) U_43 + (long) 1L;
  mir_write_ulong(fp, U_43);
  mir_label = 584; break;
case 579:
case 584:
case 578:
  u0_precision = 0L;
  I_44 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_44) != (int) 46L) { mir_label = 585; break; }
case 586:
  u_46 = u0_flags;
  u_46 = (int) u_46 | (int) 1024L;
  u0_flags = u_46;
  U_48 = mir_read_ulong(fp);
  U_48 = (long) U_48 + (long) 1L;
  mir_write_ulong(fp, U_48);
  I_50 = mir_read_ulong(fp);
  i_49 = isdigit((int) mir_read_byte(I_50));
  I_51 = (long) (int) i_49;
  if (((long) I_51 == 0)) { mir_label = 587; break; }
case 588:
  U_53 = fp;
  u_52 = m1__atoi((long) U_53);
  u0_precision = u_52;
  mir_label = 589; break;
case 587:
  I_54 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_54) != (int) 42L) { mir_label = 590; break; }
case 591:
  { // va_arg(int)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_57 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_int(I_57, (int) arg_value);
  } // end of va_arg
  i_58 = mir_read_int(I_57);
  i_59 = i_58;
  i13_prec = i_59;
  if ((int) i13_prec <= (int) 0L) { mir_label = 592; break; }
case 593:
  u_61 = i13_prec;
  u_62 = u_61;
  mir_label = 594; break;
case 592:
  u_62 = 0L;
case 594:
  u0_precision = u_62;
  U_63 = mir_read_ulong(fp);
  U_63 = (long) U_63 + (long) 1L;
  mir_write_ulong(fp, U_63);
  mir_label = 595; break;
case 590:
case 595:
case 589:
  mir_label = 596; break;
case 585:
case 596:
  I_64 = mir_read_ulong(fp);
  i_65 = mir_read_byte(I_64);
  if ((int) i_65 == (int) 108L) { mir_label = 597; break; }
  if ((int) i_65 == (int) 104L) { mir_label = 598; break; }
  if ((int) i_65 == (int) 116L) { mir_label = 599; break; }
  if ((int) i_65 == (int) 106L) { mir_label = 600; break; }
  if ((int) i_65 == (int) 122L) { mir_label = 601; break; }
  mir_label = 602; break;
case 597:
  u_66 = u0_flags;
  u_66 = (int) u_66 | (int) 256L;
  u0_flags = u_66;
  U_68 = mir_read_ulong(fp);
  U_68 = (long) U_68 + (long) 1L;
  mir_write_ulong(fp, U_68);
  I_69 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_69) != (int) 108L) { mir_label = 603; break; }
case 604:
  u_71 = u0_flags;
  u_71 = (int) u_71 | (int) 512L;
  u0_flags = u_71;
  U_73 = mir_read_ulong(fp);
  U_73 = (long) U_73 + (long) 1L;
  mir_write_ulong(fp, U_73);
  mir_label = 605; break;
case 603:
case 605:
  mir_label = 606; break;
case 598:
  u_74 = u0_flags;
  u_74 = (int) u_74 | (int) 128L;
  u0_flags = u_74;
  U_76 = mir_read_ulong(fp);
  U_76 = (long) U_76 + (long) 1L;
  mir_write_ulong(fp, U_76);
  I_77 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_77) != (int) 104L) { mir_label = 607; break; }
case 608:
  u_79 = u0_flags;
  u_79 = (int) u_79 | (int) 64L;
  u0_flags = u_79;
  U_81 = mir_read_ulong(fp);
  U_81 = (long) U_81 + (long) 1L;
  mir_write_ulong(fp, U_81);
  mir_label = 609; break;
case 607:
case 609:
  mir_label = 606; break;
case 599:
  u_82 = u0_flags;
  u_82 = (int) u_82 | (int) 256L;
  u0_flags = u_82;
  U_84 = mir_read_ulong(fp);
  U_84 = (long) U_84 + (long) 1L;
  mir_write_ulong(fp, U_84);
  mir_label = 606; break;
case 600:
  u_85 = u0_flags;
  u_85 = (int) u_85 | (int) 256L;
  u0_flags = u_85;
  U_87 = mir_read_ulong(fp);
  U_87 = (long) U_87 + (long) 1L;
  mir_write_ulong(fp, U_87);
  mir_label = 606; break;
case 601:
  u_88 = u0_flags;
  u_88 = (int) u_88 | (int) 256L;
  u0_flags = u_88;
  U_90 = mir_read_ulong(fp);
  U_90 = (long) U_90 + (long) 1L;
  mir_write_ulong(fp, U_90);
  mir_label = 606; break;
case 602:
case 606:
  I_91 = mir_read_ulong(fp);
  i_92 = mir_read_byte(I_91);
  if ((int) i_92 == (int) 100L) { mir_label = 610; break; }
  if ((int) i_92 == (int) 105L) { mir_label = 610; break; }
  if ((int) i_92 == (int) 117L) { mir_label = 610; break; }
  if ((int) i_92 == (int) 120L) { mir_label = 610; break; }
  if ((int) i_92 == (int) 88L) { mir_label = 610; break; }
  if ((int) i_92 == (int) 111L) { mir_label = 610; break; }
  if ((int) i_92 == (int) 98L) { mir_label = 610; break; }
  if ((int) i_92 == (int) 102L) { mir_label = 611; break; }
  if ((int) i_92 == (int) 70L) { mir_label = 611; break; }
  if ((int) i_92 == (int) 99L) { mir_label = 612; break; }
  if ((int) i_92 == (int) 115L) { mir_label = 613; break; }
  if ((int) i_92 == (int) 112L) { mir_label = 614; break; }
  if ((int) i_92 == (int) 37L) { mir_label = 615; break; }
  mir_label = 616; break;
case 610:
  I_93 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_93) == (int) 120L) { mir_label = 617; break; }
case 618:
  I_95 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_95) != (int) 88L) { mir_label = 619; break; }
case 617:
  u18_base = 16L;
  mir_label = 620; break;
case 619:
  I_97 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_97) != (int) 111L) { mir_label = 621; break; }
case 622:
  u18_base = 8L;
  mir_label = 623; break;
case 621:
  I_99 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_99) != (int) 98L) { mir_label = 624; break; }
case 625:
  u18_base = 2L;
  mir_label = 626; break;
case 624:
  u18_base = 10L;
  u_101 = u0_flags;
  u_101 = (int) u_101 & (int) 4294967279L;
  u0_flags = u_101;
case 626:
case 623:
case 620:
  I_103 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_103) != (int) 88L) { mir_label = 627; break; }
case 628:
  u_105 = u0_flags;
  u_105 = (int) u_105 | (int) 32L;
  u0_flags = u_105;
  mir_label = 629; break;
case 627:
case 629:
  I_107 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_107) == (int) 105L) { mir_label = 630; break; }
case 631:
  I_109 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_109) == (int) 100L) { mir_label = 630; break; }
case 632:
  u_111 = u0_flags;
  u_111 = (int) u_111 & (int) 4294967283L;
  u0_flags = u_111;
  mir_label = 633; break;
case 630:
case 633:
  u_113 = (int) u0_flags & (int) 1024L;
  I_114 = (((long) u_113) & 0xFFFFFFFFL);
  if (((long) I_114 == 0)) { mir_label = 634; break; }
case 635:
  u_115 = u0_flags;
  u_115 = (int) u_115 & (int) 4294967294L;
  u0_flags = u_115;
  mir_label = 636; break;
case 634:
case 636:
  I_117 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_117) == (int) 105L) { mir_label = 637; break; }
case 638:
  I_119 = mir_read_ulong(fp);
  if ((int) mir_read_byte(I_119) != (int) 100L) { mir_label = 639; break; }
case 637:
  u_121 = (int) u0_flags & (int) 512L;
  I_122 = (((long) u_121) & 0xFFFFFFFFL);
  if (((long) I_122 == 0)) { mir_label = 640; break; }
case 641:
  { // va_arg(long)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_124 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_long(I_124, (long) arg_value);
  } // end of va_arg
  I_125 = mir_read_long(I_124);
  I27_value = I_125;
  if ((long) I27_value <= (long) 0L) { mir_label = 642; break; }
case 643:
  I_128 = I27_value;
  mir_label = 644; break;
case 642:
  I_129 = (long) 0L - (long) I27_value;
  I_128 = I_129;
case 644:
  U_130 = I_128;
  i_131 = ((long) I27_value < (long) 0L) ? 1 : 0;
  U_132 = (((long) u18_base) & 0xFFFFFFFFL);
  U_126 = m1__ntoa_long_long((long) U0_stream, (long) U0_out, (long) U0_buffer, (long) U0_idx, (long) U0_maxlen, (long) U_130, (short) i_131, (long) U_132, (long) u0_precision, (long) u0_width, (long) u0_flags);
  U0_idx = U_126;
  mir_label = 645; break;
case 640:
  u_133 = (int) u0_flags & (int) 256L;
  I_134 = (((long) u_133) & 0xFFFFFFFFL);
  if (((long) I_134 == 0)) { mir_label = 646; break; }
case 647:
  { // va_arg(long)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_136 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_long(I_136, (long) arg_value);
  } // end of va_arg
  I_137 = mir_read_long(I_136);
  I28_value = I_137;
  if ((long) I28_value <= (long) 0L) { mir_label = 648; break; }
case 649:
  I_140 = I28_value;
  mir_label = 650; break;
case 648:
  I_141 = (long) 0L - (long) I28_value;
  I_140 = I_141;
case 650:
  U_142 = I_140;
  i_143 = ((long) I28_value < (long) 0L) ? 1 : 0;
  U_144 = (((long) u18_base) & 0xFFFFFFFFL);
  U_138 = m1__ntoa_long((long) U0_stream, (long) U0_out, (long) U0_buffer, (long) U0_idx, (long) U0_maxlen, (long) U_142, (short) i_143, (long) U_144, (long) u0_precision, (long) u0_width, (long) u0_flags);
  U0_idx = U_138;
  mir_label = 651; break;
case 646:
  u_145 = (int) u0_flags & (int) 64L;
  I_146 = (((long) u_145) & 0xFFFFFFFFL);
  if (((long) I_146 == 0)) { mir_label = 652; break; }
case 653:
  { // va_arg(int)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_148 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_int(I_148, (int) arg_value);
  } // end of va_arg
  i_149 = mir_read_int(I_148);
  I_150 = (long) (byte) i_149;
  i_151 = I_150;
  mir_label = 654; break;
case 652:
  u_152 = (int) u0_flags & (int) 128L;
  I_153 = (((long) u_152) & 0xFFFFFFFFL);
  if (((long) I_153 == 0)) { mir_label = 655; break; }
case 656:
  { // va_arg(int)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_155 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_int(I_155, (int) arg_value);
  } // end of va_arg
  i_156 = mir_read_int(I_155);
  I_157 = (long) (short) i_156;
  i_158 = I_157;
  mir_label = 657; break;
case 655:
  { // va_arg(int)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_160 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_int(I_160, (int) arg_value);
  } // end of va_arg
  i_161 = mir_read_int(I_160);
  i_158 = i_161;
case 657:
  i_151 = i_158;
case 654:
  i29_value = i_151;
  if ((int) i29_value <= (int) 0L) { mir_label = 658; break; }
case 659:
  i_164 = i29_value;
  mir_label = 660; break;
case 658:
  i_165 = (int) 0L - (int) i29_value;
  i_164 = i_165;
case 660:
  u_166 = i_164;
  U_167 = (((long) u_166) & 0xFFFFFFFFL);
  i_168 = ((int) i29_value < (int) 0L) ? 1 : 0;
  U_169 = (((long) u18_base) & 0xFFFFFFFFL);
  U_162 = m1__ntoa_long((long) U0_stream, (long) U0_out, (long) U0_buffer, (long) U0_idx, (long) U0_maxlen, (long) U_167, (short) i_168, (long) U_169, (long) u0_precision, (long) u0_width, (long) u0_flags);
  U0_idx = U_162;
case 651:
case 645:
  mir_label = 661; break;
case 639:
  u_170 = (int) u0_flags & (int) 512L;
  I_171 = (((long) u_170) & 0xFFFFFFFFL);
  if (((long) I_171 == 0)) { mir_label = 662; break; }
case 663:
  { // va_arg(long)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_174 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_ulong(I_174, (long) arg_value);
  } // end of va_arg
  U_175 = mir_read_ulong(I_174);
  U_176 = (((long) u18_base) & 0xFFFFFFFFL);
  U_172 = m1__ntoa_long_long((long) U0_stream, (long) U0_out, (long) U0_buffer, (long) U0_idx, (long) U0_maxlen, (long) U_175, (short) 0L, (long) U_176, (long) u0_precision, (long) u0_width, (long) u0_flags);
  U0_idx = U_172;
  mir_label = 664; break;
case 662:
  u_177 = (int) u0_flags & (int) 256L;
  I_178 = (((long) u_177) & 0xFFFFFFFFL);
  if (((long) I_178 == 0)) { mir_label = 665; break; }
case 666:
  { // va_arg(long)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_181 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_ulong(I_181, (long) arg_value);
  } // end of va_arg
  U_182 = mir_read_ulong(I_181);
  U_183 = (((long) u18_base) & 0xFFFFFFFFL);
  U_179 = m1__ntoa_long((long) U0_stream, (long) U0_out, (long) U0_buffer, (long) U0_idx, (long) U0_maxlen, (long) U_182, (short) 0L, (long) U_183, (long) u0_precision, (long) u0_width, (long) u0_flags);
  U0_idx = U_179;
  mir_label = 667; break;
case 665:
  u_184 = (int) u0_flags & (int) 64L;
  I_185 = (((long) u_184) & 0xFFFFFFFFL);
  if (((long) I_185 == 0)) { mir_label = 668; break; }
case 669:
  { // va_arg(long)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_187 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_uint(I_187, (long) arg_value);
  } // end of va_arg
  u_188 = mir_read_uint(I_187);
  I_189 = (((long) (int) u_188) & 0xFFL);
  u_190 = I_189;
  mir_label = 670; break;
case 668:
  u_191 = (int) u0_flags & (int) 128L;
  I_192 = (((long) u_191) & 0xFFFFFFFFL);
  if (((long) I_192 == 0)) { mir_label = 671; break; }
case 672:
  { // va_arg(long)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_194 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_uint(I_194, (long) arg_value);
  } // end of va_arg
  u_195 = mir_read_uint(I_194);
  I_196 = (((long) (int) u_195) & 0xFFFFL);
  u_197 = I_196;
  mir_label = 673; break;
case 671:
  { // va_arg(long)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_199 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_uint(I_199, (long) arg_value);
  } // end of va_arg
  u_200 = mir_read_uint(I_199);
  u_197 = u_200;
case 673:
  u_190 = u_197;
case 670:
  u33_value = u_190;
  U_202 = (((long) u33_value) & 0xFFFFFFFFL);
  U_203 = (((long) u18_base) & 0xFFFFFFFFL);
  U_201 = m1__ntoa_long((long) U0_stream, (long) U0_out, (long) U0_buffer, (long) U0_idx, (long) U0_maxlen, (long) U_202, (short) 0L, (long) U_203, (long) u0_precision, (long) u0_width, (long) u0_flags);
  U0_idx = U_201;
case 667:
case 664:
case 661:
  U_204 = mir_read_ulong(fp);
  U_204 = (long) U_204 + (long) 1L;
  mir_write_ulong(fp, U_204);
  mir_label = 674; break;
case 611:
  { // va_arg(double)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_207 = varArgs.getArgDataAddr();
  double arg_value = varArgs.nextDouble();
  mir_write_double(I_207, (double) arg_value);
  } // end of va_arg
  d_208 = mir_read_double(I_207);
  U_205 = m1__ftoa((long) U0_stream, (long) U0_out, (long) U0_buffer, (long) U0_idx, (long) U0_maxlen, (double) d_208, (long) u0_precision, (long) u0_width, (long) u0_flags);
  U0_idx = U_205;
  U_209 = mir_read_ulong(fp);
  U_209 = (long) U_209 + (long) 1L;
  mir_write_ulong(fp, U_209);
  mir_label = 674; break;
case 612:
  u34_l = 1L;
  u_210 = (int) u0_flags & (int) 2L;
  I_211 = (((long) u_210) & 0xFFFFFFFFL);
  if (((long) I_211 != 0)) { mir_label = 675; break; }
case 676:
case 677:
  u_212 = u34_l;
  u_213 = u34_l;
  u_213 = (int) u_213 + (int) 1L;
  u34_l = u_213;
  if (Integer.compareUnsigned((int) u_212, (int) u0_width) >= 0) { mir_label = 678; break; }
case 679:
  U_215 = U0_idx;
  U_216 = U0_idx;
  U_216 = (long) U_216 + (long) 1L;
  U0_idx = U_216;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) 32L, (long) U0_buffer, (long) U_215, (long) U0_maxlen);
  u_217 = u34_l;
  u_218 = u34_l;
  u_218 = (int) u_218 + (int) 1L;
  u34_l = u_218;
  if (Integer.compareUnsigned((int) u_217, (int) u0_width) < 0) { mir_label = 679; break; }
case 678:
  mir_label = 680; break;
case 675:
case 680:
  { // va_arg(int)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_221 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_int(I_221, (int) arg_value);
  } // end of va_arg
  i_222 = mir_read_int(I_221);
  I_223 = (long) (byte) i_222;
  U_224 = U0_idx;
  U_225 = U0_idx;
  U_225 = (long) U_225 + (long) 1L;
  U0_idx = U_225;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) I_223, (long) U0_buffer, (long) U_224, (long) U0_maxlen);
  u_226 = (int) u0_flags & (int) 2L;
  I_227 = (((long) u_226) & 0xFFFFFFFFL);
  if (((long) I_227 == 0)) { mir_label = 681; break; }
case 682:
case 683:
  u_228 = u34_l;
  u_229 = u34_l;
  u_229 = (int) u_229 + (int) 1L;
  u34_l = u_229;
  if (Integer.compareUnsigned((int) u_228, (int) u0_width) >= 0) { mir_label = 684; break; }
case 685:
  U_231 = U0_idx;
  U_232 = U0_idx;
  U_232 = (long) U_232 + (long) 1L;
  U0_idx = U_232;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) 32L, (long) U0_buffer, (long) U_231, (long) U0_maxlen);
  u_233 = u34_l;
  u_234 = u34_l;
  u_234 = (int) u_234 + (int) 1L;
  u34_l = u_234;
  if (Integer.compareUnsigned((int) u_233, (int) u0_width) < 0) { mir_label = 685; break; }
case 684:
  mir_label = 686; break;
case 681:
case 686:
  U_236 = mir_read_ulong(fp);
  U_236 = (long) U_236 + (long) 1L;
  mir_write_ulong(fp, U_236);
  mir_label = 674; break;
case 613:
  { // va_arg(long)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_238 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_ulong(I_238, (long) arg_value);
  } // end of va_arg
  U_239 = mir_read_ulong(I_238);
  U39_p = U_239;
  U_240 = strlen((long) U39_p);
  u39_l = U_240;
  u_241 = (int) u0_flags & (int) 1024L;
  I_242 = (((long) u_241) & 0xFFFFFFFFL);
  if (((long) I_242 == 0)) { mir_label = 687; break; }
case 688:
  if (Integer.compareUnsigned((int) u39_l, (int) u0_precision) >= 0) { mir_label = 689; break; }
case 690:
  u_244 = u39_l;
  mir_label = 691; break;
case 689:
  u_244 = u0_precision;
case 691:
  u39_l = u_244;
  mir_label = 692; break;
case 687:
case 692:
  u_245 = (int) u0_flags & (int) 2L;
  I_246 = (((long) u_245) & 0xFFFFFFFFL);
  if (((long) I_246 != 0)) { mir_label = 693; break; }
case 694:
case 695:
  u_247 = u39_l;
  u_248 = u39_l;
  u_248 = (int) u_248 + (int) 1L;
  u39_l = u_248;
  if (Integer.compareUnsigned((int) u_247, (int) u0_width) >= 0) { mir_label = 696; break; }
case 697:
  U_250 = U0_idx;
  U_251 = U0_idx;
  U_251 = (long) U_251 + (long) 1L;
  U0_idx = U_251;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) 32L, (long) U0_buffer, (long) U_250, (long) U0_maxlen);
  u_252 = u39_l;
  u_253 = u39_l;
  u_253 = (int) u_253 + (int) 1L;
  u39_l = u_253;
  if (Integer.compareUnsigned((int) u_252, (int) u0_width) < 0) { mir_label = 697; break; }
case 696:
  mir_label = 698; break;
case 693:
case 698:
case 699:
  if ((int) mir_read_byte(U39_p) == (int) 0L) { mir_label = 700; break; }
case 701:
  u_256 = (int) u0_flags & (int) 1024L;
  I_257 = (((long) u_256) & 0xFFFFFFFFL);
  if (((long) I_257 == 0)) { mir_label = 702; break; }
case 703:
  u_258 = u0_precision;
  u_259 = u0_precision;
  u_259 = (int) u_259 - (int) 1L;
  u0_precision = u_259;
  I_260 = (((long) u_258) & 0xFFFFFFFFL);
  if (((long) I_260 == 0)) { mir_label = 700; break; }
case 702:
  U_261 = U39_p;
  U_262 = U39_p;
  U_262 = (long) U_262 + (long) 1L;
  U39_p = U_262;
  U_263 = U0_idx;
  U_264 = U0_idx;
  U_264 = (long) U_264 + (long) 1L;
  U0_idx = U_264;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) mir_read_byte(U_261), (long) U0_buffer, (long) U_263, (long) U0_maxlen);
  if ((int) mir_read_byte(U39_p) == (int) 0L) { mir_label = 700; break; }
case 704:
  u_266 = (int) u0_flags & (int) 1024L;
  I_267 = (((long) u_266) & 0xFFFFFFFFL);
  if (((long) I_267 == 0)) { mir_label = 702; break; }
case 705:
  u_268 = u0_precision;
  u_269 = u0_precision;
  u_269 = (int) u_269 - (int) 1L;
  u0_precision = u_269;
  I_270 = (((long) u_268) & 0xFFFFFFFFL);
  if (((long) I_270 != 0)) { mir_label = 702; break; }
case 700:
  u_271 = (int) u0_flags & (int) 2L;
  I_272 = (((long) u_271) & 0xFFFFFFFFL);
  if (((long) I_272 == 0)) { mir_label = 706; break; }
case 707:
case 708:
  u_273 = u39_l;
  u_274 = u39_l;
  u_274 = (int) u_274 + (int) 1L;
  u39_l = u_274;
  if (Integer.compareUnsigned((int) u_273, (int) u0_width) >= 0) { mir_label = 709; break; }
case 710:
  U_276 = U0_idx;
  U_277 = U0_idx;
  U_277 = (long) U_277 + (long) 1L;
  U0_idx = U_277;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) 32L, (long) U0_buffer, (long) U_276, (long) U0_maxlen);
  u_278 = u39_l;
  u_279 = u39_l;
  u_279 = (int) u_279 + (int) 1L;
  u39_l = u_279;
  if (Integer.compareUnsigned((int) u_278, (int) u0_width) < 0) { mir_label = 710; break; }
case 709:
  mir_label = 711; break;
case 706:
case 711:
  U_281 = mir_read_ulong(fp);
  U_281 = (long) U_281 + (long) 1L;
  mir_write_ulong(fp, U_281);
  mir_label = 674; break;
case 614:
  u0_width = 16L;
  u_282 = u0_flags;
  u_282 = (int) u_282 | (int) 33L;
  u0_flags = u_282;
  I_284 = (((long) (int) 0L) & 0xFFL);
  u46_is_ll = I_284;
  I_285 = (((long) u46_is_ll) & 0xFFFFFFFFL);
  if (((long) I_285 == 0)) { mir_label = 712; break; }
case 713:
  { // va_arg(long)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_288 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_ulong(I_288, (long) arg_value);
  } // end of va_arg
  U_289 = mir_read_ulong(I_288);
  u_290 = U_289;
  U_291 = (((long) u_290) & 0xFFFFFFFFL);
  U_286 = m1__ntoa_long_long((long) U0_stream, (long) U0_out, (long) U0_buffer, (long) U0_idx, (long) U0_maxlen, (long) U_291, (short) 0L, (long) 16L, (long) u0_precision, (long) u0_width, (long) u0_flags);
  U0_idx = U_286;
  mir_label = 714; break;
case 712:
  { // va_arg(long)
  VarArgs varArgs = mir_va_get_wrapper(U0_va);
  I_294 = varArgs.getArgDataAddr();
  long arg_value = varArgs.nextLong();
  mir_write_ulong(I_294, (long) arg_value);
  } // end of va_arg
  U_295 = mir_read_ulong(I_294);
  u_296 = U_295;
  U_297 = (((long) u_296) & 0xFFFFFFFFL);
  U_292 = m1__ntoa_long((long) U0_stream, (long) U0_out, (long) U0_buffer, (long) U0_idx, (long) U0_maxlen, (long) U_297, (short) 0L, (long) 16L, (long) u0_precision, (long) u0_width, (long) u0_flags);
  U0_idx = U_292;
case 714:
  U_298 = mir_read_ulong(fp);
  U_298 = (long) U_298 + (long) 1L;
  mir_write_ulong(fp, U_298);
  mir_label = 674; break;
case 615:
  U_299 = U0_idx;
  U_300 = U0_idx;
  U_300 = (long) U_300 + (long) 1L;
  U0_idx = U_300;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) 37L, (long) U0_buffer, (long) U_299, (long) U0_maxlen);
  U_301 = mir_read_ulong(fp);
  U_301 = (long) U_301 + (long) 1L;
  mir_write_ulong(fp, U_301);
  mir_label = 674; break;
case 616:
  I_302 = mir_read_ulong(fp);
  U_303 = U0_idx;
  U_304 = U0_idx;
  U_304 = (long) U_304 + (long) 1L;
  U0_idx = U_304;
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) mir_read_byte(I_302), (long) U0_buffer, (long) U_303, (long) U0_maxlen);
  U_305 = mir_read_ulong(fp);
  U_305 = (long) U_305 + (long) 1L;
  mir_write_ulong(fp, U_305);
case 674:
  I_306 = mir_read_ulong(fp);
  if (((long) mir_read_byte(I_306) != 0)) { mir_label = 562; break; }
case 561:
  if (Long.compareUnsigned((long) U0_idx, (long) U0_maxlen) >= 0) { mir_label = 715; break; }
case 716:
  U_308 = U0_idx;
  mir_label = 717; break;
case 715:
  U_309 = (long) U0_maxlen - (long) 1L;
  U_308 = U_309;
case 717:
  mir_call_function_ret_void(U0_out, (long) U0_stream, (byte) 0L, (long) U0_buffer, (long) U_308, (long) U0_maxlen);
  i_310 = U0_idx;
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i_310;
} // End of switch
} // End of while
} // End of function _vsnprintf

public int printf (long _U0_format, Object... mir_var_args) {
  long U0_format = _U0_format;
  long fp = 0;
  long I_0 = 0;
  long i0_ret = 0;
  long i_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(48L);
  I_0 = (long) fp + (long) 16L;
  mir_va_start(I_0, mir_var_args);
  I_2 = stdout;
  I_3 = (long) fp + (long) 16L;
  i_1 = m1__vsnprintf((long) mir_read_ulong(I_2), (long) mir_get_function_ptr("m1__out_char"), (long) fp, (long) -1L, (long) U0_format, (long) I_3);
  i0_ret = i_1;
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_ret;
} // End of function printf

public int sprintf (long _U0_buffer, long _U0_format, Object... mir_var_args) {
  long U0_buffer = _U0_buffer;
  long U0_format = _U0_format;
  long fp = 0;
  long i0_ret = 0;
  long i_0 = 0;
  long I_1 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(32L);
  mir_va_start(fp, mir_var_args);
  I_1 = stdout;
  i_0 = m1__vsnprintf((long) mir_read_ulong(I_1), (long) mir_get_function_ptr("m1__out_buffer"), (long) U0_buffer, (long) -1L, (long) U0_format, (long) fp);
  i0_ret = i_0;
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_ret;
} // End of function sprintf

public int snprintf (long _U0_buffer, long _U0_count, long _U0_format, Object... mir_var_args) {
  long U0_buffer = _U0_buffer;
  long U0_count = _U0_count;
  long U0_format = _U0_format;
  long fp = 0;
  long i0_ret = 0;
  long i_0 = 0;
  long I_1 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(32L);
  mir_va_start(fp, mir_var_args);
  I_1 = stdout;
  i_0 = m1__vsnprintf((long) mir_read_ulong(I_1), (long) mir_get_function_ptr("m1__out_buffer"), (long) U0_buffer, (long) U0_count, (long) U0_format, (long) fp);
  i0_ret = i_0;
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_ret;
} // End of function snprintf

public int vsprintf (long _U0_s, long _U0_format, long _U0_arg) {
  long U0_s = _U0_s;
  long U0_format = _U0_format;
  long U0_arg = _U0_arg;
  long i_0 = 0;
  i_0 = vsnprintf((long) U0_s, (long) 4294967295L, (long) U0_format, (long) U0_arg);
  return (int) i_0;
} // End of function vsprintf

public int vsnprintf (long _U0_buffer, long _U0_count, long _U0_format, long _U0_va) {
  long U0_buffer = _U0_buffer;
  long U0_count = _U0_count;
  long U0_format = _U0_format;
  long U0_va = _U0_va;
  long i_0 = 0;
  long I_1 = 0;
  I_1 = stdout;
  i_0 = m1__vsnprintf((long) mir_read_ulong(I_1), (long) mir_get_function_ptr("m1__out_buffer"), (long) U0_buffer, (long) U0_count, (long) U0_format, (long) U0_va);
  return (int) i_0;
} // End of function vsnprintf

public int vprintf (long _U0_format, long _U0_arg) {
  long U0_format = _U0_format;
  long U0_arg = _U0_arg;
  long fp = 0;
  long i_0 = 0;
  long I_1 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(16L);
  I_1 = stdout;
  i_0 = m1__vsnprintf((long) mir_read_ulong(I_1), (long) mir_get_function_ptr("m1__out_char"), (long) fp, (long) -1L, (long) U0_format, (long) U0_arg);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i_0;
} // End of function vprintf

public int vfprintf (long _U0_stream, long _U0_format, long _U0_arg) {
  long U0_stream = _U0_stream;
  long U0_format = _U0_format;
  long U0_arg = _U0_arg;
  long fp = 0;
  long i_0 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(16L);
  i_0 = m1__vsnprintf((long) U0_stream, (long) mir_get_function_ptr("m1__out_char"), (long) fp, (long) -1L, (long) U0_format, (long) U0_arg);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i_0;
} // End of function vfprintf

public int fprintf (long _U0_stream, long _U0_format, Object... mir_var_args) {
  long U0_stream = _U0_stream;
  long U0_format = _U0_format;
  long fp = 0;
  long i0_result = 0;
  long i_0 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(32L);
  mir_va_start(fp, mir_var_args);
  i_0 = vfprintf((long) U0_stream, (long) U0_format, (long) fp);
  i0_result = i_0;
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_result;
} // End of function fprintf

public void div (long _Ret_Addr, int _i0_numer, int _i0_denom) {
  long Ret_Addr = _Ret_Addr;
  long i0_numer = _i0_numer;
  long i0_denom = _i0_denom;
  long fp = 0;
  long i_0 = 0;
  long i_1 = 0;
  long I_2 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(16L);
  i_0 = (int) i0_numer / (int) i0_denom;
  mir_write_int(fp, i_0);
  i_1 = (int) i0_numer % (int) i0_denom;
  mir_write_int(4L + fp, i_1);
  I_2 = memcpy((long) Ret_Addr, (long) fp, (long) 8L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of function div

public void ldiv (long _Ret_Addr, long I0_numer, long I0_denom) {
  long Ret_Addr = _Ret_Addr;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(16L);
  I_0 = (long) I0_numer / (long) I0_denom;
  mir_write_long(fp, I_0);
  I_1 = (long) I0_numer % (long) I0_denom;
  mir_write_long(8L + fp, I_1);
  I_2 = memcpy((long) Ret_Addr, (long) fp, (long) 16L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of function ldiv

public void lldiv (long _Ret_Addr, long I0_numer, long I0_denom) {
  long Ret_Addr = _Ret_Addr;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(16L);
  I_0 = (long) I0_numer / (long) I0_denom;
  mir_write_long(fp, I_0);
  I_1 = (long) I0_numer % (long) I0_denom;
  mir_write_long(8L + fp, I_1);
  I_2 = memcpy((long) Ret_Addr, (long) fp, (long) 16L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of function lldiv

public double atof (long _U0_nptr) {
  long U0_nptr = _U0_nptr;
  double d_0 = 0;
  d_0 = strtod((long) U0_nptr, (long) 0L);
  return (double) d_0;
} // End of function atof

public int atoi (long _U0_nptr) {
  long U0_nptr = _U0_nptr;
  long I_0 = 0;
  long i_1 = 0;
  I_0 = strtol((long) U0_nptr, (long) 0L, (int) 10L);
  i_1 = I_0;
  return (int) i_1;
} // End of function atoi

public long atol (long _U0_nptr) {
  long U0_nptr = _U0_nptr;
  long I_0 = 0;
  I_0 = strtol((long) U0_nptr, (long) 0L, (int) 10L);
  return (long) I_0;
} // End of function atol

public long atoll (long _U0_nptr) {
  long U0_nptr = _U0_nptr;
  return (long) 0L;
} // End of function atoll

public double strtod (long _U0_nptr, long _U0_endptr) {
  long U0_nptr = _U0_nptr;
  long U0_endptr = _U0_endptr;
  double d0_x = 0;
  double d0_xs = 0;
  double d0_xf = 0;
  double d0_xd = 0;
  long i_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long i_5 = 0;
  long I_6 = 0;
  long I_7 = 0;
  long i_8 = 0;
  double d_9 = 0;
  long U_10 = 0;
  long i_11 = 0;
  long U_12 = 0;
  long i_13 = 0;
  long I_14 = 0;
  long I_15 = 0;
  double d_16 = 0;
  double d_17 = 0;
  long i_18 = 0;
  double d_19 = 0;
  long I_20 = 0;
  double d_21 = 0;
  long U_22 = 0;
  double d_23 = 0;
  long i_24 = 0;
  long U_25 = 0;
  long i_26 = 0;
  long I_27 = 0;
  long I_28 = 0;
  double d_29 = 0;
  double d_30 = 0;
  long i_31 = 0;
  double d_32 = 0;
  long I_33 = 0;
  double d_34 = 0;
  double d_35 = 0;
  double d_36 = 0;
  double d_37 = 0;
  double d_38 = 0;
  double d_39 = 0;
  long U_40 = 0;
  long i_41 = 0;
  long i_42 = 0;
  long U_43 = 0;
  double d10_es = 0;
  long i_44 = 0;
  double d_45 = 0;
  long U_46 = 0;
  double d_47 = 0;
  double d_48 = 0;
  long i_49 = 0;
  long I_50 = 0;
  long I_51 = 0;
  double d_52 = 0;
  double d_53 = 0;
  long i_54 = 0;
  double d_55 = 0;
  long I_56 = 0;
  double d_57 = 0;
  long U_58 = 0;
  double d_59 = 0;
  long i_60 = 0;
  double d_61 = 0;
  double d_62 = 0;
  double d_63 = 0;
  double d_64 = 0;
  double d_65 = 0;
  double d_66 = 0;
  long i_67 = 0;
  long i_68 = 0;
  double d_69 = 0;
  double d_70 = 0;
  double d_71 = 0;
  double d_72 = 0;
  long i_73 = 0;
  long U_74 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  d0_x = 0;
  d0_xs = 1;
  d0_xf = 0;
  d0_xd = 1;
case 718:
  I_1 = (((long) (int) mir_read_byte(U0_nptr)) & 0xFFL);
  i_0 = isspace((int) I_1);
  I_2 = (long) (int) i_0;
  if (((long) I_2 == 0)) { mir_label = 719; break; }
case 720:
  U_3 = U0_nptr;
  U_3 = (long) U_3 + (long) 1L;
  U0_nptr = U_3;
  I_6 = (((long) (int) mir_read_byte(U0_nptr)) & 0xFFL);
  i_5 = isspace((int) I_6);
  I_7 = (long) (int) i_5;
  if (((long) I_7 != 0)) { mir_label = 720; break; }
case 719:
  if ((int) mir_read_byte(U0_nptr) != (int) 45L) { mir_label = 721; break; }
case 722:
  d_9 = (double) -1L;
  d0_xs = d_9;
  U_10 = U0_nptr;
  U_10 = (long) U_10 + (long) 1L;
  U0_nptr = U_10;
  mir_label = 723; break;
case 721:
  if ((int) mir_read_byte(U0_nptr) != (int) 43L) { mir_label = 724; break; }
case 725:
  U_12 = U0_nptr;
  U_12 = (long) U_12 + (long) 1L;
  U0_nptr = U_12;
  mir_label = 726; break;
case 724:
case 726:
case 723:
case 727:
  if (((long) 1L == 0)) { mir_label = 728; break; }
case 729:
  I_14 = (((long) (int) mir_read_byte(U0_nptr)) & 0xFFL);
  i_13 = isdigit((int) I_14);
  I_15 = (long) (int) i_13;
  if (((long) I_15 == 0)) { mir_label = 730; break; }
case 731:
  d_16 = (double) 10L;
  d_17 = d0_x * d_16;
  i_18 = (int) mir_read_byte(U0_nptr) - (int) 48L;
  I_20 = (long) (int) i_18;
  d_19 = (double) I_20;
  d_21 = d_17 + d_19;
  d0_x = d_21;
  U_22 = U0_nptr;
  U_22 = (long) U_22 + (long) 1L;
  U0_nptr = U_22;
  mir_label = 732; break;
case 730:
  d_23 = d0_x * d0_xs;
  d0_x = d_23;
  mir_label = 728; break;
case 732:
  if (((long) 1L != 0)) { mir_label = 729; break; }
case 728:
  if ((int) mir_read_byte(U0_nptr) != (int) 46L) { mir_label = 733; break; }
case 734:
  U_25 = U0_nptr;
  U_25 = (long) U_25 + (long) 1L;
  U0_nptr = U_25;
case 735:
  if (((long) 1L == 0)) { mir_label = 736; break; }
case 737:
  I_27 = (((long) (int) mir_read_byte(U0_nptr)) & 0xFFL);
  i_26 = isdigit((int) I_27);
  I_28 = (long) (int) i_26;
  if (((long) I_28 == 0)) { mir_label = 738; break; }
case 739:
  d_29 = (double) 10L;
  d_30 = d0_xf * d_29;
  i_31 = (int) mir_read_byte(U0_nptr) - (int) 48L;
  I_33 = (long) (int) i_31;
  d_32 = (double) I_33;
  d_34 = d_30 + d_32;
  d0_xf = d_34;
  d_35 = (double) 10L;
  d_36 = d0_xd * d_35;
  d0_xd = d_36;
  mir_label = 740; break;
case 738:
  d_37 = d0_xf / d0_xd;
  d_38 = d0_xs * d_37;
  d_39 = d0_x + d_38;
  d0_x = d_39;
  mir_label = 736; break;
case 740:
  U_40 = U0_nptr;
  U_40 = (long) U_40 + (long) 1L;
  U0_nptr = U_40;
  if (((long) 1L != 0)) { mir_label = 737; break; }
case 736:
  mir_label = 741; break;
case 733:
case 741:
  if ((int) mir_read_byte(U0_nptr) == (int) 101L) { mir_label = 742; break; }
case 743:
  if ((int) mir_read_byte(U0_nptr) != (int) 69L) { mir_label = 744; break; }
case 742:
  U_43 = U0_nptr;
  U_43 = (long) U_43 + (long) 1L;
  U0_nptr = U_43;
  d10_es = 1;
  if ((int) mir_read_byte(U0_nptr) != (int) 45L) { mir_label = 745; break; }
case 746:
  d_45 = (double) -1L;
  d10_es = d_45;
  U_46 = U0_nptr;
  U_46 = (long) U_46 + (long) 1L;
  U0_nptr = U_46;
  mir_label = 747; break;
case 745:
case 747:
  d_47 = (double) 1L;
  d0_xd = d_47;
  d_48 = (double) 0L;
  d0_xf = d_48;
case 748:
  if (((long) 1L == 0)) { mir_label = 749; break; }
case 750:
  I_50 = (((long) (int) mir_read_byte(U0_nptr)) & 0xFFL);
  i_49 = isdigit((int) I_50);
  I_51 = (long) (int) i_49;
  if (((long) I_51 == 0)) { mir_label = 751; break; }
case 752:
  d_52 = (double) 10L;
  d_53 = d0_xf * d_52;
  i_54 = (int) mir_read_byte(U0_nptr) - (int) 48L;
  I_56 = (long) (int) i_54;
  d_55 = (double) I_56;
  d_57 = d_53 + d_55;
  d0_xf = d_57;
  U_58 = U0_nptr;
  U_58 = (long) U_58 + (long) 1L;
  U0_nptr = U_58;
  mir_label = 753; break;
case 751:
case 754:
  d_59 = (double) 0L;
  if (d0_xf > d_59) { mir_label = 755; break; }
  mir_label = 756; break;
case 755:
  d_61 = (double) 10L;
  d_62 = d0_xd;
  d_62 = d_62 * d_61;
  d0_xd = d_62;
  d_64 = d0_xf;
  d_65 = (double) 1L;
  d_64 = d_64 - d_65;
  d0_xf = d_64;
  d_66 = (double) 0L;
  if (d0_xf > d_66) { mir_label = 755; break; }
case 756:
  if (d10_es < 0) { mir_label = 757; break; }
  mir_label = 758; break;
case 757:
  d_69 = d0_x;
  d_69 = d_69 / d0_xd;
  d0_x = d_69;
  mir_label = 759; break;
case 758:
  d_71 = d0_x;
  d_71 = d_71 * d0_xd;
  d0_x = d_71;
case 759:
  mir_label = 749; break;
case 753:
  if (((long) 1L != 0)) { mir_label = 750; break; }
case 749:
  mir_label = 760; break;
case 744:
case 760:
  if ((long) U0_endptr == (long) 0L) { mir_label = 761; break; }
case 762:
  U_74 = U0_nptr;
  mir_write_ulong(U0_endptr, U_74);
  mir_label = 763; break;
case 761:
case 763:
  return (double) d0_x;
} // End of switch
} // End of while
} // End of function strtod

public double strtold (long _U0_nptr, long _U0_endptr) {
  long U0_nptr = _U0_nptr;
  long U0_endptr = _U0_endptr;
  double D_0 = 0;
  D_0 = (double) 0L;
  return (double) D_0;
} // End of function strtold

public long strtol (long _U0_s, long _U0_endptr, int _i0_base) {
  long U0_s = _U0_s;
  long U0_endptr = _U0_endptr;
  long i0_base = _i0_base;
  long fp = 0;
  long I_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long U0_a = 0;
  long U0_b = 0;
  long I_7 = 0;
  long U_8 = 0;
  long i0_c = 0;
  long I_9 = 0;
  long i_10 = 0;
  long i_11 = 0;
  long I_12 = 0;
  long I_13 = 0;
  long U_14 = 0;
  long I_15 = 0;
  long I_16 = 0;
  long i_17 = 0;
  long I0_rc = 0;
  long U_18 = 0;
  long U_19 = 0;
  long u_20 = 0;
  long U_21 = 0;
  long I_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long U_25 = 0;
  long U_26 = 0;
  long U_27 = 0;
  long i_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  mir_write_int(4L + fp, i0_base);
  I_0 = (long) (byte) 43L;
  mir_write_byte(fp, I_0);
  U_2 = fp;
  U_3 = 4L;
  U_3 = (long) U_3 + (long) fp;
  U_1 = m1_strtox_prelim((long) U0_s, (long) U_2, (long) U_3);
  mir_write_ulong(8L + fp, U_1);
  if ((int) mir_read_int(4L + fp) < (int) 2L) { mir_label = 764; break; }
case 765:
  if ((int) mir_read_int(4L + fp) <= (int) 36L) { mir_label = 766; break; }
case 764:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) 0L;
  // Dead code: mir_label = 767; break;
case 766:
case 767:
  if ((int) mir_read_byte(fp) != (int) 43L) { mir_label = 768; break; }
case 769:
  U0_a = 9223372036854775807L;
  I_7 = (long) 9223372036854775807L / (long) mir_read_int(4L + fp);
  U_8 = I_7;
  U0_b = U_8;
  I_9 = (long) 9223372036854775807L % (long) mir_read_int(4L + fp);
  i_10 = I_9;
  i0_c = i_10;
  mir_label = 770; break;
case 768:
  U0_a = -9223372036854775808L;
  i_11 = - (int) mir_read_int(4L + fp);
  I_12 = (long) (int) i_11;
  I_13 = (long) -9223372036854775808L / (long) I_12;
  U_14 = I_13;
  U0_b = U_14;
  I_15 = (long) -9223372036854775808L % (long) mir_read_int(4L + fp);
  I_16 = - (long) I_15;
  i_17 = I_16;
  i0_c = i_17;
case 770:
  U_19 = 8L;
  U_19 = (long) U_19 + (long) fp;
  u_20 = mir_read_int(4L + fp);
  U_21 = fp;
  U_18 = m1_strtox_main((long) U_19, (long) u_20, (long) U0_a, (long) U0_b, (int) i0_c, (long) U_21);
  I_22 = U_18;
  I0_rc = I_22;
  if ((long) U0_endptr == (long) 0L) { mir_label = 771; break; }
case 772:
  if ((long) mir_read_ulong(8L + fp) == (long) 0L) { mir_label = 773; break; }
case 774:
  U_25 = mir_read_ulong(8L + fp);
  U_26 = U_25;
  mir_label = 775; break;
case 773:
  U_27 = U0_s;
  U_26 = U_27;
case 775:
  mir_write_ulong(U0_endptr, U_26);
  mir_label = 776; break;
case 771:
case 776:
  if ((int) mir_read_byte(fp) != (int) 43L) { mir_label = 777; break; }
case 778:
  I_29 = I0_rc;
  mir_label = 779; break;
case 777:
  I_30 = - (long) I0_rc;
  I_29 = I_30;
case 779:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) I_29;
} // End of switch
} // End of while
} // End of function strtol

public long strtoul (long _U0_s, long _U0_endptr, int _i0_base) {
  long U0_s = _U0_s;
  long U0_endptr = _U0_endptr;
  long i0_base = _i0_base;
  long fp = 0;
  long I_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long U0_rc = 0;
  long U_6 = 0;
  long U_7 = 0;
  long u_8 = 0;
  long U_9 = 0;
  long U_10 = 0;
  long U_11 = 0;
  long i_12 = 0;
  long U_13 = 0;
  long U_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long U_17 = 0;
  long U_18 = 0;
  long U_19 = 0;
  long i_20 = 0;
  long U_21 = 0;
  long U_22 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  mir_write_int(4L + fp, i0_base);
  I_0 = (long) (byte) 43L;
  mir_write_byte(fp, I_0);
  U_2 = fp;
  U_3 = 4L;
  U_3 = (long) U_3 + (long) fp;
  U_1 = m1_strtox_prelim((long) U0_s, (long) U_2, (long) U_3);
  mir_write_ulong(8L + fp, U_1);
  if ((int) mir_read_int(4L + fp) < (int) 2L) { mir_label = 780; break; }
case 781:
  if ((int) mir_read_int(4L + fp) <= (int) 36L) { mir_label = 782; break; }
case 780:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) 0L;
  // Dead code: mir_label = 783; break;
case 782:
case 783:
  U_7 = 8L;
  U_7 = (long) U_7 + (long) fp;
  u_8 = mir_read_int(4L + fp);
  U_9 = (long) Long.divideUnsigned((long) -1L, (long) mir_read_int(4L + fp));
  U_10 = U_9;
  U_11 = (long) Long.remainderUnsigned((long) -1L, (long) mir_read_int(4L + fp));
  i_12 = U_11;
  U_13 = fp;
  U_6 = m1_strtox_main((long) U_7, (long) u_8, (long) -1L, (long) U_10, (int) i_12, (long) U_13);
  U_14 = U_6;
  U0_rc = U_14;
  if ((long) U0_endptr == (long) 0L) { mir_label = 784; break; }
case 785:
  if ((long) mir_read_ulong(8L + fp) == (long) 0L) { mir_label = 786; break; }
case 787:
  U_17 = mir_read_ulong(8L + fp);
  U_18 = U_17;
  mir_label = 788; break;
case 786:
  U_19 = U0_s;
  U_18 = U_19;
case 788:
  mir_write_ulong(U0_endptr, U_18);
  mir_label = 789; break;
case 784:
case 789:
  if ((int) mir_read_byte(fp) != (int) 43L) { mir_label = 790; break; }
case 791:
  U_21 = U0_rc;
  mir_label = 792; break;
case 790:
  U_22 = - (long) U0_rc;
  U_21 = U_22;
case 792:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) U_21;
} // End of switch
} // End of while
} // End of function strtoul

public long strtoll (long _U0_s, long _U0_endptr, int _i0_base) {
  long U0_s = _U0_s;
  long U0_endptr = _U0_endptr;
  long i0_base = _i0_base;
  long fp = 0;
  long I_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long U0_a = 0;
  long U0_b = 0;
  long I_7 = 0;
  long U_8 = 0;
  long i0_c = 0;
  long I_9 = 0;
  long i_10 = 0;
  long i_11 = 0;
  long I_12 = 0;
  long I_13 = 0;
  long U_14 = 0;
  long I_15 = 0;
  long I_16 = 0;
  long i_17 = 0;
  long I0_rc = 0;
  long U_18 = 0;
  long U_19 = 0;
  long u_20 = 0;
  long U_21 = 0;
  long I_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long U_25 = 0;
  long U_26 = 0;
  long U_27 = 0;
  long i_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  mir_write_int(4L + fp, i0_base);
  I_0 = (long) (byte) 43L;
  mir_write_byte(fp, I_0);
  U_2 = fp;
  U_3 = 4L;
  U_3 = (long) U_3 + (long) fp;
  U_1 = m1_strtox_prelim((long) U0_s, (long) U_2, (long) U_3);
  mir_write_ulong(8L + fp, U_1);
  if ((int) mir_read_int(4L + fp) < (int) 2L) { mir_label = 793; break; }
case 794:
  if ((int) mir_read_int(4L + fp) <= (int) 36L) { mir_label = 795; break; }
case 793:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) 0L;
  // Dead code: mir_label = 796; break;
case 795:
case 796:
  if ((int) mir_read_byte(fp) != (int) 43L) { mir_label = 797; break; }
case 798:
  U0_a = 9223372036854775807L;
  I_7 = (long) 9223372036854775807L / (long) mir_read_int(4L + fp);
  U_8 = I_7;
  U0_b = U_8;
  I_9 = (long) 9223372036854775807L % (long) mir_read_int(4L + fp);
  i_10 = I_9;
  i0_c = i_10;
  mir_label = 799; break;
case 797:
  U0_a = -9223372036854775808L;
  i_11 = - (int) mir_read_int(4L + fp);
  I_12 = (long) (int) i_11;
  I_13 = (long) -9223372036854775808L / (long) I_12;
  U_14 = I_13;
  U0_b = U_14;
  I_15 = (long) -9223372036854775808L % (long) mir_read_int(4L + fp);
  I_16 = - (long) I_15;
  i_17 = I_16;
  i0_c = i_17;
case 799:
  U_19 = 8L;
  U_19 = (long) U_19 + (long) fp;
  u_20 = mir_read_int(4L + fp);
  U_21 = fp;
  U_18 = m1_strtox_main((long) U_19, (long) u_20, (long) U0_a, (long) U0_b, (int) i0_c, (long) U_21);
  I_22 = U_18;
  I0_rc = I_22;
  if ((long) U0_endptr == (long) 0L) { mir_label = 800; break; }
case 801:
  if ((long) mir_read_ulong(8L + fp) == (long) 0L) { mir_label = 802; break; }
case 803:
  U_25 = mir_read_ulong(8L + fp);
  U_26 = U_25;
  mir_label = 804; break;
case 802:
  U_27 = U0_s;
  U_26 = U_27;
case 804:
  mir_write_ulong(U0_endptr, U_26);
  mir_label = 805; break;
case 800:
case 805:
  if ((int) mir_read_byte(fp) != (int) 43L) { mir_label = 806; break; }
case 807:
  I_29 = I0_rc;
  mir_label = 808; break;
case 806:
  I_30 = - (long) I0_rc;
  I_29 = I_30;
case 808:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) I_29;
} // End of switch
} // End of while
} // End of function strtoll

public long strtoull (long _U0_s, long _U0_endptr, int _i0_base) {
  long U0_s = _U0_s;
  long U0_endptr = _U0_endptr;
  long i0_base = _i0_base;
  long fp = 0;
  long I_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long U0_rc = 0;
  long U_6 = 0;
  long U_7 = 0;
  long u_8 = 0;
  long U_9 = 0;
  long U_10 = 0;
  long U_11 = 0;
  long i_12 = 0;
  long U_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long U_16 = 0;
  long U_17 = 0;
  long U_18 = 0;
  long i_19 = 0;
  long U_20 = 0;
  long U_21 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  mir_write_int(4L + fp, i0_base);
  I_0 = (long) (byte) 43L;
  mir_write_byte(fp, I_0);
  U_2 = fp;
  U_3 = 4L;
  U_3 = (long) U_3 + (long) fp;
  U_1 = m1_strtox_prelim((long) U0_s, (long) U_2, (long) U_3);
  mir_write_ulong(8L + fp, U_1);
  if ((int) mir_read_int(4L + fp) < (int) 2L) { mir_label = 809; break; }
case 810:
  if ((int) mir_read_int(4L + fp) <= (int) 36L) { mir_label = 811; break; }
case 809:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) 0L;
  // Dead code: mir_label = 812; break;
case 811:
case 812:
  U_7 = 8L;
  U_7 = (long) U_7 + (long) fp;
  u_8 = mir_read_int(4L + fp);
  U_9 = (long) Long.divideUnsigned((long) -1L, (long) mir_read_int(4L + fp));
  U_10 = U_9;
  U_11 = (long) Long.remainderUnsigned((long) -1L, (long) mir_read_int(4L + fp));
  i_12 = U_11;
  U_13 = fp;
  U_6 = m1_strtox_main((long) U_7, (long) u_8, (long) -1L, (long) U_10, (int) i_12, (long) U_13);
  U0_rc = U_6;
  if ((long) U0_endptr == (long) 0L) { mir_label = 813; break; }
case 814:
  if ((long) mir_read_ulong(8L + fp) == (long) 0L) { mir_label = 815; break; }
case 816:
  U_16 = mir_read_ulong(8L + fp);
  U_17 = U_16;
  mir_label = 817; break;
case 815:
  U_18 = U0_s;
  U_17 = U_18;
case 817:
  mir_write_ulong(U0_endptr, U_17);
  mir_label = 818; break;
case 813:
case 818:
  if ((int) mir_read_byte(fp) != (int) 43L) { mir_label = 819; break; }
case 820:
  U_20 = U0_rc;
  mir_label = 821; break;
case 819:
  U_21 = - (long) U0_rc;
  U_20 = U_21;
case 821:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) U_20;
} // End of switch
} // End of while
} // End of function strtoull

long m1_myseed = mir_set_data_ulong(0x1L);
public int rand () {
  long I_0 = 0;
  long I_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long i0_ret = 0;
  long I_4 = 0;
  long U_5 = 0;
  long U_6 = 0;
  long i_7 = 0;
  I_0 = m1_myseed;
  I_1 = m1_myseed;
  U_2 = (long) mir_read_ulong(I_1) * (long) 1103515245L;
  U_3 = (long) U_2 + (long) 12345L;
  mir_write_ulong(I_0, U_3);
  I_4 = m1_myseed;
  U_5 = (long) mir_read_ulong(I_4) >>> (long) 16L;
  U_6 = (long) U_5 & (long) 36863L;
  i_7 = U_6;
  i0_ret = i_7;
  return (int) i0_ret;
} // End of function rand

public void srand (long _u0_seed) {
  long u0_seed = _u0_seed;
  long I_0 = 0;
  long U_1 = 0;
  I_0 = m1_myseed;
  U_1 = (((long) u0_seed) & 0xFFFFFFFFL);
  mir_write_ulong(I_0, U_1);
  return;
} // End of function srand

public int abs (int _i0_j) {
  long i0_j = _i0_j;
  long i_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((int) i0_j >= (int) 0L) { mir_label = 822; break; }
case 823:
  i_1 = - (int) i0_j;
  i_2 = i_1;
  mir_label = 824; break;
case 822:
  i_2 = i0_j;
case 824:
  return (int) i_2;
} // End of switch
} // End of while
} // End of function abs

public long labs (long I0_j) {
  long i_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((long) I0_j >= (long) 0L) { mir_label = 825; break; }
case 826:
  I_1 = - (long) I0_j;
  I_2 = I_1;
  mir_label = 827; break;
case 825:
  I_2 = I0_j;
case 827:
  return (long) I_2;
} // End of switch
} // End of while
} // End of function labs

public long llabs (long I0_j) {
  long i_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((long) I0_j >= (long) 0L) { mir_label = 828; break; }
case 829:
  I_1 = - (long) I0_j;
  I_2 = I_1;
  mir_label = 830; break;
case 828:
  I_2 = I0_j;
case 830:
  return (long) I_2;
} // End of switch
} // End of while
} // End of function llabs

public int mblen (long _U0_s, long _U0_n) {
  long U0_s = _U0_s;
  long U0_n = _U0_n;
  long i_0 = 0;
  long i_1 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((long) U0_s != (long) 0L) { mir_label = 831; break; }
case 832:
  return (int) 0L;
  // Dead code: mir_label = 833; break;
case 831:
case 833:
  if ((long) U0_n != (long) 1L) { mir_label = 834; break; }
case 835:
  return (int) 1L;
  // Dead code: mir_label = 836; break;
case 834:
  return (int) -1L;
case 836:
  return (int) 0L;
} // End of switch
} // End of while
} // End of function mblen

public int mbtowc (long _U0_pwc, long _U0_s, long _U0_n) {
  long U0_pwc = _U0_pwc;
  long U0_s = _U0_s;
  long U0_n = _U0_n;
  long i_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((long) U0_s != (long) 0L) { mir_label = 837; break; }
case 838:
  return (int) 0L;
  // Dead code: mir_label = 839; break;
case 837:
case 839:
  if ((long) U0_n != (long) 1L) { mir_label = 840; break; }
case 841:
  if ((long) U0_pwc == (long) 0L) { mir_label = 842; break; }
case 843:
  I_3 = (((long) (int) mir_read_byte(U0_s)) & 0xFFFFL);
  mir_write_ushort(U0_pwc, I_3);
  mir_label = 844; break;
case 842:
case 844:
  return (int) 1L;
  // Dead code: mir_label = 845; break;
case 840:
  return (int) -1L;
case 845:
  return (int) 0L;
} // End of switch
} // End of while
} // End of function mbtowc

public int wctomb (long _U0_s, int _u0_wchar) {
  long U0_s = _U0_s;
  long u0_wchar = _u0_wchar;
  long i_0 = 0;
  long I_1 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if ((long) U0_s == (long) 0L) { mir_label = 846; break; }
case 847:
  I_1 = (long) (byte) u0_wchar;
  mir_write_byte(U0_s, I_1);
  return (int) 1L;
  // Dead code: mir_label = 848; break;
case 846:
  return (int) 0L;
case 848:
  return (int) 0L;
} // End of switch
} // End of while
} // End of function wctomb

public long mbstowcs (long _U0_pwcs, long _U0_s, long _U0_n) {
  long U0_pwcs = _U0_pwcs;
  long U0_s = _U0_s;
  long U0_n = _U0_n;
  long U_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long i_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U_1 = U0_pwcs;
  U_0 = strncpy((long) U_1, (long) U0_s, (long) U0_n);
  U_2 = strlen((long) U0_s);
  if (Long.compareUnsigned((long) U_2, (long) U0_n) < 0) { mir_label = 849; break; }
case 850:
  return (long) U0_n;
  // Dead code: mir_label = 851; break;
case 849:
case 851:
  U_5 = U0_pwcs;
  U_4 = strlen((long) U_5);
  return (long) U_4;
} // End of switch
} // End of while
} // End of function mbstowcs

public long wcstombs (long _U0_s, long _U0_pwcs, long _U0_n) {
  long U0_s = _U0_s;
  long U0_pwcs = _U0_pwcs;
  long U0_n = _U0_n;
  long U_0 = 0;
  long U_1 = 0;
  long U_2 = 0;
  long U_3 = 0;
  long i_4 = 0;
  long U_5 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U_1 = U0_pwcs;
  U_0 = strncpy((long) U0_s, (long) U_1, (long) U0_n);
  U_3 = U0_pwcs;
  U_2 = strlen((long) U_3);
  if (Long.compareUnsigned((long) U_2, (long) U0_n) < 0) { mir_label = 852; break; }
case 853:
  return (long) U0_n;
  // Dead code: mir_label = 854; break;
case 852:
case 854:
  U_5 = strlen((long) U0_s);
  return (long) U_5;
} // End of switch
} // End of while
} // End of function wcstombs

public long bsearch (long _U0_key, long _U0_base, long _U0_nmemb, long _U0_size, long _U0_compar) {
  long U0_key = _U0_key;
  long U0_base = _U0_base;
  long U0_nmemb = _U0_nmemb;
  long U0_size = _U0_size;
  long U0_compar = _U0_compar;
  long i_0 = 0;
  long U2_try = 0;
  long U_1 = 0;
  long U2_ptr = 0;
  long U_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long U_5 = 0;
  long U_6 = 0;
  long i2_res = 0;
  long i_7 = 0;
  long i_8 = 0;
  long U_9 = 0;
  long i_10 = 0;
  long U_11 = 0;
  long U_12 = 0;
  long U_13 = 0;
  long U_14 = 0;
  long U_15 = 0;
  long U_16 = 0;
  long i_17 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
case 855:
  if (Long.compareUnsigned((long) U0_nmemb, (long) 0L) <= 0) { mir_label = 856; break; }
case 857:
  U_1 = (long) Long.divideUnsigned((long) U0_nmemb, (long) 2L);
  U2_try = U_1;
  U_2 = U0_base;
  U_3 = (long) U2_try * (long) U0_size;
  U_5 = (long) U_3 * (long) 1L;
  U_4 = (long) U_2 + (long) U_5;
  U_6 = U_4;
  U2_ptr = U_6;
  i_7 = mir_call_function_ret_long(U0_compar, (long) U2_ptr, (long) U0_key);
  i2_res = i_7;
  if ((int) i2_res != (int) 0L) { mir_label = 858; break; }
case 859:
  U_9 = U2_ptr;
  return (long) U_9;
  // Dead code: mir_label = 860; break;
case 858:
  if ((int) i2_res >= (int) 0L) { mir_label = 861; break; }
case 862:
  U_11 = (long) U0_nmemb - (long) U2_try;
  U_12 = (long) U_11 - (long) 1L;
  U0_nmemb = U_12;
  U_13 = U2_ptr;
  U_15 = (long) U0_size * (long) 1L;
  U_14 = (long) U_13 + (long) U_15;
  U_16 = U_14;
  U0_base = U_16;
  mir_label = 863; break;
case 861:
  U0_nmemb = U2_try;
case 863:
case 860:
  if (Long.compareUnsigned((long) U0_nmemb, (long) 0L) > 0) { mir_label = 857; break; }
case 856:
  return (long) 0L;
} // End of switch
} // End of while
} // End of function bsearch

public void qsort (long _U0_base, long _U0_nmemb, long _U0_size, long _U0_compar) {
  long U0_base = _U0_base;
  long U0_nmemb = _U0_nmemb;
  long U0_size = _U0_size;
  long U0_compar = _U0_compar;
  long U0_base2 = 0;
  long U_0 = 0;
  long i_1 = 0;
  long U2_a = 0;
  long U2_b = 0;
  long U_2 = 0;
  long U2_c = 0;
  long U_3 = 0;
  long U_4 = 0;
  long i_5 = 0;
  long U_6 = 0;
  long U_7 = 0;
  long U_8 = 0;
  long U_9 = 0;
  long i_10 = 0;
  long U_11 = 0;
  long i_12 = 0;
  long U_13 = 0;
  long U_14 = 0;
  long U_15 = 0;
  long U_16 = 0;
  long i_17 = 0;
  long i_18 = 0;
  long U_19 = 0;
  long U_20 = 0;
  long U_21 = 0;
  long U_22 = 0;
  long i_23 = 0;
  long U_24 = 0;
  long i_25 = 0;
  long U_26 = 0;
  long U_27 = 0;
  long U_28 = 0;
  long U_29 = 0;
  long i_30 = 0;
  long i_31 = 0;
  long U5_i = 0;
  long i_32 = 0;
  long i6_tmp = 0;
  long U_33 = 0;
  long U_34 = 0;
  long I_35 = 0;
  long U_36 = 0;
  long U_37 = 0;
  long U_38 = 0;
  long U_39 = 0;
  long I_40 = 0;
  long U_41 = 0;
  long U_42 = 0;
  long I_43 = 0;
  long U_44 = 0;
  long i_45 = 0;
  long i_46 = 0;
  long i_47 = 0;
  long U_48 = 0;
  long U_49 = 0;
  long U_50 = 0;
  long U_51 = 0;
  long i_52 = 0;
  long U_53 = 0;
  long U_54 = 0;
  long U_55 = 0;
  long U_56 = 0;
  long U_57 = 0;
  long U_58 = 0;
  long i_59 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U_0 = U0_base;
  U0_base2 = U_0;
case 864:
  if (Long.compareUnsigned((long) U0_nmemb, (long) 1L) <= 0) { mir_label = 865; break; }
case 866:
  U2_a = 0L;
  U_2 = (long) U0_nmemb - (long) 1L;
  U2_b = U_2;
  U_3 = (long) U2_a + (long) U2_b;
  U_4 = (long) Long.divideUnsigned((long) U_3, (long) 2L);
  U2_c = U_4;
case 867:
case 868:
  U_6 = (long) U0_size * (long) U2_c;
  U_7 = (long) U_6 * (long) 1L;
  U_7 = (long) U_7 + (long) U0_base2;
  U_8 = (long) U0_size * (long) U2_a;
  U_9 = (long) U_8 * (long) 1L;
  U_9 = (long) U_9 + (long) U0_base2;
  i_5 = mir_call_function_ret_long(U0_compar, (long) U_7, (long) U_9);
  if ((int) i_5 <= (int) 0L) { mir_label = 869; break; }
case 870:
  U_11 = U2_a;
  U_11 = (long) U_11 + (long) 1L;
  U2_a = U_11;
  U_13 = (long) U0_size * (long) U2_c;
  U_14 = (long) U_13 * (long) 1L;
  U_14 = (long) U_14 + (long) U0_base2;
  U_15 = (long) U0_size * (long) U2_a;
  U_16 = (long) U_15 * (long) 1L;
  U_16 = (long) U_16 + (long) U0_base2;
  i_12 = mir_call_function_ret_long(U0_compar, (long) U_14, (long) U_16);
  if ((int) i_12 > (int) 0L) { mir_label = 870; break; }
case 869:
case 871:
  U_19 = (long) U0_size * (long) U2_c;
  U_20 = (long) U_19 * (long) 1L;
  U_20 = (long) U_20 + (long) U0_base2;
  U_21 = (long) U0_size * (long) U2_b;
  U_22 = (long) U_21 * (long) 1L;
  U_22 = (long) U_22 + (long) U0_base2;
  i_18 = mir_call_function_ret_long(U0_compar, (long) U_20, (long) U_22);
  if ((int) i_18 >= (int) 0L) { mir_label = 872; break; }
case 873:
  U_24 = U2_b;
  U_24 = (long) U_24 - (long) 1L;
  U2_b = U_24;
  U_26 = (long) U0_size * (long) U2_c;
  U_27 = (long) U_26 * (long) 1L;
  U_27 = (long) U_27 + (long) U0_base2;
  U_28 = (long) U0_size * (long) U2_b;
  U_29 = (long) U_28 * (long) 1L;
  U_29 = (long) U_29 + (long) U0_base2;
  i_25 = mir_call_function_ret_long(U0_compar, (long) U_27, (long) U_29);
  if ((int) i_25 < (int) 0L) { mir_label = 873; break; }
case 872:
  if (Long.compareUnsigned((long) U2_a, (long) U2_b) < 0) { mir_label = 874; break; }
case 875:
  mir_label = 876; break;
  // Dead code: mir_label = 877; break;
case 874:
case 877:
  U5_i = 0L;
  if (Long.compareUnsigned((long) U5_i, (long) U0_size) >= 0) { mir_label = 878; break; }
case 879:
  U_33 = (long) U0_size * (long) U2_a;
  U_34 = (long) U_33 + (long) U5_i;
  I_35 = (long) (byte) mir_read_byte(U0_base2 + U_34);
  i6_tmp = I_35;
  U_36 = (long) U0_size * (long) U2_a;
  U_37 = (long) U_36 + (long) U5_i;
  U_38 = (long) U0_size * (long) U2_b;
  U_39 = (long) U_38 + (long) U5_i;
  I_40 = (long) (byte) mir_read_byte(U0_base2 + U_39);
  mir_write_byte(U0_base2 + U_37, I_40);
  U_41 = (long) U0_size * (long) U2_b;
  U_42 = (long) U_41 + (long) U5_i;
  I_43 = (long) (byte) i6_tmp;
  mir_write_byte(U0_base2 + U_42, I_43);
case 880:
  U_44 = U5_i;
  U_44 = (long) U_44 + (long) 1L;
  U5_i = U_44;
  if (Long.compareUnsigned((long) U5_i, (long) U0_size) < 0) { mir_label = 879; break; }
case 878:
  if ((long) U2_c != (long) U2_a) { mir_label = 881; break; }
case 882:
  U2_c = U2_b;
  mir_label = 883; break;
case 881:
  if ((long) U2_c != (long) U2_b) { mir_label = 884; break; }
case 885:
  U2_c = U2_a;
  mir_label = 886; break;
case 884:
case 886:
case 883:
  U_48 = U2_a;
  U_48 = (long) U_48 + (long) 1L;
  U2_a = U_48;
  U_49 = U2_b;
  U_49 = (long) U_49 - (long) 1L;
  U2_b = U_49;
case 887:
  mir_label = 867; break;
case 876:
  U_50 = U2_b;
  U_50 = (long) U_50 + (long) 1L;
  U2_b = U_50;
  U_51 = (long) U0_nmemb - (long) U2_b;
  if (Long.compareUnsigned((long) U2_b, (long) U_51) >= 0) { mir_label = 888; break; }
case 889:
  qsort((long) U0_base2, (long) U2_b, (long) U0_size, (long) U0_compar);
  U_53 = (long) U0_size * (long) U2_b;
  U_54 = (long) U_53 * (long) 1L;
  U_54 = (long) U_54 + (long) U0_base2;
  U0_base2 = U_54;
  U_55 = (long) U0_nmemb - (long) U2_b;
  U0_nmemb = U_55;
  mir_label = 890; break;
case 888:
  U_56 = (long) U0_size * (long) U2_b;
  U_57 = (long) U_56 * (long) 1L;
  U_57 = (long) U_57 + (long) U0_base2;
  U_58 = (long) U0_nmemb - (long) U2_b;
  qsort((long) U_57, (long) U_58, (long) U0_size, (long) U0_compar);
  U0_nmemb = U2_b;
case 890:
  if (Long.compareUnsigned((long) U0_nmemb, (long) 1L) > 0) { mir_label = 866; break; }
case 865:
  return;
} // End of switch
} // End of while
} // End of function qsort

public long clock () {
  return (long) -1L;
} // End of function clock

public double difftime (long I0_time1, long I0_time0) {
  long I_0 = 0;
  double d_1 = 0;
  I_0 = (long) I0_time1 - (long) I0_time0;
  d_1 = (double) I_0;
  return (double) d_1;
} // End of function difftime

public long mktime (long _U0_timeptr) {
  long U0_timeptr = _U0_timeptr;
  return (long) 0L;
} // End of function mktime

public long time (long _U0_timer) {
  long U0_timer = _U0_timer;
  return (long) 0L;
} // End of function time

long m1_l_time = mir_allocate(36);
public long gmtime (long _U0_timer) {
  long U0_timer = _U0_timer;
  long I_0 = 0;
  long U_1 = 0;
  I_0 = m1_l_time;
  U_1 = I_0;
  return (long) U_1;
} // End of function gmtime

public long gmtime_s (long _U0_timer, long _U0_result) {
  long U0_timer = _U0_timer;
  long U0_result = _U0_result;
  return (long) 0L;
} // End of function gmtime_s

public long localtime (long _U0_timer) {
  long U0_timer = _U0_timer;
  long I_0 = 0;
  long U_1 = 0;
  I_0 = m1_l_time;
  U_1 = I_0;
  return (long) U_1;
} // End of function localtime

public long localtime_s (long _U0_timer, long _U0_result) {
  long U0_timer = _U0_timer;
  long U0_result = _U0_result;
  return (long) 0L;
} // End of function localtime_s

long m1_l_timeString = mir_allocate(64);
public long asctime (long _U0_timeptr) {
  long U0_timeptr = _U0_timeptr;
  long I_0 = 0;
  long i_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  I_0 = m1_l_timeString;
  i_1 = 0L;
  I_2 = (long) (byte) 0L;
  mir_write_byte(I_0 + i_1, I_2);
  I_3 = m1_l_timeString;
  return (long) I_3;
} // End of function asctime

public int asctime_s (long _U0_s, long _U0_maxsize, long _U0_timeptr) {
  long U0_s = _U0_s;
  long U0_maxsize = _U0_maxsize;
  long U0_timeptr = _U0_timeptr;
  long i_0 = 0;
  long I_1 = 0;
  i_0 = 0L;
  I_1 = (long) (byte) 0L;
  mir_write_byte(U0_s + i_0, I_1);
  return (int) -1L;
} // End of function asctime_s

public long ctime (long _U0_timer) {
  long U0_timer = _U0_timer;
  long I_0 = 0;
  long i_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  I_0 = m1_l_timeString;
  i_1 = 0L;
  I_2 = (long) (byte) 0L;
  mir_write_byte(I_0 + i_1, I_2);
  I_3 = m1_l_timeString;
  return (long) I_3;
} // End of function ctime

public int ctime_s (long _U0_s, long _U0_maxsize, long _U0_timer) {
  long U0_s = _U0_s;
  long U0_maxsize = _U0_maxsize;
  long U0_timer = _U0_timer;
  long i_0 = 0;
  long I_1 = 0;
  i_0 = 0L;
  I_1 = (long) (byte) 0L;
  mir_write_byte(U0_s + i_0, I_1);
  return (int) -1L;
} // End of function ctime_s

public long strftime (long _U0_s, long _U0_maxsize, long _U0_format, long _U0_timeptr) {
  long U0_s = _U0_s;
  long U0_maxsize = _U0_maxsize;
  long U0_format = _U0_format;
  long U0_timeptr = _U0_timeptr;
  long i_0 = 0;
  long I_1 = 0;
  i_0 = 0L;
  I_1 = (long) (byte) 0L;
  mir_write_byte(U0_s + i_0, I_1);
  return (long) 0L;
} // End of function strftime

public int timespec_get (long _U0_ts, int _i0_base) {
  long U0_ts = _U0_ts;
  long i0_base = _i0_base;
  return (int) 0L;
} // End of function timespec_get

public int clock_gettime (int _i0_clk, long _U0_ts) {
  long i0_clk = _i0_clk;
  long U0_ts = _U0_ts;
  long i0_r = 0;
  long i_0 = 0;
  i_0 = mir_sysclock_gettime((int) i0_clk, (long) U0_ts);
  i0_r = i_0;
  return (int) i0_r;
} // End of function clock_gettime

public int nanosleep (long _U0_req, long _U0_rem) {
  long U0_req = _U0_req;
  long U0_rem = _U0_rem;
  return (int) 0L;
} // End of function nanosleep

public long inet_ntoa (long _I0_in) {
  long I0_in = _I0_in;
  long fp = 0;
  long I_0 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  I_0 = 4L;
case 891:
  I_0 = (long) I_0 - (long) 1L;
  mir_write_byte(fp + I_0, mir_read_byte(I0_in + I_0));
  if ((long) I_0 > (long) 0L) { mir_label = 891; break; }
  mir_set_stack_position(mir_saved_stack_position);
  return (long) mir_get_string_ptr("127.0.0.1");
} // End of switch
} // End of while
} // End of function inet_ntoa

public long inet_addr (long _U0_cp) {
  long U0_cp = _U0_cp;
  return (long) 4294967295L;
} // End of function inet_addr

long m2_guiIcons = mir_set_data_uint(0L);
long unused_data_addr_24 = mir_set_data_uint(0L);
long unused_data_addr_25 = mir_set_data_uint(0L);
long unused_data_addr_26 = mir_set_data_uint(0L);
long unused_data_addr_27 = mir_set_data_uint(0L);
long unused_data_addr_28 = mir_set_data_uint(0L);
long unused_data_addr_29 = mir_set_data_uint(0L);
long unused_data_addr_30 = mir_set_data_uint(0L);
long unused_data_addr_31 = mir_set_data_uint(1073217536L);
long unused_data_addr_32 = mir_set_data_uint(789061640L);
long unused_data_addr_33 = mir_set_data_uint(541204606L);
long unused_data_addr_34 = mir_set_data_uint(1073905602L);
long unused_data_addr_35 = mir_set_data_uint(1073889282L);
long unused_data_addr_36 = mir_set_data_uint(1073889282L);
long unused_data_addr_37 = mir_set_data_uint(1073889282L);
long unused_data_addr_38 = mir_set_data_uint(32766L);
long unused_data_addr_39 = mir_set_data_uint(1073610752L);
long unused_data_addr_40 = mir_set_data_uint(1143104546L);
long unused_data_addr_41 = mir_set_data_uint(1073891298L);
long unused_data_addr_42 = mir_set_data_uint(1610235906L);
long unused_data_addr_43 = mir_set_data_uint(1474973706L);
long unused_data_addr_44 = mir_set_data_uint(1342853130L);
long unused_data_addr_45 = mir_set_data_uint(1073897466L);
long unused_data_addr_46 = mir_set_data_uint(32766L);
long unused_data_addr_47 = mir_set_data_uint(0L);
long unused_data_addr_48 = mir_set_data_uint(4325502L);
long unused_data_addr_49 = mir_set_data_uint(1073905602L);
long unused_data_addr_50 = mir_set_data_uint(1073889282L);
long unused_data_addr_51 = mir_set_data_uint(1090666498L);
long unused_data_addr_52 = mir_set_data_uint(1145193090L);
long unused_data_addr_53 = mir_set_data_uint(2034123010L);
long unused_data_addr_54 = mir_set_data_uint(256L);
long unused_data_addr_55 = mir_set_data_uint(0L);
long unused_data_addr_56 = mir_set_data_uint(4325502L);
long unused_data_addr_57 = mir_set_data_uint(1073905602L);
long unused_data_addr_58 = mir_set_data_uint(1073889282L);
long unused_data_addr_59 = mir_set_data_uint(1090666754L);
long unused_data_addr_60 = mir_set_data_uint(1145192706L);
long unused_data_addr_61 = mir_set_data_uint(2034123394L);
long unused_data_addr_62 = mir_set_data_uint(0L);
long unused_data_addr_63 = mir_set_data_uint(1072693248L);
long unused_data_addr_64 = mir_set_data_uint(538714128L);
long unused_data_addr_65 = mir_set_data_uint(537141252L);
long unused_data_addr_66 = mir_set_data_uint(553918468L);
long unused_data_addr_67 = mir_set_data_uint(608445060L);
long unused_data_addr_68 = mir_set_data_uint(553918724L);
long unused_data_addr_69 = mir_set_data_uint(537141508L);
long unused_data_addr_70 = mir_set_data_uint(16380L);
long unused_data_addr_71 = mir_set_data_uint(1072693248L);
long unused_data_addr_72 = mir_set_data_uint(538714128L);
long unused_data_addr_73 = mir_set_data_uint(537141252L);
long unused_data_addr_74 = mir_set_data_uint(553918468L);
long unused_data_addr_75 = mir_set_data_uint(553918724L);
long unused_data_addr_76 = mir_set_data_uint(579085380L);
long unused_data_addr_77 = mir_set_data_uint(537141508L);
long unused_data_addr_78 = mir_set_data_uint(16380L);
long unused_data_addr_79 = mir_set_data_uint(1072693248L);
long unused_data_addr_80 = mir_set_data_uint(538714128L);
long unused_data_addr_81 = mir_set_data_uint(270340L);
long unused_data_addr_82 = mir_set_data_uint(537137156L);
long unused_data_addr_83 = mir_set_data_uint(545539972L);
long unused_data_addr_84 = mir_set_data_uint(8655748L);
long unused_data_addr_85 = mir_set_data_uint(537143172L);
long unused_data_addr_86 = mir_set_data_uint(16380L);
long unused_data_addr_87 = mir_set_data_uint(1072693248L);
long unused_data_addr_88 = mir_set_data_uint(538714128L);
long unused_data_addr_89 = mir_set_data_uint(537141252L);
long unused_data_addr_90 = mir_set_data_uint(537141252L);
long unused_data_addr_91 = mir_set_data_uint(570696196L);
long unused_data_addr_92 = mir_set_data_uint(570699652L);
long unused_data_addr_93 = mir_set_data_uint(537141764L);
long unused_data_addr_94 = mir_set_data_uint(16380L);
long unused_data_addr_95 = mir_set_data_uint(1072693248L);
long unused_data_addr_96 = mir_set_data_uint(538714128L);
long unused_data_addr_97 = mir_set_data_uint(537141252L);
long unused_data_addr_98 = mir_set_data_uint(537141252L);
long unused_data_addr_99 = mir_set_data_uint(621029508L);
long unused_data_addr_100 = mir_set_data_uint(621027844L);
long unused_data_addr_101 = mir_set_data_uint(537143428L);
long unused_data_addr_102 = mir_set_data_uint(16380L);
long unused_data_addr_103 = mir_set_data_uint(1072693248L);
long unused_data_addr_104 = mir_set_data_uint(538714128L);
long unused_data_addr_105 = mir_set_data_uint(537141252L);
long unused_data_addr_106 = mir_set_data_uint(537145332L);
long unused_data_addr_107 = mir_set_data_uint(537145332L);
long unused_data_addr_108 = mir_set_data_uint(537145332L);
long unused_data_addr_109 = mir_set_data_uint(537141252L);
long unused_data_addr_110 = mir_set_data_uint(16380L);
long unused_data_addr_111 = mir_set_data_uint(1072693248L);
long unused_data_addr_112 = mir_set_data_uint(538714128L);
long unused_data_addr_113 = mir_set_data_uint(654581764L);
long unused_data_addr_114 = mir_set_data_uint(608445636L);
long unused_data_addr_115 = mir_set_data_uint(641999940L);
long unused_data_addr_116 = mir_set_data_uint(543434340L);
long unused_data_addr_117 = mir_set_data_uint(537141252L);
long unused_data_addr_118 = mir_set_data_uint(16380L);
long unused_data_addr_119 = mir_set_data_uint(1072693248L);
long unused_data_addr_120 = mir_set_data_uint(538714128L);
long unused_data_addr_121 = mir_set_data_uint(637806084L);
long unused_data_addr_122 = mir_set_data_uint(537141252L);
long unused_data_addr_123 = mir_set_data_uint(893659268L);
long unused_data_addr_124 = mir_set_data_uint(605299244L);
long unused_data_addr_125 = mir_set_data_uint(537141252L);
long unused_data_addr_126 = mir_set_data_uint(16380L);
long unused_data_addr_127 = mir_set_data_uint(1072693248L);
long unused_data_addr_128 = mir_set_data_uint(538714128L);
long unused_data_addr_129 = mir_set_data_uint(549724164L);
long unused_data_addr_130 = mir_set_data_uint(574890308L);
long unused_data_addr_131 = mir_set_data_uint(574891076L);
long unused_data_addr_132 = mir_set_data_uint(549724484L);
long unused_data_addr_133 = mir_set_data_uint(537141252L);
long unused_data_addr_134 = mir_set_data_uint(16380L);
long unused_data_addr_135 = mir_set_data_uint(1072693248L);
long unused_data_addr_136 = mir_set_data_uint(1073491952L);
long unused_data_addr_137 = mir_set_data_uint(1060909044L);
long unused_data_addr_138 = mir_set_data_uint(1035742900L);
long unused_data_addr_139 = mir_set_data_uint(1035742132L);
long unused_data_addr_140 = mir_set_data_uint(1060908724L);
long unused_data_addr_141 = mir_set_data_uint(1073491956L);
long unused_data_addr_142 = mir_set_data_uint(12276L);
long unused_data_addr_143 = mir_set_data_uint(1072693248L);
long unused_data_addr_144 = mir_set_data_uint(538714128L);
long unused_data_addr_145 = mir_set_data_uint(562307460L);
long unused_data_addr_146 = mir_set_data_uint(562307076L);
long unused_data_addr_147 = mir_set_data_uint(562307460L);
long unused_data_addr_148 = mir_set_data_uint(562307460L);
long unused_data_addr_149 = mir_set_data_uint(537141636L);
long unused_data_addr_150 = mir_set_data_uint(16380L);
long unused_data_addr_151 = mir_set_data_uint(267386880L);
long unused_data_addr_152 = mir_set_data_uint(941361168L);
long unused_data_addr_153 = mir_set_data_uint(671361028L);
long unused_data_addr_154 = mir_set_data_uint(671361028L);
long unused_data_addr_155 = mir_set_data_uint(671361028L);
long unused_data_addr_156 = mir_set_data_uint(671361028L);
long unused_data_addr_157 = mir_set_data_uint(537931772L);
long unused_data_addr_158 = mir_set_data_uint(16368L);
long unused_data_addr_159 = mir_set_data_uint(0L);
long unused_data_addr_160 = mir_set_data_uint(1880883200L);
long unused_data_addr_161 = mir_set_data_uint(127671828L);
long unused_data_addr_162 = mir_set_data_uint(1436549360L);
long unused_data_addr_163 = mir_set_data_uint(127664368L);
long unused_data_addr_164 = mir_set_data_uint(1880890900L);
long unused_data_addr_165 = mir_set_data_uint(0L);
long unused_data_addr_166 = mir_set_data_uint(0L);
long unused_data_addr_167 = mir_set_data_uint(29360128L);
long unused_data_addr_168 = mir_set_data_uint(333716460L);
long unused_data_addr_169 = mir_set_data_uint(1065619460L);
long unused_data_addr_170 = mir_set_data_uint(541335748L);
long unused_data_addr_171 = mir_set_data_uint(541335620L);
long unused_data_addr_172 = mir_set_data_uint(541335620L);
long unused_data_addr_173 = mir_set_data_uint(545005636L);
long unused_data_addr_174 = mir_set_data_uint(16320L);
long unused_data_addr_175 = mir_set_data_uint(0L);
long unused_data_addr_176 = mir_set_data_uint(983568352L);
long unused_data_addr_177 = mir_set_data_uint(716974752L);
long unused_data_addr_178 = mir_set_data_uint(715401892L);
long unused_data_addr_179 = mir_set_data_uint(537143972L);
long unused_data_addr_180 = mir_set_data_uint(537141252L);
long unused_data_addr_181 = mir_set_data_uint(1073487876L);
long unused_data_addr_182 = mir_set_data_uint(0L);
long unused_data_addr_183 = mir_set_data_uint(0L);
long unused_data_addr_184 = mir_set_data_uint(3932172L);
long unused_data_addr_185 = mir_set_data_uint(50856136L);
long unused_data_addr_186 = mir_set_data_uint(806358032L);
long unused_data_addr_187 = mir_set_data_uint(270540832L);
long unused_data_addr_188 = mir_set_data_uint(71305280L);
long unused_data_addr_189 = mir_set_data_uint(25166464L);
long unused_data_addr_190 = mir_set_data_uint(0L);
long unused_data_addr_191 = mir_set_data_uint(0L);
long unused_data_addr_192 = mir_set_data_uint(1572864L);
long unused_data_addr_193 = mir_set_data_uint(32505976L);
long unused_data_addr_194 = mir_set_data_uint(65013744L);
long unused_data_addr_195 = mir_set_data_uint(130024416L);
long unused_data_addr_196 = mir_set_data_uint(67112512L);
long unused_data_addr_197 = mir_set_data_uint(0L);
long unused_data_addr_198 = mir_set_data_uint(0L);
long unused_data_addr_199 = mir_set_data_uint(0L);
long unused_data_addr_200 = mir_set_data_uint(67108864L);
long unused_data_addr_201 = mir_set_data_uint(285215232L);
long unused_data_addr_202 = mir_set_data_uint(71305856L);
long unused_data_addr_203 = mir_set_data_uint(17826336L);
long unused_data_addr_204 = mir_set_data_uint(5767304L);
long unused_data_addr_205 = mir_set_data_uint(56L);
long unused_data_addr_206 = mir_set_data_uint(0L);
long unused_data_addr_207 = mir_set_data_uint(67108864L);
long unused_data_addr_208 = mir_set_data_uint(352324096L);
long unused_data_addr_209 = mir_set_data_uint(1346381952L);
long unused_data_addr_210 = mir_set_data_uint(336603168L);
long unused_data_addr_211 = mir_set_data_uint(84150792L);
long unused_data_addr_212 = mir_set_data_uint(22807180L);
long unused_data_addr_213 = mir_set_data_uint(8126652L);
long unused_data_addr_214 = mir_set_data_uint(0L);
long unused_data_addr_215 = mir_set_data_uint(29360128L);
long unused_data_addr_216 = mir_set_data_uint(20971840L);
long unused_data_addr_217 = mir_set_data_uint(20971840L);
long unused_data_addr_218 = mir_set_data_uint(267911488L);
long unused_data_addr_219 = mir_set_data_uint(267913224L);
long unused_data_addr_220 = mir_set_data_uint(178784264L);
long unused_data_addr_221 = mir_set_data_uint(178784936L);
long unused_data_addr_222 = mir_set_data_uint(4088L);
long unused_data_addr_223 = mir_set_data_uint(536608768L);
long unused_data_addr_224 = mir_set_data_uint(1610383358L);
long unused_data_addr_225 = mir_set_data_uint(1073758208L);
long unused_data_addr_226 = mir_set_data_uint(8421248L);
long unused_data_addr_227 = mir_set_data_uint(29360576L);
long unused_data_addr_228 = mir_set_data_uint(29360576L);
long unused_data_addr_229 = mir_set_data_uint(29360576L);
long unused_data_addr_230 = mir_set_data_uint(128L);
long unused_data_addr_231 = mir_set_data_uint(0L);
long unused_data_addr_232 = mir_set_data_uint(8388608L);
long unused_data_addr_233 = mir_set_data_uint(29360256L);
long unused_data_addr_234 = mir_set_data_uint(65012160L);
long unused_data_addr_235 = mir_set_data_uint(133170144L);
long unused_data_addr_236 = mir_set_data_uint(56624880L);
long unused_data_addr_237 = mir_set_data_uint(448L);
long unused_data_addr_238 = mir_set_data_uint(0L);
long unused_data_addr_239 = mir_set_data_uint(0L);
long unused_data_addr_240 = mir_set_data_uint(1040201728L);
long unused_data_addr_241 = mir_set_data_uint(528498560L);
long unused_data_addr_242 = mir_set_data_uint(203431488L);
long unused_data_addr_243 = mir_set_data_uint(34081808L);
long unused_data_addr_244 = mir_set_data_uint(8651012L);
long unused_data_addr_245 = mir_set_data_uint(3670084L);
long unused_data_addr_246 = mir_set_data_uint(0L);
long unused_data_addr_247 = mir_set_data_uint(0L);
long unused_data_addr_248 = mir_set_data_uint(125829888L);
long unused_data_addr_249 = mir_set_data_uint(534777792L);
long unused_data_addr_250 = mir_set_data_uint(1065893840L);
long unused_data_addr_251 = mir_set_data_uint(235020036L);
long unused_data_addr_252 = mir_set_data_uint(33817602L);
long unused_data_addr_253 = mir_set_data_uint(15728904L);
long unused_data_addr_254 = mir_set_data_uint(0L);
long unused_data_addr_255 = mir_set_data_uint(12582912L);
long unused_data_addr_256 = mir_set_data_uint(41943360L);
long unused_data_addr_257 = mir_set_data_uint(136315968L);
long unused_data_addr_258 = mir_set_data_uint(537399312L);
long unused_data_addr_259 = mir_set_data_uint(805187588L);
long unused_data_addr_260 = mir_set_data_uint(66586620L);
long unused_data_addr_261 = mir_set_data_uint(14680560L);
long unused_data_addr_262 = mir_set_data_uint(64L);
long unused_data_addr_263 = mir_set_data_uint(0L);
long unused_data_addr_264 = mir_set_data_uint(562315260L);
long unused_data_addr_265 = mir_set_data_uint(25166208L);
long unused_data_addr_266 = mir_set_data_uint(25166208L);
long unused_data_addr_267 = mir_set_data_uint(25166208L);
long unused_data_addr_268 = mir_set_data_uint(25166208L);
long unused_data_addr_269 = mir_set_data_uint(62914944L);
long unused_data_addr_270 = mir_set_data_uint(0L);
long unused_data_addr_271 = mir_set_data_uint(8388608L);
long unused_data_addr_272 = mir_set_data_uint(20971904L);
long unused_data_addr_273 = mir_set_data_uint(102761280L);
long unused_data_addr_274 = mir_set_data_uint(202376736L);
long unused_data_addr_275 = mir_set_data_uint(536349712L);
long unused_data_addr_276 = mir_set_data_uint(940316680L);
long unused_data_addr_277 = mir_set_data_uint(1879470084L);
long unused_data_addr_278 = mir_set_data_uint(63503L);
long unused_data_addr_279 = mir_set_data_uint(2013265920L);
long unused_data_addr_280 = mir_set_data_uint(1342193664L);
long unused_data_addr_281 = mir_set_data_uint(18432L);
long unused_data_addr_282 = mir_set_data_uint(62915520L);
long unused_data_addr_283 = mir_set_data_uint(62915520L);
long unused_data_addr_284 = mir_set_data_uint(1048576L);
long unused_data_addr_285 = mir_set_data_uint(131082L);
long unused_data_addr_286 = mir_set_data_uint(14L);
long unused_data_addr_287 = mir_set_data_uint(1968570368L);
long unused_data_addr_288 = mir_set_data_uint(1577074690L);
long unused_data_addr_289 = mir_set_data_uint(1409290242L);
long unused_data_addr_290 = mir_set_data_uint(1090523650L);
long unused_data_addr_291 = mir_set_data_uint(1082261758L);
long unused_data_addr_292 = mir_set_data_uint(1082261634L);
long unused_data_addr_293 = mir_set_data_uint(1082261634L);
long unused_data_addr_294 = mir_set_data_uint(27390L);
long unused_data_addr_295 = mir_set_data_uint(0L);
long unused_data_addr_296 = mir_set_data_uint(1056980736L);
long unused_data_addr_297 = mir_set_data_uint(1056980736L);
long unused_data_addr_298 = mir_set_data_uint(1056980736L);
long unused_data_addr_299 = mir_set_data_uint(4194432L);
long unused_data_addr_300 = mir_set_data_uint(1835040L);
long unused_data_addr_301 = mir_set_data_uint(1835036L);
long unused_data_addr_302 = mir_set_data_uint(0L);
long unused_data_addr_303 = mir_set_data_uint(1837105152L);
long unused_data_addr_304 = mir_set_data_uint(16512L);
long unused_data_addr_305 = mir_set_data_uint(1082146944L);
long unused_data_addr_306 = mir_set_data_uint(1082130432L);
long unused_data_addr_307 = mir_set_data_uint(4222336L);
long unused_data_addr_308 = mir_set_data_uint(1835040L);
long unused_data_addr_309 = mir_set_data_uint(1835036L);
long unused_data_addr_310 = mir_set_data_uint(0L);
long unused_data_addr_311 = mir_set_data_uint(1074266112L);
long unused_data_addr_312 = mir_set_data_uint(536748040L);
long unused_data_addr_313 = mir_set_data_uint(336072712L);
long unused_data_addr_314 = mir_set_data_uint(285741576L);
long unused_data_addr_315 = mir_set_data_uint(273158280L);
long unused_data_addr_316 = mir_set_data_uint(268963880L);
long unused_data_addr_317 = mir_set_data_uint(268730360L);
long unused_data_addr_318 = mir_set_data_uint(4098L);
long unused_data_addr_319 = mir_set_data_uint(1048576L);
long unused_data_addr_320 = mir_set_data_uint(1073479696L);
long unused_data_addr_321 = mir_set_data_uint(716191056L);
long unused_data_addr_322 = mir_set_data_uint(581969232L);
long unused_data_addr_323 = mir_set_data_uint(548413776L);
long unused_data_addr_324 = mir_set_data_uint(540024912L);
long unused_data_addr_325 = mir_set_data_uint(536936432L);
long unused_data_addr_326 = mir_set_data_uint(8192L);
long unused_data_addr_327 = mir_set_data_uint(1073741824L);
long unused_data_addr_328 = mir_set_data_uint(536354816L);
long unused_data_addr_329 = mir_set_data_uint(67643400L);
long unused_data_addr_330 = mir_set_data_uint(17310216L);
long unused_data_addr_331 = mir_set_data_uint(4726920L);
long unused_data_addr_332 = mir_set_data_uint(1581096L);
long unused_data_addr_333 = mir_set_data_uint(894705672L);
long unused_data_addr_334 = mir_set_data_uint(2L);
long unused_data_addr_335 = mir_set_data_uint(0L);
long unused_data_addr_336 = mir_set_data_uint(41943680L);
long unused_data_addr_337 = mir_set_data_uint(113247936L);
long unused_data_addr_338 = mir_set_data_uint(245370592L);
long unused_data_addr_339 = mir_set_data_uint(512761520L);
long unused_data_addr_340 = mir_set_data_uint(1049116312L);
long unused_data_addr_341 = mir_set_data_uint(2130476684L);
long unused_data_addr_342 = mir_set_data_uint(0L);
long unused_data_addr_343 = mir_set_data_uint(16777216L);
long unused_data_addr_344 = mir_set_data_uint(90177792L);
long unused_data_addr_345 = mir_set_data_uint(491261264L);
long unused_data_addr_346 = mir_set_data_uint(2101493060L);
long unused_data_addr_347 = mir_set_data_uint(1027898690L);
long unused_data_addr_348 = mir_set_data_uint(223354184L);
long unused_data_addr_349 = mir_set_data_uint(16778592L);
long unused_data_addr_350 = mir_set_data_uint(256L);
long unused_data_addr_351 = mir_set_data_uint(25165824L);
long unused_data_addr_352 = mir_set_data_uint(69206592L);
long unused_data_addr_353 = mir_set_data_uint(268961808L);
long unused_data_addr_354 = mir_set_data_uint(8184L);
long unused_data_addr_355 = mir_set_data_uint(32766L);
long unused_data_addr_356 = mir_set_data_uint(267395064L);
long unused_data_addr_357 = mir_set_data_uint(62916576L);
long unused_data_addr_358 = mir_set_data_uint(384L);
long unused_data_addr_359 = mir_set_data_uint(0L);
long unused_data_addr_360 = mir_set_data_uint(17301744L);
long unused_data_addr_361 = mir_set_data_uint(33817092L);
long unused_data_addr_362 = mir_set_data_uint(33817092L);
long unused_data_addr_363 = mir_set_data_uint(133169928L);
long unused_data_addr_364 = mir_set_data_uint(469765632L);
long unused_data_addr_365 = mir_set_data_uint(805320704L);
long unused_data_addr_366 = mir_set_data_uint(0L);
long unused_data_addr_367 = mir_set_data_uint(0L);
long unused_data_addr_368 = mir_set_data_uint(102237168L);
long unused_data_addr_369 = mir_set_data_uint(136580108L);
long unused_data_addr_370 = mir_set_data_uint(134481940L);
long unused_data_addr_371 = mir_set_data_uint(202115076L);
long unused_data_addr_372 = mir_set_data_uint(602936856L);
long unused_data_addr_373 = mir_set_data_uint(402662400L);
long unused_data_addr_374 = mir_set_data_uint(0L);
long unused_data_addr_375 = mir_set_data_uint(0L);
long unused_data_addr_376 = mir_set_data_uint(0L);
long unused_data_addr_377 = mir_set_data_uint(477104064L);
long unused_data_addr_378 = mir_set_data_uint(1670263704L);
long unused_data_addr_379 = mir_set_data_uint(477115288L);
long unused_data_addr_380 = mir_set_data_uint(1984L);
long unused_data_addr_381 = mir_set_data_uint(0L);
long unused_data_addr_382 = mir_set_data_uint(0L);
long unused_data_addr_383 = mir_set_data_uint(0L);
long unused_data_addr_384 = mir_set_data_uint(268443648L);
long unused_data_addr_385 = mir_set_data_uint(74452928L);
long unused_data_addr_386 = mir_set_data_uint(1628320280L);
long unused_data_addr_387 = mir_set_data_uint(477114520L);
long unused_data_addr_388 = mir_set_data_uint(1050528L);
long unused_data_addr_389 = mir_set_data_uint(8L);
long unused_data_addr_390 = mir_set_data_uint(0L);
long unused_data_addr_391 = mir_set_data_uint(0L);
long unused_data_addr_392 = mir_set_data_uint(32764L);
long unused_data_addr_393 = mir_set_data_uint(1074036732L);
long unused_data_addr_394 = mir_set_data_uint(269492232L);
long unused_data_addr_395 = mir_set_data_uint(71305248L);
long unused_data_addr_396 = mir_set_data_uint(41943680L);
long unused_data_addr_397 = mir_set_data_uint(41943680L);
long unused_data_addr_398 = mir_set_data_uint(256L);
long unused_data_addr_399 = mir_set_data_uint(0L);
long unused_data_addr_400 = mir_set_data_uint(1073905662L);
long unused_data_addr_401 = mir_set_data_uint(268967940L);
long unused_data_addr_402 = mir_set_data_uint(69208080L);
long unused_data_addr_403 = mir_set_data_uint(37749312L);
long unused_data_addr_404 = mir_set_data_uint(37749312L);
long unused_data_addr_405 = mir_set_data_uint(20972096L);
long unused_data_addr_406 = mir_set_data_uint(192L);
long unused_data_addr_407 = mir_set_data_uint(8388608L);
long unused_data_addr_408 = mir_set_data_uint(8388736L);
long unused_data_addr_409 = mir_set_data_uint(128L);
long unused_data_addr_410 = mir_set_data_uint(1016987648L);
long unused_data_addr_411 = mir_set_data_uint(0L);
long unused_data_addr_412 = mir_set_data_uint(8388736L);
long unused_data_addr_413 = mir_set_data_uint(8388736L);
long unused_data_addr_414 = mir_set_data_uint(0L);
long unused_data_addr_415 = mir_set_data_uint(8388608L);
long unused_data_addr_416 = mir_set_data_uint(8388736L);
long unused_data_addr_417 = mir_set_data_uint(8388736L);
long unused_data_addr_418 = mir_set_data_uint(1065222592L);
long unused_data_addr_419 = mir_set_data_uint(8389056L);
long unused_data_addr_420 = mir_set_data_uint(8388736L);
long unused_data_addr_421 = mir_set_data_uint(8388736L);
long unused_data_addr_422 = mir_set_data_uint(0L);
long unused_data_addr_423 = mir_set_data_uint(8388608L);
long unused_data_addr_424 = mir_set_data_uint(8388736L);
long unused_data_addr_425 = mir_set_data_uint(65011840L);
long unused_data_addr_426 = mir_set_data_uint(1044251168L);
long unused_data_addr_427 = mir_set_data_uint(65012256L);
long unused_data_addr_428 = mir_set_data_uint(8388736L);
long unused_data_addr_429 = mir_set_data_uint(8388736L);
long unused_data_addr_430 = mir_set_data_uint(0L);
long unused_data_addr_431 = mir_set_data_uint(16777216L);
long unused_data_addr_432 = mir_set_data_uint(71303808L);
long unused_data_addr_433 = mir_set_data_uint(16777472L);
long unused_data_addr_434 = mir_set_data_uint(1132732424L);
long unused_data_addr_435 = mir_set_data_uint(1132763826L);
long unused_data_addr_436 = mir_set_data_uint(16785416L);
long unused_data_addr_437 = mir_set_data_uint(71303424L);
long unused_data_addr_438 = mir_set_data_uint(16777856L);
long unused_data_addr_439 = mir_set_data_uint(16777216L);
long unused_data_addr_440 = mir_set_data_uint(71303808L);
long unused_data_addr_441 = mir_set_data_uint(16777472L);
long unused_data_addr_442 = mir_set_data_uint(1090789640L);
long unused_data_addr_443 = mir_set_data_uint(1090822130L);
long unused_data_addr_444 = mir_set_data_uint(16785672L);
long unused_data_addr_445 = mir_set_data_uint(71303424L);
long unused_data_addr_446 = mir_set_data_uint(16777856L);
long unused_data_addr_447 = mir_set_data_uint(2015232000L);
long unused_data_addr_448 = mir_set_data_uint(1342849026L);
long unused_data_addr_449 = mir_set_data_uint(69224466L);
long unused_data_addr_450 = mir_set_data_uint(576L);
long unused_data_addr_451 = mir_set_data_uint(37748736L);
long unused_data_addr_452 = mir_set_data_uint(1209140256L);
long unused_data_addr_453 = mir_set_data_uint(1073893386L);
long unused_data_addr_454 = mir_set_data_uint(30750L);
long unused_data_addr_455 = mir_set_data_uint(0L);
long unused_data_addr_456 = mir_set_data_uint(536886272L);
long unused_data_addr_457 = mir_set_data_uint(603990016L);
long unused_data_addr_458 = mir_set_data_uint(16777728L);
long unused_data_addr_459 = mir_set_data_uint(4194432L);
long unused_data_addr_460 = mir_set_data_uint(1310756L);
long unused_data_addr_461 = mir_set_data_uint(3932164L);
long unused_data_addr_462 = mir_set_data_uint(0L);
long unused_data_addr_463 = mir_set_data_uint(0L);
long unused_data_addr_464 = mir_set_data_uint(262204L);
long unused_data_addr_465 = mir_set_data_uint(2359316L);
long unused_data_addr_466 = mir_set_data_uint(8388672L);
long unused_data_addr_467 = mir_set_data_uint(33554688L);
long unused_data_addr_468 = mir_set_data_uint(671097856L);
long unused_data_addr_469 = mir_set_data_uint(1006641152L);
long unused_data_addr_470 = mir_set_data_uint(0L);
long unused_data_addr_471 = mir_set_data_uint(0L);
long unused_data_addr_472 = mir_set_data_uint(1048608L);
long unused_data_addr_473 = mir_set_data_uint(269492168L);
long unused_data_addr_474 = mir_set_data_uint(268439584L);
long unused_data_addr_475 = mir_set_data_uint(268439552L);
long unused_data_addr_476 = mir_set_data_uint(268439552L);
long unused_data_addr_477 = mir_set_data_uint(8128L);
long unused_data_addr_478 = mir_set_data_uint(0L);
long unused_data_addr_479 = mir_set_data_uint(0L);
long unused_data_addr_480 = mir_set_data_uint(134218752L);
long unused_data_addr_481 = mir_set_data_uint(134747128L);
long unused_data_addr_482 = mir_set_data_uint(525320L);
long unused_data_addr_483 = mir_set_data_uint(524296L);
long unused_data_addr_484 = mir_set_data_uint(524296L);
long unused_data_addr_485 = mir_set_data_uint(1016L);
long unused_data_addr_486 = mir_set_data_uint(0L);
long unused_data_addr_487 = mir_set_data_uint(0L);
long unused_data_addr_488 = mir_set_data_uint(1073479680L);
long unused_data_addr_489 = mir_set_data_uint(537141252L);
long unused_data_addr_490 = mir_set_data_uint(536879104L);
long unused_data_addr_491 = mir_set_data_uint(541073408L);
long unused_data_addr_492 = mir_set_data_uint(1066410016L);
long unused_data_addr_493 = mir_set_data_uint(4194336L);
long unused_data_addr_494 = mir_set_data_uint(0L);
long unused_data_addr_495 = mir_set_data_uint(0L);
long unused_data_addr_496 = mir_set_data_uint(1073479680L);
long unused_data_addr_497 = mir_set_data_uint(537141252L);
long unused_data_addr_498 = mir_set_data_uint(670834692L);
long unused_data_addr_499 = mir_set_data_uint(538976256L);
long unused_data_addr_500 = mir_set_data_uint(1070080016L);
long unused_data_addr_501 = mir_set_data_uint(2097168L);
long unused_data_addr_502 = mir_set_data_uint(0L);
long unused_data_addr_503 = mir_set_data_uint(0L);
long unused_data_addr_504 = mir_set_data_uint(267386880L);
long unused_data_addr_505 = mir_set_data_uint(268965912L);
long unused_data_addr_506 = mir_set_data_uint(293605384L);
long unused_data_addr_507 = mir_set_data_uint(268439936L);
long unused_data_addr_508 = mir_set_data_uint(403705888L);
long unused_data_addr_509 = mir_set_data_uint(1052616L);
long unused_data_addr_510 = mir_set_data_uint(32L);
long unused_data_addr_511 = mir_set_data_uint(0L);
long unused_data_addr_512 = mir_set_data_uint(67109376L);
long unused_data_addr_513 = mir_set_data_uint(604252668L);
long unused_data_addr_514 = mir_set_data_uint(537141764L);
long unused_data_addr_515 = mir_set_data_uint(541335556L);
long unused_data_addr_516 = mir_set_data_uint(1066672164L);
long unused_data_addr_517 = mir_set_data_uint(4194336L);
long unused_data_addr_518 = mir_set_data_uint(0L);
long unused_data_addr_519 = mir_set_data_uint(0L);
long unused_data_addr_520 = mir_set_data_uint(536875008L);
long unused_data_addr_521 = mir_set_data_uint(571493390L);
long unused_data_addr_522 = mir_set_data_uint(8392992L);
long unused_data_addr_523 = mir_set_data_uint(287309888L);
long unused_data_addr_524 = mir_set_data_uint(1275994640L);
long unused_data_addr_525 = mir_set_data_uint(268443648L);
long unused_data_addr_526 = mir_set_data_uint(0L);
long unused_data_addr_527 = mir_set_data_uint(2147352576L);
long unused_data_addr_528 = mir_set_data_uint(1342324738L);
long unused_data_addr_529 = mir_set_data_uint(1141000194L);
long unused_data_addr_530 = mir_set_data_uint(1090667010L);
long unused_data_addr_531 = mir_set_data_uint(1078083714L);
long unused_data_addr_532 = mir_set_data_uint(1074937890L);
long unused_data_addr_533 = mir_set_data_uint(1073889290L);
long unused_data_addr_534 = mir_set_data_uint(32766L);
long unused_data_addr_535 = mir_set_data_uint(8388608L);
long unused_data_addr_536 = mir_set_data_uint(65011840L);
long unused_data_addr_537 = mir_set_data_uint(134743184L);
long unused_data_addr_538 = mir_set_data_uint(1016989704L);
long unused_data_addr_539 = mir_set_data_uint(134744072L);
long unused_data_addr_540 = mir_set_data_uint(65012880L);
long unused_data_addr_541 = mir_set_data_uint(8388736L);
long unused_data_addr_542 = mir_set_data_uint(0L);
long unused_data_addr_543 = mir_set_data_uint(8388608L);
long unused_data_addr_544 = mir_set_data_uint(8388736L);
long unused_data_addr_545 = mir_set_data_uint(8388736L);
long unused_data_addr_546 = mir_set_data_uint(1073611200L);
long unused_data_addr_547 = mir_set_data_uint(8389056L);
long unused_data_addr_548 = mir_set_data_uint(8388736L);
long unused_data_addr_549 = mir_set_data_uint(8388736L);
long unused_data_addr_550 = mir_set_data_uint(0L);
long unused_data_addr_551 = mir_set_data_uint(8388608L);
long unused_data_addr_552 = mir_set_data_uint(8388736L);
long unused_data_addr_553 = mir_set_data_uint(65011840L);
long unused_data_addr_554 = mir_set_data_uint(1073611744L);
long unused_data_addr_555 = mir_set_data_uint(65012704L);
long unused_data_addr_556 = mir_set_data_uint(8388736L);
long unused_data_addr_557 = mir_set_data_uint(8388736L);
long unused_data_addr_558 = mir_set_data_uint(0L);
long unused_data_addr_559 = mir_set_data_uint(16777216L);
long unused_data_addr_560 = mir_set_data_uint(130024320L);
long unused_data_addr_561 = mir_set_data_uint(16777472L);
long unused_data_addr_562 = mir_set_data_uint(1670127624L);
long unused_data_addr_563 = mir_set_data_uint(1670183870L);
long unused_data_addr_564 = mir_set_data_uint(16785416L);
long unused_data_addr_565 = mir_set_data_uint(130023680L);
long unused_data_addr_566 = mir_set_data_uint(16778112L);
long unused_data_addr_567 = mir_set_data_uint(16777216L);
long unused_data_addr_568 = mir_set_data_uint(130024320L);
long unused_data_addr_569 = mir_set_data_uint(16777472L);
long unused_data_addr_570 = mir_set_data_uint(1628184840L);
long unused_data_addr_571 = mir_set_data_uint(1628241918L);
long unused_data_addr_572 = mir_set_data_uint(16785672L);
long unused_data_addr_573 = mir_set_data_uint(130023680L);
long unused_data_addr_574 = mir_set_data_uint(16778112L);
long unused_data_addr_575 = mir_set_data_uint(2015232000L);
long unused_data_addr_576 = mir_set_data_uint(1611034638L);
long unused_data_addr_577 = mir_set_data_uint(69224466L);
long unused_data_addr_578 = mir_set_data_uint(576L);
long unused_data_addr_579 = mir_set_data_uint(37748736L);
long unused_data_addr_580 = mir_set_data_uint(1209140256L);
long unused_data_addr_581 = mir_set_data_uint(1879990278L);
long unused_data_addr_582 = mir_set_data_uint(30750L);
long unused_data_addr_583 = mir_set_data_uint(0L);
long unused_data_addr_584 = mir_set_data_uint(939539456L);
long unused_data_addr_585 = mir_set_data_uint(603992064L);
long unused_data_addr_586 = mir_set_data_uint(16777728L);
long unused_data_addr_587 = mir_set_data_uint(4194432L);
long unused_data_addr_588 = mir_set_data_uint(786468L);
long unused_data_addr_589 = mir_set_data_uint(3932188L);
long unused_data_addr_590 = mir_set_data_uint(0L);
long unused_data_addr_591 = mir_set_data_uint(0L);
long unused_data_addr_592 = mir_set_data_uint(1835068L);
long unused_data_addr_593 = mir_set_data_uint(2359308L);
long unused_data_addr_594 = mir_set_data_uint(8388672L);
long unused_data_addr_595 = mir_set_data_uint(33554688L);
long unused_data_addr_596 = mir_set_data_uint(805315584L);
long unused_data_addr_597 = mir_set_data_uint(1006647296L);
long unused_data_addr_598 = mir_set_data_uint(0L);
long unused_data_addr_599 = mir_set_data_uint(0L);
long unused_data_addr_600 = mir_set_data_uint(3145760L);
long unused_data_addr_601 = mir_set_data_uint(271589368L);
long unused_data_addr_602 = mir_set_data_uint(268439584L);
long unused_data_addr_603 = mir_set_data_uint(268439552L);
long unused_data_addr_604 = mir_set_data_uint(268439552L);
long unused_data_addr_605 = mir_set_data_uint(8128L);
long unused_data_addr_606 = mir_set_data_uint(0L);
long unused_data_addr_607 = mir_set_data_uint(0L);
long unused_data_addr_608 = mir_set_data_uint(201327616L);
long unused_data_addr_609 = mir_set_data_uint(201859064L);
long unused_data_addr_610 = mir_set_data_uint(525320L);
long unused_data_addr_611 = mir_set_data_uint(524296L);
long unused_data_addr_612 = mir_set_data_uint(524296L);
long unused_data_addr_613 = mir_set_data_uint(1016L);
long unused_data_addr_614 = mir_set_data_uint(0L);
long unused_data_addr_615 = mir_set_data_uint(0L);
long unused_data_addr_616 = mir_set_data_uint(1073479680L);
long unused_data_addr_617 = mir_set_data_uint(537141252L);
long unused_data_addr_618 = mir_set_data_uint(536879104L);
long unused_data_addr_619 = mir_set_data_uint(541073408L);
long unused_data_addr_620 = mir_set_data_uint(1072701536L);
long unused_data_addr_621 = mir_set_data_uint(4194400L);
long unused_data_addr_622 = mir_set_data_uint(0L);
long unused_data_addr_623 = mir_set_data_uint(0L);
long unused_data_addr_624 = mir_set_data_uint(1073479680L);
long unused_data_addr_625 = mir_set_data_uint(537141252L);
long unused_data_addr_626 = mir_set_data_uint(670834692L);
long unused_data_addr_627 = mir_set_data_uint(538976256L);
long unused_data_addr_628 = mir_set_data_uint(1073225776L);
long unused_data_addr_629 = mir_set_data_uint(2097200L);
long unused_data_addr_630 = mir_set_data_uint(0L);
long unused_data_addr_631 = mir_set_data_uint(0L);
long unused_data_addr_632 = mir_set_data_uint(267386880L);
long unused_data_addr_633 = mir_set_data_uint(268965912L);
long unused_data_addr_634 = mir_set_data_uint(293605384L);
long unused_data_addr_635 = mir_set_data_uint(268439936L);
long unused_data_addr_636 = mir_set_data_uint(405803040L);
long unused_data_addr_637 = mir_set_data_uint(3149816L);
long unused_data_addr_638 = mir_set_data_uint(32L);
long unused_data_addr_639 = mir_set_data_uint(0L);
long unused_data_addr_640 = mir_set_data_uint(100663808L);
long unused_data_addr_641 = mir_set_data_uint(637808636L);
long unused_data_addr_642 = mir_set_data_uint(537141764L);
long unused_data_addr_643 = mir_set_data_uint(541335556L);
long unused_data_addr_644 = mir_set_data_uint(1072963684L);
long unused_data_addr_645 = mir_set_data_uint(4194400L);
long unused_data_addr_646 = mir_set_data_uint(0L);
long unused_data_addr_647 = mir_set_data_uint(0L);
long unused_data_addr_648 = mir_set_data_uint(805310464L);
long unused_data_addr_649 = mir_set_data_uint(839941134L);
long unused_data_addr_650 = mir_set_data_uint(8392992L);
long unused_data_addr_651 = mir_set_data_uint(287309888L);
long unused_data_addr_652 = mir_set_data_uint(2081305104L);
long unused_data_addr_653 = mir_set_data_uint(268447744L);
long unused_data_addr_654 = mir_set_data_uint(0L);
long unused_data_addr_655 = mir_set_data_uint(0L);
long unused_data_addr_656 = mir_set_data_uint(805584892L);
long unused_data_addr_657 = mir_set_data_uint(604252164L);
long unused_data_addr_658 = mir_set_data_uint(553918980L);
long unused_data_addr_659 = mir_set_data_uint(541335684L);
long unused_data_addr_660 = mir_set_data_uint(538189860L);
long unused_data_addr_661 = mir_set_data_uint(1073487884L);
long unused_data_addr_662 = mir_set_data_uint(0L);
long unused_data_addr_663 = mir_set_data_uint(0L);
long unused_data_addr_664 = mir_set_data_uint(537149436L);
long unused_data_addr_665 = mir_set_data_uint(537141252L);
long unused_data_addr_666 = mir_set_data_uint(537141252L);
long unused_data_addr_667 = mir_set_data_uint(537141252L);
long unused_data_addr_668 = mir_set_data_uint(537141252L);
long unused_data_addr_669 = mir_set_data_uint(1073487876L);
long unused_data_addr_670 = mir_set_data_uint(0L);
long unused_data_addr_671 = mir_set_data_uint(0L);
long unused_data_addr_672 = mir_set_data_uint(600063996L);
long unused_data_addr_673 = mir_set_data_uint(600056772L);
long unused_data_addr_674 = mir_set_data_uint(537142212L);
long unused_data_addr_675 = mir_set_data_uint(537141252L);
long unused_data_addr_676 = mir_set_data_uint(537141252L);
long unused_data_addr_677 = mir_set_data_uint(1073487876L);
long unused_data_addr_678 = mir_set_data_uint(0L);
long unused_data_addr_679 = mir_set_data_uint(0L);
long unused_data_addr_680 = mir_set_data_uint(1040465916L);
long unused_data_addr_681 = mir_set_data_uint(1040465412L);
long unused_data_addr_682 = mir_set_data_uint(537148932L);
long unused_data_addr_683 = mir_set_data_uint(537141252L);
long unused_data_addr_684 = mir_set_data_uint(537141252L);
long unused_data_addr_685 = mir_set_data_uint(1073487876L);
long unused_data_addr_686 = mir_set_data_uint(0L);
long unused_data_addr_687 = mir_set_data_uint(0L);
long unused_data_addr_688 = mir_set_data_uint(537149436L);
long unused_data_addr_689 = mir_set_data_uint(537141252L);
long unused_data_addr_690 = mir_set_data_uint(1040465412L);
long unused_data_addr_691 = mir_set_data_uint(1040465412L);
long unused_data_addr_692 = mir_set_data_uint(537141252L);
long unused_data_addr_693 = mir_set_data_uint(1073487876L);
long unused_data_addr_694 = mir_set_data_uint(0L);
long unused_data_addr_695 = mir_set_data_uint(0L);
long unused_data_addr_696 = mir_set_data_uint(537149436L);
long unused_data_addr_697 = mir_set_data_uint(537141252L);
long unused_data_addr_698 = mir_set_data_uint(537141252L);
long unused_data_addr_699 = mir_set_data_uint(1040457732L);
long unused_data_addr_700 = mir_set_data_uint(1040465412L);
long unused_data_addr_701 = mir_set_data_uint(1073495556L);
long unused_data_addr_702 = mir_set_data_uint(0L);
long unused_data_addr_703 = mir_set_data_uint(0L);
long unused_data_addr_704 = mir_set_data_uint(537149436L);
long unused_data_addr_705 = mir_set_data_uint(537141252L);
long unused_data_addr_706 = mir_set_data_uint(537141252L);
long unused_data_addr_707 = mir_set_data_uint(600055812L);
long unused_data_addr_708 = mir_set_data_uint(600056772L);
long unused_data_addr_709 = mir_set_data_uint(1073488836L);
long unused_data_addr_710 = mir_set_data_uint(0L);
long unused_data_addr_711 = mir_set_data_uint(0L);
long unused_data_addr_712 = mir_set_data_uint(537149436L);
long unused_data_addr_713 = mir_set_data_uint(537141252L);
long unused_data_addr_714 = mir_set_data_uint(537141252L);
long unused_data_addr_715 = mir_set_data_uint(545005572L);
long unused_data_addr_716 = mir_set_data_uint(545005692L);
long unused_data_addr_717 = mir_set_data_uint(1073487996L);
long unused_data_addr_718 = mir_set_data_uint(0L);
long unused_data_addr_719 = mir_set_data_uint(0L);
long unused_data_addr_720 = mir_set_data_uint(537149436L);
long unused_data_addr_721 = mir_set_data_uint(537141252L);
long unused_data_addr_722 = mir_set_data_uint(545005692L);
long unused_data_addr_723 = mir_set_data_uint(545005692L);
long unused_data_addr_724 = mir_set_data_uint(537141252L);
long unused_data_addr_725 = mir_set_data_uint(1073487876L);
long unused_data_addr_726 = mir_set_data_uint(0L);
long unused_data_addr_727 = mir_set_data_uint(0L);
long unused_data_addr_728 = mir_set_data_uint(545013756L);
long unused_data_addr_729 = mir_set_data_uint(545005692L);
long unused_data_addr_730 = mir_set_data_uint(537141372L);
long unused_data_addr_731 = mir_set_data_uint(537141252L);
long unused_data_addr_732 = mir_set_data_uint(537141252L);
long unused_data_addr_733 = mir_set_data_uint(1073487876L);
long unused_data_addr_734 = mir_set_data_uint(0L);
long unused_data_addr_735 = mir_set_data_uint(0L);
long unused_data_addr_736 = mir_set_data_uint(537149436L);
long unused_data_addr_737 = mir_set_data_uint(537141252L);
long unused_data_addr_738 = mir_set_data_uint(600056772L);
long unused_data_addr_739 = mir_set_data_uint(600056772L);
long unused_data_addr_740 = mir_set_data_uint(537141252L);
long unused_data_addr_741 = mir_set_data_uint(1073487876L);
long unused_data_addr_742 = mir_set_data_uint(0L);
long unused_data_addr_743 = mir_set_data_uint(2147352576L);
long unused_data_addr_744 = mir_set_data_uint(1073889282L);
long unused_data_addr_745 = mir_set_data_uint(1206010242L);
long unused_data_addr_746 = mir_set_data_uint(1341278178L);
long unused_data_addr_747 = mir_set_data_uint(1206013938L);
long unused_data_addr_748 = mir_set_data_uint(1099057122L);
long unused_data_addr_749 = mir_set_data_uint(1073889282L);
long unused_data_addr_750 = mir_set_data_uint(32766L);
long unused_data_addr_751 = mir_set_data_uint(2147418112L);
long unused_data_addr_752 = mir_set_data_uint(1073823745L);
long unused_data_addr_753 = mir_set_data_uint(1073823745L);
long unused_data_addr_754 = mir_set_data_uint(1230331357L);
long unused_data_addr_755 = mir_set_data_uint(1229277533L);
long unused_data_addr_756 = mir_set_data_uint(1073826245L);
long unused_data_addr_757 = mir_set_data_uint(1073823745L);
long unused_data_addr_758 = mir_set_data_uint(32767L);
long unused_data_addr_759 = mir_set_data_uint(2147352576L);
long unused_data_addr_760 = mir_set_data_uint(1395815218L);
long unused_data_addr_761 = mir_set_data_uint(1154370766L);
long unused_data_addr_762 = mir_set_data_uint(1093813042L);
long unused_data_addr_763 = mir_set_data_uint(1078870222L);
long unused_data_addr_764 = mir_set_data_uint(1209160754L);
long unused_data_addr_765 = mir_set_data_uint(1074156558L);
long unused_data_addr_766 = mir_set_data_uint(32766L);
long unused_data_addr_767 = mir_set_data_uint(2147352576L);
long unused_data_addr_768 = mir_set_data_uint(1395815218L);
long unused_data_addr_769 = mir_set_data_uint(1154370766L);
long unused_data_addr_770 = mir_set_data_uint(1093813042L);
long unused_data_addr_771 = mir_set_data_uint(1548632270L);
long unused_data_addr_772 = mir_set_data_uint(1142047794L);
long unused_data_addr_773 = mir_set_data_uint(1074158606L);
long unused_data_addr_774 = mir_set_data_uint(32766L);
long unused_data_addr_775 = mir_set_data_uint(2147352576L);
long unused_data_addr_776 = mir_set_data_uint(1123959166L);
long unused_data_addr_777 = mir_set_data_uint(1123959166L);
long unused_data_addr_778 = mir_set_data_uint(1123959166L);
long unused_data_addr_779 = mir_set_data_uint(1123959166L);
long unused_data_addr_780 = mir_set_data_uint(1123959166L);
long unused_data_addr_781 = mir_set_data_uint(1123959166L);
long unused_data_addr_782 = mir_set_data_uint(32766L);
long unused_data_addr_783 = mir_set_data_uint(134086656L);
long unused_data_addr_784 = mir_set_data_uint(536477698L);
long unused_data_addr_785 = mir_set_data_uint(2146041866L);
long unused_data_addr_786 = mir_set_data_uint(1076510762L);
long unused_data_addr_787 = mir_set_data_uint(1529499946L);
long unused_data_addr_788 = mir_set_data_uint(1361597738L);
long unused_data_addr_789 = mir_set_data_uint(1075859752L);
long unused_data_addr_790 = mir_set_data_uint(32736L);
long unused_data_addr_791 = mir_set_data_uint(0L);
long unused_data_addr_792 = mir_set_data_uint(536346624L);
long unused_data_addr_793 = mir_set_data_uint(306713160L);
long unused_data_addr_794 = mir_set_data_uint(306716664L);
long unused_data_addr_795 = mir_set_data_uint(536351304L);
long unused_data_addr_796 = mir_set_data_uint(306713160L);
long unused_data_addr_797 = mir_set_data_uint(8184L);
long unused_data_addr_798 = mir_set_data_uint(0L);
long unused_data_addr_799 = mir_set_data_uint(306708480L);
long unused_data_addr_800 = mir_set_data_uint(2147357256L);
long unused_data_addr_801 = mir_set_data_uint(306713160L);
long unused_data_addr_802 = mir_set_data_uint(306741246L);
long unused_data_addr_803 = mir_set_data_uint(2147357256L);
long unused_data_addr_804 = mir_set_data_uint(306713160L);
long unused_data_addr_805 = mir_set_data_uint(306741246L);
long unused_data_addr_806 = mir_set_data_uint(4680L);
long unused_data_addr_807 = mir_set_data_uint(0L);
long unused_data_addr_808 = mir_set_data_uint(473432064L);
long unused_data_addr_809 = mir_set_data_uint(473438184L);
long unused_data_addr_810 = mir_set_data_uint(135268368L);
long unused_data_addr_811 = mir_set_data_uint(135268368L);
long unused_data_addr_812 = mir_set_data_uint(401087544L);
long unused_data_addr_813 = mir_set_data_uint(7224L);
long unused_data_addr_814 = mir_set_data_uint(0L);
long unused_data_addr_815 = mir_set_data_uint(1879965696L);
long unused_data_addr_816 = mir_set_data_uint(1879990266L);
long unused_data_addr_817 = mir_set_data_uint(537141252L);
long unused_data_addr_818 = mir_set_data_uint(537141252L);
long unused_data_addr_819 = mir_set_data_uint(537141252L);
long unused_data_addr_820 = mir_set_data_uint(537141252L);
long unused_data_addr_821 = mir_set_data_uint(1610248206L);
long unused_data_addr_822 = mir_set_data_uint(28686L);
long unused_data_addr_823 = mir_set_data_uint(1065222144L);
long unused_data_addr_824 = mir_set_data_uint(557982018L);
long unused_data_addr_825 = mir_set_data_uint(557982018L);
long unused_data_addr_826 = mir_set_data_uint(16254L);
long unused_data_addr_827 = mir_set_data_uint(557989758L);
long unused_data_addr_828 = mir_set_data_uint(557982018L);
long unused_data_addr_829 = mir_set_data_uint(1065230658L);
long unused_data_addr_830 = mir_set_data_uint(0L);
long unused_data_addr_831 = mir_set_data_uint(0L);
long unused_data_addr_832 = mir_set_data_uint(1001914368L);
long unused_data_addr_833 = mir_set_data_uint(1001929656L);
long unused_data_addr_834 = mir_set_data_uint(1001914368L);
long unused_data_addr_835 = mir_set_data_uint(1001929656L);
long unused_data_addr_836 = mir_set_data_uint(1001914368L);
long unused_data_addr_837 = mir_set_data_uint(1001929656L);
long unused_data_addr_838 = mir_set_data_uint(0L);
long unused_data_addr_839 = mir_set_data_uint(2147352576L);
long unused_data_addr_840 = mir_set_data_uint(2147385342L);
long unused_data_addr_841 = mir_set_data_uint(2013163520L);
long unused_data_addr_842 = mir_set_data_uint(2013165566L);
long unused_data_addr_843 = mir_set_data_uint(2004776704L);
long unused_data_addr_844 = mir_set_data_uint(2004776830L);
long unused_data_addr_845 = mir_set_data_uint(2004776830L);
long unused_data_addr_846 = mir_set_data_uint(30590L);
long unused_data_addr_847 = mir_set_data_uint(2015232000L);
long unused_data_addr_848 = mir_set_data_uint(1073889282L);
long unused_data_addr_849 = mir_set_data_uint(16386L);
long unused_data_addr_850 = mir_set_data_uint(25165824L);
long unused_data_addr_851 = mir_set_data_uint(384L);
long unused_data_addr_852 = mir_set_data_uint(1073872896L);
long unused_data_addr_853 = mir_set_data_uint(1073889282L);
long unused_data_addr_854 = mir_set_data_uint(30750L);
long unused_data_addr_855 = mir_set_data_uint(2015232000L);
long unused_data_addr_856 = mir_set_data_uint(1073889282L);
long unused_data_addr_857 = mir_set_data_uint(16386L);
long unused_data_addr_858 = mir_set_data_uint(62915520L);
long unused_data_addr_859 = mir_set_data_uint(62915520L);
long unused_data_addr_860 = mir_set_data_uint(1073872896L);
long unused_data_addr_861 = mir_set_data_uint(1073889282L);
long unused_data_addr_862 = mir_set_data_uint(30750L);
long unused_data_addr_863 = mir_set_data_uint(2015232000L);
long unused_data_addr_864 = mir_set_data_uint(1073889282L);
long unused_data_addr_865 = mir_set_data_uint(132136962L);
long unused_data_addr_866 = mir_set_data_uint(132122592L);
long unused_data_addr_867 = mir_set_data_uint(132122592L);
long unused_data_addr_868 = mir_set_data_uint(1073874912L);
long unused_data_addr_869 = mir_set_data_uint(1073889282L);
long unused_data_addr_870 = mir_set_data_uint(30750L);
long unused_data_addr_871 = mir_set_data_uint(2015232000L);
long unused_data_addr_872 = mir_set_data_uint(1610235906L);
long unused_data_addr_873 = mir_set_data_uint(536371194L);
long unused_data_addr_874 = mir_set_data_uint(536354808L);
long unused_data_addr_875 = mir_set_data_uint(536354808L);
long unused_data_addr_876 = mir_set_data_uint(1610227704L);
long unused_data_addr_877 = mir_set_data_uint(1073897466L);
long unused_data_addr_878 = mir_set_data_uint(30750L);
long unused_data_addr_879 = mir_set_data_uint(0L);
long unused_data_addr_880 = mir_set_data_uint(537147420L);
long unused_data_addr_881 = mir_set_data_uint(8196L);
long unused_data_addr_882 = mir_set_data_uint(0L);
long unused_data_addr_883 = mir_set_data_uint(0L);
long unused_data_addr_884 = mir_set_data_uint(537133056L);
long unused_data_addr_885 = mir_set_data_uint(941367300L);
long unused_data_addr_886 = mir_set_data_uint(0L);
long unused_data_addr_887 = mir_set_data_uint(0L);
long unused_data_addr_888 = mir_set_data_uint(498597888L);
long unused_data_addr_889 = mir_set_data_uint(268963848L);
long unused_data_addr_890 = mir_set_data_uint(268959744L);
long unused_data_addr_891 = mir_set_data_uint(4104L);
long unused_data_addr_892 = mir_set_data_uint(268963848L);
long unused_data_addr_893 = mir_set_data_uint(7608L);
long unused_data_addr_894 = mir_set_data_uint(0L);
long unused_data_addr_895 = mir_set_data_uint(894828544L);
long unused_data_addr_896 = mir_set_data_uint(8194L);
long unused_data_addr_897 = mir_set_data_uint(8194L);
long unused_data_addr_898 = mir_set_data_uint(8194L);
long unused_data_addr_899 = mir_set_data_uint(8194L);
long unused_data_addr_900 = mir_set_data_uint(8194L);
long unused_data_addr_901 = mir_set_data_uint(894836738L);
long unused_data_addr_902 = mir_set_data_uint(0L);
long unused_data_addr_903 = mir_set_data_uint(2147352576L);
long unused_data_addr_904 = mir_set_data_uint(1073889282L);
long unused_data_addr_905 = mir_set_data_uint(1209159666L);
long unused_data_addr_906 = mir_set_data_uint(1234323474L);
long unused_data_addr_907 = mir_set_data_uint(1209158034L);
long unused_data_addr_908 = mir_set_data_uint(1341278226L);
long unused_data_addr_909 = mir_set_data_uint(1073889282L);
long unused_data_addr_910 = mir_set_data_uint(32766L);
long unused_data_addr_911 = mir_set_data_uint(0L);
long unused_data_addr_912 = mir_set_data_uint(277094396L);
long unused_data_addr_913 = mir_set_data_uint(277090436L);
long unused_data_addr_914 = mir_set_data_uint(536612996L);
long unused_data_addr_915 = mir_set_data_uint(277090436L);
long unused_data_addr_916 = mir_set_data_uint(277090436L);
long unused_data_addr_917 = mir_set_data_uint(8188L);
long unused_data_addr_918 = mir_set_data_uint(0L);
long unused_data_addr_919 = mir_set_data_uint(0L);
long unused_data_addr_920 = mir_set_data_uint(0L);
long unused_data_addr_921 = mir_set_data_uint(268435456L);
long unused_data_addr_922 = mir_set_data_uint(67110912L);
long unused_data_addr_923 = mir_set_data_uint(17039872L);
long unused_data_addr_924 = mir_set_data_uint(5243016L);
long unused_data_addr_925 = mir_set_data_uint(32L);
long unused_data_addr_926 = mir_set_data_uint(0L);
long unused_data_addr_927 = mir_set_data_uint(0L);
long unused_data_addr_928 = mir_set_data_uint(268959744L);
long unused_data_addr_929 = mir_set_data_uint(69208080L);
long unused_data_addr_930 = mir_set_data_uint(25166400L);
long unused_data_addr_931 = mir_set_data_uint(37749120L);
long unused_data_addr_932 = mir_set_data_uint(135267360L);
long unused_data_addr_933 = mir_set_data_uint(4104L);
long unused_data_addr_934 = mir_set_data_uint(0L);
long unused_data_addr_935 = mir_set_data_uint(0L);
long unused_data_addr_936 = mir_set_data_uint(33554432L);
long unused_data_addr_937 = mir_set_data_uint(8388864L);
long unused_data_addr_938 = mir_set_data_uint(2097216L);
long unused_data_addr_939 = mir_set_data_uint(2097168L);
long unused_data_addr_940 = mir_set_data_uint(8388672L);
long unused_data_addr_941 = mir_set_data_uint(33554688L);
long unused_data_addr_942 = mir_set_data_uint(0L);
long unused_data_addr_943 = mir_set_data_uint(0L);
long unused_data_addr_944 = mir_set_data_uint(4194304L);
long unused_data_addr_945 = mir_set_data_uint(16777344L);
long unused_data_addr_946 = mir_set_data_uint(67109376L);
long unused_data_addr_947 = mir_set_data_uint(67110912L);
long unused_data_addr_948 = mir_set_data_uint(16777728L);
long unused_data_addr_949 = mir_set_data_uint(4194432L);
long unused_data_addr_950 = mir_set_data_uint(0L);
long unused_data_addr_951 = mir_set_data_uint(0L);
long unused_data_addr_952 = mir_set_data_uint(0L);
long unused_data_addr_953 = mir_set_data_uint(0L);
long unused_data_addr_954 = mir_set_data_uint(134746116L);
long unused_data_addr_955 = mir_set_data_uint(35652624L);
long unused_data_addr_956 = mir_set_data_uint(8388928L);
long unused_data_addr_957 = mir_set_data_uint(0L);
long unused_data_addr_958 = mir_set_data_uint(0L);
long unused_data_addr_959 = mir_set_data_uint(0L);
long unused_data_addr_960 = mir_set_data_uint(0L);
long unused_data_addr_961 = mir_set_data_uint(20971648L);
long unused_data_addr_962 = mir_set_data_uint(68157984L);
long unused_data_addr_963 = mir_set_data_uint(268699656L);
long unused_data_addr_964 = mir_set_data_uint(0L);
long unused_data_addr_965 = mir_set_data_uint(0L);
long unused_data_addr_966 = mir_set_data_uint(0L);
long unused_data_addr_967 = mir_set_data_uint(0L);
long unused_data_addr_968 = mir_set_data_uint(33554432L);
long unused_data_addr_969 = mir_set_data_uint(58721024L);
long unused_data_addr_970 = mir_set_data_uint(65012672L);
long unused_data_addr_971 = mir_set_data_uint(65012720L);
long unused_data_addr_972 = mir_set_data_uint(58721216L);
long unused_data_addr_973 = mir_set_data_uint(33555200L);
long unused_data_addr_974 = mir_set_data_uint(0L);
long unused_data_addr_975 = mir_set_data_uint(0L);
long unused_data_addr_976 = mir_set_data_uint(4194304L);
long unused_data_addr_977 = mir_set_data_uint(29360320L);
long unused_data_addr_978 = mir_set_data_uint(130024384L);
long unused_data_addr_979 = mir_set_data_uint(130027456L);
long unused_data_addr_980 = mir_set_data_uint(29361088L);
long unused_data_addr_981 = mir_set_data_uint(4194496L);
long unused_data_addr_982 = mir_set_data_uint(0L);
long unused_data_addr_983 = mir_set_data_uint(0L);
long unused_data_addr_984 = mir_set_data_uint(0L);
long unused_data_addr_985 = mir_set_data_uint(0L);
long unused_data_addr_986 = mir_set_data_uint(267919356L);
long unused_data_addr_987 = mir_set_data_uint(65013744L);
long unused_data_addr_988 = mir_set_data_uint(8389056L);
long unused_data_addr_989 = mir_set_data_uint(0L);
long unused_data_addr_990 = mir_set_data_uint(0L);
long unused_data_addr_991 = mir_set_data_uint(0L);
long unused_data_addr_992 = mir_set_data_uint(0L);
long unused_data_addr_993 = mir_set_data_uint(29360256L);
long unused_data_addr_994 = mir_set_data_uint(133170144L);
long unused_data_addr_995 = mir_set_data_uint(536612856L);
long unused_data_addr_996 = mir_set_data_uint(0L);
long unused_data_addr_997 = mir_set_data_uint(0L);
long unused_data_addr_998 = mir_set_data_uint(0L);
long unused_data_addr_999 = mir_set_data_uint(0L);
long unused_data_addr_1000 = mir_set_data_uint(413141184L);
long unused_data_addr_1001 = mir_set_data_uint(847778448L);
long unused_data_addr_1002 = mir_set_data_uint(612509318L);
long unused_data_addr_1003 = mir_set_data_uint(646325378L);
long unused_data_addr_1004 = mir_set_data_uint(311440008L);
long unused_data_addr_1005 = mir_set_data_uint(146806944L);
long unused_data_addr_1006 = mir_set_data_uint(0L);
long unused_data_addr_1007 = mir_set_data_uint(0L);
long unused_data_addr_1008 = mir_set_data_uint(75499392L);
long unused_data_addr_1009 = mir_set_data_uint(4194496L);
long unused_data_addr_1010 = mir_set_data_uint(1713373424L);
long unused_data_addr_1011 = mir_set_data_uint(135281712L);
long unused_data_addr_1012 = mir_set_data_uint(319426072L);
long unused_data_addr_1013 = mir_set_data_uint(12686L);
long unused_data_addr_1014 = mir_set_data_uint(0L);
long unused_data_addr_1015 = mir_set_data_uint(0L);
long unused_data_addr_1016 = mir_set_data_uint(8388608L);
long unused_data_addr_1017 = mir_set_data_uint(143132808L);
long unused_data_addr_1018 = mir_set_data_uint(715786890L);
long unused_data_addr_1019 = mir_set_data_uint(176827050L);
long unused_data_addr_1020 = mir_set_data_uint(143132808L);
long unused_data_addr_1021 = mir_set_data_uint(128L);
long unused_data_addr_1022 = mir_set_data_uint(0L);
long unused_data_addr_1023 = mir_set_data_uint(0L);
long unused_data_addr_1024 = mir_set_data_uint(6291456L);
long unused_data_addr_1025 = mir_set_data_uint(17301648L);
long unused_data_addr_1026 = mir_set_data_uint(33816840L);
long unused_data_addr_1027 = mir_set_data_uint(1107575300L);
long unused_data_addr_1028 = mir_set_data_uint(604120066L);
long unused_data_addr_1029 = mir_set_data_uint(6144L);
long unused_data_addr_1030 = mir_set_data_uint(0L);
long unused_data_addr_1031 = mir_set_data_uint(0L);
long unused_data_addr_1032 = mir_set_data_uint(133693440L);
long unused_data_addr_1033 = mir_set_data_uint(67634184L);
long unused_data_addr_1034 = mir_set_data_uint(67634184L);
long unused_data_addr_1035 = mir_set_data_uint(67634184L);
long unused_data_addr_1036 = mir_set_data_uint(2081293320L);
long unused_data_addr_1037 = mir_set_data_uint(0L);
long unused_data_addr_1038 = mir_set_data_uint(0L);
long unused_data_addr_1039 = mir_set_data_uint(0L);
long unused_data_addr_1040 = mir_set_data_uint(0L);
long unused_data_addr_1041 = mir_set_data_uint(10485824L);
long unused_data_addr_1042 = mir_set_data_uint(570966288L);
long unused_data_addr_1043 = mir_set_data_uint(134353924L);
long unused_data_addr_1044 = mir_set_data_uint(0L);
long unused_data_addr_1045 = mir_set_data_uint(0L);
long unused_data_addr_1046 = mir_set_data_uint(0L);
long unused_data_addr_1047 = mir_set_data_uint(0L);
long unused_data_addr_1048 = mir_set_data_uint(0L);
long unused_data_addr_1049 = mir_set_data_uint(69206016L);
long unused_data_addr_1050 = mir_set_data_uint(25166400L);
long unused_data_addr_1051 = mir_set_data_uint(37749120L);
long unused_data_addr_1052 = mir_set_data_uint(1056L);
long unused_data_addr_1053 = mir_set_data_uint(0L);
long unused_data_addr_1054 = mir_set_data_uint(0L);
long unused_data_addr_1055 = mir_set_data_uint(0L);
long unused_data_addr_1056 = mir_set_data_uint(406323200L);
long unused_data_addr_1057 = mir_set_data_uint(304616488L);
long unused_data_addr_1058 = mir_set_data_uint(279449896L);
long unused_data_addr_1059 = mir_set_data_uint(287838376L);
long unused_data_addr_1060 = mir_set_data_uint(338170408L);
long unused_data_addr_1061 = mir_set_data_uint(6200L);
long unused_data_addr_1062 = mir_set_data_uint(0L);
long unused_data_addr_1063 = mir_set_data_uint(0L);
long unused_data_addr_1064 = mir_set_data_uint(402653184L);
long unused_data_addr_1065 = mir_set_data_uint(293606912L);
long unused_data_addr_1066 = mir_set_data_uint(270012512L);
long unused_data_addr_1067 = mir_set_data_uint(274731032L);
long unused_data_addr_1068 = mir_set_data_uint(369103232L);
long unused_data_addr_1069 = mir_set_data_uint(6144L);
long unused_data_addr_1070 = mir_set_data_uint(0L);
long unused_data_addr_1071 = mir_set_data_uint(0L);
long unused_data_addr_1072 = mir_set_data_uint(1572864L);
long unused_data_addr_1073 = mir_set_data_uint(25690216L);
long unused_data_addr_1074 = mir_set_data_uint(403179016L);
long unused_data_addr_1075 = mir_set_data_uint(101193736L);
long unused_data_addr_1076 = mir_set_data_uint(6816136L);
long unused_data_addr_1077 = mir_set_data_uint(24L);
long unused_data_addr_1078 = mir_set_data_uint(0L);
long unused_data_addr_1079 = mir_set_data_uint(0L);
long unused_data_addr_1080 = mir_set_data_uint(511180800L);
long unused_data_addr_1081 = mir_set_data_uint(306713160L);
long unused_data_addr_1082 = mir_set_data_uint(306713160L);
long unused_data_addr_1083 = mir_set_data_uint(306713160L);
long unused_data_addr_1084 = mir_set_data_uint(306713160L);
long unused_data_addr_1085 = mir_set_data_uint(7800L);
long unused_data_addr_1086 = mir_set_data_uint(0L);
long unused_data_addr_1087 = mir_set_data_uint(0L);
long unused_data_addr_1088 = mir_set_data_uint(536346624L);
long unused_data_addr_1089 = mir_set_data_uint(268963848L);
long unused_data_addr_1090 = mir_set_data_uint(268963848L);
long unused_data_addr_1091 = mir_set_data_uint(268963848L);
long unused_data_addr_1092 = mir_set_data_uint(268963848L);
long unused_data_addr_1093 = mir_set_data_uint(8184L);
long unused_data_addr_1094 = mir_set_data_uint(0L);
long unused_data_addr_1095 = mir_set_data_uint(0L);
long unused_data_addr_1096 = mir_set_data_uint(471334912L);
long unused_data_addr_1097 = mir_set_data_uint(340268072L);
long unused_data_addr_1098 = mir_set_data_uint(352851080L);
long unused_data_addr_1099 = mir_set_data_uint(344462600L);
long unused_data_addr_1100 = mir_set_data_uint(338170952L);
long unused_data_addr_1101 = mir_set_data_uint(7192L);
long unused_data_addr_1102 = mir_set_data_uint(0L);
long unused_data_addr_1103 = mir_set_data_uint(0L);
long unused_data_addr_1104 = mir_set_data_uint(62914560L);
long unused_data_addr_1105 = mir_set_data_uint(135267360L);
long unused_data_addr_1106 = mir_set_data_uint(268963848L);
long unused_data_addr_1107 = mir_set_data_uint(268963848L);
long unused_data_addr_1108 = mir_set_data_uint(69208080L);
long unused_data_addr_1109 = mir_set_data_uint(960L);
long unused_data_addr_1110 = mir_set_data_uint(0L);
long unused_data_addr_1111 = mir_set_data_uint(0L);
long unused_data_addr_1112 = mir_set_data_uint(204474336L);
long unused_data_addr_1113 = mir_set_data_uint(331880472L);
long unused_data_addr_1114 = mir_set_data_uint(338171496L);
long unused_data_addr_1115 = mir_set_data_uint(338170920L);
long unused_data_addr_1116 = mir_set_data_uint(473439288L);
long unused_data_addr_1117 = mir_set_data_uint(135275076L);
long unused_data_addr_1118 = mir_set_data_uint(0L);
long unused_data_addr_1119 = mir_set_data_uint(130023424L);
long unused_data_addr_1120 = mir_set_data_uint(136316960L);
long unused_data_addr_1121 = mir_set_data_uint(1073219616L);
long unused_data_addr_1122 = mir_set_data_uint(596123656L);
long unused_data_addr_1123 = mir_set_data_uint(554181512L);
long unused_data_addr_1124 = mir_set_data_uint(537403656L);
long unused_data_addr_1125 = mir_set_data_uint(535830536L);
long unused_data_addr_1126 = mir_set_data_uint(0L);
long unused_data_addr_1127 = mir_set_data_uint(130023424L);
long unused_data_addr_1128 = mir_set_data_uint(134219776L);
long unused_data_addr_1129 = mir_set_data_uint(1073219584L);
long unused_data_addr_1130 = mir_set_data_uint(596123656L);
long unused_data_addr_1131 = mir_set_data_uint(554181512L);
long unused_data_addr_1132 = mir_set_data_uint(537403656L);
long unused_data_addr_1133 = mir_set_data_uint(535830536L);
long unused_data_addr_1134 = mir_set_data_uint(0L);
long unused_data_addr_1135 = mir_set_data_uint(29360128L);
long unused_data_addr_1136 = mir_set_data_uint(202901360L);
long unused_data_addr_1137 = mir_set_data_uint(814094476L);
long unused_data_addr_1138 = mir_set_data_uint(1619206274L);
long unused_data_addr_1139 = mir_set_data_uint(1610827649L);
long unused_data_addr_1140 = mir_set_data_uint(805707778L);
long unused_data_addr_1141 = mir_set_data_uint(202905612L);
long unused_data_addr_1142 = mir_set_data_uint(29362032L);
long unused_data_addr_1143 = mir_set_data_uint(169869312L);
long unused_data_addr_1144 = mir_set_data_uint(455088928L);
long unused_data_addr_1145 = mir_set_data_uint(69209632L);
long unused_data_addr_1146 = mir_set_data_uint(69207072L);
long unused_data_addr_1147 = mir_set_data_uint(74449952L);
long unused_data_addr_1148 = mir_set_data_uint(242224752L);
long unused_data_addr_1149 = mir_set_data_uint(242224752L);
long unused_data_addr_1150 = mir_set_data_uint(69209712L);
long unused_data_addr_1151 = mir_set_data_uint(25165824L);
long unused_data_addr_1152 = mir_set_data_uint(1004286348L);
long unused_data_addr_1153 = mir_set_data_uint(267395064L);
long unused_data_addr_1154 = mir_set_data_uint(2084445816L);
long unused_data_addr_1155 = mir_set_data_uint(511212606L);
long unused_data_addr_1156 = mir_set_data_uint(536350704L);
long unused_data_addr_1157 = mir_set_data_uint(831273948L);
long unused_data_addr_1158 = mir_set_data_uint(384L);
long unused_data_addr_1159 = mir_set_data_uint(25165824L);
long unused_data_addr_1160 = mir_set_data_uint(1073492364L);
long unused_data_addr_1161 = mir_set_data_uint(473440248L);
long unused_data_addr_1162 = mir_set_data_uint(2015238168L);
long unused_data_addr_1163 = mir_set_data_uint(404256798L);
long unused_data_addr_1164 = mir_set_data_uint(536353848L);
long unused_data_addr_1165 = mir_set_data_uint(831275004L);
long unused_data_addr_1166 = mir_set_data_uint(384L);
long unused_data_addr_1167 = mir_set_data_uint(0L);
long unused_data_addr_1168 = mir_set_data_uint(134746104L);
long unused_data_addr_1169 = mir_set_data_uint(134750204L);
long unused_data_addr_1170 = mir_set_data_uint(178784936L);
long unused_data_addr_1171 = mir_set_data_uint(178784936L);
long unused_data_addr_1172 = mir_set_data_uint(178784936L);
long unused_data_addr_1173 = mir_set_data_uint(134744744L);
long unused_data_addr_1174 = mir_set_data_uint(4088L);
long unused_data_addr_1175 = mir_set_data_uint(0L);
long unused_data_addr_1176 = mir_set_data_uint(0L);
long unused_data_addr_1177 = mir_set_data_uint(537149436L);
long unused_data_addr_1178 = mir_set_data_uint(134496132L);
long unused_data_addr_1179 = mir_set_data_uint(67374980L);
long unused_data_addr_1180 = mir_set_data_uint(67372932L);
long unused_data_addr_1181 = mir_set_data_uint(2044L);
long unused_data_addr_1182 = mir_set_data_uint(0L);
long unused_data_addr_1183 = mir_set_data_uint(0L);
long unused_data_addr_1184 = mir_set_data_uint(608175104L);
long unused_data_addr_1185 = mir_set_data_uint(5248L);
long unused_data_addr_1186 = mir_set_data_uint(1862143488L);
long unused_data_addr_1187 = mir_set_data_uint(3584L);
long unused_data_addr_1188 = mir_set_data_uint(608179328L);
long unused_data_addr_1189 = mir_set_data_uint(1024L);
long unused_data_addr_1190 = mir_set_data_uint(0L);
long unused_data_addr_1191 = mir_set_data_uint(0L);
long unused_data_addr_1192 = mir_set_data_uint(62914560L);
long unused_data_addr_1193 = mir_set_data_uint(137364576L);
long unused_data_addr_1194 = mir_set_data_uint(286789912L);
long unused_data_addr_1195 = mir_set_data_uint(286789912L);
long unused_data_addr_1196 = mir_set_data_uint(73402416L);
long unused_data_addr_1197 = mir_set_data_uint(960L);
long unused_data_addr_1198 = mir_set_data_uint(0L);
long unused_data_addr_1199 = mir_set_data_uint(0L);
long unused_data_addr_1200 = mir_set_data_uint(277348480L);
long unused_data_addr_1201 = mir_set_data_uint(113248272L);
long unused_data_addr_1202 = mir_set_data_uint(913049568L);
long unused_data_addr_1203 = mir_set_data_uint(132121152L);
long unused_data_addr_1204 = mir_set_data_uint(5992L);
long unused_data_addr_1205 = mir_set_data_uint(69206592L);
long unused_data_addr_1206 = mir_set_data_uint(0L);
long unused_data_addr_1207 = mir_set_data_uint(0L);
long unused_data_addr_1208 = mir_set_data_uint(1026031616L);
long unused_data_addr_1209 = mir_set_data_uint(623387948L);
long unused_data_addr_1210 = mir_set_data_uint(1026041128L);
long unused_data_addr_1211 = mir_set_data_uint(86508840L);
long unused_data_addr_1212 = mir_set_data_uint(99091752L);
long unused_data_addr_1213 = mir_set_data_uint(0L);
long unused_data_addr_1214 = mir_set_data_uint(0L);
long unused_data_addr_1215 = mir_set_data_uint(25165824L);
long unused_data_addr_1216 = mir_set_data_uint(62915520L);
long unused_data_addr_1217 = mir_set_data_uint(25166784L);
long unused_data_addr_1218 = mir_set_data_uint(267388896L);
long unused_data_addr_1219 = mir_set_data_uint(198183888L);
long unused_data_addr_1220 = mir_set_data_uint(173018064L);
long unused_data_addr_1221 = mir_set_data_uint(37749312L);
long unused_data_addr_1222 = mir_set_data_uint(37749312L);
long unused_data_addr_1223 = mir_set_data_uint(25165824L);
long unused_data_addr_1224 = mir_set_data_uint(62915520L);
long unused_data_addr_1225 = mir_set_data_uint(293606336L);
long unused_data_addr_1226 = mir_set_data_uint(63447032L);
long unused_data_addr_1227 = mir_set_data_uint(130024392L);
long unused_data_addr_1228 = mir_set_data_uint(71304256L);
long unused_data_addr_1229 = mir_set_data_uint(201852024L);
long unused_data_addr_1230 = mir_set_data_uint(0L);
long unused_data_addr_1231 = mir_set_data_uint(1073217536L);
long unused_data_addr_1232 = mir_set_data_uint(806895608L);
long unused_data_addr_1233 = mir_set_data_uint(806891544L);
long unused_data_addr_1234 = mir_set_data_uint(1073233912L);
long unused_data_addr_1235 = mir_set_data_uint(50332416L);
long unused_data_addr_1236 = mir_set_data_uint(62915520L);
long unused_data_addr_1237 = mir_set_data_uint(65012480L);
long unused_data_addr_1238 = mir_set_data_uint(992L);
long unused_data_addr_1239 = mir_set_data_uint(1073217536L);
long unused_data_addr_1240 = mir_set_data_uint(1073233912L);
long unused_data_addr_1241 = mir_set_data_uint(865615864L);
long unused_data_addr_1242 = mir_set_data_uint(1073230744L);
long unused_data_addr_1243 = mir_set_data_uint(1073233912L);
long unused_data_addr_1244 = mir_set_data_uint(1344L);
long unused_data_addr_1245 = mir_set_data_uint(266341024L);
long unused_data_addr_1246 = mir_set_data_uint(4064L);
long unused_data_addr_1247 = mir_set_data_uint(0L);
long unused_data_addr_1248 = mir_set_data_uint(267386880L);
long unused_data_addr_1249 = mir_set_data_uint(537137160L);
long unused_data_addr_1250 = mir_set_data_uint(625221636L);
long unused_data_addr_1251 = mir_set_data_uint(268967940L);
long unused_data_addr_1252 = mir_set_data_uint(100666352L);
long unused_data_addr_1253 = mir_set_data_uint(768L);
long unused_data_addr_1254 = mir_set_data_uint(0L);
long unused_data_addr_1255 = mir_set_data_uint(0L);
long unused_data_addr_1256 = mir_set_data_uint(289669120L);
long unused_data_addr_1257 = mir_set_data_uint(133172200L);
long unused_data_addr_1258 = mir_set_data_uint(471600696L);
long unused_data_addr_1259 = mir_set_data_uint(471600152L);
long unused_data_addr_1260 = mir_set_data_uint(133172792L);
long unused_data_addr_1261 = mir_set_data_uint(289672168L);
long unused_data_addr_1262 = mir_set_data_uint(0L);
long unused_data_addr_1263 = mir_set_data_uint(0L);
long unused_data_addr_1264 = mir_set_data_uint(537395200L);
long unused_data_addr_1265 = mir_set_data_uint(207622160L);
long unused_data_addr_1266 = mir_set_data_uint(130027488L);
long unused_data_addr_1267 = mir_set_data_uint(130025408L);
long unused_data_addr_1268 = mir_set_data_uint(207622112L);
long unused_data_addr_1269 = mir_set_data_uint(537399312L);
long unused_data_addr_1270 = mir_set_data_uint(0L);
long unused_data_addr_1271 = mir_set_data_uint(0L);
long unused_data_addr_1272 = mir_set_data_uint(537395200L);
long unused_data_addr_1273 = mir_set_data_uint(207622160L);
long unused_data_addr_1274 = mir_set_data_uint(71307232L);
long unused_data_addr_1275 = mir_set_data_uint(71325012L);
long unused_data_addr_1276 = mir_set_data_uint(207622112L);
long unused_data_addr_1277 = mir_set_data_uint(537399312L);
long unused_data_addr_1278 = mir_set_data_uint(0L);
long unused_data_addr_1279 = mir_set_data_uint(0L);
long unused_data_addr_1280 = mir_set_data_uint(8388736L);
long unused_data_addr_1281 = mir_set_data_uint(29360576L);
long unused_data_addr_1282 = mir_set_data_uint(536625150L);
long unused_data_addr_1283 = mir_set_data_uint(65013744L);
long unused_data_addr_1284 = mir_set_data_uint(133170144L);
long unused_data_addr_1285 = mir_set_data_uint(202901360L);
long unused_data_addr_1286 = mir_set_data_uint(2056L);
long unused_data_addr_1287 = mir_set_data_uint(267386880L);
long unused_data_addr_1288 = mir_set_data_uint(135792656L);
long unused_data_addr_1289 = mir_set_data_uint(135268376L);
long unused_data_addr_1290 = mir_set_data_uint(168822800L);
long unused_data_addr_1291 = mir_set_data_uint(135792656L);
long unused_data_addr_1292 = mir_set_data_uint(135268376L);
long unused_data_addr_1293 = mir_set_data_uint(135268368L);
long unused_data_addr_1294 = mir_set_data_uint(8184L);
long unused_data_addr_1295 = mir_set_data_uint(267386880L);
long unused_data_addr_1296 = mir_set_data_uint(135268368L);
long unused_data_addr_1297 = mir_set_data_uint(135268368L);
long unused_data_addr_1298 = mir_set_data_uint(269484048L);
long unused_data_addr_1299 = mir_set_data_uint(1334845456L);
long unused_data_addr_1300 = mir_set_data_uint(269492240L);
long unused_data_addr_1301 = mir_set_data_uint(135266320L);
long unused_data_addr_1302 = mir_set_data_uint(4080L);
long unused_data_addr_1303 = mir_set_data_uint(262144L);
long unused_data_addr_1304 = mir_set_data_uint(2031630L);
long unused_data_addr_1305 = mir_set_data_uint(250871812L);
long unused_data_addr_1306 = mir_set_data_uint(317985412L);
long unused_data_addr_1307 = mir_set_data_uint(250876436L);
long unused_data_addr_1308 = mir_set_data_uint(268697604L);
long unused_data_addr_1309 = mir_set_data_uint(2147233796L);
long unused_data_addr_1310 = mir_set_data_uint(268447744L);
long unused_data_addr_1311 = mir_set_data_uint(2013528064L);
long unused_data_addr_1312 = mir_set_data_uint(1344233486L);
long unused_data_addr_1313 = mir_set_data_uint(250888196L);
long unused_data_addr_1314 = mir_set_data_uint(317985412L);
long unused_data_addr_1315 = mir_set_data_uint(250876548L);
long unused_data_addr_1316 = mir_set_data_uint(269746180L);
long unused_data_addr_1317 = mir_set_data_uint(2147233804L);
long unused_data_addr_1318 = mir_set_data_uint(268447744L);
long unused_data_addr_1319 = mir_set_data_uint(2145386496L);
long unused_data_addr_1320 = mir_set_data_uint(1344823344L);
long unused_data_addr_1321 = mir_set_data_uint(1207846916L);
long unused_data_addr_1322 = mir_set_data_uint(1143096322L);
long unused_data_addr_1323 = mir_set_data_uint(1143096354L);
long unused_data_addr_1324 = mir_set_data_uint(605189602L);
long unused_data_addr_1325 = mir_set_data_uint(201724938L);
long unused_data_addr_1326 = mir_set_data_uint(2046L);
long unused_data_addr_1327 = mir_set_data_uint(2145386496L);
long unused_data_addr_1328 = mir_set_data_uint(1610121200L);
long unused_data_addr_1329 = mir_set_data_uint(1207848956L);
long unused_data_addr_1330 = mir_set_data_uint(1143096322L);
long unused_data_addr_1331 = mir_set_data_uint(1143096354L);
long unused_data_addr_1332 = mir_set_data_uint(605189602L);
long unused_data_addr_1333 = mir_set_data_uint(201724938L);
long unused_data_addr_1334 = mir_set_data_uint(2046L);
long unused_data_addr_1335 = mir_set_data_uint(2145386496L);
long unused_data_addr_1336 = mir_set_data_uint(1345871920L);
long unused_data_addr_1337 = mir_set_data_uint(1207846972L);
long unused_data_addr_1338 = mir_set_data_uint(1144931390L);
long unused_data_addr_1339 = mir_set_data_uint(1144931390L);
long unused_data_addr_1340 = mir_set_data_uint(605976062L);
long unused_data_addr_1341 = mir_set_data_uint(201724942L);
long unused_data_addr_1342 = mir_set_data_uint(2046L);
long unused_data_addr_1343 = mir_set_data_uint(2145386496L);
long unused_data_addr_1344 = mir_set_data_uint(1344823344L);
long unused_data_addr_1345 = mir_set_data_uint(1207846916L);
long unused_data_addr_1346 = mir_set_data_uint(1207846910L);
long unused_data_addr_1347 = mir_set_data_uint(1207846910L);
long unused_data_addr_1348 = mir_set_data_uint(670988286L);
long unused_data_addr_1349 = mir_set_data_uint(268310526L);
long unused_data_addr_1350 = mir_set_data_uint(2046L);
long unused_data_addr_1351 = mir_set_data_uint(2145386496L);
long unused_data_addr_1352 = mir_set_data_uint(1344823344L);
long unused_data_addr_1353 = mir_set_data_uint(1207846916L);
long unused_data_addr_1354 = mir_set_data_uint(1143096322L);
long unused_data_addr_1355 = mir_set_data_uint(1143096354L);
long unused_data_addr_1356 = mir_set_data_uint(1072857058L);
long unused_data_addr_1357 = mir_set_data_uint(268312570L);
long unused_data_addr_1358 = mir_set_data_uint(2046L);
long unused_data_addr_1359 = mir_set_data_uint(2145386496L);
long unused_data_addr_1360 = mir_set_data_uint(1881694256L);
long unused_data_addr_1361 = mir_set_data_uint(2147383300L);
long unused_data_addr_1362 = mir_set_data_uint(2082634754L);
long unused_data_addr_1363 = mir_set_data_uint(2082634786L);
long unused_data_addr_1364 = mir_set_data_uint(1007844834L);
long unused_data_addr_1365 = mir_set_data_uint(201726986L);
long unused_data_addr_1366 = mir_set_data_uint(2046L);
long unused_data_addr_1367 = mir_set_data_uint(2145386496L);
long unused_data_addr_1368 = mir_set_data_uint(2145943536L);
long unused_data_addr_1369 = mir_set_data_uint(2147385316L);
long unused_data_addr_1370 = mir_set_data_uint(2145550306L);
long unused_data_addr_1371 = mir_set_data_uint(2145550306L);
long unused_data_addr_1372 = mir_set_data_uint(605192162L);
long unused_data_addr_1373 = mir_set_data_uint(201724938L);
long unused_data_addr_1374 = mir_set_data_uint(2046L);
long unused_data_addr_1375 = mir_set_data_uint(0L);
long unused_data_addr_1376 = mir_set_data_uint(704787454L);
long unused_data_addr_1377 = mir_set_data_uint(570566146L);
long unused_data_addr_1378 = mir_set_data_uint(570565122L);
long unused_data_addr_1379 = mir_set_data_uint(704783874L);
long unused_data_addr_1380 = mir_set_data_uint(10499070L);
long unused_data_addr_1381 = mir_set_data_uint(34078992L);
long unused_data_addr_1382 = mir_set_data_uint(0L);
long unused_data_addr_1383 = mir_set_data_uint(0L);
long unused_data_addr_1384 = mir_set_data_uint(537673724L);
long unused_data_addr_1385 = mir_set_data_uint(786444L);
long unused_data_addr_1386 = mir_set_data_uint(1073479692L);
long unused_data_addr_1387 = mir_set_data_uint(805318656L);
long unused_data_addr_1388 = mir_set_data_uint(805318656L);
long unused_data_addr_1389 = mir_set_data_uint(1073491972L);
long unused_data_addr_1390 = mir_set_data_uint(0L);
long unused_data_addr_1391 = mir_set_data_uint(0L);
long unused_data_addr_1392 = mir_set_data_uint(2228286L);
long unused_data_addr_1393 = mir_set_data_uint(19005922L);
long unused_data_addr_1394 = mir_set_data_uint(16777534L);
long unused_data_addr_1395 = mir_set_data_uint(16777472L);
long unused_data_addr_1396 = mir_set_data_uint(2030043392L);
long unused_data_addr_1397 = mir_set_data_uint(1325418752L);
long unused_data_addr_1398 = mir_set_data_uint(30720L);
long unused_data_addr_1399 = mir_set_data_uint(0L);
long unused_data_addr_1400 = mir_set_data_uint(1140882432L);
long unused_data_addr_1401 = mir_set_data_uint(1157645824L);
long unused_data_addr_1402 = mir_set_data_uint(6454462L);
long unused_data_addr_1403 = mir_set_data_uint(6422562L);
long unused_data_addr_1404 = mir_set_data_uint(1157659838L);
long unused_data_addr_1405 = mir_set_data_uint(1140868608L);
long unused_data_addr_1406 = mir_set_data_uint(31744L);
long unused_data_addr_1407 = mir_set_data_uint(0L);
long unused_data_addr_1408 = mir_set_data_uint(4456572L);
long unused_data_addr_1409 = mir_set_data_uint(1048700L);
long unused_data_addr_1410 = mir_set_data_uint(1058013200L);
long unused_data_addr_1411 = mir_set_data_uint(1058021872L);
long unused_data_addr_1412 = mir_set_data_uint(1058013200L);
long unused_data_addr_1413 = mir_set_data_uint(1056973296L);
long unused_data_addr_1414 = mir_set_data_uint(0L);
long unused_data_addr_1415 = mir_set_data_uint(0L);
long unused_data_addr_1416 = mir_set_data_uint(4456572L);
long unused_data_addr_1417 = mir_set_data_uint(4456516L);
long unused_data_addr_1418 = mir_set_data_uint(1048700L);
long unused_data_addr_1419 = mir_set_data_uint(1048592L);
long unused_data_addr_1420 = mir_set_data_uint(1141931024L);
long unused_data_addr_1421 = mir_set_data_uint(1140869104L);
long unused_data_addr_1422 = mir_set_data_uint(31744L);
long unused_data_addr_1423 = mir_set_data_uint(0L);
long unused_data_addr_1424 = mir_set_data_uint(4456572L);
long unused_data_addr_1425 = mir_set_data_uint(4456516L);
long unused_data_addr_1426 = mir_set_data_uint(124L);
long unused_data_addr_1427 = mir_set_data_uint(16L);
long unused_data_addr_1428 = mir_set_data_uint(1140882448L);
long unused_data_addr_1429 = mir_set_data_uint(1140868432L);
long unused_data_addr_1430 = mir_set_data_uint(31744L);
long unused_data_addr_1431 = mir_set_data_uint(44040192L);
long unused_data_addr_1432 = mir_set_data_uint(581189628L);
long unused_data_addr_1433 = mir_set_data_uint(537141252L);
long unused_data_addr_1434 = mir_set_data_uint(537145332L);
long unused_data_addr_1435 = mir_set_data_uint(537145332L);
long unused_data_addr_1436 = mir_set_data_uint(537145332L);
long unused_data_addr_1437 = mir_set_data_uint(537141252L);
long unused_data_addr_1438 = mir_set_data_uint(16380L);
long unused_data_addr_1439 = mir_set_data_uint(1073479680L);
long unused_data_addr_1440 = mir_set_data_uint(537141252L);
long unused_data_addr_1441 = mir_set_data_uint(610150340L);
long unused_data_addr_1442 = mir_set_data_uint(667165764L);
long unused_data_addr_1443 = mir_set_data_uint(537141278L);
long unused_data_addr_1444 = mir_set_data_uint(538845188L);
long unused_data_addr_1445 = mir_set_data_uint(537141252L);
long unused_data_addr_1446 = mir_set_data_uint(16380L);
long unused_data_addr_1447 = mir_set_data_uint(0L);
long unused_data_addr_1448 = mir_set_data_uint(132120576L);
long unused_data_addr_1449 = mir_set_data_uint(69207072L);
long unused_data_addr_1450 = mir_set_data_uint(606355452L);
long unused_data_addr_1451 = mir_set_data_uint(606348324L);
long unused_data_addr_1452 = mir_set_data_uint(606348324L);
long unused_data_addr_1453 = mir_set_data_uint(1073488932L);
long unused_data_addr_1454 = mir_set_data_uint(0L);
long unused_data_addr_1455 = mir_set_data_uint(0L);
long unused_data_addr_1456 = mir_set_data_uint(266338304L);
long unused_data_addr_1457 = mir_set_data_uint(136316960L);
long unused_data_addr_1458 = mir_set_data_uint(1074036732L);
long unused_data_addr_1459 = mir_set_data_uint(2147243348L);
long unused_data_addr_1460 = mir_set_data_uint(1074025812L);
long unused_data_addr_1461 = mir_set_data_uint(2147237892L);
long unused_data_addr_1462 = mir_set_data_uint(0L);
long unused_data_addr_1463 = mir_set_data_uint(0L);
long unused_data_addr_1464 = mir_set_data_uint(537149436L);
long unused_data_addr_1465 = mir_set_data_uint(1073487876L);
long unused_data_addr_1466 = mir_set_data_uint(331878408L);
long unused_data_addr_1467 = mir_set_data_uint(268964808L);
long unused_data_addr_1468 = mir_set_data_uint(268963848L);
long unused_data_addr_1469 = mir_set_data_uint(536350728L);
long unused_data_addr_1470 = mir_set_data_uint(0L);
long unused_data_addr_1471 = mir_set_data_uint(0L);
long unused_data_addr_1472 = mir_set_data_uint(1073905662L);
long unused_data_addr_1473 = mir_set_data_uint(1610244090L);
long unused_data_addr_1474 = mir_set_data_uint(1610244090L);
long unused_data_addr_1475 = mir_set_data_uint(1073897466L);
long unused_data_addr_1476 = mir_set_data_uint(62947326L);
long unused_data_addr_1477 = mir_set_data_uint(536354808L);
long unused_data_addr_1478 = mir_set_data_uint(0L);
long unused_data_addr_1479 = mir_set_data_uint(267386880L);
long unused_data_addr_1480 = mir_set_data_uint(1811841022L);
long unused_data_addr_1481 = mir_set_data_uint(2147385342L);
long unused_data_addr_1482 = mir_set_data_uint(1746305022L);
long unused_data_addr_1483 = mir_set_data_uint(135292950L);
long unused_data_addr_1484 = mir_set_data_uint(135268368L);
long unused_data_addr_1485 = mir_set_data_uint(267388944L);
long unused_data_addr_1486 = mir_set_data_uint(0L);
long unused_data_addr_1487 = mir_set_data_uint(1073217536L);
long unused_data_addr_1488 = mir_set_data_uint(4294844424L);
long unused_data_addr_1489 = mir_set_data_uint(2265612290L);
long unused_data_addr_1490 = mir_set_data_uint(2420803722L);
long unused_data_addr_1491 = mir_set_data_uint(2420805706L);
long unused_data_addr_1492 = mir_set_data_uint(2265614474L);
long unused_data_addr_1493 = mir_set_data_uint(4294868994L);
long unused_data_addr_1494 = mir_set_data_uint(0L);
long unused_data_addr_1495 = mir_set_data_uint(264241152L);
long unused_data_addr_1496 = mir_set_data_uint(4244507864L);
long unused_data_addr_1497 = mir_set_data_uint(2147680254L);
long unused_data_addr_1498 = mir_set_data_uint(2218951554L);
long unused_data_addr_1499 = mir_set_data_uint(2218951746L);
long unused_data_addr_1500 = mir_set_data_uint(2147648386L);
long unused_data_addr_1501 = mir_set_data_uint(4294868994L);
long unused_data_addr_1502 = mir_set_data_uint(0L);
long unused_data_addr_1503 = mir_set_data_uint(0L);
long unused_data_addr_1504 = mir_set_data_uint(37749120L);
long unused_data_addr_1505 = mir_set_data_uint(135267360L);
long unused_data_addr_1506 = mir_set_data_uint(537137160L);
long unused_data_addr_1507 = mir_set_data_uint(600055812L);
long unused_data_addr_1508 = mir_set_data_uint(574890564L);
long unused_data_addr_1509 = mir_set_data_uint(1073488452L);
long unused_data_addr_1510 = mir_set_data_uint(0L);
long unused_data_addr_1511 = mir_set_data_uint(0L);
long unused_data_addr_1512 = mir_set_data_uint(477102080L);
long unused_data_addr_1513 = mir_set_data_uint(1073233656L);
long unused_data_addr_1514 = mir_set_data_uint(1073233912L);
long unused_data_addr_1515 = mir_set_data_uint(266346480L);
long unused_data_addr_1516 = mir_set_data_uint(58722240L);
long unused_data_addr_1517 = mir_set_data_uint(256L);
long unused_data_addr_1518 = mir_set_data_uint(0L);
long unused_data_addr_1519 = mir_set_data_uint(0L);
long unused_data_addr_1520 = mir_set_data_uint(0L);
long unused_data_addr_1521 = mir_set_data_uint(0L);
long unused_data_addr_1522 = mir_set_data_uint(0L);
long unused_data_addr_1523 = mir_set_data_uint(0L);
long unused_data_addr_1524 = mir_set_data_uint(0L);
long unused_data_addr_1525 = mir_set_data_uint(2147483648L);
long unused_data_addr_1526 = mir_set_data_uint(3758145536L);
long unused_data_addr_1527 = mir_set_data_uint(0L);
long unused_data_addr_1528 = mir_set_data_uint(335551488L);
long unused_data_addr_1529 = mir_set_data_uint(364909568L);
long unused_data_addr_1530 = mir_set_data_uint(356521280L);
long unused_data_addr_1531 = mir_set_data_uint(358356288L);
long unused_data_addr_1532 = mir_set_data_uint(357832020L);
long unused_data_addr_1533 = mir_set_data_uint(500962644L);
long unused_data_addr_1534 = mir_set_data_uint(0L);
long unused_data_addr_1535 = mir_set_data_uint(0L);
long unused_data_addr_1536 = mir_set_data_uint(50332416L);
long unused_data_addr_1537 = mir_set_data_uint(452991744L);
long unused_data_addr_1538 = mir_set_data_uint(459283296L);
long unused_data_addr_1539 = mir_set_data_uint(460069728L);
long unused_data_addr_1540 = mir_set_data_uint(460069740L);
long unused_data_addr_1541 = mir_set_data_uint(460069740L);
long unused_data_addr_1542 = mir_set_data_uint(0L);
long unused_data_addr_1543 = mir_set_data_uint(0L);
long unused_data_addr_1544 = mir_set_data_uint(0L);
long unused_data_addr_1545 = mir_set_data_uint(1077837822L);
long unused_data_addr_1546 = mir_set_data_uint(2147369022L);
long unused_data_addr_1547 = mir_set_data_uint(2147352576L);
long unused_data_addr_1548 = mir_set_data_uint(1140737022L);
long unused_data_addr_1549 = mir_set_data_uint(32766L);
long unused_data_addr_1550 = mir_set_data_uint(0L);
long unused_data_addr_1551 = mir_set_data_uint(2147221504L);
long unused_data_addr_1552 = mir_set_data_uint(1132740612L);
long unused_data_addr_1553 = mir_set_data_uint(1132741252L);
long unused_data_addr_1554 = mir_set_data_uint(1132740612L);
long unused_data_addr_1555 = mir_set_data_uint(1115964036L);
long unused_data_addr_1556 = mir_set_data_uint(1115964036L);
long unused_data_addr_1557 = mir_set_data_uint(1074021252L);
long unused_data_addr_1558 = mir_set_data_uint(32764L);
long unused_data_addr_1559 = mir_set_data_uint(1073774592L);
long unused_data_addr_1560 = mir_set_data_uint(268443648L);
long unused_data_addr_1561 = mir_set_data_uint(67110912L);
long unused_data_addr_1562 = mir_set_data_uint(16777728L);
long unused_data_addr_1563 = mir_set_data_uint(4194432L);
long unused_data_addr_1564 = mir_set_data_uint(1048608L);
long unused_data_addr_1565 = mir_set_data_uint(262152L);
long unused_data_addr_1566 = mir_set_data_uint(65538L);
long unused_data_addr_1567 = mir_set_data_uint(0L);
long unused_data_addr_1568 = mir_set_data_uint(535830512L);
long unused_data_addr_1569 = mir_set_data_uint(405805104L);
long unused_data_addr_1570 = mir_set_data_uint(520099888L);
long unused_data_addr_1571 = mir_set_data_uint(50339584L);
long unused_data_addr_1572 = mir_set_data_uint(768L);
long unused_data_addr_1573 = mir_set_data_uint(50332416L);
long unused_data_addr_1574 = mir_set_data_uint(0L);
long unused_data_addr_1575 = mir_set_data_uint(1072693248L);
long unused_data_addr_1576 = mir_set_data_uint(716977488L);
long unused_data_addr_1577 = mir_set_data_uint(715928916L);
long unused_data_addr_1578 = mir_set_data_uint(715928916L);
long unused_data_addr_1579 = mir_set_data_uint(715928916L);
long unused_data_addr_1580 = mir_set_data_uint(715928916L);
long unused_data_addr_1581 = mir_set_data_uint(715928916L);
long unused_data_addr_1582 = mir_set_data_uint(16380L);
long unused_data_addr_1583 = mir_set_data_uint(1072693248L);
long unused_data_addr_1584 = mir_set_data_uint(538714128L);
long unused_data_addr_1585 = mir_set_data_uint(574890372L);
long unused_data_addr_1586 = mir_set_data_uint(672408612L);
long unused_data_addr_1587 = mir_set_data_uint(697575444L);
long unused_data_addr_1588 = mir_set_data_uint(804530580L);
long unused_data_addr_1589 = mir_set_data_uint(537141252L);
long unused_data_addr_1590 = mir_set_data_uint(16380L);
long unused_data_addr_1591 = mir_set_data_uint(134086656L);
long unused_data_addr_1592 = mir_set_data_uint(67240962L);
long unused_data_addr_1593 = mir_set_data_uint(2145518594L);
long unused_data_addr_1594 = mir_set_data_uint(1143096354L);
long unused_data_addr_1595 = mir_set_data_uint(1143096354L);
long unused_data_addr_1596 = mir_set_data_uint(1075857406L);
long unused_data_addr_1597 = mir_set_data_uint(1075855392L);
long unused_data_addr_1598 = mir_set_data_uint(32736L);
long unused_data_addr_1599 = mir_set_data_uint(134086656L);
long unused_data_addr_1600 = mir_set_data_uint(67240962L);
long unused_data_addr_1601 = mir_set_data_uint(2080506882L);
long unused_data_addr_1602 = mir_set_data_uint(1140999170L);
long unused_data_addr_1603 = mir_set_data_uint(1140999170L);
long unused_data_addr_1604 = mir_set_data_uint(1075857406L);
long unused_data_addr_1605 = mir_set_data_uint(1075855392L);
long unused_data_addr_1606 = mir_set_data_uint(32736L);
long unused_data_addr_1607 = mir_set_data_uint(0L);
long unused_data_addr_1608 = mir_set_data_uint(1073905662L);
long unused_data_addr_1609 = mir_set_data_uint(2147368962L);
long unused_data_addr_1610 = mir_set_data_uint(1073889282L);
long unused_data_addr_1611 = mir_set_data_uint(1073889282L);
long unused_data_addr_1612 = mir_set_data_uint(1073889282L);
long unused_data_addr_1613 = mir_set_data_uint(2147368962L);
long unused_data_addr_1614 = mir_set_data_uint(0L);
long unused_data_addr_1615 = mir_set_data_uint(152043520L);
long unused_data_addr_1616 = mir_set_data_uint(166725904L);
long unused_data_addr_1617 = mir_set_data_uint(152045840L);
long unused_data_addr_1618 = mir_set_data_uint(2320L);
long unused_data_addr_1619 = mir_set_data_uint(614627230L);
long unused_data_addr_1620 = mir_set_data_uint(664937634L);
long unused_data_addr_1621 = mir_set_data_uint(1889411234L);
long unused_data_addr_1622 = mir_set_data_uint(0L);
long unused_data_addr_1623 = mir_set_data_uint(1072693248L);
long unused_data_addr_1624 = mir_set_data_uint(538714128L);
long unused_data_addr_1625 = mir_set_data_uint(713305732L);
long unused_data_addr_1626 = mir_set_data_uint(780413572L);
long unused_data_addr_1627 = mir_set_data_uint(732176388L);
long unused_data_addr_1628 = mir_set_data_uint(715401892L);
long unused_data_addr_1629 = mir_set_data_uint(537144228L);
long unused_data_addr_1630 = mir_set_data_uint(16380L);
long unused_data_addr_1631 = mir_set_data_uint(0L);
long unused_data_addr_1632 = mir_set_data_uint(0L);
long unused_data_addr_1633 = mir_set_data_uint(1179666L);
long unused_data_addr_1634 = mir_set_data_uint(1247693778L);
long unused_data_addr_1635 = mir_set_data_uint(1213346770L);
long unused_data_addr_1636 = mir_set_data_uint(19410L);
long unused_data_addr_1637 = mir_set_data_uint(0L);
long unused_data_addr_1638 = mir_set_data_uint(0L);
long unused_data_addr_1639 = mir_set_data_uint(25165824L);
long unused_data_addr_1640 = mir_set_data_uint(941360736L);
long unused_data_addr_1641 = mir_set_data_uint(600055812L);
long unused_data_addr_1642 = mir_set_data_uint(600055876L);
long unused_data_addr_1643 = mir_set_data_uint(331883012L);
long unused_data_addr_1644 = mir_set_data_uint(135270408L);
long unused_data_addr_1645 = mir_set_data_uint(37749792L);
long unused_data_addr_1646 = mir_set_data_uint(384L);
long unused_data_addr_1647 = mir_set_data_uint(8257536L);
long unused_data_addr_1648 = mir_set_data_uint(537018306L);
long unused_data_addr_1649 = mir_set_data_uint(1076002786L);
long unused_data_addr_1650 = mir_set_data_uint(1074413626L);
long unused_data_addr_1651 = mir_set_data_uint(1074413578L);
long unused_data_addr_1652 = mir_set_data_uint(1074413578L);
long unused_data_addr_1653 = mir_set_data_uint(1074282510L);
long unused_data_addr_1654 = mir_set_data_uint(32760L);
long unused_data_addr_1655 = mir_set_data_uint(0L);
long unused_data_addr_1656 = mir_set_data_uint(4325502L);
long unused_data_addr_1657 = mir_set_data_uint(1073905602L);
long unused_data_addr_1658 = mir_set_data_uint(1140998146L);
long unused_data_addr_1659 = mir_set_data_uint(1593984002L);
long unused_data_addr_1660 = mir_set_data_uint(1140999170L);
long unused_data_addr_1661 = mir_set_data_uint(2147368962L);
long unused_data_addr_1662 = mir_set_data_uint(0L);
long unused_data_addr_1663 = mir_set_data_uint(1143078912L);
long unused_data_addr_1664 = mir_set_data_uint(306717252L);
long unused_data_addr_1665 = mir_set_data_uint(4090429440L);
long unused_data_addr_1666 = mir_set_data_uint(338166816L);
long unused_data_addr_1667 = mir_set_data_uint(1209148452L);
long unused_data_addr_1668 = mir_set_data_uint(135268368L);
long unused_data_addr_1669 = mir_set_data_uint(536350728L);
long unused_data_addr_1670 = mir_set_data_uint(62915616L);
long unused_data_addr_1671 = mir_set_data_uint(178257920L);
long unused_data_addr_1672 = mir_set_data_uint(536349344L);
long unused_data_addr_1673 = mir_set_data_uint(275279886L);
long unused_data_addr_1674 = mir_set_data_uint(268988526L);
long unused_data_addr_1675 = mir_set_data_uint(268988430L);
long unused_data_addr_1676 = mir_set_data_uint(268988430L);
long unused_data_addr_1677 = mir_set_data_uint(178266104L);
long unused_data_addr_1678 = mir_set_data_uint(2720L);
long unused_data_addr_1679 = mir_set_data_uint(132120576L);
long unused_data_addr_1680 = mir_set_data_uint(69213624L);
long unused_data_addr_1681 = mir_set_data_uint(77601848L);
long unused_data_addr_1682 = mir_set_data_uint(77602104L);
long unused_data_addr_1683 = mir_set_data_uint(77602104L);
long unused_data_addr_1684 = mir_set_data_uint(77602104L);
long unused_data_addr_1685 = mir_set_data_uint(69213496L);
long unused_data_addr_1686 = mir_set_data_uint(2016L);
long unused_data_addr_1687 = mir_set_data_uint(0L);
long unused_data_addr_1688 = mir_set_data_uint(62914560L);
long unused_data_addr_1689 = mir_set_data_uint(1010315248L);
long unused_data_addr_1690 = mir_set_data_uint(1006909452L);
long unused_data_addr_1691 = mir_set_data_uint(25165824L);
long unused_data_addr_1692 = mir_set_data_uint(62915520L);
long unused_data_addr_1693 = mir_set_data_uint(384L);
long unused_data_addr_1694 = mir_set_data_uint(0L);
long unused_data_addr_1695 = mir_set_data_uint(25165824L);
long unused_data_addr_1696 = mir_set_data_uint(25166208L);
long unused_data_addr_1697 = mir_set_data_uint(25166208L);
long unused_data_addr_1698 = mir_set_data_uint(62916576L);
long unused_data_addr_1699 = mir_set_data_uint(384L);
long unused_data_addr_1700 = mir_set_data_uint(25165824L);
long unused_data_addr_1701 = mir_set_data_uint(62915520L);
long unused_data_addr_1702 = mir_set_data_uint(384L);
long unused_data_addr_1703 = mir_set_data_uint(25165824L);
long unused_data_addr_1704 = mir_set_data_uint(132121536L);
long unused_data_addr_1705 = mir_set_data_uint(25166208L);
long unused_data_addr_1706 = mir_set_data_uint(25166208L);
long unused_data_addr_1707 = mir_set_data_uint(384L);
long unused_data_addr_1708 = mir_set_data_uint(25165824L);
long unused_data_addr_1709 = mir_set_data_uint(62915520L);
long unused_data_addr_1710 = mir_set_data_uint(384L);
long unused_data_addr_1711 = mir_set_data_uint(0L);
long unused_data_addr_1712 = mir_set_data_uint(267387840L);
long unused_data_addr_1713 = mir_set_data_uint(404495412L);
long unused_data_addr_1714 = mir_set_data_uint(809250844L);
long unused_data_addr_1715 = mir_set_data_uint(805318656L);
long unused_data_addr_1716 = mir_set_data_uint(472913920L);
long unused_data_addr_1717 = mir_set_data_uint(62918640L);
long unused_data_addr_1718 = mir_set_data_uint(0L);
long unused_data_addr_1719 = mir_set_data_uint(0L);
long unused_data_addr_1720 = mir_set_data_uint(0L);
long unused_data_addr_1721 = mir_set_data_uint(132121536L);
long unused_data_addr_1722 = mir_set_data_uint(267390960L);
long unused_data_addr_1723 = mir_set_data_uint(267390960L);
long unused_data_addr_1724 = mir_set_data_uint(62916576L);
long unused_data_addr_1725 = mir_set_data_uint(0L);
long unused_data_addr_1726 = mir_set_data_uint(0L);
long unused_data_addr_1727 = mir_set_data_uint(0L);
long unused_data_addr_1728 = mir_set_data_uint(0L);
long unused_data_addr_1729 = mir_set_data_uint(69206976L);
long unused_data_addr_1730 = mir_set_data_uint(135268368L);
long unused_data_addr_1731 = mir_set_data_uint(135268368L);
long unused_data_addr_1732 = mir_set_data_uint(62915616L);
long unused_data_addr_1733 = mir_set_data_uint(0L);
long unused_data_addr_1734 = mir_set_data_uint(0L);
long unused_data_addr_1735 = mir_set_data_uint(0L);
long unused_data_addr_1736 = mir_set_data_uint(0L);
long unused_data_addr_1737 = mir_set_data_uint(536354808L);
long unused_data_addr_1738 = mir_set_data_uint(536346624L);
long unused_data_addr_1739 = mir_set_data_uint(8184L);
long unused_data_addr_1740 = mir_set_data_uint(536354808L);
long unused_data_addr_1741 = mir_set_data_uint(0L);
long unused_data_addr_1742 = mir_set_data_uint(0L);
long unused_data_addr_1743 = mir_set_data_uint(0L);
long unused_data_addr_1744 = mir_set_data_uint(0L);
long unused_data_addr_1745 = mir_set_data_uint(8913008L);
long unused_data_addr_1746 = mir_set_data_uint(210239624L);
long unused_data_addr_1747 = mir_set_data_uint(512233720L);
long unused_data_addr_1748 = mir_set_data_uint(1049105032L);
long unused_data_addr_1749 = mir_set_data_uint(0L);
long unused_data_addr_1750 = mir_set_data_uint(0L);
long unused_data_addr_1751 = mir_set_data_uint(0L);
long unused_data_addr_1752 = mir_set_data_uint(33554432L);
long unused_data_addr_1753 = mir_set_data_uint(117443200L);
long unused_data_addr_1754 = mir_set_data_uint(117448640L);
long unused_data_addr_1755 = mir_set_data_uint(33557120L);
long unused_data_addr_1756 = mir_set_data_uint(3145776L);
long unused_data_addr_1757 = mir_set_data_uint(0L);
long unused_data_addr_1758 = mir_set_data_uint(0L);
long unused_data_addr_1759 = mir_set_data_uint(0L);
long unused_data_addr_1760 = mir_set_data_uint(0L);
long unused_data_addr_1761 = mir_set_data_uint(0L);
long unused_data_addr_1762 = mir_set_data_uint(0L);
long unused_data_addr_1763 = mir_set_data_uint(0L);
long unused_data_addr_1764 = mir_set_data_uint(0L);
long unused_data_addr_1765 = mir_set_data_uint(0L);
long unused_data_addr_1766 = mir_set_data_uint(0L);
long unused_data_addr_1767 = mir_set_data_uint(0L);
long unused_data_addr_1768 = mir_set_data_uint(0L);
long unused_data_addr_1769 = mir_set_data_uint(0L);
long unused_data_addr_1770 = mir_set_data_uint(0L);
long unused_data_addr_1771 = mir_set_data_uint(0L);
long unused_data_addr_1772 = mir_set_data_uint(0L);
long unused_data_addr_1773 = mir_set_data_uint(0L);
long unused_data_addr_1774 = mir_set_data_uint(0L);
long unused_data_addr_1775 = mir_set_data_uint(0L);
long unused_data_addr_1776 = mir_set_data_uint(0L);
long unused_data_addr_1777 = mir_set_data_uint(0L);
long unused_data_addr_1778 = mir_set_data_uint(0L);
long unused_data_addr_1779 = mir_set_data_uint(0L);
long unused_data_addr_1780 = mir_set_data_uint(0L);
long unused_data_addr_1781 = mir_set_data_uint(0L);
long unused_data_addr_1782 = mir_set_data_uint(0L);
long unused_data_addr_1783 = mir_set_data_uint(0L);
long unused_data_addr_1784 = mir_set_data_uint(0L);
long unused_data_addr_1785 = mir_set_data_uint(0L);
long unused_data_addr_1786 = mir_set_data_uint(0L);
long unused_data_addr_1787 = mir_set_data_uint(0L);
long unused_data_addr_1788 = mir_set_data_uint(0L);
long unused_data_addr_1789 = mir_set_data_uint(0L);
long unused_data_addr_1790 = mir_set_data_uint(0L);
long unused_data_addr_1791 = mir_set_data_uint(0L);
long unused_data_addr_1792 = mir_set_data_uint(0L);
long unused_data_addr_1793 = mir_set_data_uint(0L);
long unused_data_addr_1794 = mir_set_data_uint(0L);
long unused_data_addr_1795 = mir_set_data_uint(0L);
long unused_data_addr_1796 = mir_set_data_uint(0L);
long unused_data_addr_1797 = mir_set_data_uint(0L);
long unused_data_addr_1798 = mir_set_data_uint(0L);
long unused_data_addr_1799 = mir_set_data_uint(0L);
long unused_data_addr_1800 = mir_set_data_uint(0L);
long unused_data_addr_1801 = mir_set_data_uint(0L);
long unused_data_addr_1802 = mir_set_data_uint(0L);
long unused_data_addr_1803 = mir_set_data_uint(0L);
long unused_data_addr_1804 = mir_set_data_uint(0L);
long unused_data_addr_1805 = mir_set_data_uint(0L);
long unused_data_addr_1806 = mir_set_data_uint(0L);
long unused_data_addr_1807 = mir_set_data_uint(0L);
long unused_data_addr_1808 = mir_set_data_uint(0L);
long unused_data_addr_1809 = mir_set_data_uint(0L);
long unused_data_addr_1810 = mir_set_data_uint(0L);
long unused_data_addr_1811 = mir_set_data_uint(0L);
long unused_data_addr_1812 = mir_set_data_uint(0L);
long unused_data_addr_1813 = mir_set_data_uint(0L);
long unused_data_addr_1814 = mir_set_data_uint(0L);
long unused_data_addr_1815 = mir_set_data_uint(0L);
long unused_data_addr_1816 = mir_set_data_uint(0L);
long unused_data_addr_1817 = mir_set_data_uint(0L);
long unused_data_addr_1818 = mir_set_data_uint(0L);
long unused_data_addr_1819 = mir_set_data_uint(0L);
long unused_data_addr_1820 = mir_set_data_uint(0L);
long unused_data_addr_1821 = mir_set_data_uint(0L);
long unused_data_addr_1822 = mir_set_data_uint(0L);
long unused_data_addr_1823 = mir_set_data_uint(0L);
long unused_data_addr_1824 = mir_set_data_uint(0L);
long unused_data_addr_1825 = mir_set_data_uint(0L);
long unused_data_addr_1826 = mir_set_data_uint(0L);
long unused_data_addr_1827 = mir_set_data_uint(0L);
long unused_data_addr_1828 = mir_set_data_uint(0L);
long unused_data_addr_1829 = mir_set_data_uint(0L);
long unused_data_addr_1830 = mir_set_data_uint(0L);
long unused_data_addr_1831 = mir_set_data_uint(0L);
long unused_data_addr_1832 = mir_set_data_uint(0L);
long unused_data_addr_1833 = mir_set_data_uint(0L);
long unused_data_addr_1834 = mir_set_data_uint(0L);
long unused_data_addr_1835 = mir_set_data_uint(0L);
long unused_data_addr_1836 = mir_set_data_uint(0L);
long unused_data_addr_1837 = mir_set_data_uint(0L);
long unused_data_addr_1838 = mir_set_data_uint(0L);
long unused_data_addr_1839 = mir_set_data_uint(0L);
long unused_data_addr_1840 = mir_set_data_uint(0L);
long unused_data_addr_1841 = mir_set_data_uint(0L);
long unused_data_addr_1842 = mir_set_data_uint(0L);
long unused_data_addr_1843 = mir_set_data_uint(0L);
long unused_data_addr_1844 = mir_set_data_uint(0L);
long unused_data_addr_1845 = mir_set_data_uint(0L);
long unused_data_addr_1846 = mir_set_data_uint(0L);
long unused_data_addr_1847 = mir_set_data_uint(0L);
long unused_data_addr_1848 = mir_set_data_uint(0L);
long unused_data_addr_1849 = mir_set_data_uint(0L);
long unused_data_addr_1850 = mir_set_data_uint(0L);
long unused_data_addr_1851 = mir_set_data_uint(0L);
long unused_data_addr_1852 = mir_set_data_uint(0L);
long unused_data_addr_1853 = mir_set_data_uint(0L);
long unused_data_addr_1854 = mir_set_data_uint(0L);
long unused_data_addr_1855 = mir_set_data_uint(0L);
long unused_data_addr_1856 = mir_set_data_uint(0L);
long unused_data_addr_1857 = mir_set_data_uint(0L);
long unused_data_addr_1858 = mir_set_data_uint(0L);
long unused_data_addr_1859 = mir_set_data_uint(0L);
long unused_data_addr_1860 = mir_set_data_uint(0L);
long unused_data_addr_1861 = mir_set_data_uint(0L);
long unused_data_addr_1862 = mir_set_data_uint(0L);
long unused_data_addr_1863 = mir_set_data_uint(0L);
long unused_data_addr_1864 = mir_set_data_uint(0L);
long unused_data_addr_1865 = mir_set_data_uint(0L);
long unused_data_addr_1866 = mir_set_data_uint(0L);
long unused_data_addr_1867 = mir_set_data_uint(0L);
long unused_data_addr_1868 = mir_set_data_uint(0L);
long unused_data_addr_1869 = mir_set_data_uint(0L);
long unused_data_addr_1870 = mir_set_data_uint(0L);
long unused_data_addr_1871 = mir_set_data_uint(0L);
long unused_data_addr_1872 = mir_set_data_uint(0L);
long unused_data_addr_1873 = mir_set_data_uint(0L);
long unused_data_addr_1874 = mir_set_data_uint(0L);
long unused_data_addr_1875 = mir_set_data_uint(0L);
long unused_data_addr_1876 = mir_set_data_uint(0L);
long unused_data_addr_1877 = mir_set_data_uint(0L);
long unused_data_addr_1878 = mir_set_data_uint(0L);
long unused_data_addr_1879 = mir_set_data_uint(0L);
long unused_data_addr_1880 = mir_set_data_uint(0L);
long unused_data_addr_1881 = mir_set_data_uint(0L);
long unused_data_addr_1882 = mir_set_data_uint(0L);
long unused_data_addr_1883 = mir_set_data_uint(0L);
long unused_data_addr_1884 = mir_set_data_uint(0L);
long unused_data_addr_1885 = mir_set_data_uint(0L);
long unused_data_addr_1886 = mir_set_data_uint(0L);
long unused_data_addr_1887 = mir_set_data_uint(0L);
long unused_data_addr_1888 = mir_set_data_uint(0L);
long unused_data_addr_1889 = mir_set_data_uint(0L);
long unused_data_addr_1890 = mir_set_data_uint(0L);
long unused_data_addr_1891 = mir_set_data_uint(0L);
long unused_data_addr_1892 = mir_set_data_uint(0L);
long unused_data_addr_1893 = mir_set_data_uint(0L);
long unused_data_addr_1894 = mir_set_data_uint(0L);
long unused_data_addr_1895 = mir_set_data_uint(0L);
long unused_data_addr_1896 = mir_set_data_uint(0L);
long unused_data_addr_1897 = mir_set_data_uint(0L);
long unused_data_addr_1898 = mir_set_data_uint(0L);
long unused_data_addr_1899 = mir_set_data_uint(0L);
long unused_data_addr_1900 = mir_set_data_uint(0L);
long unused_data_addr_1901 = mir_set_data_uint(0L);
long unused_data_addr_1902 = mir_set_data_uint(0L);
long unused_data_addr_1903 = mir_set_data_uint(0L);
long unused_data_addr_1904 = mir_set_data_uint(0L);
long unused_data_addr_1905 = mir_set_data_uint(0L);
long unused_data_addr_1906 = mir_set_data_uint(0L);
long unused_data_addr_1907 = mir_set_data_uint(0L);
long unused_data_addr_1908 = mir_set_data_uint(0L);
long unused_data_addr_1909 = mir_set_data_uint(0L);
long unused_data_addr_1910 = mir_set_data_uint(0L);
long unused_data_addr_1911 = mir_set_data_uint(0L);
long unused_data_addr_1912 = mir_set_data_uint(0L);
long unused_data_addr_1913 = mir_set_data_uint(0L);
long unused_data_addr_1914 = mir_set_data_uint(0L);
long unused_data_addr_1915 = mir_set_data_uint(0L);
long unused_data_addr_1916 = mir_set_data_uint(0L);
long unused_data_addr_1917 = mir_set_data_uint(0L);
long unused_data_addr_1918 = mir_set_data_uint(0L);
long unused_data_addr_1919 = mir_set_data_uint(0L);
long unused_data_addr_1920 = mir_set_data_uint(0L);
long unused_data_addr_1921 = mir_set_data_uint(0L);
long unused_data_addr_1922 = mir_set_data_uint(0L);
long unused_data_addr_1923 = mir_set_data_uint(0L);
long unused_data_addr_1924 = mir_set_data_uint(0L);
long unused_data_addr_1925 = mir_set_data_uint(0L);
long unused_data_addr_1926 = mir_set_data_uint(0L);
long unused_data_addr_1927 = mir_set_data_uint(0L);
long unused_data_addr_1928 = mir_set_data_uint(0L);
long unused_data_addr_1929 = mir_set_data_uint(0L);
long unused_data_addr_1930 = mir_set_data_uint(0L);
long unused_data_addr_1931 = mir_set_data_uint(0L);
long unused_data_addr_1932 = mir_set_data_uint(0L);
long unused_data_addr_1933 = mir_set_data_uint(0L);
long unused_data_addr_1934 = mir_set_data_uint(0L);
long unused_data_addr_1935 = mir_set_data_uint(0L);
long unused_data_addr_1936 = mir_set_data_uint(0L);
long unused_data_addr_1937 = mir_set_data_uint(0L);
long unused_data_addr_1938 = mir_set_data_uint(0L);
long unused_data_addr_1939 = mir_set_data_uint(0L);
long unused_data_addr_1940 = mir_set_data_uint(0L);
long unused_data_addr_1941 = mir_set_data_uint(0L);
long unused_data_addr_1942 = mir_set_data_uint(0L);
long unused_data_addr_1943 = mir_set_data_uint(0L);
long unused_data_addr_1944 = mir_set_data_uint(0L);
long unused_data_addr_1945 = mir_set_data_uint(0L);
long unused_data_addr_1946 = mir_set_data_uint(0L);
long unused_data_addr_1947 = mir_set_data_uint(0L);
long unused_data_addr_1948 = mir_set_data_uint(0L);
long unused_data_addr_1949 = mir_set_data_uint(0L);
long unused_data_addr_1950 = mir_set_data_uint(0L);
long unused_data_addr_1951 = mir_set_data_uint(0L);
long unused_data_addr_1952 = mir_set_data_uint(0L);
long unused_data_addr_1953 = mir_set_data_uint(0L);
long unused_data_addr_1954 = mir_set_data_uint(0L);
long unused_data_addr_1955 = mir_set_data_uint(0L);
long unused_data_addr_1956 = mir_set_data_uint(0L);
long unused_data_addr_1957 = mir_set_data_uint(0L);
long unused_data_addr_1958 = mir_set_data_uint(0L);
long unused_data_addr_1959 = mir_set_data_uint(0L);
long unused_data_addr_1960 = mir_set_data_uint(0L);
long unused_data_addr_1961 = mir_set_data_uint(0L);
long unused_data_addr_1962 = mir_set_data_uint(0L);
long unused_data_addr_1963 = mir_set_data_uint(0L);
long unused_data_addr_1964 = mir_set_data_uint(0L);
long unused_data_addr_1965 = mir_set_data_uint(0L);
long unused_data_addr_1966 = mir_set_data_uint(0L);
long unused_data_addr_1967 = mir_set_data_uint(0L);
long unused_data_addr_1968 = mir_set_data_uint(0L);
long unused_data_addr_1969 = mir_set_data_uint(0L);
long unused_data_addr_1970 = mir_set_data_uint(0L);
long unused_data_addr_1971 = mir_set_data_uint(0L);
long unused_data_addr_1972 = mir_set_data_uint(0L);
long unused_data_addr_1973 = mir_set_data_uint(0L);
long unused_data_addr_1974 = mir_set_data_uint(0L);
long unused_data_addr_1975 = mir_set_data_uint(0L);
long unused_data_addr_1976 = mir_set_data_uint(0L);
long unused_data_addr_1977 = mir_set_data_uint(0L);
long unused_data_addr_1978 = mir_set_data_uint(0L);
long unused_data_addr_1979 = mir_set_data_uint(0L);
long unused_data_addr_1980 = mir_set_data_uint(0L);
long unused_data_addr_1981 = mir_set_data_uint(0L);
long unused_data_addr_1982 = mir_set_data_uint(0L);
long unused_data_addr_1983 = mir_set_data_uint(0L);
long unused_data_addr_1984 = mir_set_data_uint(0L);
long unused_data_addr_1985 = mir_set_data_uint(0L);
long unused_data_addr_1986 = mir_set_data_uint(0L);
long unused_data_addr_1987 = mir_set_data_uint(0L);
long unused_data_addr_1988 = mir_set_data_uint(0L);
long unused_data_addr_1989 = mir_set_data_uint(0L);
long unused_data_addr_1990 = mir_set_data_uint(0L);
long unused_data_addr_1991 = mir_set_data_uint(0L);
long unused_data_addr_1992 = mir_set_data_uint(0L);
long unused_data_addr_1993 = mir_set_data_uint(0L);
long unused_data_addr_1994 = mir_set_data_uint(0L);
long unused_data_addr_1995 = mir_set_data_uint(0L);
long unused_data_addr_1996 = mir_set_data_uint(0L);
long unused_data_addr_1997 = mir_set_data_uint(0L);
long unused_data_addr_1998 = mir_set_data_uint(0L);
long unused_data_addr_1999 = mir_set_data_uint(0L);
long unused_data_addr_2000 = mir_set_data_uint(0L);
long unused_data_addr_2001 = mir_set_data_uint(0L);
long unused_data_addr_2002 = mir_set_data_uint(0L);
long unused_data_addr_2003 = mir_set_data_uint(0L);
long unused_data_addr_2004 = mir_set_data_uint(0L);
long unused_data_addr_2005 = mir_set_data_uint(0L);
long unused_data_addr_2006 = mir_set_data_uint(0L);
long unused_data_addr_2007 = mir_set_data_uint(0L);
long unused_data_addr_2008 = mir_set_data_uint(0L);
long unused_data_addr_2009 = mir_set_data_uint(0L);
long unused_data_addr_2010 = mir_set_data_uint(0L);
long unused_data_addr_2011 = mir_set_data_uint(0L);
long unused_data_addr_2012 = mir_set_data_uint(0L);
long unused_data_addr_2013 = mir_set_data_uint(0L);
long unused_data_addr_2014 = mir_set_data_uint(0L);
long unused_data_addr_2015 = mir_set_data_uint(0L);
long unused_data_addr_2016 = mir_set_data_uint(0L);
long unused_data_addr_2017 = mir_set_data_uint(0L);
long unused_data_addr_2018 = mir_set_data_uint(0L);
long unused_data_addr_2019 = mir_set_data_uint(0L);
long unused_data_addr_2020 = mir_set_data_uint(0L);
long unused_data_addr_2021 = mir_set_data_uint(0L);
long unused_data_addr_2022 = mir_set_data_uint(0L);
long unused_data_addr_2023 = mir_set_data_uint(0L);
long unused_data_addr_2024 = mir_set_data_uint(0L);
long unused_data_addr_2025 = mir_set_data_uint(0L);
long unused_data_addr_2026 = mir_set_data_uint(0L);
long unused_data_addr_2027 = mir_set_data_uint(0L);
long unused_data_addr_2028 = mir_set_data_uint(0L);
long unused_data_addr_2029 = mir_set_data_uint(0L);
long unused_data_addr_2030 = mir_set_data_uint(0L);
long unused_data_addr_2031 = mir_set_data_uint(0L);
long unused_data_addr_2032 = mir_set_data_uint(0L);
long unused_data_addr_2033 = mir_set_data_uint(0L);
long unused_data_addr_2034 = mir_set_data_uint(0L);
long unused_data_addr_2035 = mir_set_data_uint(0L);
long unused_data_addr_2036 = mir_set_data_uint(0L);
long unused_data_addr_2037 = mir_set_data_uint(0L);
long unused_data_addr_2038 = mir_set_data_uint(0L);
long unused_data_addr_2039 = mir_set_data_uint(0L);
long unused_data_addr_2040 = mir_set_data_uint(0L);
long unused_data_addr_2041 = mir_set_data_uint(0L);
long unused_data_addr_2042 = mir_set_data_uint(0L);
long unused_data_addr_2043 = mir_set_data_uint(0L);
long unused_data_addr_2044 = mir_set_data_uint(0L);
long unused_data_addr_2045 = mir_set_data_uint(0L);
long unused_data_addr_2046 = mir_set_data_uint(0L);
long unused_data_addr_2047 = mir_set_data_uint(0L);
long unused_data_addr_2048 = mir_set_data_uint(0L);
long unused_data_addr_2049 = mir_set_data_uint(0L);
long unused_data_addr_2050 = mir_set_data_uint(0L);
long unused_data_addr_2051 = mir_set_data_uint(0L);
long unused_data_addr_2052 = mir_set_data_uint(0L);
long unused_data_addr_2053 = mir_set_data_uint(0L);
long unused_data_addr_2054 = mir_set_data_uint(0L);
long unused_data_addr_2055 = mir_set_data_uint(0L);
long unused_data_addr_2056 = mir_set_data_uint(0L);
long unused_data_addr_2057 = mir_set_data_uint(0L);
long unused_data_addr_2058 = mir_set_data_uint(0L);
long unused_data_addr_2059 = mir_set_data_uint(0L);
long unused_data_addr_2060 = mir_set_data_uint(0L);
long unused_data_addr_2061 = mir_set_data_uint(0L);
long unused_data_addr_2062 = mir_set_data_uint(0L);
long unused_data_addr_2063 = mir_set_data_uint(0L);
long unused_data_addr_2064 = mir_set_data_uint(0L);
long unused_data_addr_2065 = mir_set_data_uint(0L);
long unused_data_addr_2066 = mir_set_data_uint(0L);
long unused_data_addr_2067 = mir_set_data_uint(0L);
long unused_data_addr_2068 = mir_set_data_uint(0L);
long unused_data_addr_2069 = mir_set_data_uint(0L);
long unused_data_addr_2070 = mir_set_data_uint(0L);
long m2_guiIconsPtr = mir_set_data_ref(m2_guiIcons + 0);
long m2_guiState = mir_set_data_int(0);
long m2_guiFont = mir_set_data_int(0);
long unused_data_addr_2071 = mir_allocate(44);
long m2_guiLocked = mir_set_data_int(0);
long m2_guiAlpha = mir_set_data_float(1f);
long m2_guiIconScale = mir_set_data_uint(1L);
long m2_guiStyle = mir_set_data_uint(0L);
long unused_data_addr_2072 = mir_allocate(1532);
long m2_guiStyleLoaded = mir_set_data_int(0);
long m2_codepointSize = mir_set_data_int(1);
public void GuiEnable () {
  long I_0 = 0;
  long i_1 = 0;
  long I_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  I_0 = m2_guiState;
  if ((int) mir_read_int(I_0) != (int) 3L) { mir_label = 892; break; }
case 893:
  I_2 = m2_guiState;
  mir_write_int(I_2, 0L);
  mir_label = 894; break;
case 892:
case 894:
  return;
} // End of switch
} // End of while
} // End of function GuiEnable

public void GuiDisable () {
  long I_0 = 0;
  long i_1 = 0;
  long I_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  I_0 = m2_guiState;
  if ((int) mir_read_int(I_0) != (int) 0L) { mir_label = 895; break; }
case 896:
  I_2 = m2_guiState;
  mir_write_int(I_2, 3L);
  mir_label = 897; break;
case 895:
case 897:
  return;
} // End of switch
} // End of while
} // End of function GuiDisable

public void GuiLock () {
  long I_0 = 0;
  I_0 = m2_guiLocked;
  mir_write_int(I_0, 1L);
  return;
} // End of function GuiLock

public void GuiUnlock () {
  long I_0 = 0;
  I_0 = m2_guiLocked;
  mir_write_int(I_0, 0L);
  return;
} // End of function GuiUnlock

public int GuiIsLocked () {
  long I_0 = 0;
  I_0 = m2_guiLocked;
  return (int) mir_read_int(I_0);
} // End of function GuiIsLocked

public void GuiFade (float f0_alpha) {
  long i_0 = 0;
  long i_1 = 0;
  long I_2 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  if (f0_alpha < 0f) { mir_label = 898; break; }
  mir_label = 899; break;
case 898:
  f0_alpha = 0f;
  mir_label = 900; break;
case 899:
  if (f0_alpha > 1f) { mir_label = 901; break; }
  mir_label = 902; break;
case 901:
  f0_alpha = 1f;
  mir_label = 903; break;
case 902:
case 903:
case 900:
  I_2 = m2_guiAlpha;
  mir_write_float(I_2, f0_alpha);
  return;
} // End of switch
} // End of while
} // End of function GuiFade

public void GuiSetState (int _i0_state) {
  long i0_state = _i0_state;
  long I_0 = 0;
  long i_1 = 0;
  I_0 = m2_guiState;
  i_1 = i0_state;
  mir_write_int(I_0, i_1);
  return;
} // End of function GuiSetState

public int GuiGetState () {
  long I_0 = 0;
  I_0 = m2_guiState;
  return (int) mir_read_int(I_0);
} // End of function GuiGetState

public void GuiSetFont (long _I0_font) {
  long I0_font = _I0_font;
  long fp = 0;
  long I_0 = 0;
  long i_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(48L);
  I_0 = memcpy((long) fp, (long) I0_font, (long) 48L);
  if (Integer.compareUnsigned((int) mir_read_uint(8L + fp), (int) 0L) <= 0) { mir_label = 904; break; }
case 905:
  I_2 = m2_guiStyleLoaded;
  if (((long) mir_read_int(I_2) != 0)) { mir_label = 906; break; }
case 907:
  GuiLoadStyleDefault();
  mir_label = 908; break;
case 906:
case 908:
  I_3 = m2_guiFont;
  I_4 = memcpy((long) I_3, (long) fp, (long) 48L);
  GuiSetStyle((int) 0L, (int) 16L, (int) mir_read_int(fp));
  mir_label = 909; break;
case 904:
case 909:
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiSetFont

public void GuiGetFont (long _Ret_Addr) {
  long Ret_Addr = _Ret_Addr;
  long I_0 = 0;
  long I_1 = 0;
  I_0 = m2_guiFont;
  I_1 = memcpy((long) Ret_Addr, (long) I_0, (long) 48L);
  return;
} // End of function GuiGetFont

public void GuiSetStyle (int _i0_control, int _i0_property, int _i0_value) {
  long i0_control = _i0_control;
  long i0_property = _i0_property;
  long i0_value = _i0_value;
  long I_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long i_3 = 0;
  long I_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long i2_i = 0;
  long i_7 = 0;
  long I_8 = 0;
  long i_9 = 0;
  long i_10 = 0;
  long I_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  I_0 = m2_guiStyleLoaded;
  if (((long) mir_read_int(I_0) != 0)) { mir_label = 910; break; }
case 911:
  GuiLoadStyleDefault();
  mir_label = 912; break;
case 910:
case 912:
  I_1 = m2_guiStyle;
  i_2 = (int) i0_control * (int) 24L;
  i_3 = (int) i_2 + (int) i0_property;
  I_4 = (long) (int) i_3;
  mir_write_uint(I_1 + I_4 * 4, i0_value);
  if ((int) i0_control != (int) 0L) { mir_label = 913; break; }
case 914:
  if ((int) i0_property >= (int) 16L) { mir_label = 913; break; }
case 915:
  i2_i = 1L;
  if ((int) i2_i >= (int) 16L) { mir_label = 916; break; }
case 917:
  I_8 = m2_guiStyle;
  i_9 = (int) i2_i * (int) 24L;
  i_10 = (int) i_9 + (int) i0_property;
  I_11 = (long) (int) i_10;
  mir_write_uint(I_8 + I_11 * 4, i0_value);
case 918:
  i_12 = i2_i;
  i_12 = (int) i_12 + (int) 1L;
  i2_i = i_12;
  if ((int) i2_i < (int) 16L) { mir_label = 917; break; }
case 916:
  mir_label = 919; break;
case 913:
case 919:
  return;
} // End of switch
} // End of while
} // End of function GuiSetStyle

public int GuiGetStyle (int _i0_control, int _i0_property) {
  long i0_control = _i0_control;
  long i0_property = _i0_property;
  long I_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long i_3 = 0;
  long I_4 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  I_0 = m2_guiStyleLoaded;
  if (((long) mir_read_int(I_0) != 0)) { mir_label = 920; break; }
case 921:
  GuiLoadStyleDefault();
  mir_label = 922; break;
case 920:
case 922:
  I_1 = m2_guiStyle;
  i_2 = (int) i0_control * (int) 24L;
  i_3 = (int) i_2 + (int) i0_property;
  I_4 = (long) (int) i_3;
  return (int) mir_read_uint(I_1 + I_4 * 4);
} // End of switch
} // End of while
} // End of function GuiGetStyle

public int GuiWindowBox (long _I0_bounds, long _U0_title) {
  long I0_bounds = _I0_bounds;
  long U0_title = _U0_title;
  long fp = 0;
  long I_0 = 0;
  long i0_clicked = 0;
  long i0_statusBarHeight = 0;
  float f_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  float f_5 = 0;
  long I_6 = 0;
  float f_7 = 0;
  long i_8 = 0;
  float f_9 = 0;
  long I_10 = 0;
  float f_11 = 0;
  float f_12 = 0;
  long I_13 = 0;
  float f_14 = 0;
  float f_15 = 0;
  float f_16 = 0;
  float f_17 = 0;
  long I_18 = 0;
  float f_19 = 0;
  float f_20 = 0;
  float f_21 = 0;
  long I_22 = 0;
  long I_23 = 0;
  float f_24 = 0;
  long i_25 = 0;
  float f_26 = 0;
  long I_27 = 0;
  float f_28 = 0;
  float f_29 = 0;
  float f_30 = 0;
  float f_31 = 0;
  long I_32 = 0;
  float f_33 = 0;
  float f_34 = 0;
  float f_35 = 0;
  float f_36 = 0;
  float f_37 = 0;
  long I_38 = 0;
  long I_39 = 0;
  long I_40 = 0;
  long I_41 = 0;
  long i0_tempBorderWidth = 0;
  long i_42 = 0;
  long i0_tempTextAlignment = 0;
  long i_43 = 0;
  long i_44 = 0;
  long I_45 = 0;
  long U_46 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(80L);
  I_0 = memcpy((long) fp, (long) I0_bounds, (long) 20L);
  i0_clicked = 0L;
  i0_statusBarHeight = 24L;
  mir_write_float(20L + fp, mir_read_float(fp));
  mir_write_float(24L + fp, mir_read_float(4L + fp));
  mir_write_float(28L + fp, mir_read_float(8L + fp));
  I_2 = (long) (int) i0_statusBarHeight;
  f_1 = (float) I_2;
  mir_write_float(32L + fp, f_1);
  I_4 = (long) fp + (long) 36L;
  I_3 = memset((long) I_4, (int) 0L, (long) 4L);
  I_6 = (long) (int) i0_statusBarHeight;
  f_5 = (float) I_6;
  f_7 = f_5 * 2f;
  if (mir_read_float(12L + fp) < f_7) { mir_label = 923; break; }
  mir_label = 924; break;
case 923:
  I_10 = (long) (int) i0_statusBarHeight;
  f_9 = (float) I_10;
  f_11 = f_9 * 2f;
  mir_write_float(12L + fp, f_11);
  mir_label = 925; break;
case 924:
case 925:
  mir_write_float(40L + fp, mir_read_float(fp));
  I_13 = (long) (int) i0_statusBarHeight;
  f_12 = (float) I_13;
  f_14 = mir_read_float(4L + fp) + f_12;
  f_15 = (float) 1L;
  f_16 = f_14 - f_15;
  mir_write_float(44L + fp, f_16);
  mir_write_float(48L + fp, mir_read_float(8L + fp));
  I_18 = (long) (int) i0_statusBarHeight;
  f_17 = (float) I_18;
  f_19 = mir_read_float(12L + fp) - f_17;
  f_20 = (float) 1L;
  f_21 = f_19 + f_20;
  mir_write_float(52L + fp, f_21);
  I_23 = (long) fp + (long) 56L;
  I_22 = memset((long) I_23, (int) 0L, (long) 4L);
  f_24 = mir_read_float(20L + fp) + mir_read_float(28L + fp);
  i_25 = GuiGetStyle((int) 15L, (int) 12L);
  I_27 = (long) (int) i_25;
  f_26 = (float) I_27;
  f_28 = f_24 - f_26;
  f_29 = (float) 20L;
  f_30 = f_28 - f_29;
  mir_write_float(60L + fp, f_30);
  I_32 = (long) (int) i0_statusBarHeight;
  f_31 = (float) I_32;
  f_33 = f_31 / 2f;
  f_34 = mir_read_float(24L + fp) + f_33;
  f_35 = f_34 - 9f;
  mir_write_float(64L + fp, f_35);
  f_36 = (float) 18L;
  mir_write_float(68L + fp, f_36);
  f_37 = (float) 18L;
  mir_write_float(72L + fp, f_37);
  I_39 = (long) fp + (long) 76L;
  I_38 = memset((long) I_39, (int) 0L, (long) 4L);
  I_40 = (long) fp + (long) 20L;
  GuiStatusBar((long) I_40, (long) U0_title);
  I_41 = (long) fp + (long) 40L;
  GuiPanel((long) I_41, (long) 0L);
  i_42 = GuiGetStyle((int) 2L, (int) 12L);
  i0_tempBorderWidth = i_42;
  i_43 = GuiGetStyle((int) 2L, (int) 14L);
  i0_tempTextAlignment = i_43;
  GuiSetStyle((int) 2L, (int) 12L, (int) 1L);
  GuiSetStyle((int) 2L, (int) 14L, (int) 1L);
  I_45 = (long) fp + (long) 60L;
  U_46 = GuiIconText((int) 128L, (long) 0L);
  i_44 = GuiButton((long) I_45, (long) U_46);
  i0_clicked = i_44;
  GuiSetStyle((int) 2L, (int) 12L, (int) i0_tempBorderWidth);
  GuiSetStyle((int) 2L, (int) 14L, (int) i0_tempTextAlignment);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_clicked;
} // End of switch
} // End of while
} // End of function GuiWindowBox

public void GuiGroupBox (long _I0_bounds, long _U0_text) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  float f_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long I_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  long I_12 = 0;
  long i_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long I_16 = 0;
  float f_17 = 0;
  float f_18 = 0;
  float f_19 = 0;
  float f_20 = 0;
  long I_21 = 0;
  long I_22 = 0;
  long I_23 = 0;
  long I_24 = 0;
  long I_25 = 0;
  long I_26 = 0;
  long I_27 = 0;
  long I_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  long i_31 = 0;
  long i_32 = 0;
  long i_33 = 0;
  long I_34 = 0;
  float f_35 = 0;
  float f_36 = 0;
  float f_37 = 0;
  float f_38 = 0;
  long I_39 = 0;
  long I_40 = 0;
  long I_41 = 0;
  long I_42 = 0;
  long I_43 = 0;
  long I_44 = 0;
  long I_45 = 0;
  long I_46 = 0;
  long I_47 = 0;
  long I_48 = 0;
  long i_49 = 0;
  long i_50 = 0;
  long i_51 = 0;
  long I_52 = 0;
  long i_53 = 0;
  long i_54 = 0;
  float f_55 = 0;
  long I_56 = 0;
  float f_57 = 0;
  long i_58 = 0;
  float f_59 = 0;
  long I_60 = 0;
  long I_61 = 0;
  long I_62 = 0;
  long I_63 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(144L);
  I_0 = (long) fp + (long) 12L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  mir_write_float(32L + fp, mir_read_float(12L + fp));
  mir_write_float(36L + fp, mir_read_float(16L + fp));
  f_3 = (float) 1L;
  mir_write_float(40L + fp, f_3);
  mir_write_float(44L + fp, mir_read_float(24L + fp));
  I_5 = (long) fp + (long) 48L;
  I_4 = memset((long) I_5, (int) 0L, (long) 4L);
  I_6 = (long) fp + (long) 32L;
  I_7 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(fp, I_7);
  I_8 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(1L + fp, I_8);
  I_9 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(2L + fp, I_9);
  I_10 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(3L + fp, I_10);
  I_11 = (long) fp + (long) 112L;
  I_12 = (long) fp + (long) 128L;
  if ((int) i0_state != (int) 3L) { mir_label = 926; break; }
case 927:
  i_15 = 9L;
  mir_label = 928; break;
case 926:
  i_15 = 18L;
case 928:
  i_13 = GuiGetStyle((int) 0L, (int) i_15);
  m2_GetColor((long) I_12, (int) i_13);
  I_16 = m2_guiAlpha;
  m2_Fade((long) I_11, (long) I_12, (float) mir_read_float(I_16));
  m2_GuiDrawRectangle((long) I_6, (int) 0L, (long) fp, (long) I_11);
  mir_write_float(52L + fp, mir_read_float(12L + fp));
  f_17 = mir_read_float(16L + fp) + mir_read_float(24L + fp);
  f_18 = (float) 1L;
  f_19 = f_17 - f_18;
  mir_write_float(56L + fp, f_19);
  mir_write_float(60L + fp, mir_read_float(20L + fp));
  f_20 = (float) 1L;
  mir_write_float(64L + fp, f_20);
  I_22 = (long) fp + (long) 68L;
  I_21 = memset((long) I_22, (int) 0L, (long) 4L);
  I_23 = (long) fp + (long) 52L;
  I_24 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(4L + fp, I_24);
  I_25 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(5L + fp, I_25);
  I_26 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(6L + fp, I_26);
  I_27 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(7L + fp, I_27);
  I_28 = (long) fp + (long) 4L;
  I_29 = (long) fp + (long) 112L;
  I_30 = (long) fp + (long) 128L;
  if ((int) i0_state != (int) 3L) { mir_label = 929; break; }
case 930:
  i_33 = 9L;
  mir_label = 931; break;
case 929:
  i_33 = 18L;
case 931:
  i_31 = GuiGetStyle((int) 0L, (int) i_33);
  m2_GetColor((long) I_30, (int) i_31);
  I_34 = m2_guiAlpha;
  m2_Fade((long) I_29, (long) I_30, (float) mir_read_float(I_34));
  m2_GuiDrawRectangle((long) I_23, (int) 0L, (long) I_28, (long) I_29);
  f_35 = mir_read_float(12L + fp) + mir_read_float(20L + fp);
  f_36 = (float) 1L;
  f_37 = f_35 - f_36;
  mir_write_float(72L + fp, f_37);
  mir_write_float(76L + fp, mir_read_float(16L + fp));
  f_38 = (float) 1L;
  mir_write_float(80L + fp, f_38);
  mir_write_float(84L + fp, mir_read_float(24L + fp));
  I_40 = (long) fp + (long) 88L;
  I_39 = memset((long) I_40, (int) 0L, (long) 4L);
  I_41 = (long) fp + (long) 72L;
  I_42 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(8L + fp, I_42);
  I_43 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(9L + fp, I_43);
  I_44 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(10L + fp, I_44);
  I_45 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(11L + fp, I_45);
  I_46 = (long) fp + (long) 8L;
  I_47 = (long) fp + (long) 112L;
  I_48 = (long) fp + (long) 128L;
  if ((int) i0_state != (int) 3L) { mir_label = 932; break; }
case 933:
  i_51 = 9L;
  mir_label = 934; break;
case 932:
  i_51 = 18L;
case 934:
  i_49 = GuiGetStyle((int) 0L, (int) i_51);
  m2_GetColor((long) I_48, (int) i_49);
  I_52 = m2_guiAlpha;
  m2_Fade((long) I_47, (long) I_48, (float) mir_read_float(I_52));
  m2_GuiDrawRectangle((long) I_41, (int) 0L, (long) I_46, (long) I_47);
  mir_write_float(92L + fp, mir_read_float(12L + fp));
  i_53 = GuiGetStyle((int) 0L, (int) 16L);
  i_54 = (int) i_53 / (int) 2L;
  I_56 = (long) (int) i_54;
  f_55 = (float) I_56;
  f_57 = mir_read_float(16L + fp) - f_55;
  mir_write_float(96L + fp, f_57);
  mir_write_float(100L + fp, mir_read_float(20L + fp));
  i_58 = GuiGetStyle((int) 0L, (int) 16L);
  I_60 = (long) (int) i_58;
  f_59 = (float) I_60;
  mir_write_float(104L + fp, f_59);
  I_62 = (long) fp + (long) 108L;
  I_61 = memset((long) I_62, (int) 0L, (long) 4L);
  I_63 = (long) fp + (long) 92L;
  GuiLine((long) I_63, (long) U0_text);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiGroupBox

public void GuiLine (long _I0_bounds, long _U0_text) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long i_10 = 0;
  float f_11 = 0;
  float f_12 = 0;
  float f_13 = 0;
  float f_14 = 0;
  long I_15 = 0;
  long I_16 = 0;
  long I_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  long I_20 = 0;
  long I_21 = 0;
  long I_22 = 0;
  float f_23 = 0;
  long I_24 = 0;
  long I_25 = 0;
  long i_26 = 0;
  float f_27 = 0;
  long I_28 = 0;
  float f_29 = 0;
  float f_30 = 0;
  float f_31 = 0;
  float f_32 = 0;
  float f_33 = 0;
  float f_34 = 0;
  float f_35 = 0;
  long I_36 = 0;
  long I_37 = 0;
  long I_38 = 0;
  long I_39 = 0;
  long I_40 = 0;
  long I_41 = 0;
  long I_42 = 0;
  long I_43 = 0;
  long I_44 = 0;
  float f_45 = 0;
  float f_46 = 0;
  float f_47 = 0;
  float f_48 = 0;
  float f_49 = 0;
  float f_50 = 0;
  float f_51 = 0;
  float f_52 = 0;
  float f_53 = 0;
  float f_54 = 0;
  float f_55 = 0;
  float f_56 = 0;
  float f_57 = 0;
  float f_58 = 0;
  long I_59 = 0;
  long I_60 = 0;
  long I_61 = 0;
  long I_62 = 0;
  long I_63 = 0;
  long I_64 = 0;
  long I_65 = 0;
  long I_66 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(160L);
  I_0 = (long) fp + (long) 8L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  I_3 = (long) fp + (long) 128L;
  I_4 = (long) fp + (long) 144L;
  if ((int) i0_state != (int) 3L) { mir_label = 935; break; }
case 936:
  i_7 = 9L;
  mir_label = 937; break;
case 935:
  i_7 = 18L;
case 937:
  i_5 = GuiGetStyle((int) 0L, (int) i_7);
  m2_GetColor((long) I_4, (int) i_5);
  I_8 = m2_guiAlpha;
  m2_Fade((long) I_3, (long) I_4, (float) mir_read_float(I_8));
  I_9 = memcpy((long) fp, (long) I_3, (long) 4L);
  if ((long) U0_text != (long) 0L) { mir_label = 938; break; }
case 939:
  mir_write_float(28L + fp, mir_read_float(8L + fp));
  f_11 = (float) 2L;
  f_12 = mir_read_float(20L + fp) / f_11;
  f_13 = mir_read_float(12L + fp) + f_12;
  mir_write_float(32L + fp, f_13);
  mir_write_float(36L + fp, mir_read_float(16L + fp));
  f_14 = (float) 1L;
  mir_write_float(40L + fp, f_14);
  I_16 = (long) fp + (long) 44L;
  I_15 = memset((long) I_16, (int) 0L, (long) 4L);
  I_17 = (long) fp + (long) 28L;
  I_18 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(4L + fp, I_18);
  I_19 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(5L + fp, I_19);
  I_20 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(6L + fp, I_20);
  I_21 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(7L + fp, I_21);
  I_22 = (long) fp + (long) 4L;
  m2_GuiDrawRectangle((long) I_17, (int) 0L, (long) I_22, (long) fp);
  mir_label = 940; break;
case 938:
  f_23 = (float) 0L;
  mir_write_float(56L + fp, f_23);
  I_25 = (long) fp + (long) 60L;
  I_24 = memset((long) I_25, (int) 0L, (long) 16L);
  i_26 = m2_GetTextWidth((long) U0_text);
  I_28 = (long) (int) i_26;
  f_27 = (float) I_28;
  mir_write_float(64L + fp, f_27);
  mir_write_float(68L + fp, mir_read_float(20L + fp));
  f_29 = (float) 12L;
  f_30 = mir_read_float(8L + fp) + f_29;
  mir_write_float(56L + fp, f_30);
  mir_write_float(60L + fp, mir_read_float(12L + fp));
  mir_write_float(76L + fp, mir_read_float(8L + fp));
  f_31 = (float) 2L;
  f_32 = mir_read_float(20L + fp) / f_31;
  f_33 = mir_read_float(12L + fp) + f_32;
  mir_write_float(80L + fp, f_33);
  f_34 = (float) 8L;
  mir_write_float(84L + fp, f_34);
  f_35 = (float) 1L;
  mir_write_float(88L + fp, f_35);
  I_37 = (long) fp + (long) 92L;
  I_36 = memset((long) I_37, (int) 0L, (long) 4L);
  I_38 = (long) fp + (long) 76L;
  I_39 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(48L + fp, I_39);
  I_40 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(49L + fp, I_40);
  I_41 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(50L + fp, I_41);
  I_42 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(51L + fp, I_42);
  I_43 = (long) fp + (long) 48L;
  m2_GuiDrawRectangle((long) I_38, (int) 0L, (long) I_43, (long) fp);
  I_44 = (long) fp + (long) 56L;
  m2_GuiDrawText((long) U0_text, (long) I_44, (int) 0L, (long) fp);
  f_45 = (float) 12L;
  f_46 = mir_read_float(8L + fp) + f_45;
  f_47 = f_46 + mir_read_float(64L + fp);
  f_48 = (float) 4L;
  f_49 = f_47 + f_48;
  mir_write_float(96L + fp, f_49);
  f_50 = (float) 2L;
  f_51 = mir_read_float(20L + fp) / f_50;
  f_52 = mir_read_float(12L + fp) + f_51;
  mir_write_float(100L + fp, f_52);
  f_53 = mir_read_float(16L + fp) - mir_read_float(64L + fp);
  f_54 = (float) 12L;
  f_55 = f_53 - f_54;
  f_56 = (float) 4L;
  f_57 = f_55 - f_56;
  mir_write_float(104L + fp, f_57);
  f_58 = (float) 1L;
  mir_write_float(108L + fp, f_58);
  I_60 = (long) fp + (long) 112L;
  I_59 = memset((long) I_60, (int) 0L, (long) 4L);
  I_61 = (long) fp + (long) 96L;
  I_62 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(52L + fp, I_62);
  I_63 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(53L + fp, I_63);
  I_64 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(54L + fp, I_64);
  I_65 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(55L + fp, I_65);
  I_66 = (long) fp + (long) 52L;
  m2_GuiDrawRectangle((long) I_61, (int) 0L, (long) I_66, (long) fp);
case 940:
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiLine

public void GuiPanel (long _I0_bounds, long _U0_text) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long fp = 0;
  long I_0 = 0;
  long i0_state = 0;
  long I_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  float f_7 = 0;
  float f_8 = 0;
  float f_9 = 0;
  float f_10 = 0;
  long i_11 = 0;
  long I_12 = 0;
  long I_13 = 0;
  long I_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  long I_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  long i_23 = 0;
  long I_24 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(96L);
  I_0 = memcpy((long) fp, (long) I0_bounds, (long) 20L);
  I_1 = m2_guiState;
  i0_state = mir_read_int(I_1);
  mir_write_float(20L + fp, mir_read_float(fp));
  mir_write_float(24L + fp, mir_read_float(4L + fp));
  mir_write_float(28L + fp, mir_read_float(8L + fp));
  mir_write_float(32L + fp, 24f);
  I_3 = (long) fp + (long) 36L;
  I_2 = memset((long) I_3, (int) 0L, (long) 4L);
  if ((long) U0_text == (long) 0L) { mir_label = 941; break; }
case 942:
  if (mir_read_float(12L + fp) < 48f) { mir_label = 943; break; }
  mir_label = 941; break;
case 943:
  mir_write_float(12L + fp, 48f);
  mir_label = 944; break;
case 941:
case 944:
  if ((long) U0_text == (long) 0L) { mir_label = 945; break; }
case 946:
  f_7 = mir_read_float(4L + fp);
  f_7 = f_7 + 23f;
  mir_write_float(4L + fp, f_7);
  f_9 = mir_read_float(12L + fp);
  f_9 = f_9 - 25f;
  mir_write_float(12L + fp, f_9);
  mir_label = 947; break;
case 945:
case 947:
  if ((long) U0_text == (long) 0L) { mir_label = 948; break; }
case 949:
  I_12 = (long) fp + (long) 20L;
  GuiStatusBar((long) I_12, (long) U0_text);
  mir_label = 950; break;
case 948:
case 950:
  I_13 = (long) fp + (long) 48L;
  I_14 = (long) fp + (long) 64L;
  if ((int) i0_state != (int) 3L) { mir_label = 951; break; }
case 952:
  i_17 = 9L;
  mir_label = 953; break;
case 951:
  i_17 = 18L;
case 953:
  i_15 = GuiGetStyle((int) 0L, (int) i_17);
  m2_GetColor((long) I_14, (int) i_15);
  I_18 = m2_guiAlpha;
  m2_Fade((long) I_13, (long) I_14, (float) mir_read_float(I_18));
  I_19 = (long) fp + (long) 64L;
  I_20 = (long) fp + (long) 80L;
  if ((int) i0_state != (int) 3L) { mir_label = 954; break; }
case 955:
  i_23 = 10L;
  mir_label = 956; break;
case 954:
  i_23 = 19L;
case 956:
  i_21 = GuiGetStyle((int) 0L, (int) i_23);
  m2_GetColor((long) I_20, (int) i_21);
  I_24 = m2_guiAlpha;
  m2_Fade((long) I_19, (long) I_20, (float) mir_read_float(I_24));
  m2_GuiDrawRectangle((long) fp, (int) 1L, (long) I_13, (long) I_19);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiPanel

public void GuiScrollPanel (long _Ret_Addr, long _I0_bounds, long _U0_text, long _I0_content, long _U0_scroll) {
  long Ret_Addr = _Ret_Addr;
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long I0_content = _I0_content;
  long U0_scroll = _U0_scroll;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long i0_state = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long i_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  float f_14 = 0;
  float f_15 = 0;
  float f_16 = 0;
  float f_17 = 0;
  long i0_hasHorizontalScrollBar = 0;
  long i_18 = 0;
  long i_19 = 0;
  float f_20 = 0;
  long I_21 = 0;
  float f_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long i0_hasVerticalScrollBar = 0;
  long i_25 = 0;
  long i_26 = 0;
  float f_27 = 0;
  long I_28 = 0;
  float f_29 = 0;
  long i_30 = 0;
  long i_31 = 0;
  long I_32 = 0;
  long I_33 = 0;
  long i_34 = 0;
  long i_35 = 0;
  float f_36 = 0;
  long I_37 = 0;
  float f_38 = 0;
  long i_39 = 0;
  float f_40 = 0;
  long I_41 = 0;
  float f_42 = 0;
  long i_43 = 0;
  long i_44 = 0;
  long I_45 = 0;
  long I_46 = 0;
  long i_47 = 0;
  long i_48 = 0;
  float f_49 = 0;
  long I_50 = 0;
  float f_51 = 0;
  long i_52 = 0;
  float f_53 = 0;
  long I_54 = 0;
  float f_55 = 0;
  long i_56 = 0;
  long i_57 = 0;
  long i0_horizontalScrollBarWidth = 0;
  long I_58 = 0;
  long i_59 = 0;
  long i_60 = 0;
  long i0_verticalScrollBarWidth = 0;
  long I_61 = 0;
  long i_62 = 0;
  long i_63 = 0;
  long i_64 = 0;
  long i_65 = 0;
  float f_66 = 0;
  float f_67 = 0;
  long I_68 = 0;
  float f_69 = 0;
  float f_70 = 0;
  float f_71 = 0;
  float f_72 = 0;
  long i_73 = 0;
  float f_74 = 0;
  long I_75 = 0;
  float f_76 = 0;
  float f_77 = 0;
  float f_78 = 0;
  float f_79 = 0;
  long I_80 = 0;
  float f_81 = 0;
  long i_82 = 0;
  float f_83 = 0;
  long I_84 = 0;
  float f_85 = 0;
  float f_86 = 0;
  float f_87 = 0;
  long I_88 = 0;
  float f_89 = 0;
  long i_90 = 0;
  long i_91 = 0;
  float f_92 = 0;
  long I_93 = 0;
  float f_94 = 0;
  float f_95 = 0;
  long I_96 = 0;
  long I_97 = 0;
  long I_98 = 0;
  long i_99 = 0;
  long i_100 = 0;
  float f_101 = 0;
  long i_102 = 0;
  float f_103 = 0;
  long I_104 = 0;
  float f_105 = 0;
  float f_106 = 0;
  float f_107 = 0;
  float f_108 = 0;
  float f_109 = 0;
  long I_110 = 0;
  float f_111 = 0;
  long i_112 = 0;
  float f_113 = 0;
  long I_114 = 0;
  float f_115 = 0;
  float f_116 = 0;
  float f_117 = 0;
  long i_118 = 0;
  float f_119 = 0;
  long I_120 = 0;
  float f_121 = 0;
  float f_122 = 0;
  long I_123 = 0;
  float f_124 = 0;
  float f_125 = 0;
  long I_126 = 0;
  float f_127 = 0;
  long i_128 = 0;
  long i_129 = 0;
  float f_130 = 0;
  long I_131 = 0;
  float f_132 = 0;
  long I_133 = 0;
  long I_134 = 0;
  long i_135 = 0;
  long i_136 = 0;
  float f_137 = 0;
  long I_138 = 0;
  float f_139 = 0;
  long i_140 = 0;
  float f_141 = 0;
  long I_142 = 0;
  float f_143 = 0;
  long i_144 = 0;
  float f_145 = 0;
  long I_146 = 0;
  float f_147 = 0;
  long i_148 = 0;
  long i_149 = 0;
  float f_150 = 0;
  long I_151 = 0;
  float f_152 = 0;
  float f_153 = 0;
  long I_154 = 0;
  float f_155 = 0;
  long i_156 = 0;
  long i_157 = 0;
  float f_158 = 0;
  long I_159 = 0;
  float f_160 = 0;
  float f_161 = 0;
  long I_162 = 0;
  float f_163 = 0;
  long I_164 = 0;
  long I_165 = 0;
  long I_166 = 0;
  long I_167 = 0;
  long I_168 = 0;
  long i_169 = 0;
  float f_170 = 0;
  long I_171 = 0;
  float f_172 = 0;
  long i_173 = 0;
  float f_174 = 0;
  long I_175 = 0;
  float f_176 = 0;
  long i_177 = 0;
  long i_178 = 0;
  float f_179 = 0;
  long I_180 = 0;
  float f_181 = 0;
  float f_182 = 0;
  long I_183 = 0;
  float f_184 = 0;
  long i_185 = 0;
  long i_186 = 0;
  float f_187 = 0;
  long I_188 = 0;
  float f_189 = 0;
  float f_190 = 0;
  long I_191 = 0;
  float f_192 = 0;
  long I_193 = 0;
  long I_194 = 0;
  long I_195 = 0;
  long I_196 = 0;
  long I_197 = 0;
  long i_198 = 0;
  long i_199 = 0;
  float f0_horizontalMin = 0;
  long I_200 = 0;
  long i_201 = 0;
  long i_202 = 0;
  long i_203 = 0;
  float f_204 = 0;
  long I_205 = 0;
  float f_206 = 0;
  float f_207 = 0;
  long i_208 = 0;
  float f_209 = 0;
  long I_210 = 0;
  float f_211 = 0;
  float f_212 = 0;
  long i_213 = 0;
  float f_214 = 0;
  long I_215 = 0;
  float f_216 = 0;
  long i_217 = 0;
  long i_218 = 0;
  float f_219 = 0;
  long I_220 = 0;
  float f_221 = 0;
  float f_222 = 0;
  long i_223 = 0;
  float f_224 = 0;
  long I_225 = 0;
  float f_226 = 0;
  float f0_horizontalMax = 0;
  long I_227 = 0;
  float f_228 = 0;
  float f_229 = 0;
  long I_230 = 0;
  float f_231 = 0;
  long i_232 = 0;
  float f_233 = 0;
  long I_234 = 0;
  float f_235 = 0;
  long i_236 = 0;
  float f_237 = 0;
  long I_238 = 0;
  float f_239 = 0;
  long i_240 = 0;
  float f_241 = 0;
  long I_242 = 0;
  float f_243 = 0;
  float f_244 = 0;
  float f_245 = 0;
  float f_246 = 0;
  long i_247 = 0;
  long i_248 = 0;
  float f_249 = 0;
  long I_250 = 0;
  float f0_verticalMin = 0;
  long I_251 = 0;
  long i_252 = 0;
  float f_253 = 0;
  long I_254 = 0;
  float f0_verticalMax = 0;
  long I_255 = 0;
  float f_256 = 0;
  float f_257 = 0;
  long I_258 = 0;
  float f_259 = 0;
  long i_260 = 0;
  float f_261 = 0;
  long I_262 = 0;
  float f_263 = 0;
  float f_264 = 0;
  long i_265 = 0;
  long i_266 = 0;
  float f_267 = 0;
  long I_268 = 0;
  long i_269 = 0;
  long I_270 = 0;
  long I_271 = 0;
  long I_272 = 0;
  long I_273 = 0;
  long i_274 = 0;
  long I_275 = 0;
  long I_276 = 0;
  long I_277 = 0;
  long i_278 = 0;
  long I_279 = 0;
  float f3_wheelMove = 0;
  float f_280 = 0;
  long I_281 = 0;
  long i_282 = 0;
  long I_283 = 0;
  long i_284 = 0;
  long I_285 = 0;
  float f_286 = 0;
  float f_287 = 0;
  float f_288 = 0;
  float f_289 = 0;
  float f_290 = 0;
  float f_291 = 0;
  float f_292 = 0;
  float f_293 = 0;
  float f_294 = 0;
  long i_295 = 0;
  float f_296 = 0;
  float f_297 = 0;
  long i_298 = 0;
  float f_299 = 0;
  float f_300 = 0;
  long i_301 = 0;
  float f_302 = 0;
  float f_303 = 0;
  long i_304 = 0;
  float f_305 = 0;
  long i_306 = 0;
  long I_307 = 0;
  long I_308 = 0;
  long I_309 = 0;
  long I_310 = 0;
  long I_311 = 0;
  long I_312 = 0;
  long I_313 = 0;
  long i_314 = 0;
  long i0_slider = 0;
  long i_315 = 0;
  long I_316 = 0;
  long i_317 = 0;
  long i_318 = 0;
  float f_319 = 0;
  long I_320 = 0;
  float f_321 = 0;
  float f_322 = 0;
  long I_323 = 0;
  float f_324 = 0;
  long i_325 = 0;
  float f_326 = 0;
  long I_327 = 0;
  float f_328 = 0;
  long i_329 = 0;
  long i_330 = 0;
  long i_331 = 0;
  long i_332 = 0;
  long i_333 = 0;
  float f_334 = 0;
  long I_335 = 0;
  float f_336 = 0;
  long i_337 = 0;
  long i_338 = 0;
  long I_339 = 0;
  float f_340 = 0;
  long i_341 = 0;
  long i_342 = 0;
  long i_343 = 0;
  long i_344 = 0;
  float f_345 = 0;
  long I_346 = 0;
  long I_347 = 0;
  long i_348 = 0;
  long i_349 = 0;
  float f_350 = 0;
  long I_351 = 0;
  float f_352 = 0;
  float f_353 = 0;
  long I_354 = 0;
  float f_355 = 0;
  long i_356 = 0;
  float f_357 = 0;
  long I_358 = 0;
  float f_359 = 0;
  long i_360 = 0;
  long i_361 = 0;
  long i_362 = 0;
  long i_363 = 0;
  long i_364 = 0;
  float f_365 = 0;
  long I_366 = 0;
  float f_367 = 0;
  long i_368 = 0;
  long i_369 = 0;
  long I_370 = 0;
  float f_371 = 0;
  long i_372 = 0;
  long i_373 = 0;
  long i_374 = 0;
  long i_375 = 0;
  float f_376 = 0;
  long I_377 = 0;
  long I_378 = 0;
  long I_379 = 0;
  long i_380 = 0;
  long i_381 = 0;
  long i_382 = 0;
  float f_383 = 0;
  long I_384 = 0;
  float f_385 = 0;
  float f_386 = 0;
  float f_387 = 0;
  float f_388 = 0;
  float f_389 = 0;
  float f_390 = 0;
  float f_391 = 0;
  float f_392 = 0;
  float f_393 = 0;
  float f_394 = 0;
  float f_395 = 0;
  long I_396 = 0;
  float f_397 = 0;
  float f_398 = 0;
  float f_399 = 0;
  long I_400 = 0;
  float f_401 = 0;
  float f_402 = 0;
  long I_403 = 0;
  long I_404 = 0;
  long I_405 = 0;
  long I_406 = 0;
  long I_407 = 0;
  long I_408 = 0;
  long I_409 = 0;
  long I_410 = 0;
  long I_411 = 0;
  long I_412 = 0;
  long i_413 = 0;
  long i_414 = 0;
  long i_415 = 0;
  long I_416 = 0;
  long I_417 = 0;
  long i_418 = 0;
  long I_419 = 0;
  long I_420 = 0;
  long i_421 = 0;
  long i_422 = 0;
  long i_423 = 0;
  long I_424 = 0;
  long I_425 = 0;
  long I_426 = 0;
  long I_427 = 0;
  long I_428 = 0;
  long I_429 = 0;
  long i_430 = 0;
  long I_431 = 0;
  long I_432 = 0;
  long I_433 = 0;
  long I_434 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(256L);
  I_0 = (long) fp + (long) 8L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = (long) fp + (long) 28L;
  I_3 = memcpy((long) I_2, (long) I0_content, (long) 20L);
  I_4 = m2_guiState;
  i0_state = mir_read_int(I_4);
  mir_write_float(168L + fp, 0f);
  mir_write_float(172L + fp, 0f);
  I_6 = (long) fp + (long) 176L;
  I_5 = memset((long) I_6, (int) 0L, (long) 16L);
  if ((long) U0_scroll == (long) 0L) { mir_label = 957; break; }
case 958:
  I_8 = (long) fp + (long) 168L;
  I_9 = memcpy((long) I_8, (long) U0_scroll, (long) 24L);
  mir_label = 959; break;
case 957:
case 959:
  mir_write_float(48L + fp, mir_read_float(8L + fp));
  mir_write_float(52L + fp, mir_read_float(12L + fp));
  mir_write_float(56L + fp, mir_read_float(16L + fp));
  mir_write_float(60L + fp, 24f);
  I_11 = (long) fp + (long) 64L;
  I_10 = memset((long) I_11, (int) 0L, (long) 4L);
  if (mir_read_float(20L + fp) < 48f) { mir_label = 960; break; }
  mir_label = 961; break;
case 960:
  mir_write_float(20L + fp, 48f);
  mir_label = 962; break;
case 961:
case 962:
  if ((long) U0_text == (long) 0L) { mir_label = 963; break; }
case 964:
  f_14 = mir_read_float(12L + fp);
  f_14 = f_14 + 23f;
  mir_write_float(12L + fp, f_14);
  f_16 = mir_read_float(20L + fp);
  f_16 = f_16 - 25f;
  mir_write_float(20L + fp, f_16);
  mir_label = 965; break;
case 963:
case 965:
  i_18 = GuiGetStyle((int) 0L, (int) 12L);
  i_19 = (int) 2L * (int) i_18;
  I_21 = (long) (int) i_19;
  f_20 = (float) I_21;
  f_22 = mir_read_float(16L + fp) - f_20;
  if (mir_read_float(36L + fp) > f_22) { mir_label = 966; break; }
  mir_label = 967; break;
case 966:
  i_24 = 1L;
  mir_label = 968; break;
case 967:
  i_24 = 0L;
case 968:
  i0_hasHorizontalScrollBar = i_24;
  i_25 = GuiGetStyle((int) 0L, (int) 12L);
  i_26 = (int) 2L * (int) i_25;
  I_28 = (long) (int) i_26;
  f_27 = (float) I_28;
  f_29 = mir_read_float(20L + fp) - f_27;
  if (mir_read_float(40L + fp) > f_29) { mir_label = 969; break; }
  mir_label = 970; break;
case 969:
  i_31 = 1L;
  mir_label = 971; break;
case 970:
  i_31 = 0L;
case 971:
  i0_hasVerticalScrollBar = i_31;
  I_32 = (long) (int) i0_hasHorizontalScrollBar;
  if (((long) I_32 != 0)) { mir_label = 972; break; }
case 973:
  I_33 = (long) (int) i0_hasVerticalScrollBar;
  if (((long) I_33 == 0)) { mir_label = 974; break; }
case 975:
  i_34 = GuiGetStyle((int) 0L, (int) 12L);
  i_35 = (int) 2L * (int) i_34;
  I_37 = (long) (int) i_35;
  f_36 = (float) I_37;
  f_38 = mir_read_float(16L + fp) - f_36;
  i_39 = GuiGetStyle((int) 12L, (int) 18L);
  I_41 = (long) (int) i_39;
  f_40 = (float) I_41;
  f_42 = f_38 - f_40;
  if (mir_read_float(36L + fp) > f_42) { mir_label = 976; break; }
  mir_label = 974; break;
case 976:
  i_44 = 1L;
  mir_label = 977; break;
case 974:
  i_44 = 0L;
case 977:
  i0_hasHorizontalScrollBar = i_44;
  mir_label = 978; break;
case 972:
case 978:
  I_45 = (long) (int) i0_hasVerticalScrollBar;
  if (((long) I_45 != 0)) { mir_label = 979; break; }
case 980:
  I_46 = (long) (int) i0_hasHorizontalScrollBar;
  if (((long) I_46 == 0)) { mir_label = 981; break; }
case 982:
  i_47 = GuiGetStyle((int) 0L, (int) 12L);
  i_48 = (int) 2L * (int) i_47;
  I_50 = (long) (int) i_48;
  f_49 = (float) I_50;
  f_51 = mir_read_float(20L + fp) - f_49;
  i_52 = GuiGetStyle((int) 12L, (int) 18L);
  I_54 = (long) (int) i_52;
  f_53 = (float) I_54;
  f_55 = f_51 - f_53;
  if (mir_read_float(40L + fp) > f_55) { mir_label = 983; break; }
  mir_label = 981; break;
case 983:
  i_57 = 1L;
  mir_label = 984; break;
case 981:
  i_57 = 0L;
case 984:
  i0_hasVerticalScrollBar = i_57;
  mir_label = 985; break;
case 979:
case 985:
  I_58 = (long) (int) i0_hasHorizontalScrollBar;
  if (((long) I_58 == 0)) { mir_label = 986; break; }
case 987:
  i_59 = GuiGetStyle((int) 12L, (int) 18L);
  i_60 = i_59;
  mir_label = 988; break;
case 986:
  i_60 = 0L;
case 988:
  i0_horizontalScrollBarWidth = i_60;
  I_61 = (long) (int) i0_hasVerticalScrollBar;
  if (((long) I_61 == 0)) { mir_label = 989; break; }
case 990:
  i_62 = GuiGetStyle((int) 12L, (int) 18L);
  i_63 = i_62;
  mir_label = 991; break;
case 989:
  i_63 = 0L;
case 991:
  i0_verticalScrollBarWidth = i_63;
  i_64 = GuiGetStyle((int) 12L, (int) 19L);
  if ((int) i_64 != (int) 0L) { mir_label = 992; break; }
case 993:
  f_66 = mir_read_float(8L + fp);
  I_68 = (long) (int) i0_verticalScrollBarWidth;
  f_67 = (float) I_68;
  f_69 = f_66 + f_67;
  f_70 = f_69;
  mir_label = 994; break;
case 992:
  f_71 = mir_read_float(8L + fp);
  f_70 = f_71;
case 994:
  f_72 = f_70;
  i_73 = GuiGetStyle((int) 0L, (int) 12L);
  I_75 = (long) (int) i_73;
  f_74 = (float) I_75;
  f_76 = f_72 + f_74;
  mir_write_float(68L + fp, f_76);
  f_77 = mir_read_float(12L + fp);
  f_78 = f_77 + mir_read_float(20L + fp);
  I_80 = (long) (int) i0_horizontalScrollBarWidth;
  f_79 = (float) I_80;
  f_81 = f_78 - f_79;
  i_82 = GuiGetStyle((int) 0L, (int) 12L);
  I_84 = (long) (int) i_82;
  f_83 = (float) I_84;
  f_85 = f_81 - f_83;
  mir_write_float(72L + fp, f_85);
  f_86 = mir_read_float(16L + fp);
  I_88 = (long) (int) i0_verticalScrollBarWidth;
  f_87 = (float) I_88;
  f_89 = f_86 - f_87;
  i_90 = GuiGetStyle((int) 0L, (int) 12L);
  i_91 = (int) 2L * (int) i_90;
  I_93 = (long) (int) i_91;
  f_92 = (float) I_93;
  f_94 = f_89 - f_92;
  mir_write_float(76L + fp, f_94);
  I_96 = (long) (int) i0_horizontalScrollBarWidth;
  f_95 = (float) I_96;
  mir_write_float(80L + fp, f_95);
  I_98 = (long) fp + (long) 84L;
  I_97 = memset((long) I_98, (int) 0L, (long) 4L);
  i_99 = GuiGetStyle((int) 12L, (int) 19L);
  if ((int) i_99 != (int) 0L) { mir_label = 995; break; }
case 996:
  f_101 = mir_read_float(8L + fp);
  i_102 = GuiGetStyle((int) 0L, (int) 12L);
  I_104 = (long) (int) i_102;
  f_103 = (float) I_104;
  f_105 = f_101 + f_103;
  f_106 = f_105;
  mir_label = 997; break;
case 995:
  f_107 = mir_read_float(8L + fp);
  f_108 = f_107 + mir_read_float(16L + fp);
  I_110 = (long) (int) i0_verticalScrollBarWidth;
  f_109 = (float) I_110;
  f_111 = f_108 - f_109;
  i_112 = GuiGetStyle((int) 0L, (int) 12L);
  I_114 = (long) (int) i_112;
  f_113 = (float) I_114;
  f_115 = f_111 - f_113;
  f_106 = f_115;
case 997:
  f_116 = f_106;
  mir_write_float(88L + fp, f_116);
  f_117 = mir_read_float(12L + fp);
  i_118 = GuiGetStyle((int) 0L, (int) 12L);
  I_120 = (long) (int) i_118;
  f_119 = (float) I_120;
  f_121 = f_117 + f_119;
  mir_write_float(92L + fp, f_121);
  I_123 = (long) (int) i0_verticalScrollBarWidth;
  f_122 = (float) I_123;
  mir_write_float(96L + fp, f_122);
  f_124 = mir_read_float(20L + fp);
  I_126 = (long) (int) i0_horizontalScrollBarWidth;
  f_125 = (float) I_126;
  f_127 = f_124 - f_125;
  i_128 = GuiGetStyle((int) 0L, (int) 12L);
  i_129 = (int) 2L * (int) i_128;
  I_131 = (long) (int) i_129;
  f_130 = (float) I_131;
  f_132 = f_127 - f_130;
  mir_write_float(100L + fp, f_132);
  I_134 = (long) fp + (long) 104L;
  I_133 = memset((long) I_134, (int) 0L, (long) 4L);
  i_135 = GuiGetStyle((int) 12L, (int) 19L);
  if ((int) i_135 != (int) 0L) { mir_label = 998; break; }
case 999:
  I_138 = (long) (int) i0_verticalScrollBarWidth;
  f_137 = (float) I_138;
  f_139 = mir_read_float(8L + fp) + f_137;
  i_140 = GuiGetStyle((int) 0L, (int) 12L);
  I_142 = (long) (int) i_140;
  f_141 = (float) I_142;
  f_143 = f_139 + f_141;
  mir_write_float(128L + fp, f_143);
  i_144 = GuiGetStyle((int) 0L, (int) 12L);
  I_146 = (long) (int) i_144;
  f_145 = (float) I_146;
  f_147 = mir_read_float(12L + fp) + f_145;
  mir_write_float(132L + fp, f_147);
  i_148 = GuiGetStyle((int) 0L, (int) 12L);
  i_149 = (int) 2L * (int) i_148;
  I_151 = (long) (int) i_149;
  f_150 = (float) I_151;
  f_152 = mir_read_float(16L + fp) - f_150;
  I_154 = (long) (int) i0_verticalScrollBarWidth;
  f_153 = (float) I_154;
  f_155 = f_152 - f_153;
  mir_write_float(136L + fp, f_155);
  i_156 = GuiGetStyle((int) 0L, (int) 12L);
  i_157 = (int) 2L * (int) i_156;
  I_159 = (long) (int) i_157;
  f_158 = (float) I_159;
  f_160 = mir_read_float(20L + fp) - f_158;
  I_162 = (long) (int) i0_horizontalScrollBarWidth;
  f_161 = (float) I_162;
  f_163 = f_160 - f_161;
  mir_write_float(140L + fp, f_163);
  I_165 = (long) fp + (long) 144L;
  I_164 = memset((long) I_165, (int) 0L, (long) 4L);
  I_166 = (long) fp + (long) 108L;
  I_168 = (long) fp + (long) 128L;
  I_167 = memcpy((long) I_166, (long) I_168, (long) 20L);
  mir_label = 1000; break;
case 998:
  i_169 = GuiGetStyle((int) 0L, (int) 12L);
  I_171 = (long) (int) i_169;
  f_170 = (float) I_171;
  f_172 = mir_read_float(8L + fp) + f_170;
  mir_write_float(148L + fp, f_172);
  i_173 = GuiGetStyle((int) 0L, (int) 12L);
  I_175 = (long) (int) i_173;
  f_174 = (float) I_175;
  f_176 = mir_read_float(12L + fp) + f_174;
  mir_write_float(152L + fp, f_176);
  i_177 = GuiGetStyle((int) 0L, (int) 12L);
  i_178 = (int) 2L * (int) i_177;
  I_180 = (long) (int) i_178;
  f_179 = (float) I_180;
  f_181 = mir_read_float(16L + fp) - f_179;
  I_183 = (long) (int) i0_verticalScrollBarWidth;
  f_182 = (float) I_183;
  f_184 = f_181 - f_182;
  mir_write_float(156L + fp, f_184);
  i_185 = GuiGetStyle((int) 0L, (int) 12L);
  i_186 = (int) 2L * (int) i_185;
  I_188 = (long) (int) i_186;
  f_187 = (float) I_188;
  f_189 = mir_read_float(20L + fp) - f_187;
  I_191 = (long) (int) i0_horizontalScrollBarWidth;
  f_190 = (float) I_191;
  f_192 = f_189 - f_190;
  mir_write_float(160L + fp, f_192);
  I_194 = (long) fp + (long) 164L;
  I_193 = memset((long) I_194, (int) 0L, (long) 4L);
  I_195 = (long) fp + (long) 108L;
  I_197 = (long) fp + (long) 148L;
  I_196 = memcpy((long) I_195, (long) I_197, (long) 20L);
case 1000:
  if (mir_read_float(116L + fp) > mir_read_float(36L + fp)) { mir_label = 1001; break; }
  mir_label = 1002; break;
case 1001:
  mir_write_float(116L + fp, mir_read_float(36L + fp));
  mir_label = 1003; break;
case 1002:
case 1003:
  if (mir_read_float(120L + fp) > mir_read_float(40L + fp)) { mir_label = 1004; break; }
  mir_label = 1005; break;
case 1004:
  mir_write_float(120L + fp, mir_read_float(40L + fp));
  mir_label = 1006; break;
case 1005:
case 1006:
  I_200 = (long) (int) i0_hasHorizontalScrollBar;
  if (((long) I_200 == 0)) { mir_label = 1007; break; }
case 1008:
  i_201 = GuiGetStyle((int) 12L, (int) 19L);
  if ((int) i_201 != (int) 0L) { mir_label = 1009; break; }
case 1010:
  i_203 = - (int) i0_verticalScrollBarWidth;
  I_205 = (long) (int) i_203;
  f_204 = (float) I_205;
  f_206 = f_204;
  mir_label = 1011; break;
case 1009:
  f_207 = (float) 0L;
  f_206 = f_207;
case 1011:
  i_208 = GuiGetStyle((int) 0L, (int) 12L);
  I_210 = (long) (int) i_208;
  f_209 = (float) I_210;
  f_211 = f_206 - f_209;
  f_212 = f_211;
  mir_label = 1012; break;
case 1007:
  i_213 = GuiGetStyle((int) 12L, (int) 19L);
  I_215 = (long) (int) i_213;
  f_214 = (float) I_215;
  f_216 = (float) 0L;
  if (f_214 == f_216) { mir_label = 1013; break; }
  mir_label = 1014; break;
case 1013:
  i_218 = - (int) i0_verticalScrollBarWidth;
  I_220 = (long) (int) i_218;
  f_219 = (float) I_220;
  f_221 = f_219;
  mir_label = 1015; break;
case 1014:
  f_222 = (float) 0L;
  f_221 = f_222;
case 1015:
  i_223 = GuiGetStyle((int) 0L, (int) 12L);
  I_225 = (long) (int) i_223;
  f_224 = (float) I_225;
  f_226 = f_221 - f_224;
  f_212 = f_226;
case 1012:
  f0_horizontalMin = f_212;
  I_227 = (long) (int) i0_hasHorizontalScrollBar;
  if (((long) I_227 == 0)) { mir_label = 1016; break; }
case 1017:
  f_228 = mir_read_float(36L + fp) - mir_read_float(16L + fp);
  I_230 = (long) (int) i0_verticalScrollBarWidth;
  f_229 = (float) I_230;
  f_231 = f_228 + f_229;
  i_232 = GuiGetStyle((int) 0L, (int) 12L);
  I_234 = (long) (int) i_232;
  f_233 = (float) I_234;
  f_235 = f_231 + f_233;
  i_236 = GuiGetStyle((int) 12L, (int) 19L);
  I_238 = (long) (int) i_236;
  f_237 = (float) I_238;
  f_239 = (float) 0L;
  if (f_237 == f_239) { mir_label = 1018; break; }
  mir_label = 1019; break;
case 1018:
  I_242 = (long) (int) i0_verticalScrollBarWidth;
  f_241 = (float) I_242;
  f_243 = f_241;
  mir_label = 1020; break;
case 1019:
  f_244 = (float) 0L;
  f_243 = f_244;
case 1020:
  f_245 = f_235 - f_243;
  f_246 = f_245;
  mir_label = 1021; break;
case 1016:
  i_247 = GuiGetStyle((int) 0L, (int) 12L);
  i_248 = - (int) i_247;
  I_250 = (long) (int) i_248;
  f_249 = (float) I_250;
  f_246 = f_249;
case 1021:
  f0_horizontalMax = f_246;
  I_251 = (long) (int) i0_hasVerticalScrollBar;
  if (((long) I_251 == 0)) { mir_label = 1022; break; }
case 1023:
  i_252 = 0L;
  mir_label = 1024; break;
case 1022:
  i_252 = -1L;
case 1024:
  I_254 = (long) (int) i_252;
  f_253 = (float) I_254;
  f0_verticalMin = f_253;
  I_255 = (long) (int) i0_hasVerticalScrollBar;
  if (((long) I_255 == 0)) { mir_label = 1025; break; }
case 1026:
  f_256 = mir_read_float(40L + fp) - mir_read_float(20L + fp);
  I_258 = (long) (int) i0_horizontalScrollBarWidth;
  f_257 = (float) I_258;
  f_259 = f_256 + f_257;
  i_260 = GuiGetStyle((int) 0L, (int) 12L);
  I_262 = (long) (int) i_260;
  f_261 = (float) I_262;
  f_263 = f_259 + f_261;
  f_264 = f_263;
  mir_label = 1027; break;
case 1025:
  i_265 = GuiGetStyle((int) 0L, (int) 12L);
  i_266 = - (int) i_265;
  I_268 = (long) (int) i_266;
  f_267 = (float) I_268;
  f_264 = f_267;
case 1027:
  f0_verticalMax = f_264;
  if ((int) i0_state == (int) 3L) { mir_label = 1028; break; }
case 1029:
  I_270 = m2_guiLocked;
  if (((long) mir_read_int(I_270) != 0)) { mir_label = 1028; break; }
case 1030:
  I_271 = (long) fp + (long) 224L;
  GetMousePosition((long) I_271);
  I_273 = (long) fp + (long) 192L;
  I_272 = memcpy((long) I_273, (long) I_271, (long) 24L);
  I_275 = (long) fp + (long) 192L;
  I_276 = (long) fp + (long) 8L;
  i_274 = m2_CheckCollisionPointRec((long) I_275, (long) I_276);
  I_277 = (long) (int) i_274;
  if (((long) I_277 == 0)) { mir_label = 1031; break; }
case 1032:
  i_278 = IsMouseButtonDown((int) 0L);
  I_279 = (long) (int) i_278;
  if (((long) I_279 == 0)) { mir_label = 1033; break; }
case 1034:
  i0_state = 2L;
  mir_label = 1035; break;
case 1033:
  i0_state = 1L;
case 1035:
  f_280 = GetMouseWheelMove();
  f3_wheelMove = f_280;
  I_281 = (long) (int) i0_hasHorizontalScrollBar;
  if (((long) I_281 == 0)) { mir_label = 1036; break; }
case 1037:
  i_282 = IsKeyDown((int) 341L);
  I_283 = (long) (int) i_282;
  if (((long) I_283 != 0)) { mir_label = 1038; break; }
case 1039:
  i_284 = IsKeyDown((int) 344L);
  I_285 = (long) (int) i_284;
  if (((long) I_285 == 0)) { mir_label = 1036; break; }
case 1038:
  f_286 = (float) 20L;
  f_287 = f3_wheelMove * f_286;
  f_288 = mir_read_float(168L + fp);
  f_288 = f_288 + f_287;
  mir_write_float(168L + fp, f_288);
  mir_label = 1040; break;
case 1036:
  f_290 = (float) 20L;
  f_291 = f3_wheelMove * f_290;
  f_292 = mir_read_float(172L + fp);
  f_292 = f_292 + f_291;
  mir_write_float(172L + fp, f_292);
case 1040:
  mir_label = 1041; break;
case 1031:
case 1041:
  mir_label = 1042; break;
case 1028:
case 1042:
  f_294 = - f0_horizontalMin;
  if (mir_read_float(168L + fp) > f_294) { mir_label = 1043; break; }
  mir_label = 1044; break;
case 1043:
  f_296 = - f0_horizontalMin;
  mir_write_float(168L + fp, f_296);
  mir_label = 1045; break;
case 1044:
case 1045:
  f_297 = - f0_horizontalMax;
  if (mir_read_float(168L + fp) < f_297) { mir_label = 1046; break; }
  mir_label = 1047; break;
case 1046:
  f_299 = - f0_horizontalMax;
  mir_write_float(168L + fp, f_299);
  mir_label = 1048; break;
case 1047:
case 1048:
  f_300 = - f0_verticalMin;
  if (mir_read_float(172L + fp) > f_300) { mir_label = 1049; break; }
  mir_label = 1050; break;
case 1049:
  f_302 = - f0_verticalMin;
  mir_write_float(172L + fp, f_302);
  mir_label = 1051; break;
case 1050:
case 1051:
  f_303 = - f0_verticalMax;
  if (mir_read_float(172L + fp) < f_303) { mir_label = 1052; break; }
  mir_label = 1053; break;
case 1052:
  f_305 = - f0_verticalMax;
  mir_write_float(172L + fp, f_305);
  mir_label = 1054; break;
case 1053:
case 1054:
  if ((long) U0_text == (long) 0L) { mir_label = 1055; break; }
case 1056:
  I_307 = (long) fp + (long) 48L;
  GuiStatusBar((long) I_307, (long) U0_text);
  mir_label = 1057; break;
case 1055:
case 1057:
  I_308 = (long) fp + (long) 8L;
  I_309 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(fp, I_309);
  I_310 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(1L + fp, I_310);
  I_311 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(2L + fp, I_311);
  I_312 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(3L + fp, I_312);
  I_313 = (long) fp + (long) 224L;
  i_314 = GuiGetStyle((int) 0L, (int) 19L);
  m2_GetColor((long) I_313, (int) i_314);
  m2_GuiDrawRectangle((long) I_308, (int) 0L, (long) fp, (long) I_313);
  i_315 = GuiGetStyle((int) 14L, (int) 19L);
  i0_slider = i_315;
  I_316 = (long) (int) i0_hasHorizontalScrollBar;
  if (((long) I_316 == 0)) { mir_label = 1058; break; }
case 1059:
  i_317 = GuiGetStyle((int) 0L, (int) 12L);
  i_318 = (int) 2L * (int) i_317;
  I_320 = (long) (int) i_318;
  f_319 = (float) I_320;
  f_321 = mir_read_float(16L + fp) - f_319;
  I_323 = (long) (int) i0_verticalScrollBarWidth;
  f_322 = (float) I_323;
  f_324 = f_321 - f_322;
  i_325 = (long) mir_read_float(36L + fp);
  I_327 = (long) (int) i_325;
  f_326 = (float) I_327;
  f_328 = f_324 / f_326;
  i_329 = (long) mir_read_float(16L + fp);
  i_330 = GuiGetStyle((int) 0L, (int) 12L);
  i_331 = (int) 2L * (int) i_330;
  i_332 = (int) i_329 - (int) i_331;
  i_333 = (int) i_332 - (int) i0_verticalScrollBarWidth;
  I_335 = (long) (int) i_333;
  f_334 = (float) I_335;
  f_336 = f_328 * f_334;
  i_337 = (long) f_336;
  GuiSetStyle((int) 14L, (int) 19L, (int) i_337);
  I_339 = (long) fp + (long) 68L;
  f_340 = - mir_read_float(168L + fp);
  i_341 = (long) f_340;
  i_342 = (long) f0_horizontalMin;
  i_343 = (long) f0_horizontalMax;
  i_338 = m2_GuiScrollBar((long) I_339, (int) i_341, (int) i_342, (int) i_343);
  i_344 = - (int) i_338;
  I_346 = (long) (int) i_344;
  f_345 = (float) I_346;
  mir_write_float(168L + fp, f_345);
  mir_label = 1060; break;
case 1058:
  mir_write_float(168L + fp, 0f);
case 1060:
  I_347 = (long) (int) i0_hasVerticalScrollBar;
  if (((long) I_347 == 0)) { mir_label = 1061; break; }
case 1062:
  i_348 = GuiGetStyle((int) 0L, (int) 12L);
  i_349 = (int) 2L * (int) i_348;
  I_351 = (long) (int) i_349;
  f_350 = (float) I_351;
  f_352 = mir_read_float(20L + fp) - f_350;
  I_354 = (long) (int) i0_horizontalScrollBarWidth;
  f_353 = (float) I_354;
  f_355 = f_352 - f_353;
  i_356 = (long) mir_read_float(40L + fp);
  I_358 = (long) (int) i_356;
  f_357 = (float) I_358;
  f_359 = f_355 / f_357;
  i_360 = (long) mir_read_float(20L + fp);
  i_361 = GuiGetStyle((int) 0L, (int) 12L);
  i_362 = (int) 2L * (int) i_361;
  i_363 = (int) i_360 - (int) i_362;
  i_364 = (int) i_363 - (int) i0_horizontalScrollBarWidth;
  I_366 = (long) (int) i_364;
  f_365 = (float) I_366;
  f_367 = f_359 * f_365;
  i_368 = (long) f_367;
  GuiSetStyle((int) 14L, (int) 19L, (int) i_368);
  I_370 = (long) fp + (long) 88L;
  f_371 = - mir_read_float(172L + fp);
  i_372 = (long) f_371;
  i_373 = (long) f0_verticalMin;
  i_374 = (long) f0_verticalMax;
  i_369 = m2_GuiScrollBar((long) I_370, (int) i_372, (int) i_373, (int) i_374);
  i_375 = - (int) i_369;
  I_377 = (long) (int) i_375;
  f_376 = (float) I_377;
  mir_write_float(172L + fp, f_376);
  mir_label = 1063; break;
case 1061:
  mir_write_float(172L + fp, 0f);
case 1063:
  I_378 = (long) (int) i0_hasHorizontalScrollBar;
  if (((long) I_378 == 0)) { mir_label = 1064; break; }
case 1065:
  I_379 = (long) (int) i0_hasVerticalScrollBar;
  if (((long) I_379 == 0)) { mir_label = 1064; break; }
case 1066:
  i_380 = GuiGetStyle((int) 12L, (int) 19L);
  if ((int) i_380 != (int) 0L) { mir_label = 1067; break; }
case 1068:
  i_382 = GuiGetStyle((int) 0L, (int) 12L);
  I_384 = (long) (int) i_382;
  f_383 = (float) I_384;
  f_385 = mir_read_float(8L + fp) + f_383;
  f_386 = (float) 2L;
  f_387 = f_385 + f_386;
  f_388 = f_387;
  mir_label = 1069; break;
case 1067:
  f_389 = mir_read_float(68L + fp) + mir_read_float(76L + fp);
  f_390 = (float) 2L;
  f_391 = f_389 + f_390;
  f_388 = f_391;
case 1069:
  mir_write_float(196L + fp, f_388);
  f_392 = mir_read_float(92L + fp) + mir_read_float(100L + fp);
  f_393 = (float) 2L;
  f_394 = f_392 + f_393;
  mir_write_float(200L + fp, f_394);
  I_396 = (long) (int) i0_horizontalScrollBarWidth;
  f_395 = (float) I_396;
  f_397 = (float) 4L;
  f_398 = f_395 - f_397;
  mir_write_float(204L + fp, f_398);
  I_400 = (long) (int) i0_verticalScrollBarWidth;
  f_399 = (float) I_400;
  f_401 = (float) 4L;
  f_402 = f_399 - f_401;
  mir_write_float(208L + fp, f_402);
  I_404 = (long) fp + (long) 212L;
  I_403 = memset((long) I_404, (int) 0L, (long) 4L);
  I_405 = (long) fp + (long) 196L;
  I_406 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(192L + fp, I_406);
  I_407 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(193L + fp, I_407);
  I_408 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(194L + fp, I_408);
  I_409 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(195L + fp, I_409);
  I_410 = (long) fp + (long) 192L;
  I_411 = (long) fp + (long) 224L;
  I_412 = (long) fp + (long) 240L;
  i_414 = (int) i0_state * (int) 3L;
  i_415 = (int) 2L + (int) i_414;
  i_413 = GuiGetStyle((int) 12L, (int) i_415);
  m2_GetColor((long) I_412, (int) i_413);
  I_416 = m2_guiAlpha;
  m2_Fade((long) I_411, (long) I_412, (float) mir_read_float(I_416));
  m2_GuiDrawRectangle((long) I_405, (int) 0L, (long) I_410, (long) I_411);
  mir_label = 1070; break;
case 1064:
case 1070:
  I_417 = (long) fp + (long) 8L;
  i_418 = GuiGetStyle((int) 0L, (int) 12L);
  I_419 = (long) fp + (long) 224L;
  I_420 = (long) fp + (long) 240L;
  i_422 = (int) i0_state * (int) 3L;
  i_423 = (int) 0L + (int) i_422;
  i_421 = GuiGetStyle((int) 12L, (int) i_423);
  m2_GetColor((long) I_420, (int) i_421);
  I_424 = m2_guiAlpha;
  m2_Fade((long) I_419, (long) I_420, (float) mir_read_float(I_424));
  I_425 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(4L + fp, I_425);
  I_426 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(5L + fp, I_426);
  I_427 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(6L + fp, I_427);
  I_428 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(7L + fp, I_428);
  I_429 = (long) fp + (long) 4L;
  m2_GuiDrawRectangle((long) I_417, (int) i_418, (long) I_419, (long) I_429);
  GuiSetStyle((int) 14L, (int) 19L, (int) i0_slider);
  if ((long) U0_scroll == (long) 0L) { mir_label = 1071; break; }
case 1072:
  I_432 = (long) fp + (long) 168L;
  I_431 = memcpy((long) U0_scroll, (long) I_432, (long) 24L);
  mir_label = 1073; break;
case 1071:
case 1073:
  I_434 = (long) fp + (long) 108L;
  I_433 = memcpy((long) Ret_Addr, (long) I_434, (long) 20L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiScrollPanel

public void GuiLabel (long _I0_bounds, long _U0_text) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long fp = 0;
  long I_0 = 0;
  long i0_state = 0;
  long I_1 = 0;
  long I_2 = 0;
  long i_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long i_8 = 0;
  long I_9 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(96L);
  I_0 = memcpy((long) fp, (long) I0_bounds, (long) 20L);
  I_1 = m2_guiState;
  i0_state = mir_read_int(I_1);
  I_2 = (long) fp + (long) 32L;
  m2_GetTextBounds((long) I_2, (int) 1L, (long) fp);
  i_3 = GuiGetStyle((int) 1L, (int) 14L);
  I_4 = (long) fp + (long) 64L;
  I_5 = (long) fp + (long) 80L;
  i_7 = (int) i0_state * (int) 3L;
  i_8 = (int) 2L + (int) i_7;
  i_6 = GuiGetStyle((int) 1L, (int) i_8);
  m2_GetColor((long) I_5, (int) i_6);
  I_9 = m2_guiAlpha;
  m2_Fade((long) I_4, (long) I_5, (float) mir_read_float(I_9));
  m2_GuiDrawText((long) U0_text, (long) I_2, (int) i_3, (long) I_4);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of function GuiLabel

public int GuiButton (long _I0_bounds, long _U0_text) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long fp = 0;
  long I_0 = 0;
  long i0_state = 0;
  long I_1 = 0;
  long i0_pressed = 0;
  long i_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long i_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long i_10 = 0;
  long I_11 = 0;
  long i_12 = 0;
  long I_13 = 0;
  long i_14 = 0;
  long I_15 = 0;
  long I_16 = 0;
  long i_17 = 0;
  long i_18 = 0;
  long i_19 = 0;
  long I_20 = 0;
  long I_21 = 0;
  long I_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long i_25 = 0;
  long I_26 = 0;
  long I_27 = 0;
  long i_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  long i_31 = 0;
  long i_32 = 0;
  long i_33 = 0;
  long I_34 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(112L);
  I_0 = memcpy((long) fp, (long) I0_bounds, (long) 20L);
  I_1 = m2_guiState;
  i0_state = mir_read_int(I_1);
  i0_pressed = 0L;
  if ((int) i0_state == (int) 3L) { mir_label = 1074; break; }
case 1075:
  I_3 = m2_guiLocked;
  if (((long) mir_read_int(I_3) != 0)) { mir_label = 1074; break; }
case 1076:
  I_4 = (long) fp + (long) 48L;
  GetMousePosition((long) I_4);
  I_6 = (long) fp + (long) 24L;
  I_5 = memcpy((long) I_6, (long) I_4, (long) 24L);
  I_8 = (long) fp + (long) 24L;
  i_7 = m2_CheckCollisionPointRec((long) I_8, (long) fp);
  I_9 = (long) (int) i_7;
  if (((long) I_9 == 0)) { mir_label = 1077; break; }
case 1078:
  i_10 = IsMouseButtonDown((int) 0L);
  I_11 = (long) (int) i_10;
  if (((long) I_11 == 0)) { mir_label = 1079; break; }
case 1080:
  i0_state = 2L;
  mir_label = 1081; break;
case 1079:
  i0_state = 1L;
case 1081:
  i_12 = IsMouseButtonReleased((int) 0L);
  I_13 = (long) (int) i_12;
  if (((long) I_13 == 0)) { mir_label = 1082; break; }
case 1083:
  i0_pressed = 1L;
  mir_label = 1084; break;
case 1082:
case 1084:
  mir_label = 1085; break;
case 1077:
case 1085:
  mir_label = 1086; break;
case 1074:
case 1086:
  i_14 = GuiGetStyle((int) 2L, (int) 12L);
  I_15 = (long) fp + (long) 48L;
  I_16 = (long) fp + (long) 64L;
  i_18 = (int) i0_state * (int) 3L;
  i_19 = (int) 0L + (int) i_18;
  i_17 = GuiGetStyle((int) 2L, (int) i_19);
  m2_GetColor((long) I_16, (int) i_17);
  I_20 = m2_guiAlpha;
  m2_Fade((long) I_15, (long) I_16, (float) mir_read_float(I_20));
  I_21 = (long) fp + (long) 64L;
  I_22 = (long) fp + (long) 80L;
  i_24 = (int) i0_state * (int) 3L;
  i_25 = (int) 1L + (int) i_24;
  i_23 = GuiGetStyle((int) 2L, (int) i_25);
  m2_GetColor((long) I_22, (int) i_23);
  I_26 = m2_guiAlpha;
  m2_Fade((long) I_21, (long) I_22, (float) mir_read_float(I_26));
  m2_GuiDrawRectangle((long) fp, (int) i_14, (long) I_15, (long) I_21);
  I_27 = (long) fp + (long) 48L;
  m2_GetTextBounds((long) I_27, (int) 2L, (long) fp);
  i_28 = GuiGetStyle((int) 2L, (int) 14L);
  I_29 = (long) fp + (long) 80L;
  I_30 = (long) fp + (long) 96L;
  i_32 = (int) i0_state * (int) 3L;
  i_33 = (int) 2L + (int) i_32;
  i_31 = GuiGetStyle((int) 2L, (int) i_33);
  m2_GetColor((long) I_30, (int) i_31);
  I_34 = m2_guiAlpha;
  m2_Fade((long) I_29, (long) I_30, (float) mir_read_float(I_34));
  m2_GuiDrawText((long) U0_text, (long) I_27, (int) i_28, (long) I_29);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_pressed;
} // End of switch
} // End of while
} // End of function GuiButton

public int GuiLabelButton (long _I0_bounds, long _U0_text) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long fp = 0;
  long I_0 = 0;
  long i0_state = 0;
  long I_1 = 0;
  long i0_pressed = 0;
  float f0_textWidth = 0;
  long i_2 = 0;
  float f_3 = 0;
  long I_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long I_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long i_11 = 0;
  long I_12 = 0;
  long I_13 = 0;
  long i_14 = 0;
  long I_15 = 0;
  long i_16 = 0;
  long I_17 = 0;
  long I_18 = 0;
  long i_19 = 0;
  long I_20 = 0;
  long I_21 = 0;
  long i_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long I_25 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(112L);
  I_0 = memcpy((long) fp, (long) I0_bounds, (long) 20L);
  I_1 = m2_guiState;
  i0_state = mir_read_int(I_1);
  i0_pressed = 0L;
  i_2 = m2_GetTextWidth((long) U0_text);
  I_4 = (long) (int) i_2;
  f_3 = (float) I_4;
  f0_textWidth = f_3;
  if (mir_read_float(8L + fp) < f0_textWidth) { mir_label = 1087; break; }
  mir_label = 1088; break;
case 1087:
  mir_write_float(8L + fp, f0_textWidth);
  mir_label = 1089; break;
case 1088:
case 1089:
  if ((int) i0_state == (int) 3L) { mir_label = 1090; break; }
case 1091:
  I_7 = m2_guiLocked;
  if (((long) mir_read_int(I_7) != 0)) { mir_label = 1090; break; }
case 1092:
  I_8 = (long) fp + (long) 48L;
  GetMousePosition((long) I_8);
  I_10 = (long) fp + (long) 24L;
  I_9 = memcpy((long) I_10, (long) I_8, (long) 24L);
  I_12 = (long) fp + (long) 24L;
  i_11 = m2_CheckCollisionPointRec((long) I_12, (long) fp);
  I_13 = (long) (int) i_11;
  if (((long) I_13 == 0)) { mir_label = 1093; break; }
case 1094:
  i_14 = IsMouseButtonDown((int) 0L);
  I_15 = (long) (int) i_14;
  if (((long) I_15 == 0)) { mir_label = 1095; break; }
case 1096:
  i0_state = 2L;
  mir_label = 1097; break;
case 1095:
  i0_state = 1L;
case 1097:
  i_16 = IsMouseButtonReleased((int) 0L);
  I_17 = (long) (int) i_16;
  if (((long) I_17 == 0)) { mir_label = 1098; break; }
case 1099:
  i0_pressed = 1L;
  mir_label = 1100; break;
case 1098:
case 1100:
  mir_label = 1101; break;
case 1093:
case 1101:
  mir_label = 1102; break;
case 1090:
case 1102:
  I_18 = (long) fp + (long) 48L;
  m2_GetTextBounds((long) I_18, (int) 1L, (long) fp);
  i_19 = GuiGetStyle((int) 1L, (int) 14L);
  I_20 = (long) fp + (long) 80L;
  I_21 = (long) fp + (long) 96L;
  i_23 = (int) i0_state * (int) 3L;
  i_24 = (int) 2L + (int) i_23;
  i_22 = GuiGetStyle((int) 1L, (int) i_24);
  m2_GetColor((long) I_21, (int) i_22);
  I_25 = m2_guiAlpha;
  m2_Fade((long) I_20, (long) I_21, (float) mir_read_float(I_25));
  m2_GuiDrawText((long) U0_text, (long) I_18, (int) i_19, (long) I_20);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_pressed;
} // End of switch
} // End of while
} // End of function GuiLabelButton

public int GuiToggle (long _I0_bounds, long _U0_text, int _i0_active) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long i0_active = _i0_active;
  long fp = 0;
  long I_0 = 0;
  long i0_state = 0;
  long I_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long i_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long i_10 = 0;
  long I_11 = 0;
  long i_12 = 0;
  long I_13 = 0;
  long I_14 = 0;
  long I_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  long i_20 = 0;
  long I_21 = 0;
  long i_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long I_25 = 0;
  long I_26 = 0;
  long I_27 = 0;
  long i_28 = 0;
  long I_29 = 0;
  long i_30 = 0;
  long i_31 = 0;
  long i_32 = 0;
  long I_33 = 0;
  long I_34 = 0;
  long i_35 = 0;
  long I_36 = 0;
  long I_37 = 0;
  long i_38 = 0;
  long I_39 = 0;
  long i_40 = 0;
  long i_41 = 0;
  long i_42 = 0;
  long I_43 = 0;
  long i_44 = 0;
  long I_45 = 0;
  long I_46 = 0;
  long i_47 = 0;
  long i_48 = 0;
  long i_49 = 0;
  long I_50 = 0;
  long I_51 = 0;
  long I_52 = 0;
  long i_53 = 0;
  long i_54 = 0;
  long i_55 = 0;
  long I_56 = 0;
  long I_57 = 0;
  long i_58 = 0;
  long I_59 = 0;
  long I_60 = 0;
  long i_61 = 0;
  long i_62 = 0;
  long i_63 = 0;
  long I_64 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(112L);
  I_0 = memcpy((long) fp, (long) I0_bounds, (long) 20L);
  I_1 = m2_guiState;
  i0_state = mir_read_int(I_1);
  if ((int) i0_state == (int) 3L) { mir_label = 1103; break; }
case 1104:
  I_3 = m2_guiLocked;
  if (((long) mir_read_int(I_3) != 0)) { mir_label = 1103; break; }
case 1105:
  I_4 = (long) fp + (long) 48L;
  GetMousePosition((long) I_4);
  I_6 = (long) fp + (long) 24L;
  I_5 = memcpy((long) I_6, (long) I_4, (long) 24L);
  I_8 = (long) fp + (long) 24L;
  i_7 = m2_CheckCollisionPointRec((long) I_8, (long) fp);
  I_9 = (long) (int) i_7;
  if (((long) I_9 == 0)) { mir_label = 1106; break; }
case 1107:
  i_10 = IsMouseButtonDown((int) 0L);
  I_11 = (long) (int) i_10;
  if (((long) I_11 == 0)) { mir_label = 1108; break; }
case 1109:
  i0_state = 2L;
  mir_label = 1110; break;
case 1108:
  i_12 = IsMouseButtonReleased((int) 0L);
  I_13 = (long) (int) i_12;
  if (((long) I_13 == 0)) { mir_label = 1111; break; }
case 1112:
  i0_state = 0L;
  I_15 = (long) (int) i0_active;
  if (((long) I_15 == 0)) { mir_label = 1113; break; }
case 1114:
  I_14 = 0L;
  mir_label = 1115; break;
case 1113:
  I_14 = 1L;
case 1115:
  i0_active = I_14;
  mir_label = 1116; break;
case 1111:
  i0_state = 1L;
case 1116:
case 1110:
  mir_label = 1117; break;
case 1106:
case 1117:
  mir_label = 1118; break;
case 1103:
case 1118:
  if ((int) i0_state != (int) 0L) { mir_label = 1119; break; }
case 1120:
  i_17 = GuiGetStyle((int) 3L, (int) 12L);
  I_18 = (long) fp + (long) 48L;
  I_19 = (long) fp + (long) 64L;
  I_21 = (long) (int) i0_active;
  if (((long) I_21 == 0)) { mir_label = 1121; break; }
case 1122:
  i_22 = 6L;
  mir_label = 1123; break;
case 1121:
  i_23 = (int) i0_state * (int) 3L;
  i_24 = (int) 0L + (int) i_23;
  i_22 = i_24;
case 1123:
  i_20 = GuiGetStyle((int) 3L, (int) i_22);
  m2_GetColor((long) I_19, (int) i_20);
  I_25 = m2_guiAlpha;
  m2_Fade((long) I_18, (long) I_19, (float) mir_read_float(I_25));
  I_26 = (long) fp + (long) 64L;
  I_27 = (long) fp + (long) 80L;
  I_29 = (long) (int) i0_active;
  if (((long) I_29 == 0)) { mir_label = 1124; break; }
case 1125:
  i_30 = 7L;
  mir_label = 1126; break;
case 1124:
  i_31 = (int) i0_state * (int) 3L;
  i_32 = (int) 1L + (int) i_31;
  i_30 = i_32;
case 1126:
  i_28 = GuiGetStyle((int) 3L, (int) i_30);
  m2_GetColor((long) I_27, (int) i_28);
  I_33 = m2_guiAlpha;
  m2_Fade((long) I_26, (long) I_27, (float) mir_read_float(I_33));
  m2_GuiDrawRectangle((long) fp, (int) i_17, (long) I_18, (long) I_26);
  I_34 = (long) fp + (long) 48L;
  m2_GetTextBounds((long) I_34, (int) 3L, (long) fp);
  i_35 = GuiGetStyle((int) 3L, (int) 14L);
  I_36 = (long) fp + (long) 80L;
  I_37 = (long) fp + (long) 96L;
  I_39 = (long) (int) i0_active;
  if (((long) I_39 == 0)) { mir_label = 1127; break; }
case 1128:
  i_40 = 8L;
  mir_label = 1129; break;
case 1127:
  i_41 = (int) i0_state * (int) 3L;
  i_42 = (int) 2L + (int) i_41;
  i_40 = i_42;
case 1129:
  i_38 = GuiGetStyle((int) 3L, (int) i_40);
  m2_GetColor((long) I_37, (int) i_38);
  I_43 = m2_guiAlpha;
  m2_Fade((long) I_36, (long) I_37, (float) mir_read_float(I_43));
  m2_GuiDrawText((long) U0_text, (long) I_34, (int) i_35, (long) I_36);
  mir_label = 1130; break;
case 1119:
  i_44 = GuiGetStyle((int) 3L, (int) 12L);
  I_45 = (long) fp + (long) 48L;
  I_46 = (long) fp + (long) 64L;
  i_48 = (int) i0_state * (int) 3L;
  i_49 = (int) 0L + (int) i_48;
  i_47 = GuiGetStyle((int) 3L, (int) i_49);
  m2_GetColor((long) I_46, (int) i_47);
  I_50 = m2_guiAlpha;
  m2_Fade((long) I_45, (long) I_46, (float) mir_read_float(I_50));
  I_51 = (long) fp + (long) 64L;
  I_52 = (long) fp + (long) 80L;
  i_54 = (int) i0_state * (int) 3L;
  i_55 = (int) 1L + (int) i_54;
  i_53 = GuiGetStyle((int) 3L, (int) i_55);
  m2_GetColor((long) I_52, (int) i_53);
  I_56 = m2_guiAlpha;
  m2_Fade((long) I_51, (long) I_52, (float) mir_read_float(I_56));
  m2_GuiDrawRectangle((long) fp, (int) i_44, (long) I_45, (long) I_51);
  I_57 = (long) fp + (long) 48L;
  m2_GetTextBounds((long) I_57, (int) 3L, (long) fp);
  i_58 = GuiGetStyle((int) 3L, (int) 14L);
  I_59 = (long) fp + (long) 80L;
  I_60 = (long) fp + (long) 96L;
  i_62 = (int) i0_state * (int) 3L;
  i_63 = (int) 2L + (int) i_62;
  i_61 = GuiGetStyle((int) 3L, (int) i_63);
  m2_GetColor((long) I_60, (int) i_61);
  I_64 = m2_guiAlpha;
  m2_Fade((long) I_59, (long) I_60, (float) mir_read_float(I_64));
  m2_GuiDrawText((long) U0_text, (long) I_57, (int) i_58, (long) I_59);
case 1130:
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_active;
} // End of switch
} // End of while
} // End of function GuiToggle

public int GuiToggleGroup (long _I0_bounds, long _U0_text, int _i0_active) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long i0_active = _i0_active;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  float f0_initBoundsX = 0;
  long I_2 = 0;
  long I_3 = 0;
  long U0_items = 0;
  long U_4 = 0;
  long U_5 = 0;
  long I_6 = 0;
  long i0_prevRow = 0;
  long I_7 = 0;
  long i_8 = 0;
  long i1_i = 0;
  long i_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  float f_14 = 0;
  long I_15 = 0;
  float f_16 = 0;
  float f_17 = 0;
  float f_18 = 0;
  long I_19 = 0;
  long I_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  long I_23 = 0;
  long I_24 = 0;
  long i_25 = 0;
  long I_26 = 0;
  long I_27 = 0;
  long i_28 = 0;
  long i_29 = 0;
  float f_30 = 0;
  long I_31 = 0;
  float f_32 = 0;
  float f_33 = 0;
  float f_34 = 0;
  long i_35 = 0;
  long i_36 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(160L);
  I_0 = (long) fp + (long) 4L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  f0_initBoundsX = mir_read_float(4L + fp);
  mir_write_int(32L + fp, 0L);
  I_3 = (long) fp + (long) 36L;
  I_2 = memset((long) I_3, (int) 0L, (long) 124L);
  mir_write_int(fp, 0L);
  U_5 = fp;
  I_6 = (long) fp + (long) 32L;
  U_4 = m2_GuiTextSplit((long) U0_text, (byte) 59L, (long) U_5, (long) I_6);
  U0_items = U_4;
  I_7 = (long) fp + (long) 32L;
  i_8 = 0L;
  i0_prevRow = mir_read_int(I_7 + i_8 * 4);
  i1_i = 0L;
  if ((int) i1_i >= (int) mir_read_int(fp)) { mir_label = 1131; break; }
case 1132:
  I_10 = (long) fp + (long) 32L;
  I_11 = (long) (int) i1_i;
  if ((int) i0_prevRow == (int) mir_read_int(I_10 + I_11 * 4)) { mir_label = 1133; break; }
case 1134:
  mir_write_float(4L + fp, f0_initBoundsX);
  i_13 = GuiGetStyle((int) 3L, (int) 16L);
  I_15 = (long) (int) i_13;
  f_14 = (float) I_15;
  f_16 = mir_read_float(16L + fp) + f_14;
  f_17 = mir_read_float(8L + fp);
  f_17 = f_17 + f_16;
  mir_write_float(8L + fp, f_17);
  I_19 = (long) fp + (long) 32L;
  I_20 = (long) (int) i1_i;
  i0_prevRow = mir_read_int(I_19 + I_20 * 4);
  mir_label = 1135; break;
case 1133:
case 1135:
  if ((int) i1_i != (int) i0_active) { mir_label = 1136; break; }
case 1137:
  I_23 = (long) fp + (long) 4L;
  I_24 = (long) (int) i1_i;
  i_22 = GuiToggle((long) I_23, (long) mir_read_ulong(U0_items + I_24 * 8), (int) 1L);
  mir_label = 1138; break;
case 1136:
  I_26 = (long) fp + (long) 4L;
  I_27 = (long) (int) i1_i;
  i_25 = GuiToggle((long) I_26, (long) mir_read_ulong(U0_items + I_27 * 8), (int) 0L);
  if ((int) i_25 != (int) 1L) { mir_label = 1139; break; }
case 1140:
  i0_active = i1_i;
  mir_label = 1141; break;
case 1139:
case 1141:
case 1138:
  i_29 = GuiGetStyle((int) 3L, (int) 16L);
  I_31 = (long) (int) i_29;
  f_30 = (float) I_31;
  f_32 = mir_read_float(12L + fp) + f_30;
  f_33 = mir_read_float(4L + fp);
  f_33 = f_33 + f_32;
  mir_write_float(4L + fp, f_33);
case 1142:
  i_35 = i1_i;
  i_35 = (int) i_35 + (int) 1L;
  i1_i = i_35;
  if ((int) i1_i < (int) mir_read_int(fp)) { mir_label = 1132; break; }
case 1131:
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_active;
} // End of switch
} // End of while
} // End of function GuiToggleGroup

public int GuiCheckBox (long _I0_bounds, long _U0_text, int _i0_checked) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long i0_checked = _i0_checked;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  float f_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  float f_8 = 0;
  long I_9 = 0;
  long i_10 = 0;
  float f_11 = 0;
  long I_12 = 0;
  float f_13 = 0;
  long i_14 = 0;
  float f_15 = 0;
  long I_16 = 0;
  float f_17 = 0;
  float f_18 = 0;
  float f_19 = 0;
  float f_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  float f_23 = 0;
  long I_24 = 0;
  float f_25 = 0;
  long i_26 = 0;
  long i_27 = 0;
  float f_28 = 0;
  long i_29 = 0;
  float f_30 = 0;
  long I_31 = 0;
  float f_32 = 0;
  long i_33 = 0;
  long I_34 = 0;
  long I_35 = 0;
  long I_36 = 0;
  long I_37 = 0;
  long i_38 = 0;
  long i_39 = 0;
  float f_40 = 0;
  float f_41 = 0;
  long i_42 = 0;
  float f_43 = 0;
  long I_44 = 0;
  float f_45 = 0;
  long I_46 = 0;
  long I_47 = 0;
  long i_48 = 0;
  long I_49 = 0;
  long I_50 = 0;
  long I_51 = 0;
  long i_52 = 0;
  long I_53 = 0;
  long i_54 = 0;
  long I_55 = 0;
  long I_56 = 0;
  long I_57 = 0;
  long I_58 = 0;
  long i_59 = 0;
  long I_60 = 0;
  long I_61 = 0;
  long i_62 = 0;
  long i_63 = 0;
  long i_64 = 0;
  long I_65 = 0;
  long I_66 = 0;
  long I_67 = 0;
  long I_68 = 0;
  long I_69 = 0;
  long I_70 = 0;
  long i_71 = 0;
  float f_72 = 0;
  long I_73 = 0;
  float f_74 = 0;
  long i_75 = 0;
  float f_76 = 0;
  long I_77 = 0;
  float f_78 = 0;
  long i_79 = 0;
  float f_80 = 0;
  long I_81 = 0;
  float f_82 = 0;
  long i_83 = 0;
  float f_84 = 0;
  long I_85 = 0;
  float f_86 = 0;
  long i_87 = 0;
  long i_88 = 0;
  long i_89 = 0;
  long i_90 = 0;
  float f_91 = 0;
  long I_92 = 0;
  float f_93 = 0;
  long i_94 = 0;
  long i_95 = 0;
  long i_96 = 0;
  long i_97 = 0;
  float f_98 = 0;
  long I_99 = 0;
  float f_100 = 0;
  long I_101 = 0;
  long I_102 = 0;
  long I_103 = 0;
  long I_104 = 0;
  long I_105 = 0;
  long I_106 = 0;
  long I_107 = 0;
  long I_108 = 0;
  long I_109 = 0;
  long I_110 = 0;
  long i_111 = 0;
  long i_112 = 0;
  long i_113 = 0;
  long I_114 = 0;
  long I_115 = 0;
  long i_116 = 0;
  long i_117 = 0;
  long i_118 = 0;
  long I_119 = 0;
  long I_120 = 0;
  long i_121 = 0;
  long i_122 = 0;
  long i_123 = 0;
  long I_124 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(128L);
  I_0 = (long) fp + (long) 4L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  f_3 = (float) 0L;
  mir_write_float(24L + fp, f_3);
  I_5 = (long) fp + (long) 28L;
  I_4 = memset((long) I_5, (int) 0L, (long) 16L);
  if ((long) U0_text == (long) 0L) { mir_label = 1143; break; }
case 1144:
  i_7 = m2_GetTextWidth((long) U0_text);
  I_9 = (long) (int) i_7;
  f_8 = (float) I_9;
  mir_write_float(32L + fp, f_8);
  i_10 = GuiGetStyle((int) 0L, (int) 16L);
  I_12 = (long) (int) i_10;
  f_11 = (float) I_12;
  mir_write_float(36L + fp, f_11);
  f_13 = mir_read_float(4L + fp) + mir_read_float(12L + fp);
  i_14 = GuiGetStyle((int) 6L, (int) 13L);
  I_16 = (long) (int) i_14;
  f_15 = (float) I_16;
  f_17 = f_13 + f_15;
  mir_write_float(24L + fp, f_17);
  f_18 = (float) 2L;
  f_19 = mir_read_float(16L + fp) / f_18;
  f_20 = mir_read_float(8L + fp) + f_19;
  i_21 = GuiGetStyle((int) 0L, (int) 16L);
  i_22 = (int) i_21 / (int) 2L;
  I_24 = (long) (int) i_22;
  f_23 = (float) I_24;
  f_25 = f_20 - f_23;
  mir_write_float(28L + fp, f_25);
  i_26 = GuiGetStyle((int) 6L, (int) 14L);
  if ((int) i_26 != (int) 0L) { mir_label = 1145; break; }
case 1146:
  f_28 = mir_read_float(4L + fp) - mir_read_float(32L + fp);
  i_29 = GuiGetStyle((int) 6L, (int) 13L);
  I_31 = (long) (int) i_29;
  f_30 = (float) I_31;
  f_32 = f_28 - f_30;
  mir_write_float(24L + fp, f_32);
  mir_label = 1147; break;
case 1145:
case 1147:
  mir_label = 1148; break;
case 1143:
case 1148:
  if ((int) i0_state == (int) 3L) { mir_label = 1149; break; }
case 1150:
  I_34 = m2_guiLocked;
  if (((long) mir_read_int(I_34) != 0)) { mir_label = 1149; break; }
case 1151:
  I_35 = (long) fp + (long) 96L;
  GetMousePosition((long) I_35);
  I_37 = (long) fp + (long) 64L;
  I_36 = memcpy((long) I_37, (long) I_35, (long) 24L);
  i_38 = GuiGetStyle((int) 6L, (int) 14L);
  if ((int) i_38 != (int) 0L) { mir_label = 1152; break; }
case 1153:
  f_40 = mir_read_float(24L + fp);
  mir_label = 1154; break;
case 1152:
  f_40 = mir_read_float(4L + fp);
case 1154:
  mir_write_float(44L + fp, f_40);
  mir_write_float(48L + fp, mir_read_float(8L + fp));
  f_41 = mir_read_float(12L + fp) + mir_read_float(32L + fp);
  i_42 = GuiGetStyle((int) 6L, (int) 13L);
  I_44 = (long) (int) i_42;
  f_43 = (float) I_44;
  f_45 = f_41 + f_43;
  mir_write_float(52L + fp, f_45);
  mir_write_float(56L + fp, mir_read_float(16L + fp));
  I_47 = (long) fp + (long) 60L;
  I_46 = memset((long) I_47, (int) 0L, (long) 4L);
  I_49 = (long) fp + (long) 64L;
  I_50 = (long) fp + (long) 44L;
  i_48 = m2_CheckCollisionPointRec((long) I_49, (long) I_50);
  I_51 = (long) (int) i_48;
  if (((long) I_51 == 0)) { mir_label = 1155; break; }
case 1156:
  i_52 = IsMouseButtonDown((int) 0L);
  I_53 = (long) (int) i_52;
  if (((long) I_53 == 0)) { mir_label = 1157; break; }
case 1158:
  i0_state = 2L;
  mir_label = 1159; break;
case 1157:
  i0_state = 1L;
case 1159:
  i_54 = IsMouseButtonReleased((int) 0L);
  I_55 = (long) (int) i_54;
  if (((long) I_55 == 0)) { mir_label = 1160; break; }
case 1161:
  I_57 = (long) (int) i0_checked;
  if (((long) I_57 == 0)) { mir_label = 1162; break; }
case 1163:
  I_56 = 0L;
  mir_label = 1164; break;
case 1162:
  I_56 = 1L;
case 1164:
  i0_checked = I_56;
  mir_label = 1165; break;
case 1160:
case 1165:
  mir_label = 1166; break;
case 1155:
case 1166:
  mir_label = 1167; break;
case 1149:
case 1167:
  I_58 = (long) fp + (long) 4L;
  i_59 = GuiGetStyle((int) 6L, (int) 12L);
  I_60 = (long) fp + (long) 96L;
  I_61 = (long) fp + (long) 112L;
  i_63 = (int) i0_state * (int) 3L;
  i_64 = (int) 0L + (int) i_63;
  i_62 = GuiGetStyle((int) 6L, (int) i_64);
  m2_GetColor((long) I_61, (int) i_62);
  I_65 = m2_guiAlpha;
  m2_Fade((long) I_60, (long) I_61, (float) mir_read_float(I_65));
  I_66 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(fp, I_66);
  I_67 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(1L + fp, I_67);
  I_68 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(2L + fp, I_68);
  I_69 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(3L + fp, I_69);
  m2_GuiDrawRectangle((long) I_58, (int) i_59, (long) I_60, (long) fp);
  I_70 = (long) (int) i0_checked;
  if (((long) I_70 == 0)) { mir_label = 1168; break; }
case 1169:
  i_71 = GuiGetStyle((int) 6L, (int) 12L);
  I_73 = (long) (int) i_71;
  f_72 = (float) I_73;
  f_74 = mir_read_float(4L + fp) + f_72;
  i_75 = GuiGetStyle((int) 6L, (int) 16L);
  I_77 = (long) (int) i_75;
  f_76 = (float) I_77;
  f_78 = f_74 + f_76;
  mir_write_float(48L + fp, f_78);
  i_79 = GuiGetStyle((int) 6L, (int) 12L);
  I_81 = (long) (int) i_79;
  f_80 = (float) I_81;
  f_82 = mir_read_float(8L + fp) + f_80;
  i_83 = GuiGetStyle((int) 6L, (int) 16L);
  I_85 = (long) (int) i_83;
  f_84 = (float) I_85;
  f_86 = f_82 + f_84;
  mir_write_float(52L + fp, f_86);
  i_87 = GuiGetStyle((int) 6L, (int) 12L);
  i_88 = GuiGetStyle((int) 6L, (int) 16L);
  i_89 = (int) i_87 + (int) i_88;
  i_90 = (int) 2L * (int) i_89;
  I_92 = (long) (int) i_90;
  f_91 = (float) I_92;
  f_93 = mir_read_float(12L + fp) - f_91;
  mir_write_float(56L + fp, f_93);
  i_94 = GuiGetStyle((int) 6L, (int) 12L);
  i_95 = GuiGetStyle((int) 6L, (int) 16L);
  i_96 = (int) i_94 + (int) i_95;
  i_97 = (int) 2L * (int) i_96;
  I_99 = (long) (int) i_97;
  f_98 = (float) I_99;
  f_100 = mir_read_float(16L + fp) - f_98;
  mir_write_float(60L + fp, f_100);
  I_102 = (long) fp + (long) 64L;
  I_101 = memset((long) I_102, (int) 0L, (long) 4L);
  I_103 = (long) fp + (long) 48L;
  I_104 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(44L + fp, I_104);
  I_105 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(45L + fp, I_105);
  I_106 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(46L + fp, I_106);
  I_107 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(47L + fp, I_107);
  I_108 = (long) fp + (long) 44L;
  I_109 = (long) fp + (long) 96L;
  I_110 = (long) fp + (long) 112L;
  i_112 = (int) i0_state * (int) 3L;
  i_113 = (int) 2L + (int) i_112;
  i_111 = GuiGetStyle((int) 6L, (int) i_113);
  m2_GetColor((long) I_110, (int) i_111);
  I_114 = m2_guiAlpha;
  m2_Fade((long) I_109, (long) I_110, (float) mir_read_float(I_114));
  m2_GuiDrawRectangle((long) I_103, (int) 0L, (long) I_108, (long) I_109);
  mir_label = 1170; break;
case 1168:
case 1170:
  I_115 = (long) fp + (long) 24L;
  i_116 = GuiGetStyle((int) 6L, (int) 14L);
  if ((int) i_116 != (int) 2L) { mir_label = 1171; break; }
case 1172:
  i_118 = 0L;
  mir_label = 1173; break;
case 1171:
  i_118 = 2L;
case 1173:
  I_119 = (long) fp + (long) 96L;
  I_120 = (long) fp + (long) 112L;
  i_122 = (int) i0_state * (int) 3L;
  i_123 = (int) 2L + (int) i_122;
  i_121 = GuiGetStyle((int) 1L, (int) i_123);
  m2_GetColor((long) I_120, (int) i_121);
  I_124 = m2_guiAlpha;
  m2_Fade((long) I_119, (long) I_120, (float) mir_read_float(I_124));
  m2_GuiDrawText((long) U0_text, (long) I_115, (int) i_118, (long) I_119);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_checked;
} // End of switch
} // End of while
} // End of function GuiCheckBox

public int GuiComboBox (long _I0_bounds, long _U0_text, int _i0_active) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long i0_active = _i0_active;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  long i_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  float f_6 = 0;
  long I_7 = 0;
  float f_8 = 0;
  float f_9 = 0;
  float f_10 = 0;
  float f_11 = 0;
  long i_12 = 0;
  float f_13 = 0;
  long I_14 = 0;
  float f_15 = 0;
  float f_16 = 0;
  long i_17 = 0;
  float f_18 = 0;
  long I_19 = 0;
  float f_20 = 0;
  long I_21 = 0;
  long I_22 = 0;
  long U0_items = 0;
  long U_23 = 0;
  long U_24 = 0;
  long i_25 = 0;
  long i_26 = 0;
  long i_27 = 0;
  long i_28 = 0;
  long i_29 = 0;
  long I_30 = 0;
  long i_31 = 0;
  long I_32 = 0;
  long I_33 = 0;
  long I_34 = 0;
  long i_35 = 0;
  long I_36 = 0;
  long I_37 = 0;
  long I_38 = 0;
  long i_39 = 0;
  long I_40 = 0;
  long I_41 = 0;
  long I_42 = 0;
  long i_43 = 0;
  long I_44 = 0;
  long i_45 = 0;
  long i_46 = 0;
  long i_47 = 0;
  long i_48 = 0;
  long I_49 = 0;
  long I_50 = 0;
  long i_51 = 0;
  long I_52 = 0;
  long I_53 = 0;
  long i_54 = 0;
  long i_55 = 0;
  long i_56 = 0;
  long I_57 = 0;
  long I_58 = 0;
  long I_59 = 0;
  long i_60 = 0;
  long i_61 = 0;
  long i_62 = 0;
  long I_63 = 0;
  long I_64 = 0;
  long I_65 = 0;
  long I_66 = 0;
  long i_67 = 0;
  long I_68 = 0;
  long I_69 = 0;
  long i_70 = 0;
  long i_71 = 0;
  long i_72 = 0;
  long I_73 = 0;
  long i0_tempBorderWidth = 0;
  long i_74 = 0;
  long i0_tempTextAlign = 0;
  long i_75 = 0;
  long i_76 = 0;
  long I_77 = 0;
  long U_78 = 0;
  long i_79 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(144L);
  I_0 = (long) fp + (long) 4L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  i_3 = GuiGetStyle((int) 7L, (int) 16L);
  i_4 = GuiGetStyle((int) 7L, (int) 17L);
  i_5 = (int) i_3 + (int) i_4;
  I_7 = (long) (int) i_5;
  f_6 = (float) I_7;
  f_8 = mir_read_float(12L + fp);
  f_8 = f_8 - f_6;
  mir_write_float(12L + fp, f_8);
  f_10 = mir_read_float(4L + fp);
  f_11 = f_10 + mir_read_float(12L + fp);
  i_12 = GuiGetStyle((int) 7L, (int) 17L);
  I_14 = (long) (int) i_12;
  f_13 = (float) I_14;
  f_15 = f_11 + f_13;
  mir_write_float(24L + fp, f_15);
  f_16 = mir_read_float(8L + fp);
  mir_write_float(28L + fp, f_16);
  i_17 = GuiGetStyle((int) 7L, (int) 16L);
  I_19 = (long) (int) i_17;
  f_18 = (float) I_19;
  mir_write_float(32L + fp, f_18);
  f_20 = mir_read_float(16L + fp);
  mir_write_float(36L + fp, f_20);
  I_22 = (long) fp + (long) 40L;
  I_21 = memset((long) I_22, (int) 0L, (long) 4L);
  mir_write_int(fp, 0L);
  U_24 = fp;
  U_23 = m2_GuiTextSplit((long) U0_text, (byte) 59L, (long) U_24, (long) 0L);
  U0_items = U_23;
  if ((int) i0_active >= (int) 0L) { mir_label = 1174; break; }
case 1175:
  i0_active = 0L;
  mir_label = 1176; break;
case 1174:
  i_26 = (int) mir_read_int(fp) - (int) 1L;
  if ((int) i0_active <= (int) i_26) { mir_label = 1177; break; }
case 1178:
  i_28 = (int) mir_read_int(fp) - (int) 1L;
  i0_active = i_28;
  mir_label = 1179; break;
case 1177:
case 1179:
case 1176:
  if ((int) i0_state == (int) 3L) { mir_label = 1180; break; }
case 1181:
  I_30 = m2_guiLocked;
  if (((long) mir_read_int(I_30) != 0)) { mir_label = 1180; break; }
case 1182:
  if ((int) mir_read_int(fp) <= (int) 1L) { mir_label = 1180; break; }
case 1183:
  I_32 = (long) fp + (long) 80L;
  GetMousePosition((long) I_32);
  I_34 = (long) fp + (long) 48L;
  I_33 = memcpy((long) I_34, (long) I_32, (long) 24L);
  I_36 = (long) fp + (long) 48L;
  I_37 = (long) fp + (long) 4L;
  i_35 = m2_CheckCollisionPointRec((long) I_36, (long) I_37);
  I_38 = (long) (int) i_35;
  if (((long) I_38 != 0)) { mir_label = 1184; break; }
case 1185:
  I_40 = (long) fp + (long) 48L;
  I_41 = (long) fp + (long) 24L;
  i_39 = m2_CheckCollisionPointRec((long) I_40, (long) I_41);
  I_42 = (long) (int) i_39;
  if (((long) I_42 == 0)) { mir_label = 1186; break; }
case 1184:
  i_43 = IsMouseButtonPressed((int) 0L);
  I_44 = (long) (int) i_43;
  if (((long) I_44 == 0)) { mir_label = 1187; break; }
case 1188:
  i_45 = i0_active;
  i_45 = (int) i_45 + (int) 1L;
  i0_active = i_45;
  if ((int) i0_active < (int) mir_read_int(fp)) { mir_label = 1189; break; }
case 1190:
  i0_active = 0L;
  mir_label = 1191; break;
case 1189:
case 1191:
  mir_label = 1192; break;
case 1187:
case 1192:
  i_48 = IsMouseButtonDown((int) 0L);
  I_49 = (long) (int) i_48;
  if (((long) I_49 == 0)) { mir_label = 1193; break; }
case 1194:
  i0_state = 2L;
  mir_label = 1195; break;
case 1193:
  i0_state = 1L;
case 1195:
  mir_label = 1196; break;
case 1186:
case 1196:
  mir_label = 1197; break;
case 1180:
case 1197:
  I_50 = (long) fp + (long) 4L;
  i_51 = GuiGetStyle((int) 7L, (int) 12L);
  I_52 = (long) fp + (long) 80L;
  I_53 = (long) fp + (long) 96L;
  i_55 = (int) i0_state * (int) 3L;
  i_56 = (int) 0L + (int) i_55;
  i_54 = GuiGetStyle((int) 7L, (int) i_56);
  m2_GetColor((long) I_53, (int) i_54);
  I_57 = m2_guiAlpha;
  m2_Fade((long) I_52, (long) I_53, (float) mir_read_float(I_57));
  I_58 = (long) fp + (long) 96L;
  I_59 = (long) fp + (long) 112L;
  i_61 = (int) i0_state * (int) 3L;
  i_62 = (int) 1L + (int) i_61;
  i_60 = GuiGetStyle((int) 7L, (int) i_62);
  m2_GetColor((long) I_59, (int) i_60);
  I_63 = m2_guiAlpha;
  m2_Fade((long) I_58, (long) I_59, (float) mir_read_float(I_63));
  m2_GuiDrawRectangle((long) I_50, (int) i_51, (long) I_52, (long) I_58);
  I_64 = (long) (int) i0_active;
  I_65 = (long) fp + (long) 80L;
  I_66 = (long) fp + (long) 4L;
  m2_GetTextBounds((long) I_65, (int) 7L, (long) I_66);
  i_67 = GuiGetStyle((int) 7L, (int) 14L);
  I_68 = (long) fp + (long) 112L;
  I_69 = (long) fp + (long) 128L;
  i_71 = (int) i0_state * (int) 3L;
  i_72 = (int) 2L + (int) i_71;
  i_70 = GuiGetStyle((int) 7L, (int) i_72);
  m2_GetColor((long) I_69, (int) i_70);
  I_73 = m2_guiAlpha;
  m2_Fade((long) I_68, (long) I_69, (float) mir_read_float(I_73));
  m2_GuiDrawText((long) mir_read_ulong(U0_items + I_64 * 8), (long) I_65, (int) i_67, (long) I_68);
  i_74 = GuiGetStyle((int) 2L, (int) 12L);
  i0_tempBorderWidth = i_74;
  i_75 = GuiGetStyle((int) 2L, (int) 14L);
  i0_tempTextAlign = i_75;
  GuiSetStyle((int) 2L, (int) 12L, (int) 1L);
  GuiSetStyle((int) 2L, (int) 14L, (int) 1L);
  I_77 = (long) fp + (long) 24L;
  i_79 = (int) i0_active + (int) 1L;
  U_78 = m2_TextFormat((long) mir_get_string_ptr("%i/%i"), i_79, mir_read_int(fp));
  i_76 = GuiButton((long) I_77, (long) U_78);
  GuiSetStyle((int) 2L, (int) 14L, (int) i0_tempTextAlign);
  GuiSetStyle((int) 2L, (int) 12L, (int) i0_tempBorderWidth);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_active;
} // End of switch
} // End of while
} // End of function GuiComboBox

public int GuiDropdownBox (long _I0_bounds, long _U0_text, long _U0_active, int _i0_editMode) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long U0_active = _U0_active;
  long i0_editMode = _i0_editMode;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  long i0_itemSelected = 0;
  long i0_itemFocused = 0;
  long U0_items = 0;
  long U_3 = 0;
  long U_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long I_7 = 0;
  long i_8 = 0;
  long i_9 = 0;
  float f_10 = 0;
  long I_11 = 0;
  float f_12 = 0;
  float f_13 = 0;
  long I_14 = 0;
  float f_15 = 0;
  long I_16 = 0;
  long I_17 = 0;
  long I_18 = 0;
  long i0_pressed = 0;
  long i_19 = 0;
  long I_20 = 0;
  long I_21 = 0;
  long i_22 = 0;
  long I_23 = 0;
  long I_24 = 0;
  long I_25 = 0;
  long I_26 = 0;
  long i_27 = 0;
  long I_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  long i_31 = 0;
  long I_32 = 0;
  long i_33 = 0;
  long I_34 = 0;
  long i_35 = 0;
  long I_36 = 0;
  long I_37 = 0;
  long I_38 = 0;
  long i_39 = 0;
  long I_40 = 0;
  long i4_i = 0;
  long i_41 = 0;
  long i_42 = 0;
  float f_43 = 0;
  long I_44 = 0;
  float f_45 = 0;
  float f_46 = 0;
  float f_47 = 0;
  long i_48 = 0;
  long I_49 = 0;
  long I_50 = 0;
  long I_51 = 0;
  long i_52 = 0;
  long I_53 = 0;
  long i_54 = 0;
  long i_55 = 0;
  long I_56 = 0;
  long I_57 = 0;
  long I_58 = 0;
  long i_59 = 0;
  long I_60 = 0;
  long I_61 = 0;
  long I_62 = 0;
  long i_63 = 0;
  long I_64 = 0;
  long I_65 = 0;
  long I_66 = 0;
  long I_67 = 0;
  long i_68 = 0;
  long I_69 = 0;
  long I_70 = 0;
  long i_71 = 0;
  long i_72 = 0;
  long i_73 = 0;
  long I_74 = 0;
  long I_75 = 0;
  long I_76 = 0;
  long i_77 = 0;
  long i_78 = 0;
  long i_79 = 0;
  long I_80 = 0;
  long I_81 = 0;
  long I_82 = 0;
  long I_83 = 0;
  long i_84 = 0;
  long I_85 = 0;
  long I_86 = 0;
  long i_87 = 0;
  long i_88 = 0;
  long i_89 = 0;
  long I_90 = 0;
  long I_91 = 0;
  long i12_i = 0;
  long i_92 = 0;
  long i_93 = 0;
  float f_94 = 0;
  long I_95 = 0;
  float f_96 = 0;
  float f_97 = 0;
  float f_98 = 0;
  long i_99 = 0;
  long I_100 = 0;
  long i_101 = 0;
  long I_102 = 0;
  long I_103 = 0;
  long i_104 = 0;
  long I_105 = 0;
  long I_106 = 0;
  long I_107 = 0;
  long i_108 = 0;
  long I_109 = 0;
  long I_110 = 0;
  long I_111 = 0;
  long I_112 = 0;
  long i_113 = 0;
  long I_114 = 0;
  long I_115 = 0;
  long i_116 = 0;
  long I_117 = 0;
  long i_118 = 0;
  long I_119 = 0;
  long i_120 = 0;
  long I_121 = 0;
  long I_122 = 0;
  long i_123 = 0;
  long I_124 = 0;
  long I_125 = 0;
  long I_126 = 0;
  long i_127 = 0;
  long I_128 = 0;
  long I_129 = 0;
  long I_130 = 0;
  long I_131 = 0;
  long i_132 = 0;
  long I_133 = 0;
  long I_134 = 0;
  long i_135 = 0;
  long I_136 = 0;
  long I_137 = 0;
  long I_138 = 0;
  long I_139 = 0;
  long i_140 = 0;
  long I_141 = 0;
  long I_142 = 0;
  long i_143 = 0;
  long I_144 = 0;
  long i_145 = 0;
  long i_146 = 0;
  float f_147 = 0;
  long i_148 = 0;
  float f_149 = 0;
  long I_150 = 0;
  float f_151 = 0;
  float f_152 = 0;
  float f_153 = 0;
  float f_154 = 0;
  float f_155 = 0;
  float f_156 = 0;
  float f_157 = 0;
  float f_158 = 0;
  long I_159 = 0;
  long I_160 = 0;
  long I_161 = 0;
  long I_162 = 0;
  long I_163 = 0;
  long i_164 = 0;
  long i_165 = 0;
  long i_166 = 0;
  long I_167 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(176L);
  I_0 = (long) fp + (long) 4L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  i0_itemSelected = mir_read_int(U0_active);
  i0_itemFocused = -1L;
  mir_write_int(fp, 0L);
  U_4 = fp;
  U_3 = m2_GuiTextSplit((long) U0_text, (byte) 59L, (long) U_4, (long) 0L);
  U0_items = U_3;
  I_6 = (long) fp + (long) 24L;
  I_7 = (long) fp + (long) 4L;
  I_5 = memcpy((long) I_6, (long) I_7, (long) 20L);
  i_8 = (int) mir_read_int(fp) + (int) 1L;
  i_9 = GuiGetStyle((int) 8L, (int) 17L);
  I_11 = (long) (int) i_9;
  f_10 = (float) I_11;
  f_12 = mir_read_float(16L + fp) + f_10;
  I_14 = (long) (int) i_8;
  f_13 = (float) I_14;
  f_15 = f_13 * f_12;
  mir_write_float(36L + fp, f_15);
  I_17 = (long) fp + (long) 44L;
  I_18 = (long) fp + (long) 4L;
  I_16 = memcpy((long) I_17, (long) I_18, (long) 20L);
  i0_pressed = 0L;
  if ((int) i0_state == (int) 3L) { mir_label = 1198; break; }
case 1199:
  I_20 = (long) (int) i0_editMode;
  if (((long) I_20 != 0)) { mir_label = 1200; break; }
case 1201:
  I_21 = m2_guiLocked;
  if (((long) mir_read_int(I_21) != 0)) { mir_label = 1198; break; }
case 1200:
  if ((int) mir_read_int(fp) <= (int) 1L) { mir_label = 1198; break; }
case 1202:
  I_23 = (long) fp + (long) 112L;
  GetMousePosition((long) I_23);
  I_25 = (long) fp + (long) 88L;
  I_24 = memcpy((long) I_25, (long) I_23, (long) 24L);
  I_26 = (long) (int) i0_editMode;
  if (((long) I_26 == 0)) { mir_label = 1203; break; }
case 1204:
  i0_state = 2L;
  I_28 = (long) fp + (long) 88L;
  I_29 = (long) fp + (long) 24L;
  i_27 = m2_CheckCollisionPointRec((long) I_28, (long) I_29);
  I_30 = (long) (int) i_27;
  if (((long) I_30 != 0)) { mir_label = 1205; break; }
case 1206:
  i_31 = IsMouseButtonPressed((int) 0L);
  I_32 = (long) (int) i_31;
  if (((long) I_32 != 0)) { mir_label = 1207; break; }
case 1208:
  i_33 = IsMouseButtonReleased((int) 0L);
  I_34 = (long) (int) i_33;
  if (((long) I_34 == 0)) { mir_label = 1209; break; }
case 1207:
  i0_pressed = 1L;
  mir_label = 1210; break;
case 1209:
case 1210:
  mir_label = 1211; break;
case 1205:
case 1211:
  I_36 = (long) fp + (long) 88L;
  I_37 = (long) fp + (long) 4L;
  i_35 = m2_CheckCollisionPointRec((long) I_36, (long) I_37);
  I_38 = (long) (int) i_35;
  if (((long) I_38 == 0)) { mir_label = 1212; break; }
case 1213:
  i_39 = IsMouseButtonPressed((int) 0L);
  I_40 = (long) (int) i_39;
  if (((long) I_40 == 0)) { mir_label = 1212; break; }
case 1214:
  i0_pressed = 1L;
  mir_label = 1215; break;
case 1212:
case 1215:
  i4_i = 0L;
  if ((int) i4_i >= (int) mir_read_int(fp)) { mir_label = 1216; break; }
case 1217:
  i_42 = GuiGetStyle((int) 8L, (int) 17L);
  I_44 = (long) (int) i_42;
  f_43 = (float) I_44;
  f_45 = mir_read_float(16L + fp) + f_43;
  f_46 = mir_read_float(48L + fp);
  f_46 = f_46 + f_45;
  mir_write_float(48L + fp, f_46);
  I_49 = (long) fp + (long) 88L;
  I_50 = (long) fp + (long) 44L;
  i_48 = m2_CheckCollisionPointRec((long) I_49, (long) I_50);
  I_51 = (long) (int) i_48;
  if (((long) I_51 == 0)) { mir_label = 1218; break; }
case 1219:
  i0_itemFocused = i4_i;
  i_52 = IsMouseButtonReleased((int) 0L);
  I_53 = (long) (int) i_52;
  if (((long) I_53 == 0)) { mir_label = 1220; break; }
case 1221:
  i0_itemSelected = i4_i;
  i0_pressed = 1L;
  mir_label = 1222; break;
case 1220:
case 1222:
  mir_label = 1216; break;
  // Dead code: mir_label = 1223; break;
case 1218:
case 1223:
case 1224:
  i_54 = i4_i;
  i_54 = (int) i_54 + (int) 1L;
  i4_i = i_54;
  if ((int) i4_i < (int) mir_read_int(fp)) { mir_label = 1217; break; }
case 1216:
  I_56 = (long) fp + (long) 44L;
  I_58 = (long) fp + (long) 4L;
  I_57 = memcpy((long) I_56, (long) I_58, (long) 20L);
  mir_label = 1225; break;
case 1203:
  I_60 = (long) fp + (long) 88L;
  I_61 = (long) fp + (long) 4L;
  i_59 = m2_CheckCollisionPointRec((long) I_60, (long) I_61);
  I_62 = (long) (int) i_59;
  if (((long) I_62 == 0)) { mir_label = 1226; break; }
case 1227:
  i_63 = IsMouseButtonPressed((int) 0L);
  I_64 = (long) (int) i_63;
  if (((long) I_64 == 0)) { mir_label = 1228; break; }
case 1229:
  i0_pressed = 1L;
  i0_state = 2L;
  mir_label = 1230; break;
case 1228:
  i0_state = 1L;
case 1230:
  mir_label = 1231; break;
case 1226:
case 1231:
case 1225:
  mir_label = 1232; break;
case 1198:
case 1232:
  I_65 = (long) (int) i0_editMode;
  if (((long) I_65 == 0)) { mir_label = 1233; break; }
case 1234:
  I_66 = (long) fp + (long) 24L;
  GuiPanel((long) I_66, (long) 0L);
  mir_label = 1235; break;
case 1233:
case 1235:
  I_67 = (long) fp + (long) 4L;
  i_68 = GuiGetStyle((int) 8L, (int) 12L);
  I_69 = (long) fp + (long) 112L;
  I_70 = (long) fp + (long) 128L;
  i_72 = (int) i0_state * (int) 3L;
  i_73 = (int) 0L + (int) i_72;
  i_71 = GuiGetStyle((int) 8L, (int) i_73);
  m2_GetColor((long) I_70, (int) i_71);
  I_74 = m2_guiAlpha;
  m2_Fade((long) I_69, (long) I_70, (float) mir_read_float(I_74));
  I_75 = (long) fp + (long) 128L;
  I_76 = (long) fp + (long) 144L;
  i_78 = (int) i0_state * (int) 3L;
  i_79 = (int) 1L + (int) i_78;
  i_77 = GuiGetStyle((int) 8L, (int) i_79);
  m2_GetColor((long) I_76, (int) i_77);
  I_80 = m2_guiAlpha;
  m2_Fade((long) I_75, (long) I_76, (float) mir_read_float(I_80));
  m2_GuiDrawRectangle((long) I_67, (int) i_68, (long) I_69, (long) I_75);
  I_81 = (long) (int) i0_itemSelected;
  I_82 = (long) fp + (long) 112L;
  I_83 = (long) fp + (long) 4L;
  m2_GetTextBounds((long) I_82, (int) 0L, (long) I_83);
  i_84 = GuiGetStyle((int) 8L, (int) 14L);
  I_85 = (long) fp + (long) 144L;
  I_86 = (long) fp + (long) 160L;
  i_88 = (int) i0_state * (int) 3L;
  i_89 = (int) 2L + (int) i_88;
  i_87 = GuiGetStyle((int) 8L, (int) i_89);
  m2_GetColor((long) I_86, (int) i_87);
  I_90 = m2_guiAlpha;
  m2_Fade((long) I_85, (long) I_86, (float) mir_read_float(I_90));
  m2_GuiDrawText((long) mir_read_ulong(U0_items + I_81 * 8), (long) I_82, (int) i_84, (long) I_85);
  I_91 = (long) (int) i0_editMode;
  if (((long) I_91 == 0)) { mir_label = 1236; break; }
case 1237:
  i12_i = 0L;
  if ((int) i12_i >= (int) mir_read_int(fp)) { mir_label = 1238; break; }
case 1239:
  i_93 = GuiGetStyle((int) 8L, (int) 17L);
  I_95 = (long) (int) i_93;
  f_94 = (float) I_95;
  f_96 = mir_read_float(16L + fp) + f_94;
  f_97 = mir_read_float(48L + fp);
  f_97 = f_97 + f_96;
  mir_write_float(48L + fp, f_97);
  if ((int) i12_i != (int) i0_itemSelected) { mir_label = 1240; break; }
case 1241:
  I_100 = (long) fp + (long) 44L;
  i_101 = GuiGetStyle((int) 8L, (int) 12L);
  I_102 = (long) fp + (long) 112L;
  I_103 = (long) fp + (long) 128L;
  i_104 = GuiGetStyle((int) 8L, (int) 6L);
  m2_GetColor((long) I_103, (int) i_104);
  I_105 = m2_guiAlpha;
  m2_Fade((long) I_102, (long) I_103, (float) mir_read_float(I_105));
  I_106 = (long) fp + (long) 128L;
  I_107 = (long) fp + (long) 144L;
  i_108 = GuiGetStyle((int) 8L, (int) 7L);
  m2_GetColor((long) I_107, (int) i_108);
  I_109 = m2_guiAlpha;
  m2_Fade((long) I_106, (long) I_107, (float) mir_read_float(I_109));
  m2_GuiDrawRectangle((long) I_100, (int) i_101, (long) I_102, (long) I_106);
  I_110 = (long) (int) i12_i;
  I_111 = (long) fp + (long) 112L;
  I_112 = (long) fp + (long) 44L;
  m2_GetTextBounds((long) I_111, (int) 0L, (long) I_112);
  i_113 = GuiGetStyle((int) 8L, (int) 14L);
  I_114 = (long) fp + (long) 144L;
  I_115 = (long) fp + (long) 160L;
  i_116 = GuiGetStyle((int) 8L, (int) 8L);
  m2_GetColor((long) I_115, (int) i_116);
  I_117 = m2_guiAlpha;
  m2_Fade((long) I_114, (long) I_115, (float) mir_read_float(I_117));
  m2_GuiDrawText((long) mir_read_ulong(U0_items + I_110 * 8), (long) I_111, (int) i_113, (long) I_114);
  mir_label = 1242; break;
case 1240:
  if ((int) i12_i != (int) i0_itemFocused) { mir_label = 1243; break; }
case 1244:
  I_119 = (long) fp + (long) 44L;
  i_120 = GuiGetStyle((int) 8L, (int) 12L);
  I_121 = (long) fp + (long) 112L;
  I_122 = (long) fp + (long) 128L;
  i_123 = GuiGetStyle((int) 8L, (int) 3L);
  m2_GetColor((long) I_122, (int) i_123);
  I_124 = m2_guiAlpha;
  m2_Fade((long) I_121, (long) I_122, (float) mir_read_float(I_124));
  I_125 = (long) fp + (long) 128L;
  I_126 = (long) fp + (long) 144L;
  i_127 = GuiGetStyle((int) 8L, (int) 4L);
  m2_GetColor((long) I_126, (int) i_127);
  I_128 = m2_guiAlpha;
  m2_Fade((long) I_125, (long) I_126, (float) mir_read_float(I_128));
  m2_GuiDrawRectangle((long) I_119, (int) i_120, (long) I_121, (long) I_125);
  I_129 = (long) (int) i12_i;
  I_130 = (long) fp + (long) 112L;
  I_131 = (long) fp + (long) 44L;
  m2_GetTextBounds((long) I_130, (int) 0L, (long) I_131);
  i_132 = GuiGetStyle((int) 8L, (int) 14L);
  I_133 = (long) fp + (long) 144L;
  I_134 = (long) fp + (long) 160L;
  i_135 = GuiGetStyle((int) 8L, (int) 5L);
  m2_GetColor((long) I_134, (int) i_135);
  I_136 = m2_guiAlpha;
  m2_Fade((long) I_133, (long) I_134, (float) mir_read_float(I_136));
  m2_GuiDrawText((long) mir_read_ulong(U0_items + I_129 * 8), (long) I_130, (int) i_132, (long) I_133);
  mir_label = 1245; break;
case 1243:
  I_137 = (long) (int) i12_i;
  I_138 = (long) fp + (long) 112L;
  I_139 = (long) fp + (long) 44L;
  m2_GetTextBounds((long) I_138, (int) 0L, (long) I_139);
  i_140 = GuiGetStyle((int) 8L, (int) 14L);
  I_141 = (long) fp + (long) 144L;
  I_142 = (long) fp + (long) 160L;
  i_143 = GuiGetStyle((int) 8L, (int) 2L);
  m2_GetColor((long) I_142, (int) i_143);
  I_144 = m2_guiAlpha;
  m2_Fade((long) I_141, (long) I_142, (float) mir_read_float(I_144));
  m2_GuiDrawText((long) mir_read_ulong(U0_items + I_137 * 8), (long) I_138, (int) i_140, (long) I_141);
case 1245:
case 1242:
case 1246:
  i_145 = i12_i;
  i_145 = (int) i_145 + (int) 1L;
  i12_i = i_145;
  if ((int) i12_i < (int) mir_read_int(fp)) { mir_label = 1239; break; }
case 1238:
  mir_label = 1247; break;
case 1236:
case 1247:
  f_147 = mir_read_float(4L + fp) + mir_read_float(12L + fp);
  i_148 = GuiGetStyle((int) 8L, (int) 16L);
  I_150 = (long) (int) i_148;
  f_149 = (float) I_150;
  f_151 = f_147 - f_149;
  mir_write_float(64L + fp, f_151);
  f_152 = (float) 2L;
  f_153 = mir_read_float(16L + fp) / f_152;
  f_154 = mir_read_float(8L + fp) + f_153;
  f_155 = (float) 6L;
  f_156 = f_154 - f_155;
  mir_write_float(68L + fp, f_156);
  f_157 = (float) 10L;
  mir_write_float(72L + fp, f_157);
  f_158 = (float) 10L;
  mir_write_float(76L + fp, f_158);
  I_160 = (long) fp + (long) 80L;
  I_159 = memset((long) I_160, (int) 0L, (long) 4L);
  I_161 = (long) fp + (long) 64L;
  I_162 = (long) fp + (long) 112L;
  I_163 = (long) fp + (long) 128L;
  i_165 = (int) i0_state * (int) 3L;
  i_166 = (int) 2L + (int) i_165;
  i_164 = GuiGetStyle((int) 8L, (int) i_166);
  m2_GetColor((long) I_163, (int) i_164);
  I_167 = m2_guiAlpha;
  m2_Fade((long) I_162, (long) I_163, (float) mir_read_float(I_167));
  m2_GuiDrawText((long) mir_get_string_ptr("#120#"), (long) I_161, (int) 1L, (long) I_162);
  mir_write_int(U0_active, i0_itemSelected);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_pressed;
} // End of switch
} // End of while
} // End of function GuiDropdownBox

public int GuiTextBox (long _I0_bounds, long _U0_text, int _i0_textSize, int _i0_editMode) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long i0_textSize = _i0_textSize;
  long i0_editMode = _i0_editMode;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long i0_pressed = 0;
  long i0_textWidth = 0;
  long i_7 = 0;
  long i_8 = 0;
  float f_9 = 0;
  long I_10 = 0;
  float f_11 = 0;
  float f_12 = 0;
  long I_13 = 0;
  float f_14 = 0;
  float f_15 = 0;
  float f_16 = 0;
  float f_17 = 0;
  float f_18 = 0;
  float f_19 = 0;
  long i_20 = 0;
  float f_21 = 0;
  long I_22 = 0;
  float f_23 = 0;
  float f_24 = 0;
  long i_25 = 0;
  float f_26 = 0;
  long I_27 = 0;
  float f_28 = 0;
  float f_29 = 0;
  long I_30 = 0;
  long I_31 = 0;
  long i_32 = 0;
  long i_33 = 0;
  long i_34 = 0;
  float f_35 = 0;
  long I_36 = 0;
  float f_37 = 0;
  long i_38 = 0;
  float f_39 = 0;
  long I_40 = 0;
  float f_41 = 0;
  long i_42 = 0;
  long i_43 = 0;
  float f_44 = 0;
  long I_45 = 0;
  float f_46 = 0;
  long i_47 = 0;
  long I_48 = 0;
  long I_49 = 0;
  long I_50 = 0;
  long I_51 = 0;
  long I_52 = 0;
  long i2_key = 0;
  long i_53 = 0;
  long i2_keyCount = 0;
  long U_54 = 0;
  long i_55 = 0;
  long U2_textUTF8 = 0;
  long U_56 = 0;
  long U_57 = 0;
  long i_58 = 0;
  long i_59 = 0;
  long i_60 = 0;
  long i5_i = 0;
  long i_61 = 0;
  long I_62 = 0;
  long I_63 = 0;
  long I_64 = 0;
  long i_65 = 0;
  long i_66 = 0;
  long i_67 = 0;
  long I_68 = 0;
  long I_69 = 0;
  long i_70 = 0;
  long i_71 = 0;
  long I_72 = 0;
  long i_73 = 0;
  long i_74 = 0;
  long i_75 = 0;
  long I_76 = 0;
  long i_77 = 0;
  long i_78 = 0;
  long i_79 = 0;
  long i_80 = 0;
  long i_81 = 0;
  long I_82 = 0;
  long i_83 = 0;
  long i_84 = 0;
  long I_85 = 0;
  long I_86 = 0;
  long i_87 = 0;
  long I_88 = 0;
  long i_89 = 0;
  long I_90 = 0;
  long I_91 = 0;
  long I_92 = 0;
  long i_93 = 0;
  long I_94 = 0;
  long i_95 = 0;
  long I_96 = 0;
  long I_97 = 0;
  long I_98 = 0;
  long i_99 = 0;
  long I_100 = 0;
  long i_101 = 0;
  long I_102 = 0;
  long i_103 = 0;
  long I_104 = 0;
  long I_105 = 0;
  long i_106 = 0;
  long i_107 = 0;
  long i_108 = 0;
  long I_109 = 0;
  long I_110 = 0;
  long I_111 = 0;
  long i_112 = 0;
  long I_113 = 0;
  long i_114 = 0;
  long I_115 = 0;
  long i_116 = 0;
  long I_117 = 0;
  long I_118 = 0;
  long i_119 = 0;
  long i_120 = 0;
  long i_121 = 0;
  long I_122 = 0;
  long I_123 = 0;
  long I_124 = 0;
  long i_125 = 0;
  long I_126 = 0;
  long I_127 = 0;
  long I_128 = 0;
  long I_129 = 0;
  long i_130 = 0;
  long i_131 = 0;
  long i_132 = 0;
  long I_133 = 0;
  long I_134 = 0;
  long I_135 = 0;
  long I_136 = 0;
  long I_137 = 0;
  long I_138 = 0;
  float f_139 = 0;
  long I_140 = 0;
  long i_141 = 0;
  long i_142 = 0;
  long i_143 = 0;
  long i_144 = 0;
  long U_145 = 0;
  long U_146 = 0;
  long U_147 = 0;
  long U_148 = 0;
  long i_149 = 0;
  float f_150 = 0;
  long I_151 = 0;
  float f_152 = 0;
  float f_153 = 0;
  float f_154 = 0;
  float f_155 = 0;
  long I_156 = 0;
  long i_157 = 0;
  long i_158 = 0;
  long i_159 = 0;
  long I_160 = 0;
  long i_161 = 0;
  long I_162 = 0;
  long I_163 = 0;
  long i_164 = 0;
  long i_165 = 0;
  long i_166 = 0;
  long I_167 = 0;
  long I_168 = 0;
  long I_169 = 0;
  long I_170 = 0;
  long I_171 = 0;
  long I_172 = 0;
  long I_173 = 0;
  long I_174 = 0;
  long I_175 = 0;
  long I_176 = 0;
  long i_177 = 0;
  long I_178 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(160L);
  I_0 = (long) fp + (long) 8L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  I_3 = (long) fp + (long) 112L;
  I_4 = (long) fp + (long) 8L;
  m2_GetTextBounds((long) I_3, (int) 9L, (long) I_4);
  I_6 = (long) fp + (long) 28L;
  I_5 = memcpy((long) I_6, (long) I_3, (long) 20L);
  i0_pressed = 0L;
  i_7 = m2_GetTextWidth((long) U0_text);
  i0_textWidth = i_7;
  i_8 = GuiGetStyle((int) 9L, (int) 13L);
  I_10 = (long) (int) i_8;
  f_9 = (float) I_10;
  f_11 = mir_read_float(8L + fp) + f_9;
  I_13 = (long) (int) i0_textWidth;
  f_12 = (float) I_13;
  f_14 = f_11 + f_12;
  f_15 = (float) 2L;
  f_16 = f_14 + f_15;
  mir_write_float(48L + fp, f_16);
  f_17 = (float) 2L;
  f_18 = mir_read_float(20L + fp) / f_17;
  f_19 = mir_read_float(12L + fp) + f_18;
  i_20 = GuiGetStyle((int) 0L, (int) 16L);
  I_22 = (long) (int) i_20;
  f_21 = (float) I_22;
  f_23 = f_19 - f_21;
  mir_write_float(52L + fp, f_23);
  f_24 = (float) 4L;
  mir_write_float(56L + fp, f_24);
  i_25 = GuiGetStyle((int) 0L, (int) 16L);
  I_27 = (long) (int) i_25;
  f_26 = (float) I_27;
  f_28 = (float) 2L;
  f_29 = f_26 * f_28;
  mir_write_float(60L + fp, f_29);
  I_31 = (long) fp + (long) 64L;
  I_30 = memset((long) I_31, (int) 0L, (long) 4L);
  if (mir_read_float(60L + fp) >= mir_read_float(20L + fp)) { mir_label = 1248; break; }
  mir_label = 1249; break;
case 1248:
  i_33 = GuiGetStyle((int) 9L, (int) 12L);
  i_34 = (int) i_33 * (int) 2L;
  I_36 = (long) (int) i_34;
  f_35 = (float) I_36;
  f_37 = mir_read_float(20L + fp) - f_35;
  mir_write_float(60L + fp, f_37);
  mir_label = 1250; break;
case 1249:
case 1250:
  i_38 = GuiGetStyle((int) 9L, (int) 12L);
  I_40 = (long) (int) i_38;
  f_39 = (float) I_40;
  f_41 = mir_read_float(12L + fp) + f_39;
  if (mir_read_float(52L + fp) < f_41) { mir_label = 1251; break; }
  mir_label = 1252; break;
case 1251:
  i_43 = GuiGetStyle((int) 9L, (int) 12L);
  I_45 = (long) (int) i_43;
  f_44 = (float) I_45;
  f_46 = mir_read_float(12L + fp) + f_44;
  mir_write_float(52L + fp, f_46);
  mir_label = 1253; break;
case 1252:
case 1253:
  if ((int) i0_state == (int) 3L) { mir_label = 1254; break; }
case 1255:
  I_48 = m2_guiLocked;
  if (((long) mir_read_int(I_48) != 0)) { mir_label = 1254; break; }
case 1256:
  I_49 = (long) fp + (long) 112L;
  GetMousePosition((long) I_49);
  I_51 = (long) fp + (long) 72L;
  I_50 = memcpy((long) I_51, (long) I_49, (long) 24L);
  I_52 = (long) (int) i0_editMode;
  if (((long) I_52 == 0)) { mir_label = 1257; break; }
case 1258:
  i0_state = 2L;
  i_53 = GetCharPressed();
  i2_key = i_53;
  U_54 = strlen((long) U0_text);
  i_55 = U_54;
  i2_keyCount = i_55;
  mir_write_int(96L + fp, 0L);
  U_57 = 96L;
  U_57 = (long) U_57 + (long) fp;
  U_56 = m2_CodepointToUTF8((int) i2_key, (long) U_57);
  U2_textUTF8 = U_56;
  i_58 = (int) i2_keyCount + (int) mir_read_int(96L + fp);
  if ((int) i_58 >= (int) i0_textSize) { mir_label = 1259; break; }
case 1260:
  if ((int) i2_key < (int) 32L) { mir_label = 1261; break; }
case 1262:
  i5_i = 0L;
  if ((int) i5_i >= (int) mir_read_int(96L + fp)) { mir_label = 1263; break; }
case 1264:
  I_62 = (long) (int) i2_keyCount;
  I_63 = (long) (int) i5_i;
  I_64 = (long) (byte) mir_read_byte(U2_textUTF8 + I_63);
  mir_write_byte(U0_text + I_62, I_64);
  i_65 = i2_keyCount;
  i_65 = (int) i_65 + (int) 1L;
  i2_keyCount = i_65;
case 1265:
  i_66 = i5_i;
  i_66 = (int) i_66 + (int) 1L;
  i5_i = i_66;
  if ((int) i5_i < (int) mir_read_int(96L + fp)) { mir_label = 1264; break; }
case 1263:
  I_68 = (long) (int) i2_keyCount;
  I_69 = (long) (byte) 0L;
  mir_write_byte(U0_text + I_68, I_69);
  mir_label = 1266; break;
case 1261:
case 1266:
  mir_label = 1267; break;
case 1259:
case 1267:
  if ((int) i2_keyCount <= (int) 0L) { mir_label = 1268; break; }
case 1269:
  i_71 = IsKeyPressed((int) 259L);
  I_72 = (long) (int) i_71;
  if (((long) I_72 == 0)) { mir_label = 1270; break; }
case 1271:
case 1272:
  if ((int) i2_keyCount <= (int) 0L) { mir_label = 1273; break; }
case 1274:
  i_74 = i2_keyCount;
  i_74 = (int) i_74 - (int) 1L;
  i2_keyCount = i_74;
  i_75 = i_74;
  I_76 = (long) (int) i_75;
  i_77 = (int) mir_read_byte(U0_text + I_76) & (int) 192L;
  if ((int) i_77 != (int) 128L) { mir_label = 1273; break; }
case 1275:
  if ((int) i2_keyCount <= (int) 0L) { mir_label = 1273; break; }
case 1276:
  i_80 = i2_keyCount;
  i_80 = (int) i_80 - (int) 1L;
  i2_keyCount = i_80;
  i_81 = i_80;
  I_82 = (long) (int) i_81;
  i_83 = (int) mir_read_byte(U0_text + I_82) & (int) 192L;
  if ((int) i_83 == (int) 128L) { mir_label = 1275; break; }
case 1273:
  I_85 = (long) (int) i2_keyCount;
  I_86 = (long) (byte) 0L;
  mir_write_byte(U0_text + I_85, I_86);
  mir_label = 1277; break;
case 1270:
case 1277:
  mir_label = 1278; break;
case 1268:
case 1278:
  i_87 = IsKeyPressed((int) 257L);
  I_88 = (long) (int) i_87;
  if (((long) I_88 != 0)) { mir_label = 1279; break; }
case 1280:
  I_90 = (long) fp + (long) 72L;
  I_91 = (long) fp + (long) 8L;
  i_89 = m2_CheckCollisionPointRec((long) I_90, (long) I_91);
  I_92 = (long) (int) i_89;
  if (((long) I_92 != 0)) { mir_label = 1281; break; }
case 1282:
  i_93 = IsMouseButtonPressed((int) 0L);
  I_94 = (long) (int) i_93;
  if (((long) I_94 == 0)) { mir_label = 1281; break; }
case 1279:
  i0_pressed = 1L;
  mir_label = 1283; break;
case 1281:
case 1283:
  mir_label = 1284; break;
case 1257:
  I_96 = (long) fp + (long) 72L;
  I_97 = (long) fp + (long) 8L;
  i_95 = m2_CheckCollisionPointRec((long) I_96, (long) I_97);
  I_98 = (long) (int) i_95;
  if (((long) I_98 == 0)) { mir_label = 1285; break; }
case 1286:
  i0_state = 1L;
  i_99 = IsMouseButtonPressed((int) 0L);
  I_100 = (long) (int) i_99;
  if (((long) I_100 == 0)) { mir_label = 1287; break; }
case 1288:
  i0_pressed = 1L;
  mir_label = 1289; break;
case 1287:
case 1289:
  mir_label = 1290; break;
case 1285:
case 1290:
case 1284:
  mir_label = 1291; break;
case 1254:
case 1291:
  if ((int) i0_state != (int) 2L) { mir_label = 1292; break; }
case 1293:
  I_102 = (long) fp + (long) 8L;
  i_103 = GuiGetStyle((int) 9L, (int) 12L);
  I_104 = (long) fp + (long) 112L;
  I_105 = (long) fp + (long) 128L;
  i_107 = (int) i0_state * (int) 3L;
  i_108 = (int) 0L + (int) i_107;
  i_106 = GuiGetStyle((int) 9L, (int) i_108);
  m2_GetColor((long) I_105, (int) i_106);
  I_109 = m2_guiAlpha;
  m2_Fade((long) I_104, (long) I_105, (float) mir_read_float(I_109));
  I_110 = (long) fp + (long) 128L;
  I_111 = (long) fp + (long) 144L;
  i_112 = GuiGetStyle((int) 9L, (int) 7L);
  m2_GetColor((long) I_111, (int) i_112);
  I_113 = m2_guiAlpha;
  m2_Fade((long) I_110, (long) I_111, (float) mir_read_float(I_113));
  m2_GuiDrawRectangle((long) I_102, (int) i_103, (long) I_104, (long) I_110);
  mir_label = 1294; break;
case 1292:
  if ((int) i0_state != (int) 3L) { mir_label = 1295; break; }
case 1296:
  I_115 = (long) fp + (long) 8L;
  i_116 = GuiGetStyle((int) 9L, (int) 12L);
  I_117 = (long) fp + (long) 112L;
  I_118 = (long) fp + (long) 128L;
  i_120 = (int) i0_state * (int) 3L;
  i_121 = (int) 0L + (int) i_120;
  i_119 = GuiGetStyle((int) 9L, (int) i_121);
  m2_GetColor((long) I_118, (int) i_119);
  I_122 = m2_guiAlpha;
  m2_Fade((long) I_117, (long) I_118, (float) mir_read_float(I_122));
  I_123 = (long) fp + (long) 128L;
  I_124 = (long) fp + (long) 144L;
  i_125 = GuiGetStyle((int) 9L, (int) 10L);
  m2_GetColor((long) I_124, (int) i_125);
  I_126 = m2_guiAlpha;
  m2_Fade((long) I_123, (long) I_124, (float) mir_read_float(I_126));
  m2_GuiDrawRectangle((long) I_115, (int) i_116, (long) I_117, (long) I_123);
  mir_label = 1297; break;
case 1295:
  I_127 = (long) fp + (long) 8L;
  I_128 = (long) fp + (long) 112L;
  I_129 = (long) fp + (long) 128L;
  i_131 = (int) i0_state * (int) 3L;
  i_132 = (int) 0L + (int) i_131;
  i_130 = GuiGetStyle((int) 9L, (int) i_132);
  m2_GetColor((long) I_129, (int) i_130);
  I_133 = m2_guiAlpha;
  m2_Fade((long) I_128, (long) I_129, (float) mir_read_float(I_133));
  I_134 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(fp, I_134);
  I_135 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(1L + fp, I_135);
  I_136 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(2L + fp, I_136);
  I_137 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(3L + fp, I_137);
  m2_GuiDrawRectangle((long) I_127, (int) 1L, (long) I_128, (long) fp);
case 1297:
case 1294:
  I_138 = (long) (int) i0_editMode;
  if (((long) I_138 == 0)) { mir_label = 1298; break; }
case 1299:
case 1300:
  I_140 = (long) (int) i0_textWidth;
  f_139 = (float) I_140;
  if (f_139 >= mir_read_float(36L + fp)) { mir_label = 1301; break; }
  mir_label = 1302; break;
case 1301:
  i_142 = 0L;
  if ((int) mir_read_byte(U0_text + i_142) == (int) 0L) { mir_label = 1302; break; }
case 1303:
  mir_write_int(68L + fp, 0L);
  U_145 = 68L;
  U_145 = (long) U_145 + (long) fp;
  i_144 = m2_GetCodepointNext((long) U0_text, (long) U_145);
  U_146 = U0_text;
  U_147 = (long) mir_read_int(68L + fp) * (long) 1L;
  U_146 = (long) U_146 + (long) U_147;
  U0_text = U_146;
  i_149 = m2_GetTextWidth((long) U0_text);
  i0_textWidth = i_149;
  I_151 = (long) (int) i0_textWidth;
  f_150 = (float) I_151;
  f_152 = mir_read_float(28L + fp) + f_150;
  f_153 = (float) 2L;
  f_154 = f_152 + f_153;
  mir_write_float(48L + fp, f_154);
  I_156 = (long) (int) i0_textWidth;
  f_155 = (float) I_156;
  if (f_155 >= mir_read_float(36L + fp)) { mir_label = 1304; break; }
  mir_label = 1302; break;
case 1304:
  i_158 = 0L;
  if ((int) mir_read_byte(U0_text + i_158) != (int) 0L) { mir_label = 1303; break; }
case 1302:
  mir_label = 1305; break;
case 1298:
case 1305:
  I_160 = (long) fp + (long) 28L;
  i_161 = GuiGetStyle((int) 9L, (int) 14L);
  I_162 = (long) fp + (long) 112L;
  I_163 = (long) fp + (long) 128L;
  i_165 = (int) i0_state * (int) 3L;
  i_166 = (int) 2L + (int) i_165;
  i_164 = GuiGetStyle((int) 9L, (int) i_166);
  m2_GetColor((long) I_163, (int) i_164);
  I_167 = m2_guiAlpha;
  m2_Fade((long) I_162, (long) I_163, (float) mir_read_float(I_167));
  m2_GuiDrawText((long) U0_text, (long) I_160, (int) i_161, (long) I_162);
  I_168 = (long) (int) i0_editMode;
  if (((long) I_168 == 0)) { mir_label = 1306; break; }
case 1307:
  I_169 = (long) fp + (long) 48L;
  I_170 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(4L + fp, I_170);
  I_171 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(5L + fp, I_171);
  I_172 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(6L + fp, I_172);
  I_173 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(7L + fp, I_173);
  I_174 = (long) fp + (long) 4L;
  I_175 = (long) fp + (long) 112L;
  I_176 = (long) fp + (long) 128L;
  i_177 = GuiGetStyle((int) 9L, (int) 6L);
  m2_GetColor((long) I_176, (int) i_177);
  I_178 = m2_guiAlpha;
  m2_Fade((long) I_175, (long) I_176, (float) mir_read_float(I_178));
  m2_GuiDrawRectangle((long) I_169, (int) 0L, (long) I_174, (long) I_175);
  mir_label = 1308; break;
case 1306:
case 1308:
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_pressed;
} // End of switch
} // End of while
} // End of function GuiTextBox

public int GuiSpinner (long _I0_bounds, long _U0_text, long _U0_value, int _i0_minValue, int _i0_maxValue, int _i0_editMode) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long U0_value = _U0_value;
  long i0_minValue = _i0_minValue;
  long i0_maxValue = _i0_maxValue;
  long i0_editMode = _i0_editMode;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  long i0_pressed = 0;
  long i_3 = 0;
  float f_4 = 0;
  long I_5 = 0;
  float f_6 = 0;
  long i_7 = 0;
  float f_8 = 0;
  long I_9 = 0;
  float f_10 = 0;
  long i_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  long i_14 = 0;
  float f_15 = 0;
  long I_16 = 0;
  float f_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  float f_20 = 0;
  float f_21 = 0;
  long i_22 = 0;
  float f_23 = 0;
  long I_24 = 0;
  float f_25 = 0;
  long I_26 = 0;
  long I_27 = 0;
  float f_28 = 0;
  float f_29 = 0;
  long i_30 = 0;
  float f_31 = 0;
  long I_32 = 0;
  float f_33 = 0;
  float f_34 = 0;
  long i_35 = 0;
  float f_36 = 0;
  long I_37 = 0;
  float f_38 = 0;
  long I_39 = 0;
  long I_40 = 0;
  float f_41 = 0;
  long I_42 = 0;
  long I_43 = 0;
  long i_44 = 0;
  long i_45 = 0;
  float f_46 = 0;
  long I_47 = 0;
  long i_48 = 0;
  float f_49 = 0;
  long I_50 = 0;
  float f_51 = 0;
  long i_52 = 0;
  float f_53 = 0;
  long I_54 = 0;
  float f_55 = 0;
  float f_56 = 0;
  float f_57 = 0;
  float f_58 = 0;
  long i_59 = 0;
  long i_60 = 0;
  float f_61 = 0;
  long I_62 = 0;
  float f_63 = 0;
  long i_64 = 0;
  long i_65 = 0;
  float f_66 = 0;
  long i_67 = 0;
  float f_68 = 0;
  long I_69 = 0;
  float f_70 = 0;
  long i_71 = 0;
  long I_72 = 0;
  long I_73 = 0;
  long I_74 = 0;
  long I_75 = 0;
  long i_76 = 0;
  long I_77 = 0;
  long I_78 = 0;
  long I_79 = 0;
  long i_80 = 0;
  long I_81 = 0;
  long i_82 = 0;
  long I_83 = 0;
  long U_84 = 0;
  long I_85 = 0;
  long i_86 = 0;
  long i_87 = 0;
  long I_88 = 0;
  long U_89 = 0;
  long I_90 = 0;
  long i_91 = 0;
  long I_92 = 0;
  long i_93 = 0;
  long i_94 = 0;
  long i_95 = 0;
  long I_96 = 0;
  long U_97 = 0;
  long i0_tempBorderWidth = 0;
  long i_98 = 0;
  long i0_tempTextAlign = 0;
  long i_99 = 0;
  long i_100 = 0;
  long I_101 = 0;
  long i_102 = 0;
  long i_103 = 0;
  long i_104 = 0;
  long I_105 = 0;
  long I_106 = 0;
  long i_107 = 0;
  long i_108 = 0;
  long i_109 = 0;
  long I_110 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(160L);
  I_0 = (long) fp + (long) 4L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  i0_pressed = 0L;
  mir_write_int(fp, mir_read_int(U0_value));
  i_3 = GuiGetStyle((int) 11L, (int) 16L);
  I_5 = (long) (int) i_3;
  f_4 = (float) I_5;
  f_6 = mir_read_float(4L + fp) + f_4;
  i_7 = GuiGetStyle((int) 11L, (int) 17L);
  I_9 = (long) (int) i_7;
  f_8 = (float) I_9;
  f_10 = f_6 + f_8;
  mir_write_float(24L + fp, f_10);
  mir_write_float(28L + fp, mir_read_float(8L + fp));
  i_11 = GuiGetStyle((int) 11L, (int) 16L);
  i_12 = GuiGetStyle((int) 11L, (int) 17L);
  i_13 = (int) i_11 + (int) i_12;
  i_14 = (int) 2L * (int) i_13;
  I_16 = (long) (int) i_14;
  f_15 = (float) I_16;
  f_17 = mir_read_float(12L + fp) - f_15;
  mir_write_float(32L + fp, f_17);
  mir_write_float(36L + fp, mir_read_float(16L + fp));
  I_19 = (long) fp + (long) 40L;
  I_18 = memset((long) I_19, (int) 0L, (long) 4L);
  f_20 = mir_read_float(4L + fp);
  mir_write_float(44L + fp, f_20);
  f_21 = mir_read_float(8L + fp);
  mir_write_float(48L + fp, f_21);
  i_22 = GuiGetStyle((int) 11L, (int) 16L);
  I_24 = (long) (int) i_22;
  f_23 = (float) I_24;
  mir_write_float(52L + fp, f_23);
  f_25 = mir_read_float(16L + fp);
  mir_write_float(56L + fp, f_25);
  I_27 = (long) fp + (long) 60L;
  I_26 = memset((long) I_27, (int) 0L, (long) 4L);
  f_28 = mir_read_float(4L + fp);
  f_29 = f_28 + mir_read_float(12L + fp);
  i_30 = GuiGetStyle((int) 11L, (int) 16L);
  I_32 = (long) (int) i_30;
  f_31 = (float) I_32;
  f_33 = f_29 - f_31;
  mir_write_float(64L + fp, f_33);
  f_34 = mir_read_float(8L + fp);
  mir_write_float(68L + fp, f_34);
  i_35 = GuiGetStyle((int) 11L, (int) 16L);
  I_37 = (long) (int) i_35;
  f_36 = (float) I_37;
  mir_write_float(72L + fp, f_36);
  f_38 = mir_read_float(16L + fp);
  mir_write_float(76L + fp, f_38);
  I_40 = (long) fp + (long) 80L;
  I_39 = memset((long) I_40, (int) 0L, (long) 4L);
  f_41 = (float) 0L;
  mir_write_float(84L + fp, f_41);
  I_43 = (long) fp + (long) 88L;
  I_42 = memset((long) I_43, (int) 0L, (long) 16L);
  if ((long) U0_text == (long) 0L) { mir_label = 1309; break; }
case 1310:
  i_45 = m2_GetTextWidth((long) U0_text);
  I_47 = (long) (int) i_45;
  f_46 = (float) I_47;
  mir_write_float(92L + fp, f_46);
  i_48 = GuiGetStyle((int) 0L, (int) 16L);
  I_50 = (long) (int) i_48;
  f_49 = (float) I_50;
  mir_write_float(96L + fp, f_49);
  f_51 = mir_read_float(4L + fp) + mir_read_float(12L + fp);
  i_52 = GuiGetStyle((int) 11L, (int) 13L);
  I_54 = (long) (int) i_52;
  f_53 = (float) I_54;
  f_55 = f_51 + f_53;
  mir_write_float(84L + fp, f_55);
  f_56 = (float) 2L;
  f_57 = mir_read_float(16L + fp) / f_56;
  f_58 = mir_read_float(8L + fp) + f_57;
  i_59 = GuiGetStyle((int) 0L, (int) 16L);
  i_60 = (int) i_59 / (int) 2L;
  I_62 = (long) (int) i_60;
  f_61 = (float) I_62;
  f_63 = f_58 - f_61;
  mir_write_float(88L + fp, f_63);
  i_64 = GuiGetStyle((int) 11L, (int) 14L);
  if ((int) i_64 != (int) 0L) { mir_label = 1311; break; }
case 1312:
  f_66 = mir_read_float(4L + fp) - mir_read_float(92L + fp);
  i_67 = GuiGetStyle((int) 11L, (int) 13L);
  I_69 = (long) (int) i_67;
  f_68 = (float) I_69;
  f_70 = f_66 - f_68;
  mir_write_float(84L + fp, f_70);
  mir_label = 1313; break;
case 1311:
case 1313:
  mir_label = 1314; break;
case 1309:
case 1314:
  if ((int) i0_state == (int) 3L) { mir_label = 1315; break; }
case 1316:
  I_72 = m2_guiLocked;
  if (((long) mir_read_int(I_72) != 0)) { mir_label = 1315; break; }
case 1317:
  I_73 = (long) fp + (long) 128L;
  GetMousePosition((long) I_73);
  I_75 = (long) fp + (long) 104L;
  I_74 = memcpy((long) I_75, (long) I_73, (long) 24L);
  I_77 = (long) fp + (long) 104L;
  I_78 = (long) fp + (long) 4L;
  i_76 = m2_CheckCollisionPointRec((long) I_77, (long) I_78);
  I_79 = (long) (int) i_76;
  if (((long) I_79 == 0)) { mir_label = 1318; break; }
case 1319:
  i_80 = IsMouseButtonDown((int) 0L);
  I_81 = (long) (int) i_80;
  if (((long) I_81 == 0)) { mir_label = 1320; break; }
case 1321:
  i0_state = 2L;
  mir_label = 1322; break;
case 1320:
  i0_state = 1L;
case 1322:
  mir_label = 1323; break;
case 1318:
case 1323:
  mir_label = 1324; break;
case 1315:
case 1324:
  I_83 = (long) fp + (long) 44L;
  U_84 = GuiIconText((int) 118L, (long) 0L);
  i_82 = GuiButton((long) I_83, (long) U_84);
  I_85 = (long) (int) i_82;
  if (((long) I_85 == 0)) { mir_label = 1325; break; }
case 1326:
  i_86 = mir_read_int(fp);
  i_86 = (int) i_86 - (int) 1L;
  mir_write_int(fp, i_86);
  mir_label = 1327; break;
case 1325:
case 1327:
  I_88 = (long) fp + (long) 64L;
  U_89 = GuiIconText((int) 119L, (long) 0L);
  i_87 = GuiButton((long) I_88, (long) U_89);
  I_90 = (long) (int) i_87;
  if (((long) I_90 == 0)) { mir_label = 1328; break; }
case 1329:
  i_91 = mir_read_int(fp);
  i_91 = (int) i_91 + (int) 1L;
  mir_write_int(fp, i_91);
  mir_label = 1330; break;
case 1328:
case 1330:
  I_92 = (long) (int) i0_editMode;
  if (((long) I_92 != 0)) { mir_label = 1331; break; }
case 1332:
  if ((int) mir_read_int(fp) >= (int) i0_minValue) { mir_label = 1333; break; }
case 1334:
  mir_write_int(fp, i0_minValue);
  mir_label = 1335; break;
case 1333:
case 1335:
  if ((int) mir_read_int(fp) <= (int) i0_maxValue) { mir_label = 1336; break; }
case 1337:
  mir_write_int(fp, i0_maxValue);
  mir_label = 1338; break;
case 1336:
case 1338:
  mir_label = 1339; break;
case 1331:
case 1339:
  I_96 = (long) fp + (long) 24L;
  U_97 = fp;
  i_95 = GuiValueBox((long) I_96, (long) 0L, (long) U_97, (int) i0_minValue, (int) i0_maxValue, (int) i0_editMode);
  i0_pressed = i_95;
  i_98 = GuiGetStyle((int) 2L, (int) 12L);
  i0_tempBorderWidth = i_98;
  i_99 = GuiGetStyle((int) 2L, (int) 14L);
  i0_tempTextAlign = i_99;
  i_100 = GuiGetStyle((int) 11L, (int) 12L);
  GuiSetStyle((int) 2L, (int) 12L, (int) i_100);
  GuiSetStyle((int) 2L, (int) 14L, (int) 1L);
  GuiSetStyle((int) 2L, (int) 14L, (int) i0_tempTextAlign);
  GuiSetStyle((int) 2L, (int) 12L, (int) i0_tempBorderWidth);
  I_101 = (long) fp + (long) 84L;
  i_102 = GuiGetStyle((int) 11L, (int) 14L);
  if ((int) i_102 != (int) 2L) { mir_label = 1340; break; }
case 1341:
  i_104 = 0L;
  mir_label = 1342; break;
case 1340:
  i_104 = 2L;
case 1342:
  I_105 = (long) fp + (long) 128L;
  I_106 = (long) fp + (long) 144L;
  i_108 = (int) i0_state * (int) 3L;
  i_109 = (int) 2L + (int) i_108;
  i_107 = GuiGetStyle((int) 1L, (int) i_109);
  m2_GetColor((long) I_106, (int) i_107);
  I_110 = m2_guiAlpha;
  m2_Fade((long) I_105, (long) I_106, (float) mir_read_float(I_110));
  m2_GuiDrawText((long) U0_text, (long) I_101, (int) i_104, (long) I_105);
  mir_write_int(U0_value, mir_read_int(fp));
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_pressed;
} // End of switch
} // End of while
} // End of function GuiSpinner

public int GuiValueBox (long _I0_bounds, long _U0_text, long _U0_value, int _i0_minValue, int _i0_maxValue, int _i0_editMode) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long U0_value = _U0_value;
  long i0_minValue = _i0_minValue;
  long i0_maxValue = _i0_maxValue;
  long i0_editMode = _i0_editMode;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  long i0_pressed = 0;
  long I_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long i_7 = 0;
  long I_8 = 0;
  float f_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  float f_14 = 0;
  long I_15 = 0;
  long i_16 = 0;
  float f_17 = 0;
  long I_18 = 0;
  float f_19 = 0;
  long i_20 = 0;
  float f_21 = 0;
  long I_22 = 0;
  float f_23 = 0;
  float f_24 = 0;
  float f_25 = 0;
  float f_26 = 0;
  long i_27 = 0;
  long i_28 = 0;
  float f_29 = 0;
  long I_30 = 0;
  float f_31 = 0;
  long i_32 = 0;
  long i_33 = 0;
  float f_34 = 0;
  long i_35 = 0;
  float f_36 = 0;
  long I_37 = 0;
  float f_38 = 0;
  long i_39 = 0;
  long I_40 = 0;
  long I_41 = 0;
  long I_42 = 0;
  long I_43 = 0;
  long i2_valueHasChanged = 0;
  long I_44 = 0;
  long i3_keyCount = 0;
  long U_45 = 0;
  long I_46 = 0;
  long i_47 = 0;
  long i_48 = 0;
  long i_49 = 0;
  long I_50 = 0;
  float f_51 = 0;
  long I_52 = 0;
  long i_53 = 0;
  long i5_key = 0;
  long i_54 = 0;
  long i_55 = 0;
  long i_56 = 0;
  long I_57 = 0;
  long I_58 = 0;
  long I_59 = 0;
  long I_60 = 0;
  long i_61 = 0;
  long i_62 = 0;
  long i_63 = 0;
  long I_64 = 0;
  long i_65 = 0;
  long I_66 = 0;
  long I_67 = 0;
  long I_68 = 0;
  long I_69 = 0;
  long i_70 = 0;
  long I_71 = 0;
  long i_72 = 0;
  long I_73 = 0;
  long i_74 = 0;
  long I_75 = 0;
  long I_76 = 0;
  long I_77 = 0;
  long i_78 = 0;
  long I_79 = 0;
  long i_80 = 0;
  long i_81 = 0;
  long i_82 = 0;
  long I_83 = 0;
  long I_84 = 0;
  long I_85 = 0;
  long i_86 = 0;
  long I_87 = 0;
  long I_88 = 0;
  long I_89 = 0;
  long I_90 = 0;
  long I_91 = 0;
  long i_92 = 0;
  long I_93 = 0;
  long i_94 = 0;
  long I_95 = 0;
  long i_96 = 0;
  long I_97 = 0;
  long i_98 = 0;
  long I_99 = 0;
  long I_100 = 0;
  long i_101 = 0;
  long I_102 = 0;
  long I_103 = 0;
  long i_104 = 0;
  long i_105 = 0;
  long i_106 = 0;
  long I_107 = 0;
  long I_108 = 0;
  long I_109 = 0;
  long I_110 = 0;
  long I_111 = 0;
  long I_112 = 0;
  long i_113 = 0;
  long i_114 = 0;
  long i_115 = 0;
  long I_116 = 0;
  long I_117 = 0;
  long i_118 = 0;
  long I_119 = 0;
  long i_120 = 0;
  float f_121 = 0;
  long I_122 = 0;
  float f_123 = 0;
  float f_124 = 0;
  float f_125 = 0;
  float f_126 = 0;
  float f_127 = 0;
  float f_128 = 0;
  long i_129 = 0;
  long i_130 = 0;
  float f_131 = 0;
  long I_132 = 0;
  float f_133 = 0;
  float f_134 = 0;
  long i_135 = 0;
  long i_136 = 0;
  float f_137 = 0;
  long I_138 = 0;
  float f_139 = 0;
  long I_140 = 0;
  long I_141 = 0;
  long I_142 = 0;
  long I_143 = 0;
  long I_144 = 0;
  long I_145 = 0;
  long I_146 = 0;
  long I_147 = 0;
  long I_148 = 0;
  long I_149 = 0;
  long i_150 = 0;
  long I_151 = 0;
  long I_152 = 0;
  long i_153 = 0;
  long i_154 = 0;
  long i_155 = 0;
  long I_156 = 0;
  long I_157 = 0;
  long i_158 = 0;
  long i_159 = 0;
  long i_160 = 0;
  long I_161 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(192L);
  I_0 = (long) fp + (long) 8L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  i0_pressed = 0L;
  I_4 = (long) fp + (long) 48L;
  I_3 = memcpy((long) I_4, (long) mir_get_string_ptr("\0"), (long) 2L);
  I_6 = (long) fp + (long) 50L;
  I_5 = memset((long) I_6, (int) 0L, (long) 31L);
  I_8 = (long) fp + (long) 48L;
  i_7 = sprintf((long) I_8, (long) mir_get_string_ptr("%i"), mir_read_int(U0_value));
  f_9 = (float) 0L;
  mir_write_float(28L + fp, f_9);
  I_11 = (long) fp + (long) 32L;
  I_10 = memset((long) I_11, (int) 0L, (long) 16L);
  if ((long) U0_text == (long) 0L) { mir_label = 1343; break; }
case 1344:
  i_13 = m2_GetTextWidth((long) U0_text);
  I_15 = (long) (int) i_13;
  f_14 = (float) I_15;
  mir_write_float(36L + fp, f_14);
  i_16 = GuiGetStyle((int) 0L, (int) 16L);
  I_18 = (long) (int) i_16;
  f_17 = (float) I_18;
  mir_write_float(40L + fp, f_17);
  f_19 = mir_read_float(8L + fp) + mir_read_float(16L + fp);
  i_20 = GuiGetStyle((int) 10L, (int) 13L);
  I_22 = (long) (int) i_20;
  f_21 = (float) I_22;
  f_23 = f_19 + f_21;
  mir_write_float(28L + fp, f_23);
  f_24 = (float) 2L;
  f_25 = mir_read_float(20L + fp) / f_24;
  f_26 = mir_read_float(12L + fp) + f_25;
  i_27 = GuiGetStyle((int) 0L, (int) 16L);
  i_28 = (int) i_27 / (int) 2L;
  I_30 = (long) (int) i_28;
  f_29 = (float) I_30;
  f_31 = f_26 - f_29;
  mir_write_float(32L + fp, f_31);
  i_32 = GuiGetStyle((int) 10L, (int) 14L);
  if ((int) i_32 != (int) 0L) { mir_label = 1345; break; }
case 1346:
  f_34 = mir_read_float(8L + fp) - mir_read_float(36L + fp);
  i_35 = GuiGetStyle((int) 10L, (int) 13L);
  I_37 = (long) (int) i_35;
  f_36 = (float) I_37;
  f_38 = f_34 - f_36;
  mir_write_float(28L + fp, f_38);
  mir_label = 1347; break;
case 1345:
case 1347:
  mir_label = 1348; break;
case 1343:
case 1348:
  if ((int) i0_state == (int) 3L) { mir_label = 1349; break; }
case 1350:
  I_40 = m2_guiLocked;
  if (((long) mir_read_int(I_40) != 0)) { mir_label = 1349; break; }
case 1351:
  I_41 = (long) fp + (long) 128L;
  GetMousePosition((long) I_41);
  I_43 = (long) fp + (long) 96L;
  I_42 = memcpy((long) I_43, (long) I_41, (long) 24L);
  i2_valueHasChanged = 0L;
  I_44 = (long) (int) i0_editMode;
  if (((long) I_44 == 0)) { mir_label = 1352; break; }
case 1353:
  i0_state = 2L;
  I_46 = (long) fp + (long) 48L;
  U_45 = strlen((long) I_46);
  i_47 = U_45;
  i3_keyCount = i_47;
  if ((int) i3_keyCount >= (int) 32L) { mir_label = 1354; break; }
case 1355:
  I_50 = (long) fp + (long) 48L;
  i_49 = m2_GetTextWidth((long) I_50);
  I_52 = (long) (int) i_49;
  f_51 = (float) I_52;
  if (f_51 < mir_read_float(16L + fp)) { mir_label = 1356; break; }
  mir_label = 1357; break;
case 1356:
  i_54 = GetCharPressed();
  i5_key = i_54;
  if ((int) i5_key < (int) 48L) { mir_label = 1358; break; }
case 1359:
  if ((int) i5_key > (int) 57L) { mir_label = 1358; break; }
case 1360:
  I_57 = (long) fp + (long) 48L;
  I_58 = (long) (int) i3_keyCount;
  I_59 = (long) (byte) i5_key;
  I_60 = (long) (byte) I_59;
  mir_write_byte(I_57 + I_58, I_60);
  i_61 = i3_keyCount;
  i_61 = (int) i_61 + (int) 1L;
  i3_keyCount = i_61;
  i2_valueHasChanged = 1L;
  mir_label = 1361; break;
case 1358:
case 1361:
  mir_label = 1362; break;
case 1357:
case 1362:
  mir_label = 1363; break;
case 1354:
case 1363:
  if ((int) i3_keyCount <= (int) 0L) { mir_label = 1364; break; }
case 1365:
  i_63 = IsKeyPressed((int) 259L);
  I_64 = (long) (int) i_63;
  if (((long) I_64 == 0)) { mir_label = 1366; break; }
case 1367:
  i_65 = i3_keyCount;
  i_65 = (int) i_65 - (int) 1L;
  i3_keyCount = i_65;
  I_66 = (long) fp + (long) 48L;
  I_67 = (long) (int) i3_keyCount;
  I_68 = (long) (byte) 0L;
  mir_write_byte(I_66 + I_67, I_68);
  i2_valueHasChanged = 1L;
  mir_label = 1368; break;
case 1366:
case 1368:
  mir_label = 1369; break;
case 1364:
case 1369:
  I_69 = (long) (int) i2_valueHasChanged;
  if (((long) I_69 == 0)) { mir_label = 1370; break; }
case 1371:
  I_71 = (long) fp + (long) 48L;
  i_70 = m2_TextToInteger((long) I_71);
  mir_write_int(U0_value, i_70);
  mir_label = 1372; break;
case 1370:
case 1372:
  i_72 = IsKeyPressed((int) 257L);
  I_73 = (long) (int) i_72;
  if (((long) I_73 != 0)) { mir_label = 1373; break; }
case 1374:
  I_75 = (long) fp + (long) 96L;
  I_76 = (long) fp + (long) 8L;
  i_74 = m2_CheckCollisionPointRec((long) I_75, (long) I_76);
  I_77 = (long) (int) i_74;
  if (((long) I_77 != 0)) { mir_label = 1375; break; }
case 1376:
  i_78 = IsMouseButtonPressed((int) 0L);
  I_79 = (long) (int) i_78;
  if (((long) I_79 == 0)) { mir_label = 1375; break; }
case 1373:
  i0_pressed = 1L;
  mir_label = 1377; break;
case 1375:
case 1377:
  mir_label = 1378; break;
case 1352:
  if ((int) mir_read_int(U0_value) <= (int) i0_maxValue) { mir_label = 1379; break; }
case 1380:
  mir_write_int(U0_value, i0_maxValue);
  mir_label = 1381; break;
case 1379:
  if ((int) mir_read_int(U0_value) >= (int) i0_minValue) { mir_label = 1382; break; }
case 1383:
  mir_write_int(U0_value, i0_minValue);
  mir_label = 1384; break;
case 1382:
case 1384:
case 1381:
  I_83 = (long) fp + (long) 96L;
  I_84 = (long) fp + (long) 8L;
  i_82 = m2_CheckCollisionPointRec((long) I_83, (long) I_84);
  I_85 = (long) (int) i_82;
  if (((long) I_85 == 0)) { mir_label = 1385; break; }
case 1386:
  i0_state = 1L;
  i_86 = IsMouseButtonPressed((int) 0L);
  I_87 = (long) (int) i_86;
  if (((long) I_87 == 0)) { mir_label = 1387; break; }
case 1388:
  i0_pressed = 1L;
  mir_label = 1389; break;
case 1387:
case 1389:
  mir_label = 1390; break;
case 1385:
case 1390:
case 1378:
  mir_label = 1391; break;
case 1349:
case 1391:
  I_88 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(fp, I_88);
  I_89 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(1L + fp, I_89);
  I_90 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(2L + fp, I_90);
  I_91 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(3L + fp, I_91);
  if ((int) i0_state != (int) 2L) { mir_label = 1392; break; }
case 1393:
  I_93 = (long) fp + (long) 128L;
  i_94 = GuiGetStyle((int) 10L, (int) 7L);
  m2_GetColor((long) I_93, (int) i_94);
  I_95 = 4L;
case 1394:
  I_95 = (long) I_95 - (long) 1L;
  mir_write_byte(fp + I_95, mir_read_byte(I_93 + I_95));
  if ((long) I_95 > (long) 0L) { mir_label = 1394; break; }
  mir_label = 1395; break;
case 1392:
  if ((int) i0_state != (int) 3L) { mir_label = 1396; break; }
case 1397:
  I_97 = (long) fp + (long) 128L;
  i_98 = GuiGetStyle((int) 10L, (int) 10L);
  m2_GetColor((long) I_97, (int) i_98);
  I_99 = 4L;
case 1398:
  I_99 = (long) I_99 - (long) 1L;
  mir_write_byte(fp + I_99, mir_read_byte(I_97 + I_99));
  if ((long) I_99 > (long) 0L) { mir_label = 1398; break; }
  mir_label = 1399; break;
case 1396:
case 1399:
case 1395:
  I_100 = (long) fp + (long) 8L;
  i_101 = GuiGetStyle((int) 10L, (int) 12L);
  I_102 = (long) fp + (long) 128L;
  I_103 = (long) fp + (long) 144L;
  i_105 = (int) i0_state * (int) 3L;
  i_106 = (int) 0L + (int) i_105;
  i_104 = GuiGetStyle((int) 10L, (int) i_106);
  m2_GetColor((long) I_103, (int) i_104);
  I_107 = m2_guiAlpha;
  m2_Fade((long) I_102, (long) I_103, (float) mir_read_float(I_107));
  m2_GuiDrawRectangle((long) I_100, (int) i_101, (long) I_102, (long) fp);
  I_108 = (long) fp + (long) 48L;
  I_109 = (long) fp + (long) 128L;
  I_110 = (long) fp + (long) 8L;
  m2_GetTextBounds((long) I_109, (int) 10L, (long) I_110);
  I_111 = (long) fp + (long) 160L;
  I_112 = (long) fp + (long) 176L;
  i_114 = (int) i0_state * (int) 3L;
  i_115 = (int) 2L + (int) i_114;
  i_113 = GuiGetStyle((int) 10L, (int) i_115);
  m2_GetColor((long) I_112, (int) i_113);
  I_116 = m2_guiAlpha;
  m2_Fade((long) I_111, (long) I_112, (float) mir_read_float(I_116));
  m2_GuiDrawText((long) I_108, (long) I_109, (int) 1L, (long) I_111);
  I_117 = (long) (int) i0_editMode;
  if (((long) I_117 == 0)) { mir_label = 1400; break; }
case 1401:
  I_119 = (long) fp + (long) 48L;
  i_118 = m2_GetTextWidth((long) I_119);
  i_120 = (int) i_118 / (int) 2L;
  I_122 = (long) (int) i_120;
  f_121 = (float) I_122;
  f_123 = mir_read_float(8L + fp) + f_121;
  f_124 = (float) 2L;
  f_125 = mir_read_float(16L + fp) / f_124;
  f_126 = f_123 + f_125;
  f_127 = (float) 2L;
  f_128 = f_126 + f_127;
  mir_write_float(100L + fp, f_128);
  i_129 = GuiGetStyle((int) 10L, (int) 12L);
  i_130 = (int) 2L * (int) i_129;
  I_132 = (long) (int) i_130;
  f_131 = (float) I_132;
  f_133 = mir_read_float(12L + fp) + f_131;
  mir_write_float(104L + fp, f_133);
  f_134 = (float) 4L;
  mir_write_float(108L + fp, f_134);
  i_135 = GuiGetStyle((int) 10L, (int) 12L);
  i_136 = (int) 4L * (int) i_135;
  I_138 = (long) (int) i_136;
  f_137 = (float) I_138;
  f_139 = mir_read_float(20L + fp) - f_137;
  mir_write_float(112L + fp, f_139);
  I_141 = (long) fp + (long) 116L;
  I_140 = memset((long) I_141, (int) 0L, (long) 4L);
  I_142 = (long) fp + (long) 100L;
  I_143 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(96L + fp, I_143);
  I_144 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(97L + fp, I_144);
  I_145 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(98L + fp, I_145);
  I_146 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(99L + fp, I_146);
  I_147 = (long) fp + (long) 96L;
  I_148 = (long) fp + (long) 128L;
  I_149 = (long) fp + (long) 144L;
  i_150 = GuiGetStyle((int) 10L, (int) 6L);
  m2_GetColor((long) I_149, (int) i_150);
  I_151 = m2_guiAlpha;
  m2_Fade((long) I_148, (long) I_149, (float) mir_read_float(I_151));
  m2_GuiDrawRectangle((long) I_142, (int) 0L, (long) I_147, (long) I_148);
  mir_label = 1402; break;
case 1400:
case 1402:
  I_152 = (long) fp + (long) 28L;
  i_153 = GuiGetStyle((int) 10L, (int) 14L);
  if ((int) i_153 != (int) 2L) { mir_label = 1403; break; }
case 1404:
  i_155 = 0L;
  mir_label = 1405; break;
case 1403:
  i_155 = 2L;
case 1405:
  I_156 = (long) fp + (long) 128L;
  I_157 = (long) fp + (long) 144L;
  i_159 = (int) i0_state * (int) 3L;
  i_160 = (int) 2L + (int) i_159;
  i_158 = GuiGetStyle((int) 1L, (int) i_160);
  m2_GetColor((long) I_157, (int) i_158);
  I_161 = m2_guiAlpha;
  m2_Fade((long) I_156, (long) I_157, (float) mir_read_float(I_161));
  m2_GuiDrawText((long) U0_text, (long) I_152, (int) i_155, (long) I_156);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_pressed;
} // End of switch
} // End of while
} // End of function GuiValueBox

public int GuiTextBoxMulti (long _I0_bounds, long _U0_text, int _i0_textSize, int _i0_editMode) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long i0_textSize = _i0_textSize;
  long i0_editMode = _i0_editMode;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  long i0_pressed = 0;
  long i_3 = 0;
  float f_4 = 0;
  long I_5 = 0;
  float f_6 = 0;
  long i_7 = 0;
  float f_8 = 0;
  long I_9 = 0;
  float f_10 = 0;
  long i_11 = 0;
  float f_12 = 0;
  long I_13 = 0;
  float f_14 = 0;
  long i_15 = 0;
  float f_16 = 0;
  long I_17 = 0;
  float f_18 = 0;
  long i_19 = 0;
  long i_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  float f_23 = 0;
  long I_24 = 0;
  float f_25 = 0;
  long i_26 = 0;
  long i_27 = 0;
  long i_28 = 0;
  long i_29 = 0;
  float f_30 = 0;
  long I_31 = 0;
  float f_32 = 0;
  long I_33 = 0;
  long I_34 = 0;
  float f_35 = 0;
  float f_36 = 0;
  float f_37 = 0;
  long i_38 = 0;
  float f_39 = 0;
  long I_40 = 0;
  float f_41 = 0;
  float f_42 = 0;
  long I_43 = 0;
  long I_44 = 0;
  float f0_scaleFactor = 0;
  long i_45 = 0;
  float f_46 = 0;
  long I_47 = 0;
  long I_48 = 0;
  float f_49 = 0;
  float f_50 = 0;
  long i_51 = 0;
  long I_52 = 0;
  long I_53 = 0;
  long I_54 = 0;
  long I_55 = 0;
  long I_56 = 0;
  long i2_codepoint = 0;
  long i_57 = 0;
  long i2_textLength = 0;
  long U_58 = 0;
  long i_59 = 0;
  long U2_textUTF8 = 0;
  long U_60 = 0;
  long U_61 = 0;
  long i_62 = 0;
  long i_63 = 0;
  long i_64 = 0;
  long I_65 = 0;
  long I_66 = 0;
  long I_67 = 0;
  long i_68 = 0;
  long i_69 = 0;
  long U5_charEncoded = 0;
  long U_70 = 0;
  long U_71 = 0;
  long U_72 = 0;
  long U_73 = 0;
  long U_74 = 0;
  long U_75 = 0;
  long i_76 = 0;
  long i_77 = 0;
  long i_78 = 0;
  long i_79 = 0;
  long I_80 = 0;
  long i_81 = 0;
  long I_82 = 0;
  long I_83 = 0;
  long i_84 = 0;
  long i_85 = 0;
  long I_86 = 0;
  long I_87 = 0;
  long i9_charUTF8Length = 0;
  long i_88 = 0;
  long i_89 = 0;
  long i_90 = 0;
  long I_91 = 0;
  long I_92 = 0;
  long i_93 = 0;
  long i_94 = 0;
  long i_95 = 0;
  long i_96 = 0;
  long i_97 = 0;
  long i_98 = 0;
  long I_99 = 0;
  long I_100 = 0;
  long i_101 = 0;
  long i_102 = 0;
  long i_103 = 0;
  long i_104 = 0;
  long i_105 = 0;
  long I_106 = 0;
  long I_107 = 0;
  long i_108 = 0;
  long I_109 = 0;
  long I_110 = 0;
  long I_111 = 0;
  long i_112 = 0;
  long I_113 = 0;
  long i_114 = 0;
  long I_115 = 0;
  long I_116 = 0;
  long I_117 = 0;
  long i_118 = 0;
  long I_119 = 0;
  long i_120 = 0;
  long I_121 = 0;
  long i_122 = 0;
  long I_123 = 0;
  long I_124 = 0;
  long i_125 = 0;
  long i_126 = 0;
  long i_127 = 0;
  long I_128 = 0;
  long I_129 = 0;
  long I_130 = 0;
  long i_131 = 0;
  long I_132 = 0;
  long i_133 = 0;
  long I_134 = 0;
  long i_135 = 0;
  long I_136 = 0;
  long I_137 = 0;
  long i_138 = 0;
  long i_139 = 0;
  long i_140 = 0;
  long I_141 = 0;
  long I_142 = 0;
  long I_143 = 0;
  long i_144 = 0;
  long I_145 = 0;
  long I_146 = 0;
  long I_147 = 0;
  long I_148 = 0;
  long i_149 = 0;
  long i_150 = 0;
  long i_151 = 0;
  long I_152 = 0;
  long I_153 = 0;
  long I_154 = 0;
  long I_155 = 0;
  long I_156 = 0;
  long i0_wrapMode = 0;
  long I_157 = 0;
  long I_158 = 0;
  long i14_i = 0;
  long I_159 = 0;
  long i_160 = 0;
  long i15_codepoint = 0;
  long i_161 = 0;
  long U_162 = 0;
  long U_163 = 0;
  long U_164 = 0;
  long U_165 = 0;
  long i15_index = 0;
  long i_166 = 0;
  long I_167 = 0;
  long I_168 = 0;
  long I_169 = 0;
  long I_170 = 0;
  long I_171 = 0;
  long I_172 = 0;
  long I_173 = 0;
  long I_174 = 0;
  long I_175 = 0;
  long I_176 = 0;
  long I_177 = 0;
  long I_178 = 0;
  long I_179 = 0;
  long i_180 = 0;
  long i_181 = 0;
  long I_182 = 0;
  float f_183 = 0;
  float f_184 = 0;
  long i_185 = 0;
  float f_186 = 0;
  long I_187 = 0;
  float f_188 = 0;
  float f_189 = 0;
  float f_190 = 0;
  long i_191 = 0;
  long i18_glyphWidth = 0;
  long i_192 = 0;
  long i_193 = 0;
  long i_194 = 0;
  float f_195 = 0;
  float f_196 = 0;
  long i_197 = 0;
  long i_198 = 0;
  long i_199 = 0;
  float f_200 = 0;
  long I_201 = 0;
  float f_202 = 0;
  float f_203 = 0;
  float f_204 = 0;
  long i_205 = 0;
  long I_206 = 0;
  float f_207 = 0;
  float f_208 = 0;
  long i_209 = 0;
  float f_210 = 0;
  long I_211 = 0;
  float f_212 = 0;
  float f_213 = 0;
  float f_214 = 0;
  long i_215 = 0;
  long I_216 = 0;
  long I_217 = 0;
  long i_218 = 0;
  float f_219 = 0;
  long I_220 = 0;
  long I_221 = 0;
  long I_222 = 0;
  long i_223 = 0;
  long i_224 = 0;
  long i_225 = 0;
  long I_226 = 0;
  long i17_glyphWidth = 0;
  long i_227 = 0;
  long i_228 = 0;
  long i_229 = 0;
  float f_230 = 0;
  float f_231 = 0;
  long i_232 = 0;
  long i_233 = 0;
  long i_234 = 0;
  float f_235 = 0;
  long I_236 = 0;
  float f_237 = 0;
  long i_238 = 0;
  float f_239 = 0;
  long I_240 = 0;
  float f_241 = 0;
  float f_242 = 0;
  float f_243 = 0;
  long i_244 = 0;
  long i_245 = 0;
  long I_246 = 0;
  long i_247 = 0;
  long I_248 = 0;
  long I_249 = 0;
  long I_250 = 0;
  long I_251 = 0;
  long I_252 = 0;
  long I_253 = 0;
  long I_254 = 0;
  long I_255 = 0;
  long I_256 = 0;
  long i_257 = 0;
  long I_258 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(208L);
  I_0 = (long) fp + (long) 8L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  i0_pressed = 0L;
  i_3 = GuiGetStyle((int) 9L, (int) 12L);
  I_5 = (long) (int) i_3;
  f_4 = (float) I_5;
  f_6 = mir_read_float(8L + fp) + f_4;
  i_7 = GuiGetStyle((int) 9L, (int) 16L);
  I_9 = (long) (int) i_7;
  f_8 = (float) I_9;
  f_10 = f_6 + f_8;
  mir_write_float(28L + fp, f_10);
  i_11 = GuiGetStyle((int) 9L, (int) 12L);
  I_13 = (long) (int) i_11;
  f_12 = (float) I_13;
  f_14 = mir_read_float(12L + fp) + f_12;
  i_15 = GuiGetStyle((int) 9L, (int) 16L);
  I_17 = (long) (int) i_15;
  f_16 = (float) I_17;
  f_18 = f_14 + f_16;
  mir_write_float(32L + fp, f_18);
  i_19 = GuiGetStyle((int) 9L, (int) 12L);
  i_20 = GuiGetStyle((int) 9L, (int) 16L);
  i_21 = (int) i_19 + (int) i_20;
  i_22 = (int) 2L * (int) i_21;
  I_24 = (long) (int) i_22;
  f_23 = (float) I_24;
  f_25 = mir_read_float(16L + fp) - f_23;
  mir_write_float(36L + fp, f_25);
  i_26 = GuiGetStyle((int) 9L, (int) 12L);
  i_27 = GuiGetStyle((int) 9L, (int) 16L);
  i_28 = (int) i_26 + (int) i_27;
  i_29 = (int) 2L * (int) i_28;
  I_31 = (long) (int) i_29;
  f_30 = (float) I_31;
  f_32 = mir_read_float(20L + fp) - f_30;
  mir_write_float(40L + fp, f_32);
  I_34 = (long) fp + (long) 44L;
  I_33 = memset((long) I_34, (int) 0L, (long) 4L);
  f_35 = (float) 0L;
  mir_write_float(48L + fp, f_35);
  f_36 = (float) -1L;
  mir_write_float(52L + fp, f_36);
  f_37 = (float) 4L;
  mir_write_float(56L + fp, f_37);
  i_38 = GuiGetStyle((int) 0L, (int) 16L);
  I_40 = (long) (int) i_38;
  f_39 = (float) I_40;
  f_41 = (float) 2L;
  f_42 = f_39 + f_41;
  mir_write_float(60L + fp, f_42);
  I_44 = (long) fp + (long) 64L;
  I_43 = memset((long) I_44, (int) 0L, (long) 4L);
  i_45 = GuiGetStyle((int) 0L, (int) 16L);
  I_47 = (long) (int) i_45;
  f_46 = (float) I_47;
  I_48 = m2_guiFont;
  f_49 = (float) mir_read_int(I_48);
  f_50 = f_46 / f_49;
  f0_scaleFactor = f_50;
  if ((int) i0_state == (int) 3L) { mir_label = 1406; break; }
case 1407:
  I_52 = m2_guiLocked;
  if (((long) mir_read_int(I_52) != 0)) { mir_label = 1406; break; }
case 1408:
  I_53 = (long) fp + (long) 160L;
  GetMousePosition((long) I_53);
  I_55 = (long) fp + (long) 96L;
  I_54 = memcpy((long) I_55, (long) I_53, (long) 24L);
  I_56 = (long) (int) i0_editMode;
  if (((long) I_56 == 0)) { mir_label = 1409; break; }
case 1410:
  i0_state = 2L;
  i_57 = GetCharPressed();
  i2_codepoint = i_57;
  U_58 = strlen((long) U0_text);
  i_59 = U_58;
  i2_textLength = i_59;
  mir_write_int(120L + fp, 0L);
  U_61 = 120L;
  U_61 = (long) U_61 + (long) fp;
  U_60 = m2_CodepointToUTF8((int) i2_codepoint, (long) U_61);
  U2_textUTF8 = U_60;
  i_62 = (int) i2_textLength + (int) mir_read_int(120L + fp);
  if ((int) i_62 >= (int) i0_textSize) { mir_label = 1411; break; }
case 1412:
  i_64 = IsKeyPressed((int) 257L);
  I_65 = (long) (int) i_64;
  if (((long) I_65 == 0)) { mir_label = 1413; break; }
case 1414:
  I_66 = (long) (int) i2_textLength;
  I_67 = (long) (byte) 10L;
  mir_write_byte(U0_text + I_66, I_67);
  i_68 = i2_textLength;
  i_68 = (int) i_68 + (int) 1L;
  i2_textLength = i_68;
  mir_label = 1415; break;
case 1413:
  if ((int) i2_codepoint < (int) 32L) { mir_label = 1416; break; }
case 1417:
  mir_write_int(124L + fp, 0L);
  U_71 = 124L;
  U_71 = (long) U_71 + (long) fp;
  U_70 = m2_CodepointToUTF8((int) i2_codepoint, (long) U_71);
  U5_charEncoded = U_70;
  U_73 = (long) (int) i2_textLength;
  U_75 = (long) U_73 * (long) 1L;
  U_74 = (long) U0_text + (long) U_75;
  U_72 = memcpy((long) U_74, (long) U5_charEncoded, (long) mir_read_int(124L + fp));
  i_76 = i2_textLength;
  i_76 = (int) i_76 + (int) mir_read_int(124L + fp);
  i2_textLength = i_76;
  mir_label = 1418; break;
case 1416:
case 1418:
case 1415:
  mir_label = 1419; break;
case 1411:
case 1419:
  if ((int) i2_textLength <= (int) 0L) { mir_label = 1420; break; }
case 1421:
  i_79 = IsKeyPressed((int) 259L);
  I_80 = (long) (int) i_79;
  if (((long) I_80 == 0)) { mir_label = 1422; break; }
case 1423:
  i_81 = (int) i2_textLength - (int) 1L;
  I_82 = (long) (int) i_81;
  I_83 = (((long) (int) mir_read_byte(U0_text + I_82)) & 0xFFL);
  if ((int) I_83 >= (int) 127L) { mir_label = 1424; break; }
case 1425:
  i_85 = i2_textLength;
  i_85 = (int) i_85 - (int) 1L;
  i2_textLength = i_85;
  I_86 = (long) (int) i2_textLength;
  I_87 = (long) (byte) 0L;
  mir_write_byte(U0_text + I_86, I_87);
  mir_label = 1426; break;
case 1424:
  i9_charUTF8Length = 0L;
case 1427:
  if ((int) i9_charUTF8Length >= (int) i2_textLength) { mir_label = 1428; break; }
case 1429:
  i_89 = (int) i2_textLength - (int) 1L;
  i_90 = (int) i_89 - (int) i9_charUTF8Length;
  I_91 = (long) (int) i_90;
  I_92 = (((long) (int) mir_read_byte(U0_text + I_91)) & 0xFFL);
  i_93 = (int) I_92 & (int) 64L;
  if ((int) i_93 != (int) 0L) { mir_label = 1428; break; }
case 1430:
  i_95 = i9_charUTF8Length;
  i_95 = (int) i_95 + (int) 1L;
  i9_charUTF8Length = i_95;
  if ((int) i9_charUTF8Length >= (int) i2_textLength) { mir_label = 1428; break; }
case 1431:
  i_97 = (int) i2_textLength - (int) 1L;
  i_98 = (int) i_97 - (int) i9_charUTF8Length;
  I_99 = (long) (int) i_98;
  I_100 = (((long) (int) mir_read_byte(U0_text + I_99)) & 0xFFL);
  i_101 = (int) I_100 & (int) 64L;
  if ((int) i_101 == (int) 0L) { mir_label = 1430; break; }
case 1428:
  i_103 = (int) i9_charUTF8Length + (int) 1L;
  i_104 = i2_textLength;
  i_104 = (int) i_104 - (int) i_103;
  i2_textLength = i_104;
  I_106 = (long) (int) i2_textLength;
  I_107 = (long) (byte) 0L;
  mir_write_byte(U0_text + I_106, I_107);
case 1426:
  mir_label = 1432; break;
case 1422:
case 1432:
  mir_label = 1433; break;
case 1420:
case 1433:
  I_109 = (long) fp + (long) 96L;
  I_110 = (long) fp + (long) 8L;
  i_108 = m2_CheckCollisionPointRec((long) I_109, (long) I_110);
  I_111 = (long) (int) i_108;
  if (((long) I_111 != 0)) { mir_label = 1434; break; }
case 1435:
  i_112 = IsMouseButtonPressed((int) 0L);
  I_113 = (long) (int) i_112;
  if (((long) I_113 == 0)) { mir_label = 1434; break; }
case 1436:
  i0_pressed = 1L;
  mir_label = 1437; break;
case 1434:
case 1437:
  mir_label = 1438; break;
case 1409:
  I_115 = (long) fp + (long) 96L;
  I_116 = (long) fp + (long) 8L;
  i_114 = m2_CheckCollisionPointRec((long) I_115, (long) I_116);
  I_117 = (long) (int) i_114;
  if (((long) I_117 == 0)) { mir_label = 1439; break; }
case 1440:
  i0_state = 1L;
  i_118 = IsMouseButtonPressed((int) 0L);
  I_119 = (long) (int) i_118;
  if (((long) I_119 == 0)) { mir_label = 1441; break; }
case 1442:
  i0_pressed = 1L;
  mir_label = 1443; break;
case 1441:
case 1443:
  mir_label = 1444; break;
case 1439:
case 1444:
case 1438:
  mir_label = 1445; break;
case 1406:
case 1445:
  if ((int) i0_state != (int) 2L) { mir_label = 1446; break; }
case 1447:
  I_121 = (long) fp + (long) 8L;
  i_122 = GuiGetStyle((int) 9L, (int) 12L);
  I_123 = (long) fp + (long) 160L;
  I_124 = (long) fp + (long) 176L;
  i_126 = (int) i0_state * (int) 3L;
  i_127 = (int) 0L + (int) i_126;
  i_125 = GuiGetStyle((int) 9L, (int) i_127);
  m2_GetColor((long) I_124, (int) i_125);
  I_128 = m2_guiAlpha;
  m2_Fade((long) I_123, (long) I_124, (float) mir_read_float(I_128));
  I_129 = (long) fp + (long) 176L;
  I_130 = (long) fp + (long) 192L;
  i_131 = GuiGetStyle((int) 9L, (int) 7L);
  m2_GetColor((long) I_130, (int) i_131);
  I_132 = m2_guiAlpha;
  m2_Fade((long) I_129, (long) I_130, (float) mir_read_float(I_132));
  m2_GuiDrawRectangle((long) I_121, (int) i_122, (long) I_123, (long) I_129);
  mir_label = 1448; break;
case 1446:
  if ((int) i0_state != (int) 3L) { mir_label = 1449; break; }
case 1450:
  I_134 = (long) fp + (long) 8L;
  i_135 = GuiGetStyle((int) 9L, (int) 12L);
  I_136 = (long) fp + (long) 160L;
  I_137 = (long) fp + (long) 176L;
  i_139 = (int) i0_state * (int) 3L;
  i_140 = (int) 0L + (int) i_139;
  i_138 = GuiGetStyle((int) 9L, (int) i_140);
  m2_GetColor((long) I_137, (int) i_138);
  I_141 = m2_guiAlpha;
  m2_Fade((long) I_136, (long) I_137, (float) mir_read_float(I_141));
  I_142 = (long) fp + (long) 176L;
  I_143 = (long) fp + (long) 192L;
  i_144 = GuiGetStyle((int) 9L, (int) 10L);
  m2_GetColor((long) I_143, (int) i_144);
  I_145 = m2_guiAlpha;
  m2_Fade((long) I_142, (long) I_143, (float) mir_read_float(I_145));
  m2_GuiDrawRectangle((long) I_134, (int) i_135, (long) I_136, (long) I_142);
  mir_label = 1451; break;
case 1449:
  I_146 = (long) fp + (long) 8L;
  I_147 = (long) fp + (long) 160L;
  I_148 = (long) fp + (long) 176L;
  i_150 = (int) i0_state * (int) 3L;
  i_151 = (int) 0L + (int) i_150;
  i_149 = GuiGetStyle((int) 9L, (int) i_151);
  m2_GetColor((long) I_148, (int) i_149);
  I_152 = m2_guiAlpha;
  m2_Fade((long) I_147, (long) I_148, (float) mir_read_float(I_152));
  I_153 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(fp, I_153);
  I_154 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(1L + fp, I_154);
  I_155 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(2L + fp, I_155);
  I_156 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(3L + fp, I_156);
  m2_GuiDrawRectangle((long) I_146, (int) 1L, (long) I_147, (long) fp);
case 1451:
case 1448:
  i0_wrapMode = 1L;
  mir_write_float(72L + fp, mir_read_float(28L + fp));
  mir_write_float(76L + fp, mir_read_float(32L + fp));
  I_158 = (long) fp + (long) 80L;
  I_157 = memset((long) I_158, (int) 0L, (long) 16L);
  i14_i = 0L;
  mir_write_int(96L + fp, 0L);
  I_159 = (long) (int) i14_i;
  if ((int) mir_read_byte(U0_text + I_159) == (int) 0L) { mir_label = 1452; break; }
case 1453:
  U_162 = (long) (int) i14_i;
  U_164 = (long) U_162 * (long) 1L;
  U_163 = (long) U0_text + (long) U_164;
  U_165 = 96L;
  U_165 = (long) U_165 + (long) fp;
  i_161 = m2_GetCodepointNext((long) U_163, (long) U_165);
  i15_codepoint = i_161;
  I_167 = m2_guiFont;
  i_166 = GetGlyphIndex((long) I_167, (int) i15_codepoint);
  i15_index = i_166;
  I_168 = m2_guiFont;
  I_169 = (long) (int) i15_index;
  I_170 = mir_read_ulong(32L + I_168);
  I_172 = (long) fp + (long) 100L;
  I_173 = (long) I_169 * (long) 20L;
  I_173 = (long) I_173 + (long) I_170;
  I_171 = memcpy((long) I_172, (long) I_173, (long) 20L);
  I_174 = m2_guiFont;
  I_175 = (long) (int) i15_index;
  I_176 = mir_read_ulong(40L + I_174);
  I_178 = (long) fp + (long) 120L;
  I_179 = (long) I_175 * (long) 40L;
  I_179 = (long) I_179 + (long) I_176;
  I_177 = memcpy((long) I_178, (long) I_179, (long) 40L);
  if ((int) mir_read_int(96L + fp) != (int) 1L) { mir_label = 1454; break; }
case 1455:
  if ((int) i15_codepoint != (int) 10L) { mir_label = 1454; break; }
case 1456:
  I_182 = m2_guiFont;
  f_183 = (float) mir_read_int(I_182);
  f_184 = f_183 * f0_scaleFactor;
  i_185 = GuiGetStyle((int) 9L, (int) 17L);
  I_187 = (long) (int) i_185;
  f_186 = (float) I_187;
  f_188 = f_184 + f_186;
  f_189 = mir_read_float(76L + fp);
  f_189 = f_189 + f_188;
  mir_write_float(76L + fp, f_189);
  mir_write_float(72L + fp, mir_read_float(28L + fp));
  mir_label = 1457; break;
case 1454:
  if ((int) i0_wrapMode != (int) 1L) { mir_label = 1458; break; }
case 1459:
  i18_glyphWidth = 0L;
  if ((int) mir_read_int(132L + fp) == (int) 0L) { mir_label = 1460; break; }
case 1461:
  i_193 = i18_glyphWidth;
  i_193 = (int) i_193 + (int) mir_read_int(132L + fp);
  i18_glyphWidth = i_193;
  mir_label = 1462; break;
case 1460:
  f_195 = (float) mir_read_int(124L + fp);
  f_196 = mir_read_float(108L + fp) + f_195;
  i_197 = (long) f_196;
  i_198 = i18_glyphWidth;
  i_198 = (int) i_198 + (int) i_197;
  i18_glyphWidth = i_198;
case 1462:
  I_201 = (long) (int) i18_glyphWidth;
  f_200 = (float) I_201;
  f_202 = f_200 * f0_scaleFactor;
  f_203 = mir_read_float(72L + fp) + f_202;
  f_204 = mir_read_float(28L + fp) + mir_read_float(36L + fp);
  if (f_203 > f_204) { mir_label = 1463; break; }
  mir_label = 1464; break;
case 1463:
  I_206 = m2_guiFont;
  f_207 = (float) mir_read_int(I_206);
  f_208 = f_207 * f0_scaleFactor;
  i_209 = GuiGetStyle((int) 9L, (int) 17L);
  I_211 = (long) (int) i_209;
  f_210 = (float) I_211;
  f_212 = f_208 + f_210;
  f_213 = mir_read_float(76L + fp);
  f_213 = f_213 + f_212;
  mir_write_float(76L + fp, f_213);
  mir_write_float(72L + fp, mir_read_float(28L + fp));
  mir_label = 1465; break;
case 1464:
case 1465:
  mir_label = 1466; break;
case 1458:
  if ((int) i0_wrapMode != (int) 2L) { mir_label = 1467; break; }
case 1468:
  mir_label = 1469; break;
case 1467:
case 1469:
case 1466:
  I_216 = m2_guiFont;
  I_217 = (long) fp + (long) 72L;
  i_218 = GuiGetStyle((int) 0L, (int) 16L);
  I_220 = (long) (int) i_218;
  f_219 = (float) I_220;
  I_221 = (long) fp + (long) 160L;
  I_222 = (long) fp + (long) 176L;
  i_224 = (int) i0_state * (int) 3L;
  i_225 = (int) 2L + (int) i_224;
  i_223 = GuiGetStyle((int) 9L, (int) i_225);
  m2_GetColor((long) I_222, (int) i_223);
  I_226 = m2_guiAlpha;
  m2_Fade((long) I_221, (long) I_222, (float) mir_read_float(I_226));
  DrawTextCodepoint((long) I_216, (int) i15_codepoint, (long) I_217, (float) f_219, (long) I_221);
  i17_glyphWidth = 0L;
  if ((int) mir_read_int(132L + fp) == (int) 0L) { mir_label = 1470; break; }
case 1471:
  i_228 = i17_glyphWidth;
  i_228 = (int) i_228 + (int) mir_read_int(132L + fp);
  i17_glyphWidth = i_228;
  mir_label = 1472; break;
case 1470:
  f_230 = (float) mir_read_int(124L + fp);
  f_231 = mir_read_float(108L + fp) + f_230;
  i_232 = (long) f_231;
  i_233 = i17_glyphWidth;
  i_233 = (int) i_233 + (int) i_232;
  i17_glyphWidth = i_233;
case 1472:
  I_236 = (long) (int) i17_glyphWidth;
  f_235 = (float) I_236;
  f_237 = f_235 * f0_scaleFactor;
  i_238 = GuiGetStyle((int) 0L, (int) 17L);
  I_240 = (long) (int) i_238;
  f_239 = (float) I_240;
  f_241 = f_237 + f_239;
  f_242 = mir_read_float(72L + fp);
  f_242 = f_242 + f_241;
  mir_write_float(72L + fp, f_242);
case 1457:
case 1473:
  i_244 = i14_i;
  i_244 = (int) i_244 + (int) mir_read_int(96L + fp);
  i14_i = i_244;
  I_246 = (long) (int) i14_i;
  if ((int) mir_read_byte(U0_text + I_246) != (int) 0L) { mir_label = 1453; break; }
case 1452:
  mir_write_float(48L + fp, mir_read_float(72L + fp));
  mir_write_float(52L + fp, mir_read_float(76L + fp));
  I_248 = (long) (int) i0_editMode;
  if (((long) I_248 == 0)) { mir_label = 1474; break; }
case 1475:
  I_249 = (long) fp + (long) 48L;
  I_250 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(4L + fp, I_250);
  I_251 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(5L + fp, I_251);
  I_252 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(6L + fp, I_252);
  I_253 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(7L + fp, I_253);
  I_254 = (long) fp + (long) 4L;
  I_255 = (long) fp + (long) 160L;
  I_256 = (long) fp + (long) 176L;
  i_257 = GuiGetStyle((int) 9L, (int) 6L);
  m2_GetColor((long) I_256, (int) i_257);
  I_258 = m2_guiAlpha;
  m2_Fade((long) I_255, (long) I_256, (float) mir_read_float(I_258));
  m2_GuiDrawRectangle((long) I_249, (int) 0L, (long) I_254, (long) I_255);
  mir_label = 1476; break;
case 1474:
case 1476:
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_pressed;
} // End of switch
} // End of while
} // End of function GuiTextBoxMulti

public float GuiSliderPro (long _I0_bounds, long _U0_textLeft, long _U0_textRight, float f0_value, float f0_minValue, float f0_maxValue, int _i0_sliderWidth) {
  long I0_bounds = _I0_bounds;
  long U0_textLeft = _U0_textLeft;
  long U0_textRight = _U0_textRight;
  long i0_sliderWidth = _i0_sliderWidth;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  long i0_sliderValue = 0;
  float f_3 = 0;
  float f_4 = 0;
  float f_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  float f_8 = 0;
  long I_9 = 0;
  float f_10 = 0;
  float f_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  float f_14 = 0;
  long I_15 = 0;
  float f_16 = 0;
  long i_17 = 0;
  float f_18 = 0;
  long I_19 = 0;
  float f_20 = 0;
  float f_21 = 0;
  long i_22 = 0;
  long i_23 = 0;
  float f_24 = 0;
  long I_25 = 0;
  float f_26 = 0;
  long i_27 = 0;
  long i_28 = 0;
  float f_29 = 0;
  long I_30 = 0;
  float f_31 = 0;
  long I_32 = 0;
  long I_33 = 0;
  long i_34 = 0;
  long i_35 = 0;
  long i_36 = 0;
  float f_37 = 0;
  long I_38 = 0;
  float f_39 = 0;
  float f_40 = 0;
  float f_41 = 0;
  long I_42 = 0;
  long i_43 = 0;
  long i_44 = 0;
  float f_45 = 0;
  long I_46 = 0;
  float f_47 = 0;
  float f_48 = 0;
  float f_49 = 0;
  long I_50 = 0;
  long i_51 = 0;
  long I_52 = 0;
  long I_53 = 0;
  long I_54 = 0;
  long I_55 = 0;
  long i_56 = 0;
  long I_57 = 0;
  long I_58 = 0;
  long I_59 = 0;
  long i_60 = 0;
  long I_61 = 0;
  float f_62 = 0;
  long i_63 = 0;
  float f_64 = 0;
  long I_65 = 0;
  float f_66 = 0;
  float f_67 = 0;
  float f_68 = 0;
  float f_69 = 0;
  float f_70 = 0;
  long I_71 = 0;
  float f_72 = 0;
  float f_73 = 0;
  float f_74 = 0;
  float f_75 = 0;
  long i_76 = 0;
  float f_77 = 0;
  float f_78 = 0;
  float f_79 = 0;
  long i_80 = 0;
  float f_81 = 0;
  long I_82 = 0;
  long i_83 = 0;
  long i_84 = 0;
  long i_85 = 0;
  long i_86 = 0;
  float f_87 = 0;
  long I_88 = 0;
  float f_89 = 0;
  long i_90 = 0;
  long i_91 = 0;
  float f_92 = 0;
  long I_93 = 0;
  float f_94 = 0;
  float f_95 = 0;
  float f_96 = 0;
  long i_97 = 0;
  float f_98 = 0;
  float f_99 = 0;
  long i_100 = 0;
  float f_101 = 0;
  long I_102 = 0;
  float f_103 = 0;
  long i_104 = 0;
  long i_105 = 0;
  long i_106 = 0;
  long i_107 = 0;
  float f_108 = 0;
  long I_109 = 0;
  float f_110 = 0;
  long I_111 = 0;
  long i_112 = 0;
  long I_113 = 0;
  long I_114 = 0;
  long i_115 = 0;
  long i_116 = 0;
  long i_117 = 0;
  long I_118 = 0;
  long I_119 = 0;
  long I_120 = 0;
  long i_121 = 0;
  long i_122 = 0;
  long i_123 = 0;
  long I_124 = 0;
  long i_125 = 0;
  long i_126 = 0;
  long I_127 = 0;
  long I_128 = 0;
  long I_129 = 0;
  long I_130 = 0;
  long I_131 = 0;
  long I_132 = 0;
  long I_133 = 0;
  long i_134 = 0;
  long I_135 = 0;
  long i_136 = 0;
  long I_137 = 0;
  long I_138 = 0;
  long I_139 = 0;
  long I_140 = 0;
  long I_141 = 0;
  long I_142 = 0;
  long I_143 = 0;
  long I_144 = 0;
  long i_145 = 0;
  long I_146 = 0;
  long i_147 = 0;
  float f_148 = 0;
  long I_149 = 0;
  long I_150 = 0;
  long i_151 = 0;
  float f_152 = 0;
  long I_153 = 0;
  long i_154 = 0;
  float f_155 = 0;
  long I_156 = 0;
  float f_157 = 0;
  long i_158 = 0;
  float f_159 = 0;
  long I_160 = 0;
  float f_161 = 0;
  float f_162 = 0;
  float f_163 = 0;
  float f_164 = 0;
  long i_165 = 0;
  long i_166 = 0;
  float f_167 = 0;
  long I_168 = 0;
  float f_169 = 0;
  long I_170 = 0;
  long I_171 = 0;
  long I_172 = 0;
  long i_173 = 0;
  long i_174 = 0;
  long i_175 = 0;
  long I_176 = 0;
  long i_177 = 0;
  float f_178 = 0;
  long I_179 = 0;
  long I_180 = 0;
  long i_181 = 0;
  float f_182 = 0;
  long I_183 = 0;
  long i_184 = 0;
  float f_185 = 0;
  long I_186 = 0;
  float f_187 = 0;
  long i_188 = 0;
  float f_189 = 0;
  long I_190 = 0;
  float f_191 = 0;
  float f_192 = 0;
  float f_193 = 0;
  float f_194 = 0;
  long i_195 = 0;
  long i_196 = 0;
  float f_197 = 0;
  long I_198 = 0;
  float f_199 = 0;
  long I_200 = 0;
  long I_201 = 0;
  long I_202 = 0;
  long i_203 = 0;
  long i_204 = 0;
  long i_205 = 0;
  long I_206 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(128L);
  I_0 = (long) fp + (long) 8L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  f_3 = f0_value - f0_minValue;
  f_4 = f0_maxValue - f0_minValue;
  f_5 = f_3 / f_4;
  i_6 = GuiGetStyle((int) 4L, (int) 12L);
  i_7 = (int) 2L * (int) i_6;
  I_9 = (long) (int) i_7;
  f_8 = (float) I_9;
  f_10 = mir_read_float(16L + fp) - f_8;
  f_11 = f_5 * f_10;
  i_12 = (long) f_11;
  i0_sliderValue = i_12;
  mir_write_float(28L + fp, mir_read_float(8L + fp));
  i_13 = GuiGetStyle((int) 4L, (int) 12L);
  I_15 = (long) (int) i_13;
  f_14 = (float) I_15;
  f_16 = mir_read_float(12L + fp) + f_14;
  i_17 = GuiGetStyle((int) 4L, (int) 17L);
  I_19 = (long) (int) i_17;
  f_18 = (float) I_19;
  f_20 = f_16 + f_18;
  mir_write_float(32L + fp, f_20);
  f_21 = (float) 0L;
  mir_write_float(36L + fp, f_21);
  i_22 = GuiGetStyle((int) 4L, (int) 12L);
  i_23 = (int) 2L * (int) i_22;
  I_25 = (long) (int) i_23;
  f_24 = (float) I_25;
  f_26 = mir_read_float(20L + fp) - f_24;
  i_27 = GuiGetStyle((int) 4L, (int) 17L);
  i_28 = (int) 2L * (int) i_27;
  I_30 = (long) (int) i_28;
  f_29 = (float) I_30;
  f_31 = f_26 - f_29;
  mir_write_float(40L + fp, f_31);
  I_33 = (long) fp + (long) 44L;
  I_32 = memset((long) I_33, (int) 0L, (long) 4L);
  if ((int) i0_sliderWidth <= (int) 0L) { mir_label = 1477; break; }
case 1478:
  i_35 = (int) i0_sliderWidth / (int) 2L;
  i_36 = (int) i0_sliderValue - (int) i_35;
  I_38 = (long) (int) i_36;
  f_37 = (float) I_38;
  f_39 = mir_read_float(28L + fp);
  f_39 = f_39 + f_37;
  mir_write_float(28L + fp, f_39);
  I_42 = (long) (int) i0_sliderWidth;
  f_41 = (float) I_42;
  mir_write_float(36L + fp, f_41);
  mir_label = 1479; break;
case 1477:
  if ((int) i0_sliderWidth != (int) 0L) { mir_label = 1480; break; }
case 1481:
  i_44 = GuiGetStyle((int) 4L, (int) 12L);
  I_46 = (long) (int) i_44;
  f_45 = (float) I_46;
  f_47 = mir_read_float(28L + fp);
  f_47 = f_47 + f_45;
  mir_write_float(28L + fp, f_47);
  I_50 = (long) (int) i0_sliderValue;
  f_49 = (float) I_50;
  mir_write_float(36L + fp, f_49);
  mir_label = 1482; break;
case 1480:
case 1482:
case 1479:
  if ((int) i0_state == (int) 3L) { mir_label = 1483; break; }
case 1484:
  I_52 = m2_guiLocked;
  if (((long) mir_read_int(I_52) != 0)) { mir_label = 1483; break; }
case 1485:
  I_53 = (long) fp + (long) 80L;
  GetMousePosition((long) I_53);
  I_55 = (long) fp + (long) 48L;
  I_54 = memcpy((long) I_55, (long) I_53, (long) 24L);
  I_57 = (long) fp + (long) 48L;
  I_58 = (long) fp + (long) 8L;
  i_56 = m2_CheckCollisionPointRec((long) I_57, (long) I_58);
  I_59 = (long) (int) i_56;
  if (((long) I_59 == 0)) { mir_label = 1486; break; }
case 1487:
  i_60 = IsMouseButtonDown((int) 0L);
  I_61 = (long) (int) i_60;
  if (((long) I_61 == 0)) { mir_label = 1488; break; }
case 1489:
  i0_state = 2L;
  f_62 = f0_maxValue - f0_minValue;
  i_63 = (int) i0_sliderWidth / (int) 2L;
  I_65 = (long) (int) i_63;
  f_64 = (float) I_65;
  f_66 = mir_read_float(8L + fp) + f_64;
  f_67 = f_66;
  f_68 = mir_read_float(48L + fp) - f_67;
  f_69 = f_62 * f_68;
  I_71 = (long) (int) i0_sliderWidth;
  f_70 = (float) I_71;
  f_72 = mir_read_float(16L + fp) - f_70;
  f_73 = f_72;
  f_74 = f_69 / f_73;
  f_75 = f_74 + f0_minValue;
  f0_value = f_75;
  if ((int) i0_sliderWidth <= (int) 0L) { mir_label = 1490; break; }
case 1491:
  f_77 = (float) 2L;
  f_78 = mir_read_float(36L + fp) / f_77;
  f_79 = mir_read_float(48L + fp) - f_78;
  mir_write_float(28L + fp, f_79);
  mir_label = 1492; break;
case 1490:
  if ((int) i0_sliderWidth != (int) 0L) { mir_label = 1493; break; }
case 1494:
  I_82 = (long) (int) i0_sliderValue;
  f_81 = (float) I_82;
  mir_write_float(36L + fp, f_81);
  mir_label = 1495; break;
case 1493:
case 1495:
case 1492:
  mir_label = 1496; break;
case 1488:
  i0_state = 1L;
case 1496:
  mir_label = 1497; break;
case 1486:
case 1497:
  if (f0_value > f0_maxValue) { mir_label = 1498; break; }
  mir_label = 1499; break;
case 1498:
  f0_value = f0_maxValue;
  mir_label = 1500; break;
case 1499:
  if (f0_value < f0_minValue) { mir_label = 1501; break; }
  mir_label = 1502; break;
case 1501:
  f0_value = f0_minValue;
  mir_label = 1503; break;
case 1502:
case 1503:
case 1500:
  mir_label = 1504; break;
case 1483:
case 1504:
  if ((int) i0_sliderWidth <= (int) 0L) { mir_label = 1505; break; }
case 1506:
  i_86 = GuiGetStyle((int) 4L, (int) 12L);
  I_88 = (long) (int) i_86;
  f_87 = (float) I_88;
  f_89 = mir_read_float(8L + fp) + f_87;
  if (mir_read_float(28L + fp) <= f_89) { mir_label = 1507; break; }
  mir_label = 1508; break;
case 1507:
  i_91 = GuiGetStyle((int) 4L, (int) 12L);
  I_93 = (long) (int) i_91;
  f_92 = (float) I_93;
  f_94 = mir_read_float(8L + fp) + f_92;
  mir_write_float(28L + fp, f_94);
  mir_label = 1509; break;
case 1508:
  f_95 = mir_read_float(28L + fp) + mir_read_float(36L + fp);
  f_96 = mir_read_float(8L + fp) + mir_read_float(16L + fp);
  if (f_95 >= f_96) { mir_label = 1510; break; }
  mir_label = 1511; break;
case 1510:
  f_98 = mir_read_float(8L + fp) + mir_read_float(16L + fp);
  f_99 = f_98 - mir_read_float(36L + fp);
  i_100 = GuiGetStyle((int) 4L, (int) 12L);
  I_102 = (long) (int) i_100;
  f_101 = (float) I_102;
  f_103 = f_99 - f_101;
  mir_write_float(28L + fp, f_103);
  mir_label = 1512; break;
case 1511:
case 1512:
case 1509:
  mir_label = 1513; break;
case 1505:
  if ((int) i0_sliderWidth != (int) 0L) { mir_label = 1514; break; }
case 1515:
  if (mir_read_float(36L + fp) > mir_read_float(16L + fp)) { mir_label = 1516; break; }
  mir_label = 1517; break;
case 1516:
  i_106 = GuiGetStyle((int) 4L, (int) 12L);
  i_107 = (int) 2L * (int) i_106;
  I_109 = (long) (int) i_107;
  f_108 = (float) I_109;
  f_110 = mir_read_float(16L + fp) - f_108;
  mir_write_float(36L + fp, f_110);
  mir_label = 1518; break;
case 1517:
case 1518:
  mir_label = 1519; break;
case 1514:
case 1519:
case 1513:
  I_111 = (long) fp + (long) 8L;
  i_112 = GuiGetStyle((int) 4L, (int) 12L);
  I_113 = (long) fp + (long) 80L;
  I_114 = (long) fp + (long) 96L;
  i_116 = (int) i0_state * (int) 3L;
  i_117 = (int) 0L + (int) i_116;
  i_115 = GuiGetStyle((int) 4L, (int) i_117);
  m2_GetColor((long) I_114, (int) i_115);
  I_118 = m2_guiAlpha;
  m2_Fade((long) I_113, (long) I_114, (float) mir_read_float(I_118));
  I_119 = (long) fp + (long) 96L;
  I_120 = (long) fp + (long) 112L;
  if ((int) i0_state == (int) 3L) { mir_label = 1520; break; }
case 1521:
  i_123 = 1L;
  mir_label = 1522; break;
case 1520:
  i_123 = 10L;
case 1522:
  i_121 = GuiGetStyle((int) 4L, (int) i_123);
  m2_GetColor((long) I_120, (int) i_121);
  I_124 = m2_guiAlpha;
  m2_Fade((long) I_119, (long) I_120, (float) mir_read_float(I_124));
  m2_GuiDrawRectangle((long) I_111, (int) i_112, (long) I_113, (long) I_119);
  if ((int) i0_state == (int) 0L) { mir_label = 1523; break; }
case 1524:
  if ((int) i0_state != (int) 2L) { mir_label = 1525; break; }
case 1523:
  I_127 = (long) fp + (long) 28L;
  I_128 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(fp, I_128);
  I_129 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(1L + fp, I_129);
  I_130 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(2L + fp, I_130);
  I_131 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(3L + fp, I_131);
  I_132 = (long) fp + (long) 80L;
  I_133 = (long) fp + (long) 96L;
  i_134 = GuiGetStyle((int) 4L, (int) 7L);
  m2_GetColor((long) I_133, (int) i_134);
  I_135 = m2_guiAlpha;
  m2_Fade((long) I_132, (long) I_133, (float) mir_read_float(I_135));
  m2_GuiDrawRectangle((long) I_127, (int) 0L, (long) fp, (long) I_132);
  mir_label = 1526; break;
case 1525:
  if ((int) i0_state != (int) 1L) { mir_label = 1527; break; }
case 1528:
  I_137 = (long) fp + (long) 28L;
  I_138 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(4L + fp, I_138);
  I_139 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(5L + fp, I_139);
  I_140 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(6L + fp, I_140);
  I_141 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(7L + fp, I_141);
  I_142 = (long) fp + (long) 4L;
  I_143 = (long) fp + (long) 80L;
  I_144 = (long) fp + (long) 96L;
  i_145 = GuiGetStyle((int) 4L, (int) 5L);
  m2_GetColor((long) I_144, (int) i_145);
  I_146 = m2_guiAlpha;
  m2_Fade((long) I_143, (long) I_144, (float) mir_read_float(I_146));
  m2_GuiDrawRectangle((long) I_137, (int) 0L, (long) I_142, (long) I_143);
  mir_label = 1529; break;
case 1527:
case 1529:
case 1526:
  if ((long) U0_textLeft == (long) 0L) { mir_label = 1530; break; }
case 1531:
  f_148 = (float) 0L;
  mir_write_float(48L + fp, f_148);
  I_150 = (long) fp + (long) 52L;
  I_149 = memset((long) I_150, (int) 0L, (long) 16L);
  i_151 = m2_GetTextWidth((long) U0_textLeft);
  I_153 = (long) (int) i_151;
  f_152 = (float) I_153;
  mir_write_float(56L + fp, f_152);
  i_154 = GuiGetStyle((int) 0L, (int) 16L);
  I_156 = (long) (int) i_154;
  f_155 = (float) I_156;
  mir_write_float(60L + fp, f_155);
  f_157 = mir_read_float(8L + fp) - mir_read_float(56L + fp);
  i_158 = GuiGetStyle((int) 4L, (int) 13L);
  I_160 = (long) (int) i_158;
  f_159 = (float) I_160;
  f_161 = f_157 - f_159;
  mir_write_float(48L + fp, f_161);
  f_162 = (float) 2L;
  f_163 = mir_read_float(20L + fp) / f_162;
  f_164 = mir_read_float(12L + fp) + f_163;
  i_165 = GuiGetStyle((int) 0L, (int) 16L);
  i_166 = (int) i_165 / (int) 2L;
  I_168 = (long) (int) i_166;
  f_167 = (float) I_168;
  f_169 = f_164 - f_167;
  mir_write_float(52L + fp, f_169);
  I_170 = (long) fp + (long) 48L;
  I_171 = (long) fp + (long) 80L;
  I_172 = (long) fp + (long) 96L;
  i_174 = (int) i0_state * (int) 3L;
  i_175 = (int) 2L + (int) i_174;
  i_173 = GuiGetStyle((int) 4L, (int) i_175);
  m2_GetColor((long) I_172, (int) i_173);
  I_176 = m2_guiAlpha;
  m2_Fade((long) I_171, (long) I_172, (float) mir_read_float(I_176));
  m2_GuiDrawText((long) U0_textLeft, (long) I_170, (int) 2L, (long) I_171);
  mir_label = 1532; break;
case 1530:
case 1532:
  if ((long) U0_textRight == (long) 0L) { mir_label = 1533; break; }
case 1534:
  f_178 = (float) 0L;
  mir_write_float(48L + fp, f_178);
  I_180 = (long) fp + (long) 52L;
  I_179 = memset((long) I_180, (int) 0L, (long) 16L);
  i_181 = m2_GetTextWidth((long) U0_textRight);
  I_183 = (long) (int) i_181;
  f_182 = (float) I_183;
  mir_write_float(56L + fp, f_182);
  i_184 = GuiGetStyle((int) 0L, (int) 16L);
  I_186 = (long) (int) i_184;
  f_185 = (float) I_186;
  mir_write_float(60L + fp, f_185);
  f_187 = mir_read_float(8L + fp) + mir_read_float(16L + fp);
  i_188 = GuiGetStyle((int) 4L, (int) 13L);
  I_190 = (long) (int) i_188;
  f_189 = (float) I_190;
  f_191 = f_187 + f_189;
  mir_write_float(48L + fp, f_191);
  f_192 = (float) 2L;
  f_193 = mir_read_float(20L + fp) / f_192;
  f_194 = mir_read_float(12L + fp) + f_193;
  i_195 = GuiGetStyle((int) 0L, (int) 16L);
  i_196 = (int) i_195 / (int) 2L;
  I_198 = (long) (int) i_196;
  f_197 = (float) I_198;
  f_199 = f_194 - f_197;
  mir_write_float(52L + fp, f_199);
  I_200 = (long) fp + (long) 48L;
  I_201 = (long) fp + (long) 80L;
  I_202 = (long) fp + (long) 96L;
  i_204 = (int) i0_state * (int) 3L;
  i_205 = (int) 2L + (int) i_204;
  i_203 = GuiGetStyle((int) 4L, (int) i_205);
  m2_GetColor((long) I_202, (int) i_203);
  I_206 = m2_guiAlpha;
  m2_Fade((long) I_201, (long) I_202, (float) mir_read_float(I_206));
  m2_GuiDrawText((long) U0_textRight, (long) I_200, (int) 0L, (long) I_201);
  mir_label = 1535; break;
case 1533:
case 1535:
  mir_set_stack_position(mir_saved_stack_position);
  return (float) f0_value;
} // End of switch
} // End of while
} // End of function GuiSliderPro

public float GuiSlider (long _I0_bounds, long _U0_textLeft, long _U0_textRight, float f0_value, float f0_minValue, float f0_maxValue) {
  long I0_bounds = _I0_bounds;
  long U0_textLeft = _U0_textLeft;
  long U0_textRight = _U0_textRight;
  long fp = 0;
  long I_0 = 0;
  float f_1 = 0;
  long i_2 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(32L);
  I_0 = memcpy((long) fp, (long) I0_bounds, (long) 20L);
  i_2 = GuiGetStyle((int) 4L, (int) 16L);
  f_1 = GuiSliderPro((long) fp, (long) U0_textLeft, (long) U0_textRight, (float) f0_value, (float) f0_minValue, (float) f0_maxValue, (int) i_2);
  mir_set_stack_position(mir_saved_stack_position);
  return (float) f_1;
} // End of function GuiSlider

public float GuiSliderBar (long _I0_bounds, long _U0_textLeft, long _U0_textRight, float f0_value, float f0_minValue, float f0_maxValue) {
  long I0_bounds = _I0_bounds;
  long U0_textLeft = _U0_textLeft;
  long U0_textRight = _U0_textRight;
  long fp = 0;
  long I_0 = 0;
  float f_1 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(32L);
  I_0 = memcpy((long) fp, (long) I0_bounds, (long) 20L);
  f_1 = GuiSliderPro((long) fp, (long) U0_textLeft, (long) U0_textRight, (float) f0_value, (float) f0_minValue, (float) f0_maxValue, (int) 0L);
  mir_set_stack_position(mir_saved_stack_position);
  return (float) f_1;
} // End of function GuiSliderBar

public float GuiProgressBar (long _I0_bounds, long _U0_textLeft, long _U0_textRight, float f0_value, float f0_minValue, float f0_maxValue) {
  long I0_bounds = _I0_bounds;
  long U0_textLeft = _U0_textLeft;
  long U0_textRight = _U0_textRight;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  long i_3 = 0;
  float f_4 = 0;
  long I_5 = 0;
  float f_6 = 0;
  long i_7 = 0;
  float f_8 = 0;
  long I_9 = 0;
  float f_10 = 0;
  long i_11 = 0;
  float f_12 = 0;
  long I_13 = 0;
  float f_14 = 0;
  float f_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  float f_18 = 0;
  long I_19 = 0;
  float f_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  float f_23 = 0;
  long I_24 = 0;
  float f_25 = 0;
  long I_26 = 0;
  long I_27 = 0;
  long i_28 = 0;
  long i_29 = 0;
  float f_30 = 0;
  float f_31 = 0;
  float f_32 = 0;
  long i_33 = 0;
  long i_34 = 0;
  float f_35 = 0;
  long I_36 = 0;
  float f_37 = 0;
  float f_38 = 0;
  float f_39 = 0;
  long I_40 = 0;
  long i_41 = 0;
  long I_42 = 0;
  long I_43 = 0;
  long i_44 = 0;
  long i_45 = 0;
  long i_46 = 0;
  long I_47 = 0;
  long I_48 = 0;
  long I_49 = 0;
  long I_50 = 0;
  long I_51 = 0;
  long i_52 = 0;
  long i_53 = 0;
  long I_54 = 0;
  long I_55 = 0;
  long I_56 = 0;
  long I_57 = 0;
  long I_58 = 0;
  long I_59 = 0;
  long I_60 = 0;
  long I_61 = 0;
  long i_62 = 0;
  long I_63 = 0;
  long i_64 = 0;
  long I_65 = 0;
  long I_66 = 0;
  long I_67 = 0;
  long I_68 = 0;
  long I_69 = 0;
  long I_70 = 0;
  long I_71 = 0;
  long I_72 = 0;
  long i_73 = 0;
  long I_74 = 0;
  long i_75 = 0;
  float f_76 = 0;
  long I_77 = 0;
  long I_78 = 0;
  long i_79 = 0;
  float f_80 = 0;
  long I_81 = 0;
  long i_82 = 0;
  float f_83 = 0;
  long I_84 = 0;
  float f_85 = 0;
  long i_86 = 0;
  float f_87 = 0;
  long I_88 = 0;
  float f_89 = 0;
  float f_90 = 0;
  float f_91 = 0;
  float f_92 = 0;
  long i_93 = 0;
  long i_94 = 0;
  float f_95 = 0;
  long I_96 = 0;
  float f_97 = 0;
  long I_98 = 0;
  long I_99 = 0;
  long I_100 = 0;
  long i_101 = 0;
  long i_102 = 0;
  long i_103 = 0;
  long I_104 = 0;
  long i_105 = 0;
  float f_106 = 0;
  long I_107 = 0;
  long I_108 = 0;
  long i_109 = 0;
  float f_110 = 0;
  long I_111 = 0;
  long i_112 = 0;
  float f_113 = 0;
  long I_114 = 0;
  float f_115 = 0;
  long i_116 = 0;
  float f_117 = 0;
  long I_118 = 0;
  float f_119 = 0;
  float f_120 = 0;
  float f_121 = 0;
  float f_122 = 0;
  long i_123 = 0;
  long i_124 = 0;
  float f_125 = 0;
  long I_126 = 0;
  float f_127 = 0;
  long I_128 = 0;
  long I_129 = 0;
  long I_130 = 0;
  long i_131 = 0;
  long i_132 = 0;
  long i_133 = 0;
  long I_134 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(112L);
  I_0 = (long) fp + (long) 12L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  i_3 = GuiGetStyle((int) 5L, (int) 12L);
  I_5 = (long) (int) i_3;
  f_4 = (float) I_5;
  f_6 = mir_read_float(12L + fp) + f_4;
  mir_write_float(32L + fp, f_6);
  i_7 = GuiGetStyle((int) 5L, (int) 12L);
  I_9 = (long) (int) i_7;
  f_8 = (float) I_9;
  f_10 = mir_read_float(16L + fp) + f_8;
  i_11 = GuiGetStyle((int) 5L, (int) 16L);
  I_13 = (long) (int) i_11;
  f_12 = (float) I_13;
  f_14 = f_10 + f_12;
  mir_write_float(36L + fp, f_14);
  f_15 = (float) 0L;
  mir_write_float(40L + fp, f_15);
  i_16 = GuiGetStyle((int) 5L, (int) 12L);
  i_17 = (int) 2L * (int) i_16;
  I_19 = (long) (int) i_17;
  f_18 = (float) I_19;
  f_20 = mir_read_float(24L + fp) - f_18;
  i_21 = GuiGetStyle((int) 5L, (int) 16L);
  i_22 = (int) 2L * (int) i_21;
  I_24 = (long) (int) i_22;
  f_23 = (float) I_24;
  f_25 = f_20 - f_23;
  mir_write_float(44L + fp, f_25);
  I_27 = (long) fp + (long) 48L;
  I_26 = memset((long) I_27, (int) 0L, (long) 4L);
  if (f0_value > f0_maxValue) { mir_label = 1536; break; }
  mir_label = 1537; break;
case 1536:
  f0_value = f0_maxValue;
  mir_label = 1538; break;
case 1537:
case 1538:
  if ((int) i0_state == (int) 3L) { mir_label = 1539; break; }
case 1540:
  f_30 = f0_maxValue - f0_minValue;
  f_31 = f0_value / f_30;
  f_32 = f_31;
  i_33 = GuiGetStyle((int) 5L, (int) 12L);
  i_34 = (int) 2L * (int) i_33;
  I_36 = (long) (int) i_34;
  f_35 = (float) I_36;
  f_37 = mir_read_float(20L + fp) - f_35;
  f_38 = f_37;
  f_39 = f_32 * f_38;
  mir_write_float(40L + fp, f_39);
  mir_label = 1541; break;
case 1539:
case 1541:
  I_40 = (long) fp + (long) 12L;
  i_41 = GuiGetStyle((int) 5L, (int) 12L);
  I_42 = (long) fp + (long) 80L;
  I_43 = (long) fp + (long) 96L;
  i_45 = (int) i0_state * (int) 3L;
  i_46 = (int) 0L + (int) i_45;
  i_44 = GuiGetStyle((int) 5L, (int) i_46);
  m2_GetColor((long) I_43, (int) i_44);
  I_47 = m2_guiAlpha;
  m2_Fade((long) I_42, (long) I_43, (float) mir_read_float(I_47));
  I_48 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(fp, I_48);
  I_49 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(1L + fp, I_49);
  I_50 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(2L + fp, I_50);
  I_51 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(3L + fp, I_51);
  m2_GuiDrawRectangle((long) I_40, (int) i_41, (long) I_42, (long) fp);
  if ((int) i0_state == (int) 0L) { mir_label = 1542; break; }
case 1543:
  if ((int) i0_state != (int) 2L) { mir_label = 1544; break; }
case 1542:
  I_54 = (long) fp + (long) 32L;
  I_55 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(4L + fp, I_55);
  I_56 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(5L + fp, I_56);
  I_57 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(6L + fp, I_57);
  I_58 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(7L + fp, I_58);
  I_59 = (long) fp + (long) 4L;
  I_60 = (long) fp + (long) 80L;
  I_61 = (long) fp + (long) 96L;
  i_62 = GuiGetStyle((int) 5L, (int) 7L);
  m2_GetColor((long) I_61, (int) i_62);
  I_63 = m2_guiAlpha;
  m2_Fade((long) I_60, (long) I_61, (float) mir_read_float(I_63));
  m2_GuiDrawRectangle((long) I_54, (int) 0L, (long) I_59, (long) I_60);
  mir_label = 1545; break;
case 1544:
  if ((int) i0_state != (int) 1L) { mir_label = 1546; break; }
case 1547:
  I_65 = (long) fp + (long) 32L;
  I_66 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(8L + fp, I_66);
  I_67 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(9L + fp, I_67);
  I_68 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(10L + fp, I_68);
  I_69 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(11L + fp, I_69);
  I_70 = (long) fp + (long) 8L;
  I_71 = (long) fp + (long) 80L;
  I_72 = (long) fp + (long) 96L;
  i_73 = GuiGetStyle((int) 5L, (int) 5L);
  m2_GetColor((long) I_72, (int) i_73);
  I_74 = m2_guiAlpha;
  m2_Fade((long) I_71, (long) I_72, (float) mir_read_float(I_74));
  m2_GuiDrawRectangle((long) I_65, (int) 0L, (long) I_70, (long) I_71);
  mir_label = 1548; break;
case 1546:
case 1548:
case 1545:
  if ((long) U0_textLeft == (long) 0L) { mir_label = 1549; break; }
case 1550:
  f_76 = (float) 0L;
  mir_write_float(52L + fp, f_76);
  I_78 = (long) fp + (long) 56L;
  I_77 = memset((long) I_78, (int) 0L, (long) 16L);
  i_79 = m2_GetTextWidth((long) U0_textLeft);
  I_81 = (long) (int) i_79;
  f_80 = (float) I_81;
  mir_write_float(60L + fp, f_80);
  i_82 = GuiGetStyle((int) 0L, (int) 16L);
  I_84 = (long) (int) i_82;
  f_83 = (float) I_84;
  mir_write_float(64L + fp, f_83);
  f_85 = mir_read_float(12L + fp) - mir_read_float(60L + fp);
  i_86 = GuiGetStyle((int) 5L, (int) 13L);
  I_88 = (long) (int) i_86;
  f_87 = (float) I_88;
  f_89 = f_85 - f_87;
  mir_write_float(52L + fp, f_89);
  f_90 = (float) 2L;
  f_91 = mir_read_float(24L + fp) / f_90;
  f_92 = mir_read_float(16L + fp) + f_91;
  i_93 = GuiGetStyle((int) 0L, (int) 16L);
  i_94 = (int) i_93 / (int) 2L;
  I_96 = (long) (int) i_94;
  f_95 = (float) I_96;
  f_97 = f_92 - f_95;
  mir_write_float(56L + fp, f_97);
  I_98 = (long) fp + (long) 52L;
  I_99 = (long) fp + (long) 80L;
  I_100 = (long) fp + (long) 96L;
  i_102 = (int) i0_state * (int) 3L;
  i_103 = (int) 2L + (int) i_102;
  i_101 = GuiGetStyle((int) 5L, (int) i_103);
  m2_GetColor((long) I_100, (int) i_101);
  I_104 = m2_guiAlpha;
  m2_Fade((long) I_99, (long) I_100, (float) mir_read_float(I_104));
  m2_GuiDrawText((long) U0_textLeft, (long) I_98, (int) 2L, (long) I_99);
  mir_label = 1551; break;
case 1549:
case 1551:
  if ((long) U0_textRight == (long) 0L) { mir_label = 1552; break; }
case 1553:
  f_106 = (float) 0L;
  mir_write_float(52L + fp, f_106);
  I_108 = (long) fp + (long) 56L;
  I_107 = memset((long) I_108, (int) 0L, (long) 16L);
  i_109 = m2_GetTextWidth((long) U0_textRight);
  I_111 = (long) (int) i_109;
  f_110 = (float) I_111;
  mir_write_float(60L + fp, f_110);
  i_112 = GuiGetStyle((int) 0L, (int) 16L);
  I_114 = (long) (int) i_112;
  f_113 = (float) I_114;
  mir_write_float(64L + fp, f_113);
  f_115 = mir_read_float(12L + fp) + mir_read_float(20L + fp);
  i_116 = GuiGetStyle((int) 5L, (int) 13L);
  I_118 = (long) (int) i_116;
  f_117 = (float) I_118;
  f_119 = f_115 + f_117;
  mir_write_float(52L + fp, f_119);
  f_120 = (float) 2L;
  f_121 = mir_read_float(24L + fp) / f_120;
  f_122 = mir_read_float(16L + fp) + f_121;
  i_123 = GuiGetStyle((int) 0L, (int) 16L);
  i_124 = (int) i_123 / (int) 2L;
  I_126 = (long) (int) i_124;
  f_125 = (float) I_126;
  f_127 = f_122 - f_125;
  mir_write_float(56L + fp, f_127);
  I_128 = (long) fp + (long) 52L;
  I_129 = (long) fp + (long) 80L;
  I_130 = (long) fp + (long) 96L;
  i_132 = (int) i0_state * (int) 3L;
  i_133 = (int) 2L + (int) i_132;
  i_131 = GuiGetStyle((int) 5L, (int) i_133);
  m2_GetColor((long) I_130, (int) i_131);
  I_134 = m2_guiAlpha;
  m2_Fade((long) I_129, (long) I_130, (float) mir_read_float(I_134));
  m2_GuiDrawText((long) U0_textRight, (long) I_128, (int) 0L, (long) I_129);
  mir_label = 1554; break;
case 1552:
case 1554:
  mir_set_stack_position(mir_saved_stack_position);
  return (float) f0_value;
} // End of switch
} // End of while
} // End of function GuiProgressBar

public void GuiStatusBar (long _I0_bounds, long _U0_text) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long fp = 0;
  long I_0 = 0;
  long i0_state = 0;
  long I_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long i_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  long I_14 = 0;
  long I_15 = 0;
  long i_16 = 0;
  long I_17 = 0;
  long I_18 = 0;
  long i_19 = 0;
  long i_20 = 0;
  long i_21 = 0;
  long I_22 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(96L);
  I_0 = memcpy((long) fp, (long) I0_bounds, (long) 20L);
  I_1 = m2_guiState;
  i0_state = mir_read_int(I_1);
  i_2 = GuiGetStyle((int) 15L, (int) 12L);
  I_3 = (long) fp + (long) 32L;
  I_4 = (long) fp + (long) 48L;
  if ((int) i0_state == (int) 3L) { mir_label = 1555; break; }
case 1556:
  i_7 = 0L;
  mir_label = 1557; break;
case 1555:
  i_7 = 9L;
case 1557:
  i_5 = GuiGetStyle((int) 15L, (int) i_7);
  m2_GetColor((long) I_4, (int) i_5);
  I_8 = m2_guiAlpha;
  m2_Fade((long) I_3, (long) I_4, (float) mir_read_float(I_8));
  I_9 = (long) fp + (long) 48L;
  I_10 = (long) fp + (long) 64L;
  if ((int) i0_state == (int) 3L) { mir_label = 1558; break; }
case 1559:
  i_13 = 1L;
  mir_label = 1560; break;
case 1558:
  i_13 = 10L;
case 1560:
  i_11 = GuiGetStyle((int) 15L, (int) i_13);
  m2_GetColor((long) I_10, (int) i_11);
  I_14 = m2_guiAlpha;
  m2_Fade((long) I_9, (long) I_10, (float) mir_read_float(I_14));
  m2_GuiDrawRectangle((long) fp, (int) i_2, (long) I_3, (long) I_9);
  I_15 = (long) fp + (long) 32L;
  m2_GetTextBounds((long) I_15, (int) 15L, (long) fp);
  i_16 = GuiGetStyle((int) 15L, (int) 14L);
  I_17 = (long) fp + (long) 64L;
  I_18 = (long) fp + (long) 80L;
  if ((int) i0_state == (int) 3L) { mir_label = 1561; break; }
case 1562:
  i_21 = 2L;
  mir_label = 1563; break;
case 1561:
  i_21 = 11L;
case 1563:
  i_19 = GuiGetStyle((int) 15L, (int) i_21);
  m2_GetColor((long) I_18, (int) i_19);
  I_22 = m2_guiAlpha;
  m2_Fade((long) I_17, (long) I_18, (float) mir_read_float(I_22));
  m2_GuiDrawText((long) U0_text, (long) I_15, (int) i_16, (long) I_17);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiStatusBar

public void GuiDummyRec (long _I0_bounds, long _U0_text) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  long i_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long I_7 = 0;
  long i_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  long i_12 = 0;
  long I_13 = 0;
  long I_14 = 0;
  long I_15 = 0;
  long I_16 = 0;
  long I_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  long I_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  long i_23 = 0;
  long I_24 = 0;
  long I_25 = 0;
  long I_26 = 0;
  long I_27 = 0;
  long I_28 = 0;
  long i_29 = 0;
  long i_30 = 0;
  long i_31 = 0;
  long I_32 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(112L);
  I_0 = (long) fp + (long) 4L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  if ((int) i0_state == (int) 3L) { mir_label = 1564; break; }
case 1565:
  I_4 = m2_guiLocked;
  if (((long) mir_read_int(I_4) != 0)) { mir_label = 1564; break; }
case 1566:
  I_5 = (long) fp + (long) 48L;
  GetMousePosition((long) I_5);
  I_7 = (long) fp + (long) 24L;
  I_6 = memcpy((long) I_7, (long) I_5, (long) 24L);
  I_9 = (long) fp + (long) 24L;
  I_10 = (long) fp + (long) 4L;
  i_8 = m2_CheckCollisionPointRec((long) I_9, (long) I_10);
  I_11 = (long) (int) i_8;
  if (((long) I_11 == 0)) { mir_label = 1567; break; }
case 1568:
  i_12 = IsMouseButtonDown((int) 0L);
  I_13 = (long) (int) i_12;
  if (((long) I_13 == 0)) { mir_label = 1569; break; }
case 1570:
  i0_state = 2L;
  mir_label = 1571; break;
case 1569:
  i0_state = 1L;
case 1571:
  mir_label = 1572; break;
case 1567:
case 1572:
  mir_label = 1573; break;
case 1564:
case 1573:
  I_14 = (long) fp + (long) 4L;
  I_15 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(fp, I_15);
  I_16 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(1L + fp, I_16);
  I_17 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(2L + fp, I_17);
  I_18 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(3L + fp, I_18);
  I_19 = (long) fp + (long) 48L;
  I_20 = (long) fp + (long) 64L;
  if ((int) i0_state == (int) 3L) { mir_label = 1574; break; }
case 1575:
  i_23 = 1L;
  mir_label = 1576; break;
case 1574:
  i_23 = 10L;
case 1576:
  i_21 = GuiGetStyle((int) 0L, (int) i_23);
  m2_GetColor((long) I_20, (int) i_21);
  I_24 = m2_guiAlpha;
  m2_Fade((long) I_19, (long) I_20, (float) mir_read_float(I_24));
  m2_GuiDrawRectangle((long) I_14, (int) 0L, (long) fp, (long) I_19);
  I_25 = (long) fp + (long) 48L;
  I_26 = (long) fp + (long) 4L;
  m2_GetTextBounds((long) I_25, (int) 0L, (long) I_26);
  I_27 = (long) fp + (long) 80L;
  I_28 = (long) fp + (long) 96L;
  if ((int) i0_state == (int) 3L) { mir_label = 1577; break; }
case 1578:
  i_31 = 2L;
  mir_label = 1579; break;
case 1577:
  i_31 = 11L;
case 1579:
  i_29 = GuiGetStyle((int) 2L, (int) i_31);
  m2_GetColor((long) I_28, (int) i_29);
  I_32 = m2_guiAlpha;
  m2_Fade((long) I_27, (long) I_28, (float) mir_read_float(I_32));
  m2_GuiDrawText((long) U0_text, (long) I_25, (int) 1L, (long) I_27);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiDummyRec

public int GuiListView (long _I0_bounds, long _U0_text, long _U0_scrollIndex, int _i0_active) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long U0_scrollIndex = _U0_scrollIndex;
  long i0_active = _i0_active;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long U0_items = 0;
  long i_2 = 0;
  long U_3 = 0;
  long U_4 = 0;
  long i_5 = 0;
  long I_6 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(32L);
  I_0 = (long) fp + (long) 4L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  mir_write_int(fp, 0L);
  U0_items = 0L;
  if ((long) U0_text == (long) 0L) { mir_label = 1580; break; }
case 1581:
  U_4 = fp;
  U_3 = m2_GuiTextSplit((long) U0_text, (byte) 59L, (long) U_4, (long) 0L);
  U0_items = U_3;
  mir_label = 1582; break;
case 1580:
case 1582:
  I_6 = (long) fp + (long) 4L;
  i_5 = GuiListViewEx((long) I_6, (long) U0_items, (int) mir_read_int(fp), (long) 0L, (long) U0_scrollIndex, (int) i0_active);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i_5;
} // End of switch
} // End of while
} // End of function GuiListView

public int GuiListViewEx (long _I0_bounds, long _U0_text, int _i0_count, long _U0_focus, long _U0_scrollIndex, int _i0_active) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long i0_count = _i0_count;
  long U0_focus = _U0_focus;
  long U0_scrollIndex = _U0_scrollIndex;
  long i0_active = _i0_active;
  long fp = 0;
  long I_0 = 0;
  long i0_state = 0;
  long I_1 = 0;
  long i0_itemFocused = 0;
  long i_2 = 0;
  long i_3 = 0;
  long i0_itemSelected = 0;
  long i0_useScrollBar = 0;
  long i_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  float f_8 = 0;
  long I_9 = 0;
  long i_10 = 0;
  float f_11 = 0;
  long I_12 = 0;
  long I_13 = 0;
  long i_14 = 0;
  float f_15 = 0;
  long I_16 = 0;
  float f_17 = 0;
  long i_18 = 0;
  float f_19 = 0;
  long I_20 = 0;
  float f_21 = 0;
  long i_22 = 0;
  float f_23 = 0;
  long I_24 = 0;
  float f_25 = 0;
  long i_26 = 0;
  long i_27 = 0;
  float f_28 = 0;
  long I_29 = 0;
  float f_30 = 0;
  long i_31 = 0;
  float f_32 = 0;
  long I_33 = 0;
  float f_34 = 0;
  long i_35 = 0;
  float f_36 = 0;
  long I_37 = 0;
  long I_38 = 0;
  long i_39 = 0;
  float f_40 = 0;
  long I_41 = 0;
  float f_42 = 0;
  float f_43 = 0;
  long i0_visibleItems = 0;
  long i_44 = 0;
  long i_45 = 0;
  long i_46 = 0;
  long i_47 = 0;
  long i_48 = 0;
  long i_49 = 0;
  long i0_startIndex = 0;
  long i_50 = 0;
  long i_51 = 0;
  long i_52 = 0;
  long i_53 = 0;
  long i_54 = 0;
  long i0_endIndex = 0;
  long i_55 = 0;
  long i_56 = 0;
  long I_57 = 0;
  long I_58 = 0;
  long I_59 = 0;
  long I_60 = 0;
  long i_61 = 0;
  long I_62 = 0;
  long I_63 = 0;
  long i3_i = 0;
  long i_64 = 0;
  long i_65 = 0;
  long I_66 = 0;
  long I_67 = 0;
  long I_68 = 0;
  long i_69 = 0;
  long i_70 = 0;
  long I_71 = 0;
  long i_72 = 0;
  long i_73 = 0;
  long i_74 = 0;
  long i_75 = 0;
  long i_76 = 0;
  long i_77 = 0;
  float f_78 = 0;
  long I_79 = 0;
  float f_80 = 0;
  float f_81 = 0;
  long i_82 = 0;
  long i_83 = 0;
  long I_84 = 0;
  long i7_wheelMove = 0;
  float f_85 = 0;
  long i_86 = 0;
  long i_87 = 0;
  long i_88 = 0;
  long i_89 = 0;
  long i_90 = 0;
  long i_91 = 0;
  long i_92 = 0;
  long i_93 = 0;
  long i_94 = 0;
  long i_95 = 0;
  float f_96 = 0;
  long I_97 = 0;
  float f_98 = 0;
  long i_99 = 0;
  float f_100 = 0;
  long I_101 = 0;
  float f_102 = 0;
  long i_103 = 0;
  long I_104 = 0;
  long I_105 = 0;
  long i_106 = 0;
  long i_107 = 0;
  long i_108 = 0;
  long I_109 = 0;
  long I_110 = 0;
  long i_111 = 0;
  long i8_i = 0;
  long i_112 = 0;
  long i_113 = 0;
  long i_114 = 0;
  long i_115 = 0;
  long i_116 = 0;
  long I_117 = 0;
  long i_118 = 0;
  long I_119 = 0;
  long I_120 = 0;
  long i_121 = 0;
  long I_122 = 0;
  long I_123 = 0;
  long I_124 = 0;
  long i_125 = 0;
  long I_126 = 0;
  long i_127 = 0;
  long I_128 = 0;
  long I_129 = 0;
  long I_130 = 0;
  long i_131 = 0;
  long I_132 = 0;
  long I_133 = 0;
  long i_134 = 0;
  long I_135 = 0;
  long i_136 = 0;
  long i_137 = 0;
  long I_138 = 0;
  long i_139 = 0;
  long I_140 = 0;
  long I_141 = 0;
  long i_142 = 0;
  long I_143 = 0;
  long I_144 = 0;
  long I_145 = 0;
  long i_146 = 0;
  long I_147 = 0;
  long i_148 = 0;
  long I_149 = 0;
  long I_150 = 0;
  long I_151 = 0;
  long i_152 = 0;
  long I_153 = 0;
  long I_154 = 0;
  long i_155 = 0;
  long I_156 = 0;
  long i_157 = 0;
  long i_158 = 0;
  long I_159 = 0;
  long i_160 = 0;
  long I_161 = 0;
  long I_162 = 0;
  long i_163 = 0;
  long I_164 = 0;
  long I_165 = 0;
  long I_166 = 0;
  long i_167 = 0;
  long I_168 = 0;
  long i_169 = 0;
  long I_170 = 0;
  long I_171 = 0;
  long I_172 = 0;
  long i_173 = 0;
  long I_174 = 0;
  long I_175 = 0;
  long i_176 = 0;
  long I_177 = 0;
  long i_178 = 0;
  long I_179 = 0;
  long I_180 = 0;
  long I_181 = 0;
  long i_182 = 0;
  long I_183 = 0;
  long I_184 = 0;
  long i_185 = 0;
  long I_186 = 0;
  long i_187 = 0;
  long i_188 = 0;
  long i_189 = 0;
  float f_190 = 0;
  long I_191 = 0;
  float f_192 = 0;
  float f_193 = 0;
  long i_194 = 0;
  long i_195 = 0;
  long i_196 = 0;
  long I_197 = 0;
  float f_198 = 0;
  long i_199 = 0;
  float f_200 = 0;
  long I_201 = 0;
  float f_202 = 0;
  long i_203 = 0;
  float f_204 = 0;
  long I_205 = 0;
  float f_206 = 0;
  long i_207 = 0;
  float f_208 = 0;
  long I_209 = 0;
  float f_210 = 0;
  long i_211 = 0;
  float f_212 = 0;
  long I_213 = 0;
  long i_214 = 0;
  long i_215 = 0;
  float f_216 = 0;
  long I_217 = 0;
  float f_218 = 0;
  long I_219 = 0;
  long I_220 = 0;
  float f15_percentVisible = 0;
  long i_221 = 0;
  float f_222 = 0;
  long I_223 = 0;
  float f_224 = 0;
  long I_225 = 0;
  float f_226 = 0;
  float f15_sliderSize = 0;
  float f_227 = 0;
  long i15_prevSliderSize = 0;
  long i_228 = 0;
  long i15_prevScrollSpeed = 0;
  long i_229 = 0;
  long i_230 = 0;
  long i_231 = 0;
  long i_232 = 0;
  long I_233 = 0;
  long i_234 = 0;
  long i_235 = 0;
  long i_236 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(128L);
  I_0 = memcpy((long) fp, (long) I0_bounds, (long) 20L);
  I_1 = m2_guiState;
  i0_state = mir_read_int(I_1);
  if ((long) U0_focus != (long) 0L) { mir_label = 1583; break; }
case 1584:
  i_3 = -1L;
  mir_label = 1585; break;
case 1583:
  i_3 = mir_read_int(U0_focus);
case 1585:
  i0_itemFocused = i_3;
  i0_itemSelected = i0_active;
  i0_useScrollBar = 0L;
  i_4 = GuiGetStyle((int) 12L, (int) 16L);
  i_5 = GuiGetStyle((int) 12L, (int) 17L);
  i_6 = (int) i_4 + (int) i_5;
  i_7 = (int) i_6 * (int) i0_count;
  I_9 = (long) (int) i_7;
  f_8 = (float) I_9;
  if (f_8 > mir_read_float(12L + fp)) { mir_label = 1586; break; }
  mir_label = 1587; break;
case 1586:
  i0_useScrollBar = 1L;
  mir_label = 1588; break;
case 1587:
case 1588:
  f_11 = (float) 0L;
  mir_write_float(20L + fp, f_11);
  I_13 = (long) fp + (long) 24L;
  I_12 = memset((long) I_13, (int) 0L, (long) 16L);
  i_14 = GuiGetStyle((int) 12L, (int) 17L);
  I_16 = (long) (int) i_14;
  f_15 = (float) I_16;
  f_17 = mir_read_float(fp) + f_15;
  mir_write_float(20L + fp, f_17);
  i_18 = GuiGetStyle((int) 12L, (int) 17L);
  I_20 = (long) (int) i_18;
  f_19 = (float) I_20;
  f_21 = mir_read_float(4L + fp) + f_19;
  i_22 = GuiGetStyle((int) 0L, (int) 12L);
  I_24 = (long) (int) i_22;
  f_23 = (float) I_24;
  f_25 = f_21 + f_23;
  mir_write_float(24L + fp, f_25);
  i_26 = GuiGetStyle((int) 12L, (int) 17L);
  i_27 = (int) 2L * (int) i_26;
  I_29 = (long) (int) i_27;
  f_28 = (float) I_29;
  f_30 = mir_read_float(8L + fp) - f_28;
  i_31 = GuiGetStyle((int) 0L, (int) 12L);
  I_33 = (long) (int) i_31;
  f_32 = (float) I_33;
  f_34 = f_30 - f_32;
  mir_write_float(28L + fp, f_34);
  i_35 = GuiGetStyle((int) 12L, (int) 16L);
  I_37 = (long) (int) i_35;
  f_36 = (float) I_37;
  mir_write_float(32L + fp, f_36);
  I_38 = (long) (int) i0_useScrollBar;
  if (((long) I_38 == 0)) { mir_label = 1589; break; }
case 1590:
  i_39 = GuiGetStyle((int) 12L, (int) 18L);
  I_41 = (long) (int) i_39;
  f_40 = (float) I_41;
  f_42 = mir_read_float(28L + fp);
  f_42 = f_42 - f_40;
  mir_write_float(28L + fp, f_42);
  mir_label = 1591; break;
case 1589:
case 1591:
  i_44 = (long) mir_read_float(12L + fp);
  i_45 = GuiGetStyle((int) 12L, (int) 16L);
  i_46 = GuiGetStyle((int) 12L, (int) 17L);
  i_47 = (int) i_45 + (int) i_46;
  i_48 = (int) i_44 / (int) i_47;
  i0_visibleItems = i_48;
  if ((int) i0_visibleItems <= (int) i0_count) { mir_label = 1592; break; }
case 1593:
  i0_visibleItems = i0_count;
  mir_label = 1594; break;
case 1592:
case 1594:
  if ((long) U0_scrollIndex != (long) 0L) { mir_label = 1595; break; }
case 1596:
  i_51 = 0L;
  mir_label = 1597; break;
case 1595:
  i_51 = mir_read_int(U0_scrollIndex);
case 1597:
  i0_startIndex = i_51;
  if ((int) i0_startIndex < (int) 0L) { mir_label = 1598; break; }
case 1599:
  i_53 = (int) i0_count - (int) i0_visibleItems;
  if ((int) i0_startIndex <= (int) i_53) { mir_label = 1600; break; }
case 1598:
  i0_startIndex = 0L;
  mir_label = 1601; break;
case 1600:
case 1601:
  i_55 = (int) i0_startIndex + (int) i0_visibleItems;
  i0_endIndex = i_55;
  if ((int) i0_state == (int) 3L) { mir_label = 1602; break; }
case 1603:
  I_57 = m2_guiLocked;
  if (((long) mir_read_int(I_57) != 0)) { mir_label = 1602; break; }
case 1604:
  I_58 = (long) fp + (long) 64L;
  GetMousePosition((long) I_58);
  I_60 = (long) fp + (long) 40L;
  I_59 = memcpy((long) I_60, (long) I_58, (long) 24L);
  I_62 = (long) fp + (long) 40L;
  i_61 = m2_CheckCollisionPointRec((long) I_62, (long) fp);
  I_63 = (long) (int) i_61;
  if (((long) I_63 == 0)) { mir_label = 1605; break; }
case 1606:
  i0_state = 1L;
  i3_i = 0L;
  if ((int) i3_i >= (int) i0_visibleItems) { mir_label = 1607; break; }
case 1608:
  I_66 = (long) fp + (long) 40L;
  I_67 = (long) fp + (long) 20L;
  i_65 = m2_CheckCollisionPointRec((long) I_66, (long) I_67);
  I_68 = (long) (int) i_65;
  if (((long) I_68 == 0)) { mir_label = 1609; break; }
case 1610:
  i_69 = (int) i0_startIndex + (int) i3_i;
  i0_itemFocused = i_69;
  i_70 = IsMouseButtonPressed((int) 0L);
  I_71 = (long) (int) i_70;
  if (((long) I_71 == 0)) { mir_label = 1611; break; }
case 1612:
  i_72 = (int) i0_startIndex + (int) i3_i;
  if ((int) i0_itemSelected != (int) i_72) { mir_label = 1613; break; }
case 1614:
  i0_itemSelected = -1L;
  mir_label = 1615; break;
case 1613:
  i_74 = (int) i0_startIndex + (int) i3_i;
  i0_itemSelected = i_74;
case 1615:
  mir_label = 1616; break;
case 1611:
case 1616:
  mir_label = 1607; break;
  // Dead code: mir_label = 1617; break;
case 1609:
case 1617:
  i_75 = GuiGetStyle((int) 12L, (int) 16L);
  i_76 = GuiGetStyle((int) 12L, (int) 17L);
  i_77 = (int) i_75 + (int) i_76;
  I_79 = (long) (int) i_77;
  f_78 = (float) I_79;
  f_80 = mir_read_float(24L + fp);
  f_80 = f_80 + f_78;
  mir_write_float(24L + fp, f_80);
case 1618:
  i_82 = i3_i;
  i_82 = (int) i_82 + (int) 1L;
  i3_i = i_82;
  if ((int) i3_i < (int) i0_visibleItems) { mir_label = 1608; break; }
case 1607:
  I_84 = (long) (int) i0_useScrollBar;
  if (((long) I_84 == 0)) { mir_label = 1619; break; }
case 1620:
  f_85 = GetMouseWheelMove();
  i_86 = (long) f_85;
  i7_wheelMove = i_86;
  i_87 = i0_startIndex;
  i_87 = (int) i_87 - (int) i7_wheelMove;
  i0_startIndex = i_87;
  if ((int) i0_startIndex >= (int) 0L) { mir_label = 1621; break; }
case 1622:
  i0_startIndex = 0L;
  mir_label = 1623; break;
case 1621:
  i_90 = (int) i0_count - (int) i0_visibleItems;
  if ((int) i0_startIndex <= (int) i_90) { mir_label = 1624; break; }
case 1625:
  i_92 = (int) i0_count - (int) i0_visibleItems;
  i0_startIndex = i_92;
  mir_label = 1626; break;
case 1624:
case 1626:
case 1623:
  i_93 = (int) i0_startIndex + (int) i0_visibleItems;
  i0_endIndex = i_93;
  if ((int) i0_endIndex <= (int) i0_count) { mir_label = 1627; break; }
case 1628:
  i0_endIndex = i0_count;
  mir_label = 1629; break;
case 1627:
case 1629:
  mir_label = 1630; break;
case 1619:
case 1630:
  mir_label = 1631; break;
case 1605:
  i0_itemFocused = -1L;
case 1631:
  i_95 = GuiGetStyle((int) 12L, (int) 17L);
  I_97 = (long) (int) i_95;
  f_96 = (float) I_97;
  f_98 = mir_read_float(4L + fp) + f_96;
  i_99 = GuiGetStyle((int) 0L, (int) 12L);
  I_101 = (long) (int) i_99;
  f_100 = (float) I_101;
  f_102 = f_98 + f_100;
  mir_write_float(24L + fp, f_102);
  mir_label = 1632; break;
case 1602:
case 1632:
  i_103 = GuiGetStyle((int) 0L, (int) 12L);
  I_104 = (long) fp + (long) 64L;
  I_105 = (long) fp + (long) 80L;
  i_107 = (int) i0_state * (int) 3L;
  i_108 = (int) 0L + (int) i_107;
  i_106 = GuiGetStyle((int) 12L, (int) i_108);
  m2_GetColor((long) I_105, (int) i_106);
  I_109 = m2_guiAlpha;
  m2_Fade((long) I_104, (long) I_105, (float) mir_read_float(I_109));
  I_110 = (long) fp + (long) 80L;
  i_111 = GuiGetStyle((int) 0L, (int) 19L);
  m2_GetColor((long) I_110, (int) i_111);
  m2_GuiDrawRectangle((long) fp, (int) i_103, (long) I_104, (long) I_110);
  i8_i = 0L;
  if ((int) i8_i >= (int) i0_visibleItems) { mir_label = 1633; break; }
case 1634:
  if ((long) U0_text == (long) 0L) { mir_label = 1633; break; }
case 1635:
  if ((int) i0_state != (int) 3L) { mir_label = 1636; break; }
case 1637:
  i_115 = (int) i0_startIndex + (int) i8_i;
  if ((int) i_115 != (int) i0_itemSelected) { mir_label = 1638; break; }
case 1639:
  I_117 = (long) fp + (long) 20L;
  i_118 = GuiGetStyle((int) 12L, (int) 12L);
  I_119 = (long) fp + (long) 64L;
  I_120 = (long) fp + (long) 80L;
  i_121 = GuiGetStyle((int) 12L, (int) 9L);
  m2_GetColor((long) I_120, (int) i_121);
  I_122 = m2_guiAlpha;
  m2_Fade((long) I_119, (long) I_120, (float) mir_read_float(I_122));
  I_123 = (long) fp + (long) 80L;
  I_124 = (long) fp + (long) 96L;
  i_125 = GuiGetStyle((int) 12L, (int) 10L);
  m2_GetColor((long) I_124, (int) i_125);
  I_126 = m2_guiAlpha;
  m2_Fade((long) I_123, (long) I_124, (float) mir_read_float(I_126));
  m2_GuiDrawRectangle((long) I_117, (int) i_118, (long) I_119, (long) I_123);
  mir_label = 1640; break;
case 1638:
case 1640:
  i_127 = (int) i0_startIndex + (int) i8_i;
  I_128 = (long) (int) i_127;
  I_129 = (long) fp + (long) 64L;
  I_130 = (long) fp + (long) 20L;
  m2_GetTextBounds((long) I_129, (int) 0L, (long) I_130);
  i_131 = GuiGetStyle((int) 12L, (int) 14L);
  I_132 = (long) fp + (long) 96L;
  I_133 = (long) fp + (long) 112L;
  i_134 = GuiGetStyle((int) 12L, (int) 11L);
  m2_GetColor((long) I_133, (int) i_134);
  I_135 = m2_guiAlpha;
  m2_Fade((long) I_132, (long) I_133, (float) mir_read_float(I_135));
  m2_GuiDrawText((long) mir_read_ulong(U0_text + I_128 * 8), (long) I_129, (int) i_131, (long) I_132);
  mir_label = 1641; break;
case 1636:
  i_136 = (int) i0_startIndex + (int) i8_i;
  if ((int) i_136 != (int) i0_itemSelected) { mir_label = 1642; break; }
case 1643:
  I_138 = (long) fp + (long) 20L;
  i_139 = GuiGetStyle((int) 12L, (int) 12L);
  I_140 = (long) fp + (long) 64L;
  I_141 = (long) fp + (long) 80L;
  i_142 = GuiGetStyle((int) 12L, (int) 6L);
  m2_GetColor((long) I_141, (int) i_142);
  I_143 = m2_guiAlpha;
  m2_Fade((long) I_140, (long) I_141, (float) mir_read_float(I_143));
  I_144 = (long) fp + (long) 80L;
  I_145 = (long) fp + (long) 96L;
  i_146 = GuiGetStyle((int) 12L, (int) 7L);
  m2_GetColor((long) I_145, (int) i_146);
  I_147 = m2_guiAlpha;
  m2_Fade((long) I_144, (long) I_145, (float) mir_read_float(I_147));
  m2_GuiDrawRectangle((long) I_138, (int) i_139, (long) I_140, (long) I_144);
  i_148 = (int) i0_startIndex + (int) i8_i;
  I_149 = (long) (int) i_148;
  I_150 = (long) fp + (long) 64L;
  I_151 = (long) fp + (long) 20L;
  m2_GetTextBounds((long) I_150, (int) 0L, (long) I_151);
  i_152 = GuiGetStyle((int) 12L, (int) 14L);
  I_153 = (long) fp + (long) 96L;
  I_154 = (long) fp + (long) 112L;
  i_155 = GuiGetStyle((int) 12L, (int) 8L);
  m2_GetColor((long) I_154, (int) i_155);
  I_156 = m2_guiAlpha;
  m2_Fade((long) I_153, (long) I_154, (float) mir_read_float(I_156));
  m2_GuiDrawText((long) mir_read_ulong(U0_text + I_149 * 8), (long) I_150, (int) i_152, (long) I_153);
  mir_label = 1644; break;
case 1642:
  i_157 = (int) i0_startIndex + (int) i8_i;
  if ((int) i_157 != (int) i0_itemFocused) { mir_label = 1645; break; }
case 1646:
  I_159 = (long) fp + (long) 20L;
  i_160 = GuiGetStyle((int) 12L, (int) 12L);
  I_161 = (long) fp + (long) 64L;
  I_162 = (long) fp + (long) 80L;
  i_163 = GuiGetStyle((int) 12L, (int) 3L);
  m2_GetColor((long) I_162, (int) i_163);
  I_164 = m2_guiAlpha;
  m2_Fade((long) I_161, (long) I_162, (float) mir_read_float(I_164));
  I_165 = (long) fp + (long) 80L;
  I_166 = (long) fp + (long) 96L;
  i_167 = GuiGetStyle((int) 12L, (int) 4L);
  m2_GetColor((long) I_166, (int) i_167);
  I_168 = m2_guiAlpha;
  m2_Fade((long) I_165, (long) I_166, (float) mir_read_float(I_168));
  m2_GuiDrawRectangle((long) I_159, (int) i_160, (long) I_161, (long) I_165);
  i_169 = (int) i0_startIndex + (int) i8_i;
  I_170 = (long) (int) i_169;
  I_171 = (long) fp + (long) 64L;
  I_172 = (long) fp + (long) 20L;
  m2_GetTextBounds((long) I_171, (int) 0L, (long) I_172);
  i_173 = GuiGetStyle((int) 12L, (int) 14L);
  I_174 = (long) fp + (long) 96L;
  I_175 = (long) fp + (long) 112L;
  i_176 = GuiGetStyle((int) 12L, (int) 5L);
  m2_GetColor((long) I_175, (int) i_176);
  I_177 = m2_guiAlpha;
  m2_Fade((long) I_174, (long) I_175, (float) mir_read_float(I_177));
  m2_GuiDrawText((long) mir_read_ulong(U0_text + I_170 * 8), (long) I_171, (int) i_173, (long) I_174);
  mir_label = 1647; break;
case 1645:
  i_178 = (int) i0_startIndex + (int) i8_i;
  I_179 = (long) (int) i_178;
  I_180 = (long) fp + (long) 64L;
  I_181 = (long) fp + (long) 20L;
  m2_GetTextBounds((long) I_180, (int) 0L, (long) I_181);
  i_182 = GuiGetStyle((int) 12L, (int) 14L);
  I_183 = (long) fp + (long) 96L;
  I_184 = (long) fp + (long) 112L;
  i_185 = GuiGetStyle((int) 12L, (int) 2L);
  m2_GetColor((long) I_184, (int) i_185);
  I_186 = m2_guiAlpha;
  m2_Fade((long) I_183, (long) I_184, (float) mir_read_float(I_186));
  m2_GuiDrawText((long) mir_read_ulong(U0_text + I_179 * 8), (long) I_180, (int) i_182, (long) I_183);
case 1647:
case 1644:
case 1641:
  i_187 = GuiGetStyle((int) 12L, (int) 16L);
  i_188 = GuiGetStyle((int) 12L, (int) 17L);
  i_189 = (int) i_187 + (int) i_188;
  I_191 = (long) (int) i_189;
  f_190 = (float) I_191;
  f_192 = mir_read_float(24L + fp);
  f_192 = f_192 + f_190;
  mir_write_float(24L + fp, f_192);
case 1648:
  i_194 = i8_i;
  i_194 = (int) i_194 + (int) 1L;
  i8_i = i_194;
  if ((int) i8_i >= (int) i0_visibleItems) { mir_label = 1633; break; }
case 1649:
  if ((long) U0_text != (long) 0L) { mir_label = 1635; break; }
case 1633:
  I_197 = (long) (int) i0_useScrollBar;
  if (((long) I_197 == 0)) { mir_label = 1650; break; }
case 1651:
  f_198 = mir_read_float(fp) + mir_read_float(8L + fp);
  i_199 = GuiGetStyle((int) 12L, (int) 12L);
  I_201 = (long) (int) i_199;
  f_200 = (float) I_201;
  f_202 = f_198 - f_200;
  i_203 = GuiGetStyle((int) 12L, (int) 18L);
  I_205 = (long) (int) i_203;
  f_204 = (float) I_205;
  f_206 = f_202 - f_204;
  mir_write_float(40L + fp, f_206);
  i_207 = GuiGetStyle((int) 12L, (int) 12L);
  I_209 = (long) (int) i_207;
  f_208 = (float) I_209;
  f_210 = mir_read_float(4L + fp) + f_208;
  mir_write_float(44L + fp, f_210);
  i_211 = GuiGetStyle((int) 12L, (int) 18L);
  I_213 = (long) (int) i_211;
  f_212 = (float) I_213;
  mir_write_float(48L + fp, f_212);
  i_214 = GuiGetStyle((int) 0L, (int) 12L);
  i_215 = (int) 2L * (int) i_214;
  I_217 = (long) (int) i_215;
  f_216 = (float) I_217;
  f_218 = mir_read_float(12L + fp) - f_216;
  mir_write_float(52L + fp, f_218);
  I_220 = (long) fp + (long) 56L;
  I_219 = memset((long) I_220, (int) 0L, (long) 4L);
  i_221 = (int) i0_endIndex - (int) i0_startIndex;
  I_223 = (long) (int) i_221;
  f_222 = (float) I_223;
  I_225 = (long) (int) i0_count;
  f_224 = (float) I_225;
  f_226 = f_222 / f_224;
  f15_percentVisible = f_226;
  f_227 = mir_read_float(12L + fp) * f15_percentVisible;
  f15_sliderSize = f_227;
  i_228 = GuiGetStyle((int) 14L, (int) 19L);
  i15_prevSliderSize = i_228;
  i_229 = GuiGetStyle((int) 14L, (int) 21L);
  i15_prevScrollSpeed = i_229;
  i_230 = (long) f15_sliderSize;
  GuiSetStyle((int) 14L, (int) 19L, (int) i_230);
  i_231 = (int) i0_count - (int) i0_visibleItems;
  GuiSetStyle((int) 14L, (int) 21L, (int) i_231);
  I_233 = (long) fp + (long) 40L;
  i_234 = (int) i0_count - (int) i0_visibleItems;
  i_232 = m2_GuiScrollBar((long) I_233, (int) i0_startIndex, (int) 0L, (int) i_234);
  i0_startIndex = i_232;
  GuiSetStyle((int) 14L, (int) 21L, (int) i15_prevScrollSpeed);
  GuiSetStyle((int) 14L, (int) 19L, (int) i15_prevSliderSize);
  mir_label = 1652; break;
case 1650:
case 1652:
  if ((long) U0_focus == (long) 0L) { mir_label = 1653; break; }
case 1654:
  mir_write_int(U0_focus, i0_itemFocused);
  mir_label = 1655; break;
case 1653:
case 1655:
  if ((long) U0_scrollIndex == (long) 0L) { mir_label = 1656; break; }
case 1657:
  mir_write_int(U0_scrollIndex, i0_startIndex);
  mir_label = 1658; break;
case 1656:
case 1658:
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_itemSelected;
} // End of switch
} // End of while
} // End of function GuiListViewEx

public void GuiColorPanel (long _Ret_Addr, long _I0_bounds, long _U0_text, long _I0_color) {
  long Ret_Addr = _Ret_Addr;
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long I0_color = _I0_color;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long I_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long i0_state = 0;
  long I_11 = 0;
  float f_12 = 0;
  long I_13 = 0;
  long I_14 = 0;
  float f_15 = 0;
  float f_16 = 0;
  float f_17 = 0;
  float f_18 = 0;
  float f_19 = 0;
  float f_20 = 0;
  long I_21 = 0;
  long I_22 = 0;
  long I_23 = 0;
  long I_24 = 0;
  long I_25 = 0;
  long I_26 = 0;
  float f_27 = 0;
  float f_28 = 0;
  float f_29 = 0;
  float f_30 = 0;
  float f_31 = 0;
  float f_32 = 0;
  float f_33 = 0;
  float f0_hue = 0;
  long i_34 = 0;
  float f_35 = 0;
  long I_36 = 0;
  long I_37 = 0;
  long I_38 = 0;
  long I_39 = 0;
  long I_40 = 0;
  long I_41 = 0;
  float f_42 = 0;
  long I_43 = 0;
  long I_44 = 0;
  long I_45 = 0;
  float f_46 = 0;
  long I_47 = 0;
  long I_48 = 0;
  long I_49 = 0;
  float f_50 = 0;
  long I_51 = 0;
  long I_52 = 0;
  long I_53 = 0;
  long I_54 = 0;
  long i_55 = 0;
  long I_56 = 0;
  long I_57 = 0;
  long I_58 = 0;
  long I_59 = 0;
  long i_60 = 0;
  long I_61 = 0;
  long I_62 = 0;
  long I_63 = 0;
  long i_64 = 0;
  long I_65 = 0;
  long I_66 = 0;
  long I_67 = 0;
  long I_68 = 0;
  float f_69 = 0;
  float f_70 = 0;
  long I_71 = 0;
  long I_72 = 0;
  float f_73 = 0;
  float f_74 = 0;
  float f_75 = 0;
  float f_76 = 0;
  float f_77 = 0;
  float f_78 = 0;
  float f_79 = 0;
  long I_80 = 0;
  long I_81 = 0;
  long I_82 = 0;
  long I_83 = 0;
  float f_84 = 0;
  long I_85 = 0;
  long I_86 = 0;
  long I_87 = 0;
  float f_88 = 0;
  long I_89 = 0;
  long I_90 = 0;
  long I_91 = 0;
  float f_92 = 0;
  long I_93 = 0;
  long I_94 = 0;
  long I_95 = 0;
  float f_96 = 0;
  float f_97 = 0;
  float f_98 = 0;
  long I_99 = 0;
  long I_100 = 0;
  long I_101 = 0;
  long I_102 = 0;
  long i_103 = 0;
  long I_104 = 0;
  long I_105 = 0;
  long I_106 = 0;
  long I_107 = 0;
  long I_108 = 0;
  long I_109 = 0;
  long I_110 = 0;
  long I_111 = 0;
  long I_112 = 0;
  long I_113 = 0;
  long I_114 = 0;
  long I_115 = 0;
  long I_116 = 0;
  long I_117 = 0;
  long I_118 = 0;
  long I_119 = 0;
  float f_120 = 0;
  long I_121 = 0;
  long I_122 = 0;
  long I_123 = 0;
  long I_124 = 0;
  long I_125 = 0;
  long I_126 = 0;
  long I_127 = 0;
  long I_128 = 0;
  float f_129 = 0;
  long i_130 = 0;
  long i_131 = 0;
  float f_132 = 0;
  long I_133 = 0;
  float f_134 = 0;
  long i_135 = 0;
  long i_136 = 0;
  float f_137 = 0;
  long I_138 = 0;
  float f_139 = 0;
  long i_140 = 0;
  float f_141 = 0;
  long I_142 = 0;
  long i_143 = 0;
  float f_144 = 0;
  long I_145 = 0;
  long I_146 = 0;
  long I_147 = 0;
  long I_148 = 0;
  long I_149 = 0;
  long I_150 = 0;
  long I_151 = 0;
  long I_152 = 0;
  long I_153 = 0;
  long I_154 = 0;
  long I_155 = 0;
  long I_156 = 0;
  long I_157 = 0;
  long I_158 = 0;
  long I_159 = 0;
  long I_160 = 0;
  long i_161 = 0;
  long I_162 = 0;
  long I_163 = 0;
  long I_164 = 0;
  long I_165 = 0;
  long I_166 = 0;
  long I_167 = 0;
  long I_168 = 0;
  long I_169 = 0;
  long I_170 = 0;
  long I_171 = 0;
  long I_172 = 0;
  long I_173 = 0;
  long i_174 = 0;
  long I_175 = 0;
  long I_176 = 0;
  long i_177 = 0;
  long I_178 = 0;
  long I_179 = 0;
  long i_180 = 0;
  long i_181 = 0;
  long i_182 = 0;
  long I_183 = 0;
  long I_184 = 0;
  long I_185 = 0;
  long I_186 = 0;
  long I_187 = 0;
  long I_188 = 0;
  long I_189 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(336L);
  I_0 = (long) fp + (long) 20L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = 4L;
case 1659:
  I_2 = (long) I_2 - (long) 1L;
  mir_write_byte(fp + I_2, mir_read_byte(I0_color + I_2));
  if ((long) I_2 > (long) 0L) { mir_label = 1659; break; }
  I_3 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(4L + fp, I_3);
  I_4 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(5L + fp, I_4);
  I_5 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(6L + fp, I_5);
  I_6 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(7L + fp, I_6);
  I_7 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(8L + fp, I_7);
  I_8 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(9L + fp, I_8);
  I_9 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(10L + fp, I_9);
  I_10 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(11L + fp, I_10);
  I_11 = m2_guiState;
  i0_state = mir_read_int(I_11);
  f_12 = (float) 0L;
  mir_write_float(40L + fp, f_12);
  I_14 = (long) fp + (long) 44L;
  I_13 = memset((long) I_14, (int) 0L, (long) 20L);
  f_15 = (float) mir_read_ubyte(fp);
  f_16 = f_15 / 255f;
  mir_write_float(64L + fp, f_16);
  f_17 = (float) mir_read_ubyte(1L + fp);
  f_18 = f_17 / 255f;
  mir_write_float(68L + fp, f_18);
  f_19 = (float) mir_read_ubyte(2L + fp);
  f_20 = f_19 / 255f;
  mir_write_float(72L + fp, f_20);
  I_22 = (long) fp + (long) 76L;
  I_21 = memset((long) I_22, (int) 0L, (long) 12L);
  I_23 = (long) fp + (long) 240L;
  I_24 = (long) fp + (long) 64L;
  m2_ConvertRGBtoHSV((long) I_23, (long) I_24);
  I_26 = (long) fp + (long) 88L;
  I_25 = memcpy((long) I_26, (long) I_23, (long) 24L);
  f_27 = mir_read_float(92L + fp);
  f_28 = f_27 * mir_read_float(28L + fp);
  f_29 = mir_read_float(20L + fp) + f_28;
  mir_write_float(40L + fp, f_29);
  f_30 = mir_read_float(96L + fp);
  f_31 = 1f - f_30;
  f_32 = f_31 * mir_read_float(32L + fp);
  f_33 = mir_read_float(24L + fp) + f_32;
  mir_write_float(44L + fp, f_33);
  f0_hue = -1f;
  if (f0_hue >= 0f) { mir_label = 1660; break; }
  mir_label = 1661; break;
case 1660:
  f_35 = f0_hue;
  mir_label = 1662; break;
case 1661:
  f_35 = mir_read_float(88L + fp);
case 1662:
  mir_write_float(112L + fp, f_35);
  mir_write_float(116L + fp, 1f);
  mir_write_float(120L + fp, 1f);
  I_37 = (long) fp + (long) 124L;
  I_36 = memset((long) I_37, (int) 0L, (long) 12L);
  I_38 = (long) fp + (long) 240L;
  I_39 = (long) fp + (long) 112L;
  m2_ConvertHSVtoRGB((long) I_38, (long) I_39);
  I_41 = (long) fp + (long) 136L;
  I_40 = memcpy((long) I_41, (long) I_38, (long) 24L);
  f_42 = 255f * mir_read_float(136L + fp);
  I_44 = (long) f_42;
  I_43 = (((long) (int) I_44) & 0xFFL);
  I_45 = (((long) (int) I_43) & 0xFFL);
  mir_write_ubyte(12L + fp, I_45);
  f_46 = 255f * mir_read_float(140L + fp);
  I_48 = (long) f_46;
  I_47 = (((long) (int) I_48) & 0xFFL);
  I_49 = (((long) (int) I_47) & 0xFFL);
  mir_write_ubyte(13L + fp, I_49);
  f_50 = 255f * mir_read_float(144L + fp);
  I_52 = (long) f_50;
  I_51 = (((long) (int) I_52) & 0xFFL);
  I_53 = (((long) (int) I_51) & 0xFFL);
  mir_write_ubyte(14L + fp, I_53);
  I_54 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(15L + fp, I_54);
  if ((int) i0_state == (int) 3L) { mir_label = 1663; break; }
case 1664:
  I_56 = m2_guiLocked;
  if (((long) mir_read_int(I_56) != 0)) { mir_label = 1663; break; }
case 1665:
  I_57 = (long) fp + (long) 240L;
  GetMousePosition((long) I_57);
  I_59 = (long) fp + (long) 160L;
  I_58 = memcpy((long) I_59, (long) I_57, (long) 24L);
  I_61 = (long) fp + (long) 160L;
  I_62 = (long) fp + (long) 20L;
  i_60 = m2_CheckCollisionPointRec((long) I_61, (long) I_62);
  I_63 = (long) (int) i_60;
  if (((long) I_63 == 0)) { mir_label = 1666; break; }
case 1667:
  i_64 = IsMouseButtonDown((int) 0L);
  I_65 = (long) (int) i_64;
  if (((long) I_65 == 0)) { mir_label = 1668; break; }
case 1669:
  i0_state = 2L;
  I_66 = (long) fp + (long) 40L;
  I_68 = (long) fp + (long) 160L;
  I_67 = memcpy((long) I_66, (long) I_68, (long) 24L);
  f_69 = mir_read_float(40L + fp) - mir_read_float(20L + fp);
  mir_write_float(192L + fp, f_69);
  f_70 = mir_read_float(44L + fp) - mir_read_float(24L + fp);
  mir_write_float(196L + fp, f_70);
  I_72 = (long) fp + (long) 200L;
  I_71 = memset((long) I_72, (int) 0L, (long) 16L);
  f_73 = mir_read_float(28L + fp);
  f_74 = mir_read_float(192L + fp);
  f_74 = f_74 / f_73;
  mir_write_float(192L + fp, f_74);
  f_76 = mir_read_float(32L + fp);
  f_77 = mir_read_float(196L + fp);
  f_77 = f_77 / f_76;
  mir_write_float(196L + fp, f_77);
  mir_write_float(92L + fp, mir_read_float(192L + fp));
  f_79 = 1f - mir_read_float(196L + fp);
  mir_write_float(96L + fp, f_79);
  I_80 = (long) fp + (long) 240L;
  I_81 = (long) fp + (long) 88L;
  m2_ConvertHSVtoRGB((long) I_80, (long) I_81);
  I_83 = (long) fp + (long) 216L;
  I_82 = memcpy((long) I_83, (long) I_80, (long) 24L);
  f_84 = 255f * mir_read_float(216L + fp);
  I_86 = (long) f_84;
  I_85 = (((long) (int) I_86) & 0xFFL);
  I_87 = (((long) (int) I_85) & 0xFFL);
  mir_write_ubyte(184L + fp, I_87);
  f_88 = 255f * mir_read_float(220L + fp);
  I_90 = (long) f_88;
  I_89 = (((long) (int) I_90) & 0xFFL);
  I_91 = (((long) (int) I_89) & 0xFFL);
  mir_write_ubyte(185L + fp, I_91);
  f_92 = 255f * mir_read_float(224L + fp);
  I_94 = (long) f_92;
  I_93 = (((long) (int) I_94) & 0xFFL);
  I_95 = (((long) (int) I_93) & 0xFFL);
  mir_write_ubyte(186L + fp, I_95);
  f_96 = (float) mir_read_ubyte(3L + fp);
  f_97 = 255f * f_96;
  f_98 = f_97 / 255f;
  I_100 = (long) f_98;
  I_99 = (((long) (int) I_100) & 0xFFL);
  I_101 = (((long) (int) I_99) & 0xFFL);
  mir_write_ubyte(187L + fp, I_101);
  I_102 = 4L;
case 1670:
  I_102 = (long) I_102 - (long) 1L;
  mir_write_byte(fp + I_102, mir_read_byte(184L + fp + I_102));
  if ((long) I_102 > (long) 0L) { mir_label = 1670; break; }
  mir_label = 1671; break;
case 1668:
  i0_state = 1L;
case 1671:
  mir_label = 1672; break;
case 1666:
case 1672:
  mir_label = 1673; break;
case 1663:
case 1673:
  if ((int) i0_state == (int) 3L) { mir_label = 1674; break; }
case 1675:
  I_104 = (long) fp + (long) 20L;
  I_105 = (long) fp + (long) 240L;
  I_106 = (long) fp + (long) 4L;
  I_107 = m2_guiAlpha;
  m2_Fade((long) I_105, (long) I_106, (float) mir_read_float(I_107));
  I_108 = (long) fp + (long) 256L;
  I_109 = (long) fp + (long) 4L;
  I_110 = m2_guiAlpha;
  m2_Fade((long) I_108, (long) I_109, (float) mir_read_float(I_110));
  I_111 = (long) fp + (long) 272L;
  I_112 = (long) fp + (long) 12L;
  I_113 = m2_guiAlpha;
  m2_Fade((long) I_111, (long) I_112, (float) mir_read_float(I_113));
  I_114 = (long) fp + (long) 288L;
  I_115 = (long) fp + (long) 12L;
  I_116 = m2_guiAlpha;
  m2_Fade((long) I_114, (long) I_115, (float) mir_read_float(I_116));
  DrawRectangleGradientEx((long) I_104, (long) I_105, (long) I_108, (long) I_111, (long) I_114);
  I_117 = (long) fp + (long) 20L;
  I_118 = (long) fp + (long) 240L;
  I_119 = (long) fp + (long) 8L;
  f_120 = (float) 0L;
  m2_Fade((long) I_118, (long) I_119, (float) f_120);
  I_121 = (long) fp + (long) 256L;
  I_122 = (long) fp + (long) 8L;
  I_123 = m2_guiAlpha;
  m2_Fade((long) I_121, (long) I_122, (float) mir_read_float(I_123));
  I_124 = (long) fp + (long) 272L;
  I_125 = (long) fp + (long) 8L;
  I_126 = m2_guiAlpha;
  m2_Fade((long) I_124, (long) I_125, (float) mir_read_float(I_126));
  I_127 = (long) fp + (long) 288L;
  I_128 = (long) fp + (long) 8L;
  f_129 = (float) 0L;
  m2_Fade((long) I_127, (long) I_128, (float) f_129);
  DrawRectangleGradientEx((long) I_117, (long) I_118, (long) I_121, (long) I_124, (long) I_127);
  i_130 = GuiGetStyle((int) 13L, (int) 16L);
  i_131 = (int) i_130 / (int) 2L;
  I_133 = (long) (int) i_131;
  f_132 = (float) I_133;
  f_134 = mir_read_float(40L + fp) - f_132;
  mir_write_float(164L + fp, f_134);
  i_135 = GuiGetStyle((int) 13L, (int) 16L);
  i_136 = (int) i_135 / (int) 2L;
  I_138 = (long) (int) i_136;
  f_137 = (float) I_138;
  f_139 = mir_read_float(44L + fp) - f_137;
  mir_write_float(168L + fp, f_139);
  i_140 = GuiGetStyle((int) 13L, (int) 16L);
  I_142 = (long) (int) i_140;
  f_141 = (float) I_142;
  mir_write_float(172L + fp, f_141);
  i_143 = GuiGetStyle((int) 13L, (int) 16L);
  I_145 = (long) (int) i_143;
  f_144 = (float) I_145;
  mir_write_float(176L + fp, f_144);
  I_147 = (long) fp + (long) 180L;
  I_146 = memset((long) I_147, (int) 0L, (long) 4L);
  I_148 = (long) fp + (long) 164L;
  I_149 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(160L + fp, I_149);
  I_150 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(161L + fp, I_150);
  I_151 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(162L + fp, I_151);
  I_152 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(163L + fp, I_152);
  I_153 = (long) fp + (long) 160L;
  I_154 = (long) fp + (long) 240L;
  I_155 = (long) fp + (long) 4L;
  I_156 = m2_guiAlpha;
  m2_Fade((long) I_154, (long) I_155, (float) mir_read_float(I_156));
  m2_GuiDrawRectangle((long) I_148, (int) 0L, (long) I_153, (long) I_154);
  mir_label = 1676; break;
case 1674:
  I_157 = (long) fp + (long) 20L;
  I_158 = (long) fp + (long) 240L;
  I_159 = (long) fp + (long) 256L;
  I_160 = (long) fp + (long) 272L;
  i_161 = GuiGetStyle((int) 13L, (int) 10L);
  m2_GetColor((long) I_160, (int) i_161);
  m2_Fade((long) I_159, (long) I_160, (float) 0.100000001f);
  I_162 = m2_guiAlpha;
  m2_Fade((long) I_158, (long) I_159, (float) mir_read_float(I_162));
  I_163 = (long) fp + (long) 256L;
  I_164 = (long) fp + (long) 272L;
  I_165 = (long) fp + (long) 8L;
  m2_Fade((long) I_164, (long) I_165, (float) 0.600000024f);
  I_166 = m2_guiAlpha;
  m2_Fade((long) I_163, (long) I_164, (float) mir_read_float(I_166));
  I_167 = (long) fp + (long) 272L;
  I_168 = (long) fp + (long) 288L;
  I_169 = (long) fp + (long) 8L;
  m2_Fade((long) I_168, (long) I_169, (float) 0.600000024f);
  I_170 = m2_guiAlpha;
  m2_Fade((long) I_167, (long) I_168, (float) mir_read_float(I_170));
  I_171 = (long) fp + (long) 288L;
  I_172 = (long) fp + (long) 304L;
  I_173 = (long) fp + (long) 320L;
  i_174 = GuiGetStyle((int) 13L, (int) 9L);
  m2_GetColor((long) I_173, (int) i_174);
  m2_Fade((long) I_172, (long) I_173, (float) 0.600000024f);
  I_175 = m2_guiAlpha;
  m2_Fade((long) I_171, (long) I_172, (float) mir_read_float(I_175));
  DrawRectangleGradientEx((long) I_157, (long) I_158, (long) I_163, (long) I_167, (long) I_171);
case 1676:
  I_176 = (long) fp + (long) 20L;
  i_177 = GuiGetStyle((int) 13L, (int) 12L);
  I_178 = (long) fp + (long) 240L;
  I_179 = (long) fp + (long) 256L;
  i_181 = (int) i0_state * (int) 3L;
  i_182 = (int) 0L + (int) i_181;
  i_180 = GuiGetStyle((int) 13L, (int) i_182);
  m2_GetColor((long) I_179, (int) i_180);
  I_183 = m2_guiAlpha;
  m2_Fade((long) I_178, (long) I_179, (float) mir_read_float(I_183));
  I_184 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(16L + fp, I_184);
  I_185 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(17L + fp, I_185);
  I_186 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(18L + fp, I_186);
  I_187 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(19L + fp, I_187);
  I_188 = (long) fp + (long) 16L;
  m2_GuiDrawRectangle((long) I_176, (int) i_177, (long) I_178, (long) I_188);
  I_189 = 4L;
case 1677:
  I_189 = (long) I_189 - (long) 1L;
  mir_write_byte(Ret_Addr + I_189, mir_read_byte(fp + I_189));
  if ((long) I_189 > (long) 0L) { mir_label = 1677; break; }
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiColorPanel

public float GuiColorBarAlpha (long _I0_bounds, long _U0_text, float f0_alpha) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  float f_3 = 0;
  float f_4 = 0;
  float f_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  float f_8 = 0;
  long I_9 = 0;
  float f_10 = 0;
  float f_11 = 0;
  long i_12 = 0;
  float f_13 = 0;
  long I_14 = 0;
  float f_15 = 0;
  long i_16 = 0;
  float f_17 = 0;
  long I_18 = 0;
  float f_19 = 0;
  long i_20 = 0;
  long i_21 = 0;
  float f_22 = 0;
  long I_23 = 0;
  float f_24 = 0;
  long I_25 = 0;
  long I_26 = 0;
  long i_27 = 0;
  long I_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  long I_31 = 0;
  long i_32 = 0;
  long I_33 = 0;
  long I_34 = 0;
  long I_35 = 0;
  long i_36 = 0;
  long I_37 = 0;
  long I_38 = 0;
  long I_39 = 0;
  long i_40 = 0;
  long I_41 = 0;
  float f_42 = 0;
  float f_43 = 0;
  long i_44 = 0;
  long i_45 = 0;
  long i_46 = 0;
  long i4_checksX = 0;
  long i_47 = 0;
  long i_48 = 0;
  long i4_checksY = 0;
  long i_49 = 0;
  long i_50 = 0;
  long i5_x = 0;
  long i_51 = 0;
  long i7_y = 0;
  long i_52 = 0;
  long i_53 = 0;
  float f_54 = 0;
  long I_55 = 0;
  float f_56 = 0;
  long i_57 = 0;
  float f_58 = 0;
  long I_59 = 0;
  float f_60 = 0;
  float f_61 = 0;
  float f_62 = 0;
  long I_63 = 0;
  long I_64 = 0;
  long I_65 = 0;
  long I_66 = 0;
  long I_67 = 0;
  long I_68 = 0;
  long I_69 = 0;
  long I_70 = 0;
  long i_71 = 0;
  long i_72 = 0;
  long I_73 = 0;
  long I_74 = 0;
  long I_75 = 0;
  long I_76 = 0;
  long i_77 = 0;
  long I_78 = 0;
  long I_79 = 0;
  long I_80 = 0;
  long I_81 = 0;
  long I_82 = 0;
  long i_83 = 0;
  long I_84 = 0;
  long i_85 = 0;
  long i_86 = 0;
  long i_87 = 0;
  long i_88 = 0;
  long I_89 = 0;
  long I_90 = 0;
  long I_91 = 0;
  long I_92 = 0;
  long I_93 = 0;
  long I_94 = 0;
  long I_95 = 0;
  long I_96 = 0;
  long I_97 = 0;
  long I_98 = 0;
  long I_99 = 0;
  long I_100 = 0;
  long I_101 = 0;
  long I_102 = 0;
  long I_103 = 0;
  long I_104 = 0;
  long I_105 = 0;
  long I_106 = 0;
  long I_107 = 0;
  long I_108 = 0;
  long I_109 = 0;
  long I_110 = 0;
  long I_111 = 0;
  long I_112 = 0;
  long I_113 = 0;
  long I_114 = 0;
  long I_115 = 0;
  long I_116 = 0;
  long i_117 = 0;
  long I_118 = 0;
  long I_119 = 0;
  long i_120 = 0;
  long I_121 = 0;
  long I_122 = 0;
  long i_123 = 0;
  long I_124 = 0;
  long I_125 = 0;
  long I_126 = 0;
  long i_127 = 0;
  long I_128 = 0;
  long I_129 = 0;
  long i_130 = 0;
  long I_131 = 0;
  long I_132 = 0;
  long i_133 = 0;
  long i_134 = 0;
  long i_135 = 0;
  long I_136 = 0;
  long I_137 = 0;
  long I_138 = 0;
  long I_139 = 0;
  long I_140 = 0;
  long I_141 = 0;
  long I_142 = 0;
  long I_143 = 0;
  long I_144 = 0;
  long I_145 = 0;
  long I_146 = 0;
  long I_147 = 0;
  long I_148 = 0;
  long i_149 = 0;
  long i_150 = 0;
  long i_151 = 0;
  long I_152 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(176L);
  I_0 = (long) fp + (long) 8L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  f_3 = mir_read_float(8L + fp);
  f_4 = f0_alpha * mir_read_float(16L + fp);
  f_5 = f_3 + f_4;
  i_6 = GuiGetStyle((int) 13L, (int) 19L);
  i_7 = (int) i_6 / (int) 2L;
  I_9 = (long) (int) i_7;
  f_8 = (float) I_9;
  f_10 = f_5 - f_8;
  mir_write_float(28L + fp, f_10);
  f_11 = mir_read_float(12L + fp);
  i_12 = GuiGetStyle((int) 13L, (int) 20L);
  I_14 = (long) (int) i_12;
  f_13 = (float) I_14;
  f_15 = f_11 - f_13;
  mir_write_float(32L + fp, f_15);
  i_16 = GuiGetStyle((int) 13L, (int) 19L);
  I_18 = (long) (int) i_16;
  f_17 = (float) I_18;
  mir_write_float(36L + fp, f_17);
  f_19 = mir_read_float(20L + fp);
  i_20 = GuiGetStyle((int) 13L, (int) 20L);
  i_21 = (int) i_20 * (int) 2L;
  I_23 = (long) (int) i_21;
  f_22 = (float) I_23;
  f_24 = f_19 + f_22;
  mir_write_float(40L + fp, f_24);
  I_26 = (long) fp + (long) 44L;
  I_25 = memset((long) I_26, (int) 0L, (long) 4L);
  if ((int) i0_state == (int) 3L) { mir_label = 1678; break; }
case 1679:
  I_28 = m2_guiLocked;
  if (((long) mir_read_int(I_28) != 0)) { mir_label = 1678; break; }
case 1680:
  I_29 = (long) fp + (long) 96L;
  GetMousePosition((long) I_29);
  I_31 = (long) fp + (long) 48L;
  I_30 = memcpy((long) I_31, (long) I_29, (long) 24L);
  I_33 = (long) fp + (long) 48L;
  I_34 = (long) fp + (long) 8L;
  i_32 = m2_CheckCollisionPointRec((long) I_33, (long) I_34);
  I_35 = (long) (int) i_32;
  if (((long) I_35 != 0)) { mir_label = 1681; break; }
case 1682:
  I_37 = (long) fp + (long) 48L;
  I_38 = (long) fp + (long) 28L;
  i_36 = m2_CheckCollisionPointRec((long) I_37, (long) I_38);
  I_39 = (long) (int) i_36;
  if (((long) I_39 == 0)) { mir_label = 1683; break; }
case 1681:
  i_40 = IsMouseButtonDown((int) 0L);
  I_41 = (long) (int) i_40;
  if (((long) I_41 == 0)) { mir_label = 1684; break; }
case 1685:
  i0_state = 2L;
  f_42 = mir_read_float(48L + fp) - mir_read_float(8L + fp);
  f_43 = f_42 / mir_read_float(16L + fp);
  f0_alpha = f_43;
  if (f0_alpha <= 0f) { mir_label = 1686; break; }
  mir_label = 1687; break;
case 1686:
  f0_alpha = 0f;
  mir_label = 1688; break;
case 1687:
case 1688:
  if (f0_alpha >= 1f) { mir_label = 1689; break; }
  mir_label = 1690; break;
case 1689:
  f0_alpha = 1f;
  mir_label = 1691; break;
case 1690:
case 1691:
  mir_label = 1692; break;
case 1684:
  i0_state = 1L;
case 1692:
  mir_label = 1693; break;
case 1683:
case 1693:
  mir_label = 1694; break;
case 1678:
case 1694:
  if ((int) i0_state == (int) 3L) { mir_label = 1695; break; }
case 1696:
  i_47 = (long) mir_read_float(16L + fp);
  i_48 = (int) i_47 / (int) 10L;
  i4_checksX = i_48;
  i_49 = (long) mir_read_float(20L + fp);
  i_50 = (int) i_49 / (int) 10L;
  i4_checksY = i_50;
  i5_x = 0L;
  if ((int) i5_x >= (int) i4_checksX) { mir_label = 1697; break; }
case 1698:
  i7_y = 0L;
  if ((int) i7_y >= (int) i4_checksY) { mir_label = 1699; break; }
case 1700:
  i_53 = (int) i5_x * (int) 10L;
  I_55 = (long) (int) i_53;
  f_54 = (float) I_55;
  f_56 = mir_read_float(8L + fp) + f_54;
  mir_write_float(68L + fp, f_56);
  i_57 = (int) i7_y * (int) 10L;
  I_59 = (long) (int) i_57;
  f_58 = (float) I_59;
  f_60 = mir_read_float(12L + fp) + f_58;
  mir_write_float(72L + fp, f_60);
  f_61 = (float) 10L;
  mir_write_float(76L + fp, f_61);
  f_62 = (float) 10L;
  mir_write_float(80L + fp, f_62);
  I_64 = (long) fp + (long) 84L;
  I_63 = memset((long) I_64, (int) 0L, (long) 4L);
  I_65 = (long) fp + (long) 68L;
  I_66 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(64L + fp, I_66);
  I_67 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(65L + fp, I_67);
  I_68 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(66L + fp, I_68);
  I_69 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(67L + fp, I_69);
  I_70 = (long) fp + (long) 64L;
  i_71 = (int) i5_x + (int) i7_y;
  i_72 = (int) i_71 % (int) 2L;
  I_73 = (long) (int) i_72;
  if (((long) I_73 == 0)) { mir_label = 1701; break; }
case 1702:
  I_74 = (long) fp + (long) 96L;
  I_75 = (long) fp + (long) 112L;
  I_76 = (long) fp + (long) 128L;
  i_77 = GuiGetStyle((int) 13L, (int) 9L);
  m2_GetColor((long) I_76, (int) i_77);
  m2_Fade((long) I_75, (long) I_76, (float) 0.400000006f);
  I_78 = m2_guiAlpha;
  m2_Fade((long) I_74, (long) I_75, (float) mir_read_float(I_78));
  I_79 = I_74;
  mir_label = 1703; break;
case 1701:
  I_80 = (long) fp + (long) 112L;
  I_81 = (long) fp + (long) 128L;
  I_82 = (long) fp + (long) 144L;
  i_83 = GuiGetStyle((int) 13L, (int) 10L);
  m2_GetColor((long) I_82, (int) i_83);
  m2_Fade((long) I_81, (long) I_82, (float) 0.400000006f);
  I_84 = m2_guiAlpha;
  m2_Fade((long) I_80, (long) I_81, (float) mir_read_float(I_84));
  I_79 = I_80;
case 1703:
  m2_GuiDrawRectangle((long) I_65, (int) 0L, (long) I_70, (long) I_79);
case 1704:
  i_85 = i7_y;
  i_85 = (int) i_85 + (int) 1L;
  i7_y = i_85;
  if ((int) i7_y < (int) i4_checksY) { mir_label = 1700; break; }
case 1699:
case 1705:
  i_87 = i5_x;
  i_87 = (int) i_87 + (int) 1L;
  i5_x = i_87;
  if ((int) i5_x < (int) i4_checksX) { mir_label = 1698; break; }
case 1697:
  I_89 = (long) fp + (long) 8L;
  I_90 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(48L + fp, I_90);
  I_91 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(49L + fp, I_91);
  I_92 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(50L + fp, I_92);
  I_93 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(51L + fp, I_93);
  I_94 = (long) fp + (long) 48L;
  I_95 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(52L + fp, I_95);
  I_96 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(53L + fp, I_96);
  I_97 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(54L + fp, I_97);
  I_98 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(55L + fp, I_98);
  I_99 = (long) fp + (long) 52L;
  I_100 = (long) fp + (long) 96L;
  I_101 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(56L + fp, I_101);
  I_102 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(57L + fp, I_102);
  I_103 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(58L + fp, I_103);
  I_104 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(59L + fp, I_104);
  I_105 = (long) fp + (long) 56L;
  I_106 = m2_guiAlpha;
  m2_Fade((long) I_100, (long) I_105, (float) mir_read_float(I_106));
  I_107 = (long) fp + (long) 112L;
  I_108 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(60L + fp, I_108);
  I_109 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(61L + fp, I_109);
  I_110 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(62L + fp, I_110);
  I_111 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(63L + fp, I_111);
  I_112 = (long) fp + (long) 60L;
  I_113 = m2_guiAlpha;
  m2_Fade((long) I_107, (long) I_112, (float) mir_read_float(I_113));
  DrawRectangleGradientEx((long) I_89, (long) I_94, (long) I_99, (long) I_100, (long) I_107);
  mir_label = 1706; break;
case 1695:
  I_114 = (long) fp + (long) 8L;
  I_115 = (long) fp + (long) 96L;
  I_116 = (long) fp + (long) 112L;
  i_117 = GuiGetStyle((int) 13L, (int) 10L);
  m2_GetColor((long) I_116, (int) i_117);
  m2_Fade((long) I_115, (long) I_116, (float) 0.100000001f);
  I_118 = (long) fp + (long) 112L;
  I_119 = (long) fp + (long) 128L;
  i_120 = GuiGetStyle((int) 13L, (int) 10L);
  m2_GetColor((long) I_119, (int) i_120);
  m2_Fade((long) I_118, (long) I_119, (float) 0.100000001f);
  I_121 = (long) fp + (long) 128L;
  I_122 = (long) fp + (long) 144L;
  i_123 = GuiGetStyle((int) 13L, (int) 9L);
  m2_GetColor((long) I_122, (int) i_123);
  I_124 = m2_guiAlpha;
  m2_Fade((long) I_121, (long) I_122, (float) mir_read_float(I_124));
  I_125 = (long) fp + (long) 144L;
  I_126 = (long) fp + (long) 160L;
  i_127 = GuiGetStyle((int) 13L, (int) 9L);
  m2_GetColor((long) I_126, (int) i_127);
  I_128 = m2_guiAlpha;
  m2_Fade((long) I_125, (long) I_126, (float) mir_read_float(I_128));
  DrawRectangleGradientEx((long) I_114, (long) I_115, (long) I_118, (long) I_121, (long) I_125);
case 1706:
  I_129 = (long) fp + (long) 8L;
  i_130 = GuiGetStyle((int) 13L, (int) 12L);
  I_131 = (long) fp + (long) 96L;
  I_132 = (long) fp + (long) 112L;
  i_134 = (int) i0_state * (int) 3L;
  i_135 = (int) 0L + (int) i_134;
  i_133 = GuiGetStyle((int) 13L, (int) i_135);
  m2_GetColor((long) I_132, (int) i_133);
  I_136 = m2_guiAlpha;
  m2_Fade((long) I_131, (long) I_132, (float) mir_read_float(I_136));
  I_137 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(fp, I_137);
  I_138 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(1L + fp, I_138);
  I_139 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(2L + fp, I_139);
  I_140 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(3L + fp, I_140);
  m2_GuiDrawRectangle((long) I_129, (int) i_130, (long) I_131, (long) fp);
  I_141 = (long) fp + (long) 28L;
  I_142 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(4L + fp, I_142);
  I_143 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(5L + fp, I_143);
  I_144 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(6L + fp, I_144);
  I_145 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(7L + fp, I_145);
  I_146 = (long) fp + (long) 4L;
  I_147 = (long) fp + (long) 96L;
  I_148 = (long) fp + (long) 112L;
  i_150 = (int) i0_state * (int) 3L;
  i_151 = (int) 0L + (int) i_150;
  i_149 = GuiGetStyle((int) 13L, (int) i_151);
  m2_GetColor((long) I_148, (int) i_149);
  I_152 = m2_guiAlpha;
  m2_Fade((long) I_147, (long) I_148, (float) mir_read_float(I_152));
  m2_GuiDrawRectangle((long) I_141, (int) 0L, (long) I_146, (long) I_147);
  mir_set_stack_position(mir_saved_stack_position);
  return (float) f0_alpha;
} // End of switch
} // End of while
} // End of function GuiColorBarAlpha

public float GuiColorBarHue (long _I0_bounds, long _U0_text, float f0_hue) {
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  float f_3 = 0;
  long i_4 = 0;
  float f_5 = 0;
  long I_6 = 0;
  float f_7 = 0;
  float f_8 = 0;
  float f_9 = 0;
  float f_10 = 0;
  float f_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  float f_14 = 0;
  long I_15 = 0;
  float f_16 = 0;
  float f_17 = 0;
  long i_18 = 0;
  long i_19 = 0;
  float f_20 = 0;
  long I_21 = 0;
  float f_22 = 0;
  long i_23 = 0;
  float f_24 = 0;
  long I_25 = 0;
  long I_26 = 0;
  long I_27 = 0;
  long i_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  long I_31 = 0;
  long I_32 = 0;
  long i_33 = 0;
  long I_34 = 0;
  long I_35 = 0;
  long I_36 = 0;
  long i_37 = 0;
  long I_38 = 0;
  long I_39 = 0;
  long I_40 = 0;
  long i_41 = 0;
  long I_42 = 0;
  float f_43 = 0;
  float f_44 = 0;
  float f_45 = 0;
  float f_46 = 0;
  long i_47 = 0;
  long i_48 = 0;
  long i_49 = 0;
  long i_50 = 0;
  long i_51 = 0;
  long i_52 = 0;
  float f_53 = 0;
  float f_54 = 0;
  float f_55 = 0;
  long i_56 = 0;
  long I_57 = 0;
  long I_58 = 0;
  long I_59 = 0;
  long I_60 = 0;
  long I_61 = 0;
  long I_62 = 0;
  long I_63 = 0;
  long I_64 = 0;
  long I_65 = 0;
  long I_66 = 0;
  long I_67 = 0;
  long I_68 = 0;
  long I_69 = 0;
  long I_70 = 0;
  long i_71 = 0;
  float f_72 = 0;
  float f_73 = 0;
  float f_74 = 0;
  long i_75 = 0;
  long i_76 = 0;
  float f_77 = 0;
  float f_78 = 0;
  float f_79 = 0;
  long i_80 = 0;
  long I_81 = 0;
  long I_82 = 0;
  long I_83 = 0;
  long I_84 = 0;
  long I_85 = 0;
  long I_86 = 0;
  long I_87 = 0;
  long I_88 = 0;
  long I_89 = 0;
  long I_90 = 0;
  long I_91 = 0;
  long I_92 = 0;
  long I_93 = 0;
  long I_94 = 0;
  long i_95 = 0;
  float f_96 = 0;
  float f_97 = 0;
  float f_98 = 0;
  float f_99 = 0;
  float f_100 = 0;
  long i_101 = 0;
  long i_102 = 0;
  float f_103 = 0;
  float f_104 = 0;
  float f_105 = 0;
  long i_106 = 0;
  long I_107 = 0;
  long I_108 = 0;
  long I_109 = 0;
  long I_110 = 0;
  long I_111 = 0;
  long I_112 = 0;
  long I_113 = 0;
  long I_114 = 0;
  long I_115 = 0;
  long I_116 = 0;
  long I_117 = 0;
  long I_118 = 0;
  long I_119 = 0;
  long I_120 = 0;
  long i_121 = 0;
  float f_122 = 0;
  float f_123 = 0;
  float f_124 = 0;
  float f_125 = 0;
  float f_126 = 0;
  long i_127 = 0;
  long i_128 = 0;
  float f_129 = 0;
  float f_130 = 0;
  float f_131 = 0;
  long i_132 = 0;
  long I_133 = 0;
  long I_134 = 0;
  long I_135 = 0;
  long I_136 = 0;
  long I_137 = 0;
  long I_138 = 0;
  long I_139 = 0;
  long I_140 = 0;
  long I_141 = 0;
  long I_142 = 0;
  long I_143 = 0;
  long I_144 = 0;
  long I_145 = 0;
  long I_146 = 0;
  long i_147 = 0;
  float f_148 = 0;
  float f_149 = 0;
  float f_150 = 0;
  float f_151 = 0;
  float f_152 = 0;
  long i_153 = 0;
  long i_154 = 0;
  float f_155 = 0;
  float f_156 = 0;
  float f_157 = 0;
  long i_158 = 0;
  long I_159 = 0;
  long I_160 = 0;
  long I_161 = 0;
  long I_162 = 0;
  long I_163 = 0;
  long I_164 = 0;
  long I_165 = 0;
  long I_166 = 0;
  long I_167 = 0;
  long I_168 = 0;
  long I_169 = 0;
  long I_170 = 0;
  long I_171 = 0;
  long I_172 = 0;
  long i_173 = 0;
  float f_174 = 0;
  float f_175 = 0;
  float f_176 = 0;
  float f_177 = 0;
  float f_178 = 0;
  long i_179 = 0;
  long i_180 = 0;
  float f_181 = 0;
  float f_182 = 0;
  long i_183 = 0;
  long I_184 = 0;
  long I_185 = 0;
  long I_186 = 0;
  long I_187 = 0;
  long I_188 = 0;
  long I_189 = 0;
  long I_190 = 0;
  long I_191 = 0;
  long I_192 = 0;
  long I_193 = 0;
  long I_194 = 0;
  long I_195 = 0;
  long I_196 = 0;
  long I_197 = 0;
  long i_198 = 0;
  long i_199 = 0;
  long i_200 = 0;
  long i_201 = 0;
  long I_202 = 0;
  long I_203 = 0;
  long I_204 = 0;
  long i_205 = 0;
  long I_206 = 0;
  long I_207 = 0;
  long I_208 = 0;
  long i_209 = 0;
  long I_210 = 0;
  long I_211 = 0;
  long i_212 = 0;
  long I_213 = 0;
  long I_214 = 0;
  long i_215 = 0;
  long i_216 = 0;
  long i_217 = 0;
  long I_218 = 0;
  long I_219 = 0;
  long I_220 = 0;
  long I_221 = 0;
  long I_222 = 0;
  long I_223 = 0;
  long I_224 = 0;
  long I_225 = 0;
  long I_226 = 0;
  long I_227 = 0;
  long I_228 = 0;
  long I_229 = 0;
  long I_230 = 0;
  long i_231 = 0;
  long i_232 = 0;
  long i_233 = 0;
  long I_234 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(144L);
  I_0 = (long) fp + (long) 8L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  f_3 = mir_read_float(8L + fp);
  i_4 = GuiGetStyle((int) 13L, (int) 20L);
  I_6 = (long) (int) i_4;
  f_5 = (float) I_6;
  f_7 = f_3 - f_5;
  mir_write_float(28L + fp, f_7);
  f_8 = mir_read_float(12L + fp);
  f_9 = f0_hue / 360f;
  f_10 = f_9 * mir_read_float(20L + fp);
  f_11 = f_8 + f_10;
  i_12 = GuiGetStyle((int) 13L, (int) 19L);
  i_13 = (int) i_12 / (int) 2L;
  I_15 = (long) (int) i_13;
  f_14 = (float) I_15;
  f_16 = f_11 - f_14;
  mir_write_float(32L + fp, f_16);
  f_17 = mir_read_float(16L + fp);
  i_18 = GuiGetStyle((int) 13L, (int) 20L);
  i_19 = (int) i_18 * (int) 2L;
  I_21 = (long) (int) i_19;
  f_20 = (float) I_21;
  f_22 = f_17 + f_20;
  mir_write_float(36L + fp, f_22);
  i_23 = GuiGetStyle((int) 13L, (int) 19L);
  I_25 = (long) (int) i_23;
  f_24 = (float) I_25;
  mir_write_float(40L + fp, f_24);
  I_27 = (long) fp + (long) 44L;
  I_26 = memset((long) I_27, (int) 0L, (long) 4L);
  if ((int) i0_state == (int) 3L) { mir_label = 1707; break; }
case 1708:
  I_29 = m2_guiLocked;
  if (((long) mir_read_int(I_29) != 0)) { mir_label = 1707; break; }
case 1709:
  I_30 = (long) fp + (long) 96L;
  GetMousePosition((long) I_30);
  I_32 = (long) fp + (long) 48L;
  I_31 = memcpy((long) I_32, (long) I_30, (long) 24L);
  I_34 = (long) fp + (long) 48L;
  I_35 = (long) fp + (long) 8L;
  i_33 = m2_CheckCollisionPointRec((long) I_34, (long) I_35);
  I_36 = (long) (int) i_33;
  if (((long) I_36 != 0)) { mir_label = 1710; break; }
case 1711:
  I_38 = (long) fp + (long) 48L;
  I_39 = (long) fp + (long) 28L;
  i_37 = m2_CheckCollisionPointRec((long) I_38, (long) I_39);
  I_40 = (long) (int) i_37;
  if (((long) I_40 == 0)) { mir_label = 1712; break; }
case 1710:
  i_41 = IsMouseButtonDown((int) 0L);
  I_42 = (long) (int) i_41;
  if (((long) I_42 == 0)) { mir_label = 1713; break; }
case 1714:
  i0_state = 2L;
  f_43 = mir_read_float(52L + fp) - mir_read_float(12L + fp);
  f_44 = (float) 360L;
  f_45 = f_43 * f_44;
  f_46 = f_45 / mir_read_float(20L + fp);
  f0_hue = f_46;
  if (f0_hue <= 0f) { mir_label = 1715; break; }
  mir_label = 1716; break;
case 1715:
  f0_hue = 0f;
  mir_label = 1717; break;
case 1716:
case 1717:
  if (f0_hue >= 359f) { mir_label = 1718; break; }
  mir_label = 1719; break;
case 1718:
  f0_hue = 359f;
  mir_label = 1720; break;
case 1719:
case 1720:
  mir_label = 1721; break;
case 1713:
  i0_state = 1L;
case 1721:
  mir_label = 1722; break;
case 1712:
case 1722:
  mir_label = 1723; break;
case 1707:
case 1723:
  if ((int) i0_state == (int) 3L) { mir_label = 1724; break; }
case 1725:
  i_50 = (long) mir_read_float(8L + fp);
  i_51 = (long) mir_read_float(12L + fp);
  i_52 = (long) mir_read_float(16L + fp);
  f_54 = (float) 6L;
  f_55 = mir_read_float(20L + fp) / f_54;
  f_53 = ceilf((float) f_55);
  i_56 = (long) f_53;
  I_57 = (long) fp + (long) 96L;
  I_58 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(48L + fp, I_58);
  I_59 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(49L + fp, I_59);
  I_60 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(50L + fp, I_60);
  I_61 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(51L + fp, I_61);
  I_62 = (long) fp + (long) 48L;
  I_63 = m2_guiAlpha;
  m2_Fade((long) I_57, (long) I_62, (float) mir_read_float(I_63));
  I_64 = (long) fp + (long) 112L;
  I_65 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(52L + fp, I_65);
  I_66 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(53L + fp, I_66);
  I_67 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(54L + fp, I_67);
  I_68 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(55L + fp, I_68);
  I_69 = (long) fp + (long) 52L;
  I_70 = m2_guiAlpha;
  m2_Fade((long) I_64, (long) I_69, (float) mir_read_float(I_70));
  m2_DrawRectangleGradientV((int) i_50, (int) i_51, (int) i_52, (int) i_56, (long) I_57, (long) I_64);
  i_71 = (long) mir_read_float(8L + fp);
  f_72 = (float) 6L;
  f_73 = mir_read_float(20L + fp) / f_72;
  f_74 = mir_read_float(12L + fp) + f_73;
  i_75 = (long) f_74;
  i_76 = (long) mir_read_float(16L + fp);
  f_78 = (float) 6L;
  f_79 = mir_read_float(20L + fp) / f_78;
  f_77 = ceilf((float) f_79);
  i_80 = (long) f_77;
  I_81 = (long) fp + (long) 96L;
  I_82 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(56L + fp, I_82);
  I_83 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(57L + fp, I_83);
  I_84 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(58L + fp, I_84);
  I_85 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(59L + fp, I_85);
  I_86 = (long) fp + (long) 56L;
  I_87 = m2_guiAlpha;
  m2_Fade((long) I_81, (long) I_86, (float) mir_read_float(I_87));
  I_88 = (long) fp + (long) 112L;
  I_89 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(60L + fp, I_89);
  I_90 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(61L + fp, I_90);
  I_91 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(62L + fp, I_91);
  I_92 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(63L + fp, I_92);
  I_93 = (long) fp + (long) 60L;
  I_94 = m2_guiAlpha;
  m2_Fade((long) I_88, (long) I_93, (float) mir_read_float(I_94));
  m2_DrawRectangleGradientV((int) i_71, (int) i_75, (int) i_76, (int) i_80, (long) I_81, (long) I_88);
  i_95 = (long) mir_read_float(8L + fp);
  f_96 = (float) 6L;
  f_97 = mir_read_float(20L + fp) / f_96;
  f_98 = (float) 2L;
  f_99 = f_98 * f_97;
  f_100 = mir_read_float(12L + fp) + f_99;
  i_101 = (long) f_100;
  i_102 = (long) mir_read_float(16L + fp);
  f_104 = (float) 6L;
  f_105 = mir_read_float(20L + fp) / f_104;
  f_103 = ceilf((float) f_105);
  i_106 = (long) f_103;
  I_107 = (long) fp + (long) 96L;
  I_108 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(64L + fp, I_108);
  I_109 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(65L + fp, I_109);
  I_110 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(66L + fp, I_110);
  I_111 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(67L + fp, I_111);
  I_112 = (long) fp + (long) 64L;
  I_113 = m2_guiAlpha;
  m2_Fade((long) I_107, (long) I_112, (float) mir_read_float(I_113));
  I_114 = (long) fp + (long) 112L;
  I_115 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(68L + fp, I_115);
  I_116 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(69L + fp, I_116);
  I_117 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(70L + fp, I_117);
  I_118 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(71L + fp, I_118);
  I_119 = (long) fp + (long) 68L;
  I_120 = m2_guiAlpha;
  m2_Fade((long) I_114, (long) I_119, (float) mir_read_float(I_120));
  m2_DrawRectangleGradientV((int) i_95, (int) i_101, (int) i_102, (int) i_106, (long) I_107, (long) I_114);
  i_121 = (long) mir_read_float(8L + fp);
  f_122 = (float) 6L;
  f_123 = mir_read_float(20L + fp) / f_122;
  f_124 = (float) 3L;
  f_125 = f_124 * f_123;
  f_126 = mir_read_float(12L + fp) + f_125;
  i_127 = (long) f_126;
  i_128 = (long) mir_read_float(16L + fp);
  f_130 = (float) 6L;
  f_131 = mir_read_float(20L + fp) / f_130;
  f_129 = ceilf((float) f_131);
  i_132 = (long) f_129;
  I_133 = (long) fp + (long) 96L;
  I_134 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(72L + fp, I_134);
  I_135 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(73L + fp, I_135);
  I_136 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(74L + fp, I_136);
  I_137 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(75L + fp, I_137);
  I_138 = (long) fp + (long) 72L;
  I_139 = m2_guiAlpha;
  m2_Fade((long) I_133, (long) I_138, (float) mir_read_float(I_139));
  I_140 = (long) fp + (long) 112L;
  I_141 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(76L + fp, I_141);
  I_142 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(77L + fp, I_142);
  I_143 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(78L + fp, I_143);
  I_144 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(79L + fp, I_144);
  I_145 = (long) fp + (long) 76L;
  I_146 = m2_guiAlpha;
  m2_Fade((long) I_140, (long) I_145, (float) mir_read_float(I_146));
  m2_DrawRectangleGradientV((int) i_121, (int) i_127, (int) i_128, (int) i_132, (long) I_133, (long) I_140);
  i_147 = (long) mir_read_float(8L + fp);
  f_148 = (float) 6L;
  f_149 = mir_read_float(20L + fp) / f_148;
  f_150 = (float) 4L;
  f_151 = f_150 * f_149;
  f_152 = mir_read_float(12L + fp) + f_151;
  i_153 = (long) f_152;
  i_154 = (long) mir_read_float(16L + fp);
  f_156 = (float) 6L;
  f_157 = mir_read_float(20L + fp) / f_156;
  f_155 = ceilf((float) f_157);
  i_158 = (long) f_155;
  I_159 = (long) fp + (long) 96L;
  I_160 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(80L + fp, I_160);
  I_161 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(81L + fp, I_161);
  I_162 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(82L + fp, I_162);
  I_163 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(83L + fp, I_163);
  I_164 = (long) fp + (long) 80L;
  I_165 = m2_guiAlpha;
  m2_Fade((long) I_159, (long) I_164, (float) mir_read_float(I_165));
  I_166 = (long) fp + (long) 112L;
  I_167 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(84L + fp, I_167);
  I_168 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(85L + fp, I_168);
  I_169 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(86L + fp, I_169);
  I_170 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(87L + fp, I_170);
  I_171 = (long) fp + (long) 84L;
  I_172 = m2_guiAlpha;
  m2_Fade((long) I_166, (long) I_171, (float) mir_read_float(I_172));
  m2_DrawRectangleGradientV((int) i_147, (int) i_153, (int) i_154, (int) i_158, (long) I_159, (long) I_166);
  i_173 = (long) mir_read_float(8L + fp);
  f_174 = (float) 6L;
  f_175 = mir_read_float(20L + fp) / f_174;
  f_176 = (float) 5L;
  f_177 = f_176 * f_175;
  f_178 = mir_read_float(12L + fp) + f_177;
  i_179 = (long) f_178;
  i_180 = (long) mir_read_float(16L + fp);
  f_181 = (float) 6L;
  f_182 = mir_read_float(20L + fp) / f_181;
  i_183 = (long) f_182;
  I_184 = (long) fp + (long) 96L;
  I_185 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(88L + fp, I_185);
  I_186 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(89L + fp, I_186);
  I_187 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(90L + fp, I_187);
  I_188 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(91L + fp, I_188);
  I_189 = (long) fp + (long) 88L;
  I_190 = m2_guiAlpha;
  m2_Fade((long) I_184, (long) I_189, (float) mir_read_float(I_190));
  I_191 = (long) fp + (long) 112L;
  I_192 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(92L + fp, I_192);
  I_193 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(93L + fp, I_193);
  I_194 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(94L + fp, I_194);
  I_195 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(95L + fp, I_195);
  I_196 = (long) fp + (long) 92L;
  I_197 = m2_guiAlpha;
  m2_Fade((long) I_191, (long) I_196, (float) mir_read_float(I_197));
  m2_DrawRectangleGradientV((int) i_173, (int) i_179, (int) i_180, (int) i_183, (long) I_184, (long) I_191);
  mir_label = 1726; break;
case 1724:
  i_198 = (long) mir_read_float(8L + fp);
  i_199 = (long) mir_read_float(12L + fp);
  i_200 = (long) mir_read_float(16L + fp);
  i_201 = (long) mir_read_float(20L + fp);
  I_202 = (long) fp + (long) 96L;
  I_203 = (long) fp + (long) 112L;
  I_204 = (long) fp + (long) 128L;
  i_205 = GuiGetStyle((int) 13L, (int) 10L);
  m2_GetColor((long) I_204, (int) i_205);
  m2_Fade((long) I_203, (long) I_204, (float) 0.100000001f);
  I_206 = m2_guiAlpha;
  m2_Fade((long) I_202, (long) I_203, (float) mir_read_float(I_206));
  I_207 = (long) fp + (long) 112L;
  I_208 = (long) fp + (long) 128L;
  i_209 = GuiGetStyle((int) 13L, (int) 9L);
  m2_GetColor((long) I_208, (int) i_209);
  I_210 = m2_guiAlpha;
  m2_Fade((long) I_207, (long) I_208, (float) mir_read_float(I_210));
  m2_DrawRectangleGradientV((int) i_198, (int) i_199, (int) i_200, (int) i_201, (long) I_202, (long) I_207);
case 1726:
  I_211 = (long) fp + (long) 8L;
  i_212 = GuiGetStyle((int) 13L, (int) 12L);
  I_213 = (long) fp + (long) 96L;
  I_214 = (long) fp + (long) 112L;
  i_216 = (int) i0_state * (int) 3L;
  i_217 = (int) 0L + (int) i_216;
  i_215 = GuiGetStyle((int) 13L, (int) i_217);
  m2_GetColor((long) I_214, (int) i_215);
  I_218 = m2_guiAlpha;
  m2_Fade((long) I_213, (long) I_214, (float) mir_read_float(I_218));
  I_219 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(fp, I_219);
  I_220 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(1L + fp, I_220);
  I_221 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(2L + fp, I_221);
  I_222 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(3L + fp, I_222);
  m2_GuiDrawRectangle((long) I_211, (int) i_212, (long) I_213, (long) fp);
  I_223 = (long) fp + (long) 28L;
  I_224 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(4L + fp, I_224);
  I_225 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(5L + fp, I_225);
  I_226 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(6L + fp, I_226);
  I_227 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(7L + fp, I_227);
  I_228 = (long) fp + (long) 4L;
  I_229 = (long) fp + (long) 96L;
  I_230 = (long) fp + (long) 112L;
  i_232 = (int) i0_state * (int) 3L;
  i_233 = (int) 0L + (int) i_232;
  i_231 = GuiGetStyle((int) 13L, (int) i_233);
  m2_GetColor((long) I_230, (int) i_231);
  I_234 = m2_guiAlpha;
  m2_Fade((long) I_229, (long) I_230, (float) mir_read_float(I_234));
  m2_GuiDrawRectangle((long) I_223, (int) 0L, (long) I_228, (long) I_229);
  mir_set_stack_position(mir_saved_stack_position);
  return (float) f0_hue;
} // End of switch
} // End of while
} // End of function GuiColorBarHue

public void GuiColorPicker (long _Ret_Addr, long _I0_bounds, long _U0_text, long _I0_color) {
  long Ret_Addr = _Ret_Addr;
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long I0_color = _I0_color;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  float f_6 = 0;
  float f_7 = 0;
  long i_8 = 0;
  float f_9 = 0;
  long I_10 = 0;
  float f_11 = 0;
  float f_12 = 0;
  long i_13 = 0;
  float f_14 = 0;
  long I_15 = 0;
  float f_16 = 0;
  long I_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  float f_20 = 0;
  float f_21 = 0;
  float f_22 = 0;
  float f_23 = 0;
  float f_24 = 0;
  float f_25 = 0;
  long I_26 = 0;
  long I_27 = 0;
  long I_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  float f_31 = 0;
  long I_32 = 0;
  long I_33 = 0;
  long I_34 = 0;
  long I_35 = 0;
  long I_36 = 0;
  float f_37 = 0;
  float f_38 = 0;
  long I_39 = 0;
  long I_40 = 0;
  long I_41 = 0;
  float f_42 = 0;
  float f_43 = 0;
  long I_44 = 0;
  long I_45 = 0;
  long I_46 = 0;
  float f_47 = 0;
  float f_48 = 0;
  long I_49 = 0;
  long I_50 = 0;
  long I_51 = 0;
  long I_52 = 0;
  long I_53 = 0;
  long I_54 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(160L);
  I_0 = (long) fp + (long) 8L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = 4L;
case 1727:
  I_2 = (long) I_2 - (long) 1L;
  mir_write_byte(fp + I_2, mir_read_byte(I0_color + I_2));
  if ((long) I_2 > (long) 0L) { mir_label = 1727; break; }
  I_3 = (long) fp + (long) 128L;
  I_4 = (long) fp + (long) 8L;
  GuiColorPanel((long) I_3, (long) I_4, (long) 0L, (long) fp);
  I_5 = 4L;
case 1728:
  I_5 = (long) I_5 - (long) 1L;
  mir_write_byte(fp + I_5, mir_read_byte(I_3 + I_5));
  if ((long) I_5 > (long) 0L) { mir_label = 1728; break; }
  f_6 = mir_read_float(8L + fp);
  f_7 = f_6 + mir_read_float(16L + fp);
  i_8 = GuiGetStyle((int) 13L, (int) 18L);
  I_10 = (long) (int) i_8;
  f_9 = (float) I_10;
  f_11 = f_7 + f_9;
  mir_write_float(28L + fp, f_11);
  f_12 = mir_read_float(12L + fp);
  mir_write_float(32L + fp, f_12);
  i_13 = GuiGetStyle((int) 13L, (int) 17L);
  I_15 = (long) (int) i_13;
  f_14 = (float) I_15;
  mir_write_float(36L + fp, f_14);
  f_16 = mir_read_float(20L + fp);
  mir_write_float(40L + fp, f_16);
  I_18 = (long) fp + (long) 44L;
  I_17 = memset((long) I_18, (int) 0L, (long) 4L);
  I_19 = (long) fp + (long) 128L;
  f_20 = (float) mir_read_ubyte(fp);
  f_21 = f_20 / 255f;
  mir_write_float(72L + fp, f_21);
  f_22 = (float) mir_read_ubyte(1L + fp);
  f_23 = f_22 / 255f;
  mir_write_float(76L + fp, f_23);
  f_24 = (float) mir_read_ubyte(2L + fp);
  f_25 = f_24 / 255f;
  mir_write_float(80L + fp, f_25);
  I_27 = (long) fp + (long) 84L;
  I_26 = memset((long) I_27, (int) 0L, (long) 12L);
  I_28 = (long) fp + (long) 72L;
  m2_ConvertRGBtoHSV((long) I_19, (long) I_28);
  I_30 = (long) fp + (long) 48L;
  I_29 = memcpy((long) I_30, (long) I_19, (long) 24L);
  I_32 = (long) fp + (long) 28L;
  f_31 = GuiColorBarHue((long) I_32, (long) 0L, (float) mir_read_float(48L + fp));
  mir_write_float(48L + fp, f_31);
  I_33 = (long) fp + (long) 128L;
  I_34 = (long) fp + (long) 48L;
  m2_ConvertHSVtoRGB((long) I_33, (long) I_34);
  I_36 = (long) fp + (long) 96L;
  I_35 = memcpy((long) I_36, (long) I_33, (long) 24L);
  f_38 = mir_read_float(96L + fp) * 255f;
  f_37 = roundf((float) f_38);
  I_40 = (long) f_37;
  I_39 = (((long) (int) I_40) & 0xFFL);
  I_41 = (((long) (int) I_39) & 0xFFL);
  mir_write_ubyte(4L + fp, I_41);
  f_43 = mir_read_float(100L + fp) * 255f;
  f_42 = roundf((float) f_43);
  I_45 = (long) f_42;
  I_44 = (((long) (int) I_45) & 0xFFL);
  I_46 = (((long) (int) I_44) & 0xFFL);
  mir_write_ubyte(5L + fp, I_46);
  f_48 = mir_read_float(104L + fp) * 255f;
  f_47 = roundf((float) f_48);
  I_50 = (long) f_47;
  I_49 = (((long) (int) I_50) & 0xFFL);
  I_51 = (((long) (int) I_49) & 0xFFL);
  mir_write_ubyte(6L + fp, I_51);
  I_52 = (((long) (int) mir_read_ubyte(3L + fp)) & 0xFFL);
  mir_write_ubyte(7L + fp, I_52);
  I_53 = 4L;
case 1729:
  I_53 = (long) I_53 - (long) 1L;
  mir_write_byte(fp + I_53, mir_read_byte(4L + fp + I_53));
  if ((long) I_53 > (long) 0L) { mir_label = 1729; break; }
  I_54 = 4L;
case 1730:
  I_54 = (long) I_54 - (long) 1L;
  mir_write_byte(Ret_Addr + I_54, mir_read_byte(fp + I_54));
  if ((long) I_54 > (long) 0L) { mir_label = 1730; break; }
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiColorPicker

public int GuiMessageBox (long _I0_bounds, long _U0_title, long _U0_message, long _U0_buttons) {
  long I0_bounds = _I0_bounds;
  long U0_title = _U0_title;
  long U0_message = _U0_message;
  long U0_buttons = _U0_buttons;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_clicked = 0;
  long U0_buttonsText = 0;
  long U_2 = 0;
  long U_3 = 0;
  float f_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  float f_7 = 0;
  float f_8 = 0;
  float f_9 = 0;
  float f_10 = 0;
  float f_11 = 0;
  float f_12 = 0;
  float f_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  float f_16 = 0;
  long I_17 = 0;
  float f_18 = 0;
  float f_19 = 0;
  float f_20 = 0;
  float f_21 = 0;
  long i0_textWidth = 0;
  long i_22 = 0;
  float f_23 = 0;
  long I_24 = 0;
  long I_25 = 0;
  float f_26 = 0;
  float f_27 = 0;
  float f_28 = 0;
  long i_29 = 0;
  float f_30 = 0;
  long I_31 = 0;
  float f_32 = 0;
  float f_33 = 0;
  float f_34 = 0;
  float f_35 = 0;
  float f_36 = 0;
  float f_37 = 0;
  long I_38 = 0;
  float f_39 = 0;
  float f_40 = 0;
  float f_41 = 0;
  float f_42 = 0;
  float f_43 = 0;
  float f_44 = 0;
  long i_45 = 0;
  long I_46 = 0;
  long I_47 = 0;
  long i0_prevTextAlignment = 0;
  long i_48 = 0;
  long I_49 = 0;
  long i_50 = 0;
  long i1_i = 0;
  long i_51 = 0;
  long i_52 = 0;
  long I_53 = 0;
  long I_54 = 0;
  long I_55 = 0;
  long i_56 = 0;
  float f_57 = 0;
  float f_58 = 0;
  float f_59 = 0;
  float f_60 = 0;
  long i_61 = 0;
  long i_62 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(64L);
  I_0 = (long) fp + (long) 4L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  i0_clicked = -1L;
  mir_write_int(fp, 0L);
  U_3 = fp;
  U_2 = m2_GuiTextSplit((long) U0_buttons, (byte) 59L, (long) U_3, (long) 0L);
  U0_buttonsText = U_2;
  f_4 = (float) 0L;
  mir_write_float(24L + fp, f_4);
  I_6 = (long) fp + (long) 28L;
  I_5 = memset((long) I_6, (int) 0L, (long) 16L);
  f_7 = (float) 12L;
  f_8 = mir_read_float(4L + fp) + f_7;
  mir_write_float(24L + fp, f_8);
  f_9 = mir_read_float(8L + fp) + mir_read_float(16L + fp);
  f_10 = (float) 24L;
  f_11 = f_9 - f_10;
  f_12 = (float) 12L;
  f_13 = f_11 - f_12;
  mir_write_float(28L + fp, f_13);
  i_14 = (int) mir_read_int(fp) + (int) 1L;
  i_15 = (int) 12L * (int) i_14;
  I_17 = (long) (int) i_15;
  f_16 = (float) I_17;
  f_18 = mir_read_float(12L + fp) - f_16;
  f_19 = (float) mir_read_int(fp);
  f_20 = f_18 / f_19;
  mir_write_float(32L + fp, f_20);
  f_21 = (float) 24L;
  mir_write_float(36L + fp, f_21);
  i_22 = m2_GetTextWidth((long) U0_message);
  i0_textWidth = i_22;
  f_23 = (float) 0L;
  mir_write_float(44L + fp, f_23);
  I_25 = (long) fp + (long) 48L;
  I_24 = memset((long) I_25, (int) 0L, (long) 16L);
  f_26 = (float) 2L;
  f_27 = mir_read_float(12L + fp) / f_26;
  f_28 = mir_read_float(4L + fp) + f_27;
  i_29 = (int) i0_textWidth / (int) 2L;
  I_31 = (long) (int) i_29;
  f_30 = (float) I_31;
  f_32 = f_28 - f_30;
  mir_write_float(44L + fp, f_32);
  f_33 = (float) 24L;
  f_34 = mir_read_float(8L + fp) + f_33;
  f_35 = (float) 12L;
  f_36 = f_34 + f_35;
  mir_write_float(48L + fp, f_36);
  I_38 = (long) (int) i0_textWidth;
  f_37 = (float) I_38;
  mir_write_float(52L + fp, f_37);
  f_39 = (float) 24L;
  f_40 = mir_read_float(16L + fp) - f_39;
  f_41 = (float) 36L;
  f_42 = f_40 - f_41;
  f_43 = (float) 24L;
  f_44 = f_42 - f_43;
  mir_write_float(56L + fp, f_44);
  I_46 = (long) fp + (long) 4L;
  i_45 = GuiWindowBox((long) I_46, (long) U0_title);
  I_47 = (long) (int) i_45;
  if (((long) I_47 == 0)) { mir_label = 1731; break; }
case 1732:
  i0_clicked = 0L;
  mir_label = 1733; break;
case 1731:
case 1733:
  i_48 = GuiGetStyle((int) 1L, (int) 14L);
  i0_prevTextAlignment = i_48;
  GuiSetStyle((int) 1L, (int) 14L, (int) 1L);
  I_49 = (long) fp + (long) 44L;
  GuiLabel((long) I_49, (long) U0_message);
  GuiSetStyle((int) 1L, (int) 14L, (int) i0_prevTextAlignment);
  i_50 = GuiGetStyle((int) 2L, (int) 14L);
  i0_prevTextAlignment = i_50;
  GuiSetStyle((int) 2L, (int) 14L, (int) 1L);
  i1_i = 0L;
  if ((int) i1_i >= (int) mir_read_int(fp)) { mir_label = 1734; break; }
case 1735:
  I_53 = (long) fp + (long) 24L;
  I_54 = (long) (int) i1_i;
  i_52 = GuiButton((long) I_53, (long) mir_read_ulong(U0_buttonsText + I_54 * 8));
  I_55 = (long) (int) i_52;
  if (((long) I_55 == 0)) { mir_label = 1736; break; }
case 1737:
  i_56 = (int) i1_i + (int) 1L;
  i0_clicked = i_56;
  mir_label = 1738; break;
case 1736:
case 1738:
  f_57 = (float) 12L;
  f_58 = mir_read_float(32L + fp) + f_57;
  f_59 = mir_read_float(24L + fp);
  f_59 = f_59 + f_58;
  mir_write_float(24L + fp, f_59);
case 1739:
  i_61 = i1_i;
  i_61 = (int) i_61 + (int) 1L;
  i1_i = i_61;
  if ((int) i1_i < (int) mir_read_int(fp)) { mir_label = 1735; break; }
case 1734:
  GuiSetStyle((int) 2L, (int) 14L, (int) i0_prevTextAlignment);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_clicked;
} // End of switch
} // End of while
} // End of function GuiMessageBox

public int GuiTextInputBox (long _I0_bounds, long _U0_title, long _U0_message, long _U0_buttons, long _U0_text, int _i0_textMaxSize, long _U0_secretViewActive) {
  long I0_bounds = _I0_bounds;
  long U0_title = _U0_title;
  long U0_message = _U0_message;
  long U0_buttons = _U0_buttons;
  long U0_text = _U0_text;
  long i0_textMaxSize = _i0_textMaxSize;
  long U0_secretViewActive = _U0_secretViewActive;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_btnIndex = 0;
  long U0_buttonsText = 0;
  long U_2 = 0;
  long U_3 = 0;
  float f_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  float f_7 = 0;
  float f_8 = 0;
  float f_9 = 0;
  float f_10 = 0;
  float f_11 = 0;
  float f_12 = 0;
  float f_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  float f_16 = 0;
  long I_17 = 0;
  float f_18 = 0;
  float f_19 = 0;
  float f_20 = 0;
  float f_21 = 0;
  long i0_messageInputHeight = 0;
  long i_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long i_25 = 0;
  long i_26 = 0;
  long i_27 = 0;
  float f_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  long i_31 = 0;
  long i1_textSize = 0;
  long i_32 = 0;
  float f_33 = 0;
  float f_34 = 0;
  float f_35 = 0;
  long i_36 = 0;
  float f_37 = 0;
  long I_38 = 0;
  float f_39 = 0;
  float f_40 = 0;
  float f_41 = 0;
  long i_42 = 0;
  float f_43 = 0;
  long I_44 = 0;
  float f_45 = 0;
  long i_46 = 0;
  float f_47 = 0;
  long I_48 = 0;
  float f_49 = 0;
  float f_50 = 0;
  float f_51 = 0;
  float f_52 = 0;
  long I_53 = 0;
  long i_54 = 0;
  float f_55 = 0;
  long I_56 = 0;
  float f_57 = 0;
  long I_58 = 0;
  long I_59 = 0;
  float f_60 = 0;
  float f_61 = 0;
  float f_62 = 0;
  float f_63 = 0;
  float f_64 = 0;
  float f_65 = 0;
  long i_66 = 0;
  float f_67 = 0;
  float f_68 = 0;
  float f_69 = 0;
  float f_70 = 0;
  long i_71 = 0;
  long i_72 = 0;
  long i_73 = 0;
  float f_74 = 0;
  long I_75 = 0;
  float f_76 = 0;
  float f_77 = 0;
  float f_78 = 0;
  float f_79 = 0;
  float f_80 = 0;
  long i_81 = 0;
  long I_82 = 0;
  long I_83 = 0;
  long i_84 = 0;
  long i2_prevTextAlignment = 0;
  long i_85 = 0;
  long I_86 = 0;
  long i_87 = 0;
  long i_88 = 0;
  float f_89 = 0;
  float f_90 = 0;
  float f_91 = 0;
  float f_92 = 0;
  long I_93 = 0;
  long I_94 = 0;
  long I_95 = 0;
  long i_96 = 0;
  long I_97 = 0;
  long U_98 = 0;
  long I_99 = 0;
  long I_100 = 0;
  long I_101 = 0;
  long I_102 = 0;
  long I_103 = 0;
  long I_104 = 0;
  long i_105 = 0;
  float f_106 = 0;
  float f_107 = 0;
  float f_108 = 0;
  float f_109 = 0;
  float f_110 = 0;
  long I_111 = 0;
  long I_112 = 0;
  long I_113 = 0;
  long i_114 = 0;
  long U_115 = 0;
  long i_116 = 0;
  long I_117 = 0;
  long I_118 = 0;
  long I_119 = 0;
  long I_120 = 0;
  long I_121 = 0;
  long I_122 = 0;
  long i0_prevBtnTextAlignment = 0;
  long i_123 = 0;
  long i5_i = 0;
  long i_124 = 0;
  long i_125 = 0;
  long I_126 = 0;
  long I_127 = 0;
  long I_128 = 0;
  long i_129 = 0;
  float f_130 = 0;
  float f_131 = 0;
  float f_132 = 0;
  float f_133 = 0;
  long i_134 = 0;
  long i_135 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(176L);
  I_0 = (long) fp + (long) 4L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  i0_btnIndex = -1L;
  mir_write_int(fp, 0L);
  U_3 = fp;
  U_2 = m2_GuiTextSplit((long) U0_buttons, (byte) 59L, (long) U_3, (long) 0L);
  U0_buttonsText = U_2;
  f_4 = (float) 0L;
  mir_write_float(24L + fp, f_4);
  I_6 = (long) fp + (long) 28L;
  I_5 = memset((long) I_6, (int) 0L, (long) 16L);
  f_7 = (float) 12L;
  f_8 = mir_read_float(4L + fp) + f_7;
  mir_write_float(24L + fp, f_8);
  f_9 = mir_read_float(8L + fp) + mir_read_float(16L + fp);
  f_10 = (float) 24L;
  f_11 = f_9 - f_10;
  f_12 = (float) 12L;
  f_13 = f_11 - f_12;
  mir_write_float(28L + fp, f_13);
  i_14 = (int) mir_read_int(fp) + (int) 1L;
  i_15 = (int) 12L * (int) i_14;
  I_17 = (long) (int) i_15;
  f_16 = (float) I_17;
  f_18 = mir_read_float(12L + fp) - f_16;
  f_19 = (float) mir_read_int(fp);
  f_20 = f_18 / f_19;
  mir_write_float(32L + fp, f_20);
  f_21 = (float) 24L;
  mir_write_float(36L + fp, f_21);
  i_22 = (long) mir_read_float(16L + fp);
  i_23 = (int) i_22 - (int) 24L;
  i_24 = GuiGetStyle((int) 15L, (int) 12L);
  i_25 = (int) i_23 - (int) i_24;
  i_26 = (int) i_25 - (int) 24L;
  i_27 = (int) i_26 - (int) 24L;
  i0_messageInputHeight = i_27;
  f_28 = (float) 0L;
  mir_write_float(44L + fp, f_28);
  I_30 = (long) fp + (long) 48L;
  I_29 = memset((long) I_30, (int) 0L, (long) 16L);
  if ((long) U0_message == (long) 0L) { mir_label = 1740; break; }
case 1741:
  i_32 = m2_GetTextWidth((long) U0_message);
  i1_textSize = i_32;
  f_33 = (float) 2L;
  f_34 = mir_read_float(12L + fp) / f_33;
  f_35 = mir_read_float(4L + fp) + f_34;
  i_36 = (int) i1_textSize / (int) 2L;
  I_38 = (long) (int) i_36;
  f_37 = (float) I_38;
  f_39 = f_35 - f_37;
  mir_write_float(44L + fp, f_39);
  f_40 = (float) 24L;
  f_41 = mir_read_float(8L + fp) + f_40;
  i_42 = (int) i0_messageInputHeight / (int) 4L;
  I_44 = (long) (int) i_42;
  f_43 = (float) I_44;
  f_45 = f_41 + f_43;
  i_46 = GuiGetStyle((int) 0L, (int) 16L);
  I_48 = (long) (int) i_46;
  f_47 = (float) I_48;
  f_49 = (float) 2L;
  f_50 = f_47 / f_49;
  f_51 = f_45 - f_50;
  mir_write_float(48L + fp, f_51);
  I_53 = (long) (int) i1_textSize;
  f_52 = (float) I_53;
  mir_write_float(52L + fp, f_52);
  i_54 = GuiGetStyle((int) 0L, (int) 16L);
  I_56 = (long) (int) i_54;
  f_55 = (float) I_56;
  mir_write_float(56L + fp, f_55);
  mir_label = 1742; break;
case 1740:
case 1742:
  f_57 = (float) 0L;
  mir_write_float(64L + fp, f_57);
  I_59 = (long) fp + (long) 68L;
  I_58 = memset((long) I_59, (int) 0L, (long) 16L);
  f_60 = (float) 12L;
  f_61 = mir_read_float(4L + fp) + f_60;
  mir_write_float(64L + fp, f_61);
  f_62 = (float) 24L;
  f_63 = mir_read_float(8L + fp) + f_62;
  f_64 = (float) 13L;
  f_65 = f_63 - f_64;
  mir_write_float(68L + fp, f_65);
  if ((long) U0_message != (long) 0L) { mir_label = 1743; break; }
case 1744:
  f_67 = (float) 24L;
  f_68 = mir_read_float(8L + fp) + f_67;
  f_69 = (float) 12L;
  f_70 = f_68 + f_69;
  mir_write_float(68L + fp, f_70);
  mir_label = 1745; break;
case 1743:
  i_71 = (int) i0_messageInputHeight / (int) 2L;
  i_72 = (int) i0_messageInputHeight / (int) 4L;
  i_73 = (int) i_71 + (int) i_72;
  I_75 = (long) (int) i_73;
  f_74 = (float) I_75;
  f_76 = mir_read_float(68L + fp);
  f_76 = f_76 + f_74;
  mir_write_float(68L + fp, f_76);
case 1745:
  f_78 = (float) 24L;
  f_79 = mir_read_float(12L + fp) - f_78;
  mir_write_float(72L + fp, f_79);
  f_80 = (float) 26L;
  mir_write_float(76L + fp, f_80);
  I_82 = (long) fp + (long) 4L;
  i_81 = GuiWindowBox((long) I_82, (long) U0_title);
  I_83 = (long) (int) i_81;
  if (((long) I_83 == 0)) { mir_label = 1746; break; }
case 1747:
  i0_btnIndex = 0L;
  mir_label = 1748; break;
case 1746:
case 1748:
  if ((long) U0_message == (long) 0L) { mir_label = 1749; break; }
case 1750:
  i_85 = GuiGetStyle((int) 1L, (int) 14L);
  i2_prevTextAlignment = i_85;
  GuiSetStyle((int) 1L, (int) 14L, (int) 1L);
  I_86 = (long) fp + (long) 44L;
  GuiLabel((long) I_86, (long) U0_message);
  GuiSetStyle((int) 1L, (int) 14L, (int) i2_prevTextAlignment);
  mir_label = 1751; break;
case 1749:
case 1751:
  if ((long) U0_secretViewActive == (long) 0L) { mir_label = 1752; break; }
case 1753:
  mir_write_float(128L + fp, mir_read_float(64L + fp));
  mir_write_float(132L + fp, mir_read_float(68L + fp));
  f_89 = (float) 4L;
  f_90 = mir_read_float(72L + fp) - f_89;
  f_91 = (float) 26L;
  f_92 = f_90 - f_91;
  mir_write_float(136L + fp, f_92);
  mir_write_float(140L + fp, mir_read_float(76L + fp));
  I_94 = (long) fp + (long) 144L;
  I_93 = memset((long) I_94, (int) 0L, (long) 4L);
  I_95 = (long) fp + (long) 128L;
  if ((int) mir_read_int(U0_secretViewActive) == (int) 1L) { mir_label = 1754; break; }
case 1755:
  I_97 = m2_S0_GuiTextInputBox_textEditMode;
  if (((long) mir_read_int(I_97) == 0)) { mir_label = 1756; break; }
case 1754:
  U_98 = U0_text;
  mir_label = 1757; break;
case 1756:
  I_99 = m2_S3_GuiTextInputBox_stars;
  U_98 = I_99;
case 1757:
  I_100 = m2_S0_GuiTextInputBox_textEditMode;
  i_88 = GuiTextBox((long) I_95, (long) U_98, (int) i0_textMaxSize, (int) mir_read_int(I_100));
  I_101 = (long) (int) i_88;
  if (((long) I_101 == 0)) { mir_label = 1758; break; }
case 1759:
  I_102 = m2_S0_GuiTextInputBox_textEditMode;
  I_104 = m2_S0_GuiTextInputBox_textEditMode;
  if (((long) mir_read_int(I_104) == 0)) { mir_label = 1760; break; }
case 1761:
  I_103 = 0L;
  mir_label = 1762; break;
case 1760:
  I_103 = 1L;
case 1762:
  mir_write_int(I_102, I_103);
  mir_label = 1763; break;
case 1758:
case 1763:
  f_106 = mir_read_float(64L + fp) + mir_read_float(72L + fp);
  f_107 = (float) 26L;
  f_108 = f_106 - f_107;
  mir_write_float(148L + fp, f_108);
  mir_write_float(152L + fp, mir_read_float(68L + fp));
  f_109 = (float) 26L;
  mir_write_float(156L + fp, f_109);
  f_110 = (float) 26L;
  mir_write_float(160L + fp, f_110);
  I_112 = (long) fp + (long) 164L;
  I_111 = memset((long) I_112, (int) 0L, (long) 4L);
  I_113 = (long) fp + (long) 148L;
  if ((int) mir_read_int(U0_secretViewActive) != (int) 1L) { mir_label = 1764; break; }
case 1765:
  U_115 = mir_get_string_ptr("#44#");
  mir_label = 1766; break;
case 1764:
  U_115 = mir_get_string_ptr("#45#");
case 1766:
  i_105 = GuiToggle((long) I_113, (long) U_115, (int) mir_read_int(U0_secretViewActive));
  mir_write_int(U0_secretViewActive, i_105);
  mir_label = 1767; break;
case 1752:
  I_117 = (long) fp + (long) 64L;
  I_118 = m2_S0_GuiTextInputBox_textEditMode;
  i_116 = GuiTextBox((long) I_117, (long) U0_text, (int) i0_textMaxSize, (int) mir_read_int(I_118));
  I_119 = (long) (int) i_116;
  if (((long) I_119 == 0)) { mir_label = 1768; break; }
case 1769:
  I_120 = m2_S0_GuiTextInputBox_textEditMode;
  I_122 = m2_S0_GuiTextInputBox_textEditMode;
  if (((long) mir_read_int(I_122) == 0)) { mir_label = 1770; break; }
case 1771:
  I_121 = 0L;
  mir_label = 1772; break;
case 1770:
  I_121 = 1L;
case 1772:
  mir_write_int(I_120, I_121);
  mir_label = 1773; break;
case 1768:
case 1773:
case 1767:
  i_123 = GuiGetStyle((int) 2L, (int) 14L);
  i0_prevBtnTextAlignment = i_123;
  GuiSetStyle((int) 2L, (int) 14L, (int) 1L);
  i5_i = 0L;
  if ((int) i5_i >= (int) mir_read_int(fp)) { mir_label = 1774; break; }
case 1775:
  I_126 = (long) fp + (long) 24L;
  I_127 = (long) (int) i5_i;
  i_125 = GuiButton((long) I_126, (long) mir_read_ulong(U0_buttonsText + I_127 * 8));
  I_128 = (long) (int) i_125;
  if (((long) I_128 == 0)) { mir_label = 1776; break; }
case 1777:
  i_129 = (int) i5_i + (int) 1L;
  i0_btnIndex = i_129;
  mir_label = 1778; break;
case 1776:
case 1778:
  f_130 = (float) 12L;
  f_131 = mir_read_float(32L + fp) + f_130;
  f_132 = mir_read_float(24L + fp);
  f_132 = f_132 + f_131;
  mir_write_float(24L + fp, f_132);
case 1779:
  i_134 = i5_i;
  i_134 = (int) i_134 + (int) 1L;
  i5_i = i_134;
  if ((int) i5_i < (int) mir_read_int(fp)) { mir_label = 1775; break; }
case 1774:
  GuiSetStyle((int) 2L, (int) 14L, (int) i0_prevBtnTextAlignment);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_btnIndex;
} // End of switch
} // End of while
} // End of function GuiTextInputBox

long m2_S0_GuiTextInputBox_textEditMode = mir_set_data_int(0);
long m2_S3_GuiTextInputBox_stars = mir_set_data_ubytes(new short[] { 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 0 });
public void GuiGrid (long _Ret_Addr, long _I0_bounds, long _U0_text, float f0_spacing, int _i0_subdivs) {
  long Ret_Addr = _Ret_Addr;
  long I0_bounds = _I0_bounds;
  long U0_text = _U0_text;
  long i0_subdivs = _i0_subdivs;
  long fp = 0;
  long I_0 = 0;
  long i0_state = 0;
  long I_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  float f_5 = 0;
  float f_6 = 0;
  long I_7 = 0;
  long I_8 = 0;
  long i0_linesV = 0;
  float f_9 = 0;
  long i_10 = 0;
  long i_11 = 0;
  long i_12 = 0;
  long i0_linesH = 0;
  float f_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long I_18 = 0;
  long i_19 = 0;
  long I_20 = 0;
  long I_21 = 0;
  float f_22 = 0;
  float f_23 = 0;
  long i_24 = 0;
  float f_25 = 0;
  long I_26 = 0;
  float f_27 = 0;
  float f_28 = 0;
  long i_29 = 0;
  float f_30 = 0;
  long I_31 = 0;
  long i_32 = 0;
  long i6_i = 0;
  long i_33 = 0;
  float f_34 = 0;
  long I_35 = 0;
  float f_36 = 0;
  float f_37 = 0;
  long I_38 = 0;
  float f_39 = 0;
  float f_40 = 0;
  float f_41 = 0;
  long I_42 = 0;
  long I_43 = 0;
  long I_44 = 0;
  long I_45 = 0;
  long I_46 = 0;
  long I_47 = 0;
  long I_48 = 0;
  long I_49 = 0;
  long i_50 = 0;
  long i_51 = 0;
  long I_52 = 0;
  long I_53 = 0;
  long i_54 = 0;
  long I_55 = 0;
  long I_56 = 0;
  long I_57 = 0;
  long i_58 = 0;
  long i_59 = 0;
  long i_60 = 0;
  long i8_i = 0;
  long i_61 = 0;
  float f_62 = 0;
  long I_63 = 0;
  float f_64 = 0;
  float f_65 = 0;
  long I_66 = 0;
  float f_67 = 0;
  float f_68 = 0;
  float f_69 = 0;
  long I_70 = 0;
  long I_71 = 0;
  long I_72 = 0;
  long I_73 = 0;
  long I_74 = 0;
  long I_75 = 0;
  long I_76 = 0;
  long I_77 = 0;
  long i_78 = 0;
  long i_79 = 0;
  long I_80 = 0;
  long I_81 = 0;
  long i_82 = 0;
  long I_83 = 0;
  long I_84 = 0;
  long I_85 = 0;
  long i_86 = 0;
  long i_87 = 0;
  long i_88 = 0;
  long I_89 = 0;
  long I_90 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(144L);
  I_0 = memcpy((long) fp, (long) I0_bounds, (long) 20L);
  I_1 = m2_guiState;
  i0_state = mir_read_int(I_1);
  I_2 = (long) fp + (long) 96L;
  GetMousePosition((long) I_2);
  I_4 = (long) fp + (long) 24L;
  I_3 = memcpy((long) I_4, (long) I_2, (long) 24L);
  f_5 = (float) -1L;
  mir_write_float(48L + fp, f_5);
  f_6 = (float) -1L;
  mir_write_float(52L + fp, f_6);
  I_8 = (long) fp + (long) 56L;
  I_7 = memset((long) I_8, (int) 0L, (long) 16L);
  f_9 = mir_read_float(8L + fp) / f0_spacing;
  i_10 = (long) f_9;
  i_11 = (int) i_10 * (int) i0_subdivs;
  i_12 = (int) i_11 + (int) 1L;
  i0_linesV = i_12;
  f_13 = mir_read_float(12L + fp) / f0_spacing;
  i_14 = (long) f_13;
  i_15 = (int) i_14 * (int) i0_subdivs;
  i_16 = (int) i_15 + (int) 1L;
  i0_linesH = i_16;
  if ((int) i0_state == (int) 3L) { mir_label = 1780; break; }
case 1781:
  I_18 = m2_guiLocked;
  if (((long) mir_read_int(I_18) != 0)) { mir_label = 1780; break; }
case 1782:
  I_20 = (long) fp + (long) 24L;
  i_19 = m2_CheckCollisionPointRec((long) I_20, (long) fp);
  I_21 = (long) (int) i_19;
  if (((long) I_21 == 0)) { mir_label = 1783; break; }
case 1784:
  f_22 = mir_read_float(24L + fp) - mir_read_float(fp);
  f_23 = f_22 / f0_spacing;
  i_24 = (long) f_23;
  I_26 = (long) (int) i_24;
  f_25 = (float) I_26;
  mir_write_float(48L + fp, f_25);
  f_27 = mir_read_float(28L + fp) - mir_read_float(4L + fp);
  f_28 = f_27 / f0_spacing;
  i_29 = (long) f_28;
  I_31 = (long) (int) i_29;
  f_30 = (float) I_31;
  mir_write_float(52L + fp, f_30);
  mir_label = 1785; break;
case 1783:
case 1785:
  mir_label = 1786; break;
case 1780:
case 1786:
  if ((int) i0_state != (int) 0L) { mir_label = 1787; break; }
case 1788:
  if ((int) i0_subdivs <= (int) 0L) { mir_label = 1789; break; }
case 1790:
  i6_i = 0L;
  if ((int) i6_i >= (int) i0_linesV) { mir_label = 1791; break; }
case 1792:
  I_35 = (long) (int) i6_i;
  f_34 = (float) I_35;
  f_36 = f0_spacing * f_34;
  I_38 = (long) (int) i0_subdivs;
  f_37 = (float) I_38;
  f_39 = f_36 / f_37;
  f_40 = mir_read_float(fp) + f_39;
  mir_write_float(76L + fp, f_40);
  mir_write_float(80L + fp, mir_read_float(4L + fp));
  f_41 = (float) 1L;
  mir_write_float(84L + fp, f_41);
  mir_write_float(88L + fp, mir_read_float(12L + fp));
  I_43 = (long) fp + (long) 92L;
  I_42 = memset((long) I_43, (int) 0L, (long) 4L);
  I_44 = (long) fp + (long) 76L;
  I_45 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(72L + fp, I_45);
  I_46 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(73L + fp, I_46);
  I_47 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(74L + fp, I_47);
  I_48 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(75L + fp, I_48);
  I_49 = (long) fp + (long) 72L;
  i_50 = (int) i6_i % (int) i0_subdivs;
  if ((int) i_50 != (int) 0L) { mir_label = 1793; break; }
case 1794:
  I_52 = (long) fp + (long) 96L;
  I_53 = (long) fp + (long) 112L;
  i_54 = GuiGetStyle((int) 0L, (int) 18L);
  m2_GetColor((long) I_53, (int) i_54);
  m2_Fade((long) I_52, (long) I_53, (float) 0.600000024f);
  I_55 = I_52;
  mir_label = 1795; break;
case 1793:
  I_56 = (long) fp + (long) 112L;
  I_57 = (long) fp + (long) 128L;
  i_58 = GuiGetStyle((int) 0L, (int) 18L);
  m2_GetColor((long) I_57, (int) i_58);
  m2_Fade((long) I_56, (long) I_57, (float) 0.150000006f);
  I_55 = I_56;
case 1795:
  m2_GuiDrawRectangle((long) I_44, (int) 0L, (long) I_49, (long) I_55);
case 1796:
  i_59 = i6_i;
  i_59 = (int) i_59 + (int) 1L;
  i6_i = i_59;
  if ((int) i6_i < (int) i0_linesV) { mir_label = 1792; break; }
case 1791:
  i8_i = 0L;
  if ((int) i8_i >= (int) i0_linesH) { mir_label = 1797; break; }
case 1798:
  mir_write_float(76L + fp, mir_read_float(fp));
  I_63 = (long) (int) i8_i;
  f_62 = (float) I_63;
  f_64 = f0_spacing * f_62;
  I_66 = (long) (int) i0_subdivs;
  f_65 = (float) I_66;
  f_67 = f_64 / f_65;
  f_68 = mir_read_float(4L + fp) + f_67;
  mir_write_float(80L + fp, f_68);
  mir_write_float(84L + fp, mir_read_float(8L + fp));
  f_69 = (float) 1L;
  mir_write_float(88L + fp, f_69);
  I_71 = (long) fp + (long) 92L;
  I_70 = memset((long) I_71, (int) 0L, (long) 4L);
  I_72 = (long) fp + (long) 76L;
  I_73 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(72L + fp, I_73);
  I_74 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(73L + fp, I_74);
  I_75 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(74L + fp, I_75);
  I_76 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(75L + fp, I_76);
  I_77 = (long) fp + (long) 72L;
  i_78 = (int) i8_i % (int) i0_subdivs;
  if ((int) i_78 != (int) 0L) { mir_label = 1799; break; }
case 1800:
  I_80 = (long) fp + (long) 96L;
  I_81 = (long) fp + (long) 112L;
  i_82 = GuiGetStyle((int) 0L, (int) 18L);
  m2_GetColor((long) I_81, (int) i_82);
  m2_Fade((long) I_80, (long) I_81, (float) 0.600000024f);
  I_83 = I_80;
  mir_label = 1801; break;
case 1799:
  I_84 = (long) fp + (long) 112L;
  I_85 = (long) fp + (long) 128L;
  i_86 = GuiGetStyle((int) 0L, (int) 18L);
  m2_GetColor((long) I_85, (int) i_86);
  m2_Fade((long) I_84, (long) I_85, (float) 0.150000006f);
  I_83 = I_84;
case 1801:
  m2_GuiDrawRectangle((long) I_72, (int) 0L, (long) I_77, (long) I_83);
case 1802:
  i_87 = i8_i;
  i_87 = (int) i_87 + (int) 1L;
  i8_i = i_87;
  if ((int) i8_i < (int) i0_linesH) { mir_label = 1798; break; }
case 1797:
  mir_label = 1803; break;
case 1789:
case 1803:
  mir_label = 1804; break;
case 1787:
case 1804:
  I_90 = (long) fp + (long) 48L;
  I_89 = memcpy((long) Ret_Addr, (long) I_90, (long) 24L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiGrid

public void GuiLoadStyle (long _U0_fileName) {
  long U0_fileName = _U0_fileName;
  long fp = 0;
  long i0_tryBinary = 0;
  long U0_rgsFile = 0;
  long U_0 = 0;
  long i_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long U_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long i_8 = 0;
  long I_9 = 0;
  long i_10 = 0;
  long i_11 = 0;
  long i_12 = 0;
  long U_13 = 0;
  long U_14 = 0;
  long U_15 = 0;
  long i_16 = 0;
  long I_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  long I_20 = 0;
  long I_21 = 0;
  long I_22 = 0;
  long i_23 = 0;
  long U_24 = 0;
  long I_25 = 0;
  long I_26 = 0;
  long I_27 = 0;
  long I_28 = 0;
  long I_29 = 0;
  long i_30 = 0;
  long i_31 = 0;
  long U7_charValues = 0;
  long U_32 = 0;
  long I_33 = 0;
  long i_34 = 0;
  long U8_chars = 0;
  long U_35 = 0;
  long U_36 = 0;
  long U8_values = 0;
  long U_37 = 0;
  long U_38 = 0;
  long U_39 = 0;
  long i9_i = 0;
  long i_40 = 0;
  long I_41 = 0;
  long i_42 = 0;
  long I_43 = 0;
  long i_44 = 0;
  long i_45 = 0;
  long I_46 = 0;
  long i_47 = 0;
  long I_48 = 0;
  long I_49 = 0;
  long U_50 = 0;
  long U_51 = 0;
  long I_52 = 0;
  long I_53 = 0;
  long I_54 = 0;
  long i_55 = 0;
  long I_56 = 0;
  long I_57 = 0;
  long I_58 = 0;
  long I_59 = 0;
  long i_60 = 0;
  long I_61 = 0;
  long I_62 = 0;
  long U_63 = 0;
  long U_64 = 0;
  long I_65 = 0;
  long I_66 = 0;
  long I_67 = 0;
  long i_68 = 0;
  long I_69 = 0;
  long I_70 = 0;
  long I_71 = 0;
  long i_72 = 0;
  long i_73 = 0;
  long I_74 = 0;
  long U_75 = 0;
  long i_76 = 0;
  long I_77 = 0;
  long i_78 = 0;
  long I_79 = 0;
  long U_80 = 0;
  long i_81 = 0;
  long I_82 = 0;
  long I_83 = 0;
  long I_84 = 0;
  long I_85 = 0;
  long I_86 = 0;
  long U_87 = 0;
  long I_88 = 0;
  long U_89 = 0;
  long U_90 = 0;
  long U_91 = 0;
  long U_92 = 0;
  long U_93 = 0;
  long U_94 = 0;
  long I_95 = 0;
  long i_96 = 0;
  long i_97 = 0;
  long I_98 = 0;
  long i_99 = 0;
  long i_100 = 0;
  long I_101 = 0;
  long i_102 = 0;
  long i_103 = 0;
  long I_104 = 0;
  long i_105 = 0;
  long i_106 = 0;
  long I_107 = 0;
  long I_108 = 0;
  long i13_i = 0;
  long i_109 = 0;
  long U_110 = 0;
  long U_111 = 0;
  long U_112 = 0;
  long U_113 = 0;
  long U_114 = 0;
  long U_115 = 0;
  long i_116 = 0;
  long i_117 = 0;
  long i_118 = 0;
  long i16_i = 0;
  long i_119 = 0;
  long i_120 = 0;
  long i_121 = 0;
  long i_122 = 0;
  long i_123 = 0;
  long i_124 = 0;
  long i_125 = 0;
  long i_126 = 0;
  long i_127 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(896L);
  i0_tryBinary = 0L;
  U_0 = fopen((long) U0_fileName, (long) mir_get_string_ptr("rt"));
  U0_rgsFile = U_0;
  if ((long) U0_rgsFile == (long) 0L) { mir_label = 1805; break; }
case 1806:
  I_2 = (long) (byte) 0L;
  mir_write_byte(fp, I_2);
  I_4 = (long) fp + (long) 1L;
  I_3 = memset((long) I_4, (int) 0L, (long) 255L);
  U_5 = fgets((long) fp, (int) 256L, (long) U0_rgsFile);
  i_6 = 0L;
  if ((int) mir_read_byte(fp + i_6) != (int) 35L) { mir_label = 1807; break; }
case 1808:
  mir_write_int(256L + fp, 0L);
  mir_write_int(260L + fp, 0L);
  mir_write_uint(264L + fp, 0L);
case 1809:
  i_8 = feof((long) U0_rgsFile);
  I_9 = (long) (int) i_8;
  if (((long) I_9 != 0)) { mir_label = 1810; break; }
case 1811:
  i_10 = 0L;
  i_11 = mir_read_byte(fp + i_10);
  if ((int) i_11 == (int) 112L) { mir_label = 1812; break; }
  if ((int) i_11 == (int) 102L) { mir_label = 1813; break; }
  mir_label = 1814; break;
case 1812:
  U_13 = 256L;
  U_13 = (long) U_13 + (long) fp;
  U_14 = 260L;
  U_14 = (long) U_14 + (long) fp;
  U_15 = 264L;
  U_15 = (long) U_15 + (long) fp;
  i_12 = sscanf((long) fp, (long) mir_get_string_ptr("p %d %d 0x%x"), U_13, U_14, U_15);
  i_16 = mir_read_uint(264L + fp);
  GuiSetStyle((int) mir_read_int(256L + fp), (int) mir_read_int(260L + fp), (int) i_16);
  mir_label = 1815; break;
case 1813:
  mir_write_int(268L + fp, 0L);
  I_17 = (long) (byte) 0L;
  mir_write_byte(320L + fp, I_17);
  I_19 = (long) fp + (long) 321L;
  I_18 = memset((long) I_19, (int) 0L, (long) 255L);
  I_20 = (long) (byte) 0L;
  mir_write_byte(576L + fp, I_20);
  I_22 = (long) fp + (long) 577L;
  I_21 = memset((long) I_22, (int) 0L, (long) 255L);
  U_24 = 268L;
  U_24 = (long) U_24 + (long) fp;
  I_25 = (long) fp + (long) 320L;
  I_26 = (long) fp + (long) 576L;
  i_23 = sscanf((long) fp, (long) mir_get_string_ptr("f %d %s %[^\r\n]s"), U_24, I_25, I_26);
  mir_write_int(272L + fp, 0L);
  I_28 = (long) fp + (long) 276L;
  I_27 = memset((long) I_28, (int) 0L, (long) 44L);
  I_29 = (long) fp + (long) 320L;
  i_30 = 0L;
  if ((int) mir_read_byte(I_29 + i_30) == (int) 48L) { mir_label = 1816; break; }
case 1817:
  I_33 = (long) fp + (long) 320L;
  U_32 = LoadFileText((long) I_33);
  U7_charValues = U_32;
  if ((long) U7_charValues == (long) 0L) { mir_label = 1818; break; }
case 1819:
  mir_write_int(832L + fp, 0L);
  U_36 = 832L;
  U_36 = (long) U_36 + (long) fp;
  U_35 = TextSplit((long) U7_charValues, (byte) 10L, (long) U_36);
  U8_chars = U_35;
  U_38 = (long) mir_read_int(832L + fp) * (long) 4L;
  U_37 = malloc((long) U_38);
  U_39 = U_37;
  U8_values = U_39;
  i9_i = 0L;
  if ((int) i9_i >= (int) mir_read_int(832L + fp)) { mir_label = 1820; break; }
case 1821:
  I_41 = (long) (int) i9_i;
  I_43 = (long) (int) i9_i;
  i_42 = m2_TextToInteger((long) mir_read_ulong(U8_chars + I_43 * 8));
  mir_write_int(U8_values + I_41 * 4, i_42);
case 1822:
  i_44 = i9_i;
  i_44 = (int) i_44 + (int) 1L;
  i9_i = i_44;
  if ((int) i9_i < (int) mir_read_int(832L + fp)) { mir_label = 1821; break; }
case 1820:
  I_46 = (long) fp + (long) 848L;
  GetFontDefault((long) I_46);
  if ((int) mir_read_uint(280L + fp) == (int) mir_read_uint(8L + I_46)) { mir_label = 1823; break; }
case 1824:
  I_48 = (long) fp + (long) 280L;
  UnloadTexture((long) I_48);
  mir_label = 1825; break;
case 1823:
case 1825:
  I_49 = (long) fp + (long) 848L;
  U_51 = GetDirectoryPath((long) U0_fileName);
  I_52 = (long) fp + (long) 576L;
  U_50 = m2_TextFormat((long) mir_get_string_ptr("%s/%s"), U_51, I_52);
  LoadFontEx((long) I_49, (long) U_50, (int) mir_read_int(268L + fp), (long) U8_values, (int) mir_read_int(832L + fp));
  I_53 = (long) fp + (long) 272L;
  I_54 = memcpy((long) I_53, (long) I_49, (long) 48L);
  if ((int) mir_read_uint(280L + fp) != (int) 0L) { mir_label = 1826; break; }
case 1827:
  I_56 = (long) fp + (long) 848L;
  GetFontDefault((long) I_56);
  I_57 = (long) fp + (long) 272L;
  I_58 = memcpy((long) I_57, (long) I_56, (long) 48L);
  mir_label = 1828; break;
case 1826:
case 1828:
  free((long) U8_values);
  mir_label = 1829; break;
case 1818:
case 1829:
  mir_label = 1830; break;
case 1816:
  I_59 = (long) fp + (long) 848L;
  GetFontDefault((long) I_59);
  if ((int) mir_read_uint(280L + fp) == (int) mir_read_uint(8L + I_59)) { mir_label = 1831; break; }
case 1832:
  I_61 = (long) fp + (long) 280L;
  UnloadTexture((long) I_61);
  mir_label = 1833; break;
case 1831:
case 1833:
  I_62 = (long) fp + (long) 848L;
  U_64 = GetDirectoryPath((long) U0_fileName);
  I_65 = (long) fp + (long) 576L;
  U_63 = m2_TextFormat((long) mir_get_string_ptr("%s/%s"), U_64, I_65);
  LoadFontEx((long) I_62, (long) U_63, (int) mir_read_int(268L + fp), (long) 0L, (int) 0L);
  I_66 = (long) fp + (long) 272L;
  I_67 = memcpy((long) I_66, (long) I_62, (long) 48L);
  if ((int) mir_read_uint(280L + fp) != (int) 0L) { mir_label = 1834; break; }
case 1835:
  I_69 = (long) fp + (long) 848L;
  GetFontDefault((long) I_69);
  I_70 = (long) fp + (long) 272L;
  I_71 = memcpy((long) I_70, (long) I_69, (long) 48L);
  mir_label = 1836; break;
case 1834:
case 1836:
case 1830:
  if (Integer.compareUnsigned((int) mir_read_uint(280L + fp), (int) 0L) <= 0) { mir_label = 1837; break; }
case 1838:
  if ((int) mir_read_int(276L + fp) <= (int) 0L) { mir_label = 1837; break; }
case 1839:
  I_74 = (long) fp + (long) 272L;
  GuiSetFont((long) I_74);
  mir_label = 1840; break;
case 1837:
case 1840:
  mir_label = 1815; break;
case 1814:
case 1815:
  U_75 = fgets((long) fp, (int) 256L, (long) U0_rgsFile);
  i_76 = feof((long) U0_rgsFile);
  I_77 = (long) (int) i_76;
  if (((long) I_77 == 0)) { mir_label = 1811; break; }
case 1810:
  mir_label = 1841; break;
case 1807:
  i0_tryBinary = 1L;
case 1841:
  i_78 = fclose((long) U0_rgsFile);
  mir_label = 1842; break;
case 1805:
case 1842:
  I_79 = (long) (int) i0_tryBinary;
  if (((long) I_79 == 0)) { mir_label = 1843; break; }
case 1844:
  U_80 = fopen((long) U0_fileName, (long) mir_get_string_ptr("rb"));
  U0_rgsFile = U_80;
  if ((long) U0_rgsFile != (long) 0L) { mir_label = 1845; break; }
case 1846:
  mir_set_stack_position(mir_saved_stack_position);
  return;
  // Dead code: mir_label = 1847; break;
case 1845:
case 1847:
  I_82 = (long) (byte) 0L;
  mir_write_byte(8L + fp, I_82);
  I_84 = (long) fp + (long) 9L;
  I_83 = memset((long) I_84, (int) 0L, (long) 4L);
  I_85 = (long) (short) 0L;
  mir_write_short(fp, I_85);
  I_86 = (long) (short) 0L;
  mir_write_short(2L + fp, I_86);
  mir_write_int(4L + fp, 0L);
  I_88 = (long) fp + (long) 8L;
  U_87 = fread((long) I_88, (long) 1L, (long) 4L, (long) U0_rgsFile);
  U_90 = fp;
  U_89 = fread((long) U_90, (long) 1L, (long) 2L, (long) U0_rgsFile);
  U_92 = 2L;
  U_92 = (long) U_92 + (long) fp;
  U_91 = fread((long) U_92, (long) 1L, (long) 2L, (long) U0_rgsFile);
  U_94 = 4L;
  U_94 = (long) U_94 + (long) fp;
  U_93 = fread((long) U_94, (long) 1L, (long) 4L, (long) U0_rgsFile);
  I_95 = (long) fp + (long) 8L;
  i_96 = 0L;
  if ((int) mir_read_byte(I_95 + i_96) != (int) 114L) { mir_label = 1848; break; }
case 1849:
  I_98 = (long) fp + (long) 8L;
  i_99 = 1L;
  if ((int) mir_read_byte(I_98 + i_99) != (int) 71L) { mir_label = 1848; break; }
case 1850:
  I_101 = (long) fp + (long) 8L;
  i_102 = 2L;
  if ((int) mir_read_byte(I_101 + i_102) != (int) 83L) { mir_label = 1848; break; }
case 1851:
  I_104 = (long) fp + (long) 8L;
  i_105 = 3L;
  if ((int) mir_read_byte(I_104 + i_105) != (int) 32L) { mir_label = 1848; break; }
case 1852:
  I_107 = (long) (short) 0L;
  mir_write_short(14L + fp, I_107);
  I_108 = (long) (short) 0L;
  mir_write_short(16L + fp, I_108);
  mir_write_uint(20L + fp, 0L);
  i13_i = 0L;
  if ((int) i13_i >= (int) mir_read_int(4L + fp)) { mir_label = 1853; break; }
case 1854:
  U_111 = 14L;
  U_111 = (long) U_111 + (long) fp;
  U_110 = fread((long) U_111, (long) 1L, (long) 2L, (long) U0_rgsFile);
  U_113 = 16L;
  U_113 = (long) U_113 + (long) fp;
  U_112 = fread((long) U_113, (long) 1L, (long) 2L, (long) U0_rgsFile);
  U_115 = 20L;
  U_115 = (long) U_115 + (long) fp;
  U_114 = fread((long) U_115, (long) 1L, (long) 4L, (long) U0_rgsFile);
  if ((int) mir_read_short(14L + fp) != (int) 0L) { mir_label = 1855; break; }
case 1856:
  i_117 = mir_read_short(16L + fp);
  GuiSetStyle((int) 0L, (int) i_117, (int) mir_read_uint(20L + fp));
  if ((int) mir_read_short(16L + fp) >= (int) 16L) { mir_label = 1857; break; }
case 1858:
  i16_i = 1L;
  if ((int) i16_i >= (int) 16L) { mir_label = 1859; break; }
case 1860:
  i_120 = mir_read_short(16L + fp);
  GuiSetStyle((int) i16_i, (int) i_120, (int) mir_read_uint(20L + fp));
case 1861:
  i_121 = i16_i;
  i_121 = (int) i_121 + (int) 1L;
  i16_i = i_121;
  if ((int) i16_i < (int) 16L) { mir_label = 1860; break; }
case 1859:
  mir_label = 1862; break;
case 1857:
case 1862:
  mir_label = 1863; break;
case 1855:
  i_123 = mir_read_short(14L + fp);
  i_124 = mir_read_short(16L + fp);
  GuiSetStyle((int) i_123, (int) i_124, (int) mir_read_uint(20L + fp));
case 1863:
case 1864:
  i_125 = i13_i;
  i_125 = (int) i_125 + (int) 1L;
  i13_i = i_125;
  if ((int) i13_i < (int) mir_read_int(4L + fp)) { mir_label = 1854; break; }
case 1853:
  mir_label = 1865; break;
case 1848:
case 1865:
  i_127 = fclose((long) U0_rgsFile);
  mir_label = 1866; break;
case 1843:
case 1866:
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiLoadStyle

public void GuiLoadStyleDefault () {
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long i_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long I_7 = 0;
  long I_8 = 0;
  float f_9 = 0;
  float f_10 = 0;
  float f_11 = 0;
  float f_12 = 0;
  long I_13 = 0;
  long I_14 = 0;
  long I_15 = 0;
  long I_16 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(80L);
  I_0 = m2_guiStyleLoaded;
  mir_write_int(I_0, 1L);
  GuiSetStyle((int) 0L, (int) 0L, (int) 2206434303L);
  GuiSetStyle((int) 0L, (int) 1L, (int) 3385444863L);
  GuiSetStyle((int) 0L, (int) 2L, (int) 1751673087L);
  GuiSetStyle((int) 0L, (int) 3L, (int) 1538447871L);
  GuiSetStyle((int) 0L, (int) 4L, (int) 3387948799L);
  GuiSetStyle((int) 0L, (int) 5L, (int) 1822145791L);
  GuiSetStyle((int) 0L, (int) 6L, (int) 76728319L);
  GuiSetStyle((int) 0L, (int) 7L, (int) 2548629503L);
  GuiSetStyle((int) 0L, (int) 8L, (int) 915124223L);
  GuiSetStyle((int) 0L, (int) 9L, (int) 3049374463L);
  GuiSetStyle((int) 0L, (int) 10L, (int) 3874089471L);
  GuiSetStyle((int) 0L, (int) 11L, (int) 2931276031L);
  GuiSetStyle((int) 0L, (int) 12L, (int) 1L);
  GuiSetStyle((int) 0L, (int) 13L, (int) 0L);
  GuiSetStyle((int) 0L, (int) 14L, (int) 1L);
  GuiSetStyle((int) 1L, (int) 14L, (int) 0L);
  GuiSetStyle((int) 2L, (int) 12L, (int) 2L);
  GuiSetStyle((int) 4L, (int) 13L, (int) 4L);
  GuiSetStyle((int) 6L, (int) 13L, (int) 4L);
  GuiSetStyle((int) 6L, (int) 14L, (int) 2L);
  GuiSetStyle((int) 9L, (int) 13L, (int) 4L);
  GuiSetStyle((int) 9L, (int) 14L, (int) 0L);
  GuiSetStyle((int) 10L, (int) 13L, (int) 4L);
  GuiSetStyle((int) 10L, (int) 14L, (int) 0L);
  GuiSetStyle((int) 11L, (int) 13L, (int) 4L);
  GuiSetStyle((int) 11L, (int) 14L, (int) 0L);
  GuiSetStyle((int) 15L, (int) 13L, (int) 8L);
  GuiSetStyle((int) 15L, (int) 14L, (int) 0L);
  GuiSetStyle((int) 0L, (int) 16L, (int) 10L);
  GuiSetStyle((int) 0L, (int) 17L, (int) 1L);
  GuiSetStyle((int) 0L, (int) 18L, (int) 2427172351L);
  GuiSetStyle((int) 0L, (int) 19L, (int) 4126537215L);
  GuiSetStyle((int) 3L, (int) 16L, (int) 2L);
  GuiSetStyle((int) 4L, (int) 16L, (int) 16L);
  GuiSetStyle((int) 4L, (int) 17L, (int) 1L);
  GuiSetStyle((int) 5L, (int) 16L, (int) 1L);
  GuiSetStyle((int) 6L, (int) 16L, (int) 1L);
  GuiSetStyle((int) 7L, (int) 16L, (int) 32L);
  GuiSetStyle((int) 7L, (int) 17L, (int) 2L);
  GuiSetStyle((int) 8L, (int) 16L, (int) 16L);
  GuiSetStyle((int) 8L, (int) 17L, (int) 2L);
  GuiSetStyle((int) 9L, (int) 17L, (int) 4L);
  GuiSetStyle((int) 9L, (int) 16L, (int) 4L);
  GuiSetStyle((int) 11L, (int) 16L, (int) 24L);
  GuiSetStyle((int) 11L, (int) 17L, (int) 2L);
  GuiSetStyle((int) 14L, (int) 12L, (int) 0L);
  GuiSetStyle((int) 14L, (int) 17L, (int) 0L);
  GuiSetStyle((int) 14L, (int) 16L, (int) 6L);
  GuiSetStyle((int) 14L, (int) 18L, (int) 0L);
  GuiSetStyle((int) 14L, (int) 19L, (int) 16L);
  GuiSetStyle((int) 14L, (int) 20L, (int) 0L);
  GuiSetStyle((int) 14L, (int) 21L, (int) 12L);
  GuiSetStyle((int) 12L, (int) 16L, (int) 28L);
  GuiSetStyle((int) 12L, (int) 17L, (int) 2L);
  GuiSetStyle((int) 12L, (int) 18L, (int) 12L);
  GuiSetStyle((int) 12L, (int) 19L, (int) 1L);
  GuiSetStyle((int) 13L, (int) 16L, (int) 8L);
  GuiSetStyle((int) 13L, (int) 17L, (int) 16L);
  GuiSetStyle((int) 13L, (int) 18L, (int) 8L);
  GuiSetStyle((int) 13L, (int) 19L, (int) 8L);
  GuiSetStyle((int) 13L, (int) 20L, (int) 2L);
  I_1 = m2_guiFont;
  I_2 = (long) fp + (long) 32L;
  GetFontDefault((long) I_2);
  if ((int) mir_read_uint(8L + I_1) == (int) mir_read_uint(8L + I_2)) { mir_label = 1867; break; }
case 1868:
  I_4 = m2_guiFont;
  I_5 = (long) I_4 + (long) 8L;
  UnloadTexture((long) I_5);
  I_6 = m2_guiFont;
  I_7 = (long) fp + (long) 32L;
  GetFontDefault((long) I_7);
  I_8 = memcpy((long) I_6, (long) I_7, (long) 48L);
  f_9 = (float) 41L;
  mir_write_float(fp, f_9);
  f_10 = (float) 46L;
  mir_write_float(4L + fp, f_10);
  f_11 = (float) 2L;
  mir_write_float(8L + fp, f_11);
  f_12 = (float) 8L;
  mir_write_float(12L + fp, f_12);
  I_14 = (long) fp + (long) 16L;
  I_13 = memset((long) I_14, (int) 0L, (long) 4L);
  I_15 = m2_guiFont;
  I_16 = (long) I_15 + (long) 8L;
  SetShapesTexture((long) I_16, (long) fp);
  mir_label = 1869; break;
case 1867:
case 1869:
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiLoadStyleDefault

public long GuiIconText (int _i0_iconId, long _U0_text) {
  long i0_iconId = _i0_iconId;
  long U0_text = _U0_text;
  long fp = 0;
  long i_0 = 0;
  long U_1 = 0;
  long I_2 = 0;
  long i_3 = 0;
  long I_4 = 0;
  long i2_i = 0;
  long i_5 = 0;
  long I_6 = 0;
  long I_7 = 0;
  long i_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long i_11 = 0;
  long I_12 = 0;
  long i_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long I_16 = 0;
  long i_17 = 0;
  long I_18 = 0;
  long i_19 = 0;
  long I_20 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(1040L);
  if ((long) U0_text == (long) 0L) { mir_label = 1870; break; }
case 1871:
  I_2 = m2_S0_GuiIconText_buffer;
  U_1 = memset((long) I_2, (int) 0L, (long) 1024L);
  I_4 = m2_S0_GuiIconText_buffer;
  i_3 = sprintf((long) I_4, (long) mir_get_string_ptr("#%03i#"), i0_iconId);
  i2_i = 5L;
  if ((int) i2_i >= (int) 1024L) { mir_label = 1872; break; }
case 1873:
  I_6 = m2_S0_GuiIconText_buffer;
  I_7 = (long) (int) i2_i;
  i_8 = (int) i2_i - (int) 5L;
  I_9 = (long) (int) i_8;
  I_10 = (long) (byte) mir_read_byte(U0_text + I_9);
  mir_write_byte(I_6 + I_7, I_10);
  i_11 = (int) i2_i - (int) 5L;
  I_12 = (long) (int) i_11;
  if ((int) mir_read_byte(U0_text + I_12) != (int) 0L) { mir_label = 1874; break; }
case 1875:
  mir_label = 1872; break;
  // Dead code: mir_label = 1876; break;
case 1874:
case 1876:
case 1877:
  i_14 = i2_i;
  i_14 = (int) i_14 + (int) 1L;
  i2_i = i_14;
  if ((int) i2_i < (int) 1024L) { mir_label = 1873; break; }
case 1872:
  I_16 = m2_S0_GuiIconText_buffer;
  mir_set_stack_position(mir_saved_stack_position);
  return (long) I_16;
  // Dead code: mir_label = 1878; break;
case 1870:
  I_18 = m2_S0_GuiIconText_iconBuffer;
  i_19 = (int) i0_iconId & (int) 511L;
  i_17 = sprintf((long) I_18, (long) mir_get_string_ptr("#%03i#"), i_19);
  I_20 = m2_S0_GuiIconText_iconBuffer;
  mir_set_stack_position(mir_saved_stack_position);
  return (long) I_20;
case 1878:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) 0L;
} // End of switch
} // End of while
} // End of function GuiIconText

long m2_S0_GuiIconText_buffer = mir_set_data_byte(0);
long unused_data_addr_2073 = mir_allocate(1023);
long m2_S0_GuiIconText_iconBuffer = mir_set_data_byte(0);
long unused_data_addr_2074 = mir_allocate(5);
public long GuiGetIcons () {
  long I_0 = 0;
  I_0 = m2_guiIconsPtr;
  return (long) mir_read_ulong(I_0);
} // End of function GuiGetIcons

public long GuiLoadIcons (long _U0_fileName, int _i0_loadIconsName) {
  long U0_fileName = _U0_fileName;
  long i0_loadIconsName = _i0_loadIconsName;
  long fp = 0;
  long U0_rgiFile = 0;
  long U_0 = 0;
  long U0_guiIconsName = 0;
  long i_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long I_7 = 0;
  long I_8 = 0;
  long U_9 = 0;
  long I_10 = 0;
  long U_11 = 0;
  long U_12 = 0;
  long U_13 = 0;
  long U_14 = 0;
  long U_15 = 0;
  long U_16 = 0;
  long U_17 = 0;
  long U_18 = 0;
  long I_19 = 0;
  long i_20 = 0;
  long i_21 = 0;
  long I_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long I_25 = 0;
  long i_26 = 0;
  long i_27 = 0;
  long I_28 = 0;
  long i_29 = 0;
  long i_30 = 0;
  long I_31 = 0;
  long U_32 = 0;
  long U_33 = 0;
  long U_34 = 0;
  long i4_i = 0;
  long i_35 = 0;
  long I_36 = 0;
  long U_37 = 0;
  long U_38 = 0;
  long U_39 = 0;
  long I_40 = 0;
  long i_41 = 0;
  long i_42 = 0;
  long i_43 = 0;
  long i_44 = 0;
  long I_45 = 0;
  long U_46 = 0;
  long I_47 = 0;
  long i_48 = 0;
  long i_49 = 0;
  long i_50 = 0;
  long U_51 = 0;
  long i_52 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  U_0 = fopen((long) U0_fileName, (long) mir_get_string_ptr("rb"));
  U0_rgiFile = U_0;
  U0_guiIconsName = 0L;
  if ((long) U0_rgiFile == (long) 0L) { mir_label = 1879; break; }
case 1880:
  I_2 = (long) (byte) 0L;
  mir_write_byte(8L + fp, I_2);
  I_4 = (long) fp + (long) 9L;
  I_3 = memset((long) I_4, (int) 0L, (long) 4L);
  I_5 = (long) (short) 0L;
  mir_write_short(fp, I_5);
  I_6 = (long) (short) 0L;
  mir_write_short(2L + fp, I_6);
  I_7 = (long) (short) 0L;
  mir_write_short(4L + fp, I_7);
  I_8 = (long) (short) 0L;
  mir_write_short(6L + fp, I_8);
  I_10 = (long) fp + (long) 8L;
  U_9 = fread((long) I_10, (long) 1L, (long) 4L, (long) U0_rgiFile);
  U_12 = fp;
  U_11 = fread((long) U_12, (long) 1L, (long) 2L, (long) U0_rgiFile);
  U_14 = 2L;
  U_14 = (long) U_14 + (long) fp;
  U_13 = fread((long) U_14, (long) 1L, (long) 2L, (long) U0_rgiFile);
  U_16 = 4L;
  U_16 = (long) U_16 + (long) fp;
  U_15 = fread((long) U_16, (long) 1L, (long) 2L, (long) U0_rgiFile);
  U_18 = 6L;
  U_18 = (long) U_18 + (long) fp;
  U_17 = fread((long) U_18, (long) 1L, (long) 2L, (long) U0_rgiFile);
  I_19 = (long) fp + (long) 8L;
  i_20 = 0L;
  if ((int) mir_read_byte(I_19 + i_20) != (int) 114L) { mir_label = 1881; break; }
case 1882:
  I_22 = (long) fp + (long) 8L;
  i_23 = 1L;
  if ((int) mir_read_byte(I_22 + i_23) != (int) 71L) { mir_label = 1881; break; }
case 1883:
  I_25 = (long) fp + (long) 8L;
  i_26 = 2L;
  if ((int) mir_read_byte(I_25 + i_26) != (int) 73L) { mir_label = 1881; break; }
case 1884:
  I_28 = (long) fp + (long) 8L;
  i_29 = 3L;
  if ((int) mir_read_byte(I_28 + i_29) != (int) 32L) { mir_label = 1881; break; }
case 1885:
  I_31 = (long) (int) i0_loadIconsName;
  if (((long) I_31 == 0)) { mir_label = 1886; break; }
case 1887:
  U_33 = (long) mir_read_short(4L + fp) * (long) 8L;
  U_32 = malloc((long) U_33);
  U_34 = U_32;
  U0_guiIconsName = U_34;
  i4_i = 0L;
  if ((int) i4_i >= (int) mir_read_short(4L + fp)) { mir_label = 1888; break; }
case 1889:
  I_36 = (long) (int) i4_i;
  U_37 = malloc((long) 32L);
  U_38 = U_37;
  mir_write_ulong(U0_guiIconsName + I_36 * 8, U_38);
  I_40 = (long) (int) i4_i;
  U_39 = fread((long) mir_read_ulong(U0_guiIconsName + I_40 * 8), (long) 32L, (long) 1L, (long) U0_rgiFile);
case 1890:
  i_41 = i4_i;
  i_41 = (int) i_41 + (int) 1L;
  i4_i = i_41;
  if ((int) i4_i < (int) mir_read_short(4L + fp)) { mir_label = 1889; break; }
case 1888:
  mir_label = 1891; break;
case 1886:
  i_44 = (int) mir_read_short(4L + fp) * (int) 32L;
  I_45 = (long) (int) i_44;
  i_43 = fseek((long) U0_rgiFile, (long) I_45, (int) 1L);
case 1891:
  I_47 = m2_guiIconsPtr;
  i_48 = (int) mir_read_short(6L + fp) * (int) mir_read_short(6L + fp);
  i_49 = (int) i_48 / (int) 32L;
  i_50 = (int) mir_read_short(4L + fp) * (int) i_49;
  U_51 = (long) (int) i_50;
  U_46 = fread((long) mir_read_ulong(I_47), (long) U_51, (long) 4L, (long) U0_rgiFile);
  mir_label = 1892; break;
case 1881:
case 1892:
  i_52 = fclose((long) U0_rgiFile);
  mir_label = 1893; break;
case 1879:
case 1893:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) U0_guiIconsName;
} // End of switch
} // End of while
} // End of function GuiLoadIcons

public void GuiDrawIcon (int _i0_iconId, int _i0_posX, int _i0_posY, int _i0_pixelSize, long _I0_color) {
  long i0_iconId = _i0_iconId;
  long i0_posX = _i0_posX;
  long i0_posY = _i0_posY;
  long i0_pixelSize = _i0_pixelSize;
  long I0_color = _I0_color;
  long fp = 0;
  long I_0 = 0;
  long i1_i = 0;
  long i1_y = 0;
  long i_1 = 0;
  long i3_k = 0;
  long i_2 = 0;
  long I_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long I_6 = 0;
  long I_7 = 0;
  long u_8 = 0;
  long u_9 = 0;
  long I_10 = 0;
  long i_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long i_18 = 0;
  long i_19 = 0;
  long i_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  I_0 = 4L;
case 1894:
  I_0 = (long) I_0 - (long) 1L;
  mir_write_byte(fp + I_0, mir_read_byte(I0_color + I_0));
  if ((long) I_0 > (long) 0L) { mir_label = 1894; break; }
  i1_i = 0L;
  i1_y = 0L;
  if ((int) i1_i >= (int) 8L) { mir_label = 1895; break; }
case 1896:
  i3_k = 0L;
  if ((int) i3_k >= (int) 32L) { mir_label = 1897; break; }
case 1898:
  I_3 = m2_guiIconsPtr;
  i_4 = (int) i0_iconId * (int) 8L;
  i_5 = (int) i_4 + (int) i1_i;
  I_6 = (long) (int) i_5;
  I_7 = mir_read_ulong(I_3);
  u_8 = (int) 1L << (int) i3_k;
  u_9 = (int) mir_read_uint(I_7 + I_6 * 4) & (int) u_8;
  I_10 = (((long) u_9) & 0xFFFFFFFFL);
  if (((long) I_10 == 0)) { mir_label = 1899; break; }
case 1900:
  i_11 = (int) i3_k % (int) 16L;
  i_12 = (int) i_11 * (int) i0_pixelSize;
  i_13 = (int) i0_posX + (int) i_12;
  i_14 = (int) i1_y * (int) i0_pixelSize;
  i_15 = (int) i0_posY + (int) i_14;
  DrawRectangle((int) i_13, (int) i_15, (int) i0_pixelSize, (int) i0_pixelSize, (long) fp);
  mir_label = 1901; break;
case 1899:
case 1901:
  if ((int) i3_k == (int) 15L) { mir_label = 1902; break; }
case 1903:
  if ((int) i3_k != (int) 31L) { mir_label = 1904; break; }
case 1902:
  i_18 = i1_y;
  i_18 = (int) i_18 + (int) 1L;
  i1_y = i_18;
  mir_label = 1905; break;
case 1904:
case 1905:
case 1906:
  i_19 = i3_k;
  i_19 = (int) i_19 + (int) 1L;
  i3_k = i_19;
  if ((int) i3_k < (int) 32L) { mir_label = 1898; break; }
case 1897:
case 1907:
  i_21 = i1_i;
  i_21 = (int) i_21 + (int) 1L;
  i1_i = i_21;
  if ((int) i1_i < (int) 8L) { mir_label = 1896; break; }
case 1895:
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiDrawIcon

protected int m2_GetTextWidth (long _U0_text) {
  long U0_text = _U0_text;
  long fp = 0;
  float f_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long i0_textIconOffset = 0;
  long i_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long i3_i = 0;
  long I_8 = 0;
  long i_9 = 0;
  long i_10 = 0;
  long I_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  long I_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long U_17 = 0;
  long U_18 = 0;
  long U_19 = 0;
  long U_20 = 0;
  float f1_fontSize = 0;
  long i_21 = 0;
  float f_22 = 0;
  long I_23 = 0;
  long I_24 = 0;
  long i_25 = 0;
  long i_26 = 0;
  long i6_size = 0;
  long i7_i = 0;
  long i_27 = 0;
  long I_28 = 0;
  long i_29 = 0;
  long I_30 = 0;
  long i_31 = 0;
  long i_32 = 0;
  long i_33 = 0;
  long i_34 = 0;
  float f6_scaleFactor = 0;
  long I_35 = 0;
  float f_36 = 0;
  float f_37 = 0;
  long I_38 = 0;
  float f_39 = 0;
  float f_40 = 0;
  float f6_glyphWidth = 0;
  long i9_i = 0;
  long i_41 = 0;
  long i10_codepoint = 0;
  long i_42 = 0;
  long I_43 = 0;
  long U_44 = 0;
  long U_45 = 0;
  long i10_codepointIndex = 0;
  long i_46 = 0;
  long I_47 = 0;
  long I_48 = 0;
  long I_49 = 0;
  long I_50 = 0;
  long i_51 = 0;
  long I_52 = 0;
  long I_53 = 0;
  long I_54 = 0;
  float f_55 = 0;
  float f_56 = 0;
  long i_57 = 0;
  float f_58 = 0;
  long I_59 = 0;
  float f_60 = 0;
  long I_61 = 0;
  long I_62 = 0;
  long I_63 = 0;
  float f_64 = 0;
  float f_65 = 0;
  long i_66 = 0;
  float f_67 = 0;
  long I_68 = 0;
  float f_69 = 0;
  float f_70 = 0;
  float f_71 = 0;
  long i_72 = 0;
  long i_73 = 0;
  long i_74 = 0;
  long i_75 = 0;
  float f_76 = 0;
  float f_77 = 0;
  float f_78 = 0;
  long i_79 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(32L);
  f_0 = (float) 0L;
  mir_write_float(fp, f_0);
  I_2 = (long) fp + (long) 4L;
  I_1 = memset((long) I_2, (int) 0L, (long) 20L);
  i0_textIconOffset = 0L;
  if ((long) U0_text == (long) 0L) { mir_label = 1908; break; }
case 1909:
  i_4 = 0L;
  if ((int) mir_read_byte(U0_text + i_4) == (int) 0L) { mir_label = 1908; break; }
case 1910:
  i_6 = 0L;
  if ((int) mir_read_byte(U0_text + i_6) != (int) 35L) { mir_label = 1911; break; }
case 1912:
  i3_i = 1L;
  I_8 = (long) (int) i3_i;
  if ((int) mir_read_byte(U0_text + I_8) == (int) 0L) { mir_label = 1913; break; }
case 1914:
  if ((int) i3_i >= (int) 5L) { mir_label = 1913; break; }
case 1915:
  I_11 = (long) (int) i3_i;
  if ((int) mir_read_byte(U0_text + I_11) != (int) 35L) { mir_label = 1916; break; }
case 1917:
  i0_textIconOffset = i3_i;
  mir_label = 1913; break;
  // Dead code: mir_label = 1918; break;
case 1916:
case 1918:
case 1919:
  i_13 = i3_i;
  i_13 = (int) i_13 + (int) 1L;
  i3_i = i_13;
  I_14 = (long) (int) i3_i;
  if ((int) mir_read_byte(U0_text + I_14) == (int) 0L) { mir_label = 1913; break; }
case 1920:
  if ((int) i3_i < (int) 5L) { mir_label = 1915; break; }
case 1913:
  mir_label = 1921; break;
case 1911:
case 1921:
  U_17 = (long) (int) i0_textIconOffset;
  U_18 = U0_text;
  U_19 = (long) U_17 * (long) 1L;
  U_18 = (long) U_18 + (long) U_19;
  U0_text = U_18;
  i_21 = GuiGetStyle((int) 0L, (int) 16L);
  I_23 = (long) (int) i_21;
  f_22 = (float) I_23;
  f1_fontSize = f_22;
  I_24 = m2_guiFont;
  if (Integer.compareUnsigned((int) mir_read_uint(8L + I_24), (int) 0L) <= 0) { mir_label = 1922; break; }
case 1923:
  if ((long) U0_text == (long) 0L) { mir_label = 1922; break; }
case 1924:
  i6_size = 0L;
  i7_i = 0L;
  if ((int) i7_i >= (int) 256L) { mir_label = 1925; break; }
case 1926:
  I_28 = (long) (int) i7_i;
  if ((int) mir_read_byte(U0_text + I_28) == (int) 0L) { mir_label = 1927; break; }
case 1928:
  I_30 = (long) (int) i7_i;
  if ((int) mir_read_byte(U0_text + I_30) == (int) 10L) { mir_label = 1927; break; }
case 1929:
  i_32 = i6_size;
  i_32 = (int) i_32 + (int) 1L;
  i6_size = i_32;
  mir_label = 1930; break;
case 1927:
  mir_label = 1925; break;
case 1930:
case 1931:
  i_33 = i7_i;
  i_33 = (int) i_33 + (int) 1L;
  i7_i = i_33;
  if ((int) i7_i < (int) 256L) { mir_label = 1926; break; }
case 1925:
  I_35 = m2_guiFont;
  f_36 = (float) mir_read_int(I_35);
  f_37 = f1_fontSize / f_36;
  f6_scaleFactor = f_37;
  I_38 = m2_guiFont;
  f_39 = (float) mir_read_int(I_38);
  f_40 = f_39 * f6_scaleFactor;
  mir_write_float(4L + fp, f_40);
  f6_glyphWidth = 0f;
  i9_i = 0L;
  mir_write_int(24L + fp, 0L);
  if ((int) i9_i >= (int) i6_size) { mir_label = 1932; break; }
case 1933:
  I_43 = (long) (int) i9_i;
  U_44 = (long) I_43 * (long) 1L;
  U_44 = (long) U_44 + (long) U0_text;
  U_45 = 24L;
  U_45 = (long) U_45 + (long) fp;
  i_42 = m2_GetCodepointNext((long) U_44, (long) U_45);
  i10_codepoint = i_42;
  I_47 = m2_guiFont;
  i_46 = GetGlyphIndex((long) I_47, (int) i10_codepoint);
  i10_codepointIndex = i_46;
  I_48 = m2_guiFont;
  I_49 = (long) (int) i10_codepointIndex;
  I_50 = mir_read_ulong(40L + I_48);
  if ((int) mir_read_int(12L + I_50 + I_49 * 40) != (int) 0L) { mir_label = 1934; break; }
case 1935:
  I_52 = m2_guiFont;
  I_53 = (long) (int) i10_codepointIndex;
  I_54 = mir_read_ulong(32L + I_52);
  f_55 = mir_read_float(8L + I_54 + I_53 * 20);
  f_56 = f_55 * f6_scaleFactor;
  i_57 = GuiGetStyle((int) 0L, (int) 17L);
  I_59 = (long) (int) i_57;
  f_58 = (float) I_59;
  f_60 = f_56 + f_58;
  f6_glyphWidth = f_60;
  mir_label = 1936; break;
case 1934:
  I_61 = m2_guiFont;
  I_62 = (long) (int) i10_codepointIndex;
  I_63 = mir_read_ulong(40L + I_61);
  f_64 = (float) mir_read_int(12L + I_63 + I_62 * 40);
  f_65 = f_64 * f6_scaleFactor;
  i_66 = GuiGetStyle((int) 0L, (int) 17L);
  I_68 = (long) (int) i_66;
  f_67 = (float) I_68;
  f_69 = f_65 + f_67;
  f6_glyphWidth = f_69;
case 1936:
  f_70 = mir_read_float(fp);
  f_70 = f_70 + f6_glyphWidth;
  mir_write_float(fp, f_70);
case 1937:
  i_72 = i9_i;
  i_72 = (int) i_72 + (int) mir_read_int(24L + fp);
  i9_i = i_72;
  if ((int) i9_i < (int) i6_size) { mir_label = 1933; break; }
case 1932:
  mir_label = 1938; break;
case 1922:
case 1938:
  if ((int) i0_textIconOffset <= (int) 0L) { mir_label = 1939; break; }
case 1940:
  f_76 = (float) 12L;
  f_77 = mir_read_float(fp);
  f_77 = f_77 + f_76;
  mir_write_float(fp, f_77);
  mir_label = 1941; break;
case 1939:
case 1941:
  mir_label = 1942; break;
case 1908:
case 1942:
  i_79 = (long) mir_read_float(fp);
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i_79;
} // End of switch
} // End of while
} // End of function GetTextWidth

protected void m2_GetTextBounds (long _Ret_Addr, int _i0_control, long _I0_bounds) {
  long Ret_Addr = _Ret_Addr;
  long i0_control = _i0_control;
  long I0_bounds = _I0_bounds;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long i_3 = 0;
  float f_4 = 0;
  long I_5 = 0;
  float f_6 = 0;
  long i_7 = 0;
  float f_8 = 0;
  long I_9 = 0;
  float f_10 = 0;
  long i_11 = 0;
  long i_12 = 0;
  float f_13 = 0;
  long I_14 = 0;
  float f_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  float f_18 = 0;
  long I_19 = 0;
  float f_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  float f_23 = 0;
  long I_24 = 0;
  float f_25 = 0;
  long i_26 = 0;
  long i_27 = 0;
  long i_28 = 0;
  float f_29 = 0;
  long I_30 = 0;
  float f_31 = 0;
  float f_32 = 0;
  long i_33 = 0;
  long i_34 = 0;
  long i_35 = 0;
  float f_36 = 0;
  long I_37 = 0;
  float f_38 = 0;
  float f_39 = 0;
  long i_40 = 0;
  float f_41 = 0;
  long I_42 = 0;
  float f_43 = 0;
  float f_44 = 0;
  long i_45 = 0;
  long i_46 = 0;
  float f_47 = 0;
  long I_48 = 0;
  float f_49 = 0;
  float f_50 = 0;
  long I_51 = 0;
  long I_52 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(48L);
  I_0 = memcpy((long) fp, (long) I0_bounds, (long) 20L);
  I_2 = (long) fp + (long) 20L;
  I_1 = memcpy((long) I_2, (long) fp, (long) 20L);
  i_3 = GuiGetStyle((int) i0_control, (int) 12L);
  I_5 = (long) (int) i_3;
  f_4 = (float) I_5;
  f_6 = mir_read_float(fp) + f_4;
  mir_write_float(20L + fp, f_6);
  i_7 = GuiGetStyle((int) i0_control, (int) 12L);
  I_9 = (long) (int) i_7;
  f_8 = (float) I_9;
  f_10 = mir_read_float(4L + fp) + f_8;
  mir_write_float(24L + fp, f_10);
  i_11 = GuiGetStyle((int) i0_control, (int) 12L);
  i_12 = (int) 2L * (int) i_11;
  I_14 = (long) (int) i_12;
  f_13 = (float) I_14;
  f_15 = mir_read_float(8L + fp) - f_13;
  i_16 = GuiGetStyle((int) i0_control, (int) 13L);
  i_17 = (int) 2L * (int) i_16;
  I_19 = (long) (int) i_17;
  f_18 = (float) I_19;
  f_20 = f_15 - f_18;
  mir_write_float(28L + fp, f_20);
  i_21 = GuiGetStyle((int) i0_control, (int) 12L);
  i_22 = (int) 2L * (int) i_21;
  I_24 = (long) (int) i_22;
  f_23 = (float) I_24;
  f_25 = mir_read_float(12L + fp) - f_23;
  mir_write_float(32L + fp, f_25);
  if ((int) i0_control == (int) 7L) { mir_label = 1943; break; }
  if ((int) i0_control == (int) 10L) { mir_label = 1944; break; }
  mir_label = 1945; break;
case 1943:
  i_26 = GuiGetStyle((int) i0_control, (int) 16L);
  i_27 = GuiGetStyle((int) i0_control, (int) 17L);
  i_28 = (int) i_26 + (int) i_27;
  I_30 = (long) (int) i_28;
  f_29 = (float) I_30;
  f_31 = mir_read_float(8L + fp);
  f_31 = f_31 - f_29;
  mir_write_float(8L + fp, f_31);
  mir_label = 1946; break;
case 1944:
  mir_label = 1946; break;
case 1945:
  i_33 = GuiGetStyle((int) i0_control, (int) 14L);
  if ((int) i_33 != (int) 2L) { mir_label = 1947; break; }
case 1948:
  i_35 = GuiGetStyle((int) i0_control, (int) 13L);
  I_37 = (long) (int) i_35;
  f_36 = (float) I_37;
  f_38 = mir_read_float(20L + fp);
  f_38 = f_38 - f_36;
  mir_write_float(20L + fp, f_38);
  mir_label = 1949; break;
case 1947:
  i_40 = GuiGetStyle((int) i0_control, (int) 13L);
  I_42 = (long) (int) i_40;
  f_41 = (float) I_42;
  f_43 = mir_read_float(20L + fp);
  f_43 = f_43 + f_41;
  mir_write_float(20L + fp, f_43);
case 1949:
  i_45 = GuiGetStyle((int) i0_control, (int) 13L);
  i_46 = (int) 2L * (int) i_45;
  I_48 = (long) (int) i_46;
  f_47 = (float) I_48;
  f_49 = mir_read_float(28L + fp);
  f_49 = f_49 - f_47;
  mir_write_float(28L + fp, f_49);
case 1946:
  I_52 = (long) fp + (long) 20L;
  I_51 = memcpy((long) Ret_Addr, (long) I_52, (long) 20L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GetTextBounds

protected long m2_GetTextIcon (long _U0_text, long _U0_iconId) {
  long U0_text = _U0_text;
  long U0_iconId = _U0_iconId;
  long fp = 0;
  long i_0 = 0;
  long i_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long i1_pos = 0;
  long i_5 = 0;
  long I_6 = 0;
  long i_7 = 0;
  long I_8 = 0;
  long i_9 = 0;
  long i_10 = 0;
  long I_11 = 0;
  long I_12 = 0;
  long I_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long I_16 = 0;
  long i_17 = 0;
  long I_18 = 0;
  long i_19 = 0;
  long I_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long U_25 = 0;
  long U_26 = 0;
  long U_27 = 0;
  long U_28 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  mir_write_int(U0_iconId, -1L);
  i_0 = 0L;
  if ((int) mir_read_byte(U0_text + i_0) != (int) 35L) { mir_label = 1950; break; }
case 1951:
  I_2 = (long) (byte) 0L;
  mir_write_byte(fp, I_2);
  I_4 = (long) fp + (long) 1L;
  I_3 = memset((long) I_4, (int) 0L, (long) 3L);
  i1_pos = 1L;
case 1952:
  if ((int) i1_pos >= (int) 4L) { mir_label = 1953; break; }
case 1954:
  I_6 = (long) (int) i1_pos;
  if ((int) mir_read_byte(U0_text + I_6) < (int) 48L) { mir_label = 1953; break; }
case 1955:
  I_8 = (long) (int) i1_pos;
  if ((int) mir_read_byte(U0_text + I_8) > (int) 57L) { mir_label = 1953; break; }
case 1956:
  i_10 = (int) i1_pos - (int) 1L;
  I_11 = (long) (int) i_10;
  I_12 = (long) (int) i1_pos;
  I_13 = (long) (byte) mir_read_byte(U0_text + I_12);
  mir_write_byte(fp + I_11, I_13);
  i_14 = i1_pos;
  i_14 = (int) i_14 + (int) 1L;
  i1_pos = i_14;
  if ((int) i1_pos >= (int) 4L) { mir_label = 1953; break; }
case 1957:
  I_16 = (long) (int) i1_pos;
  if ((int) mir_read_byte(U0_text + I_16) < (int) 48L) { mir_label = 1953; break; }
case 1958:
  I_18 = (long) (int) i1_pos;
  if ((int) mir_read_byte(U0_text + I_18) <= (int) 57L) { mir_label = 1956; break; }
case 1953:
  I_20 = (long) (int) i1_pos;
  if ((int) mir_read_byte(U0_text + I_20) != (int) 35L) { mir_label = 1959; break; }
case 1960:
  i_22 = m2_TextToInteger((long) fp);
  mir_write_int(U0_iconId, i_22);
  if ((int) mir_read_int(U0_iconId) < (int) 0L) { mir_label = 1961; break; }
case 1962:
  i_24 = (int) i1_pos + (int) 1L;
  U_25 = (long) (int) i_24;
  U_26 = U0_text;
  U_27 = (long) U_25 * (long) 1L;
  U_26 = (long) U_26 + (long) U_27;
  U0_text = U_26;
  mir_label = 1963; break;
case 1961:
case 1963:
  mir_label = 1964; break;
case 1959:
case 1964:
  mir_label = 1965; break;
case 1950:
case 1965:
  mir_set_stack_position(mir_saved_stack_position);
  return (long) U0_text;
} // End of switch
} // End of while
} // End of function GetTextIcon

public long GetTextLines (long _U0_text, long _U0_count) {
  long U0_text = _U0_text;
  long U0_count = _U0_count;
  long fp = 0;
  long U_0 = 0;
  long I_1 = 0;
  long i0_textLen = 0;
  long U_2 = 0;
  long I_3 = 0;
  long i_4 = 0;
  long i0_len = 0;
  long i0_lineSize = 0;
  long i1_i = 0;
  long i1_k = 0;
  long i_5 = 0;
  long i_6 = 0;
  long I_7 = 0;
  long i_8 = 0;
  long i_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  long i_12 = 0;
  long I_13 = 0;
  long U_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long i_18 = 0;
  long i_19 = 0;
  long i_20 = 0;
  long I_21 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(1024L);
  I_1 = m2_S0_GetTextLines_lines;
  U_0 = memset((long) I_1, (int) 0L, (long) 8L);
  U_2 = strlen((long) U0_text);
  i0_textLen = U_2;
  I_3 = m2_S0_GetTextLines_lines;
  i_4 = 0L;
  mir_write_ulong(I_3 + i_4 * 8, U0_text);
  i0_len = 0L;
  mir_write_int(U0_count, 1L);
  i0_lineSize = 0L;
  i1_i = 0L;
  i1_k = 0L;
  if ((int) i1_i >= (int) i0_textLen) { mir_label = 1966; break; }
case 1967:
  if ((int) mir_read_int(U0_count) >= (int) 128L) { mir_label = 1966; break; }
case 1968:
  I_7 = (long) (int) i1_i;
  if ((int) mir_read_byte(U0_text + I_7) != (int) 10L) { mir_label = 1969; break; }
case 1970:
  i0_lineSize = i0_len;
  i_9 = i1_k;
  i_9 = (int) i_9 + (int) 1L;
  i1_k = i_9;
  I_10 = m2_S0_GetTextLines_lines;
  I_11 = (long) (int) i1_k;
  i_12 = (int) i1_i + (int) 1L;
  I_13 = (long) (int) i_12;
  U_14 = (long) I_13 * (long) 1L;
  U_14 = (long) U_14 + (long) U0_text;
  mir_write_ulong(I_10 + I_11 * 8, U_14);
  i0_len = 0L;
  i_15 = mir_read_int(U0_count);
  i_15 = (int) i_15 + (int) 1L;
  mir_write_int(U0_count, i_15);
  mir_label = 1971; break;
case 1969:
  i_17 = i0_len;
  i_17 = (int) i_17 + (int) 1L;
  i0_len = i_17;
case 1971:
case 1972:
  i_18 = i1_i;
  i_18 = (int) i_18 + (int) 1L;
  i1_i = i_18;
  if ((int) i1_i >= (int) i0_textLen) { mir_label = 1966; break; }
case 1973:
  if ((int) mir_read_int(U0_count) < (int) 128L) { mir_label = 1968; break; }
case 1966:
  I_21 = m2_S0_GetTextLines_lines;
  mir_set_stack_position(mir_saved_stack_position);
  return (long) I_21;
} // End of switch
} // End of while
} // End of function GetTextLines

long m2_S0_GetTextLines_lines = mir_set_data_ulong(0L);
long unused_data_addr_2075 = mir_allocate(1016);
protected void m2_GuiDrawText (long _U0_text, long _I0_bounds, int _i0_alignment, long _I0_tint) {
  long U0_text = _U0_text;
  long I0_bounds = _I0_bounds;
  long i0_alignment = _i0_alignment;
  long I0_tint = _I0_tint;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long i_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long U1_lines = 0;
  long U_6 = 0;
  long U_7 = 0;
  long U_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  long I_12 = 0;
  float f1_totalHeight = 0;
  long i_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long i_18 = 0;
  long i_19 = 0;
  float f_20 = 0;
  long I_21 = 0;
  float f1_posOffsetY = 0;
  float f_22 = 0;
  long i2_i = 0;
  long i_23 = 0;
  long I_24 = 0;
  long U_25 = 0;
  long I_26 = 0;
  long U_27 = 0;
  long U_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  long i3_textSizeX = 0;
  long i_31 = 0;
  long I_32 = 0;
  long i_33 = 0;
  long I_34 = 0;
  long u_35 = 0;
  long u_36 = 0;
  long i_37 = 0;
  long I_38 = 0;
  long i_39 = 0;
  long I_40 = 0;
  long i_41 = 0;
  long I_42 = 0;
  long i_43 = 0;
  long i_44 = 0;
  long i_45 = 0;
  float f_46 = 0;
  float f_47 = 0;
  float f_48 = 0;
  float f_49 = 0;
  float f_50 = 0;
  float f_51 = 0;
  float f_52 = 0;
  long i_53 = 0;
  long i_54 = 0;
  float f_55 = 0;
  long I_56 = 0;
  float f_57 = 0;
  float f_58 = 0;
  float f_59 = 0;
  float f_60 = 0;
  long i_61 = 0;
  float f_62 = 0;
  long I_63 = 0;
  float f_64 = 0;
  float f_65 = 0;
  float f_66 = 0;
  float f_67 = 0;
  float f_68 = 0;
  float f_69 = 0;
  float f_70 = 0;
  float f_71 = 0;
  long i_72 = 0;
  long i_73 = 0;
  float f_74 = 0;
  long I_75 = 0;
  float f_76 = 0;
  float f_77 = 0;
  float f_78 = 0;
  long I_79 = 0;
  float f_80 = 0;
  float f_81 = 0;
  float f_82 = 0;
  float f_83 = 0;
  float f_84 = 0;
  float f_85 = 0;
  float f_86 = 0;
  float f_87 = 0;
  long i_88 = 0;
  long i_89 = 0;
  float f_90 = 0;
  long I_91 = 0;
  float f_92 = 0;
  long i_93 = 0;
  float f_94 = 0;
  long I_95 = 0;
  long i_96 = 0;
  float f_97 = 0;
  long I_98 = 0;
  long i_99 = 0;
  long i_100 = 0;
  float f_101 = 0;
  float f_102 = 0;
  float f_103 = 0;
  long I_104 = 0;
  long u_105 = 0;
  long u_106 = 0;
  float f_107 = 0;
  long I_108 = 0;
  float f_109 = 0;
  long i_110 = 0;
  long i_111 = 0;
  float f_112 = 0;
  long I_113 = 0;
  float f_114 = 0;
  long i_115 = 0;
  long I_116 = 0;
  long I_117 = 0;
  long u_118 = 0;
  long u_119 = 0;
  float f_120 = 0;
  long I_121 = 0;
  float f_122 = 0;
  float f_123 = 0;
  long i3_size = 0;
  long i10_c = 0;
  long I_124 = 0;
  long I_125 = 0;
  long I_126 = 0;
  long i_127 = 0;
  long I_128 = 0;
  long I_129 = 0;
  long I_130 = 0;
  long i_131 = 0;
  long i_132 = 0;
  long i_133 = 0;
  long i_134 = 0;
  long I_135 = 0;
  long I_136 = 0;
  long I_137 = 0;
  long i_138 = 0;
  long I_139 = 0;
  long I_140 = 0;
  long I_141 = 0;
  long i_142 = 0;
  float f3_scaleFactor = 0;
  long i_143 = 0;
  float f_144 = 0;
  long I_145 = 0;
  long I_146 = 0;
  float f_147 = 0;
  float f_148 = 0;
  long i3_textOffsetY = 0;
  float f3_textOffsetX = 0;
  long i12_c = 0;
  long i_149 = 0;
  long i13_codepoint = 0;
  long i_150 = 0;
  long I_151 = 0;
  long I_152 = 0;
  long I_153 = 0;
  long U_154 = 0;
  long U_155 = 0;
  long i13_index = 0;
  long i_156 = 0;
  long I_157 = 0;
  long i_158 = 0;
  long i_159 = 0;
  long i_160 = 0;
  long i_161 = 0;
  long i_162 = 0;
  long I_163 = 0;
  float f_164 = 0;
  float f_165 = 0;
  long I_166 = 0;
  float f_167 = 0;
  long I_168 = 0;
  long I_169 = 0;
  long I_170 = 0;
  long i_171 = 0;
  float f_172 = 0;
  long I_173 = 0;
  long I_174 = 0;
  long I_175 = 0;
  long I_176 = 0;
  long i_177 = 0;
  long I_178 = 0;
  long I_179 = 0;
  long I_180 = 0;
  float f_181 = 0;
  float f_182 = 0;
  long i_183 = 0;
  float f_184 = 0;
  long I_185 = 0;
  float f_186 = 0;
  float f_187 = 0;
  float f_188 = 0;
  long I_189 = 0;
  long I_190 = 0;
  long I_191 = 0;
  float f_192 = 0;
  float f_193 = 0;
  long i_194 = 0;
  float f_195 = 0;
  long I_196 = 0;
  float f_197 = 0;
  float f_198 = 0;
  float f_199 = 0;
  long i_200 = 0;
  long i_201 = 0;
  long i_202 = 0;
  long i_203 = 0;
  float f_204 = 0;
  long I_205 = 0;
  float f_206 = 0;
  float f_207 = 0;
  float f_208 = 0;
  long i_209 = 0;
  long i_210 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(144L);
  I_0 = (long) fp + (long) 4L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = 4L;
case 1974:
  I_2 = (long) I_2 - (long) 1L;
  mir_write_byte(fp + I_2, mir_read_byte(I0_tint + I_2));
  if ((long) I_2 > (long) 0L) { mir_label = 1974; break; }
  if ((long) U0_text == (long) 0L) { mir_label = 1975; break; }
case 1976:
  i_4 = 0L;
  if ((int) mir_read_byte(U0_text + i_4) == (int) 0L) { mir_label = 1975; break; }
case 1977:
  mir_write_int(24L + fp, 0L);
  U_7 = U0_text;
  U_8 = 24L;
  U_8 = (long) U_8 + (long) fp;
  U_6 = GetTextLines((long) U_7, (long) U_8);
  U1_lines = U_6;
  I_9 = (long) fp + (long) 112L;
  I_10 = (long) fp + (long) 4L;
  m2_GetTextBounds((long) I_9, (int) 1L, (long) I_10);
  I_12 = (long) fp + (long) 28L;
  I_11 = memcpy((long) I_12, (long) I_9, (long) 20L);
  i_13 = GuiGetStyle((int) 0L, (int) 16L);
  i_14 = (int) mir_read_int(24L + fp) * (int) i_13;
  i_15 = (int) mir_read_int(24L + fp) - (int) 1L;
  i_16 = GuiGetStyle((int) 0L, (int) 16L);
  i_17 = (int) i_15 * (int) i_16;
  i_18 = (int) i_17 / (int) 2L;
  i_19 = (int) i_14 + (int) i_18;
  I_21 = (long) (int) i_19;
  f_20 = (float) I_21;
  f1_totalHeight = f_20;
  f_22 = (float) 0L;
  f1_posOffsetY = f_22;
  i2_i = 0L;
  if ((int) i2_i >= (int) mir_read_int(24L + fp)) { mir_label = 1978; break; }
case 1979:
  mir_write_int(48L + fp, 0L);
  I_24 = (long) (int) i2_i;
  I_26 = (long) (int) i2_i;
  U_27 = 48L;
  U_27 = (long) U_27 + (long) fp;
  U_25 = m2_GetTextIcon((long) mir_read_ulong(U1_lines + I_26 * 8), (long) U_27);
  U_28 = U_25;
  mir_write_ulong(U1_lines + I_24 * 8, U_28);
  mir_write_float(56L + fp, mir_read_float(4L + fp));
  mir_write_float(60L + fp, mir_read_float(8L + fp));
  I_30 = (long) fp + (long) 64L;
  I_29 = memset((long) I_30, (int) 0L, (long) 16L);
  I_32 = (long) (int) i2_i;
  i_31 = m2_GetTextWidth((long) mir_read_ulong(U1_lines + I_32 * 8));
  i3_textSizeX = i_31;
  if ((int) mir_read_int(48L + fp) < (int) 0L) { mir_label = 1980; break; }
case 1981:
  I_34 = m2_guiIconScale;
  u_35 = (int) 16L * (int) mir_read_uint(I_34);
  u_36 = i3_textSizeX;
  u_36 = (int) u_36 + (int) u_35;
  i3_textSizeX = u_36;
  I_38 = (long) (int) i2_i;
  if ((long) mir_read_ulong(U1_lines + I_38 * 8) == (long) 0L) { mir_label = 1982; break; }
case 1983:
  I_40 = (long) (int) i2_i;
  i_41 = 0L;
  I_42 = mir_read_ulong(U1_lines + I_40 * 8);
  if ((int) mir_read_byte(I_42 + i_41) == (int) 0L) { mir_label = 1982; break; }
case 1984:
  i_44 = i3_textSizeX;
  i_44 = (int) i_44 + (int) 4L;
  i3_textSizeX = i_44;
  mir_label = 1985; break;
case 1982:
case 1985:
  mir_label = 1986; break;
case 1980:
case 1986:
  if ((int) i0_alignment == (int) 0L) { mir_label = 1987; break; }
  if ((int) i0_alignment == (int) 1L) { mir_label = 1988; break; }
  if ((int) i0_alignment == (int) 2L) { mir_label = 1989; break; }
  mir_label = 1990; break;
case 1987:
  mir_write_float(56L + fp, mir_read_float(4L + fp));
  f_46 = mir_read_float(8L + fp) + f1_posOffsetY;
  f_47 = (float) 2L;
  f_48 = mir_read_float(16L + fp) / f_47;
  f_49 = f_46 + f_48;
  f_50 = (float) 2L;
  f_51 = f1_totalHeight / f_50;
  f_52 = f_49 - f_51;
  i_53 = (long) mir_read_float(16L + fp);
  i_54 = (int) i_53 % (int) 2L;
  I_56 = (long) (int) i_54;
  f_55 = (float) I_56;
  f_57 = f_52 + f_55;
  mir_write_float(60L + fp, f_57);
  mir_label = 1991; break;
case 1988:
  f_58 = (float) 2L;
  f_59 = mir_read_float(12L + fp) / f_58;
  f_60 = mir_read_float(4L + fp) + f_59;
  i_61 = (int) i3_textSizeX / (int) 2L;
  I_63 = (long) (int) i_61;
  f_62 = (float) I_63;
  f_64 = f_60 - f_62;
  mir_write_float(56L + fp, f_64);
  f_65 = mir_read_float(8L + fp) + f1_posOffsetY;
  f_66 = (float) 2L;
  f_67 = mir_read_float(16L + fp) / f_66;
  f_68 = f_65 + f_67;
  f_69 = (float) 2L;
  f_70 = f1_totalHeight / f_69;
  f_71 = f_68 - f_70;
  i_72 = (long) mir_read_float(16L + fp);
  i_73 = (int) i_72 % (int) 2L;
  I_75 = (long) (int) i_73;
  f_74 = (float) I_75;
  f_76 = f_71 + f_74;
  mir_write_float(60L + fp, f_76);
  mir_label = 1991; break;
case 1989:
  f_77 = mir_read_float(4L + fp) + mir_read_float(12L + fp);
  I_79 = (long) (int) i3_textSizeX;
  f_78 = (float) I_79;
  f_80 = f_77 - f_78;
  mir_write_float(56L + fp, f_80);
  f_81 = mir_read_float(8L + fp) + f1_posOffsetY;
  f_82 = (float) 2L;
  f_83 = mir_read_float(16L + fp) / f_82;
  f_84 = f_81 + f_83;
  f_85 = (float) 2L;
  f_86 = f1_totalHeight / f_85;
  f_87 = f_84 - f_86;
  i_88 = (long) mir_read_float(16L + fp);
  i_89 = (int) i_88 % (int) 2L;
  I_91 = (long) (int) i_89;
  f_90 = (float) I_91;
  f_92 = f_87 + f_90;
  mir_write_float(60L + fp, f_92);
  mir_label = 1991; break;
case 1990:
case 1991:
  i_93 = (long) mir_read_float(56L + fp);
  I_95 = (long) (int) i_93;
  f_94 = (float) I_95;
  mir_write_float(56L + fp, f_94);
  i_96 = (long) mir_read_float(60L + fp);
  I_98 = (long) (int) i_96;
  f_97 = (float) I_98;
  mir_write_float(60L + fp, f_97);
  if ((int) mir_read_int(48L + fp) < (int) 0L) { mir_label = 1992; break; }
case 1993:
  i_100 = (long) mir_read_float(56L + fp);
  f_101 = (float) 2L;
  f_102 = mir_read_float(16L + fp) / f_101;
  f_103 = mir_read_float(8L + fp) + f_102;
  I_104 = m2_guiIconScale;
  u_105 = (int) 16L * (int) mir_read_uint(I_104);
  u_106 = (long) Integer.divideUnsigned((int) u_105, (int) 2L);
  I_108 = (((long) u_106) & 0xFFFFFFFFL);
  f_107 = (float) (long) I_108;
  f_109 = f_103 - f_107;
  i_110 = (long) mir_read_float(16L + fp);
  i_111 = (int) i_110 % (int) 2L;
  I_113 = (long) (int) i_111;
  f_112 = (float) I_113;
  f_114 = f_109 + f_112;
  i_115 = (long) f_114;
  I_116 = m2_guiIconScale;
  GuiDrawIcon((int) mir_read_int(48L + fp), (int) i_100, (int) i_115, (int) mir_read_uint(I_116), (long) fp);
  I_117 = m2_guiIconScale;
  u_118 = (int) 16L * (int) mir_read_uint(I_117);
  u_119 = (int) u_118 + (int) 4L;
  I_121 = (((long) u_119) & 0xFFFFFFFFL);
  f_120 = (float) (long) I_121;
  f_122 = mir_read_float(56L + fp);
  f_122 = f_122 + f_120;
  mir_write_float(56L + fp, f_122);
  mir_label = 1994; break;
case 1992:
case 1994:
  i3_size = 0L;
  i10_c = 0L;
  I_124 = (long) (int) i2_i;
  I_125 = (long) (int) i10_c;
  I_126 = mir_read_ulong(U1_lines + I_124 * 8);
  if ((int) mir_read_byte(I_126 + I_125) == (int) 0L) { mir_label = 1995; break; }
case 1996:
  I_128 = (long) (int) i2_i;
  I_129 = (long) (int) i10_c;
  I_130 = mir_read_ulong(U1_lines + I_128 * 8);
  if ((int) mir_read_byte(I_130 + I_129) == (int) 10L) { mir_label = 1995; break; }
case 1997:
case 1998:
  i_132 = i10_c;
  i_132 = (int) i_132 + (int) 1L;
  i10_c = i_132;
  i_133 = i3_size;
  i_134 = i3_size;
  i_134 = (int) i_134 + (int) 1L;
  i3_size = i_134;
  I_135 = (long) (int) i2_i;
  I_136 = (long) (int) i10_c;
  I_137 = mir_read_ulong(U1_lines + I_135 * 8);
  if ((int) mir_read_byte(I_137 + I_136) == (int) 0L) { mir_label = 1995; break; }
case 1999:
  I_139 = (long) (int) i2_i;
  I_140 = (long) (int) i10_c;
  I_141 = mir_read_ulong(U1_lines + I_139 * 8);
  if ((int) mir_read_byte(I_141 + I_140) != (int) 10L) { mir_label = 1997; break; }
case 1995:
  i_143 = GuiGetStyle((int) 0L, (int) 16L);
  I_145 = (long) (int) i_143;
  f_144 = (float) I_145;
  I_146 = m2_guiFont;
  f_147 = (float) mir_read_int(I_146);
  f_148 = f_144 / f_147;
  f3_scaleFactor = f_148;
  i3_textOffsetY = 0L;
  f3_textOffsetX = 0f;
  i12_c = 0L;
  mir_write_int(80L + fp, 0L);
  if ((int) i12_c >= (int) i3_size) { mir_label = 2000; break; }
case 2001:
  I_151 = (long) (int) i2_i;
  I_152 = (long) (int) i12_c;
  I_153 = mir_read_ulong(U1_lines + I_151 * 8);
  U_154 = (long) I_152 * (long) 1L;
  U_154 = (long) U_154 + (long) I_153;
  U_155 = 80L;
  U_155 = (long) U_155 + (long) fp;
  i_150 = m2_GetCodepointNext((long) U_154, (long) U_155);
  i13_codepoint = i_150;
  I_157 = m2_guiFont;
  i_156 = GetGlyphIndex((long) I_157, (int) i13_codepoint);
  i13_index = i_156;
  if ((int) i13_codepoint != (int) 63L) { mir_label = 2002; break; }
case 2003:
  mir_write_int(80L + fp, 1L);
  mir_label = 2004; break;
case 2002:
case 2004:
  if ((int) i13_codepoint != (int) 10L) { mir_label = 2005; break; }
case 2006:
  mir_label = 2000; break;
  // Dead code: mir_label = 2007; break;
case 2005:
  if ((int) i13_codepoint == (int) 32L) { mir_label = 2008; break; }
case 2009:
  if ((int) i13_codepoint == (int) 9L) { mir_label = 2008; break; }
case 2010:
  if (f3_textOffsetX < mir_read_float(12L + fp)) { mir_label = 2011; break; }
  mir_label = 2012; break;
case 2011:
  I_163 = m2_guiFont;
  f_164 = mir_read_float(56L + fp) + f3_textOffsetX;
  mir_write_float(88L + fp, f_164);
  I_166 = (long) (int) i3_textOffsetY;
  f_165 = (float) I_166;
  f_167 = mir_read_float(60L + fp) + f_165;
  mir_write_float(92L + fp, f_167);
  I_169 = (long) fp + (long) 96L;
  I_168 = memset((long) I_169, (int) 0L, (long) 16L);
  I_170 = (long) fp + (long) 88L;
  i_171 = GuiGetStyle((int) 0L, (int) 16L);
  I_173 = (long) (int) i_171;
  f_172 = (float) I_173;
  DrawTextCodepoint((long) I_163, (int) i13_codepoint, (long) I_170, (float) f_172, (long) fp);
  mir_label = 2013; break;
case 2012:
case 2013:
  mir_label = 2014; break;
case 2008:
case 2014:
  I_174 = m2_guiFont;
  I_175 = (long) (int) i13_index;
  I_176 = mir_read_ulong(40L + I_174);
  if ((int) mir_read_int(12L + I_176 + I_175 * 40) != (int) 0L) { mir_label = 2015; break; }
case 2016:
  I_178 = m2_guiFont;
  I_179 = (long) (int) i13_index;
  I_180 = mir_read_ulong(32L + I_178);
  f_181 = mir_read_float(8L + I_180 + I_179 * 20);
  f_182 = f_181 * f3_scaleFactor;
  i_183 = GuiGetStyle((int) 0L, (int) 17L);
  I_185 = (long) (int) i_183;
  f_184 = (float) I_185;
  f_186 = f_182 + f_184;
  f_187 = f3_textOffsetX;
  f_187 = f_187 + f_186;
  f3_textOffsetX = f_187;
  mir_label = 2017; break;
case 2015:
  I_189 = m2_guiFont;
  I_190 = (long) (int) i13_index;
  I_191 = mir_read_ulong(40L + I_189);
  f_192 = (float) mir_read_int(12L + I_191 + I_190 * 40);
  f_193 = f_192 * f3_scaleFactor;
  i_194 = GuiGetStyle((int) 0L, (int) 17L);
  I_196 = (long) (int) i_194;
  f_195 = (float) I_196;
  f_197 = f_193 + f_195;
  f_198 = f3_textOffsetX;
  f_198 = f_198 + f_197;
  f3_textOffsetX = f_198;
case 2017:
case 2007:
case 2018:
  i_200 = i12_c;
  i_200 = (int) i_200 + (int) mir_read_int(80L + fp);
  i12_c = i_200;
  if ((int) i12_c < (int) i3_size) { mir_label = 2001; break; }
case 2000:
  i_203 = GuiGetStyle((int) 0L, (int) 16L);
  I_205 = (long) (int) i_203;
  f_204 = (float) I_205;
  f_206 = f_204 * 1.5f;
  f_207 = f1_posOffsetY;
  f_207 = f_207 + f_206;
  f1_posOffsetY = f_207;
case 2019:
  i_209 = i2_i;
  i_209 = (int) i_209 + (int) 1L;
  i2_i = i_209;
  if ((int) i2_i < (int) mir_read_int(24L + fp)) { mir_label = 1979; break; }
case 1978:
  mir_label = 2020; break;
case 1975:
case 2020:
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiDrawText

protected void m2_GuiDrawRectangle (long _I0_rec, int _i0_borderWidth, long _I0_borderColor, long _I0_color) {
  long I0_rec = _I0_rec;
  long i0_borderWidth = _i0_borderWidth;
  long I0_borderColor = _I0_borderColor;
  long I0_color = _I0_color;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long i_8 = 0;
  long I_9 = 0;
  long i_10 = 0;
  long i_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long i_18 = 0;
  long i_19 = 0;
  long i_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long i_25 = 0;
  long i_26 = 0;
  long i_27 = 0;
  long i_28 = 0;
  long i_29 = 0;
  long i_30 = 0;
  long i_31 = 0;
  long i_32 = 0;
  long i_33 = 0;
  long i_34 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(32L);
  I_0 = (long) fp + (long) 8L;
  I_1 = memcpy((long) I_0, (long) I0_rec, (long) 20L);
  I_2 = 4L;
case 2021:
  I_2 = (long) I_2 - (long) 1L;
  mir_write_byte(fp + I_2, mir_read_byte(I0_borderColor + I_2));
  if ((long) I_2 > (long) 0L) { mir_label = 2021; break; }
  I_3 = 4L;
case 2022:
  I_3 = (long) I_3 - (long) 1L;
  mir_write_byte(4L + fp + I_3, mir_read_byte(I0_color + I_3));
  if ((long) I_3 > (long) 0L) { mir_label = 2022; break; }
  if ((int) mir_read_ubyte(7L + fp) <= (int) 0L) { mir_label = 2023; break; }
case 2024:
  i_5 = (long) mir_read_float(8L + fp);
  i_6 = (long) mir_read_float(12L + fp);
  i_7 = (long) mir_read_float(16L + fp);
  i_8 = (long) mir_read_float(20L + fp);
  I_9 = (long) fp + (long) 4L;
  DrawRectangle((int) i_5, (int) i_6, (int) i_7, (int) i_8, (long) I_9);
  mir_label = 2025; break;
case 2023:
case 2025:
  if ((int) i0_borderWidth <= (int) 0L) { mir_label = 2026; break; }
case 2027:
  i_11 = (long) mir_read_float(8L + fp);
  i_12 = (long) mir_read_float(12L + fp);
  i_13 = (long) mir_read_float(16L + fp);
  DrawRectangle((int) i_11, (int) i_12, (int) i_13, (int) i0_borderWidth, (long) fp);
  i_14 = (long) mir_read_float(8L + fp);
  i_15 = (long) mir_read_float(12L + fp);
  i_16 = (int) i_15 + (int) i0_borderWidth;
  i_17 = (long) mir_read_float(20L + fp);
  i_18 = (int) 2L * (int) i0_borderWidth;
  i_19 = (int) i_17 - (int) i_18;
  DrawRectangle((int) i_14, (int) i_16, (int) i0_borderWidth, (int) i_19, (long) fp);
  i_20 = (long) mir_read_float(8L + fp);
  i_21 = (long) mir_read_float(16L + fp);
  i_22 = (int) i_20 + (int) i_21;
  i_23 = (int) i_22 - (int) i0_borderWidth;
  i_24 = (long) mir_read_float(12L + fp);
  i_25 = (int) i_24 + (int) i0_borderWidth;
  i_26 = (long) mir_read_float(20L + fp);
  i_27 = (int) 2L * (int) i0_borderWidth;
  i_28 = (int) i_26 - (int) i_27;
  DrawRectangle((int) i_23, (int) i_25, (int) i0_borderWidth, (int) i_28, (long) fp);
  i_29 = (long) mir_read_float(8L + fp);
  i_30 = (long) mir_read_float(12L + fp);
  i_31 = (long) mir_read_float(20L + fp);
  i_32 = (int) i_30 + (int) i_31;
  i_33 = (int) i_32 - (int) i0_borderWidth;
  i_34 = (long) mir_read_float(16L + fp);
  DrawRectangle((int) i_29, (int) i_33, (int) i_34, (int) i0_borderWidth, (long) fp);
  mir_label = 2028; break;
case 2026:
case 2028:
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GuiDrawRectangle

protected long m2_GuiTextSplit (long _U0_text, byte _i0_delimiter, long _U0_count, long _U0_textRow) {
  long U0_text = _U0_text;
  long i0_delimiter = _i0_delimiter;
  long U0_count = _U0_count;
  long U0_textRow = _U0_textRow;
  long fp = 0;
  long U_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long i_3 = 0;
  long I_4 = 0;
  long i0_counter = 0;
  long i_5 = 0;
  long i_6 = 0;
  long i1_i = 0;
  long i_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  long I_12 = 0;
  long I_13 = 0;
  long i_14 = 0;
  long I_15 = 0;
  long I_16 = 0;
  long i_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  long i_20 = 0;
  long I_21 = 0;
  long I_22 = 0;
  long I_23 = 0;
  long U_24 = 0;
  long U_25 = 0;
  long U_26 = 0;
  long U_27 = 0;
  long i_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  long i_31 = 0;
  long I_32 = 0;
  long i_33 = 0;
  long I_34 = 0;
  long i_35 = 0;
  long I_36 = 0;
  long i_37 = 0;
  long I_38 = 0;
  long I_39 = 0;
  long I_40 = 0;
  long I_41 = 0;
  long i_42 = 0;
  long i_43 = 0;
  long i_44 = 0;
  long i_45 = 0;
  long I_46 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(2048L);
  I_1 = m2_S0_GuiTextSplit_buffer;
  U_0 = memset((long) I_1, (int) 0L, (long) 1024L);
  I_2 = m2_S0_GuiTextSplit_result;
  i_3 = 0L;
  I_4 = m2_S0_GuiTextSplit_buffer;
  mir_write_ulong(I_2 + i_3 * 8, I_4);
  i0_counter = 1L;
  if ((long) U0_textRow == (long) 0L) { mir_label = 2029; break; }
case 2030:
  i_6 = 0L;
  mir_write_int(U0_textRow + i_6 * 4, 0L);
  mir_label = 2031; break;
case 2029:
case 2031:
  i1_i = 0L;
  if ((int) i1_i >= (int) 1024L) { mir_label = 2032; break; }
case 2033:
  I_8 = m2_S0_GuiTextSplit_buffer;
  I_9 = (long) (int) i1_i;
  I_10 = (long) (int) i1_i;
  I_11 = (long) (byte) mir_read_byte(U0_text + I_10);
  mir_write_byte(I_8 + I_9, I_11);
  I_12 = m2_S0_GuiTextSplit_buffer;
  I_13 = (long) (int) i1_i;
  if ((int) mir_read_byte(I_12 + I_13) != (int) 0L) { mir_label = 2034; break; }
case 2035:
  mir_label = 2032; break;
  // Dead code: mir_label = 2036; break;
case 2034:
  I_15 = m2_S0_GuiTextSplit_buffer;
  I_16 = (long) (int) i1_i;
  if ((int) mir_read_byte(I_15 + I_16) == (int) i0_delimiter) { mir_label = 2037; break; }
case 2038:
  I_18 = m2_S0_GuiTextSplit_buffer;
  I_19 = (long) (int) i1_i;
  if ((int) mir_read_byte(I_18 + I_19) != (int) 10L) { mir_label = 2039; break; }
case 2037:
  I_21 = m2_S0_GuiTextSplit_result;
  I_22 = (long) (int) i0_counter;
  I_23 = m2_S0_GuiTextSplit_buffer;
  U_24 = (long) (int) i1_i;
  U_26 = (long) U_24 * (long) 1L;
  U_25 = (long) I_23 + (long) U_26;
  U_27 = (long) U_25 + (long) 1L;
  mir_write_ulong(I_21 + I_22 * 8, U_27);
  if ((long) U0_textRow == (long) 0L) { mir_label = 2040; break; }
case 2041:
  I_29 = m2_S0_GuiTextSplit_buffer;
  I_30 = (long) (int) i1_i;
  if ((int) mir_read_byte(I_29 + I_30) != (int) 10L) { mir_label = 2042; break; }
case 2043:
  I_32 = (long) (int) i0_counter;
  i_33 = (int) i0_counter - (int) 1L;
  I_34 = (long) (int) i_33;
  i_35 = (int) mir_read_int(U0_textRow + I_34 * 4) + (int) 1L;
  mir_write_int(U0_textRow + I_32 * 4, i_35);
  mir_label = 2044; break;
case 2042:
  I_36 = (long) (int) i0_counter;
  i_37 = (int) i0_counter - (int) 1L;
  I_38 = (long) (int) i_37;
  mir_write_int(U0_textRow + I_36 * 4, mir_read_int(U0_textRow + I_38 * 4));
case 2044:
  mir_label = 2045; break;
case 2040:
case 2045:
  I_39 = m2_S0_GuiTextSplit_buffer;
  I_40 = (long) (int) i1_i;
  I_41 = (long) (byte) 0L;
  mir_write_byte(I_39 + I_40, I_41);
  i_42 = i0_counter;
  i_42 = (int) i_42 + (int) 1L;
  i0_counter = i_42;
  if ((int) i0_counter != (int) 128L) { mir_label = 2046; break; }
case 2047:
  mir_label = 2032; break;
  // Dead code: mir_label = 2048; break;
case 2046:
case 2048:
  mir_label = 2049; break;
case 2039:
case 2049:
case 2036:
case 2050:
  i_44 = i1_i;
  i_44 = (int) i_44 + (int) 1L;
  i1_i = i_44;
  if ((int) i1_i < (int) 1024L) { mir_label = 2033; break; }
case 2032:
  mir_write_int(U0_count, i0_counter);
  I_46 = m2_S0_GuiTextSplit_result;
  mir_set_stack_position(mir_saved_stack_position);
  return (long) I_46;
} // End of switch
} // End of while
} // End of function GuiTextSplit

long m2_S0_GuiTextSplit_result = mir_set_data_ulong(0L);
long unused_data_addr_2076 = mir_allocate(1016);
long m2_S0_GuiTextSplit_buffer = mir_set_data_byte(0);
long unused_data_addr_2077 = mir_allocate(1023);
protected void m2_ConvertRGBtoHSV (long _Ret_Addr, long _I0_rgb) {
  long Ret_Addr = _Ret_Addr;
  long I0_rgb = _I0_rgb;
  long fp = 0;
  long I_0 = 0;
  float f_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  float f0_min = 0;
  float f0_max = 0;
  float f0_delta = 0;
  long i_4 = 0;
  float f_5 = 0;
  long i_6 = 0;
  float f_7 = 0;
  long i_8 = 0;
  float f_9 = 0;
  long i_10 = 0;
  float f_11 = 0;
  float f_12 = 0;
  long i_13 = 0;
  long I_14 = 0;
  long I_15 = 0;
  long i_16 = 0;
  float f_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  long i_20 = 0;
  float f_21 = 0;
  float f_22 = 0;
  long i_23 = 0;
  float f_24 = 0;
  float f_25 = 0;
  float f_26 = 0;
  float f_27 = 0;
  float f_28 = 0;
  float f_29 = 0;
  float f_30 = 0;
  float f_31 = 0;
  long i_32 = 0;
  float f_33 = 0;
  float f_34 = 0;
  long I_35 = 0;
  long I_36 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(48L);
  I_0 = memcpy((long) fp, (long) I0_rgb, (long) 24L);
  f_1 = (float) 0L;
  mir_write_float(24L + fp, f_1);
  I_3 = (long) fp + (long) 28L;
  I_2 = memset((long) I_3, (int) 0L, (long) 20L);
  f0_min = 0f;
  f0_max = 0f;
  f0_delta = 0f;
  if (mir_read_float(fp) < mir_read_float(4L + fp)) { mir_label = 2051; break; }
  mir_label = 2052; break;
case 2051:
  f_5 = mir_read_float(fp);
  mir_label = 2053; break;
case 2052:
  f_5 = mir_read_float(4L + fp);
case 2053:
  f0_min = f_5;
  if (f0_min < mir_read_float(8L + fp)) { mir_label = 2054; break; }
  mir_label = 2055; break;
case 2054:
  f_7 = f0_min;
  mir_label = 2056; break;
case 2055:
  f_7 = mir_read_float(8L + fp);
case 2056:
  f0_min = f_7;
  if (mir_read_float(fp) > mir_read_float(4L + fp)) { mir_label = 2057; break; }
  mir_label = 2058; break;
case 2057:
  f_9 = mir_read_float(fp);
  mir_label = 2059; break;
case 2058:
  f_9 = mir_read_float(4L + fp);
case 2059:
  f0_max = f_9;
  if (f0_max > mir_read_float(8L + fp)) { mir_label = 2060; break; }
  mir_label = 2061; break;
case 2060:
  f_11 = f0_max;
  mir_label = 2062; break;
case 2061:
  f_11 = mir_read_float(8L + fp);
case 2062:
  f0_max = f_11;
  mir_write_float(32L + fp, f0_max);
  f_12 = f0_max - f0_min;
  f0_delta = f_12;
  if (f0_delta < 9.99999975e-06f) { mir_label = 2063; break; }
  mir_label = 2064; break;
case 2063:
  mir_write_float(28L + fp, 0f);
  mir_write_float(24L + fp, 0f);
  I_15 = (long) fp + (long) 24L;
  I_14 = memcpy((long) Ret_Addr, (long) I_15, (long) 24L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
  // Dead code: mir_label = 2065; break;
case 2064:
case 2065:
  if (f0_max > 0f) { mir_label = 2066; break; }
  mir_label = 2067; break;
case 2066:
  f_17 = f0_delta / f0_max;
  mir_write_float(28L + fp, f_17);
  mir_label = 2068; break;
case 2067:
  mir_write_float(28L + fp, 0f);
  mir_write_float(24L + fp, 0f);
  I_19 = (long) fp + (long) 24L;
  I_18 = memcpy((long) Ret_Addr, (long) I_19, (long) 24L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
case 2068:
  if (mir_read_float(fp) >= f0_max) { mir_label = 2069; break; }
  mir_label = 2070; break;
case 2069:
  f_21 = mir_read_float(4L + fp) - mir_read_float(8L + fp);
  f_22 = f_21 / f0_delta;
  mir_write_float(24L + fp, f_22);
  mir_label = 2071; break;
case 2070:
  if (mir_read_float(4L + fp) >= f0_max) { mir_label = 2072; break; }
  mir_label = 2073; break;
case 2072:
  f_24 = mir_read_float(8L + fp) - mir_read_float(fp);
  f_25 = f_24 / f0_delta;
  f_26 = 2f + f_25;
  mir_write_float(24L + fp, f_26);
  mir_label = 2074; break;
case 2073:
  f_27 = mir_read_float(fp) - mir_read_float(4L + fp);
  f_28 = f_27 / f0_delta;
  f_29 = 4f + f_28;
  mir_write_float(24L + fp, f_29);
case 2074:
case 2071:
  f_30 = mir_read_float(24L + fp);
  f_30 = f_30 * 60f;
  mir_write_float(24L + fp, f_30);
  if (mir_read_float(24L + fp) < 0f) { mir_label = 2075; break; }
  mir_label = 2076; break;
case 2075:
  f_33 = mir_read_float(24L + fp);
  f_33 = f_33 + 360f;
  mir_write_float(24L + fp, f_33);
  mir_label = 2077; break;
case 2076:
case 2077:
  I_36 = (long) fp + (long) 24L;
  I_35 = memcpy((long) Ret_Addr, (long) I_36, (long) 24L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function ConvertRGBtoHSV

protected void m2_ConvertHSVtoRGB (long _Ret_Addr, long _I0_hsv) {
  long Ret_Addr = _Ret_Addr;
  long I0_hsv = _I0_hsv;
  long fp = 0;
  long I_0 = 0;
  float f_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  float f0_hh = 0;
  float f0_p = 0;
  float f0_q = 0;
  float f0_t = 0;
  float f0_ff = 0;
  long I0_i = 0;
  long i_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long i_7 = 0;
  float f_8 = 0;
  float f_9 = 0;
  long I_10 = 0;
  float f_11 = 0;
  float f_12 = 0;
  float f_13 = 0;
  float f_14 = 0;
  float f_15 = 0;
  float f_16 = 0;
  float f_17 = 0;
  float f_18 = 0;
  float f_19 = 0;
  float f_20 = 0;
  float f_21 = 0;
  long I_22 = 0;
  long I_23 = 0;
  long I_24 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(48L);
  I_0 = memcpy((long) fp, (long) I0_hsv, (long) 24L);
  f_1 = (float) 0L;
  mir_write_float(24L + fp, f_1);
  I_3 = (long) fp + (long) 28L;
  I_2 = memset((long) I_3, (int) 0L, (long) 20L);
  f0_hh = 0f;
  f0_p = 0f;
  f0_q = 0f;
  f0_t = 0f;
  f0_ff = 0f;
  I0_i = 0L;
  if (mir_read_float(4L + fp) <= 0f) { mir_label = 2078; break; }
  mir_label = 2079; break;
case 2078:
  mir_write_float(24L + fp, mir_read_float(8L + fp));
  mir_write_float(28L + fp, mir_read_float(8L + fp));
  mir_write_float(32L + fp, mir_read_float(8L + fp));
  I_6 = (long) fp + (long) 24L;
  I_5 = memcpy((long) Ret_Addr, (long) I_6, (long) 24L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
  // Dead code: mir_label = 2080; break;
case 2079:
case 2080:
  f0_hh = mir_read_float(fp);
  if (f0_hh >= 360f) { mir_label = 2081; break; }
  mir_label = 2082; break;
case 2081:
  f0_hh = 0f;
  mir_label = 2083; break;
case 2082:
case 2083:
  f_8 = f0_hh;
  f_8 = f_8 / 60f;
  f0_hh = f_8;
  I_10 = (long) f0_hh;
  I0_i = I_10;
  f_11 = (float) I0_i;
  f_12 = f0_hh - f_11;
  f0_ff = f_12;
  f_13 = 1f - mir_read_float(4L + fp);
  f_14 = mir_read_float(8L + fp) * f_13;
  f0_p = f_14;
  f_15 = mir_read_float(4L + fp) * f0_ff;
  f_16 = 1f - f_15;
  f_17 = mir_read_float(8L + fp) * f_16;
  f0_q = f_17;
  f_18 = 1f - f0_ff;
  f_19 = mir_read_float(4L + fp) * f_18;
  f_20 = 1f - f_19;
  f_21 = mir_read_float(8L + fp) * f_20;
  f0_t = f_21;
  I_22 = (long) I0_i - (long) 0L;
  if (Long.compareUnsigned((long) I_22, (long) 5L) > 0) { mir_label = 2084; break; }
  switch((int) I_22) {
  case 0: mir_label = 2085; break;
  case 1: mir_label = 2086; break;
  case 2: mir_label = 2087; break;
  case 3: mir_label = 2088; break;
  case 4: mir_label = 2089; break;
  case 5: mir_label = 2084; break;
  }
  break; // End of switch(I_22)
case 2085:
  mir_write_float(24L + fp, mir_read_float(8L + fp));
  mir_write_float(28L + fp, f0_t);
  mir_write_float(32L + fp, f0_p);
  mir_label = 2090; break;
case 2086:
  mir_write_float(24L + fp, f0_q);
  mir_write_float(28L + fp, mir_read_float(8L + fp));
  mir_write_float(32L + fp, f0_p);
  mir_label = 2090; break;
case 2087:
  mir_write_float(24L + fp, f0_p);
  mir_write_float(28L + fp, mir_read_float(8L + fp));
  mir_write_float(32L + fp, f0_t);
  mir_label = 2090; break;
case 2088:
  mir_write_float(24L + fp, f0_p);
  mir_write_float(28L + fp, f0_q);
  mir_write_float(32L + fp, mir_read_float(8L + fp));
  mir_label = 2090; break;
case 2089:
  mir_write_float(24L + fp, f0_t);
  mir_write_float(28L + fp, f0_p);
  mir_write_float(32L + fp, mir_read_float(8L + fp));
  mir_label = 2090; break;
case 2084:
  mir_write_float(24L + fp, mir_read_float(8L + fp));
  mir_write_float(28L + fp, f0_p);
  mir_write_float(32L + fp, f0_q);
case 2090:
  I_24 = (long) fp + (long) 24L;
  I_23 = memcpy((long) Ret_Addr, (long) I_24, (long) 24L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function ConvertHSVtoRGB

protected int m2_GuiScrollBar (long _I0_bounds, int _i0_value, int _i0_minValue, int _i0_maxValue) {
  long I0_bounds = _I0_bounds;
  long i0_value = _i0_value;
  long i0_minValue = _i0_minValue;
  long i0_maxValue = _i0_maxValue;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i0_state = 0;
  long I_2 = 0;
  long i0_isVertical = 0;
  long i_3 = 0;
  long i_4 = 0;
  long i0_spinnerSize = 0;
  long i_5 = 0;
  long I_6 = 0;
  long I_7 = 0;
  long i_8 = 0;
  long i_9 = 0;
  long i_10 = 0;
  long i_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  float f_18 = 0;
  long I_19 = 0;
  long I_20 = 0;
  float f_21 = 0;
  long I_22 = 0;
  long I_23 = 0;
  float f_24 = 0;
  long I_25 = 0;
  long I_26 = 0;
  float f_27 = 0;
  long I_28 = 0;
  long I_29 = 0;
  long i_30 = 0;
  long i_31 = 0;
  long i0_range = 0;
  long i_32 = 0;
  long i0_sliderSize = 0;
  long i_33 = 0;
  float f_34 = 0;
  long i_35 = 0;
  float f_36 = 0;
  long I_37 = 0;
  float f_38 = 0;
  float f_39 = 0;
  long i_40 = 0;
  float f_41 = 0;
  long I_42 = 0;
  float f_43 = 0;
  float f_44 = 0;
  long I_45 = 0;
  float f_46 = 0;
  long I_47 = 0;
  long I_48 = 0;
  long I_49 = 0;
  long I_50 = 0;
  long I_51 = 0;
  long I_52 = 0;
  long I_53 = 0;
  float f_54 = 0;
  long i_55 = 0;
  float f_56 = 0;
  long I_57 = 0;
  float f_58 = 0;
  float f_59 = 0;
  float f_60 = 0;
  float f_61 = 0;
  long I_62 = 0;
  float f_63 = 0;
  long i_64 = 0;
  float f_65 = 0;
  long I_66 = 0;
  float f_67 = 0;
  float f_68 = 0;
  long I_69 = 0;
  float f_70 = 0;
  long I_71 = 0;
  long I_72 = 0;
  long I_73 = 0;
  long I_74 = 0;
  long I_75 = 0;
  long I_76 = 0;
  long i_77 = 0;
  float f_78 = 0;
  long I_79 = 0;
  float f_80 = 0;
  long i_81 = 0;
  float f_82 = 0;
  long I_83 = 0;
  float f_84 = 0;
  float f_85 = 0;
  long i_86 = 0;
  long i_87 = 0;
  long i_88 = 0;
  long i_89 = 0;
  float f_90 = 0;
  long I_91 = 0;
  float f_92 = 0;
  float f_93 = 0;
  float f_94 = 0;
  long i_95 = 0;
  long i_96 = 0;
  float f_97 = 0;
  long I_98 = 0;
  float f_99 = 0;
  long I_100 = 0;
  long I_101 = 0;
  long I_102 = 0;
  long I_103 = 0;
  long I_104 = 0;
  float f_105 = 0;
  long I_106 = 0;
  long i_107 = 0;
  long i_108 = 0;
  long i_109 = 0;
  long i_110 = 0;
  float f_111 = 0;
  long i_112 = 0;
  float f_113 = 0;
  long I_114 = 0;
  float f_115 = 0;
  long i_116 = 0;
  float f_117 = 0;
  long I_118 = 0;
  float f_119 = 0;
  float f_120 = 0;
  long i_121 = 0;
  float f_122 = 0;
  long I_123 = 0;
  float f_124 = 0;
  long I_125 = 0;
  float f_126 = 0;
  float f_127 = 0;
  long I_128 = 0;
  float f_129 = 0;
  float f_130 = 0;
  long i_131 = 0;
  float f_132 = 0;
  long I_133 = 0;
  float f_134 = 0;
  float f_135 = 0;
  long i_136 = 0;
  long i_137 = 0;
  long i_138 = 0;
  long i_139 = 0;
  float f_140 = 0;
  long I_141 = 0;
  float f_142 = 0;
  float f_143 = 0;
  long I_144 = 0;
  long I_145 = 0;
  long I_146 = 0;
  long I_147 = 0;
  long I_148 = 0;
  long I_149 = 0;
  float f_150 = 0;
  float f_151 = 0;
  float f_152 = 0;
  long I_153 = 0;
  float f_154 = 0;
  long i_155 = 0;
  float f_156 = 0;
  long I_157 = 0;
  float f_158 = 0;
  float f_159 = 0;
  long i_160 = 0;
  float f_161 = 0;
  long I_162 = 0;
  float f_163 = 0;
  float f_164 = 0;
  long I_165 = 0;
  float f_166 = 0;
  long I_167 = 0;
  long I_168 = 0;
  long I_169 = 0;
  long I_170 = 0;
  long I_171 = 0;
  long I_172 = 0;
  float f_173 = 0;
  long i_174 = 0;
  float f_175 = 0;
  long I_176 = 0;
  float f_177 = 0;
  long i_178 = 0;
  float f_179 = 0;
  long I_180 = 0;
  float f_181 = 0;
  float f_182 = 0;
  float f_183 = 0;
  long i_184 = 0;
  long i_185 = 0;
  float f_186 = 0;
  long I_187 = 0;
  float f_188 = 0;
  long i_189 = 0;
  long i_190 = 0;
  long i_191 = 0;
  long i_192 = 0;
  float f_193 = 0;
  long I_194 = 0;
  float f_195 = 0;
  long I_196 = 0;
  long I_197 = 0;
  long I_198 = 0;
  long I_199 = 0;
  long I_200 = 0;
  float f_201 = 0;
  long I_202 = 0;
  long i_203 = 0;
  long i_204 = 0;
  long i_205 = 0;
  long i_206 = 0;
  float f_207 = 0;
  long i_208 = 0;
  float f_209 = 0;
  long I_210 = 0;
  float f_211 = 0;
  long I_212 = 0;
  float f_213 = 0;
  float f_214 = 0;
  long I_215 = 0;
  float f_216 = 0;
  float f_217 = 0;
  long i_218 = 0;
  float f_219 = 0;
  long I_220 = 0;
  float f_221 = 0;
  float f_222 = 0;
  long i_223 = 0;
  float f_224 = 0;
  long I_225 = 0;
  float f_226 = 0;
  long i_227 = 0;
  float f_228 = 0;
  long I_229 = 0;
  float f_230 = 0;
  float f_231 = 0;
  long I_232 = 0;
  float f_233 = 0;
  long i_234 = 0;
  long i_235 = 0;
  long i_236 = 0;
  long i_237 = 0;
  float f_238 = 0;
  long I_239 = 0;
  float f_240 = 0;
  long I_241 = 0;
  long I_242 = 0;
  long I_243 = 0;
  long I_244 = 0;
  long I_245 = 0;
  long i_246 = 0;
  long I_247 = 0;
  long I_248 = 0;
  long I_249 = 0;
  long I_250 = 0;
  long i_251 = 0;
  long I_252 = 0;
  long I_253 = 0;
  long I_254 = 0;
  long i4_wheel = 0;
  float f_255 = 0;
  long i_256 = 0;
  long i_257 = 0;
  long i_258 = 0;
  long i_259 = 0;
  long i_260 = 0;
  long I_261 = 0;
  long i_262 = 0;
  long I_263 = 0;
  long I_264 = 0;
  long I_265 = 0;
  long i_266 = 0;
  long i_267 = 0;
  long i_268 = 0;
  long i_269 = 0;
  long i_270 = 0;
  long I_271 = 0;
  long I_272 = 0;
  long I_273 = 0;
  long i_274 = 0;
  long i_275 = 0;
  long i_276 = 0;
  long i_277 = 0;
  long i_278 = 0;
  long I_279 = 0;
  long I_280 = 0;
  float f_281 = 0;
  long i_282 = 0;
  long i_283 = 0;
  float f_284 = 0;
  long I_285 = 0;
  float f_286 = 0;
  long I_287 = 0;
  long I_288 = 0;
  long i_289 = 0;
  long I_290 = 0;
  long I_291 = 0;
  long I_292 = 0;
  float f_293 = 0;
  float f_294 = 0;
  float f_295 = 0;
  float f_296 = 0;
  float f_297 = 0;
  float f_298 = 0;
  long I_299 = 0;
  float f_300 = 0;
  float f_301 = 0;
  float f_302 = 0;
  float f_303 = 0;
  long I_304 = 0;
  float f_305 = 0;
  long i_306 = 0;
  float f_307 = 0;
  long i_308 = 0;
  long i_309 = 0;
  float f_310 = 0;
  long I_311 = 0;
  float f_312 = 0;
  long I_313 = 0;
  long I_314 = 0;
  long i_315 = 0;
  long I_316 = 0;
  long I_317 = 0;
  long I_318 = 0;
  float f_319 = 0;
  float f_320 = 0;
  float f_321 = 0;
  float f_322 = 0;
  float f_323 = 0;
  float f_324 = 0;
  long I_325 = 0;
  float f_326 = 0;
  float f_327 = 0;
  float f_328 = 0;
  float f_329 = 0;
  long I_330 = 0;
  float f_331 = 0;
  long i_332 = 0;
  long i_333 = 0;
  long i_334 = 0;
  long I_335 = 0;
  long i_336 = 0;
  long I_337 = 0;
  long I_338 = 0;
  long i_339 = 0;
  long i_340 = 0;
  long i_341 = 0;
  long I_342 = 0;
  long I_343 = 0;
  long I_344 = 0;
  long i_345 = 0;
  long I_346 = 0;
  long I_347 = 0;
  long I_348 = 0;
  long I_349 = 0;
  long I_350 = 0;
  long I_351 = 0;
  long I_352 = 0;
  long I_353 = 0;
  long i_354 = 0;
  long I_355 = 0;
  long I_356 = 0;
  long I_357 = 0;
  long I_358 = 0;
  long I_359 = 0;
  long I_360 = 0;
  long I_361 = 0;
  long I_362 = 0;
  long I_363 = 0;
  long i_364 = 0;
  long i_365 = 0;
  long i_366 = 0;
  long I_367 = 0;
  long i_368 = 0;
  long I_369 = 0;
  long I_370 = 0;
  long U_371 = 0;
  long I_372 = 0;
  float f_373 = 0;
  long I_374 = 0;
  float f_375 = 0;
  long I_376 = 0;
  long I_377 = 0;
  long I_378 = 0;
  long I_379 = 0;
  long I_380 = 0;
  long i_381 = 0;
  long i_382 = 0;
  long i_383 = 0;
  long I_384 = 0;
  long I_385 = 0;
  long U_386 = 0;
  long I_387 = 0;
  float f_388 = 0;
  long I_389 = 0;
  float f_390 = 0;
  long I_391 = 0;
  long I_392 = 0;
  long I_393 = 0;
  long I_394 = 0;
  long I_395 = 0;
  long i_396 = 0;
  long i_397 = 0;
  long i_398 = 0;
  long I_399 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(240L);
  I_0 = (long) fp + (long) 8L;
  I_1 = memcpy((long) I_0, (long) I0_bounds, (long) 20L);
  I_2 = m2_guiState;
  i0_state = mir_read_int(I_2);
  if (mir_read_float(16L + fp) > mir_read_float(20L + fp)) { mir_label = 2091; break; }
  mir_label = 2092; break;
case 2091:
  i_4 = 0L;
  mir_label = 2093; break;
case 2092:
  i_4 = 1L;
case 2093:
  i0_isVertical = i_4;
  i_5 = GuiGetStyle((int) 14L, (int) 17L);
  I_6 = (long) (int) i_5;
  if (((long) I_6 == 0)) { mir_label = 2094; break; }
case 2095:
  I_7 = (long) (int) i0_isVertical;
  if (((long) I_7 == 0)) { mir_label = 2096; break; }
case 2097:
  i_8 = (long) mir_read_float(16L + fp);
  i_9 = GuiGetStyle((int) 14L, (int) 12L);
  i_10 = (int) 2L * (int) i_9;
  i_11 = (int) i_8 - (int) i_10;
  i_12 = i_11;
  mir_label = 2098; break;
case 2096:
  i_13 = (long) mir_read_float(20L + fp);
  i_14 = GuiGetStyle((int) 14L, (int) 12L);
  i_15 = (int) 2L * (int) i_14;
  i_16 = (int) i_13 - (int) i_15;
  i_12 = i_16;
case 2098:
  i_17 = i_12;
  mir_label = 2099; break;
case 2094:
  i_17 = 0L;
case 2099:
  i0_spinnerSize = i_17;
  f_18 = (float) 0L;
  mir_write_float(28L + fp, f_18);
  I_20 = (long) fp + (long) 32L;
  I_19 = memset((long) I_20, (int) 0L, (long) 16L);
  f_21 = (float) 0L;
  mir_write_float(48L + fp, f_21);
  I_23 = (long) fp + (long) 52L;
  I_22 = memset((long) I_23, (int) 0L, (long) 16L);
  f_24 = (float) 0L;
  mir_write_float(68L + fp, f_24);
  I_26 = (long) fp + (long) 72L;
  I_25 = memset((long) I_26, (int) 0L, (long) 16L);
  f_27 = (float) 0L;
  mir_write_float(88L + fp, f_27);
  I_29 = (long) fp + (long) 92L;
  I_28 = memset((long) I_29, (int) 0L, (long) 16L);
  if ((int) i0_value <= (int) i0_maxValue) { mir_label = 2100; break; }
case 2101:
  i0_value = i0_maxValue;
  mir_label = 2102; break;
case 2100:
case 2102:
  if ((int) i0_value >= (int) i0_minValue) { mir_label = 2103; break; }
case 2104:
  i0_value = i0_minValue;
  mir_label = 2105; break;
case 2103:
case 2105:
  i_32 = (int) i0_maxValue - (int) i0_minValue;
  i0_range = i_32;
  i_33 = GuiGetStyle((int) 14L, (int) 19L);
  i0_sliderSize = i_33;
  f_34 = mir_read_float(8L + fp);
  i_35 = GuiGetStyle((int) 14L, (int) 12L);
  I_37 = (long) (int) i_35;
  f_36 = (float) I_37;
  f_38 = f_34 + f_36;
  mir_write_float(108L + fp, f_38);
  f_39 = mir_read_float(12L + fp);
  i_40 = GuiGetStyle((int) 14L, (int) 12L);
  I_42 = (long) (int) i_40;
  f_41 = (float) I_42;
  f_43 = f_39 + f_41;
  mir_write_float(112L + fp, f_43);
  I_45 = (long) (int) i0_spinnerSize;
  f_44 = (float) I_45;
  mir_write_float(116L + fp, f_44);
  I_47 = (long) (int) i0_spinnerSize;
  f_46 = (float) I_47;
  mir_write_float(120L + fp, f_46);
  I_49 = (long) fp + (long) 124L;
  I_48 = memset((long) I_49, (int) 0L, (long) 4L);
  I_50 = (long) fp + (long) 28L;
  I_52 = (long) fp + (long) 108L;
  I_51 = memcpy((long) I_50, (long) I_52, (long) 20L);
  I_53 = (long) (int) i0_isVertical;
  if (((long) I_53 == 0)) { mir_label = 2106; break; }
case 2107:
  f_54 = mir_read_float(8L + fp);
  i_55 = GuiGetStyle((int) 14L, (int) 12L);
  I_57 = (long) (int) i_55;
  f_56 = (float) I_57;
  f_58 = f_54 + f_56;
  mir_write_float(128L + fp, f_58);
  f_59 = mir_read_float(12L + fp);
  f_60 = f_59 + mir_read_float(20L + fp);
  I_62 = (long) (int) i0_spinnerSize;
  f_61 = (float) I_62;
  f_63 = f_60 - f_61;
  i_64 = GuiGetStyle((int) 14L, (int) 12L);
  I_66 = (long) (int) i_64;
  f_65 = (float) I_66;
  f_67 = f_63 - f_65;
  mir_write_float(132L + fp, f_67);
  I_69 = (long) (int) i0_spinnerSize;
  f_68 = (float) I_69;
  mir_write_float(136L + fp, f_68);
  I_71 = (long) (int) i0_spinnerSize;
  f_70 = (float) I_71;
  mir_write_float(140L + fp, f_70);
  I_73 = (long) fp + (long) 144L;
  I_72 = memset((long) I_73, (int) 0L, (long) 4L);
  I_74 = (long) fp + (long) 48L;
  I_76 = (long) fp + (long) 128L;
  I_75 = memcpy((long) I_74, (long) I_76, (long) 20L);
  i_77 = GuiGetStyle((int) 14L, (int) 12L);
  I_79 = (long) (int) i_77;
  f_78 = (float) I_79;
  f_80 = mir_read_float(8L + fp) + f_78;
  i_81 = GuiGetStyle((int) 14L, (int) 20L);
  I_83 = (long) (int) i_81;
  f_82 = (float) I_83;
  f_84 = f_80 + f_82;
  mir_write_float(148L + fp, f_84);
  f_85 = mir_read_float(32L + fp) + mir_read_float(40L + fp);
  mir_write_float(152L + fp, f_85);
  i_86 = GuiGetStyle((int) 14L, (int) 12L);
  i_87 = GuiGetStyle((int) 14L, (int) 20L);
  i_88 = (int) i_86 + (int) i_87;
  i_89 = (int) 2L * (int) i_88;
  I_91 = (long) (int) i_89;
  f_90 = (float) I_91;
  f_92 = mir_read_float(16L + fp) - f_90;
  mir_write_float(156L + fp, f_92);
  f_93 = mir_read_float(20L + fp) - mir_read_float(40L + fp);
  f_94 = f_93 - mir_read_float(60L + fp);
  i_95 = GuiGetStyle((int) 14L, (int) 12L);
  i_96 = (int) 2L * (int) i_95;
  I_98 = (long) (int) i_96;
  f_97 = (float) I_98;
  f_99 = f_94 - f_97;
  mir_write_float(160L + fp, f_99);
  I_101 = (long) fp + (long) 164L;
  I_100 = memset((long) I_101, (int) 0L, (long) 4L);
  I_102 = (long) fp + (long) 68L;
  I_104 = (long) fp + (long) 148L;
  I_103 = memcpy((long) I_102, (long) I_104, (long) 20L);
  I_106 = (long) (int) i0_sliderSize;
  f_105 = (float) I_106;
  if (f_105 >= mir_read_float(80L + fp)) { mir_label = 2108; break; }
  mir_label = 2109; break;
case 2108:
  i_108 = (long) mir_read_float(80L + fp);
  i_109 = (int) i_108 - (int) 2L;
  i_110 = i_109;
  mir_label = 2110; break;
case 2109:
  i_110 = i0_sliderSize;
case 2110:
  i0_sliderSize = i_110;
  f_111 = mir_read_float(8L + fp);
  i_112 = GuiGetStyle((int) 14L, (int) 12L);
  I_114 = (long) (int) i_112;
  f_113 = (float) I_114;
  f_115 = f_111 + f_113;
  i_116 = GuiGetStyle((int) 14L, (int) 18L);
  I_118 = (long) (int) i_116;
  f_117 = (float) I_118;
  f_119 = f_115 + f_117;
  mir_write_float(168L + fp, f_119);
  f_120 = mir_read_float(72L + fp);
  i_121 = (int) i0_value - (int) i0_minValue;
  I_123 = (long) (int) i_121;
  f_122 = (float) I_123;
  I_125 = (long) (int) i0_range;
  f_124 = (float) I_125;
  f_126 = f_122 / f_124;
  I_128 = (long) (int) i0_sliderSize;
  f_127 = (float) I_128;
  f_129 = mir_read_float(80L + fp) - f_127;
  f_130 = f_126 * f_129;
  i_131 = (long) f_130;
  I_133 = (long) (int) i_131;
  f_132 = (float) I_133;
  f_134 = f_120 + f_132;
  mir_write_float(172L + fp, f_134);
  f_135 = mir_read_float(16L + fp);
  i_136 = GuiGetStyle((int) 14L, (int) 12L);
  i_137 = GuiGetStyle((int) 14L, (int) 18L);
  i_138 = (int) i_136 + (int) i_137;
  i_139 = (int) 2L * (int) i_138;
  I_141 = (long) (int) i_139;
  f_140 = (float) I_141;
  f_142 = f_135 - f_140;
  mir_write_float(176L + fp, f_142);
  I_144 = (long) (int) i0_sliderSize;
  f_143 = (float) I_144;
  mir_write_float(180L + fp, f_143);
  I_146 = (long) fp + (long) 184L;
  I_145 = memset((long) I_146, (int) 0L, (long) 4L);
  I_147 = (long) fp + (long) 88L;
  I_149 = (long) fp + (long) 168L;
  I_148 = memcpy((long) I_147, (long) I_149, (long) 20L);
  mir_label = 2111; break;
case 2106:
  f_150 = mir_read_float(8L + fp);
  f_151 = f_150 + mir_read_float(16L + fp);
  I_153 = (long) (int) i0_spinnerSize;
  f_152 = (float) I_153;
  f_154 = f_151 - f_152;
  i_155 = GuiGetStyle((int) 14L, (int) 12L);
  I_157 = (long) (int) i_155;
  f_156 = (float) I_157;
  f_158 = f_154 - f_156;
  mir_write_float(128L + fp, f_158);
  f_159 = mir_read_float(12L + fp);
  i_160 = GuiGetStyle((int) 14L, (int) 12L);
  I_162 = (long) (int) i_160;
  f_161 = (float) I_162;
  f_163 = f_159 + f_161;
  mir_write_float(132L + fp, f_163);
  I_165 = (long) (int) i0_spinnerSize;
  f_164 = (float) I_165;
  mir_write_float(136L + fp, f_164);
  I_167 = (long) (int) i0_spinnerSize;
  f_166 = (float) I_167;
  mir_write_float(140L + fp, f_166);
  I_169 = (long) fp + (long) 144L;
  I_168 = memset((long) I_169, (int) 0L, (long) 4L);
  I_170 = (long) fp + (long) 48L;
  I_172 = (long) fp + (long) 128L;
  I_171 = memcpy((long) I_170, (long) I_172, (long) 20L);
  f_173 = mir_read_float(28L + fp) + mir_read_float(36L + fp);
  mir_write_float(148L + fp, f_173);
  i_174 = GuiGetStyle((int) 14L, (int) 12L);
  I_176 = (long) (int) i_174;
  f_175 = (float) I_176;
  f_177 = mir_read_float(12L + fp) + f_175;
  i_178 = GuiGetStyle((int) 14L, (int) 20L);
  I_180 = (long) (int) i_178;
  f_179 = (float) I_180;
  f_181 = f_177 + f_179;
  mir_write_float(152L + fp, f_181);
  f_182 = mir_read_float(16L + fp) - mir_read_float(36L + fp);
  f_183 = f_182 - mir_read_float(56L + fp);
  i_184 = GuiGetStyle((int) 14L, (int) 12L);
  i_185 = (int) 2L * (int) i_184;
  I_187 = (long) (int) i_185;
  f_186 = (float) I_187;
  f_188 = f_183 - f_186;
  mir_write_float(156L + fp, f_188);
  i_189 = GuiGetStyle((int) 14L, (int) 12L);
  i_190 = GuiGetStyle((int) 14L, (int) 20L);
  i_191 = (int) i_189 + (int) i_190;
  i_192 = (int) 2L * (int) i_191;
  I_194 = (long) (int) i_192;
  f_193 = (float) I_194;
  f_195 = mir_read_float(20L + fp) - f_193;
  mir_write_float(160L + fp, f_195);
  I_197 = (long) fp + (long) 164L;
  I_196 = memset((long) I_197, (int) 0L, (long) 4L);
  I_198 = (long) fp + (long) 68L;
  I_200 = (long) fp + (long) 148L;
  I_199 = memcpy((long) I_198, (long) I_200, (long) 20L);
  I_202 = (long) (int) i0_sliderSize;
  f_201 = (float) I_202;
  if (f_201 >= mir_read_float(76L + fp)) { mir_label = 2112; break; }
  mir_label = 2113; break;
case 2112:
  i_204 = (long) mir_read_float(76L + fp);
  i_205 = (int) i_204 - (int) 2L;
  i_206 = i_205;
  mir_label = 2114; break;
case 2113:
  i_206 = i0_sliderSize;
case 2114:
  i0_sliderSize = i_206;
  f_207 = mir_read_float(68L + fp);
  i_208 = (int) i0_value - (int) i0_minValue;
  I_210 = (long) (int) i_208;
  f_209 = (float) I_210;
  I_212 = (long) (int) i0_range;
  f_211 = (float) I_212;
  f_213 = f_209 / f_211;
  I_215 = (long) (int) i0_sliderSize;
  f_214 = (float) I_215;
  f_216 = mir_read_float(76L + fp) - f_214;
  f_217 = f_213 * f_216;
  i_218 = (long) f_217;
  I_220 = (long) (int) i_218;
  f_219 = (float) I_220;
  f_221 = f_207 + f_219;
  mir_write_float(168L + fp, f_221);
  f_222 = mir_read_float(12L + fp);
  i_223 = GuiGetStyle((int) 14L, (int) 12L);
  I_225 = (long) (int) i_223;
  f_224 = (float) I_225;
  f_226 = f_222 + f_224;
  i_227 = GuiGetStyle((int) 14L, (int) 18L);
  I_229 = (long) (int) i_227;
  f_228 = (float) I_229;
  f_230 = f_226 + f_228;
  mir_write_float(172L + fp, f_230);
  I_232 = (long) (int) i0_sliderSize;
  f_231 = (float) I_232;
  mir_write_float(176L + fp, f_231);
  f_233 = mir_read_float(20L + fp);
  i_234 = GuiGetStyle((int) 14L, (int) 12L);
  i_235 = GuiGetStyle((int) 14L, (int) 18L);
  i_236 = (int) i_234 + (int) i_235;
  i_237 = (int) 2L * (int) i_236;
  I_239 = (long) (int) i_237;
  f_238 = (float) I_239;
  f_240 = f_233 - f_238;
  mir_write_float(180L + fp, f_240);
  I_242 = (long) fp + (long) 184L;
  I_241 = memset((long) I_242, (int) 0L, (long) 4L);
  I_243 = (long) fp + (long) 88L;
  I_245 = (long) fp + (long) 168L;
  I_244 = memcpy((long) I_243, (long) I_245, (long) 20L);
case 2111:
  if ((int) i0_state == (int) 3L) { mir_label = 2115; break; }
case 2116:
  I_247 = m2_guiLocked;
  if (((long) mir_read_int(I_247) != 0)) { mir_label = 2115; break; }
case 2117:
  I_248 = (long) fp + (long) 192L;
  GetMousePosition((long) I_248);
  I_250 = (long) fp + (long) 128L;
  I_249 = memcpy((long) I_250, (long) I_248, (long) 24L);
  I_252 = (long) fp + (long) 128L;
  I_253 = (long) fp + (long) 8L;
  i_251 = m2_CheckCollisionPointRec((long) I_252, (long) I_253);
  I_254 = (long) (int) i_251;
  if (((long) I_254 == 0)) { mir_label = 2118; break; }
case 2119:
  i0_state = 1L;
  f_255 = GetMouseWheelMove();
  i_256 = (long) f_255;
  i4_wheel = i_256;
  if ((int) i4_wheel == (int) 0L) { mir_label = 2120; break; }
case 2121:
  i_258 = i0_value;
  i_258 = (int) i_258 + (int) i4_wheel;
  i0_value = i_258;
  mir_label = 2122; break;
case 2120:
case 2122:
  i_260 = IsMouseButtonPressed((int) 0L);
  I_261 = (long) (int) i_260;
  if (((long) I_261 == 0)) { mir_label = 2123; break; }
case 2124:
  I_263 = (long) fp + (long) 128L;
  I_264 = (long) fp + (long) 28L;
  i_262 = m2_CheckCollisionPointRec((long) I_263, (long) I_264);
  I_265 = (long) (int) i_262;
  if (((long) I_265 == 0)) { mir_label = 2125; break; }
case 2126:
  i_266 = GuiGetStyle((int) 14L, (int) 21L);
  i_267 = (int) i0_range / (int) i_266;
  i_268 = i0_value;
  i_268 = (int) i_268 - (int) i_267;
  i0_value = i_268;
  mir_label = 2127; break;
case 2125:
  I_271 = (long) fp + (long) 128L;
  I_272 = (long) fp + (long) 48L;
  i_270 = m2_CheckCollisionPointRec((long) I_271, (long) I_272);
  I_273 = (long) (int) i_270;
  if (((long) I_273 == 0)) { mir_label = 2128; break; }
case 2129:
  i_274 = GuiGetStyle((int) 14L, (int) 21L);
  i_275 = (int) i0_range / (int) i_274;
  i_276 = i0_value;
  i_276 = (int) i_276 + (int) i_275;
  i0_value = i_276;
  mir_label = 2130; break;
case 2128:
case 2130:
case 2127:
  i0_state = 2L;
  mir_label = 2131; break;
case 2123:
  i_278 = IsMouseButtonDown((int) 0L);
  I_279 = (long) (int) i_278;
  if (((long) I_279 == 0)) { mir_label = 2132; break; }
case 2133:
  I_280 = (long) (int) i0_isVertical;
  if (((long) I_280 != 0)) { mir_label = 2134; break; }
case 2135:
  f_281 = mir_read_float(28L + fp) + mir_read_float(36L + fp);
  mir_write_float(152L + fp, f_281);
  mir_write_float(156L + fp, mir_read_float(32L + fp));
  mir_write_float(160L + fp, mir_read_float(76L + fp));
  i_282 = GuiGetStyle((int) 14L, (int) 12L);
  i_283 = (int) 2L * (int) i_282;
  I_285 = (long) (int) i_283;
  f_284 = (float) I_285;
  f_286 = mir_read_float(20L + fp) - f_284;
  mir_write_float(164L + fp, f_286);
  I_288 = (long) fp + (long) 168L;
  I_287 = memset((long) I_288, (int) 0L, (long) 4L);
  I_290 = (long) fp + (long) 128L;
  I_291 = (long) fp + (long) 152L;
  i_289 = m2_CheckCollisionPointRec((long) I_290, (long) I_291);
  I_292 = (long) (int) i_289;
  if (((long) I_292 == 0)) { mir_label = 2136; break; }
case 2137:
  f_293 = mir_read_float(128L + fp) - mir_read_float(152L + fp);
  f_294 = (float) 2L;
  f_295 = mir_read_float(96L + fp) / f_294;
  f_296 = f_293 - f_295;
  f_297 = f_296;
  I_299 = (long) (int) i0_range;
  f_298 = (float) I_299;
  f_300 = f_297 * f_298;
  f_301 = mir_read_float(160L + fp) - mir_read_float(96L + fp);
  f_302 = f_300 / f_301;
  I_304 = (long) (int) i0_minValue;
  f_303 = (float) I_304;
  f_305 = f_302 + f_303;
  i_306 = (long) f_305;
  i0_value = i_306;
  mir_label = 2138; break;
case 2136:
case 2138:
  mir_label = 2139; break;
case 2134:
  mir_write_float(152L + fp, mir_read_float(28L + fp));
  f_307 = mir_read_float(32L + fp) + mir_read_float(40L + fp);
  mir_write_float(156L + fp, f_307);
  i_308 = GuiGetStyle((int) 14L, (int) 12L);
  i_309 = (int) 2L * (int) i_308;
  I_311 = (long) (int) i_309;
  f_310 = (float) I_311;
  f_312 = mir_read_float(16L + fp) - f_310;
  mir_write_float(160L + fp, f_312);
  mir_write_float(164L + fp, mir_read_float(80L + fp));
  I_314 = (long) fp + (long) 168L;
  I_313 = memset((long) I_314, (int) 0L, (long) 4L);
  I_316 = (long) fp + (long) 128L;
  I_317 = (long) fp + (long) 152L;
  i_315 = m2_CheckCollisionPointRec((long) I_316, (long) I_317);
  I_318 = (long) (int) i_315;
  if (((long) I_318 == 0)) { mir_label = 2140; break; }
case 2141:
  f_319 = mir_read_float(132L + fp) - mir_read_float(156L + fp);
  f_320 = (float) 2L;
  f_321 = mir_read_float(100L + fp) / f_320;
  f_322 = f_319 - f_321;
  f_323 = f_322;
  I_325 = (long) (int) i0_range;
  f_324 = (float) I_325;
  f_326 = f_323 * f_324;
  f_327 = mir_read_float(164L + fp) - mir_read_float(100L + fp);
  f_328 = f_326 / f_327;
  I_330 = (long) (int) i0_minValue;
  f_329 = (float) I_330;
  f_331 = f_328 + f_329;
  i_332 = (long) f_331;
  i0_value = i_332;
  mir_label = 2142; break;
case 2140:
case 2142:
case 2139:
  mir_label = 2143; break;
case 2132:
case 2143:
case 2131:
  mir_label = 2144; break;
case 2118:
case 2144:
  if ((int) i0_value <= (int) i0_maxValue) { mir_label = 2145; break; }
case 2146:
  i0_value = i0_maxValue;
  mir_label = 2147; break;
case 2145:
case 2147:
  if ((int) i0_value >= (int) i0_minValue) { mir_label = 2148; break; }
case 2149:
  i0_value = i0_minValue;
  mir_label = 2150; break;
case 2148:
case 2150:
  mir_label = 2151; break;
case 2115:
case 2151:
  I_335 = (long) fp + (long) 8L;
  i_336 = GuiGetStyle((int) 14L, (int) 12L);
  I_337 = (long) fp + (long) 192L;
  I_338 = (long) fp + (long) 208L;
  i_340 = (int) i0_state * (int) 3L;
  i_341 = (int) 0L + (int) i_340;
  i_339 = GuiGetStyle((int) 12L, (int) i_341);
  m2_GetColor((long) I_338, (int) i_339);
  I_342 = m2_guiAlpha;
  m2_Fade((long) I_337, (long) I_338, (float) mir_read_float(I_342));
  I_343 = (long) fp + (long) 208L;
  I_344 = (long) fp + (long) 224L;
  i_345 = GuiGetStyle((int) 0L, (int) 9L);
  m2_GetColor((long) I_344, (int) i_345);
  I_346 = m2_guiAlpha;
  m2_Fade((long) I_343, (long) I_344, (float) mir_read_float(I_346));
  m2_GuiDrawRectangle((long) I_335, (int) i_336, (long) I_337, (long) I_343);
  I_347 = (long) fp + (long) 68L;
  I_348 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(fp, I_348);
  I_349 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(1L + fp, I_349);
  I_350 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(2L + fp, I_350);
  I_351 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(3L + fp, I_351);
  I_352 = (long) fp + (long) 192L;
  I_353 = (long) fp + (long) 208L;
  i_354 = GuiGetStyle((int) 2L, (int) 1L);
  m2_GetColor((long) I_353, (int) i_354);
  I_355 = m2_guiAlpha;
  m2_Fade((long) I_352, (long) I_353, (float) mir_read_float(I_355));
  m2_GuiDrawRectangle((long) I_347, (int) 0L, (long) fp, (long) I_352);
  I_356 = (long) fp + (long) 88L;
  I_357 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(4L + fp, I_357);
  I_358 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(5L + fp, I_358);
  I_359 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(6L + fp, I_359);
  I_360 = (((long) (int) 0L) & 0xFFL);
  mir_write_ubyte(7L + fp, I_360);
  I_361 = (long) fp + (long) 4L;
  I_362 = (long) fp + (long) 192L;
  I_363 = (long) fp + (long) 208L;
  i_365 = (int) i0_state * (int) 3L;
  i_366 = (int) 0L + (int) i_365;
  i_364 = GuiGetStyle((int) 4L, (int) i_366);
  m2_GetColor((long) I_363, (int) i_364);
  I_367 = m2_guiAlpha;
  m2_Fade((long) I_362, (long) I_363, (float) mir_read_float(I_367));
  m2_GuiDrawRectangle((long) I_356, (int) 0L, (long) I_361, (long) I_362);
  i_368 = GuiGetStyle((int) 14L, (int) 17L);
  I_369 = (long) (int) i_368;
  if (((long) I_369 == 0)) { mir_label = 2152; break; }
case 2153:
  I_370 = (long) (int) i0_isVertical;
  if (((long) I_370 == 0)) { mir_label = 2154; break; }
case 2155:
  U_371 = mir_get_string_ptr("#121#");
  mir_label = 2156; break;
case 2154:
  U_371 = mir_get_string_ptr("#118#");
case 2156:
  mir_write_float(128L + fp, mir_read_float(28L + fp));
  mir_write_float(132L + fp, mir_read_float(32L + fp));
  I_372 = (long) (int) i0_isVertical;
  if (((long) I_372 == 0)) { mir_label = 2157; break; }
case 2158:
  f_373 = mir_read_float(16L + fp);
  mir_label = 2159; break;
case 2157:
  f_373 = mir_read_float(20L + fp);
case 2159:
  mir_write_float(136L + fp, f_373);
  I_374 = (long) (int) i0_isVertical;
  if (((long) I_374 == 0)) { mir_label = 2160; break; }
case 2161:
  f_375 = mir_read_float(16L + fp);
  mir_label = 2162; break;
case 2160:
  f_375 = mir_read_float(20L + fp);
case 2162:
  mir_write_float(140L + fp, f_375);
  I_377 = (long) fp + (long) 144L;
  I_376 = memset((long) I_377, (int) 0L, (long) 4L);
  I_378 = (long) fp + (long) 128L;
  I_379 = (long) fp + (long) 192L;
  I_380 = (long) fp + (long) 208L;
  i_382 = (int) i0_state * (int) 3L;
  i_383 = (int) 2L + (int) i_382;
  i_381 = GuiGetStyle((int) 14L, (int) i_383);
  m2_GetColor((long) I_380, (int) i_381);
  I_384 = m2_guiAlpha;
  m2_Fade((long) I_379, (long) I_380, (float) mir_read_float(I_384));
  m2_GuiDrawText((long) U_371, (long) I_378, (int) 1L, (long) I_379);
  I_385 = (long) (int) i0_isVertical;
  if (((long) I_385 == 0)) { mir_label = 2163; break; }
case 2164:
  U_386 = mir_get_string_ptr("#120#");
  mir_label = 2165; break;
case 2163:
  U_386 = mir_get_string_ptr("#119#");
case 2165:
  mir_write_float(148L + fp, mir_read_float(48L + fp));
  mir_write_float(152L + fp, mir_read_float(52L + fp));
  I_387 = (long) (int) i0_isVertical;
  if (((long) I_387 == 0)) { mir_label = 2166; break; }
case 2167:
  f_388 = mir_read_float(16L + fp);
  mir_label = 2168; break;
case 2166:
  f_388 = mir_read_float(20L + fp);
case 2168:
  mir_write_float(156L + fp, f_388);
  I_389 = (long) (int) i0_isVertical;
  if (((long) I_389 == 0)) { mir_label = 2169; break; }
case 2170:
  f_390 = mir_read_float(16L + fp);
  mir_label = 2171; break;
case 2169:
  f_390 = mir_read_float(20L + fp);
case 2171:
  mir_write_float(160L + fp, f_390);
  I_392 = (long) fp + (long) 164L;
  I_391 = memset((long) I_392, (int) 0L, (long) 4L);
  I_393 = (long) fp + (long) 148L;
  I_394 = (long) fp + (long) 192L;
  I_395 = (long) fp + (long) 208L;
  i_397 = (int) i0_state * (int) 3L;
  i_398 = (int) 2L + (int) i_397;
  i_396 = GuiGetStyle((int) 14L, (int) i_398);
  m2_GetColor((long) I_395, (int) i_396);
  I_399 = m2_guiAlpha;
  m2_Fade((long) I_394, (long) I_395, (float) mir_read_float(I_399));
  m2_GuiDrawText((long) U_386, (long) I_393, (int) 1L, (long) I_394);
  mir_label = 2172; break;
case 2152:
case 2172:
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_value;
} // End of switch
} // End of while
} // End of function GuiScrollBar

protected void m2_GetColor (long _Ret_Addr, int _i0_hexValue) {
  long Ret_Addr = _Ret_Addr;
  long i0_hexValue = _i0_hexValue;
  long fp = 0;
  long i_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  long i_4 = 0;
  long I_5 = 0;
  long i_6 = 0;
  long I_7 = 0;
  long i_8 = 0;
  long I_9 = 0;
  long i_10 = 0;
  long I_11 = 0;
  long I_12 = 0;
  long i_13 = 0;
  long I_14 = 0;
  long I_15 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  i_0 = (int) i0_hexValue >> (int) 24L;
  I_1 = (((long) (int) i_0) & 0xFFL);
  i_2 = (int) I_1 & (int) 255L;
  I_3 = (((long) (int) i_2) & 0xFFL);
  mir_write_ubyte(fp, I_3);
  i_4 = (int) i0_hexValue >> (int) 16L;
  I_5 = (((long) (int) i_4) & 0xFFL);
  i_6 = (int) I_5 & (int) 255L;
  I_7 = (((long) (int) i_6) & 0xFFL);
  mir_write_ubyte(1L + fp, I_7);
  i_8 = (int) i0_hexValue >> (int) 8L;
  I_9 = (((long) (int) i_8) & 0xFFL);
  i_10 = (int) I_9 & (int) 255L;
  I_11 = (((long) (int) i_10) & 0xFFL);
  mir_write_ubyte(2L + fp, I_11);
  I_12 = (((long) (int) i0_hexValue) & 0xFFL);
  i_13 = (int) I_12 & (int) 255L;
  I_14 = (((long) (int) i_13) & 0xFFL);
  mir_write_ubyte(3L + fp, I_14);
  I_15 = 4L;
case 2173:
  I_15 = (long) I_15 - (long) 1L;
  mir_write_byte(Ret_Addr + I_15, mir_read_byte(fp + I_15));
  if ((long) I_15 > (long) 0L) { mir_label = 2173; break; }
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GetColor

public int ColorToInt (long _I0_color) {
  long I0_color = _I0_color;
  long fp = 0;
  long I_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  long i_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long i_8 = 0;
  long i_9 = 0;
  long i_10 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  I_0 = 4L;
case 2174:
  I_0 = (long) I_0 - (long) 1L;
  mir_write_byte(fp + I_0, mir_read_byte(I0_color + I_0));
  if ((long) I_0 > (long) 0L) { mir_label = 2174; break; }
  i_1 = mir_read_ubyte(fp);
  i_2 = (int) i_1 << (int) 24L;
  i_3 = mir_read_ubyte(1L + fp);
  i_4 = (int) i_3 << (int) 16L;
  i_5 = (int) i_2 | (int) i_4;
  i_6 = mir_read_ubyte(2L + fp);
  i_7 = (int) i_6 << (int) 8L;
  i_8 = (int) i_5 | (int) i_7;
  i_9 = mir_read_ubyte(3L + fp);
  i_10 = (int) i_8 | (int) i_9;
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i_10;
} // End of switch
} // End of while
} // End of function ColorToInt

protected int m2_CheckCollisionPointRec (long _I0_point, long _I0_rec) {
  long I0_point = _I0_point;
  long I0_rec = _I0_rec;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long i0_collision = 0;
  long i_3 = 0;
  float f_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  float f_7 = 0;
  long i_8 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(48L);
  I_0 = (long) fp + (long) 24L;
  I_1 = memcpy((long) I_0, (long) I0_point, (long) 24L);
  I_2 = memcpy((long) fp, (long) I0_rec, (long) 20L);
  i0_collision = 0L;
  if (mir_read_float(24L + fp) >= mir_read_float(fp)) { mir_label = 2175; break; }
  mir_label = 2176; break;
case 2175:
  f_4 = mir_read_float(fp) + mir_read_float(8L + fp);
  if (mir_read_float(24L + fp) <= f_4) { mir_label = 2177; break; }
  mir_label = 2176; break;
case 2177:
  if (mir_read_float(28L + fp) >= mir_read_float(4L + fp)) { mir_label = 2178; break; }
  mir_label = 2176; break;
case 2178:
  f_7 = mir_read_float(4L + fp) + mir_read_float(12L + fp);
  if (mir_read_float(28L + fp) <= f_7) { mir_label = 2179; break; }
  mir_label = 2176; break;
case 2179:
  i0_collision = 1L;
  mir_label = 2180; break;
case 2176:
case 2180:
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_collision;
} // End of switch
} // End of while
} // End of function CheckCollisionPointRec

protected void m2_Fade (long _Ret_Addr, long _I0_color, float f0_alpha) {
  long Ret_Addr = _Ret_Addr;
  long I0_color = _I0_color;
  long fp = 0;
  long I_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  float f_6 = 0;
  long I_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  I_0 = 4L;
case 2181:
  I_0 = (long) I_0 - (long) 1L;
  mir_write_byte(fp + I_0, mir_read_byte(I0_color + I_0));
  if ((long) I_0 > (long) 0L) { mir_label = 2181; break; }
  if (f0_alpha < 0f) { mir_label = 2182; break; }
  mir_label = 2183; break;
case 2182:
  f0_alpha = 0f;
  mir_label = 2184; break;
case 2183:
  if (f0_alpha > 1f) { mir_label = 2185; break; }
  mir_label = 2186; break;
case 2185:
  f0_alpha = 1f;
  mir_label = 2187; break;
case 2186:
case 2187:
case 2184:
  I_3 = (((long) (int) mir_read_ubyte(fp)) & 0xFFL);
  mir_write_ubyte(4L + fp, I_3);
  I_4 = (((long) (int) mir_read_ubyte(1L + fp)) & 0xFFL);
  mir_write_ubyte(5L + fp, I_4);
  I_5 = (((long) (int) mir_read_ubyte(2L + fp)) & 0xFFL);
  mir_write_ubyte(6L + fp, I_5);
  f_6 = 255f * f0_alpha;
  I_8 = (long) f_6;
  I_7 = (((long) (int) I_8) & 0xFFL);
  I_9 = (((long) (int) I_7) & 0xFFL);
  mir_write_ubyte(7L + fp, I_9);
  I_10 = 4L;
case 2188:
  I_10 = (long) I_10 - (long) 1L;
  mir_write_byte(Ret_Addr + I_10, mir_read_byte(4L + fp + I_10));
  if ((long) I_10 > (long) 0L) { mir_label = 2188; break; }
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function Fade

protected long m2_TextFormat (long _U0_text, Object... mir_var_args) {
  long U0_text = _U0_text;
  long fp = 0;
  long i_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(288L);
  mir_va_start(fp, mir_var_args);
  I_1 = m2_S0_TextFormat_buffer;
  i_0 = vsprintf((long) I_1, (long) U0_text, (long) fp);
  I_2 = m2_S0_TextFormat_buffer;
  mir_set_stack_position(mir_saved_stack_position);
  return (long) I_2;
} // End of function TextFormat

long m2_S0_TextFormat_buffer = mir_allocate(256);
protected void m2_DrawRectangleGradientV (int _i0_posX, int _i0_posY, int _i0_width, int _i0_height, long _I0_color1, long _I0_color2) {
  long i0_posX = _i0_posX;
  long i0_posY = _i0_posY;
  long i0_width = _i0_width;
  long i0_height = _i0_height;
  long I0_color1 = _I0_color1;
  long I0_color2 = _I0_color2;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  float f_2 = 0;
  long I_3 = 0;
  float f_4 = 0;
  long I_5 = 0;
  float f_6 = 0;
  long I_7 = 0;
  float f_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  long I_12 = 0;
  long I_13 = 0;
  long I_14 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(32L);
  I_0 = 4L;
case 2189:
  I_0 = (long) I_0 - (long) 1L;
  mir_write_byte(fp + I_0, mir_read_byte(I0_color1 + I_0));
  if ((long) I_0 > (long) 0L) { mir_label = 2189; break; }
  I_1 = 4L;
case 2190:
  I_1 = (long) I_1 - (long) 1L;
  mir_write_byte(4L + fp + I_1, mir_read_byte(I0_color2 + I_1));
  if ((long) I_1 > (long) 0L) { mir_label = 2190; break; }
  I_3 = (long) (int) i0_posX;
  f_2 = (float) I_3;
  mir_write_float(8L + fp, f_2);
  I_5 = (long) (int) i0_posY;
  f_4 = (float) I_5;
  mir_write_float(12L + fp, f_4);
  I_7 = (long) (int) i0_width;
  f_6 = (float) I_7;
  mir_write_float(16L + fp, f_6);
  I_9 = (long) (int) i0_height;
  f_8 = (float) I_9;
  mir_write_float(20L + fp, f_8);
  I_11 = (long) fp + (long) 24L;
  I_10 = memset((long) I_11, (int) 0L, (long) 4L);
  I_12 = (long) fp + (long) 8L;
  I_13 = (long) fp + (long) 4L;
  I_14 = (long) fp + (long) 4L;
  DrawRectangleGradientEx((long) I_12, (long) fp, (long) I_13, (long) I_14, (long) fp);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function DrawRectangleGradientV

public long TextSplit (long _U0_text, byte _i0_delimiter, long _U0_count) {
  long U0_text = _U0_text;
  long i0_delimiter = _i0_delimiter;
  long U0_count = _U0_count;
  long fp = 0;
  long U_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long i_3 = 0;
  long I_4 = 0;
  long i0_counter = 0;
  long i_5 = 0;
  long i2_i = 0;
  long i_6 = 0;
  long I_7 = 0;
  long I_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  long I_12 = 0;
  long i_13 = 0;
  long I_14 = 0;
  long I_15 = 0;
  long i_16 = 0;
  long I_17 = 0;
  long I_18 = 0;
  long I_19 = 0;
  long I_20 = 0;
  long I_21 = 0;
  long I_22 = 0;
  long U_23 = 0;
  long U_24 = 0;
  long U_25 = 0;
  long U_26 = 0;
  long i_27 = 0;
  long i_28 = 0;
  long i_29 = 0;
  long i_30 = 0;
  long I_31 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(2048L);
  I_1 = m2_S0_TextSplit_buffer;
  U_0 = memset((long) I_1, (int) 0L, (long) 1024L);
  I_2 = m2_S0_TextSplit_result;
  i_3 = 0L;
  I_4 = m2_S0_TextSplit_buffer;
  mir_write_ulong(I_2 + i_3 * 8, I_4);
  i0_counter = 0L;
  if ((long) U0_text == (long) 0L) { mir_label = 2191; break; }
case 2192:
  i0_counter = 1L;
  i2_i = 0L;
  if ((int) i2_i >= (int) 1024L) { mir_label = 2193; break; }
case 2194:
  I_7 = m2_S0_TextSplit_buffer;
  I_8 = (long) (int) i2_i;
  I_9 = (long) (int) i2_i;
  I_10 = (long) (byte) mir_read_byte(U0_text + I_9);
  mir_write_byte(I_7 + I_8, I_10);
  I_11 = m2_S0_TextSplit_buffer;
  I_12 = (long) (int) i2_i;
  if ((int) mir_read_byte(I_11 + I_12) != (int) 0L) { mir_label = 2195; break; }
case 2196:
  mir_label = 2193; break;
  // Dead code: mir_label = 2197; break;
case 2195:
  I_14 = m2_S0_TextSplit_buffer;
  I_15 = (long) (int) i2_i;
  if ((int) mir_read_byte(I_14 + I_15) != (int) i0_delimiter) { mir_label = 2198; break; }
case 2199:
  I_17 = m2_S0_TextSplit_buffer;
  I_18 = (long) (int) i2_i;
  I_19 = (long) (byte) 0L;
  mir_write_byte(I_17 + I_18, I_19);
  I_20 = m2_S0_TextSplit_result;
  I_21 = (long) (int) i0_counter;
  I_22 = m2_S0_TextSplit_buffer;
  U_23 = (long) (int) i2_i;
  U_25 = (long) U_23 * (long) 1L;
  U_24 = (long) I_22 + (long) U_25;
  U_26 = (long) U_24 + (long) 1L;
  mir_write_ulong(I_20 + I_21 * 8, U_26);
  i_27 = i0_counter;
  i_27 = (int) i_27 + (int) 1L;
  i0_counter = i_27;
  if ((int) i0_counter != (int) 128L) { mir_label = 2200; break; }
case 2201:
  mir_label = 2193; break;
  // Dead code: mir_label = 2202; break;
case 2200:
case 2202:
  mir_label = 2203; break;
case 2198:
case 2203:
case 2197:
case 2204:
  i_29 = i2_i;
  i_29 = (int) i_29 + (int) 1L;
  i2_i = i_29;
  if ((int) i2_i < (int) 1024L) { mir_label = 2194; break; }
case 2193:
  mir_label = 2205; break;
case 2191:
case 2205:
  mir_write_int(U0_count, i0_counter);
  I_31 = m2_S0_TextSplit_result;
  mir_set_stack_position(mir_saved_stack_position);
  return (long) I_31;
} // End of switch
} // End of while
} // End of function TextSplit

long m2_S0_TextSplit_result = mir_set_data_ulong(0L);
long unused_data_addr_2078 = mir_allocate(1016);
long m2_S0_TextSplit_buffer = mir_set_data_byte(0);
long unused_data_addr_2079 = mir_allocate(1023);
protected int m2_TextToInteger (long _U0_text) {
  long U0_text = _U0_text;
  long i0_value = 0;
  long i0_sign = 0;
  long i_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  long i_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long U_6 = 0;
  long i2_i = 0;
  long I_7 = 0;
  long i_8 = 0;
  long I_9 = 0;
  long i_10 = 0;
  long i_11 = 0;
  long I_12 = 0;
  long i_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long I_18 = 0;
  long i_19 = 0;
  long I_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  i0_value = 0L;
  i0_sign = 1L;
  i_0 = 0L;
  if ((int) mir_read_byte(U0_text + i_0) == (int) 43L) { mir_label = 2206; break; }
case 2207:
  i_2 = 0L;
  if ((int) mir_read_byte(U0_text + i_2) != (int) 45L) { mir_label = 2208; break; }
case 2206:
  i_4 = 0L;
  if ((int) mir_read_byte(U0_text + i_4) != (int) 45L) { mir_label = 2209; break; }
case 2210:
  i0_sign = -1L;
  mir_label = 2211; break;
case 2209:
case 2211:
  U_6 = U0_text;
  U_6 = (long) U_6 + (long) 1L;
  U0_text = U_6;
  mir_label = 2212; break;
case 2208:
case 2212:
  i2_i = 0L;
  I_7 = (long) (int) i2_i;
  if ((int) mir_read_byte(U0_text + I_7) < (int) 48L) { mir_label = 2213; break; }
case 2214:
  I_9 = (long) (int) i2_i;
  if ((int) mir_read_byte(U0_text + I_9) > (int) 57L) { mir_label = 2213; break; }
case 2215:
  i_11 = (int) i0_value * (int) 10L;
  I_12 = (long) (int) i2_i;
  i_13 = (int) mir_read_byte(U0_text + I_12) - (int) 48L;
  i_14 = i_13;
  i_15 = (int) i_11 + (int) i_14;
  i0_value = i_15;
case 2216:
  i_16 = i2_i;
  i_16 = (int) i_16 + (int) 1L;
  i2_i = i_16;
  I_18 = (long) (int) i2_i;
  if ((int) mir_read_byte(U0_text + I_18) < (int) 48L) { mir_label = 2213; break; }
case 2217:
  I_20 = (long) (int) i2_i;
  if ((int) mir_read_byte(U0_text + I_20) <= (int) 57L) { mir_label = 2215; break; }
case 2213:
  i_22 = (int) i0_value * (int) i0_sign;
  return (int) i_22;
} // End of switch
} // End of while
} // End of function TextToInteger

protected long m2_CodepointToUTF8 (int _i0_codepoint, long _U0_byteSize) {
  long i0_codepoint = _i0_codepoint;
  long U0_byteSize = _U0_byteSize;
  long fp = 0;
  long i0_size = 0;
  long i_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long i_5 = 0;
  long I_6 = 0;
  long i_7 = 0;
  long i_8 = 0;
  long i_9 = 0;
  long i_10 = 0;
  long I_11 = 0;
  long I_12 = 0;
  long I_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long I_17 = 0;
  long I_18 = 0;
  long i_19 = 0;
  long I_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long I_25 = 0;
  long I_26 = 0;
  long I_27 = 0;
  long i_28 = 0;
  long i_29 = 0;
  long i_30 = 0;
  long i_31 = 0;
  long I_32 = 0;
  long I_33 = 0;
  long I_34 = 0;
  long i_35 = 0;
  long i_36 = 0;
  long i_37 = 0;
  long I_38 = 0;
  long I_39 = 0;
  long i_40 = 0;
  long I_41 = 0;
  long i_42 = 0;
  long i_43 = 0;
  long i_44 = 0;
  long i_45 = 0;
  long I_46 = 0;
  long I_47 = 0;
  long I_48 = 0;
  long i_49 = 0;
  long i_50 = 0;
  long i_51 = 0;
  long i_52 = 0;
  long I_53 = 0;
  long I_54 = 0;
  long I_55 = 0;
  long i_56 = 0;
  long i_57 = 0;
  long i_58 = 0;
  long i_59 = 0;
  long I_60 = 0;
  long I_61 = 0;
  long I_62 = 0;
  long i_63 = 0;
  long i_64 = 0;
  long i_65 = 0;
  long I_66 = 0;
  long I_67 = 0;
  long I_68 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  i0_size = 0L;
  if ((int) i0_codepoint > (int) 127L) { mir_label = 2218; break; }
case 2219:
  I_1 = m2_S0_CodepointToUTF8_utf8;
  i_2 = 0L;
  I_3 = (long) (byte) i0_codepoint;
  I_4 = (long) (byte) I_3;
  mir_write_byte(I_1 + i_2, I_4);
  i0_size = 1L;
  mir_label = 2220; break;
case 2218:
  if ((int) i0_codepoint > (int) 2047L) { mir_label = 2221; break; }
case 2222:
  I_6 = m2_S0_CodepointToUTF8_utf8;
  i_7 = 0L;
  i_8 = (int) i0_codepoint >> (int) 6L;
  i_9 = (int) i_8 & (int) 31L;
  i_10 = (int) i_9 | (int) 192L;
  I_11 = (long) (byte) i_10;
  I_12 = (long) (byte) I_11;
  mir_write_byte(I_6 + i_7, I_12);
  I_13 = m2_S0_CodepointToUTF8_utf8;
  i_14 = 1L;
  i_15 = (int) i0_codepoint & (int) 63L;
  i_16 = (int) i_15 | (int) 128L;
  I_17 = (long) (byte) i_16;
  I_18 = (long) (byte) I_17;
  mir_write_byte(I_13 + i_14, I_18);
  i0_size = 2L;
  mir_label = 2223; break;
case 2221:
  if ((int) i0_codepoint > (int) 65535L) { mir_label = 2224; break; }
case 2225:
  I_20 = m2_S0_CodepointToUTF8_utf8;
  i_21 = 0L;
  i_22 = (int) i0_codepoint >> (int) 12L;
  i_23 = (int) i_22 & (int) 15L;
  i_24 = (int) i_23 | (int) 224L;
  I_25 = (long) (byte) i_24;
  I_26 = (long) (byte) I_25;
  mir_write_byte(I_20 + i_21, I_26);
  I_27 = m2_S0_CodepointToUTF8_utf8;
  i_28 = 1L;
  i_29 = (int) i0_codepoint >> (int) 6L;
  i_30 = (int) i_29 & (int) 63L;
  i_31 = (int) i_30 | (int) 128L;
  I_32 = (long) (byte) i_31;
  I_33 = (long) (byte) I_32;
  mir_write_byte(I_27 + i_28, I_33);
  I_34 = m2_S0_CodepointToUTF8_utf8;
  i_35 = 2L;
  i_36 = (int) i0_codepoint & (int) 63L;
  i_37 = (int) i_36 | (int) 128L;
  I_38 = (long) (byte) i_37;
  I_39 = (long) (byte) I_38;
  mir_write_byte(I_34 + i_35, I_39);
  i0_size = 3L;
  mir_label = 2226; break;
case 2224:
  if ((int) i0_codepoint > (int) 1114111L) { mir_label = 2227; break; }
case 2228:
  I_41 = m2_S0_CodepointToUTF8_utf8;
  i_42 = 0L;
  i_43 = (int) i0_codepoint >> (int) 18L;
  i_44 = (int) i_43 & (int) 7L;
  i_45 = (int) i_44 | (int) 240L;
  I_46 = (long) (byte) i_45;
  I_47 = (long) (byte) I_46;
  mir_write_byte(I_41 + i_42, I_47);
  I_48 = m2_S0_CodepointToUTF8_utf8;
  i_49 = 1L;
  i_50 = (int) i0_codepoint >> (int) 12L;
  i_51 = (int) i_50 & (int) 63L;
  i_52 = (int) i_51 | (int) 128L;
  I_53 = (long) (byte) i_52;
  I_54 = (long) (byte) I_53;
  mir_write_byte(I_48 + i_49, I_54);
  I_55 = m2_S0_CodepointToUTF8_utf8;
  i_56 = 2L;
  i_57 = (int) i0_codepoint >> (int) 6L;
  i_58 = (int) i_57 & (int) 63L;
  i_59 = (int) i_58 | (int) 128L;
  I_60 = (long) (byte) i_59;
  I_61 = (long) (byte) I_60;
  mir_write_byte(I_55 + i_56, I_61);
  I_62 = m2_S0_CodepointToUTF8_utf8;
  i_63 = 3L;
  i_64 = (int) i0_codepoint & (int) 63L;
  i_65 = (int) i_64 | (int) 128L;
  I_66 = (long) (byte) i_65;
  I_67 = (long) (byte) I_66;
  mir_write_byte(I_62 + i_63, I_67);
  i0_size = 4L;
  mir_label = 2229; break;
case 2227:
case 2229:
case 2226:
case 2223:
case 2220:
  mir_write_int(U0_byteSize, i0_size);
  I_68 = m2_S0_CodepointToUTF8_utf8;
  mir_set_stack_position(mir_saved_stack_position);
  return (long) I_68;
} // End of switch
} // End of while
} // End of function CodepointToUTF8

long m2_S0_CodepointToUTF8_utf8 = mir_set_data_byte(0);
long unused_data_addr_2080 = mir_allocate(5);
protected int m2_GetCodepointNext (long _U0_text, long _U0_codepointSize) {
  long U0_text = _U0_text;
  long U0_codepointSize = _U0_codepointSize;
  long U0_ptr = 0;
  long i0_codepoint = 0;
  long i_0 = 0;
  long i_1 = 0;
  long i_2 = 0;
  long i_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  long i_7 = 0;
  long i_8 = 0;
  long i_9 = 0;
  long i_10 = 0;
  long i_11 = 0;
  long i_12 = 0;
  long i_13 = 0;
  long i_14 = 0;
  long i_15 = 0;
  long i_16 = 0;
  long i_17 = 0;
  long i_18 = 0;
  long i_19 = 0;
  long i_20 = 0;
  long i_21 = 0;
  long i_22 = 0;
  long i_23 = 0;
  long i_24 = 0;
  long i_25 = 0;
  long i_26 = 0;
  long i_27 = 0;
  long i_28 = 0;
  long i_29 = 0;
  long i_30 = 0;
  long i_31 = 0;
  long i_32 = 0;
  long i_33 = 0;
  long i_34 = 0;
  long i_35 = 0;
  long i_36 = 0;
  long i_37 = 0;
  long i_38 = 0;
  long i_39 = 0;
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  U0_ptr = U0_text;
  i0_codepoint = 63L;
  mir_write_int(U0_codepointSize, 0L);
  i_0 = 0L;
  i_1 = (int) 248L & (int) mir_read_byte(U0_ptr + i_0);
  if ((int) 240L != (int) i_1) { mir_label = 2230; break; }
case 2231:
  i_3 = 0L;
  i_4 = (int) 7L & (int) mir_read_byte(U0_ptr + i_3);
  i_5 = (int) i_4 << (int) 18L;
  i_6 = 1L;
  i_7 = (int) 63L & (int) mir_read_byte(U0_ptr + i_6);
  i_8 = (int) i_7 << (int) 12L;
  i_9 = (int) i_5 | (int) i_8;
  i_10 = 2L;
  i_11 = (int) 63L & (int) mir_read_byte(U0_ptr + i_10);
  i_12 = (int) i_11 << (int) 6L;
  i_13 = (int) i_9 | (int) i_12;
  i_14 = 3L;
  i_15 = (int) 63L & (int) mir_read_byte(U0_ptr + i_14);
  i_16 = (int) i_13 | (int) i_15;
  i0_codepoint = i_16;
  mir_write_int(U0_codepointSize, 4L);
  mir_label = 2232; break;
case 2230:
  i_17 = 0L;
  i_18 = (int) 240L & (int) mir_read_byte(U0_ptr + i_17);
  if ((int) 224L != (int) i_18) { mir_label = 2233; break; }
case 2234:
  i_20 = 0L;
  i_21 = (int) 15L & (int) mir_read_byte(U0_ptr + i_20);
  i_22 = (int) i_21 << (int) 12L;
  i_23 = 1L;
  i_24 = (int) 63L & (int) mir_read_byte(U0_ptr + i_23);
  i_25 = (int) i_24 << (int) 6L;
  i_26 = (int) i_22 | (int) i_25;
  i_27 = 2L;
  i_28 = (int) 63L & (int) mir_read_byte(U0_ptr + i_27);
  i_29 = (int) i_26 | (int) i_28;
  i0_codepoint = i_29;
  mir_write_int(U0_codepointSize, 3L);
  mir_label = 2235; break;
case 2233:
  i_30 = 0L;
  i_31 = (int) 224L & (int) mir_read_byte(U0_ptr + i_30);
  if ((int) 192L != (int) i_31) { mir_label = 2236; break; }
case 2237:
  i_33 = 0L;
  i_34 = (int) 31L & (int) mir_read_byte(U0_ptr + i_33);
  i_35 = (int) i_34 << (int) 6L;
  i_36 = 1L;
  i_37 = (int) 63L & (int) mir_read_byte(U0_ptr + i_36);
  i_38 = (int) i_35 | (int) i_37;
  i0_codepoint = i_38;
  mir_write_int(U0_codepointSize, 2L);
  mir_label = 2238; break;
case 2236:
  i_39 = 0L;
  i0_codepoint = mir_read_byte(U0_ptr + i_39);
  mir_write_int(U0_codepointSize, 1L);
case 2238:
case 2235:
case 2232:
  return (int) i0_codepoint;
} // End of switch
} // End of while
} // End of function GetCodepointNext

public int GetGlyphIndex (long _I0_font, int _i0_codepoint) {
  long I0_font = _I0_font;
  long i0_codepoint = _i0_codepoint;
  long fp = 0;
  long I_0 = 0;
  long i0_index = 0;
  long i1_i = 0;
  long i_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long i_4 = 0;
  long i_5 = 0;
  long i_6 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(48L);
  I_0 = memcpy((long) fp, (long) I0_font, (long) 48L);
  i0_index = 63L;
  i1_i = 0L;
  if ((int) i1_i >= (int) mir_read_int(4L + fp)) { mir_label = 2239; break; }
case 2240:
  I_2 = (long) (int) i1_i;
  I_3 = mir_read_ulong(40L + fp);
  if ((int) mir_read_int(I_3 + I_2 * 40) != (int) i0_codepoint) { mir_label = 2241; break; }
case 2242:
  i0_index = i1_i;
  mir_label = 2239; break;
  // Dead code: mir_label = 2243; break;
case 2241:
case 2243:
case 2244:
  i_5 = i1_i;
  i_5 = (int) i_5 + (int) 1L;
  i1_i = i_5;
  if ((int) i1_i < (int) mir_read_int(4L + fp)) { mir_label = 2240; break; }
case 2239:
  mir_set_stack_position(mir_saved_stack_position);
  return (int) i0_index;
} // End of switch
} // End of while
} // End of function GetGlyphIndex

public void ClearBackground (long _I0_c) {
  long I0_c = _I0_c;
  long fp = 0;
  long I_0 = 0;
  long i_1 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  I_0 = 4L;
case 2245:
  I_0 = (long) I_0 - (long) 1L;
  mir_write_byte(fp + I_0, mir_read_byte(I0_c + I_0));
  if ((long) I_0 > (long) 0L) { mir_label = 2245; break; }
  i_1 = printf((long) mir_get_string_ptr("[DEBUG] ClearBackground()\n"));
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function ClearBackground

public int GetScreenWidth () {
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] GetScreenWidth()\n"));
  return (int) 640L;
} // End of function GetScreenWidth

public int GetScreenHeight () {
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] GetScreenHeight()\n"));
  return (int) 480L;
} // End of function GetScreenHeight

public void InitWindow (int _i0_screenWidth, int _i0_screenHeight, long _U0_screenName) {
  long i0_screenWidth = _i0_screenWidth;
  long i0_screenHeight = _i0_screenHeight;
  long U0_screenName = _U0_screenName;
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] InitWindow()\n"));
  return;
} // End of function InitWindow

public void BeginDrawing () {
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] BeginDrawing()\n"));
  return;
} // End of function BeginDrawing

public void EndDrawing () {
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] EndDrawing()\n"));
  return;
} // End of function EndDrawing

public void GetMousePosition (long _Ret_Addr) {
  long Ret_Addr = _Ret_Addr;
  long fp = 0;
  long i_0 = 0;
  float f_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(32L);
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] GetMousePosition()\n"));
  f_1 = (float) 0L;
  mir_write_float(fp, f_1);
  I_3 = (long) fp + (long) 4L;
  I_2 = memset((long) I_3, (int) 0L, (long) 20L);
  I_4 = memcpy((long) Ret_Addr, (long) fp, (long) 24L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of function GetMousePosition

public float GetMouseWheelMove () {
  long i_0 = 0;
  float f_1 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] GetMouseWheelMove()\n"));
  f_1 = (float) 0L;
  return (float) f_1;
} // End of function GetMouseWheelMove

public int IsMouseButtonDown (int _i0_button) {
  long i0_button = _i0_button;
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] IsMouseButtonDown()\n"));
  return (int) 0L;
} // End of function IsMouseButtonDown

public int IsMouseButtonPressed (int _i0_button) {
  long i0_button = _i0_button;
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] IsMouseButtonPressed()\n"));
  return (int) 0L;
} // End of function IsMouseButtonPressed

public int IsMouseButtonReleased (int _i0_button) {
  long i0_button = _i0_button;
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] IsMouseButtonReleased()\n"));
  return (int) 0L;
} // End of function IsMouseButtonReleased

public int IsKeyDown (int _i0_key) {
  long i0_key = _i0_key;
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] IsKeyDown()\n"));
  return (int) 0L;
} // End of function IsKeyDown

public int IsKeyPressed (int _i0_key) {
  long i0_key = _i0_key;
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] IsKeyPressed()\n"));
  return (int) 0L;
} // End of function IsKeyPressed

public int GetCharPressed () {
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] GetCharPressed()\n"));
  return (int) 0L;
} // End of function GetCharPressed

public void DrawRectangle (int _i0_x, int _i0_y, int _i0_width, int _i0_height, long _I0_color) {
  long i0_x = _i0_x;
  long i0_y = _i0_y;
  long i0_width = _i0_width;
  long i0_height = _i0_height;
  long I0_color = _I0_color;
  long fp = 0;
  long I_0 = 0;
  long i_1 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(16L);
  I_0 = 4L;
case 2246:
  I_0 = (long) I_0 - (long) 1L;
  mir_write_byte(fp + I_0, mir_read_byte(I0_color + I_0));
  if ((long) I_0 > (long) 0L) { mir_label = 2246; break; }
  i_1 = printf((long) mir_get_string_ptr("[DEBUG] DrawRectangle()\n"));
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function DrawRectangle

public void DrawRectangleGradientEx (long _I0_rec, long _I0_col1, long _I0_col2, long _I0_col3, long _I0_col4) {
  long I0_rec = _I0_rec;
  long I0_col1 = _I0_col1;
  long I0_col2 = _I0_col2;
  long I0_col3 = _I0_col3;
  long I0_col4 = _I0_col4;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long i_6 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(48L);
  I_0 = (long) fp + (long) 16L;
  I_1 = memcpy((long) I_0, (long) I0_rec, (long) 20L);
  I_2 = 4L;
case 2247:
  I_2 = (long) I_2 - (long) 1L;
  mir_write_byte(fp + I_2, mir_read_byte(I0_col1 + I_2));
  if ((long) I_2 > (long) 0L) { mir_label = 2247; break; }
  I_3 = 4L;
case 2248:
  I_3 = (long) I_3 - (long) 1L;
  mir_write_byte(4L + fp + I_3, mir_read_byte(I0_col2 + I_3));
  if ((long) I_3 > (long) 0L) { mir_label = 2248; break; }
  I_4 = 4L;
case 2249:
  I_4 = (long) I_4 - (long) 1L;
  mir_write_byte(8L + fp + I_4, mir_read_byte(I0_col3 + I_4));
  if ((long) I_4 > (long) 0L) { mir_label = 2249; break; }
  I_5 = 4L;
case 2250:
  I_5 = (long) I_5 - (long) 1L;
  mir_write_byte(12L + fp + I_5, mir_read_byte(I0_col4 + I_5));
  if ((long) I_5 > (long) 0L) { mir_label = 2250; break; }
  i_6 = printf((long) mir_get_string_ptr("[DEBUG] DrawRectangleGradientEx()\n"));
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function DrawRectangleGradientEx

public void DrawTriangle (long _I0_v1, long _I0_v2, long _I0_v3, long _I0_color) {
  long I0_v1 = _I0_v1;
  long I0_v2 = _I0_v2;
  long I0_v3 = _I0_v3;
  long I0_color = _I0_color;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long i_7 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(80L);
  I_0 = (long) fp + (long) 8L;
  I_1 = memcpy((long) I_0, (long) I0_v1, (long) 24L);
  I_2 = (long) fp + (long) 32L;
  I_3 = memcpy((long) I_2, (long) I0_v2, (long) 24L);
  I_4 = (long) fp + (long) 56L;
  I_5 = memcpy((long) I_4, (long) I0_v3, (long) 24L);
  I_6 = 4L;
case 2251:
  I_6 = (long) I_6 - (long) 1L;
  mir_write_byte(fp + I_6, mir_read_byte(I0_color + I_6));
  if ((long) I_6 > (long) 0L) { mir_label = 2251; break; }
  i_7 = printf((long) mir_get_string_ptr("[DEBUG] DrawTriangle()\n"));
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function DrawTriangle

public void DrawTextureRec (long _I0_texture, long _I0_sourceRec, long _I0_position, long _I0_tint) {
  long I0_texture = _I0_texture;
  long I0_sourceRec = _I0_sourceRec;
  long I0_position = _I0_position;
  long I0_tint = _I0_tint;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long i_7 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(80L);
  I_0 = (long) fp + (long) 4L;
  I_1 = memcpy((long) I_0, (long) I0_texture, (long) 20L);
  I_2 = (long) fp + (long) 24L;
  I_3 = memcpy((long) I_2, (long) I0_sourceRec, (long) 20L);
  I_4 = (long) fp + (long) 48L;
  I_5 = memcpy((long) I_4, (long) I0_position, (long) 24L);
  I_6 = 4L;
case 2252:
  I_6 = (long) I_6 - (long) 1L;
  mir_write_byte(fp + I_6, mir_read_byte(I0_tint + I_6));
  if ((long) I_6 > (long) 0L) { mir_label = 2252; break; }
  i_7 = printf((long) mir_get_string_ptr("[DEBUG] DrawTextureRec()\n"));
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function DrawTextureRec

public void DrawTextCodepoint (long _I0_font, int _i0_codepoint, long _I0_position, float f0_fontSize, long _I0_tint) {
  long I0_font = _I0_font;
  long i0_codepoint = _i0_codepoint;
  long I0_position = _I0_position;
  long I0_tint = _I0_tint;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long i_5 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(80L);
  I_0 = (long) fp + (long) 32L;
  I_1 = memcpy((long) I_0, (long) I0_font, (long) 48L);
  I_2 = (long) fp + (long) 8L;
  I_3 = memcpy((long) I_2, (long) I0_position, (long) 24L);
  I_4 = 4L;
case 2253:
  I_4 = (long) I_4 - (long) 1L;
  mir_write_byte(fp + I_4, mir_read_byte(I0_tint + I_4));
  if ((long) I_4 > (long) 0L) { mir_label = 2253; break; }
  i_5 = printf((long) mir_get_string_ptr("[DEBUG] DrawTextCodepoint()\n"));
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function DrawTextCodepoint

public void UnloadTexture (long _I0_texture) {
  long I0_texture = _I0_texture;
  long fp = 0;
  long I_0 = 0;
  long i_1 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(32L);
  I_0 = memcpy((long) fp, (long) I0_texture, (long) 20L);
  i_1 = printf((long) mir_get_string_ptr("[DEBUG] UnloadTexture()\n"));
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of function UnloadTexture

public int GetMaxCharWidth () {
  return (int) 10L;
} // End of function GetMaxCharWidth

public int GetMaxCharHeight () {
  return (int) 10L;
} // End of function GetMaxCharHeight

long m2_defaultFont = mir_set_data_int(0);
long unused_data_addr_2081 = mir_allocate(44);
public void GetFontDefault (long _Ret_Addr) {
  long Ret_Addr = _Ret_Addr;
  long fp = 0;
  long I_0 = 0;
  long i_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long i0_baseH = 0;
  long i_4 = 0;
  long i0_monoW = 0;
  long i_5 = 0;
  long i0_glyphCount = 0;
  long U0_rects = 0;
  long U_6 = 0;
  long U_7 = 0;
  long U_8 = 0;
  long U0_glyphs = 0;
  long U_9 = 0;
  long U_10 = 0;
  long U_11 = 0;
  long i2_i = 0;
  long i_12 = 0;
  long I_13 = 0;
  long i_14 = 0;
  float f_15 = 0;
  long I_16 = 0;
  float f_17 = 0;
  float f_18 = 0;
  long I_19 = 0;
  float f_20 = 0;
  long I_21 = 0;
  long I_22 = 0;
  long I_23 = 0;
  long I_24 = 0;
  long I_25 = 0;
  long I_26 = 0;
  long I_27 = 0;
  long I_28 = 0;
  long I_29 = 0;
  long I_30 = 0;
  long I_31 = 0;
  long I_32 = 0;
  long i_33 = 0;
  long i_34 = 0;
  long i_35 = 0;
  long I_36 = 0;
  long I_37 = 0;
  long I_38 = 0;
  long I_39 = 0;
  long I_40 = 0;
  long I_41 = 0;
  long I_42 = 0;
  long I_43 = 0;
  long I_44 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(176L);
  I_0 = m2_defaultFont;
  if ((long) mir_read_ulong(40L + I_0) == (long) 0L) { mir_label = 2254; break; }
case 2255:
  I_2 = m2_defaultFont;
  I_3 = memcpy((long) Ret_Addr, (long) I_2, (long) 48L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
  // Dead code: mir_label = 2256; break;
case 2254:
case 2256:
  i_4 = GetMaxCharHeight();
  i0_baseH = i_4;
  i_5 = GetMaxCharWidth();
  i0_monoW = i_5;
  i0_glyphCount = 128L;
  U_7 = (long) (int) i0_glyphCount;
  U_8 = (long) U_7 * (long) 20L;
  U_6 = malloc((long) U_8);
  U0_rects = U_6;
  U_10 = (long) (int) i0_glyphCount;
  U_11 = (long) U_10 * (long) 40L;
  U_9 = malloc((long) U_11);
  U0_glyphs = U_9;
  i2_i = 0L;
  if ((int) i2_i >= (int) i0_glyphCount) { mir_label = 2257; break; }
case 2258:
  I_13 = (long) (int) i2_i;
  i_14 = (int) i2_i * (int) i0_monoW;
  I_16 = (long) (int) i_14;
  f_15 = (float) I_16;
  mir_write_float(88L + fp, f_15);
  f_17 = (float) 0L;
  mir_write_float(92L + fp, f_17);
  I_19 = (long) (int) i0_monoW;
  f_18 = (float) I_19;
  mir_write_float(96L + fp, f_18);
  I_21 = (long) (int) i0_baseH;
  f_20 = (float) I_21;
  mir_write_float(100L + fp, f_20);
  I_23 = (long) fp + (long) 104L;
  I_22 = memset((long) I_23, (int) 0L, (long) 4L);
  I_24 = (long) I_13 * (long) 20L;
  I_24 = (long) I_24 + (long) U0_rects;
  I_26 = (long) fp + (long) 88L;
  I_25 = memcpy((long) I_24, (long) I_26, (long) 20L);
  I_27 = (long) (int) i2_i;
  mir_write_int(136L + fp, i2_i);
  mir_write_int(140L + fp, 0L);
  mir_write_int(144L + fp, 0L);
  mir_write_int(148L + fp, i0_monoW);
  mir_write_ulong(152L + fp, 0L);
  I_29 = (long) fp + (long) 160L;
  I_28 = memset((long) I_29, (int) 0L, (long) 16L);
  I_30 = (long) I_27 * (long) 40L;
  I_30 = (long) I_30 + (long) U0_glyphs;
  I_32 = (long) fp + (long) 136L;
  I_31 = memcpy((long) I_30, (long) I_32, (long) 40L);
case 2259:
  i_33 = i2_i;
  i_33 = (int) i_33 + (int) 1L;
  i2_i = i_33;
  if ((int) i2_i < (int) i0_glyphCount) { mir_label = 2258; break; }
case 2257:
  mir_write_uint(fp, 1L);
  i_35 = (int) i0_monoW * (int) i0_glyphCount;
  mir_write_int(4L + fp, i_35);
  mir_write_int(8L + fp, i0_baseH);
  mir_write_int(12L + fp, 1L);
  mir_write_int(16L + fp, 0L);
  I_36 = m2_defaultFont;
  mir_write_int(40L + fp, i0_baseH);
  mir_write_int(44L + fp, i0_glyphCount);
  I_38 = (long) fp + (long) 48L;
  I_37 = memcpy((long) I_38, (long) fp, (long) 20L);
  I_40 = (long) fp + (long) 68L;
  I_39 = memset((long) I_40, (int) 0L, (long) 4L);
  mir_write_ulong(72L + fp, U0_rects);
  mir_write_ulong(80L + fp, U0_glyphs);
  I_42 = (long) fp + (long) 40L;
  I_41 = memcpy((long) I_36, (long) I_42, (long) 48L);
  I_43 = m2_defaultFont;
  I_44 = memcpy((long) Ret_Addr, (long) I_43, (long) 48L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function GetFontDefault

public void DrawTextEx (long _I0_font, long _U0_text, long _I0_position, float f0_fontSize, float f0_spacing, long _I0_tint) {
  long I0_font = _I0_font;
  long U0_text = _U0_text;
  long I0_position = _I0_position;
  long I0_tint = _I0_tint;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long I_4 = 0;
  long i_5 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(80L);
  I_0 = (long) fp + (long) 32L;
  I_1 = memcpy((long) I_0, (long) I0_font, (long) 48L);
  I_2 = (long) fp + (long) 8L;
  I_3 = memcpy((long) I_2, (long) I0_position, (long) 24L);
  I_4 = 4L;
case 2260:
  I_4 = (long) I_4 - (long) 1L;
  mir_write_byte(fp + I_4, mir_read_byte(I0_tint + I_4));
  if ((long) I_4 > (long) 0L) { mir_label = 2260; break; }
  i_5 = printf((long) mir_get_string_ptr("[DEBUG] DrawTextEx()\n"));
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of switch
} // End of while
} // End of function DrawTextEx

public void SetShapesTexture (long _I0_tex, long _I0_rec) {
  long I0_tex = _I0_tex;
  long I0_rec = _I0_rec;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long i_3 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(48L);
  I_0 = memcpy((long) fp, (long) I0_tex, (long) 20L);
  I_1 = (long) fp + (long) 20L;
  I_2 = memcpy((long) I_1, (long) I0_rec, (long) 20L);
  i_3 = printf((long) mir_get_string_ptr("[DEBUG] SetShapesTexture()\n"));
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of function SetShapesTexture

public long LoadFileText (long _U0_fileName) {
  long U0_fileName = _U0_fileName;
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] LoadFileText()\n"));
  return (long) 0L;
} // End of function LoadFileText

public void LoadFontEx (long _Ret_Addr, long _U0_fileName, int _i0_fontSize, long _U0_fontChars, int _i0_glyphCount) {
  long Ret_Addr = _Ret_Addr;
  long U0_fileName = _U0_fileName;
  long i0_fontSize = _i0_fontSize;
  long U0_fontChars = _U0_fontChars;
  long i0_glyphCount = _i0_glyphCount;
  long fp = 0;
  long I_0 = 0;
  long I_1 = 0;
  long i_2 = 0;
  long I_3 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  fp = mir_allocate(48L);
  mir_write_int(fp, 0L);
  I_1 = (long) fp + (long) 4L;
  I_0 = memset((long) I_1, (int) 0L, (long) 44L);
  i_2 = printf((long) mir_get_string_ptr("[DEBUG] LoadFontEx()\n"));
  I_3 = memcpy((long) Ret_Addr, (long) fp, (long) 48L);
  mir_set_stack_position(mir_saved_stack_position);
  return;
} // End of function LoadFontEx

public long LoadText (long _U0_fileName) {
  long U0_fileName = _U0_fileName;
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] LoadText()\n"));
  return (long) 0L;
} // End of function LoadText

public long GetDirectoryPath (long _U0_filePath) {
  long U0_filePath = _U0_filePath;
  long i_0 = 0;
  i_0 = printf((long) mir_get_string_ptr("[DEBUG] GetDirectoryPath()\n"));
  return (long) 0L;
} // End of function GetDirectoryPath

public int main () {
  long fp = 0;
  long i0_screenWidth = 0;
  long i0_screenHeight = 0;
  long i0_dropDown000EditMode = 0;
  long i0_dropDown001EditMode = 0;
  long i0_spinnerEditMode = 0;
  long i0_valueBoxEditMode = 0;
  long I_0 = 0;
  long I_1 = 0;
  long I_2 = 0;
  long I_3 = 0;
  long i0_textBoxEditMode = 0;
  long i0_listViewActive = 0;
  long i0_listViewExActive = 0;
  long I_4 = 0;
  long I_5 = 0;
  long I_6 = 0;
  long I_7 = 0;
  long i0_multiTextBoxEditMode = 0;
  long I_8 = 0;
  long I_9 = 0;
  long I_10 = 0;
  long I_11 = 0;
  long i0_sliderValue = 0;
  long i0_sliderBarValue = 0;
  float f0_progressValue = 0;
  long i0_forceSquaredChecked = 0;
  float f0_alphaValue = 0;
  long i0_comboBoxActive = 0;
  long i0_toggleGroupActive = 0;
  float f_12 = 0;
  float f_13 = 0;
  long I_14 = 0;
  long I_15 = 0;
  long i0_exitWindow = 0;
  long i0_showMessageBox = 0;
  long I_16 = 0;
  long I_17 = 0;
  long I_18 = 0;
  long i0_showTextInputBox = 0;
  long I_19 = 0;
  long I_20 = 0;
  long I_21 = 0;
  long I_22 = 0;
  long i_23 = 0;
  long I_24 = 0;
  long I_25 = 0;
  long I_26 = 0;
  long i_27 = 0;
  long I_28 = 0;
  long i_29 = 0;
  long I_30 = 0;
  long I_31 = 0;
  long i_32 = 0;
  long I_33 = 0;
  long I_34 = 0;
  long I_35 = 0;
  long I_36 = 0;
  long i_37 = 0;
  float f_38 = 0;
  float f_39 = 0;
  float f_40 = 0;
  float f_41 = 0;
  long I_42 = 0;
  long I_43 = 0;
  long I_44 = 0;
  long i_45 = 0;
  float f_46 = 0;
  float f_47 = 0;
  float f_48 = 0;
  float f_49 = 0;
  long I_50 = 0;
  long I_51 = 0;
  long I_52 = 0;
  long U_53 = 0;
  long I_54 = 0;
  long I_55 = 0;
  long I_56 = 0;
  long i_57 = 0;
  float f_58 = 0;
  float f_59 = 0;
  float f_60 = 0;
  float f_61 = 0;
  long I_62 = 0;
  long I_63 = 0;
  long I_64 = 0;
  long U_65 = 0;
  long I_66 = 0;
  long I_67 = 0;
  long I_68 = 0;
  long i_69 = 0;
  float f_70 = 0;
  float f_71 = 0;
  float f_72 = 0;
  float f_73 = 0;
  long I_74 = 0;
  long I_75 = 0;
  long I_76 = 0;
  long I_77 = 0;
  long I_78 = 0;
  long I_79 = 0;
  long I_80 = 0;
  long i_81 = 0;
  float f_82 = 0;
  float f_83 = 0;
  float f_84 = 0;
  float f_85 = 0;
  long I_86 = 0;
  long I_87 = 0;
  long I_88 = 0;
  long U_89 = 0;
  long I_90 = 0;
  float f_91 = 0;
  float f_92 = 0;
  float f_93 = 0;
  float f_94 = 0;
  long I_95 = 0;
  long I_96 = 0;
  long I_97 = 0;
  long i_98 = 0;
  float f_99 = 0;
  float f_100 = 0;
  float f_101 = 0;
  float f_102 = 0;
  long I_103 = 0;
  long I_104 = 0;
  long I_105 = 0;
  long I_106 = 0;
  long i_107 = 0;
  float f_108 = 0;
  float f_109 = 0;
  float f_110 = 0;
  float f_111 = 0;
  long I_112 = 0;
  long I_113 = 0;
  long I_114 = 0;
  long I_115 = 0;
  long i_116 = 0;
  float f_117 = 0;
  float f_118 = 0;
  float f_119 = 0;
  float f_120 = 0;
  long I_121 = 0;
  long I_122 = 0;
  long I_123 = 0;
  long I_124 = 0;
  long i_125 = 0;
  float f_126 = 0;
  float f_127 = 0;
  float f_128 = 0;
  float f_129 = 0;
  long I_130 = 0;
  long I_131 = 0;
  long I_132 = 0;
  long I_133 = 0;
  long i_134 = 0;
  float f_135 = 0;
  float f_136 = 0;
  float f_137 = 0;
  float f_138 = 0;
  long I_139 = 0;
  long I_140 = 0;
  long I_141 = 0;
  long i_142 = 0;
  float f_143 = 0;
  float f_144 = 0;
  float f_145 = 0;
  float f_146 = 0;
  long I_147 = 0;
  long I_148 = 0;
  long I_149 = 0;
  long U_150 = 0;
  long I_151 = 0;
  long I_152 = 0;
  long I_153 = 0;
  long i_154 = 0;
  float f_155 = 0;
  float f_156 = 0;
  float f_157 = 0;
  float f_158 = 0;
  long I_159 = 0;
  long I_160 = 0;
  long I_161 = 0;
  long U_162 = 0;
  long I_163 = 0;
  long I_164 = 0;
  long I_165 = 0;
  long i_166 = 0;
  float f_167 = 0;
  float f_168 = 0;
  float f_169 = 0;
  float f_170 = 0;
  long I_171 = 0;
  long I_172 = 0;
  long I_173 = 0;
  long U_174 = 0;
  long i_175 = 0;
  float f_176 = 0;
  float f_177 = 0;
  float f_178 = 0;
  float f_179 = 0;
  long I_180 = 0;
  long I_181 = 0;
  long I_182 = 0;
  long I_183 = 0;
  long U_184 = 0;
  long U_185 = 0;
  long i_186 = 0;
  float f_187 = 0;
  float f_188 = 0;
  float f_189 = 0;
  float f_190 = 0;
  long I_191 = 0;
  long I_192 = 0;
  long I_193 = 0;
  long i_194 = 0;
  float f_195 = 0;
  float f_196 = 0;
  float f_197 = 0;
  float f_198 = 0;
  long I_199 = 0;
  long I_200 = 0;
  long I_201 = 0;
  long I_202 = 0;
  long I_203 = 0;
  long I_204 = 0;
  long I_205 = 0;
  long I_206 = 0;
  float f_207 = 0;
  float f_208 = 0;
  float f_209 = 0;
  float f_210 = 0;
  long I_211 = 0;
  long I_212 = 0;
  long I_213 = 0;
  long I_214 = 0;
  long I_215 = 0;
  float f_216 = 0;
  float f_217 = 0;
  float f_218 = 0;
  float f_219 = 0;
  float f_220 = 0;
  long I_221 = 0;
  long I_222 = 0;
  long I_223 = 0;
  long U_224 = 0;
  float f_225 = 0;
  long I_226 = 0;
  double d_227 = 0;
  float f_228 = 0;
  long I_229 = 0;
  float f_230 = 0;
  float f_231 = 0;
  long i_232 = 0;
  float f_233 = 0;
  float f_234 = 0;
  float f_235 = 0;
  float f_236 = 0;
  float f_237 = 0;
  long I_238 = 0;
  long I_239 = 0;
  long I_240 = 0;
  long U_241 = 0;
  long i_242 = 0;
  float f_243 = 0;
  long I_244 = 0;
  float f_245 = 0;
  float f_246 = 0;
  long i_247 = 0;
  float f_248 = 0;
  float f_249 = 0;
  float f_250 = 0;
  float f_251 = 0;
  float f_252 = 0;
  long I_253 = 0;
  long I_254 = 0;
  long I_255 = 0;
  float f_256 = 0;
  float f_257 = 0;
  long I_258 = 0;
  float f_259 = 0;
  float f_260 = 0;
  float f_261 = 0;
  float f_262 = 0;
  long I_263 = 0;
  long I_264 = 0;
  long I_265 = 0;
  float f_266 = 0;
  float f_267 = 0;
  float f_268 = 0;
  float f_269 = 0;
  long I_270 = 0;
  long I_271 = 0;
  long I_272 = 0;
  long U_273 = 0;
  long I_274 = 0;
  long I_275 = 0;
  float f_276 = 0;
  float f_277 = 0;
  float f_278 = 0;
  float f_279 = 0;
  long I_280 = 0;
  long I_281 = 0;
  long I_282 = 0;
  long I_283 = 0;
  float f_284 = 0;
  float f_285 = 0;
  float f_286 = 0;
  float f_287 = 0;
  long I_288 = 0;
  long I_289 = 0;
  long I_290 = 0;
  float f_291 = 0;
  float f_292 = 0;
  long i_293 = 0;
  float f_294 = 0;
  long I_295 = 0;
  float f_296 = 0;
  float f_297 = 0;
  long i_298 = 0;
  float f_299 = 0;
  long I_300 = 0;
  float f_301 = 0;
  long I_302 = 0;
  long I_303 = 0;
  long I_304 = 0;
  float f_305 = 0;
  float f_306 = 0;
  float f_307 = 0;
  float f_308 = 0;
  float f_309 = 0;
  long I_310 = 0;
  long I_311 = 0;
  long I_312 = 0;
  long I_313 = 0;
  long i_314 = 0;
  long i_315 = 0;
  long I_316 = 0;
  long I_317 = 0;
  long I_318 = 0;
  long I_319 = 0;
  long I_320 = 0;
  long I_321 = 0;
  long i6_result = 0;
  long i_322 = 0;
  long i_323 = 0;
  float f_324 = 0;
  long I_325 = 0;
  float f_326 = 0;
  float f_327 = 0;
  float f_328 = 0;
  float f_329 = 0;
  long i_330 = 0;
  float f_331 = 0;
  long I_332 = 0;
  float f_333 = 0;
  float f_334 = 0;
  float f_335 = 0;
  float f_336 = 0;
  float f_337 = 0;
  float f_338 = 0;
  long I_339 = 0;
  long I_340 = 0;
  long I_341 = 0;
  long U_342 = 0;
  long i_343 = 0;
  long i_344 = 0;
  long i_345 = 0;
  long I_346 = 0;
  long i_347 = 0;
  long i_348 = 0;
  long I_349 = 0;
  long I_350 = 0;
  long I_351 = 0;
  long I_352 = 0;
  long I_353 = 0;
  long I_354 = 0;
  long i7_result = 0;
  long i_355 = 0;
  long i_356 = 0;
  float f_357 = 0;
  long I_358 = 0;
  float f_359 = 0;
  float f_360 = 0;
  float f_361 = 0;
  float f_362 = 0;
  long i_363 = 0;
  float f_364 = 0;
  long I_365 = 0;
  float f_366 = 0;
  float f_367 = 0;
  float f_368 = 0;
  float f_369 = 0;
  float f_370 = 0;
  float f_371 = 0;
  long I_372 = 0;
  long I_373 = 0;
  long I_374 = 0;
  long U_375 = 0;
  long I_376 = 0;
  long i_377 = 0;
  long U_378 = 0;
  long I_379 = 0;
  long I_380 = 0;
  long i_381 = 0;
  long i_382 = 0;
  long i_383 = 0;
  long U_384 = 0;
  long I_385 = 0;
  long I_386 = 0;
  int mir_saved_stack_position =  mir_get_stack_position();
  int mir_label = -1;
while (true) {
switch (mir_label) {
case -1:
  fp = mir_allocate(1584L);
  i0_screenWidth = 690L;
  i0_screenHeight = 560L;
  InitWindow((int) i0_screenWidth, (int) i0_screenHeight, (long) mir_get_string_ptr("raygui - controls test suite"));
  GuiSetStyle((int) 0L, (int) 16L, (int) 16L);
  mir_write_int(fp, 0L);
  i0_dropDown000EditMode = 0L;
  mir_write_int(4L + fp, 0L);
  i0_dropDown001EditMode = 0L;
  mir_write_int(8L + fp, 0L);
  i0_spinnerEditMode = 0L;
  mir_write_int(12L + fp, 0L);
  i0_valueBoxEditMode = 0L;
  I_1 = (long) fp + (long) 64L;
  I_0 = memcpy((long) I_1, (long) mir_get_string_ptr("Text box"), (long) 9L);
  I_3 = (long) fp + (long) 73L;
  I_2 = memset((long) I_3, (int) 0L, (long) 55L);
  i0_textBoxEditMode = 0L;
  mir_write_int(16L + fp, 0L);
  i0_listViewActive = -1L;
  mir_write_int(20L + fp, 0L);
  i0_listViewExActive = 2L;
  mir_write_int(24L + fp, -1L);
  mir_write_ulong(128L + fp, mir_get_string_ptr("This"));
  mir_write_ulong(136L + fp, mir_get_string_ptr("is"));
  mir_write_ulong(144L + fp, mir_get_string_ptr("a"));
  mir_write_ulong(152L + fp, mir_get_string_ptr("list view"));
  mir_write_ulong(160L + fp, mir_get_string_ptr("with"));
  mir_write_ulong(168L + fp, mir_get_string_ptr("disable"));
  mir_write_ulong(176L + fp, mir_get_string_ptr("elements"));
  mir_write_ulong(184L + fp, mir_get_string_ptr("amazing!"));
  I_5 = (long) fp + (long) 192L;
  I_4 = memcpy((long) I_5, (long) mir_get_string_ptr("Multi text box"), (long) 15L);
  I_7 = (long) fp + (long) 207L;
  I_6 = memset((long) I_7, (int) 0L, (long) 241L);
  i0_multiTextBoxEditMode = 0L;
  I_8 = (((long) (int) 230L) & 0xFFL);
  mir_write_ubyte(28L + fp, I_8);
  I_9 = (((long) (int) 41L) & 0xFFL);
  mir_write_ubyte(29L + fp, I_9);
  I_10 = (((long) (int) 55L) & 0xFFL);
  mir_write_ubyte(30L + fp, I_10);
  I_11 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(31L + fp, I_11);
  i0_sliderValue = 50L;
  i0_sliderBarValue = 60L;
  f0_progressValue = 0.400000006f;
  i0_forceSquaredChecked = 0L;
  f0_alphaValue = 0.5f;
  i0_comboBoxActive = 1L;
  i0_toggleGroupActive = 0L;
  f_12 = (float) 0L;
  mir_write_float(40L + fp, f_12);
  f_13 = (float) 0L;
  mir_write_float(44L + fp, f_13);
  I_15 = (long) fp + (long) 48L;
  I_14 = memset((long) I_15, (int) 0L, (long) 16L);
  i0_exitWindow = 0L;
  i0_showMessageBox = 0L;
  I_16 = (long) (byte) 0L;
  mir_write_byte(448L + fp, I_16);
  I_18 = (long) fp + (long) 449L;
  I_17 = memset((long) I_18, (int) 0L, (long) 255L);
  i0_showTextInputBox = 0L;
  I_19 = (long) (byte) 0L;
  mir_write_byte(704L + fp, I_19);
  I_21 = (long) fp + (long) 705L;
  I_20 = memset((long) I_21, (int) 0L, (long) 255L);
case 2261:
  I_22 = (long) (int) i0_exitWindow;
  if (((long) I_22 != 0)) { mir_label = 2262; break; }
case 2263:
  i_23 = IsKeyPressed((int) 256L);
  I_24 = (long) (int) i_23;
  if (((long) I_24 == 0)) { mir_label = 2264; break; }
case 2265:
  I_26 = (long) (int) i0_showMessageBox;
  if (((long) I_26 == 0)) { mir_label = 2266; break; }
case 2267:
  I_25 = 0L;
  mir_label = 2268; break;
case 2266:
  I_25 = 1L;
case 2268:
  i0_showMessageBox = I_25;
  mir_label = 2269; break;
case 2264:
case 2269:
  i_27 = IsKeyDown((int) 341L);
  I_28 = (long) (int) i_27;
  if (((long) I_28 == 0)) { mir_label = 2270; break; }
case 2271:
  i_29 = IsKeyPressed((int) 83L);
  I_30 = (long) (int) i_29;
  if (((long) I_30 == 0)) { mir_label = 2270; break; }
case 2272:
  i0_showTextInputBox = 1L;
  mir_label = 2273; break;
case 2270:
case 2273:
  BeginDrawing();
  I_31 = (long) fp + (long) 1552L;
  i_32 = GuiGetStyle((int) 0L, (int) 19L);
  m2_GetColor((long) I_31, (int) i_32);
  ClearBackground((long) I_31);
  I_33 = (long) (int) i0_dropDown000EditMode;
  if (((long) I_33 != 0)) { mir_label = 2274; break; }
case 2275:
  I_34 = (long) (int) i0_dropDown001EditMode;
  if (((long) I_34 == 0)) { mir_label = 2276; break; }
case 2274:
  GuiLock();
  mir_label = 2277; break;
case 2276:
  I_35 = (long) (int) i0_dropDown000EditMode;
  if (((long) I_35 != 0)) { mir_label = 2278; break; }
case 2279:
  I_36 = (long) (int) i0_dropDown001EditMode;
  if (((long) I_36 != 0)) { mir_label = 2278; break; }
case 2280:
  GuiUnlock();
  mir_label = 2281; break;
case 2278:
case 2281:
case 2277:
  f_38 = (float) 25L;
  mir_write_float(960L + fp, f_38);
  f_39 = (float) 108L;
  mir_write_float(964L + fp, f_39);
  f_40 = (float) 15L;
  mir_write_float(968L + fp, f_40);
  f_41 = (float) 15L;
  mir_write_float(972L + fp, f_41);
  I_43 = (long) fp + (long) 976L;
  I_42 = memset((long) I_43, (int) 0L, (long) 4L);
  I_44 = (long) fp + (long) 960L;
  i_37 = GuiCheckBox((long) I_44, (long) mir_get_string_ptr("FORCE CHECK!"), (int) i0_forceSquaredChecked);
  i0_forceSquaredChecked = i_37;
  GuiSetStyle((int) 9L, (int) 14L, (int) 1L);
  f_46 = (float) 25L;
  mir_write_float(980L + fp, f_46);
  f_47 = (float) 135L;
  mir_write_float(984L + fp, f_47);
  f_48 = (float) 125L;
  mir_write_float(988L + fp, f_48);
  f_49 = (float) 30L;
  mir_write_float(992L + fp, f_49);
  I_51 = (long) fp + (long) 996L;
  I_50 = memset((long) I_51, (int) 0L, (long) 4L);
  I_52 = (long) fp + (long) 980L;
  U_53 = 8L;
  U_53 = (long) U_53 + (long) fp;
  i_45 = GuiSpinner((long) I_52, (long) 0L, (long) U_53, (int) 0L, (int) 100L, (int) i0_spinnerEditMode);
  I_54 = (long) (int) i_45;
  if (((long) I_54 == 0)) { mir_label = 2282; break; }
case 2283:
  I_56 = (long) (int) i0_spinnerEditMode;
  if (((long) I_56 == 0)) { mir_label = 2284; break; }
case 2285:
  I_55 = 0L;
  mir_label = 2286; break;
case 2284:
  I_55 = 1L;
case 2286:
  i0_spinnerEditMode = I_55;
  mir_label = 2287; break;
case 2282:
case 2287:
  f_58 = (float) 25L;
  mir_write_float(1000L + fp, f_58);
  f_59 = (float) 175L;
  mir_write_float(1004L + fp, f_59);
  f_60 = (float) 125L;
  mir_write_float(1008L + fp, f_60);
  f_61 = (float) 30L;
  mir_write_float(1012L + fp, f_61);
  I_63 = (long) fp + (long) 1016L;
  I_62 = memset((long) I_63, (int) 0L, (long) 4L);
  I_64 = (long) fp + (long) 1000L;
  U_65 = 12L;
  U_65 = (long) U_65 + (long) fp;
  i_57 = GuiValueBox((long) I_64, (long) 0L, (long) U_65, (int) 0L, (int) 100L, (int) i0_valueBoxEditMode);
  I_66 = (long) (int) i_57;
  if (((long) I_66 == 0)) { mir_label = 2288; break; }
case 2289:
  I_68 = (long) (int) i0_valueBoxEditMode;
  if (((long) I_68 == 0)) { mir_label = 2290; break; }
case 2291:
  I_67 = 0L;
  mir_label = 2292; break;
case 2290:
  I_67 = 1L;
case 2292:
  i0_valueBoxEditMode = I_67;
  mir_label = 2293; break;
case 2288:
case 2293:
  GuiSetStyle((int) 9L, (int) 14L, (int) 0L);
  f_70 = (float) 25L;
  mir_write_float(1020L + fp, f_70);
  f_71 = (float) 215L;
  mir_write_float(1024L + fp, f_71);
  f_72 = (float) 125L;
  mir_write_float(1028L + fp, f_72);
  f_73 = (float) 30L;
  mir_write_float(1032L + fp, f_73);
  I_75 = (long) fp + (long) 1036L;
  I_74 = memset((long) I_75, (int) 0L, (long) 4L);
  I_76 = (long) fp + (long) 1020L;
  I_77 = (long) fp + (long) 64L;
  i_69 = GuiTextBox((long) I_76, (long) I_77, (int) 64L, (int) i0_textBoxEditMode);
  I_78 = (long) (int) i_69;
  if (((long) I_78 == 0)) { mir_label = 2294; break; }
case 2295:
  I_80 = (long) (int) i0_textBoxEditMode;
  if (((long) I_80 == 0)) { mir_label = 2296; break; }
case 2297:
  I_79 = 0L;
  mir_label = 2298; break;
case 2296:
  I_79 = 1L;
case 2298:
  i0_textBoxEditMode = I_79;
  mir_label = 2299; break;
case 2294:
case 2299:
  GuiSetStyle((int) 2L, (int) 14L, (int) 1L);
  f_82 = (float) 25L;
  mir_write_float(1040L + fp, f_82);
  f_83 = (float) 255L;
  mir_write_float(1044L + fp, f_83);
  f_84 = (float) 125L;
  mir_write_float(1048L + fp, f_84);
  f_85 = (float) 30L;
  mir_write_float(1052L + fp, f_85);
  I_87 = (long) fp + (long) 1056L;
  I_86 = memset((long) I_87, (int) 0L, (long) 4L);
  I_88 = (long) fp + (long) 1040L;
  U_89 = GuiIconText((int) 6L, (long) mir_get_string_ptr("Save File"));
  i_81 = GuiButton((long) I_88, (long) U_89);
  I_90 = (long) (int) i_81;
  if (((long) I_90 == 0)) { mir_label = 2300; break; }
case 2301:
  i0_showTextInputBox = 1L;
  mir_label = 2302; break;
case 2300:
case 2302:
  f_91 = (float) 25L;
  mir_write_float(1060L + fp, f_91);
  f_92 = (float) 310L;
  mir_write_float(1064L + fp, f_92);
  f_93 = (float) 125L;
  mir_write_float(1068L + fp, f_93);
  f_94 = (float) 150L;
  mir_write_float(1072L + fp, f_94);
  I_96 = (long) fp + (long) 1076L;
  I_95 = memset((long) I_96, (int) 0L, (long) 4L);
  I_97 = (long) fp + (long) 1060L;
  GuiGroupBox((long) I_97, (long) mir_get_string_ptr("STATES"));
  GuiSetState((int) 0L);
  f_99 = (float) 30L;
  mir_write_float(1080L + fp, f_99);
  f_100 = (float) 320L;
  mir_write_float(1084L + fp, f_100);
  f_101 = (float) 115L;
  mir_write_float(1088L + fp, f_101);
  f_102 = (float) 30L;
  mir_write_float(1092L + fp, f_102);
  I_104 = (long) fp + (long) 1096L;
  I_103 = memset((long) I_104, (int) 0L, (long) 4L);
  I_105 = (long) fp + (long) 1080L;
  i_98 = GuiButton((long) I_105, (long) mir_get_string_ptr("NORMAL"));
  I_106 = (long) (int) i_98;
  if (((long) I_106 == 0)) { mir_label = 2303; break; }
case 2304:
  mir_label = 2305; break;
case 2303:
case 2305:
  GuiSetState((int) 1L);
  f_108 = (float) 30L;
  mir_write_float(1100L + fp, f_108);
  f_109 = (float) 355L;
  mir_write_float(1104L + fp, f_109);
  f_110 = (float) 115L;
  mir_write_float(1108L + fp, f_110);
  f_111 = (float) 30L;
  mir_write_float(1112L + fp, f_111);
  I_113 = (long) fp + (long) 1116L;
  I_112 = memset((long) I_113, (int) 0L, (long) 4L);
  I_114 = (long) fp + (long) 1100L;
  i_107 = GuiButton((long) I_114, (long) mir_get_string_ptr("FOCUSED"));
  I_115 = (long) (int) i_107;
  if (((long) I_115 == 0)) { mir_label = 2306; break; }
case 2307:
  mir_label = 2308; break;
case 2306:
case 2308:
  GuiSetState((int) 2L);
  f_117 = (float) 30L;
  mir_write_float(1120L + fp, f_117);
  f_118 = (float) 390L;
  mir_write_float(1124L + fp, f_118);
  f_119 = (float) 115L;
  mir_write_float(1128L + fp, f_119);
  f_120 = (float) 30L;
  mir_write_float(1132L + fp, f_120);
  I_122 = (long) fp + (long) 1136L;
  I_121 = memset((long) I_122, (int) 0L, (long) 4L);
  I_123 = (long) fp + (long) 1120L;
  i_116 = GuiButton((long) I_123, (long) mir_get_string_ptr("#15#PRESSED"));
  I_124 = (long) (int) i_116;
  if (((long) I_124 == 0)) { mir_label = 2309; break; }
case 2310:
  mir_label = 2311; break;
case 2309:
case 2311:
  GuiSetState((int) 3L);
  f_126 = (float) 30L;
  mir_write_float(1140L + fp, f_126);
  f_127 = (float) 425L;
  mir_write_float(1144L + fp, f_127);
  f_128 = (float) 115L;
  mir_write_float(1148L + fp, f_128);
  f_129 = (float) 30L;
  mir_write_float(1152L + fp, f_129);
  I_131 = (long) fp + (long) 1156L;
  I_130 = memset((long) I_131, (int) 0L, (long) 4L);
  I_132 = (long) fp + (long) 1140L;
  i_125 = GuiButton((long) I_132, (long) mir_get_string_ptr("DISABLED"));
  I_133 = (long) (int) i_125;
  if (((long) I_133 == 0)) { mir_label = 2312; break; }
case 2313:
  mir_label = 2314; break;
case 2312:
case 2314:
  GuiSetState((int) 0L);
  f_135 = (float) 25L;
  mir_write_float(1160L + fp, f_135);
  f_136 = (float) 470L;
  mir_write_float(1164L + fp, f_136);
  f_137 = (float) 125L;
  mir_write_float(1168L + fp, f_137);
  f_138 = (float) 30L;
  mir_write_float(1172L + fp, f_138);
  I_140 = (long) fp + (long) 1176L;
  I_139 = memset((long) I_140, (int) 0L, (long) 4L);
  I_141 = (long) fp + (long) 1160L;
  i_134 = GuiComboBox((long) I_141, (long) mir_get_string_ptr("ONE;TWO;THREE;FOUR"), (int) i0_comboBoxActive);
  i0_comboBoxActive = i_134;
  GuiSetStyle((int) 8L, (int) 14L, (int) 0L);
  f_143 = (float) 25L;
  mir_write_float(1180L + fp, f_143);
  f_144 = (float) 65L;
  mir_write_float(1184L + fp, f_144);
  f_145 = (float) 125L;
  mir_write_float(1188L + fp, f_145);
  f_146 = (float) 30L;
  mir_write_float(1192L + fp, f_146);
  I_148 = (long) fp + (long) 1196L;
  I_147 = memset((long) I_148, (int) 0L, (long) 4L);
  I_149 = (long) fp + (long) 1180L;
  U_150 = 4L;
  U_150 = (long) U_150 + (long) fp;
  i_142 = GuiDropdownBox((long) I_149, (long) mir_get_string_ptr("#01#ONE;#02#TWO;#03#THREE;#04#FOUR"), (long) U_150, (int) i0_dropDown001EditMode);
  I_151 = (long) (int) i_142;
  if (((long) I_151 == 0)) { mir_label = 2315; break; }
case 2316:
  I_153 = (long) (int) i0_dropDown001EditMode;
  if (((long) I_153 == 0)) { mir_label = 2317; break; }
case 2318:
  I_152 = 0L;
  mir_label = 2319; break;
case 2317:
  I_152 = 1L;
case 2319:
  i0_dropDown001EditMode = I_152;
  mir_label = 2320; break;
case 2315:
case 2320:
  GuiSetStyle((int) 8L, (int) 14L, (int) 1L);
  f_155 = (float) 25L;
  mir_write_float(1200L + fp, f_155);
  f_156 = (float) 25L;
  mir_write_float(1204L + fp, f_156);
  f_157 = (float) 125L;
  mir_write_float(1208L + fp, f_157);
  f_158 = (float) 30L;
  mir_write_float(1212L + fp, f_158);
  I_160 = (long) fp + (long) 1216L;
  I_159 = memset((long) I_160, (int) 0L, (long) 4L);
  I_161 = (long) fp + (long) 1200L;
  U_162 = fp;
  i_154 = GuiDropdownBox((long) I_161, (long) mir_get_string_ptr("ONE;TWO;THREE"), (long) U_162, (int) i0_dropDown000EditMode);
  I_163 = (long) (int) i_154;
  if (((long) I_163 == 0)) { mir_label = 2321; break; }
case 2322:
  I_165 = (long) (int) i0_dropDown000EditMode;
  if (((long) I_165 == 0)) { mir_label = 2323; break; }
case 2324:
  I_164 = 0L;
  mir_label = 2325; break;
case 2323:
  I_164 = 1L;
case 2325:
  i0_dropDown000EditMode = I_164;
  mir_label = 2326; break;
case 2321:
case 2326:
  f_167 = (float) 165L;
  mir_write_float(1220L + fp, f_167);
  f_168 = (float) 25L;
  mir_write_float(1224L + fp, f_168);
  f_169 = (float) 140L;
  mir_write_float(1228L + fp, f_169);
  f_170 = (float) 140L;
  mir_write_float(1232L + fp, f_170);
  I_172 = (long) fp + (long) 1236L;
  I_171 = memset((long) I_172, (int) 0L, (long) 4L);
  I_173 = (long) fp + (long) 1220L;
  U_174 = 16L;
  U_174 = (long) U_174 + (long) fp;
  i_166 = GuiListView((long) I_173, (long) mir_get_string_ptr("Charmander;Bulbasaur;#18#Squirtel;Pikachu;Eevee;Pidgey"), (long) U_174, (int) i0_listViewActive);
  i0_listViewActive = i_166;
  f_176 = (float) 165L;
  mir_write_float(1240L + fp, f_176);
  f_177 = (float) 180L;
  mir_write_float(1244L + fp, f_177);
  f_178 = (float) 140L;
  mir_write_float(1248L + fp, f_178);
  f_179 = (float) 200L;
  mir_write_float(1252L + fp, f_179);
  I_181 = (long) fp + (long) 1256L;
  I_180 = memset((long) I_181, (int) 0L, (long) 4L);
  I_182 = (long) fp + (long) 1240L;
  I_183 = (long) fp + (long) 128L;
  U_184 = 24L;
  U_184 = (long) U_184 + (long) fp;
  U_185 = 20L;
  U_185 = (long) U_185 + (long) fp;
  i_175 = GuiListViewEx((long) I_182, (long) I_183, (int) 8L, (long) U_184, (long) U_185, (int) i0_listViewExActive);
  i0_listViewExActive = i_175;
  f_187 = (float) 165L;
  mir_write_float(1260L + fp, f_187);
  f_188 = (float) 400L;
  mir_write_float(1264L + fp, f_188);
  f_189 = (float) 140L;
  mir_write_float(1268L + fp, f_189);
  f_190 = (float) 25L;
  mir_write_float(1272L + fp, f_190);
  I_192 = (long) fp + (long) 1276L;
  I_191 = memset((long) I_192, (int) 0L, (long) 4L);
  I_193 = (long) fp + (long) 1260L;
  i_186 = GuiToggleGroup((long) I_193, (long) mir_get_string_ptr("#1#ONE\n#3#TWO\n#8#THREE\n#23#"), (int) i0_toggleGroupActive);
  i0_toggleGroupActive = i_186;
  f_195 = (float) 320L;
  mir_write_float(1280L + fp, f_195);
  f_196 = (float) 25L;
  mir_write_float(1284L + fp, f_196);
  f_197 = (float) 225L;
  mir_write_float(1288L + fp, f_197);
  f_198 = (float) 140L;
  mir_write_float(1292L + fp, f_198);
  I_200 = (long) fp + (long) 1296L;
  I_199 = memset((long) I_200, (int) 0L, (long) 4L);
  I_201 = (long) fp + (long) 1280L;
  I_202 = (long) fp + (long) 192L;
  i_194 = GuiTextBoxMulti((long) I_201, (long) I_202, (int) 256L, (int) i0_multiTextBoxEditMode);
  I_203 = (long) (int) i_194;
  if (((long) I_203 == 0)) { mir_label = 2327; break; }
case 2328:
  I_205 = (long) (int) i0_multiTextBoxEditMode;
  if (((long) I_205 == 0)) { mir_label = 2329; break; }
case 2330:
  I_204 = 0L;
  mir_label = 2331; break;
case 2329:
  I_204 = 1L;
case 2331:
  i0_multiTextBoxEditMode = I_204;
  mir_label = 2332; break;
case 2327:
case 2332:
  I_206 = (long) fp + (long) 1552L;
  f_207 = (float) 320L;
  mir_write_float(1300L + fp, f_207);
  f_208 = (float) 185L;
  mir_write_float(1304L + fp, f_208);
  f_209 = (float) 196L;
  mir_write_float(1308L + fp, f_209);
  f_210 = (float) 192L;
  mir_write_float(1312L + fp, f_210);
  I_212 = (long) fp + (long) 1316L;
  I_211 = memset((long) I_212, (int) 0L, (long) 4L);
  I_213 = (long) fp + (long) 1300L;
  I_214 = (long) fp + (long) 28L;
  GuiColorPicker((long) I_206, (long) I_213, (long) 0L, (long) I_214);
  I_215 = 4L;
case 2333:
  I_215 = (long) I_215 - (long) 1L;
  mir_write_byte(28L + fp + I_215, mir_read_byte(I_206 + I_215));
  if ((long) I_215 > (long) 0L) { mir_label = 2333; break; }
  f_217 = (float) 355L;
  mir_write_float(1320L + fp, f_217);
  f_218 = (float) 400L;
  mir_write_float(1324L + fp, f_218);
  f_219 = (float) 165L;
  mir_write_float(1328L + fp, f_219);
  f_220 = (float) 20L;
  mir_write_float(1332L + fp, f_220);
  I_222 = (long) fp + (long) 1336L;
  I_221 = memset((long) I_222, (int) 0L, (long) 4L);
  I_223 = (long) fp + (long) 1320L;
  I_226 = (long) (int) i0_sliderValue;
  f_225 = (float) I_226;
  d_227 = (double) f_225;
  U_224 = m2_TextFormat((long) mir_get_string_ptr("%2.2f"), d_227);
  I_229 = (long) (int) i0_sliderValue;
  f_228 = (float) I_229;
  f_230 = (float) -50L;
  f_231 = (float) 100L;
  f_216 = GuiSlider((long) I_223, (long) mir_get_string_ptr("TEST"), (long) U_224, (float) f_228, (float) f_230, (float) f_231);
  i_232 = (long) f_216;
  i0_sliderValue = i_232;
  f_234 = (float) 320L;
  mir_write_float(1340L + fp, f_234);
  f_235 = (float) 430L;
  mir_write_float(1344L + fp, f_235);
  f_236 = (float) 200L;
  mir_write_float(1348L + fp, f_236);
  f_237 = (float) 20L;
  mir_write_float(1352L + fp, f_237);
  I_239 = (long) fp + (long) 1356L;
  I_238 = memset((long) I_239, (int) 0L, (long) 4L);
  I_240 = (long) fp + (long) 1340L;
  i_242 = i0_sliderBarValue;
  U_241 = m2_TextFormat((long) mir_get_string_ptr("%i"), i_242);
  I_244 = (long) (int) i0_sliderBarValue;
  f_243 = (float) I_244;
  f_245 = (float) 0L;
  f_246 = (float) 100L;
  f_233 = GuiSliderBar((long) I_240, (long) 0L, (long) U_241, (float) f_243, (float) f_245, (float) f_246);
  i_247 = (long) f_233;
  i0_sliderBarValue = i_247;
  f_249 = (float) 320L;
  mir_write_float(1360L + fp, f_249);
  f_250 = (float) 460L;
  mir_write_float(1364L + fp, f_250);
  f_251 = (float) 200L;
  mir_write_float(1368L + fp, f_251);
  f_252 = (float) 20L;
  mir_write_float(1372L + fp, f_252);
  I_254 = (long) fp + (long) 1376L;
  I_253 = memset((long) I_254, (int) 0L, (long) 4L);
  I_255 = (long) fp + (long) 1360L;
  f_256 = (float) 0L;
  f_257 = (float) 1L;
  f_248 = GuiProgressBar((long) I_255, (long) 0L, (long) 0L, (float) f0_progressValue, (float) f_256, (float) f_257);
  f0_progressValue = f_248;
  I_258 = (long) fp + (long) 1552L;
  f_259 = (float) 560L;
  mir_write_float(1400L + fp, f_259);
  f_260 = (float) 25L;
  mir_write_float(1404L + fp, f_260);
  f_261 = (float) 100L;
  mir_write_float(1408L + fp, f_261);
  f_262 = (float) 160L;
  mir_write_float(1412L + fp, f_262);
  I_264 = (long) fp + (long) 1416L;
  I_263 = memset((long) I_264, (int) 0L, (long) 4L);
  I_265 = (long) fp + (long) 1400L;
  f_266 = (float) 560L;
  mir_write_float(1420L + fp, f_266);
  f_267 = (float) 25L;
  mir_write_float(1424L + fp, f_267);
  f_268 = (float) 200L;
  mir_write_float(1428L + fp, f_268);
  f_269 = (float) 400L;
  mir_write_float(1432L + fp, f_269);
  I_271 = (long) fp + (long) 1436L;
  I_270 = memset((long) I_271, (int) 0L, (long) 4L);
  I_272 = (long) fp + (long) 1420L;
  U_273 = 40L;
  U_273 = (long) U_273 + (long) fp;
  GuiScrollPanel((long) I_258, (long) I_265, (long) 0L, (long) I_272, (long) U_273);
  I_275 = (long) fp + (long) 1380L;
  I_274 = memcpy((long) I_275, (long) I_258, (long) 20L);
  f_276 = (float) 560L;
  mir_write_float(1440L + fp, f_276);
  f_277 = (float) 205L;
  mir_write_float(1444L + fp, f_277);
  f_278 = (float) 100L;
  mir_write_float(1448L + fp, f_278);
  f_279 = (float) 160L;
  mir_write_float(1452L + fp, f_279);
  I_281 = (long) fp + (long) 1456L;
  I_280 = memset((long) I_281, (int) 0L, (long) 4L);
  I_282 = (long) fp + (long) 1440L;
  GuiPanel((long) I_282, (long) mir_get_string_ptr("Panel Info"));
  I_283 = (long) fp + (long) 1552L;
  f_284 = (float) 560L;
  mir_write_float(1460L + fp, f_284);
  f_285 = (float) 385L;
  mir_write_float(1464L + fp, f_285);
  f_286 = (float) 100L;
  mir_write_float(1468L + fp, f_286);
  f_287 = (float) 120L;
  mir_write_float(1472L + fp, f_287);
  I_289 = (long) fp + (long) 1476L;
  I_288 = memset((long) I_289, (int) 0L, (long) 4L);
  I_290 = (long) fp + (long) 1460L;
  f_291 = (float) 20L;
  GuiGrid((long) I_283, (long) I_290, (long) 0L, (float) f_291, (int) 2L);
  f_292 = (float) 0L;
  mir_write_float(1480L + fp, f_292);
  i_293 = GetScreenHeight();
  I_295 = (long) (int) i_293;
  f_294 = (float) I_295;
  f_296 = (float) 20L;
  f_297 = f_294 - f_296;
  mir_write_float(1484L + fp, f_297);
  i_298 = GetScreenWidth();
  I_300 = (long) (int) i_298;
  f_299 = (float) I_300;
  mir_write_float(1488L + fp, f_299);
  f_301 = (float) 20L;
  mir_write_float(1492L + fp, f_301);
  I_303 = (long) fp + (long) 1496L;
  I_302 = memset((long) I_303, (int) 0L, (long) 4L);
  I_304 = (long) fp + (long) 1480L;
  GuiStatusBar((long) I_304, (long) mir_get_string_ptr("This is a status bar"));
  f_306 = (float) 320L;
  mir_write_float(1500L + fp, f_306);
  f_307 = (float) 490L;
  mir_write_float(1504L + fp, f_307);
  f_308 = (float) 200L;
  mir_write_float(1508L + fp, f_308);
  f_309 = (float) 30L;
  mir_write_float(1512L + fp, f_309);
  I_311 = (long) fp + (long) 1516L;
  I_310 = memset((long) I_311, (int) 0L, (long) 4L);
  I_312 = (long) fp + (long) 1500L;
  f_305 = GuiColorBarAlpha((long) I_312, (long) 0L, (float) f0_alphaValue);
  f0_alphaValue = f_305;
  I_313 = (long) (int) i0_showMessageBox;
  if (((long) I_313 == 0)) { mir_label = 2334; break; }
case 2335:
  i_314 = GetScreenWidth();
  i_315 = GetScreenHeight();
  I_316 = (long) fp + (long) 1552L;
  I_317 = (((long) (int) 245L) & 0xFFL);
  mir_write_ubyte(1520L + fp, I_317);
  I_318 = (((long) (int) 245L) & 0xFFL);
  mir_write_ubyte(1521L + fp, I_318);
  I_319 = (((long) (int) 245L) & 0xFFL);
  mir_write_ubyte(1522L + fp, I_319);
  I_320 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(1523L + fp, I_320);
  I_321 = (long) fp + (long) 1520L;
  m2_Fade((long) I_316, (long) I_321, (float) 0.800000012f);
  DrawRectangle((int) 0L, (int) 0L, (int) i_314, (int) i_315, (long) I_316);
  i_323 = GetScreenWidth();
  I_325 = (long) (int) i_323;
  f_324 = (float) I_325;
  f_326 = (float) 2L;
  f_327 = f_324 / f_326;
  f_328 = (float) 125L;
  f_329 = f_327 - f_328;
  mir_write_float(1524L + fp, f_329);
  i_330 = GetScreenHeight();
  I_332 = (long) (int) i_330;
  f_331 = (float) I_332;
  f_333 = (float) 2L;
  f_334 = f_331 / f_333;
  f_335 = (float) 50L;
  f_336 = f_334 - f_335;
  mir_write_float(1528L + fp, f_336);
  f_337 = (float) 250L;
  mir_write_float(1532L + fp, f_337);
  f_338 = (float) 100L;
  mir_write_float(1536L + fp, f_338);
  I_340 = (long) fp + (long) 1540L;
  I_339 = memset((long) I_340, (int) 0L, (long) 4L);
  I_341 = (long) fp + (long) 1524L;
  U_342 = GuiIconText((int) 159L, (long) mir_get_string_ptr("Close Window"));
  i_322 = GuiMessageBox((long) I_341, (long) U_342, (long) mir_get_string_ptr("Do you really want to exit?"), (long) mir_get_string_ptr("Yes;No"));
  i6_result = i_322;
  if ((int) i6_result == (int) 0L) { mir_label = 2336; break; }
case 2337:
  if ((int) i6_result != (int) 2L) { mir_label = 2338; break; }
case 2336:
  i0_showMessageBox = 0L;
  mir_label = 2339; break;
case 2338:
  if ((int) i6_result != (int) 1L) { mir_label = 2340; break; }
case 2341:
  i0_exitWindow = 1L;
  mir_label = 2342; break;
case 2340:
case 2342:
case 2339:
  mir_label = 2343; break;
case 2334:
case 2343:
  I_346 = (long) (int) i0_showTextInputBox;
  if (((long) I_346 == 0)) { mir_label = 2344; break; }
case 2345:
  i_347 = GetScreenWidth();
  i_348 = GetScreenHeight();
  I_349 = (long) fp + (long) 1552L;
  I_350 = (((long) (int) 245L) & 0xFFL);
  mir_write_ubyte(1520L + fp, I_350);
  I_351 = (((long) (int) 245L) & 0xFFL);
  mir_write_ubyte(1521L + fp, I_351);
  I_352 = (((long) (int) 245L) & 0xFFL);
  mir_write_ubyte(1522L + fp, I_352);
  I_353 = (((long) (int) 255L) & 0xFFL);
  mir_write_ubyte(1523L + fp, I_353);
  I_354 = (long) fp + (long) 1520L;
  m2_Fade((long) I_349, (long) I_354, (float) 0.800000012f);
  DrawRectangle((int) 0L, (int) 0L, (int) i_347, (int) i_348, (long) I_349);
  i_356 = GetScreenWidth();
  I_358 = (long) (int) i_356;
  f_357 = (float) I_358;
  f_359 = (float) 2L;
  f_360 = f_357 / f_359;
  f_361 = (float) 120L;
  f_362 = f_360 - f_361;
  mir_write_float(1524L + fp, f_362);
  i_363 = GetScreenHeight();
  I_365 = (long) (int) i_363;
  f_364 = (float) I_365;
  f_366 = (float) 2L;
  f_367 = f_364 / f_366;
  f_368 = (float) 60L;
  f_369 = f_367 - f_368;
  mir_write_float(1528L + fp, f_369);
  f_370 = (float) 240L;
  mir_write_float(1532L + fp, f_370);
  f_371 = (float) 140L;
  mir_write_float(1536L + fp, f_371);
  I_373 = (long) fp + (long) 1540L;
  I_372 = memset((long) I_373, (int) 0L, (long) 4L);
  I_374 = (long) fp + (long) 1524L;
  U_375 = GuiIconText((int) 6L, (long) mir_get_string_ptr("Save file as..."));
  I_376 = (long) fp + (long) 448L;
  i_355 = GuiTextInputBox((long) I_374, (long) mir_get_string_ptr("Save"), (long) U_375, (long) mir_get_string_ptr("Ok;Cancel"), (long) I_376, (int) 255L, (long) 0L);
  i7_result = i_355;
  if ((int) i7_result != (int) 1L) { mir_label = 2346; break; }
case 2347:
  I_379 = (long) fp + (long) 704L;
  I_380 = (long) fp + (long) 448L;
  U_378 = strcpy((long) I_379, (long) I_380);
  mir_label = 2348; break;
case 2346:
case 2348:
  if ((int) i7_result == (int) 0L) { mir_label = 2349; break; }
case 2350:
  if ((int) i7_result == (int) 1L) { mir_label = 2349; break; }
case 2351:
  if ((int) i7_result != (int) 2L) { mir_label = 2352; break; }
case 2349:
  i0_showTextInputBox = 0L;
  I_385 = (long) fp + (long) 448L;
  U_384 = strcpy((long) I_385, (long) mir_get_string_ptr("\0"));
  mir_label = 2353; break;
case 2352:
case 2353:
  mir_label = 2354; break;
case 2344:
case 2354:
  EndDrawing();
  I_386 = (long) (int) i0_exitWindow;
  if (((long) I_386 == 0)) { mir_label = 2263; break; }
case 2262:
  mir_set_stack_position(mir_saved_stack_position);
  return (int) 0L;
} // End of switch
} // End of while
} // End of function main

} // End of class Main
