class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] rowSums = new long[m];

        for(int i = 0 ; i < m ; i++){

            long sum = 0;
            for(int j = 0 ; j < n ; j++){

                sum += grid[i][j];

            }
            rowSums[i] = sum;
        }
        long[] prefR = new long[m];

        prefR[0] = rowSums[0];

        
        
        for(int i = 1 ; i < m ; i++){
            prefR[i] = prefR[i-1] + rowSums[i];
        }

        long totalSum = prefR[m-1];

        for(int i = 0 ; i < m ; i++){
            if(prefR[i] == totalSum - prefR[i]){
                return true;
            }    
        }


        long[] colSums = new long[n];

        for(int k = 0 ; k < n ; k++){
            
            long sum = 0;

            for(int l = 0 ; l < m ; l++){
                sum += grid[l][k];
            }

            colSums[k] = sum;
        }

        long[] prefC = new long[n];

        prefC[0] = colSums[0];
        

        for(int k = 1 ; k < n ; k++){
            prefC[k] = prefC[k-1] + colSums[k];
        }
        totalSum = prefC[n-1];

        for(int i = 0 ; i < n ; i++){
            if(prefC[i] == totalSum - prefC[i]){
                return true;
            }
        }


        return false;


    }
}