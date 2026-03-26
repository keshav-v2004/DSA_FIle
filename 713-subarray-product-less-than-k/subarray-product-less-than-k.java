class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if(k==0) return 0;

        int prod = 1;
        int i = 0;
        int j = 0;

        int n = nums.length;
        int count = 0;

        while(i < n){

            prod = prod * nums[i];

            while(prod >= k && j <= i){
                prod = prod / nums[j];
                j++;

            }
            count += (i-j+1);
            i++;

        }

        return count;
    }
}