package problems.easy;

// todo not done
public class StringToInteger_8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("56-47"));
        System.out.println(Integer.parseInt("+-2"));
    }

    public static int myAtoi(String str) {
        int s = 0;
        boolean minus = false;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == '-') minus = true;
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') s = s * 10 + str.charAt(i) - '0';
        }
        return minus ? 0 - s : s;
    }
}
/*
    input: "+-2"
    output: 0
 */