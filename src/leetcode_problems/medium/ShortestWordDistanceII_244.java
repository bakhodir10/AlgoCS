package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII_244 {

    private final Map<String, List<Integer>> cache;

    // Time complexity(N). Space complexity: O(N)
    public ShortestWordDistanceII_244(String[] wordsDict) {
        this.cache = new HashMap<>();

        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            List<Integer> indexes = cache.getOrDefault(word, new ArrayList<>());
            indexes.add(i);
            this.cache.put(word, indexes);
        }
    }

    // Time complexity(O(K + L). Space complexity: O(n)
    public int shortest(String word1, String word2) {
        List<Integer> indexes1 = this.cache.get(word1);
        List<Integer> indexes2 = this.cache.get(word2);

        int p1 = 0, p2 = 0, min = Integer.MAX_VALUE;

        while (p1 < indexes1.size() && p2 < indexes2.size()) {
            min = Math.min(min, Math.abs(indexes1.get(p1) - indexes2.get(p2)));

            if (indexes1.get(p1) < indexes2.get(p2)) p1++;
            else p2++;
        }
        return min;
    }
}
