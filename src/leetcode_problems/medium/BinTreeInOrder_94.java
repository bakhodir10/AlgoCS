package leetcode_problems.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Note: Recursive solution is trivial, could you do it iteratively?
 */

@SuppressWarnings("Duplicates")
public class BinTreeInOrder_94 {
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


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
