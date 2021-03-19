package problems.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {

    // Time complexity: O(n). Space complexity: O(1)
    public int romanToInt(String s) {
        int i = 0;
        int total = 0;
        Map<String, Integer> map = new HashMap<>() {{
            put("I", 1);
            put("IV", 4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
        }};

        while (i < s.length()) {
            if (i + 2 <= s.length() && map.containsKey(s.substring(i, i + 2))) {
                total += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                total += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return total;
    }
}