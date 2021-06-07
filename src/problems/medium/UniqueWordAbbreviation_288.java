package problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbreviation_288 {

    private final Map<String, Set<String>> abbs;

    public UniqueWordAbbreviation_288(String[] dictionary) {
        this.abbs = new HashMap<>();

        for (String dict : dictionary) {
            String abb = dict.length() > 2 ? getAbbreviation(dict) : dict;
            Set<String> words = this.abbs.getOrDefault(abb, new HashSet<>());
            if(words.size() > 1) continue;
            words.add(dict);
            this.abbs.put(abb, words);
        }
    }

    // Time complexity: O(n -> word's length). Space complexity: O(m - map's size)
    public boolean isUnique(String word) {
        String abb = word.length() > 2 ? getAbbreviation(word) : word;

        if (!this.abbs.containsKey(abb)) return true;
        else return this.abbs.get(abb).size() == 1 && this.abbs.get(abb).contains(word);
    }

    private String getAbbreviation(String word) {
        return word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
    }
}
