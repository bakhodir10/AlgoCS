package leetcode_problems.easy;

public class SingleNumber_136 {
    public static int singleNumber(int a[]) {
        if(a.length == 0) return -1;
        int single = a[0];
        for (int i = 1; i < a.length; i++) {
            single ^= a[i];
        }
        return single;
    }
}
