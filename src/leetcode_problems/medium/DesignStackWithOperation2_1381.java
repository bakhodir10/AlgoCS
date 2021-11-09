package leetcode_problems.medium;

public class DesignStackWithOperation2_1381 {

    private int size = 0;
    private final int maxSize;
    private final int[] arr;

    public DesignStackWithOperation2_1381(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    // Time complexity O(1)
    public void push(int x) {
        if (size >= maxSize) return;
        arr[size++] = x;
    }

    // Time complexity O(1)
    public int pop() {
        if (size <= 0) return -1;
        int last = arr[size];
        arr[size--] = -1;
        return last;

    }

    // Time complexity O(k)
    public void increment(int k, int val) {
        int loopCount = Math.min(k, size);
        for (int i = 0; i < loopCount; i++) arr[i] += val;
    }
}
