package leetcode_problems.medium;

import java.util.LinkedList;

public class DesignStackWithOperation_1381 {

    private int size = 0;
    private final int maxSize;
    private final LinkedList<Node> linkedList;

    public DesignStackWithOperation_1381(int maxSize) {
        this.maxSize = maxSize;
        this.linkedList = new LinkedList<>();
    }

    // Time complexity O(1)
    public void push(int x) {
        if (size >= maxSize) return;
        linkedList.addLast(new Node(x));
        size++;
    }

    // Time complexity O(1)
    public int pop() {
        if (size <= 0) return -1;
        Node node = linkedList.removeLast();
        size--;
        return node.val;

    }

    // Time complexity O(k)
    public void increment(int k, int val) {
        int loopCount = Math.min(k, linkedList.size());

        for (int i = 0; i < loopCount; i++) {
            Node node = linkedList.get(i);
            node.val = node.val + val;
        }
    }

    private static class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
