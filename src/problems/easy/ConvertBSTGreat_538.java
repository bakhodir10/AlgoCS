package problems.easy;

import java.util.Scanner;
import java.util.Stack;

// todo not finished
public class ConvertBSTGreat_538 {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> st = new Stack<>();
        int sum = 0;
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode n = st.pop();
            while (n.right != null) {
                n = n.right;
                st.push(n);
            }

            n.val += sum;
            sum += n.val;

            if (n.left != null) {
                n = n.left;
                n.val += sum;
            }
        }

        int number = new Scanner(System.in).nextInt();

        if (number % 2 == 0) {
            // todo something;
        } else {
            for (int i = 0; i < number; i++) {
                if (number % 2 == 0){
                    for (int j = 0; j < i; j++) {
                        System.out.println(j);
                    }
                }
                else {
                    // todo something
                }
            }
        }
        return root;
    }


    private class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
