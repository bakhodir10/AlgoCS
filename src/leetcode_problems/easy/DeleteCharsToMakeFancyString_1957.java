package leetcode_problems.easy;

public class DeleteCharsToMakeFancyString_1957 {

    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(sb.length() < 2) sb.append(s.charAt(i));
            else if(s.charAt(i) != sb.charAt(sb.length() - 1)
                    || s.charAt(i) != sb.charAt(sb.length() - 2)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
