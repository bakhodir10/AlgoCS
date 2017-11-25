package problems.easy;

public class JudgeRouteCircle_657 {
    public static boolean judgeCircle(String moves) {
        int positive = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R') positive++;
            if (moves.charAt(i) == 'L') positive--;
            if (moves.charAt(i) == 'U') positive++;
            if (moves.charAt(i) == 'D') positive--;
        }
        return positive == 0;
    }
}
