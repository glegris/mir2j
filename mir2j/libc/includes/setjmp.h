#ifndef setjmp_h
#define setjmp_h

// TODO: jmp_buf
#if defined(__MipsCube__)

#define _JBLEN 95 /* size, in longs (or long longs), of a jmp_buf */

typedef struct _jmp_buf {
    long _jb[_JBLEN + 1];
} jmp_buf[1];

#else
// This is processor specific.
typedef struct {
	int dummy;
} jmp_buf;
#endif

int setjmp(jmp_buf env);
_Noreturn void longjmp(jmp_buf env, int val);

#endif
