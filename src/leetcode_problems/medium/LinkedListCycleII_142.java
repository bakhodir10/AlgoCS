package leetcode_problems.medium;

import java.util.HashSet;
import java.util.Objects;
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

    // Floyd's Tortoise and Hare algorithm
    // approach 2.Time complexity is O(n). Space complexity is O(1).
    public static ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next.next == null ) return null;

        // By Floyd's algorithm, the distance from head to cycle starting node is equal
        // to a distance from intersected node to cycle starting node
        ListNode slow2 = head;
        while(slow2 != slow) {
            slow2 = slow2.next;
            slow = slow.next;
        }
        return slow2.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
    }
}
