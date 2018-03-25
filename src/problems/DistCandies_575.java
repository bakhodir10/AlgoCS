package problems;

import java.util.Arrays;

public class DistCandies_575 {
    public static int distributeCandies(int[] arr) {
        int differ = 1;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++)
            if (arr[i] != arr[i - 1]) differ++;
        return differ >= arr.length / 2 ? arr.length / 2 : differ;
    }
}
