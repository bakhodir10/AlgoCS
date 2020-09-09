package skiena_book;

public class Ex3_23 {

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode following = head;

        while (current != null) {
            following = following.next;
            current.next = prev;
            prev = current;
            current = following;
        }
        return prev;
    }

    private class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
