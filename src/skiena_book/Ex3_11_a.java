package skiena_book;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Ex3_11_a {

    private final Map<Pair, Integer> map;

    public Ex3_11_a(int[] nums) {
        this.map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int theSmallest = nums[i];
            for (int j = i; j < nums.length; j++) {
                theSmallest = Math.min(theSmallest, nums[j]);
                map.put(new Pair(i, j), theSmallest);
            }
        }
    }

    public int findSmallestInRange(int i, int j) {
        return this.map.get(new Pair(i, j));
    }

    private static class Pair {
        private final int a;
        private final int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a &&
                    b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
