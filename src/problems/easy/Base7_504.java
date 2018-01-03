package problems.easy;

public class Base7_504 {
    public static String convertToBase7(int num) {
        long s = 1;
        int i = 0;
        boolean isNegative = false;
        if (num < 0) {
            num = -num;
            isNegative = true;
        }
        StringBuilder b = new StringBuilder();
        while (s * 7 <= num) {
            s *= 7;
            i++;
        }
        while (i >= 0) {
            b.append((int) (num / Math.pow(7, i)));
            num = (int) (num % Math.pow(7, i));
            i--;
        }
        if (isNegative) b.insert(0, "-");
        return b.toString();
    }
}
