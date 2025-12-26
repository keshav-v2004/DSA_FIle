class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> mapS = new HashMap<>();
        HashMap<Character,Integer> mapT = new HashMap<>();

        for(char ch : s.toCharArray()){
            mapS.put(ch , mapS.getOrDefault(ch,0)+1);
        }
        for(char ch : t.toCharArray()){
            mapT.put(ch , mapT.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character , Integer> entry : mapT.entrySet()){
            if(!mapS.containsKey(entry.getKey()) || mapS.get(entry.getKey()) != entry.getValue()){
                return entry.getKey();
            }
        }
        return '0';

    }
}