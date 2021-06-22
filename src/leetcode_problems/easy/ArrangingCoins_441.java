package leetcode_problems.easy;

public class ArrangingCoins_441 {
    public static int arrangeCoins(int s) {
        // arithmetic sequence -> (-b + (Math.sqrt(b * b - 4 * a * c)) / 2 * a
        return (int) ((-1 + Math.sqrt(1 + (long) 4 * 2 * s)) / 2);
    }
}