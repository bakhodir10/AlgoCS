package problems.medium;

// todo not done
public class DecodeString_394 {
    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        int i = 0;
        StringBuilder b = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) >= '1' || s.charAt(i) <= '9') {
                int j = 0, k = i + 2, num = s.charAt(i) - '0';
                System.out.println(num);
                StringBuilder sb = new StringBuilder();
                while (s.charAt(k) != ']' || s.charAt(k) > '9')
                    sb.append(s.charAt(k++));
                while (j < num) {
                    b.append(sb);
                    j++;
                }
                i = ++k;
            }
        }
        return b.toString();
    }
}
