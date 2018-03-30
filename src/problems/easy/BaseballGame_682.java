package problems.easy;

import java.util.Stack;

// todo not done
public class BaseballGame_682 {
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
//        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    public static int calPoints(String[] ops) {
        int sum = 0;
        Stack<String> st = new Stack<>();
        st.push(ops[0]);
        int couldPoint = 0;
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            if (s.charAt(0) == '+') {
                sum = Integer.valueOf(st.peek()) + couldPoint + sum;
            } else if (s.charAt(0) == 'D') {
                sum = Integer.valueOf(st.peek()) * 2 + sum;
                couldPoint = Integer.valueOf(st.peek());
            } else if (s.charAt(0) == 'C') {
                sum -= Integer.parseInt(st.pop());
            } else {
                sum += Integer.parseInt(s);
                st.push(s);
            }
        }
        return sum;
    }
}
