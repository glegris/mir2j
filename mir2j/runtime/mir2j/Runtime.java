package mir2j;

public class Runtime {

	private static byte[] memory = new byte[1000000];

	private static int stackPosition = 1000; // Do not start at 0 to avoid weird bugs caused by comparisons with 0
	private static int savedStackPosition;

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
		if ((oldStackPosition + sizeInBytes) > memory.length) {
			growMemory(oldStackPosition + sizeInBytes);
		}
		stackPosition += sizeInBytes;
		return oldStackPosition;
	}

	public static long mir_read_byte(long addr) {
		long b = memory[(int) addr];
		//System.out.println("readbyte(" + addr + "): " + b);
		return b;
	}

	public static void mir_write_byte(long addr, long b) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		memory[(int) addr] = (byte) b;
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
	
	public static long mir_read_int(long longAddr) {
		int addr = (int) longAddr;
		int b1 = memory[addr];
		int b2 = memory[addr + 1];
		int b3 = memory[addr + 2];
		int b4 = memory[addr + 3];
		int i = ((b1 & 0xFF) << 24) | ((b2 & 0xFF) << 16) | ((b3 & 0xFF) << 8) | (b4 & 0xFF);
		//System.out.println("readbyte(" + addr + "): " + b);
		return i;
	}

	public static long mir_allocate_int(long v) {
		//System.out.println("writebyte(" + addr + "," + b + ")");
		long addr = mir_allocate(4);
		mir_write_int(addr, v);
		return addr;
	}

	public static int printf(String string, Object... args) {
		System.out.printf(string, args);
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
