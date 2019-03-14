package problems.medium;

import java.util.Arrays;
import java.util.List;

// todo not done
public class WordBreak_139 {

    public static void main(String[] args) {
        wordBreak("leetcode", Arrays.asList("leet", "code"));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {

        for (String word : wordDict) {
            System.out.println("word: " + word);

            while (s.contains(word)) {
                int index = s.indexOf(word);
                System.out.println("s1: " + s);
                System.out.println("index: " + index);
                String temp = s.substring(0, index);
                s = temp + s.substring(index + word.length());
                System.out.println("s2: " + s);
            }
        }
        return s.isEmpty();
    }
}
