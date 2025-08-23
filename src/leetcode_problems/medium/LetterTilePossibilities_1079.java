package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

public class LetterTilePossibilities_1079 {

    // Time complexity: O(n*n!)
    // Space complexity: O(n)
    int total = 0;
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> freqs = new HashMap<>();
        for(char c: tiles.toCharArray()) freqs.put(c, freqs.getOrDefault(c, 0) + 1);

        backtrack(freqs, new StringBuilder());
        return total - 1;
    }

    private void backtrack(Map<Character, Integer> freqs, StringBuilder curr) {
        total++;

        for(Map.Entry<Character, Integer> entry: freqs.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            if(count <= 0) continue;
            curr.append(c);
            freqs.put(c, count - 1);

            backtrack(freqs, curr);

            curr.deleteCharAt(curr.length() - 1);
            freqs.put(c, count);
        }
    }
}
