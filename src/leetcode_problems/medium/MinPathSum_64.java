package leetcode_problems.medium;

public class MinPathSum_64 {

    // Approach: Dynamic Programming. Time complexity: O(n*m). Space complexity: O(n*m)
    public int minPathSum1(int[][] grid) {
        int[][] matrix = new int[grid.length][grid[0].length];

        matrix[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) matrix[0][i] = matrix[0][i - 1] + grid[0][i];
        for (int i = 1; i < grid.length; i++) matrix[i][0] = matrix[i - 1][0] + grid[i][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                int left = matrix[i][j - 1];
                int top = matrix[i - 1][j];
                matrix[i][j] = Math.min(left + grid[i][j], top + grid[i][j]);
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }

    // Approach: Dynamic Programming. Using the input gird as cache. Time complexity: O(n*m). Space complexity: O(1)
    public int minPathSum2(int[][] grid) {
        for (int i = 1; i < grid[0].length; i++) grid[0][i] = grid[0][i - 1] + grid[0][i];
        for (int i = 1; i < grid.length; i++) grid[i][0] = grid[i - 1][0] + grid[i][0];

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                int left = grid[i][j - 1];
                int top = grid[i - 1][j];
                grid[i][j] = Math.min(left + grid[i][j], top + grid[i][j]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
