package problems.easy;

import java.util.Arrays;

public class FindSmallestCommonElement_1198 {

    // Time complexity: O(nlogm). Space complexity: O(1)
    public int smallestCommonElement(int[][] mat) {
        int smallest = Integer.MAX_VALUE;

        outerloop:
        for (int j = 0; j < mat[0].length; j++) {
            for (int[] ints : mat) {
                int index = Arrays.binarySearch(ints, mat[0][j]);
                if (index <= -1) continue outerloop;
            }
            smallest = Math.min(smallest, mat[0][j]);
        }
        return smallest == Integer.MAX_VALUE ? -1 : smallest;
    }
}
