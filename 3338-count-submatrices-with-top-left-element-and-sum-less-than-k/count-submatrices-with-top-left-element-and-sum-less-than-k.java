class Solution {
    public int countSubmatrices(int[][] grid, int k) {

        if(grid[0][0] > k) return 0;
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] row = new int[m][n];
        int[][] col = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            row[i][0] = grid[i][0];
            for(int j = 1 ; j < n ; j++){
                row[i][j] = grid[i][j] + row[i][j-1];
            }
        }
        
        for(int j = 0 ; j < n ; j++){
            for(int i = 0 ; i < m ; i++){
                if(i==0){
                    col[0][j] = grid[0][j];
                }
                else{
                    col[i][j] = col[i-1][j] + grid[i][j];
                }
            }
        }
        int count = 0;

        for(int i = 0 ; i < m ; i++){
            int totalSum = 0;
            for(int j = 0 ; j < n ; j++){
                totalSum += col[i][j];   

                if(totalSum <= k){
                    count++;
                }
            }
        }



        return count;
    }
}