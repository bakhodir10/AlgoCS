package leetcode_problems.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinRemoveMakeValidParentheses_1249 {

    // Time complexity: O(n). Space complexity: O(n)
    public String minRemoveToMakeValid(String s) {
        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (currChar == '(') st.push(new Pair(i, currChar));
            else if (currChar == ')') {
                if (st.isEmpty()) st.push(new Pair(i, currChar));
                else if (st.peek().sym == '(') st.pop();
                else st.push(new Pair(i, currChar));
            }
        }

        StringBuilder res = new StringBuilder();
        Set<Integer> indexes = new HashSet<>();

        while (!st.isEmpty()) indexes.add(st.pop().idx);

        for (int i = 0; i < s.length(); i++) {
            if (!indexes.contains(i)) res.append(s.charAt(i));
        }
        return res.toString();
    }

    private static class Pair {
        private final int idx;
        private final char sym;

        public Pair(int idx, char sym) {
            this.idx = idx;
            this.sym = sym;
        }
    }
}
