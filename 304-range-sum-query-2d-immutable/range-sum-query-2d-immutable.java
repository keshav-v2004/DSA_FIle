class NumMatrix {

    int[][] col;
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;

        int m = matrix.length;
        int n = matrix[0].length;

        col = new int[m][n];

        for(int j = 0 ; j < n ; j++){
            col[0][j] = matrix[0][j];     
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                col[i][j] = matrix[i][j] + col[i-1][j];
            }
        }



    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalSum = 0;

        for (int j = col1; j <= col2; j++) {
            if (row1 > 0) {
                totalSum += col[row2][j] - col[row1 - 1][j];
            } else {
                totalSum += col[row2][j];
            }
        }

        return totalSum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */