package problems.easy;

public class KthMissingPositiveNum_1539 {

    // Time complexity O(n). Space complexity O(n)
    public int findKthPositive1(int[] arr, int k) {
        boolean[] bucket = new boolean[1001];
        for (int num : arr) bucket[num] = true;

        for (int i = 0; i < bucket.length; i++) {
            if (!bucket[i]) k--;
            if (k == -1) return i;
        }
        return k + bucket.length;
    }

    // Time complexity O(log(n)). Space complexity O(1). Using binary search
    public int findKthPositive2(int[] a, int k) {
        int l = 0, r = a.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] - (m + 1) < k) l = m + 1;
            else r = m;
        }
        return l + k;
    }
}