package ds.queue;

import java.util.NoSuchElementException;

public class PriorityQueue {

    private int size;
    private Node head;
    private Node tail;

    public void offer(Integer value) {
        if (value == null) throw new NullPointerException();
        Node newNode = new Node(value, null);
        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public Integer poll() {
        if (head == null) throw new NoSuchElementException();
        Node temp = new Node(null, head);
        Node dummy = temp;
        int max = Integer.MIN_VALUE;
        while (temp.next != null) {
            if (temp.next.value > max) max = temp.next.value;
            if (temp.next == tail) tail = temp;
            temp.next = temp.next.next;
            size--;
            temp = temp.next;
        }
        head = dummy.next;
        return max;
    }

    private class Node {
        private Integer value;
        private Node next;

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
