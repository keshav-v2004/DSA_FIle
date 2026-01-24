class Solution {

    Integer[][] memo;

    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][2];
        return helper(prices, 0, true);
    }

    public int helper(int[] prices, int index, boolean canBuy) {

        if (index >= prices.length) return 0;

        int flag = canBuy ? 1 : 0;
        if (memo[index][flag] != null)
            return memo[index][flag];

        int cost = prices[index];
        int maxProfit = 0;

        // allowed to buy
        if (canBuy) {

            // skip
            int p1 = helper(prices, index + 1, true);

            // buy
            int p2 = helper(prices, index + 1, false) - cost;

            maxProfit = Math.max(p1, p2);
        }
        // must sell or skip
        else {

            // skip
            int p1 = helper(prices, index + 1, false);

            // sell  ADD cost here
            int p2 = helper(prices, index + 1, true) + cost;

            maxProfit = Math.max(p1, p2);
        }

        return memo[index][flag] = maxProfit;
    }
}
