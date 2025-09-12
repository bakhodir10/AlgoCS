package leetcode_problems.explore.trees.recurcive;

import java.util.LinkedList;
import java.util.List;

public class PreOrderTraversal {

    private List<Integer> preOrderedList = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            preOrderedList.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return preOrderedList;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
