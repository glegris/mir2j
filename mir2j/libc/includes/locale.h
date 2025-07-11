#ifndef locale_h
#define locale_h

#include <stdlib.h>

// TODO: Structure for locale conversion.
#if 0
struct lconv {
	
};
#endif

#define LC_ALL 0
#define LC_COLLATE 1
#define LC_CTYPE 2
#define LC_MONETARY 3
#define LC_NUMERIC 4
#define LC_TIME 5

char *setlocale(int category, const char *locale);
struct lconv *localeconv(void);

#endif
