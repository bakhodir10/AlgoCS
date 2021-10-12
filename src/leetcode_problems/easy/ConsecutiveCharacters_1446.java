package leetcode_problems.easy;

public class ConsecutiveCharacters_1446 {

    // Time complexity: O(n). Space complexity: O(n)
    public int maxPower(String s) {
        int count = 1;
        int max = Integer.MIN_VALUE;
        char[] arr = s.toCharArray();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(count, max);
    }
}
