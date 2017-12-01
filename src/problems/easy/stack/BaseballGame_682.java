package problems.easy.stack;

import java.util.Stack;

public class BaseballGame_682 {
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
//        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    public static int calPoints(String[] ops) {
        int sum = 0;
        Stack<String> st = new Stack<>();
        st.push(ops[0]);
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            String el = st.peek();
            if (s.charAt(0) == '+') {
                sum += Integer.parseInt(el);
            } else if (s.charAt(0) == 'D') {
                sum = sum * 2 + sum;
            } else if (s.charAt(0) == 'C') {
                sum -= Integer.parseInt(st.peek());
            } else {
                sum += Integer.valueOf(ops[i]);
            }
        }
        return sum;
    }
}
