package leetcode_problems.easy;

public class FindPivotIndex_724 {

    // Time complexity: O(n). Space complexity: O(1)
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int sumSoFar = 0;

        for (int num : nums) totalSum += num;

        for (int i = 0; i < nums.length; i++) {
            if (totalSum - nums[i] - sumSoFar == sumSoFar) return i;
            sumSoFar += nums[i];
        }
        return -1;
    }
}