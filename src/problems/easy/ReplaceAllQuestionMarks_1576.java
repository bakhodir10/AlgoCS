package problems.easy;

public class ReplaceAllQuestionMarks_1576 {

    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '?') sb.append(s.charAt(i));
            else {
                char c = 'a';
                while ((i < s.length() - 1 && s.charAt(i + 1) == c) || (sb.length() > 0 && sb.charAt(sb.length() - 1) == c))
                    c++;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}