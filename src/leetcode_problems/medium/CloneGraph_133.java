package leetcode_problems.medium;

import java.util.*;

public class CloneGraph_133 {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    // Time complexity: O(n + m). Space complexity: O(n + m);
    public Node cloneGraph(Node node) {

        if (node == null) return null;

        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> nodesMap = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        q.offer(node);
        nodesMap.put(node, new Node(node.val));
        visited.add(node);

        while (!q.isEmpty()) {
            for (Node childNode : q.poll().neighbors) {
                if (visited.contains(childNode)) continue;
                q.offer(childNode);
                visited.add(childNode);
                nodesMap.put(childNode, new Node(childNode.val));
            }
        }

        for (Map.Entry<Node, Node> item : nodesMap.entrySet()) {
            Node oldNode = item.getKey();
            Node newNode = item.getValue();
            for (Node oldChild : oldNode.neighbors) newNode.neighbors.add(nodesMap.get(oldChild));
        }

        return nodesMap.get(node);
    }

    // Time complexity: O(n + m). Space complexity: O(n + m);
    public Node cloneGraph2(Node node) {
        if(node == null) return null;


        Map<Node, Node> mapping = new HashMap<>();
        Deque<Node> q = new ArrayDeque<>();
        Node newRoot = new Node(node.val);

        mapping.put(node, newRoot);
        q.offer(node);

        while(!q.isEmpty()) {
            Node oldNode = q.poll();
            Node newNode = mapping.get(oldNode);

            for(Node child: oldNode.neighbors) {
                if(!mapping.containsKey(child)) {
                    Node copiedChild = new Node(child.val);
                    newNode.neighbors.add(copiedChild);
                    mapping.put(child, copiedChild);
                    q.offer(child);
                } else {
                    newNode.neighbors.add(mapping.get(child));
                }
            }
        }
        return newRoot;
    }

    // Approach 3. Using DFS
    // Time complexity: O(n + m). Space complexity: O(n + m);
    Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph3(Node node) {
        if(node == null) return null;

        if(visited.containsKey(node)) return visited.get(node);

        Node newNode = new Node(node.val, new ArrayList<>());
        visited.put(node, newNode);

        for(Node n: node.neighbors) {
            newNode.neighbors.add(cloneGraph(n));
        }
        return newNode;
    }
}
