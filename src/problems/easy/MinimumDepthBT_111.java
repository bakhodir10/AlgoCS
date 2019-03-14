package problems.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBT_111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if (n.left == null && n.right == null) return count;
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            count++;
        }
        return count;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
