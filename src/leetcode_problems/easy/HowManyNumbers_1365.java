package leetcode_problems.easy;

public class HowManyNumbers_1365 {

    // Time complexity: O(n*Max(num[i])). Space complexity: O(n)
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) counts[num]++;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums[i]; j++) {
                if (nums[i] != j) count += counts[j];
            }
            nums[i] = count;
        }
        return nums;
    }

    // Time complexity: O(n). Space complexity: O(n)
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] counts = new int[101];

        for (int num : nums) counts[num]++;

        int sum = 0;
        int[] preSum = new int[101];

        for (int i = 0; i < preSum.length; i++) {
            preSum[i] = sum;
            sum += counts[i];
        }
        for (int i = 0; i < nums.length; i++) nums[i] = preSum[nums[i]];
        return nums;
    }
}