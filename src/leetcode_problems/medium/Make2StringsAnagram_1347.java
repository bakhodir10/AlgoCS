package leetcode_problems.medium;

public class Make2StringsAnagram_1347 {

    // Time complexity: O(n). Space complexity: O(1)
    public int minSteps(String s, String t) {
        int[] counts = new int[26];
        int diff = 0;

        for (char c : t.toCharArray()) counts[c - 'a']++;
        for (char c : s.toCharArray()) counts[c - 'a']--;

        for (int count : counts) {
            if (count > 0) diff += count;
        }
        return diff;
    }
}
