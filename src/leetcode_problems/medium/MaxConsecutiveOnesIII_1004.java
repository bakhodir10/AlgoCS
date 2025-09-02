package leetcode_problems.medium;

public class MaxConsecutiveOnesIII_1004 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int longestOnes(int[] nums, int k) {
        int[] counts = new int[2];
        int left = 0, right = 0, max = 0;
        while(right < nums.length) {
            counts[nums[right]]++;

            if(counts[0] <= k) max = Math.max(max, right - left + 1);

            while(counts[0] > k && left < right) {
                counts[nums[left]]--;
                left++;
            }
            right++;
        }
        return max;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int longestOnes2(int[] nums, int k) {
        int left = 0, right = 0, max = 0, zeros = 0;
        while(right < nums.length) {
            if(nums[right] == 0) zeros++;

            while(zeros > k) {
                if(nums[left] == 0) zeros--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
