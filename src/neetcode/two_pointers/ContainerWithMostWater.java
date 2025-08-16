package neetcode.two_pointers;

public class ContainerWithMostWater {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public int maxArea(int[] heights) {
        int max = 0, l = 0, r = heights.length - 1;

        for(int i = 0; i < heights.length; i++) {
            for(int j = i + 1; j < heights.length; j++) {
                max = Math.max(max, (j - i) * Math.min(heights[i], heights[j]));
            }
        }
        return max;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int maxArea2(int[] heights) {
        int max = 0, l = 0, r = heights.length - 1;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(heights[l], heights[r]));
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
