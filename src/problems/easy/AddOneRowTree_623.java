package problems.easy;

import java.util.LinkedList;
import java.util.Queue;

// todo not finished
public class AddOneRowTree_623 {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return root;
        int level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
//            int sum = q.
        }
        return null;
    }

    private class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
