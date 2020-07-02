package leetcode_explore.trees.iterative;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allLevelValues = new LinkedList<>();
        if (root == null) return allLevelValues;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelValues = new LinkedList<>();
            int childrenCount = queue.size();
            for (int i = 0; i < childrenCount; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            allLevelValues.add(levelValues);
        }
        return allLevelValues;
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }
}
