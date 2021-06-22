package leetcode_problems.easy;

public class PalindromeNumber_9 {
    public static boolean isPalindrome(int number) {
        if (number < 0) return false;
        int temp = number, rev = 0;
        while (number != 0) {
            rev = rev * 10 + number % 10;
            number /= 10;
        }
        return temp == rev;
    }
}
