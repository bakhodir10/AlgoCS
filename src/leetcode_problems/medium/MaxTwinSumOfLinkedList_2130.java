package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class MaxTwinSumOfLinkedList_2130 {

    public static class ListNode {
        int val;
        ListNode next;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int pairSum1 (ListNode head) {
        ListNode curr = head;
        int max = 0;
        List<Integer> list = new ArrayList<>();

        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        for(int i = 0; i < list.size()/ 2; i++) {
            max = Math.max(max, list.get(i) + list.get(list.size() - i - 1));
        }
        return max;
    }

    // Time complexity: O(n)
    // Space complexity: (1)
    public int pairSum2(ListNode head) {
        // [6,5,4,3,2,1]
        ListNode curr = head;
        ListNode fast = head;
        ListNode slow = head;
        int max = 0;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // we need to reverse 2nd half of the list
        // slow = 3->2->1->null
        ListNode prev = null;
        while(slow != null) {
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        // prev = 1->2->3->null
        // curr = 6->5->4->3->2->1->null
        while(prev != null && curr != null) {
            max = Math.max(max, prev.val + curr.val);
            curr = curr.next;
            prev = prev.next;
        }
        return max;
    }
}
