package problems.medium.linkedlist;

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

        ListNode newNode = new ListNode(Integer.MIN_VALUE);
        ListNode dummy = newNode;
        int remainder = 0;

        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            newNode.next = new ListNode((sum + remainder) % 10);
            newNode = newNode.next;
            remainder = (sum + remainder) / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (remainder != 0) newNode.next = new ListNode(remainder);
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
