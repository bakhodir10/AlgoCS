package leetcode_problems.easy;

import java.util.Stack;

public class MaximumNestingDepth_1614 {

    // Time complexity: O(n). Space complexity: O(n)
    public int maxDepth(String s) {
        int max = 0;
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
                max = Math.max(max, st.size());
            } else if (c == ')') {
                st.pop();
            }
        }
        return max;
    }
}
