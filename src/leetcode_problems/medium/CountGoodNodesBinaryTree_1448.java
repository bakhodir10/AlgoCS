package leetcode_problems.medium;

public class CountGoodNodesBinaryTree_1448 {
    private int count = 0;

    // Time complexity: O(n). Space complexity: O(1)
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return count;
    }

    private void helper(TreeNode root, int maxSoFar) {
        if (root == null) return;
        if (root.val >= maxSoFar) {
            maxSoFar = root.val;
            count++;
        }
        helper(root.left, maxSoFar);
        helper(root.right, maxSoFar);
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
