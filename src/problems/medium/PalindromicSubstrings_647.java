package problems.medium;

public class PalindromicSubstrings_647 {

    public int countSubstrings(String s) {
        char[] c = s.toCharArray();
        int count = 0;

        for (int i = 0; i < c.length; i++) {
            count += findPalindromeCount(c, i, i); // case: aaa
            count += findPalindromeCount(c, i, i + 1); // case: caac
        }
        return count;
    }

    private int findPalindromeCount(char[] c, int a, int b) {
        int count = 0;

        while (a >= 0 && b < c.length && c[a] == c[b]) {
            count++;
            a--;
            b++;
        }
        return count;
    }
}
