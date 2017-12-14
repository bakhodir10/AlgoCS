package problems.easy;

// todo not done
public class RotateArray_189 {
    public static void main(String[] args) {
        rotate1(new int[]{2, 1}, 1);
    }

    public static void rotate1(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            arr[i] = arr[k % arr.length + i];

        }
    }
}
