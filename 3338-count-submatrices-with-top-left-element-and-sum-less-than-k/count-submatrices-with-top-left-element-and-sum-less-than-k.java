class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        
        if(grid[0][0] > k) return 0;
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] pref = new int[m][n];

        pref[0][0] = grid[0][0];

        for(int j = 1 ; j < n ; j++){
            pref[0][j] = pref[0][j-1] + grid[0][j];
        }

        for(int i  = 1 ; i < m ; i++){
            pref[i][0] = pref[i-1][0] + grid[i][0];
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                pref[i][j] = grid[i][j] + pref[i-1][j] + pref[i][j-1] - pref[i-1][j-1];
            }
        }

        int count = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                if(pref[i][j] <= k){
                    count++;
                }
            }
        }
        return count;
    }
}