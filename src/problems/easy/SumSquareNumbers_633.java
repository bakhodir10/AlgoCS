package problems.easy;

// todo not done
public class SumSquareNumbers_633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(10));
    }

    public static boolean judgeSquareSum(int c){
        for (int i = 0; i <= c; i++) {
            if (i * i == c - (i * i)) return true;
        }
        return false;
    }
}
