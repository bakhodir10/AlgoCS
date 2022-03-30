package leetcode_problems.hard;

import java.util.*;

public class VerticalOrderTraversalBT_987 {

    // Time complexity: O(n). Space complexity: O(n)
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<TreeNode, Pair> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<int[]> pQ = new PriorityQueue<>((e1, e2) -> {
            // col, row, val
            if (e1[0] == e2[0]) { // col
                if (e1[1] == e2[1]) { // row
                    return e1[2] - e2[2]; // val
                }
                return e1[1] - e2[1];
            }
            return e1[0] - e2[0];
        });

        q.offer(root);
        map.put(root, new Pair(0, 0));

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            Pair p = map.get(node);
            pQ.offer(new int[]{p.col, p.row, node.val});

            if (node.left != null) {
                q.offer(node.left);
                map.put(node.left, new Pair(p.row + 1, p.col - 1));
            }
            if (node.right != null) {
                q.offer(node.right);
                map.put(node.right, new Pair(p.row + 1, p.col + 1));
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

    record Pair(int row, int col) { }

    record TreeNode(int val, TreeNode left, TreeNode right) { }
}
