package problems.easy.string;

public class ReverseString_344 {
    public static String reverseString(String s) {
        StringBuilder build = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            build.append(s.charAt(i));
            i--;
        }
        return build.toString();
//        return new StringBuilder(s).reverse().toString();
    }
}
