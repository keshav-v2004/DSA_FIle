class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer , List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            int elem = nums[i];

            map.putIfAbsent(elem , new ArrayList<>());
            map.get(elem).add(i);
        }

        boolean found = false;

        int minDist = Integer.MAX_VALUE;

        for(Map.Entry<Integer , List<Integer>> entry : map.entrySet()){

            if(entry.getValue().size() < 3){
                continue;
            }
            else{
                found = true;

                for(int i = 0 ; i <= entry.getValue().size()-3 ; i++){

                    int x = entry.getValue().get(i+1) - entry.getValue().get(i);
                    int y =  entry.getValue().get(i+2) - entry.getValue().get(i+1);

                    int z = entry.getValue().get(i+2) - entry.getValue().get(i);

                    int dist = x+y+z;
                    minDist = Math.min(minDist , dist);

                    
                }
            }
        }
        if(found==false){
            return -1;
        }
        return minDist;
    }
}