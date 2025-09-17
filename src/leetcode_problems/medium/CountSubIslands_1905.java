package leetcode_problems.medium;

public class CountSubIslands_1905 {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        boolean[][] visited = new boolean[grid2.length][grid2[0].length];

        for(int i = 0; i < grid2.length; i ++) {
            for(int j = 0; j < grid2[i].length; j ++) {
                if(!visited[i][j] && grid2[i][j] == 1) {
                    if(dfs(i, j, grid1, grid2, visited)) count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int i, int j, int[][] grid1, int[][] grid2, boolean[][] visited) {
        if(i >= grid2.length || i < 0 || j >= grid2[i].length || j < 0
                || visited[i][j] || grid2[i][j] == 0) {
            return true;
        }

        if(grid1[i][j] == 0) return false;
        visited[i][j] = true;

        boolean up = dfs(i + 1, j, grid1, grid2, visited);
        boolean down = dfs(i - 1, j, grid1, grid2, visited);
        boolean right = dfs(i, j + 1, grid1, grid2, visited);
        boolean left = dfs(i, j - 1, grid1, grid2, visited);

        return up && down && right && left;
    }
}
