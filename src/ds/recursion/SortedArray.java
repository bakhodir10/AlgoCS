package ds.recursion;

public class SortedArray {
    public static boolean isArraySorted(int[] nums, int index) {
        // base case
        if (index == 0) {
            return true;
        } else {      // recursive case
            if (nums[index] < nums[index - 1]) return false;
            return isArraySorted(nums, index - 1);
        }
    }
}