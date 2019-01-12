package problems.easy;

import java.util.*;

public class NTreeLevelOrder_429 {

    public List<List<Integer>> levelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        res.add(Arrays.asList(root.val));

        while (!queue.isEmpty()) {
            List<Integer> subRes = new ArrayList<>();
            int childrenSize = queue.size();
            for (int i = 0; i < childrenSize; i++) {
                Node node = queue.poll();
                List<Node> children = node.children;
                for (Node n : children) {
                    subRes.add(n.val);
                    queue.offer(n);
                }
            }
            if (!subRes.isEmpty()) res.add(subRes);
        }

        return res;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
