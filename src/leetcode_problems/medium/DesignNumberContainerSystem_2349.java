package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignNumberContainerSystem_2349 {

    private final Map<Integer, TreeSet<Integer>> cache;
    private final Map<Integer, Integer> numberByIndex;

    public DesignNumberContainerSystem_2349() {
        this.cache = new HashMap<>();
        this.numberByIndex = new HashMap<>();
    }

    // Time complexity: O(logn)
    public void change(int index, int number) {
        Integer currNumber = numberByIndex.get(index);

        if(currNumber != null) {
            TreeSet<Integer> oldNumIndices = cache.get(currNumber);
            oldNumIndices.remove(index);
            if(oldNumIndices.isEmpty()) cache.remove(currNumber);
        }
        numberByIndex.put(index, number);
        cache.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    // Time complexity: O(1)
    public int find(int number) {
        TreeSet<Integer> indices = cache.get(number);
        return indices == null ? -1 : indices.getFirst();
    }
}
