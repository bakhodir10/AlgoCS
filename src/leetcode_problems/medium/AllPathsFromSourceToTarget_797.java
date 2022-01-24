package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget_797 {

    private List<List<Integer>> res;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        path.add(0);
        dfs(graph, 0, graph.length - 1, path);
        return res;
    }

    private void dfs(int[][] graph, int curr, int tar, LinkedList<Integer> path) {
        if (curr == tar) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int v : graph[curr]) {
            path.add(v);
            dfs(graph, v, tar, path);
            path.removeLast();
        }
    }
}
