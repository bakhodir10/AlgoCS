package leetcode_problems.medium;

public class RemoveNthNode_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        int i = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        while (i < n) {
            fast = fast.next;
            i++;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
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
