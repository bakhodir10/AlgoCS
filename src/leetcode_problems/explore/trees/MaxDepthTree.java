package leetcode_problems.explore.trees;

public class MaxDepthTree {

    // approach 1. Top down approach.
    // The idea is to pass the depth in each node to its children.
    // When we reach the leaf node, we compare the depth of the path with the best depth we have.
    int maxDepth = 0;

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        helper(root, 1);
        return maxDepth;
    }

    private void helper(TreeNode node, int depth) {
        if (node == null) return;
        if (node.left == null && node.right == null) maxDepth = Math.max(maxDepth, depth);
        helper(node.left, depth + 1);
        helper(node.right, depth + 1);
    }

    // approach 2. Bottom up approach.
    // The idea is to find the max depth on left child of root and right child of the root and then compare both.
    // Recursive function goes all the way down till it reaches the leaf. The depth count is built from leaf to root
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int depthLeft = maxDepth2(root.left);
        int depthRight = maxDepth2(root.right);
        return Math.max(depthLeft, depthRight) + 1;
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
