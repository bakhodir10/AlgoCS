package leetcode_problems.medium;

import java.util.Arrays;

public class MinimumFallingPathSum_931 {

    // Time complexity: O(n^2)
    // Space complexity: O(n^2)
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] memo = new int[n][n];

        System.arraycopy(matrix[0], 0, memo[0], 0, n);
        for(int i = 1; i < n; i++) Arrays.fill(memo[i], Integer.MAX_VALUE);

        for(int i = 0; i < n - 1; i ++) {
            for(int j = 0; j < n; j++) {
                int curr = memo[i][j];
                int left = j == 0 ? 0 : matrix[i + 1][j - 1];
                int below = matrix[i + 1][j];
                int right = j == n - 1 ? 0 : matrix[i + 1][j + 1];

                if(j != 0) memo[i + 1][j - 1] = Math.min(memo[i + 1][j - 1], curr + left);
                memo[i + 1][j] = Math.min(memo[i + 1][j], curr + below);
                if(j != n - 1) memo[i + 1][j + 1] = Math.min(memo[i + 1][j + 1], curr + right);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) min = Math.min(min, memo[n - 1][j]);
        return min;
    }
}
