package leetcode_problems.medium;

import java.util.Stack;

public class MinAddMakeParenthValid_921 {

    // Approach 1. Time complexity: O(n). Space complexity: O(n)
    public int minAddToMakeValid1(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (st.isEmpty() || c == '(') st.push(c);
            else {
                if (st.peek() == '(') st.pop();
                else st.push(c);
            }
        }
        return st.size();
    }

    // Approach 2. Time complexity: O(n). Space complexity: O(1)
    public int minAddToMakeValid2(String s) {
        int open = 0, close = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else {
                if (open > 0) open--;
                else close++;
            }
        }
        return open + close;
    }
}
