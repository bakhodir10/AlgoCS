package leetcode_problems.medium;

public class DotProductTwoSparse_1570 {

    public int[] arr;

    DotProductTwoSparse_1570(int[] nums) {
        this.arr = nums;
    }

    // Return the dotProduct of two sparse vectors
    // Time complexity: O(n). Space complexity: O(n)
    public int dotProduct(DotProductTwoSparse_1570 vec) {
        int total = 0;
        int[] vecArr = vec.arr;
        for (int i = 0; i < this.arr.length; i++) {
            total += this.arr[i] * vecArr[i];
        }
        return total;
    }
}
