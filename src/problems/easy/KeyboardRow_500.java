package problems.easy;

import java.util.*;

public class KeyboardRow_500 {

    // Time complexity: O(n). Space complexity: O(n)
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        Set<Character> c1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> c2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> c3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

        for (String word : words) {
            boolean a = false;
            boolean b = false;
            boolean c = false;

            for (char ch : word.toCharArray()) {
                char cIgnore = Character.toLowerCase(ch);
                if (c1.contains(cIgnore)) a = true;
                if (c2.contains(cIgnore)) b = true;
                if (c3.contains(cIgnore)) c = true;
            }
            if (a && !b && !c) res.add(word);
            else if (b && !a && !c) res.add(word);
            else if (c && !a && !b) res.add(word);
        }
        return res.toArray(String[]::new);
    }
}
