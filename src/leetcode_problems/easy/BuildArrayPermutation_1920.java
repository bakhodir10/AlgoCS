package leetcode_problems.easy;

public class BuildArrayPermutation_1920 {

    // Time complexity: O(n). Space complexity: O(n)
    public int[] buildArray(int[] nums) {
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) newArr[i] = nums[nums[i]];
        return newArr;
    }
}