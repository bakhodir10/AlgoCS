package leetcode_problems.hard;

import java.util.*;

public class SerializeAndDeserializeNAaryTree_428 {

    private static class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
        }
        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    // How data are stored below:
    // 1#4,2,3,4,5,2#0,3#2,6,7,4#1,8,5#2,9,10,6#0,7#1,11,8#1,12,9#1,13,10#0,11#1,14,12#0,13#0,14#0
    // As an improvement we can try to get rid of leaf nodes such as 2:0, 6:0, etc to make string short
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            Node node = q.poll();
            sb.append(node.val).append("#").append(node.children.size()).append(",");
            for(Node child: node.children) {
                q.offer(child);
                sb.append(child.val).append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty()) return null;

        String[] tokens = data.split(",");
        Deque<Node> q = new ArrayDeque<>();
        String[] rootInfo = tokens[0].split("#");
        Node root = new Node(Integer.parseInt(rootInfo[0]), new ArrayList<>());
        q.offer(root);
        int idx = 0;

        while(!q.isEmpty() && idx < tokens.length) {
            Node parent = q.poll();
            String[] parentInfo = tokens[idx].split("#");
            int numberOfChildren = Integer.parseInt(parentInfo[1]);
            idx++;
            for(int i = 0; i < numberOfChildren; i++) {
                Node childNode = new Node(Integer.parseInt(tokens[idx++]), new ArrayList<>());
                parent.children.add(childNode);
                q.offer(childNode);
            }
        }
        return root;
    }
}
