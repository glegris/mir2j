# MIR2j

Run C applications/libraries on the JVM by translating __[MIR](https://github.com/vnmakarov/mir)__ to __Java source__.

Prior art exists:
- [NestedVM ](http://nestedvm.ibex.org/) / [Cibyl](https://github.com/SimonKagstrom/cibyl)
- [LLJVM-translator](https://github.com/maropu/lljvm-translator) (based on [LLJVM ](https://github.com/davidar/lljvm) by David Roberts)

It should be possible to do the same thing with [MIR](https://github.com/vnmakarov/mir) but with a much smaller footprint.

The idea here is to reuse [MIR](https://github.com/vnmakarov/mir) for a much smaller footprint and generate Java sources (for easy experimentation and portability). Generating Java also keeps the door open to C# / Dart later.

```
C / LLVM IR  →  MIR  →  Java sources  →  JVM
```

Because there is no ```goto``` instruction at source level in Java, control flow is expressed with a loop + switch/case over a label

```
while (true) {
  switch (label) {
    case 1: /* ... */ label = 2; break;  // goto L2;
    case 2: /* ... */ return;
  }
}
```

## Machine model
- Endianness: little-endian (LE)
- Pointer size: 64-bit (8 bytes)
- Memory layout: DATA | STACK | HEAP in a single byte[]
- Function pointers are modeled as small integers mapped to Java Method handles.

## Runtine

The default runtime intentionally stays minimal: memcpy, memset, very limited printf, basic strlen/strcpy, a few syscalls/stubs used by tests.

If you need more libc surface (and richer printf/vfprintf/…), you can link a small C standard library alongside.

## Build

Prereqs: make, a C99 compiler, and a JDK 1.2+

#### Build MIR and c2mir

``` make ```

#### Build mir2j

``` make m2j```

#### Build test program & demo ([raygui 3.5](https://github.com/raysan5/raygui) port in Java)  

```
cd mir2j
./compile-test.sh
```

or 

```
./compile-raygui.sh
```

## Status
- Experimental. Focus is correctness and clarity of the translation path.
- Java sources are generated for readability and quick iteration (no bytecode gen yet).

## Why MIR?
[MIR](https://github.com/vnmakarov/mir) is tiny and fast, making it a great IR target for lightweight toolchains. The translator stays simple and the runtime small.

## Roadmap (short)
- Fill more libc gaps as needed (either Java-side or via a small C shim)
- More intrinsics / syscalls as use-cases surface
- Performance passes once semantics are solid


