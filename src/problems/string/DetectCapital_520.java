package problems.string;

public class DetectCapital_520 {
    public static boolean detectCapitalUse(String s) {
        if (s == null) return false;
        int countUp = 0, countLow = 0;
        boolean firstUp = s.charAt(0) >= 'A' && s.charAt(0) <= 'Z';

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') countUp++;
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') countLow++;
        }
        return (firstUp && countLow == s.length() - 1) || countUp == s.length() || countLow == s.length();
    }
}
