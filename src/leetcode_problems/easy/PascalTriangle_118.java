package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {

    // Time complexity: O(n^2). Space complexity: O(n^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) newList.add(1);
                else newList.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            list.add(newList);
        }
        return list;
    }
}
