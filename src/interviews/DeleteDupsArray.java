package interviews;

/*
    Delete all the duplicates in given unsorted array. Delete means moving an element to the end of the array.
    Can you do it in-place and without using any additional memory ?
    Input: 2 6 2 5 2 3 7 5
    Output: 2 6 5 3 7
 */

import java.util.Arrays;

public class DeleteDupsArray {

    // Approach 1. Time Complexity: O(n^2). Space complexity: O(1)
    public static int[] deleteDups(int nums[]) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }
        return nums;
    }
}
