package leetcode_problems.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RingsRods_5952 {

    // Time complexity: O(n). Space complexity: O(n)
    public int countPoints(String rings) {
        Map<Integer, Set<Character>> map = new HashMap<>();

        for (int i = 0; i < rings.length() - 1; i += 2) {
            Set<Character> rods = map.getOrDefault(rings.charAt(i + 1) - '0', new HashSet<>());
            rods.add(rings.charAt(i));
            map.put(rings.charAt(i + 1) - '0', rods);
        }

        int count = 0;
        for (Map.Entry<Integer, Set<Character>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 3) count++;
        }
        return count;
    }
}