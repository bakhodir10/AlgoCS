package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinTreeRightSide_199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (i == 0) l.add(t.val);
                if (t.right != null) {
                    q.offer(t.right);
                }
                if (t.left != null) {
                    q.offer(t.left);
                }
            }
        }
        return l;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
