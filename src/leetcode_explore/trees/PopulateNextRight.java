package leetcode_explore.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRight {

    // Approach 1. BFS
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

    // Approach 2. DFS
    public Node connect2(Node root) {
        if (root == null) return null;
        helper(root, null, 0);
        return root;
    }

    private void helper(Node root, Node prev, int level) {
        if (root == null) return;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }
}
