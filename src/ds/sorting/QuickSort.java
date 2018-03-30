package ds.sorting;

/*
Quicksort is a divide and conquer algorithm. Quicksort first divides a large array into two smaller
 sub-arrays: the low elements and the high elements. Quicksort can then recursively sort the sub-arrays.
The steps are:
1) Pick an element, called a pivot, from the array.
2) Partitioning: reorder the array so that all elements with values less than the pivot come before the
pivot, while all elements with values greater than the pivot come after it (equal values can go either way)
After this partitioning, the pivot is in its final position. This is called the partition operation.
3) Recursively apply the above steps to the sub-array of elements with smaller values and separately to
the sub-array of elements with greater values.
The base case of the recursion is arrays of size zero or one, which are in order by definition, so they never need to be sorted.
The pivot selection and partitioning steps can be done in several different ways; the choice of specific implementation schemes greatly affects the algorithm's performance.

Worst-case performance:	O(n2)
Best-case performance:	O(n log n) (simple partition) or O(n) (three-way partition and equal keys)
Average performance:	O(n log n)
Worst-case space complexity:	O(n) auxiliary (naive). O(log n)
 */
public class QuickSort {
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}
