package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.List;

public class MinDistanceBetweenBST_783 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    private final List<Integer> sortedList = new ArrayList<>();
    public int minDiffInBST1(TreeNode root) {
        helper(root);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < sortedList.size(); i ++) {
            min = Math.min(min, sortedList.get(i) - sortedList.get(i - 1));
        }
        return min;
    }

    private void helper(TreeNode root) {
        if(root == null) return;
        if(root.left != null) helper(root.left);
        sortedList.add(root.val);
        if(root.right != null) helper(root.right);
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    int pre = -1, min = Integer.MAX_VALUE;
    public int minDiffInBST2(TreeNode root) {
        if(root.left != null) minDiffInBST2(root.left);
        if(pre >= 0) min = Math.min(min, root.val - pre);
        pre = root.val;
        if(root.right != null) minDiffInBST2(root.right);
        return min;
    }
}
