package problems.easy;

public class NumberOfGoodPairs_1512 {

    // Time complexity: O(n^2). Space complexity: O(1);
    public int numIdenticalPairs1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) count++;
            }
        }
        return count;
    }

    // Time complexity: O(n). Space complexity: O(n);
    public int numIdenticalPairs2(int[] nums) {
        int[] count = new int[101];
        int total = 0;

        for (int num : nums) {
            total += count[num];
            count[num]++;
        }
        return total;
    }
}
