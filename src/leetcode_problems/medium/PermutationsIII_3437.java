package leetcode_problems.medium;

import java.util.*;

public class PermutationsIII_3437 {

    private final List<List<Integer>> res = new ArrayList<>();
    private final List<Integer> subRes = new LinkedList<>();

    // Time complexity: O(n * n!)
    // Space complexity: O(n)
    public int[][] permute(int n) {
        Set<Integer> used = new HashSet<>();
        backtrack(n, used);

        return res.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    private void backtrack(int n, Set<Integer> used) {
        if(subRes.size() == n) {
            res.add(new LinkedList<>(subRes));
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(used.contains(i)) continue;
            if (!subRes.isEmpty()) {
                int last = subRes.getLast();
                if ((i % 2 == 0 && last % 2 == 0) || (i % 2 == 1 && last % 2 == 1)) continue;
            }

            used.add(i);
            subRes.add(i);

            backtrack(n, used);

            used.remove(i);
            subRes.removeLast();
        }
    }
}
