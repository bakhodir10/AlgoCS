package leetcode_problems.explore.trees.recurcive;

import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

    List<List<Integer>> allLevelValues = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return allLevelValues;
    }

    private void helper(TreeNode root, int height) {
        if (root == null) return;
        if (height == allLevelValues.size()) allLevelValues.add(new LinkedList<>());
        allLevelValues.get(height).add(root.val);
        helper(root.left, height + 1);
        helper(root.right, height + 1);
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
