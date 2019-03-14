package problems.easy;

public class MaximumDepthBT_104 {

    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return maxDepth;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        maxDepth = Math.max(maxDepth, depth);
        if (root.left != null) dfs(root.left, depth + 1);
        if (root.right != null) dfs(root.right, depth + 1);
    }

    private class TreeNode {
        public TreeNode left;
        public TreeNode right;
    }
}
