package leetcode_problems.easy;

public class PathSumIII_437 {

    private int count = 0;

    private int pathSum(TreeNode root, int sum) {
        if (root == null) return count;
        isEqual(root, sum);
        if (root.left != null) pathSum(root.left, sum);
        if (root.right != null) pathSum(root.right, sum);

        return count;
    }

    private void isEqual(TreeNode root, int sum) {
        if (root.val == sum) count++;
        if (root.left != null) isEqual(root.left, sum - root.val);
        if (root.right != null) isEqual(root.right, sum - root.val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
