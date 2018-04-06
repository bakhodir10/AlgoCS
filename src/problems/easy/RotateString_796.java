package problems.easy;

public class RotateString_796 {

    // version 1
    public static boolean rotateString1(String a, String b) {
        return a.length() == b.length() && (a + a).contains(b);
    }

    //version 2
    public static boolean rotateString2(String a, String b) {
        if (a == null || b == null) return false;
        if (a.isEmpty() && b.isEmpty()) return true;
        else if (a.isEmpty() || b.isEmpty()) return false;

        int i = 0;
        while (i < a.length()) {
            char c = a.charAt(0);
            a = a.substring(1);
            a = a.concat(c + "");

            if (a.equals(b)) return true;
            i++;
        }
        return false;
    }
}
