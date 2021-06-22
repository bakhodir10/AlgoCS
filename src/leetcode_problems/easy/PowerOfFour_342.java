package leetcode_problems.easy;

public class PowerOfFour_342 {

    // approach 1
    public static boolean isPowerOfFour1(int num) {
        if (num < 0) return false;
        String bin = Integer.toBinaryString(num);
        return Integer.bitCount(num) == 1 && (bin.length() - 1) % 2 == 0;
    }

    // approach 2
    public static boolean isPowerOfFour2(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        if (num % 4 != 0) return false;
        return isPowerOfFour2(num / 4);
    }
}
