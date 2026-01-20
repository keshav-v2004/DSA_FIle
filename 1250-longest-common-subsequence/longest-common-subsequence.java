class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length()-1;
        int j = text2.length()-1;

        int[][] dp =new int[i+1][j+1];

        for(int k = 0 ; k < dp.length ; k++){
            Arrays.fill(dp[k] , -1);
        }

        return helper(text1 , text2 , i , j , dp);
    }

    public int helper(String text1 , String text2 , int i , int j , int[][] dp){

        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        char ch1 = text1.charAt(i);
        char ch2 = text2.charAt(j);
        
        int answer = 0;
        if(ch1==ch2){
            answer = 1 + helper(text1 , text2 , i-1 , j-1 , dp);
        }
        else{
            answer = Math.max(
                helper(text1 , text2 , i-1 , j , dp) , helper(text1 , text2 , i , j-1 , dp)
            );
        }
        return dp[i][j] = answer;
    }
}