class Solution {
    public int minSteps(String s, String t) {
        String word1 = s;
        String word2 = t;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char ch : word1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int answer = 0;
        for(Map.Entry<Character , Integer> entry : map1.entrySet()){
            char key = entry.getKey();
            int freq = entry.getValue();

            if(map2.containsKey(key)){
                if(map2.get(key) < freq){
                    answer+= (freq - map2.get(key));
                }
            }
            else{
                answer+=freq;
            }
        }

        return answer;

    }
}

