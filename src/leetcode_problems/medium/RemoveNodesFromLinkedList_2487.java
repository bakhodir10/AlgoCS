package leetcode_problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveNodesFromLinkedList_2487 {

    public static class ListNode {
        int val;
        ListNode next;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public ListNode removeNodes1(ListNode head) {
        Deque<ListNode> st = new ArrayDeque<>();
        ListNode curr = head;

        while(curr != null) {
            if(st.isEmpty()) st.addLast(head);
            else {
                while(!st.isEmpty() && st.getLast().val < curr.val) st.pollLast();
                st.addLast(curr);
            }
            curr = curr.next;
        }

        if(st.isEmpty()) return null;

        ListNode res = st.pollFirst();
        curr = res;
        while(!st.isEmpty()) {
            curr.next = st.pollFirst();
            curr = curr.next;
        }
        curr.next = null;
        return res;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public ListNode removeNodes(ListNode head) {
        // TODO
        return null;
    }

}
