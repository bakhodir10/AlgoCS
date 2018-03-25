package problems.string;

public class AddBinary_67 {
    public static String addBinary(String a, String b) {
        StringBuilder build = new StringBuilder();

        if (a.length() > b.length()) b = fill(b, a.length() - b.length());
        else a = fill(a, b.length() - a.length());
        int remainder = 0, sum;
        for (int i = a.length() - 1; i >= 0; i--) {
            sum = a.charAt(i) - '0' + b.charAt(i) - '0';
            int k = 0;
            if (sum == 2) {
                sum = 0;
                k = 1;
            }
            if (sum + remainder == 2) k = 1;
            build.insert(0, sum + remainder == 2 ? 0 : sum + remainder);
            remainder = k;
        }
        if (remainder == 1) build.insert(0, 1);
        return build.toString();
    }

    private static String fill(String a, int n) {
        StringBuilder b = new StringBuilder(a);
        for (int i = 0; i < n; i++) {
            b.insert(0, 0);
        }
        return b.toString();
    }
}
