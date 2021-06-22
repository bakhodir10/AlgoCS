package leetcode_problems.medium;

public class SumRootToLeaf_129 {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int num) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            num = num * 10 + root.val;
            sum += num;
        }

        helper(root.left, num * 10 + root.val);
        helper(root.right, num * 10 + root.val);
    }

    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
