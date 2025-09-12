package leetcode_problems.medium;

import ds.queue.QueueArray;

import java.util.*;

public class CloneNAryTree_1490 {

    private static class Node {
        private final int val;
        private final List<Node> children;

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }
    }

    // m -> number of nodes
    // Time complexity: O(m)
    // Space complexity: O(m)
    public Node cloneTree(Node root) {
        if (root == null) return null;

        Map<Node, Node> oldNewMapping = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        oldNewMapping.put(root, new Node(root.val));

        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            for (Node child : currentNode.children) {
                oldNewMapping.put(child, new Node(child.val));
                q.offer(child);
            }
        }

        for (Map.Entry<Node, Node> pair : oldNewMapping.entrySet()) {
            Node original = pair.getKey();
            Node copy = pair.getValue();
            for (Node child : original.children) copy.children.add(oldNewMapping.get(child));
        }
        return oldNewMapping.get(root);
    }

    // 2nd approach. Using recursion
    // m -> number of nodes
    // Time complexity: O(m)
    // Space complexity: O(m)
    public Node cloneTree2(Node root) {
        if (root == null) return null;

        Node newNode = new Node(root.val);
        for (Node child : root.children) newNode.children.add(cloneTree(child));
        return newNode;
    }

    // 3rd approach. Iterative solution
    // m -> number of nodes
    // Time complexity: O(m)
    // Space complexity: O(m)
    public Node cloneTree3(Node root) {
        if(root == null) return null;

        Node newRoot = new Node(root.val);
        Deque<Node[]> q = new ArrayDeque<>(); // acts as like queue and stack but non java.stream_java8.thread-safe
        q.push(new Node[]{root, newRoot});

        while(!q.isEmpty()) {
            Node[] nodes = q.poll();
            Node original = nodes[0];
            Node copy = nodes[1];

            for(Node child: original.children) {
                Node childCopy = new Node(child.val);
                copy.children.add(childCopy);
                q.offer(new Node[]{child, childCopy});
            }
        }
        return newRoot;
    }
}
