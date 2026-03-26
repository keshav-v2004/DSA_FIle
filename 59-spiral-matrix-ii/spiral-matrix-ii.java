class Solution {
    public int[][] generateMatrix(int n) {

        int[][] output = new int[n][n];

        int top = 0;
        int bottom = n-1;

        int left = 0;
        int right = n-1;
        
        int number = 1;

        while(top <= bottom && left <= right){

            for(int i = left ; i<= right ; i++){
                output[top][i] = number;
                number++;
            }
            top++;

            for(int i = top ; i<= bottom ; i++){
                output[i][right] = number;
                number++;
            }
            right--;

            if(left <= right){
                for(int i = right ; i>= left ; i--){
                    output[bottom][i] = number;
                    number++;
                }
            }
            bottom--;

            if(top <= bottom){
                for(int i = bottom ; i>= top ; i--){
                    output[i][left] = number;
                    number++;
                }
            }
            left++;
        }   
        return output;
    }
}