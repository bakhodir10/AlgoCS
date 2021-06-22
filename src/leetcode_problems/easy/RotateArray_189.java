package leetcode_problems.easy;

public class RotateArray_189 {

    // approach 1
    public void rotate1(int[] arr, int k) {
        k %= arr.length;
        reverse(arr, 0, arr.length);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length);
    }

    private void reverse(int[] arr, int from, int to) {
        while (from < to) {
            int temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from++;
            to--;
        }
    }

    // approach 2
    public static void rotate2(int[] arr, int k) {
        for (int i = 0; i < k % arr.length; i++) {
            int temp = arr[arr.length - 1];
            for (int j = 0; j < arr.length; j++) {
                int c = arr[j];
                arr[j] = temp;
                temp = c;
            }
        }
    }
}
