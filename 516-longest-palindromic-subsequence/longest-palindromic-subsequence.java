class Solution {
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();

        int i = s.length();
        int j = s.length();

        int[][] dp = new int[i+1][i+1];

        for(int k = 0 ; k < i+1 ; k++){
            dp[0][k] = 0;
            dp[k][0] = 0;

        }

        for(int k = 1 ; k < i+1 ; k++){
            for(int l = 1 ; l < j+1 ; l++){
                char ch1 = s.charAt(k-1);
                char ch2 = r.charAt(l-1);
                
                if(ch1==ch2){
                    dp[k][l] = 1 + dp[k-1][l-1];
                }
                else{
                    dp[k][l] = Math.max(dp[k-1][l], dp[k][l-1]);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        i = s.length() ;
        j = s.length()  ;

        while(i > 0 && j > 0){
            int cur = dp[i][j];

            if(cur > Math.max(dp[i-1][j] , dp[i][j-1])){
                answer.append(s.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(cur==dp[i-1][j]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }

        // longest palindromic subsequence
        System.out.println(answer.reverse().toString());

        return answer.length();
    }

    public int helper(int i , int j , String s , String r , int[][] dp){

        if(i == 0 || j == 0){
            return 0;
        }

        if(dp[i][j] != -1 ) return dp[i][j];
        char ch1 = s.charAt(i-1);
        char ch2 = r.charAt(j-1);
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