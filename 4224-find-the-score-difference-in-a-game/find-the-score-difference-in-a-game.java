class Solution {
    public int scoreDifference(int[] nums) {
        
        int p1Total = 0 ;
        int p2Total = 0;

        boolean isP1 = true;

        for(int i = 0 ; i < nums.length ; i++){
            int elem = nums[i];

            if(elem % 2 != 0){
                isP1 = !isP1;

            }
            if((i + 1) % 6 ==0){
                isP1 = !isP1;
            }
            
            if(isP1){
                p1Total+=elem;
            }
            else{
                p2Total+=elem;
            }
        }

        return p1Total-p2Total;

    }
}