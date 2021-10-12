package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval_57 {

    // Time complexity: O(n). Space complexity: O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean added = false;
        List<int[]> newIntervals = new ArrayList<>();

        for (int[] ints : intervals) {
            if (ints[0] >= newInterval[0]) {
                added = true;
                newIntervals.add(newInterval);
            }
            newIntervals.add(ints);
        }
        if (!added) newIntervals.add(newInterval);

        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : newIntervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) merged.add(interval);
            else merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}