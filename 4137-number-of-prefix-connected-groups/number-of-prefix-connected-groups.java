class Solution {
    public int prefixConnected(String[] words, int k) {
        
        Map<String , Integer> map = new HashMap<>();

        for(String str : words){
            if(str.length() < k) continue;

            String key = str.substring(0 , k);

            map.put(key , map.getOrDefault(key , 0)+1);

        }
        int answer = 0;
        for(Map.Entry<String , Integer> entry : map.entrySet()){
            if(entry.getValue() >= 2){
                answer++;
            }
        }
        return answer;
    }
}