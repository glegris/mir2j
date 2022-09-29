package mir2j;

public class RuntimeTest extends Runtime {

	public static final int SIEVE_SIZE = 819000;
	public static final int SIEVE_EXPECTED = 65333;
	public static final int SIEVE_ITERATIONS = 1000;
//	public static final int SieveSize = 8190;
//	public static final int Expected = 1027;

	public void check(String testName, boolean success) {
		if (success) {
			System.out.println(testName + ": OK");
		} else {
			System.out.println(testName + ": FAIL");
		}
	}

	public void testWriteRead() {
		long addr = 10;
		mir_write_int(addr, 7);
		int i = mir_read_int(addr);
		check("Write/Read integer", i == 7);
		//System.out.println("i=" + Integer.toHexString(i));
		//System.out.println("v=" + Long.toHexString(v));
		mir_write_int(addr + 4, 15);
		i = mir_read_int(addr + 4);
		//System.out.println("i=" + Integer.toHexString(i));
		long v = mir_read_long(addr);
		check("Write/Read long", v == 0x70000000FL);
		mir_write_long(addr + 8, 0x876543210L);
		v = mir_read_long(addr + 8);
		check("Write/Read long #2", v == 0x876543210L);
		addr = mir_allocate_longs(new long[] { 0 , 12, 0, 46 } );
		v = mir_read_long(addr + 8);
		check("Write/Read long #2", v == 12);
		v = mir_read_long(addr + 24);
		check("Write/Read long #2", v == 46);

		//System.out.println("i=" + Long.toHexString(v));
		//System.out.println("v=" + v);
		//int a = (int) ((v >> 32));
		//int b = (int) (v & 0xFFFFFFFFL);
		//System.out.println("a=" + a + " b=" + b);
	}

	public int sieveWithStringLabels(int _i0_n) {
		mir_saveStack();
		long i0_n = _i0_n;
		long fp = 0;
		long I0_iter = 0;
		long I_0 = 0;
		long i_1 = 0;
		long I0_count = 0;
		long I0_i = 0;
		long i_2 = 0;
		long I_3 = 0;
		long I_4 = 0;
		long i_5 = 0;
		long i_6 = 0;
		long I0_prime = 0;
		long I_7 = 0;
		long I0_k = 0;
		long I_8 = 0;
		long i_9 = 0;
		long I_10 = 0;
		long I_11 = 0;
		long I_12 = 0;
		long i_13 = 0;
		long I_14 = 0;
		long I_15 = 0;
		long i_16 = 0;
		long I_17 = 0;
		long I_18 = 0;
		long i_19 = 0;
		String label = "startLabel";
		while (true) {
			switch (label) {
			case "startLabel":
				fp = mir_allocate(SIEVE_SIZE + 8);
				I0_iter = 0;
				I_0 = (long) (int) i0_n;
				if ((long) I0_iter >= (long) I_0) {
					label = "l17";
					break;
				}
			case "l18":
				I0_count = 0;
				I0_i = 0;
				if ((long) I0_i >= (long) SIEVE_SIZE) {
					label = "l19";
					break;
				}
			case "l20":
				I_3 = (long) (byte) 1;
				mir_write_byte(fp + I0_i, I_3);
			case "l21":
				I_4 = I0_i;
				I_4 = (long) I_4 + (long) 1;
				I0_i = I_4;
				if ((long) I0_i < (long) SIEVE_SIZE) {
					label = "l20";
					break;
				}
			case "l19":
				I0_i = 2;
				if ((long) I0_i >= (long) SIEVE_SIZE) {
					label = "l22";
					break;
				}
			case "l23":
				if (((long) mir_read_byte(fp + I0_i) == 0)) {
					label = "l24";
					break;
				}
			case "l25":
				I_7 = (long) I0_i + (long) 1;
				I0_prime = I_7;
				I_8 = (long) I0_i + (long) I0_prime;
				I0_k = I_8;
				if ((long) I0_k >= (long) SIEVE_SIZE) {
					label = "l26";
					break;
				}
			case "l27":
				I_10 = (long) (byte) 0;
				mir_write_byte(fp + I0_k, I_10);
			case "l28":
				I_11 = I0_k;
				I_11 = (long) I_11 + (long) I0_prime;
				I0_k = I_11;
				if ((long) I0_k < (long) SIEVE_SIZE) {
					label = "l27";
					break;
				}
			case "l26":
				I_14 = I0_count;
				I_14 = (long) I_14 + (long) 1;
				I0_count = I_14;
				label = "l29";
				break;
			case "l24":
			case "l29":
			case "l30":
				I_15 = I0_i;
				I_15 = (long) I_15 + (long) 1;
				I0_i = I_15;
				if ((long) I0_i < (long) SIEVE_SIZE) {
					label = "l23";
					break;
				}
			case "l22":
			case "l31":
				I_17 = I0_iter;
				I_17 = (long) I_17 + (long) 1;
				I0_iter = I_17;
				I_18 = (long) (int) i0_n;
				if ((long) I0_iter < (long) I_18) {
					label = "l18";
					break;
				}
			case "l17":
				mir_restoreStack();
				return (int) I0_count;
			} // End of switch
		} // End of while
	} // End of function sieve

	public int sieveWithIntegerLabels(int _i0_n) {
		mir_saveStack();
		long i0_n = _i0_n;
		long fp = 0;
		long I0_iter = 0;
		long I_0 = 0;
		long i_1 = 0;
		long I0_count = 0;
		long I0_i = 0;
		long i_2 = 0;
		long I_3 = 0;
		long I_4 = 0;
		long i_5 = 0;
		long i_6 = 0;
		long I0_prime = 0;
		long I_7 = 0;
		long I0_k = 0;
		long I_8 = 0;
		long i_9 = 0;
		long I_10 = 0;
		long I_11 = 0;
		long I_12 = 0;
		long i_13 = 0;
		long I_14 = 0;
		long I_15 = 0;
		long i_16 = 0;
		long I_17 = 0;
		long I_18 = 0;
		long i_19 = 0;
		int label = 0;
		while (true) {
			switch (label) {
			case 0:
				fp = mir_allocate(SIEVE_SIZE + 8);
				I0_iter = 0;
				I_0 = (long) (int) i0_n;
				if ((long) I0_iter >= (long) I_0) {
					label = 17;
					break;
				}
			case 18:
				I0_count = 0;
				I0_i = 0;
				if ((long) I0_i >= (long) SIEVE_SIZE) {
					label = 19;
					break;
				}
			case 20:
				I_3 = (long) (byte) 1;
				mir_write_byte(fp + I0_i, I_3);
			case 21:
				I_4 = I0_i;
				I_4 = (long) I_4 + (long) 1;
				I0_i = I_4;
				if ((long) I0_i < (long) SIEVE_SIZE) {
					label = 20;
					break;
				}
			case 19:
				I0_i = 2;
				if ((long) I0_i >= (long) SIEVE_SIZE) {
					label = 22;
					break;
				}
			case 23:
				if (((long) mir_read_byte(fp + I0_i) == 0)) {
					label = 24;
					break;
				}
			case 25:
				I_7 = (long) I0_i + (long) 1;
				I0_prime = I_7;
				I_8 = (long) I0_i + (long) I0_prime;
				I0_k = I_8;
				if ((long) I0_k >= (long) SIEVE_SIZE) {
					label = 26;
					break;
				}
			case 27:
				I_10 = (long) (byte) 0;
				mir_write_byte(fp + I0_k, I_10);
			case 28:
				I_11 = I0_k;
				I_11 = (long) I_11 + (long) I0_prime;
				I0_k = I_11;
				if ((long) I0_k < (long) SIEVE_SIZE) {
					label = 27;
					break;
				}
			case 26:
				I_14 = I0_count;
				I_14 = (long) I_14 + (long) 1;
				I0_count = I_14;
				label = 29;
				break;
			case 24:
			case 29:
			case 30:
				I_15 = I0_i;
				I_15 = (long) I_15 + (long) 1;
				I0_i = I_15;
				if ((long) I0_i < (long) SIEVE_SIZE) {
					label = 23;
					break;
				}
			case 22:
			case 31:
				I_17 = I0_iter;
				I_17 = (long) I_17 + (long) 1;
				I0_iter = I_17;
				I_18 = (long) (int) i0_n;
				if ((long) I0_iter < (long) I_18) {
					label = 18;
					break;
				}
			case 17:
				mir_restoreStack();
				return (int) I0_count;
			} // End of switch
		} // End of while
	} // End of function sieve
	
	public int sieveWithIntegerLabelsWithoutLongCast(int _i0_n) {
		mir_saveStack();
		int i0_n = _i0_n;
		long fp = 0;
		int I0_iter = 0;
		int I_0 = 0;
		int i_1 = 0;
		int I0_count = 0;
		int I0_i = 0;
		int i_2 = 0;
		int I_3 = 0;
		int I_4 = 0;
		int i_5 = 0;
		int i_6 = 0;
		int I0_prime = 0;
		int I_7 = 0;
		int I0_k = 0;
		int I_8 = 0;
		int i_9 = 0;
		int I_10 = 0;
		int I_11 = 0;
		int I_12 = 0;
		int i_13 = 0;
		int I_14 = 0;
		int I_15 = 0;
		int i_16 = 0;
		int I_17 = 0;
		int I_18 = 0;
		int i_19 = 0;
		int label = 0;
		while (true) {
			switch (label) {
			case 0:
				fp = mir_allocate(SIEVE_SIZE + 8);
				I0_iter = 0;
				I_0 =  (int) i0_n;
				if ( I0_iter >=  I_0) {
					label = 17;
					break;
				}
			case 18:
				I0_count = 0;
				I0_i = 0;
				if ( I0_i >=  SIEVE_SIZE) {
					label = 19;
					break;
				}
			case 20:
				I_3 =  1;
				mir_write_byte(fp + I0_i, I_3);
			case 21:
				I_4 = I0_i;
				I_4 =  I_4 +  1;
				I0_i = I_4;
				if ( I0_i <  SIEVE_SIZE) {
					label = 20;
					break;
				}
			case 19:
				I0_i = 2;
				if ( I0_i >=  SIEVE_SIZE) {
					label = 22;
					break;
				}
			case 23:
				if (( mir_read_byte(fp + I0_i) == 0)) {
					label = 24;
					break;
				}
			case 25:
				I_7 =  I0_i +  1;
				I0_prime = I_7;
				I_8 =  I0_i +  I0_prime;
				I0_k = I_8;
				if ( I0_k >=  SIEVE_SIZE) {
					label = 26;
					break;
				}
			case 27:
				I_10 =  0;
				mir_write_byte(fp + I0_k, I_10);
			case 28:
				I_11 = I0_k;
				I_11 =  I_11 +  I0_prime;
				I0_k = I_11;
				if ( I0_k <  SIEVE_SIZE) {
					label = 27;
					break;
				}
			case 26:
				I_14 = I0_count;
				I_14 =  I_14 +  1;
				I0_count = I_14;
				label = 29;
				break;
			case 24:
			case 29:
			case 30:
				I_15 = I0_i;
				I_15 =  I_15 +  1;
				I0_i = I_15;
				if ( I0_i <  SIEVE_SIZE) {
					label = 23;
					break;
				}
			case 22:
			case 31:
				I_17 = I0_iter;
				I_17 =  I_17 +  1;
				I0_iter = I_17;
				I_18 =  i0_n;
				if ( I0_iter <  I_18) {
					label = 18;
					break;
				}
			case 17:
				mir_restoreStack();
				return I0_count;
			} // End of switch
		} // End of while
	} // End of function sieve
	
	public int sieveWithIntegerLabelsWithoutLongCastAndLocalMemoryAccess(int _i0_n) {
		mir_saveStack();
		byte[] memory = new byte[SIEVE_SIZE + 8];
		int i0_n = _i0_n;
		int fp = 0;
		int I0_iter = 0;
		int I_0 = 0;
		int i_1 = 0;
		int I0_count = 0;
		int I0_i = 0;
		int i_2 = 0;
		int I_3 = 0;
		int I_4 = 0;
		int i_5 = 0;
		int i_6 = 0;
		int I0_prime = 0;
		int I_7 = 0;
		int I0_k = 0;
		int I_8 = 0;
		int i_9 = 0;
		int I_10 = 0;
		int I_11 = 0;
		int I_12 = 0;
		int i_13 = 0;
		int I_14 = 0;
		int I_15 = 0;
		int i_16 = 0;
		int I_17 = 0;
		int I_18 = 0;
		int i_19 = 0;
		int label = 0;
		while (true) {
			switch (label) {
			case 0:
				fp = 0; //mir_allocate(SIEVE_SIZE + 8);
				I0_iter = 0;
				I_0 =  (int) i0_n;
				if ( I0_iter >=  I_0) {
					label = 17;
					break;
				}
			case 18:
				I0_count = 0;
				I0_i = 0;
				if ( I0_i >=  SIEVE_SIZE) {
					label = 19;
					break;
				}
			case 20:
				I_3 =  (byte) 1;
				memory[fp + I0_i] = (byte)I_3;
			case 21:
				I_4 = I0_i;
				I_4 =  I_4 +  1;
				I0_i = I_4;
				if ( I0_i <  SIEVE_SIZE) {
					label = 20;
					break;
				}
			case 19:
				I0_i = 2;
				if ( I0_i >=  SIEVE_SIZE) {
					label = 22;
					break;
				}
			case 23:
				if (( memory[fp + I0_i] == 0)) {
					label = 24;
					break;
				}
			case 25:
				I_7 =  I0_i +  1;
				I0_prime = I_7;
				I_8 =  I0_i +  I0_prime;
				I0_k = I_8;
				if ( I0_k >=  SIEVE_SIZE) {
					label = 26;
					break;
				}
			case 27:
				I_10 =  (byte) 0;
				memory[fp + I0_k] = (byte) I_10;
			case 28:
				I_11 = I0_k;
				I_11 =  I_11 +  I0_prime;
				I0_k = I_11;
				if ( I0_k <  SIEVE_SIZE) {
					label = 27;
					break;
				}
			case 26:
				I_14 = I0_count;
				I_14 =  I_14 +  1;
				I0_count = I_14;
				label = 29;
				break;
			case 24:
			case 29:
			case 30:
				I_15 = I0_i;
				I_15 =  I_15 +  1;
				I0_i = I_15;
				if ( I0_i <  SIEVE_SIZE) {
					label = 23;
					break;
				}
			case 22:
			case 31:
				I_17 = I0_iter;
				I_17 =  I_17 +  1;
				I0_iter = I_17;
				I_18 =  i0_n;
				if ( I0_iter <  I_18) {
					label = 18;
					break;
				}
			case 17:
				mir_restoreStack();
				return I0_count;
			} // End of switch
		} // End of while
	} // End of function sieve

	public int sieveJava(int n) {
		int i, iter, k, count = 0, prime;
		byte flags[] = new byte[SIEVE_SIZE];

		for (iter = 0; iter < n; iter++) {
			count = 0;
			for (i = 0; i < SIEVE_SIZE; i++)
				flags[i] = 1;
			for (i = 2; i < SIEVE_SIZE; i++)
				if (flags[i] == 1) {
					prime = i + 1;
					for (k = (int) (i + prime); k < SIEVE_SIZE; k += prime)
						flags[k] = 0;
					count++;
				}
		}
		return count;
	}

	public int sieveJavaWithMemoryOperations(int n) {
		int i, iter, k, count = 0, prime;
		//byte flags[] = new byte[SieveSize];

		for (iter = 0; iter < n; iter++) {
			count = 0;
			for (i = 0; i < SIEVE_SIZE; i++)
				mir_write_byte(i, 1);
			for (i = 2; i < SIEVE_SIZE; i++)
				if (mir_read_byte(i) == 1) {
					prime = i + 1;
					for (k = (int) (i + prime); k < SIEVE_SIZE; k += prime)
						mir_write_byte(k, 0);
					count++;
				}
		}
		return count;
	}

	public void testAll() {
		testWriteRead();

		long startTime = System.currentTimeMillis();
		int r = sieveJava(SIEVE_ITERATIONS);
		long endTime = System.currentTimeMillis();
		check("Sieve (Java version)", r == SIEVE_EXPECTED);
		float duration = ((float) (endTime - startTime)) / 1000;
		System.out.println("Sieve time (seconds):" + duration);
//		for (int i = 0; i < 5; i++) {
//			startTime = System.currentTimeMillis();
//			r = sieveJava(SIEVE_ITERATIONS);
//			endTime = System.currentTimeMillis();
//			check("Sieve (Java version)", r == SIEVE_EXPECTED);
//			duration = ((float) (endTime - startTime)) / 1000;
//			System.out.println("Sieve time (seconds):" + duration);
//		}

//		startTime = System.currentTimeMillis();
//		r = sieveJavaWithMemoryOperations(SIEVE_ITERATIONS);
//		endTime = System.currentTimeMillis();
//		check("Sieve (Java version with memory operations)", r == SIEVE_EXPECTED);
//		duration = ((float) (endTime - startTime)) / 1000;
//		System.out.println("Sieve (Java version with memory operations): time=" + duration);
//
//		startTime = System.currentTimeMillis();
//		r = sieveWithIntegerLabels(SIEVE_ITERATIONS);
//		endTime = System.currentTimeMillis();
//		check("Sieve (MIR to Java version with integers label)", r == SIEVE_EXPECTED);
//		duration = ((float) (endTime - startTime)) / 1000;
//		System.out.println("Sieve (MIR to Java version with integers label): time=" + duration);
//
		startTime = System.currentTimeMillis();
		r = sieveWithStringLabels(SIEVE_ITERATIONS);
		endTime = System.currentTimeMillis();
		check("Sieve (MIR to Java version: string label)", r == SIEVE_EXPECTED);
		duration = ((float) (endTime - startTime)) / 1000;
		System.out.println("Sieve (MIR to Java version: string label): time=" + duration);
//		
//		startTime = System.currentTimeMillis();
//		r = sieveWithIntegerLabelsWithoutLongCast(SIEVE_ITERATIONS);
//		endTime = System.currentTimeMillis();
//		check("Sieve (MIR to Java version: integers label, long cast removed)", r == SIEVE_EXPECTED);
//		duration = ((float) (endTime - startTime)) / 1000;
//		System.out.println("Sieve (MIR to Java version: integers label, long cast removed): time=" + duration);
		
//		startTime = System.currentTimeMillis();
//		r = sieveWithIntegerLabelsWithoutLongCastAndLocalMemoryAccess(SIEVE_ITERATIONS);
//		endTime = System.currentTimeMillis();
//		check("Sieve (MIR to Java version: integers label, long cast removed, inlined memory access)", r == SIEVE_EXPECTED);
//		duration = ((float) (endTime - startTime)) / 1000;
//		System.out.println("Sieve (MIR to Java version: integers label, long cast removed, inlined memory access): time=" + duration);
		
		
	}

	public static void main(String[] args) {
		RuntimeTest test = new RuntimeTest();
		test.testAll();

	}

}
