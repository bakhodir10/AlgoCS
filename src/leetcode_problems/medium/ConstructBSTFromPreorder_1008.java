package leetcode_problems.medium;

public class ConstructBSTFromPreorder_1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int pre : preorder) root = buildTree(root, pre);
        return root;
    }

    private TreeNode buildTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = buildTree(root.left, val);
        else root.right = buildTree(root.right, val);

        return root;
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
