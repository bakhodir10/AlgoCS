package leetcode_problems.easy;

import java.util.HashMap;

public class SquaresSortedArr_977 {

    public int[] sortedSquares(int[] a) {
        int pivot = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] *= a[i];
            if (i > 0 && a[i - 1] > a[i]) pivot = i;
        }

        int[] newArr = new int[a.length];
        int i = pivot, j = pivot + 1, k = 0;

        while (i > -1 && j < a.length) {
            if (a[i] > a[j]) newArr[k++] = a[j++];
            else newArr[k++] = a[i--];
        }

        while (j < a.length) newArr[k++] = a[j++];
        while (i > -1) newArr[k++] = a[i--];
        HashMap<Integer, String> map = new HashMap<>();
        map.remove(1);
        return newArr;
    }
}
