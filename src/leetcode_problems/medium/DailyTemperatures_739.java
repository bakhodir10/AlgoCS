package leetcode_problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperatures_739 {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < temperatures.length; i ++) {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int idx = st.pop();
                res[idx] = i - idx;
            }
            st.push(i);
        }
        return res;
    }

    private record Pair(int idx, int val){};

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Pair> st = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i ++) {
            while(!st.isEmpty() && temperatures[i] > st.peek().val) {
                Pair pair = st.pop();
                res[pair.idx] = i - pair.idx;
            }
            st.push(new Pair(i, temperatures[i]));
        }
        return res;
    }
}
