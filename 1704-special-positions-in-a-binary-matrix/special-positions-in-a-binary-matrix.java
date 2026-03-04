class Solution {
    public int numSpecial(int[][] mat) {
        

        int count = 0;

        for(int i = 0 ; i < mat.length ; i++){

            for(int j = 0 ; j < mat[0].length ; j++){

                if(mat[i][j] == 1){
                    if(checkRow(mat , i , j) && checkCol(mat , j , i)){
                        count++;
                    }
                }
            }
        }


        return count;

    }

    public boolean checkRow(int[][] mat , int r , int x){
        boolean isValid = true;

        for(int j = 0 ; j < mat[0].length ; j ++ ){
            if(mat[r][j] == 1 && j != x){
                isValid = false;
                break;
            }
        }
        return isValid;
    }
    public boolean checkCol(int[][] mat , int c , int x){
        boolean isValid = true;

        for(int j = 0 ; j < mat.length ; j ++ ){
            if(mat[j][c] == 1 && j != x){
                isValid = false;
                break;
            }
        }

        return isValid;
    }
    
}