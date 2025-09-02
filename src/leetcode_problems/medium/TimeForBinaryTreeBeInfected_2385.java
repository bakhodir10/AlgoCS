package leetcode_problems.medium;

import java.util.*;

public class TimeForBinaryTreeBeInfected_2385 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        convert(root, map);

        int time = 0;
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> seen = new HashSet<>();
        seen.add(start);

        q.offer(start);
        while(!q.isEmpty()) {
            int levelSize = q.size();

            for(int i = 0; i < levelSize; i++) {
                int curr = q.poll();
                List<Integer> adjacents = map.getOrDefault(curr, new ArrayList<>());
                for(int ad: adjacents) {
                    if(!seen.contains(ad)) {
                        seen.add(ad);
                        q.offer(ad);
                    }
                }
            }
            time++;
        }
        return time - 1;
    }

    private void convert(TreeNode root, Map<Integer, List<Integer>> map) {
        Map<Integer, Integer> childToParent = new HashMap<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i ++) {
                TreeNode node = q.poll();
                List<Integer> neighbors = map.getOrDefault(node.val, new ArrayList<>());
                if(node.left != null) {
                    q.offer(node.left);
                    neighbors.add(node.left.val);
                    childToParent.put(node.left.val, node.val);
                }
                if(node.right != null) {
                    q.offer(node.right);
                    neighbors.add(node.right.val);
                    childToParent.put(node.right.val, node.val);
                }
                if(childToParent.containsKey(node.val)) {
                    neighbors.add(childToParent.get(node.val));
                }
                if(!neighbors.isEmpty())  map.put(node.val, neighbors);
            }
        }
    }
}
