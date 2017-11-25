package ds.basics;

public class Fibonacci {

    public static int fibonacci(int n){
        if (n <= 1) return  n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int findMinFibonacci(int n){
        int s = 0, a1 = 0, a2 = 1;
        while(s + a1 <= n){
            s = a1 + a2;
            a1 = a2;
            a2 = s;
        }
        return s;
    }

    public static int findFibonacciNumber(int n){
        if (n == 1) return 0;
        if (n == 2) return 1;
        int a1 = 0, a2 = 1, i = 2, res = 0;
        while (i != n){
            res = a1 + a2;
            a1 = a2;
            a2 = res;
            i++;
        }
        return res;
    }


    public static void showFibonacciNumbers(int n){
        int i = 2, a1 = 0, a2 = 1, res = 0;
        while (i != n){
            res = a1 + a2;
            a1 = a2;
            a2 = res;
            i ++;
            System.out.println(res);
        }
    }
}
