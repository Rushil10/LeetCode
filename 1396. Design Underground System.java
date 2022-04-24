class UndergroundSystem {
    
    public class Passenger {
        String station;
        int time;
        Passenger(String station,int time){
            this.station=station;
            this.time=time;
        }
    }
    
    HashMap<Integer,Passenger> map = new HashMap<>();
    HashMap<String,List<Double>> avg = new HashMap<>();

    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        Passenger p = new Passenger(stationName,t);
        map.put(id,p);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Passenger p = map.get(id);
        double diff = t-p.time;
        String journey = p.station+"->"+stationName;
        if(avg.containsKey(journey)){
            double avge = avg.get(journey).get(0);
            double total = avg.get(journey).get(1);
            double sum = total*avge+diff;
            total=total+1;
            double newAvg = sum/total;
            List<Double> li = new ArrayList<>();
            li.add(newAvg);
            li.add(total);
            avg.put(journey,li);
        } else {
            List<Double> li = new ArrayList<>();
            li.add(diff);
            li.add(1.0);
            avg.put(journey,li);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return avg.get(startStation+"->"+endStation).get(0);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */