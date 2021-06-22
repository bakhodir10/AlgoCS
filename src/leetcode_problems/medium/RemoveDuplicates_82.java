package leetcode_problems.medium;

/*
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only
    distinct numbers from the original list.
 */

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates_82 {

    // Time complexity: O(n). Space complexity: O(n)
    public static ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> counts = new HashMap<>();
        ListNode newNode = new ListNode();
        ListNode dummyHead = newNode;
        newNode.next = head;

        ListNode temp = head;
        while (temp != null) {
            counts.put(temp.val, counts.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }

        while (newNode.next != null) {
            if (counts.get(newNode.next.val) != 1) newNode.next = newNode.next.next;
            else newNode = newNode.next;
        }
        return dummyHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
