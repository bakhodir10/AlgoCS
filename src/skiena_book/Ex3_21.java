package skiena_book;

public class Ex3_21 {

    public boolean ifIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return ifIdentical(root1.left, root2.left) && ifIdentical(root1.right, root2.right) && root1.val == root2.val;
    }

    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
