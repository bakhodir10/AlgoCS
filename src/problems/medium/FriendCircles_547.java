package problems.medium;

public class FriendCircles_547 {

    // Algorithm 1. Grouping friend circles
    public int findCircleNum1(int[][] m) {
        int groupNum = 2;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 1) dfs(m, i, groupNum++);
            }
        }
        return groupNum - 2;
    }

    private void dfs(int[][] m, int person, int groupNum) {
        for (int friend = 0; friend < m[person].length; friend++) {
            if (m[person][friend] == 1) {
                m[person][friend] = groupNum;
                dfs(m, friend, groupNum);
            }
        }
    }

    // Algorithm 2. Marking as visited after each row visit
    public int findCircleNum2(int[][] m) {
        boolean[] visited = new boolean[m.length];
        int count = 0;

        for (int i = 0; i < m.length; i++) {
            if (!visited[i]) {
                dfs(m, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m, boolean[] visited, int person) {
        for (int friend = 0; friend < m[person].length; friend++) {
            if (!visited[friend] && m[person][friend] == 1) {
                visited[friend] = true;
                dfs(m, visited, friend);
            }
        }
    }

}
