package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargeValEachRow_515 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<Integer> maxs = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (t.val > max) max = t.val;
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            maxs.add(max);
            max = Integer.MIN_VALUE;
        }
        return maxs;
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
