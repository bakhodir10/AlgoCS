package leetcode_problems.easy;

public class RotatedDigits_788 {
    public int rotatedDigits(int n) {
        int count = 0;
        outer:
        for (int i = 1; i <= n; i++) {
            int d = 0;
            for (char c : String.valueOf(i).toCharArray()) {
                if (c == '3' || c == '4' || c == '7') continue outer;
                if (c == '2' || c == '5' || c == '6' || c == '9') d = 1;
            }
            count += d;
        }
        return count;
    }
}
