class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int size = nums.length;
        int n = size/2;

        for(int elem : nums){
            map.put(elem , map.getOrDefault(elem , 0)+1);
        }
        int answer =-1;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            if(entry.getValue()==n){
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}