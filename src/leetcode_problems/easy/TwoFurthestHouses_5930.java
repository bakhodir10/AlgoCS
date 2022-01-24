package leetcode_problems.easy;

public class TwoFurthestHouses_5930 {

    // Approach 1. Brute Force solution. Time complexity: O(n^2). Space complexity: O(1)
    public int maxDistance1(int[] colors) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]) max = Math.max(max, j - i);
            }
        }
        return max;
    }
}
