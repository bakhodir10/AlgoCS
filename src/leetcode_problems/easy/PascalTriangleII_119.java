package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII_119 {

    // Time complexity: O(n^2). Space complexity: O(n^2)
    public List<Integer> getRow1(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) newList.add(1);
                else newList.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            list.add(newList);
        }
        return list.get(rowIndex);
    }

    // Time complexity: O(n^2). Space complexity: O(n)
    public List<Integer> getRow(int rowIndex) {
        Integer[] integers = new Integer[rowIndex + 1];
        Arrays.fill(integers, 1);

        for (int row = 0; row < rowIndex; row++) {
            for (int col = row; col > 0; col--) integers[col] += integers[col - 1];
        }
        return Arrays.asList(integers);
    }
}
