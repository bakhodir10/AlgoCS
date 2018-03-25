package problems.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Note: Recursive solution is trivial, could you do it iteratively?
 */

@SuppressWarnings("Duplicates")
public class BinTreePreorder_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode node = root;
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        while (node != null && !st.isEmpty()) {
            while (node != null) {
                st.push(node);
                list.add(node.val);
                node = node.left;
            }
            if (!st.isEmpty()) {
                TreeNode popped = st.pop();
                if (popped.right != null) node = popped.right;
            }
        }
        return list;
    }

    private class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
