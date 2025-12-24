class Solution {
    public boolean isTrionic(int[] nums) {
        
        for(int i = 1 ; i < nums.length-1 ; i++){
            for(int j = i+1 ; j < nums.length-1 ; j++){
                if(first(nums , i , j)) return true;
            }
        }
        return false;

    }
    public boolean first(int[] nums , int p , int q){

        for(int i = 0 ; i < p ; i++){
            if(nums[i] >= nums[i+1]){
                return false;
            }
        }

        for(int i = p ; i < q ; i++){
            if(nums[i] <=  nums[i+1]){
                return false;
            }
        }
        for(int i = q ; i < nums.length-1 ; i++){
            if(nums[i] >= nums[i+1]){
                return false;
            }
        }
        return true;
    }
    
}