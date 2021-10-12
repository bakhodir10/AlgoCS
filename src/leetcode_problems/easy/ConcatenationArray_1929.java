package leetcode_problems.easy;

public class ConcatenationArray_1929 {

    // Time complexity: O(n). Space complexity: O(n)
    public int[] getConcatenation(int[] nums) {
        int[] newArr = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) newArr[i] = newArr[i + nums.length] = nums[i % nums.length];
        return newArr;
    }
}
