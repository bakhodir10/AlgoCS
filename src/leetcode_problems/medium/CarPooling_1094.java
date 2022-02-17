package leetcode_problems.medium;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling_1094 {

    // Time complexity: O(nlogn). Space complexity: O(n)
    public boolean carPooling1(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int[] trip : trips) {
            int from = map.getOrDefault(trip[1], 0);
            from += trip[0];
            map.put(trip[1], from);

            int to = map.getOrDefault(trip[2], 0);
            to -= trip[0];
            map.put(trip[2], to);
        }

        int currCap = 0;
        for (int val : map.values()) {
            currCap += val;
            if (currCap > capacity) return false;
        }
        return true;
    }

    // Time complexity: O(n). Space complexity: O(1). We are using this approach because 1 <= trips.length <= 1000
    public boolean carPooling2(int[][] trips, int capacity) {
        int[] bucket = new int[1001];

        for (int[] trip : trips) {
            bucket[trip[1]] += trip[0];
            bucket[trip[2]] -= trip[0];
        }

        int currCap = 0;
        for (int j : bucket) {
            currCap += j;
            if (currCap > capacity) return false;
        }
        return true;
    }
}
