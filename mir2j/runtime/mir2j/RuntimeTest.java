package mir2j;

public class RuntimeTest {
	
	Runtime runtime = new Runtime();
	
	public void check(String testName, boolean success) {
		if (success) {
			System.out.println(testName + ": OK");
		} else {
			System.out.println(testName + ": FAIL");
		}
	}
	
	public void testWriteRead() {
		long addr = 10;
		runtime.mir_write_int(addr, 7);
		int i =  runtime.mir_read_int(addr);
		check("Write/Read integer", i == 7);
		//System.out.println("i=" + Integer.toHexString(i));
		//System.out.println("v=" + Long.toHexString(v));
		runtime.mir_write_int(addr + 4, 15);
		i =  runtime.mir_read_int(addr + 4);
		//System.out.println("i=" + Integer.toHexString(i));
		long v = runtime.mir_read_long(addr);
		check("Write/Read long", v == 0x70000000FL);
		runtime.mir_write_long(addr + 8, 0x876543210L);
		v = runtime.mir_read_long(addr + 8);
		check("Write/Read long #2", v == 0x876543210L);
		
		//System.out.println("i=" + Long.toHexString(v));
		//System.out.println("v=" + v);
		//int a = (int) ((v >> 32));
		//int b = (int) (v & 0xFFFFFFFFL);
		//System.out.println("a=" + a + " b=" + b);
	}
	
	public void testAll() {
		testWriteRead();
	}

	public static void main(String[] args) {
		RuntimeTest test = new RuntimeTest();
		test.testAll();

	}

}
