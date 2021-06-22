package leetcode_problems.easy;

public class FindEvenDigits_1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) count++;
        }
        return count;
    }
}
