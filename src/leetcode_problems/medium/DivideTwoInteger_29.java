package leetcode_problems.medium;

public class DivideTwoInteger_29 {
    public static int divide(int a, int b) {
        long ans = divideHelper(a, b);
        return (int) ans;
    }

    public static long divideHelper(long a, long b) {

        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        boolean isNegative = (a > 0 && b < 0) || (a < 0 && b > 0);
        a = Math.abs(a);
        b = Math.abs(b);

        long l = 0;
        long r = a;

        while (l <= r) {
            long m = (l + r) / 2;
            if (m * b == a) return isNegative ? -m : m;

            if (m * b > a) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return isNegative ? -r : r;
    }
}
