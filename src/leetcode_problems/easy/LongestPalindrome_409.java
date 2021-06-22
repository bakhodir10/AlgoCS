package leetcode_problems.easy;

public class LongestPalindrome_409 {

    public static int longestPalindrome(String s) {
        int[] arr = new int[128];
        int ans = 0;

        for (char c : s.toCharArray()) arr[c]++;
        boolean hasOdd = false;

        for (int count : arr) {
            ans += count / 2;
            if (count % 2 == 1) hasOdd = true;
        }
        return hasOdd ? ans * 2 + 1 : ans * 2;
    }
}