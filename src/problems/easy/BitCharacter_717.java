package problems.easy;

public class BitCharacter_717 {

    public boolean isOneBitCharacter(int[] bits) {
        boolean res = false;
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 1) {
                res = false;
                i += 2;
            } else {
                res = true;
                i++;
            }
        }
        return res;
    }
}
