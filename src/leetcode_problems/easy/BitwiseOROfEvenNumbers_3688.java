package leetcode_problems.easy;

public class BitwiseOROfEvenNumbers_3688 {

    public int evenNumberBitwiseORs(int[] nums) {
        if(nums.length == 0) return 0;
        int xor = 0;

        for(int num: nums) {
            if(num % 2 == 0) xor |= num;
        }
        return xor;
    }
}
