package problems.easy;

public class PerfectNumber_507 {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        long sum = 1;
        int i = 2, maxNum = num;
        while (i < maxNum) {
            if (num % i == 0) {
                maxNum = num / i;
                sum += i;
                sum += maxNum;
            }
            if (sum > num) return false;
            i++;
        }
        return sum == num;
    }
}
