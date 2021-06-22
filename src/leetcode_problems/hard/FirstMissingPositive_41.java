package leetcode_problems.hard;

public class FirstMissingPositive_41 {

    // Time complexity O(N). Memory complexity O(1)
    public int firstMissingPositive(int[] nums) {
        // replace all negatives with 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) nums[i] = 0;
        }
        // mark arr value as visited by multiplying it by -1.
        // if an arr value is 0, set it to Integer.MAX_VALUE
        for (int i = 0; i < nums.length; i++) {
            int targetIndex = Math.abs(nums[i]) - 1;
            if (targetIndex >= 0 && targetIndex < nums.length) {
                if (nums[targetIndex] == 0) nums[targetIndex] = Integer.MAX_VALUE;
                nums[targetIndex] = Math.abs(nums[targetIndex]) * -1;
            }
        }
        // check if any value is not visited
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i + 1;
        }
        // all visited, the next smaller positive integer is the next num after arr.length
        return nums.length + 1;
    }
}
