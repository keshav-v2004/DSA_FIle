class Solution {
    public int hIndex(int[] citations) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < citations.length ; i++){
            map.put(i , citations[i]);
        }
        int low = 0;
        int high = citations.length;
        int answer = -1;
        while(low <= high){

            int mid = low + (high-low)/2;

            int count = 0;

            for(Map.Entry<Integer , Integer> entry : map.entrySet()){
                if(entry.getValue() >= mid){
                    count++;
                }
            }
            if(count >= mid){
                answer = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return answer;
    }
}