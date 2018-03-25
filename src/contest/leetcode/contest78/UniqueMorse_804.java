package contest.leetcode.contest78;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorse_804 {
    public static int uniqueMorseRepresentations(String[] words) {
        if (words.length == 0) return 0;
        Map<Character, String> map = new HashMap<>();

        String w[] = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--."
                , "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (int i = 0; i < w.length; i++) map.put((char) (i + 'a'), w[0]);

        String s[] = new String[words.length];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            s[i] = "";
            for (int j = 0; j < words[i].length(); j++) {
                String temp = map.get(words[i].charAt(j));
                s[i] = s[i].concat(temp);
            }
            set.add(s[i]);
        }

        return set.size();
    }
}
