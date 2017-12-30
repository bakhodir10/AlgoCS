package hackerrank;

public class LeftRotation {
    public static int[] leftRotation(int n, int r, int a[]) {
        int newArray[] = new int[n];
        for (int i = r; i < r + a.length; i++) {
            if (i < n) newArray[i] = a[i];
            else newArray[i-n] = newArray[i - n];
        }
        return newArray;
    }
}
