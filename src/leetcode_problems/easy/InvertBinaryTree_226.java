package leetcode_problems.easy;

public class InvertBinaryTree_226 {

    // DFS. Time complexity: O(n). Space complexity: O(n)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
