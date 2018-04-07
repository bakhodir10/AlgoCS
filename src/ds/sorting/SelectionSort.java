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
        int i = 0;
        while (i < arr.length) {
            int min = arr[i];
            int j = i + 1, k = i;
            while (j < arr.length) {
                if (min > arr[j]) {
                    min = arr[j];
                    k = j;
                }
                j++;
            }
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
            i++;
        }
        return arr;
    }
}
