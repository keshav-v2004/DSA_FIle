class Solution {
    public int islandPerimeter(int[][] grid) {
        int peri = 0;

        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){

                if(grid[i][j]==1){
                int top = i-1;
                int bottom = i+1;
                int left = j-1;
                int right = j+1;

                if(top < 0 || grid[top][j] == 0){
                    peri++;
                }
                if(bottom >= row || grid[bottom][j] == 0){
                    peri++;
                }
                if(left < 0 || grid[i][left] == 0){
                    peri++;
                }
                if(right>= col || grid[i][right] == 0){
                    peri++;
                }
                }

            }
        }
        return peri;
    }
}