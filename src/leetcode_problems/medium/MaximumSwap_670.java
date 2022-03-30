package leetcode_problems.medium;

public class MaximumSwap_670 {

    // Time complexity: O(n^2). Space complexity: O(n)
    public int maximumSwap1(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int max = 0;

        for (int i = 0; i < sb.length(); i++) {
            for (int j = i; j < sb.length(); j++) {
                if(sb.charAt(i) > sb.charAt(j)) continue;
                replace(sb, i, j);
                max = Math.max(max, Integer.parseInt(sb.toString()));
                replace(sb, i, j);
            }
        }
        return max;
    }

    private void replace(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}
