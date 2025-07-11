#ifndef stdarg_h
#define stdarg_h

#if 0
#ifdef __GNUC__

typedef __builtin_va_list _LP_LIBC_va_list;
#define _LP_LIBC_va_arg( ap, type ) (__builtin_va_arg( (ap), type ))
#define _LP_LIBC_va_copy( dest, src ) (__builtin_va_copy( (dest), (src) ))
#define _LP_LIBC_va_end( ap ) (__builtin_va_end( ap ) )
#define _LP_LIBC_va_start( ap, parmN ) (__builtin_va_start( (ap), (parmN) ))

//#elif (defined(__i386__) || defined(__i386) || defined(_M_IX86)) && !(defined(__amd64__) || defined(__x86_64__) || defined(_M_AMD64))
#else

/* Internal helper macro. va_round is not part of <stdarg.h>. */
#define _LP_LIBC_va_round( type ) ( (sizeof(type) + sizeof(void *) - 1) & ~(sizeof(void *) - 1) )
typedef char * _LP_LIBC_va_list;
#define _LP_LIBC_va_arg( ap, type ) ( (ap) += (_LP_LIBC_va_round(type)), ( *(type*) ( (ap) - (_LP_LIBC_va_round(type)) ) ) )
#define _LP_LIBC_va_copy( dest, src ) ( (dest) = (src), (void)0 )
#define _LP_LIBC_va_end( ap ) ( (ap) = (void *)0, (void)0 )
#define _LP_LIBC_va_start( ap, parmN ) ( (ap) = (char *) &parmN + ( _LP_LIBC_va_round(parmN) ), (void)0 )

//#else

//#error "The compiler/architecture doesn't support varargs"

#endif

typedef _LP_LIBC_va_list va_list;

#define va_arg( ap, type )    _LP_LIBC_va_arg( ap, type )
#define va_copy( dest, src )  _LP_LIBC_va_copy( dest, src )
#define va_end( ap )          _LP_LIBC_va_end( ap )
#define va_start( ap, parmN ) _LP_LIBC_va_start( ap, parmN )

#endif

#endif // #if 0
