package timus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anindilyakwa_1777 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        List<Long> list = new ArrayList<>();
        list.add(x.nextLong());
        list.add(x.nextLong());
        list.add(x.nextLong());
        long d = Long.MAX_VALUE;
        long count = 1;
        while (true) {
            for (int i = 1; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (Math.abs(list.get(i) - list.get(j)) <= d && i != j) {
                        d = Math.abs(list.get(i) - list.get(j));
                    }
                }
            }
            if (d != 0) {
                list.add(d);
                d = Long.MAX_VALUE;
                count++;
            } else {
                System.out.println(count);
                return;
            }
        }
    }
}
