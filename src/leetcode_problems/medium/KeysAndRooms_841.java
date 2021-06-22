package leetcode_problems.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms_841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Queue<Integer> keys = new LinkedList<>(rooms.get(0));
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        while (!keys.isEmpty()) {
            int key = keys.poll();
            if (!visited[key]) keys.addAll(rooms.get(key));
            visited[key] = true;
        }

        for (boolean cell : visited) {
            if (!cell) return false;
        }

        return true;
    }
}