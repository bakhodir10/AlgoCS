package leetcode_problems.medium;

public class SortChars_451 {
    public static String frequencySort(String s) {
        int[] a = new int[250];
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < s.length(); i++) a[s.charAt(i)]++;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                int max = 0;
                char c1 = 0;
                for (int j = 0; j < a.length; j++) {
                    char c = (char) (j);
                    if (a[j] > max && b.indexOf(String.valueOf(c)) == -1) {
                        max = a[j];
                        c1 = (char) (j);
                    }
                }
                for (int k = 0; k < max; k++) {
                    b.append(c1);
                }
            }
        }
        return b.toString();
    }
}
