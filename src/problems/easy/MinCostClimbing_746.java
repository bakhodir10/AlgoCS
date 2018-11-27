package problems.easy;

// todo not finished
public class MinCostClimbing_746 {

    public static void main(String[] args) {

    }

    public int minCostClimbingStairs2(int cost[]) {
        int ans = 0;
        int n = 10;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            }
        }

        for (int i = 0; i < n; i++) {
        }
        return ans;
    }


    public int minCostClimbingStairs(int[] cost) {
        int ans = 0;
        if (cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        int i = cost[0] < cost[1] ? 0 : 1;
        while (i < cost.length - 2) {
            if (cost[i + 1] > cost[i + 2]) {
                ans += cost[i + 2];
                i += 2;
            } else {
                ans += cost[i + 1];
                i += 1;
            }
        }
        return ans;
    }
}