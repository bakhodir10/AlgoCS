package leetcode_problems.medium;

public class NumberSmoothDescent_2110 {

    // Time complexity: O(n). Space complexity: O(1)
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int l = 0, r = 0;

        while (r < prices.length) {
            if (r == l) {
                ans++;
            } else if (prices[r - 1] - prices[r] == 1) {
                ans += r - l + 1;
            } else {
                l = r;
                ans++;
            }
            r++;
        }
        return ans;
    }
}