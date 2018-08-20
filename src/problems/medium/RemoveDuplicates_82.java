package problems.medium;

/*
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only
    distinct numbers from the original list.
 */

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates_82 {

    public static ListNode deleteDuplicates(ListNode node) {

        Map<Integer, Integer> elCount = new HashMap<>();
        ListNode countHead = node;
        ListNode resHead = new ListNode(Integer.MIN_VALUE);
        resHead.next = node;
        ListNode dummy = resHead;

        while (countHead != null) {
            int count = elCount.getOrDefault(countHead.val, 0);
            elCount.put(countHead.val, ++count);
            countHead = countHead.next;
        }

        while (resHead.next != null) {
            int count = elCount.get(resHead.next.val);
            if (count > 1) resHead.next = resHead.next.next;
            else resHead = resHead.next;
        }
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
