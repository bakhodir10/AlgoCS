package problems;

/*
     Write an algorithm to add an item at the bottom of a doubly linked list.
 */
public class AddAtTheEndDouble<E> {

    private int size;
    private ListNode head;
    private ListNode tail;

    public void add(ListNode newNode) {
        if (newNode == null) throw new NullPointerException();

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail.next.prev = tail;
            tail = tail.next;
        }
        size++;
    }

    private class ListNode {
        private E element;
        private ListNode next;
        private ListNode prev;

        public ListNode(E element, ListNode next, ListNode prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
