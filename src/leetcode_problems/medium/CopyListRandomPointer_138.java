package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListRandomPointer_138 {

    // Time complexity: O(n^2). Space complexity: O(1);
    public Node copyRandomList1(Node head) {
        Node dummyNode = new Node(-1);
        Node dummyHead = head;
        Node newNode = dummyNode;

        while (head != null) {
            newNode.next = new Node(head.val);
            head = head.next;
            newNode = newNode.next;
        }
        newNode = dummyNode.next;
        head = dummyHead;

        while (head != null) {
            Node headTemp = dummyHead;
            Node newNodeTemp = dummyNode.next;

            while (headTemp != head.random) {
                headTemp = headTemp.next;
                newNodeTemp = newNodeTemp.next;
            }
            newNode.random = newNodeTemp;
            head = head.next;
            newNode = newNode.next;
        }
        newNode = dummyNode.next;

        return newNode;
    }

    // Time complexity: O(n). Space complexity: O(N);
    public Node copyRandomList2(Node head) {
        if (head == null) return null;

        Map<Node, Node> mappedNodes = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            mappedNodes.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            mappedNodes.get(temp).next = mappedNodes.get(temp.next);
            mappedNodes.get(temp).random = mappedNodes.get(temp.random);
            temp = temp.next;
        }
        return mappedNodes.get(head);
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
