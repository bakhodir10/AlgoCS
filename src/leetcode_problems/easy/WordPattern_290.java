package leetcode_problems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern_290 {

    // n -> pattern length
    // m -> str length
    // Time complexity: O(n + m^2) ~= O(n + n^2) = O(n^2)
    // Space complexity: O(n + m) ~= O(n)
    public static boolean wordPattern(String pattern, String str){
        Map<Character, String> map = new HashMap<>();
        String[] words = str.split(" ");
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

    // n -> pattern length
    // m -> str length
    // Time complexity: O(n + m) ~= O(n + n) = O(n)
    // Space complexity: O(n + m) ~= O(n)
    public boolean wordPattern2(String pattern, String s) {
        Map<Character, String> cToWord = new HashMap<>();
        Map<String, Character> wordToC = new HashMap<>();
        String[] words = s.split(" ");
        char[] c = pattern.toCharArray();

        if(words.length != c.length) return false;

        for(int i = 0; i < c.length; i ++) {
            if(cToWord.containsKey(c[i])) {
                String word = cToWord.get(c[i]);
                if(!word.equals(words[i])) return false;
            } else {
                if(wordToC.containsKey(words[i])) return false;
                cToWord.put(c[i], words[i]);
                wordToC.put(words[i], c[i]);
            }
        }
        return true;
    }
}
