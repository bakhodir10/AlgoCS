package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams_438 {

    // Time complexity: O(s.length + p.length). Space complexity: O(n)
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256];
        int left = 0, count = p.length();

        for (char c : p.toCharArray()) hash[c]++;

        for (int right = 0; right < s.length(); right++) {
            if (hash[s.charAt(right)] > 0) count--;
            hash[s.charAt(right)]--;

            if (count == 0) list.add(left);

            if (right >= p.length() - 1) {
                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0) count++;
                left++;
            }
        }
        return list;
    }

    // Time complexity: O(s.length + p.length). Space complexity: O(n)
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] counts = new int[26];
        int left = 0;

        for (char c : p.toCharArray()) counts[c - 'a']++;

        for (int right = 0; right < s.length(); right++) {
            counts[s.charAt(right) - 'a']--;
            if (isZero(counts)) list.add(left);
            if (right >= p.length() - 1) counts[s.charAt(left++) - 'a']++;
        }
        return list;
    }

    private boolean isZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }
}