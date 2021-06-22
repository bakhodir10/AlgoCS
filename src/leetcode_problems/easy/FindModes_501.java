package leetcode_problems.easy;

public class FindModes_501 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private int ans[];
    private int currentCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;
    private int currentVal = 0;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        ans = new int[modeCount];
        currentCount = 0;
        currentVal = 0;
        modeCount = 0;
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        handleValue(node.val);
        inOrder(node.right);
    }

    private void handleValue(int val) {
        if (currentVal != val) {
            currentVal = val;
            currentCount = 0;
        }
        currentCount++;
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modeCount = 1;
        } else if (currentCount == maxCount) {
            if (ans != null) ans[modeCount] = currentVal;
            modeCount++;
        }
    }
}
