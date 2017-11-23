package judge.acmp.linear;

import java.util.Scanner;

public class ZerosSequence {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        String text = x.next();
        int count = 1, max = 0;
        boolean exist = false;
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == '0' && text.charAt(i - 1) == text.charAt(i)) {
                exist = true;
                count ++;
            }
            else count = 1;
            if(count > max) max = count;
        }
        System.out.println(!exist ? 0 : max);
    }
}
