package problems.medium;

import java.util.Stack;

public class RemoveAllAdjacent_1209 {

    public String removeDuplicates(String s, int k) {
        Stack<Node> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().c == c) st.peek().count++;
            else st.push(new Node(c, 1));
            if (st.peek().count == k) st.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (Node node : st) sb.append(String.valueOf(node.c).repeat(node.count));
        return sb.toString();
    }

    private class Node {
        private char c;
        private int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
