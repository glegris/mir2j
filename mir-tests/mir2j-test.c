//void printf (const char *fmt, ...);
//void abort (void);

#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include <setjmp.h>

#define SieveSize 819000
#define Expected 65333
//#define SieveSize 8190
//#define Expected 1027
#define N_ITER 1000

int global_var_int = 15;
char global_var_char = 'd';
long global_var_long = 32L;
static const int global_int_array[] = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };

struct pair {
	int a;
	int b;
};

struct point {
    int x;
    struct {
      int y;
      int z;
    } nest;
    int t;
    int q;
};

struct lib {
  char *name;
  char *link;
};

typedef struct lib lib_t;

static lib_t std_libs[] = {{"/lib/libc.so.6", NULL},   {"/lib32/libc.so.6", NULL},     
       {"/lib/libm.so.6", NULL}, {"/lib32/libm.so.6", NULL}, {"/lib/libpthread.so.0", NULL}, 
       {"/lib32/libpthread.so.0", NULL}};

void test_check(const char* s, int v) {
  printf(s);
  printf(": ");
  if (v) {
  	printf("OK\n");
  } else {
  	printf("FAIL\n");
  }
	
} 

void test_arithmetics() {
  int8_t c = -100;
  int8_t rc = c >> 1;
  test_check("Arithmetics #1 (int8_t)", (rc == -50));
  rc = c + 200;
  test_check("Arithmetics #2 (int8_t)", (rc == 100));
  rc = rc >> 1;
  test_check("Arithmetics #3 (int8_t)", (rc == 50));
  
  uint8_t uc = 200;
  uint8_t ruc = uc + 50;
  test_check("Arithmetics #4 (uint8_t)", (ruc == 250));
  ruc = ruc >> 1;
  test_check("Arithmetics #5 (uint8_t)", (ruc == 125));

  int32_t i = 65;
  int32_t ri = i - 130;
  test_check("Arithmetics #6 (int32_t)", (ri == -65));

  uint32_t ui = 2147483647;
  uint32_t rui = ui + 50;
  test_check("Arithmetics #7 (uint32_t)", (rui > 2147483647));
}

void test_local_variables() {
  const int local_const_int_array[] = { 2, 20, 200, 2000, 20000 };
  test_check("Local variables #1 (const array)", local_const_int_array[4] == 20000);
  int local_int_array[] = { 3, 30, 300, 3000, 30000 };
  test_check("Local variables #2 (array)", local_int_array[3] == 3000); 	
}

void test_global_variables() {
  test_check("Global variables #1 (int)", global_var_int == 15);
  test_check("Global variables #2 (char)", global_var_char == 'd');
  test_check("Global variables #3 (long)", global_var_long == 32L);
  test_check("Global variables #4 (int array)", global_int_array[4] == 10000);
  lib_t first_lib = std_libs[0];
  test_check("Global variables #5 (struct)", first_lib.name[10] == 's');
  // printf("global_var_int=%d\n", global_var_int);
  // printf("global_var_char=%c\n", global_var_char);
  // printf("global_var_long=%d\n", global_var_long);
}

static int call_static_function() {
  return 145;
}

void test_static_functions() {
  int v= call_static_function();
  test_check("Static functions #1", v == 145);	
}

void pointed_function_void(int input) {
  global_var_int += input;
}

int pointed_function_int(int input) {
  int v = input + 37;
  return v;
}

int pointed_function_int2(int input) {
  int v = input + 76;
  return v;
}

float pointed_function_float(float input) {
  float v = input / 2;
  return v;
}

double pointed_function_double(double input) {
  double v = input / 4;
  return v;
}

void call_pointed_function_void(int input, void (*pf)(int)) {
  pf(input);
}

int call_pointed_function_int(int input, int (*pf)(int)) {
  return pf(input);
}

static int call_static_pointed_function_int(int input, int (*pf)(int)) {
  return pf(input);
}

float call_pointed_function_float(float input, float (*pf)(float)) {
  return pf(input);
}

double call_pointed_function_double(float input, double (*pf)(double)) {
  return pf(input);
}

void test_pointers() {
  int g;
  int  x;
  int *p;
  g = 1;
  x = 1;
  p = &x;
  *p = 32;
  test_check("Pointers #1 (Assignement)", x == 32);
  
  p = &g;
  *p = 45;
  test_check("Pointers #2 (Assignement)", g == 45);

  char *a;
  a = "abcdef";
  test_check("Pointers #3 (Arithmetic)", *(a + 2) == 'c');

  int (*pf)(int);
  pf = &pointed_function_int;
  int v = pf(12);
  pf = &pointed_function_int2;
  int v2 = pf(v);
  test_check("Pointers #4 (Function)", (v == 49) && (v2 == 125));
  v2 = call_pointed_function_int(100, &pointed_function_int);
  test_check("Pointers #5 (Function)", (v2 == 137));
  v2 = call_static_pointed_function_int(100, &pointed_function_int);
  test_check("Pointers #6 (Function)", (v2 == 137));
  float f = call_pointed_function_float(2.5, &pointed_function_float);
  test_check("Pointers #7 (Function)", (f == 1.25));
  double d = call_pointed_function_double(10, &pointed_function_double);
  test_check("Pointers #8 (Function)", (d == 2.5));
  int last_global_var_int = global_var_int;
  call_pointed_function_void(23, &pointed_function_void);
  test_check("Pointers #9 (Function)", (global_var_int == (last_global_var_int + 23)));
}

struct pair get_pair(int a, int b) {
	struct pair p;
	//printf("get_pair(): a=%d b=%d\n", a, b);
	p.a = a;
	p.b = b;
	return p;
}

void modify_pair(struct pair* p) {
	p->a = 340;
	p->b = 360;
}

int add_pair(struct pair p1, struct pair p2) {
	int r = p1.a + p2.a;
	return r;
}

struct point get_point(int x, int y, int z) {
	struct point v;
	v.x = x;
	v.nest.y = y;
	v.nest.z = z;
	//v.t = 400;
	//v.q = 500;
	return v;
}

void test_structures() {
  struct point v;
  v.x = 1;
  v.nest.y = 2;
  v.nest.z = 3;
  test_check("Structures #1", v.x + v.nest.y + v.nest.z == 6);

  struct point *p;
  p = &v;
  v.nest.y = 56;
  test_check("Structures #2", p->nest.y == 56);

  struct pair p2;
  p2 = get_pair(78, 126); 
  test_check("Structures #3", (p2.a == 78) && (p2.b == 126)); 

  modify_pair(&p2);
  test_check("Structures #4", (p2.a == 340) && (p2.b == 360)); 

  struct pair p3;
  p3.a = 600;
  int r = add_pair(p2, p3);
  test_check("Structures #5", (r == 940)); 
  
  struct point v2 = get_point(100, 200, 300);
  test_check("Structures #6", (v2.x == 100) && (v2.nest.y == 200) && (v2.nest.z == 300)); // && (v2.t == 400) && (v2.q == 500));
}

static int call_switch(int label) {
  int i = label;
  int r = 0;
  switch(i) {
    case 0:
      r = i + 4;
      break;
    case 1:
      r = i * 8;
      break;
    case 2:
      r = i * 16;
      break;
    case 3:
      r = i - 1;
      break;
    case 4:
      r = i + 2;
      break;
    case 5:
    default:
      r = i * 5;
      break;
  }
  return r;	
}

void test_switch() {
  int r = call_switch(0);
  test_check("Switch #1", r == 4);
  r = call_switch(1);
  test_check("Switch #2", r == 8);
  r = call_switch(2);
  test_check("Switch #3", r == 32);
  r = call_switch(3);
  test_check("Switch #4", r == 2);
  r = call_switch(4);
  test_check("Switch #5", r == 6);
  r = call_switch(5);
  test_check("Switch #6", r == 25);
  r = call_switch(20);
  test_check("Switch #7", r == 100);
}

static int add_em_up(int count,...) {
  va_list ap;
  int i; 
  double sum;
  va_start (ap, count);         /* Initialize the argument list. */
  sum = 0;
  sum += va_arg (ap, double);
  for (i = 1; i < count; i++)
    sum += va_arg (ap, int);    /* Get the next argument value. */
  va_end (ap);                  /* Clean up. */
  return sum;
}

void test_varargs() {
  int v = add_em_up (3, 5.0, 5, 6);
  test_check("Varargs #1", v == 16);
  v = add_em_up (10, 1.0, 2, 3, 4, 5, 6, 7, 8, 9, 10);
  test_check("Varargs #2", v == 55);
}

static jmp_buf jump_buffer;

static void call_longjmp(int v) {
  longjmp(jump_buffer, v);
}

void test_setjmp() {
  int i = 987;
  int j = 1025;
  int v = setjmp(jump_buffer);
  if (v == 0) {
    test_check("Setjmp #1", v == 0);
    i++; j++; // Should have no effect after the longjmp 
    // Direct return
    call_longjmp(34);
    test_check("Setjmp #2", 0); // We should not be here
  } else {
    // Return from longjmp
    test_check("Setjmp #2", (v == 34) && (i == 987) && (j == 1025));
  }
}

/*=========================
         Sieve  
  ========================*/

int sieve (int n) {
  long i, k, count, iter, prime;
  char flags[SieveSize];

  for (iter = 0; iter < n; iter++) {
    count = 0;
    for (i = 0; i < SieveSize; i++) flags[i] = 1;
    for (i = 2; i < SieveSize; i++)
      if (flags[i]) {
        prime = i + 1;
        for (k = i + prime; k < SieveSize; k += prime) flags[k] = 0;
        count++;
      }
  }
  return count;
}

void test_sieve() {
  int n = sieve (N_ITER);
  printf ("%d iterations of sieve for %d: result = %d\n", N_ITER, SieveSize, n);
  test_check("Sieve", n == Expected);
}


/*=========================
         Arrays  
  ========================*/

void test_arrays() {
    int n = 50000; //5000000
    int i, k, *x, *y;
    
    x = (int *) calloc(n, sizeof(int));
    y = (int *) calloc(n, sizeof(int));

    for (i = 0; i < n; i++) {
      x[i] = i + 1;
    }
    for (k=0; k<1000; k++) {
      for (i = n-1; i >= 0; i--) {
        y[i] += x[i];
      }
    }

    //printf("%d %d\n", y[0], y[n-1]);
    test_check("Arrays", (y[0] == 1000) && (y[n-1] == 50000000)); // 1000 705032704

    free(x);
    free(y);
}

/*=========================
         Heap sort  
  ========================*/

#define IM 139968
#define IA   3877
#define IC  29573

double gen_random(double max) {
    static long last = 42;
    return( max * (last = (last * IA + IC) % IM) / IM );
}

void heap_sort(int n, double *ra) {
  int i, j;
  int ir = n;
  int l = (n >> 1) + 1;
  double rra;

  for (;;) {
    if (l > 1) {
      rra = ra[--l];
    } else {
      rra = ra[ir];
      ra[ir] = ra[1];
      if (--ir == 1) {
        ra[1] = rra;
        return;
      }
    }
    i = l;
    j = l << 1;
    while (j <= ir) {
      if (j < ir && ra[j] < ra[j+1]) { ++j; }
      if (rra < ra[j]) {
        ra[i] = ra[j];
        j += (i = j);
      } else {
        j = ir + 1;
      }
    }
    ra[i] = rra;
  }
}

void test_heapsort() {
  int N = 200000;
  double *ary;
  int i;
    
  ary = (double *) malloc((N+1) * sizeof(double));
  for (i=1; i<=N; i++) {
    ary[i] = gen_random(1);
  }

  heap_sort(N, ary);

  //printf("%.10g\n", ary[N]);
  //printf("%g\n", ary[N]);
  test_check("Heap sort", (ary[N] > 0.999992) && (ary[N] < 0.999993));
  
  free(ary);
}

/*=========================
         Matrix  
  ========================*/

#define SIZE 30

int **mkmatrix (int rows, int cols) {
  int i, j, count = 1;
  int **m = (int **) malloc (rows * sizeof (int *));
  for (i = 0; i < rows; i++) {
    m[i] = (int *) malloc (cols * sizeof (int));
    for (j = 0; j < cols; j++) {
      m[i][j] = count++;
    }
  }
  return (m);
}

void zeromatrix (int rows, int cols, int **m) {
  int i, j;
  for (i = 0; i < rows; i++)
    for (j = 0; j < cols; j++) m[i][j] = 0;
}

void freematrix (int rows, int **m) {
  while (--rows > -1) {
    free (m[rows]);
  }
  free (m);
}

int **mmult (int rows, int cols, int **m1, int **m2, int **m3) {
  int i, j, k, val;
  for (i = 0; i < rows; i++) {
    for (j = 0; j < cols; j++) {
      val = 0;
      for (k = 0; k < cols; k++) {
        val += m1[i][k] * m2[k][j];
      }
      m3[i][j] = val;
    }
  }
  return (m3);
}

void test_matrix() {
  int i, n = 3000;

  int **m1 = mkmatrix (SIZE, SIZE);
  int **m2 = mkmatrix (SIZE, SIZE);
  int **mm = mkmatrix (SIZE, SIZE);

  for (i = 0; i < n; i++) {
    mm = mmult (SIZE, SIZE, m1, m2, mm);
  }
  //printf ("%d %d %d %d\n", mm[0][0], mm[2][3], mm[3][2], mm[4][4]);
  test_check("Matrix", (mm[0][0] == 270165) && (mm[2][3] == 1061760) && (mm[3][2] == 1453695) && (mm[4][4] == 1856025));

  freematrix (SIZE, m1);
  freematrix (SIZE, m2);
  freematrix (SIZE, mm);
}

int main (void) {
  
  test_arithmetics();
  test_local_variables();
  test_global_variables();
  test_static_functions();
  test_pointers();
  test_structures();
  test_switch();
  test_varargs();
  test_setjmp();
  
  //test_sieve();
  test_arrays();
  test_heapsort();
  test_matrix();

  return 0;
}
