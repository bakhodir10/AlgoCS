package problems.easy;

public class LongestPalindrome_409 {
    public static int longestPalindrome(String s) {
        int arr[] = new int[60];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) arr[s.charAt(i) - 'A']++;

        boolean one = false;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] == 1) && ((char) (i + 'A') >= 'A' && (char) (i + 'A') <= 'Z'
                    || (char) (i + 'A') >= 'a' && (char) (i + 'A') <= 'z'))
                one = true;
            if (arr[i] % 2 == 0) ans += arr[i];
            else {
                one = true;
                ans += arr[i] - 1;
            }
        }
        return one ? ++ans : ans;
    }
}
