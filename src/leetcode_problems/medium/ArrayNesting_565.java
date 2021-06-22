package leetcode_problems.medium;

public class ArrayNesting_565 {
    public int arrayNesting(int[] nums) {
        int max = 0;
        boolean b[] = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int k = i, count = 0;
            while (!b[i]) {
                k = nums[k];
                b[k] = true;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
