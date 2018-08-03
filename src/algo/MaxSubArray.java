package algo;
/*
    Find an subarray of given array that sums up the biggest value
 */
@SuppressWarnings("Duplicates")
public class MaxSubArray {

    /*
        Algorithm 1: straightforward way to solve the problem is to go through all possible subarrays,
        calculate the sum of values in each subarray and maintain the maximum sum.
        Time complexity: O(n^3)
     */
    public static int findMaxSubArray1(int arr[]) {

        int best = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                best = Math.max(best, sum);
            }
        }
        return best;
    }

    /*
        Algorithm 2: we can get rid of one loop.
        Time complexity: O(n^2)
     */
    public static int findMaxSubArray2(int arr[]) {
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                best = Math.max(best, sum);
            }
        }
        return best;
    }

    /*
        Algorithm 3: Find a sum of numbers for at position k. If found sum is bigger than best, then best is found sum.
        Time complexity: O(n)
     */
    public static int findMaxSubArray3(int arr[]) {
        int sum = 0;
        int best = Integer.MIN_VALUE;
        for (int anArr : arr) {
            sum = Math.max(sum, sum + anArr);
            best = Math.max(best, sum);
        }
        return best;
    }
}