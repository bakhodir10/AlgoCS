package leetcode_problems.medium;

import java.util.*;

public class CourseScheduleII_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[numCourses];

        for (int[] pre : prerequisites) {
            indegrees[pre[0]]++;

            Set<Integer> set = adj.getOrDefault(pre[1], new HashSet<>());
            set.add(pre[0]);
            adj.put(pre[1], set);
        }

        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            res[count++] = course;

            Set<Integer> neighbors = adj.getOrDefault(course, new HashSet<>());
            for (int neighbor : neighbors) {
                indegrees[neighbor]--;

                if (indegrees[neighbor] == 0) q.offer(neighbor);
            }
        }
        return count != numCourses ? new int[]{} : res;
    }
}
