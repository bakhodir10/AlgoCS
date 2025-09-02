package leetcode_problems.medium;

import java.util.*;

public class CloneBinaryTreeWithRandomPointer_1485 {

    static class Node {
         private final int val;
         Node left;
         Node right;
         Node random;

        public Node(int _val) {
            val = _val;
        }
    }

    static class NodeCopy extends Node {
        public NodeCopy(int _val) {
            super(_val);
        }
    }

    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null) return null;

        Map<Node, NodeCopy> map = new HashMap<>();
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
            map.put(node, new NodeCopy(node.val));
        }

        for(Map.Entry<Node, NodeCopy> entry: map.entrySet()) {
            Node original = entry.getKey();
            NodeCopy copied = entry.getValue();

            copied.left = map.get(original.left);
            copied.right = map.get(original.right);
            copied.random = map.get(original.random);
        }
        return map.get(root);
    }
}
