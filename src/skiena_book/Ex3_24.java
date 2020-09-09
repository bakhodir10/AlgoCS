package skiena_book;

import java.util.HashMap;
import java.util.Map;

public class Ex3_24 {

    private Map<String, Boolean> visited;

    public Ex3_24() {
        this.visited = new HashMap<>();
    }

    public boolean ifVisited(String s) {
        if (visited.containsKey(s)) return true;
        visited.put(s, true);
        return false;
    }
}
