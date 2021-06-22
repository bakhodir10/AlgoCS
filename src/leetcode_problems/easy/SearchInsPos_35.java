package leetcode_problems.easy;

public class SearchInsPos_35 {

    //approach 1
    public static int searchInsert1(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    private static int binarySearch(int left, int right, int a[], int target) {
        int mid = (right + left) / 2;
        if (left > right) return left;
        else if (a[mid] == target) return mid;
        else if (a[mid] > target) return binarySearch(0, mid - 1, a, target);
        return binarySearch(mid + 1, right, a, target);
    }

    // approach 2
    public static int searchInsert2(int[] nums, int target) {
        int i = 0;
        while (i < nums.length && nums[i] < target) {
            i++;
        }
        return i;
    }
}
