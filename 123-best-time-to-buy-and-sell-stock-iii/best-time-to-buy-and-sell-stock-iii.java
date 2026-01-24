class Solution {

    Integer[][][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2][3];   // index, holding(0/1), k=0..2
        return helper(prices, 0, 1, 2);  // start free, 2 transactions
    }

    // holding = 1 -> free to buy
    // holding = 0 -> stock in hand
    public int helper(int[] prices, int index, int holding, int k) {

        if (index == prices.length || k == 0)
            return 0;

        if (dp[index][holding][k] != null)
            return dp[index][holding][k];

        int price = prices[index];
        int profit;

        if (holding == 1) {
            // free to buy

            // skip
            int p1 = helper(prices, index + 1, 1, k);

            // buy
            int p2 = -price + helper(prices, index + 1, 0, k);

            profit = Math.max(p1, p2);

        } else {
            // holding stock

            // skip
            int p1 = helper(prices, index + 1, 0, k);

            // sell (consume 1 transaction)
            int p2 = price + helper(prices, index + 1, 1, k - 1);

            profit = Math.max(p1, p2);
        }

        return dp[index][holding][k] = profit;
    }
}
