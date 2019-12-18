package problems.easy;

public class MinTimeVisit_1266 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int minTime = 0;
        for (int i = 0; i < points.length - 1; i++) {
            minTime += Math.max(
                    Math.abs(points[i][0] - points[i + 1][0]),
                    Math.abs(points[i][1] - points[i + 1][1])
            );
        }
        return minTime;
    }
}