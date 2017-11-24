package problems.easy;

/*
    Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 */
public class SumofTwo_371 {
    public static int getSum(int a, int b){
        return a & b;
    }
    public static void main(String args[]){
        System.out.println(getSum(1, 2));
    }
}
