package interviews;

import java.util.Arrays;

/*
    Given an unsorted array of integers arr and a number s, write a function findArrayQuadruplet that
     finds four numbers (quadruplet) in arr that sum up to s. Your function should return an array of
     these numbers in an ascending order. If such a quadruplet doesn’t exist, return an empty array.
 */

public class ArrayQuadruplet {
    
    // Time complexity: O(n^3). Space Complexity: O(1)
    static int[] findArrayQuadruplet(int[] arr, int s) {
        if (arr.length < 4) return new int[0];
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int r = s - (arr[i] + arr[j]);
                int low = j + 1;
                int high = arr.length - 1;

                while (low < high) {
                    if (arr[low] + arr[high] < r) {
                        low++;
                    } else if (arr[low] + arr[high] > r) {
                        high--;
                    } else {
                        return new int[]{arr[i], arr[j], arr[low], arr[high]};
                    }
                }
            }
        }
        return new int[0];
    }
}
