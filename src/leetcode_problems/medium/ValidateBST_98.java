package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST_98 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // DFS
    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean isValidBST1(TreeNode root) {
        if(root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(!(root.val > min && root.val < max)) return false;
        return helper(root.left, min, root.val)
                && helper(root.right, root.val, max);
    }

    // Using inOrderTraversal
    // Time complexity: O(n)
    // Space complexity: O(n)
    private final List<Integer> numsInOrder = new ArrayList<>();
    public boolean isValidBST2(TreeNode root) {
        makeInOrder(root);
        for (int i = 1; i < numsInOrder.size(); i++) {
            if (numsInOrder.get(i) <= numsInOrder.get(i - 1)) return false;
        }
        return true;
    }

    private void makeInOrder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) makeInOrder(root.left);
        numsInOrder.add(root.val);
        makeInOrder(root.right);
    }
}
