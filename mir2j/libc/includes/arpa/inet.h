#ifndef _ARPA_INET_H
#define	_ARPA_INET_H

#include <netinet/in.h>

in_addr_t inet_addr(const char* cp);
char* inet_ntoa(struct in_addr);

#endif
