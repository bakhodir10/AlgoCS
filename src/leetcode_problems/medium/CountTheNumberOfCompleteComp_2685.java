package leetcode_problems.medium;

import java.util.*;

public class CountTheNumberOfCompleteComp_2685 {

    // Approach 1st. Using DFS
    // Time complexity: O(n + m)
    public int countCompleteComponents(int n, int[][] edges) {
        int count = 0;
        Map<Integer, List<Integer>> mappings = new HashMap<>();

        for (int i = 0; i < n; i++) mappings.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            mappings.get(edge[0]).add(edge[1]);
            mappings.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                List<Integer> comp = new ArrayList<>();
                dfs(mappings, i, visited, comp);

                int componentSize = comp.size();
                boolean found = false;
                for (int co : comp) {
                    if (mappings.get(co).size() != componentSize - 1) {
                        found = true;
                        break;
                    }
                }
                if (!found) count++;
            }
        }
        return count;
    }

    private void dfs(Map<Integer, List<Integer>> mappings, int key,
                     Set<Integer> visited, List<Integer> comp) {
        visited.add(key);
        comp.add(key);
        List<Integer> neighbors = mappings.get(key);
        for (int v : neighbors) {
            if (!visited.contains(v)) {
                dfs(mappings, v, visited, comp);
            }
        }
    }
}
