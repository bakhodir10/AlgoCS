package problems.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBin_637 {
    public List<Double> averageOfLevels(TreeNode node) {
        List<Double> list = new LinkedList<>();
        if (node == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            int i = 0;
            while (i < size) {
                TreeNode t = q.poll();
                sum += t.val;
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
                i++;
            }
            list.add(sum / size);
        }
        return list;
    }

    private class TreeNode {
        private int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
