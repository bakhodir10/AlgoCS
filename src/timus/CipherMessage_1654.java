package timus;

import java.util.Scanner;
import java.util.Stack;

public class CipherMessage_1654 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        Scanner x = new Scanner(System.in);
        String s = x.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '`' && s.charAt(i) <= '9' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                if (stack.isEmpty()) {
                    stack.push('`');
                }
                if (s.charAt(i) != stack.peek()) stack.push(s.charAt(i));
                else stack.pop();
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i) != '`')
                System.out.print(stack.get(i));
        }
    }
}
