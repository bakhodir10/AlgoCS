package leetcode_problems.medium;

import java.util.*;

public class ReportSpamMessage_3295 {

    // Time complexity: O(n + m) where n is the length of the messages and m is the length of bannedWords
    // Space complexity: O(m) where m is the length of the banned words.
    public boolean reportSpam(String[] messages, String[] bannedWords) {
        Set<String> banWords = new HashSet<>(Arrays.asList(bannedWords));
        boolean seen = false;
        for(String s: messages) {
            if(banWords.contains(s)) {
                if (seen) return true;
                seen = true;
            }
        }
        return false;
    }

    // Time complexity: O(n + m) where n is the length of the messages and m is the length of bannedWords
    // Space complexity: O(n + m) where m is the length of the banned words.
    public boolean reportSpam2(String[] messages, String[] bannedWords) {
        int count = 0;
        Map<String, Integer> msgs = new HashMap<>();
        Set<String> banWords = new HashSet<>(Arrays.asList(bannedWords));

        for(String m: messages) msgs.put(m,  msgs.getOrDefault(m, 0) + 1);

        for(String s: banWords) {
            if(msgs.containsKey(s)) count += msgs.get(s);
            if(count >= 2) return true;
        }

        return false;
    }
}
