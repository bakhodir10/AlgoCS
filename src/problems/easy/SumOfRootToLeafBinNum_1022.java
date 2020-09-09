package problems.easy;

public class SumOfRootToLeafBinNum_1022 {

    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        helper(root, new StringBuilder());
        return sum;
    }

    private void helper(TreeNode root, StringBuilder num) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            num.append(root.val);
            sum += Integer.parseInt(num.toString(), 2);
            num.setLength(num.length() - 1);
        }

        helper(root.left, num.append(root.val));
        num.setLength(num.length() - 1);
        helper(root.right, num.append(root.val));
        num.setLength(num.length() - 1);
    }

    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
