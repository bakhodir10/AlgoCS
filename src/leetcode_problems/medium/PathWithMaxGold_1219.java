package leetcode_problems.medium;

public class PathWithMaxGold_1219 {

    int max = 0;
    public int getMaximumGold(int[][] grid) {
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[i].length; j ++) {
                if(grid[i][j] != 0) backtrack(grid, i, j, 0);
            }
        }
        return max;
    }

    private void backtrack(int[][] grid, int i, int j, int sumSoFar) {
        if(i >= grid.length || i < 0 || j >= grid[i].length || j < 0
                || grid[i][j] == 0) {
            return;
        }

        sumSoFar += grid[i][j];
        int originalVal = grid[i][j];
        grid[i][j] = 0;

        max = Math.max(max, sumSoFar);

        backtrack(grid, i + 1, j, sumSoFar);
        backtrack(grid, i - 1, j, sumSoFar);
        backtrack(grid, i, j + 1, sumSoFar);
        backtrack(grid, i, j - 1, sumSoFar);

        sumSoFar -= originalVal;
        grid[i][j] = originalVal;
    }
}
