/*
MIT License

Copyright (c) 2025 Guillaume Legris

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package mir2j;

public class RuntimeTest extends Runtime {

    public static final int SIEVE_SIZE = 819000;
    public static final int SIEVE_EXPECTED = 65333;
    public static final int SIEVE_ITERATIONS = 1000;
//	public static final int SieveSize = 8190;
//	public static final int Expected = 1027;

    public RuntimeTest(int size) {
       super(size);
    }

    public void check(String testName, boolean success) {
        if (success) {
            System.out.println(testName + ": OK");
        } else {
            System.out.println(testName + ": FAIL");
        }
    }

    private void checkNear(String name, double a, double b, double eps) {
        boolean ok = (Double.isNaN(a) && Double.isNaN(b)) || Math.abs(a - b) <= eps;
        check(name, ok);
    }

    private void checkNear(String name, float a, float b, float eps) {
        boolean ok = (Float.isNaN(a) && Float.isNaN(b)) || Math.abs(a - b) <= eps;
        check(name, ok);
    }

//	public void testWriteRead() {
//		long addr = 10;
//		mir_write_int(addr, 7);
//		int i = mir_read_int(addr);
//		check("Write/Read integer", i == 7);
//		//System.out.println("i=" + Integer.toHexString(i));
//		//System.out.println("v=" + Long.toHexString(v));
//		mir_write_int(addr + 4, 15);
//		i = mir_read_int(addr + 4);
//		//System.out.println("i=" + Integer.toHexString(i));
//		long v = mir_read_long(addr);
//		check("Write/Read long", v == 0x70000000FL);
//		mir_write_long(addr + 8, 0x876543210L);
//		v = mir_read_long(addr + 8);
//		check("Write/Read long #2", v == 0x876543210L);
//		addr = mir_set_data_longs(new long[] { 0 , 12, 0, 46 } );
//		v = mir_read_long(addr + 8);
//		check("Write/Read long #2", v == 12);
//		v = mir_read_long(addr + 24);
//		check("Write/Read long #2", v == 46);
//		addr = 10;
//		mir_write_double(addr, 45.678);
//		double d = mir_read_double(addr);
//		check("Write/Read double", d == 45.678);
//		mir_write_float(addr + 8, 145.678f);
//		float f = mir_read_float(addr + 8);
//		check("Write/Read float", f == 145.678f);
//		mir_write_uint(addr + 12, 278);
//		long ui = mir_read_uint(addr + 12);
//		check("Write/Read uint", ui == 278);
//		mir_write_uint(addr + 16, (long)Integer.MAX_VALUE + 100L);
//		ui = mir_read_uint(addr + 16);
//		check("Write/Read uint #2", ui == ((long)Integer.MAX_VALUE + 100L));
//		
//		
//		addr = malloc(60);
//		mir_write_byte(addr + 25, 89);
//		long addr2 = realloc(addr, 26);
//		v = mir_read_byte(addr2 + 25);
//		check("Stdlib: malloc #1 (realloc)", v == 89);
//		
//		addr2 = memset(addr2, 254, 26);
//		v = mir_read_ubyte(addr2 + 25);
//		check("Stdlib: memset #1", v == 254);
//		
//		mir_write_byte(addr2, 'y');
//		mir_write_byte(addr2 + 1, 'e');
//		mir_write_byte(addr2 + 2, 's');
//		mir_write_byte(addr2 + 3, '\0');
//		long length = strlen(addr2);
//		check("Stdlib: strlen #1", length == 3);
//		String str = getStringFromMemory(addr2);
//		check("Stdlib: strlen #2", str.equals("yes"));
//		
//		strcpy(addr2 + 8, addr2);
//		v = mir_read_ubyte(addr2 + 10);
//		check("Stdlib: strcpy #1", v == 's');
//		//System.out.println("i=" + Long.toHexString(v));
//		//System.out.println("v=" + v);
//		//int a = (int) ((v >> 32));
//		//int b = (int) (v & 0xFFFFFFFFL);
//		//System.out.println("a=" + a + " b=" + b);
//	}

    /* --------- core memory tests (LE) ---------- */

    public void testEndianAndPrimitives() {
        long base = 64;

        // short / ushort
        mir_write_short(base + 0, 0xABCD);
        short s = mir_read_short(base + 0);
        int us = mir_read_ushort(base + 0);
        check("LE: short round-trip", s == (short) 0xABCD);
        check("LE: ushort round-trip", us == 0xABCD);

        // Check byte layout: 0xABCD -> CD AB
        int b0 = mir_read_ubyte(base + 0);
        int b1 = mir_read_ubyte(base + 1);
        check("LE: short layout b0", b0 == 0xCD);
        check("LE: short layout b1", b1 == 0xAB);

        // int / uint
        mir_write_int(base + 8, 0xA1B2C3D4);
        int i = mir_read_int(base + 8);
        long ui = mir_read_uint(base + 8);
        check("LE: int round-trip", i == 0xA1B2C3D4);
        check("LE: uint round-trip", ui == 0xA1B2C3D4L);

        // Layout: D4 C3 B2 A1
        int i0 = mir_read_ubyte(base + 8);
        int i1 = mir_read_ubyte(base + 9);
        int i2 = mir_read_ubyte(base + 10);
        int i3 = mir_read_ubyte(base + 11);
        check("LE: int layout b0", i0 == 0xD4);
        check("LE: int layout b1", i1 == 0xC3);
        check("LE: int layout b2", i2 == 0xB2);
        check("LE: int layout b3", i3 == 0xA1);

        // long / ulong
        long L = 0x0102030405060708L;
        mir_write_long(base + 16, L);
        long L2 = mir_read_long(base + 16);
        check("LE: long round-trip", L2 == L);

        // Layout: 08 07 06 05 04 03 02 01
        int l0 = mir_read_ubyte(base + 16);
        int l1 = mir_read_ubyte(base + 17);
        int l2 = mir_read_ubyte(base + 18);
        int l3 = mir_read_ubyte(base + 19);
        int l4 = mir_read_ubyte(base + 20);
        int l5 = mir_read_ubyte(base + 21);
        int l6 = mir_read_ubyte(base + 22);
        int l7 = mir_read_ubyte(base + 23);
        check("LE: long layout b0", l0 == 0x08);
        check("LE: long layout b1", l1 == 0x07);
        check("LE: long layout b2", l2 == 0x06);
        check("LE: long layout b3", l3 == 0x05);
        check("LE: long layout b4", l4 == 0x04);
        check("LE: long layout b5", l5 == 0x03);
        check("LE: long layout b6", l6 == 0x02);
        check("LE: long layout b7", l7 == 0x01);

        // Mix: int at addr, int at addr+4 => read one long at addr
        long addr = 128;
        mir_write_int(addr, 7); // bytes: 07 00 00 00
        mir_write_int(addr + 4, 15); // bytes: 0F 00 00 00
        long mixed = mir_read_long(addr); // bytes together LE => 0x0000000F00000007
        check("LE: long from two ints", mixed == 0x0000000F00000007L);
    }

    public void testUnsigned32() {
        long addr = 256;

        mir_write_uint(addr, 0xFFFFFFFFL);
        long u1 = mir_read_uint(addr);
        int s1 = mir_read_int(addr);
        check("uint=0xFFFFFFFF -> read_uint", u1 == 0xFFFFFFFFL);
        check("uint=0xFFFFFFFF -> read_int", s1 == -1);

        mir_write_uint(addr + 4, (long) Integer.MAX_VALUE + 100L);
        long u2 = mir_read_uint(addr + 4);
        check("uint > MAX_INT round-trip", u2 == (long) Integer.MAX_VALUE + 100L);
    }

    public void testFloatDouble() {
        long addr = 384;

        // float
        float f = 145.678f;
        mir_write_float(addr, f);
        float fr = mir_read_float(addr);
        checkNear("float round-trip", fr, f, 0.0f); // bit-identique attendu

        // double
        double d = 45.678;
        mir_write_double(addr + 8, d);
        double dr = mir_read_double(addr + 8);
        checkNear("double round-trip", dr, d, 0.0);

        // NaN / Inf round-trip
        mir_write_float(addr + 16, Float.NaN);
        check("float NaN", Float.isNaN(mir_read_float(addr + 16)));
        mir_write_double(addr + 24, Double.POSITIVE_INFINITY);
        check("double +Inf", Double.isInfinite(mir_read_double(addr + 24)) && mir_read_double(addr + 24) > 0);
    }

    public void testSetDataFamily() {
        // mir_set_data_longs
        long a = mir_set_data_longs(new long[] { 0, 12, 0, 46 });
        check("set_data_longs[1]=12", mir_read_long(a + 8) == 12);
        check("set_data_longs[3]=46", mir_read_long(a + 24) == 46);

        // mir_set_data_double (doit allouer 8 octets)
        long ad = mir_set_data_double(Math.PI);
        checkNear("set_data_double", mir_read_double(ad), Math.PI, 0.0);

        // bytes / ubytes / shorts
        long ab = mir_set_data_bytes(new byte[] { 'O', 'K', 0 });
        check("set_data_bytes C-string", getStringFromMemory(ab).equals("OK"));

        long ab2 = mir_set_data_ubyte(255);
        check("set_data_ubyte(255)", mir_read_ubyte(ab2) == 255);
        long aub = mir_set_data_ubytes(new short[] { 0x7F, 0x80, 0xFF });
        check("set_data_ubytes[0]=0x7F", mir_read_ubyte(aub) == 0x7F);
        check("set_data_ubytes[1]=0x80", mir_read_ubyte(aub + 1) == 0x80);
        check("set_data_ubytes[2]=0xFF", mir_read_ubyte(aub + 2) == 0xFF);

        long ash = mir_set_data_shorts(new short[] { (short) 0x1234, (short) 0xABCD });
        check("set_data_shorts[0]", mir_read_ushort(ash) == 0x1234);
        check("set_data_shorts[1]", mir_read_ushort(ash + 2) == 0xABCD);
    }

    public void testCStringAndInterning() {
        long p1 = mir_get_string_ptr("hello");
        long p2 = mir_get_string_ptr("hello");
        long p3 = mir_get_string_ptr("world");
        check("C-string intern same content", p1 == p2);
        check("C-string intern different content", p1 != p3);
        check("C-string content", getStringFromMemory(p3).equals("world"));
    }

    public void testStdlibBasics() {
        long addr = malloc(60);
        mir_write_byte(addr + 25, 89);
        long addr2 = realloc(addr, 26);
        long v = mir_read_byte(addr2 + 25);
        check("stdlib: malloc/realloc", v == 89);

        memset(addr2, 254, 26);
        int ub = mir_read_ubyte(addr2 + 25);
        check("stdlib: memset", ub == 254);

        // strlen / strcpy
        mir_write_byte(addr2, 'y');
        mir_write_byte(addr2 + 1, 'e');
        mir_write_byte(addr2 + 2, 's');
        mir_write_byte(addr2 + 3, '\0');
        long length = strlen(addr2);
        check("stdlib: strlen", length == 3);
        String str = getStringFromMemory(addr2);
        check("stdlib: getStringFromMemory", str.equals("yes"));

        strcpy(addr2 + 8, addr2);
        ub = mir_read_ubyte(addr2 + 10);
        check("stdlib: strcpy", ub == 's');

        // memcpy
        long src = mir_get_string_ptr("abcd");
        long dst = malloc(5);
        memcpy(dst, src, 5);
        check("stdlib: memcpy C-string", getStringFromMemory(dst).equals("abcd"));
    }

    public void testSprintfVariants() {
        // sprintf
        long buf = malloc(64);
        long fmt = mir_get_string_ptr("x=%d y=%u z=%X");
        int n = sprintf(buf, fmt, -3, 300L, 0xABCD);
        check("sprintf length>0", n > 0);
        String out = getStringFromMemory(buf);
        check("sprintf content", out.equals(String.format("x=%d y=%d z=%X", -3, 300, 0xABCD)));

        // vsprintf using our VarArgs wrapper
        long vbuf = malloc(64);
        long vfmt = mir_get_string_ptr("p=%d q=%d");
        long va = 0x1234; // any non-zero "address" for the wrapper map
        mir_va_start(va, new Object[] { 5, 7 });
        int vn = vsprintf(vbuf, vfmt, va);
        check("vsprintf length>0", vn > 0);
        String vout = getStringFromMemory(vbuf);
        check("vsprintf content", vout.equals("p=5 q=7"));
    }

    public void testWriteRead() {
        // Conservons ce test en l’adaptant au little-endian
        long addr = 10;
        mir_write_int(addr, 7);
        int i = mir_read_int(addr);
        check("Write/Read integer", i == 7);

        mir_write_int(addr + 4, 15);
        i = mir_read_int(addr + 4);

        long v = mir_read_long(addr);
        // En little-endian: 07 00 00 00 0F 00 00 00 => 0x0000000F00000007
        check("Write/Read long (2 ints)", v == 0x0000000F00000007L);

        mir_write_long(addr + 8, 0x876543210L);
        v = mir_read_long(addr + 8);
        check("Write/Read long #2", v == 0x876543210L);

        addr = mir_set_data_longs(new long[] { 0, 12, 0, 46 });
        v = mir_read_long(addr + 8);
        check("Write/Read long array #1", v == 12);
        v = mir_read_long(addr + 24);
        check("Write/Read long array #2", v == 46);

        addr = 10;
        mir_write_double(addr, 45.678);
        double d = mir_read_double(addr);
        checkNear("Write/Read double", d, 45.678, 0.0);

        mir_write_float(addr + 8, 145.678f);
        float f = mir_read_float(addr + 8);
        checkNear("Write/Read float", f, 145.678f, 0.0f);

        mir_write_uint(addr + 12, 278);
        long ui = mir_read_uint(addr + 12);
        check("Write/Read uint", ui == 278);

        mir_write_uint(addr + 16, (long) Integer.MAX_VALUE + 100L);
        ui = mir_read_uint(addr + 16);
        check("Write/Read uint #2", ui == ((long) Integer.MAX_VALUE + 100L));
    }

    public int sieveWithStringLabels(int _i0_n) {
        int saved_stack_position = mir_get_stack_position();
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
                mir_set_stack_position(saved_stack_position);
                return (int) I0_count;
            } // End of switch
        } // End of while
    } // End of function sieve

    public int sieveWithIntegerLabels(int _i0_n) {
        int saved_stack_position = mir_get_stack_position();
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
                mir_set_stack_position(saved_stack_position);
                return (int) I0_count;
            } // End of switch
        } // End of while
    } // End of function sieve

    public int sieveWithIntegerLabelsWithoutLongCast(int _i0_n) {
        int saved_stack_position = mir_get_stack_position();
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
                I_0 = (int) i0_n;
                if (I0_iter >= I_0) {
                    label = 17;
                    break;
                }
            case 18:
                I0_count = 0;
                I0_i = 0;
                if (I0_i >= SIEVE_SIZE) {
                    label = 19;
                    break;
                }
            case 20:
                I_3 = 1;
                mir_write_byte(fp + I0_i, I_3);
            case 21:
                I_4 = I0_i;
                I_4 = I_4 + 1;
                I0_i = I_4;
                if (I0_i < SIEVE_SIZE) {
                    label = 20;
                    break;
                }
            case 19:
                I0_i = 2;
                if (I0_i >= SIEVE_SIZE) {
                    label = 22;
                    break;
                }
            case 23:
                if ((mir_read_byte(fp + I0_i) == 0)) {
                    label = 24;
                    break;
                }
            case 25:
                I_7 = I0_i + 1;
                I0_prime = I_7;
                I_8 = I0_i + I0_prime;
                I0_k = I_8;
                if (I0_k >= SIEVE_SIZE) {
                    label = 26;
                    break;
                }
            case 27:
                I_10 = 0;
                mir_write_byte(fp + I0_k, I_10);
            case 28:
                I_11 = I0_k;
                I_11 = I_11 + I0_prime;
                I0_k = I_11;
                if (I0_k < SIEVE_SIZE) {
                    label = 27;
                    break;
                }
            case 26:
                I_14 = I0_count;
                I_14 = I_14 + 1;
                I0_count = I_14;
                label = 29;
                break;
            case 24:
            case 29:
            case 30:
                I_15 = I0_i;
                I_15 = I_15 + 1;
                I0_i = I_15;
                if (I0_i < SIEVE_SIZE) {
                    label = 23;
                    break;
                }
            case 22:
            case 31:
                I_17 = I0_iter;
                I_17 = I_17 + 1;
                I0_iter = I_17;
                I_18 = i0_n;
                if (I0_iter < I_18) {
                    label = 18;
                    break;
                }
            case 17:
                mir_set_stack_position(saved_stack_position);
                return I0_count;
            } // End of switch
        } // End of while
    } // End of function sieve

    public int sieveWithIntegerLabelsWithoutLongCastAndLocalMemoryAccess(int _i0_n) {
        int saved_stack_position = mir_get_stack_position();
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
                fp = 0; // mir_allocate(SIEVE_SIZE + 8);
                I0_iter = 0;
                I_0 = (int) i0_n;
                if (I0_iter >= I_0) {
                    label = 17;
                    break;
                }
            case 18:
                I0_count = 0;
                I0_i = 0;
                if (I0_i >= SIEVE_SIZE) {
                    label = 19;
                    break;
                }
            case 20:
                I_3 = (byte) 1;
                memory[fp + I0_i] = (byte) I_3;
            case 21:
                I_4 = I0_i;
                I_4 = I_4 + 1;
                I0_i = I_4;
                if (I0_i < SIEVE_SIZE) {
                    label = 20;
                    break;
                }
            case 19:
                I0_i = 2;
                if (I0_i >= SIEVE_SIZE) {
                    label = 22;
                    break;
                }
            case 23:
                if ((memory[fp + I0_i] == 0)) {
                    label = 24;
                    break;
                }
            case 25:
                I_7 = I0_i + 1;
                I0_prime = I_7;
                I_8 = I0_i + I0_prime;
                I0_k = I_8;
                if (I0_k >= SIEVE_SIZE) {
                    label = 26;
                    break;
                }
            case 27:
                I_10 = (byte) 0;
                memory[fp + I0_k] = (byte) I_10;
            case 28:
                I_11 = I0_k;
                I_11 = I_11 + I0_prime;
                I0_k = I_11;
                if (I0_k < SIEVE_SIZE) {
                    label = 27;
                    break;
                }
            case 26:
                I_14 = I0_count;
                I_14 = I_14 + 1;
                I0_count = I_14;
                label = 29;
                break;
            case 24:
            case 29:
            case 30:
                I_15 = I0_i;
                I_15 = I_15 + 1;
                I0_i = I_15;
                if (I0_i < SIEVE_SIZE) {
                    label = 23;
                    break;
                }
            case 22:
            case 31:
                I_17 = I0_iter;
                I_17 = I_17 + 1;
                I0_iter = I_17;
                I_18 = i0_n;
                if (I0_iter < I_18) {
                    label = 18;
                    break;
                }
            case 17:
                mir_set_stack_position(saved_stack_position);
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
        // byte flags[] = new byte[SieveSize];

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
        testEndianAndPrimitives();
        testUnsigned32();
        testFloatDouble();
        testSetDataFamily();
        testCStringAndInterning();
        testStdlibBasics();
        //testSprintfVariants();
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
		startTime = System.currentTimeMillis();
		r = sieveWithIntegerLabels(SIEVE_ITERATIONS);
		endTime = System.currentTimeMillis();
		check("Sieve (MIR to Java version with integers label)", r == SIEVE_EXPECTED);
		duration = ((float) (endTime - startTime)) / 1000;
		System.out.println("Sieve (MIR to Java version with integers label): time=" + duration);
//
//        startTime = System.currentTimeMillis();
//        r = sieveWithStringLabels(SIEVE_ITERATIONS);
//        endTime = System.currentTimeMillis();
//        check("Sieve (MIR to Java version: string label)", r == SIEVE_EXPECTED);
//        duration = ((float) (endTime - startTime)) / 1000;
//        System.out.println("Sieve (MIR to Java version: string label): time=" + duration);
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
        RuntimeTest test = new RuntimeTest(5000000);
        test.testAll();

    }

}
