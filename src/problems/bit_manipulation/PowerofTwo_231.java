package problems.bit_manipulation;

public class PowerofTwo_231 {

    // approach 1
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    // approach 2
    public boolean isPowerOfTwo2(int n) {
        long sum = 1, i = 0;
        while (sum < n) {
            sum *= 2;
            i++;
        }
        return sum == n;
    }
}
