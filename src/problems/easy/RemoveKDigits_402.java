package problems.easy;

import java.util.Stack;

public class RemoveKDigits_402 {
    public String removeKdigits(String num, int k) {

        int i = 1, count = 0;
        Stack<Character> st = new Stack<>();
        st.push(num.charAt(0));

        while (count < k) {
            if (st.isEmpty()) {
                st.push(num.charAt(i++));
                continue;
            }
            if (num.charAt(i) >= st.peek()) st.push(num.charAt(i++));
            else {
                st.pop();
                count++;
            }
        }
        for (int j = count; j < k; j++) st.pop();
        for (int j = i; j < num.length(); j++) st.push(num.charAt(j));

        StringBuilder ans = new StringBuilder();
        boolean leadZero = true;
        for (char c : st) {
            if (c != '0') leadZero = false;
            if (!leadZero) ans.append(c);
        }

        return ans.toString().isEmpty() ? "0" : ans.toString();
    }
}