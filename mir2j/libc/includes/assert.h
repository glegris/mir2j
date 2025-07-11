#ifndef assert_h
#define assert_h

#if defined(NDEBUG)

#define assert(ignore) ((void)0)

#else

void __assert(const char * restrict expression, const char * restrict file, int line, const char * restrict function);
#define assert(expression) \
	{ \
		if (!(expression)) { \
			__assert(#expression, __FILE__, __LINE__, __func__); \
		} \
	}

#endif

#define static_assert _Static_assert

#endif
