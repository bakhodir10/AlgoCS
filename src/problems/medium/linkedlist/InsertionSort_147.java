package problems.medium.linkedlist;

public class InsertionSort_147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode temp = head;
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);

        while (temp != null) {

            ListNode next_cell = temp;
            temp = temp.next;
            ListNode after_me = sentinel;

            while (after_me.next != null && after_me.next.val < next_cell.val) {
                after_me = after_me.next;
            }

            next_cell.next = after_me.next;
            after_me.next = next_cell;
        }

        sentinel = sentinel.next;
        return sentinel;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
