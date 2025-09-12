package leetcode_problems.medium;

public class FindPeakElement_162 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int findPeakElement(int[] nums) {
        if(nums.length <= 1) return 0;

        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length - 2] < nums[nums.length - 1]) return nums.length - 1;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) return i;
        }
        return -1;
    }

    // Time complexity: O(log(n))
    // Space complexity: O(1)
    public int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
