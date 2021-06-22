package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeopleGroupSize_1282 {

    // Time complexity: O(n). Space complexity: O(n)
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> people = map.getOrDefault(groupSizes[i], new ArrayList<>());
            people.add(i);
            map.put(groupSizes[i], people);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> peopleInGroup = new ArrayList<>();

            for (int person : entry.getValue()) {
                peopleInGroup.add(person);
                if (peopleInGroup.size() == entry.getKey()) {
                    res.add(peopleInGroup);
                    peopleInGroup = new ArrayList<>();
                }
            }
        }
        return res;
    }
}
