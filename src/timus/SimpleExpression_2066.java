package timus;

public class SimpleExpression_2066 {
    public static int findMinOutcome(int a, int b, int c){
        return a - ((b * c) > (b + c) ? (b * c) : (b + c));
    }
}
