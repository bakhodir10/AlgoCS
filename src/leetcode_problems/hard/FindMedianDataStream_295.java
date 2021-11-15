package leetcode_problems.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Brute Force solution. This will get TLE
public class FindMedianDataStream_295 {

    private final List<Integer> list;

    public FindMedianDataStream_295() {
        this.list = new ArrayList<>();
    }

    // Time complexity: O(1)
    public void addNum(int num) {
        list.add(num);
    }

    // Time complexity: O(nlogn)
    public double findMedian() {
        int size = list.size();
        Collections.sort(list);

        if (size % 2 == 1) return (double) list.get(size / 2);
        else {
            int firstMiddle = list.get(size / 2 - 1);
            int secondMiddle = list.get(size / 2);
            return (double) (firstMiddle + secondMiddle) / 2;
        }
    }
}
