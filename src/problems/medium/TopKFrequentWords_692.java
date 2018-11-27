package problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//todo not done
public class TopKFrequentWords_692 {

    public List<String> topKFrequent(String words[], int k) {
        List<String> ans = new ArrayList<>();
        Map<String, Pair> map = new TreeMap<>();

        return ans;
    }

    private class Pair implements Comparable<Pair> {

        private String word;
        private Integer freq;

        public Pair(String word) {
            this.word = word;
            this.freq = 1;
        }

        @Override
        public int hashCode() {
            return 31 * word.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = ((Pair) obj);
            if (obj == null) return false;
            return this.word.equals(p.word);
        }

        @Override
        public int compareTo(Pair p) {
            int c = this.freq - p.freq;
            if (c != 0) return c;
            return this.word.compareTo(p.word);
        }
    }
}
