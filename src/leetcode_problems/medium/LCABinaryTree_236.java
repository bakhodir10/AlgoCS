package leetcode_problems.medium;

import java.util.*;

public class LCABinaryTree_236 {

    // Time complexity: O(n). Space complexity: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        Deque<TreeNode> st = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        st.push(root);
        parent.put(root, null);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode currNode = st.pop();

            if (currNode.left != null) {
                parent.put(currNode.left, currNode);
                st.push(currNode.left);
            }
            if (currNode.right != null) {
                parent.put(currNode.right, currNode);
                st.push(currNode.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>(); // collect ancestors of node p

        while (parent.containsKey(p)) {
            ancestors.add(p);
            p = parent.get(p);
        }

        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }

    private record TreeNode(int val, TreeNode left, TreeNode right) {
    }
}
