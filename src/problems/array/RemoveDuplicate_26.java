package problems.array;

public class RemoveDuplicate_26 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return nums.length;
        int i = 1, k = 0;
        nums[k++] = nums[0];
        while (i < nums.length) {
            if (nums[i] != nums[i - 1]) nums[k++] = nums[i];
            i++;
        }
        return k;
    }
}
