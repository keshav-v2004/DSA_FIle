class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        Map<Map<Character , Integer> , List<String>> outerMap = new HashMap<>();

        for(String str : strs){
            Map<Character , Integer> innerMap = new HashMap<>();
            for(char ch : str.toCharArray()){
                innerMap.put(ch , innerMap.getOrDefault(ch , 0)+1);
            }

            if(outerMap.containsKey(innerMap)){
                outerMap.get(innerMap).add(str);
            }
            else{
                List<String> words = new ArrayList<>();
                words.add(str);
                outerMap.put(innerMap , words);
            }
        }
        List<List<String>> answer= new ArrayList<>();  
        for(Map.Entry<Map<Character , Integer> , List<String>> entry : outerMap.entrySet()){
            answer.add(entry.getValue());
        }
        return answer;
    }
}