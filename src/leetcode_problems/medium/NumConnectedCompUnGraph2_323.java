package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumConnectedCompUnGraph2_323 {

    // Union Find. Time complexity: O(n). Space complexity: (1)
    public int countComponents(int n, int[][] edges) {
        int count = n;
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) count--;
        }
        return count;
    }

    private static class UnionFind {
        private final Map<Integer, Integer> mappings;
        private final Map<Integer, Integer> ranks;

        public UnionFind(int n) {
            this.mappings = new HashMap<>();
            this.ranks = new HashMap<>();

            for (int i = 0; i < n; i++) {
                this.mappings.put(i, i);
                this.ranks.put(i, 1);
            }
        }

        // Union - Optimized by ranking. Time complexity: O(1)
        public boolean union(int a, int b) {
            int parentOfA = find(a);
            int parentOfB = find(b);

            if (parentOfA == parentOfB) return false;

            if (ranks.get(parentOfA) > ranks.get(parentOfB)) {
                mappings.put(parentOfB, parentOfA);
            } else if (ranks.get(parentOfA) < ranks.get(parentOfB)) {
                mappings.put(parentOfA, parentOfB);
            } else if (ranks.get(parentOfA) == ranks.get(parentOfB)) {
                mappings.put(parentOfA, parentOfB);
                ranks.put(parentOfA, ranks.get(parentOfA) + 1);
            }
            return true;
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