package ds.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("Duplicates")
public class TraversalIterative {

    // preorder traversal
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

    // inorder traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (node != null && !st.isEmpty()) {
            while (node.left != null) {
                node = node.left;
                st.push(node);
            }
            TreeNode popped = st.pop();
            list.add(popped.val);
            if (popped.right != null) {
                st.push(popped.right);
                node = popped.right;
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
