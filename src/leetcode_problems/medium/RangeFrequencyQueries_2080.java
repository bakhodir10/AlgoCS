package leetcode_problems.medium;

import java.util.*;

public class RangeFrequencyQueries_2080 {
    private final Map<Integer, List<Integer>> map;

    // Time complexity: O(n)
    // Space complexity: O(n)
    public RangeFrequencyQueries_2080(int[] arr) {
        this.map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])) map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
    }

    // Time complexity: O(logn)
    // Space complexity: O(1)
    public int query(int left, int right, int value) {
        if(!map.containsKey(value)) return 0;

        List<Integer> indexes = map.get(value);
        int upper = Collections.binarySearch(indexes, right);
        int lower = Collections.binarySearch(indexes, left);

        if(upper < 0) upper = upper * (-1) - 2;
        if(lower < 0) lower = lower * (-1) - 1;
        return upper - lower + 1;
    }
}
