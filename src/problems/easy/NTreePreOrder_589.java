package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class NTreePreOrder_589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        return helper(root, res);
    }

    private List<Integer> helper(Node node, List<Integer> list) {
        if (node == null) return list;
        List<Node> children = node.children;
        list.add(node.val);

        for (Node n : children) helper(n, list);
        return list;
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
}
