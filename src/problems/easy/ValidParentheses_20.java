package problems.easy;

import java.util.Stack;

public class ValidParentheses_20 {
    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (st.isEmpty()) st.push(c);
            else {
                char last = st.peek();
                if (c == '(' || c == '{' || c == '[') st.push(c);
                else if (c == ')' && last == '(' || c == '}' && last == '{'
                        || c == ']' && last == '[') st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }
}
