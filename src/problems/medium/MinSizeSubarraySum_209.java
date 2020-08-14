package problems.medium;

public class MinSizeSubarraySum_209 {

    public int minSubArrayLen(int k, int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0, sum = 0, minLength = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];

            while (sum >= k) {
                if (minLength == 0) minLength = fast - slow + 1;
                else minLength = Math.min(minLength, fast - slow + 1);
                sum -= nums[slow++];
            }
        }
        return minLength;
    }
}