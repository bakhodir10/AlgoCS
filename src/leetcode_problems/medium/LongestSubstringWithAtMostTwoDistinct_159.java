package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinct_159 {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, right = 0, max = 0;
        Map<Character, Integer> counts = new HashMap<>();

        while(right < s.length()) {
            char rc = s.charAt(right);
            counts.put(rc, counts.getOrDefault(rc, 0) + 1);

            while(counts.size() > 2) {
                char lc = s.charAt(left);
                int currCount = counts.getOrDefault(lc, 0);
                if(currCount <= 1) counts.remove(lc);
                else counts.put(lc, currCount - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    // Time complexity: O(n*60) = O(n)
    // Space complexity: O(1)
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        int left = 0, right = 0, max = 0;
        int[] counts = new int[60];

        while(right < s.length()) {

            // System.out.println(left + " " + right);

            counts[s.charAt(right) - 'A']++;

            while(!isKDistinctChars(counts)) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    private boolean isKDistinctChars(int[] counts) {
        int count = 0;

        for(int i = 0; i < 60; i++) {
            if(counts[i] > 0) count++;
            if(count > 2) return false;
        }
        return true;
    }
}
