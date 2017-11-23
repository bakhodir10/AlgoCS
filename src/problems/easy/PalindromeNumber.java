package problems.easy;

public class PalindromeNumber {
    public static boolean isPalindrome(int number){
        if (number < 0) return false;
        int temp = number;
        long rev = 0;
        while (number != 0){
            rev = rev * 10 + number % 10;
            number /= 10;
        }
        return temp == rev;
    }
}
