package leetcode_problems.easy;

import java.util.Stack;

public class GoalParserInterpretation_1678 {

    // Approach 1. Using Stack. Time complexity: O(n). Space complexity: O(n);
    public String interpret(String command) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (char c : command.toCharArray()) {
            if (st.isEmpty()) st.push(c);
            else {
                if (c == '(') st.push(c);
                else if (c == ')') {
                    if (st.peek() == '(') {
                        st.pop();
                        st.push('o');
                    }
                } else {
                    if (st.peek() == '(') {
                        st.pop();
                    }
                    st.push(c);
                }
            }
        }
        while (!st.isEmpty()) res.append(st.pop());
        return res.reverse().toString();
    }

    // Approach 2. Time complexity: O(n). Space complexity: O(1);
    public String interpret2(String command) {
        command = command.replace("()", "o");
        command = command.replace("(al)", "al");
        return command;
    }
}
