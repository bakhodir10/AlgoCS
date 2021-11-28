package leetcode_problems.medium;

public class RemoveMinAndMax_5940 {

    //  Time complexity: O(n). Space complexity: O(1)
    public int minimumDeletions(int[] nums) {
        int minIndex = 0, min = Integer.MAX_VALUE;
        int maxIndex = 0, max = Integer.MIN_VALUE;

        if (nums.length == 1) return 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
            if (nums[i] < min) {
                minIndex = i;
                min = nums[i];
            }
        }

        if (minIndex < maxIndex) {
            int sum1 = maxIndex + 1; // from 0 to maxIndex
            int sum2 = nums.length - minIndex; // from end to minIndex
            int sum3 = minIndex + 1 + nums.length - maxIndex; // from 0 to minIndex + from end to maxIndex
            return Math.min(Math.min(sum1, sum2), sum3);
        } else {
            int sum1 = minIndex + 1; // from 0 to minIndex
            int sum2 = nums.length - maxIndex; // from end to maxIndex
            int sum3 = maxIndex + 1 + nums.length - minIndex; // from 0 to maxIndex + from end to minIndex
            return Math.min(Math.min(sum1, sum2), sum3);
        }
    }
}
