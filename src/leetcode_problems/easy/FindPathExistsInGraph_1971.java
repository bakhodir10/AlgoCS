package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPathExistsInGraph_1971 {

    // DFS. Time complexity: O(V + E). Space complexity: O(V)
    public boolean validPath1(int n, int[][] edges, int start, int end) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            List<Integer> children1 = map.get(edge[0]);
            List<Integer> children2 = map.get(edge[1]);
            children1.add(edge[1]);
            children2.add(edge[0]);
            map.put(edge[0], children1);
            map.put(edge[1], children2);
        }

        boolean[] visited = new boolean[n];
        return dfs(map, start, end, visited);
    }

    private boolean dfs(Map<Integer, List<Integer>> map, int curr, int des, boolean[] visited) {
        if (curr == des) return true;

        List<Integer> children = map.get(curr);

        visited[curr] = true;

        for (int child : children) {
            if (!visited[child]) {
                boolean res = dfs(map, child, des, visited);
                if (res) return true;
            }
        }
        return false;
    }

    // Union Find. Time complexity: O(n). Space complexity: O(n)
    public boolean validPath2(int n, int[][] edges, int start, int end) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) uf.union(edge[0], edge[1]);
        return uf.find(start) == uf.find(end);
    }

    private static class UnionFind {
        private final Map<Integer, Integer> mappings;
        private final Map<Integer, Integer> rankings;

        public UnionFind(int n) {
            this.mappings = new HashMap<>();
            this.rankings = new HashMap<>();

            for (int i = 0; i < n; i++) {
                mappings.put(i, i);
                rankings.put(i, 1);
            }
        }

        public void union(int a, int b) {
            int parentOfA = find(a);
            int parentOfB = find(b);

            if (parentOfA == parentOfB) return;

            if (rankings.get(parentOfA) > rankings.get(parentOfB)) {
                mappings.put(parentOfB, parentOfA);
            } else if (rankings.get(parentOfA) < rankings.get(parentOfB)) {
                mappings.put(parentOfA, parentOfB);
            } else {
                mappings.put(parentOfA, parentOfB);
                rankings.put(parentOfB, rankings.get(parentOfB) + 1);
            }
        }

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
