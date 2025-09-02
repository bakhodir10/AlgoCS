package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinct_340 {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0, right = 0, max = 0;
        Map<Character, Integer> counts = new HashMap<>();

        while(right < s.length()) {
            char rightC = s.charAt(right);
            counts.put(rightC, counts.getOrDefault(rightC, 0) + 1);

            while(counts.size() > k) {
                char leftC = s.charAt(left);

                int currCount = counts.getOrDefault(leftC, 0);
                if(currCount <= 1) counts.remove(leftC);
                else counts.put(leftC, currCount - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    // Time complexity: O(n*256) = O(n)
    // Space complexity: O(1)
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        int left = 0, right = 0, max = 0;
        int[] counts = new int[256];

        while(right < s.length()) {
            counts[s.charAt(right)]++;

            while(!isKDistinctChars(counts, k)) {
                counts[s.charAt(left)]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    private boolean isKDistinctChars(int[] counts, int k) {
        int count = 0;
        for(int i = 0; i < 256; i++) {
            if(counts[i] > 0) count++;
            if(count > k) return false;
        }
        return true;
    }
}
