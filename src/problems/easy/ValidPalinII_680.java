package problems.easy;

public class ValidPalinII_680 {

    public static boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int i = 0, j = s.length() - 1;
        char c[] = s.toCharArray();
        while (i < j) {
            if (c[i] != c[j]) {
                return isPalindrome(c, i + 1, j) || isPalindrome(c, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isPalindrome(char c[], int start, int end) {
        while (start < end) {
            if (c[start] != c[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}