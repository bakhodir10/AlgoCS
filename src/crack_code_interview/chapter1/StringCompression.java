package crack_code_interview.chapter1;

/*
    String Compression: Implement a method to perform basic string compression using the counts
    of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
    "compressed" string would not become smaller than the original string, your method should return
    the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */

public class StringCompression {

    // Time complexity: O(n). Space complexity: O(n)
    public static String stringCompression1(String s) {
        StringBuilder res = new StringBuilder();
        int counter = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                res.append(s.charAt(i - 1)).append(counter);
                counter = 1;
            } else counter++;
        }
        res.append(s.charAt(s.length() - 1)).append(counter);
        return res.toString();
    }

    // Time complexity: O(n). Space complexity: O(n)
    public static String stringCompression2(String s) {

        StringBuilder res = new StringBuilder();
        char prev = s.charAt(0);
        int counter = 1;

        for (char c : s.toCharArray()) {
            if (c == prev) counter++;
            else {
                res.append(prev).append(counter);
                prev = c;
                counter = 1;
            }
        }
        res.append(prev).append(counter);
        return res.toString();
    }
}
