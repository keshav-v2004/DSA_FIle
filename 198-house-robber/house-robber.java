class Solution {
    public int rob(int[] nums) {
        int n = nums.length-1;

        if(n+1 ==1) return nums[0];

        if(n+1 == 2) return Math.max(nums[0] , nums[1]);

        int[] dp = new int[n+1];


        return helper(nums ,  dp);
    }

    public int helper(int[] nums , int[] dp){

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);

        for(int i = 2 ; i < nums.length ; i++){
            int rob = nums[i] + dp[i-2];
            int skip = dp[i-1];

            dp[i] = Math.max(rob , skip);
        }
        return dp[nums.length-1];

    }
}