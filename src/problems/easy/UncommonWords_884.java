package problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWords_884 {

    // Time complexity: O(n). Space complexity: O(n)
    public String[] uncommonFromSentences(String a, String b) {
        Map<String, Integer> commons = new HashMap<>();
        String[] arrA = a.split(" ");
        String[] arrB = b.split(" ");

        for (String s : arrA) commons.put(s, commons.getOrDefault(s, 0) + 1);
        for (String s : arrB) commons.put(s, commons.getOrDefault(s, 0) + 1);

        return commons.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).toArray(String[]::new);
    }
}