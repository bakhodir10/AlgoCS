package leetcode_problems.explore.trees;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (isLeaf(root)) return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
