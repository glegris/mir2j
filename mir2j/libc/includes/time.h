#ifndef time_h
#define time_h

#include "errno.h"
#include "stddef.h"
#include "stdint.h"

//--------------------------------------------------------------------------------
// Clock time since the program started.
//--------------------------------------------------------------------------------
#define CLOCKS_PER_SEC 1000000

typedef int64_t clock_t;

clock_t clock();

//--------------------------------------------------------------------------------
// Calendar time of the system as time since epoch.
//--------------------------------------------------------------------------------
/**
 * Calendar time.
 * This is the arithmetic form.
 */
typedef int64_t time_t;

/**
 * Calendar time.
 * This is a broken-down form of time_t.
 */
struct tm {
    int tm_sec; //< Seconds after the minute [0, 61] (61 allows for two leap-seconds).
    int tm_min; //< Minutes after the minute [0, 59].
    int tm_hour; //< Hours since midnight [0, 23].
    int tm_mday; //< Day of month [1, 31].
    int tm_mon; //< Month since january [0, 11].
    int tm_year; //< Years since 1900.
    int tm_wday; //< Day since sunday [0, 6].
    int tm_yday; //< Day since january 1 [0, 365].
    int tm_isdst; //< Daylight saving time flag (>0 if daylight saving time; 0 if not; <0 if don't know).
};

double difftime(time_t time1, time_t time0);
time_t mktime(struct tm *timeptr);
time_t time(time_t *timer);
char *asctime(const struct tm *timeptr);
char *ctime(const time_t *timer);
struct tm *gmtime(const time_t *timer);
struct tm *localtime(const time_t *timer);
size_t strftime(char * restrict s, size_t maxsize, const char * restrict format, const struct tm * restrict timeptr);

errno_t asctime_s(char *s, rsize_t maxsize, const struct tm *timeptr);
errno_t ctime_s(char *s, rsize_t maxsize, const time_t *timer);
struct tm *gmtime_s(const time_t * restrict timer, struct tm * restrict result);
struct tm *localtime_s(const time_t * restrict timer, struct tm * restrict result);

//--------------------------------------------------------------------------------
// Calendar time in seconds and nanoseconds based on a given time base.
//--------------------------------------------------------------------------------
#define TIME_UTC 0

/// Calendar time in seconds and nanoseconds.
struct timespec {
    time_t tv_sec; //< Whole seconds. Valid values are >= 0.
    long tv_nsec; //< Nanoseconds. Valid values are [0, 999999999].
};

/**
 * Returns the calendar time based on a given time base.
 * @param ts The structure to fill with the calendar time.
 * @param base TIME_UTC or another nonzero integer value indicating the time base.
 * @return The value of \p base if successful, 0 otherwise.
 */
int timespec_get(struct timespec *ts, int base);

//--------------------------------------------------------------------------------
// Clock and time functions 
//--------------------------------------------------------------------------------

#define CLOCK_REALTIME           0
#define CLOCK_MONOTONIC          1
#define CLOCK_PROCESS_CPUTIME_ID 2
#define CLOCK_THREAD_CPUTIME_ID  3
#define CLOCK_MONOTONIC_RAW      4

/**  Identifier of the particular clock on which to act. */
typedef int clockid_t;

/**
 * Find the resolution (precision) of the specified clock clk_id
 * @param clk the output file descriptor
 * @param ts the timespec struct
 * @return 0 for success, or -1 for failure (in which case errno is set appropriately)
 */
int clock_getres(clockid_t clk_id, struct timespec *res);

/**
 * Retrieve the time of the specified clock clk_id
 * @param clk the output file descriptor
 * @param ts the timespec struct
 * @return 0 for success, or -1 for failure (in which case errno is set appropriately)
 */
int clock_gettime(clockid_t clk_id, struct timespec *tp);

/**
 * Set the time of the specified clock clk_id
 * @param clk the output file descriptor
 * @param ts the timespec struct
 * @return 0 for success, or -1 for failure (in which case errno is set appropriately)
 */
int clock_settime(clockid_t clk_id, const struct timespec *tp); 

//--------------------------------------------------------------------------------
// Sleep
//--------------------------------------------------------------------------------

int nanosleep (const struct timespec *, struct timespec *);

#endif
