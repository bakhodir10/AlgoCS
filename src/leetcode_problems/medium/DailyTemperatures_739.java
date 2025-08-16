package leetcode_problems.medium;

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
}
