package leetcode_problems.easy;

public class SumDigitsMinimum_1085 {

    // Time complexity: O(n). Space complexity: O(1)
    public int sumOfDigits(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int num : nums) min = Math.min(min, num);

        while (min != 0) {
            sum += min % 10;
            min /= 10;
        }
        return sum % 2 == 1 ? 0 : 1;
    }
}
