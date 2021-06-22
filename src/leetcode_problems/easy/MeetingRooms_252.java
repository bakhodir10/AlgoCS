package leetcode_problems.easy;

import java.util.Arrays;

public class MeetingRooms_252 {

    // Time complexity: O(nlogn). Space complexity: O(1)
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);

        for (int i = 0; i < intervals.length - 1; i++) {
            int endTimeOfFirst = intervals[i][1];
            int startTimeOfSecond = intervals[i + 1][0];

            if (endTimeOfFirst > startTimeOfSecond) return false;
        }
        return true;
    }
}
