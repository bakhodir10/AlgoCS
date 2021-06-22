package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST_98 {

    private List<Integer> numsInOrder = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        makeInOrder(root);
        for (int i = 1; i < numsInOrder.size(); i++) {
            if (numsInOrder.get(i) <= numsInOrder.get(i - 1)) return false;
        }
        return true;
    }

    private void makeInOrder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) makeInOrder(root.left);
        numsInOrder.add(root.val);
        makeInOrder(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
