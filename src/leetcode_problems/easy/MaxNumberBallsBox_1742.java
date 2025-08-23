package leetcode_problems.easy;

public class MaxNumberBallsBox_1742 {

    // Time complexity: O(highLimit - lowLimit)
    // Space complexity: O(1)
    public int countBalls(int lowLimit, int highLimit) {
        int[] counts = new int[46];

        for(int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int curr = i;
            while(curr != 0) {
                sum += curr % 10;
                curr /= 10;
            }
            counts[sum]++;
        }
        int max = 0;
        for(int count: counts) max = Math.max(max, count);
        return max;
    }
}
