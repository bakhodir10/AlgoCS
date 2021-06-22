package leetcode_problems.easy;

public class SumOfLeftLeaves_404 {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return sum;
        if (isLeaf(root.left)) sum += root.left.val;
        if (root.left != null) sumOfLeftLeaves(root.left);
        if (root.right != null) sumOfLeftLeaves(root.right);

        return sum;
    }

    private boolean isLeaf(TreeNode root) {
        if (root == null) return false;
        return root.left == null && root.right == null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
