package leetcode_explore.trees.recurcive;

import java.util.LinkedList;
import java.util.List;

public class InOrderTraversal {

    private List<Integer> inOrderList = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            inOrderList.add(root.val);
            inorderTraversal(root.right);
        }
        return inOrderList;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
