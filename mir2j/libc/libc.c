/*
MIT License

Copyright (c) 2025 Guillaume Legris

The printf functions are derived from code by:
Marco Paland (info@paland.com)
2014-2018, PALANDesign Hannover, Germany

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

#include <assert.h>
#include <ctype.h>
#include <errno.h>
#include <inttypes.h>
#include <limits.h>
#include <stdarg.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include "sysio.h"
#include <time.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdnoreturn.h> /* for _Noreturn */


//********************************************************************************
// System call interface for C library
//********************************************************************************

 /**
 * @param status the exit code
 */
noreturn void mir_sys_exit(int status);

/// Internal structure for FILE.
struct __sysio_FILE {
    int fd;
    int error;

    // Used when outputting to a string.
    char *stringBuffer;
    int stringBufferLength;
    int stringBufferCapacity;
    int charCount;
};

static struct __sysio_FILE __stdin  = { .fd = 0, .error = 0, .stringBuffer = NULL, .stringBufferLength = 0, .stringBufferCapacity = 0, .charCount = 0 };
static struct __sysio_FILE __stdout = { .fd = 1, .error = 0, .stringBuffer = NULL, .stringBufferLength = 0, .stringBufferCapacity = 0, .charCount = 0 };
static struct __sysio_FILE __stderr = { .fd = 2, .error = 0, .stringBuffer = NULL, .stringBufferLength = 0, .stringBufferCapacity = 0, .charCount = 0 };

FILE* const stdin  = &__stdin;
FILE* const stdout = &__stdout;
FILE* const stderr = &__stderr;

int mir_sysio_open(const char *filename, const char *mode);
int mir_sysio_close_fd(int fd);
long mir_sysio_read(int fd, void *buffer, unsigned long count);

/**
 * @param stream the output stream
 * @param buffer the data buffer
 * @param count the byte count
 * @return the number of bytes written, or `-errno`
 */
long mir_sysio_write(int fd, const void * restrict buffer, unsigned long count);

long  mir_sysio_seek(int fd, long offset, int whence);
long  mir_sysio_tell(int fd);
int   mir_sysio_feof(int fd);

/**
 * Retrieve the time of the specified clock clk_id
 * @param clk the output file descriptor
 * @param ts the timespec struct
 * @return 0 for success, or -1 for failure (in which case errno is set appropriately)
 */
int mir_sysclock_gettime(clockid_t clk, struct timespec *ts);


//********************************************************************************
// assert.h
//********************************************************************************

void __assert(const char * restrict expression, const char * restrict file, int line, const char * restrict function) {
    #if 0
	//printf("Assertion failed: %s, file %s, line %i, function %s\n", expression, file, line, function);
	if (func == NULL)
		printf("Assertion failed: (%s), file %s, line %d.\n",
		    failedexpr, file, line);
	else
		printf(
		    "Assertion failed: (%s), function %s, file %s, line %d.\n",
		    failedexpr, func, file, line);
    #endif
	abort();
	// Unreachable.
}

//********************************************************************************
// ctype.h
//********************************************************************************
int isalnum(int c) {
	return isalpha(c) || isdigit(c);
}

int isalpha(const int c) {
	return isupper(c) || islower(c);
}

int isascii(const int c) {
	return c >= 0 && c <= 0x7F; /* 7-bit ASCII */
}

int isblank(const int c) {
	return c == ' ' || c == '\t';
}

int iscntrl(const int c) {
	return (unsigned int)c < 0x20 || c == 0x7F;
}

int isdigit(const int c) {
	return c >= '0' && c <= '9';
}

int isgraph(const int c) {
	return c >= 0x21 && c <= 0x7E;
}

int islower(const int c) {
	return c >= 'a' && c <= 'z';
}

int isprint(const int c) {
	return c >= 0x20 && c <= 0x7E;
}

int ispunct(const int c) {
	return isprint(c) && !isspace(c) && !isalnum(c);
}

int isspace(const int c) {
	switch (c) {
	case ' ': /* space */
	case '\f': /* form feed */
	case '\n': /* new-line */
	case '\r': /* carriage return */
	case '\t': /* horizontal tab */
	case '\v': /* vertical tab */
		return 1;
	default:
		return 0;
	}
}

int isupper(const int c) {
	return c >= 'A' && c <= 'Z';
}

int isxdigit(const int c) {
	return (c >= '0' && c <= '9') ||
	       (c >= 'a' && c <= 'f') ||
	       (c >= 'A' && c <= 'F');
}

int tolower(const int c) {
	return isupper(c) ? 'a' + (c - 'A') : c;
}

int toupper(const int c) {
	return islower(c) ? 'A' + (c - 'a') : c;
}

//********************************************************************************
// errno.h
//********************************************************************************
int __errno;

//********************************************************************************
// inttypes.h
//********************************************************************************
/* FIXME 2 return values in MIR ... */
/*
imaxdiv_t imaxdiv(intmax_t numer, intmax_t denom) {
    imaxdiv_t rc;
    rc.quot = numer / denom;
    rc.rem  = numer % denom;
    return rc;
}
*/

static const char _LP_C_digits[] = "0123456789abcdefghijklmnopqrstuvwxyz";

static const char * strtox_prelim( const char * p, char * sign, int * base ) {
    /* skipping leading whitespace */
    while ( isspace( *p ) ) ++p;
    /* determining / skipping sign */
    if ( *p != '+' && *p != '-' ) *sign = '+';
    else *sign = *(p++);
    /* determining base */
    if ( *p == '0' ) {
        ++p;
        if ((*base == 0 || *base == 16) && (*p == 'x' || *p == 'X')) {
            *base = 16;
            ++p;
            /* catching a border case here: "0x" followed by a non-digit should
               be parsed as the unprefixed zero.
               We have to "rewind" the parsing; having the base set to 16 if it
               was zero previously does not hurt, as the result is zero anyway.
            */
            if (memchr(_LP_C_digits, tolower(*p), *base) == NULL) {
                p -= 2;
            }
        } else if (*base == 0) {
            *base = 8;
		} else {
            --p;
        }
    } else if ( ! *base ) {
        *base = 10;
    }
    return ((*base >= 2) && (*base <= 36)) ? p : NULL;
}

static uintmax_t strtox_main(const char ** p, unsigned int base, uintmax_t error, uintmax_t limval, int limdigit, char * sign ) {
    uintmax_t rc = 0;
    int digit = -1;
    const char * x;
    while (( x = memchr(_LP_C_digits, tolower(**p), base)) != NULL) {
        digit = x - _LP_C_digits;
        if (( rc < limval) || ( (rc == limval) && (digit <= limdigit))) {
            rc = rc * base + (unsigned)digit;
            ++(*p);
        } else {
            errno = ERANGE;
            /* TODO: Only if endptr != NULL - but do we really want *another* parameter? */
            /* TODO: Earlier version was missing tolower() here but was not caught by tests */
            while (memchr(_LP_C_digits, tolower(**p), base) != NULL) ++(*p);
            /* TODO: This is ugly, but keeps caller from negating the error value */
            *sign = '+';
            return error;
        }
    }
    if (digit == -1) {
        *p = NULL;
        return 0;
    }
    return rc;
}

/*
 * GCC issue for strtoimax/strtoumax:
 * On x86, some long long operations (modulo, division) require compiler builtins like
 * _modti3 and __divti3. So you have to add -lgcc flag to force gcc to grab these functions when
 * you don't use default standard library
 */
intmax_t strtoimax(const char * restrict nptr, char ** restrict endptr, int base) {
    char sign = '+';
    const char * p = strtox_prelim(nptr, &sign, &base);
    if (base < 2 || base > 36) return 0;
    uintmax_t a, b;
    int c;
    if (sign == '+') {
        a = (uintmax_t)INTMAX_MAX;
        b = (uintmax_t)(INTMAX_MAX / base);
        c = (int)(INTMAX_MAX % base);
    } else {
        a = (uintmax_t)INTMAX_MIN;
        b = (uintmax_t)(INTMAX_MIN / -base);
        c = (int)(-(INTMAX_MIN % base));
    }
    intmax_t rc = (intmax_t)strtox_main(&p, (unsigned)base, a, b, c, &sign);
    if (endptr != NULL) *endptr = (p != NULL) ? (char *) p : (char *) nptr;
    return (sign == '+') ? rc : -rc;
}

uintmax_t strtoumax(const char * restrict nptr, char ** restrict endptr, int base) {
    char sign = '+';
    const char * p = strtox_prelim(nptr, &sign, &base);
    if ( base < 2 || base > 36 ) return 0;
    uintmax_t rc = strtox_main(&p, (unsigned)base, (uintmax_t)UINTMAX_MAX, (uintmax_t)( UINTMAX_MAX / base ), (int)( UINTMAX_MAX % base ), &sign);
    if (endptr != NULL) *endptr = (p != NULL) ? (char *) p : (char *) nptr;
    return (sign == '+') ? rc : -rc;
}

intmax_t imaxabs(intmax_t j) {
    return (j >= 0) ? j : -j;
}


//********************************************************************************
// malloc(), free(), realloc().
//********************************************************************************


// void free(void *ptr) {
// }

// void *malloc(size_t size) {
	// return NULL;
// }

// void* realloc(void *oldptr, size_t size) {
    // return NULL;
// }

//********************************************************************************
// string.h
//********************************************************************************

// void* calloc(size_t num, size_t size) {
	// if (!num || !size)
		// return NULL;
	// size_t totalSize = num * size;
    // assert(size == totalSize / num);
	// void *data = malloc(totalSize);
	// if (data)
        // memset(data, 0, totalSize);
	// return data;
// }

void* memchr(const void *s, int c, size_t n) {
	const unsigned char *p = (const unsigned char *)s;
	while (n--) {
		if (*p == (unsigned char)c)
			return (void *)p;
		++p;
	}
	return NULL;
}

int memcmp(const void *s1, const void *s2, size_t n) {
	const unsigned char *p1 = (const unsigned char *)s1;
	const unsigned char *p2 = (const unsigned char *)s2;
	while (n--) {
		if (*p1 != *p2)
			return *p1 - *p2;
		++p1;
		++p2;
	}
	return 0;
}

/*
void* memcpy(void * restrict s1, const void * restrict s2, size_t n) {
	char *dest = (char *)s1;
	const char *src = (const char *)s2;
	while (n--)
		*dest++ = *src++;
	return s1;
}
*/

void* memmove(void *s1, const void *s2, size_t n) {
	char *dest = (char *)s1;
	const char *src = (const char *)s2;
	if (dest <= src) {
		while (n--)
			*dest++ = *src++;
	} else {
		src += n;
		dest += n;
		while (n--)
			*--dest = *--src;
	}
	return s1;
}

// void* memset(void *s, int c, size_t n) {
	// unsigned char *p = (unsigned char *)s;
	// while (n--)
		// *p++ = (unsigned char)c;
	// return s;
// }

char* strcat(char * restrict s1, const char * restrict s2) {
	char *rc = s1;
	if (*s1) {
		while (*++s1) ;
	}
	while ((*s1++ = *s2++)) ;
	return rc;
}

char* strchr(const char *s, const int c) {
	while (*s != '\0' && *s != (char)c)
		s++;
	return (*s != '\0' || c == '\0') ? (char *)s : NULL;
}

int strcmp(const char * const s1, const char * const s2) {
	const unsigned char *p1 = (unsigned char *)s1;
	const unsigned char *p2 = (unsigned char *)s2;
	while (*p1 != '\0' && *p1 == *p2) {
		p1++, p2++;
	}
	return *p1 - *p2;
}

int strcoll(const char * const s1, const char * const s2) {
	return strcmp(s1, s2);
}

// char* strcpy(char * restrict s1, const char * restrict s2) {
	// char *rc = s1;
	// while ((*s1++ = *s2++)) ;
	// return rc;
// }

size_t strcspn(const char *s1, const char * const s2) {
	size_t result = 0;
	while (*s1 != '\0' && strchr(s2, *s1) == NULL) {
		s1++, result++;
	}
	return result;
}

char *strdup(const char *s) {
    char* ns = NULL;
    if(s) {
        size_t len = strlen(s) + 1;
        ns = malloc(len);
        if(ns)
            strncpy(ns, s, len);
    }
    return ns;
}

char* strerror(int errnum) {
	switch (errnum) {
	case EDOM:   return "Numerical argument out of domain";
	case EILSEQ: return "Illegal byte sequence";
	case ERANGE: return "Result too large";
	default:     return "Unknown error";
	}
}

// size_t strlen(const char * const s) {
	// const char *p = s;
	// while (*p != '\0') p++;
	// return p - s;
// }

char* strncat(char * restrict s1, const char * restrict s2, size_t n) {
	char * rc = s1;
	while (*s1) {
		++s1;
	}
	while (n && (*s1++ = *s2++)) {
		--n;
	}
	if (n == 0) {
		*s1 = '\0';
	}
	return rc;
}

int strncmp(const char *s1, const char *s2, size_t n) {
	while (*s1 && n && (*s1 == *s2)) {
		++s1;
		++s2;
		--n;
	}
	if (n == 0)
		return 0;
	else
		return (*(unsigned char *)s1 - *(unsigned char *)s2);
}

char* strncpy(char * restrict s1, const char * restrict s2, size_t n) {
	char *rc = s1;
	while ((n > 0) && (*s1++ = *s2++)) {
		/* Cannot do "n--" in the conditional as size_t is unsigned and we have
		   to check it again for >0 in the next loop below, so we must not risk
		   underflow.
		 */
		--n;
	}
	/* Checking against 1 as we missed the last --n in the loop above. */
	while (n-- > 1)
		*s1++ = '\0';
	return rc;
}

char *strndup( const char * s, size_t len ) {
    char* ns = NULL;
    if(s) {
        ns = malloc(len + 1);
        if(ns) {
            ns[len] = 0;
            // strncpy to be pedantic about modification in multithreaded
            // applications
            return strncpy(ns, s, len);
        }
    }
    return ns;
}

size_t strnlen(const char *s, size_t maxlen) {
	for (size_t len = 0; len != maxlen; len++) {
		if (s[len] == '\0') return len;
	}
	return maxlen;
}

char* strpbrk(const char *s1, const char * const s2) {
	while (*s1 != '\0' && strchr(s2, *s1) == NULL)
		s1++;
	return (*s1 != '\0') ? (char *)s1 : NULL;
}

char* strrchr(const char *s, const int c) {
	size_t i = 0;
	while (s[i++])
		;
	do {
		if (s[--i] == (char) c) {
			return (char *) s + i;
		}
	} while (i);
	return NULL;
}

size_t strspn(const char *s1, const char * const s2) {
	size_t result = 0;
	while (*s1 != '\0' && strchr(s2, *s1) != NULL) {
		s1++, result++;
	}
	return result;
}

char* strstr(const char *s1, const char *s2) {
	const char *p1 = s1;
	while (*s1) {
		const char *p2 = s2;
		while (*p2 && (*p1 == *p2)) {
			++p1;
			++p2;
		}
		if (!*p2)
			return (char *)s1;
		++s1;
		p1 = s1;
	}
	return NULL;
}

char* strtok(char * restrict s1, const char * restrict s2) {
	static char *tmp = NULL;
	const char *p = s2;

	if (s1 != NULL) {
		/* new string */
		tmp = s1;
	} else {
		/* old string continued */
		if (tmp == NULL)
			/* No old string, no new string, nothing to do */
			return NULL;
		s1 = tmp;
	}

	/* skipping leading s2 characters */
	while (*p && *s1) {
		if (*s1 == *p) {
			/* found seperator; skip and start over */
			++s1;
			p = s2;
			continue;
		}
		++p;
	}

	if (!*s1)
		/* no more to parse */
		return (tmp = NULL);

	/* skipping non-s2 characters */
	tmp = s1;
	while (*tmp) {
		p = s2;
		while (*p) {
			if (*tmp == *p++) {
				/* found seperator; overwrite with '\0', position tmp, return */
				*tmp++ = '\0';
				return s1;
			}
		}
		++tmp;
	}

	/* parsed to end of string */
	tmp = NULL;
	return s1;
}

size_t strxfrm(char * restrict s1, const char * restrict s2, size_t n) {
	size_t len = strlen(s2);
	if (len < n) {
		/* Cannot use strncpy() here as the filling of s1 with '\0' is not part
		 of the spec.
		 */
		/* FIXME: The code below became invalid when we started doing *real* locales... */
		while (n-- && (*s1++ = (unsigned char) *s2++))
			;
	}
	return len;
}

//********************************************************************************
// stdio.h
//********************************************************************************
static int outputBuffer(FILE * restrict stream, const char *s, int length) {
    if (stream->fd < 0) {
        while (length != 0) {
            int c = *s++;
            if (length < 0) {
                if (c == 0)
                    break;
            } else
                length--;
            if (stream->stringBufferLength < stream->stringBufferCapacity) {
                stream->stringBuffer[stream->stringBufferLength] = c;
                stream->stringBufferLength++;
            }
        }
    } else {
        if (length < 0)
            length = strlen(s);
        long rc = mir_sysio_write(stream->fd, s, length);
        if (rc < 0) {
            errno = -((int)rc);
            return EOF;
        }
    }
    return 0;
}


static int outputChar(FILE * restrict stream, char c) {
    return outputBuffer(stream, &c, 1);
}

/*
static int outputCharFill(FILE * restrict stream, char c, int length) {
    int status;
    while (length > 0)
        status = outputBuffer(stream, &c, 1);
    return status;
}

static int outputString(FILE * restrict stream, const char *s) {
    return outputBuffer(stream, s, -1);
}
*/

FILE* fopen(const char *filename, const char *mode) {
    int fd = mir_sysio_open(filename, mode);
    if (fd < 0) { errno = -fd; return NULL; }
    FILE *stream = (FILE*)calloc(1, sizeof(FILE));
    if (!stream) { mir_sysio_close_fd(fd); errno = ENOMEM; return NULL; }
    stream->fd = fd;
    return stream;
}

FILE* freopen(const char *restrict filename, const char *restrict mode, FILE *restrict stream) {
    if (!stream) return fopen(filename, mode);
    int fd = mir_sysio_open(filename, mode);
    if (fd < 0) { errno = -fd; return NULL; }
    if (stream->fd >= 0) mir_sysio_close_fd(stream->fd);
    stream->fd = fd;
    stream->error = 0;
    return stream;
}

int fclose(FILE *stream) {
    if (!stream) { errno = EINVAL; return EOF; }
    int rc = mir_sysio_close_fd(stream->fd);
    free(stream);
    if (rc < 0) { errno = -rc; return EOF; }
    return 0;
}

size_t fread(void *ptr, size_t size, size_t nmemb, FILE *stream) {
    if (!stream || !ptr) { errno = EINVAL; return 0; }
    unsigned long want = size * nmemb;
    long rc = mir_sysio_read(stream->fd, ptr, want);
    if (rc < 0) { errno = -rc; return 0; }
    return (size_t)(rc / (long)size);
}

size_t fwrite(const void *ptr, size_t size, size_t nmemb, FILE *stream) {
    if (!stream || !ptr) { errno = EINVAL; return 0; }
    unsigned long want = size * nmemb;
    long rc = mir_sysio_write(stream->fd, ptr, want);
    if (rc < 0) { errno = -rc; return 0; }
    return (size_t)(rc / (long)size);
}

int feof(FILE *stream) {
    if (!stream) { errno = EINVAL; return 0; }
    int rc = mir_sysio_feof(stream->fd);
    if (rc < 0) { errno = -rc; return 0; }
    return rc;
}

long int ftell(FILE *stream) {
    if (!stream) { errno = EINVAL; return -1L; }
    long rc = mir_sysio_tell(stream->fd);
    if (rc < 0) { errno = -rc; return -1L; }
    return rc;
}

int fseek(FILE *stream, long int offset, int whence) {
    if (!stream) { errno = EINVAL; return -1; }
    long rc = mir_sysio_seek(stream->fd, offset, whence);
    if (rc < 0) { errno = -rc; return -1; }
    return 0;
}

char *fgets(char *restrict s, int n, FILE *restrict stream) {
    if (!stream || !s || n <= 1) { errno = EINVAL; return NULL; }
    int i = 0;
    while (i < n - 1) {
        char ch;
        long rc = mir_sysio_read(stream->fd, &ch, 1);
        if (rc < 0) { errno = -rc; return (i > 0) ? s : NULL; }
        if (rc == 0) break; /* EOF */
        s[i++] = ch;
        if (ch == '\n') break;
    }
    if (i == 0) return NULL;
    s[i] = '\0';
    return s;
}

int fputs(const char *s, FILE *stream) {
    if (!stream || !s) { errno = EINVAL; return EOF; }
    long rc = mir_sysio_write(stream->fd, s, strlen(s));
    if (rc < 0) { errno = -rc; return EOF; }
    return (int)rc;
}

int fputc(int ch, FILE *stream) {
    unsigned char c = (unsigned char)ch;
    long rc = mir_sysio_write(stream->fd, &c, 1);
    if (rc < 0) { errno = -rc; return EOF; }
    return c;
}

int fgetc(FILE *stream) {
    if (!stream) { errno = EINVAL; return EOF; }
    unsigned char ch = 0;
    long rc = mir_sysio_read(stream->fd, &ch, 1);
    if (rc < 0) { errno = (int)-rc; return EOF; }  // backend error
    if (rc == 0) return EOF;                       // EOF
    return (int)ch;
}

int fflush(FILE *stream) {
    /* No stdio buffering layer is implemented:
       - outputBuffer() writes directly via mir_sysio_write()
       - Java backend flushes stdout/stderr itself
       Therefore there is nothing to flush here. */
    (void)stream;
    return 0;
}

int sscanf(const char * restrict s, const char * restrict format, ...) {
    return EOF;
}

int vsscanf(const char * restrict s, const char * restrict format, va_list arg) {
    return EOF;
}

int vfscanf(FILE *stream, const char *format, va_list ap) {
    return EOF;
}

int fscanf(FILE * restrict stream, const char * restrict format, ...) {
    int rc;
    va_list ap;
    va_start( ap, format );
    rc = vfscanf( stream, format, ap );
    va_end( ap );
    return rc;
}

int getc(FILE *stream) {
    return fgetc(stream);
}

int putc(int c, FILE *stream) {
	return fputc(c, stream);
}

int putchar(int c) {
	return putc(c, stdout);
}

int puts(const char *s) {
	int ret = fputs(s, stdout);
	if (ret == EOF)
		return ret;
	return putc('\n', stdout);
}

#define PRINTF_NTOA_BUFFER_SIZE    32U
#define PRINTF_FTOA_BUFFER_SIZE    32U

// internal flag definitions
#define FLAGS_ZEROPAD   (1U <<  0U)
#define FLAGS_LEFT      (1U <<  1U)
#define FLAGS_PLUS      (1U <<  2U)
#define FLAGS_SPACE     (1U <<  3U)
#define FLAGS_HASH      (1U <<  4U)
#define FLAGS_UPPERCASE (1U <<  5U)
#define FLAGS_CHAR      (1U <<  6U)
#define FLAGS_SHORT     (1U <<  7U)
#define FLAGS_LONG      (1U <<  8U)
#define FLAGS_LONG_LONG (1U <<  9U)
#define FLAGS_PRECISION (1U << 10U)

// internal buffer output
static inline void _out_buffer(FILE * restrict stream, char character, void* buffer, size_t idx, size_t maxlen) {
	(void) stream;
	if (idx < maxlen) {
		((char*) buffer)[idx] = character;
	}
}

// internal null output
static inline void _out_null(FILE * restrict stream, char character, void* buffer, size_t idx, size_t maxlen) {
	(void) stream;
	(void) character;
	(void) buffer;
	(void) idx;
	(void) maxlen;
}

// internal _putchar wrapper
static inline void _out_char(FILE * restrict stream, char character, void* buffer, size_t idx, size_t maxlen) {
	(void) stream;
	(void) buffer;
	(void) idx;
	(void) maxlen;
	if (character) {
		outputChar(stream, character);
	}
}

// output function type
typedef void (*out_fct_type)(FILE * restrict stream, char character, void* buffer, size_t idx, size_t maxlen);

// internal ASCII string to unsigned int conversion
static unsigned int _atoi(const char** str) {
	unsigned int i = 0U;
	while (isdigit(**str)) {
		i = i * 10U + (unsigned int) (*((*str)++) - '0');
	}
	return i;
}

// internal itoa format
static size_t _ntoa_format(FILE * restrict stream, out_fct_type out, char* buffer, size_t idx, size_t maxlen, char* buf, size_t len, bool negative, unsigned int base, unsigned int prec, unsigned int width, unsigned int flags) {
	const size_t start_idx = idx;

	// pad leading zeros
	if (!(flags & FLAGS_LEFT)) {
		while ((len < prec) && (len < PRINTF_NTOA_BUFFER_SIZE)) {
			buf[len++] = '0';
		}
		while ((flags & FLAGS_ZEROPAD) && (len < width) && (len < PRINTF_NTOA_BUFFER_SIZE)) {
			buf[len++] = '0';
		}
	}

	// handle hash
	if (flags & FLAGS_HASH) {
		if (!(flags & FLAGS_PRECISION) && len && ((len == prec) || (len == width))) {
			len--;
			if (len && (base == 16U)) {
				len--;
			}
		}
		if ((base == 16U) && !(flags & FLAGS_UPPERCASE) && (len < PRINTF_NTOA_BUFFER_SIZE)) {
			buf[len++] = 'x';
		} else if ((base == 16U) && (flags & FLAGS_UPPERCASE) && (len < PRINTF_NTOA_BUFFER_SIZE)) {
			buf[len++] = 'X';
		} else if ((base == 2U) && (len < PRINTF_NTOA_BUFFER_SIZE)) {
			buf[len++] = 'b';
		}
		if (len < PRINTF_NTOA_BUFFER_SIZE) {
			buf[len++] = '0';
		}
	}

	// handle sign
	if (len && (len == width) && (negative || (flags & FLAGS_PLUS) || (flags & FLAGS_SPACE))) {
		len--;
	}
	if (len < PRINTF_NTOA_BUFFER_SIZE) {
		if (negative) {
			buf[len++] = '-';
		} else if (flags & FLAGS_PLUS) {
			buf[len++] = '+'; // ignore the space if the '+' exists
		} else if (flags & FLAGS_SPACE) {
			buf[len++] = ' ';
		}
	}

	// pad spaces up to given width
	if (!(flags & FLAGS_LEFT) && !(flags & FLAGS_ZEROPAD)) {
		for (size_t i = len; i < width; i++) {
			out(stream, ' ', buffer, idx++, maxlen);
		}
	}

	// reverse string
	for (size_t i = 0U; i < len; i++) {
		out(stream, buf[len - i - 1U], buffer, idx++, maxlen);
	}

	// append pad spaces up to given width
	if (flags & FLAGS_LEFT) {
		while (idx - start_idx < width) {
			out(stream, ' ', buffer, idx++, maxlen);
		}
	}

	return idx;
}

// internal itoa for 'long' type
static size_t _ntoa_long(FILE * restrict stream, out_fct_type out, char* buffer, size_t idx, size_t maxlen, unsigned long value, bool negative, unsigned long base, unsigned int prec, unsigned int width, unsigned int flags) {
	char buf[PRINTF_NTOA_BUFFER_SIZE];
	size_t len = 0U;

	// no hash for 0 values
	if (!value) {
		flags &= ~FLAGS_HASH;
	}

	// write if precision != 0 and value is != 0
	if (!(flags & FLAGS_PRECISION) || value) {
		do {
			const char digit = (char) (value % base);
			buf[len++] = digit < 10 ? '0' + digit : (flags & FLAGS_UPPERCASE ? 'A' : 'a') + digit - 10;
			value /= base;
		} while (value && (len < PRINTF_NTOA_BUFFER_SIZE));
	}

	return _ntoa_format(stream, out, buffer, idx, maxlen, buf, len, negative, (unsigned int) base, prec, width, flags);
}

// internal itoa for 'long long' type
static size_t _ntoa_long_long(FILE * restrict stream, out_fct_type out, char* buffer, size_t idx, size_t maxlen, unsigned long long value, bool negative, unsigned long long base, unsigned int prec, unsigned int width, unsigned int flags) {
	char buf[PRINTF_NTOA_BUFFER_SIZE];
	size_t len = 0U;

	// no hash for 0 values
	if (!value) {
		flags &= ~FLAGS_HASH;
	}

	// write if precision != 0 and value is != 0
	if (!(flags & FLAGS_PRECISION) || value) {
		do {
			const char digit = (char) (value % base);
			buf[len++] = digit < 10 ? '0' + digit : (flags & FLAGS_UPPERCASE ? 'A' : 'a') + digit - 10;
			value /= base;
		} while (value && (len < PRINTF_NTOA_BUFFER_SIZE));
	}

	return _ntoa_format(stream, out, buffer, idx, maxlen, buf, len, negative, (unsigned int) base, prec, width, flags);
}

static size_t _ftoa(FILE * restrict stream, out_fct_type out, char* buffer, size_t idx, size_t maxlen, double value, unsigned int prec, unsigned int width, unsigned int flags) {
	const size_t start_idx = idx;

	char buf[PRINTF_FTOA_BUFFER_SIZE];
	size_t len = 0U;
	double diff = 0.0;

	// if input is larger than thres_max, revert to exponential
	const double thres_max = (double) 0x7FFFFFFF;

	// powers of 10
	static const double pow10[] = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };

	// test for negative
	bool negative = false;
	if (value < 0) {
		negative = true;
		value = 0 - value;
	}

	// set default precision to 6, if not set explicitly
	if (!(flags & FLAGS_PRECISION)) {
		prec = 6U;
	}
	// limit precision to 9, cause a prec >= 10 can lead to overflow errors
	while ((len < PRINTF_FTOA_BUFFER_SIZE) && (prec > 9U)) {
		buf[len++] = '0';
		prec--;
	}

	int whole = (int) value;
	double tmp = (value - whole) * pow10[prec];
	unsigned long frac = (unsigned long) tmp;
	diff = tmp - frac;

	if (diff > 0.5) {
		++frac;
		// handle rollover, e.g. case 0.99 with prec 1 is 1.0
		if (frac >= pow10[prec]) {
			frac = 0;
			++whole;
		}
	} else if ((diff == 0.5) && ((frac == 0U) || (frac & 1U))) {
		// if halfway, round up if odd, OR if last digit is 0
		++frac;
	}

	// TBD: for very large numbers switch back to native sprintf for exponentials. Anyone want to write code to replace this?
	// Normal printf behavior is to print EVERY whole number digit which can be 100s of characters overflowing your buffers == bad
	if (value > thres_max) {
		return 0U;
	}

	if (prec == 0U) {
		diff = value - (double) whole;
		if (diff > 0.5) {
			// greater than 0.5, round up, e.g. 1.6 -> 2
			++whole;
		} else if ((diff == 0.5) && (whole & 1)) {
			// exactly 0.5 and ODD, then round up
			// 1.5 -> 2, but 2.5 -> 2
			++whole;
		}
	} else {
		unsigned int count = prec;
		// now do fractional part, as an unsigned number
		while (len < PRINTF_FTOA_BUFFER_SIZE) {
			--count;
			buf[len++] = (char) (48U + (frac % 10U));
			if (!(frac /= 10U)) {
				break;
			}
		}
		// add extra 0s
		while ((len < PRINTF_FTOA_BUFFER_SIZE) && (count-- > 0U)) {
			buf[len++] = '0';
		}
		if (len < PRINTF_FTOA_BUFFER_SIZE) {
			// add decimal
			buf[len++] = '.';
		}
	}

	// do whole part, number is reversed
	while (len < PRINTF_FTOA_BUFFER_SIZE) {
		buf[len++] = (char) (48 + (whole % 10));
		if (!(whole /= 10)) {
			break;
		}
	}

	// pad leading zeros
	if (!(flags & FLAGS_LEFT) && (flags & FLAGS_ZEROPAD)) {
		while ((len < width) && (len < PRINTF_FTOA_BUFFER_SIZE)) {
			buf[len++] = '0';
		}
	}

	// handle sign
	if ((len == width) && (negative || (flags & FLAGS_PLUS) || (flags & FLAGS_SPACE))) {
		len--;
	}
	if (len < PRINTF_FTOA_BUFFER_SIZE) {
		if (negative) {
			buf[len++] = '-';
		} else if (flags & FLAGS_PLUS) {
			buf[len++] = '+'; // ignore the space if the '+' exists
		} else if (flags & FLAGS_SPACE) {
			buf[len++] = ' ';
		}
	}

	// pad spaces up to given width
	if (!(flags & FLAGS_LEFT) && !(flags & FLAGS_ZEROPAD)) {
		for (size_t i = len; i < width; i++) {
			out(stream, ' ', buffer, idx++, maxlen);
		}
	}

	// reverse string
	for (size_t i = 0U; i < len; i++) {
		out(stream, buf[len - i - 1U], buffer, idx++, maxlen);
	}

	// append pad spaces up to given width
	if (flags & FLAGS_LEFT) {
		while (idx - start_idx < width) {
			out(stream, ' ', buffer, idx++, maxlen);
		}
	}

	return idx;
}

static int _vsnprintf(FILE * restrict stream, out_fct_type out, char* buffer, const size_t maxlen, const char* format, va_list va) {
	unsigned int flags, width, precision, n;
	size_t idx = 0U;

	if (!buffer) {
		// use null output function
		out = _out_null;
	}

	while (*format) {
		// format specifier?  %[flags][width][.precision][length]
		if (*format != '%') {
			// no
			out(stream, *format, buffer, idx++, maxlen);
			format++;
			continue;
		} else {
			// yes, evaluate it
			format++;
		}

		// evaluate flags
		flags = 0U;
		do {
			switch (*format) {
			case '0':
				flags |= FLAGS_ZEROPAD;
				format++;
				n = 1U;
				break;
			case '-':
				flags |= FLAGS_LEFT;
				format++;
				n = 1U;
				break;
			case '+':
				flags |= FLAGS_PLUS;
				format++;
				n = 1U;
				break;
			case ' ':
				flags |= FLAGS_SPACE;
				format++;
				n = 1U;
				break;
			case '#':
				flags |= FLAGS_HASH;
				format++;
				n = 1U;
				break;
			default:
				n = 0U;
				break;
			}
		} while (n);

		// evaluate width field
		width = 0U;
		if (isdigit(*format)) {
			width = _atoi(&format);
		} else if (*format == '*') {
			const int w = va_arg(va, int);
			if (w < 0) {
				flags |= FLAGS_LEFT; // reverse padding
				width = (unsigned int) -w;
			} else {
				width = (unsigned int) w;
			}
			format++;
		}

		// evaluate precision field
		precision = 0U;
		if (*format == '.') {
			flags |= FLAGS_PRECISION;
			format++;
			if (isdigit(*format)) {
				precision = _atoi(&format);
			} else if (*format == '*') {
				const int prec = (int) va_arg(va, int);
				precision = prec > 0 ? (unsigned int) prec : 0U;
				format++;
			}
		}

		// evaluate length field
		switch (*format) {
		case 'l':
			flags |= FLAGS_LONG;
			format++;
			if (*format == 'l') {
				flags |= FLAGS_LONG_LONG;
				format++;
			}
			break;
		case 'h':
			flags |= FLAGS_SHORT;
			format++;
			if (*format == 'h') {
				flags |= FLAGS_CHAR;
				format++;
			}
			break;
		case 't':
			flags |= (sizeof(ptrdiff_t) == sizeof(long) ? FLAGS_LONG : FLAGS_LONG_LONG);
			format++;
			break;
		case 'j':
			flags |= (sizeof(intmax_t) == sizeof(long) ? FLAGS_LONG : FLAGS_LONG_LONG);
			format++;
			break;
		case 'z':
			flags |= (sizeof(size_t) == sizeof(long) ? FLAGS_LONG : FLAGS_LONG_LONG);
			format++;
			break;
		default:
			break;
		}

		// evaluate specifier
		switch (*format) {
		case 'd':
		case 'i':
		case 'u':
		case 'x':
		case 'X':
		case 'o':
		case 'b': {
			// set the base
			unsigned int base;
			if (*format == 'x' || *format == 'X') {
				base = 16U;
			} else if (*format == 'o') {
				base = 8U;
			} else if (*format == 'b') {
				base = 2U;
			} else {
				base = 10U;
				flags &= ~FLAGS_HASH; // no hash for dec format
			}
			// uppercase
			if (*format == 'X') {
				flags |= FLAGS_UPPERCASE;
			}

			// no plus or space flag for u, x, X, o, b
			if ((*format != 'i') && (*format != 'd')) {
				flags &= ~(FLAGS_PLUS | FLAGS_SPACE);
			}

			// ignore '0' flag when precision is given
			if (flags & FLAGS_PRECISION) {
				flags &= ~FLAGS_ZEROPAD;
			}

			// convert the integer
			if ((*format == 'i') || (*format == 'd')) {
				// signed
				if (flags & FLAGS_LONG_LONG) {
					const long long value = va_arg(va, long long);
					idx = _ntoa_long_long(stream, out, buffer, idx, maxlen, (unsigned long long) (value > 0 ? value : 0 - value), value < 0, base, precision, width, flags);
				} else if (flags & FLAGS_LONG) {
					const long value = va_arg(va, long);
					idx = _ntoa_long(stream, out, buffer, idx, maxlen, (unsigned long) (value > 0 ? value : 0 - value), value < 0, base, precision, width, flags);
				} else {
					const int value = (flags & FLAGS_CHAR) ? (char) va_arg(va, int) : (flags & FLAGS_SHORT) ? (short int) va_arg(va, int) : va_arg(va, int);
					idx = _ntoa_long(stream, out, buffer, idx, maxlen, (unsigned int) (value > 0 ? value : 0 - value), value < 0, base, precision, width, flags);
				}
			} else {
				// unsigned
				if (flags & FLAGS_LONG_LONG) {
					idx = _ntoa_long_long(stream, out, buffer, idx, maxlen, va_arg(va, unsigned long long), false, base, precision, width, flags);
				} else if (flags & FLAGS_LONG) {
					idx = _ntoa_long(stream, out, buffer, idx, maxlen, va_arg(va, unsigned long), false, base, precision, width, flags);
				} else {
					const unsigned int value = (flags & FLAGS_CHAR) ? (unsigned char) va_arg(va, unsigned int) : (flags & FLAGS_SHORT) ? (unsigned short int) va_arg(va, unsigned int) : va_arg(va, unsigned int);
					idx = _ntoa_long(stream, out, buffer, idx, maxlen, value, false, base, precision, width, flags);
				}
			}
			format++;
			break;
		}
		case 'f':
		case 'F':
			idx = _ftoa(stream, out, buffer, idx, maxlen, va_arg(va, double), precision, width, flags);
			format++;
			break;
		case 'c': {
			unsigned int l = 1U;
			// pre padding
			if (!(flags & FLAGS_LEFT)) {
				while (l++ < width) {
					out(stream, ' ', buffer, idx++, maxlen);
				}
			}
			// char output
			out(stream, (char) va_arg(va, int), buffer, idx++, maxlen);
			// post padding
			if (flags & FLAGS_LEFT) {
				while (l++ < width) {
					out(stream, ' ', buffer, idx++, maxlen);
				}
			}
			format++;
			break;
		}

		case 's': {
			char* p = va_arg(va, char*);
			unsigned int l = strlen(p);
			// pre padding
			if (flags & FLAGS_PRECISION) {
				l = (l < precision ? l : precision);
			}
			if (!(flags & FLAGS_LEFT)) {
				while (l++ < width) {
					out(stream, ' ', buffer, idx++, maxlen);
				}
			}
			// string output
			while ((*p != 0) && (!(flags & FLAGS_PRECISION) || precision--)) {
				out(stream, *(p++), buffer, idx++, maxlen);
			}
			// post padding
			if (flags & FLAGS_LEFT) {
				while (l++ < width) {
					out(stream, ' ', buffer, idx++, maxlen);
				}
			}
			format++;
			break;
		}

		case 'p': {
			width = sizeof(void*) * 2U;
			flags |= FLAGS_ZEROPAD | FLAGS_UPPERCASE;
			const bool is_ll = sizeof(uintptr_t) == sizeof(long long);
			if (is_ll) {
				idx = _ntoa_long_long(stream, out, buffer, idx, maxlen, (uintptr_t) va_arg(va, void*), false, 16U, precision, width, flags);
			} else {
				idx = _ntoa_long(stream, out, buffer, idx, maxlen, (unsigned long) ((uintptr_t) va_arg(va, void*)), false, 16U, precision, width, flags);
			}
			format++;
			break;
		}

		case '%':
			out(stream, '%', buffer, idx++, maxlen);
			format++;
			break;

		default:
			out(stream, *format, buffer, idx++, maxlen);
			format++;
			break;
		}
	}

	// termination
	out(stream, (char) 0, buffer, idx < maxlen ? idx : maxlen - 1U, maxlen);

	// return written chars without terminating \0
	return (int) idx;
}

int printf(const char* format, ...) {
	va_list va;
	va_start(va, format);
	char buffer[1];
	const int ret = _vsnprintf(stdout, _out_char, buffer, (size_t) -1, format, va);
	va_end(va);
	return ret;
}

int sprintf(char* buffer, const char* format, ...) {
	va_list va;
	va_start(va, format);
	const int ret = _vsnprintf(stdout, _out_buffer, buffer, (size_t) -1, format, va);
	va_end(va);
	return ret;
}

int snprintf(char* buffer, size_t count, const char* format, ...) {
	va_list va;
	va_start(va, format);
	const int ret = _vsnprintf(stdout, _out_buffer, buffer, count, format, va);
	va_end(va);
	return ret;
}

int vsprintf(char * restrict s, const char * restrict format, va_list arg) {
    return vsnprintf( s, SIZE_MAX, format, arg );
}

int vsnprintf(char* buffer, size_t count, const char* format, va_list va) {
	return _vsnprintf(stdout, _out_buffer, buffer, count, format, va);
}

int vprintf(const char * restrict format, va_list arg) {
	char buffer[1];
	return _vsnprintf(stdout, _out_char, buffer, (size_t) -1, format, arg);
}

int vfprintf(FILE *stream, const char *format, va_list arg) {
	char buffer[1];
	return _vsnprintf(stream, _out_char, buffer, (size_t) -1, format, arg);
}

int fprintf(FILE *stream, const char *format, ...) {
	va_list arg;
	va_start(arg, format);
	int result = vfprintf(stream, format, arg);
	va_end(arg);
	return result;
}

//********************************************************************************
// stdlib.h
//********************************************************************************

/*
_Noreturn void _Exit(int status) {
	mir_sys_exit(status);
    //while (1) ;
}

void exit(int status) {
	_Exit(status);
}

void quick_exit(int status) {
	_Exit(status);
}

void abort() {
    _Exit(1);
}
*/

/* Return quotient (quot) and remainder (rem) of an integer division in one of
   the structs above.
*/
div_t div(int numer, int denom) {
    div_t rc;
    rc.quot = numer / denom;
    rc.rem  = numer % denom;
    return rc;
}

ldiv_t ldiv(long int numer, long int denom) {
    ldiv_t rc;
    rc.quot = numer / denom;
    rc.rem  = numer % denom;
    return rc;
}

lldiv_t lldiv(long long int numer, long long int denom) {
    lldiv_t rc;
    rc.quot = numer / denom;
    rc.rem  = numer % denom;
    return rc;
}

double atof(const char *nptr) {
	return (strtod(nptr, (char **)NULL));
}

int atoi(const char *nptr) {
	return ((int)strtol(nptr, (char **)NULL, 10));
}

long int atol(const char *nptr) {
	return (strtol(nptr, (char **)NULL, 10));
}

long long int atoll(const char *nptr) {
	return 0; //TODO
}

double strtod(const char *nptr, char **endptr) {
	double x = 0.0;
	double xs = 1.0;
	double xf = 0.0;
	double xd = 1.0;

	while (isspace((unsigned char)*nptr)) ++nptr;
	if (*nptr == '-') {
		xs = -1;
		nptr++;
	} else if (*nptr == '+') {
		nptr++;
	}

	while (1) {
		if (isdigit((unsigned char)*nptr)) {
			x = x * 10 + (*nptr - '0');
			nptr++;
		} else {
			x = x * xs;
			break;
		}
	}
	if (*nptr == '.') {
		nptr++;
		while (1) {
			if (isdigit((unsigned char)*nptr)) {
				xf = xf * 10 + (*nptr - '0');
				xd = xd * 10;
			} else {
				x = x + xs * (xf / xd);
				break;
			}
			nptr++;
		}
	}
	if ((*nptr == 'e') || (*nptr == 'E')) {
		nptr++;
        double es = 1.0;
		if (*nptr == '-') {
			es = -1;
			nptr++;
		}
		xd = 1;
		xf = 0;
		while (1) {
			if (isdigit((unsigned char)*nptr)) {
				xf = xf * 10 + (*nptr - '0');
				nptr++;
			} else {
				while (xf > 0) {
					xd *= 10;
					xf--;
				}
				if (es < 0.0)
					x /= xd;
				else
					x *= xd;
				break;
			}
		}
	}
	if (endptr != NULL)
		*endptr = (char *)nptr;
	return x;
}

long double strtold(const char * restrict nptr, char ** restrict endptr) {
	return 0; // TODO
}

long int strtol(const char * s, char ** endptr, int base) {
	char sign = '+';
	const char * p = strtox_prelim(s, &sign, &base);
	if (base < 2 || base > 36)
		return 0;
    uintmax_t a, b;
    int c;
	if (sign == '+') {
        a = (uintmax_t) LONG_MAX;
        b = (uintmax_t) (LONG_MAX / base);
        c = (int) (LONG_MAX % base);
	} else {
        a = (uintmax_t) LONG_MIN;
        b = (uintmax_t) (LONG_MIN / -base);
        c = (int) (-(LONG_MIN % base));
	}
	long int rc = (long int) strtox_main(&p, (unsigned) base, a, b, c, &sign);
	if (endptr != NULL)
		*endptr = (p != NULL) ? (char *) p : (char *) s;
	return (sign == '+') ? rc : -rc;
}

unsigned long int strtoul(const char * s, char ** endptr, int base) {
	char sign = '+';
	const char * p = strtox_prelim(s, &sign, &base);
	if (base < 2 || base > 36)
		return 0;
	unsigned long int rc = (unsigned long int) strtox_main(&p, (unsigned) base, (uintmax_t) ULONG_MAX, (uintmax_t) ( ULONG_MAX / base), (int) ( ULONG_MAX % base), &sign);
	if (endptr != NULL)
		*endptr = (p != NULL) ? (char *) p : (char *) s;
	return (sign == '+') ? rc : -rc;
}

/*
 * GCC issue for strtoll/strtoull:
 * On x86, some long long operations (modulo, division) require compiler builtins like
 * _modti3 and __divti3. So you have to add -lgcc flag to force gcc to grab these functions (or implement
 * your own) when you don't use default standard library
 */
long long int strtoll(const char * s, char ** endptr, int base) {
	long long int rc;
	char sign = '+';
	const char * p = strtox_prelim(s, &sign, &base);
	if (base < 2 || base > 36)
		return 0;
    uintmax_t a, b;
    int c;
	if (sign == '+') {
        a = LLONG_MAX;
        b = (uintmax_t) ( LLONG_MAX / base);
        c = (int) ( LLONG_MAX % base);
	} else {
        a = (uintmax_t) LLONG_MIN;
        b = (uintmax_t) ( LLONG_MIN / -base);
        c = (int) (-( LLONG_MIN % base));
	}
    rc = (long long int) strtox_main(&p, (unsigned) base, a, b, c, &sign);
	if (endptr != NULL)
		*endptr = (p != NULL) ? (char *) p : (char *) s;
	return (sign == '+') ? rc : -rc;
}

unsigned long long int strtoull(const char * s, char ** endptr, int base) {
	char sign = '+';
	const char * p = strtox_prelim(s, &sign, &base);
	if (base < 2 || base > 36)
		return 0;
	unsigned long long int rc = strtox_main(&p, (unsigned) base, (uintmax_t) ULLONG_MAX, (uintmax_t) ( ULLONG_MAX / base), (int) ( ULLONG_MAX % base), &sign);
	if (endptr != NULL)
		*endptr = (p != NULL) ? (char *) p : (char *) s;
	return (sign == '+') ? rc : -rc;
}

static unsigned long myseed = 1;

int rand() {
	myseed = myseed * 1103515245UL + 12345;
	int ret = (int)((myseed >> 16) & RAND_MAX);
	return (ret);
}

void srand(unsigned int seed) {
	myseed = seed;
}

int abs(const int j) {
	return (j < 0) ? -j : j;
}

long int labs(const long int j) {
	return (j < 0) ? -j : j;
}

long long int llabs(const long long int j) {
	return (j < 0) ? -j : j;
}

int mblen(const char *s, size_t n) {
	if (s == NULL)
		return 0;
	if (n == 1)
		return 1;
	else
		return -1;
}

int mbtowc(wchar_t *pwc, const char *s, size_t n) {
	if (s == NULL)
		return 0;
	if (n == 1) {
		if (pwc != NULL)
			*pwc = *s;
		return 1;
	} else
		return -1;
}

int wctomb(char *s, wchar_t wchar) {
	if (s != NULL) {
		*s = wchar;
		return 1;
	} else
		return 0;
}

size_t mbstowcs(wchar_t *pwcs, const char *s, size_t n) {
	strncpy((char *)pwcs, s, n);
	if (strlen(s) >= n)
		return n;
	return strlen((char *)pwcs);
}

size_t wcstombs(char *s, const wchar_t *pwcs, size_t n) {
	strncpy(s, (const char *)pwcs, n);
	if (strlen((const char *)pwcs) >= n)
		return (n);
	return strlen(s);
}

void* bsearch(const void *key, const void *base, size_t nmemb, size_t size, int (*compar)(const void *, const void *)) {
	while (nmemb > 0) {
		size_t try = nmemb / 2;
		const void *ptr = (void *)((char *)base + try * size);
		int res = compar(ptr, key);
		if (res == 0)
			return ((void *)ptr);
		else if (res < 0) {
			nmemb = nmemb - try - 1;
			base = (const void *)((const char *)ptr + size);
		} else
			nmemb = try;
	}
	return NULL;
}

/*
 * This qsort function does a little trick:
 * To reduce stackspace it iterates the larger interval instead of doing
 * the recursion on both intervals.
 * So stackspace is limited to 32*stack_for_1_iteration =
 * 32*4*(4 arguments+1 returnaddress+11 stored registers) = 2048 Bytes,
 * which is small enough for everybodys use.
 * (And this is the worst case if you own 4GB and sort an array of chars.)
 * Sparing the function calling overhead does improve performance, too.
 */
void qsort(void *base, size_t nmemb, size_t size, int (*compar)(const void *, const void *)) {
	char *base2 = (char *)base;
	while (nmemb > 1) {
		size_t a = 0;
		size_t b = nmemb - 1;
		size_t c = (a + b) / 2; /* Middle element */
		for (;; ) {
			while ((*compar)(&base2[size * c], &base2[size * a]) > 0)
				a++; /* Look for one >= middle */
			while ((*compar)(&base2[size * c], &base2[size * b]) < 0)
				b--; /* Look for one <= middle */
			if (a >= b)
				break; /* We found no pair */
			for (size_t i = 0; i < size; i++) { /* swap them */
				char tmp = base2[size * a + i];
				base2[size * a + i] = base2[size * b + i];
				base2[size * b + i] = tmp;
			}
			if (c == a) /* Keep track of middle element */
				c = b;
			else if (c == b)
				c = a;
			a++; /* These two are already sorted */
			b--;
		} /* a points to first element of right interval now (b to last of left) */
		b++;
		if (b < nmemb - b) { /* do recursion on smaller interval and iteration on larger one */
			qsort(base2, b, size, compar);
			base2 = &base2[size * b];
			nmemb = nmemb - b;
		} else {
			qsort(&base2[size * b], nmemb - b, size, compar);
			nmemb = b;
		}
	}
}

//********************************************************************************
// time.h
//********************************************************************************
//--------------------------------------------------------------------------------
// Clock time since the program started.
//--------------------------------------------------------------------------------
clock_t clock() {
    return -1;
}

//--------------------------------------------------------------------------------
// Calendar time of the system as time since epoch.
//--------------------------------------------------------------------------------
double difftime(time_t time1, time_t time0) {
    return (double)(time1 - time0);
}

time_t mktime(struct tm *timeptr) {
    return 0;
}

time_t time(time_t *timer) {
    return 0;
}

static struct tm l_time;

struct tm *gmtime(const time_t *timer) {
    return &l_time;
}

struct tm *gmtime_s(const time_t * restrict timer, struct tm * restrict result) {
//    return result;
    return NULL;
}

struct tm *localtime(const time_t *timer) {
    return &l_time;
}

struct tm *localtime_s(const time_t * restrict timer, struct tm * restrict result) {
//    return result;
    return NULL;
}

static char l_timeString[64];

char *asctime(const struct tm *timeptr) {
    l_timeString[0]=0;
    return l_timeString;
}

errno_t asctime_s(char *s, rsize_t maxsize, const struct tm *timeptr) {
    s[0]=0;
    return -1;
}

char *ctime(const time_t *timer) {
    l_timeString[0]=0;
    return l_timeString;
}

errno_t ctime_s(char *s, rsize_t maxsize, const time_t *timer) {
    s[0]=0;
    return -1;
}

size_t strftime(char * restrict s, size_t maxsize, const char * restrict format, const struct tm * restrict timeptr) {
    s[0]=0;
    return 0;
}

//--------------------------------------------------------------------------------
// Calendar time in seconds and nanoseconds based on a given time base.
//--------------------------------------------------------------------------------
int timespec_get(struct timespec *ts, int base) {
    return 0;
}

int clock_gettime(clockid_t clk, struct timespec *ts) {
	int r = mir_sysclock_gettime(clk, ts);
	return r;
}


//--------------------------------------------------------------------------------
// Sleep
//--------------------------------------------------------------------------------
int nanosleep (const struct timespec *req, struct timespec *rem) {
    return 0;
}

//--------------------------------------------------------------------------------
// Net
//--------------------------------------------------------------------------------
char* inet_ntoa(struct in_addr in) {
    return "127.0.0.1";
}

in_addr_t inet_addr(const char* cp) {
    return INADDR_NONE;
}


