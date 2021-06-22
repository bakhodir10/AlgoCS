package leetcode_problems.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar_387 {

    //version 1
    public static int firstUniqueChar1(String s) {
        int[] arr = new int[26];

        for (char c : s.toCharArray()) arr[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

    // version 2
    public int firstUniqueChar2(String s) {
        if (s == null) return -1;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int t = map.get(s.charAt(i));
                map.put(s.charAt(i), ++t);
            } else map.put(s.charAt(i), 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
