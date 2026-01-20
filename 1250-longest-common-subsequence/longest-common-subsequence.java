class Solution {
    public int longestCommonSubsequence(String text1, String text2) {


        int[][] dp =new int[text1.length()+1][text2.length()+1];

        for(int k = 0 ; k < dp.length ;k++){
            dp[k][0] = 0;
        }
        for(int k = 0 ; k < dp[0].length ; k++){
            dp[0][k] =0;
        }

        for(int i = 1 ; i<=  text1.length() ; i++){
            for(int j =1 ; j <=  text2.length() ; j++){
                char ch1 = text1.charAt(i-1);
                char ch2 = text2.charAt(j -1);

                if(ch1==ch2){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];

    }

    public int helper(String text1, String text2, int i, int j, int[][] dp) {

        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        char ch1 = text1.charAt(i);
        char ch2 = text2.charAt(j);

        int answer = 0;
        if (ch1 == ch2) {
            answer = 1 + helper(text1, text2, i - 1, j - 1, dp);
        } else {
            answer = Math.max(
                    helper(text1, text2, i - 1, j, dp), helper(text1, text2, i, j - 1, dp));
        }
        return dp[i][j] = answer;
    }
}