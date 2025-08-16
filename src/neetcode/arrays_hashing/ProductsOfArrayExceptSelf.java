package neetcode.arrays_hashing;

import java.util.Arrays;

public class ProductsOfArrayExceptSelf {

    // Using division operation
    // Time complexity: O(n). n-> the length of the array
    // Space complexity: O(1)
    public int[] productExceptSelf1(int[] nums) {
        int total = 1;
        int zeroCount = 0, zeroIndex = -1;

        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            }
            if(zeroCount > 1) {
                Arrays.fill(nums, 0);
                return nums;
            }
            if(nums[i] != 0) total *= nums[i];
        }

        for(int i = 0; i < nums.length; i ++) {
            if(zeroIndex == i) nums[i] = total;
            else if(zeroIndex != -1) nums[i] = 0;
            else nums[i] = total / nums[i];
        }
        return nums;
    }

    // Without division operation
    // Time complexity: O(n). n-> the length of the array
    // Space complexity: O(n)
    public int[] productExceptSel2(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = nums[0];
        postfix[nums.length - 1] = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++) prefix[i] = prefix[i - 1] * nums[i];
        for(int i = nums.length - 2; i >= 0; i--) postfix[i] = postfix[i + 1] * nums[i];

        for(int i = 0; i < nums.length; i ++) {
            int before = i == 0 ? 1: prefix[i - 1];
            int after = i == nums.length - 1 ? 1 : postfix[i + 1];
            nums[i] = before * after;
        }
        return nums;
    }
}
