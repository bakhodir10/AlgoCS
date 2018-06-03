package problems.medium;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII_142 {

    // approach 1.Time complexity is O(n). Space complexity is O(n).
    public static ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }

    // approach 2.Time complexity is O(n). Space complexity is O(1).
    public static ListNode detectCycle2(ListNode head) {
        return null;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
