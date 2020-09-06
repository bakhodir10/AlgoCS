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

    // todo
    // Time complexity O(log(n)). Space complexity O(1). Using binary search
    public int findKthPositive2(int[] arr, int k) {
        return -1;
    }
}