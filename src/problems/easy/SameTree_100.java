package problems.easy;

public class SameTree_100 {
    public boolean isSameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        return n1 != null && n2 != null && isSameTree(n1.left, n2.left)
                && isSameTree(n1.right, n2.right) && n1.val == n2.val;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
