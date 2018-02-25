package ds.recursion;

public class Factorial {

    public static int factorial(int n) {
        if (n == 1) return 1; // base case
        else return n * factorial(n - 1); // recursive case
    }

     /*
            How it works !

        4 -> else condition works, 4 * 3! and calls itself again
        3 -> else condition works, 3 * 2! and calls itself again
        2 -> else condition works, 2 * 1! and calls itself again
        1 -> if condition works, returns value 1;

        Now, we know 1! = 1. Once it reaches the base case, it goes up again.
        2 * 1! = 2 * 1 = 2;
        3 * 2! = 3 * 2 = 6;
        4 * 3! = 4 * 6 = 24;

     */

    public static void main(String[] args) {
        System.out.println(factorial(4));
    }
}
