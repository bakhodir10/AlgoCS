package leetcode_problems.easy;

import java.util.HashSet;
import java.util.Set;

public class MaxNumOfWordsYouCanType_1935 {

    // Time complexity: O(n + m)
    // Space complexity: O(n + m)
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();

        for(char c: brokenLetters.toCharArray()) broken.add(c);

        int count = 0;
        String[] words = text.split(" ");
        for(String word: words) {
            boolean isInvalid = false;
            for(char c: word.toCharArray()) {
                if(broken.contains(c)) {
                    isInvalid = true;
                    break;
                }
            }
            if(!isInvalid) count++;
        }
        return count;
    }
}
