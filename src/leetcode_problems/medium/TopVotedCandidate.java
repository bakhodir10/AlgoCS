package leetcode_problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {

    private Map<Integer, Integer> countStore = new HashMap<>();
    private int timeStore[];

    public TopVotedCandidate(int[] persons, int[] times) {
        timeStore = times;
        int leading = persons[0];
        Map<Integer, Integer> counts = new HashMap<>();
        int i = 0;
        while (i < persons.length) {
            counts.put(persons[i], counts.getOrDefault(persons[i], 0) + 1);
            if (counts.get(leading) <= counts.get(persons[i])) {
                leading = persons[i];
            }
            countStore.put(times[i], leading);
            i++;
        }
    }

    public int q(int t) {
        int index = Arrays.binarySearch(timeStore, t);
        return index < 0 ? countStore.get(timeStore[-index - 2]) : countStore.get(timeStore[index]);
    }
}
