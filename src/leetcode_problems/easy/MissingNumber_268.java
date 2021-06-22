package leetcode_problems.easy;

public class MissingNumber_268 {

    // approach 1
    public static int missingNumber1(int[] nums) {
        int totalSum = (int) ((1 + nums.length) * 1. / 2 * nums.length);
        for (int num : nums) totalSum -= num;
        return totalSum;
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
