package problems.string;

public class ComplexNumber_537 {
    public static String complexNumberMultiply(String a, String b) {
        int plusIndex = a.indexOf("+");
        Integer x1 = Integer.parseInt(a.substring(0, plusIndex));
        int iIndex = a.indexOf("i");
        Integer y1 = Integer.parseInt(a.substring(plusIndex + 1, iIndex));

        int plusIndexB = b.indexOf("+");
        Integer x2 = Integer.parseInt(b.substring(0, plusIndexB));
        int iIndexB = b.indexOf("i");
        Integer y2 = Integer.parseInt(b.substring(plusIndexB + 1, iIndexB));

        Integer sum1 = x1 * x2 + (y1 * y2) * -1;
        Integer sum2 = x1 * y2 + y1 * x2;

        return String.valueOf(sum1) + "+" + sum2 + "i";
    }
}
