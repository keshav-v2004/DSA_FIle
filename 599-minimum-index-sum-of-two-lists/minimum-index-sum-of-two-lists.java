class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String , Integer> map1 = new HashMap<>();
        Map<String , Integer> map2 = new HashMap<>();
        
        Map<String , Integer> mapCommon = new HashMap<>();

        for(int i = 0 ; i < list1.length ; i++){
            map1.put(list1[i] , i);
        }

        for(int i = 0 ; i < list2.length ; i++){
            map2.put(list2[i] , i);
        }

        for(String str : list1){
            if(map1.containsKey(str) && map2.containsKey(str)){
                mapCommon.put(str , map1.get(str) + map2.get(str));
            }
        }
        for(String str : list2){
            if(map1.containsKey(str) && map2.containsKey(str)){
                mapCommon.put(str , map1.get(str) + map2.get(str));
            }
        }

        int min = Integer.MAX_VALUE;
        ArrayList<String> answer = new ArrayList<>();

        for(Map.Entry<String , Integer> entry : mapCommon.entrySet()){
            min = Math.min(min , entry.getValue());
        }
        for(Map.Entry<String , Integer> entry : mapCommon.entrySet()){
            if(entry.getValue()==min){
                answer.add(entry.getKey());
            }
        }
        String[] out = new String[answer.size()];
        for(int i = 0 ; i < out.length ; i++){
            out[i] = answer.get(i);
        }
        return out;

        

    }
}