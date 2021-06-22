package leetcode_problems.easy;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowTree_623 {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return null;

        int level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        if (d == 1) {
            TreeNode newN = new TreeNode(v);
            newN.left = root;
            root = newN;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (t == null) continue;
                if (level == d - 1) {
                    TreeNode right = t.right;
                    TreeNode left = t.left;
                    t.right = new TreeNode(v);
                    t.left = new TreeNode(v);
                    t.right.right = right;
                    t.left.left = left;
                } else {
                    if (t.left != null) q.offer(t.left);
                    if (t.right != null) q.offer(t.right);
                }
            }
            level++;
        }
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
