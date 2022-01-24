package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

// Approach 2: Quick Find algorithm
public class RedundantConnection2_684 {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges);

        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) return edge;
        }
        return null;
    }

    // a class UnionFind to create connections
    private static class UnionFind {
        private final Map<Integer, Integer> nodeWithParent;

        // Time complexity: O(n)
        public UnionFind(int[][] edges) {
            this.nodeWithParent = new HashMap<>();

            // set vertices to be a parent of its own
            for (int[] edge : edges) {
                nodeWithParent.put(edge[0], edge[0]);
                nodeWithParent.put(edge[1], edge[1]);
            }
        }

        // Time complexity: O(n)
        public boolean union(int a, int b) {
            int parentOfA = find(a);
            int parentOfB = find(b);
            if (parentOfA == parentOfB) return false;    // checking if components are connected. if yes, union is unsuccessful

            // connect two components
            for (int vertex : nodeWithParent.keySet()) {
                if (nodeWithParent.get(vertex) == parentOfB) nodeWithParent.put(vertex, parentOfA);
            }
            return true;
        }

        // Quick Find. Time complexity: O(1)
        private int find(int node) {
            return nodeWithParent.get(node);
        }
    }
}