package leetcode_problems.easy;

public class SecondLargestDigit_1796 {

    // Time complexity: O(n). Space complexity: O(1)
    public int secondHighest(String s) {
        boolean[] b = new boolean[10];
        int first = -1, second = -1;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) b[c - '0'] = true;
        }

        for (int i = b.length - 1; i >= 0; i--) {
            if (!b[i]) continue;

            if (first == -1) first = i;
            else if (second == -1) second = i;
        }
        return second;
    }
}
