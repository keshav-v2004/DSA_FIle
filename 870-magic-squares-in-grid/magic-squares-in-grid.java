class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        for(int i = 0 ; i <= row-3 ; i++){
            for(int j = 0 ; j<= col-3 ; j++){

                int[] hash = new int[10];
                boolean allDistinct = true;
                for(int x = 0 ; x < 3 ; x++){
                    
                    for(int y = 0 ; y < 3 ; y++){

                        int newR = x+i;
                        int newCol = y+j;

                        int val = grid[newR][newCol];

                        if(val < 1 || val > 9 || hash[val]==1){
                            allDistinct = false;
                            break;
                        }
                        hash[grid[newR][newCol]]=1;
                    }
                    if(allDistinct==false) break;
                }
                if(allDistinct){
                    // findSums
                    int target = findRowSum(grid, i, j);

                    if (
                        findRowSum(grid, i + 1, j) == target &&
                        findRowSum(grid, i + 2, j) == target &&
                        findColSum(grid, i, j)     == target &&
                        findColSum(grid, i, j + 1) == target &&
                        findColSum(grid, i, j + 2) == target &&
                        (grid[i][j]     + grid[i + 1][j + 1] + grid[i + 2][j + 2]) == target &&
                        (grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2])     == target
                    ) {
                        count++;
                    }
                    
                }


            }
            
        }
        return count;

    }

    public int findRowSum(int [][] grid , int i , int j){
        int sum = 0;
        for(int k = 0 ; k < 3 ; k++){
            sum+=grid[i][k+j];
        }
        return sum;
    }

    public int findColSum(int[][] grid , int i , int j){
        int sum = 0;
        for(int k = 0 ; k < 3 ; k++){
            sum+=grid[k+i][j];
        }
        return sum;
    }
}