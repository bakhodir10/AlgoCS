package problems.medium;

import java.util.Arrays;

public class BTFromPreAndPostOrder_889 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return buildHelper(inorder, postorder);
    }

    private TreeNode buildHelper(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        TreeNode node = new TreeNode(postorder[postorder.length - 1]);
        int indexNode = findIndex(postorder[postorder.length - 1], inorder);
        node.left = buildHelper(Arrays.copyOfRange(inorder, 0, indexNode), Arrays.copyOfRange(postorder, 0, indexNode));
        node.right = buildHelper(Arrays.copyOfRange(inorder, indexNode + 1, inorder.length), Arrays.copyOfRange(postorder, indexNode, postorder.length - 1));
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
