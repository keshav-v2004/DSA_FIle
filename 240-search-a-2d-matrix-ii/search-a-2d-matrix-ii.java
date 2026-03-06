class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        

        for(int i = 0 ; i < mat.length ; i++){

            int low = 0;
            int high = mat[0].length-1;

            while(low <= high){
                int mid = (low+high)/2;

                if(mat[i][mid]==target){
                    return true;
                }
                else if(mat[i][mid] > target){
                    high = mid-1;

                }
                else{
                    low = mid+1;
                }
            }
        }
        return false;

    }
}