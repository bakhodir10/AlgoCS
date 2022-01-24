package leetcode_problems.easy;

public class FindFirstPalindromic_5956 {

    // Time complexity: O(n). Space complexity: O(1)
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (word.equals(new StringBuilder(word).reverse().toString())) return word;
        }
        return "";
    }
}
