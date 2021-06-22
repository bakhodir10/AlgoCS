package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class SortCharactersByFrequency_451 {

    // Time complexity: O(n). Space complexity: O(n)
    public String frequencySort(String s) {
        int[] counts = new int[256];
        List<Character>[] bucket = new List[s.length() + 1];

        for (char c : s.toCharArray()) counts[c]++;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) continue;
            if (bucket[counts[i]] == null) bucket[counts[i]] = new ArrayList<>();
            bucket[counts[i]].add((char) i);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            List<Character> list = bucket[i];
            if (list == null) continue;
            for (char c : list) ans.append(String.valueOf(c).repeat(i));
        }
        return ans.toString();
    }
}
