package timus;

public class Flags_1225 {
    public static long countFlags(int n){
        long a[] = new long[n + 1];
        a[0] = 2;
        a[1] = 2;
        for (int i = 2; i < a.length; i++) a[i] = a[i - 2] + a[i - 1];
        return a[n - 1];
    }
}
