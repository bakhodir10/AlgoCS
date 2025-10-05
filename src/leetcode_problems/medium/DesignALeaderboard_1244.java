package leetcode_problems.medium;

import java.util.*;

public class DesignALeaderboard_1244 {

    private record Pair(int id, int score){}

    private final Set<Pair> board;
    private final Map<Integer, Integer> players;

    public DesignALeaderboard_1244() {
        this.board = new TreeSet<>((a, b) -> {
            if(a.score != b.score) return b.score - a.score;
            else return a.id - b.id;
        });
        this.players = new HashMap<>();
    }

    public void addScore(int id, int score) {
        int currentScore = players.getOrDefault(id, 0);
        board.remove(new Pair(id, currentScore));

        currentScore += score;
        players.put(id, currentScore);
        board.add(new Pair(id, currentScore));
    }

    public int top(int K) {
        int sum = 0;
        Iterator<Pair> it = board.iterator();
        while(K-- > 0 && it.hasNext()) sum += it.next().score;
        return sum;
    }

    public void reset(int id) {
        int currentScore = players.get(id);
        board.remove(new Pair(id, currentScore));
        players.remove(id);
    }
}
