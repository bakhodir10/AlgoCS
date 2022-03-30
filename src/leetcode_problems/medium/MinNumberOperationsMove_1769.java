package leetcode_problems.medium;

public class MinNumberOperationsMove_1769 {

    // Time complexity: O(n^2). Space complexity: O(n);
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        char[] cBoxes = boxes.toCharArray();

        for (int i = 0; i < cBoxes.length; i++) {
            int sum = 0;
            for (int j = 0; j < cBoxes.length; j++) {
                if (cBoxes[j] == '0' || i == j) continue;
                sum += Math.abs(i - j);
            }
            ans[i] = sum;
        }
        return ans;
    }
}
