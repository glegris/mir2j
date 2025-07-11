#ifndef uchar_h
#define uchar_h

mbstate_t size_t char16_t char32_t
size_t mbrtoc16(char16_t * restrict pc16, const char * restrict s, size_t n, mbstate_t * restrict ps);
size_t c16rtomb(char * restrict s, char16_t c16, mbstate_t * restrict ps);
size_t mbrtoc32(char32_t * restrict pc32, const char * restrict s, size_t n, mbstate_t * restrict ps);
size_t c32rtomb(char * restrict s, char32_t c32, mbstate_t * restrict ps);

#endif
