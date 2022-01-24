package leetcode_problems.medium;

import java.util.*;

public class FriendCircles_547 {

    // Approach 1. Union Find. Time complexity: O(n^2)
    public int findCircleNum(int[][] m) {
        Set<Integer> circles = new HashSet<>();
        UnionFind uf = new UnionFind(m);

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 1 && i != j) uf.union(i, j);
            }
        }

        for (int i = 0; i < m.length; i++) circles.add(uf.find(i));

        return circles.size();
    }

    private static class UnionFind {
        private final Map<Integer, Integer> mappings;
        private final Map<Integer, Integer> ranks;

        // Time complexity: O(n)
        public UnionFind(int[][] edges) {
            this.mappings = new HashMap<>();
            this.ranks = new HashMap<>();

            for (int i = 0; i < edges.length; i++) {
                this.mappings.put(i, i);
                this.ranks.put(i, 1);
            }
        }

        // Union - Optimized by ranking. Time complexity: O(1)
        public void union(int a, int b) {
            int parentOfA = find(a);
            int parentOfB = find(b);

            if (parentOfA == parentOfB) return;

            if (ranks.get(parentOfA) > ranks.get(parentOfB)) {
                mappings.put(parentOfB, parentOfA);
            } else if (ranks.get(parentOfA) < ranks.get(parentOfB)) {
                mappings.put(parentOfA, parentOfB);
            } else if (ranks.get(parentOfA) == ranks.get(parentOfB)) {
                mappings.put(parentOfA, parentOfB);
                ranks.put(parentOfA, ranks.get(parentOfA) + 1);
            }
        }

        // Find - Optimized with path compression. Time complexity: O(1)
        public int find(int a) {
            List<Integer> path = new ArrayList<>();
            while (mappings.get(a) != a) {
                path.add(a);
                a = mappings.get(a);
            }
            for (int v : path) mappings.put(v, a);
            return a;
        }
    }

    // Approach 2. Grouping friend circles
    public int findCircleNum2(int[][] m) {
        int groupNum = 2;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 1) dfs(m, i, groupNum++);
            }
        }
        return groupNum - 2;
    }

    private void dfs(int[][] m, int person, int groupNum) {
        for (int friend = 0; friend < m[person].length; friend++) {
            if (m[person][friend] == 1) {
                m[person][friend] = groupNum;
                dfs(m, friend, groupNum);
            }
        }
    }

    // Approach 3. Marking as visited after each row visit
    public int findCircleNum3(int[][] m) {
        boolean[] visited = new boolean[m.length];
        int count = 0;

        for (int i = 0; i < m.length; i++) {
            if (!visited[i]) {
                dfs(m, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m, boolean[] visited, int person) {
        for (int friend = 0; friend < m[person].length; friend++) {
            if (!visited[friend] && m[person][friend] == 1) {
                visited[friend] = true;
                dfs(m, visited, friend);
            }
        }
    }
}
