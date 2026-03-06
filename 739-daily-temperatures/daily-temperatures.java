class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Map<Integer , Integer> map = new HashMap<>();
        int n = temperatures.length;

        int[] answer = new int[n];
        answer[n-1] = 0;
        map.put(temperatures[n-1] , n-1);


        for(int i = n-2 ; i >= 0 ; i--){

            int cur = temperatures[i];

            
            int minDays = Integer.MAX_VALUE;

            for(int j = cur+1 ; j<= 100 ; j++){
                if(map.containsKey(j)){
                    int days = map.get(j) - i;
                    minDays = Math.min(minDays , days);
                }
            }
            map.put(cur , i);

            if(minDays==Integer.MAX_VALUE){
                answer[i] = 0;
            }
            else{
                answer[i] = minDays;
            }
        }   
        return answer;
    }
}