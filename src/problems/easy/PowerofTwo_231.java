package problems.easy;

public class PowerofTwo_231 {

    // approach 1
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    // approach 2
    public boolean isPowerOfTwo2(int n) {
        long sum = 1;
        while (sum < n) {
            sum *= 2;
        }
        return sum == n;
    }

    // approach 3
    public boolean isPowerOfTwo3(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo3(n / 2);
    }

    // approach 4
    public boolean isPowerOfTwo4(int n) {
        return n > 0 && isPowerOfTwoHelper(n) == n;
    }

    private int isPowerOfTwoHelper(int n) {
        if (n == 1) return 1;
        else {
            int prev = isPowerOfTwoHelper(n / 2);
            return prev * 2;
        }
    }
}
