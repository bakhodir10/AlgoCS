package ds.sorting;

/*
Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps
through the list to be sorted, compares each pair of adjacent items and swaps them if they are in the
wrong order. The pass through the list is repeated until no swaps are needed, which indicates that the
list is sorted.

Data structure: Array
Worst-case performance: O(N2)
Best-case performance: O(N)
Average performance: O(N2)
Worst-case space complexity: O(1) auxiliary
 */

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
