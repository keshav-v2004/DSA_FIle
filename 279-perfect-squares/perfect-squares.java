class Solution {
    public int numSquares(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return helper(n , dp);
    }

    public int helper(int amount , int[] dp){

        if(amount <= 0){
            return 0;

        }
        if(dp[amount] != -1) return dp[amount];

        int answer = (int) 1e9;

        int number = 1;
        

        while(number*number <= amount){
            answer = Math.min(answer , 1 + helper(amount - (number*number) , dp));
            number++;
        }

        return dp[amount] = answer;

        

    }
}