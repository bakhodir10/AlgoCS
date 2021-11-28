package leetcode_problems.medium;

public class LongestPalindromicSubstring_5 {

    //  Time complexity: O(n). Space complexity: O(1)
    public String longestPalindrome(String s) {

        String max = String.valueOf(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i + 1 < s.length() && c == s.charAt(i + 1)) {
                String palindrome = isPalindromic(i, i + 1, s);
                if (max.length() < palindrome.length()) max = palindrome;
            }
            if (i + 2 < s.length() && c == s.charAt(i + 2)) {
                String palindrome = isPalindromic(i, i + 2, s);
                if (max.length() < palindrome.length()) max = palindrome;
            }
        }
        return max;
    }

    private String isPalindromic(int i, int j, String s) {
        char[] arr = s.toCharArray();
        while (i >= 0 && j < arr.length && arr[i] == arr[j]) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
