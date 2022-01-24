package leetcode_problems.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU_1834 {

    // Time complexity: O(nlogn). Space complexity: O(n)
    public int[] getOrder(int[][] tasks) {
        int[][] extTask = new int[tasks.length][3]; // to keep original order of tasks

        for (int i = 0; i < tasks.length; i++) {
            extTask[i][0] = tasks[i][0]; //  enqueueTime time
            extTask[i][1] = tasks[i][1]; // processingTime
            extTask[i][2] = i; // id
        }

        Arrays.sort(extTask, (e1, e2) -> e1[0] - e2[0]);
        PriorityQueue<int[]> pQ = new PriorityQueue<>((e1, e2) -> { // [enqueueTime, processingTime, id]
            if (e1[1] == e2[1]) return e1[2] - e2[2];
            else return e1[1] - e2[1];
        });

        int currTime = 0, ai = 0, ti = 0;
        int[] ans = new int[extTask.length];

        while (ai < ans.length) {

            while (ti < extTask.length && currTime >= extTask[ti][0]) pQ.offer(extTask[ti++]);

            if (pQ.isEmpty()) {
                currTime = extTask[ti][0];
                continue;
            }

            int[] best = pQ.poll();
            currTime += best[1];
            ans[ai++] = best[2];
        }
        return ans;
    }
}
