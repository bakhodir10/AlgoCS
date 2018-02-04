package problems.medium;

import java.util.Stack;

// todo not done
public class RemoveKDigits_402 {
    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("0200"));
//        System.out.println(removeKdigits("1432219", 5));
//        System.out.println(removeKdigits("1432219", 6));
//        System.out.println(removeKdigits("10200", 1));
//        System.out.println(removeKdigits("10", 3));
        System.out.println(removeKdigits("53402", 4));
    }

    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        if (k >= num.length()) return "0";
        if (num.isEmpty()) return "";
        Stack<Character> st = new Stack<>();
        int count = 0;
        st.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            System.out.println(st);
            if (st.peek() >= num.charAt(i)) {
                st.pop();
                st.push(num.charAt(i));
                count++;
            }
        }
//        System.out.println(st);
//        System.out.println(count);
        StringBuilder b = new StringBuilder();
        st.forEach(b::append);
//        for (int i = 0; i < b.length(); i++) {
//            if (b.charAt(i) == '0') {
//                b.delete(i, i + 1);
//                i--;
//            } else break;
//        }
        return b.toString();
    }
}
