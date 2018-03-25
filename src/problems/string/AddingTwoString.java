package problems.string;


public class AddingTwoString {
    public static String add(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 < len2) num1 = fill(num1, len2 - len1);
        else num2 = fill(num2, len1 - len2);

        StringBuilder result = new StringBuilder();
        int remainder = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int value = num1.charAt(i) - '0' + num2.charAt(i) - '0' + remainder;
            result.insert(0, String.valueOf(value % 10));
            remainder = value / 10;
        }
        if (remainder == 1) result.insert(0, 1);
        return result.toString();
    }

    private static String fill(String s, int c) {
        int i = 0;
        StringBuilder temp = new StringBuilder(s);
        while (i < c) {
            temp.insert(0, '0');
            i++;
        }
        return temp.toString();
    }
}
