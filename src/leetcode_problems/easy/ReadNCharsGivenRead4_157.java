package leetcode_problems.easy;

// The read4 API is defined in the parent class Reader4.
abstract class Reader4 {
    int read4(char[] buf) {
        return buf.length;
    }
}

public class ReadNCharsGivenRead4_157 extends Reader4 {

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int read(char[] buf, int n) {
        int p = 0, total = 0;
        char[] readChars = new char[4];

        while (n > 0) {
            int numberOfReads = read4(readChars);
            for (int i = 0; i < Math.min(numberOfReads, n); i++) buf[p++] = readChars[i];
            total += Math.min(numberOfReads, n);
            if (numberOfReads == 0) n = 0;
            else n -= numberOfReads;
        }
        return total;
    }
}
