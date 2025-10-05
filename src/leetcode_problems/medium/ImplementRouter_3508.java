package leetcode_problems.medium;

import java.util.*;

public class ImplementRouter_3508 {

    private record Packet(int source, int destination, int timestamp) {}

    private final int memoryLimit;
    private final LinkedHashSet<Packet> set;
    private final HashMap<Integer, TreeMap<Integer, Integer>> counts;

    public ImplementRouter_3508(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.set = new LinkedHashSet<>();
        this.counts = new HashMap<>();
    }

    private void removePacket(Packet p) {
        TreeMap<Integer, Integer> times = counts.get(p.destination);
        if (times == null) return;

        // decrease count for timestamp
        int current = times.get(p.timestamp);
        if (current == times.floorEntry(p.timestamp).getValue()) {
            // adjust prefix sums after this timestamp
            NavigableMap<Integer, Integer> tail = times.tailMap(p.timestamp, true);
            for (Map.Entry<Integer, Integer> e : tail.entrySet()) {
                times.put(e.getKey(), e.getValue() - 1);
            }
        } else {
            // decrement only prefix sums
            NavigableMap<Integer, Integer> tail = times.tailMap(p.timestamp, true);
            for (Map.Entry<Integer, Integer> e : tail.entrySet()) {
                times.put(e.getKey(), e.getValue() - 1);
            }
        }

        if (times.isEmpty()) counts.remove(p.destination);
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);
        if (set.contains(p)) return false;

        if (set.size() == memoryLimit) {
            Iterator<Packet> it = set.iterator();
            if (it.hasNext()) {
                Packet removedPacket = it.next();
                it.remove();
                removePacket(removedPacket);
            }
        }
        set.add(p);

        TreeMap<Integer, Integer> times = counts.computeIfAbsent(destination, k -> new TreeMap<>());
        int prev = times.isEmpty() ? 0 : times.lastEntry().getValue();
        times.put(timestamp, prev + 1);

        return true;
    }

    public int[] forwardPacket() {
        Iterator<Packet> it = set.iterator();
        if (it.hasNext()) {
            Packet p = it.next();
            it.remove();
            removePacket(p);
            return new int[]{p.source, p.destination, p.timestamp};
        }
        return new int[]{};
    }

    public int getCount(int destination, int startTime, int endTime) {
        TreeMap<Integer, Integer> times = counts.get(destination);
        if (times == null) return 0;

        Map.Entry<Integer, Integer> endEntry = times.floorEntry(endTime);
        Map.Entry<Integer, Integer> startEntry = times.floorEntry(startTime - 1);

        int sumEnd = endEntry == null ? 0 : endEntry.getValue();
        int sumStart = startEntry == null ? 0 : startEntry.getValue();

        return sumEnd - sumStart;
    }
}
