class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int max = 0;

        Integer[] dp = new Integer[n];

        for(int i = 0 ; i < n ; i++){
            max = Math.max(max , helper(prices , i , dp));
        }
        return max;

    }

    public int helper(int[] prices , int buyIndex , Integer[] dp){
        int n = prices.length;

        if(buyIndex >=n) return 0;

        if(dp[buyIndex] != null) return dp[buyIndex];

        int maxProfit = helper(prices , buyIndex+1 , dp);

        int buyCost = prices[buyIndex];

        for(int sellIndex = buyIndex+1 ; sellIndex <n ; sellIndex++){
            int sellCost = prices[sellIndex];

            int profit = 0;
            if(sellCost > buyCost){
                profit = (sellCost - buyCost) + helper(prices , sellIndex ,dp);
                maxProfit = Math.max(maxProfit , profit);
            }
        }
        return dp[buyIndex] = maxProfit;


    }
}