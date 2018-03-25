package problems.string;

public class ReverseWords_557 {
    public static String reverse(String s) {
        String s1[] = s.split(" ");
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s1.length - 1; i++) {
            b.append(new StringBuilder(s1[i]).reverse()).append(" ");
        }
        b.append(new StringBuilder(s1[s1.length - 1]).reverse());
        return b.toString();
    }
}
