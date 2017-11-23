package ds.linkedlist;

import java.util.Stack;

public class LinkedListLoops<E> {

    private int size;
    private Node head;
    private Node tail;

    // to check whether if the node has a loop or not by using marking
    public boolean hasLoopMark() {
        Node temp = head;
        boolean hasLoop = false;

        while (temp != null) {
            if (temp.visited) {
                temp.next = null;
                hasLoop = true;
            }
            temp.visited = true;
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.visited = false;
            temp = temp.next;
        }

        return hasLoop;
    }

    // to check whether if the node has a loop or not by using Hashtable
    public boolean hasLoopHashtable() {
        Node temp = head;
        Stack<Node> stack = new Stack<>();
        while (temp != null) {
            if (stack.contains(temp)) {
                temp.next = null;
                return true;
            }
            stack.add(temp);
            temp = temp.next;
        }
        return false;
    }

    // to check whether if the node has a loop or not by using retracing method
    public boolean hasLoopRetrace() {
        Node temp = head;

        while (temp != null) {
            Node newItem = temp.next;
            while (newItem != null) {
                if (newItem == temp) return false;
                newItem = newItem.next;
            }
            temp = temp.next;
        }
        return false;
    }

    // to check whether if the node has a loop or not by using reverse list
    public boolean hasLoopReverse(Node node) {
        // if node is empty, it has no loops
        if (node.next == null) return false;
        // loop through the list to reverse links
        Node newNode = reverseList(node);
        // if   the reversed list starts the same node
        // as the origin list, there is a loop
        // return the result;
        if (newNode == node) return true;
        return false;
    }

    public Node reverseList(Node node) {
        Node prevNode = null;
        Node currentNode = node;

        while (currentNode != null) {
            // reverse the link out of this node
            Node nextNode = currentNode.next;
            currentNode.next = prevNode;

            // move to the next node
            prevNode = currentNode;
            currentNode = nextNode;
        }
        // to return last node we visited
        return prevNode;
    }

    // to detect loops in the linked list by using Floyd algorithm
    public void floydCycle() {
        if (head == null || head.next == null) throw new NullPointerException();

        Node temp = head;
        Node fast = head;
        Node slow = head;

        while (fast.next != null) {
            slow = slow.next;
            // to check if node size doesn't overflow
            if (fast.next.next != null) {
                fast = fast.next.next;
            }
            // to check if there is a loop
            if (fast == slow) {
                // to start from beginning of the linked list
                fast = temp;
                // they meet at starting point of the loop
                while (fast != slow) {
                    fast = fast.next;
                }
                // to seek end point of the loop
                while (fast.next != slow) {
                    fast = fast.next;
                }
                // to prevent linked list from being infinitive
                fast.next = null;
            }
        }
    }


    private class Node {
        private E elem;
        private Node next;
        private boolean visited;
    }
}
