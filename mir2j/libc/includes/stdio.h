#ifndef stdio_h
#define stdio_h

#include "errno.h"
#include <stdarg.h>
#include "stddef.h"
#include "stdint.h"

#define EOF (-1)

typedef struct __sysio_FILE FILE;

#define stdin (stdin)
extern FILE* const stdin;

#define stdout (stdout)
extern FILE* const stdout;

#define stderr (stderr)
extern FILE* const stderr;

typedef int64_t fpos_t;

#define EOF (-1)

#define SEEK_SET 0
#define SEEK_CUR 1
#define SEEK_END 2

#define TMP_MAX 32
#define FOPEN_MAX 32
#define FILENAME_MAX 256
#define BUFSIZ 256

/*
_IOFBF
_IOLBF
_IONBF
L_tmpnam
*/

int remove(const char *filename);
int rename(const char *old, const char *new);
FILE *tmpfile();
char *tmpnam(char *s);

/**
 * Open the file with the given filename in the given mode, and return a stream
 * handle for it in which error and end-of-file indicator are cleared.
 */
FILE *fopen(const char * restrict filename, const char * restrict mode);

/**
 * Close the file associated with the given stream (after flushing its buffers).
 * Returns zero if successful, EOF if any errors occur.
 */
int fclose(FILE *stream);

/**
 * Close any file currently associated with the given stream. Open the file
 * identified by the given filename with the given mode (equivalent to fopen()),
 * and associate it with the given stream. If filename is a NULL pointer,
 * attempt to change the mode of the given stream.
 */
FILE *freopen(const char * restrict filename, const char * restrict mode, FILE * restrict stream);

/**
 * Read up to nmemb elements of given size from given stream into the buffer
 * pointed to by ptr. Returns the number of elements successfully read, which
 * may be less than nmemb if a read error or EOF is encountered. If a read
 * error is encountered, the value of the file position indicator is
 * indeterminate. If a partial element is read, its value is indeterminate.
 * If size or nmemb are zero, the function does nothing and returns zero.
 */
size_t fread(void * restrict ptr, size_t size, size_t nmemb, FILE * restrict stream);

/**
 * Write up to nmemb elements of given size from buffer pointed to by ptr to
 * the given stream. Returns the number of elements successfully written, which
 * will be less than nmemb only if a write error is encountered. If a write
 * error is encountered, the value of the file position indicator is
 * indeterminate. If size or nmemb are zero, the function does nothing and
 * returns zero.
 */
size_t fwrite(const void * restrict ptr, size_t size, size_t nmemb, FILE * restrict stream);

/**
 * Flush the buffers of the given output stream. If the stream is an input
 * stream, or an update stream with the last operation being an input operation,
 * behaviour is undefined.
 * If stream is a NULL pointer, perform the buffer flushing for all applicable
 * streams.
 * Returns zero if successful, EOF if a write error occurs.
 * Sets the error indicator of the stream if a write error occurs.
 */
int fflush(FILE *stream);

int fgetpos(FILE * restrict stream, fpos_t * restrict pos);

/**
 * Set the position indicator for the given stream to the given offset from:
 * - the beginning of the file if whence is SEEK_SET,
 * - the current value of the position indicator if whence is SEEK_CUR,
 * - end-of-file if whence is SEEK_END.
 * On text streams, non-zero offsets are only allowed with SEEK_SET, and must
 * have been returned by ftell() for the same file.
 * Any characters buffered by ungetc() are dropped, the end-of-file indicator
 * for the stream is cleared. If the given stream is an update stream, the next
 * operation after a successful fseek() may be either input or output.
 * Returns zero if successful, nonzero otherwise. If a read/write error occurs,
 * the error indicator for the given stream is set.
 */
int fseek(FILE *stream, long int offset, int whence);

int fsetpos(FILE *stream, const fpos_t *pos);

/**
 *  Return the current offset of the given stream from the beginning of the
 *  associated file. For text streams, the exact value returned is unspecified
 *  (and may not be equal to the number of characters), but may be used in
 *  subsequent calls to fseek().
 *  Returns -1L if unsuccessful.
 */
long int ftell(FILE *stream);

void rewind(FILE *stream);
void clearerr(FILE *stream);

/**
 * Return zero if the end-of-file indicator for the given stream is not set,
 * nonzero otherwise.
 */
int feof(FILE *stream);

int ferror(FILE *stream);
void setbuf(FILE * restrict stream, char * restrict buf);
int setvbuf(FILE * restrict stream, char * restrict buf, int mode, size_t size);

int sscanf(const char * restrict s, const char * restrict format, ...);
int vsscanf(const char * restrict s, const char * restrict format, va_list arg);
int fscanf(FILE * restrict stream, const char * restrict format, ...);
int vfscanf(FILE * restrict stream, const char * restrict format, va_list arg);

/**
 * Equivalent to fgetc( stream ), but may be overloaded by a macro that
 * evaluates its parameter more than once.
 */
int getc(FILE *stream);

int ungetc(int c, FILE *stream);

/**
 * Retrieve the next character from given stream.
 * Returns the character, EOF otherwise.
 * If end-of-file is reached, the EOF indicator of the stream is set.
 * If a read error occurs, the error indicator of the stream is set.
 */
int fgetc(FILE *stream);

char *fgets(char * restrict s, int n, FILE * restrict stream);
int scanf(const char * restrict format, ...);
int vscanf(const char * restrict format, va_list arg);

int vsprintf(char * restrict s, const char * restrict format, va_list arg);
int sprintf(char * restrict s, const char * restrict format, ...);
int snprintf(char * restrict s, size_t n, const char * restrict format, ...);
int vsnprintf(char * restrict s, size_t n, const char * restrict format, va_list arg);
int printf(const char * restrict format, ...);
int vprintf(const char * restrict format, va_list arg);
int vfprintf(FILE * restrict stream, const char * restrict format, va_list arg);
int fprintf(FILE * restrict stream, const char * restrict format, ...);
int fputs(const char * restrict s, FILE * restrict stream);

/**
 * Write the value c (cast to unsigned char) to the given stream.
 * Returns c if successful, EOF otherwise.
 * If a write error occurs, sets the error indicator of the stream is set.
 */
int fputc(int c, FILE *stream);

/**
 * Equivalent to fputc( c, stream ), but may be overloaded by a macro that
 * evaluates its parameter more than once.
 */
int putc(int c, FILE *stream);

/**
 * Write the string s (not including the terminating \0) to stdout, and append
 * a newline to the output. Returns a value >= 0 when successful, EOF if a
 * write error occurred.
 */
int puts(const char *s);
void perror(const char *s);

/**
 * Equivalent to fputc( c, stdout ), but may be overloaded by a macro that
 * evaluates its parameter more than once.
 */
int putchar(int c);

/**
 * Equivalent to fgetc( stdin ).
 */
int getchar();

/*

#if defined(__STDC_WANT_LIB_EXT1__)
#define L_tmpnam_s ???
#define TMP_MAX_S ???

errno_t tmpfile_s(FILE * restrict * restrict streamptr);
errno_t tmpnam_s(char *s, rsize_t maxsize);
errno_t fopen_s(FILE * restrict * restrict streamptr, const char * restrict filename, const char * restrict mode);
errno_t freopen_s(FILE * restrict * restrict newstreamptr, const char * restrict filename, const char * restrict mode, FILE * restrict stream);
int fprintf_s(FILE * restrict stream, const char * restrict format, ...);
int fscanf_s(FILE * restrict stream, const char * restrict format, ...);
int printf_s(const char * restrict format, ...);
int scanf_s(const char * restrict format, ...);
int snprintf_s(char * restrict s, rsize_t n, const char * restrict format, ...);
int sprintf_s(char * restrict s, rsize_t n, const char * restrict format, ...);
int sscanf_s(const char * restrict s, const char * restrict format, ...);
int vfprintf_s(FILE * restrict stream, const char * restrict format, va_list arg);
int vfscanf_s(FILE * restrict stream, const char * restrict format, va_list arg);
int vprintf_s(const char * restrict format, va_list arg);
int vscanf_s(const char * restrict format, va_list arg);
int vsnprintf_s(char * restrict s, rsize_t n, const char * restrict format, va_list arg);
int vsprintf_s(char * restrict s, rsize_t n, const char * restrict format, va_list arg);
int vsscanf_s(const char * restrict s, const char * restrict format, va_list arg);
char *gets_s(char *s, rsize_t n);
#endif

*/

#endif
