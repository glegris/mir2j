package mir2j;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Runtime {
	
	private static final int VA_ARG_BUFFER_SIZE = 8;

	private byte[] memory = new byte[5000000];

	private int stackPosition = 8; // Do not start at 0 to avoid weird bugs caused by comparisons with 0
	private int maxStackSize = 1000000;
	private int varArgsBufferAddress = maxStackSize;
	private int functionSpaceStartAddress = varArgsBufferAddress + VA_ARG_BUFFER_SIZE;
	private int functionSpaceSize = 1000;
	private int nextfunctionPointer = functionSpaceStartAddress;
	private int heapStartAddress = functionSpaceStartAddress + functionSpaceSize;
	private TreeMap<Integer, MemoryBlock> memoryBlockMap = new TreeMap<>();
	private TreeMap<Integer, VarArgs> varArgsMap = new TreeMap<>();
	private HashMap<String, Integer> stringMap = new HashMap<>();
	private FunctionMap functionMap = new FunctionMap();

	public static final int stdin = 0;
	public static int stdout = 1;
	public static int stderr = 2;
	public static int EOF = -1;

	public int growMemory(int minSize) {
		int newSize = memory.length * 2;
		while (newSize < minSize) {
			newSize = memory.length * 2;
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

//	public long mir_allocate(int sizeInBytes) {
//		int oldStackPosition = stackPosition;
//		if ((oldStackPosition + sizeInBytes) > memory.length) {
//			growMemory(oldStackPosition + sizeInBytes);
//		}
//		stackPosition += sizeInBytes;
//		return oldStackPosition;
//	}

	private MemoryBlock addBlock(int address, int size, boolean free) {
		if ((address + size) > memory.length) {
			// TODO Try to merge free blocks before growing memory
			growMemory(address + size);
		}
		MemoryBlock block = new MemoryBlock(address, size, free);
		memoryBlockMap.put(address, block);
		//System.out.println(block);
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
		//System.out.println("readbyte(" + addr + "): " + b);
		return (byte) b;
	}

	public void mir_write_byte(long addr, long b) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		memory[(int) addr] = (byte) (b & 0xFF);
	}

	public int mir_read_ubyte(long addr) {
		int v = ((int) memory[(int) addr]) & 0xFF;
		return v;
	}

	public void mir_write_ubyte(long addr, long b) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		memory[(int) addr] = (byte) (b & 0xFF);
	}

	public short mir_read_short(long longAddr) {
		int addr = (int) longAddr;
		int b1 = memory[addr];
		int b2 = memory[addr + 1];
		int i = ((b1 & 0xFF) << 8) | (b2 & 0xFF);
		return (short) i;
	}

	public void mir_write_short(long longAddr, long v) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		int addr = (int) longAddr;
		memory[addr] = (byte) ((v >> 8) & 0xFF);
		memory[addr + 1] = (byte) (v & 0xFF);
	}

	public void mir_write_int(long longAddr, long v) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		int addr = (int) longAddr;
		int i = (int) v;
		memory[addr] = (byte) ((i >> 24) & 0xFF);
		memory[addr + 1] = (byte) ((i >> 16) & 0xFF);
		memory[addr + 2] = (byte) ((i >> 8) & 0xFF);
		memory[addr + 3] = (byte) (i & 0xFF);
	}

	public int mir_read_int(long longAddr) {
		int addr = (int) longAddr;
		int b1 = memory[addr];
		int b2 = memory[addr + 1];
		int b3 = memory[addr + 2];
		int b4 = memory[addr + 3];
		int i = ((b1 & 0xFF) << 24) | ((b2 & 0xFF) << 16) | ((b3 & 0xFF) << 8) | (b4 & 0xFF);
		//System.out.println("readbyte(" + addr + "): " + b);
		return i;
	}

	public void mir_write_uint(long longAddr, long v) {
		mir_write_int(longAddr, v & 0xFFFFFFFFL);
	}

	public long mir_read_uint(long longAddr) {
		long v = ((long) mir_read_int(longAddr)) & 0xFFFFFFFFL;
		return v;
	}

	public void mir_write_long(long longAddr, long l) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		int addr = (int) longAddr;
		memory[addr] = (byte) ((l >> 56) & 0xFF);
		memory[addr + 1] = (byte) ((l >> 48) & 0xFF);
		memory[addr + 2] = (byte) ((l >> 40) & 0xFF);
		memory[addr + 3] = (byte) ((l >> 32) & 0xFF);
		memory[addr + 4] = (byte) ((l >> 24) & 0xFF);
		memory[addr + 5] = (byte) ((l >> 16) & 0xFF);
		memory[addr + 6] = (byte) ((l >> 8) & 0xFF);
		memory[addr + 7] = (byte) (l & 0xFF);
	}

	public long mir_read_long(long longAddr) {
		int addr = (int) longAddr;
		long b1 = ((long) (memory[addr] & 0xFF)) << 56;
		long b2 = ((long) (memory[addr + 1] & 0xFF)) << 48;
		long b3 = ((long) (memory[addr + 2] & 0xFF)) << 40;
		long b4 = ((long) (memory[addr + 3] & 0xFF)) << 32;
		long b5 = ((long) (memory[addr + 4] & 0xFF)) << 24;
		long b6 = ((long) (memory[addr + 5] & 0xFF)) << 16;
		long b7 = ((long) (memory[addr + 6] & 0xFF)) << 8;
		long b8 = ((long) (memory[addr + 7] & 0xFF));
		long l = b1 | b2 | b3 | b4 | b5 | b6 | b7 | b8;
		//System.out.println("readbyte(" + addr + "): " + b);
		return l;
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

	public long mir_set_data_bytes(byte[] s) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		long addr = mir_allocate(s.length);
		for (int i = 0; i < s.length; i++) {
			mir_write_byte(addr + i, s[i]);
		}
		return addr;
	}

	public long mir_set_data_ubytes(short[] s) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		long addr = mir_allocate(s.length);
		for (int i = 0; i < s.length; i++) {
			mir_write_ubyte(addr + i, s[i]);
		}
		return addr;
	}

	public long mir_set_data_shorts(short[] s) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		long addr = mir_allocate(s.length * 2);
		for (int i = 0; i < s.length; i++) {
			mir_write_short(addr + i * 2, s[i]);
		}
		return addr;
	}

	public long mir_set_data_longs(long[] s) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		long addr = mir_allocate(s.length * 8);
		for (int i = 0; i < s.length; i++) {
			mir_write_long(addr + i * 8, s[i]);
		}
		return addr;
	}

	public long mir_set_data_byte(long v) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		long addr = mir_allocate(1);
		mir_write_byte(addr, v);
		return addr;
	}

	public long mir_set_data_int(long v) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		long addr = mir_allocate(4);
		mir_write_int(addr, v);
		return addr;
	}

	public long mir_set_data_uint(long v) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		long addr = mir_allocate(4);
		mir_write_int(addr, v);
		return addr;
	}

	public long mir_set_data_long(long v) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
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
	
	/* FIXME: va_end is not emitted by c2mir ! 
	 * TODO: Temporary fix to call mir_va_end when the last arg is requested 
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

	public long mir_get_function_ptr(String functionName) {
		int functionAddress = 0;
		// Check if we have already registered the given function
		MethodHandle methodHandle = functionMap.getMethodHandleByName(functionName);
		// If unknown, link then register the function
		if (methodHandle == null) {
			Method[] methods = getClass().getDeclaredMethods();
			int targetMethodIndex = -1;
			for (int i = 0; i < methods.length; i++) {
				//System.out.println("method name: " + methods[i].getName());
				if (methods[i].getName().equals(functionName)) {
					targetMethodIndex = i;
				}
			}
			if (targetMethodIndex == -1) {
				throw new RuntimeException("Function '" + functionName + "' was not found.");
			}
			if (nextfunctionPointer > functionSpaceStartAddress + functionSpaceSize) {
				throw new RuntimeException("Can't allocate more function pointer");
			}
			functionAddress = nextfunctionPointer;
			Method method = methods[targetMethodIndex];
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

	public int printf(long addr, Object... args) {
		String s = getStringFromMemory(addr);
		System.out.printf(s, args);
		return 1;
	}

	public long fprintf(long id, Object... args) {
		System.out.println("[WARNING] fprintf: not implemented yet");
		// TODO Auto-generated method stub
		return 0;
	}

	public long fread(long i_88, long l, long m, long u0_rgsFile) {
		System.out.println("[WARNING] fread: not implemented yet");
		// TODO Auto-generated method stub
		return 0;
	}

	public long fclose(long u0_rgsFile) {
		System.out.println("[WARNING] fclose: not implemented yet");
		// TODO Auto-generated method stub
		return 0;
	}

	public long __isoc99_sscanf(long fp, long mir_get_string_ptr, long u_13, long u_14, long u_15) {
		System.out.println("[WARNING] __isoc99_sscanf: not implemented yet");
		// TODO Auto-generated method stub
		return 0;
	}

	public long feof(long u0_rgsFile) {
		System.out.println("[WARNING] feof: not implemented yet");
		// TODO Auto-generated method stub
		return 0;
	}

	public long fgets(long fp, int i, long u0_rgsFile) {
		System.out.println("[WARNING] fgets: not implemented yet");
		// TODO Auto-generated method stub
		return 0;
	}

	public long fopen(long u0_fileName, long mir_get_string_ptr) {
		System.out.println("[WARNING] fopen: not implemented yet");
		// TODO Auto-generated method stub
		return 0;
	}

	private String convertPrintfFormat(String format) {
		format = format.replaceAll("%i", "%d");
		return format;
	}

	public long sprintf(long bufferAddr, long stringAddr, Object... args) {
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

	public long vsprintf(long bufferAddr, long stringAddr, long va_listAddress) {
		//System.out.println("[WARNING] vsprintf: not implemented yet");
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
		System.out.println("[WARNING] _setjmp: not implemented yet");
		// TODO Auto-generated method stub
		return 0;
	}

	public long setjmp(long jumpBufferAddress) {
		return _setjmp(jumpBufferAddress);
	}

	public void _longjmp(long jumpBufferAddress, int val) {
		System.out.println("[WARNING] _longjmp: not implemented yet");
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
