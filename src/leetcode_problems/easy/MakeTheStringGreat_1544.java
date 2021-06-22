package leetcode_problems.easy;

import java.util.Stack;

public class MakeTheStringGreat_1544 {

    // Time complexity: O(n). Space complexity: O(n)
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (st.isEmpty()) st.push(c);
            else {
                if (st.peek() != c && Character.toUpperCase(st.peek()) == Character.toUpperCase(c)) st.pop();
                else st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pop());

        return sb.reverse().toString();
    }
}
