class RideSharingSystem {

    ArrayList<Integer> rider;
    ArrayList<Integer> driver;

    public RideSharingSystem() {
        rider = new ArrayList<>();
        driver = new ArrayList<>();

    }
    
    public void addRider(int riderId) {
        rider.add(riderId);
    }
    
    public void addDriver(int driverId) {
        driver.add(driverId);

    }
    
    public int[] matchDriverWithRider() {
        int[] answer = new int[2];
        answer[0] = -1;
        answer[1] = -1;
        if(rider.size() != 0 && driver.size() != 0){
            answer[0] = driver.get(0);
            answer[1] = rider.get(0);
            rider.remove(0);
            driver.remove(0);
            return answer;
        }
        return answer;
        
    }
    
    public void cancelRider(int riderId) {
        int index = -1;
        for(int i = 0 ; i < rider.size() ; i++){
            int id = rider.get(i);
            if(id==riderId){
                index = i;
                break;
            }
        }
        if(index != -1){
            rider.remove(index);
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */