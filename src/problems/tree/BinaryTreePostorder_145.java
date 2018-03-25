package problems.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// todo not done
public class BinaryTreePostorder_145 {

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            TreeNode peek = st.peek();
            if (peek.right != null) {
                root = peek.right;
                st.push(root);
            } else {
                list.add(st.pop().val);
                st.peek().left = null;
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
/*
[1,2,3,4,5, null,null,null,6, null,null,7,8]
[7,8,6,4,5,2,3,1]
 */