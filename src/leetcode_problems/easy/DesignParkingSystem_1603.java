package leetcode_problems.easy;

public class DesignParkingSystem_1603 {
    private final int[] slots;

    public DesignParkingSystem_1603(int big, int medium, int small) {
        this.slots = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return this.slots[carType - 1]-- > 0;
    }
}
