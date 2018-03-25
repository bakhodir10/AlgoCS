package problems.linkedlist;

/*
    Write an algorithm that deletes a specified cell from a doubly linked list.
 */
public class DeleteNodeDouble<E> {
    private int size;
    private ListNode head;
    private ListNode tail;

    public boolean delete(ListNode node) {
        if (node == null) throw new NullPointerException();

        ListNode temp = head;
        while (temp != null && temp != node) {
            temp = temp.next;
        }

        if (temp == null) return false;
        boolean del = false;
        if (temp.prev != null) {
            temp.prev.next = temp.next;
            del = true;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
            del = true;
        }
        size--;

        return del;
    }

    private class ListNode {
        private E elem;
        private ListNode prev;
        private ListNode next;
    }
}
