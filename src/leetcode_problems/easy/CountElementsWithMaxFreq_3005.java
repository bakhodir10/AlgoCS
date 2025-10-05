package leetcode_problems.easy;

public class CountElementsWithMaxFreq_3005 {

    public int maxFrequencyElements(int[] nums) {
        int[] freqs = new int[101];
        int max = 0, sum = 0;
        for(int num: nums) {
            freqs[num]++;
            max = Math.max(max, freqs[num]);
        }
        for(int count: freqs) {
            if(count == max) sum += count;
        }
        return sum;
    }
}
