package timus;
import java.util.*;

public class TurnForMega_1787 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int  i, b = x.nextInt(), n = x.nextInt(), q = 0;
        for(i = 0; i < n; i++) {
              int a = x.nextInt();
            if(a + q > b) q = - b + a + q; else q = 0;
        }
        System.out.println(q);
    }
}
