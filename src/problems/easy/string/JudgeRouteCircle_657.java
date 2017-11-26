package problems.easy.string;

public class JudgeRouteCircle_657 {
    public static boolean judgeCircle(String moves) {
        int count = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R') count++;
            if (moves.charAt(i) == 'L') count--;
            if (moves.charAt(i) == 'U') count++;
            if (moves.charAt(i) == 'D') count--;
        }
        return count == 0;
    }
}
