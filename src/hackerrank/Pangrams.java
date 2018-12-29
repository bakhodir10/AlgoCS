package hackerrank;

public class Pangrams {

    static String pangrams(String s) {
        int[] a = new int[26];
        s = s.toLowerCase();

        for (char c : s.toCharArray()) {
            if (c != ' ') a[c - 'a']++;
        }
        for (int i : a) {
            if (i == 0) return "not pangram";
        }
        return "pangram";
    }
}

