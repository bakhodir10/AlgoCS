package leetcode_problems.medium;

public class MaximumNonNegativeProduct_5521 {

    // Approach => Dynamic Programming. Time complexity: O(n*m). Space complexity: O(n*m)
    public int maxProductPath(int[][] grid) {
        long[][] mins = new long[grid.length][grid[0].length];
        long[][] maxes = new long[grid.length][grid[0].length];
        long mod = (long) 1e9 + 7;

        for (int i = 1; i < grid.length; i++) grid[i][0] *= grid[i - 1][0];
        for (int j = 1; j < grid[0].length; j++) grid[0][j] *= grid[0][j - 1];

        for (int i = 0; i < grid.length; i++) {
            mins[i][0] = grid[i][0];
            maxes[i][0] = grid[i][0];
        }
        for (int j = 0; j < grid[0].length; j++) {
            mins[0][j] = grid[0][j];
            maxes[0][j] = grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {

                long min1 = Math.min(maxes[i - 1][j] * grid[i][j], maxes[i][j - 1] * grid[i][j]);
                long min2 = Math.min(mins[i - 1][j] * grid[i][j], mins[i][j - 1] * grid[i][j]);
                long max1 = Math.max(maxes[i - 1][j] * grid[i][j], maxes[i][j - 1] * grid[i][j]);
                long max2 = Math.max(mins[i - 1][j] * grid[i][j], mins[i][j - 1] * grid[i][j]);

                mins[i][j] = Math.min(min1, min2);
                maxes[i][j] = Math.max(max1, max2);
            }
        }
        return maxes[maxes.length - 1][maxes[0].length - 1] < 0 ? -1
                : (int) (maxes[maxes.length - 1][maxes[0].length - 1] % mod);
    }

    // Approach => DFS.
    long max = Integer.MIN_VALUE;
    long mod = (long) 1e9 + 7;

    public int maxProductPath2(int[][] grid) {
        dfs(grid, 0, 0, 1L);
        return max < 0 ? -1 : (int) (max % mod);
    }

    private void dfs(int[][] grid, int i, int j, long prod) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return;

        if (prod == 0) {
            max = Math.max(max, prod);
            return;
        }
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            prod *= grid[i][j];
            max = Math.max(max, prod);
            return;
        }

        dfs(grid, i + 1, j, prod * grid[i][j]);
        dfs(grid, i, j + 1, prod * grid[i][j]);
    }
}
