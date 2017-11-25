package problems.easy.linkedlist;

/*
The section “Adding Cells at the End” gives an O(N) algorithm for add-
ing an item at the end of a singly linked list. If you keep another variable,
bottom , that points to the last cell in the list, you can add items to the end
of the list in O(1) time. Write such an algorithm. How does this complicate
other algorithms that add an item at the beginning or end of the list, fi nd
an item, and remove an item? Write an algorithm for removing an item
from this kind of list.
 */
public class AddAtTheEndSingle<E> {
    private int size;
    private ListNode head;
    private ListNode tail;

    public ListNode add(ListNode newNode) {
        if (newNode == null) throw new NullPointerException();
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
        return head;
    }

    private class ListNode {
        private ListNode next;
        private E elem;

        public ListNode(ListNode next, E elem) {
            this.next = next;
            this.elem = elem;
        }
    }
}
