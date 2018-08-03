package problems.easy;

@SuppressWarnings("Duplicates")
public class MaximumSubarray_53 {

    // approach 1. Time complexity is O(n^2)
    public int maxSubArray1(int nums[]) {
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                best = Math.max(best, sum);
            }
        }
        return best;
    }

    // approach 2. Time complexity is O(n)
    public int maxSubArray2(int nums[]) {
        int best = Integer.MIN_VALUE, sum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = Math.max(num, sum + num);
            best = Math.max(best, sum);
        }
        return best;
    }
}
