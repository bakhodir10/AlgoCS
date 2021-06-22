package leetcode_problems.medium;

public class IntegerBreak_343 {

    // Time complexity: O(1). Space complexity: O(1)
    public int integerBreak(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 2;

        if (n % 3 == 0) return (int) Math.pow(3, n / 3);
        if (n % 3 == 1) return 4 * (int) Math.pow(3, (n - 4) / 3);
        if (n % 3 == 2) return 2 * (int) Math.pow(3, (n - 2) / 3);

        return -1;
    }
}