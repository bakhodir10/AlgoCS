package leetcode_problems.medium;

// todo not finished
public class BTFromPreAndPostOrder_889 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return buildHelper(inorder, postorder);
    }

    private TreeNode buildHelper(int[] inorder, int[] postorder) {
        return null;
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
