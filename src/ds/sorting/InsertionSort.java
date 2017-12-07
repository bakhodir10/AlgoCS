package ds.sorting;

public class InsertionSort {
    public static int[] sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int j = i - 1;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int a = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = a;
                j--;
            }
        }
        return arr;
    }
}
