package problems.easy;

public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
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
