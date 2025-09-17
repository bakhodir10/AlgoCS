package leetcode_problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VowelSpellchecker_966 {

    private final Set<Character> VOWELS = new HashSet<>(
            Set.of('a', 'e', 'i', 'o', 'u',
                    'A', 'E', 'I', 'O', 'U')
    );
    Set<String> matches;
    Map<String, String> lowercases;
    Map<String, String> vowelErrors;

    // Time complexity: O(n*m)
    // Space complexity: O(n*m)
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] result = new String[queries.length];
        matches = new HashSet<>();
        lowercases = new HashMap<>();
        vowelErrors = new HashMap<>();

        for(String word: wordlist) {
            matches.add(word);
            lowercases.putIfAbsent(word.toLowerCase(), word);
            String devowedS = devow(word);
            vowelErrors.putIfAbsent(devowedS, word);
        }

        for(int i = 0; i < queries.length; i ++) {
            String subRes = solve(queries[i]);
            result[i] = subRes;
        }
        return result;
    }

    private String solve(String query) {
        if(matches.contains(query)) {
            return query;
        }
        if(lowercases.containsKey(query.toLowerCase())) {
            return lowercases.get(query.toLowerCase());
        }

        String devowedS = devow(query);
        if(vowelErrors.containsKey(devowedS)) {
            return vowelErrors.get(devowedS);
        }
        return "";
    }

    private String devow(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(VOWELS.contains(c)) sb.append("*");
            else sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}
