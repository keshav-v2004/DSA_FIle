class Solution {
    public int minInsertions(String s) {
        int start = 0;
        int end = s.length()-1;

        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1);
        }

        return helper(s , start , end  ,dp);
    }

    public int helper(String s , int i , int j , int[][] dp){


        if(i>=j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        char ch1 = s.charAt(i);
        char ch2 = s.charAt(j);

        int answer = (int) 1e9;

        if(ch1==ch2){
            answer = helper(s , i+1 , j-1 , dp);
        }
        else{
            int insertAtLeft = 1 + helper(s , i , j-1 , dp);
            int insertAtRight = 1 + helper(s , i+1 , j , dp);
            answer = Math.min(insertAtLeft , insertAtRight);
        }

        return dp[i][j] = answer;
    }
}