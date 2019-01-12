package problems.medium;

public class NumberOfIslands_200 {

    public static void main(String[] args) {
        char c[][] = new char[4][5];
        c[0] = "11110".toCharArray();
        c[1] = "11010".toCharArray();
        c[2] = "11000".toCharArray();
        c[3] = "00000".toCharArray();
        numIslands(c);
    }

    private static boolean[] visited;

    public static int numIslands(char[][] grid) {
        int counter = 0;
        visited = new boolean[grid.length];
        dfs(grid, 0);
        return counter;
    }

    private static int dfs(char grid[][], int i) {

        visited[i] = true;
        for (int j = 0; j < 20; j++) {
            if (!visited[i]) {
                System.out.println(grid[i][j]);
                dfs(grid, j);
            }
        }
        return 0;
    }
}