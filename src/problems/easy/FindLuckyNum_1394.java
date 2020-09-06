package problems.easy;

public class FindLuckyNum_1394 {

    public int findLucky(int[] arr) {
        int[] counts = new int[501];
        int luckyNum = -1;

        for (int num : arr) counts[num]++;
        for (int i = 1; i < counts.length; i++) {
            if (i == counts[i]) luckyNum = i;
        }
        return luckyNum;
    }
}
