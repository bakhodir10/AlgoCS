package problems.easy;

public class ReachNumber_754 {

    public int reachNumber(int target) {
        target = Math.abs(target);
        
        int step = 0;
        int sum = 0;
        int i = 0;

        while (sum < target) {
            sum += ++i;
            step++;
        }
        if ((sum - target) % 2 == 0) return step;

        while ((sum - target) % 2 != 0) {
            sum += ++i;
            step++;
        }
        return step;
    }
}