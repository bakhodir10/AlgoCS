package problems.easy;

public class BestTimeBuy_121 {

    // approach 1. Time complexity: O(n)
    public int maxProfit(int prices[]) {
        if (prices.length == 0) return 0;
        int differ = 0, max = prices[0], min = prices[0];

        for (int i : prices) {
            if (i < min) {
                min = i;
                max = i;
            }
            max = Math.max(max, i);
            differ = Math.max(differ, max - min);
        }
        return differ;
    }

    // approach 2. Time complexity: O(n^2)
    public int maxProfit2(int[] prices) {
        int best = 0;
        for (int i = 0; i < prices.length; i++) {
            int profit;
            for (int j = i + 1; j < prices.length; j++) {
                profit = prices[j] - prices[i];
                best = Math.max(best, profit);
            }
        }
        return best;
    }
}
