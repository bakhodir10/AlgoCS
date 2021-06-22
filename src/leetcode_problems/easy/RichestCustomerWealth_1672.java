package leetcode_problems.easy;

public class RichestCustomerWealth_1672 {

    // Time complexity: O(n). Space complexity: O(1);
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int[] customerAcc : accounts) {
            int sum = 0;
            for (int acc : customerAcc) sum += acc;
            res = Math.max(res, sum);
        }
        return res;
    }
}
