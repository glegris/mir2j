package mir2j;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Runtime {

	private byte[] memory = new byte[5000000];

	private int stackPosition = 8; // Do not start at 0 to avoid weird bugs caused by comparisons with 0
	private int savedStackPosition;
	private int maxStackSize = 1000000;
	private int functionSpaceStartAddress = maxStackSize;
	private int functionSpaceSize = 1000;
	private int nextfunctionPointer = functionSpaceStartAddress;
	private int heapStartAddress = functionSpaceStartAddress + functionSpaceSize;
	private TreeMap<Integer, MemoryBlock> memoryBlockMap = new TreeMap<>();
	private HashMap<String, Integer> stringMap = new HashMap<>();
	private FunctionMap functionMap = new FunctionMap();

	public static int stdin = 0;
	public static int stdout = 1;
	public static int stderr = 2;

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

	public void mir_saveStack() {
		savedStackPosition = stackPosition;
	}

	public void mir_restoreStack() {
		stackPosition = savedStackPosition;
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
			mir_write_byte(addr + i, s[i] & 0xFF);
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

	public long mir_allocate_double(double v) {
		long addr = mir_allocate(8);
		mir_write_double(addr, v);
		return addr;
	}

	public long mir_get_string_ptr(String s) {
		if (stringMap.containsKey(s)) {
			return stringMap.get(s);
		}
		byte[] bytes = s.getBytes();
		int size = bytes.length;
		int addr = (int) malloc(size + 1); // Add one byte to add end string char
		for (int i = 0; i < size; i++) {
			mir_write_byte(addr + i, bytes[i]);
		}
		mir_write_byte(addr + size, '\0');
		stringMap.put(s, addr);
		return addr;
	}

	private String getStringFromMemory(long addr) {
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
			methodHandle = new MethodHandle(functionAddress, methods[targetMethodIndex]);
			functionMap.put(functionName, methodHandle);
			nextfunctionPointer++;
		}
		functionAddress = methodHandle.getAddress();
		return functionAddress;
	}

	public long mir_call_function(long functionAddr, Object... args) {
		if ((functionAddr < functionSpaceStartAddress) || (functionAddr > functionSpaceStartAddress + functionSpaceSize)) {
			throw new RuntimeException("Bad function address: " + functionAddr);
		}
		MethodHandle methodHandle = functionMap.getMethodByAddress((int) functionAddr);
		if (methodHandle == null) {
			throw new RuntimeException("Function at addr=" + functionAddr + " is not mapped.");
		}
		try {
			Object result = methodHandle.getMethod().invoke(this, args);
			//System.out.println("result=" + result);
			return ((Number) result).longValue();
		} catch (Exception e) {
			throw new RuntimeException("Error while calling function '" + methodHandle.getMethod().getName() + "' (addr=" + functionAddr + ")", e);
		}
	}

	public long memcpy(long destAddr, long srcAddr, long size) {
		System.arraycopy(memory, (int) srcAddr, memory, (int) destAddr, (int) size);
		return destAddr;
	}

//	public int printf(String string, Object... args) {
//		System.out.printf(string, args);
//		return 1;
//	}

	public int printf(long addr, Object... args) {
		String s = getStringFromMemory(addr);
		System.out.printf(s, args);
		return 1;
	}

	public void abort() {
		System.out.println("aborting...");
		System.exit(1);
	}

	public void exit(int v) {
		System.exit(v);
	}

	public long fprintf(long mir_read_long, Object... args) {
		// TODO Auto-generated method stub
		return 0;
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
