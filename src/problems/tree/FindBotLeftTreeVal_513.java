package problems.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBotLeftTreeVal_513 {
    public int findBottomLeftValue(TreeNode n) {
        Queue<TreeNode> st = new LinkedList<>();
        int res = -1;
        st.offer(n);
        while (!st.isEmpty()) {
            TreeNode t = st.poll();
            res = t.val;
            if (t.right != null) st.offer(t.right);
            if (t.left != null) st.offer(t.left);
        }
        return res;
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