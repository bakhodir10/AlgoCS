package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class RedundantConnection_684 {
    
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges);

        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) return edge;
        }
        return null;
    }

    // a class UnionFind to create connections
    private class UnionFind {
        private final Map<Integer, Integer> nodeWithParent;

        public UnionFind(int[][] edges) {
            this.nodeWithParent = new HashMap<>();

            // set vertices to be parent of its own
            for (int[] edge : edges) {
                nodeWithParent.put(edge[0], edge[0]);
                nodeWithParent.put(edge[1], edge[1]);
            }
        }

        public boolean union(int a, int b) {
            int parentOfA = find(a);
            int parentOfB = find(b);
            if (parentOfA == parentOfB)
                return false;    // checking if components are connected. if yes, union is unsuccessful
            nodeWithParent.put(parentOfA, parentOfB);    // connect two components
            return true;
        }

        private int find(int node) {
            if (nodeWithParent.get(node) != node) return find(nodeWithParent.get(node));
            else return node;
        }
    }
}