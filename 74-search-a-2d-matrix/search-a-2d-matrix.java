class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        
        boolean found = false;

        int l = 0;
        int r = mat.length-1;

        while(l <= r){

            int mid = (l+r)/2;

            if(mat[mid][0] > target){
                r = mid-1;
            }
            else{
                boolean inThisRow = false;

                int i = 0;
                int j = mat[0].length - 1;

                while(i <= j){
                    int col = (i+j)/2;

                    if(mat[mid][col]==target){
                        inThisRow=true;
                        break;
                    }
                    else if(mat[mid][col] > target){
                        j = col-1;
                    }
                    else{
                        i = col+1;
                    }
                }

                if(inThisRow){
                    found=true;
                    break;
                }

                l = mid+1;
            }
        }

        return found;

    }
}