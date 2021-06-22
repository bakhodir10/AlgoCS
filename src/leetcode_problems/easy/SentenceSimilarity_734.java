package leetcode_problems.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SentenceSimilarity_734 {

    // Time complexity: O(n). Space complexity: O(n)
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> pairs) {
        if (sentence1.length != sentence2.length) return false;

        Set<Pair> setOfPairs = new HashSet<>();
        for (List<String> pair : pairs) setOfPairs.add(new Pair(pair.get(0), pair.get(1)));

        for (int i = 0; i < sentence1.length; i++) {
            String s1 = sentence1[i];
            String s2 = sentence2[i];
            if (s1.equals(s2)) continue;
            if (!setOfPairs.contains(new Pair(s1, s2))) return false;
        }
        return true;
    }

    private static class Pair {
        private final String s1;
        private final String s2;

        public Pair(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        public int hashCode() {
            return (this.s1.hashCode() + this.s2.hashCode()) * 13;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) return false;
            Pair p = (Pair) obj;
            return (this.s1.equals(p.s1) && this.s2.equals(p.s2)) || (this.s1.equals(p.s2) && this.s2.equals(p.s1));
        }
    }
}
