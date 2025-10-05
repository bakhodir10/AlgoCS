package leetcode_problems.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DesignTaskManager_3408 {

    private record Task(int userId, int taskId, int priority){}
    private record Pair(int userId, int priority){}

    private final TreeSet<Task> taskSet;
    private final Map<Integer, Pair> userTaskMap;

    // Time complexity: O(nlogn)
    public DesignTaskManager_3408(List<List<Integer>> tasks) {
        this.taskSet = new TreeSet<>((a, b) -> {
            if(a.priority != b.priority) return b.priority - a.priority;
            else return b.taskId - a.taskId;
        });
        this.userTaskMap = new HashMap<>();

        for(List<Integer> task: tasks) {
            Task t = new Task(task.get(0), task.get(1), task.get(2));
            taskSet.add(t);
            userTaskMap.put(task.get(1), new Pair(task.get(0), task.get(2)));
        }
    }

    // Time complexity: O(logn)
    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        taskSet.add(t);
        userTaskMap.put(taskId, new Pair(userId, priority));
    }

    // Time complexity: O(logn)
    public void edit(int taskId, int newPriority) {
        if(!userTaskMap.containsKey(taskId)) return;

        Pair p = userTaskMap.get(taskId);
        Task oldT = new Task(p.userId, taskId, p.priority);
        taskSet.remove(oldT);

        Task newT = new Task(p.userId, taskId, newPriority);
        taskSet.add(newT);
        userTaskMap.put(taskId, new Pair(p.userId, newPriority));
    }

    // Time complexity: O(logn)
    public void rmv(int taskId) {
        if(!userTaskMap.containsKey(taskId)) return;

        Pair p = userTaskMap.get(taskId);
        Task t = new Task(p.userId, taskId, p.priority);

        userTaskMap.remove(taskId);
        taskSet.remove(t);
    }

    // Time complexity: O(logn)
    public int execTop() {
        if(taskSet.isEmpty()) return -1;

        Task top = taskSet.removeFirst();
        userTaskMap.remove(top.taskId);
        return top.userId;
    }
}
