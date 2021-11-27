package leetcode_problems.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemDupFromUnsortedList_1836 {

    // Time complexity: O(n). Space complexity: O(n)
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Pair> uniques = new LinkedHashMap<>();
        ListNode newNode = new ListNode(-1);
        ListNode headToNewNode = newNode;

        while (head != null) {
            Pair pair = uniques.getOrDefault(head.val, new Pair(0, head));
            pair.count++;
            uniques.put(head.val, pair);
            head = head.next;
        }

        for (Pair pair : uniques.values()) {
            if (pair.count > 1) continue;

            newNode.next = pair.node;
            newNode = newNode.next;
            newNode.next = null;
        }
        return headToNewNode.next;
    }

    private static class Pair {
        private int count;
        private final ListNode node;

        public Pair(int count, ListNode node) {
            this.count = count;
            this.node = node;
        }
    }

    private static class ListNode {
        private final int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
