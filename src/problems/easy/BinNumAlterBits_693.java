package problems.easy;

public class BinNumAlterBits_693 {
    public static boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) return false;
        }
        return true;
    }
}
