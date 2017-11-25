package ds.basics;

/*
    Question : an algorithm that calculates the greatest common divisor(GCD)
*/
public class GCD {

    //  first method to calculate
    public static int gcd1(int a, int b) {
        int counter = 0;
        while (a != b) {
            if (a > b) a -= b;
            if (a < b) b -= a;
            counter++;
        }
        return a;
    }

    //  second method to calculate
    public static int gcd2(int a, int b) {
        int counter = 0;
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
            counter++;
        }
        return a;
    }

    //    third method to calculate
    public static int gcd3(int a, int b) {
        return (b == 0) ? a : gcd3(b, a % b);
    }

}
