package leetcode_explore.trees.recurcive;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    private List<Integer> postOrderList = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            postOrderList.add(root.val);
        }
        return postOrderList;

    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
