#ifndef limits_h
#define limits_h

#define CHAR_BIT 8
#if defined(__THENESIS_CHAR_IS_SIGNED__)
#define CHAR_MIN SCHAR_MIN
#define CHAR_MAX SCHAR_MAX
#else
#define CHAR_MIN UCHAR_MIN
#define CHAR_MAX UCHAR_MAX
#endif
#define SCHAR_MIN (-128)
#define SCHAR_MAX (+127)
#define UCHAR_MAX (255)
#define SHRT_MIN (-32768)
#define SHRT_MAX (+32767)
#define USHRT_MAX (65535)
#define INT_MIN (-2147483647 - 1)
#define INT_MAX (+2147483647)
#define UINT_MAX (4294967295)
#define LONG_MIN (-2147483647l - 1)
#define LONG_MAX (+2147483647l)
#define ULONG_MAX (4294967295ul)
#define LLONG_MIN (-9223372036854775807ll - 1)
#define LLONG_MAX (+9223372036854775807ll)
#define ULLONG_MAX (18446744073709551615ull)
#define MB_LEN_MAX (1)

#endif
