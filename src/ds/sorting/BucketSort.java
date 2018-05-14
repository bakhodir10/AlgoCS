package ds.sorting;

public class BucketSort {

    public static int[] sort(int a[]) {
        int k = 0;
        int m = getMax(a);
        int bucket[] = new int[m + 1];

        for (int anA : a) bucket[anA]++;

        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) a[k++] = i;
        }
        return a;
    }

    private static int getMax(int a[]) {
        int max = Integer.MIN_VALUE;
        for (int anA : a) {
            max = Math.max(anA, max);
        }
        return max;
    }
}
