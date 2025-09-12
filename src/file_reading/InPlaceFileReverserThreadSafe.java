package file_reading;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ConcurrentHashMap;

public class InPlaceFileReverserThreadSafe {

    public static void main(String[] args) {
        reverseFileContentInPlace(new java.io.File(".").getAbsolutePath()
                + "/src/file_reading/bigfile.txt", 30);
    }

    private static final ConcurrentHashMap<String, Object> fileLocks = new ConcurrentHashMap<>();

    public static void reverseFileContentInPlace(String path, int k) {
        // --- Step 1: Get a lock object for this file ---
        Object lock = fileLocks.get(path);
        if (lock == null) {
            lock = new Object();
            Object existing = fileLocks.putIfAbsent(path, lock);
            if (existing != null) {
                lock = existing; // another java.stream_java8.thread added the lock before us
            }
        }

        // --- Step 2: Perform reversal inside synchronized block ---
        synchronized (lock) {
            try(RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
                long left = 0L;
                long right = raf.length();
                byte[] leftKBytes;
                byte[] rightKBytes;

                while (left < right) {
                    long span = right - left;
                    int block = (int)Math.min(k, span / 2);
                    long rightStartingPointer = right - block;

                    if(block == 0) return;

                    leftKBytes = new byte[block];
                    rightKBytes = new byte[block];

                    // read k bytes from the front
                    raf.seek(left);
                    raf.readFully(leftKBytes, 0, block);

                    // read k bytes from the end
                    raf.seek(rightStartingPointer);
                    raf.readFully(rightKBytes, 0, block);

                    // reverse both bytes in place
                    reverseInPlace(leftKBytes);
                    reverseInPlace(rightKBytes);

                    // write k bytes on the right to the left side
                    raf.seek(left);
                    raf.write(rightKBytes, 0, block);

                    // write k bytes on the right to the left side
                    raf.seek(rightStartingPointer);
                    raf.write(leftKBytes, 0, block);

                    left += block;
                    right -= block;
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to reverse file: " + path, e);
            } finally {
                fileLocks.remove(path, lock); // we need to clean up, as it grows indefinitely
            }
        }
    }

    private static void reverseInPlace(byte[] b) {
        for (int i = 0; i < b.length / 2; i ++) {
            byte temp = b[i];
            b[i] = b[b.length - 1 - i];
            b[b.length - 1 - i] = temp;
        }
    }
}
