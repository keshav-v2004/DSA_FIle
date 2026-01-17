class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            Arrays.fill(dp[i] , -1);
        }

        return helper(grid , 0 , 0 , dp);
    }

    public int helper(int[][] grid , int i , int j , int[][] dp){
        if(i >= grid.length || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }

        if(dp[i][j] != -1) return dp[i][j];

        int down = helper(grid , i+1 , j , dp);
        int right = helper(grid , i , j+1 , dp);

        return dp[i][j] = grid[i][j] + Math.min(down , right);
    }
}