package problems.easy;

public class MaxConsecutiv_485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) k++;
            else {
                if (k > max) max = k;
                k = 0;
            }
        }
        if(k > max) max = k;
        return max;
    }
}
