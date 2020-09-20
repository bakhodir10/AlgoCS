package problems.medium;

import java.util.Arrays;

public class MaximumNonNegativeProduct_5521 {

    // todo
    // Approach. Dynamic Programming
    public int maxProductPath1(int[][] grid) {
        int[][] mins = new int[grid.length][grid[0].length];
        long mod = (long) 1e9 + 7;
        for (int i = 1; i < grid.length; i++) grid[i][0] *= grid[i - 1][0];
        for (int j = 1; j < grid[0].length; j++) grid[0][j] *= grid[0][j - 1];

        for (int i = 0; i < grid.length; i++) mins[i][0] = grid[i][0];
        for (int j = 0; j < grid[0].length; j++) mins[0][j] = grid[0][j];

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                mins[i][j] = Math.min(mins[i - 1][j] * grid[i][j], mins[i][j - 1] * grid[i][j]);

                int max1 = Math.max(grid[i - 1][j] * grid[i][j], grid[i][j - 1] * grid[i][j]);
                int max2 = Math.max(mins[i - 1][j] * grid[i][j], mins[i][j - 1] * grid[i][j]);

                grid[i][j] = Math.max(max1, max2);
            }
        }

        for (int[] m : mins) System.out.println(Arrays.toString(m));
        System.out.println("***************************************");
        for (int[] g : grid) System.out.println(Arrays.toString(g));

        return grid[grid.length - 1][grid[0].length - 1] < 0 ? -1
                : (int) (grid[grid.length - 1][grid[0].length - 1] % mod);
    }

    // Approach DFS.
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
