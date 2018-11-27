package interviews;

public class ReverseString {

    // approach 1. Time complexity: O(n). Space complexity: O(n);
    public static String reverseByIteration(String s) {
        char c[] = s.toCharArray();

        for (int i = 0; i < c.length / 2; i++) {
            char temp = c[i];
            c[i] = c[c.length - 1 - i];
            c[c.length - 1 - i] = temp;
        }
        return new String(c);
    }

    // approach 2. Time complexity: O(n). Space complexity: O(n);
    public static String reverseByRecursion(String s) {
        if (s.length() == 0) return "";
        return reverseByRecursion(s.substring(1)) + s.charAt(0);
    }
}