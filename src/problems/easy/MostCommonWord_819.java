package problems.easy;

import java.util.*;

public class MostCommonWord_819 {
    
    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        paragraph = paragraph.toLowerCase();
        String words[] = paragraph.split(" ");
        Map<String, Integer> result = new HashMap<>();

        for (String word : words) {
            if (word.contains("!") || word.contains("?") || word.contains("'")
                    || word.contains(",") || word.contains(";") || word.contains(".")) {
                word = word.substring(0, word.length() - 1);
            }
            if (result.containsKey(word)) {
                int count = result.get(word);
                result.put(word, ++count);
            } else result.put(word, 1);

            if (bannedWords.contains(word)) result.remove(word);
        }
        String ans = "";
        int count = 0;
        for (Map.Entry<String, Integer> m : result.entrySet()) {
            if (m.getValue() > count) {
                ans = m.getKey();
                count = m.getValue();
            }
        }
        return ans;
    }
}
