package leetcode_problems.medium;

public class RemoveDuplicate_80 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return nums.length;
        int size, k = 0, count = 1, i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) count++;
            else {
                size = count > 2 ? 2 : count;
                for (int j = 0; j < size; j++) nums[k++] = nums[i - 1];
                count = 1;
            }
            i++;
        }
        size = count > 2 ? 2 : count;
        for (int j = 0; j < size; j++) {
            nums[k++] = nums[nums.length - 1];
        }
        return k;
    }
}
