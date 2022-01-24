package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphValidTree_261 {

    // Union Find. Time complexity: O(n)
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) return false;
        }

        int root = uf.find(0);

        for (int i = 1; i < n; i++) {
            if (uf.find(i) != root) return false;
        }
        return true;
    }

    private static class UnionFind {
        private final Map<Integer, Integer> mappings;
        private final Map<Integer, Integer> rankings;

        // Time complexity: O(n)
        public UnionFind(int n) {
            this.mappings = new HashMap<>();
            this.rankings = new HashMap<>();

            for (int i = 0; i < n; i++) {
                this.mappings.put(i, i);
                this.rankings.put(i, 1);
            }
        }

        // Union - Optimized by ranking. Time complexity: O(1)
        public boolean union(int a, int b) {
            int parentOfA = find(a);
            int parentOfB = find(b);

            if (parentOfA == parentOfB) return false;

            if (this.rankings.get(parentOfA) > this.rankings.get(parentOfB)) {
                this.mappings.put(parentOfB, parentOfA);
            } else if (this.rankings.get(parentOfA) < this.rankings.get(parentOfB)) {
                this.mappings.put(parentOfA, parentOfB);
            } else {
                this.mappings.put(parentOfA, parentOfB);
                this.rankings.put(parentOfB, this.rankings.get(parentOfB) + 1);
            }

            return true;
        }

        // Find - Optimized with path compression. Time complexity: O(1)
        public int find(int a) {
            List<Integer> list = new ArrayList<>();
            while (mappings.get(a) != a) {
                list.add(a);
                a = mappings.get(a);
            }
            for (int v : list) this.mappings.put(v, a);
            return a;
        }
    }
}
