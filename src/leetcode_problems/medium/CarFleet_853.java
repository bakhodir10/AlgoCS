package leetcode_problems.medium;

import java.util.Arrays;

public class CarFleet_853 {

    public static class Car {
        int pos;
        double time;

        public Car(int pos, double time) {
            this.pos = pos;
            this.time = time;
        }
    }

    // Time complexity: O(nlogn)
    // Space complexity: O(n)
    public int carFleet(int target, int[] position, int[] speed) {
        int fleets = 0;
        Car[] cars = new Car[position.length];

        for(int i = 0; i < position.length; i ++) {
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }

        Arrays.sort(cars, (e1, e2) -> e2.pos - e1.pos);

        double maxTime = -1.00;
        for(Car c: cars) {
            if(c.time > maxTime) {
                fleets++;
                maxTime = c.time;
            }
        }
        return fleets;
    }
}
