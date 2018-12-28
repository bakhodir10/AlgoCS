package problems.easy;

public class NRepeated_961 {

    public int repeatedNTimes(int[] a) {
        int i = 0, j = 0;
        while (i == j || a[i] != a[j]) {
            i = (int) (Math.random() * a.length);
            j = (int) (Math.random() * a.length);
        }
        return a[i];
    }
}