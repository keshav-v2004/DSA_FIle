class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0 ; i < dp.length ; i++){
            Arrays.fill(dp[i] , -1);
        }
        return helper(amount , coins , coins.length - 1 , dp);
    }

    public int helper(int amount , int[] coins , int index , int[][] dp){

        if(amount==0) return 1;

        if(index==0){
            if(amount % coins[0]==0){
                return 1;
            }
            return 0;
        }

        if(dp[index][amount] != -1) return dp[index][amount];
        int take = 0;
        if(amount - coins[index] >= 0){
            take = helper(amount - coins[index] , coins , index , dp);
        }

        int leave = helper(amount , coins , index-1 , dp);

        return dp[index][amount] = take + leave;
    }
}