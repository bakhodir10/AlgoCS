package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class NTreePostOrder_590 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        return helper(root, res);
    }

    private List<Integer> helper(Node node, List<Integer> list) {
        if (node == null) return list;
        List<Node> children = node.children;

        for (Node n : children) helper(n, list);
        list.add(node.val);
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
