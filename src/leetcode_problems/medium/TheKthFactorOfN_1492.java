package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.List;

public class TheKthFactorOfN_1492 {

    // Time complexity: O(n). Space complexity: O(n)
    public int kthFactor1(int n, int k) {
        int i = 1;
        List<Integer> list = new ArrayList<>();

        while (i <= n) {
            if (n % i == 0) list.add(i);
            i++;
        }
        return list.size() <= k - 1 ? -1 : list.get(k - 1);
    }

    // Time complexity: O(sqrt(n)). Space complexity: O(1)
    public int kthFactor2(int n, int k) {
        boolean[] nums = new boolean[1001];

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) nums[i] = true;
                else {
                    nums[i] = true;
                    nums[n / i] = true;
                }
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i]) k--;
            if (k == 0) return i;
        }
        return -1;
    }
}
