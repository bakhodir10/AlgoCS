package ds.sorting;

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
