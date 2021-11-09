package leetcode_problems.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_146 {

    private final LinkedHashMap<Integer, Integer> map;

    // Time complexity: O(1). Space complexity: O(capacity)
    public LRUCache_146(int capacity) {
        this.map = new LinkedHashMap<>(capacity, 0.75F, true) {
            protected boolean removeEldestEntry(Map.Entry entry) {
                return this.size() > capacity;
            }
        };
    }

    // Time complexity: O(1)
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    // Time complexity: O(1)
    public void put(int key, int value) {
        map.put(key, value);
    }
}
