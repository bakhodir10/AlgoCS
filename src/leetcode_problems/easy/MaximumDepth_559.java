package leetcode_problems.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepth_559 {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int maxDepth = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node n = q.poll();
                List<Node> children = n.children;
                q.addAll(children);
            }
            maxDepth++;
        }
        return maxDepth;
    }

    private class Node {
        int val;
        List<Node> children;

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
