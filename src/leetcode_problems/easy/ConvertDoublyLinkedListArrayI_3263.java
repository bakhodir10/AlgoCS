package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.List;

public class ConvertDoublyLinkedListArrayI_3263 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
    }

    public int[] toArray(Node head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);

        return res;
    }
}
