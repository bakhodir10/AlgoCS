package ds.sorting;

/*
The algorithm divides the input list into two parts: the sublist of items already sorted, remaining
which is built up from left to right at the front (left) of the list, and the sublist of items to be
sorted that occupy the rest of the list. Initially, the sorted sublist is emptyand the unsorted sublist
is the entire input list. The algorithm proceeds by finding the smallest(or largest, depending on sorting
order) element in the unsorted sublist, exchanging (swapping) it with the leftmost unsorted element
(putting it in sorted order), and moving the sublist boundaries one element to the right.

Data structure:	Array
Worst-case performance:	О(n2) comparisons, О(n) swaps
Best-case performance:	О(n2) comparisons, О(n) swaps
Average performance:	О(n2) comparisons, О(n) swaps
Worst-case space complexity:	О(n) total, O(1) auxiliary

 */
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
