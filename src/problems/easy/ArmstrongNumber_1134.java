package problems.easy;

public class ArmstrongNumber_1134 {

    // Time complexity: O(n -> digits count). Space complexity: O(1)
    public boolean isArmstrong(int n) {
        int sum = 0, count = 0, temp = n;

        while (temp != 0) {
            count++;
            temp /= 10;
        }
        temp = n;
        while (temp != 0) {
            int num = temp % 10;
            sum += Math.pow(num, count);
            temp /= 10;
        }
        return sum == n;
    }
}
