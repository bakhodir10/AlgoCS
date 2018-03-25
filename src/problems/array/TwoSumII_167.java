package problems.array;

import java.util.Arrays;

public class TwoSumII_167 {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            int l = Arrays.binarySearch(nums, i + 1, nums.length, k);
            if (l >= 0) return new int[]{i + 1, l + 1};
        }
        return null;
    }
}