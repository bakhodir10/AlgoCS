package problems.medium;

import java.util.Map;
import java.util.TreeMap;

public class KThSmallestMatrix_378 {

    public int kthSmallest(int[][] matrix, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                if (!map.containsKey(anAMatrix)) map.put(anAMatrix, 1);
                else {
                    int count = map.get(anAMatrix);
                    map.put(anAMatrix, ++count);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            k -= val;
            if (k <= 0) return key;
        }

        return -1;
    }
}