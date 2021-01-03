package problems.medium;

import java.util.*;

public class CloneGraph_133 {

    // Time complexity: O(n). Space complexity: O(N);
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

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
    }
}
