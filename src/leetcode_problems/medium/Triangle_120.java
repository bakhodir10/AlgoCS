package leetcode_problems.medium;

import java.util.Arrays;
import java.util.List;

public class Triangle_120 {

    // Time complexity(n*m)
    // Space complexity: O(n*m)
    public int minimumTotal(List<List<Integer>> t) {
        int[][] memo = new int[t.size()][];
        for(int i = 0; i < t.size(); i ++) {
            memo[i] = new int[t.get(i).size()];
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        memo[0][0] = t.getFirst().getFirst();

        for(int i = 0; i < t.size() - 1; i ++) {
            for(int j = 0; j < t.get(i).size(); j++) {
                int curr = memo[i][j];
                int nextLeft = t.get(i + 1).get(j);
                int nextRight = t.get(i + 1).get(j + 1);
                memo[i + 1][j] = Math.min(memo[i + 1][j], curr + nextLeft);
                memo[i + 1][j + 1] = Math.min(memo[i + 1][j + 1], curr + nextRight);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < memo[memo.length - 1].length; j++) {
            min = Math.min(min, memo[memo.length - 1][j]);
        }
        return min;
    }
}
