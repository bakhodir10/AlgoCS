package problems;

/*
    Write an algorithm for inserting an item in a sorted doubly linked list
    where the top and bottom sentinels hold the minimum and maximum
    possible values.
 */
public class InsertSortedDouble {
    private int size;
    private ListNode head;
    private ListNode tail;

    public void insert(ListNode newNode) {
        if (newNode == null) throw new NullPointerException();

        if (head == null) {
            head = tail = newNode;
        } else if (newNode.elem < head.elem) {
            newNode.next = head;
            newNode.next.prev = newNode;
            head = newNode;
        } else if (newNode.elem > tail.elem) {
            tail.next = newNode;
            tail.next.prev = tail;
            tail = tail.next;
        } else {
            ListNode temp = head;
            ListNode dummy = temp;
            while (temp.next != null) {
                if (temp.next.elem > newNode.elem) {
                    newNode.next = temp.next;
                    temp.next = newNode;

                    newNode.prev = temp;
                    newNode.next.prev = newNode;
                }
                temp = temp.next;
            }
            head = dummy;
        }

        size++;
    }

    private class ListNode {
        private ListNode prev;
        private ListNode next;
        private Integer elem;
    }
}
