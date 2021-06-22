package leetcode_problems.easy;

public class DecodeXORedArray_1720 {

    // Time complexity: O(n). Space complexity: O(n)
    public int[] decode(int[] encoded, int first) {
        int[] newArr = new int[encoded.length + 1];
        newArr[0] = first;
        for (int i = 1; i < newArr.length; i++) newArr[i] = encoded[i - 1] ^ newArr[i - 1];
        return newArr;
    }
}
