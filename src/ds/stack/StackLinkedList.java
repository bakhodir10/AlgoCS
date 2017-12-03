package ds.stack;

import java.util.NoSuchElementException;

public class StackLinkedList<E> {
    private int size;
    private Node head;

    public void push(E elem) {
        if (elem == null) throw new NullPointerException();
        Node sentinel = new Node(elem);
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
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.elem);
            temp = temp.next;
        }
    }

    public int getSize() {
        return size;
    }


    class Node {
        private E elem;
        private Node next;

        public Node(E elem) {
            this.elem = elem;
        }

        public Node(E elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }
}
