package crack_code_interview;

import java.util.Arrays;

public class Permutation {

    public static void permutation(int arr[]) {
        permutationHelper(arr, 0);
    }

    private static void permutationHelper(int arr[], int start) {
        if (start == arr.length - 1) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = start; i <= arr.length - 1; i++) {
                swap(arr, start, i);
                permutationHelper(arr, start + 1);
                swap(arr, start, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}