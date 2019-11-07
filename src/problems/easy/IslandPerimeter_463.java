package problems.easy;

public class IslandPerimeter_463 {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) perimeter++;
                    if (i == grid.length - 1) perimeter++;
                    if (j == 0) perimeter++;
                    if (j == grid[i].length - 1) perimeter++;

                    if (i > 0 && grid[i - 1][j] != 1) perimeter++;
                    if (i < grid.length - 1 && grid[i + 1][j] != 1) perimeter++;

                    if (j > 0 && grid[i][j - 1] != 1) perimeter++;
                    if (j < grid[i].length - 1 && grid[i][j + 1] != 1) perimeter++;
                }
            }
        }
        return perimeter;
    }
}
