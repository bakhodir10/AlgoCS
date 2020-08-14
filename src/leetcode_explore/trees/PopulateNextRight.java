package leetcode_explore.trees;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("Duplicates")
public class PopulateNextRight {

    // Approach 1. BFS. Time complexity O(n). Space complexity O(n)
    public Node connect1(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (prev != null) prev.next = node;
                prev = node;
            }
        }
        return root;
    }

    // Approach 2. BFS. Time complexity O(n). Space complexity O(1)
    public Node connect2(Node root) {
        if (root == null) return null;
        Node pre = root, current;

        while (pre.left != null) {
            current = pre;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) current.right.next = current.next.left;
                current = current.next;
            }
            pre = pre.left;
        }
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }
}
