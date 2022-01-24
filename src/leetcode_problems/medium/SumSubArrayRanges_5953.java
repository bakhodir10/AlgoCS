package leetcode_problems.medium;

public class SumSubArrayRanges_5953 {

    // Time complexity: O(n^2). Space complexity: O(1)
    public long subArrayRanges(int[] nums) {
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            int smallest = nums[i];
            int largest = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < smallest) smallest = nums[j];
                if (nums[j] > largest) largest = nums[j];
                res += largest - smallest;
            }
        }
        return res;
    }
}
