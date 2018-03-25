package problems.math;

public class MinimumMovesEqual_453 {
    public static int minMoves(int nums[]) {
        if (nums.length == 0) return 0;

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) min = nums[i];
            sum += nums[i];
        }
        return sum - min * nums.length;
    }
}
