package problems.medium;


public class RangeSumBST_938 {
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int l, int r) {
        sumBST(root, l, r);
        return sum;
    }

    private void sumBST(TreeNode root, int l, int r) {
        if (root == null) return;
        if (root.val >= l && root.val <= r) sum += root.val;
        if (root.left != null) sumBST(root.left, l, r);
        if (root.right != null) sumBST(root.right, l, r);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
