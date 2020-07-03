package problems.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("Duplicates")
public class BinTreeLevelOrder_107 {

    // approach 1. BFS
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        if (root == null) return new LinkedList<>();
        LinkedList<List<Integer>> allLevelValues = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelValues = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                levelValues.add(t.val);
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
            }
            allLevelValues.addFirst(levelValues);
        }
        return allLevelValues;
    }

    // approach 2. DFS
    LinkedList<List<Integer>> allLevelValues = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if (root == null) return new LinkedList<>();
        helper(root, 0);
        Collections.reverse(allLevelValues);
        return allLevelValues;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) return;
        if (level == allLevelValues.size()) allLevelValues.add(new LinkedList<>());
        allLevelValues.get(level).add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
