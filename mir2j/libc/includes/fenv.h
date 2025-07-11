#ifndef fenv_h
#define fenv_h

struct __fenv_s;
typedef __fenv_s fenv_t;

struct __fexcept_s;
typedef __fexcept_s fexcept_t;

#define FE_DIVBYZERO 1
#define FE_INEXACT 2
#define FE_INVALID 4
#define FE_OVERFLOW 8
#define FE_UNDERFLOW 16
#define FE_ALL_EXCEPT 0x1f

#define FE_DOWNWARD 0
#define FE_TONEAREST 1
#define FE_TOWARDZERO 2
#define FE_UPWARD 3

extern const fenv_t *__FE_DFL_ENV;
#define FE_DFL_ENV __FE_DFL_ENV

//#pragma STDC FENV_ACCESS on-off-switch

int feclearexcept(int excepts);
int fegetexceptflag(fexcept_t *flagp, int excepts);
int feraiseexcept(int excepts);
int fesetexceptflag(const fexcept_t *flagp, int excepts);
int fetestexcept(int excepts);
int fegetround(void);
int fesetround(int round);
int fegetenv(fenv_t *envp);
int feholdexcept(fenv_t *envp);
int fesetenv(const fenv_t *envp);
int feupdateenv(const fenv_t *envp);

#endif
