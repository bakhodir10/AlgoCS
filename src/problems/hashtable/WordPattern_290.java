package problems.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern_290 {
    public static boolean wordPattern(String pattern, String str){
        Map<Character, String> map = new HashMap<>();
        String words[] = str.split(" ");
        if (pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            String s1 = map.get(pattern.charAt(i));
                if (s1 == null) {
                    for (Map.Entry<Character, String> entry : map.entrySet()) {
                        if (entry.getValue().equals(words[i])){
                            return false;
                        }
                    }
                    map.put(pattern.charAt(i), words[i]);
                } else {
                    if (!Objects.equals(s1, words[i])) return false;
                }
        }
        return true;
    }
}
