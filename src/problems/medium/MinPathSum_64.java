package problems.medium;

public class MinPathSum_64 {
    public static int minPathSum(int grid[][]) {
        for (int i = 1; i < grid[0].length; i++) grid[0][i] = grid[0][i] + grid[0][i - 1];
        for (int i = 1; i < grid.length; i++) grid[i][0] = grid[i][0] + grid[i - 1][0];

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                int max1 = grid[i][j] + grid[i][j - 1];
                int max2 = grid[i][j] + grid[i - 1][j];
                grid[i][j] = Math.min(max1, max2);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
