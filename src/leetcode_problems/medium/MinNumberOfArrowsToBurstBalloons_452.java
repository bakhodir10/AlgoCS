package leetcode_problems.medium;

import java.util.Arrays;

public class MinNumberOfArrowsToBurstBalloons_452 {

    // Time complexity: O(nlogn)
    // Space complexity: O(1)
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (e1, e2) -> Integer.compare(e1[1], e2[1]));
        int arrowTop = points[0][1], count = 1;

        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] > arrowTop) {
                arrowTop = point[1];
                count++;
            }
        }
        return count;
    }
}
