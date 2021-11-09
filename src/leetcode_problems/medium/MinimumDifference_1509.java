package leetcode_problems.medium;

import java.util.Arrays;

public class MinimumDifference_1509 {

    // Time complexity: O(nlogn). Space complexity: O(n-> for sorting)
    public int minDifference(int[] nums) {
        if (nums.length < 5) return 0;

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) min = Math.min(min, nums[nums.length - 4 + i] - nums[i]);
        return min;
    }
}
