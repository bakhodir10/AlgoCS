package problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FlattenNestedList_341 {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
//    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
//    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
//    public List<FlattenNestedList_341> getList();

    private class NestedIterator implements Iterator<Integer> {

        private List<Integer> list = new LinkedList<>();
        private int count = 0;

        public NestedIterator(List<FlattenNestedList_341> nestedList) {
            copyAllElement(nestedList, list);
        }

        private void copyAllElement(List<FlattenNestedList_341> nestedList, List<Integer> list) {
            for (int i = 0; i < nestedList.size(); i++) {
//                FlattenNestedList_341 ni = nestedList.get(i);
//                if (ni.isInteger()) list.add(ni.getInteger());
//                else copyAllElement(ni.getList(), list);
            }
        }

        @Override
        public Integer next() {
            return list.get(count++);
        }

        @Override
        public boolean hasNext() {
            return count != list.size();
        }
    }

}
