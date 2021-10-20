package leetcode_problems.easy;

public class XOROperation_1486 {

    // Time complexity: O(n). Space complexity: O(1)
    public int xorOperation(int n, int start) {
        int res = 0;
        for(int i = 0; i < n; i++) res ^= start + 2 * i;
        return res;
    }
}
