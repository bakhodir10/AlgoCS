package problems;

public class FindDiff_389 {
    public static char findTheDifference(String s, String t) {
        char a[] = new char[26], b[] = new char[26];
        for (int i = 0; i < t.length(); i++) {
            if (i < s.length()) a[s.charAt(i) - 'a']++;
            b[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return (char) (i + 'a');
        }
        return '.';
    }
}