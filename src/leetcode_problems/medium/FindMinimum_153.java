package leetcode_problems.medium;

public class FindMinimum_153 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (r + l) / 2;
            if (nums[m] > nums[r] && nums[m] >= nums[l]) l = m + 1;
            else r = m;
        }
        return nums[l];
    }
}
