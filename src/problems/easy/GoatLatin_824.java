package problems.easy;

public class GoatLatin_824 {
    public static String toGoatLatin(String s) {
        String words[] = s.split(" ");
        StringBuilder ans = new StringBuilder();
        int i = 1;
        for (String w : words) {
            if (w.toLowerCase().startsWith("a") || w.toLowerCase().startsWith("e") ||
                    w.toLowerCase().startsWith("i") || w.toLowerCase().startsWith("o") ||
                    w.toLowerCase().startsWith("u")) {
                w = w.concat("ma");
            } else {
                char c = w.charAt(0);
                w = w.substring(1);
                w = w.concat(c + "");
                w = w.concat("ma");
            }
            int j = 0;
            while (j < i) {
                w = w.concat("a");
                j++;
            }
            i++;
            ans.append(w).append(" ");
        }

        ans.delete(ans.length() - 1, 1);
        return ans.toString();
    }
}
