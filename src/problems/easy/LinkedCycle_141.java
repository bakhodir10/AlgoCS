package problems.easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedCycle_141 {

    // approach 1. Time complexity is O(n). Space complexity is O(n)
    public static ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }

    // approach 2. Time complexity is O(n). Space complexity is O(1)
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }


    // approach 3. Time complexity is O(n). Space complexity is O(1)
    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode newNode = reverse(head);
        if (newNode == head) return true;
        return false;
    }

    private static ListNode reverse(ListNode node) {
        ListNode prevNode = null;
        ListNode currentNode = node;

        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
