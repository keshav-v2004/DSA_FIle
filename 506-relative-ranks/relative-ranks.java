class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int elem : score){
            pq.offer(elem);
        }
        int rank = 4;
        int start = 1;

        Map<Integer , String> map = new HashMap<>();

        while(!pq.isEmpty()){

            int val = pq.poll();

            if(start <= 3){
                if(start==1){
                    map.put(val , "Gold Medal");
                }
                else if(start==2){
                    map.put(val , "Silver Medal");
                }
                else{
                    map.put(val , "Bronze Medal");
                }
                start++;
            }
            else{
                map.put(val,String.valueOf(rank));
                rank++;
            }
        }

        String[] answer = new String[score.length];
        for(int i = 0 ; i < score.length ; i++){
            answer[i] = map.get(score[i]);
        }
        return answer;
    }
}