class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return helper(prices , 0 , true , dp);
    }

    public int helper(int[] prices, int index , boolean canBuy , Integer[][] dp){
        
        int n = prices.length;
        if(index >= n) return 0;

        int flag = canBuy ? 1 : 0;
        if(dp[index][flag] != null) return dp[index][flag];

        
        int price = prices[index];

        int maxProfit ;
        
        // allowed to buy
        if(canBuy){

            // skip buying on this day
            int p1 = helper(prices , index+1 , true ,dp) - 0;

            // buy on this day
            int p2 = helper(prices , index+1 , false ,dp) - price;
            maxProfit = Math.max(p1,p2);
        }

        // not allowed to buy 
        else{

            // skip selling on this day
            int p1 = helper(prices , index+1 ,false,dp);

            // sell on this day
            int p2 = price + helper(prices , index+2 , true,dp);
            maxProfit = Math.max(p1,p2);


        }

        return dp[index][flag] = maxProfit;

    }
}