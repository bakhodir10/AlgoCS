package problems.bit_manipulation;

public class PowerOfFour_342 {
    public static boolean isPowerOfFour(int num) {
        if (num < 0) return false;
        String bin = Integer.toBinaryString(num);
        return Integer.bitCount(num) == 1 && (bin.length() - 1) % 2 == 0;
    }
}
