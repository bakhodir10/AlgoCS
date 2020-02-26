package problems.medium;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImplementMagicDict_676 {

    /**
     * Initialize your data structure here.
     */
    private Set<String> dictionary = new HashSet<>();

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        Collections.addAll(dictionary, dict);
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        for (String dictWord : dictionary) {
            if (dictWord.length() != word.length()) continue;
            int diff = 0;
            for (int i = 0; i < dictWord.length(); i++) {
                if (dictWord.charAt(i) != word.charAt(i)) diff++;
            }
            if (diff == 1) return true;
        }
        return false;
    }
}
