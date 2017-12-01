package ds.stack;


import java.util.NoSuchElementException;

public class StackLinkedList<E> {
    private int size;
    private ListNode head;

    public void push(E elem) {
        if (elem == null) throw new NullPointerException();
        ListNode sentinel = new ListNode(elem);
        sentinel.next = head;
        head = sentinel;
        size++;
    }

    public E peek() {
        if (head == null) throw new NoSuchElementException();
        return head.elem;
    }

    public E pop() {
        if (head == null) throw new NoSuchElementException();
        head = head.next;
        size --;
        return head.elem;
    }

    public void iterate() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.elem);
            temp = temp.next;
        }
    }

    public int getSize() {
        return size;
    }


    class ListNode {
        private E elem;
        private ListNode next;

        public ListNode(E elem) {
            this.elem = elem;
        }

        public ListNode(E elem, ListNode next) {
            this.elem = elem;
            this.next = next;
        }
    }
}
