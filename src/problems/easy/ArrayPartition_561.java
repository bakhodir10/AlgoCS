package problems.easy;

import java.util.Arrays;

public class ArrayPartition_561 {
    public static int arrayPairSum(int nums[]) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }
}
