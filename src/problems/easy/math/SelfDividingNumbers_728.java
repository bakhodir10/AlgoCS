package problems.easy.math;

import java.util.LinkedList;
import java.util.List;

public class SelfDividingNumbers_728 {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            int num = i;
            int div = i % 10;
            boolean b = true;
            while (num != 0) {
                if(div == 0) {
                    b = false;
                    break;
                }
                if (i % div != 0) {
                    b = false;
                    break;
                }
                num /= 10;
                div = num % 10;
            }
            if (b) list.add(i);
        }
        return list;
    }
}
