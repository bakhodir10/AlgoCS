package leetcode_problems.medium;

import java.util.*;

public class NumberOfUniqueCategories_2782 {

    interface CategoryHandler {
        boolean haveSameCategory(int a, int b);
    }

    public int numberOfCategories(int n, CategoryHandler categoryHandler) {
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (categoryHandler.haveSameCategory(i, j)) uf.union(i, j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(uf.find(i));

        return set.size();
    }

    private static class UnionFind {
        private final Map<Integer, Integer> parents;
        private final Map<Integer, Integer> ranks;

        public UnionFind(int n) {
            this.parents = new HashMap<>();
            this.ranks = new HashMap<>();

            for (int i = 0; i < n; i++) {
                parents.put(i, i);
                ranks.put(i, 0);
            }
        }

        public void union(int a, int b) {
            int parentOfA = find(a);
            int parentOfB = find(b);

            if (parentOfA == parentOfB) return;

            if (ranks.get(parentOfA) < ranks.get(parentOfB)) {
                parents.put(parentOfA, parentOfB);
            } else if (ranks.get(parentOfA) > ranks.get(parentOfB)) {
                parents.put(parentOfB, parentOfA);
            } else {
                parents.put(parentOfA, parentOfB);
                ranks.put(parentOfB, ranks.get(parentOfB) + 1);
            }
        }

        public int find(int a) {
            List<Integer> path = new ArrayList<>();
            while (parents.get(a) != a) {
                path.add(a);
                a = parents.get(a);
            }
            for (int p : path) parents.put(p, a);
            return a;
        }
    }
}
