package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumBT_1161 {
    
    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE;
        int level = Integer.MIN_VALUE;
        int i = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;

            for (int k = 0; k < size; k++) {
                TreeNode child = q.poll();
                sum += child.val;
                if (child.left != null) q.add(child.left);
                if (child.right != null) q.add(child.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                level = i;
            }

            i++;
        }
        return level;
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
