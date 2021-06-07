package problems.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII_170 {

    /**
     * Initialize your data structure here.
     */
    private int max;
    private int min;
    private final Map<Integer, Integer> map;

    public TwoSumIII_170() {
        this.map = new HashMap<>();
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
    }

    /**
     * Add the number to an internal data structure..
     */
    // Time complexity: O(1)
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
        min = Math.min(min, number);
        max = Math.max(max, number);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    // Time complexity: O(n)
    public boolean find(int value) {
        if (min * 2 > value || max * 2 < value) return false;

        for (int key : map.keySet()) {
            if (key * 2 == value && map.get(key) > 1
                    || key * 2 != value && map.containsKey(value - key)) return true;
        }
        return false;
    }
}
