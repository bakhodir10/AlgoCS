package leetcode_problems.easy;

/*
    Write an algorithm to add an item at the top of a doubly linked list.
 */
public class AddAtTheTopDouble<E> {
    private int size;
    private ListNode head;
    private ListNode tail;

    public ListNode add(ListNode newNode) {
        if (newNode == null) throw new NullPointerException();

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
            head.next.prev = head;
            head.prev = null;
        }
        size++;
        return head;
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
