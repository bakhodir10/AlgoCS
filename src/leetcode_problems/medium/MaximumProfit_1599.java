package leetcode_problems.medium;

public class MaximumProfit_1599 {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int sum = 0, rotation = -1, maxProfit = -1, profit = 0;

        for (int i = 0; i < customers.length || sum > 0; ++i) {
            if (i < customers.length) sum += customers[i];
            int getOn = Math.min(4, sum);
            profit += getOn * boardingCost - runningCost;
            sum -= getOn;

            if (profit > maxProfit) {
                maxProfit = profit;
                rotation = i + 1;
            }
        }
        return rotation;
    }
}
