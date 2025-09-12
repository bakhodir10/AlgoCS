package leetcode_problems.medium;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem_1396 {

    private record TripStart(String startPlace, int startTime) {}
    private record StationPair(String startPlace, String endPlace) {}

    private static class JourneyStats {
        long total;
        int count;

        public JourneyStats(long total, int count) {
            this.total = total;
            this.count = count;
        }

        public void addTrip(int time) {
            total += time;
            count++;
        }

        public double getAverage() {
            return total * 1.0 / count;
        }
    }

    Map<Integer, TripStart> activeTrips;
    Map<StationPair, JourneyStats> journeyStats;

    public DesignUndergroundSystem_1396() {
        this.activeTrips = new HashMap<>();
        this.journeyStats = new HashMap<>();
    }

    public void checkIn(int id, String startPlace, int startTime) {
        this.activeTrips.put(id, new TripStart(startPlace, startTime));
    }

    public void checkOut(int id, String endPlace, int endTime) {
        TripStart tripStart = activeTrips.get(id);
        if(tripStart == null) return;

        StationPair route = new StationPair(tripStart.startPlace, endPlace);
        journeyStats.putIfAbsent(route, new JourneyStats(0, 0));
        journeyStats.get(route).addTrip(endTime - tripStart.startTime);
    }

    public double getAverageTime(String startPlace, String endPlace) {
        JourneyStats journey = journeyStats.get(new StationPair(startPlace, endPlace));
        return journey.getAverage();
    }
}
