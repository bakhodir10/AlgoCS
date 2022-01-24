package leetcode_problems.easy;

public class SubtreeAnotherTree_572 {

    // Time complexity: O(n^2). Space complexity: O(n)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if (isEqual(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isEqual(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
