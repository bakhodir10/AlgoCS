package leetcode_problems.medium;

public class SortColors_75 {

    // Time complexity: O(n). Space complexity: O(1)
    public void sortColors(int[] nums) {
        int countRed = 0, countWhite = 0, countBlue = 0;

        for (int num : nums) {
            if (num == 0) countRed++;
            if (num == 1) countWhite++;
            if (num == 2) countBlue++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (countRed-- > 0) nums[i] = 0;
            else if (countWhite-- > 0) nums[i] = 1;
            else if (countBlue-- > 0) nums[i] = 2;
        }
    }
}
