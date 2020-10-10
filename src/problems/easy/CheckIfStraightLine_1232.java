package problems.easy;

public class CheckIfStraightLine_1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 0; i < coordinates.length - 2; i++) {
            int x1 = coordinates[i][0];
            int x2 = coordinates[i + 1][0];
            int x3 = coordinates[i + 2][0];
            int y1 = coordinates[i][1];
            int y2 = coordinates[i + 1][1];
            int y3 = coordinates[i + 2][1];
            if ((y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1)) return false;
        }
        return true;
    }
}
