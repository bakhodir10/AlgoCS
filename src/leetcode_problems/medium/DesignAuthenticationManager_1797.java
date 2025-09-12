package leetcode_problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DesignAuthenticationManager_1797 {

    int timeToLive;
    Deque<Pair> q;
    Map<String, Integer> logs;

    // Space complexity: (n)
    public DesignAuthenticationManager_1797(int timeToLive) {
        this.timeToLive = timeToLive;
        this.logs = new HashMap<>();
        this.q = new ArrayDeque<>();
    }

    private record Pair(String id, int expiration) {}

    // Time complexity: amortized O( 1)
    private void cleanUp(int currentTime) {
        while (!q.isEmpty() && q.peek().expiration <= currentTime) {
            Pair p = q.poll();
            if (logs.containsKey(p.id) && logs.get(p.id) <= currentTime) logs.remove(p.id);
        }
    }

    // Time complexity: amortized O( 1)
    public void generate(String tokenId, int currentTime) {
        cleanUp(currentTime);
        logs.put(tokenId, currentTime + timeToLive);
        q.offer(new Pair(tokenId, currentTime + timeToLive));
    }

    // Time complexity: amortized O( 1)
    public void renew(String tokenId, int currentTime) {
        cleanUp(currentTime);

        if (!logs.containsKey(tokenId)) return;

        logs.put(tokenId, currentTime + timeToLive);
        q.offer(new Pair(tokenId, currentTime + timeToLive));
    }

    // Time complexity: amortized O( 1)
    public int countUnexpiredTokens(int currentTime) {
        cleanUp(currentTime);
        return logs.size();
    }
}
