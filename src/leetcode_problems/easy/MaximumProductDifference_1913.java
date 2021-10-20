package leetcode_problems.easy;

import java.util.Arrays;

public class MaximumProductDifference_1913 {

    // Time complexity: O(nlogn). Space complexity: O(1)
    public int maxProductDifference1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }

    // Time complexity: O(n). Space complexity: O(1)
    public int maxProductDifference2(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num <= smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest) secondSmallest = num;

            if (num >= biggest) {
                secondBiggest = biggest;
                biggest = num;
            } else if (num > secondBiggest) secondBiggest = num;
        }

        return secondBiggest * biggest - secondSmallest * smallest;
    }
}
