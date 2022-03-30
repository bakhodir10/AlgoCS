package leetcode_problems.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageDataStream_346 {

    private int sum = 0;
    private final int size;
    private final Queue<Integer> q;

    public MovingAverageDataStream_346(int size) {
        this.size = size;
        this.q = new LinkedList<>();
    }

    // Time complexity: O(1). Space complexity: O(n)
    public double next(int val) {
        if (q.isEmpty() || q.size() < size) {
            q.add(val);
            sum += val;
        } else {
            int lastNum = q.poll();
            sum -= lastNum;
            sum += val;
            q.offer(val);
        }
        return sum * 1.0 / q.size();
    }
}
