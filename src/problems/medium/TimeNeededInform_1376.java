package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededInform_1376 {

    // Time complexity: O(n). Space complexity: O(n)
    private int total = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < manager.length; i++) {
            int managerID = manager[i];
            if (!graph.containsKey(managerID)) graph.put(managerID, new ArrayList<>());
            graph.get(managerID).add(i);
        }
        dfs(headID, graph, informTime, informTime[headID]);
        return total;
    }

    private void dfs(int headID, Map<Integer, List<Integer>> graph, int[] informTime, int sum) {
        List<Integer> employees = graph.get(headID);

        if (employees == null || employees.isEmpty()) {
            total = Math.max(total, sum);
            return;
        }
        for (Integer managerID : employees) {
            dfs(managerID, graph, informTime, sum + informTime[managerID]);
        }
    }
}