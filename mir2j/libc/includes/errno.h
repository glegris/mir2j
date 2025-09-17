#ifndef errno_h
#define errno_h

#include "stddef.h"

extern errno_t __errno;
//int __errno;

#define errno __errno

#define EDOM 33 /* Numerical argument out of domain */
#define EILSEQ 84 /* Invalid or incomplete multibyte or wide character */
#define ERANGE 34 /* Numerical result out of range*/
#define	ENOMEM 12 /* Not enough core */

// Needed to build with libraries from Linux and Windows.
#if defined(__unix__)
#define EINVAL 22
#endif

#endif
