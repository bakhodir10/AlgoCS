package leetcode_problems.medium;

public class MaxConsecutiveOnesII_487 {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeros = 0, left = 0, right = 0, max = 0;

        while(right < nums.length) {
            if(nums[right] == 0) zeros++;

            while(zeros > 1) {
                if(nums[left] == 0) zeros--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    // Follow up: What if the input numbers come in one by one as an infinite stream?
    // In other words, you can't store all numbers coming from the stream as it's too large to hold in memory.
    // Time complexity: O(1)
    // Space complexity: O(1)
    int index = 0;
    int maxLen = 0;
    int lastSeenZeroIndex = 0;
    int secondLastSeenZeroIndex = 0;
    public int findMaxConsecutiveOnes2(int num) {
        if(num == 0) {
            secondLastSeenZeroIndex = lastSeenZeroIndex;
            lastSeenZeroIndex = index;
        }
        maxLen = Math.max(maxLen, index - secondLastSeenZeroIndex);
        index++;
        return maxLen;
    }
}
