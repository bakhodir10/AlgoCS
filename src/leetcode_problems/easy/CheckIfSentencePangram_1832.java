package leetcode_problems.easy;

public class CheckIfSentencePangram_1832 {

    // Time complexity: O(n). Space complexity: O(1)
    public boolean checkIfPangram(String sentence) {
        boolean[] arr = new boolean[26];
        for (char c : sentence.toCharArray()) arr[c - 'a'] = true;
        for (boolean b : arr) {
            if (!b) return false;
        }
        return true;
    }
}