package ds.linkedlist;

/*
    implementation of methods of single linked list
 */
public class SingleLinkedList2<E> {

    public void iterate(Node<E> top) {
        while (top != null) {
            System.out.println(top.value);
            top = top.next;
        }
    }

    public Node find(Node<E> top, E target) {
        while (top != null) {
            if (top.value == target) return top;
            top = top.next;
        }
        return null;
    }

    public Node findBefore(Node<E> top, E target) {
        while (top.next != null) {
            if (top.next.value == target) return top;
            top = top.next;
        }
        return null;
    }

    public void insertAtBeginning(Node<E> top, Node<E> new_node) {
        new_node.next = top.next;
        top.next = new_node;
    }

    public void insertAtEnd(Node<E> top, Node<E> new_node) {
        while (top.next != null) {
            top = top.next;
        }
        top.next = new_node;
        new_node.next = null;
    }

    public void insertAfter(Node<E> after_me, Node<E> new_node) {
        new_node.next = after_me.next;
        after_me.next = new_node;
    }

    public void deleteAfter(Node<E> after_me) {
        after_me.next = after_me.next.next;
    }

    public void destroyList(Node<E> top) {
        while (top != null) {
            Node<E> next_node = top.next;
            Runtime.getRuntime().gc();
            top = next_node;
        }
    }

    private class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
