class Solution {
    public int coinChange(int[] coins, int amount) {

        if(amount==0) return 0;

        Arrays.sort(coins);
        int i = coins.length;

        Integer[][] dp = new Integer[i][amount+1];



        int answer =helper(coins , amount , i-1 , dp);
        if(answer >= (int) 1e9) return -1;
        return answer;

    }

    public int helper(int[] coins , int amount , int index , Integer[][] dp){
        
        if(amount==0) return 0;

        if(index==0){
            if(amount % coins[0] == 0) return amount / coins[0];
            return (int)1e9;

        }

        if(dp[index][amount] != null) return dp[index][amount];


        // skip this coin
        int skip = helper(coins , amount ,index-1 , dp);

        // use this coin ( possible only if this coin value <= amount )
        int use = (int) 1e9;

        if(coins[index] <= amount){
            use = 1 + helper(coins , amount-coins[index] , index , dp);
        }

        int answer = Math.min(use , skip);

        return dp[index][amount] = answer;


    }
}