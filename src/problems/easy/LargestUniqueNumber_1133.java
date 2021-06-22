package problems.easy;

public class LargestUniqueNumber_1133 {

    // Time complexity: O(n). Space complexity: O(1)
    public int largestUniqueNumber(int[] nums) {
        int[] counts = new int[1001];

        for (int num : nums) counts[num]++;

        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] == 1) return i;
        }
        return -1;
    }
}
