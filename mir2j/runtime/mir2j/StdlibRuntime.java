package mir2j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class StdlibRuntime extends Runtime {
    
    /* =========================================================================
     * File and time 
     * =========================================================================*/

    /* ===== File-descriptor table for stdio back-end ===== */
    private final Map<Integer, RandomAccessFile> fdTable = new HashMap<>();
    private final Map<Integer, Boolean> fdEof = new HashMap<>();
    private int nextFd = 3; // 0,1,2 reserved (stdin, stdout, stderr)

    public static final int FD_STDIN = 0;
    public static final int FD_STDOUT = 1;
    public static final int FD_STDERR = 2;

    /* Errno-like constants (minimal) */
    private static final int ENOENT = 2;
    private static final int EBADF = 9;
    private static final int EINVAL = 22;
    private static final int EIO = 5;

    /* Helpers */
    private static boolean isStdStream(int fd) {
        return fd == FD_STDIN || fd == FD_STDOUT || fd == FD_STDERR;
    }

    private int allocFd(RandomAccessFile raf) {
        int fd = nextFd++;
        fdTable.put(fd, raf);
        fdEof.put(fd, Boolean.FALSE);
        return fd;
    }

    private RandomAccessFile rafOrNull(int fd) {
        return fdTable.get(fd);
    }

    /* Read a C string from emulated memory (you already have getStringFromMemory) */
    // String getStringFromMemory(long addr) is already implemented above

    /* ===== Java back-end for libc.c primitives (fd-based) ===== */

    /**
     * int mir_sysio_open(const char *filename, const char *mode); returns fd >= 0 on success, or negative errno on error.
     */
    public int mir_sysio_open(long filenamePtr, long modePtr) {
        try {
            String path = getStringFromMemory(filenamePtr);
            String mode = getStringFromMemory(modePtr); // e.g. "r", "rb", "w", "a+", "r+"
            //System.out.println("mir_sysio_open path='" + path + "' mode='" + mode + "'");
            if (path == null || mode == null)
                return -EINVAL;

            String rafMode = "r";
            boolean append = false;
            if (mode.indexOf('w') >= 0 || mode.indexOf('+') >= 0)
                rafMode = "rw";
            if (mode.indexOf('a') >= 0) {
                rafMode = "rw";
                append = true;
            }

            RandomAccessFile raf = new RandomAccessFile(path, rafMode);
            //System.out.println("  opened raf=" + raf + " mode=" + rafMode);
            if (mode.indexOf('w') >= 0)
                raf.setLength(0L); // truncate on "w"
            if (append)
                raf.seek(raf.length());
            else
                raf.seek(0L);

            return allocFd(raf);
        } catch (FileNotFoundException e) {
            return -ENOENT;
        } catch (SecurityException e) {
            return -EIO;
        } catch (IOException e) {
            return -EIO;
        } catch (Throwable t) {
            return -EIO;
        }
    }

    /** int mir_sysio_close_fd(int fd); returns 0 on success, negative errno on error. */
    public int mir_sysio_close_fd(int fd) {
        if (isStdStream(fd))
            return 0; // nothing to close for std streams
        RandomAccessFile raf = rafOrNull(fd);
        if (raf == null)
            return -EBADF;
        try {
            fdTable.remove(fd);
            fdEof.remove(fd);
            raf.close();
            return 0;
        } catch (IOException e) {
            return -EIO;
        }
    }

    /**
     * long mir_sysio_read(int fd, void* buffer, unsigned long count); returns bytes read >=0, 0 on EOF, or negative errno on error.
     */
    public long mir_sysio_read(int fd, long bufferAddr, long count) {
        //System.out.println("mir_sysio_read fd=" + fd + " bufferAddr=0x" + Long.toHexString(bufferAddr) + " count=" + count);
        if (count <= 0)
            return 0;
        if (fd == FD_STDOUT || fd == FD_STDERR)
            return -EBADF; // not readable
        try {
            if (count > Integer.MAX_VALUE)
                count = Integer.MAX_VALUE;
            byte[] tmp = new byte[(int) count];

            if (fd == FD_STDIN) {
                // Simple stdin stub: read nothing (EOF). Improve if needed.
                fdEof.put(fd, Boolean.TRUE);
                return 0;
            }

            RandomAccessFile raf = rafOrNull(fd);
            if (raf == null)
                return -EBADF;

            int n = raf.read(tmp);
            if (n <= 0) { // EOF
                fdEof.put(fd, Boolean.TRUE);
                return 0;
            }
            // write to emulated memory
            for (int i = 0; i < n; i++)
                mir_write_byte((int) (bufferAddr + i), tmp[i]); // memory[(int) (bufferAddr + i)] = tmp[i];
            return n;
        } catch (IOException e) {
            return -EIO;
        } catch (Throwable t) {
            return -EIO;
        }
    }

    /**
     * long mir_sysio_write(int fd, const void* buffer, unsigned long count); returns bytes written >=0, or negative errno on error.
     */
    public long mir_sysio_write(int fd, long bufferAddr, long count) {
        if (count <= 0)
            return 0;
        try {
            if (count > Integer.MAX_VALUE)
                count = Integer.MAX_VALUE;
            byte[] tmp = new byte[(int) count];
            for (int i = 0; i < (int) count; i++)
                tmp[i] = mir_read_byte((int) (bufferAddr + i)); // memory[(int) (bufferAddr + i)];

            if (fd == FD_STDOUT || fd == FD_STDERR) {
                OutputStream os = (fd == FD_STDOUT) ? System.out : System.err;
                os.write(tmp);
                os.flush();
                return count;
            }
            if (fd == FD_STDIN)
                return -EBADF;

            RandomAccessFile raf = rafOrNull(fd);
            if (raf == null)
                return -EBADF;
            raf.write(tmp);
            return count;
        } catch (IOException e) {
            return -EIO;
        } catch (Throwable t) {
            return -EIO;
        }
    }

    /**
     * long mir_sysio_seek(int fd, long offset, int whence); returns new position >=0, or negative errno on error. whence: 0=SEEK_SET, 1=SEEK_CUR, 2=SEEK_END
     */
    public long mir_sysio_seek(int fd, long offset, int whence) {
        RandomAccessFile raf = rafOrNull(fd);
        if (raf == null)
            return -EBADF;
        try {
            long base;
            if (whence == 0)
                base = 0L;
            else if (whence == 1)
                base = raf.getFilePointer();
            else if (whence == 2)
                base = raf.length();
            else
                return -EINVAL;

            long pos = base + offset;
            if (pos < 0)
                pos = 0;
            raf.seek(pos);
            fdEof.put(fd, Boolean.FALSE);
            return raf.getFilePointer();
        } catch (IOException e) {
            return -EIO;
        } catch (Throwable t) {
            return -EIO;
        }
    }

    /** long mir_sysio_tell(int fd); returns position >=0 or negative errno. */
    public long mir_sysio_tell(int fd) {
        RandomAccessFile raf = rafOrNull(fd);
        if (raf == null)
            return -EBADF;
        try {
            return raf.getFilePointer();
        } catch (IOException e) {
            return -EIO;
        }
    }

    /** int mir_sysio_feof(int fd); returns 1 if EOF, 0 otherwise, or negative errno. */
    public int mir_sysio_feof(int fd) {
        if (isStdStream(fd))
            return 0;
        RandomAccessFile raf = rafOrNull(fd);
        if (raf == null)
            return -EBADF;
        try {
            long pos = raf.getFilePointer();
            long len = raf.length();
            boolean atEnd = (pos >= len) || Boolean.TRUE.equals(fdEof.get(fd));
            return atEnd ? 1 : 0;
        } catch (IOException e) {
            return -EIO;
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

    
  

}
