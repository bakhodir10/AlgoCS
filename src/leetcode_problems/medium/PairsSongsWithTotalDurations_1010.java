package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsSongsWithTotalDurations_1010 {

    // Time complexity: O(n). Space complexity: O(1)
    public int numPairsDivisibleBy60(int[] times) {
        int count = 0;
        Map<Integer, List<Integer>> cache = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            List<Integer> list = cache.getOrDefault(times[i] % 60, new ArrayList<>());
            list.add(i);
            cache.put(times[i] % 60, list);
        }

        for (int i = 0; i < times.length; i++) {
            List<Integer> indexes = cache.get((60 - times[i] % 60) % 60);

            if (indexes == null) continue;

            for (int index : indexes) {
                if (i < index) count++;
            }
        }
        return count;
    }
}
