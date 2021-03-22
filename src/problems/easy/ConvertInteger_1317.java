package problems.easy;

public class ConvertInteger_1317 {

    // Time complexity: O(n). Space complexity: O(n)
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n; i++) {
            if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) return new int[]{i, n - i};
        }
        return new int[]{-1, -1};
    }
}