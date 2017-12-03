package ds.queue;

public class QueueLinkedList<E> {
    private int size;
    private Node head;
    private Node tail;

    public void offer(E elem) {
        Node newNode = new Node(elem, null);
        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        Node node = tail;
        tail.prev.next = null;
        tail = tail.prev;
        size--;
        return (E) node;
    }


    public E element() {
        return head.elem;
    }

    public String toString() {
        Node temp = head;
        if (head == null) return "[]";

        StringBuilder b = new StringBuilder();
        b.append("[ ");
        while (temp != null) {
            b.append(temp.elem);
            if (temp.next != null) b.append(", ");
            temp = temp.next;
        }
        b.append(" ]");
        return b.toString();
    }

    public void iterate() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.elem + " ");
            temp = temp.next;
        }
    }

    public int size() {
        return size;
    }

    private class Node {
        private E elem;
        private Node next;
        private Node prev;

        public Node(E elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }
}
