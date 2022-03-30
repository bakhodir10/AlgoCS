package leetcode_problems.medium;

import java.util.*;

public class LowestCommonAncestorBTII_1644 {

    // Time complexity: O(n). Space complexity: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Set<TreeNode> ansc = new HashSet<>();

        parent.put(root, null);
        bfs(root, parent);

        while (p != null) {
            ansc.add(p);
            p = parent.get(p);
        }

        while (!ansc.contains(q) && q != null) q = parent.get(q);

        return q;
    }

    private void bfs(TreeNode root, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                q.offer(node.left);
                parent.put(node.left, node);
            }
            if (node.right != null) {
                q.offer(node.right);
                parent.put(node.right, node);
            }
        }
    }

    private record TreeNode(TreeNode left, TreeNode right) {
    }
}
