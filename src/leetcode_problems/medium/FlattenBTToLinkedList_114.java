package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class FlattenBTToLinkedList_114 {

    List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        helper(root);
        TreeNode newNode = new TreeNode(-1);
        TreeNode head = newNode;
        for (TreeNode node : list) {
            newNode.right = node;
            newNode.left = null;
            newNode = newNode.right;
            newNode.right = null;
        }
        root = head;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        list.add(root);
        helper(root.left);
        helper(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
