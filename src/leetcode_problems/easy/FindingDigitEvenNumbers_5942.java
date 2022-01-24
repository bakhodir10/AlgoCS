package leetcode_problems.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindingDigitEvenNumbers_5942 {

    // Time complexity: O(n^3 + mlogm). Space complexity: O(1)
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < digits.length; j++) {
                if (i == j) continue;
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) continue;
                    int num = (digits[i] * 10 + digits[j]) * 10 + digits[k];
                    if (num % 2 == 0) set.add(num);
                }
            }
        }

        int idx = 0;
        int[] ans = new int[set.size()];

        for (int num : set) ans[idx++] = num;

        Arrays.sort(ans);
        return ans;
    }
}
