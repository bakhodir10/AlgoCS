package contest.leetcode.contest79;

public class LargestTriangle_812 {
    public static double largestTriangleArea(int[][] points) {
        double x1, x2, x3;
        double y1, y2, y3;
        double area = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    x1 = points[i][0] * 1.0;
                    y1 = points[i][1] * 1.0;

                    x2 = points[j][0] * 1.0;
                    y2 = points[j][1] * 1.0;

                    x3 = points[k][0] * 1.0;
                    y3 = points[k][1] * 1.0;
                    double d = Math.abs(0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));

                    area = Math.max(area, d);
                }
            }
        }
        return area;
    }
}