class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length-1;

        int left = 0;
        int right = matrix[0].length-1;

        while(top <= bottom && left <= right){

            // top row
            for(int i = left ; i <= right ; i++){
                answer.add(matrix[top][i]);

            }
            top++;

            // right column
            for(int i = top ; i<= bottom ; i++){
                answer.add(matrix[i][right]);
            }
            right--;

            // bottom row
            if(top <= bottom){
            for(int i = right ; i>= left ; i--){
                answer.add(matrix[bottom][i]);
            }
            bottom--;
            }


            // left column
            if(left <= right){
            for(int i = bottom ; i>= top ; i--){
                answer.add(matrix[i][left]);
            }
            left++;
            }

        }
        return answer;

    }
}