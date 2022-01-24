package leetcode_problems.easy;

import java.util.HashSet;
import java.util.Set;

public class CheckIfEveryRow_2133 {

    public boolean checkValid(int[][] matrix) {

        for (int[] ints : matrix) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                set.add(ints[j]);
            }
            if (set.size() != matrix.length) return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int[] ints : matrix) {
                set.add(ints[i]);
            }
            if (set.size() != matrix.length) return false;
        }
        return true;
    }
}
