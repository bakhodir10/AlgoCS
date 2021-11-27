package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

// Space complexity: O(n)
public class SnapshotArray_1146 {

    private int snap_id;
    private final Map<Integer, Map<Integer, Integer>> snapshot;

    // Time complexity: O(1)
    public SnapshotArray_1146(int length) {
        this.snap_id = 0;
        this.snapshot = new HashMap<>();
    }

    // Time complexity: O(1)
    public void set(int index, int val) {
        Map<Integer, Integer> cache = this.snapshot.getOrDefault(snap_id, new HashMap<>());
        cache.put(index, val);
        this.snapshot.put(snap_id, cache);
    }

    // Time complexity: O(1)
    public int snap() {
        return this.snap_id++;
    }

    // Time complexity: O(snap_id)
    public int get(int index, int snap_id) {
        while (snap_id >= 0) {
            Map<Integer, Integer> cache = this.snapshot.get(snap_id--);
            if (cache != null && cache.containsKey(index)) return cache.get(index);
        }
        return 0;
    }
}
