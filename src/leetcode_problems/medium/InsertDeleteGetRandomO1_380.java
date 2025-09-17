package leetcode_problems.medium;

import java.util.*;

public class InsertDeleteGetRandomO1_380 {
    private final Random random;
    private final List<Integer> list;
    private final Map<Integer, Integer> map;

    public InsertDeleteGetRandomO1_380() {
        this.random = new Random();
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    // Time complexity: O(1)
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    // Time complexity: O(1)
    public boolean remove(int val) {

        // 5, 2, 0, 3, 1
        // {1,4},{2,1},{3,3},{5,0}
        // Remove 5
        // 1, 2, 0, 3
        // {1,0},{2,1},{3,3}

        if(!map.containsKey(val)) return false;

        int lastIndexInList = list.size() - 1;
        int lastElementInList = list.get(lastIndexInList);
        int toBeRemovedIndexList = map.get(val);

        // change the index of last element in the list to a new index location
        map.put(lastElementInList, toBeRemovedIndexList);
        // move the last element of the list to an index, element being removed
        list.set(toBeRemovedIndexList, lastElementInList);

        // remove the element from the map
        map.remove(val);
        // remove the last element from list since it is moved somewhere else
        list.remove(lastIndexInList);
        return true;
    }

    // Time complexity: O(1)
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
