package leetcode_problems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Approach. Brute Force Solution. This will get TLE
public class PrefixAndSuffixSearch2_745 {

    private final List<String> cache;

    public PrefixAndSuffixSearch2_745(String[] words) {
        this.cache = new ArrayList<>();
        cache.addAll(Arrays.asList(words));
    }

    public int f(String prefix, String suffix) {
        int max = Integer.MIN_VALUE;
        int idx = 0;

        for (String word : cache) {
            if (word.startsWith(prefix) && word.endsWith(suffix)) max = idx;
            idx++;
        }
        return max;
    }
}
