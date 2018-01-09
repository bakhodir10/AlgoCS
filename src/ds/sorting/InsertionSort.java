package ds.sorting;

/*
Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs
within the sorted list, and inserts it there. It repeats until no input elements remain.

Data structure:	Array
Worst-case performance:	О(n2) comparisons, swaps
Best-case performance:	O(n) comparisons, O(1) swaps
Average performance:	О(n2) comparisons, swaps
Worst-case space complexity:	О(n) total, O(1) auxiliary
 */
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
