package contest.leetcode.contest70;

import java.util.HashMap;
import java.util.Map;

public class FindAnagram_760 {
    // approach 1
    public int[] anagramMappings1(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    a[i] = j;
                    break;
                }
            }
        }
        return a;
    }

    //approach 2
    public int[] anagramMappings2(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length; i++) map.put(b[i], i);
        for (int i = 0; i < a.length; i++) a[i] = map.get(a[i]);
        return a;
    }
}
