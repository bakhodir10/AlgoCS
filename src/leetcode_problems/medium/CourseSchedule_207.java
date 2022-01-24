package leetcode_problems.medium;

import java.util.*;

public class CourseSchedule_207 {

    // Time complexity: O(V+E). Space complexity: O(V)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Queue<Integer> nonDepCourses = new LinkedList<>();
        List<Integer> courses = new ArrayList<>();

        for (int[] pre : prerequisites) {
            Set<Integer> set = adj.getOrDefault(pre[1], new HashSet<>());
            set.add(pre[0]);
            adj.put(pre[1], set);
        }

        for (int[] pre : prerequisites) indegrees[pre[0]]++;

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) nonDepCourses.offer(i);
        }

        while (!nonDepCourses.isEmpty()) {
            int course = nonDepCourses.poll();
            courses.add(course);

            Set<Integer> neighbors = adj.getOrDefault(course, new HashSet<>());

            for (int neighbor : neighbors) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) nonDepCourses.add(neighbor);
            }
        }
        return courses.size() == numCourses;
    }
}
