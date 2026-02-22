class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();

        for(int elem : nums){
            map.put(elem , map.getOrDefault(elem , 0)+1);
        }

        Map<Integer , Set<Integer>> map2 = new HashMap<>();

        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            int elem = entry.getKey();
            int freq = entry.getValue();

            if(map2.containsKey(freq)){
                map2.get(freq).add(elem);
            }
            else{
                Set<Integer> set = new HashSet<>();
                set.add(elem);
                map2.put(freq , set);
            }
        }
        int answer = -1;

        for(int elem : nums){

            int freq = map.get(elem);

            Set<Integer> allElements = map2.get(freq);
            if(allElements.size() == 1){
                answer = allElements.iterator().next();
                break;
            }
        }
        return answer;
    }
}