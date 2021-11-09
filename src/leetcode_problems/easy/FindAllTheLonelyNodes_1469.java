package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllTheLonelyNodes_1469 {

    // Time complexity: O(n). Space complexity: O(1)
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;

        if (root.left == null) list.add(root.right.val);
        else if (root.right == null) list.add(root.left.val);

        helper(list, root.left);
        helper(list, root.right);
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
