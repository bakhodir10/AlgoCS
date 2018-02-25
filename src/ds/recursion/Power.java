package ds.recursion;

public class Power {
    public static int power(int base, int exp) {
        if (exp == 0) return 1; // base case
        return base * power(base, exp - 1); // recursive case
    }
}
