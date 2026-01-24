class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;


        for (int index = n - 1; index >= 0; index--) {
            int price = prices[index];

            // buy = 1  -> canBuy = true
            // buy = 0  -> canBuy = false (holding stock)

            // Case 1: canBuy = true  (buy = 1)
            {
                // skip
                int p1 = dp[index + 1][1];

                // buy
                int p2 = dp[index + 1][0] - price ;

                dp[index][1] = Math.max(p1, p2);
            }

            // Case 2: canBuy = false (buy = 0)
            {
                // skip
                int p1 = dp[index + 1][0];

                // sell
                int p2 = price + dp[index + 1][1];

                dp[index][0] = Math.max(p1, p2);
            }
        }

        // Start at day 0, free to buy
        return dp[0][1];
    }
}
