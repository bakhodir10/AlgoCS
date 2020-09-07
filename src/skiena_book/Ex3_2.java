package skiena_book;

public class Ex3_2 {

    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node following = head;

        while (current != null) {
            following = following.next;
            current.next = prev;
            prev = current;
            current = following;
        }
        return prev;
    }

    private static class Node {
        private int val;
        private Node next;
    }
}
