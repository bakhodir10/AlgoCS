package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class FourSumII_454 {

    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                map.put(a[i] + b[j], map.getOrDefault(a[i] + b[j], 0) + 1);
            }
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                res += map.getOrDefault(0 - (c[i] + d[j]), 0);
            }
        }
        return res;
    }
}
