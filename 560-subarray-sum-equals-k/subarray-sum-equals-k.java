class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        long preSum = 0;

        Map<Long , Integer> map = new HashMap<>();

        map.put(0L , 1);

        for(int elem : nums){
            preSum+=(long)elem;

            long remainingSum = preSum - k;

            if(map.containsKey(remainingSum)){
                count+=map.get(remainingSum);
            }

            map.put(preSum , map.getOrDefault(preSum , 0)+1);
        }
        return count;
    }
}