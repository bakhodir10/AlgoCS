package problems.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinTreeZigzagLevel_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int zigzag = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                l.add(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            if (zigzag % 2 == 1) {
                Collections.reverse(l);
            }
            zigzag++;
            list.add(l);
            System.out.println(l);
            l = new LinkedList<>();
        }
        return list;
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
