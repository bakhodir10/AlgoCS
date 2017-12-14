package ds.linkedlist;

/*
    implementation of methods of double linked list
 */
public class DoubleLinkedList<E> {

    private int size;
    private Node head;
    private Node tail;

    // to add a new element to nodes
    public void add(E elem) {
        if (elem == null) throw new NullPointerException();

        if (head == null) {
            head = tail = new Node(elem, null, null);
        } else {
            tail.next = new Node(elem, null, tail);
            tail = tail.next;
        }
        size++;
    }

    // to get an element from the nodes
    public E get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        Node temp = head;
        for (int i = 0; i < index; i++) temp = temp.next;
        return temp.elem;
    }

    // to delete an element from the nodes
    public boolean delete(E elem) {
        if(elem == null) throw new NullPointerException();

        Node temp = head;
        while (temp != null) {
            if (temp.elem.equals(elem)) {
                if (temp.next == null) tail = temp.prev;
                else temp.next.prev = temp.prev;
                if (temp.prev == null) head = temp.next;
                else temp.prev.next = temp.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    // to iterate all elements
    public void iterate() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.elem);
            temp = temp.next;
        }
    }

    // to get size of nodes
    public int getSize() {
        return size;
    }

    // to check whether it is empty
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        E elem;
        Node next;
        Node prev;

        public Node(E elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }
}

