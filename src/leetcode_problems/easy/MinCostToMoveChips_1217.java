package leetcode_problems.easy;

public class MinCostToMoveChips_1217 {

    // Time complexity: O(n). Space complexity: O(1)
    public int minCostToMoveChips(int[] positions) {
        int evenSum = 0;
        int oddSum = 0;

        for (int pos : positions) {
            if (pos % 2 == 0) evenSum++;
            else oddSum++;
        }
        return Math.min(evenSum, oddSum);
    }
}
