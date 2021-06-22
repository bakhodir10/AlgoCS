package leetcode_problems.easy;

public class ValidPerfectSquare_367 {
    
    public static boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
