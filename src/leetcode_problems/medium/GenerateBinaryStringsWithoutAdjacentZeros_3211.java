package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringsWithoutAdjacentZeros_3211 {

    List<String> result = new ArrayList<>();

    // Time complexity: O(n*n!)
    // Space complexity: O(n)
    public List<String> validStrings(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(n, sb, -1);
        return result;
    }

    private void backtrack(int n, StringBuilder sb, int lastChar) {
        if(sb.length() == n) {
            result.add(sb.toString());
            return;
        }

        sb.append("1");
        backtrack(n, sb, 1);
        sb.deleteCharAt(sb.length() - 1);

        if(lastChar != 0) {
            sb.append("0");
            backtrack(n, sb, 0);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
