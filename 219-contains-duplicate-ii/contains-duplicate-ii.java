class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer , List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){

                for(int elem : map.get(nums[i])){
                    if(Math.abs(elem - i) <= k) return true;
                }
                map.get(nums[i]).add(i);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i] , list);
            }
        }
        return false;


    }
}