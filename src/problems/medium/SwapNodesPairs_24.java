package problems.medium;

public class SwapNodesPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummy = head;
        while (head.next != null) {
            int c = head.val;
            head.val = head.next.val;
            head.next.val = c;
            head = head.next.next != null ? head.next.next : head.next;
        }
        return dummy;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
