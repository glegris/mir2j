package mir2j;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Runtime {

    private static final boolean LOG_WARNING = true;

    private static final int PTR_SIZE = 8;
    private static final int VA_ARG_BUFFER_SIZE = 8;

    private byte[] memory;

    private int stackPosition = 8; // Do not start at 0 to avoid weird bugs caused by comparisons with 0
    private final int maxStackSize;
    private final int varArgsBufferAddress;
    private final int functionSpaceStartAddress;
    private final int functionSpaceSize;
    private int nextfunctionPointer;
    private final int heapStartAddress;
    private TreeMap<Integer, MemoryBlock> memoryBlockMap = new TreeMap<>();
    private TreeMap<Integer, VarArgs> varArgsMap = new TreeMap<>();
    private HashMap<String, Integer> stringMap = new HashMap<>();
    private FunctionMap functionMap = new FunctionMap();

    public static final int FD_STDIN  = 0;
    public static final int FD_STDOUT = 1;
    public static final int FD_STDERR = 2;
    public static final int EOF = -1;
    
    public Runtime() {
        this(1000000);
    }
    
    public Runtime(int memorySize) {
        // Define memory sections
        memory = new byte[memorySize];
        maxStackSize = memorySize / 5;
        varArgsBufferAddress = maxStackSize;
        functionSpaceStartAddress = varArgsBufferAddress + VA_ARG_BUFFER_SIZE;
        functionSpaceSize = 1000;
        nextfunctionPointer = functionSpaceStartAddress;
        heapStartAddress = functionSpaceStartAddress + functionSpaceSize;
    }

    public int growMemory(int minSize) {
        int newSize = memory.length * 2;
        while (newSize < minSize) {
            newSize *= 2;
        }
        byte[] newMemory = new byte[newSize];
        System.arraycopy(memory, 0, newMemory, 0, memory.length);
        memory = newMemory;
        return newSize;
    }

    public int mir_get_stack_position() {
        return stackPosition;
    }

    public void mir_set_stack_position(int position) {
        stackPosition = position;
    }

    public long mir_allocate(long sizeInBytes) {
        int oldStackPosition = stackPosition;
        if ((oldStackPosition + sizeInBytes) > maxStackSize) {
            throw new RuntimeException("Stack overflow");
        }
        stackPosition += sizeInBytes;
        return oldStackPosition;
    }

    private MemoryBlock addBlock(int address, int size, boolean free) {
        if ((address + size) > memory.length) {
            // TODO Try to merge free blocks before growing memory
            growMemory(address + size);
        }
        MemoryBlock block = new MemoryBlock(address, size, free);
        memoryBlockMap.put(address, block);
        // System.out.println(block);
        return block;
    }

    public long malloc(long longSize) {
        int size = (int) longSize;
        // Try to find a free block
        if (!memoryBlockMap.isEmpty()) {
            Iterator<MemoryBlock> i = memoryBlockMap.values().iterator();
            while (i.hasNext()) {
                MemoryBlock block = i.next();
                if (block.getSize() >= size && block.isFree()) {
                    block.setFree(false);
                    // Split block if possible
                    int newBlockSize = block.getSize() - size;
                    if (newBlockSize > 0) {
                        // Resize the current block before creating a new one
                        block.setSize(size);
                        int newBlockAddress = block.getStartAddress() + size;
                        addBlock(newBlockAddress, newBlockSize, true);
                    }
                    return block.getStartAddress();
                }
            }
        }
        // No block was found. Let's create a new one.
        int newAddress;
        if (memoryBlockMap.isEmpty()) {
            newAddress = heapStartAddress;
        } else {
            MemoryBlock lastBlock = memoryBlockMap.lastEntry().getValue();
            newAddress = lastBlock.getStartAddress() + lastBlock.getSize();
        }
        addBlock(newAddress, size, false);
        return newAddress;
    }

    public long calloc(long elementCount, long elementSize) {
        int totalSize = (int) (elementCount * elementSize);
        int addr = (int) malloc(totalSize);
        if (addr == 0) {
            return 0;
        }
        for (int i = 0; i < totalSize; i++) {
            memory[addr + i] = 0;
        }
        return addr;
    }

    public long realloc(long blockAddr, long newSize) {
        MemoryBlock block = memoryBlockMap.get((int) blockAddr);
        if (block == null) {
            throw new RuntimeException("Can't find memory block at address " + blockAddr);
        }
        // TODO Try to not copy:
        // if newSize > oldSize: merging old block with next blocks
        // if newSize < oldSize: reducing the current bloc size and create a (free) new one
        int newBlockAddr = (int) malloc(newSize);
        int length = Math.min(block.getSize(), (int) newSize);
        System.arraycopy(memory, block.getStartAddress(), memory, newBlockAddr, length);
        return newBlockAddr;
    }

    public void free(long longAddr) {
        MemoryBlock block = memoryBlockMap.get((int) longAddr);
        if (block == null) {
            throw new RuntimeException("Can't free memory block at address " + longAddr);
        }
        block.setFree(true);
    }

    public byte mir_read_byte(long addr) {
        long b = memory[(int) addr];
        // System.out.println("readbyte(" + addr + "): " + b);
        return (byte) b;
    }

    public void mir_write_byte(long addr, long b) {
        // System.out.println("writebyte(" + addr + "," + b + ")");
        memory[(int) addr] = (byte) (b & 0xFF);
    }

    public int mir_read_ubyte(long addr) {
        int v = ((int) memory[(int) addr]) & 0xFF;
        return v;
    }

    public void mir_write_ubyte(long addr, long b) {
        // System.out.println("writebyte(" + addr + "," + b + ")");
        memory[(int) addr] = (byte) (b & 0xFF);
    }

    public short mir_read_short(long longAddr) {
        int addr = (int) longAddr;
        int b1 = memory[addr] & 0xFF;
        int b2 = memory[addr + 1] & 0xFF;
        return (short) ((b2 << 8) | b1);
    }

    public void mir_write_short(long longAddr, long v) {
        int addr = (int) longAddr;
        memory[addr]     = (byte) (v & 0xFF);
        memory[addr + 1] = (byte) ((v >> 8) & 0xFF);
    }
    
    public int mir_read_ushort(long longAddr) {
        int addr = (int) longAddr;
        int b1 = memory[addr] & 0xFF;
        int b2 = memory[addr + 1] & 0xFF;
        return (b2 << 8) | b1;
    }

    public void mir_write_ushort(long longAddr, long v) {
        int addr = (int) longAddr;
        int val = (int) (v & 0xFFFFL);
        memory[addr]     = (byte) (val & 0xFF);
        memory[addr + 1] = (byte) ((val >> 8) & 0xFF);
    }

    public void mir_write_int(long longAddr, long v) {
        int addr = (int) longAddr;
        int i = (int) v;
        memory[addr]     = (byte) (i & 0xFF);
        memory[addr + 1] = (byte) ((i >> 8) & 0xFF);
        memory[addr + 2] = (byte) ((i >> 16) & 0xFF);
        memory[addr + 3] = (byte) ((i >> 24) & 0xFF);
    }

    public int mir_read_int(long longAddr) {
        int addr = (int) longAddr;
        int b1 = memory[addr] & 0xFF;
        int b2 = memory[addr + 1] & 0xFF;
        int b3 = memory[addr + 2] & 0xFF;
        int b4 = memory[addr + 3] & 0xFF;
        return (b4 << 24) | (b3 << 16) |  (b2 << 8) | b1;
    }

    public void mir_write_uint(long longAddr, long v) {
        mir_write_int(longAddr, v & 0xFFFFFFFFL);
    }

    public long mir_read_uint(long longAddr) {
        long v = ((long) mir_read_int(longAddr)) & 0xFFFFFFFFL;
        return v;
    }

    public void mir_write_long(long longAddr, long l) {
        int addr = (int) longAddr;
        memory[addr]     = (byte) (l & 0xFF);
        memory[addr + 1] = (byte) ((l >> 8) & 0xFF);
        memory[addr + 2] = (byte) ((l >> 16) & 0xFF);
        memory[addr + 3] = (byte) ((l >> 24) & 0xFF);
        memory[addr + 4] = (byte) ((l >> 32) & 0xFF);
        memory[addr + 5] = (byte) ((l >> 40) & 0xFF);
        memory[addr + 6] = (byte) ((l >> 48) & 0xFF);
        memory[addr + 7] = (byte) ((l >> 56) & 0xFF);
    }

    public long mir_read_long(long longAddr) {
        int addr = (int) longAddr;
        long b1 =  (long) (memory[addr]     & 0xFF);
        long b2 = ((long) (memory[addr + 1] & 0xFF)) << 8;
        long b3 = ((long) (memory[addr + 2] & 0xFF)) << 16;
        long b4 = ((long) (memory[addr + 3] & 0xFF)) << 24;
        long b5 = ((long) (memory[addr + 4] & 0xFF)) << 32;
        long b6 = ((long) (memory[addr + 5] & 0xFF)) << 40;
        long b7 = ((long) (memory[addr + 6] & 0xFF)) << 48;
        long b8 = ((long) (memory[addr + 7] & 0xFF)) << 56;
        return b1 | b2 | b3 | b4 | b5 | b6 | b7 | b8;
    }

    public void mir_write_ulong(long longAddr, long l) {
        mir_write_long(longAddr, l);
    }

    public long mir_read_ulong(long longAddr) {
        return mir_read_long(longAddr);
    }

    public void mir_write_float(long longAddr, float f) {
        long intBits = Float.floatToRawIntBits(f);
        mir_write_int(longAddr, intBits);
    }

    public float mir_read_float(long longAddr) {
        int intBits = mir_read_int(longAddr);
        float f = Float.intBitsToFloat(intBits);
        return f;
    }

    public void mir_write_double(long longAddr, double d) {
        long longBits = Double.doubleToRawLongBits(d);
        mir_write_long(longAddr, longBits);
    }

    public double mir_read_double(long longAddr) {
        long longBits = mir_read_long(longAddr);
        double d = Double.longBitsToDouble(longBits);
        return d;
    }
    
    public long mir_read_pointer(long addr) {
        return mir_read_long(addr);
    }

    public void mir_write_pointer(long addr, long v) {
        mir_write_long(addr, v);
    }

    public long mir_set_data_bytes(byte[] s) {
        // System.out.println("writebyte(" + addr + "," + b + ")");
        long addr = mir_allocate(s.length);
        for (int i = 0; i < s.length; i++) {
            mir_write_byte(addr + i, s[i]);
        }
        return addr;
    }

    public long mir_set_data_ubytes(short[] s) {
        // System.out.println("writebyte(" + addr + "," + b + ")");
        long addr = mir_allocate(s.length);
        for (int i = 0; i < s.length; i++) {
            mir_write_ubyte(addr + i, s[i]);
        }
        return addr;
    }

    public long mir_set_data_shorts(short[] s) {
        // System.out.println("writebyte(" + addr + "," + b + ")");
        long addr = mir_allocate(s.length * 2);
        for (int i = 0; i < s.length; i++) {
            mir_write_short(addr + i * 2, s[i]);
        }
        return addr;
    }

    public long mir_set_data_longs(long[] s) {
        // System.out.println("writebyte(" + addr + "," + b + ")");
        long addr = mir_allocate(s.length * 8);
        for (int i = 0; i < s.length; i++) {
            mir_write_long(addr + i * 8, s[i]);
        }
        return addr;
    }

    public long mir_set_data_byte(long v) {
        // System.out.println("writebyte(" + addr + "," + b + ")");
        long addr = mir_allocate(1);
        mir_write_byte(addr, v);
        return addr;
    }

    public long mir_set_data_int(long v) {
        // System.out.println("writebyte(" + addr + "," + b + ")");
        long addr = mir_allocate(4);
        mir_write_int(addr, v);
        return addr;
    }

    public long mir_set_data_uint(long v) {
        // System.out.println("writebyte(" + addr + "," + b + ")");
        long addr = mir_allocate(4);
        mir_write_uint(addr, v);
        return addr;
    }

    public long mir_set_data_long(long v) {
        // System.out.println("writebyte(" + addr + "," + b + ")");
        long addr = mir_allocate(8);
        mir_write_long(addr, v);
        return addr;
    }

    public long mir_set_data_ulong(long v) {
        return mir_set_data_long(v);
    }

    public long mir_set_data_ref(long v) {
        return mir_set_data_long(v);
    }

    public long mir_set_data_float(float v) {
        long addr = mir_allocate(4);
        mir_write_float(addr, v);
        return addr;
    }
    
    public long mir_set_data_double(double v) {
        long addr = mir_allocate(8);
        mir_write_double(addr, v);
        return addr;
    }

    public long mir_allocate_double(double v) {
        long addr = mir_allocate(8);
        mir_write_double(addr, v);
        return addr;
    }

    public void mir_va_start(long vaListAddr, Object[] mir_var_args) {
        VarArgs varArgs = varArgsMap.get((int) vaListAddr);
        if (varArgs == null) {
            varArgs = new VarArgs(vaListAddr, mir_var_args);
            varArgsMap.put((int) vaListAddr, varArgs);
        } else {
            varArgs.reset(mir_var_args);
        }
    }

    /*
     * FIXME: va_end is not emitted by c2mir ! TODO: Temporary fix to call mir_va_end when the last arg is requested
     */
    public void mir_va_end(long vaListAddr) {
        varArgsMap.remove((int) vaListAddr);
    }

    public VarArgs mir_va_get_wrapper(long vaListAddr) {
        VarArgs varArgs = varArgsMap.get((int) vaListAddr);
        return varArgs;
    }

    public class VarArgs {
        private int vaListAddr;
        private Object[] args;
        private int index;

        public VarArgs(long vaListAddr, Object[] args) {
            this.vaListAddr = (int) vaListAddr;
            reset(args);
        }

        private Object nextArg() {
            Object arg = args[index++];
            return arg;
        }

        /* FIXME: Temporary fix until va_end is emitted: clean context when the last arg is requested */
        private void cleanIfTerminated() {
            if (index == args.length) {
                varArgsMap.remove(vaListAddr);
            } else if (index > args.length) {
                throw new IllegalStateException();
            }
        }

        public long nextLong() {
            Object arg = nextArg();
            long l = ((Number) arg).longValue();
            cleanIfTerminated();
            return l;
        }

        public double nextDouble() {
            Object arg = nextArg();
            double d = ((Number) arg).doubleValue();
            cleanIfTerminated();
            return d;
        }

        public Object[] getAllArgs() {
            index = args.length;
            cleanIfTerminated();
            return args;
        }

        public long getArgDataAddr() {
            return varArgsBufferAddress;
        }

        public void reset(Object[] args) {
            this.args = args;
            this.index = 0;
        }

    }

    public long mir_get_string_ptr(String s) {
        if (stringMap.containsKey(s)) {
            return stringMap.get(s);
        }
        byte[] bytes = s.getBytes();
        int addr = (int) malloc(bytes.length + 1); // Add one byte to add end string char
        writeCStringInMemoryFromJavaString(addr, bytes);
        stringMap.put(s, addr);
        return addr;
    }

    public void writeCStringInMemoryFromJavaString(long longAddr, byte[] javaStringBytes) {
        int size = javaStringBytes.length;
        int addr = (int) longAddr;
        for (int i = 0; i < size; i++) {
            mir_write_byte(addr + i, javaStringBytes[i]);
        }
        mir_write_byte(addr + size, '\0');
    }

    public String getStringFromMemory(long addr) {
        // TODO Try to get String from the string map
        int endCharIndex = 0;
        while (true) {
            char c = (char) memory[(int) addr + endCharIndex];
            if (c == '\0') {
                break;
            }
            endCharIndex++;
        }
        byte[] bytes = new byte[endCharIndex];
        for (int i = 0; i < endCharIndex; i++) {
            bytes[i] = memory[(int) addr + i];
        }
        String s = new String(bytes);
        return s;
    }
    
    public static Method getDeclaredMethodRecursive(Class current, String name) {
        // System.out.println("Searching method '" + name + "' in class " + clazz.getName());
        while (current != null) {
            Method method = null;
            Method[] methods = current.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                method = methods[i];
                // System.out.println("Method: " + method.getName());
                if (method.getName().equals(name)) {
                    // System.out.println("Found method '" + name + "' in class " + current);
                    // method.setAccessible(true);
                    return method;
                }

            }
            current = current.getSuperclass();

        }
        return null;
    }

    public long mir_get_function_ptr(String functionName) {
        int functionAddress = 0;
        // Check if we have already registered the given function
        MethodHandle methodHandle = functionMap.getMethodHandleByName(functionName);
        // If unknown, link then register the function
        if (methodHandle == null) {
            Method method = getDeclaredMethodRecursive(getClass(), functionName);
            if (method == null) {
                throw new RuntimeException("Function '" + functionName + "' was not found.");
            }
            if (nextfunctionPointer > functionSpaceStartAddress + functionSpaceSize) {
                throw new RuntimeException("Can't allocate more function pointer");
            }
            functionAddress = nextfunctionPointer;
            // Allow reflective access to private methods
            method.setAccessible(true);
            methodHandle = new MethodHandle(functionAddress, method);
            functionMap.put(functionName, methodHandle);
            nextfunctionPointer++;
        }
        functionAddress = methodHandle.getAddress();
        return functionAddress;
    }

    /* Call-through wrappers preserving floating return types */
    private Object invoke(long functionAddr, Object... args) {
        if (functionAddr < functionSpaceStartAddress || functionAddr > functionSpaceStartAddress + functionSpaceSize)
            throw new RuntimeException("Bad function address: " + functionAddr);
        MethodHandle methodHandle = functionMap.getMethodByAddress((int) functionAddr);
        if (methodHandle == null)
            throw new RuntimeException("Function at addr=" + functionAddr + " is not mapped.");
        try {
            Method m = methodHandle.getMethod();
            return m.invoke(this, args);
        } catch (Exception e) {
            throw new RuntimeException("Error while calling function '" + methodHandle.getMethod().getName() + "' (addr=" + functionAddr + ")", e);
        }
    }

    public void mir_call_function_ret_void(long addr, Object... args) {
        invoke(addr, args);
    }

    public long mir_call_function_ret_long(long addr, Object... args) {
        return ((Number) invoke(addr, args)).longValue();
    }

    public double mir_call_function_ret_double(long addr, Object... args) {
        return ((Number) invoke(addr, args)).doubleValue();
    }

    public float mir_call_function_ret_float(long addr, Object... args) {
        return ((Number) invoke(addr, args)).floatValue();
    }

    private static void logWarning(String message) {
        if (LOG_WARNING) {
            System.out.println("[WARNING] " + message);
        }
    }
    
    
    /**
     * Constructs an array C argv = {progName, args..., NULL} in MIR memory. 
     * Returns the address (char**). Expected argc = args.length + 1.
     */
    public long makeArgv(String progName, String[] args) {
        if (args == null) args = new String[0];
        int argc = args.length + 1; // +1 for argv[0] = progName
        long argvAddr = malloc((argc + 1L) * PTR_SIZE); // +1 fo the final NULL

        // argv[0] = progName
        long p0 = mir_get_string_ptr(progName != null ? progName : "program");
        mir_write_long(argvAddr + 0L * PTR_SIZE, p0);

        // argv[1..argc-1]
        for (int i = 0; i < args.length; i++) {
            long pi = mir_get_string_ptr(args[i] != null ? args[i] : "");
            mir_write_long(argvAddr + (long) (i + 1) * PTR_SIZE, pi);
        }

        // argv[argc] = NULL
        mir_write_long(argvAddr + (long) argc * PTR_SIZE, 0L);
        return argvAddr;
    }
    
    /* Write: fd=1 -> stdout, fd=2 -> stderr. Return number of written bytes or -errno */
    public long mir_sysio_write(int fd, long bufferAddr, long count) {
        int len = (int) count;
        if (len < 0) return -1; // EINVAL simplified

        byte[] buf = new byte[len];
        System.arraycopy(memory, (int) bufferAddr, buf, 0, len);

        try {
            String s = new String(buf); // Ok for text (printf/fputs)
            if (fd == FD_STDOUT) {
                System.out.print(s);
            } else if (fd == FD_STDERR) {
                System.err.print(s);
            } else {
                // No real file yet: simulate ENOSYS
                return -38; // -ENOSYS
            }
            return count;
        } catch (Exception e) {
            return -5; // -EIO
        }
    }
    
    /* clock_gettime backend: writes struct timespec { time_t sec; long nsec; } */
    public int mir_sysclock_gettime(int clk, long tsAddr) {
        // CLOCK_REALTIME approximated via currentTimeMillis. TODO: MONOTONIC via nanoTime
        long millis = System.currentTimeMillis();
        long sec = millis / 1000L;
        long nsec = (millis % 1000L) * 1000000L;

        // struct timespec is 2 x 8 bytes on our target
        mir_write_long(tsAddr, sec);
        mir_write_long(tsAddr + 8, nsec);
        return 0;
    }

    public long memcpy(long destAddr, long srcAddr, long size) {
        System.arraycopy(memory, (int) srcAddr, memory, (int) destAddr, (int) size);
        return destAddr;
    }

    public long memset(long addr, int value, long count) {
        int intCount = (int) count;
        byte v = (byte) (value & 0xFF);
        int intAddr = (int) addr;
        for (int i = 0; i < intCount; i++) {
            memory[intAddr + i] = v;
        }
        return addr;
    }

//	public int printf(String string, Object... args) {
//		System.out.printf(string, args);
//		return 1;
//	}

    public long strlen(long longAddr) {
        int addr = (int) longAddr;
        int endCharIndex = 0;
        while (true) {
            char c = (char) memory[addr + endCharIndex];
            if (c == '\0') {
                break;
            }
            endCharIndex++;
        }
        return endCharIndex;
    }

    public long strcpy(long destAddr, long srcAddr) {
        int dAddr = (int) destAddr;
        int sAddr = (int) srcAddr;
        int i = 0;
        byte v;
        do {
            v = memory[sAddr + i];
            memory[dAddr + i] = v;
            i++;
        } while (v != '\0');
        return dAddr;
    }

//    public int printf(long addr, Object... args) {
//        String s = getStringFromMemory(addr);
//        String convertedFormat = convertPrintfFormat(s);
//        System.out.printf(convertedFormat, args);
//        return 1;
//    }

    public long fprintf(long id, Object... args) {
        logWarning("fprintf: not implemented yet");
        // TODO Auto-generated method stub
        return 0;
    }

    public long fread(long i_88, long l, long m, long u0_rgsFile) {
        logWarning("fread: not implemented yet");
        // TODO Auto-generated method stub
        return 0;
    }

    public int fclose(long u0_rgsFile) {
        logWarning("fclose: not implemented yet");
        // TODO Auto-generated method stub
        return 0;
    }

    public long __isoc99_sscanf(long fp, long mir_get_string_ptr, long u_13, long u_14, long u_15) {
        logWarning("__isoc99_sscanf: not implemented yet");
        // TODO Auto-generated method stub
        return 0;
    }

    public int feof(long u0_rgsFile) {
        logWarning("feof: not implemented yet");
        // TODO Auto-generated method stub
        return 0;
    }

    public long fgets(long fp, int i, long u0_rgsFile) {
        logWarning("fgets: not implemented yet");
        // TODO Auto-generated method stub
        return 0;
    }

    public long fopen(long u0_fileName, long mir_get_string_ptr) {
        logWarning("fopen: not implemented yet");
        // TODO Auto-generated method stub
        return 0;
    }

    private String convertPrintfFormat(String format) {
        format = format.replaceAll("%i", "%d");
        return format;
    }

    public int sprintf(long bufferAddr, long stringAddr, Object... args) {
        String inputString = getStringFromMemory(stringAddr);
        try {
            String convertedFormat = convertPrintfFormat(inputString);
            String outputString = String.format(convertedFormat, args);
            writeCStringInMemoryFromJavaString(bufferAddr, outputString.getBytes());
            return outputString.length();
        } catch (IllegalFormatException e) {
            e.printStackTrace();
            // TODO Write the error in errno
            return EOF;
        }
    }

    public int vsprintf(long bufferAddr, long stringAddr, long va_listAddress) {
        // System.out.println("[WARNING] vsprintf: not implemented yet");
        String inputString = getStringFromMemory(stringAddr);
        try {
            String convertedFormat = convertPrintfFormat(inputString);
            VarArgs varArgs = mir_va_get_wrapper(va_listAddress);
            String outputString = String.format(convertedFormat, varArgs.getAllArgs());
            writeCStringInMemoryFromJavaString(bufferAddr, outputString.getBytes());
            return outputString.length();
        } catch (IllegalFormatException e) {
            e.printStackTrace();
            // TODO Write the error in errno
            return EOF;
        }
    }

    public long _setjmp(long jumpBufferAddress) {
        logWarning("_setjmp: not implemented yet");
        // TODO Auto-generated method stub
        return 0;
    }

    public long setjmp(long jumpBufferAddress) {
        return _setjmp(jumpBufferAddress);
    }

    public void _longjmp(long jumpBufferAddress, int val) {
        logWarning("_longjmp: not implemented yet");
        // TODO Auto-generated method stub
    }

    public void longjmp(long jumpBufferAddress, int val) {
        _longjmp(jumpBufferAddress, val);
    }

    public void abort() {
        System.out.println("aborting...");
        System.exit(1);
    }

    public void exit(int v) {
        System.exit(v);
    }

    public float ceilf(float value) {
        float f = (float) Math.ceil(value);
        return f;
    }

    public float roundf(float value) {
        float f = (float) Math.round(value);
        return f;
    }

//	public long strtol(long stringAddr, long endAddr, int base) {
//		String s = getStringFromMemory(stringAddr);
//		long value = Long.parseLong(s, base);
//		
//	}

//	static int[] memory = new int[1000000];
//	
//	public static int growMemory(int minSize) {
//		int newSize = memory.length * 2;
//		while (newSize < minSize) {
//			newSize = memory.length * 2;
//		}
//		int[] newMemory = new int[newSize];
//		System.arraycopy(memory, 0, newMemory, 0, memory.length);
//		memory = newMemory;
//		return newSize;
//	}
//	
//	public static int allocateOnStack(int sizeInBytes) {
//		int intSize = sizeInBytes >> 2 + 1;
//		int oldStackPosition = stackPosition;
//		if ((oldStackPosition + intSize) > memory.length) {
//			growMemory(oldStackPosition + intSize);
//		}
//		stackPosition += intSize;
//		return oldStackPosition;
//	}
//	
//	public static byte readbyte(int addr) {
//		int i = memory[addr >> 2];
//		byte b = (byte) ((i >> (addr % 4)) & 0xFF);
//		return b;
//	}
//	
//	public static byte writebyte(int addr) {
//		int i = memory[addr >> 2];
//		byte b = (byte) ((i >> (addr % 4)) & 0xFF);
//		return b;
//	}

}

class FunctionMap {

    private Map<Object, MethodHandle> map = new HashMap<Object, MethodHandle>();

    public void put(String functionName, MethodHandle methodHandle) {
        map.put(functionName, methodHandle);
        map.put(methodHandle.getAddress(), methodHandle);
    }

    public MethodHandle getMethodHandleByName(String functionName) {
        return map.get(functionName);
    }

    public MethodHandle getMethodByAddress(int address) {
        return map.get(address);
    }

}

class MethodHandle {

    private int address;
    private Method method;

    public MethodHandle(int address, Method method) {
        this.address = address;
        this.method = method;
    }

    /**
     * @return the address
     */
    public int getAddress() {
        return address;
    }

    /**
     * @return the method
     */
    public Method getMethod() {
        return method;
    }

}

class MemoryBlock {

    int startAddress;
    int endAddress;
    int size;
    boolean free;

    public MemoryBlock(int startAddress, int size, boolean free) {
        this.startAddress = startAddress;
        this.size = size;
        this.free = free;
        endAddress = startAddress + size - 1;
    }

    /**
     * @return the free
     */
    public boolean isFree() {
        return free;
    }

    /**
     * @param free the free to set
     */
    public void setFree(boolean free) {
        this.free = free;
    }

    /**
     * @return the startAddress
     */
    public int getStartAddress() {
        return startAddress;
    }

    /**
     * @return the endAddress
     */
    public int getEndAddress() {
        return endAddress;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "MemoryBlock [startAddress=" + startAddress + ", endAddress=" + endAddress + ", size=" + size + ", free=" + free + "]";
    }

}
