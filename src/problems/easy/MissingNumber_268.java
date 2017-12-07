package problems.easy;

public class MissingNumber_268 {

    // approach 1
    public static int missingNumber1(int[] nums) {
        int sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
        }
        int sum2 = (int) ((1 + nums.length) * 1. / 2 * nums.length);
        return sum2 - sum1;
    }

    // approach 2
    public int missingNumber2(int[] nums) {
        boolean b[] = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            b[nums[i]] = true;
        }
        for (int i = 0; i < b.length; i++) {
            if (!b[i]) return i;
        }
        return -1;
    }
}
