package problems.medium;

import java.util.*;

// todo not finished
public class MaxWidthBT_662 {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxWidth = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'b'));
        Map<Integer, Integer> map = new HashMap<>();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if (n != null) {
                    q.add(n.left);
                    q.add(n.right);
                }
            }
            maxWidth = Math.max(maxWidth, size);
        }
        return maxWidth;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}