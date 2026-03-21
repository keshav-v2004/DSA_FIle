class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        update(x,y,grid,k);

        return grid;
    }

    public void update(int x , int y , int[][] grid , int k){

        int i = x;
        int j = x + k-1;

        while(i < j){

            for(int a = y ; a < y+k ; a++){

                int temp = grid[i][a];

                grid[i][a] = grid[j][a];
                grid[j][a] = temp;


            }
            i++;
            j--;

        }


    }
}