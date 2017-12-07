package ds.sorting;

public class BubbleSort {
    public static int[] sort(int arr[]) {
        boolean notSorted = true;
        while (notSorted) {
            notSorted = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int a = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = a;
                    notSorted = true;
                }
            }
        }
        return arr;
    }
}
