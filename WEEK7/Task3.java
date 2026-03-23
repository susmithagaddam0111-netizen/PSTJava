import java.util.*;

class UndergroundSystem {

    private static class CheckInInfo {
        String station;
        int time;
        CheckInInfo(String s, int t) {
            station = s;
            time = t;
        }
    }

    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, int[]> tripData;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        tripData = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.get(id);
        String key = info.station + "->" + stationName;
        int duration = t - info.time;
        int[] data = tripData.getOrDefault(key, new int[2]);
        data[0] += duration; // total time
        data[1] += 1;        // count
        tripData.put(key, data);
        checkIns.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        int[] data = tripData.get(key);
        return (double) data[0] / data[1];
    }
}
