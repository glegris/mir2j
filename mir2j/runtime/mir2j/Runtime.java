package mir2j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Runtime {

	private static byte[] memory = new byte[5000000];

	private static int stackPosition = 8; // Do not start at 0 to avoid weird bugs caused by comparisons with 0
	private static int savedStackPosition;
	private static int maxStackSize = 1000000;
	private static TreeMap<Integer, MemoryBlock> blocks = new TreeMap<>();
	private static HashMap<String, Integer> stringMap = new HashMap<>();

	public static int growMemory(int minSize) {
		int newSize = memory.length * 2;
		while (newSize < minSize) {
			newSize = memory.length * 2;
		}
		byte[] newMemory = new byte[newSize];
		System.arraycopy(memory, 0, newMemory, 0, memory.length);
		memory = newMemory;
		return newSize;
	}

	public static void mir_saveStack() {
		savedStackPosition = stackPosition;
	}

	public static void mir_restoreStack() {
		stackPosition = savedStackPosition;
	}

	public static long mir_allocate(int sizeInBytes) {
		int oldStackPosition = stackPosition;
		if ((oldStackPosition + sizeInBytes) > maxStackSize) {
			throw new RuntimeException("Stack overflow");
		}
		stackPosition += sizeInBytes;
		return oldStackPosition;
	}

//	public static long mir_allocate(int sizeInBytes) {
//		int oldStackPosition = stackPosition;
//		if ((oldStackPosition + sizeInBytes) > memory.length) {
//			growMemory(oldStackPosition + sizeInBytes);
//		}
//		stackPosition += sizeInBytes;
//		return oldStackPosition;
//	}

	private static MemoryBlock addBlock(int address, int size, boolean free) {
		if ((address + size) > memory.length) {
			// TODO Try to merge free blocks before growing memory
			growMemory(address + size);
		}
		int startAddress = maxStackSize;
		MemoryBlock block = new MemoryBlock(address, size, free);
		blocks.put(startAddress, block);
		//System.out.println(block);
		return block;
	}

	public static long malloc(int size) {
		// Try to find a free block
		if (!blocks.isEmpty()) {
			Iterator<MemoryBlock> i = blocks.values().iterator();
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
		if (blocks.isEmpty()) {
			newAddress = maxStackSize;
		} else {
			MemoryBlock lastBlock = blocks.lastEntry().getValue();
			newAddress = lastBlock.getStartAddress() + lastBlock.getSize();
		}
		addBlock(newAddress, size, false);
		return newAddress;
	}

	public static byte mir_read_byte(long addr) {
		long b = memory[(int) addr];
		//System.out.println("readbyte(" + addr + "): " + b);
		return (byte) b;
	}

	public static void mir_write_byte(long addr, long b) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		memory[(int) addr] = (byte) (b & 0xFF);
	}

	public static void mir_write_int(long longAddr, long v) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		int addr = (int) longAddr;
		int i = (int) v;
		memory[addr] = (byte) ((i >> 24) & 0xFF);
		memory[addr + 1] = (byte) ((i >> 16) & 0xFF);
		memory[addr + 2] = (byte) ((i >> 8) & 0xFF);
		memory[addr + 3] = (byte) (i & 0xFF);
	}

	public static int mir_read_int(long longAddr) {
		int addr = (int) longAddr;
		int b1 = memory[addr];
		int b2 = memory[addr + 1];
		int b3 = memory[addr + 2];
		int b4 = memory[addr + 3];
		int i = ((b1 & 0xFF) << 24) | ((b2 & 0xFF) << 16) | ((b3 & 0xFF) << 8) | (b4 & 0xFF);
		//System.out.println("readbyte(" + addr + "): " + b);
		return i;
	}

	public static void mir_write_long(long longAddr, long l) {
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

	public static long mir_read_long(long longAddr) {
		int addr = (int) longAddr;
		long b1 = ((long) (memory[addr] & 0xFF)) << 56 ;
		long b2 = ((long) (memory[addr + 1] & 0xFF)) << 48 ;
		long b3 = ((long) (memory[addr + 2] & 0xFF)) << 40 ;
		long b4 = ((long) (memory[addr + 3] & 0xFF)) << 32 ;
		long b5 = ((long) (memory[addr + 4] & 0xFF)) << 24 ;
		long b6 = ((long) (memory[addr + 5] & 0xFF)) << 16 ;
		long b7 = ((long) (memory[addr + 6] & 0xFF)) << 8 ;
		long b8 = ((long) (memory[addr + 7] & 0xFF));
		long l = b1 | b2 | b3 | b4 | b5 | b6 | b7 | b8;
		//System.out.println("readbyte(" + addr + "): " + b);
		return l;
	}

	public static long mir_allocate_byte(long v) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		long addr = mir_allocate(1);
		mir_write_byte(addr, v);
		return addr;
	}

	public static long mir_allocate_int(long v) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		long addr = mir_allocate(4);
		mir_write_int(addr, v);
		return addr;
	}

	public static long mir_allocate_long(long v) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		long addr = mir_allocate(8);
		mir_write_long(addr, v);
		return addr;
	}

	public static long mir_get_string_ptr(String s) {
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

	private static String getStringFromMemory(long addr) {
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

	public static long memcpy(long destAddr, long srcAddr, long size) {
		System.arraycopy(memory, (int) srcAddr, memory, (int) destAddr, (int) size);
		return destAddr;
	}

	public static int printf(String string, Object... args) {
		System.out.printf(string, args);
		return 1;
	}

	public static int printf(long addr, Object... args) {
		String s = getStringFromMemory(addr);
		System.out.printf(s, args);
		return 1;
	}

	public static void abort() {
		System.out.println("aborting...");
		System.exit(1);
	}

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
