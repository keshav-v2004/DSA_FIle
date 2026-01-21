class Solution {
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();

        int i = s.length();
        int j = s.length();

        int[][] dp = new int[i][i];

        for(int k = 0 ; k < i ; k++){
            Arrays.fill(dp[k] , -1);
        }

        return helper(i-1 , j-1 , s , r , dp);
    }

    public int helper(int i , int j , String s , String r , int[][] dp){

        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != -1 ) return dp[i][j];
        char ch1 = s.charAt(i);
        char ch2 = r.charAt(j);
        int answer = 0;
        if(ch1==ch2){
            answer = 1 + helper(i-1 , j-1 , s , r , dp);
        }
        else{
            answer = Math.max(helper(i-1 , j , s , r , dp) , helper(i , j-1 , s , r , dp));
        }

        return dp[i][j] = answer;

    }
}