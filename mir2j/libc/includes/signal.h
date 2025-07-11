#ifndef signal_h
#define signal_h

typedef int sig_atomic_t;

// TODO: Signals.
#if 0
#define SIG_DFL
#define SIG_ERR
#define SIG_IGN

#define SIGABRT
#define SIGFPE
#define SIGILL
#define SIGINT
#define SIGSEGV
#define SIGTERM
#endif

void (*signal(int sig, void (*func)(int)))(int);
int raise(int sig);

#endif
