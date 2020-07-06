package leetcode_explore.trees;

import java.util.Arrays;

public class BTFromPreAndInOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return buildHelper(preorder, inorder);
    }

    private TreeNode buildHelper(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int rootIndex = findIndex(preorder[0], inorder);
        TreeNode node = new TreeNode(preorder[0]);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1), Arrays.copyOfRange(inorder, 0, rootIndex));
        node.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length), Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        return node;
    }

    private int findIndex(int target, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) return i;
        }
        return -1;
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
