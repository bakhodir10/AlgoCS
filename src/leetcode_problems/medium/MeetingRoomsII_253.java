package leetcode_problems.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII_253 {

    // Time complexity: O(nlogn). Space complexity: O(n)
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(intervals.length, Comparator.comparingInt(e -> e));

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (pQ.isEmpty()) {
                pQ.offer(end);
                continue;
            }
            if (start >= pQ.peek()) pQ.poll();
            pQ.offer(end);
        }
        return pQ.size();
    }
}
