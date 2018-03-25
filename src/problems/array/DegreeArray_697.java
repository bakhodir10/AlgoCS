package problems.array;

import java.util.HashMap;
import java.util.Map;

public class DegreeArray_697 {
    public static int findShortestSubArray(int nums[]) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> elWithCount = new HashMap<>();
        Map<Integer, Integer> maxIndex = new HashMap<>();
        Map<Integer, Integer> minIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            boolean exist = elWithCount.containsKey(nums[i]);
            if (exist) {
                int t = elWithCount.get(nums[i]);
                elWithCount.put(nums[i], ++t);
            } else elWithCount.put(nums[i], 1);

            boolean max = maxIndex.containsKey(nums[i]);
            if (max) maxIndex.put(nums[i], i);
            else {
                minIndex.put(nums[i], i);
                maxIndex.put(nums[i], i);
            }
        }

        int maxElem = 0;
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> map : elWithCount.entrySet()) {
            if (maxElem <= map.getValue()) {
                int key = map.getKey();
                int value = map.getValue();
                int min = minIndex.get(key);
                int max = maxIndex.get(key);

                if (maxElem == value && res > max - min + 1) res = max - min + 1;
                else if (maxElem < value) res = max - min + 1;
                maxElem = value;
            }
        }
        return res;
    }
}
