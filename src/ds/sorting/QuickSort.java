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
Worst-case space complexity:	O(n) auxiliary (naive). O(log n) auxiliary (Sedgewick 1978)
 */
public class QuickSort {
    private int arr[];

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public int[] sort() {
        return arr;
    }

    private int getDivider(int a, int b) {
        return (a + b) / 2;
    }
}
