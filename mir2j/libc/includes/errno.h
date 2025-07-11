#ifndef errno_h
#define errno_h

#include "stddef.h"

extern errno_t __errno;
//int __errno;

#define errno __errno

#define EDOM 1
#define EILSEQ 2
#define ERANGE 3

// Needed to build with libraries from Linux and Windows.
#if defined(__unix__)
#define EINVAL 22
#endif

#endif
