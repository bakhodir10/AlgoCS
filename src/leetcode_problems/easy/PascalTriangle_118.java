package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle_118 {

    // Time complexity: O(n^2). Space complexity: O(n^2)
    public List<List<Integer>> generate1(int numRows) {
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

    // Approach: Dynamic Programming. Time complexity: O(n^2). Space complexity: O(n^2)
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] matrix = new int[numRows][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[i + 1];
            matrix[i][0] = 1;
            matrix[matrix[i].length - 1][matrix[i].length - 1] = 1;
        }

        for (int i = 2; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length - 1; j++) {
                int prevRowLeft = matrix[i - 1][j - 1];
                int prevRoUp = matrix[i - 1][j];
                matrix[i][j] = prevRowLeft + prevRoUp;
            }
        }

        for (int[] ints : matrix) {
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            result.add(list);
        }
        return result;
    }
}
