package leetcode_problems.medium;

import java.util.*;

public class AccountsMerge_721 {

    private record Pair(String name, String parent){}

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Set<String> allEmails = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for(List<String> acc: accounts) allEmails.addAll(acc.subList(1, acc.size()));
        UnionFind uf = new UnionFind(allEmails);

        for(List<String> acc: accounts) {
            for(int i = 1; i < acc.size() - 1; i ++) uf.union(acc.get(i), acc.get(i + 1));
        }

        Map<Pair, Set<String>> uniques = new HashMap<>();
        for(List<String> acc: accounts) {
            String name = acc.get(0);
            String parent = uf.find(acc.get(1));
            Pair p = new Pair(name, parent);
            Set<String> emails = uniques.getOrDefault(p, new TreeSet<>());
            emails.addAll(acc.subList(1, acc.size()));
            uniques.put(p, emails);
        }

        for(Map.Entry<Pair, Set<String>> entry: uniques.entrySet()) {
            List<String> sub = new ArrayList<>();
            sub.add(entry.getKey().name);
            sub.addAll(entry.getValue());
            result.add(sub);
        }
        return result;
    }

    private static class UnionFind {
        private final Map<String, String> parents;
        private final Map<String, Integer> rankings;

        public UnionFind(Set<String> allEmails) {
            this.parents = new HashMap<>();
            this.rankings = new HashMap<>();

            for(String email: allEmails) {
                this.parents.put(email, email);
                this.rankings.put(email, 0);
            }
        }

        public void union(String a, String b) {
            String parentOfA = find(a);
            String parentOfB = find(b);

            if(parentOfA.equals(parentOfB)) return;

            if(rankings.get(parentOfA) > rankings.get(parentOfB)) {
                parents.put(parentOfB, parentOfA);
            } else if(rankings.get(parentOfA) < rankings.get(parentOfB)) {
                parents.put(parentOfA, parentOfB);
            } else {
                parents.put(parentOfA, parentOfB);
                rankings.put(parentOfB, rankings.get(parentOfB) + 1);
            }
        }

        public String find(String a) {
            List<String> path = new ArrayList<>();

            while(!parents.get(a).equals(a)) {
                path.add(a);
                a = parents.get(a);
            }
            for(String s: path) parents.put(s, a);
            return a;
        }
    }
}
