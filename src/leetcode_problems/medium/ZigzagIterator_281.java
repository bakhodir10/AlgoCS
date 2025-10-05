package leetcode_problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class ZigzagIterator_281 {

    private Deque<Iterator<Integer>> q;
    public ZigzagIterator_281(List<Integer> v1, List<Integer> v2) {
        q = new ArrayDeque<>();
        if(!v1.isEmpty()) q.add(v1.iterator());
        if(!v2.isEmpty()) q.add(v2.iterator());
    }

    public int next() {
        if(q.isEmpty()) return -1;
        Iterator<Integer> curr = q.poll();
        int val = curr.next();
        if(curr.hasNext()) q.offer(curr);
        return val;
    }

    public boolean hasNext() {
        if(q.isEmpty()) return false;
        Iterator<Integer> curr = q.peek();
        return curr.hasNext();
    }
}
