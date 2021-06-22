package leetcode_problems.medium;

public class SearchRotated_33 {

    public int search(int nums[], int t) {
        int l1 = 0, r1 = findMin(nums) - 1;
        int l2 = r1 + 1, r2 = nums.length - 1;
        int val1 = binarySearch(nums, l1, r1, t);
        int val2 = binarySearch(nums, l2, r2, t);
        return val1 == -1 && val2 == -1 ? -1 : val1 != -1 ? val1 : val2;
    }

    private int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (r + l) / 2;
            if (nums[m] > nums[r] && nums[m] >= nums[l]) l = m + 1;
            else r = m;
        }
        return l;
    }

    private int binarySearch(int nums[], int l, int r, int t) {
        if (l > r) return -1;
        int m = l + (r - l) / 2;
        if (nums[m] == t) return m;
        if (nums[m] > t) return binarySearch(nums, l, m - 1, t);
        else return binarySearch(nums, m + 1, r, t);
    }
}
