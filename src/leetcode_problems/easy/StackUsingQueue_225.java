package leetcode_problems.easy;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue_225 {
    private Queue<Integer> q, temp;
    private int lastElement = 0;

    /**
     * Initialize your data structure here.
     */
    public StackUsingQueue_225() {
        q = new LinkedList<>();
        temp = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.offer(x);
        lastElement = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        temp.clear();
        int x = 0;
        while (q.size() != 1) {
            if (q.size() == 2) lastElement = q.peek();
            temp.offer(q.poll());
        }
        if (!q.isEmpty()) x = q.poll();
        while (!temp.isEmpty()) q.offer(temp.poll());
        return x;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return lastElement;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        System.out.println(q);
        return q.isEmpty();
    }
}