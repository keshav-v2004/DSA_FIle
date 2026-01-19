class Solution {

    Map<String , Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        return helper(n-1 , target ,nums  );
    }

    public int helper(int index , int target , int[] nums ){

        if(index < 0){
            if(target==0) return 1;
            return 0;
        }

        String key = index + ":" + target;
        if(map.containsKey(key)) return map.get(key);

        int pos = helper(index-1 , target - nums[index] , nums );
        int neg = helper(index-1 , target+nums[index] ,nums );

        map.put(key , pos+neg);

        return pos+neg;

    }
}