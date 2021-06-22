package leetcode_problems.medium;

public class NumberOfSubArrays_1343 {

    // Time complexity: O(n). Space complexity: O(1)
    public int numOfSubArrays(int[] arr, int k, int threshold) {
        int count = 0, sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                if (sum * 1.0 / k >= threshold) count++;
                sum -= arr[i + 1 - k];
            }
        }
        return count;
    }
}
