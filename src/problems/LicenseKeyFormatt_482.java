package problems;

public class LicenseKeyFormatt_482 {
    public static String licenceKeyFormatting(String s, int k) {
        StringBuilder res = new StringBuilder();
        s = s.toUpperCase();
        s = s.replaceAll("-", "");
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count != k) {
                res.insert(0, s.charAt(i));
                count++;
            } else {
                res.insert(0, "-");
                i++;
                count = 0;
            }
        }
        return res.toString();
    }
}
