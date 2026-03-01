class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int n = guess.length();

        Map<Integer , Integer> map1 = new HashMap<>();
        Map<Integer , Integer> map2 = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            int ch1 = secret.charAt(i) - '0';
            int ch2 = guess.charAt(i) - '0';

            if(ch1==ch2){
                bulls++;
            }
            else{
                map1.put(ch1 , map1.getOrDefault(ch1,0)+1);
                map2.put(ch2 , map2.getOrDefault(ch2,0)+1);
            }
        }

        for(Map.Entry<Integer , Integer> entry : map1.entrySet()){
            int key1 = entry.getKey();
            int val1 = entry.getValue();

            if(map2.containsKey(key1)){
                cows+= Math.min(val1 , map2.get(key1));
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(bulls);
        answer.append("A");
        answer.append(cows);
        answer.append("B");

        return answer.toString();
    }
}