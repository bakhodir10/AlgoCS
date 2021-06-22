package leetcode_problems.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator_284 {

    class PeekingIterator implements Iterator<Integer> {

        private int pointer = 0;
        private final List<Integer> items = new ArrayList<>();

        public PeekingIterator(Iterator<Integer> iterator) {
            while (iterator.hasNext()) items.add(iterator.next());
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return items.get(pointer);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return items.get(pointer++);
        }

        @Override
        public boolean hasNext() {
            return pointer < items.size();
        }
    }
}
