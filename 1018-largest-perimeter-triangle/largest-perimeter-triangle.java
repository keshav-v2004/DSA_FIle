class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for(int i = nums.length-1 ; i>= 2 ; i--){
            if(i >= 2){
                int s1 = nums[i];
                int s2 = nums[i-1];
                int s3 = nums[i-2];

                if(
                    s1 < (s2+s3) 
                ){
                    return s1+s2+s3;
                }
                
            }
        }
        return 0;
    }
}