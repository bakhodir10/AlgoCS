package problems;

public class ValidAnagram_242 {
    public static boolean isAnagram(String s, String t) {
        StringBuilder a = new StringBuilder(s);
        for (int i = 0; i < t.length(); i++) {
            int index = a.indexOf(t.charAt(i) + "");
            if (index != -1) a.delete(index, index + 1);
            else return false;
        }
        return a.length() == 0;
    }
}
