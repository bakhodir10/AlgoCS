package problems.medium;

public class RemoveNthNode_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy, slow = dummy;
        int i = 0;

        while (i < n) {
            fast = fast.next;
            i++;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if (slow != null && slow.next != null) slow.next = slow.next.next;

        return dummy.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
