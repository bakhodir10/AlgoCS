package leetcode_problems.easy;

import java.util.HashMap;
import java.util.Map;

// Space complexity: O(n => unique number of messages)
public class LoggerRateLimiter_359 {

    private final Map<String, Integer> cache;

    public LoggerRateLimiter_359() {
        this.cache = new HashMap<>();
    }

    // Time complexity: O(1)
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!cache.containsKey(message)) {
            cache.put(message, timestamp);
            return true;
        }

        int time = cache.get(message);
        if (time + 10 <= timestamp) {
            cache.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}
