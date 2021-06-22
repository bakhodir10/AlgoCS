package leetcode_problems.easy;

import java.util.Stack;

public class RemoveOutermost_1021 {

    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int[] memo = new int[s.length()];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (st.isEmpty()) memo[i] = -1;
            if (c == '(') st.push(c);
            if (c == ')') st.pop();
            if (st.isEmpty()) memo[i] = -1;
        }
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] != -1) result.append(s.charAt(i));
        }

        return result.toString();
    }
}
