class Solution {
    public int rob(int[] nums) {

        if(nums.length==1) return nums[0];

        int n = nums.length-1;
        int[] dp = new int[n];
        Arrays.fill(dp ,-1);

        int[] firstArr = new int[n];

        for(int i = 0 ; i< nums.length-1 ; i++){
            firstArr[i] = nums[i];
        }
        int[] secondArr = new int[n];

        for(int i = 1 ; i< nums.length ; i++){
            secondArr[i-1] = nums[i];
        }

        int first =  helper(firstArr , firstArr.length-1 , dp);

        Arrays.fill(dp , -1);
        int second = helper(secondArr, secondArr.length-1 , dp);

        return Math.max(first , second);

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