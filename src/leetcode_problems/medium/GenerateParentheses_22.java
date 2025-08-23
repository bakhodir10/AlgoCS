package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    // Time complexity: O(2^n)
    // Space complexity:O(n)
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, new StringBuilder(), 0, 0);
        return result;
    }

    private void backtrack(int n, StringBuilder sb, int openCount, int closeCount) {
        if(sb.length() == n * 2) {
            result.add(sb.toString());
            return;
        }

        if(openCount < n) {
            sb.append("(");
            backtrack(n, sb, openCount + 1, closeCount);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(closeCount < openCount) {
            sb.append(")");
            backtrack(n, sb, openCount, closeCount + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
