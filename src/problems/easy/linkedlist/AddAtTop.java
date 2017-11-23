package problems.easy.linkedlist;

/*
    Write an algorithm to add an item at the top of a doubly linked list.
 */
public class AddAtTop<E> {
    private ListNode head;
    private ListNode tail;

    public ListNode add(ListNode newNode) {
        if (newNode == null) throw new NullPointerException();

        ListNode sentinel = new ListNode(null, head, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            sentinel.next = newNode.next;
        }
        return sentinel.next;
    }

    private class ListNode {
        private E elem;
        private ListNode next;
        private ListNode prev;

        public ListNode(E elem, ListNode next, ListNode prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }
}
