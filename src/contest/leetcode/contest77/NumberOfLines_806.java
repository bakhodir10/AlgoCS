package contest.leetcode.contest77;

public class NumberOfLines_806 {
    public static int[] numberOfLines(int[] widths, String s) {
        int unit = 1, sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = widths[s.charAt(i) - 'a'];
            if (sum + c > 100) {
                unit++;
                sum = c;
            } else sum += c;
        }
        return new int[]{unit, sum};
    }
}
