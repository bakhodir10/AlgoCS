package leetcode_problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBT_958 {

    // Approach 1. Using BFS. Early stopping once BT is not complete BT. Time complexity: O(n). Space complexity: O(n)
    public boolean isCompleteTree1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;

        while (!queue.isEmpty()) {
            int currLevel = queue.size();

            for (int i = 0; i < currLevel; i++) {
                TreeNode child = queue.poll();
                if (child == null) flag = true;
                else if (flag) return false;

                if (child != null) {
                    queue.add(child.left);
                    queue.add(child.right);
                }
            }
        }
        return true;
    }

    // Approach 2. Using BFS. Time complexity: O(n). Space complexity: O(n)
    public boolean isCompleteTree2(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);

        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }

        while (!bfs.isEmpty() && bfs.peek() == null) bfs.poll();

        return bfs.isEmpty();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
