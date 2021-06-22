package leetcode_problems.easy;

public class SortArrByParity_905 {

    public int[] sortArrayByParity(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (a[i] % 2 == 0) i++;
            else {
                if (a[j] % 2 == 0) swap(a, i++, j);
                else j--;
            }
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
}
