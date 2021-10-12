package leetcode_problems.medium;

import java.util.Stack;

public class DecodeString_394 {

    // Time complexity: O(n*Max number). Space complexity: O(n)
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c != ']') stack.push(c);
            else {
                StringBuilder letter = new StringBuilder();
                while (stack.peek() != '[') letter.append(stack.pop());
                stack.pop(); // remove an opening char [
                StringBuilder number = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) number.append(stack.pop());
                int count = Integer.parseInt(number.reverse().toString());

                StringBuilder decodedString = new StringBuilder();
                decodedString.append(String.valueOf(letter.reverse()).repeat(count));

                for (char inC : decodedString.toString().toCharArray()) stack.push(inC);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
