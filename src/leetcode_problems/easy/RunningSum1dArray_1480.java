package leetcode_problems.easy;

public class RunningSum1dArray_1480 {

    // Time complexity: O(n). Space complexity: O(1);
    public int[] runningSum(int[] nums) {
        int sumSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
            sumSoFar += nums[i];
            nums[i] = sumSoFar;
        }
        return nums;
    }
}
