class Solution {
    public int maxProduct(int[] nums) {
        int preProd = 1;
        int sufProd = 1;

        int mpp = Integer.MIN_VALUE;
        int mps = Integer.MIN_VALUE;
        
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            preProd = preProd * nums[i];

            mpp = Math.max(mpp , preProd);

            if(preProd==0){
                preProd = 1;

            }
        }

        
        for(int i = n-1 ; i >= 0 ; i--){
            sufProd = sufProd * nums[i];

            mps = Math.max(mps , sufProd);
            
            if(sufProd==0){
                sufProd = 1;

            }

        }
        return Math.max(mps , mpp);
    }
}