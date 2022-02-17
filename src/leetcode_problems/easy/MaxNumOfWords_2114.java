package leetcode_problems.easy;

public class MaxNumOfWords_2114 {

    // Time complexity: O(n). Space complexity: O(1);
    public int mostWordsFound(String[] sentences) {
        int max = 0;

        for (String sentence : sentences) {
            int len = sentence.split(" ").length;
            max = Math.max(max, len);
        }
        return max;
    }
}
