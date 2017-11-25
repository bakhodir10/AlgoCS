package ds.linkedlist;

/*
    implementation of methods of sorted linked list
 */
public class SortedLinkedList {
    private Node head;
    private Node tail;

    // to add a new element to nodes
    public void add(Integer elem) {
        Node node = new Node(elem, null);
        // to check if the node is the first;
        if (head == null) {
            head = tail = node;
        } else {
            Node temp = new Node(elem, head);
            // to hold the current node
            Node dummy = temp;
            while (temp.next != null && temp.next.element < elem) {
                temp = temp.next;
            }
            // to check if the node is equal to the last element
            if (temp.next == tail) tail = temp.next;
            node.next = temp.next;
            temp.next = node;
            // to return initial head;
            head = dummy.next;
        }
    }

    // to iterate all nodes
    public void iterate() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.element);
            temp = temp.next;
        }
    }

    private class Node{
        int element;
        private Node next;

        public Node(int element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
