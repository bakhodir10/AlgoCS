package ds.recursion;

public class Palindrome {

    public static boolean isPalindrome1(String s, int from, int end) {
        if (s == null) return false;
        if (s.charAt(from) != s.charAt(end)) return false;
        if (from >= end) return true;
        return isPalindrome1(s, from + 1, end - 1);
    }

    public static boolean isPalindrome2(String s) {
        if (s.length() < 2) return true;
        else {
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            if (first == last) {
                String rest = s.substring(1, s.length() - 2);
                return isPalindrome2(rest);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome1("aziza", 0, 4));
        System.out.println(isPalindrome2("aziza"));
    }
}
