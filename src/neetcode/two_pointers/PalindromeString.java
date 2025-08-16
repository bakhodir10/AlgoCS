package neetcode.two_pointers;

public class PalindromeString {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        s = sb.toString();
        return sb.reverse().toString().equals(s);
    }

    // Using two pointers
    // Time complexity: O(n)
    // Space complexity: O(1)
    public boolean isPalindrome2(String s) {
        int i = 0, j = s.length() - 1;

        while(i < j) {
            while(i < j && !isAlphaNumberic(s.charAt(i))) {
                i++;
            }
            while(i < j && !isAlphaNumberic(s.charAt(j))) {
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphaNumberic(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }
}
