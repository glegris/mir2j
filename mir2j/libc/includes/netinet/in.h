#ifndef	_NETINET_IN_H
#define	_NETINET_IN_H

typedef uint32_t in_addr_t;
#define INADDR_NONE       ((in_addr_t) 0xFFFFFFFF)

struct in_addr { in_addr_t s_addr; };

#endif

