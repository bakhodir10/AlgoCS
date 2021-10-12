package leetcode_problems.medium;

import java.util.Stack;

public class TernaryExpressionParser_439 {

    // Time complexity: O(n). Space complexity: O(n)
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] chars = expression.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() == '?') {

                char sign = chars[i];
                stack.pop();

                char left = stack.pop();
                stack.pop();
                char right = stack.pop();

                if (sign == 'T') stack.push(left);
                else stack.push(right);
            } else {
                stack.push(chars[i]);
            }
        }
        return String.valueOf(stack.pop());
    }
}
