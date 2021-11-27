package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore_981 {
    private final Map<String, TreeMap<Integer, String>> cache;

    public TimeBasedKeyValueStore_981() {
        this.cache = new HashMap<>();
    }

    // Time complexity: O(log(timestamp))
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> mapping = this.cache.getOrDefault(key, new TreeMap<>());
        mapping.put(timestamp, value);
        this.cache.put(key, mapping);
    }

    // Time complexity: O(log(timestamp))
    public String get(String key, int timestamp) {
        if (!cache.containsKey(key)) return "";
        TreeMap<Integer, String> mapping = this.cache.get(key);

        Integer floorKey = mapping.floorKey(timestamp);
        return floorKey == null ? "" : mapping.get(floorKey);
    }
}
