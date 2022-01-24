package leetcode_problems.medium;

public class ContainerWithMostWater_11 {

    // This approach TLE. Posted the solution is just to know Brute force solution
    // Time complexity: O(n^2). Space complexity: O(1)
    public int maxArea1(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int currMin = Math.min(height[i], height[j]);
                max = Math.max(max, currMin * (j - i));
            }
        }
        return max;
    }

    // Time complexity: O(n). Space complexity: O(1)
    public int maxArea2(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {
            int min = Math.min(height[l], height[r]);
            max = Math.max(max, min * (r - l));

            if (height[l] > height[r]) r--;
            else l++;
        }
        return max;
    }
}