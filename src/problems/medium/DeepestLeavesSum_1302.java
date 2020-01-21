package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum_1302 {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deepLeavesSum = root.val;

        while (!queue.isEmpty()) {
            int len = queue.size();
            deepLeavesSum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                deepLeavesSum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return deepLeavesSum;
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
