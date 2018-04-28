package problems.medium;

public class UniquePathsII_63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) return 0;

        boolean hasObstacle = false;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
                hasObstacle = true;
            } else {
                if (hasObstacle) obstacleGrid[0][i] = 0;
                else obstacleGrid[0][i] = 1;
            }
        }
        hasObstacle = false;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
                hasObstacle = true;
            } else {
                if (hasObstacle) obstacleGrid[i][0] = 0;
                else obstacleGrid[i][0] = 1;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}