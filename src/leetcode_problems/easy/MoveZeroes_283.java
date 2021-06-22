package leetcode_problems.easy;

public class MoveZeroes_283 {
    public static void moveZeroes(int[] nums) {
        int k = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[k++] = nums[i];
            else count++;
        }
        for (int i = 0; i < count; i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }
}
