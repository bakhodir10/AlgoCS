package ds.recursion;

public class PrintBinary {
    public static void printBinary(int n) {
        // base case
        if (n < 2) {
            System.out.print(n);
        } else {    // recursive case
            // this is similar to stack.push(n / 2);
            printBinary(n / 2);
            // this method waits until printBinary(n / 2) gets done
            // this is similar to invoke stack.pop(n);
            printBinary(n % 2);
        }
    }

    /*
            how it works
         it is given n = 8;

        n = 8 else condition works
        n = 4 else condition works
        n = 2 else condition works
        n = 1 else condition works
       coming to this step base case works and then algorithm goes up again

       n = 1 if condition works, just prints value 1
       n = 2 else condition printBinary(n % 2) method works, it calls method itself with value 2 % 2 = 0
       and once method has been called it reaches base and just prints value 0;
       n = 4 else condition printBinary(n % 2) method works, it calls method itself with value 4 % 2 = 0
       and once method has been called it reaches base and just prints value 0;
       n = 8 else condition printBinary(n % 2) method works, it calls method itself with value 8 % 2 = 0
       and once method has been called it reaches base and just prints value 0;

       Finally we have got 1000 result
     */
}
