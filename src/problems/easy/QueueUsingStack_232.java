package problems.easy;

import java.util.Stack;

public class QueueUsingStack_232 {
    private Stack<Integer> st, helper;
    private int i = 0, peek = 0;

    /**
     * Initialize your data structure here.
     */
    public QueueUsingStack_232() {
        st = new Stack<>();
        helper = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        st.push(x);
        if (i == 0) peek = x;
        i++;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        helper.clear();
        while (!st.isEmpty()) helper.push(st.pop());
        int x = 0;
        if (!helper.isEmpty()) x = helper.pop();
        if (!helper.isEmpty()) peek = helper.peek();
        while (!helper.isEmpty()) st.push(helper.pop());
        i--;
        return x;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return peek;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return st.isEmpty();
    }
}
