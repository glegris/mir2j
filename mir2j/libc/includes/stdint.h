#ifndef stdint_h
#define stdint_h

#include "stddef.h"

//--------------------------------------------------------------------------------
// Exact size integer types.
//--------------------------------------------------------------------------------
typedef signed char int8_t;
#define INT8_MIN -128
#define INT8_MAX 127

typedef unsigned char uint8_t;
#define UINT8_MAX 255

typedef signed short int16_t;
#define INT16_MIN -32768
#define INT16_MAX 32767

typedef unsigned short uint16_t;
#define UINT16_MAX 65535

typedef signed int int32_t;
#define INT32_MIN (-2147483647l - 1)
#define INT32_MAX 2147483647l

typedef unsigned int uint32_t;
#define UINT32_MAX 4294967295ul

typedef signed long long int int64_t;
#define INT64_MIN (-9223372036854775807ll - 1)
#define INT64_MAX 9223372036854775807ll

typedef unsigned long long int uint64_t;
#define UINT64_MAX 18446744073709551615ull

//--------------------------------------------------------------------------------
// Least-size integer types of a minimum width.
//--------------------------------------------------------------------------------
typedef int8_t int_least8_t;
#define INT_LEAST8_MIN INT8_MIN
#define INT_LEAST8_MAX INT8_MAX
#define INT8_C(value) ((int_least8_t)(value))

typedef uint8_t uint_least8_t;
#define UINT_LEAST8_MAX UINT8_MAX
#define UINT8_C(value) ((uint_least8_t)(value))

typedef int16_t int_least16_t;
#define INT_LEAST16_MIN INT16_MIN
#define INT_LEAST16_MAX INT16_MAX
#define INT16_C(value) ((int_least16_t)(value))

typedef uint16_t uint_least16_t;
#define UINT_LEAST16_MAX UINT16_MAX
#define UINT16_C(value) ((uint_least16_t)(value))

typedef int32_t int_least32_t;
#define INT_LEAST32_MIN INT32_MIN
#define INT_LEAST32_MAX INT32_MAX
#define INT32_C(value) ((int_least32_t)(value))

typedef uint32_t uint_least32_t;
#define UINT_LEAST32_MAX UINT32_MAX
#define UINT32_C(value) ((uint_least32_t)(value))

typedef int64_t int_least64_t;
#define INT_LEAST64_MIN INT64_MIN
#define INT_LEAST64_MAX INT64_MAX
#define INT64_C(value) ((int_least64_t)(value))

typedef uint64_t uint_least64_t;
#define UINT_LEAST64_MAX UINT64_MAX
#define UINT64_C(value) ((uint_least64_t)(value))

//--------------------------------------------------------------------------------
// Fast integer types of a minimum width.
//--------------------------------------------------------------------------------
typedef int32_t int_fast8_t;
#define INT_FAST8_MIN INT32_MIN
#define INT_FAST8_MAX INT32_MAX

typedef uint32_t uint_fast8_t;
#define UINT_FAST8_MAX UINT32_MAX

typedef int32_t int_fast16_t;
#define INT_FAST16_MIN INT32_MIN
#define INT_FAST16_MAX INT32_MAX

typedef uint32_t uint_fast16_t;
#define UINT_FAST16_MAX UINT32_MAX

typedef int32_t int_fast32_t;
#define INT_FAST32_MIN INT32_MIN
#define INT_FAST32_MAX INT32_MAX

typedef uint32_t uint_fast32_t;
#define UINT_FAST32_MAX UINT32_MAX

typedef int64_t int_fast64_t;
#define INT_FAST64_MIN INT64_MIN
#define INT_FAST64_MAX INT64_MAX

typedef uint64_t uint_fast64_t;
#define UINT_FAST64_MAX UINT64_MAX

//--------------------------------------------------------------------------------
// Maximum-size integer types.
//--------------------------------------------------------------------------------
typedef int64_t intmax_t;
#define INTMAX_MIN INT64_MIN
#define INTMAX_MAX INT64_MAX
#define INTMAX_C(value) ((intmax_t)(value))

typedef uint64_t uintmax_t;
#define UINTMAX_MAX UINT64_MAX
#define UINTMAX_C(value) ((uintmax_t)(value))

//--------------------------------------------------------------------------------
// Pointer-size.
//--------------------------------------------------------------------------------
#if defined(__64bit__)

typedef int64_t intptr_t;
#define INTPTR_MIN INT64_MIN
#define INTPTR_MAX INT64_MAX

typedef uint64_t uintptr_t;
#define UINTPTR_MAX UINT64_MAX

#define PTRDIFF_MIN INT64_MIN
#define PTRDIFF_MAX INT64_MAX

#else

typedef int32_t intptr_t;
#define INTPTR_MIN INT32_MIN
#define INTPTR_MAX INT32_MAX

typedef uint32_t uintptr_t;
#define UINTPTR_MAX UINT32_MAX

#define PTRDIFF_MIN INT32_MIN
#define PTRDIFF_MAX INT32_MAX

#endif

//--------------------------------------------------------------------------------
// Size.
//--------------------------------------------------------------------------------
#define SIZE_MAX UINT32_MAX

//#if defined(__STDC_WANT_LIB_EXT1__)
typedef size_t rsize_t;
#define RSIZE_MAX ((size_t)SIZE_MAX)
//#endif

//--------------------------------------------------------------------------------
// Wide char.
//--------------------------------------------------------------------------------
#define WCHAR_MIN 0
#define WCHAR_MAX UINT16_MAX

#define WINT_MIN 0
#define WINT_MAX UINT16_MAX

//--------------------------------------------------------------------------------
// Atomic.
//--------------------------------------------------------------------------------
#define SIG_ATOMIC_MIN __ // TODO
#define SIG_ATOMIC_MAX __ // TODO

#endif
