package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class AllElementsTwoBST_1305 {

    // Time complexity: O(n1 + n2). Space complexity: O(n1 + n2)
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inOrder(list1, root1);
        inOrder(list2, root2);
        return merge(list1, list2);
    }

    private void inOrder(List<Integer> list, TreeNode root) {
        if (root != null) {
            inOrder(list, root.left);
            list.add(root.val);
            inOrder(list, root.right);
        }
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        int i = 0, j = 0;
        int size1 = list1.size(), size2 = list2.size();
        List<Integer> result = new ArrayList<>(size1 + size2);

        while (i < size1 || j < size2) {
            if (i < size1 && j < size2) {
                if (list1.get(i) > list2.get(j)) result.add(list2.get(j++));
                else result.add(list1.get(i++));
            } else if (i < size1) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }
        return result;
    }

    private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;
    }
}
