package skiena_book;

public class Ex3_28 {

    // approach 1. Time complexity O(n^2)
    public int[] solve(int[] arr) {
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) product *= arr[j];
            }
            res[i] = product;
        }
        return res;
    }

    // approach 2.
}