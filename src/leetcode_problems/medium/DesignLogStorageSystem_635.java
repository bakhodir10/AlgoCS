package leetcode_problems.medium;

import java.util.*;

public class DesignLogStorageSystem_635 {

    private final TreeMap<String, Set<Integer>> logs;

    // Space complexity: O(n)
    public DesignLogStorageSystem_635() {
        this.logs = new TreeMap<>();
    }

    // Time complexity: O(logn)
    // Space complexity: O(1)
    public void put(int id, String timestamp) {
        this.logs.computeIfAbsent(timestamp, k -> new HashSet<>()).add(id);
    }

    // Time complexity: O(logn)
    // Space complexity: O(n)
    public List<Integer> retrieve(String start, String end, String granularity) {
        String consStartTime = getTime(start, granularity, true);
        String consEndTime = getTime(end, granularity, false);
        NavigableMap<String, Set<Integer>> subMap = logs.subMap(consStartTime, true, consEndTime, true);

        List<Integer> result = new ArrayList<>();
        for(Set<Integer> values: subMap.values()) result.addAll(values);
        return result;
    }

    private String getTime(String timestamp, String granularity, boolean isStartTime) {
        String[] gs  = new String[]{"Second", "Minute", "Hour", "Day", "Month", "Year"};
        StringBuilder sb = new StringBuilder(timestamp);
        sb.reverse();
        int i = 0;

        for(String g: gs) {
            if(!granularity.equals(g)) {
                sb.setCharAt(i++, isStartTime ? '0' : '9');
                sb.setCharAt(i++, isStartTime ? '0' : '5');
            } else {
                break;
            }
            i++;
        }
        sb.reverse();
        return sb.toString();
    }
}
