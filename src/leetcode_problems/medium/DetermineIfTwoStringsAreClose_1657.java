package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

public class DetermineIfTwoStringsAreClose_1657 {

    // Time complexity: O(n + m)
    // Space complexity: O(1)
    public boolean closeStrings(String word1, String word2) {

        // cabbba -> a:2, b:3, c:1
        // abbccc -> a:1, b:2, c:3 -> a:1, b:3, c:2 -> a:2, b:3, c:1

        int[] counts1 = new int[26];
        int[] counts2 = new int[26];

        for(int i = 0; i < word1.length(); i ++) counts1[word1.charAt(i) - 'a']++;
        for(int i = 0; i < word2.charAt(i); i ++) counts2[word2.charAt(i) - 'a']++;

        for(int i = 0; i < 26; i++) {
            if(counts1[i] != 0 && counts2[i] == 0 || counts1[i] == 0 && counts2[i] != 0) {
                return false;
            }
        }

        Map<Integer, Integer> freqs = new HashMap<>(26);
        for (int j : counts1) {
            if (j != 0) freqs.put(j, freqs.getOrDefault(j, 0) + 1);
        }

        for (int j : counts2) {
            if (j != 0) {
                if (!freqs.containsKey(j)) return false;
                freqs.put(j, freqs.get(j) - 1);
                if (freqs.get(j) == 0) freqs.remove(j);
            }
        }
        return freqs.isEmpty();
    }
}
