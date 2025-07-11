#ifndef stddef_h
#define stddef_h

/**
 * @file
 *
 * <stddef.h> - C11 7.19: Common definitions.
 *
 * @see http://libc11.org/stddef/
 */

/**
 * The signed integer type of the result of subtracting two pointers.
 */
#if defined(__64bit__)
typedef signed long long ptrdiff_t;
#else
typedef signed long ptrdiff_t;
#endif

/**
 * The unsigned integer type of the result of the `sizeof` operator.
 */
#if defined(__64bit__)
typedef unsigned long long size_t;
#else
typedef unsigned long size_t;
#endif

/**
 * An object type whose alignment is as great as is supported by the
 * implementation in all contexts.
 */
typedef struct { long long __ll; long double __ld; } max_align_t;

/**
 * An integer type whose range of values can represent distinct codes for
 * all members of the largest extended character set specified among the
 * supported locales.
 */
typedef unsigned short wchar_t;

/**
 * Null pointer constant.
 */
#define NULL ((void*)0)

/**
 * The offset in bytes to the structure member from the beginning of its
 * structure.
 */
#define offsetof(type, member) ((size_t)&(((type*)0)->member))

typedef int errno_t;

#endif
