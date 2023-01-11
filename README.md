# MIR2j Project

The goal of this project is to make C applications/libraries work in a JVM. There are already projects that do this:
- [NestedVM ](http://nestedvm.ibex.org/) or [Cibyl](https://github.com/SimonKagstrom/cibyl)
- [LLJVM-translator](https://github.com/maropu/lljvm-translator) (based on [LLJVM ](https://github.com/davidar/lljvm) by David Roberts)

It should be possible to do the same thing with [MIR](https://github.com/vnmakarov/mir) but with a much smaller footprint.

At first, I thought it wasn't a good idea (for me) to start generating bytecodes because I needed to understand how MIR works and experiment with trial and error (and also because I haven't found a good bytecode manipulation library in pure c). So I decided to generate Java sources for now. Another advantage is that we could also easily generate sources for languages close to Java syntax like C# or Dart.

```
LLVM IR / C => MIR => Java Sources
```

Because there is no goto instruction at source level, the program flow is based on a loop with switch/case statements.

```
public void doSomething() {
  while(true) {
    switch(label) {
    case 1:
     ....
    case 2:
      label = 1; // goto L1;
      break;
    }
  }
}  
```

Memory is a giant byte array (byte[]) with this structure: DATA | STACK | HEAP. It seems to me than putting the heap at the end helps to minimize memory footprint when a program is not allocating on the heap.

The C Standard library will be implemented in two places : a Runtime class (only printf and alloca yet) and a single C file for the other common functions which don't require an interaction with the subsystem (like string manipulations)

Currently the code is in its early stages, but the sieve.c example can already be converted and works fine.

## Issues

When calling functions passing structures by value, the following behavior has been observed:
> If the size of the structure is less than 16 bytes, then c2mir generates functions which return 2 values of 8 bytes to avoid allocating a block of memory on the stack.

> If the size of the structure is greater than 16 bytes, c2mir allocates a memory block on the stack in which the values of the structure are written.

Until this problem is fixed, you should modify your C source code so that structures are always larger than 16 bytes (ugly)

