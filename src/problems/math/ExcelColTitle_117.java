package problems.math;

public class ExcelColTitle_117 {
    public static String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            n--;
            s.insert(0, (char) (n % 26 + 'A'));
            n /= 26;
        }
        return s.toString();
    }
}
