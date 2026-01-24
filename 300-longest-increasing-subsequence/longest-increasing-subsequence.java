class Solution {
    
    public int lengthOfLIS(int[] nums) {

        int index = nums.length-1;

        int n = nums.length;
        Integer[] dp = new Integer[n];


        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, helper(nums, i, dp));
        }

        return maxLen;  
    }

    public int helper(int[] nums , int index ,Integer[] dp){

        if(index < 0) return 0;
        if(dp[index] != null) return dp[index];

        int cur = nums[index];

        int maxLen = 1;

        for(int i = index-1 ; i>= 0 ; i--){
            int elem = nums[i];

            if(elem < cur){
                maxLen = Math.max(maxLen ,  1 + helper(nums , i , dp));
                
            }
        }
        return dp[index] = maxLen;

    }
}