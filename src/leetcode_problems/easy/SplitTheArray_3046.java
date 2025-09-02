package leetcode_problems.easy;

public class SplitTheArray_3046 {

    // Time complexity: O(n)
    // Space complexity: (1)
    public boolean isPossibleToSplit(int[] nums) {
        int[] counts = new int[101];

        for(int num: nums) counts[num]++;
        for(int count: counts) {
            if(count > 2) return false;
        }
        return true;
    }
}
