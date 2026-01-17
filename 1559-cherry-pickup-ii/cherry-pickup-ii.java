class Solution {
    public int cherryPickup(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int[][][] dp = new int[row][col][col];

        for(int i = 0 ; i < row ; i++){
            for(int j= 0 ; j < col ; j++){
                for(int k = 0 ; k < col ; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(grid , 0 , 0 , grid[0].length-1 , dp);
    }

    public int helper(int[][] grid , int row , int c1 , int c2 ,int[][][] dp){
        
        if(c1 < 0 || c2 < 0 || c1 >= grid[0].length || c2 >= grid[0].length){
            return Integer.MIN_VALUE;
        }

        if(row==grid.length-1){
            if(c1==c2){
                return grid[row][c1];
            }
            return grid[row][c1] + grid[row][c2];
        }

        if(dp[row][c1][c2] != -1) return dp[row][c1][c2];


        int best = Integer.MIN_VALUE;

        for(int d1 = -1 ; d1 <= 1 ; d1++){
            for(int d2 = -1 ; d2 <= 1 ; d2++){
                int collected = helper(grid , row+1 , c1+d1 , c2+d2 , dp);
                if(c1==c2){
                    collected += grid[row][c1];
                }
                else{
                    collected+= grid[row][c1] + grid[row][c2];
                }
                best = Math.max(best , collected);
            }
        }
        return dp[row][c1][c2] = best;
    }
}