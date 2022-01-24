package leetcode_problems.medium;

import java.util.*;

public class NumConnectedCompUnGraph_323 {

    // Union Find. Time complexity: O(n). Space complexity: (n)
    public int countComponents(int n, int[][] edges) {
        Set<Integer> components = new HashSet<>();
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) uf.union(edge[0], edge[1]);
        for (int i = 0; i < n; i++) components.add(uf.find(i));

        return components.size();
    }

    private static class UnionFind {
        private final Map<Integer, Integer> mappings;
        private final Map<Integer, Integer> ranks;

        // Time complexity: O(n)
        public UnionFind(int n) {
            this.mappings = new HashMap<>();
            this.ranks = new HashMap<>();

            for (int i = 0; i < n; i++) {
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
}
