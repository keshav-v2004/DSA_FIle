class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        
        int m = mat.length;
        int n = mat[0].length;

        int[][] output = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                output[i][j] = mat[i][j];
            }
        }

        while(k-->0){

            for(int i = 0 ; i < m ; i++){

                if(i % 2 == 0){
                    shiftLeft(output , i);
                }
                else{
                    shiftRight(output , i);
                }
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] != output[i][j]){
                    return false;
                }
            }
        }
        return true;

    }

    public void shiftLeft(int[][] mat , int row){
        int first = mat[row][0];
        int n = mat[0].length;

        for(int i = 1 ; i < n  ;i++){
            mat[row][i-1] = mat[row][i];

        }
        mat[row][n-1] = first;

    }
    public void shiftRight(int[][] mat , int row){
        
        int n = mat[0].length;
        int last = mat[row][n-1];

        for(int i = n-2 ; i>= 0 ; i--){

            mat[row][i+1] = mat[row][i];

        }
        mat[row][0] = last;
       
    }
}