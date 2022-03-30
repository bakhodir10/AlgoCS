package leetcode_problems.medium;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal_314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Map<TreeNode, Pair> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<int[]> pQ = new PriorityQueue<>((e1, e2) -> {
            // col, row, val, order
            if (e1[0] == e2[0]) { // col
                if (e1[1] == e2[1]) { // row
                    return e1[3] - e2[3]; // order
                }
                return e1[1] - e2[1];
            }
            return e1[0] - e2[0];
        });

        q.offer(root);
        map.put(root, new Pair(0, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int order = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                Pair p = map.get(node);
                pQ.offer(new int[]{p.col, p.row, node.val, order++});

                if (node.left != null) {
                    q.offer(node.left);
                    map.put(node.left, new Pair(p.row + 1, p.col - 1));
                }
                if (node.right != null) {
                    q.offer(node.right);
                    map.put(node.right, new Pair(p.row + 1, p.col + 1));
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!pQ.isEmpty()) {
            int[] rcv = pQ.poll();
            List<Integer> layer = new ArrayList<>();
            layer.add(rcv[2]);

            while (!pQ.isEmpty() && pQ.peek()[0] == rcv[0]) {
                layer.add(pQ.poll()[2]);
            }
            ans.add(layer);
        }
        return ans;
    }


    record Pair(int row, int col) {
    }

    record TreeNode(int val, TreeNode left, TreeNode right) {
    }
}
