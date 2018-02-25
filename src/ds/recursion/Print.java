package ds.recursion;

public class Print {

    public static int print(int n) {
        // base case
        if (n == 0) {
            return 0;
        }
        // recursive case
        else {
            System.out.println(n);
            return print(n - 1);
        }
    }

    /*
            How it works !
        let's say n = 4

        5 -> else condition works, prints 5 and calls function itself with value 5 - 1 = 4
        4 -> else condition works, prints 4 and calls function itself with value 4 - 1 = 3
        3 -> else condition works, prints 3 and calls function itself with value 3 - 1 = 2
        2 -> else condition works, prints 2 and calls function itself with value 2 - 1 = 1
        1 -> else condition works, prints 1 and calls function itself with value 1 - 1 = 0
        0 -> if condition works, just terminates loop.
     */
}
