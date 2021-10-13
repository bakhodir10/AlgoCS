package leetcode_problems.medium;

import java.util.*;

public class ArithmeticSubArrays_1630 {

    // Time complexity: O(m*nlogn). Space complexity: O(m)
    public List<Boolean> checkArithmeticSubarrays1(int[] nums, int[] left, int[] right) {
        List<Boolean> res = new LinkedList<>();
        for (int i = 0; i < left.length; i++) res.add(isArithmetic1(Arrays.copyOfRange(nums, left[i], right[i] + 1)));
        return res;
    }

    private boolean isArithmetic1(int[] nums) {
        Arrays.sort(nums);
        int diff = nums[1] - nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != diff) return false;
        }
        return true;
    }

    // Time complexity: O(m*n). Space complexity: O(m)
    public List<Boolean> checkArithmeticSubarrays2(int[] nums, int[] left, int[] right) {
        List<Boolean> res = new LinkedList<>();

        for (int i = 0; i < left.length; i++) res.add(isArithmetic2(nums, left[i], right[i]));
        return res;
    }

    private boolean isArithmetic2(int[] nums, int left, int right) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            set.add(nums[i]);
        }

        int count = 0;
        int d = (max - min) / (right - left);

        if (d == 0) return set.size() == 1;

        while (set.contains(max)) {
            max -= d;
            count++;
        }
        return count == right - left + 1;
    }
}