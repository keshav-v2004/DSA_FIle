class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Integer[][] dp = new Integer[m][n];

        int answer = Integer.MAX_VALUE;

        for(int j = 0 ; j < n ; j++){
            answer = Math.min(answer , helper(matrix , 0 , j , dp));
        }
        return answer;
    }

    public int helper(int[][] grid ,int i , int j , Integer[][] dp){

        if(j < 0 || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }

        if(i==grid.length-1){
            return grid[i][j];
        }

        if(dp[i][j] != null) return dp[i][j];

        int left = helper(grid , i+1 , j-1 ,dp);
        int bottom = helper(grid , i+1 , j , dp);
        int right = helper(grid , i+1 , j+1 , dp);

        return dp[i][j] = grid[i][j] + Math.min(left , Math.min(right , bottom));


    }
}