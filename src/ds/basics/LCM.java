package ds.basics;

/*
    Question: an algorithm that calculate th least common multiple
 */
public class LCM {

    public static int lcm1(int a, int b){
        return (a * b) / gcd(a, b);
    }

    public static int gcd(int a, int b){
        return a == 0 ? a : gcd(a, a % b);
    }
}
