#ifndef float_h
#define float_h

/// @file
/// 80-bit long double are not supported (and will not be).

/// The rounding mode for floating-point addition is characterized by the implementation-defined value of FLT_ROUNDS:
/// -1 indeterminable
///  0 toward zero
///  1 to nearest
///  2 toward positive infinity
///  3 toward negative infinity
/// All other values for FLT_ROUNDS characterize implementation-defined rounding behavior.
#define FLT_ROUNDS (-1)

/// Except for assignment and cast (which remove all extra range and precision), the values
/// yielded by operators with floating operands and values subject to the usual arithmetic
/// conversions and of floating constants are evaluated to a format whose range and precision
/// may be greater than required by the type. The use of evaluation formats is characterized
/// by the implementation-defined value of FLT_EVAL_METHOD:24)
/// -1 indeterminable;
///  0 evaluate all operations and constants just to the range and precision of the type;
///  1 evaluate operations and constants of type float and double to the
///    range and precision of the double type, evaluate long double
///    operations and constants to the range and precision of the long double type;
///  2 evaluate all operations and constants to the range and precision of the long double type.
/// All other negative values for FLT_EVAL_METHOD characterize implementation-defined behavior.
#define FLT_EVAL_METHOD (-1)

/// The presence or absence of subnormal numbers is characterized by the implementation-
/// defined values of FLT_HAS_SUBNORM, DBL_HAS_SUBNORM, and LDBL_HAS_SUBNORM:
/// -1 indeterminable
///  0 absent (type does not support subnormal numbers)
///  1 present (type does support subnormal numbers)
#define FLT_HAS_SUBNORM (-1)
#define DBL_HAS_SUBNORM (-1)
#define LDBL_HAS_SUBNORM (-1)

#define FLT_RADIX 2

#define DECIMAL_DIG 17

#define FLT_MANT_DIG 24
#define DBL_MANT_DIG 53
#define LDBL_MANT_DIG DBL_MANT_DIG

#define FLT_DECIMAL_DIG 9
#define DBL_DECIMAL_DIG 17
#define LDBL_DECIMAL_DIG DBL_DECIMAL_DIG

#define FLT_DIG 6
#define DBL_DIG 15
#define LDBL_DIG DBL_DIG

#define FLT_MIN_EXP (-125)
#define DBL_MIN_EXP (-1021)
#define LDBL_MIN_EXP DBL_MIN_EXP

#define FLT_MIN_10_EXP (-37)
#define DBL_MIN_10_EXP (-307)
#define LDBL_MIN_10_EXP DBL_MIN_10_EXP

#define FLT_MAX_EXP 128
#define DBL_MAX_EXP 1024
#define LDBL_MAX_EXP DBL_MAX_EXP

#define FLT_MAX_10_EXP 38
#define DBL_MAX_10_EXP 308
#define LDBL_MAX_10_EXP DBL_MAX_10_EXP

#define FLT_MIN 0x1.0p-126f // 1.17549435e-38f
#define DBL_MIN 0x1.0p-1022 // 2.2250738585072014e-308
#define LDBL_MIN DBL_MIN

#define FLT_MAX 0x1.fffffep127f // 3.40282347e+38f
#define DBL_MAX 0x1.fffffffffffffp1023 // 1.7976931348623157e+308
#define LDBL_MAX DBL_MAX

#define FLT_TRUE_MIN 0x1.0p-149f // 1.40129846e-45f
#define DBL_TRUE_MIN 0x1.0p-1074 // 4.9406564584124654e-324
#define LDBL_TRUE_MIN DBL_TRUE_MIN

#define FLT_EPSILON 0x1.0p-23f // 1.19209290e-07f
#define DBL_EPSILON 0x1.0p-52 // 2.2204460492503131e-16
#define LDBL_EPSILON DBL_EPSILON

#endif
