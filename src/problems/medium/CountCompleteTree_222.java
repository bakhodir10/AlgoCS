package problems.medium;

public class CountCompleteTree_222 {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int heightLeft = leftmost(root, 0);
        int heightRight = rightmost(root, 0);

        if (heightLeft == heightRight) return (int) Math.pow(2, heightLeft) - 1;
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int leftmost(TreeNode root, int level) {
        if (root == null) return level;
        level++;
        return leftmost(root.left, level);
    }

    private int rightmost(TreeNode root, int level) {
        if (root == null) return level;
        level++;
        return rightmost(root.right, level);
    }

    private class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
