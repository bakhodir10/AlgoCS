package leetcode_problems.medium;

import java.util.List;

public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] memo = new int[triangle.size()][];
        int[][] dp = new int[memo.length][];

        for (int i = 0; i < triangle.size(); i++) {
            memo[i] = new int[i + 1];
            dp[i] = new int[i + 1];
            for (int j = 0; j < triangle.get(i).size(); j++) {
                memo[i][j] = triangle.get(i).get(j);
            }
        }

        dp[0][0] = memo[0][0];

        for (int i = 1; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j] + memo[i][j];
                else {
                    int leftNum = dp[i - 1][j - 1];
                    int rightNum = (j == dp[i - 1].length) ? dp[i - 1][j - 1] : dp[i - 1][j];
                    dp[i][j] = Math.min(leftNum + memo[i][j], rightNum + memo[i][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < dp.length; j++) min = Math.min(min, dp[dp.length - 1][j]);

        return min;
    }
}
