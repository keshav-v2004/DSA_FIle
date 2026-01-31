class Solution {
    long[][] dp;

    public int numDistinct(String s, String t) {
        long[][] dp = new long[s.length()+1][t.length()+1];
        

        for(int k = 0 ; k < dp[0].length ; k++){
            dp[0][k] = 0;
        }

        for(int k = 1 ; k < dp.length ; k++){
            dp[k][0] =  1;
        }

        dp[0][0] = 1;

        for(int k = 1 ; k < dp.length ; k++){
            for(int l = 1 ; l < dp[0].length ; l++){
                dp[k][l] = dp[k-1][l];

                if(s.charAt(k-1)==t.charAt(l-1)){
                    dp[k][l] += dp[k-1][l-1];
                }
            }


        }

        return (int)dp[s.length()][t.length()];
    }
}
