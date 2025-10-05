package leetcode_problems.medium;

public class MaximumTotalSubarrayValueI_3689 {

    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for(int num: nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        long sum = 0;
        while(k-- > 0) sum += max - min;
        return sum;
    }
}
