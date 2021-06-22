package leetcode_problems.medium;

import java.util.Stack;

public class ScoreParentheses_856 {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()"));
        System.out.println(scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses("()()()"));
    }

    public static int scoreOfParentheses(String s) {
        int count = 0;
        Stack<Character> parentheses = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') parentheses.add(c);
            else {
                count++;
                parentheses.pop();
            }
        }
        return count;
    }
}
