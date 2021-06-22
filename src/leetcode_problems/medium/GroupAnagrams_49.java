package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> mapOfCanonical = new HashMap<>();

        for (String s : strs) {
            String canonical = getCanonical(s);
            List<String> list = mapOfCanonical.get(canonical);
            if (list == null) mapOfCanonical.put(canonical, list = new ArrayList<>());
            list.add(s);
        }
        return new ArrayList<>(mapOfCanonical.values());
    }

    private static String getCanonical(String str) {
        int charCount[] = new int[26];
        StringBuilder canonical = new StringBuilder();
        for (char c : str.toCharArray()) charCount[c - 'a']++;
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] != 0) {
                canonical.append((char) (i + 'a'));
                canonical.append(charCount[i]);
            }
        }
        return canonical.toString();
    }
}
