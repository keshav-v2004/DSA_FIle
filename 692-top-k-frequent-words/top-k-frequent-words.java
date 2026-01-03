class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String , Integer> map = new HashMap<>();

        for(String str : words){
            map.put(str , map.getOrDefault(str , 0)+1);
        }

        PriorityQueue<Map.Entry<String , Integer>> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.getValue()==b.getValue()){
                    return a.getKey().compareTo(b.getKey());
                }
                else{
                    return b.getValue() - a.getValue();
                }
            }
        );
        for(Map.Entry<String , Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        int count = 0;
        List<String> answer = new ArrayList<>();

        while(count < k){
            answer.add(pq.poll().getKey());
            count++;
        }
        return answer;
        
    }
}