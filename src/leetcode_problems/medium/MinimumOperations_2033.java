package leetcode_problems.medium;

import java.util.Arrays;

public class MinimumOperations_2033 {

    // Time complexity: O(nlogn). Space complexity: O(n*m)
    public int minOperations(int[][] grid, int x) {
        int min = 0;
        int k = 0;
        int[] newArr = new int[grid.length * grid[0].length];

        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                newArr[k++] = ints[j];
            }
        }

        Arrays.sort(newArr);
        int median = newArr[newArr.length / 2];

        for (int num : newArr) {
            int diff = Math.abs(num - median);
            if (diff % x != 0) return -1;
            min += diff / x;
        }
        return min;
    }
}
