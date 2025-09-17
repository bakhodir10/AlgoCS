package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences_187 {

    // Time complexity: O(n)
    // Space complexity: O(n/10)
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> unique10Letters = new HashMap<>();
        List<String> repeated10Letters = new ArrayList<>();

        for(int i = 0; i < s.length() - 9; i ++) {
            String letters10 = s.substring(i, i + 10);
            unique10Letters.put(letters10, unique10Letters.getOrDefault(letters10, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry: unique10Letters.entrySet()) {
            if(entry.getValue() > 1) repeated10Letters.add(entry.getKey());
        }
        return repeated10Letters;
    }
}
