package problems.easy;

import java.util.Stack;

public class QueueUsingStack_232 {
    private Stack<Integer> st, temp;
    private int i = 0, lasElement = 0;

    /**
     * Initialize your data structure here.
     */
    public QueueUsingStack_232() {
        st = new Stack<>();
        temp = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        st.push(x);
        if (i == 0) lasElement = x;
        i++;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        temp.clear();
        while (!st.isEmpty()) temp.push(st.pop());
        int x = 0;
        if (!temp.isEmpty()) x = temp.pop();
        if (!temp.isEmpty()) lasElement = temp.peek();
        while (!temp.isEmpty()) st.push(temp.pop());
        i--;
        return x;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return lasElement;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return st.isEmpty();
    }
}
