#ifndef stdnoreturn_h
#define stdnoreturn_h

#if __STDC_VERSION__ < 201112L
    #if 0 // defined(__GNUC__)
        #define _Noreturn __dead2
    #else
        #define _Noreturn
    #endif
#endif

#define noreturn _Noreturn

#endif
