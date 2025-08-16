package lintcode.leetcode_premiums;

public class DotProductOfTwoSparseVectors_3691 {
    final int [] nums;

    DotProductOfTwoSparseVectors_3691(int[] nums) {
        this.nums = nums;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfTwoSparseVectors_3691 vec) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) sum += this.nums[i] * vec.nums[i];
        return sum;
    }
}
