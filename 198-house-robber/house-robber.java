class Solution {
    public int rob(int[] nums) {
        int n = nums.length-1;
        int[] dp = new int[n+1];
        Arrays.fill(dp ,-1);
        return helper(nums , n , dp);
    }

    public int helper(int[] nums , int index , int[] dp){

        if(index < 0){
            return 0;
        }

        if(dp[index] != -1) return dp[index];

        // rob this house
        int rob = nums[index] + helper(nums , index-2 ,dp);
        
        // skip this house
        int skip = helper(nums , index-1 , dp);

        return dp[index] = Math.max(rob , skip);
    }
}