package leetcode_problems.medium;

import java.util.Stack;

public class ConvertBSTToGreaterTree_538 {

    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }

    // Recursiv solution
    // Time complexity: O(n)
    // Space complexity: O(n)
    int preSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        convertBST(root.right);
        root.val += preSum;
        preSum = root.val;
        convertBST(root.left);
        return root;
    }

    // Iterative solution
    // Time complexity: O(n)
    // Space complexity: O(n)
    public TreeNode bstToGst2(TreeNode root) {
        int preSum = 0;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while(!st.isEmpty() || curr != null) {
            while(curr != null) {
                st.push(curr);
                curr = curr.right;
            }
            curr = st.pop();
            curr.val += preSum;
            preSum = curr.val;

            curr = curr.left;
        }
        return root;
    }
}
