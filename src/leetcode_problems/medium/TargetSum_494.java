package leetcode_problems.medium;

public class TargetSum_494 {

    // Time complexity: O(2^n)
    // Space complexity: O(n)
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    private void backtrack(int[] nums, int target, int idx, int sumSoFar) {
        if(idx == nums.length) {
            if(target == sumSoFar) count++;
            return;
        }
        backtrack(nums, target, idx + 1, sumSoFar - nums[idx]);
        backtrack(nums, target, idx + 1, sumSoFar + nums[idx]);
    }
}
