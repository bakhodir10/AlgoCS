package neetcode.sliding_window;

public class BestTimeToBuyAndSellStock {

    // Brute force solution
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public int maxProfit1(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length; i ++) {
            for(int j = i + 1; j < prices.length; j ++) max = Math.max(max, prices[j] - prices[i]);
        }
        return max;
    }

    // Sliding window
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int maxProfit2(int[] prices) {
        int max = 0, l = 0, r = 1;

        while(r < prices.length) {
            while(r < prices.length) {
                if(prices[l] < prices[r]) max = Math.max(max, prices[r] - prices[l]);
                else l = r;

                r++;
            }
        }
        return max;
    }
}
