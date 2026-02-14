class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return helper(n , costs , dp);
    }

    public int helper(int n, int[] costs , int[] dp) {
        if (n == 0){
            return 0;
        }

        if(dp[n] != -1) return dp[n];

        int jump1 = (int) 1e9;
        int jump2 = (int) 1e9;
        int jump3 = (int) 1e9;

        // jump 1
        if (n >= 1) {
            jump1 = 1 +  helper(n - 1, costs , dp);
        }
        // jump 2
        if (n >= 2) {
            jump2 = 4 + helper(n - 2, costs , dp);
        }
        // jump 3
        if (n >= 3) {
            jump3 = 9 + helper(n - 3, costs , dp);
        }

        return dp[n] = dp[n] = costs[n - 1] + Math.min(jump1, Math.min(jump2, jump3));
    }
}