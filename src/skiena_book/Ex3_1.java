package skiena_book;

import java.util.Stack;

public class Ex3_1 {

    // Time complexity: O(n). Space complexity: O(n)
    public int indexOfNonValidParentheses(String s) {
        if (s == null) return -1;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (st.isEmpty() && c == ')') return i + 1;
            if (st.isEmpty()) st.push(c);
            else {
                if (c == '(') st.add(c);
                else st.pop();
            }
        }
        return st.isEmpty() ? -1 : 1;
    }
}