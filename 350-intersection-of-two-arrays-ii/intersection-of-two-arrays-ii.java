class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer , int[]> map = new HashMap<>();

        for(int elem : nums1){
            if(map.containsKey(elem)){
                map.get(elem)[0]++;
                map.get(elem)[1]++;
            }
            else{
                int[] log = new int[2];
                log[0]++;
                log[1]++;
                map.put(elem , log);
            }
        }
        for(int elem : nums2){
            if(map.containsKey(elem)){
                map.get(elem)[1]--;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(Map.Entry<Integer , int[]> entry : map.entrySet()){

            int freqInNums1 = entry.getValue()[0];
            int remaining = entry.getValue()[1];

            int common = freqInNums1 - Math.max(remaining, 0);

            for (int i = 0; i < common; i++) {
                answer.add(entry.getKey());
            }
        }
        int[] arr = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            arr[i] = answer.get(i);
        }
        return arr;
    }
}