package leetcode_problems.medium;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindOriginalArray_2007 {

    // Time complexity: O(nlogn). Space complexity: O(n)
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[]{};

        Arrays.sort(changed);

        int k = 0;
        int[] original = new int[changed.length / 2];
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : changed) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count == 0 || k > changed.length / 2) continue;
            if (!map.containsKey(num * 2)) return new int[]{};

            map.put(num * 2, map.get(num * 2) - count);

            int size = num == num * 2 ? count / 2 : count;

            for (int i = 0; i < size; i++) original[k++] = num;
        }

        return original;
    }
}
