class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        

        int m = mat.length;
        int n = mat[0].length;

        int col = n-1;
        int row = 0;

        while(col >= 0 && row <= m-1){

            if(mat[row][col]==target){
                return true;
            }

            if(mat[row][col] > target){
                col--;
            }
            else{
                row++;
            }

        }
        return false;
    }
}