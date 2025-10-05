package leetcode_problems.medium;

public class FindTriangularSumOfAnArray_2221 {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public int triangularSum(int[] nums) {
        for(int i = nums.length - 1; i > 0; i--) {
            for(int j = 0; j < nums.length - 1; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }
}
