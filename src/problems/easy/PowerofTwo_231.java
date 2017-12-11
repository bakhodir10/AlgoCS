package problems.easy;

public class PowerofTwo_231 {
    public boolean isPowerOfTwo(int n) {
        long sum = 1, i = 0;
        while (sum < n) {
            sum = (long) Math.pow(2, i++);
        }
        return sum == n;
    }
}
