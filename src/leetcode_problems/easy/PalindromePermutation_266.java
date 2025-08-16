package leetcode_problems.easy;

public class PalindromePermutation_266 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public boolean canPermutePalindrome(String s) {
        int res = 0;
        int[] counts = new int[26];

        for(char c: s.toCharArray()) counts[c - 'a'] ++;
        for(int count: counts) res += count % 2;

        return res <= 1;
    }
}
