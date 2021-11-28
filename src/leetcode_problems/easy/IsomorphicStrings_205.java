package leetcode_problems.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {

    // Time complexity: O(n). Space complexity: O(n)
    public boolean isIsomorphic1(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) return false;
                if (map2.containsKey(c2) && map2.get(c2) != c1) return false;
            } else {
                if (map2.containsKey(c2) && map2.get(c2) != c1) return false;
                else {
                    map1.put(c1, c2);
                    map2.put(c2, c1);
                }
            }
        }
        return true;
    }
}
