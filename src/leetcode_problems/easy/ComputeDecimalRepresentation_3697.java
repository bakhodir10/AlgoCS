package leetcode_problems.easy;

import java.util.ArrayList;
import java.util.List;

public class ComputeDecimalRepresentation_3697 {

    public int[] decimalRepresentation(int n) {
        List<Integer> list = new ArrayList<>();
 
        while(n != 0) {
            String s = String.valueOf(n);
            int curr = (s.charAt(0) - '0') * (int)(Math.pow(10, s.length() - 1));
            list.add(curr);
            n -= curr;
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i ++) result[i] = list.get(i);
        return result;
    }
}
