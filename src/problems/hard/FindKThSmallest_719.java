package problems.hard;

public class FindKThSmallest_719 {

    public static int smallestDistancePair(int[] nums, int k) {

        int arr[] = new int[1000001];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                arr[Math.abs(nums[i] - nums[j])]++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int count = arr[i];
            for (int j = 0; j < count; j++) {
                k--;
                if (k == 0) return i;
            }
        }
        return -1;
    }
}
