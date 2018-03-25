package problems.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinTreeLevelOrder_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> st = new Stack<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                l.add(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            st.push(l);
            l = new LinkedList<>();
        }
        while (!st.isEmpty()) {
            list.add(st.pop());
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
