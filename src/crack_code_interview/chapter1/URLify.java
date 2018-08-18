package crack_code_interview.chapter1;

/*
    URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string
    has sufficient space at the end to hold the additional characters, and that you are given the "true"
    length of the string.
 */

public class URLify {

    // Time complexity O(n). Space complexity O(n)
    public static String urlify(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') builder.append(c);
            else builder.append("%20");
        }
        return builder.toString();
    }
}
