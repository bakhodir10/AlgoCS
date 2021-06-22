package problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingActiveMinutes_1817 {

    // Time complexity: O(n). Space complexity: O(n)
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> uam = new HashMap<>();

        for (int[] log : logs) {
            Set<Integer> uniqueUam = uam.getOrDefault(log[0], new HashSet<>());
            uniqueUam.add(log[1]);
            uam.put(log[0], uniqueUam);
        }
        int[] res = new int[k];
        for (Set<Integer> uniqueUam : uam.values()) res[uniqueUam.size() - 1]++;
        return res;
    }
}
