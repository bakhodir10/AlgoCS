package ds.sorting;

public class HeapSort {
    public int arr[];

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    // to make a heap
    public void makeHeap() {
        for (int i = 0; i < arr.length; i++) {
            // index of child element
            int index = i;
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (arr[index] <= arr[parent]) break;
                // swap child element to its parent one
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
                index = parent;
            }
        }
    }

    // to remove item from the top of the binary tree -> arr[0]
    public void removeTopItem(int count) {
        int a = arr[0];
        arr[0] = arr[count];
        arr[count] = a;
        int index = 0;
        count--;
        // to remake binary tree
        while (true) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;

            // check the boundary
            if (rightChild > count) break;
            if (arr[index] > arr[leftChild] && arr[index] > arr[rightChild]) break;

            // to get greater parent
            int parentGreat = arr[rightChild] > arr[leftChild] ? rightChild : leftChild;

            // swap current item to its parent one
            int temp = arr[index];
            arr[index] = arr[parentGreat];
            arr[parentGreat] = temp;
            index = parentGreat;
        }
    }

    // sort by using heap
    public int[] sort() {
        // make a heap
        makeHeap();
        // sorting
        for (int i = arr.length - 1; i >= 0; i--) {
            removeTopItem(i);
        }
        return arr;
    }
}
