class Solution {

    public int mod = (int)1e9 + 7;
    public int k;

    public int numberOfPaths(int[][] grid, int k) {
        this.k = k;

        int m =grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k];

        for(int i = 0 ; i < m ;i ++){
            for(int j = 0 ; j < n ; j++){
                for(int l = 0 ; l < k ; l++){
                    dp[i][j][l] = -1;
                }
            }
        }

        return helper(0 , 0 , grid , 0 , dp);
    }

    public int helper(int i , int j  , int[][] grid , int sum , int[][][] dp){

        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j >= n){
            return 0;
        }

        if(i==m-1 && j == n-1){
            if((sum+grid[i][j]) % k ==0){
                return 1;
            }
            return 0;
        }

        if(dp[i][j][sum%k] != -1) return dp[i][j][sum%k];

        int goDown = helper(i+1 , j , grid , sum + grid[i][j] , dp);
        int goRight = helper(i , j+1 , grid , sum + grid[i][j] , dp);

        return dp[i][j][sum%k] = (goDown + goRight) % (mod);


    }
}