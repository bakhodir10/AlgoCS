package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels_763 {

    // Time complexity: O(n), n -> the length of S string
    // Space complexity: O(n) n -> the length of S string.
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> intervals = new LinkedHashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            int [] window = intervals.getOrDefault(s.charAt(i), new int[]{i, i});
            window[1] = i;
            intervals.put(s.charAt(i), window);
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int[] window: intervals.values()) {
            if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
                min = window[0];
                max = window[1];
            } else if(max >= window[0]) {
                if(max < window[1]) max = window[1];
            } else {
                result.add(max - min + 1);
                min = window[0];
                max = window[1];
            }
        }

        if(min <= max) result.add(max - min + 1);
        return result;
    }
}
