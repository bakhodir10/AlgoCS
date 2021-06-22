package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckArrayFormation_1640 {

    // Time complexity: O(n). Space complexity: O(n)
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] piece : pieces) {
            List<Integer> numList = new ArrayList<>();
            for (int p : piece) numList.add(p);
            map.put(piece[0], numList);
        }

        int pointer = 0;
        while (pointer < arr.length) {
            List<Integer> numList = map.get(arr[pointer]);
            if (numList == null) return false;
            for (int num : numList) {
                if (arr[pointer++] != num) return false;
            }
        }
        return true;
    }
}