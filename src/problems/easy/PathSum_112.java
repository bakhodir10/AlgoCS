package problems.easy;

// todo not done
public class PathSum_112 {
    int count = 0;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        count += root.val;
        if (root.left != null) hasPathSum(root.left, sum);
        if (root.right != null) hasPathSum(root.right, sum);
        // if (count == sum) return true;
        System.out.println("bottom");
        System.out.println(count);
        count -= root.val;
        return false;
    }

    private class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
/*
[5, 4 , 8, 11, null, 13, 4, 7, 2, null, null, null, 1]
        18
        */