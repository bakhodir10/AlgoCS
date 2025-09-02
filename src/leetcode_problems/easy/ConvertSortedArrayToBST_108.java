package leetcode_problems.easy;

public class ConvertSortedArrayToBST_108 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    // Time complexity: O(N)
    // Space complexity: O(N)
    private TreeNode helper(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid - 1);
        node.right = helper(nums, mid + 1, end);

        return node;
    }
}
