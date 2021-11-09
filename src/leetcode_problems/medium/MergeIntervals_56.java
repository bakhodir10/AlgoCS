package leetcode_problems.medium;

import java.util.*;

public class MergeIntervals_56 {

    //  Approach 1. Using LinkedList. Time complexity: O(nlogn). Space complexity: O(n)
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) merged.add(interval);
            else merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    // Time complexity: O(nlogn). Space complexity: O(n)
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        List<int[]> iVals = new ArrayList<>();

        for (int[] interval : intervals) {
            int currStart = interval[0];
            int currEnd = interval[1];

            if (prevEnd > currEnd) continue;
            else if (prevEnd >= currStart) prevEnd = currEnd;
            else {
                iVals.add(new int[]{prevStart, prevEnd});
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }
        iVals.add(new int[]{prevStart, prevEnd});
        return iVals.toArray(new int[iVals.size()][]);
    }

    // Approach 3. Using Stack. Time complexity: O(nlogn). Space complexity: O(n)
    public int[][] merge3(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
        Stack<int[]> merged = new Stack<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.peek()[1] < interval[0]) merged.push(interval);
            else {
                if (merged.peek()[1] < interval[1]) {  // (1, 10), (2 15)
                    int start = merged.peek()[0];
                    merged.pop();
                    merged.push(new int[]{start, interval[1]});
                }
            }
        }

        int idx = 0;
        int[][] res = new int[merged.size()][2];

        for (int[] interval : merged) res[idx++] = interval;

        return res;
    }
}
