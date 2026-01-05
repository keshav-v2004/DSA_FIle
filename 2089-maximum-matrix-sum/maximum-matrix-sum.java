class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;

        long min = Integer.MAX_VALUE;

        int neg = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                min = Math.min(min, Math.abs(matrix[i][j]));
                if(matrix[i][j] < 0){
                    neg++;
                }
            }
        }
        long answer = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                answer+=Math.abs(matrix[i][j]);
            }
        }
        if(neg%2==0){
            return answer;
        }
        else{
            return answer - (2*min);
        }

    }
}