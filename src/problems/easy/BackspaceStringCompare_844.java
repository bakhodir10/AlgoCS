package problems.easy;

import java.util.Stack;

public class BackspaceStringCompare_844 {

    // Time complexity: O(n). Space complexity: O(n)
    public boolean backspaceCompare(String s, String t) {
        return backspacing(s).equals(backspacing(t));
    }

    private Stack<Character> backspacing(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '#') st.push(c);
            else if (!st.isEmpty()) st.pop();
        }
        return st;
    }
}
