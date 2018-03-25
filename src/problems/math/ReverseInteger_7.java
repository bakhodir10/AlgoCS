package problems.math;

public class ReverseInteger_7 {
    public static int reverse(int number){
        long rev = 0;
        while (number != 0){
            rev = rev * 10 + number % 10;
            number /= 10;
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) return 0;
        return (int)rev;
    }
}