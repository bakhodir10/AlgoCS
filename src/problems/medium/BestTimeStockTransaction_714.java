package problems.medium;

// todo not done
public class BestTimeStockTransaction_714 {

    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int best = 0;
        int min = prices[0];
        int max = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]);


        }
        return profit;
    }
}
