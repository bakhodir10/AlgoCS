package ds.sorting;

public class SelectionSort {
    public static int[] sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    k = j;
                    min = arr[j];
                }
            }
            int a = arr[i];
            arr[i] = arr[k];
            arr[k] = a;
        }
        return arr;
    }
}
