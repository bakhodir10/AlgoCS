package leetcode_problems.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmployeeFreeTime_759 {

    // Time complexity: O(nlogn). Space complexity: O(1)
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> scheduleList = new ArrayList<>();

        for (List<Interval> list : schedule) scheduleList.addAll(list);

        scheduleList.sort((e1, e2) -> e1.start - e2.start);
        LinkedList<Interval> merged = new LinkedList<>();

        for (Interval iVal : scheduleList) {
            if (merged.isEmpty() || merged.getLast().end < iVal.start) merged.add(iVal);
            else merged.getLast().end = Math.max(merged.getLast().end, iVal.end);
        }

        List<Interval> res = new ArrayList<>();
        for (int i = 1; i < merged.size(); i++) res.add(new Interval(merged.get(i - 1).end, merged.get(i).start));
        return res;
    }

    private class Interval {
        public int start;
        public int end;

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
}
