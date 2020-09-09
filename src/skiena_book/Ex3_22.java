package skiena_book;

public class Ex3_22 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(18);

        ListNode node = convertBSTIntoList(root);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode convertBSTIntoList(TreeNode root) {
        ListNode dummy = new ListNode(-1);
        helper(dummy, root);
        return dummy;
    }

    private static void helper(ListNode node, TreeNode root) {
        if (root != null) {
            node.next = new ListNode(root.val);
            helper(node.next, root.left);
            helper(node.next, root.right);
        }
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
