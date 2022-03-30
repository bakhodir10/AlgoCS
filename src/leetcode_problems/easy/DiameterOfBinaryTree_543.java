package leetcode_problems.easy;

public class DiameterOfBinaryTree_543 {

    // Time complexity: O(n). Space complexity: O(n => recursive call stack)
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return this.max;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return 0;

        int left = getHeight(root.left) + 1;
        int right = getHeight(root.right) + 1;
        this.max = Math.max(this.max, left + right);

        return Math.max(left, right);
    }

    private record TreeNode(TreeNode left, TreeNode right) {
    }
}
