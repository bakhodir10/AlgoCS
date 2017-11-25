package problems.easy.math;

public class SumOfSquareNumbers_633 {
    public static boolean judgeSquareSum(int c) {
        for (long a = 1; a * a <= c; a++) {
            long b = c - a * a;
            if (Math.sqrt(b) == (int) Math.sqrt(b)) return true;
        }
        return false;
    }
}
