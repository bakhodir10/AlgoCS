package leetcode_problems.easy;

public class LargestNumAtLeast_747 {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE, pos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                pos = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > max && i != pos) return -1;
        }
        return pos;
    }
}
