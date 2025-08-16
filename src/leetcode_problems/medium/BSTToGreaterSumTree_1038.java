package leetcode_problems.medium;

public class BSTToGreaterSumTree_1038 {
    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    int preSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return null;

        bstToGst(root.right);
        root.val += preSum;
        preSum = root.val;
        bstToGst(root.left);
        return root;
    }
}
