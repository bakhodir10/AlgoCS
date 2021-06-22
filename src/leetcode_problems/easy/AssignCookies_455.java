package leetcode_problems.easy;

import java.util.Arrays;

public class AssignCookies_455 {

    public int findContentChildren(int[] g, int[] s) {
        int i = 0, j = 0, count = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }
}
