package problems.string;

public class ValidPalindrome_125 {
    public static boolean isPalindrome(String s) {
        StringBuilder b = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= '0' && s.charAt(i) <= '9')
                b.append(s.charAt(i));
        }
        return b.toString().equals(b.reverse().toString());
    }
}
