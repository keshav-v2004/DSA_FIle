class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] output = new int[n];

        output[n-1] = prices[n-1];

        for(int i = n-2 ; i>= 0 ; i--){
            output[i] = Math.max(prices[i] , output[i+1]);
        }

        int profit = 0;
        for(int i = 0 ; i < n ; i++){
            profit = Math.max(profit , output[i] - prices[i]);
        }
        return profit;


    }
}