package leetcode_problems.medium;

import java.util.Arrays;

public class KRadiusSubArrayAverages_5939 {

    //  Time complexity: O(n). Space complexity: O(1)
    public int[] getAverages(int[] nums, int k) {
        long sum = 0;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < k * 2 && i < nums.length; i++) sum += nums[i];

        for (int i = k; i < nums.length - k; i++) {
            sum += nums[i + k];
            res[i] = (int) (sum / (k * 2 + 1));
            sum -= nums[i - k];
        }
        return res;
    }
}
