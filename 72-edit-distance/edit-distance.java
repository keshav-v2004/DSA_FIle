class Solution {
    public int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();

        int[][] dp = new int[i][j];
        for(int k = 0 ; k < dp.length ; k++){
            Arrays.fill(dp[k] , -1);
        }

        return helper(word1 , word2 , i-1 , j-1 , dp);
    }

    public int helper(String word1 , String word2 , int i , int j , int[][] dp){

        if(i < 0 || j < 0){
            if(i< 0 && j < 0) return 0;

            if(i < 0) return j+1;

            return i+1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        char ch1 = word1.charAt(i);
        char ch2 = word2.charAt(j);

        int answer = 0;

        if(ch1==ch2){
            answer = helper(word1 , word2 , i-1 , j-1 , dp);
        }
        else{
            int ins = helper(word1 , word2 , i , j-1 , dp);

            int rep = helper(word1 , word2 , i-1 , j-1 , dp);
            
            int del = helper(word1 , word2 , i-1 , j , dp);
            answer = 1 + Math.min(ins , Math.min(rep , del));

        }
        return dp[i][j] = answer;
    }
}