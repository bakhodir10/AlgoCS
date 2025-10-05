package leetcode_problems.medium;

import leetcode_problems.easy.ConvertDoublyLinkedListArrayI_3263;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConvertDoublyLinkedListArrayII_3294 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
    }

    public int[] toArray(Node node) {
        if (node == null) return new int[]{};

        Deque<Integer> dq = new ArrayDeque<>();
        Node curr = node;

        while (curr != null) {
            dq.addFirst(curr.val);
            curr = curr.prev;
        }
        curr = node.next;
        while (curr != null) {
            dq.addLast(curr.val);
            curr = curr.next;
        }
        int[] res = new int[dq.size()];
        int i = 0;
        for (int val : dq) res[i++] = val;

        return res;
    }
}
