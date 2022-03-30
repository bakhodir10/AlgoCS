package leetcode_problems.medium;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions_636 {

    // Time complexity: O(n). Space complexity: O(n)
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> st = new Stack<>(); // [id. start/end]
        int currTime = 0;

        for (String log : logs) {
            String[] s = log.split(":");
            int id = Integer.parseInt(s[0]);
            int startOrStop = s[1].equals("start") ? 1 : -1;
            int time = Integer.parseInt(s[2]);

            if (st.isEmpty()) {
                st.push(new int[]{id, startOrStop});
                currTime = time;
            } else {
                if (startOrStop == 1) {
                    res[st.peek()[0]] += time - currTime - 1;
                    st.push(new int[]{id, startOrStop});
                    currTime = time;
                } else {
                    res[id] += time - currTime + 1;
                    currTime = time;
                    st.pop();
                }
            }
        }
        return res;
    }
}
